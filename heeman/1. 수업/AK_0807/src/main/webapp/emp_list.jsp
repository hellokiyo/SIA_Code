<%@page import="java.util.List"%>
<%@page import="myjsp.EmpUtil"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<style>
	.outer-container {
	    display: flex; /* 중앙 정렬을 위한 flex */
	    justify-content: center;
	    padding: 50px;
	    background-color: #f0f0f0;
	}
	
	.inner-container {
	    display: grid;
	    grid-template-columns: repeat(3, 100px); /* 3개씩 나열 */
	    gap: 10px;
	    background-color: #fff;
	    padding: 10px;
	}

</style>



</head>
<body>
<%--
	클라이언트로 부터 전송된 데이터를 추출한다.
 --%>
<div class ="outer-container">
	<%
		EmpUtil empUtil = new EmpUtil();
		String jobId = request.getParameter("jobId");
		List<String> DeptNameList = empUtil.getDeptList(jobId);
	%>
	
	<div class="inner-container">
		<%=jobId %>직무 직원 목록 조회
	</div>
	

</div>
<div class ="outer-container">
		<%
			for(String DeptName : DeptNameList) {
				out.print(DeptName+"<br>");
			}
		%>
	</div>
</body>
</html>