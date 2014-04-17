<%@page import="vo.UsersVo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
      <% 
    List<UsersVo> list = 
          (List<UsersVo>)request.getAttribute("list"); 
    %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>사용자정보목록(byJSP)</title>
<h1>사용자 정보 목록</h1>
<a href='user.html'>사용자 등록</a><br>
<table border='1'>
<tr>
  <th>번호</th>
  <th>이름</th>
  <th>이메일</th>
  <th>전화번호</th>
</tr>
<% 
for(UsersVo user : list){%>
<tr>
  <td><%=user.getNo()%></td>
  <td><a href='detail.bit?no=<%=user.getNo()%>'><%=user.getName()%></a></td>
  <td><%=user.getEmail()%></td>
  <td><%=user.getTel()%></td>
</tr>
<%}%>
</table>
</body></html>
