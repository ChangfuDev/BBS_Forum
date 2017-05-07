package com.bbsforum.dao;

import java.util.List;

import com.bbsforum.entity.Message;
import com.bbsforum.entity.User;

public interface MessageDao {

	/**
	 * ���ݽ����ߵ������ַ��ȡ���û�����������
	 * @param ReceiverMail
	 * @return �����б�
	 */
	public List<Message> getMessageByReceiverMail(String ReceiverMail);
	
	/**
	 * 
	 * @param message 
	 * @return ���Ϊtrue��ʾ���سɹ�����action��ͨ��flag֪ͨǰ̨�Ƿ��ѷ����ɹ�
	 */
	public boolean addMessage(Message message);
	
	/**
	 * ���÷�ҳ��ѯ��ȡ��Ϣ�б�
	 * @param pageIndex ��ʼҳ�� 
	 * @param pageSize һ��ҳ���м�¼����
	 * @return ��ҳ��ĵ�ҳ�����б�
	 */
	public List<Message> getMessagesForPage(int offset,int pageSize,String receiveral);
	
	
}
