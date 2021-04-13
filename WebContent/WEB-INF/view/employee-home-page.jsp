<!-- Add suport for jstl core tags -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>

<html>

<head>

<title>Home Page</title>

<!-- reference our style sheet -->
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/style.css" />

</head>

<body>

	<div id="wrapper">
		<div id="header">
			<h2>Travel Agency</h2>
		</div>
	</div>

	<div id="container">
		<div id="content">



			<!-- put new button: Log out-->
			<input type="button" value="Log out"
				onclick="window.location.href='logOut'; return false;"
				class="add-button" />

			<!-- put new button: view counties-->
			<input type="button" value="Coutnries"
				onclick="window.location.href='viewCountriesPage'; return false;"
				class="add-button" />

			<!-- put new button: View Cities-->
			<input type="button" value="Cities"
				onclick="window.location.href='viewCitiesPage'; return false;"
				class="add-button" />

			<br>
			
			<!-- put new button: View Hotels-->
			<input type="button" value="Hotels"
				onclick="window.location.href='viewHotelsPage'; return false;"
				class="add-button" />

			<!-- put new button: View Transport-->
			<input type="button" value="Transports"
				onclick="window.location.href='viewTransportsPage'; return false;"
				class="add-button" />

			<!-- put new button: View Transport Type-->
			<input type="button" value="Transport Types"
				onclick="window.location.href='viewTransportTypesPage'; return false;"
				class="add-button" />
			
			<br>
			
			<!-- put new button: View Travels-->
			<input type="button" value="Travels"
				onclick="window.location.href='viewTravelsPage'; return false;"
				class="add-button" />

			<!-- put new button: View Users-->
			<input type="button" value="Users"
				onclick="window.location.href='viewUsersPage'; return false;"
				class="add-button" />
			
			<!-- put new button: View Companies-->
			<input type="button" value="Companies"
				onclick="window.location.href='viewCompaniesPage'; return false;"
				class="add-button" />

			
		</div>
	</div>

</body>
</html>