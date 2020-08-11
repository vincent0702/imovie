package web.food.dao;

import java.util.List;
import java.util.Map;

import com.web.store.model.FoodBean;
import com.web.store.model.Food_Genre;


public interface FoodDao {

	List<Food_Genre> getGenreFood();

	void saveFood(FoodBean foodBean);

	Map<Integer, FoodBean> getFood();

	FoodBean getFoodImg(Integer foodId);

	void FoodDelete(Integer foodId);

	void FoodUpdata(FoodBean foodBean, long sizeInBytes);

	List<FoodBean> saveFoodAJAX(FoodBean foodBean);

	List<FoodBean> UpFoodAjax(FoodBean foodBean, long sizeInBytes);
	
}
