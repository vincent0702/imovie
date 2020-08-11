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

import com.web.store.model.FoodBean;
import com.web.store.model.Food_Genre;

import web.food.service.FoodService;

@Controller
public class TestFoodController {
	@Autowired
	ServletContext context;
	@Autowired
	FoodService foodService;
	
	@GetMapping("/Food")//食物新增修改畫面
	public String food(Model model) {
		Map<Integer, FoodBean> foodMap = foodService.getFood();
		model.addAttribute("foodMap",foodMap);
		FoodBean foodBean = new FoodBean();
		model.addAttribute("foodBean",foodBean);//回傳空表單(foodBean)
		return "Food/FoodUpdata";
	}
	
	@PostMapping("/Food")//更新電影
	public String updataFood(@ModelAttribute("foodBean") FoodBean foodBean, BindingResult result) {
		long sizeInBytes = 0;
		InputStream is = null;
		MultipartFile productImage = foodBean.getProductImage();
		String originalFilename = productImage.getOriginalFilename();
		foodBean.setFoodFileName(originalFilename);
		//  建立Blob物件，交由 Hibernate 寫入資料庫
		if (productImage != null && !productImage.isEmpty() ) {
			
			try {
				byte[] b = productImage.getBytes();
				Blob blob = new SerialBlob(b);
				foodBean.setFoodImg(blob);
				sizeInBytes = 1;
			} catch(Exception e) {
				e.printStackTrace();
				throw new RuntimeException("檔案上傳發生異常: " + e.getMessage());
			}
		}else {
			sizeInBytes = -1;
		}
		foodService.FoodUpdata(foodBean, sizeInBytes);
		return "redirect:/Food";
	}
	
	@PostMapping("/FoodDelete")//刪除電影測試
	public String RoomDelete(@RequestParam Integer FoodId, Model model) {
		foodService.FoodDelete(FoodId);
		return "redirect:/Food";
	}
	
	@GetMapping("/FoodIn")//新增食物畫面，回傳空表單
	public String foodIn(Model model) {
		FoodBean foodBean = new FoodBean();
		model.addAttribute("foodBean", foodBean);//回傳空表單(foodBean)
		return "Food/Food";
	}
	
	@PostMapping("/FoodIn")//新增食物，送出表單
	public String AddfoodIn(@ModelAttribute("foodBean") FoodBean foodBean, BindingResult result) {
		MultipartFile productImage = foodBean.getProductImage();
		String originalFilename = productImage.getOriginalFilename();
		foodBean.setFoodFileName(originalFilename);
		//  建立Blob物件，交由 Hibernate 寫入資料庫
		if (productImage != null && !productImage.isEmpty() ) {
			try {
				byte[] b = productImage.getBytes();
				Blob blob = new SerialBlob(b);
				foodBean.setFoodImg(blob);
			} catch(Exception e) {
				e.printStackTrace();
				throw new RuntimeException("檔案上傳發生異常: " + e.getMessage());
			}
		}
		foodService.saveFood(foodBean);
		return "redirect:/Food";
	}
	
	@ModelAttribute("Genre")//傳回食物類型
	public List<String>getGenreList() {
		List<String> Genrelist = new ArrayList<>();
		List<Food_Genre> list=foodService.getGenreFood();
		for (Food_Genre cb : list) {
			//System.out.println(cb);
			//GenreMap.put(cb.getfGenreName(),cb.getfGenreName());
			Genrelist.add(cb.getfGenreName());
		}
		return Genrelist;
	}
	
	@PostMapping(value = "/AddFood",produces = "application/json")//新增食物AJAX
	public ResponseEntity<List<FoodBean>>  AddFood(@ModelAttribute("foodBean") FoodBean foodBean, Model model) throws ParseException  { 
		
		MultipartFile productImage = foodBean.getProductImage();
		String originalFilename = productImage.getOriginalFilename();
		foodBean.setFoodFileName(originalFilename);
		//  建立Blob物件，交由 Hibernate 寫入資料庫
		if (productImage != null && !productImage.isEmpty() ) {
			try {
				byte[] b = productImage.getBytes();
				Blob blob = new SerialBlob(b);
				foodBean.setFoodImg(blob);
			} catch(Exception e) {
				e.printStackTrace();
				throw new RuntimeException("檔案上傳發生異常: " + e.getMessage());
			}
		}
		SimpleDateFormat sdFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = new Date();
		String FoodDate = sdFormat.format(date);
        Date d1 = Timestamp.valueOf(FoodDate);
        foodBean.setFoodDate(d1);
		List<FoodBean> foodList = foodService.saveFoodAJAX(foodBean);
		ResponseEntity<List<FoodBean>> AddFoodAJAX = new ResponseEntity<>(foodList, HttpStatus.OK);
		return AddFoodAJAX;
	}
	@PostMapping(value = "/UpFood",produces = "application/json")//新增食物AJAX
	public ResponseEntity<List<FoodBean>>  UpFood(@ModelAttribute("foodBean") FoodBean foodBean, Model model) throws ParseException  { 
		long sizeInBytes = 0;
		InputStream is = null;
		MultipartFile productImage = foodBean.getProductImage();
		String originalFilename = productImage.getOriginalFilename();
		foodBean.setFoodFileName(originalFilename);
		//  建立Blob物件，交由 Hibernate 寫入資料庫
		if (productImage != null && !productImage.isEmpty() ) {
			
			try {
				byte[] b = productImage.getBytes();
				Blob blob = new SerialBlob(b);
				foodBean.setFoodImg(blob);
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
		String FoodDate = sdFormat.format(date);
		Date d1 = Timestamp.valueOf(FoodDate);
		foodBean.setFoodDate(d1);
		List<FoodBean> foodList = foodService.UpFoodAjax(foodBean, sizeInBytes);
		ResponseEntity<List<FoodBean>> UpFoodAjax = new ResponseEntity<>(foodList, HttpStatus.OK);
		return UpFoodAjax;
	}
	@GetMapping("/getFoodImgDaneil/{foodId}")//食物測試畫面，圖片(資料表內容，二進制轉圖片)
	public ResponseEntity<byte[]> getPicture(HttpServletResponse resp, @PathVariable Integer foodId) {
		String filePath = "/resources/images/NoImage.jpg";
		byte[] media = null;
		HttpHeaders headers = new HttpHeaders();
		String filename = "";
		int len = 0;
		FoodBean bean = foodService.getFoodImg(foodId);
		if (bean != null) {
			Blob blob = bean.getFoodImg();
			filename = bean.getFoodFileName();
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
