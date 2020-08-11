package _00_init.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import _00_init.dao.BaseDao;
import _00_init.service.BaseService;

@Service
public class BaseServiceImpl implements BaseService {

	@Autowired
	BaseDao  baseDao;
	
	@Override
	public void initData() {
		baseDao.initData();

	}

}
