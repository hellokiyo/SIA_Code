<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Employees 검색</h1>
	<form action="ex-05.jsp">
		<table>
			<tr>
				<td><select name="searchType">
						<option value="employee_id">employee_id</option>
						<option value="first_name">first_name</option>
						<option value="department_id">department_id</option>
				</select></td>
				<td><input type="text" id="serchText"></td>
				<td><input type="submit" value="검색"></td>
				<br>
			</tr>
		</table>
	</form>
	<%
		String searchType = request.getParameter("searchType");
		if(searchType==null || searchType.length()==0) {
	%>
	전체를 출력한다.<br>
	<%
		return;
		} 
	%> 
	
	
	<%	if(searchType.equals("employee_id")){ %>
	
	
	employee_id에 해당하는 조회결과를 출력한다.<br>
	
	<tabel border="1">
	<%for(String emp : selectEmp) {%>
		<tr>
			<td><%=emp_id %></td>
			<td><%=firstName %></td>
			<td><%=sal%></td>
			<td><%=dept_id %></td>
		</tr>
	<%}%>
</tabel>
	
	
	
	
	
	
	<%
		return;
		} 
	%> 
	
	
	<%	if(searchType.equals("first_name")) { %>
	 firstName 해당하는 조회결과를 출력한다.<br>
	<%
		return;
		} 
	%>
	 
	<%	if(searchType.equals("department_id")) { %>
	 departmentId에 해당하는 직원목록을 출력한다.<br>
	<%
		return;
		} 
	%> 




</body>
</html>