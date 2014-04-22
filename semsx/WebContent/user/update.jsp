<%@page import="vo.UsersVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
UsersVo users = (UsersVo)request.getAttribute("users");
%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">

<title>사용자변경(byJSP)</title>
</head>
<body>
 <jsp:include page="../header.jsp" />
 <h1>사용자 변경</h1>
 <form action='update.bit' method='post'>
 사용자번호: <input type='text' name='no' value='<%=users.getNo()%>'readonly><br>
이메일: <input type='text' name='email' value='<%=users.getEmail()%>' ><br>
패스워드:<input type='password' name='password' value='<%=users.getPassword()%>' ><br>
이름: <input type='text' name='name' value='<%=users.getName()%>' ><br>
전화번호: <input type='text' name='tel' value='<%=users.getTel()%>' ><br>
팩스: <input type='text' name='fax' value='<%=users.getFax()%>' ><br>
우편번호: <input type='text' name='postNo'  value='<%=users.getPostNo()%>'><br>
주소: <input type='text' name='addr' value='<%=users.getAddr()%>' ><br>
사진여부: <input type='text' name='phot' value='등록된 사진이 없습니다.' readonly><br>
  <input type='submit' value='변경'>
  <input type='button' value='취소'
 onclick="location.href='detail.bit?no=<%=users.getNo()%>' "> 
 </form>
 </body>
 </html>



