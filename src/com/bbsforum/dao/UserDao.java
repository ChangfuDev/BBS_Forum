package com.bbsforum.dao;

import java.sql.Date;
import java.util.List;

import org.hibernate.Transaction;

import com.bbsforum.entity.Post;
import com.bbsforum.entity.User;

public interface UserDao {

	//ͨ�������ַ����¼ʱ���õ��˺������û�������һ��Userʵ��
	public 	User findUserByMailAddress(String mailAddress);
	/**
	 * @param offset Ҫ�鿴��һҳ�ĵ�һ����¼�±�
	 * @param PageSize ҳ���С
	 * @return ����һ��ҳ����û�
	 */
	public List getAllUserList(int offset,int pageSize);
	/**
	 * @param iΪ�û���id
	 * @return �û������м���
	 */
	public List getAllUserList1(int i);
	/**
	 * @param userһ��user��
	 * @return ����true��false
	 */
	public boolean updaUser(User user);
	/**
	 * @param i�û���id
	 * @return ����һ���û���Ϣ
	 */
	public List getUser(int i);
	/**
	 * @param user User��
	 * @function �����ݿ�����û���¼��ʵ��ע�Ṧ��
	 * @return ����һ��boolean���ͣ�true ���� false
	 * */
	public boolean addUser(User user);
	/**
	 * @param user User��
	 * @function �޸����ݿ����ݣ�ʵ���һ����룬�޸ĸ�����Ϣ�ȹ���
	 * @return ����һ��boolean���ͣ�true ���� false
	 * */
	public boolean UpdateUser(User user);

	//ͨ������¼���ڻ�ȡ����ָ������ǰ��¼���û��б�
	public List<User> showUserByDate(Date lastLoginDate);
	//ͨ����ҳ��ѯ��ʾ����¼���ڻ�ȡ����ָ������ǰ��¼���û��б�
	public List<User> getOutdateUserForPage(int offset,int pageSize,Date lastLoginDate);
	//ͨ�������ַɾ���û�
	public boolean deleteUserByMailAddress(String mailAddress);
	//ͨ���������ָ���û�
	public boolean silenceUserByMailAddress(String mailAddress);
	//ͨ������������ָ���û�
	public boolean NonsilenceUserByMailAddress(String mailAddress);
	//�����û�����¼ʱ��
	public void updateUserLastLoginDate(User user);
	public boolean checkShieldForUser(String userMail,String shieldMail);
	
	public boolean addShieldUser(String userMail,String shieldMail);
	
	public boolean deleShieldUser(String userMail,String shieldMail);
	
}