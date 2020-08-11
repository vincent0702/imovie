package web.home.service;

import java.util.Map;

import com.web.store.model.HomeBean;


public interface HomeService {

	Map<Integer, HomeBean> getHome();

	void HomeUpdata(HomeBean homeBean, long sizeInBytes);

	void saveHome(HomeBean homeBean);

	HomeBean getHomeImg(Integer homeId);

	void HomeDelete(Integer homeId);

}
