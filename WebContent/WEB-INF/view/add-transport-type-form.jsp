<!-- Add suport for spring mvc tags -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>

<head>

<title>Price</title>

<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/style.css">

<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/add-customer-style.css">


</head>

<body>
	<div id="wrapper">
		<div id="header">
			<h2>Travel Agency - Add Transport Type</h2>
		</div>
	</div>

	<div id="container">
		<h3>Add Transport Type:</h3>

			<form:form action="processAddTransportTypeForm" modelAttribute="transportType" >

				<!-- need to associate this data with city id (very important) -->
				<form:hidden path="transportTypeId" />


				<table>
					<tbody>

						<tr>
							<td><label>Transport Type Name:</label></td>
							<td><form:input path="transportTypeName" /></td>
							<td><form:errors path="transportTypeName" cssClass="error" /></td>
						</tr>

					</tbody>
				</table>
				
				<tr>
					<td><label></label></td>
					<td><input type="submit" value="Submit" class="save" /></td>
				</tr>
			</form:form>

		<div style=""></div>
		<p>
			<a href="${pageContext.request.contextPath}/user/viewTransportTypesPage">Back start</a>
		</p>
	</div>

</body>

</html>