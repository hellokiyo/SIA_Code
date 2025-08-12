<%@page import="myjsp.EmpUtil"%>
<%@page import="java.util.List"%>
<%@page import="com.mysql.cj.Query"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- 

- 검색조건이 선택되어야 하며 검색조건을 employee_id로 선택하고, 직원의 아이디를 입력하면 해당 직원에 대
한 결과만 출력된다.

- 검색조건을 first_name로 하고 직원의 first_name을 입력하면 해당 이름의 직원데이터가 출력된다.
- 검색조건을 department_id로 하고 부서 아이디를 입력하면 해당 부서의 모든 직원의 결과가 출력된다.

 -->
 	<h1>Employee 검색</h1>
 	<form action="">  <!-- 테이블로감싸기 -->
		<select id="select" name="select">
			<option value="employee_id">employee_id</option>
			<option value="first_name">first_name</option>
			<option value="department_id">department_id</option>
		</select> 
		<input type="text" id="serchEmp">
		<input type="submit" value="serch"><br>
 	</form>

<%
String select = request.getParameter("select");
String serchEmp = request.getParameter("serchEmp");

EmpUtil empUtil = new EmpUtil();
List<String> selectEmp = empUtil.getSerchBy(select,serchEmp);


// 테이블에 들어갈 값
String emp_id = selectEmp.get(0);
String firstName =selectEmp.get(1); 
String sal = selectEmp.get(2);
String dept_id = selectEmp.get(3);


%>
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


</body>
</html>