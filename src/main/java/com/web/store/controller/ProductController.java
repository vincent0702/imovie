package com.web.store.controller;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.sql.Blob;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.CacheControl;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.context.request.WebRequest;

import com.web.store.model.CartOrderBean;
import com.web.store.model.FoodBean;
import com.web.store.model.FoodBeanWithImageData;
import com.web.store.model.FoodShoppingCart;
import com.web.store.model.Food_Genre;
import com.web.store.model.HomeBeanWithImageData;
import com.web.store.model.MovieBean;
import com.web.store.model.MovieBeanWithImageData;
import com.web.store.model.Movie_Genre;
import com.web.store.model.RoomBean;
import com.web.store.model.RoomBeanWithImageData;
import com.web.store.service.ProductServiec;

import ecpay.payment.integration.AllInOne;
import ecpay.payment.integration.domain.AioCheckOutALL;

@Controller
@SessionAttributes({"FoodCart","allFood","room","movie","main","dessert","drink","packa","OrderCart","categoryList"})
public class ProductController {
	public static AllInOne all;
	@Autowired
	ProductServiec service;

	@Autowired
	ServletContext context;
	
	private static void initial(){
		all = new AllInOne("");
	}
	//Home Ajax分類顯示
		@GetMapping("/allHomes")
		public ResponseEntity<List<HomeBeanWithImageData>>  allHomesWithImageData()  {
			System.out.println("A----------------------");
			List<HomeBeanWithImageData> list = service.getAllHomesWithImageData();
			ResponseEntity<List<HomeBeanWithImageData>> he = new ResponseEntity<>(list, HttpStatus.OK);
			return he;
		}
		//Home Ajax分類顯示
		@GetMapping("/allHomevedio")
		public ResponseEntity<List<HomeBeanWithImageData>>  allHomesWithImageData1()  {
			System.out.println("A----------------------");
			List<HomeBeanWithImageData> list = service.getAllHomesWithImageData();
			ResponseEntity<List<HomeBeanWithImageData>> he = new ResponseEntity<>(list, HttpStatus.OK);
			return he;
		}
	
	//Food Ajax分類顯示
	@GetMapping("/allFoods")
	public ResponseEntity<List<FoodBeanWithImageData>>  allFoodsWithImageData()  {
		System.out.println("A----------------------");
		List<FoodBeanWithImageData> list = service.getAllFoodsWithImageData();
		ResponseEntity<List<FoodBeanWithImageData>> re = new ResponseEntity<>(list, HttpStatus.OK);
		return re;
	}
	
	//Movie Ajax顯示
	@GetMapping("/allMovies")
	public ResponseEntity<List<MovieBeanWithImageData>>  allMoviesWithImageData()  {
		System.out.println("Z----------------------");
		List<MovieBeanWithImageData> list = service.getAllMoviesWithImageData();
		ResponseEntity<List<MovieBeanWithImageData>> re = new ResponseEntity<>(list, HttpStatus.OK);
		return re;
	}
	
	//Room Ajax顯示
	@GetMapping("/allRooms")
	public ResponseEntity<List<RoomBeanWithImageData>>  allRoomsWithImageData()  {
		System.out.println("Z----------------------");
		List<RoomBeanWithImageData> list = service.getAllRoomsWithImageData();
		ResponseEntity<List<RoomBeanWithImageData>> re = new ResponseEntity<>(list, HttpStatus.OK);
		return re;
	}
	
	
	
	//Food Ajax分類顯示	
	@RequestMapping(value ="/allFood",method = RequestMethod.GET)
	public ResponseEntity<List<FoodBean>>  allFoodPublishers(@RequestParam ("foodTypeStr") String foodTypeStr, Model model)  {		
		List<FoodBean> list = service.getFoodByString(foodTypeStr);
		ResponseEntity<List<FoodBean>> re = new ResponseEntity<>(list, HttpStatus.OK);
		return re;
	}
	//Movie Ajax分類顯示
	@RequestMapping(value ="/allMovie",method = RequestMethod.GET)
	public ResponseEntity<List<MovieBean>>  allMoviePublishers(@RequestParam Integer movieTypeId, Model model)  {		
		List<MovieBean> list = service.getSelectmovies(movieTypeId);
		ResponseEntity<List<MovieBean>> se = new ResponseEntity<>(list, HttpStatus.OK);
		 System.out.println("M----------------------"+movieTypeId);
		return se;
	}
	//Room Ajax分類顯示
	@RequestMapping(value ="/allRoom",method = RequestMethod.GET)
	public ResponseEntity<List<RoomBean>>  allRoomPublishers(@RequestParam ("roomTypeStr")String TypeStr, Model model)  {		
		List<RoomBean> list = service.getRoomByString(TypeStr);
		ResponseEntity<List<RoomBean>> ro = new ResponseEntity<>(list, HttpStatus.OK);
		return ro;
	}
	
	//Food 方法
	@RequestMapping("/menu")
	public String list(Model model, String type) {
		List<Food_Genre> list = service.getAllFoodType ();
		List<FoodBean> beans = service.getFoodByCategory(type);
		model.addAttribute("categoryList", list);
		model.addAttribute("menu", beans);
		return "menu";

	}
		
	@GetMapping("/product")
	public String getProductById(@RequestParam Integer id, Model model) {
		model.addAttribute("product", service.getProductById(id));
		return "product";
	}
	
	// movie方法
	@RequestMapping("/movie")
	public String list1(Model model, String type) {
//		List<MovieBean> list = service.getSelectmovieTypes();
		List<MovieBean> beans = service.getProductsByCategory1(type);
		List<Movie_Genre> movieTList = service.getAllMovieType ();
		
		model.addAttribute("categoryList", movieTList);
		model.addAttribute("movie", beans);			
		return "movie";
	}
	
	@GetMapping("/product1")
	public String getProductById1(@RequestParam Integer id, Model model) {
		model.addAttribute("product1", service.getProductById1(id));
		return "product1";
	}

	// room方法
	@RequestMapping("/room")
	public String list2(Model model,String type) {
		List<String> list = service.getAllRoom ();
		List<RoomBean> beans = service.getProductsByCategory2(type);
		model.addAttribute("categoryList", list);
		model.addAttribute("room", beans);
		return "room";

	}

	@GetMapping("/product2")
	public String getProductById2(@RequestParam Integer id, Model model) {
		model.addAttribute("product2", service.getProductById2(id));
		return "product2";
	}

//-----------------------測試購物車0704、0705------------------------

	
	@GetMapping("/testCart")
	public String Flist(Model model, HttpServletRequest req) {
		
		List<RoomBean> Roombeans = service.getAllProducts2();
		model.addAttribute("room", Roombeans);
		List<MovieBean> Moviebeans = service.getAllProducts1();
		model.addAttribute("movie", Moviebeans);
		List<FoodBean> Foodbeans = service.getAllProducts();
		model.addAttribute("Food", Foodbeans);
		
		List<Movie_Genre> list = service.getAllMovieType(); //電影類型
		model.addAttribute("categoryList", list);
		
		
		model.addAttribute("allFood",Foodbeans);
		List<FoodBean> stapleFood = new ArrayList<FoodBean>();
		List<FoodBean> dessert = new ArrayList<FoodBean>();
		List<FoodBean> drink = new ArrayList<FoodBean>();
		List<FoodBean> packa = new ArrayList<FoodBean>();
		String type = null;
		for(FoodBean fd : Foodbeans) {
			type =  fd.getFoodType();
			switch(type) {
				case "主食":
					stapleFood.add(fd);
					break;
				case "飲品":
					drink.add(fd);
					break;
				case "點心":
					dessert.add(fd);
					break;
				case "套餐":
					packa.add(fd);
					break;
				default: 
					break;
			}
		}
		
		model.addAttribute("main",stapleFood);
		model.addAttribute("dessert",dessert);
		model.addAttribute("drink",drink);
		model.addAttribute("packa",packa);
		return "testProject";
	}
	
	@GetMapping("/getFoodImg/{foodId}")
	private ResponseEntity<byte[]> foodImg(HttpServletRequest req, 
			@PathVariable Integer foodId){
		String noImagePath = "\\resources\\images\\NoImage.jpg";
		ResponseEntity<byte[]> img = null;
		FoodBean bean = service.getProductById(foodId);
		ByteArrayOutputStream baos = null;
		InputStream is = null;
		
		try {
			Blob blob = bean.getFoodImg();
			if(blob != null) {
				is = blob.getBinaryStream(); // inputStream轉成位元組陣列
			}else {
				;
			}
			if(is == null) {
				is = context.getResourceAsStream(noImagePath);
			}
			
			baos = new ByteArrayOutputStream();
			int len = 0;
			byte[] b = new byte[819200];
			while((len = is.read(b))!=-1) {
				baos.write(b, 0, len);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		byte[] b0 = baos.toByteArray();
		
		String filename = bean.getFoodFileName();
		String mimeType = null;
		MediaType mediaType = null;
		
		if(filename!=null) {
			mimeType = context.getMimeType(filename);
//			mediaType = MediaType.valueOf(mimeType);
		}else {
			mimeType = context.getMimeType(noImagePath);
//			mediaType = MediaType.valueOf(mimeType);
		}
		mediaType = MediaType.valueOf(mimeType);

		HttpHeaders headers = new HttpHeaders();
		
		//Parameters:mediaType 
		headers.setContentType(mediaType);
		headers.setCacheControl(CacheControl.noCache().getHeaderValue());
		img = new ResponseEntity<>(b0, headers, HttpStatus.OK);
				
		return img;
	}
  
	
//-------------------------測試購物車------------------------------

	// 分類查詢
		@GetMapping("{category}")
		public String getProductsByCategory(@PathVariable String category, Model model) {
			String type = "";
			List<String> movieList = service.getAllCategories1();
			List<String> foodList = service.getAllCategories();
			List<String> roomList = service.getAllCategories2();
			for (String movie : movieList) {
				if (movie.equals(category)) {
					type = "movie";
					List<MovieBean> products = service.getProductsByCategory1(category);
					model.addAttribute("movie", products);
					return "movie";
				}
				for (String food : foodList) {
					if (food.equals(category)) {
						type = "food";
						List<FoodBean> products = service.getFoodByCategory(category);
						model.addAttribute("menu", products);
						return "menu";
					}
				}
			}
			for (String room : roomList) {
				if (room.equals(category)) {
					type = "room";
					List<RoomBean> products = service.getProductsByCategory2(category);
					model.addAttribute("room", products);
					return "room";
				}
			}
			return "";
		}
		
		@GetMapping(value = "/getPicture/{foodId}")
		public ResponseEntity<byte[]> getPicture(HttpServletResponse resp, @PathVariable Integer foodId) {
			String filePath = "/resources/images/NoImage.jpg";

			byte[] media = null;
			HttpHeaders headers = new HttpHeaders();
			String filename = "";
			int len = 0;
			FoodBean bean = service.getProductById(foodId);
			System.out.println(bean);
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
			System.out.println("mediaType =" + mediaType);
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
		
		@GetMapping(value = "/getPicture1/{movieId}")
		private ResponseEntity<byte[]> movieImg(HttpServletRequest req, 
				@PathVariable Integer movieId){
			String noImagePath = "\\resources\\images\\NoImage.jpg";
			ResponseEntity<byte[]> img = null;
			MovieBean bean = service.getProductById1(movieId);
			ByteArrayOutputStream baos = null;
			InputStream is = null;
			
			try {
				Blob blob = bean.getMovieImg();
				if(blob != null) {
					is = blob.getBinaryStream(); // inputStream轉成位元組陣列
				}else {
					;
				}
				if(is == null) {
					is = context.getResourceAsStream(noImagePath);
				}
				
				baos = new ByteArrayOutputStream();
				int len = 0;
				byte[] b = new byte[819200];
				while((len = is.read(b))!=-1) {
					baos.write(b, 0, len);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			byte[] b0 = baos.toByteArray();
			
			String filename = bean.getMovieFileName();
			String mimeType = null;
			MediaType mediaType = null;
			
			if(filename!=null) {
				mimeType = context.getMimeType(filename);
//				mediaType = MediaType.valueOf(mimeType);
			}else {
				mimeType = context.getMimeType(noImagePath);
//				mediaType = MediaType.valueOf(mimeType);
			}
			mediaType = MediaType.valueOf(mimeType);

			HttpHeaders headers = new HttpHeaders();
			
			//Parameters:mediaType 
			headers.setContentType(mediaType);
			headers.setCacheControl(CacheControl.noCache().getHeaderValue());
			img = new ResponseEntity<>(b0, headers, HttpStatus.OK);
					
			return img;
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
		
		@GetMapping(value = "/getPicture2/{roomId}")
		private ResponseEntity<byte[]> roomImg(HttpServletRequest req, 
				@PathVariable Integer roomId){
			String noImagePath = "\\resources\\images\\NoImage.jpg";
			ResponseEntity<byte[]> img = null;
			RoomBean bean = service.getProductById2(roomId);
			ByteArrayOutputStream baos = null;
			InputStream is = null;
			
			try {
				Blob blob = bean.getRoomImg();
				if(blob != null) {
					is = blob.getBinaryStream(); // inputStream轉成位元組陣列
				}else {
					;
				}
				if(is == null) {
					is = context.getResourceAsStream(noImagePath);
				}
				
				baos = new ByteArrayOutputStream();
				int len = 0;
				byte[] b = new byte[819200];
				while((len = is.read(b))!=-1) {
					baos.write(b, 0, len);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			byte[] b0 = baos.toByteArray();
			
			String filename = bean.getRoomFileName();
			String mimeType = null;
			MediaType mediaType = null;
			
			if(filename!=null) {
				mimeType = context.getMimeType(filename);
//				mediaType = MediaType.valueOf(mimeType);
			}else {
				mimeType = context.getMimeType(noImagePath);
//				mediaType = MediaType.valueOf(mimeType);
			}
			mediaType = MediaType.valueOf(mimeType);

			HttpHeaders headers = new HttpHeaders();
			
			//Parameters:mediaType 
			headers.setContentType(mediaType);
			headers.setCacheControl(CacheControl.noCache().getHeaderValue());
			img = new ResponseEntity<>(b0, headers, HttpStatus.OK);
					
			return img;
		}
		
		private byte[] toByteArray2(String filepath) {
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
		//綠界測試
		@RequestMapping("/opay")
		public void opay(Model model,HttpServletResponse response, WebRequest webRequest, SessionStatus status,@RequestParam(name = "finalTotal") String totalAmount , 
				@RequestParam(name = "orderDate")String orderDate , 
				@RequestParam(name = "timeStart")String orderStart , 
				@RequestParam(name = "timeEnd")String orderEnd , 
				@RequestParam(name = "orderNum")String orderNo) throws UnsupportedEncodingException {
			
			CartOrderBean cob = (CartOrderBean) model.getAttribute("OrderCart");
			FoodShoppingCart fsc = (FoodShoppingCart) model.getAttribute("FoodCart");
			
			System.out.println("TotalAmount = "+cob.getTotalAmount());
			System.out.println("cobID = "+cob.getOrderNo());
			System.out.println("fsc = "+fsc);
			
			service.cartToDB(cob);
			status.setComplete();
			webRequest.removeAttribute("FoodCart", WebRequest.SCOPE_SESSION);
			webRequest.removeAttribute("OrderCart", WebRequest.SCOPE_SESSION);
			initial();
			try {
				AioCheckOutALL obj = new AioCheckOutALL();
				SimpleDateFormat sdFormat = new SimpleDateFormat("yyyy/MM/dd hh:mm:ss");
				Date date = new Date();
				String strDate = sdFormat.format(date);
				obj.setMerchantTradeNo(orderNo);				
				obj.setMerchantTradeDate(strDate);
				obj.setTotalAmount(totalAmount);
//				obj.setTradeDesc("請提早至少10分鐘到現場確認。如欲取消訂單，最晚預約前一天來電取消。");
				obj.setTradeDesc("Imovie+%e9%9b%bb%e5%bd%b1%e9%a4%a8");
				obj.setItemName("Imovie 預訂服務");
				obj.setReturnURL("http://211.23.128.214:5000");
				obj.setClientBackURL("http://localhost:8080/ImovieS/");
				obj.setNeedExtraPaidInfo("N");
				
			String form = all.aioCheckOut(obj, null);
			response.setCharacterEncoding("UTF-8");
			PrintWriter out =response.getWriter();
			
			out.print("<html>");
			out.print("<meta http-equiv='Content-Type' content='text/html; charset=UTF-8'>");
			out.print("<title>oPay</title>");
			out.print("<body>");
			out.print(form);
			out.print("</body>");
			out.print("</html>");
			out.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		@PostMapping(value= "/searchMovieType", produces = {"application/json"})
		protected ResponseEntity<List<MovieBean>> searchType(Model model, HttpServletRequest request, HttpServletResponse response , 
				 @RequestParam (value = "typeStr") String movieTStr){
			
			List<MovieBean> typeMovie = service.getMovieByString(movieTStr);
			ResponseEntity<List<MovieBean>> movies = new ResponseEntity<>(typeMovie,HttpStatus.OK);
			
			System.out.println("看到此行，分類已經到底囉");
			return movies;
		}
		

		@GetMapping(value= "/roomAnalysis", produces = {"application/json"})
		protected ResponseEntity<List<Map<String,String>>> toChart(Model model, HttpServletRequest req) {
			
			List<Map<String,String>> list = new ArrayList<Map<String,String>>();
			ArrayList<Integer> bookedId = service.getBookedList();
			System.out.println("?????東西呢");
			DecimalFormat df = new DecimalFormat("##.00");
			
			
			String nameStr = "";
			String rateStr = "";
//			ArrayList<String> roomName = new ArrayList<String>();
//			ArrayList<String> roomRateStr = new ArrayList<String>();
			int listSize = bookedId.size();
			int test = 0;
			for(Integer id : bookedId) {
				
				int roomId = (int)id;
				System.out.println("getRate = "+service.getRate(roomId));
				double rate = Double.parseDouble(df.format(service.getRate(roomId)*100));
				String bookedRate = String.valueOf(rate);
				System.out.println("轉換前double:"+rate+" ,轉換後:"+bookedRate);
				String name = service.getProductById2(roomId).getRoomName();
				System.out.println(name);
				Map<String, String> map = new HashMap<String, String>();
				map.put("roomName",name);
				map.put("roomRate",bookedRate);
				list.add(map);
				test++;
				if(test==listSize) {
					nameStr += name;
					rateStr += bookedRate;
				}else {
					nameStr += name+",";
					rateStr += bookedRate+",";
				}
			}
			
			System.out.println(nameStr+"wtfwtfwtfwtfwtf");
			System.out.println(rateStr+"wtfwtfwtfwtfwtf");
			String[] nameStrSplit = nameStr.split(",");
			String[] rateStrSplit = rateStr.split(",");
			for (int i = 0; i < nameStrSplit.length; i++) {
				
				System.out.println(nameStrSplit[i]+"="+rateStrSplit[i]);
			}
			ResponseEntity<List<Map<String,String>>> re = new ResponseEntity<>(list,HttpStatus.OK);
			return re;
		}

		@GetMapping("/hihihi")
		public String wtf(Model model, HttpServletRequest req) {
			return "columnChart";
		}
		
		
}
