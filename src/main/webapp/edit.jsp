<%@page import="dto.User"%>
<%@page import="dao.UserDao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<%

if(request.getSession().getAttribute("id")==null)
{
	response.getWriter().print("<h1  style=\"color: white;\"> Invalid Session Login Again </h1>");
	request.getRequestDispatcher("Login.html").include(request, response);
}
else{
%>
<%
String email= request.getParameter("email"); 
UserDao dao=new UserDao();
User user=dao.find(email);

%>
<div class="a2">
	<div id="a1"><h2>Sign Up</h2></div>
		<form action="update">

			<table style="background-color: gray; width: 490px; height: 550px; color: rgba(#7A254B,#D7DADE,#0C1310); "
				class="t1">
				
				<tr>
				<td>
				<input type="text" name="id" value="<%= user.getId()%>" hidden="hidden"></td>
				</tr>
				<tr class="tr1">
					<td><label for="name">Name</label></td>
					<td><input type="text" name="name" placeholder="Enter name" value="<%=user.getName() %>"></td>
				</tr>
				<tr class="tr2">
					<td><label for="email">E-Mail</label></td>
					<td><input type="email" name="email" placeholder="Enter email" value="<%=user.getEmail()%>" readonly="readonly"></td>
				</tr>
				<tr class="tr3">
					<td><label for="Password">Password</label></td>
					<td><input type="password" name="password"placeholder="Enter password" value="<%=user.getPass()%>"></td>
				</tr>
				<tr class="tr4">
					<td><label for="phno">PNumber</label></td>
					<td><input type="text" name="phno" placeholder="Enter number" value="<%=user.getPhno()%>">
					</td>
				</tr>

				<tr class="tr5">
					<td><label for="gen">Gender</label></td>
					<%if(user.getGender().equals("male")) { %>
					<td ><input type="radio" name="gen" value="male" checked="checked">Male</td>
					<td class="m1"><input type="radio" name="gen" value="female">Female</td>
					<% }else { %>
					<td ><input type="radio" name="gen" value="male">Male</td>
					<td class="m1"><input type="radio" name="gen" value="female" checked="checked">Female</td>
					<%} %>
				</tr>
				<tr class="tr6">
					<td><label for="address">Address</label></td>
					<td><textarea name="address" cols="30" rows="10"><%=user.getAddress()%></textarea></td>
					
				</tr>
				<tr>
					<td id="td1">
						<button>Update</button>
					<td id="td2">
						<button type="reset" >Cancle</button>
					</td>
					</td>


				</tr>

			</table>
		</form>

	</div>
<%} %>
	<style>

#a1{
position: relative;
top: 70px;
left: 160px;
color: rgba(#0C1310);}
	
	.a2{
	
	position: relative;
	top: 5px;
	right: -450px;}
	.tr1{

position: relative;
top: 60px;
left: 20px;
cursor: pointer;}
	.tr2{

position: relative;
top: 60px;
left: 20px;
cursor: pointer;}
.tr3{

position: relative;
top: 60px;
left: 20px;cursor: pointer;}

.tr4{
position: relative;
top: 60px;
left: 20px;;cursor: pointer;
}

.tr5 {
	position: relative;
	top: 60px;
	left: 20px;cursor: pointer;
}

.m1{

position: relative;
right: 190px;
}
.m2{

position: relative;
right: 190px;
}


.tr6 {
	position: relative;
	top: 40px;
	left: 20px;cursor: pointer;
}

#td1 {
	position: relative;
	left: 130px;
	bottom: 10px;
	cursor: pointer;
}

#td2 {
	position: relative;
	left: 200px;
	bottom: 10px;
	cursor: pointer;
}
</style>
</body>
</html>