package com.bbsforum.dao;

import com.bbsforum.entity.User;

public interface UserDAO {

	//ͨ�������ַ����¼ʱ���õ��˺������û�������һ��Userʵ��
	public 	User findUserByMailAddress(String mailAddress);


}
