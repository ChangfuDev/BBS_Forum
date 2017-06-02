package com.bbsforum.daoimpl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.apache.log4j.*;
import org.springframework.beans.factory.annotation.Autowired;

import com.bbsforum.dao.UserDao;
import com.bbsforum.entity.Post;
import com.bbsforum.entity.User;

public class UserDaoImpl implements UserDao {

	private static Logger logger=Logger.getLogger(UserDaoImpl.class);
	@Autowired
	SessionFactory sessionFactory;
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	Session session;
	@Override
	public User findUserByMailAddress(String mailAddress) {
		//logger.info("mailAddress:"+mailAddress);
		session=sessionFactory.openSession();
		User user=(User) session.get(User.class,mailAddress);
		logger.info("posts.size:"+user.getPosts().size());
		session.close();	
		return user;
	}
	@Override
	public List getAllUserList(int offset, int pageSize) {
		// TODO Auto-generated method stub
		session=sessionFactory.openSession();
		List<User> UserPage=new ArrayList<User>();
		String hql="from User";
		Query query=session.createQuery(hql);
		query.setFirstResult(offset);
		query.setMaxResults(pageSize);
		UserPage=query.list();
		session.close();
		return UserPage;
	}
	@Override
	public List getAllUserList1(int i) {
		// TODO Auto-generated method stub
		session=sessionFactory.openSession();
		List<User> UserPage=new ArrayList<User>();
		String hql="from User";
		Query query=session.createQuery(hql);
		UserPage=query.list();
		session.close();
		return UserPage;
	}
	@Override
	public boolean updaUser(User user) {
		// TODO Auto-generated method stub
		session=sessionFactory.openSession();
		Transaction tran = this.session.beginTransaction();
		try {
			session.update(user);
			tran.commit();
			//System.out.println("���³ɹ�����������������");
			session.close();
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			session.close();
			//System.out.println("����ʧ�ܣ�����������");
			return false;
		}
	}
	@Override
	public List getUser(int i) {
		// TODO Auto-generated method stub
		session=sessionFactory.openSession();
		List<User> UserPage=new ArrayList<User>();
		String hql="from User where type=1";
		Query query=session.createQuery(hql);
		UserPage=query.list();
		session.close();
		return UserPage;
	}
}
