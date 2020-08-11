package web.home.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.web.store.model.HomeBean;


public interface HomeDao {

	Map<Integer, HomeBean> getHome();

	void HomeUpdata(HomeBean homeBean, long sizeInBytes);

	void HomeDelete(Integer homeId);

	void saveHome(HomeBean homeBean);

	HomeBean getHomeImg(Integer homeId);
	
	
}
