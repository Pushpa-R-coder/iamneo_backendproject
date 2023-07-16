<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Bootstrap Card</title>
<meta charset="utf-8">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto:400,700">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
<link href='https://unpkg.com/boxicons@2.0.7/css/boxicons.min.css' rel='stylesheet'>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/5.0.0-alpha1/css/bootstrap.min.css"integrity="sha384-r4NyP46KrjDleawBgD5tp8Y7UzmLA05oM1iAEQ17CSuDqnUK2+k9luXQOfXJCJ4I"crossorigin="anonymous">
<link rel="stylesheet" href="Home.css">
</head>
<br>
<br>
<body style="text-align: center;background-color: #f5f5f5;">
<form action="Update" method="post">
<div class="container mt-3">
<div class="container mt-3" style="width: 500px;">
<div class="card">
<div class="card-body">
<h4 class="card-title mt-3 text-center">Update Data</h4>
<p class="text-muted font-weight-bold ">
</p>
<form>
<div class="form-group input-group">
<input class="form-control" type="text" name="email" value="<%= request.getParameter("email") %>">
</div>
<div class="form-group input-group">
<input type="text" class="form-control" placeholder="Name" id="name" name="name" value="<%= request.getParameter("name") %>">
</div>
<div class="form-group input-group">
<input type="date" class="form-control" placeholder="Date of Birth" id="dob" name="dob" value="<%= request.getParameter("dob") %>">
</div>
<div class="form-group input-group">
<input type="text" class="form-control" placeholder="Address" id="address" name="address" value="<%= request.getParameter("address") %>">
</div>
<div class="form-group input-group">
<input type="tel" class="form-control" placeholder="Phone No" id="phoneNo" name="phoneNo" value="<%= request.getParameter("phoneNo") %>">
</div>
<div class="form-group input-group">
<input type="password" class="form-control" placeholder="Password" id="password" name="password" value="<%= request.getParameter("password") %>">
</div>
<button type="submit" class="btn btn-dark btn-block" id="submit" value="Register" >Update</button>
</form>
</div>
</div>
</div>
</div></form>
</body>
</html>
