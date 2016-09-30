<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Flash Notes | Login</title>
	
		<link href="<c:url value="/resources/css/normalize.css" />" rel="stylesheet">
		<link href="<c:url value="/resources/css/bootstrap.css" />" rel="stylesheet">
	    <script src="<c:url value="/resources/js/bootstrap.js" />"></script>
	    <script src="<c:url value="/resources/jQuery/jquery-1.12.1.min.js" />"></script>
	    <script src="<c:url value="/resources/jQuery/jquery.validate.min.js" />"></script>
	</head>
	<body>
		<div class="page-header">
			<div class="jumbotron">
				<h1 id="wtfn" class="text-center">Welcome to Flash Notes</h1>
			</div>
		</div>
		<div>
			<br> <br> <br> <br>
		</div>
		<div class="container">
			<div class="Content">
				<form action="login" id="login-form">
	
					<div class="form-group">
						<div class="col-md-4 col-md-offset-4">
							<div class="input-group input-group-lg">
								<span class="input-group-addon" id="sizing-addon1">User
									ID</span> <input id="trans_un" name="trans_un" type="text" class="form-control"
									placeholder="UserID (must be numeric)" autofocus required
									pattern="\d+" title="UserId must be numeric">
							</div>
						</div>
						<div>
							<br><br><br>
						</div>
					</div>
	
					<div class="form-group">
						<div class="col-md-4 col-md-offset-4">
							<div class="input-group input-group-lg">
								<span class="input-group-addon" id="sizing-addon1" for="password">Password</span>
								<input id="trans_pass"  name="trans_pass" type="password" class="form-control"
									placeholder="Password" required>
							</div>
						</div>
					</div>
					<div>
						</br> </br> </br>
					</div>
					<div class="form-group">
						<div class="col-md-4 col-md-offset-4">
							<div class="input-group input-group-lg">
								<span id="rem_me_span" class="input-group-addon"> <input
									id="rem_me" type="checkbox" class="input-group-addon"
									value="remember me" onclick="changeText(this.id);"> </span> <label
									id="rem_me_label" for="rem_me" type="text" class="form-control"
									aria-label="...">Remember me ? <label id="rem_me_resp">No</label>
								</label>
							</div>
						</div>
					</div>
					<div>
						</br> </br>
					</div>
					<div class="form-group">
						<div class="col-md-4 col-md-offset-4">
							<div class="btn-group btn-group-lg" role="group">
								<button id="login" type="Submit" class="btn btn-default">Login</button>
								<button id="reset" type="reset" class="btn btn-default">Reset</button>
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
	
		<script>
			$(document).ready(function() {
				$("#rem_me").click(	function() {
					$("#rem_me_resp").text(
						$("#rem_me_resp").text() == 'No' ? 'Yes' : 'No');
				});
	
				$("#reset").click(function() {
					$("#userID").val() = " ";
					$("#password").val() = " ";
	
				});
	
				/* $("#login").click(function() {			
				
				 var username=$("#userID").val();
				 var password=$("#password").val();
	
				 if(username=="")
				 {
				 $('#dis').slideDown().html("<span>Please type Username</span>");
				 return false;
				 }
				 if(password=="")
				 {
				 $('#dis').slideDown().html('<span id="error">Please type Password</span>');
				 return false;
				 }
				 });  */
	
			});
		</script>
	</body>
</html>