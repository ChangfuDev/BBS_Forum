package com.bbsforum.bizimpl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.bbsforum.biz.NewsBiz;
import com.bbsforum.dao.NewsDao;
import com.bbsforum.dao.UserDao;
import com.bbsforum.entity.News;
import com.bbsforum.entity.User;

public class NewsBizImpl implements NewsBiz {

	private Logger logger=Logger.getLogger(NewsBiz.class);
	@Autowired
	NewsDao newsDao;
	public NewsDao setNewsDao() {
		return newsDao;
	}
	@Autowired
	UserDao userDao;
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	
	@Override
	public boolean sendMessage(String senderMail, String receiverMail,
			String content, int type) {
		logger.info(" �û���["+senderMail+"]���� ��   [ "+receiverMail+"]���ͺ�������");
		News news=new News();
		User sender=userDao.findUserByMailAddress(senderMail);
		User receiver=userDao.findUserByMailAddress(receiverMail);
		String id=senderMail+System.currentTimeMillis();
		news.setId(id);
		news.setSenderMail(sender);
		news.setReceiverMail(receiver);
		news.setContent(content);
		news.setType(type);
		news.setState(0);		
		return newsDao.sendNews(news);
	}

	@Override
	public boolean handleFriendRequest(String newsId, boolean operate) {
		
		return newsDao.handleFriendRequest(newsId, operate);
	}

	@Override
	public boolean checkFriRequestExist(String senderMail, String receiverMail) {
		
		return newsDao.checkFriRequestExist(senderMail, receiverMail);
	}

	@Override
	public List<News> getFriRequestListByReceiverMail(String reciverMail) {
		logger.info("�û����䣺 ["+reciverMail+"]���ڲ鿴�Լ��ĺ��������б�");
		return newsDao.getFriRequestListByReceiverMail(reciverMail);
	}

	
}
