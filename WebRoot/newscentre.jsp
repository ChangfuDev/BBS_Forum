<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="zh-CN">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">   <%-- 在IE运行最新的渲染模式 --%>
		<meta name="viewport" content="width=device-width, initial-scale=1">   <%-- 初始化移动浏览显示 --%>
		<meta name="Author" content="Dreamer-1.">
		<link rel="stylesheet" href="css/style.min.css" />
		<link rel="stylesheet" href="css/base.css" />	
		<style type="text/css">
			.greenbutton {
				color: #fff; 
				background: #5cb85c;
			}
			
			/* Blue Color */
			.redbutton {
				color: #fff;
				background: #d9534f;
			}
			.hoverbutton {
				display: inline-block;
				position: relative;
				margin-top: 3px;
				padding: 0 20px;
				text-align: center;
				text-decoration: none;
				font: bold 12px/25px Arial, sans-serif;
				text-shadow: 1px 1px 1px rgba(255,255,255, .22);
				-webkit-border-radius: 30px;
				-moz-border-radius: 30px;
				border-radius: 30px;
				-webkit-box-shadow: 1px 1px 1px rgba(0,0,0, .29), inset 1px 1px 1px rgba(255,255,255, .44);
				-moz-box-shadow: 1px 1px 1px rgba(0,0,0, .29), inset 1px 1px 1px rgba(255,255,255, .44);
				box-shadow: 1px 1px 1px rgba(0,0,0, .29), inset 1px 1px 1px rgba(255,255,255, .44);
				-webkit-transition: all 0.15s ease;
				-moz-transition: all 0.15s ease;
				-o-transition: all 0.15s ease;
				-ms-transition: all 0.15s ease;
				transition: all 0.15s ease;
			} 
  		</style>
	
		<title>消息中心</title>
	</head>
	
	<body id="message_center">
		<jsp:include page="pages/header.jsp"></jsp:include>
		<div id="message_center_box">
			<div id="message_left" style="margin-top: 52px">
		<!-- 		<div id="message_head">
				消息中心				
				</div>
				<ul id="message_pagination_lists" style="margin-top: 30px">    
			        <li class="message_pagination_list active ">
			            <a href="#reply">		               
			                <span class="message-type">●&nbsp;&nbsp;好友请求</span>		                		                
			            </a>
			        </li>		     		   
			        <li class="message_pagination_list  ">
			            <a href="#system">           
			                <span class="message-type">●&nbsp;&nbsp;系统通知</span>		                
			            </a>
			        </li>
			        <li class="message_pagination_list  ">
			            <a href="#whisper">		                
			                <span class="message-type">●&nbsp;&nbsp;我的私信</span>		                		              
			            </a>
			        </li>		     		    
			   </ul>
			    -->
			   <div id="message_head" style="margin-bottom: 40px">
					消息中心				
				</div>
				<ul class="nav nav-pills nav-stacked">				  
				  <li class="active">
				  	<a href="#friend" data-toggle="tab">好友请求</a>
				  </li>
				  <li>
				  	<a href="#news" data-toggle="tab">私信</a>
				  </li>
				  <li>
				  	<a href="#system" data-toggle="tab">系统消息</a>
				  </li>				  
				</ul>
			</div>
			
			
			<div id="message_right"  >
				<div  class="tab-content">
					<div class="tab-pane fade in active" id="friend">
						<div class="message-main" >
							<div class="message-title group-title-3">好友请求</div>
					
						</div>
						<ul class="message-main-lists"> 
						    <li class="message-main-list">
						        <img class="message-source-logo" src="//i2.hdslb.com/u_user/31ce8733288c19be92d7ce9cb83462dc.png" alt="主站" title="主站">
						        <div class="message-main-left">
						            <a target="_blank" class="medium-pic round" href="//space.bilibili.com/3454387" title="杀手简">
						                <img src="//i1.hdslb.com/bfs/face/9fdfb73e86105e216efaf9f6c42f2094bcfa2800.jpg" alt="杀手简">
						            </a>
						        </div>
						        <div class="message-main-right">
						            <a class="message-username" href="//space.bilibili.com/3454387" title="杀手简">
						                	杀手简
						            </a>
						            <span class="message-source-time">
						                2017-03-29 17:04:38
						            </span>
						            <div class="message-content-title">
						                <a target="_blank" >向您发送了好友请求</a>
						            </div>
						            <div class="message-content-wrapper">
						                <div class="message-content">
						                    		<a class="hoverbutton greenbutton" style="" ><i class="fa fa-envelope-o"></i> <font color="FFFFFF">接受</font></a>
						                    		<a class="hoverbutton redbutton"><i class="fa fa-envelope-o"></i> <font color="FFFFFF">拒绝</font></a> 
						                </div>				                
						            </div>
						        </div>
						    </li>			
						</ul>
					</div>
					
					<div class="tab-pane fade" id="news" >
						<div class="message-title group-title-3">我的私信</div>
					</div>
					<div class="tab-pane fade" id="system" >
						<div class="message-title group-title-3">系统消息</div>
					</div>
				</div>
			
			</div>
			
		</div>
		
	</body>
	</body>
</html>