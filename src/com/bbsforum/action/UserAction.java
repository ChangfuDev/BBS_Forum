package com.bbsforum.action;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

import com.bbsforum.biz.UserBiz;
import com.bbsforum.entity.User;
import com.opensymphony.xwork2.ActionSupport;

public class UserAction extends BaseAction {

	private String mailAddress;
	private String password;
	private int errorFlag;
	
	
	public int getErrorFlag() {
		return errorFlag;
	}
	public void setErrorFlag(int errorFlag) {
		this.errorFlag = errorFlag;
	}
	public String getMailAddress() {
		return mailAddress;
	}
	public void setMailAddress(String mailAddress) {
		this.mailAddress = mailAddress;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
	
	
	UserBiz userBiz;
	public void setUserBiz(UserBiz userBiz) {
		this.userBiz = userBiz;
	}
	
	@Action(value="login",results={
			@Result(name="success",location="/index.jsp"),
			@Result(name="login",location="/login.jsp")
	})
	public String login(){
		
		User user=userBiz.getUserByMailAddress(mailAddress);
		if(user==null){
			errorFlag=0;
			return LOGIN;
		}else{
			if(user.getPassword().endsWith(password)){
				getSession().put("userMail", mailAddress);
				getSession().put("username", user.getUsername());
				getSession().put("usertype", user.getType());
				return SUCCESS;
			}else{
				errorFlag=2;
				return LOGIN;
			}
		}
	}
	
	@Action(value="logout",results={
			@Result(name="success",location="/index.jsp")
	})
	public String logout(){
		getSession().put("username", null);
		getSession().put("userMail", null);
		getSession().put("usertype", null);
		return SUCCESS;

	}
	
	
}
