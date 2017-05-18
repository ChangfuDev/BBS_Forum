package com.bbsforum.dao;

import java.util.List;

public interface SearchDao {

	/**
	 * ������������ķ�ҳ��ʾ
	 * @param keyword �����ؼ���
	 * @param offset
	 * @param PageSize
	 * @return �����б�
	 */
	public List SearchPostByKeywordForPage(String keyword,int offset, int PageSize);
	/**
	 * �û���ȡ�����������
	 * @param keyword	�ؼ���
	 * @return
	 */
	public int SearchSumPostByKeyword(String keyword);
	/**
	 * 
	 * @param username  �û���
	 * @return
	 */
	public int SearchSumUserByUsername(String username);
	/**
	 * ���ڷ�ҳ��ʾͨ���û��������û����������
	 * @param username
	 * @param offset
	 * @param PageSize
	 * @return
	 */
	public List SearchUserByUsernameForPage(String username,int offset, int PageSize);
	
	public int SearchSumPostByChildboard(String keyword,int childboardId);
	
	public List SearchPostByChildboard(String keyword,int childboardId,int offset,int pageSize);
	
	public int SearchSumPostByUsername(String username,String keyword);
	
	public List SearchPostByUsername(String uername,String keyword,int offset,int pageSize);
}
