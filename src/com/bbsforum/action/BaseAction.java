package com.bbsforum.action;

import java.util.Map;

import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class BaseAction extends ActionSupport implements SessionAware, RequestAware {

	private static final long serialVersionUID = 1L;
	private Map<String, Object> session;
	private Map<String, Object> request;
	
	@Override//��д�Ը��ӿ�SessionAware�ķ���,���������е��ò���session����ֵ
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
	
	@Override//��д�Ը��ӿ�RequestAware�ķ���,���������е��ò���request����ֵ
	public void setRequest(Map<String, Object> request) {
		this.request = request;
	}
	
	//�����������л�ȡsession����
	public Map<String, Object> getSession(){
		return session;
	}
	
	//�����������л�ȡrequest����
	public Map<String, Object> getRequest(){
		return request;
	}
	


}
