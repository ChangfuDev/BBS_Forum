package com.bbsforum.biz;

import java.util.List;

import com.bbsforum.entity.Post;

public interface PostBiz {

	/**
	 * ��ҳ��ȡ���������б�
	 * @param pageIndex  ҳ�룬��1��ʼ
	 * @param pageSize	ҳ���С����ÿһҳ����������
	 * @return �����б�
	 */
	public List<Post> getLastestPost(int pageIndex, int pageSize);
}
