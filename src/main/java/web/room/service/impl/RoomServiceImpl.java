package web.room.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.web.store.model.CartOrderBean;
import com.web.store.model.RoomBean;
import com.web.store.model.SurveyBean;

import web.room.dao.RoomDao;
import web.room.service.RoomService;


@Service
public class RoomServiceImpl implements RoomService{
	
	@Autowired
	RoomDao dao;
	
	@Transactional
	@Override
	public int saveRoom(RoomBean room) {
		int n = 0;
		n = dao.saveRoom(room);
		return n;
	}

	@Transactional
	@Override
	public Map<Integer, RoomBean> getRoom() {
		Map<Integer, RoomBean> map = null;
		map = dao.getRoom();
		return map;
	}

	@Transactional
	@Override
	public RoomBean getRoomImg(int Id) {
		RoomBean bean;
		bean = dao.getRoomImg(Id);
		return bean;
	}
	@Transactional
	@Override
	public int RoomDelete(Integer roomId) {
		int n = 0;
		n = dao.RoomDelete(roomId);
		return n;
	}

	@Transactional
	@Override
	public int RoomUpdata(RoomBean newRoomBean, long sizeInBytes) {
		int n = 0;
		n = dao.RoomUpdata(newRoomBean, sizeInBytes);
		return n;
	}

	@Transactional
	@Override
	public List<RoomBean> AddRoomAjax(RoomBean roomBean) {
		return dao.AddRoomAjax(roomBean);
	}

	@Transactional
	@Override
	public List<RoomBean> getUpRoom(Integer roomId) {
		return dao.getUpRoom(roomId);
	}

	@Transactional
	@Override
	public Map<String, CartOrderBean> getCartOrderBean() {
		return dao.getCartOrderBean();
	}

	@Transactional
	@Override
	public Map<Integer, SurveyBean> getSurveyBean() {
		return dao.getSurveyBean();
	}
	
	@Transactional
	@Override
	public List<RoomBean> SearchRoomAjax(String name) {
		return dao.SearchRoomAjax(name);
	}

}
