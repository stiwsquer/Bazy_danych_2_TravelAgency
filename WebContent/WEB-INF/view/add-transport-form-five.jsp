<!-- Add suport for jstl core tags -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>

<html>

<head>

	<title> Select Company</title>

	<!-- reference our style sheet -->
	<link type = "text/css"
		  rel = "stylesheet"
		  href = "${pageContext.request.contextPath}/resources/css/style.css" />
	
</head>

<body>
	
	<div id = "wrapper">
		<div id="header">
			<h2>Travel Agency - Select Company for new Transport</h2>
		</div>
	</div>
	
	<div id="container">
		<div id="content">
			
			<h3>Select Company:</h3>
			
			<!-- add our html table here -->
			<table>
			
				<tr>
				 	<th>Company Name </th>
				 	<th>Action</th>
				</tr>
				
				<!-- loop over and print our customers -->
				<c:forEach var="tempCompany" items="${companies}">
					
					<!-- construct an "update" link with country id -->
					<c:url var="selectLink" value="/user/processAddTransportFormFive">
						<c:param name="companyId" value="${tempCompany.companyId}" />
					</c:url>
					
					
					
					<tr> 
						<td> ${tempCompany.fullName} </td>
					
						<td> 
							<!-- display the select link -->
							<a href="${selectLink}">Select</a>
						</td>
					</tr>
					
				</c:forEach>
				
			</table>
			<div style = "clear; both;" >  </div>
			<p> 
				<a href="${pageContext.request.contextPath}/user/processAddTransportFormOne">Back to start</a>
			</p>
		</div>
	</div>
	
</body>
</html>