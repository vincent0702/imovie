package com.web.store.service.impl;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.web.store.dao.ProductDao;
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
import com.web.store.service.ProductServiec;

@Service
public class ProductServiecImpl implements ProductServiec {

	@Autowired
	ProductDao productDao;
	//Food
	@Transactional
	@Override
	public List<FoodBean> getAllProducts() {
		return productDao.getAllProducts();
	}

	@Transactional
	@Override
	public List<String> getAllCategories() {  
	
		return productDao.getAllCategories();
		
	}
	@Transactional
	@Override
	public List<FoodBean> getFoodByCategory(String category) {
		return productDao.getFoodByCategory(category);
	}
	@Transactional
	@Override
	public FoodBean getProductById(int productId) {
		return productDao.getProductById(productId);
	}
	//movie方法
	@Transactional
	@Override
	public List<MovieBean> getAllProducts1() {
		return productDao.getAllProducts1();
	}
	@Transactional
	@Override
	public List<String> getAllCategories1() {
		return productDao.getAllCategories1();
	}
	@Transactional
	@Override
	public List<MovieBean> getProductsByCategory1(String category) {
		return productDao.getProductsByCategory1(category);
	}
	@Transactional
	@Override
	public MovieBean getProductById1(int productId) {
		return productDao.getProductById1(productId);
	}
	//Room
	@Transactional
	@Override
	public List<RoomBean> getAllProducts2() {
		return productDao.getAllProducts2();
	}
	@Transactional
	@Override
	public List<String> getAllCategories2() {
		return productDao.getAllCategories2();
	}
	@Transactional
	@Override
	public List<RoomBean> getProductsByCategory2(String category) {
		return productDao.getProductsByCategory2(category);
	}
	@Transactional
	@Override
	public RoomBean getProductById2(int productId) {
		return productDao.getProductById2(productId);
	}

	@Transactional
	@Override
	public List<FoodBeanWithImageData> getAllFoodsWithImageData() {
		return productDao.getAllFoodsWithImageData();
	}
	@Transactional
	@Override
	public List<MovieBeanWithImageData> getAllMoviesWithImageData() {
		return productDao.getAllMoviesWithImageData();
	}
	@Transactional
	@Override
	public List<RoomBeanWithImageData> getAllRoomsWithImageData() {
		return productDao.getAllRoomsWithImageData();
	}
	@Transactional
	@Override
	public List<FoodBean> getFoodType() {
		
		return productDao.getFoodType();
	}
	@Transactional
	@Override
	public List<FoodBean> getSelectfoodTypes() {
		
		return productDao.getSelectfoodTypes();
	}
	@Transactional
	@Override
	public List<FoodBean> getSelectfoods(Integer foodTypeId) {
		return productDao.getSelectfoods(foodTypeId);
	}
	@Transactional
	@Override
	public List<MovieBean> getSelectmovies(Integer movieTypeId) {
		return productDao.getSelectmovies(movieTypeId);
	}
	@Transactional
	@Override
	public List<MovieBean> getSelectmovieTypes() {
		
		return productDao.getSelectmovieTypes();
	}
	@Transactional
	@Override
	public List<RoomBean> getSelectrooms(Integer roomNameId) {
		
		return productDao.getSelectrooms(roomNameId);
	}
	@Transactional
	@Override
	public List<RoomBean> getSelectroomTypes() {
		
		return productDao.getSelectroomTypes();
	}

	@Transactional
	@Override
	public void cartToDB(CartOrderBean cob) {
		productDao.cartToDB(cob);	
	}
	
	@Transactional
	@Override
	public boolean checkOrderTime(int orderRoomId, String checkDay, String checkStart, String checkEnd)
			throws ParseException {
		
		return productDao.checkOrderTime(orderRoomId,checkDay,checkStart,checkEnd);
	}
	@Transactional
	@Override
	public List<HomeBeanWithImageData> getAllHomesWithImageData() {
		return productDao.getAllHomesWithImageData();
	}
	
	@Transactional
	@Override
	public Boolean checkOrderNo(String checkNum) {
		return productDao.checkOrderNo(checkNum);
	}
	
	
	@Transactional
	@Override
	public List<Movie_Genre> getAllMovieType() {
		return productDao.getAllMovieType();
	}
	
	@Transactional
	@Override
	public List<MovieBean> getMovieByString(String movieType) {
		return productDao.getMovieByString(movieType);
	}

	@Transactional
	@Override
	public ArrayList<Integer> getBookedList() {
		return productDao.getBookedList();
	}

	@Transactional
	@Override
	public double getRate(int roomId) {
		return productDao.getRate(roomId);
	}
	
	@Transactional
	@Override
	public List<Food_Genre> getAllFoodType() {
		return productDao.getAllFoodType();
	}
	
	@Transactional
	@Override
	public List<FoodBean> getFoodByString(String foodType) {
		return productDao.getFoodByString(foodType);
	}
	
	@Transactional
	@Override
	public List<String> getAllRoom() {
		return productDao.getAllRoom();
	}
	
	@Transactional
	@Override
	public List<RoomBean> getRoomByString(String roomType) {
		return productDao.getRoomByString(roomType);
	}
	
	@Transactional
	@Override
	public List<CartOrderBean> getOrderById(String memberId) {
		List<CartOrderBean> list = null;

		list = productDao.getOrderById(memberId);

		return list;
	}
	
	@Transactional
	@Override
	public List<CartOrderFood>  getFoodByBean(CartOrderBean bean) {
		List<CartOrderFood> list = null;
		list = productDao.getFoodByBean(bean);
		return list;
	}
	
	
	
	@Transactional
	@Override
	public CartOrderBean getIdByNo(String orderNo) {
		return productDao.getIdByNo(orderNo);
	}
	
	@Transactional
	@Override
	public void saveSurvey(SurveyBean satisfy) {
		productDao.saveSurvey(satisfy);
	}
	
	@Transactional
	@Override
	public Double getSatisfy() {
		return productDao.getSatisfy();
	}
	
	@Transactional
	@Override
	public List<MovieBean> getMovieByFuzzy(String movieStr) {
		return productDao.getMovieByFuzzy(movieStr);
	}
	
	@Transactional
	@Override
	public List<Integer> getOrderedMidList() {
		return productDao.getOrderedMidList();
	}
	
	@Transactional
	@Override
	public String getPercenstByMId(int movieId) {
		return productDao.getPercenstByMId(movieId);
	}
	
	@Transactional
	@Override
	public String getMovieNameById(int movieId) {
		return productDao.getMovieNameById(movieId);
	}
	
	@Transactional
	@Override
	public List<SurveyBean> getSurveyByNo(String orderno) {
		return productDao.getSurveyByNo(orderno);
	}
	
	@Transactional
	@Override
	public Integer getAllMoney() {
		return productDao.getAllMoney();
	}
	
	@Transactional
	@Override
	public Integer getAllMemberQua() {
		return productDao.getAllMemberQua();
	}
	
	@Transactional
	@Override
	public Integer getAllRoomQua() {
		return productDao.getAllRoomQua();
	}
	
	@Transactional
	@Override
	public Integer getAllRateMemberQua() {
		return productDao.getAllRateMemberQua();
	}
	
	@Transactional
	@Override
	public Integer getAllStar() {
		return productDao.getAllStar();
	}

}
