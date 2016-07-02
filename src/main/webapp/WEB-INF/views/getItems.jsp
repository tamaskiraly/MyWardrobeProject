<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Goals Report</title>
</head>
<body>


	<table>
	
		<tr>
			<th>ID</th><th>ITEM</th><th>USER</th>
		</tr>
	
		<c:forEach items="${items}" var="item">
		
			<tr>
				
				<td>${item.id}</td><td>${item.name}</td><td>${item.user.firstname}</td>
				
				<td>
					<table>
						<tr>
							<th>User ID</th><th>First Name</th><th>Last Name</th>
						</tr>
						<c:forEach items="${item.id}" var="user">
							<tr>
								<td>${user}</td>
							</tr>
						</c:forEach>
						
					</table>
				</td>
				
			</tr>
		
		</c:forEach>
	
	</table>

</body>
</html>