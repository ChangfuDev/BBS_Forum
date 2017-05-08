package com.bbsforum.dao;

import java.util.List;
import java.util.Set;

import org.jboss.logging.Param;

import com.bbsforum.entity.Post;

/**
 * ���ӵ����ݿ���ʽӿ�
 * @author ����
 * @version 1.0
 */
public interface PostDao {
	
	/**
	 * ��ҳ��ȡ���������б�
	 * @param pageIndex  ҳ�룬��1��ʼ
	 * @param pageSize	ҳ���С����һҳ���м�������
	 * @return ���������б�
	 */
	public List getLastestPostList(int pageIndex,int pageSize );
	/**
	 * @param offset Ҫ�鿴��һҳ�ĵ�һ����¼�±�
	 * @param PageSize ҳ���С
	 * @param PublisherMail �����˵������ַ
	 * @return ����һ��ҳ��������б�
	 */
	public List<Post> getPostListForPage(int offset,int PageSize,String PublisherMail);
	
	
}
