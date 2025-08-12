<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>


	<%
	request.setCharacterEncoding("utf-8");

	Map<String, String> menuList = new HashMap<String,String>();
	menuList.put("jja", "짜장면");
	menuList.put("jjam", "짬뽕");
	menuList.put("tang", "탕수육");
	
	String lunch = "";

	
	
	
	
	Map<String, String> hobbyList = new HashMap<String,String>();
	hobbyList.put("sports", "운동");
	hobbyList.put("instrument", "악기");
	hobbyList.put("travel", "여행");
	
	String[] hobbiesParams = request.getParameterValues("hobby"); // 여러 개 받기
	String hobbyOutput = "";

	if(hobbiesParams != null) {
		for(String hobby : hobbiesParams) {
			if(hobbyList.containsKey(hobby)) {
				hobbyOutput += hobbyList.get(hobby) + " ";
			}
		}
	}
	
	
	
	String userName =  request.getParameter("username");
	String email = request.getParameter("email");
	String menu = request.getParameter("menu");
	

	out.print("당신의 이름은 : " + userName + "이군요!<br>");
	out.print("이메일은 : " + email + "입니다<br>");

	out.print("취미로는 : " + hobbyOutput + "이군요!<br>");
	
	if(	menuList.containsKey(menu)) {
		lunch = menuList.get(menu);
		out.print("점심으로는 " + lunch + "을 드시려 하는군요!ㅎ");
	}
%>



</body>
</html>