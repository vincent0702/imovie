
package web.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletResponse;
import javax.sql.rowset.serial.SerialBlob;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.CacheControl;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.web.store.model.MovieBean;
import com.web.store.model.Movie_Genre;

import web.movie.service.MovieService;

@Controller
public class TestMovieController {
	@Autowired
	ServletContext context;
	@Autowired
	MovieService movieService;
	
	@ModelAttribute("GenreList")
	public List<String>getGenreList() {
		List<Movie_Genre> list=movieService.getGenreList();
		List<String> list1 = new ArrayList<>();
		for (Movie_Genre cb : list) {
			System.out.println(cb);
			//GenreMap.put(cb.getmGenreName(),cb.getmGenreName());
			list1.add(cb.getmGenreName());
			//(cb.getmGenreName());
		}
		return list1;
	}
	
	@GetMapping("/Movie")
	public String movie(Model model) {
		Map<Integer, MovieBean> movieMap = movieService.getMovie();
		model.addAttribute("movieMap",movieMap);
		MovieBean movieBean = new MovieBean();
		model.addAttribute("movieBean", movieBean);//回傳空表單(MovieBean)
		return "Movie/MovieUpdata";
	}
	
	@PostMapping("/Movie")//更新電影
	public String updataMovieIn(@ModelAttribute("movieBean") MovieBean movieBean, BindingResult result) {
		long sizeInBytes = 0;
		InputStream is = null;
		MultipartFile productImage = movieBean.getProductImage();
		String originalFilename = productImage.getOriginalFilename();
		movieBean.setMovieFileName(originalFilename);
		//  建立Blob物件，交由 Hibernate 寫入資料庫
		if (productImage != null && !productImage.isEmpty() ) {
			
			try {
				byte[] b = productImage.getBytes();
				Blob blob = new SerialBlob(b);
				movieBean.setMovieImg(blob);
				sizeInBytes = 1;
			} catch(Exception e) {
				e.printStackTrace();
				throw new RuntimeException("檔案上傳發生異常: " + e.getMessage());
			}
		}else {
			sizeInBytes = -1;
		}
		movieService.MovieUpdata(movieBean, sizeInBytes);
		return "redirect:/Movie";
	}
	
	@PostMapping("/MovieDelete/{MoviemId}")//刪除電影測試
	public String MovieDelete( @PathVariable Integer MoviemId, Model model) {
		movieService.MovieDelete(MoviemId);
		return "redirect:/Movie";
	}
	
	@PostMapping("/MovieUpdateAjax")
	public ResponseEntity<List<MovieBean>>  MovieUpdateAjax(@RequestParam Integer MoviemId, Model model)  {
		List<MovieBean> mapMovieUpdate = movieService.MovieUpdateAjax(MoviemId);
		ResponseEntity<List<MovieBean>> MovieUpdateAjax = new ResponseEntity<>(mapMovieUpdate, HttpStatus.OK);
		return MovieUpdateAjax;
	}
	
	@PostMapping(value = "/MovieUpdateSubmit",produces = "application/json")
	public ResponseEntity<Map<Integer, MovieBean>>  MovieUpdateSubmit(@ModelAttribute("movieBean") MovieBean movieBean, Model model)  { 
		long sizeInBytes = 0;
		InputStream is = null;
		MultipartFile productImage = movieBean.getProductImage();
		String originalFilename = productImage.getOriginalFilename();
		movieBean.setMovieFileName(originalFilename);
		//  建立Blob物件，交由 Hibernate 寫入資料庫
		if (productImage != null && !productImage.isEmpty() ) {
			
			try {
				byte[] b = productImage.getBytes();
				Blob blob = new SerialBlob(b);
				movieBean.setMovieImg(blob);
				sizeInBytes = 1;
			} catch(Exception e) {
				e.printStackTrace();
				throw new RuntimeException("檔案上傳發生異常: " + e.getMessage());
			}
		}else {
			sizeInBytes = -1;
		}
		SimpleDateFormat sdFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = new Date();
		String movieDate = sdFormat.format(date);
        Date d1 = Timestamp.valueOf(movieDate);
        movieBean.setMovieDate(d1);
        Map<Integer, MovieBean> movieMap = movieService.MovieUpdata(movieBean, sizeInBytes);
		
//		List<MovieBean> mapMovieUpdate = movieService.MovieUpdateAjax(MoviemId);
//		ResponseEntity<List<MovieBean>> MovieUpdateAjax = new ResponseEntity<>(mapMovieUpdate, HttpStatus.OK);
//		
//		System.out.println(mapMovieUpdate+"==============================");
//		Map<Integer, MovieBean> movieMap = movieService.getMovie();
		ResponseEntity<Map<Integer, MovieBean>> MovieUpdateAjax = new ResponseEntity<>(movieMap, HttpStatus.OK);
		return MovieUpdateAjax;
	}
	
	@PostMapping(value = "/MovieAddSubmit",produces = "application/json")
	public ResponseEntity<Map<Integer, MovieBean>>  MovieAddSubmit(@ModelAttribute("movieBean") MovieBean movieBean, Model model) throws ParseException  { 
		MultipartFile productImage = movieBean.getProductImage();
		String originalFilename = productImage.getOriginalFilename();
		movieBean.setMovieFileName(originalFilename);
//		System.out.println(movieBean.getProductImage()+"==================================productImage");
		//  建立Blob物件，交由 Hibernate 寫入資料庫
		if (productImage != null && !productImage.isEmpty() ) {
			try {
				byte[] b = productImage.getBytes();
				Blob blob = new SerialBlob(b);
				movieBean.setMovieImg(blob);
			} catch(Exception e) {
				e.printStackTrace();
				throw new RuntimeException("檔案上傳發生異常: " + e.getMessage());
			}
		}
		SimpleDateFormat sdFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = new Date();
		String movieDate = sdFormat.format(date);
        Date d1 = Timestamp.valueOf(movieDate);
        movieBean.setMovieDate(d1);
        Map<Integer, MovieBean> movieMap = movieService.saveMovie(movieBean);
//		Map<Integer, MovieBean> movieMap = movieService.getMovie();
		ResponseEntity<Map<Integer, MovieBean>> MovieUpdateAjax = new ResponseEntity<>(movieMap, HttpStatus.OK);
		return MovieUpdateAjax;
	}
	
	@GetMapping("/MovieIn")//新增電影，回傳空表單(MovieBean)
	public String addMovie(Model model) {
		MovieBean movieBean = new MovieBean();
		model.addAttribute("movieBean", movieBean);
		return "Movie/Movie";
	}
	
	@PostMapping("/MovieIn")//新增電影
	public String addMovieIn(@ModelAttribute("movieBean") MovieBean movieBean, BindingResult result) {
		MultipartFile productImage = movieBean.getProductImage();
		String originalFilename = productImage.getOriginalFilename();
		movieBean.setMovieFileName(originalFilename);
//		System.out.println(movieBean.getProductImage()+"==================================productImage");
		//  建立Blob物件，交由 Hibernate 寫入資料庫
		if (productImage != null && !productImage.isEmpty() ) {
			try {
				byte[] b = productImage.getBytes();
				Blob blob = new SerialBlob(b);
				movieBean.setMovieImg(blob);
			} catch(Exception e) {
				e.printStackTrace();
				throw new RuntimeException("檔案上傳發生異常: " + e.getMessage());
			}
		}
		movieService.saveMovie(movieBean);
//		String ext = originalFilename.substring(originalFilename.lastIndexOf("."));
//		String rootDirectory = context.getRealPath("/");
//		try {
//			File imageFolder = new File(rootDirectory, "images");
//			if (!imageFolder.exists()) imageFolder.mkdirs();
//			File file = new File(imageFolder, movieBean.getMovieId() + ext);
//			productImage.transferTo(file);
//		} catch(Exception e) {
//			e.printStackTrace();
//			throw new RuntimeException("檔案上傳發生異常: " + e.getMessage());
//		}
		return "redirect:/Movie";
	}
	
	
	
	
	
	
	@GetMapping("/getMovieImg/{movieId}")//包廂測試畫面，圖片(資料表內容，二進制轉圖片)
	public ResponseEntity<byte[]> getPicture(HttpServletResponse resp, @PathVariable Integer movieId) {
		String filePath = "/resources/images/NoImage.jpg";
		byte[] media = null; 
		HttpHeaders headers = new HttpHeaders();
		String filename = "";
		int len = 0;
		MovieBean bean = movieService.getMovieImg(movieId);
		if (bean != null) {
			Blob blob = bean.getMovieImg();
			filename = bean.getMovieFileName();
			if (blob != null) {
				try {
					len = (int) blob.length();
					media = blob.getBytes(1, len);
				} catch (SQLException e) {
					throw new RuntimeException("ProductController的getPicture()發生SQLException: " + e.getMessage());
				}
			} else {
				media = toByteArray(filePath);
				filename = filePath;
			}
		} else {
			media = toByteArray(filePath);
			filename = filePath;
		}
		headers.setCacheControl(CacheControl.noCache().getHeaderValue());
		String mimeType = context.getMimeType(filename);
		MediaType mediaType = MediaType.valueOf(mimeType);
//		System.out.println("mediaType =" + mediaType);
		headers.setContentType(mediaType);
		ResponseEntity<byte[]> responseEntity = new ResponseEntity<>(media, headers, HttpStatus.OK);
		return responseEntity;
	}

	private byte[] toByteArray(String filepath) {
		byte[] b = null;
		String realPath = context.getRealPath(filepath);
		try {
			File file = new File(realPath);
			long size = file.length();
			b = new byte[(int) size];
			InputStream fis = context.getResourceAsStream(filepath);
			fis.read(b);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return b;
	}
	
	
}

