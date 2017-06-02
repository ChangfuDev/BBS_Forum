package com.bbsforum.dao;

import java.util.List;

import com.bbsforum.entity.Reply;

public interface ReplyDao {
	/**
	 * @param replyһ��������
	 * @return ����true��false
	 */
	public boolean addReply(Reply reply);
	/**
	 * @param pid��Ӧ�����ӵ�id
	 * @param offset Ҫ�鿴��һҳ�ĵ�һ����¼�±�
	 * @param PageSize ҳ���С
	 * @return ���ظ������лظ���
	 */
	public List<Reply> getReplyListForPage(int offset, int PageSize,String pid);
	/**
	 * @param pid��Ӧ�����ӵ�id
	 * @return ���ظ������лظ���
	 */
	public List<Reply> getReplyListForPage1(String pid);
	/**
	 * @param postid�ظ������ӵ�id
	 * @return ����true��false
	 */
	public boolean deleteReply(String postid);
}
