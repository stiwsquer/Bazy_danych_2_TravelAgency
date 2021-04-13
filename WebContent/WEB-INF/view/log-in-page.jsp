<!-- Add suport for spring mvc tags -->
<%@ taglib  prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<!DOCTYPE html>
<html>

<head>

	<title>Log in</title>
	
	<link type="text/css" 
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/resources/css/style.css"
	>
	
	<link type="text/css" 
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/resources/css/add-customer-style.css"
	>
	
	<style type="text/css">
	
		.failed{
			color: red;
		}
		
	</style>
</head>

<body>
	<div id = "wrapper">
		<div id="header">
			<h2>Travel Agency</h2>
		</div>
	</div>
	
	<div id="container">
		<h3>LOG IN</h3>
		<form:form action = "processLogInForm" modelAttribute="user" method="POST">
			
			<!-- need to associate this data with user id (very important) <form:hidden path="userId" /> -->
			
			<c:if test="${param.error != null}">
					<i class="failed">Sorry! You entered invalid username/password.</i>
			</c:if>
			
			<table>
				<tbody>
				
					<tr> 
						<td> <label>Email:</label> </td>
						<td> <form:input path="email"/>  </td>
					</tr>
					
					<tr> 
						<td> <label>Password:</label> </td>
						<td> <form:input type="password" path="pass"/>  </td>
					</tr>
					<tr> 
						<td> <label></label> </td>
						<td> <input type="submit" value="Submit" class="save" />  </td>
					</tr>
					
				</tbody>
			</table>
			
		</form:form>
		
		<div style = "clear; both;" >  </div>
		<p> 
			<a href="${pageContext.request.contextPath}/user/signInForm">SIGN IN</a>
		</p>
	</div>
	
</body>

</html>