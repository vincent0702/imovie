package web.home.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.web.store.model.HomeBean;

import web.home.dao.HomeDao;


@Repository
public class HomeDaoImpl implements HomeDao {

	@Autowired
	SessionFactory factory;
	
	@Override
	public void saveHome(HomeBean homeBean) {
		Session session = factory.getCurrentSession();
		session.save(homeBean);
	}

	@SuppressWarnings("unchecked")
	@Override
	public Map<Integer, HomeBean> getHome() {
		String hql = "FROM HomeBean";
		Map<Integer, HomeBean> map = new HashMap<>();
		Session session = factory.getCurrentSession();
		List<HomeBean> list = session.createQuery(hql).getResultList();
		for (HomeBean homeBean : list) {
			map.put(homeBean.getHomeId(), homeBean);
		}
		return map;
	}

	
	@Override
	public HomeBean getHomeImg(Integer homeId) {
		Session session = factory.getCurrentSession();
		return session.get(HomeBean.class, homeId);
	}

	@Override
	public void HomeDelete(Integer homeId) {
		String hql = "DELETE HomeBean WHERE homeId = :homeId";
		Session session = factory.getCurrentSession();
		session.createQuery(hql).setParameter("homeId", homeId).executeUpdate();
		
	}

	@Override
	public void HomeUpdata(HomeBean homeBean, long sizeInBytes) {
		if (sizeInBytes == -1) { // 不修改圖片
			HomeBean home = null;
	        Session session = factory.getCurrentSession();
	        home = session.get(HomeBean.class, homeBean.getHomeId());
	        homeBean.setHomeImg(home.getHomeImg());
	        homeBean.setHomeFileName(home.getHomeFileName());
	        session.evict(home);
	        session.saveOrUpdate(homeBean);
        }else {
			 Session session = factory.getCurrentSession();
			 session.saveOrUpdate(homeBean);
		}
	}

}
