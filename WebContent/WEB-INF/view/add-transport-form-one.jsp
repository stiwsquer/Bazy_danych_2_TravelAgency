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
			<h2>Travel Agency - Add Price</h2>
		</div>
	</div>

	<div id="container">
		<h3>Add price of the transport:</h3>

			<form:form action="processAddTransportFormOne" modelAttribute="transport" >

				<!-- need to associate this data with city id (very important) -->
				<form:hidden path="transportId" />


				<table>
					<tbody>

						<tr>
							<td><label>Price:</label></td>
							<td><form:input path="transportPrice" /></td>
							<td><form:errors path="transportPrice" cssClass="error" /></td>
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
			<a href="${pageContext.request.contextPath}/user/viewTransportsPage">Back start</a>
		</p>
	</div>

</body>

</html>