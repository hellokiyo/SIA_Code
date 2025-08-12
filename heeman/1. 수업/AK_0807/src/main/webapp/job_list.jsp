<%@page import="java.util.List"%>
<%@page import="myjsp.EmpUtil"%>
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
	// job_id_list를 출력한다.
	//String[] jobList = EmpUtil.getJobList(); //리턴타입 : 문자배열 //매개변수 : X
	List<String> jobList = EmpUtil.getJobList();
	for(String jobId : jobList) {
%>

	<a href = "empt_list.jsp?jobId=<%=jobId %>"><%= jobId %></a><br>

<% }%>

job list size : <%= jobList.size() %>
<form action="emp_list.jsp">
	<select name="jobId">
		<% for(String jobId : jobList) { %>
		<option value = "<%=jobId %>"><%=jobId %></option>
		<%} %>
	</select>
	<input type = "submit" value="부서원보기">
</form>

</body>
</html>