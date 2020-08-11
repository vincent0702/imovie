package _01_register.service.impl;

import java.util.Map;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import _01_register.dao.MemberDao;
import _01_register.model.MemberBean;
import _01_register.service.MemberService;

@Service
public class MemberServiceImpl implements MemberService {
	@Autowired
	MemberDao  dao;
	
	@Autowired
	SessionFactory factory;
	
	public MemberServiceImpl() {
	}
	
	@Transactional
	@Override
	public int saveMember(MemberBean mb) {
		int n = 0;
		dao.saveMember(mb);
		n++;
		return n;
	}
	@Transactional
	@Override
	public void updateMember(MemberBean mb,long sizeInBytes) {
		dao.updateMember(mb,sizeInBytes);
	}
	@Transactional
	@Override
	public boolean idExists(String id) {
		boolean exist = false;
		exist = dao.idExists(id);
		return exist;
	}
	@Transactional
	@Override
	public MemberBean queryMember(String id) {
		MemberBean mb = null;
		mb = dao.queryMember(id);
		return mb;
	}

	@Transactional
	public MemberBean checkIdPassword(String userId, String password) {
		MemberBean mb = null;
		mb = dao.checkIdPassword(userId, password);
		return mb;
	}
	@Transactional
	@Override
	public MemberBean get(Integer pkey) {
		return dao.get(pkey);
		
	}

	@Transactional
	@Override
	public Map<Integer, MemberBean> getMemberList() {
		return dao.getMemberList();
	}
	
	@Transactional
	public MemberBean checkMailTel(String email, String tel) {
		MemberBean mb = null;
		mb = dao.checkMailTel(email, tel);
		return mb;
	}
	@Transactional
	@Override
	public void updatePassword(MemberBean mb) {
		dao.updatePassword(mb);
		
	}
}
