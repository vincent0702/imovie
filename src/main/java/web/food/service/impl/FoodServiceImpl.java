package web.food.service.impl;

import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.store.model.FoodBean;
import com.web.store.model.Food_Genre;

import web.food.dao.FoodDao;
import web.food.service.FoodService;

@Service
public class FoodServiceImpl implements FoodService {

	@Autowired
	FoodDao foodDao;
	
	@Transactional
	@Override
	public List<Food_Genre> getGenreFood() {
		return foodDao.getGenreFood();
	}
	
	@Transactional
	@Override
	public void saveFood(FoodBean foodBean) {
		foodDao.saveFood(foodBean);
	}

	@Transactional
	@Override
	public Map<Integer, FoodBean> getFood() {
		return foodDao.getFood();
	}

	@Transactional
	@Override
	public FoodBean getFoodImg(Integer foodId) {
		return foodDao.getFoodImg(foodId);
	}

	@Transactional
	@Override
	public void FoodDelete(Integer foodId) {
		foodDao.FoodDelete(foodId);
	}

	@Transactional
	@Override
	public void FoodUpdata(FoodBean foodBean, long sizeInBytes) {
		foodDao.FoodUpdata(foodBean,sizeInBytes);
	}

	@Transactional
	@Override
	public List<FoodBean> saveFoodAJAX(FoodBean foodBean) {
		return foodDao.saveFoodAJAX(foodBean);
	}

	@Transactional
	@Override
	public List<FoodBean> UpFoodAjax(FoodBean foodBean, long sizeInBytes) {
		return foodDao.UpFoodAjax(foodBean,sizeInBytes);
	}

}
