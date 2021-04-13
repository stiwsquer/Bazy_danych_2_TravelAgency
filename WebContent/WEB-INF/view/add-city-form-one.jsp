<!-- Add suport for spring mvc tags -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>

<head>

<title>Add City</title>

<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/style.css">

<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/add-customer-style.css">


</head>

<body>
	<div id="wrapper">
		<div id="header">
			<h2>Travel Agency - Add City</h2>
		</div>
	</div>

	<div id="container">
		<h3>Add city:</h3>

			<form:form action="processAddCityFormOne" modelAttribute="city" method="POST">

				<!-- need to associate this data with city id (very important) -->
				<form:hidden path="cityId" />


				<table>
					<tbody>

						<tr>
							<td><label>City name:</label></td>
							<td><form:input path="cityName" /></td>
							<td><form:errors path="cityName" cssClass="error" /></td>
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
			<a href="${pageContext.request.contextPath}/user/viewCitiesPage">Back to all cities</a>
		</p>
	</div>

</body>

</html>