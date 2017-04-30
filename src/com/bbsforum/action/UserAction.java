package com.bbsforum.action;

import org.apache.log4j.Logger;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;

import com.bbsforum.biz.UserBiz;
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
	
	@Action(value="chaeckUserByUrl",results={
			@Result(name="others",location="/member.jsp"),
			@Result(name="self",location="/personal.jsp")
	})
	public String checkUserByUrl(){
		User user=(User) getSession().get("user");
		//���Ҫ�鿴���û����ʱ�ѵ�¼���û���ͬһ���ˣ�����ת���û��ĸ��������޸�ҳ��
		if(null==user){//��δ��¼������£�����ʾ��url��ָ�û�����ϸ��Ϣҳ
			User checked=userBiz.getUserByMailAddress(mailAddress);
			logger.info("�û�δ��¼��   ���ڲ鿴�û�����ϸ��Ϣ���� �û������ַΪ��"+mailAddress+"   �û���Ϊ��"+checked.getUsername());
			getRequest().put("user",checked);
			return "others";
		}
		else if(mailAddress.equals(user.getMailAddress())){//�����˵�½�ҵ�½�߾���Ҫ�鿴����
			getRequest().put("user", (User)getSession().get("user"));
			return "self";
		}
		else {
			User checked=userBiz.getUserByMailAddress(mailAddress);
			logger.info("�û��ѵ�¼��   ���ڲ鿴�û�����ϸ��Ϣ���� �û������ַΪ��"+mailAddress+"   �û���Ϊ��"+checked.getUsername());
			getRequest().put("user",checked);
			return "others";
		}
	}
	
	
}
