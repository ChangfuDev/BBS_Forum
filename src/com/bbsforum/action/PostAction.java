package com.bbsforum.action;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.json.annotations.JSON;
import org.springframework.beans.factory.annotation.Autowired;

import com.bbsforum.biz.PageViewBiz;
import com.bbsforum.biz.PostBiz;
import com.bbsforum.biz.UserBiz;
import com.bbsforum.dao.UserDao;
import com.bbsforum.daoimpl.PostDaoImlp;
import com.bbsforum.entity.PageBean;
import com.bbsforum.entity.Post;
import com.bbsforum.entity.User;

@ParentPackage("json-default")//Ҫʹ��json����Ҫ�����ڸð�
public class PostAction extends BaseAction {
	Logger logger=Logger.getLogger(PostAction.class);
	private List<Post> lastestPostList;
	public List<Post> getLastestPostList() {
		return lastestPostList;
	}
	public void setLastestPostList(List<Post> lastestPostList) {
		this.lastestPostList = lastestPostList;
	}
	
	private PageBean pageBean;
		
	public PageBean getPageBean() {
		return pageBean;
	}
	public void setPageBean(PageBean pageBean) {
		this.pageBean = pageBean;
	}
	private String publisherMail;
	
	@JSON(serialize=false)
	public String getPublisherMail() {
		return publisherMail;
	}
	public void setPublisherMail(String publisherMail) {
		this.publisherMail = publisherMail;
	}

	private int page;
	@JSON(serialize=false)
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}

	@Autowired
	PostBiz postBiz;
	public void setPostBiz(PostBiz postBiz) {
		this.postBiz = postBiz;
	}
	@Autowired
	UserBiz userBiz;
	public void setUserBiz(UserBiz userBiz) {
		this.userBiz = userBiz;
	}
	
	@Action(value="showLastestPostOnIndexPage",results={
			@Result(name="success",type="json",params={
					"excludeProperties","lastestPostList\\[\\d+\\]\\.childboardId.parentBoard,"
							+ "lastestPostList\\[\\d+\\]\\.childboardId.posts,"
							+ "lastestPostList\\[\\d+\\]\\.publisherMail.posts,"
							+ "lastestPostList\\[\\d+\\]\\.publisherMail.friends"})
			//�������ʹ��������ʽ������˵���������˵���ĵ�
	})
	public String  showLastestPostOnIndexPage(){
		lastestPostList=new ArrayList<Post>();
		lastestPostList=postBiz.getLastestPost(1, 10);//��ʾǰʮ�����·���
		return SUCCESS;
	}
	
	@Autowired
	private PageViewBiz pageViewBiz;
	public PageViewBiz getPageViewBiz() {
		return pageViewBiz;
	}
	
	@Action(value="showPostByPage",results={
			@Result(name="success",type="json",params={
					"excludeProperties", "pageBean.list\\[\\d+\\]\\.publisherMail.posts,"
							+ "pageBean.list\\[\\d+\\]\\.childboardId.posts,"
							+ "pageBean.list\\[\\d+\\]\\.publisherMail.friends,"
							+"pageBean.list\\[\\d+\\]\\.childboardId.parentBoard"})
	}) 
	public String showPostByPage(){
		User publisher=userBiz.getUserByMailAddress(publisherMail);
		pageBean=pageViewBiz.showPostBypage(page, 5, publisherMail, publisher.getPosts().size());
		logger.info("�ɹ���ȡ������ҳ�桭�� ҳ���е���������Ϊ��"+pageBean.getList().size());
		return SUCCESS;
	}
}
