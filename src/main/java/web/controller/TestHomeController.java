package web.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Base64;
import java.util.LinkedList;
import java.util.List;

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

import com.web.store.model.HomeBean;

import web.home.service.HomeService;



@Controller
public class TestHomeController {
	@Autowired
	ServletContext context;
	@Autowired
	HomeService homeService;
	
	String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    String url = "jdbc:sqlserver://localhost:1433;DatabaseName=Imovie";
    String userid = "sa";
    String passwd = "sa123456";
    private static final String SELECT_Img = "Select * From Home where homeTpy=1";
    private static final String SELECT_Vedio = "Select * From Home where homeTpy=2";
    private static final String INSERT_Img = "INSERT INTO Home(homeName,homeImg,homeTpy,homeFileName)  VALUES (?,?,?,?)";
    private static final String INSERT_Vedio = "INSERT INTO Home(homeName,homeImg,homeTpy,homeFileName)  VALUES (?,?,?,?)";
    private static final String UPDATE_Img = "UPDATE  Home set  homeName=? ,homeImg =?,homeTpy=?,homeFileName=? Where homeId=?";
    private static final String UPDATE_Vedio = "UPDATE  Home set homeName=? ,homeImg =?,homeTpy=?,homeFileName=? Where homeId=?";
	
	@GetMapping("/Home")//圖片顯示畫面
	public String homeImg(Model model) {
		Connection con = null;
		PreparedStatement ps = null;
		List<HomeBean> list = new LinkedList<HomeBean>();
		PreparedStatement ps1 = null;
		List<HomeBean> list1 = new LinkedList<HomeBean>();
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			ps = con.prepareStatement(SELECT_Img);
			ps1 = con.prepareStatement(SELECT_Vedio);
			ResultSet rs=ps.executeQuery();
			ResultSet rs1=ps1.executeQuery();
			while(rs.next()) {
				HomeBean homeBean = new HomeBean();
				homeBean = new HomeBean();
				//圖片轉檔
				StringBuffer sb = new StringBuffer();
				String fileName = rs.getString("homeFileName");
				String mimeType = context.getMimeType(fileName);
				Blob blob = rs.getBlob("homeImg");
				byte[] bytes = blob.getBytes(1, (int) blob.length());
				String prefix = "data:" + mimeType + ";base64,";
				sb.append(prefix);
				Base64.Encoder be = Base64.getEncoder();
				String str = new String(be.encode(bytes));
				sb.append(str);
				String iamgeData = sb.toString();
				homeBean.setHomeId(rs.getInt("homeId"));
				homeBean.setHomeTpy(rs.getInt("homeTpy"));
				homeBean.setHomeName(rs.getString("homeName"));
				homeBean.setHomeImg(rs.getBlob("homeImg"));
				homeBean.setHomeFileName(iamgeData);
				list.add(homeBean);			
			}
			while(rs1.next()) {
				HomeBean homeBean = new HomeBean();
				homeBean = new HomeBean();
				//圖片轉檔
				StringBuffer sb = new StringBuffer();
				String fileName = rs1.getString("homeFileName");
				String mimeType = context.getMimeType(fileName);
				Blob blob = rs1.getBlob("homeImg");
				byte[] bytes = blob.getBytes(1, (int) blob.length());
				String prefix = "data:" + mimeType + ";base64,";
				sb.append(prefix);
				Base64.Encoder be = Base64.getEncoder();
				String str = new String(be.encode(bytes));
				sb.append(str);
				String iamgeData = sb.toString();
				homeBean.setHomeId(rs1.getInt("homeId"));
				homeBean.setHomeTpy(rs1.getInt("homeTpy"));
				homeBean.setHomeName(rs1.getString("homeName"));
				homeBean.setHomeImg(rs1.getBlob("homeImg"));
				homeBean.setHomeFileName(iamgeData);
				list1.add(homeBean);				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}		
		model.addAttribute("homeImg",list);//回傳空表單(foodBean)
		model.addAttribute("homeVedio",list1);//回傳空表單(foodBean)
		return "Home/HomeUpdata";
	}
		
	@PostMapping("/HomeDelete")//刪除電影測試
	public String HomeDelete(@RequestParam Integer HomeId, Model model) {
		homeService.HomeDelete(HomeId);
		return "redirect:/Home";
	}
	
	@GetMapping("/HomeIn")//新增首頁圖畫面，回傳空表單
	public String homeIn(Model model) {
		HomeBean homeBean = new HomeBean();
		model.addAttribute("homeBean", homeBean);//回傳空表單(foodBean)
		return "Home/Home";
	}
	
	@PostMapping("/HomeIn")//新增首頁圖，送出表單
	public String AddfoodIn(@RequestParam("homeName") String homeName ,@RequestParam("productImage") MultipartFile productImage) {		
		Connection con = null;
		PreparedStatement ps = null;
		List<HomeBean> list = new LinkedList<HomeBean>();
		//  建立Blob物件，交由 Hibernate 寫入資料庫
		if (productImage != null && !productImage.isEmpty() ) {
			try {
				Class.forName(driver);
				con = DriverManager.getConnection(url, userid, passwd);
				ps = con.prepareStatement(INSERT_Img);
				ps.setString(1, homeName);
				byte[] b = productImage.getBytes();
				Blob blob = new SerialBlob(b);
				ps.setBlob(2, blob);
				ps.setInt(3, 1);
				ps.setString(4, homeName+".jpg");
				ps.execute();
			} catch(Exception e) {
				e.printStackTrace();
				throw new RuntimeException("檔案上傳發生異常: " + e.getMessage());
			}
		}
		return "redirect:/Home";
	}
	@PostMapping("/HomeUp")//修改首頁圖，送出表單
	public String UpdataImgn(@RequestParam("homeName") String homeName ,@RequestParam("productImage") MultipartFile productImage,@RequestParam("homeId") Integer homeId) {		
		Connection con = null;
		PreparedStatement ps = null;
		List<HomeBean> list = new LinkedList<HomeBean>();
		//  建立Blob物件，交由 Hibernate 寫入資料庫
		if (productImage != null && !productImage.isEmpty() ) {
			try {
				Class.forName(driver);
				con = DriverManager.getConnection(url, userid, passwd);
				ps = con.prepareStatement(UPDATE_Img);
				ps.setString(1, homeName);
				byte[] b = productImage.getBytes();
				Blob blob = new SerialBlob(b);
				ps.setBlob(2, blob);
				ps.setInt(3, 1);
				ps.setString(4, homeName+".jpg");
				ps.setInt(5, homeId);
				ps.executeUpdate();
			} catch(Exception e) {
				e.printStackTrace();
				throw new RuntimeException("檔案上傳發生異常: " + e.getMessage());
			}
		}
		return "redirect:/Home";
	}
	
	@GetMapping("/getHomeImg/{homeId}")//首頁畫面，圖片(資料表內容，二進制轉圖片)
	public ResponseEntity<byte[]> getPicture(HttpServletResponse resp, @PathVariable Integer homeId) {
		String filePath = "/resources/images/NoImage.jpg";
		byte[] media = null;
		HttpHeaders headers = new HttpHeaders();
		String filename = "";
		int len = 0;
		HomeBean bean = homeService.getHomeImg(homeId);
		if (bean != null) {
			Blob blob = bean.getHomeImg();
			filename = bean.getHomeFileName();
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
	
	@PostMapping("/HomeVdDelete")//刪除電影測試
	public String HomevedioDelete(@RequestParam Integer HomeId, Model model) {
		homeService.HomeDelete(HomeId);
		return "redirect:/Home";
	}
	
	@GetMapping("/HomeVdIn")//新增首頁圖畫面，回傳空表單
	public String homevedioIn(Model model) {
		HomeBean homeBean = new HomeBean();
		model.addAttribute("homeBean", homeBean);//回傳空表單(foodBean)
		return "Home/Home";
	}
	
	@PostMapping("/HomeVdIn")//新增首頁圖，送出表單
	public String AddvedioIn(@RequestParam("homeName") String homeName ,@RequestParam("productImage") MultipartFile productImage) {
		Connection con = null;
		PreparedStatement ps = null;
		List<HomeBean> list = new LinkedList<HomeBean>();
		//  建立Blob物件，交由 Hibernate 寫入資料庫
		if (productImage != null && !productImage.isEmpty() ) {
			try {
				Class.forName(driver);
				con = DriverManager.getConnection(url, userid, passwd);
				ps = con.prepareStatement(INSERT_Vedio);
				ps.setString(1, homeName);
				byte[] b = productImage.getBytes();
				Blob blob = new SerialBlob(b);
				ps.setBlob(2, blob);
				ps.setInt(3, 2);
				ps.setString(4, homeName+".mp4");
				ps.execute();
			} catch(Exception e) {
				e.printStackTrace();
				throw new RuntimeException("檔案上傳發生異常: " + e.getMessage());
			}
		}
		return "redirect:/Home";
	}
	
	@PostMapping("/HomeVdUp")//修改首頁圖，送出表單
	public String UpdataVedio(@RequestParam("homeName") String homeName ,@RequestParam("productImage") MultipartFile productVedio,@RequestParam("homeId") Integer homeId) {		
		Connection con = null;
		PreparedStatement ps = null;
		List<HomeBean> list = new LinkedList<HomeBean>();
		//  建立Blob物件，交由 Hibernate 寫入資料庫
		if (productVedio != null && !productVedio.isEmpty() ) {
			try {
				Class.forName(driver);
				con = DriverManager.getConnection(url, userid, passwd);
				ps = con.prepareStatement(UPDATE_Vedio);
				ps.setString(1, homeName);
				byte[] b = productVedio.getBytes();
				Blob blob = new SerialBlob(b);
				ps.setBlob(2, blob);
				ps.setInt(3, 2);
				ps.setString(4, homeName+".mp4");
				ps.setInt(5, homeId);
				ps.executeUpdate();
			} catch(Exception e) {
				e.printStackTrace();
				throw new RuntimeException("檔案上傳發生異常: " + e.getMessage());
			}
		}
		return "redirect:/Home";
	}
	
	@GetMapping("/getHomeVd/{homeId}")//首頁畫面，圖片(資料表內容，二進制轉圖片)
	public ResponseEntity<byte[]> getVedio(HttpServletResponse resp, @PathVariable Integer homeId) {
		String filePath = "/resources/WEB-INF/views/img/NoImage.mp4";
		byte[] media = null;
		HttpHeaders headers = new HttpHeaders();
		String filename = "";
		int len = 0;
		HomeBean bean = homeService.getHomeImg(homeId);
		if (bean != null) {
			Blob blob = bean.getHomeImg();
			filename = bean.getHomeFileName();
			if (blob != null) {
				try {
					len = (int) blob.length();
					media = blob.getBytes(1, len);
				} catch (SQLException e) {
					throw new RuntimeException("ProductController的getPicture()發生SQLException: " + e.getMessage());
				}
			} else {
				media = toByteArray1(filePath);
				filename = filePath;
			}
		} else {
			media = toByteArray1(filePath);
			filename = filePath;
		}
		headers.setCacheControl(CacheControl.noCache().getHeaderValue());
		String mimeType = context.getMimeType(filename);
		MediaType mediaType = MediaType.valueOf(mimeType);		
		headers.setContentType(mediaType);
		ResponseEntity<byte[]> responseEntity = new ResponseEntity<>(media, headers, HttpStatus.OK);
		return responseEntity;
	}
	private byte[] toByteArray1(String filepath) {
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
