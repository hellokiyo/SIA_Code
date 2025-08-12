<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

</head>
<body>

<form name="buyForm" method=post action="result.jsp">
	<table border="1">
		<tr>
			<th>과일목록</th>
			<th>가격</th>
		</tr>
		<tr>
			<td>
				<input type="checkbox" name="fruit" value="cherry">체리<br>
				<input type="checkbox" name="fruit" value="orange">오렌지<br>
				<input type="checkbox" name="fruit" value="apple">사과<br>
			</td>
			<td>
				<span>25000</span><br>
				<span>23000</span><br>
				<span>16000</span><br>
			</td>
		</tr>
		<tr>
			<td colspan="2"  align=center>
				<input type="submit" value="구입">
			</td>	
		</tr>
	</table>
</form> 

<%

%>

</body>
</html>