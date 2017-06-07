<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
        <%@taglib uri="/struts-tags" prefix="s" %>
    <%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<style type="text/css">
table.hovertable {
    font-family: verdana,arial,sans-serif;
    font-size:11px;
    color:#333333;
    border-width: 1px;
    border-color: #999999;
    border-collapse: collapse;
}
table.hovertable th {
    background-color:#c3dde0;
    border-width: 1px;
    padding: 8px;
    border-style: solid;
    border-color: #a9c6c9;
}
table.hovertable tr {
    background-color:#d4e3e5;
}
table.hovertable td {
    border-width: 1px;
    padding: 8px;
    border-style: solid;
    border-color: #a9c6c9;
}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
   <script type="text/javascript" src="<%=basePath%>js/member.js" charset="gb2312"></script>
    <script type="text/javascript" src="<%=basePath%>js/jquery.min.js"></script>
<body>
    <jsp:include page="pages/header2.jsp"></jsp:include>
    <div class="position clearfix"><a href="<%=basePath%>/manage.jsp">首页</a> / <a href="updateBoard.jsp">修改版块信息版块</a> /<a href="updatechildBoard.jsp">修改子版块信息</a></div>
  <form action="updateBoard.action" method="post">
   <center>
    <table  class="hovertable" width="60%">
    <tr onmouseover="this.style.backgroundColor='#ffff66';" onmouseout="this.style.backgroundColor='#d4e3e5';">
      <td width="30%">原版块名</td>
      <td width="30%">
         <s:iterator value="#session.BoardList1" var="board">
      <!--<s:radio name="board.id" value="0" list="#{'1':'移动开发','2':'WEB开发','3':'游戏开发' }"/> -->
      <input type="radio" name="board.id" value=${board.id} /> ${board.name}
      </s:iterator>
      </td>
    </tr>
     <tr onmouseover="this.style.backgroundColor='#ffff66';" onmouseout="this.style.backgroundColor='#d4e3e5';">
      <td>现版块名</td>
      <td><input type="text" name="board.name" /></td>
    </tr>
     <tr onmouseover="this.style.backgroundColor='#ffff66';" onmouseout="this.style.backgroundColor='#d4e3e5';">
      <td>说明</td>
      <td><input type="text" name="board.info" /></td>
    </tr>

    <tr onmouseover="this.style.backgroundColor='#ffff66';" onmouseout="this.style.backgroundColor='#d4e3e5';">
       <td><input type="submit" value="提交"/> </td>   
       <td><input type="reset" value="重置"/></td>
    </tr>
    </table>
</center>
    </form>
</body>
</html>