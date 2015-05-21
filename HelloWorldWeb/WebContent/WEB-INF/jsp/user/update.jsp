<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>User Update</title>
<style type="text/css">
label {
	width:150px;
	display:inline-block;
}
</style>
</head>
<body>

<form name="updateForm" action="UserUpdateServlet" method="post">
<input name="id" type="hidden" value="${user.id }" >
	<div>
		<label for="loginId">Login Id</label>
		<input name="loginId" value="${user.loginId }" readonly="readonly">
	</div>
	<div>
		<label for="firstName">First Name</label>
		<input name="firstName" value="${user.firstName }">
	</div>
	<div>
		<label for="lastName">Last Name</label>
		<input name="lastName" value="${user.lastName }">
	</div>
	<div>
		<label for="displayName">Display Name</label>
		<input name="displayName" value="${user.displayName }">
	</div>
	<div>
		<label for="email">Email</label>
		<input name="email" value="${user.email }">
	</div>
	<div>
		<label for="password">Password</label>
		<input type="password" name="password">
	</div>
	<div align="center">
		<input type="submit" value="Update">
		<input type="reset" value="Reset">
	</div>
</form>
</body>
</html>