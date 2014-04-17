<%@page import="vo.CourseVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%CourseVo course = (CourseVo)request.getAttribute("course");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
  <title>강의상세정보</title>
    <LINK href="courseCss.css" rel="stylesheet" type="text/css">
  </head><body>
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
<form class="form" action="update.bit" method="post">
<div class="row"><input type="text" class="simple" name="no" value="<%=course.getNo()%>" readonly="readonly"></div>
<div class="row"><input type="text" class="simple" name="title" value="<%=course.getTitle()%>"></div>
<div class="row"><textarea cols="10" rows="7" class="simple" name="description" value="<%=course.getDescription()%>"><%=course.getDescription()%></textarea></div>
<div class="row"><input type="text" class="simple" name="hours" value="<%=course.getHours()%>"></div>
<div id="row5"><input type="submit" id="btnAdd" value="Update"></div>
<div id="row6"><input type="reset" id="btnCancel" value="Cancel"></div>
<div id="row6"><input type="button" id="btnDelete" value="Delete" onclick="location.href='delete.bit?no=<%=course.getNo()%>'"></div>
</form>
</div></div>
<div id="key">
  <a href="list.bit?pageNo=1&pageSize=10" style="text-decoration:none"><input type="submit" id="btnList" value="강의리스트 바로가기"></a>
  </div>
</div>
</div>
<div id="footer"></div>

</body></html>
