<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Flash Notes | Login</title>
		<link rel=icon href="<c:url value="/resources/favicon/64.ico" />">
	   	<%@ include file="staticFiles.jsp" %>
	</head>
	<body>
		<div class="page-header">
			<div class="jumbotron" style="background-color:rgb(200,150,20);">
				<h1 id="wtfn" class="text-center">
					Add a New User
				</h1>
			</div>
		</div>
		<div>
			<br><br>
		</div>
		<div class="container">
			<div class="Content">
				<form action="addLogin" id="login-form" method="POST">
	
					<div class="form-group">
						<div class="col-md-4 col-md-offset-4">
							<div class="input-group input-group-lg">
								<span class="input-group-addon" id="sizing-addon1">Username</span> <input id="username" name="username" type="text" class="form-control"
									placeholder="Username" autofocus required
									title="Domain Username">
							</div>
						</div>
						<div>
							<br><br><br>
						</div>
					</div>
	
					<div class="row form-group">
						<div class="col-md-4 col-md-offset-4">
							<div class="input-group input-group-lg">
								<span class="input-group-addon" id="sizing-addon1" for="password">Password</span>
								<input id="password"  name="password" type="password" class="form-control"
									placeholder="Password" required>
							</div>
						</div>
					</div>

					<!-- <div class="row form-group">
						<div class="col-md-4 col-md-offset-4">
							<div class="input-group input-group-lg">
								<span class="input-group-addon" id="sizing-addon1" for="password">Confirm Password</span>
								<input id="password2"  name="password2" type="password" class="form-control"
									placeholder="Confirm Password" required>
							</div>
						</div>
					</div> -->
					<div class="row">
						<div class="text-danger text-center">
							<p id="errorMsg">${errorMsg}</p>
						</div>
					</div>
					<div class="form-group">
						<div class="col-md-4 col-md-offset-4 text-center">
							<div class="btn-group btn-group-lg" role="group">
								<button id="signUpBtn" type="Submit" class="btn btn-primary">Submit</button>
							</div>
						</div>
					</div>
				</form>
			</div>
		</div>
		<div class="clearfix">
			</br> </br> </br> </br> </br> </br>
		</div>
		<div class="footer">
			<div class="col-md-6 col-md-offset-3">
				<a class="pull-left btn-link btn-lg glyphicon glyphicon-info-sign"
					href="#">About</a> <a
					class="pull-right btn-link btn-lg glyphicon glyphicon-question-sign"
					href="#">Help</a>
			</div>
		</div>
		
		<!-- <script type="text/javascript">
		
		$("#password2").blur(function (){
			alert($("#password1").val());
			alert($("#password2").val());
			if($("#password1").text() == $("#password2").text()){
				$("#password1").val() = "";
				$("#password2").val() = "";
				alert("Passwords do not Match!");
			}
		});
		</script> -->
	</body>
</html>