<!-- Add suport for spring mvc tags -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>

<head>

<title>Add Hotel</title>

<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/style.css">

<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/add-customer-style.css">


</head>

<body>
	<div id="wrapper">
		<div id="header">
			<h2>Travel Agency - Add Hotel</h2>
		</div>
	</div>

	<div id="container">
		<h3>Add hotel:</h3>

			<form:form modelAttribute="hotel" action="processAddHotelFormOne" >

				<!-- need to associate this data with city id (very important) -->
				<form:hidden path="hotelId" />


				<table>
					<tbody>

						<tr>
							<td><label>Hotel name:</label></td>
							<td><form:input path="hotelName" /></td>
							<td><form:errors path="hotelName" cssClass="error" /></td>
						</tr>
						<tr>
							<td><label>Hotel price:</label></td>
							<td><form:input path="hotelPrice" /></td>
							<td><form:errors path="hotelPrice" cssClass="error" /></td>
						</tr>
						<tr>
							<td><label>Rating:</label></td>
							<td><form:input path="rating" /></td>
							<td><form:errors path="rating" cssClass="error" /></td>
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
			<a href="${pageContext.request.contextPath}/user/viewHotelsPage">Back to all hotels</a>
		</p>
	</div>

</body>

</html>