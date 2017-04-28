package com.bbsforum.bizimpl;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.bbsforum.biz.UserBiz;
import com.bbsforum.dao.UserDao;
import com.bbsforum.entity.User;

public class UserBizImpl implements UserBiz {

	private static Logger logger=Logger.getLogger(UserBiz.class);
	@Autowired
	UserDao userDao;
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}


	@Override
	public User getUserByMailAddress(String mailAddress) {
		User user=userDao.findUserByMailAddress(mailAddress);
		return user;
	}

}
