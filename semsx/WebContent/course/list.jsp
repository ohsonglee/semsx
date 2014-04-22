<%@page import="vo.CourseVo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
  
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>강의목록(byJSP)</title>
<LINK href="courseCss.css" rel="stylesheet" type="text/css">
</head>
<body>
	<jsp:include page="/header.jsp"></jsp:include>
	<div id="rainb"></div>
	<div id="topmenu">
		<div id="menu">
			<ul>
				<li class="me"><a href="/semsx/subject/list.bit?pageNo=1&pageSize=10"
					style="text-decoration: none">Subject</a></li>
				<li class="me"><a href="/semsx/course/list.bit?pageNo=1&pageSize=10"
					style="text-decoration: none">Course</a></li>
				<li class="me"><a href="/semsx/user/list.bit?pageNo=1&pageSize=10"
					style="text-decoration: none">Users</a></li>
			</ul>
		</div>
	</div>
	<div id="toptext">
		<p id="p"></p>
	</div>
	<div id="center">
		<div id="box">
			<div id="main">
				<div>

					<table id="tata">
						<tr>
							<th>번호</th>
							<th>수업명</th>
						</tr>
						<c:forEach var="course" items="${list}">
							<tr>
								<td>${course.no}</td>
								<td><a href='detail.bit?no=${course.no}'>${course.title}</a></td>
							</tr>
						</c:forEach>
					</table>
				</div>
			</div>
			<div id="key">
				<a href="list.bit?pageNo=1&pageSize=10"
					style="text-decoration: none"><input type="submit" id="btnList"
					value="강의리스트 바로가기"></a>

				<div id="key2">
					<a href="course.html" style="text-decoration: none"><input
						type="submit" id="btnInsert" value="강의등록 바로가기"></a>
				</div>
			</div>
		</div>
	</div>
	<div id="footer">
		<jsp:include page="/footer.jsp"></jsp:include>
	</div>
</body>
</html>
