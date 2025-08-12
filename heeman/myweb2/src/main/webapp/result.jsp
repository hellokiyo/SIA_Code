<%@page import="java.util.Arrays"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
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


	Map<String, Integer> fruitList = new HashMap<String, Integer>();
	fruitList.put("cherry",25000);
	fruitList.put("orange",23000);
	fruitList.put("apple",16000);
	
	String[] fruits = request.getParameterValues("fruit");
	String fruitBuy ="";
	int fruitSum = 0;
	
	if(fruits != null) {
		for(String fruit : fruits) { 
			int i =0;
			session.setAttribute("fruitOutput"+i,fruit);
		
			System.out.print("구입한 과일 추가됨" +fruit);
			
			if(fruitList.containsKey(fruit)) {  //합계
				fruitSum += fruitList.get(fruit);

			}
		}
	}

	
	
	
	
	
%>
<form method="post" action="first.jsp">
<table border="1">
	<tr>
		<th>구입한 과일</th>
		<td><%=fruitOutput%></td>
	</tr>
	<tr>
		<th>합계</th>
		<td><%=fruitSum %></td>
	</tr>
	<tr>
		
		<td colspan="2"  align=center>
			<input type="submit" value="과일구입화면">		
		</td>
 	</tr>
</table>
</form>

</body>
</html>