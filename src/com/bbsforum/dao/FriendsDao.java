package com.bbsforum.dao;

import java.util.List;

import com.bbsforum.entity.User;

public interface FriendsDao {

	public boolean addFriends(String userMail,String friendMail);
	
	public List getFriendList(String userMail,int offset,int PageSize);
	public boolean deleteFriend(String userMail,String friendMail);
	/**
	 * �жϲ鿴�������û��Ƿ��ǵ�½�ߵĺ���
	 * @param userMail ��¼�û�
	 * @param friendMail ���鿴���û�
	 * @return 
	 */
	public boolean checkFriend(String userMail,String friendMail);
}
