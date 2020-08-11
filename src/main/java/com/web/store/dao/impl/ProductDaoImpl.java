package com.web.store.dao.impl;

import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.web.store.dao.ProductDao;
import com.web.store.model.CartOrderBean;
import com.web.store.model.CartOrderFood;
import com.web.store.model.FoodBean;
import com.web.store.model.FoodBeanWithImageData;
import com.web.store.model.Food_Genre;
import com.web.store.model.HomeBean;
import com.web.store.model.HomeBeanWithImageData;
import com.web.store.model.MovieBean;
import com.web.store.model.MovieBeanWithImageData;
import com.web.store.model.Movie_Genre;
import com.web.store.model.RoomBean;
import com.web.store.model.RoomBeanWithImageData;
import com.web.store.model.SurveyBean;

import _00_init.util.GlobalService;
import _01_register.model.MemberBean;
import antlr.StringUtils;

@Repository
public class ProductDaoImpl implements ProductDao {
	
	@Autowired
	SessionFactory factory;
	
	@Autowired
	ServletContext ctx;
	
	String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    String url = "jdbc:sqlserver://localhost:1433;DatabaseName=Imovie";
    String userid = "sa";
    String passwd = "sa123456";
	
    private static final String SELECT_all_foodTypes = "Select Distinct b.foodType , b.foodTypeId From Food b";
    private static final String SELECT_foods = "Select * From Food where foodTypeId=?";
    private static final String SELECT_all_movieTypes = "Select Distinct m.movieGenre1 , m.movieTypeId From Movie m";
    private static final String SELECT_movies = "Select * From Movie where movieTypeId=?";
    private static final String SELECT_all_roomTypes = "Select Distinct r.roomName , r.roomNameId From Room r";
    private static final String SELECT_rooms = "Select * From Room where roomNameId=?";
    
	Integer foodId;
	Integer movieId;
	Integer roomId;
	Integer recordsPerPage = GlobalService.RECORDS_PER_PAGE;
	public Integer getFoodId() {
		return foodId;
	}

	public Integer getRoomId() {
		return roomId;
	}

	public void setRoomId(Integer roomId) {
		this.roomId = roomId;
	}

	public void setFoodId(Integer foodId) {
		this.foodId = foodId;
	}
	
	public Integer getMovieId() {
		return movieId;
	}

	public void setMovieId(Integer movieId) {
		this.movieId = movieId;
	}
	//首頁 顯示
	@Override
	public List<HomeBeanWithImageData> getAllHomesWithImageData() {
		List<HomeBean> listSource = getAllHomesJson();
		List<HomeBeanWithImageData> listTarget = new ArrayList<>();
		for(HomeBean bean : listSource) {
			listTarget.add(addImageData(bean));
		}
		return listTarget;
	}
	
	private HomeBeanWithImageData addImageData(HomeBean bean) {
		HomeBeanWithImageData bbwid = null;
		try {
			StringBuffer sb = new StringBuffer();
			String fileName = bean.getHomeFileName();
			String mimeType = ctx.getMimeType(fileName);
			Blob blob = bean.getHomeImg();
			byte[] bytes = blob.getBytes(1, (int) blob.length());
			String prefix = "data:" + mimeType + ";base64,";
			sb.append(prefix);
			Base64.Encoder be = Base64.getEncoder();
			String str = new String(be.encode(bytes));
			sb.append(str);
			String iamgeData = sb.toString();
			bbwid = new HomeBeanWithImageData(bean, iamgeData);
		} catch (Exception e) {
			e.printStackTrace();
		}		
		return bbwid;		
	}

	@SuppressWarnings("unchecked")
	private List<HomeBean> getAllHomesJson() {
		String hql = "FROM HomeBean";
		Session session = factory.getCurrentSession();
		List<HomeBean> list = session.createQuery(hql).getResultList();
		return list;
	}

	//Food的方法
	@Override
	@SuppressWarnings("unchecked")
	public List<FoodBean> getAllProducts() {
		String hql ="From FoodBean";
		Session session = factory.getCurrentSession();
		List<FoodBean> beans = session.createQuery(hql)
										.getResultList();
		return beans;
	}


	//取得類型
	@SuppressWarnings("unchecked")
	@Override
	public List<String> getAllCategories() { 
		String hql="Select Distinct foodType,foodTypeId From FoodBean ";
		Session session = factory.getCurrentSession();
		return session.createQuery(hql).getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<FoodBean> getFoodByCategory(String category) {
		String hql="From FoodBean bb ";
		Session session = factory.getCurrentSession();		
		if(!"foodall".equals(category)) {
			hql+="Where bb.foodType = :category";
			return session.createQuery(hql)
					   .setParameter("category",category)
					   .getResultList();
		}else {
			return session.createQuery(hql).getResultList();
		}
		
	}


	@Override
	public FoodBean getProductById(int productId) {
		Session session = factory.getCurrentSession();
		return session.get(FoodBean.class,productId);
	}
	
	public FoodBeanWithImageData addImageData(FoodBean bean) {
		FoodBeanWithImageData bbwid = null;
		try {
			StringBuffer sb = new StringBuffer();
			String fileName = bean.getFoodFileName();
			String mimeType = ctx.getMimeType(fileName);
			Blob blob = bean.getFoodImg();
			byte[] bytes = blob.getBytes(1, (int) blob.length());
			String prefix = "data:" + mimeType + ";base64,";
			sb.append(prefix);
			Base64.Encoder be = Base64.getEncoder();
			String str = new String(be.encode(bytes));
			sb.append(str);
			String iamgeData = sb.toString();
			bbwid = new FoodBeanWithImageData(bean, iamgeData);
		} catch (Exception e) {
			e.printStackTrace();
		}		
		return bbwid;		
	}
	@Override
	public List<FoodBeanWithImageData> getAllFoodsWithImageData() {
		List<FoodBean> listSource = getAllFoodsJson();
		List<FoodBeanWithImageData> listTarget = new ArrayList<>();
		for(FoodBean bean : listSource) {
			listTarget.add(addImageData(bean));
		}
		return listTarget;
	}

	@SuppressWarnings("unchecked")
	public List<FoodBean> getAllFoodsJson()  {
		String hql = "FROM FoodBean";
		Session session = factory.getCurrentSession();
		List<FoodBean> list = session.createQuery(hql).getResultList();
		return list;
	}
	
	//movie 的方法
	@SuppressWarnings("unchecked")
	@Override
	public List<MovieBean> getAllProducts1() {
		String hql ="From MovieBean";
		Session session = factory.getCurrentSession();
		List<MovieBean> beans = session.createQuery(hql)
										.getResultList();
		return beans;
	}
	//取得類型
	@SuppressWarnings("unchecked")
	@Override
	public List<String> getAllCategories1() {
		String hql="Select Distinct movieGenre1,movieTypeId From MovieBean ";
		Session session = factory.getCurrentSession();
		return session.createQuery(hql).getResultList();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<MovieBean> getProductsByCategory1(String category) {
		String hql="From MovieBean mm ";
		Session session = factory.getCurrentSession();
		if(!"movieall".equals(category)) {
			hql+="Where mm.movieGenre1 = :category";
			return session.createQuery(hql)
					   .setParameter("category",category)
					   .getResultList();
		}else {
			return session.createQuery(hql).getResultList();
		}
		
	}

	@Override
	public MovieBean getProductById1(int productId) {
		Session session = factory.getCurrentSession();
		return session.get(MovieBean.class,productId);
	}
	
	public MovieBeanWithImageData addImageData(MovieBean bean) {
		MovieBeanWithImageData bbwid = null;
		try {
			StringBuffer sb = new StringBuffer();
			String fileName = bean.getMovieFileName();
			String mimeType = ctx.getMimeType(fileName);
			Blob blob = bean.getMovieImg();
			byte[] bytes = blob.getBytes(1, (int) blob.length());
			String prefix = "data:" + mimeType + ";base64,";
			sb.append(prefix);
			Base64.Encoder be = Base64.getEncoder();
			String str = new String(be.encode(bytes));
			sb.append(str);
			String iamgeData = sb.toString();
			bbwid = new MovieBeanWithImageData(bean, iamgeData);
		} catch (Exception e) {
			e.printStackTrace();
		}		
		return bbwid;		
	}
	@Override
	public List<MovieBeanWithImageData> getAllMoviesWithImageData() {
		List<MovieBean> listSource = getAllMoviesJson();
		List<MovieBeanWithImageData> listTarget = new ArrayList<>();
		for(MovieBean bean : listSource) {
			listTarget.add(addImageData(bean));
		}
		return listTarget;
	}
	@SuppressWarnings("unchecked")
	public List<MovieBean> getAllMoviesJson()  {
		String hql = "FROM MovieBean";
		Session session = factory.getCurrentSession();
		List<MovieBean> list = session.createQuery(hql).getResultList();
		return list;
	}
	
	//room方法
	@SuppressWarnings("unchecked")
	@Override
	public List<String> getAllCategories2() {
		String hql="Select Distinct r.roomSize From RoomBean r";
		Session session = factory.getCurrentSession();
		return session.createQuery(hql).getResultList();
	}
	//取得類型
	@SuppressWarnings("unchecked")
	@Override
	public List<RoomBean> getAllProducts2() {
		String hql ="From RoomBean";
		Session session = factory.getCurrentSession();
		List<RoomBean> beans = session.createQuery(hql)
										.getResultList();
		return beans;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<RoomBean> getProductsByCategory2(String category) {
		String hql="From RoomBean rr ";
		Session session = factory.getCurrentSession();		
		if(!"roomall".equals(category)) {
			hql+="Where rr.roomSize = :category";
			return session.createQuery(hql)
					   .setParameter("category",category)
					   .getResultList();
		}else {
			return session.createQuery(hql).getResultList();
		}
	}
	@Override
	public RoomBean getProductById2(int productId) {
		Session session = factory.getCurrentSession();
		return session.get(RoomBean.class,productId);
	}
	
	public RoomBeanWithImageData addImageData(RoomBean bean) {
		RoomBeanWithImageData bbwid = null;
		try {
			StringBuffer sb = new StringBuffer();
			String fileName = bean.getRoomFileName();
			String mimeType = ctx.getMimeType(fileName);
			Blob blob = bean.getRoomImg();
			byte[] bytes = blob.getBytes(1, (int) blob.length());
			String prefix = "data:" + mimeType + ";base64,";
			sb.append(prefix);
			Base64.Encoder be = Base64.getEncoder();
			String str = new String(be.encode(bytes));
			sb.append(str);
			String iamgeData = sb.toString();
			bbwid = new RoomBeanWithImageData(bean, iamgeData);
		} catch (Exception e) {
			e.printStackTrace();
		}		
		return bbwid;		
	}
	
	@Override
	public List<RoomBeanWithImageData> getAllRoomsWithImageData() {
		List<RoomBean> listSource = getAllRoomsJson();
		List<RoomBeanWithImageData> listTarget = new ArrayList<>();
		for(RoomBean bean : listSource) {
			listTarget.add(addImageData(bean));
		}
		return listTarget;
	}

	@SuppressWarnings("unchecked")
	public List<RoomBean> getAllRoomsJson()  {
		String hql = "FROM RoomBean";
		Session session = factory.getCurrentSession();
		List<RoomBean> list = session.createQuery(hql).getResultList();
		return list;
	}
	
	//Movie Json 分類顯示
	@SuppressWarnings("unchecked")
	@Override
	public List<MovieBean> getPageMovies(Integer pageNo) {
		int startRecordNo = 0;
        startRecordNo = (pageNo - 1) * recordsPerPage;
        List<MovieBean> list = new ArrayList<MovieBean>();
        String hql = "FROM MovieBean";
        Session session = factory.getCurrentSession();
		list = session.createQuery(hql)
                      .setFirstResult(startRecordNo)
                      .setMaxResults(recordsPerPage)
                      .getResultList();        						
		return list;
	}
	
	//Foood Json 分類顯示
		@SuppressWarnings("unchecked")
		@Override
		public List<FoodBean> getPageFoods(Integer pageNo) {
			int startRecordNo = 0;
	        startRecordNo = (pageNo - 1) * recordsPerPage;
	        List<FoodBean> list = new ArrayList<FoodBean>();
	        String hql = "FROM FoodBean";
	        Session session = factory.getCurrentSession();
			list = session.createQuery(hql)
	                      .setFirstResult(startRecordNo)
	                      .setMaxResults(recordsPerPage)
	                      .getResultList();        						
			return list;
		}
		
		//Foood Json 分類顯示
		@SuppressWarnings("unchecked")
		@Override
		public List<FoodBean> getFoodType() {
			String hql="Select Distinct b.foodType From FoodBean b";
			Session session = factory.getCurrentSession();
			return session.createQuery(hql).getResultList();
		}
		
		public List<FoodBean> getSelectfoodTypes(){
			Connection con = null;
			PreparedStatement ps = null;
			List<FoodBean> list = new LinkedList<FoodBean>();
			
			try {
				Class.forName(driver);
				con = DriverManager.getConnection(url, userid, passwd);
				ps = con.prepareStatement(SELECT_all_foodTypes);
				ResultSet rs=ps.executeQuery();
				while(rs.next()) {
					FoodBean foodBean = new FoodBean();
					foodBean = new FoodBean();
					foodBean.setFoodTypeId(rs.getInt("foodTypeId"));
					foodBean.setFoodType(rs.getString("foodType"));
					list.add(foodBean);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			return list;
		}
		//Foood Json 分類顯示
		@Override
		public List<FoodBean> getSelectfoods(Integer foodTypeId) {
			Connection con = null;
			PreparedStatement ps = null;
			List<FoodBean> list = new LinkedList<FoodBean>();
			
			try {
				Class.forName(driver);
				con = DriverManager.getConnection(url, userid, passwd);
				ps = con.prepareStatement(SELECT_foods);
				ps.setInt(1, foodTypeId);
				ResultSet rs=ps.executeQuery();
				while(rs.next()) {
					FoodBean foodBean = new FoodBean();
					foodBean = new FoodBean();
					//圖片轉檔
					StringBuffer sb = new StringBuffer();
					String fileName = rs.getString("foodFileName");
					String mimeType = ctx.getMimeType(fileName);
					Blob blob = rs.getBlob("foodImg");
					byte[] bytes = blob.getBytes(1, (int) blob.length());
					String prefix = "data:" + mimeType + ";base64,";
					sb.append(prefix);
					Base64.Encoder be = Base64.getEncoder();
					String str = new String(be.encode(bytes));
					sb.append(str);
					String iamgeData = sb.toString();				
					foodBean.setFoodTypeId(rs.getInt("foodTypeId"));
					foodBean.setFoodType(rs.getString("foodType"));
					foodBean.setFoodName(rs.getString("foodName"));
					foodBean.setFoodPrice(rs.getInt("foodPrice"));
					foodBean.setFoodImg(rs.getBlob("foodImg"));
					foodBean.setFoodFileName(iamgeData);
					list.add(foodBean);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			return list;
		}
	
	//Movie Json 分類顯示
	@SuppressWarnings("unchecked")
	@Override
	public List<MovieBean> getMovieType() {
		String hql="Select Distinct m.movieGenre1 From MovieBean m";
		Session session = factory.getCurrentSession();
		return session.createQuery(hql).getResultList();
	}
	
	public List<MovieBean> getSelectmovieTypes(){
		Connection con = null;
		PreparedStatement ps = null;
		List<MovieBean> list = new LinkedList<MovieBean>();
		
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			ps = con.prepareStatement(SELECT_all_movieTypes);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				MovieBean movieBean = new MovieBean();
				movieBean = new MovieBean();
				movieBean.setMovieTypeId(rs.getInt("movieTypeId"));
				movieBean.setMovieGenre1(rs.getString("movieGenre1"));
				list.add(movieBean);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	//Movie Json 分類顯示
	@Override
	public List<MovieBean> getSelectmovies(Integer movieTypeId) {
		Connection con = null;
		PreparedStatement ps = null;
		List<MovieBean> list = new LinkedList<MovieBean>();
		
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			ps = con.prepareStatement(SELECT_movies);
			ps.setInt(1, movieTypeId);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				MovieBean movieBean = new MovieBean();
				//圖片轉檔
				StringBuffer sb = new StringBuffer();
				String fileName = rs.getString("movieFileName");
				String mimeType = ctx.getMimeType(fileName);
				Blob blob = rs.getBlob("movieImg");
				byte[] bytes = blob.getBytes(1, (int) blob.length());
				String prefix = "data:" + mimeType + ";base64,";
				sb.append(prefix);
				Base64.Encoder be = Base64.getEncoder();
				String str = new String(be.encode(bytes));
				sb.append(str);
				String iamgeData = sb.toString();
				movieBean.setMovieId(rs.getInt("movieId"));
				movieBean.setMovieGenre1(rs.getString("movieGenre1"));
				movieBean.setMovieEName(rs.getString("movieEName"));
				movieBean.setMovieName(rs.getString("movieName"));
				movieBean.setMovieLength(rs.getString("movieLength"));
				movieBean.setMovieNote(rs.getString("movieNote"));
				movieBean.setMovieRated(rs.getString("movieRated"));
				movieBean.setMovieTypeId(rs.getInt("movieTypeId"));
				movieBean.setMovieImg(rs.getBlob("movieImg"));

				movieBean.setMovieFileName(iamgeData);
				list.add(movieBean);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	//Room Json 分類顯示
	@SuppressWarnings("unchecked")
	@Override
	public List<RoomBean> getPageRooms(Integer pageNo) {
		int startRecordNo = 0;
        startRecordNo = (pageNo - 1) * recordsPerPage;
        List<RoomBean> list = new ArrayList<RoomBean>();
        String hql = "FROM RoomBean";
        Session session = factory.getCurrentSession();
		list = session.createQuery(hql)
                      .setFirstResult(startRecordNo)
                      .setMaxResults(recordsPerPage)
                      .getResultList();        						
		return list;
	}
	
	//Room Json 分類顯示
	@SuppressWarnings("unchecked")
	@Override
	public List<RoomBean> getRoomType() {
		String hql="Select Distinct r.roomName From RoomBean r";
		Session session = factory.getCurrentSession();
		return session.createQuery(hql).getResultList();
	}
	
	public List<RoomBean> getSelectroomTypes(){
		Connection con = null;
		PreparedStatement ps = null;
		List<RoomBean> list = new LinkedList<RoomBean>();
		
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			ps = con.prepareStatement(SELECT_all_roomTypes);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				RoomBean roomBean = new RoomBean();
				roomBean.setRoomNameId(rs.getInt("roomNameId"));
				roomBean.setRoomName(rs.getString("roomName"));
				list.add(roomBean);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	//Room Json 分類顯示
	@Override
	public List<RoomBean> getSelectrooms(Integer roomNameId) {
		Connection con = null;
		PreparedStatement ps = null;
		List<RoomBean> list = new LinkedList<RoomBean>();
		
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			ps = con.prepareStatement(SELECT_rooms);
			ps.setInt(1, roomNameId);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				RoomBean roomBean = new RoomBean();
				roomBean = new RoomBean();
				//圖片轉檔
				StringBuffer sb = new StringBuffer();
				String fileName = rs.getString("roomFileName");
				String mimeType = ctx.getMimeType(fileName);
				Blob blob = rs.getBlob("roomImg");
				byte[] bytes = blob.getBytes(1, (int) blob.length());
				String prefix = "data:" + mimeType + ";base64,";
				sb.append(prefix);
				Base64.Encoder be = Base64.getEncoder();
				String str = new String(be.encode(bytes));
				sb.append(str);
				String iamgeData = sb.toString();				
				roomBean.setRoomNameId(rs.getInt("roomNameId"));
				roomBean.setRoomName(rs.getString("roomName"));
				roomBean.setRoomSize(rs.getString("roomSize"));
				roomBean.setRoomPrice(rs.getString("roomPrice"));
				roomBean.setRoomImg(rs.getBlob("roomImg"));
				roomBean.setRoomFileName(iamgeData);
				list.add(roomBean);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	

	
	
	@Override
	public void cartToDB(CartOrderBean cob) {
		Session session = factory.getCurrentSession();
        session.save(cob);
	}
	


	@SuppressWarnings("unchecked")
	@Override
	public Boolean checkOrderTime(int orderRoomId, String checkDay, String checkStart, String checkEnd) throws ParseException{
		Session session = factory.getCurrentSession();
		String hqlStr ="FROM CartOrderBean cob WHERE cob.roomId = :rId and cob.orderDate = :rDate";

		List<CartOrderBean> listbean = session.createQuery(hqlStr).setParameter("rId", orderRoomId).setParameter("rDate", checkDay).getResultList();
		System.out.println("********listDate = "+listbean.size());
		
//		String[] forStart
		int testDB = 0;
		if(listbean.size() == 0) {
			return true;  //代表此房型在該天無任何訂單
		}
		
		for(CartOrderBean cob : listbean) {
			
			if(compareTime(checkStart,checkEnd,cob.getOrderDateStart(),cob.getOrderDateEnd())) {
				;
			}else {
				testDB++;
			}
		}
		if(testDB == 0) {
			return true;
		}else {
			return false;
		}
			
		
	}
	public static boolean compareTime(String myStart,String myEnd,String dbStart,String dbEnd) throws ParseException {
		
		String[] mysList = myStart.split(":");
		int mys = Integer.parseInt(mysList[0])*60+Integer.parseInt(mysList[1]);
		
		String[] myeList = myEnd.split(":");
		int mye = Integer.parseInt(myeList[0])*60+Integer.parseInt(myeList[1]);
		
		String[] dbsList = dbStart.split(":");
		int dbs = Integer.parseInt(dbsList[0])*60+Integer.parseInt(dbsList[1]);
		
		String[] dbeList = dbEnd.split(":");
		int dbe = Integer.parseInt(dbeList[0])*60+Integer.parseInt(dbeList[1]);
	
		if(mye-dbs<0) {
			System.out.println("***完全在前面哦 = "+(mye-dbs));
			return true;
		}else if(mys-dbe>0) {
			System.out.println("***完全在後面哦 = "+(mys-dbe));
			return true;
		}else {
			return false;
		}
	
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public Boolean checkOrderNo(String checkNum) {
		Session session = factory.getCurrentSession();
		String hqlStr ="FROM CartOrderBean cob WHERE cob.orderNo = :Num";
		List<String> listNum = session.createQuery(hqlStr).setParameter("Num", checkNum).getResultList();
		if(listNum.size() == 0) {
			System.out.println("此編號還沒被使用");
			return true; 
		}else {
			System.out.println("編號被使用");
			return false;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Movie_Genre> getAllMovieType() {
		Session session = factory.getCurrentSession();
		String hqlStr ="FROM Movie_Genre mg";
		List<Movie_Genre> movieGenre = session.createQuery(hqlStr).getResultList();
		
		return movieGenre;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<MovieBean> getMovieByString(String movieType) {
		Session session = factory.getCurrentSession();
		String hqlStr ="FROM MovieBean mb WHERE mb.movieGenre1 like :type";
//		String hqlStr2 ="FROM MovieBean mb WHERE mb.movieGenre2 = :type2";
		List<MovieBean> listMovie = session.createQuery(hqlStr).setParameter("type", "%"+movieType+"%").getResultList();
//		List<MovieBean> listMovie2 = session.createQuery(hqlStr).setParameter("type2", movieType).getResultList();
//		for(MovieBean bean:listMovie2) {
//			listMovie.add(bean);
//		}
		String hqlStrAll ="FROM MovieBean";
		List<MovieBean> allMovie = session.createQuery(hqlStrAll).getResultList();
		System.out.println(allMovie.size());
		System.out.println(movieType);
		if(movieType.equals("全部")) {
			System.out.println(movieType);
			return allMovie;
		}else {
			return listMovie;			
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public ArrayList<Integer> getBookedList() { //至今為止全部訂單，不考慮不同月份
		Session session = factory.getCurrentSession();
		String hqlStr ="Select Distinct roomId From CartOrderBean";
		List<Integer> room = session.createQuery(hqlStr).getResultList();
//		System.out.println(room);
//		System.out.println(room.toString());
		ArrayList<Integer> roomIds = new ArrayList<Integer>();
		for(Integer beans:room) {
			roomIds.add(beans);
		}
		return roomIds;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public double getRate(int roomId) {
		Session session = factory.getCurrentSession();
		String hqlAll ="FROM CartOrderBean";
		List<CartOrderBean> allRoom = session.createQuery(hqlAll).getResultList();
		double allOrderSize = allRoom.size();
		System.out.println("共幾筆訂單 = "+allOrderSize);
		String hqlThis ="FROM CartOrderBean cob WHERE cob.roomId = :rId";
		List<CartOrderBean> room = session.createQuery(hqlThis).setParameter("rId", roomId).getResultList();
		double thisSize = room.size();
		System.out.println("此ID訂單  = "+thisSize);
		double bookRate = thisSize/allOrderSize;
		System.out.println(bookRate);
		return bookRate;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Food_Genre> getAllFoodType() {
		Session session = factory.getCurrentSession();
		String hqlStr ="FROM Food_Genre";
		List<Food_Genre> foodGenre = session.createQuery(hqlStr).getResultList();
		
		return foodGenre;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<FoodBean> getFoodByString(String foodType) {
		Session session = factory.getCurrentSession();
		String hqlStr ="FROM FoodBean fb WHERE fb.foodType like :type";

		List<FoodBean> listFood = session.createQuery(hqlStr).setParameter("type", "%"+foodType+"%").getResultList();

		String hqlStrAll ="FROM FoodBean";
		List<FoodBean> allFood = session.createQuery(hqlStrAll).getResultList();
		System.out.println(allFood.size());
		System.out.println(foodType);
		if(foodType.equals("全部")) {
			System.out.println(foodType);
			return allFood;
		}else {
			return listFood;			
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<String> getAllRoom() {
		Session session = factory.getCurrentSession();
		String hqlStr ="Select Distinct roomSize From RoomBean";
		List<String> roomGenre = session.createQuery(hqlStr).getResultList();
		
		return roomGenre;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<RoomBean> getRoomByString(String roomType) {
		Session session = factory.getCurrentSession();
		String hqlStr ="FROM RoomBean rb WHERE rb.roomSize like :type";

		List<RoomBean> listRoom = session.createQuery(hqlStr).setParameter("type", "%"+roomType+"%").getResultList();

		String hqlStrAll ="FROM RoomBean";
		List<RoomBean> allRoom = session.createQuery(hqlStrAll).getResultList();
		System.out.println(allRoom.size());
		System.out.println(roomType);
		if(roomType.equals("全部")) {
			System.out.println(roomType);
			return allRoom;
		}else {
			return listRoom;			
		}
	}

	@Override
	public void saveSurvey(SurveyBean satisfy) {
		Session session = factory.getCurrentSession();
        session.save(satisfy);
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<CartOrderBean> getOrderById(String memberId) {
		List<CartOrderBean> list = null;
        Session session = factory.getCurrentSession();
        String hql = "FROM CartOrderBean ob WHERE ob.memberId = :mid";
        list = session.createQuery(hql)
        			  .setParameter("mid", memberId)
        			  .getResultList();
        return list;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<CartOrderFood> getFoodByBean(CartOrderBean bean) {
		
//		Session session = factory.getCurrentSession();
//				
//		return  (List<CartOrderFood>) session.get(CartOrderFood.class,CartOrderId);
		List<CartOrderFood> list = null;
        Session session = factory.getCurrentSession();
        String hql = "FROM CartOrderFood f WHERE f.cartOrderBean = :mid";        
        list = session.createQuery(hql)
        			  .setParameter("mid", bean)
        			  .getResultList();
        return list;
	}

	

	@Override
	public CartOrderBean getIdByNo(String orderNo) {
		Session session = factory.getCurrentSession();
		return session.get(CartOrderBean.class,orderNo);
	}

	@SuppressWarnings("unchecked")
	@Override
	public Double getSatisfy() {
		Session session = factory.getCurrentSession();
		String hql = "FROM SurveyBean";
		List<SurveyBean> beans = session.createQuery(hql).getResultList();
		DecimalFormat df = new DecimalFormat("##.00");
		double size = beans.size();
		double totalRate = 0.0;
		for(SurveyBean tot:beans) {
			totalRate+=tot.getSatisfaction();
			System.out.println(totalRate);
		}
		
		Double finalSatisfy = Double.parseDouble(df.format(totalRate/size));
		return finalSatisfy;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<MovieBean> getMovieByFuzzy(String movieStr) {
		Session session = factory.getCurrentSession();
		String hqlStr ="FROM MovieBean mb WHERE mb.movieName like :str or mb.movieEName like :str";
		List<MovieBean> listMovie = session.createQuery(hqlStr).setParameter("str", "%"+movieStr+"%").getResultList();
		
		return listMovie;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Integer> getOrderedMidList() {
		Session session = factory.getCurrentSession();
		String hqlStr ="Select Distinct movieId From CartOrderBean";
		List<Integer> Movie = session.createQuery(hqlStr).getResultList();
		System.out.println("***************"+Movie);
//		List<Integer> orderedMovies = new LinkedList<Integer>();
//		System.out.println(orderedMovies);
//		for(CartOrderBean cob : Movie) {
//			System.out.println("94616546568"+cob.getMovieId());
//			orderedMovies.add(cob.getMovieId());
//		}
		return Movie;
	}

	@SuppressWarnings("unchecked")
	@Override
	public String getPercenstByMId(int movieId) {
		Session session = factory.getCurrentSession();
		String hqlStr ="FROM CartOrderBean cob Where cob.movieId = :Mid";
		
		String hqlStrAll = "FROM CartOrderBean";
		DecimalFormat df = new DecimalFormat("##.00");
		
		List<CartOrderBean> Movie = session.createQuery(hqlStr).setParameter("Mid", movieId).getResultList();
		Double thisNumber = (double) Movie.size();
		System.out.println("this count = "+thisNumber);
		Double allOrder = (double) session.createQuery(hqlStrAll).getResultList().size();
		System.out.println("all order = " + allOrder);
		
		String thisPercent = df.format(thisNumber/allOrder);
		
		return thisPercent;
	}

	@Override
	public String getMovieNameById(int movieId) {
		Session session = factory.getCurrentSession();
		MovieBean bean = null;
		bean = session.get(MovieBean.class, movieId);
		String movieName = bean.getMovieName();
		return movieName;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<SurveyBean> getSurveyByNo(String orderno) {
		Session session = factory.getCurrentSession();
		String hqlStr ="FROM SurveyBean sb WHERE sb.orderNo=:no";
		List<SurveyBean> list = session.createQuery(hqlStr).setParameter("no",orderno).getResultList();
		return list;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public Integer getAllMoney() {
		Session session = factory.getCurrentSession();
		String hqlStr ="FROM CartOrderBean";
		List<CartOrderBean> list = session.createQuery(hqlStr).getResultList();	
		int sum = 0;
		for(CartOrderBean cob :list) {
			sum+=cob.getTotalAmount();
		}
		return sum;		
	}

	@SuppressWarnings("unchecked")
	@Override
	public Integer getAllMemberQua() {
		Session session = factory.getCurrentSession();
		String hqlStr ="FROM MemberBean";
		List<MemberBean> list = session.createQuery(hqlStr).getResultList();	
		int size = list.size();
		
		return size;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Integer getAllRoomQua() {
		String hql="From CartOrderBean";
		Session session = factory.getCurrentSession();
		
		List <Integer> list = session.createQuery(hql).getResultList();	
		int size = list.size();
		return size;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Integer getAllRateMemberQua() {
		Session session = factory.getCurrentSession();
		String hqlStr ="FROM SurveyBean";
		List< SurveyBean> list = session.createQuery(hqlStr).getResultList();	
		int size = list.size();		
		return size;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Integer getAllStar() {
		Session session = factory.getCurrentSession();
		String hqlStr ="FROM SurveyBean";
		List<SurveyBean> list = session.createQuery(hqlStr).getResultList();	
		int sum = 0;
		for(SurveyBean sb :list) {
			sum+=sb.getSatisfaction();
		}
		return sum;	
	}
}
