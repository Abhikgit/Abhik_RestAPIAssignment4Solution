<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css"
	integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS"
	crossorigin="anonymous">

<title>Employees Directory</title>
</head>

<body>

	<div class="container">

		<h3>Employees Directory</h3>
		<hr>

        <c:url var="addUrl" value = "/employee/add-begin" />

		<!-- Add a button -->
		<a href="${addUrl}"
			class="btn btn-primary btn-sm mb-3"> Add Employee </a> 
        
        
        <c:url var="logoutUrl" value = "/logout" />
        
		<a href="${logoutUrl}" 
				class="btn btn-primary btn-sm mb-3 mx-auto"> Logout </a> 

        

		<table class="table table-bordered table-striped">
<thead class="thead-dark">
				<tr>
					<th>FirstName</th>
					<th>LastName</th>
					<th>Email</th>
					<th>Action</th>
				</tr>
			</thead>

			<tbody>
				<c:forEach items="${employees}" var="tempEmployee">
					<tr>
						<td><c:out value="${tempEmployee.firstName}" /></td>
						<td><c:out value="${tempEmployee.lastName}" /></td>
						<td><c:out value="${tempEmployee.email}" /></td>
                        

                        <td>
							<!-- Add "update" button/link --> 
                            
                            <c:url var="updateUrl" value="/employee/update-begin?employee Id=${tempEmployee.id}" />
                            
                            <a
							href="${updateUrl}"
							class="btn btn-info btn-sm"> Update 
                            </a> 
                                  
                            
                            <c:url var="deleteUrl" value="/employee/delete?employeeId=${tempEmployee.id}" />
                            
							<a href="${deleteUrl}"
							class="btn btn-danger btn-sm"
							onclick="if (!(confirm('Are you sure you want to delete this Employee?'))) return false">
								Delete 
                            </a>
                            

						</td>

                        
					</tr>
				</c:forEach>

			</tbody>
		</table>

	</div>

</body>
</html>
