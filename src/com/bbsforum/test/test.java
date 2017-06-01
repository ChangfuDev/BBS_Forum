package com.bbsforum.test;


import java.util.List;
import java.util.Set;

import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.StaticApplicationContext;
import org.springframework.transaction.annotation.Transactional;

import com.bbsforum.biz.BoardBiz;
import com.bbsforum.biz.PostBiz;
import com.bbsforum.biz.SearchBiz;
import com.bbsforum.biz.UserBiz;
import com.bbsforum.bizimpl.BoardBizImpl;
import com.bbsforum.bizimpl.UserBizImpl;
import com.bbsforum.dao.BoardDao;
import com.bbsforum.dao.MessageDao;
import com.bbsforum.dao.SearchDao;
import com.bbsforum.dao.UserDao;
import com.bbsforum.daoimpl.BoardDaoImpl;
import com.bbsforum.entity.Board;
import com.bbsforum.entity.Childboard;
import com.bbsforum.entity.Message;
import com.bbsforum.entity.PageBean;
import com.bbsforum.entity.Post;
import com.bbsforum.entity.User;

public class test {

	private static Logger logger = Logger.getLogger(test.class);  
	public static void main(String[] args) throws SecurityException, IllegalStateException, RollbackException, HeuristicMixedException, HeuristicRollbackException, SystemException {
		
//		 TODO Auto-generated method stub
//		ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
//		BoardDao boardDAO=(BoardDao) context.getBean("boardDao");
//		Set<Childboard> childBoard=boardDAO.getChildBoardList(2);
//		for (Childboard temp : childBoard) {
//			System.out.println(temp.getParentBoard().getChildBoard());
//		}
	//	boardDAO.deleteChildBoard(3);
//		ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
//		MessageDao messageDao= (MessageDao) context.getBean("messageDao");
//		List<Message> list=messageDao.getMessageByReceiverMail("1111");
//		for (Message message : list) {
//			logger.info(message.getPublisherMail().getUsername());
//		}
//		ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
//		UserDao userDao=(UserDao) context.getBean("userDao");
//		User user=userDao.findUserByMailAddress("0000");
//		logger.info("0000�ĺ��Ѹ�����"+user.getFriends().size());
//		SearchBiz searchBiz=(SearchBiz) context.getBean("searchBiz");
//		PageBean temp=searchBiz.SearchUserByUsername("0", 1, 5);
//		for (Object user : temp.getList()) {
//			User tempuser=(User) user;
//			logger.info("username:"+tempuser.getUsername());
//		}
//		temp=searchBiz.SearchPostByKeyword("2", 1, 5);
//		for (Object post : temp.getList()) {
//			Post temppost=(Post) post;
//			logger.info("post title:"+temppost.getTitle()+"   content:"+temppost.getContent());
//		}
		ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
		SearchDao searchDao=(SearchDao) context.getBean("searchDao");
		List <Post> temp=searchDao.SearchPostByUsername("user", "test", 0, 5);
		for (Post post : temp) {
			logger.info(post.getTitle());
		}
		//logger.info(searchDao.SearchSumPostByChildboard("test",4));
		
		
				
				
	}

	
}
