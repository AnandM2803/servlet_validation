<%@page import="dto.User"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>


<script src="https://cdnjs.cloudflare.com/ajax/libs/xlsx/0.17.0/xlsx.full.min.js"></script>
<script type="text/javascript">
function export_data(){
	let data=document.getElementById('data');
	var fp=XLSX.utils.table_to_book(data,{sheet:'sheet1'});
	XLSX.write(fp,{
		bookType:'xlsx',
		type:'base64'
	});
	XLSX.writeFile(fp, 'test.xlsx');
}
</script>


<meta charset="ISO-8859-1">
<title>Delete Records</title>
</head>
<body>
<%

if(request.getSession().getAttribute("id")==null)
{
	response.getWriter().print("<h1> Invalid Session Login Again </h1>");
	request.getRequestDispatcher("Login.html").include(request, response);
}

else{
%>
<% List<User> list=(List<User>)request.getAttribute("list"); %>
<table border="1">
<tr>
<th>User Id</th>
<th>User Nmae</th>
<th>User Phone no</th>
<th>User Email</th>
<th>User Password</th>
<th>User Gender</th>
<th>User Address</th>
<th>Delete</th>
<th>Edit</th>
</tr>
<% for(User user:list){ %>
<tr>
<td><%=user.getId() %></td>
<td><%=user.getName() %></td>
<td><%=user.getPhno() %></td>
<td><%=user.getEmail() %></td>
<td><%=user.getPass() %></td>
<td><%=user.getGender() %></td>
<td><%=user.getAddress() %></td>
<td><a href="delete?email=<%=user.getEmail()%>"> <Button>delete </Button> </a></td>
<td><a href="edit.jsp?email=<%=user.getEmail()%>"> <button>Edit</button> </a></td>
</tr>
<%} %>
</table>
<button onclick="window.print()">Print</button>
<button onclick="export.print()">Export</button>
<br>
<a href="Logout"> <button>Logout</button> </a>
<%} %>
</body>
</html>