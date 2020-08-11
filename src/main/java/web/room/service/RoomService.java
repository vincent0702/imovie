package web.room.service;

import java.util.List;
import java.util.Map;

import com.web.store.model.CartOrderBean;
import com.web.store.model.RoomBean;
import com.web.store.model.SurveyBean;



public interface RoomService {
	int saveRoom(RoomBean room);
	Map<Integer, RoomBean> getRoom();
	RoomBean getRoomImg(int Id);
	int RoomDelete(Integer roomId);
	int RoomUpdata(RoomBean newRoomBean, long sizeInBytes);
	List<RoomBean> AddRoomAjax(RoomBean roomBean);
	List<RoomBean> getUpRoom(Integer roomId);
	Map<String, CartOrderBean> getCartOrderBean();
	Map<Integer, SurveyBean> getSurveyBean();
	List<RoomBean> SearchRoomAjax(String name);

}
