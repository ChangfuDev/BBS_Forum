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
	 * @param publisher ���Է����ߣ�Ҳ����Ŀǰsession����ĵ�½��
	 * @param receiver	���Խ�����
	 * @param Content	��������
	 * @return ���Ϊtrue��ʾ���سɹ�����action��ͨ��flag֪ͨǰ̨�Ƿ��ѷ����ɹ�
	 */
	public boolean addMessage(User publisher,User receiver,String Content);
}
