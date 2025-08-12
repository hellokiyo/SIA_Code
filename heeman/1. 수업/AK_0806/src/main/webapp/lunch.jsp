<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Enumeration"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>



<!-- 
http://localhost:9000/myjsp/lunch.jsp?
username=junghun&
email=ox%40naver.com&
searchword=serch&
hobby=%EC%9A%B4%EB%8F%99&
hobby=%EC%95%85%EA%B8%B0&
gender=%EC%97%AC%EC%9E%90&
menu=%ED%83%95%EC%88%98%EC%9C%A1 
-->

<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	Map<String, String> menuList = new HashMap<String, String>();
	menuList.put("jja","짜장면");
	menuList.put("jjam","짬뽕");
	menuList.put("tang","탕수육");

	request.setCharacterEncoding("utf-8");
	String userName = request.getParameter("username");
	String[] hobbyList = request.getParameterValues("hobby");
	String menu = request.getParameter("menu");
	String lunch = "";
%>
user name : <%= userName %>
<p>

<%
if(	menuList.containsKey(menu)) {
	lunch = menuList.get(menu);
	out.print("점심은" + lunch);
}



if(hobbyList !=null) {
	for(String hobby : hobbyList) {
		System.out.println(hobby);
		out.print("<br>" + hobby + "<br>");

%>
<br><%= hobby %><br>
<% 
	}
}	
	

%>
<%
	Enumeration paramList = request.getParameterNames();
	while(paramList.hasMoreElements()) {
		String param = (String)paramList.nextElement();
		String value = request.getParameter(param);
		out.print(param + "= " + value + "<br>");
	}
%>
</body>
</html>