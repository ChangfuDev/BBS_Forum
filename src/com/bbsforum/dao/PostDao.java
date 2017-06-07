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
	 * @param postһ��������
	 * @return ����true��false
	 */
	public boolean addPost(Post post);
	/**
	 * @param offset Ҫ�鿴��һҳ�ĵ�һ����¼�±�
	 * @param PageSize ҳ���С
	 * @param PublisherMail �����˵������ַ
	 * @return ����һ��ҳ��������б�
	 */
	public List<Post> getPostListForPage(int offset,int PageSize,String PublisherMail);
	/**
	 * @param offset Ҫ�鿴��һҳ�ĵ�һ����¼�±�
	 * @param PageSize ҳ���С
	 * @param bid���������id
	 * @return ����һ��ҳ��������б�
	 */
	public List<Post> getChoosePostListForPage(int offset, int PageSize,int bid);
	/**
	 * @param bid���������id
	 * @return �����������ӵ�����
	 */
	public List<Post> getChoosePostListForPage1(int bid);
	/**
	 * @param id���ӵ�id
	 * @return ����һ������
	 */
	public Post getPost(String id);
	/**
	 * @param offset Ҫ�鿴��һҳ�ĵ�һ����¼�±�
	 * @param PageSize ҳ���С
	 * @return ����һ��ҳ�������
	 */
	public List<Post> getAllPostListForPage(int offset,int PageSize);
	/**
	 * @param id���������id
	 * @return �����������ӵ�������
	 */
	public List getAllPostList(int i);
	/**
	 * @param offset Ҫ�鿴��һҳ�ĵ�һ����¼�±�
	 * @param PageSize ҳ���С
	 * @return ����һ��ҳ�������
	 */
	public List<Post> getViePostListForPage(int offset,int PageSize);
	/**
	 * @return �����������ӵļ���
	 */
	public List getViePostList(int i);
	/**
	 * @return �����������ӵļ���
	 */
	public List<Post> getJHPost(int i);
	/**
	 * @param postһ��������
	 * @return ����true��false
	 */
	public boolean updaPost(Post post);
	/**
	 * @param offset Ҫ�鿴��һҳ�ĵ�һ����¼�±�
	 * @param PageSize ҳ���С
	 * @return ����һ��ҳ�������
	 */
	public List<Post> getZiPostListForPage(int offset, int PageSize,int cid);
	/**
	 * @return �����������������ļ���
	 */
	public List<Post> getZiPostListForPage1(int cid);
	/**
	 * @param id��Ҫɾ�������ӵ�id
	 * @return ����true��false
	 */
	public boolean deletePost(String id);
	
	public List SearchSensitivePostForPage(int offset, int PageSize);
	public int SearchSensitiveSumPost();
	/**
	 * ��ʾ���������û��������û�������
	 * @param username
	 * @return
	 */
	public List ShowPostOnIndexExcludeShiled(String username);
	
	

}
