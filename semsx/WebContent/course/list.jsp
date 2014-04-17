<%@page import="vo.CourseVo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <% 
    List<CourseVo> list = 
    		  (List<CourseVo>)request.getAttribute("list"); 
    %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>강의목록(byJSP)</title></head><body>
<h1 >강의 목록</h1>
<a href='form.html'>새강좌 등록</a><br>
<table border='1'>
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
</body></html>