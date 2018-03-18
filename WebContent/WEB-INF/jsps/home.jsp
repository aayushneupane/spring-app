<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>

<sql:query var="rs" dataSource="jdbc/dbPool">
select id, email, name, text from offers
</sql:query>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<h2>Results</h2>

	<c:forEach var="row" items="${rs.rows}">
    Id ${row.id}<br>
    Email ${row.email}<br>
    Name ${row.name}<br>
    Text ${row.text}<br>
	</c:forEach>

</body>
</html>