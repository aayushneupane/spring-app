<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<link
	href="${pageContext.request.contextPath}/static/css/bootstrap.min.css"
	rel="stylesheet" type="text/css">
<title>Login Page</title>
</head>
<body onload='document.f.username.focus();'>
	<h3>Login with Username and Password</h3>

	<c:if test="${param.error != null}">
		<div class="alert alert-danger">
			<strong>Invalid Logins.</strong> Couldnt log in using the given credentials. 
		</div>
	</c:if>

	<form name='f' action='${pageContext.request.contextPath}/login'
		method='POST'>
		<table class="table">
			<tr>
				<td>User:</td>
				<td><input type='text' name='username' value=''></td>
			</tr>
			<tr>
				<td>Password:</td>
				<td><input type='password' name='password' /></td>
			</tr>
			<tr>
				<td colspan='2'><input name="submit" type="submit"
					value="Login" /> <input value="${_csrf.token}" type="hidden"
					name="${_csrf.parameterName}" /></td>
			</tr>

		</table>
	</form>
</body>
</html>