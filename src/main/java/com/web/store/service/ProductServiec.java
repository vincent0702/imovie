package com.web.store.service;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.web.store.model.CartOrderBean;
import com.web.store.model.CartOrderFood;
import com.web.store.model.FoodBean;
import com.web.store.model.FoodBeanWithImageData;
import com.web.store.model.Food_Genre;
import com.web.store.model.HomeBeanWithImageData;
import com.web.store.model.MovieBean;
import com.web.store.model.MovieBeanWithImageData;
import com.web.store.model.Movie_Genre;
import com.web.store.model.RoomBean;
import com.web.store.model.RoomBeanWithImageData;
import com.web.store.model.SurveyBean;

public interface ProductServiec {
	
	//List<Map<String, String>> getAllCategories();
	List<String> getAllCategories(); 
	List<FoodBean> getAllProducts();	
	List<FoodBean> getFoodType() ;
	List<FoodBean> getFoodByCategory(String category);
	public FoodBean getProductById(int productId);
	

	List<String> getAllCategories1();
	List<MovieBean> getAllProducts1();
	List<MovieBean> getProductsByCategory1(String category);
	public MovieBean getProductById1(int productId);
		List<RoomBean> getAllProducts2();
	List<String> getAllCategories2();
	List<RoomBean> getProductsByCategory2(String category);
	public RoomBean getProductById2(int productId);

	List<FoodBeanWithImageData> getAllFoodsWithImageData();
	List<MovieBeanWithImageData> getAllMoviesWithImageData();
	List<RoomBeanWithImageData> getAllRoomsWithImageData();

	List<FoodBean> getSelectfoods(Integer foodTypeId);
	List<FoodBean> getSelectfoodTypes();

	List<MovieBean> getSelectmovies(Integer movieTypeId);
	List<MovieBean> getSelectmovieTypes();
	
	List<RoomBean> getSelectrooms(Integer roomNameId);
	List<RoomBean> getSelectroomTypes();
	
	List<HomeBeanWithImageData> getAllHomesWithImageData();
	//新增的---------------
	void cartToDB(CartOrderBean cob);
	public boolean checkOrderTime(int orderRoomId,String checkDay,String checkStart,String checkEnd)throws ParseException;
	//---------------------
Boolean checkOrderNo(String checkNum);
	
	List<Movie_Genre> getAllMovieType();
	List<MovieBean> getMovieByString(String movieType);
	
	ArrayList<Integer> getBookedList();
	double getRate(int roomId);
	
	List<Food_Genre> getAllFoodType ();
	List<FoodBean> getFoodByString(String foodType);
	
	List<String> getAllRoom ();
	List<RoomBean> getRoomByString(String roomType);
	
	List<CartOrderBean> getOrderById(String memberId);
	CartOrderBean getIdByNo(String orderNo);
	List<CartOrderFood> getFoodByBean(CartOrderBean bean);
	
	void saveSurvey(SurveyBean satisfy);
	
	Double getSatisfy();
	List<MovieBean> getMovieByFuzzy(String movieStr);

	List<Integer> getOrderedMidList();
	String getPercenstByMId(int movieId);
	String getMovieNameById(int movieId);
	List<SurveyBean> getSurveyByNo(String orderno);
	Integer getAllMoney();
	Integer getAllMemberQua();
	Integer getAllRoomQua();
	Integer getAllRateMemberQua();
	Integer getAllStar();
}