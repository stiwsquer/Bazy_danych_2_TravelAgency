<!-- Add suport for spring mvc tags -->
<%@ taglib  prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>

<head>

	<title>Sign in</title>
	
	<link type="text/css" 
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/resources/css/style.css"
	>
	
	<link type="text/css" 
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/resources/css/add-customer-style.css"
	>
	
	
</head>

<body>
	<div id = "wrapper">
		<div id="header">
			<h2>Travel Agency</h2>
		</div>
	</div>
	
	<div id="container">
		<h3>Update informations</h3>
		<form:form action = "processUpdateUserDataForm" modelAttribute="user" method="POST">
			
			<!-- need to associate this data with user id (very important) -->
			 <form:hidden path="userId" />
			 <form:hidden path="userType" />
			<table>
				<tbody>
				
					<tr> 
						<td> <label>First name:</label> </td>
						<td> <form:input path="firstName"/>  </td>
						<td><form:errors path="firstName" cssClass="error"/></td>
					</tr>
					
					<tr> 
						<td> <label>Last name:</label> </td>
						<td> <form:input path="lastName"/>  </td>
						<td><form:errors path="lastName" cssClass="error"/></td>
					</tr>
					
					<tr> 
						<td> <label>Email:</label> </td>
						<td> <form:input path="email"/>  </td>
						<td><form:errors path="email" cssClass="error"/></td>
					</tr>
					
					<tr> 
						<td> <label>Password:</label> </td>
						<td> <form:input type = "password" path="pass"/>  </td>
						<td><form:errors path="pass" cssClass="error"/></td>
					</tr>
					<tr> 
						<td> <label></label> </td>
						<td> <input type="submit" value="Update" class="save" />  </td>
					</tr>
					
				</tbody>
			</table>
			
		</form:form>
		
		<div style = "clear; both;" >  </div>
		<p> 
			<a href="${pageContext.request.contextPath}/user/userHomePage">Back to home page</a>
		</p>
	</div>
	
</body>

</html>