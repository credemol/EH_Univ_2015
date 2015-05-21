<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>User Detail</title>
<style type="text/css">
.cls_label{
	width:150px;
	display:inline-block;
	font-weight:bolder;
}
</style>
</head>
<body>
<h1>User Information</h1>
<div style="margin:20px;">
<div><span class="cls_label">Login ID:</span> ${user.loginId} </div>
<div><span class="cls_label">First Name:</span> ${user.firstName }</div>
<div><span class="cls_label">Last Name:</span> ${user.lastName }</div>
<div><span class="cls_label">Display Name:</span> ${user.displayName }</div>
<div><span class="cls_label">Email:</span> ${user.email }</div>
</div>
<div>
<a href="UserListServlet">List</a> &nbsp;
<a href="javascript:deleteUser()">탈퇴</a> &nbsp;
<a href="UserUpdateServlet?id=${user.id }">Update</a>
</div>
<form name="deleteForm" method="post" action="UserDeleteServlet">
	<input type="hidden" name="id" value="${user.id }"/>
</form>
<script type="text/javascript">
function deleteUser() {
	if(confirm("정말로 탈퇴하시겠습니까?")) {
		document.deleteForm.submit();
	}
}
</script>
</body>
</html>