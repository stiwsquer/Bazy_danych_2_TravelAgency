<!-- Add suport for jstl core tags -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>

<html>

<head>

	<title> View Users</title>

	<!-- reference our style sheet -->
	<link type = "text/css"
		  rel = "stylesheet"
		  href = "${pageContext.request.contextPath}/resources/css/style.css" />
	
</head>

<body>
	
	<div id = "wrapper">
		<div id="header">
			<h2>Travel Agency - View Users</h2>
		</div>
	</div>
	
	<div id="container">
		<div id="content">
			
			
		
			
			<h3>Users:</h3>
			
			<!-- add our html table here -->
			<table>
			
				<tr>
				 	<th>First Name</th>
				 	<th>Last Name</th>
				 	<th>Email</th>
				 	<th>User Type</th>
				 	<th>Action</th>
				</tr>
				
				<!-- loop over and print our customers -->
				<c:forEach var="tempUser" items="${users}">
					
					
					<!-- construct an "delete" link with country id -->
					<c:url var="deleteLink" value="/user/deleteUser">
						<c:param name="userId" value="${tempUser.userId}" />
					</c:url>
					
					<tr> 
						<td> ${tempUser.firstName} </td>
						<td> ${tempUser.lastName} </td>
						<td> ${tempUser.email} </td>
						<td> ${tempUser.userType} </td>
						<td> 
							<!-- display the delete link -->
							<a href="${deleteLink}"
							   onclick="if(!(confirm('Are you sure you want to delete this User?'))) return false">Delete</a>
						</td>
					</tr>
					
				</c:forEach>
				
			</table>
			<div style = "clear; both;" >  </div>
			<p> 
				<a href="${pageContext.request.contextPath}/user/employeeHomePage">Back to home page</a>
			</p>
		</div>
	</div>
	
</body>
</html>