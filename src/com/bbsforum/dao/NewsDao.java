<<<<<<< HEAD
package com.bbsforum.dao;

import java.util.List;

import com.bbsforum.entity.News;
import com.bbsforum.entity.User;

public interface NewsDao {

	/**
	 * ������Ϣ
	 * @param news  ��Ϣʵ������
	 * @return ����ture��ʾ���ͳɹ�������false��ʾ����ʧ��
	 */
	public boolean sendNews(News news);
	/**
	 * �������������Ϣ
	 * @param senderMail �����������ַ
	 * @param receiverMail �����������ַ
	 * @param operate  true��ʾ�������룬false��ʾ�ܾ�������
	 * @return
	 */
	public boolean handleFriendRequest(String newsId,boolean operate);
	/**
	 * �жϸ÷������Ƿ��Ѿ����͹�����������ý�����
	 * @param senderMail ����������
	 * @param receiverMail ����������
	 * @return true������û��Ѿ������û����͹����������ˣ�false��ʾû�з��͹�
	 */
	public boolean checkFriRequestExist(String senderMail,String receiverMail);
	
	/**
	 * ͨ������������ĵ�ַ��ȡ���û��������ܵ������к�������
	 * @param reciverMail  ����������
	 * @return   ��Ϣ���ϣ�����ֻ������������
	 */
	public List<News> getFriRequestListByReceiverMail(String reciverMail);
	/**
	 * �û���ȡ˽��ҳ������ߵ������ϵ���б�
	 * @param userMail ��½�ߵ������ַ
	 * @return �����û��б�
	 */
	public List<User> getLastestSender(String userMail);
	/**
	 * ��ȡ���ĳ�������ߵ�δ����Ϣ������
	 * @param senderMail  �����������ַ
	 * @param receiverMail  �����������ַ
	 * @return δ������
	 */
	public int getUnreadSumBySender(String senderMail,String receiverMail);
	
}
=======
package com.bbsforum.dao;

import java.util.List;

import com.bbsforum.entity.News;
import com.bbsforum.entity.User;

public interface NewsDao {

	/**
	 * ������Ϣ
	 * @param news  ��Ϣʵ������
	 * @return ����ture��ʾ���ͳɹ�������false��ʾ����ʧ��
	 */
	public boolean sendNews(News news);
	/**
	 * �������������Ϣ
	 * @param senderMail �����������ַ
	 * @param receiverMail �����������ַ
	 * @param operate  true��ʾ�������룬false��ʾ�ܾ�������
	 * @return
	 */
	public boolean handleFriendRequest(String newsId,boolean operate);
	/**
	 * �жϸ÷������Ƿ��Ѿ����͹�����������ý�����
	 * @param senderMail ����������
	 * @param receiverMail ����������
	 * @return true������û��Ѿ������û����͹����������ˣ�false��ʾû�з��͹�
	 */
	public boolean checkFriRequestExist(String senderMail,String receiverMail);
	
	/**
	 * ͨ������������ĵ�ַ��ȡ���û��������ܵ������к�������
	 * @param reciverMail  ����������
	 * @return   ��Ϣ���ϣ�����ֻ������������
	 */
	public List<News> getFriRequestListByReceiverMail(String reciverMail);
	/**
	 * �û���ȡ˽��ҳ������ߵ������ϵ���б�
	 * @param userMail ��½�ߵ������ַ
	 * @return �����û��б�
	 */
	public List<User> getLastestSender(String userMail);
	/**
	 * ��ȡ���ĳ�������ߵ�δ����Ϣ������
	 * @param senderMail  �����������ַ
	 * @param receiverMail  �����������ַ
	 * @return δ������
	 */
	public int getUnreadSumBySender(String senderMail,String receiverMail);
	/**
	 * ͨ�������������뷢���������ȡ�������֮��������¼
	 * @param receiverMail �����������ַ
	 * @param pageIndex  ҳ��
	 * @param pageSize ҳ���С
	 * @return ��Ϣ�б�
	 */
	public List<News> getLastestNewsForReceiver(String senderMail,String receiverMail, int offset,int pageSize);
	/**
	 * ��ȡ�������������֮��������¼����
	 * @param senderMail
	 * @param receiverMail
	 * @return
	 */
	public int getSumNewsForReceiver(String senderMail ,String  receiverMail);
}
>>>>>>> Headbangeerr/master
