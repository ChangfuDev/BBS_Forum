package com.bbsforum.action;

import java.util.ArrayList;
import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;

import com.bbsforum.biz.PostBiz;
import com.bbsforum.daoimpl.PostDaoImlp;
import com.bbsforum.entity.Post;
import com.opensymphony.xwork2.util.logging.Logger;
import com.opensymphony.xwork2.util.logging.LoggerFactory;
@ParentPackage("json-default")//Ҫʹ��json����Ҫ�����ڸð�
public class PostAction extends BaseAction {
	
	private List<Post> lastestPostList;
	public List<Post> getLastestPostList() {
		return lastestPostList;
	}

	public void setLastestPostList(List<Post> lastestPostList) {
		this.lastestPostList = lastestPostList;
	}

	PostBiz postBiz;
	public void setPostBiz(PostBiz postBiz) {
		this.postBiz = postBiz;
	}
	
	@Action(value="showLastestPostOnIndexPage",results={
			@Result(name="success",type="json",params={
					"includeProperties","lastestPostList.*"})
			//�������ʹ��������ʽ.*�����ȡ����json�ַ�����list��ԶΪ��
	})
	public String  showLastestPostOnIndexPage(){
		
		lastestPostList=new ArrayList<Post>();
		lastestPostList=postBiz.getLastestPost(1, 10);//��ʾǰʮ�����·���
		return SUCCESS;
	}
}
