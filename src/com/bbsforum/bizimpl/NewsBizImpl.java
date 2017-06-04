package com.bbsforum.bizimpl;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.bbsforum.biz.NewsBiz;
import com.bbsforum.dao.NewsDao;
import com.bbsforum.dao.UserDao;
import com.bbsforum.entity.LastestSenderJSON;
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
	public boolean sendNews(String senderMail, String receiverMail,
			String content, int type) {
		logger.info(" �û���["+senderMail+"]���� ��   [ "+receiverMail+"]������Ϣ");
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

	@Override
	public List<LastestSenderJSON> getLastestSenders(String receiverMail) {
		logger.info("�û�:��"+receiverMail+"�����ڻ�ȡ�����ϵ���б�������");
		List<User> lastestSenders=newsDao.getLastestSender(receiverMail);		
		List<LastestSenderJSON> lastestSendersJson=new ArrayList<LastestSenderJSON>();
		logger.info("�Ѿ���ȡ�������ϵ������"+lastestSenders.size());
		for (User sender : lastestSenders) {
			LastestSenderJSON jsonTemp=new LastestSenderJSON();
			jsonTemp.setUser(sender);
			logger.info("��ϵ�������ַΪ��"+jsonTemp.getUser().getMailAddress());
			jsonTemp.setUnread(newsDao.getUnreadSumBySender(sender.getMailAddress(),receiverMail));
			lastestSendersJson.add(jsonTemp);
		}
		return lastestSendersJson;
	}

	@Override
	public int checkReadNews(String userMail, String friendMail) {
		
		return newsDao.chenkReadNews(userMail, friendMail);
	}

	@Override
	public News getLastestNewsBySender(String userMail) {
		
		return newsDao.getLastestNewsBySender(userMail);
	}

	@Override
	public boolean checkFriendInUserLastestSender(String friendMail,
			String userMail) {
		
		return newsDao.checkFriendInUserLastestSender(friendMail, userMail);
	}

	
}

