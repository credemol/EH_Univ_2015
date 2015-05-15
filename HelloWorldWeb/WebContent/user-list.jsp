<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="kr.ac.ewha.helloworld.dao.*" %>  
<%@ page import="kr.ac.ewha.helloworld.domain.*" %>   
<%@ page import="java.util.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>User List JSP</title>
</head>
<body>
	<h1>JSP User List</h1>
	<ul>
<%
	UserDao userDao = new UserDaoImpl();
	Collection<User> users = userDao.getAllUsers();
	
	for(User user: users) {
 %>
 		<li><a href='mailto:<%= user.getEmail() %>'><%= user.getDisplayName() %></a></li>
 <%
 	}
  %>
	</ul>

</body>
</html>