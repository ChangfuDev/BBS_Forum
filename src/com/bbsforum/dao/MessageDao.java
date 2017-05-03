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
}
