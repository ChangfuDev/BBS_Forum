package com.bbsforum.dao;

import java.util.List;
import java.util.Set;

import org.jboss.logging.Param;

import com.bbsforum.entity.Post;
import com.bbsforum.entity.Reply;

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
	public boolean addPost(Post post);
	
	public List<Post> getPostListForPage(int offset,int PageSize,String PublisherMail);
	
	public List<Post> getChoosePostListForPage(int offset, int PageSize,int bid);
	
	public List<Post> getChoosePostListForPage1(int bid);
	
	public Post getPost(String id);
	
	public List<Post> getAllPostListForPage(int offset,int PageSize);

	public List getAllPostList(int i);
	
	public List<Post> getViePostListForPage(int offset,int PageSize);
	
	public List getViePostList(int i);
	
	public List<Post> getJHPost(int i);
	
	public boolean updaPost(Post post);

	public List<Post> getZiPostListForPage(int offset, int PageSize,int cid);
	
	public List<Post> getZiPostListForPage1(int cid);
	
	public boolean deletePost(String id);
}
