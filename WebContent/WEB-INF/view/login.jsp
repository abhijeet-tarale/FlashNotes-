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
					Welcome to Flash Notes
				</h1>
			</div>
		</div>
		<div>
			<br> <br>
		</div>
		<div class="container">
			<div class="Content">
				<form action="login" id="login-form" method="POST">
	
					<div class="form-group">
						<div class="col-md-4 col-md-offset-4">
							<div class="input-group input-group-lg">
								<span class="input-group-addon" id="sizing-addon1">Username</span> <input id="username" name="username" type="text" class="form-control"
									placeholder="Username" autofocus required
									title="ex. firstname_lastname">
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
					<div class="row">
						<div class="text-danger text-center">
							<p id="errorMsg">${errorMsg}</p>
						</div>
					</div>
					<div class="form-group">
						<div class="col-md-4 col-md-offset-4 text-center">
							<div class="btn-group btn-group-lg" role="group">
								<button id="login" type="Submit" class="btn btn-primary">Login</button>
								<button id="reset" type="reset" class="btn btn-danger">Reset</button>
							</div>
						</div>
					</div>
				</form>
			</div>
		</div>
		<div class="clearfix">
			</br></br>
		</div>
		<div class="text-center">
			<a href="signUp"><button id="signUp" class="btn btn-success">Click here to Sign Up</button></a>
		</div>
		<div class="footer">
			<div class="col-md-6 col-md-offset-3">
				<a class="pull-left btn-link btn-lg glyphicon glyphicon-info-sign"
					href="#">About</a> <a
					class="pull-right btn-link btn-lg glyphicon glyphicon-question-sign"
					href="#">Help</a>
			</div>
		</div>
	
		<script>
		
		$(document).ready(function() {

			/* $("#errorMsg").html(${errorMsg}); */
			
			$("#rem_me").click(	function() {
				$("#rem_me_resp").text(
					$("#rem_me_resp").text() == 'No' ? 'Yes' : 'No');
			});

			$("#reset").click(function() {
				$("#userID").val() = " ";
				$("#password").val() = " ";
			});
		});
		
		</script>
	</body>
</html>