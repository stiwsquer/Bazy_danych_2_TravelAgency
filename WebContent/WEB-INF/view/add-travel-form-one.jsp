<!-- Add suport for spring mvc tags -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>

<title>Add Travel</title>

<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/style.css">

<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/add-customer-style.css">

<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet"
	href="https://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<script>
	$(function() {
		$("#datepicker1").datepicker();
	});
</script>

<script>
	$(function() {
		$("#datepicker2").datepicker();
	});
</script>
</head>

<body>
	<div id="wrapper">
		<div id="header">
			<h2>Travel Agency - Add Travel</h2>
		</div>
	</div>

	<div id="container">
		<h3>Add Travel:</h3>

		<form:form action="processAddTravelFormOne" modelAttribute="travel">


			
								<form:hidden path="travelId" />
							
							
							
							
								Number of persons:
								<form:input path="numberOfPersons" />
								<form:errors path="numberOfPersons" cssClass="error" />

				<br>
				<br>
								Choose Start Date:
								
								 <form:input path="dateFrom" id="datepicker1" />
								 <form:errors path="dateFrom" cssClass="error" />


				<br>
				<br>
								Choose End Date:
								 <form:input path="dateTill" id="datepicker2" />
								 <form:errors path="dateTill" cssClass="error" />

				<br>
				<br>  
									Add Food to the travel?	
								 <form:select path="food">
										<form:form modelAttribute="foodOptions">
											<form:options items="${foodOptions}" />
										</form:form>
								 </form:select>

				<br>
				<br>

			<tr>
				<td><label></label></td>
				<td><input type="submit" value="Next" class="save" /></td>
			</tr>
		</form:form>

		<div style="clear; both;"></div>
		<p>
			<a href="${pageContext.request.contextPath}/user/userHomePage">Back</a>
		</p>
	</div>

</body>

</html>