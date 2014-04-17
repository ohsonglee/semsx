<%@page import="vo.UsersVo"%>
<%@page import="vo.CourseVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
  <title>사용자상세정보</title>
  </head><body>
  <h1>사용자상세정보(byJSP)</h1>
<table border='1'>
<%UsersVo users = (UsersVo)request.getAttribute("users");
%>
<tr>
  <th>번호</th>
  <td><%=users.getNo()%></td>
</tr>
<tr>
  <th>이메일</th>
  <td><%=users.getEmail()%></td>
</tr>
<tr>
  <th>비밀번호</th>
  <td><%=users.getPassword()%></td>
</tr>
<tr>
  <th>이름</th>
  <td><%=users.getName()%></td>
</tr>
<tr>
  <th>전화번호</th>
  <td><%=users.getTel()%></td>
</tr>
<tr>
  <th>팩스</th>
  <td><%=users.getFax()%></td>
</tr>
<tr>
  <th>우편번호</th>
  <td><%=users.getPostNo()%></td>
</tr>
<tr>
  <th>주소</th>
  <td><%=users.getAddr()%></td>
</tr>
<tr>
  <th>사진여부</th>
  <td>등록된 사진이 없습니다.</td>
</tr>
</table>

<a href='list.bit?pageNo=1&pageSize=10'>목록</a>
<a href='delete.bit?no=<%=users.getNo()%>'>삭제</a>
<a href='update.bit?no=<%=users.getNo()%>'>변경</a><br>
</body></html>

