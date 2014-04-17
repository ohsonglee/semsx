<%@page import="vo.CourseVo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <% 
    List<CourseVo> list = 
          (List<CourseVo>)request.getAttribute("list"); 
    %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <title>강의목록(byJSP)</title>
  <LINK href="courseCss.css" rel="stylesheet" type="text/css">
</head>
<body>
<div id="rainb"></div>
<div id="topmenu"><div id="menu">
<ul>
  <li class="me"><a href="/semsx/subject/list.bit?pageNo=1&pageSize=10" style="text-decoration:none">Subject</a></li>
  <li class="me"><a href="/semsx/course/list.bit?pageNo=1&pageSize=10"style="text-decoration:none">Course</a></li>
  <li class="me"><a href="/semsx/user/list.bit?pageNo=1&pageSize=10" style="text-decoration:none">Users</a></li>
</ul>
</div></div>
<div id="toptext"><p id="p"></p></div>
<div id="center">
<div id="box">
<div id="main"><div>

<table id="tata">
<tr>
  <th>번호</th>
  <th>수업명</th>
</tr>

<%for(CourseVo course : list){%>
<tr>
  <td><%= course.getNo() %></td>
  <td><a href ='detail.bit?no=<%=course.getNo()%>'><%=course.getTitle()%></td>
</tr>
<%}%>
</table>
<!--
<form class="form" action="insert.bit" method="post">
<div class="row"><input type="text" class="simple" name="title" placeholder="강의명"></div>
<div class="row"><textarea cols="10" rows="7" class="simple" name="description" placeholder="강의설명을 적어주세요."></textarea></div>
<div class="row"><input type="text" class="simple" name="hours" placeholder="강의시간"></div>

<div id="row3"><input type="submit" id="btnAdd" value="sign up"></div>
<div id="row4"><input type="reset" id="btnCancel" value="Cancel"></div>
</form>
-->
</div></div>
<div id="key">
  <a href="list.bit?pageNo=1&pageSize=10" style="text-decoration:none"><input type="submit" id="btnList" value="강의리스트 바로가기"></a>

<div id="key2">
  <a href="course.html" style="text-decoration:none"><input type="submit" id="btnInsert" value="강의등록 바로가기"></a>
  </div>
</div>
</div>
</div>
<div id="footer"></div>
</body>
</html>
</body>
</html>