
package com.bbsforum.dao;

import java.util.List;

import org.hibernate.Transaction;

import com.bbsforum.entity.Post;
import com.bbsforum.entity.User;

public interface UserDao {

	//ͨ�������ַ����¼ʱ���õ��˺������û�������һ��Userʵ��
	public 	User findUserByMailAddress(String mailAddress);

	public List getAllUserList(int offset,int pageSize);
	
	public List getAllUserList1(int i);
	
	public boolean updaUser(User user);
	
	public List getUser(int i);
}