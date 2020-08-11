package web.home.service.impl;

import java.util.ArrayList;
import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.store.model.HomeBean;

import web.home.dao.HomeDao;
import web.home.service.HomeService;

@Service
public class HomeServiceImpl implements HomeService {

	@Autowired
	HomeDao homeDao;
	

	@Transactional
	@Override
	public Map<Integer, HomeBean> getHome() {
		return homeDao.getHome();
	}
	@Transactional
	@Override
	public void HomeUpdata(HomeBean homeBean, long sizeInBytes) {
		homeDao.HomeUpdata(homeBean,sizeInBytes);
		
	}
	@Transactional
	@Override
	public void saveHome(HomeBean homeBean) {
		homeDao.saveHome(homeBean);
		
	}
	@Transactional
	@Override
	public HomeBean getHomeImg(Integer homeId) {
		
		return homeDao.getHomeImg(homeId);
	}
	@Transactional
	@Override
	public void HomeDelete(Integer homeId) {
		homeDao.HomeDelete(homeId);
		
	}


}
