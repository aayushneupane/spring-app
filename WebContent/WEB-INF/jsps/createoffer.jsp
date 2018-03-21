<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="${pageContext.request.contextPath}/static/css/bootstrap.min.css" rel="stylesheet" type="text/css">
<title>Insert title here</title>
</head>
<body>



	<form method="post"
		action="${pageContext.request.contextPath}/docreate">
		<table class="table">

			<tr>
				<td>Name:</td>
				<td><input name="name" type="text" /></td>
			</tr>
			<tr>
				<td>Email:</td>
				<td><input name="email" type="text" /></td>
			</tr>
			<tr>
				<td>Text:</td>
				<td><textarea name="text" /></textarea></td>
			</tr>
			<tr>
				<td></td>
				<td><input value="Create" type="submit" class="btn btn-default"/></td>
				<td><input value="${_csrf.token}" type="hidden" name="${_csrf.parameterName}"/></td>
			</tr>

		</table>
	</form>



</body>
</html>