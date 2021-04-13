<!-- Add suport for spring mvc tags -->
<%@ taglib  prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>

<head>

	<title>Add Country</title>
	
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
			<h2>Travel Agency - Add Country</h2>
		</div>
	</div>
	
	<div id="container">
		<h3>Add country:</h3>
		<form:form action = "processAddCountryForm" modelAttribute="country" method="POST">
			
			<!-- need to associate this data with country id (very important) -->
			 <form:hidden path="countryId" />
			
			<table>
				<tbody>
				
					<tr> 
						<td> <label>Country name:</label> </td>
						<td> <form:input path="countryName"/>  </td>
						<td><form:errors path="countryName" cssClass="error"/></td>
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
			<a href="${pageContext.request.contextPath}/user/viewCountriesPage">Back to log all countries</a>
		</p>
	</div>
	
</body>

</html>