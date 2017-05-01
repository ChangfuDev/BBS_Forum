package com.bbsforum.daoimpl;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.bbsforum.dao.MessageDao;
import com.bbsforum.entity.Message;
import com.bbsforum.entity.Post;

public class MessageDaoImpl implements MessageDao {
	private static Logger logger=Logger.getLogger(MessageDaoImpl.class);
	@Autowired
	SessionFactory sessionFactory;
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	Session session;
	@Override
	public List<Message> getMessageByReceiverMail(String ReceiverMail) {
		session=sessionFactory.openSession();
		String hql="from Message m where reciverMail =? order by m.publishDate desc ";//Oder byҪ���������ĺ��棡����
		Query query=session.createQuery(hql);
		query.setString(0, ReceiverMail);
		List<Message> list = query.list();
		session.close();
		return list;
	}

}
