<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!Doctype html>

<html>
<head>
<title>List Customer</title>
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/style.css" />
</head>

<body>
	<div id="wrapper">
		<div id="header">
			<h2>CRM - Customer Relationship Manager</h2>
		</div>
	</div>

	<div id="container">
		<div id="content">

			<!-- put new button : Add button -->

			<input type="button" value="Add Customer"
				onClick="window.location.href='showFormForAdd'; return false;"
				class="add-button" />

			<!-- add out html table here -->
			<table>
				<tr>
					<th>First Name</th>
					<th>Last Name</th>
					<th>Email</th>
					<th>Action</th>
				</tr>

				<!--  loop over and print customer -->
				<c:forEach var="tempCustomer" items="${customers}">

					<!-- construct an "update" link -->
					<c:url var="updateLink" value="/customer/showFormForUpdate">
						<c:param name="customerId" value="${tempCustomer.id }" />
					</c:url>

					<!-- construct an "delete" link -->
					<c:url var="deleteLink" value="/customer/delete">
						<c:param name="customerId" value="${tempCustomer.id }" />
					</c:url>
					<tr>
						<td>${tempCustomer.firstName}</td>
						<td>${tempCustomer.lastName}</td>
						<td>${tempCustomer.email}</td>
						<td><a href="${updateLink}">Update link</a> | <a
							href="${deleteLink}"
							onClick="if(!(confirm('Are you sure you want to delete the customer?'))) return false">Delete
								link</a></td>

					</tr>
				</c:forEach>
			</table>



		</div>
	</div>

</body>

</html>