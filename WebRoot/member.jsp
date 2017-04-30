<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title><s:property value="#request.user.username"/>的信息</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="<%=basePath%>css/bootstrap.min.css">
	<link rel="stylesheet" type="text/css" href="<%=basePath%>css/user.css">
  </head>
  
  <body>
   <jsp:include page="/pages/header.jsp"></jsp:include>
   <div class="container user">
   	 <div class="position clearfix"><a href="#">首页</a> / 个人中心</div>
    <div class="user-cont clearfix">
        <div class="col-md-4 user-left">
            <div class="user-left-n clearfix">
                <h6>PROMULGATOR</h6>
                <a href="#" class="user-headimg f"><img src="upload/headicon/default_icon.jpg"></a>
                <div class="user-name f">
                    <h4>笨笨熊喜欢吃饼干</h4>
                    <p>hello,world</p>
                </div>
            </div>
            <div class="user-left-n clearfix">
                <ul class="list-group">
                    <li class="list-group-item">
                        <i class="fa fa-user-secret"></i>&nbsp;第 1 位会员
                    </li>
                    <a class="list-group-item" href="">
                        <span class="badge red">0</span>
                        <i class="fa fa-book"></i>&nbsp;我的文章
                    </a>
                    <a class="list-group-item" href="">
                        <span class="badge">0</span>
                        <i class="fa fa-heart"></i>&nbsp;我收藏的文章
                    </a>
                    <li class="list-group-item" href="">
                        <span class="badge">0</span>
                        <i class="fa fa-star"></i>&nbsp;关注我的人数
                    </li>
                </ul>
                <a href="#" class="btn btn-success infos"><i class="fa fa-pencil"></i>&nbsp;开始写作</a>
                <a href="#" class="btn btn-info"><i class="fa fa-cogs"></i>&nbsp;修改个人资料</a>
            </div>
            <div class="user-left-n clearfix">
                <div class="alert alert-warning">
                    <i class="fa fa-lightbulb-o"></i>&nbsp;修改个人资料功能未完善<br>
                    <i class="fa fa-lightbulb-o"></i>&nbsp;暂时不能查看关注我的用户<br>
                    <i class="fa fa-lightbulb-o"></i>&nbsp;暂时不能修改个人头像<br><br>
                    <p>请用户耐心等待技术人员的修复，一旦修复完成我们将发送邮件到您的注册邮箱</p>
                </div>
            </div>
        </div>
        <div class="col-md-8 user-right">
            <div class="user-right-n clearfix">
                <ul id="right-tab" class="nav nav-tabs">
                    <li role="presentation" class="active">
                        <a href="#myArticle" id="home-tab1" data-toggle="tab"><i class="fa fa-book"></i>&nbsp;我的文章</a>
                    </li>
                    <li role="presentation">
                        <a href="#myCollection" id="home-tab2" data-toggle="tab"><i class="fa fa-star"></i>&nbsp;我收藏的文章</a>
                    </li>
                    <li role="presentation">
                        <a href="#qd" id="home-tab3" data-toggle="tab"><i class="fa fa-edit"></i>&nbsp;签到</a>
                    </li>
                </ul>

                <div class="user-right-n clearfix tab-content">
                    <div role="tabpanel" class="tab-pane active" id="myArticle">
                        <div class="art-row">
                            <a href="" class="author"><i class="fa fa-user"></i>&nbsp;<span>笨笨熊喜欢吃饼干</span></a> <a href="" class="time"><i class="fa fa-clock-o"></i>&nbsp;<span>2016-7-17 14:24</span></a> <a href="" class="time"><i class="fa fa-list-ul"></i>&nbsp;发表在:&nbsp;<span>前端</span></a>
                            <h4><a href="" class="title">CSS3 塞贝尔曲线用法详解</a></h4>
                            <a href="" class="author"><i class="fa fa-comment"></i>&nbsp;评论:&nbsp;<span>125</span></a> <a href="" class="time"><i class="fa fa-eye"></i>&nbsp;阅读:&nbsp;<span>151</span></a> <a href="" class="time"><i class="fa fa-heart"></i>&nbsp;收藏:&nbsp;<span>151</span></a>
                        </div>

                        <div class="art-row">
                            <a href="" class="author"><i class="fa fa-user"></i>&nbsp;<span>笨笨熊喜欢吃饼干</span></a> <a href="" class="time"><i class="fa fa-clock-o"></i>&nbsp;<span>2016-7-17 14:24</span></a> <a href="" class="time"><i class="fa fa-list-ul"></i>&nbsp;发表在:&nbsp;<span>前端</span></a>
                            <h4><a href="" class="title">CSS3 塞贝尔曲线用法详解</a></h4>
                            <a href="" class="author"><i class="fa fa-comment"></i>&nbsp;评论:&nbsp;<span>125</span></a> <a href="" class="time"><i class="fa fa-eye"></i>&nbsp;阅读:&nbsp;<span>151</span></a> <a href="" class="time"><i class="fa fa-heart"></i>&nbsp;收藏:&nbsp;<span>151</span></a>
                        </div>

                        <div class="art-row">
                            <a href="" class="author"><i class="fa fa-user"></i>&nbsp;<span>笨笨熊喜欢吃饼干</span></a> <a href="" class="time"><i class="fa fa-clock-o"></i>&nbsp;<span>2016-7-17 14:24</span></a> <a href="" class="time"><i class="fa fa-list-ul"></i>&nbsp;发表在:&nbsp;<span>前端</span></a>
                            <h4><a href="" class="title">CSS3 塞贝尔曲线用法详解</a></h4>
                            <a href="" class="author"><i class="fa fa-comment"></i>&nbsp;评论:&nbsp;<span>125</span></a> <a href="" class="time"><i class="fa fa-eye"></i>&nbsp;阅读:&nbsp;<span>151</span></a> <a href="" class="time"><i class="fa fa-heart"></i>&nbsp;收藏:&nbsp;<span>151</span></a>
                        </div>

                        <div class="art-row">
                            <a href="" class="author"><i class="fa fa-user"></i>&nbsp;<span>笨笨熊喜欢吃饼干</span></a> <a href="" class="time"><i class="fa fa-clock-o"></i>&nbsp;<span>2016-7-17 14:24</span></a> <a href="" class="time"><i class="fa fa-list-ul"></i>&nbsp;发表在:&nbsp;<span>前端</span></a>
                            <h4><a href="" class="title">CSS3 塞贝尔曲线用法详解</a></h4>
                            <a href="" class="author"><i class="fa fa-comment"></i>&nbsp;评论:&nbsp;<span>125</span></a> <a href="" class="time"><i class="fa fa-eye"></i>&nbsp;阅读:&nbsp;<span>151</span></a> <a href="" class="time"><i class="fa fa-heart"></i>&nbsp;收藏:&nbsp;<span>151</span></a>
                        </div>
                    </div>

                    <div role="tabpanel" class="tab-pane" id="myCollection">
                        <div class="art-row">
                            <a href="" class="author"><i class="fa fa-user"></i>&nbsp;<span>笨笨熊喜欢吃饼干</span></a> <a href="" class="time"><i class="fa fa-clock-o"></i>&nbsp;<span>2016-7-17 14:24</span></a> <a href="" class="time"><i class="fa fa-list-ul"></i>&nbsp;发表在:&nbsp;<span>前端</span></a>
                            <h4><a href="" class="title">你好，世界！我的理想是能够在你的怀抱沉睡</a></h4>
                            <a href="" class="author"><i class="fa fa-comment"></i>&nbsp;评论:&nbsp;<span>125</span></a> <a href="" class="time"><i class="fa fa-eye"></i>&nbsp;阅读:&nbsp;<span>151</span></a> <a href="" class="time"><i class="fa fa-heart"></i>&nbsp;收藏:&nbsp;<span>151</span></a>
                        </div>
                    </div>

                    <div role="tabpanel" class="tab-pane" id="qd">
                        <div class="alert alert-info"><i class="fa fa-smile-o"></i>&nbsp;签到功能暂未上线，请大家耐心等待。一旦签到功能上线，我们将发送通知邮件到您的注册邮箱</div>
                    </div>
                </div>
            </div>
        </div>
    </div>
   	
   
   
   
   
   
   </div>
  </body>
</html>
