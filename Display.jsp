<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List" %>
<%@ page import="iamneo.model.Project" %>
<%@ page import="iamneo.dao.ProjectDAO" %>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Bootstrap Card</title>
<meta charset="utf-8">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" href="registeradmin.css">
<link href='https://unpkg.com/boxicons@2.0.7/css/boxicons.min.css' rel='stylesheet'>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="search.css">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/5.0.0-alpha1/css/bootstrap.min.css"integrity="sha384-r4NyP46KrjDleawBgD5tp8Y7UzmLA05oM1iAEQ17CSuDqnUK2+k9luXQOfXJCJ4I"crossorigin="anonymous">
</head>

<script>
function search() {
	let input = document.getElementById('searchbar').value.toLowerCase();
	let rows = document.getElementsByClassName('table-row');
	for (let i = 0; i < rows.length; i++) {
		let rowData = rows[i].innerText.toLowerCase();
		if (!rowData.includes(input)) {
			rows[i].classList.add('hide');
		} else {
			rows[i].classList.remove('hide');
		}
	}
}
</script>

<body>
<section  class="section1">
<div><h1>USER DATA</h1></div></section>
<br>
<section  class="section1">
<div class="container mt-3">
<div class="container mt-3" style="width: 1200px;">
<div class="card">
<div class="card-body">
<table ><tr>
<td style="padding-right: 40px;"><input id="searchbar" onkeyup="search()" type="text" name="search" placeholder="Search here"></td>
<td style="padding-left: 670px;"><button type="button" class="btn btn-primary float-end"><svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-plus" viewBox="0 0 16 16">
<path d="M8 4a.5.5 0 0 1 .5.5v3h3a.5.5 0 0 1 0 1h-3v3a.5.5 0 0 1-1 0v-3h-3a.5.5 0 0 1 0-1h3v-3A.5.5 0 0 1 8 4z"/>
</svg><a style="color:white;" href="Home.html">Create New Data</a></button></td>
</tr>
</table><br>
<table class="table table">
<thead>
<tr>
<th>Name</th>
<th>Email</th>
<th>Date of Birth</th>
<th>Address</th>
<th>Phone No</th>
<th>Password</th>
<th ><pre></pre>Action</th>
</tr>
</thead>
<tbody>
<% 
ProjectDAO projectDAO = new ProjectDAO();
List<Project> projectList = projectDAO.Display();
for (Project project : projectList) {
%>
<tr class="table-row">
<td  ><%= project.getName() %></td>
<td ><%= project.getEmail() %></td>
<td ><%= project.getDob() %></td>
<td><%= project.getAddress() %></td>
<td ><%= project.getPhoneNo() %></td>
<td ><%= project.getPassword() %></td>
<td >
<form method="post" action="Delete">
<input type="hidden"  name="email" value="<%= project.getEmail() %>">
<input type="submit" style="background-color:red;color:white;" value="Del">
</form>
<form method="get" action="Update.jsp">
<input type="hidden" name="email" value="<%= project.getEmail() %>">
<input type="submit" style="background-color:blue;color:white;" value="Edit">
</form>
</td>
</tr>
<%}%>
</tbody>
</table>
</div></div></div>
</div></section>
</body>
</html>
