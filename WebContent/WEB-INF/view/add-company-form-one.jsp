<!-- Add suport for spring mvc tags -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>

<head>

<title>Add Company</title>

<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/style.css">

<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/add-customer-style.css">


</head>

<body>
	<div id="wrapper">
		<div id="header">
			<h2>Travel Agency - Add Company</h2>
		</div>
	</div>

	<div id="container">
		<h3>Add Company:</h3>

			<form:form action="processAddCompanyFormOne" modelAttribute="company" method="POST">

				<!-- need to associate this data with city id (very important) -->
				<form:hidden path="companyId" />


				<table>
					<tbody>

						<tr>
							<td><label>Company full name:</label></td>
							<td><form:input path="fullName" /></td>
							<td><form:errors path="fullName" cssClass="error" /></td>
						</tr>
						
						<tr>
							<td><label>Company short name:</label></td>
							<td><form:input path="shortName" /></td>
							<td><form:errors path="shortName" cssClass="error" /></td>
						</tr>
						
						<tr>
							<td><label>Email:</label></td>
							<td><form:input path="email" /></td>
							<td><form:errors path="email" cssClass="error" /></td>
						</tr>
						
						<tr>
							<td><label>Phone 1:</label></td>
							<td><form:input path="phone1" /></td>
							<td><form:errors path="phone1" cssClass="error" /></td>
						</tr>
						<tr>
							<td><label>Phone 2:</label></td>
							<td><form:input path="phone2" /></td>
							<td><form:errors path="phone2" cssClass="error" /></td>
						</tr>
						<tr>
							<td><label>NIP:</label></td>
							<td><form:input path="nip" /></td>
							<td><form:errors path="nip" cssClass="error" /></td>
						</tr>

					</tbody>
				</table>
				
				<tr>
					<td><label></label></td>
					<td><input type="submit" value="Next" class="save" /></td>
				</tr>
			</form:form>

		<div style=""></div>
		<p>
			<a href="${pageContext.request.contextPath}/user/viewCompaniesPage">Back to all companies</a>
		</p>
	</div>

</body>

</html>