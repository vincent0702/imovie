package _01_register.service;

import java.util.Map;

import _01_register.model.MemberBean;

public interface MemberService {
	boolean idExists(String id);
	int saveMember(MemberBean mb);
	MemberBean queryMember(String id);
	MemberBean checkIdPassword(String userId, String password) ;
	public void updateMember(MemberBean mb, long sizeInBytes) ;
	MemberBean get(Integer pkey);
	Map<Integer, MemberBean> getMemberList();
	public MemberBean checkMailTel(String email, String tel);	
	void updatePassword(MemberBean mb);	

}
