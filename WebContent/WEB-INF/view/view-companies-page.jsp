<!-- Add suport for jstl core tags -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>

<head>

	<title> View Companies</title>

	<!-- reference our style sheet -->
	<link type = "text/css"
		  rel = "stylesheet"
		  href = "${pageContext.request.contextPath}/resources/css/style.css" />
	
</head>

<body>
	
	<div id = "wrapper">
		<div id="header">
			<h2>Travel Agency - View Companies</h2>
		</div>
	</div>
	
	<div id="container">
		<div id="content">
			
			<!-- put new button: Add Country -->
			<input type="button" value="Add Company" 
				   onclick="window.location.href='addCompanyFormOne'; return false;" 
				   class = "add-button"
			/> 
			
		
			
			<h3>Companies:</h3>
			
			<!-- add our html table here -->
			<table>
			
				<tr>
				 	<th>City Name </th>
				 	<th>Company Full Name </th>
				 	<th>Company Short Name </th>
				 	<th>Email</th>
				 	<th>Phone 1</th>
				 	<th>Phone 2</th>
				 	<th>NIP</th>
				 	<th>Action</th>
				</tr>
				
				<!-- loop over and print our customers -->
				<c:forEach var="tempCompany" items="${companies}">
					
					<!-- construct an "update" link with country id -->
					<c:url var="updateLink" value="/user/updateCompanyForm">
						<c:param name="companyId" value="${tempCompany.companyId}" />
					</c:url>
					
					<!-- construct an "delete" link with country id -->
					<c:url var="deleteLink" value="/user/deleteCompany">
						<c:param name="companyId" value="${tempCompany.companyId}" />
					</c:url>
					
					<tr> 
						<td> ${tempCompany.city.cityName} </td>
						<td> ${tempCompany.fullName} </td>
						<td> ${tempCompany.shortName} </td>
						<td> ${tempCompany.email} </td>
						<td> ${tempCompany.phone1} </td>
						<td> ${tempCompany.phone2} </td>
						<td> ${tempCompany.nip} </td>
						<td> 
							<!-- display the update link -->
							<a href="${updateLink}">Update</a>
							|
							<!-- display the delete link -->
							<a href="${deleteLink}"
							   onclick="if(!(confirm('Are you sure you want to delete this Company?'))) return false">Delete</a>
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