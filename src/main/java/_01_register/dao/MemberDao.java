package _01_register.dao;

import java.sql.Connection;
import java.util.Map;

import _01_register.model.MemberBean;

public interface MemberDao {
	
	public boolean idExists(String id);

	public int saveMember(MemberBean mb) ;
	
	public MemberBean queryMember(String id);
	
	public MemberBean checkIdPassword(String userId, String password);	
	
	public void setConnection(Connection con);
	
	public void updateMember(MemberBean mb, long sizeInBytes) ;
	MemberBean get(Integer pkey);

	public Map<Integer, MemberBean> getMemberList();
	public MemberBean checkMailTel(String email, String tel);

	void updatePassword(MemberBean mb);	

}