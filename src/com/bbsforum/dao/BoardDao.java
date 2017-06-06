package com.bbsforum.dao;

import java.util.List;
import java.util.Set;

import com.bbsforum.entity.Board;
import com.bbsforum.entity.Childboard;

/**
 * 
 * @author ����
 *@date 2017��4��6��
 */
public interface BoardDao {

	//����ҳ���ȡʱ��ȡ����б�
	//����ҳ���ȡʱ��ȡ����б�
	public List getBoardList(  );
	//��ȡ�Ӱ���б���Ҫ���븸���Id
	public Set getChildBoardListByParentBoardId(int ParentBoardId);
	//ɾ��ָ��id���Ӱ��
	public boolean deleteChildBoard(int ChildBoardId);
	
	public Childboard getChildboard(int id);

	public Board getBoard(int id);
	
	
	public void addBoard(Board board);
	public void addChildBoard(Childboard childBoard);
	public Board getBoardById(int id);
	public void updateBoard(Board board);
	public void updateChildBoard(Childboard childBoard);
	public void deleteBoard(int id);
	public Childboard getChildBoardById(int id);
}
