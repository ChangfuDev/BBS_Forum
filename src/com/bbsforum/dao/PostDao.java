package com.bbsforum.dao;

import java.util.List;
import java.util.Set;

import org.jboss.logging.Param;

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
}
