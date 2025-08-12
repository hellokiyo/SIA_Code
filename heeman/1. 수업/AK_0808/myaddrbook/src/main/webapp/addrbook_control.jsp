<%@page import="addrbook.AddrBookVO"%>
<%@page import="java.util.List"%>
<%@page import="addrbook.AddrBookDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
%>
<jsp:useBean id="ab" class="addrbook.AddrBookVO"></jsp:useBean>
<jsp:setProperty property="*" name="ab"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	//client의 요구(action 참조)에 따라 처리한다.
	//insert, upadte, delete, list
	String action = request.getParameter("action");
	System.out.println("action=" + action);
	String forwardPage ="addrbook_list.jsp";
	AddrBookDAO dao = new AddrBookDAO();
	if("insert".equals(action)) {
		//insert - DAO.insert();
		dao.insertDB(ab);
		response.sendRedirect("addrbook_control.jsp?action=list");
		//위 한줄과 이 아래 두줄이 같은 내용
		//List<AddrBookVO> list = dao.getDBList();
		//request.setAttribute("data", list);
		//목록이 출력될 수 있도록 한다.
		//forwardPage를 설정한다.
		
	} else if("edit".equals(action)) {
		//1. 클라이언트가 전송한 데이터 중에서 방명록id를 추출한다.
		String abIdStr = request.getParameter("ab_id");
		//2. DB에서 해당 방명록 정보를 조회한다.
		AddrBookVO vo = dao.getDB(Integer.parseInt(abIdStr));
		//3. 방명록 정보를 리퀘스트에 넣는다.
		forwardPage  = "addrbook_edit_form.jsp";
		request.setAttribute("ab", vo);
		pageContext.forward(forwardPage);
		
	}else if("delete".equals(action)) {
		String abIdStr = request.getParameter("ab_id"); 
		int result = dao.deleteDB(Integer.parseInt(abIdStr));
		forwardPage  = "addrbook_control.jsp?action=list";
		request.setAttribute("ab", result);
		pageContext.forward(forwardPage);
	}
	
	else if("list".equals(action)) {
		// scope request에 data라는 이름으로 리스트를 넣어두어야 한다.
		// jsp에 꺼내서 출력한다.
		List<AddrBookVO> list = dao.getDBList();
		request.setAttribute("data", list);
		pageContext.forward(forwardPage);
	}
%>

<%--<jsp:forward page="<%=forwardPage %>"></jsp:forward>--%>
</body>
</html>