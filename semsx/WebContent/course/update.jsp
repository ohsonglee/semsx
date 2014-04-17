<%@page import="vo.CourseVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
CourseVo course = (CourseVo)request.getAttribute("course");
%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
 <title>강의변경폼</title>
</head>
<body>
 <h1>강의 변경</h1>
 <form action='update.bit' method='post'>
 강의번호: <input type='text' name='no' value='<%=course.getNo()%>' readonly><br>
강의명: <input type='text' name='title' value='<%=course.getTitle()%>'><br>
강의설명:<br><textarea name='description' rows='10' cols='80'><%=course.getDescription()%></textarea><br>
강의시간: <input type='text' name='hours' value='<%=course.getHours()%>'><br>
  <input type='submit' value='변경'>
  <input type='button' value='취소'
 onclick="location.href='detail.bit?no=<%=course.getNo()%>' "> 
 </form>
 </body>
 </html>

