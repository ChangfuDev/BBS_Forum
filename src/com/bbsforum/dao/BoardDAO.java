package com.bbsforum.dao;

import java.util.List;
import java.util.Set;

public interface BoardDAO {

	//����ҳ���ȡʱ��ȡ����б�
	public List getBoardList();
	//��ȡ�Ӱ���б���Ҫ���븸���Id
	public Set getChildBoardList(int ParentBoardId);
	//ɾ��ָ��id���Ӱ��
	public boolean deleteChildBoard(int ChildBoardId);
}
