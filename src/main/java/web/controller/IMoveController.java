package web.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
//import java.sql.SQLException;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
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
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.web.store.model.CartOrderBean;
import com.web.store.model.RoomBean;
import com.web.store.model.SurveyBean;
import com.web.store.service.ProductServiec;

import web.room.service.RoomService;

@Controller
public class IMoveController {
//	@RequestMapping("/products")
	
	@Autowired
	RoomService service;
	@Autowired
	ProductServiec serviceP;
	
	@Autowired
	ServletContext context;
	
	@GetMapping("/Manager")//後端畫面，有拉資料表的內容
	public String Manager(Model model, HttpServletRequest req) {
		Map<String,CartOrderBean> order = service.getCartOrderBean();
		model.addAttribute("CartOrderBean",order);
		Map<Integer,SurveyBean> survey = service.getSurveyBean();
		model.addAttribute("SurveyBean",survey);
		Integer AllMoney = serviceP.getAllMoney();   //全部訂單總金額
		Integer AllMemberQua = serviceP.getAllMemberQua(); //全部會員人數
		Integer AllRoomQua = serviceP.getAllRoomQua();   //全部訂單數(不重複)
		Integer AllRateMemberQua = serviceP.getAllRateMemberQua();  //全部評分人數
		Integer AllStar = serviceP.getAllStar(); //全部評分總分數
		model.addAttribute("AllMoney",AllMoney);
		model.addAttribute("AllMemberQua",AllMemberQua);
		model.addAttribute("AllRoomQua",AllRoomQua);
		model.addAttribute("AllRateMemberQua",AllRateMemberQua);
		model.addAttribute("AllStar",AllStar);
		return "Manager/index";
	}
	@GetMapping("/ManagerTest")//包廂測試畫面，有拉資料表的內容
	public String ManagerTest(Model model, HttpServletRequest req) {
		return "Manager/test";
	}
	@GetMapping("/PieChart")//包廂測試畫面，有拉資料表的內容
	public String PieChart(Model model, HttpServletRequest req) {
		return "Manager/PieChart";
	}
	
	@GetMapping("/Room")//包廂測試畫面，有拉資料表的內容
	public String updateRoom(Model model, HttpServletRequest req) {
		Map<Integer, RoomBean> rooMap = service.getRoom();
		model.addAttribute("rooMap",rooMap);
		RoomBean roomBean = new RoomBean();
		model.addAttribute("roomBean",roomBean);
		return "Room/RoomUpdata";
	}
	
	@PostMapping(value = "/AddRoomAjax",produces = "application/json")//新增包廂AJAX
	public ResponseEntity<List<RoomBean>> AddRoomAjax(@ModelAttribute("roomBean") RoomBean roomBean){
		MultipartFile productImage = roomBean.getProductImage();
		String originalFilename = productImage.getOriginalFilename();
		roomBean.setRoomFileName(originalFilename);
		//  建立Blob物件，交由 Hibernate 寫入資料庫
		if (productImage != null && !productImage.isEmpty() ) {
			try {
				byte[] b = productImage.getBytes();
				Blob blob = new SerialBlob(b);
				roomBean.setRoomImg(blob);
			} catch(Exception e) {
				e.printStackTrace();
				throw new RuntimeException("檔案上傳發生異常: " + e.getMessage());
			}
		}
		SimpleDateFormat sdFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = new Date();
		String FoodDate = sdFormat.format(date);
        Date d1 = Timestamp.valueOf(FoodDate);
        roomBean.setRoomDate(d1);
        String roomSize = roomBean.getRoomSize();
        String roomSizeList[] = roomSize.split(",");
        roomBean.setRoomSize(roomSizeList[0]);
        roomBean.setRoomPopulation(roomSizeList[1]);
		List<RoomBean> roomList = service.AddRoomAjax(roomBean);
		ResponseEntity<List<RoomBean>> AddRoomAjax = new ResponseEntity<>(roomList, HttpStatus.OK);
		return AddRoomAjax;
	}
	
	@PostMapping(value = "/UpRoomAjax",produces = "application/json")
	public ResponseEntity<List<RoomBean>> UpRoomAjax(@ModelAttribute("roomBean") RoomBean roomBean){
		long sizeInBytes = 0;
		InputStream is = null;
		MultipartFile productImage = roomBean.getProductImage();
		String originalFilename = productImage.getOriginalFilename();
		roomBean.setRoomFileName(originalFilename);
		//  建立Blob物件，交由 Hibernate 寫入資料庫
		if (productImage != null && !productImage.isEmpty() ) {
			
			try {
				byte[] b = productImage.getBytes();
				Blob blob = new SerialBlob(b);
				roomBean.setRoomImg(blob);
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
        roomBean.setRoomDate(d1);
        String roomSize = roomBean.getRoomSize();
        String roomSizeList[] = roomSize.split(",");
        roomBean.setRoomSize(roomSizeList[0]);
        roomBean.setRoomPopulation(roomSizeList[1]);
		service.RoomUpdata(roomBean, sizeInBytes);
		List<RoomBean> list = service.getUpRoom(roomBean.getRoomId());
		ResponseEntity<List<RoomBean>> UpRoom = new ResponseEntity<>(list,HttpStatus.OK);
		return UpRoom;
	}
	
	@PostMapping(value = "/SearchRoomAjax",produces = "application/json")
	public ResponseEntity<List<RoomBean>> SearchRoomAjax(String name){
		
		List<RoomBean> list = service.SearchRoomAjax(name);
		ResponseEntity<List<RoomBean>> UpRoom = new ResponseEntity<>(list,HttpStatus.OK);
		return UpRoom;
	}
	
	@PostMapping("/Room")
	public String roomUpdata(@ModelAttribute("roomUpdata") RoomBean roomBean ,Model model) {
		//System.out.println(roomBean.getRoomIdUp());
		//String roomId1 = roomBean.getRoomIdUp();
		//Integer roomId = Integer.parseInt(roomId1);
//		Integer roomId = Integer.parseInt(roomBean.getRoomIdUp());
		//roomBean.setRoomId(roomId);
		long sizeInBytes = 0;
		InputStream is = null;
		MultipartFile productImage = roomBean.getProductImage();
		String originalFilename = productImage.getOriginalFilename();
		roomBean.setRoomFileName(originalFilename);
		//  建立Blob物件，交由 Hibernate 寫入資料庫
		if (productImage != null && !productImage.isEmpty() ) {
			
			try {
				byte[] b = productImage.getBytes();
				Blob blob = new SerialBlob(b);
				roomBean.setRoomImg(blob);
				sizeInBytes = 1;
			} catch(Exception e) {
				e.printStackTrace();
				throw new RuntimeException("檔案上傳發生異常: " + e.getMessage());
			}
		}else {
			sizeInBytes = -1;
		}
		service.RoomUpdata(roomBean, sizeInBytes);
		return "redirect:/Room";
	}
	
	@GetMapping("/RoomIn")//新增包廂測試畫面，回傳空的表單
	public String RoomIn(Model model) {
		RoomBean roomBean = new RoomBean();
		model.addAttribute("roomBean",roomBean);
		return "Room/Room";
	}
	
	@PostMapping("/RoomIn")//新增包廂測試
	public String addRoomIn(@ModelAttribute("roomBean") RoomBean roomBean, BindingResult result) {
//		String[] suppressedFields = result.getSuppressedFields();
//		if (suppressedFields.length > 0) {
//			throw new RuntimeException("嘗試傳入不允許的欄位: " + StringUtils.arrayToCommaDelimitedString(suppressedFields));
//		}
		MultipartFile productImage = roomBean.getProductImage();
		String originalFilename = productImage.getOriginalFilename();
		roomBean.setRoomFileName(originalFilename);
		//  建立Blob物件，交由 Hibernate 寫入資料庫
		if (productImage != null && !productImage.isEmpty() ) {
			try {
				byte[] b = productImage.getBytes();
				Blob blob = new SerialBlob(b);
				roomBean.setRoomImg(blob);
			} catch(Exception e) {
				e.printStackTrace();
				throw new RuntimeException("檔案上傳發生異常: " + e.getMessage());
			}
		}
		service.saveRoom(roomBean);
		String ext = originalFilename.substring(originalFilename.lastIndexOf("."));
		String rootDirectory = context.getRealPath("/");
		try {
			File imageFolder = new File(rootDirectory, "images");
			if (!imageFolder.exists()) imageFolder.mkdirs();
			File file = new File(imageFolder, roomBean.getRoomId() + ext);
			productImage.transferTo(file);
		} catch(Exception e) {
			e.printStackTrace();
			throw new RuntimeException("檔案上傳發生異常: " + e.getMessage());
		}
		return "redirect:/Room";
	}
	
	@InitBinder
	public void whiteListing(WebDataBinder binder) {
		binder.setAllowedFields("roomId"
								,"roomName"
								, "roomSize"
								, "roomPrice"
								, "roomNote"
								, "productImage"				
								);
	}
	
	@PostMapping("/RoomDelete")//刪除包廂測試
	public String RoomDelete(@RequestParam Integer RoomId, Model model) {
		//HttpSession session = model.getSession();
		service.RoomDelete(RoomId);
//		int n = service.RoomDelete(RoomId);
//		if (n == 1) {
//			model.addAttribute("BookDeleteMsg", "刪除成功");
//		} else {
//			model.addAttribute("BookDeleteMsg", "刪除失敗");
//		}
		return "redirect:/Room";
	}
	
	@GetMapping("/roomTest")//回測是首頁
	public String RoomTest() {
		return "DanielTest";
	}
	
	@GetMapping("/getRoomImg/{roomId}")//包廂測試畫面，圖片(資料表內容，二進制轉圖片)
	public ResponseEntity<byte[]> getPicture(HttpServletResponse resp, @PathVariable Integer roomId) {
		String filePath = "/resources/images/NoImage.jpg";
		byte[] media = null;
		HttpHeaders headers = new HttpHeaders();
		String filename = "";
		int len = 0;
		RoomBean bean = service.getRoomImg(roomId);
		if (bean != null) {
			Blob blob = bean.getRoomImg();
			filename = bean.getRoomFileName();
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
