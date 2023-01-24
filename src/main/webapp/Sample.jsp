<%@page import="java.awt.Button"%>
<%@page import="dto.User"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>

 <h1>Hiiiiiiiiiiiii</h1>
<%  int a=10;
System.out.println(a);%>
 <h1><% response.getWriter().print(a);%></h1> <%-- scriptlet tag --%>
 
 <%= a  %> <%-- Excpration tag --%>
 
 <%! int a=50; %> <%-- Declerative tag --%>
<h1><%= this.a  %></h1> <%--  --%>

<% List<User> list=(List<User>)request.getAttribute("list"); 

	response.getWriter().print("<table border=\"1\">"
			+"<tr>"
			+"<th>User Name </th>"
			+"<th>User Phone </th>"
			+"<th>User Email </th>"
			+"<th>User Password </th>"
			+"<th>User Gender </th>"
			+"<th>User address </th>"
			+"<th>Delete</th>"
			+"</tr>"
			);
	for(User u1:list){
	response.getWriter().print("<tr>"+"<th>"+u1.getName()+"</th><th>"+u1.getPhno()+"</th><th>"+u1.getEmail()+"</th><th>"+u1.getPass()+"</th><th>"+u1.getGender()+"</th><th>"+u1.getAddress()+"</th><th><button>delete</button");
}
%>



</body>
</html>