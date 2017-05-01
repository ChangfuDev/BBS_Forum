package com.bbsforum.action;

import java.util.List;

import org.apache.log4j.Logger;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;

import com.bbsforum.biz.MessageBiz;
import com.bbsforum.biz.UserBiz;
import com.bbsforum.entity.Message;
import com.bbsforum.entity.User;
import com.opensymphony.xwork2.ActionSupport;

public class UserAction extends BaseAction {
private static Logger logger=Logger.getLogger(UserAction.class);
	private String mailAddress;
	private String password;
	private int errorFlag;//��¼ʱ���ڱ�Ǵ�����Ϣ��Ϊ0ʱ��ʾ�û������ڣ�Ϊ2ʱ��ʾ�������
	
	
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
	
	
	
	
	@Autowired
	UserBiz userBiz;
	public void setUserBiz(UserBiz userBiz) {
		this.userBiz = userBiz;
	}
	
	@Action(value="login",results={
			@Result(name="success",location="/index.jsp"),
			@Result(name="login",location="/login.jsp")
	})
	public String login(){//��½
		logger.info("login����   useraddress:"+mailAddress);
		User user=userBiz.getUserByMailAddress(mailAddress);
		if(user==null){
			errorFlag=0;
			return LOGIN;
		}else{
			if(user.getPassword().endsWith(password)){
				getSession().put("user", user);
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
		getSession().put("user", null);
		return SUCCESS;
	}
	
	@Autowired
	MessageBiz messageBiz;
	public MessageBiz getMessageBiz() {
		return messageBiz;
	}
	
	@Action(value="chaeckUserByUrl",results={
			@Result(name="others",location="/member.jsp"),
			@Result(name="self",location="/personal.jsp")
	})
	public String checkUserByUrl(){
		User user=(User) getSession().get("user");
		//���Ҫ�鿴���û����ʱ�ѵ�¼���û���ͬһ���ˣ�����ת���û��ĸ��������޸�ҳ��
		User check;
		List<Message> messageList=messageBiz.getMessageByReceiverMail(mailAddress);
		getRequest().put("messageList", messageList);
		if(null==user){//���û���û���¼����ʱ�鿴�����û�����ת��ָ���û�����Ϣҳ��			
			check=userBiz.getUserByMailAddress(mailAddress);
			logger.info("���û���½     ���鿴���û��˺ţ�"+mailAddress+"  �û���"+check.getUsername()+"ע��ʱ�䣺"+check.getRegisterDate());			
			getRequest().put("checkedUser", check);
			return "others";
		}
		else if(mailAddress.equals(user.getMailAddress())){
			logger.info("�����û���¼     ���鿴���û��ǵ�½�߱��ˣ�"+user.getUsername());
			getRequest().put("checkedUser", user);
			return "self";
		}
		else {
			check=userBiz.getUserByMailAddress(mailAddress);
			logger.info("�û��ѵ�½     ���鿴���û��˺ţ�"+mailAddress+"  �û���"+check.getUsername());
			getRequest().put("checkedUser", check);
			return "others";
		}
	}
	
	
}
