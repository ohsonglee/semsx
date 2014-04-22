<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<div id="header" style="border: 1px solid white; background-color: darkgray; font-weight: bold; font-size:18px; color:white; ">


${loginUser.name}(${loginUser.email})
<a href="${pageContext.request.contextPath}/auth/logout.bit">로그아웃</a>
</div>