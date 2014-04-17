<%@page import="vo.CourseVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
  <title>강의상세정보</title>
  </head><body>
  <h1>강의상세정보(byJSP)</h1>
<table border='1'>
<%CourseVo course = (CourseVo)request.getAttribute("course");
%>
<tr>
  <th>번호</th>
  <td><%=course.getNo()%></td>
</tr>
<tr>
  <th>수업명</th>
  <td><%=course.getTitle()%></td>
</tr>
<tr>
  <th>수업내용</th>
 <td><textarea rows='5' cols='60'><%=course.getDescription()%></textarea></td>
</tr>
<tr>
  <th>수업시간</th>
  <td>1</td>
</tr>
</table>
<a href='list.bit?pageNo=1&pageSize=10'>목록</a>
<a href='delete.bit?no=<%=course.getNo()%>'>삭제</a>
<a href='update.bit?no=<%=course.getNo()%>'>변경</a><br>
</body></html>
