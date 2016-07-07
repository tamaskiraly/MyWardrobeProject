<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title><sec:authentication property="name"/>`s Wardrobe</title>
</head>
<body>
<h1><sec:authentication property="name"/>`s Wardrobe</h1>

	<table>
	
		<tr>
			<th>ID</th><th>Outfit name</th>
		</tr>
	
		<c:forEach items="${outfits}" var="outfit">
		
			<tr>
				
				<td>${outfit.id}</td><td>${outfit.name}</td>
				
				<td>
					<table> 
 						<tr> 
 							<th>Item ID</th><th>Item Name</th><th>Item username</th>
 						</tr> 
						<c:forEach items="${outfit.items}" var="item">
						<tr> 
								<td>${item.id}</td><td>${item.name}</td><td>${item.username}</td>
							</tr> 
						</c:forEach>
						
					</table> 
				</td>
				
			</tr>
		
		</c:forEach>
	
	</table>

</body>
</html>