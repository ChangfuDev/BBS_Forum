package com.bbsforum.dao;

import java.util.List;

import com.bbsforum.entity.Message;

public interface MessageDao {

	/**
	 * ���ݽ����ߵ������ַ��ȡ���û�����������
	 * @param ReceiverMail
	 * @return �����б�
	 */
	public List<Message> getMessageByReceiverMail(String ReceiverMail);
}
