package web.food.dao.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.web.store.model.FoodBean;
import com.web.store.model.Food_Genre;

import web.food.dao.FoodDao;

@Repository
public class FoodDaoImpl implements FoodDao {

	@Autowired
	SessionFactory factory;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Food_Genre> getGenreFood() {
		String hql="FROM Food_Genre";
		Session session=factory.getCurrentSession();
		List<Food_Genre> list= session.createQuery(hql).getResultList();
		return list;
	}

	@Override
	public void saveFood(FoodBean foodBean) {
		Session session = factory.getCurrentSession();
		session.save(foodBean);
	}

	@SuppressWarnings("unchecked")
	@Override
	public Map<Integer, FoodBean> getFood() {
		String hql = "FROM FoodBean ORDER BY foodDate DESC";
		Map<Integer, FoodBean> map = new LinkedHashMap<>();
		Session session = factory.getCurrentSession();
		List<FoodBean> list = session.createQuery(hql).getResultList();
		SimpleDateFormat sdFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = null;
		for (FoodBean foodBean : list) {
			if (foodBean.getFoodDate() != null) {
				date = foodBean.getFoodDate();
				String foodDateString = sdFormat.format(date);
				foodBean.setFoodDateString(foodDateString);
			}
			map.put(foodBean.getFoodId(), foodBean);
		}
		return map;
	}

	@Override
	public FoodBean getFoodImg(Integer foodId) {
		Session session = factory.getCurrentSession();
		return session.get(FoodBean.class, foodId);
	}

	@Override
	public void FoodDelete(Integer foodId) {
		String hql = "DELETE FoodBean WHERE foodId = :foodId";
		Session session = factory.getCurrentSession();
		session.createQuery(hql).setParameter("foodId", foodId).executeUpdate();
		
	}

	@Override
	public void FoodUpdata(FoodBean foodBean, long sizeInBytes) {
		if (sizeInBytes == -1) { // 不修改圖片
			FoodBean food = null;
	        Session session = factory.getCurrentSession();
	        food = session.get(FoodBean.class, foodBean.getFoodId());
	        foodBean.setFoodImg(food.getFoodImg());
	        foodBean.setFoodFileName(food.getFoodFileName());
	        session.evict(food);
	        session.saveOrUpdate(foodBean);
        }else {
			 Session session = factory.getCurrentSession();
			 session.saveOrUpdate(foodBean);
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<FoodBean> saveFoodAJAX(FoodBean foodBean) {
		Session session = factory.getCurrentSession();
		session.save(foodBean);
		String hql = "From FoodBean Where foodDate IN (Select MAX(foodDate) From FoodBean)";
		List<FoodBean> list = session.createQuery(hql).getResultList();
		SimpleDateFormat sdFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = null;
		for (FoodBean foodlist : list) {
			if (foodlist.getFoodDate() != null) {
				date = foodlist.getFoodDate();
				String foodDate = sdFormat.format(date);
				foodBean.setFoodDateString(foodDate);
			}
		}
		return list;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<FoodBean> UpFoodAjax(FoodBean foodBean, long sizeInBytes) {
		if (sizeInBytes == -1) { // 不修改圖片
			FoodBean food = null;
	        Session session = factory.getCurrentSession();
	        food = session.get(FoodBean.class, foodBean.getFoodId());
	        foodBean.setFoodImg(food.getFoodImg());
	        foodBean.setFoodFileName(food.getFoodFileName());
	        session.evict(food);
	        session.saveOrUpdate(foodBean);
        }else {
			 Session session = factory.getCurrentSession();
			 session.saveOrUpdate(foodBean);
		}
		String hql = "From FoodBean WHERE foodId = :foodId";
		Session session = factory.getCurrentSession();
		List<FoodBean> list = session.createQuery(hql).setParameter("foodId", foodBean.getFoodId()).getResultList();
		SimpleDateFormat sdFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = null;
		for (FoodBean foodlist : list) {
			if (foodlist.getFoodDate() != null) {
				date = foodlist.getFoodDate();
				String foodDate = sdFormat.format(date);
				foodBean.setFoodDateString(foodDate);
			}
		}
		return list;
	}

}
