<%@page import="vo.UsersVo"%>
<%@page import="vo.CourseVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
    
<%@ include file="../jsp/header.inc"  %>
<title>사용자 상세 정보</title>
<%@ include file="../jsp/tableStyle.inc"  %>
<style>
div#users-contain {
width: 200px;
margin: 20px 0;
}
</style>

<%@ include file="../jsp/endHeader.inc"  %>
 
 <body>
 <jsp:include page="../header.jsp" />
  <h1>사용자상세정보(byJSP)</h1>
  
<%--   
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
 --%>
 
<div id="users-contain" class="ui-widget">
<table id="users" class="ui-widget ui-widget-content">
<%UsersVo users = (UsersVo)request.getAttribute("users");%>
    <thead>
      <tr class="ui-widget-header ">
        <th>번호</th>
      </tr>
    </thead>
    <tbody>
      <td>${users.no}</td>
    </tbody>
    
    <thead>
      <tr class="ui-widget-header ">
        <th>이메일</th>
      </tr>
    </thead>
    <tbody>
      <td>${users.email}</td>
    </tbody>
    
    <thead>
      <tr class="ui-widget-header ">
        <th>비밀번호</th>
      </tr>
    </thead>
    <tbody>
      <td><%=users.getPassword()%></td>
    </tbody>
    
    <thead>
      <tr class="ui-widget-header ">
        <th>이름</th>
      </tr>
    </thead>
    <tbody>
      <td><%=users.getName()%></td>
    </tbody>
    
    <thead>
      <tr class="ui-widget-header ">
        <th>전화번호</th>
      </tr>
    </thead>
    <tbody>
      <td><%=users.getTel()%></td>
    </tbody>
    
    <thead>
      <tr class="ui-widget-header ">
        <th>팩스</th>
      </tr>
    </thead>
    <tbody>
    
    <c:set var="s01" value="홍길동" />
    <c:if test="${s01 == '홍길동'}">
    나는 홍길동이다!
    </c:if>
      <td><%=users.getFax()%></td>
    </tbody>
    
    <thead>
      <tr class="ui-widget-header ">
        <th>우편번호</th>
      </tr>
    </thead>
    <tbody>
      <td><%=users.getPostNo()%></td>
    </tbody>
    
    <thead>
      <tr class="ui-widget-header ">
        <th>주소</th>
      </tr>
    </thead>
    <tbody>
      <td><%=users.getAddr()%></td>
    </tbody>
    
    <thead>
      <tr class="ui-widget-header ">
        <th>사진여부</th>
      </tr>
    </thead>
    <tbody>
      <td><%=users.getPhot()%></td>
    </tbody>
  </table>
</div>

<a href='list.bit?pageNo=1&pageSize=10'>목록</a>
<a href='delete.bit?no=<%=users.getNo()%>'>삭제</a>
<a href='update.bit?no=<%=users.getNo()%>'>변경</a><br>

<%@ include file="../jsp/footer.inc" %>

