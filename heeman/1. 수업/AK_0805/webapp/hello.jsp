<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

	<head>
		<meta charset="UTF-8">
		<title>정훈이의 웹서버</title>
	</head>
	
	
	<body>
	
	안녕하세요 여기는 정훈이 PC입니다.
	
	<div style="border: 1px solid red; width: 300px; height: 100px;">			
		<a href= "https://www.google.com">
			<img src = "images/google.png" style = "width: 50px; height: 50px;">
		</a>
		
		<a href= "https://www.naver.com">
			<img src = "images/naver.png" style = "width: 50px; height: 50px;"></img>
		</a>

		<a href= "https://www.kakao.com">
			<img src = "images/kakao.png" style = "width: 50px; height: 50px;"></img>
		</a><br>
		
		
		
		<%
			String user = request.getParameter("name");
			if(user ==null) {
				user = "Guest";
			}
		%>
		Hello !~ <%=user%>
		
		<br>
		time : <%=new Date()%>   <!-- 생성자 호출(객체생성)-->
	</div>
		
		<a href ="https://www.naver.com">naver</a>
		<form action="https://www.naver.com">
		<input type="submit" value="naver">
		</form>
	</body>


</html>