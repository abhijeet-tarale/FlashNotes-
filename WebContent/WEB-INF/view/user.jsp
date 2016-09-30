<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8">
    <title>Flash Notes | Profile</title>
	<link rel=icon href="<c:url value="/resources/favicon/64.ico" />">
    <%@ include file="staticFiles.jsp" %>
    <style>
		body {
			background: rgb(0,30,30);
		}
    </style>
  </head>
  <body>
	<%@ include file="Header.jsp" %>
	
	<div class="container-fluid">
		<div class="col-md-12">
			<div class="row">
				<div class="text-center col-md-10 col-md-offset-1" style="color:white;">
					<h1 class="glyphicon glyphicon-user">
						<span class="h1">User Profile</span>
					</h1>
				</div>
			</div>
			<hr>
			<div class="row col-md-10 col-md-offset-1">
				<h1 class="jumbotron text-center" style="background-color:#C89614;color:black;"><span class="glyphicon glyphicon-bookmark" ></span> Name: <span id="userName" class="emp-name">  </span> </h1>
				<h2 class="jumbotron col-md-5"> <img src="<c:url value="/resources/images/name-img.jpg" />" width=100px/> ID : <b><span id="userId" class="emp-id text-primary"></span></b></h2>
				<h2 class="jumbotron col-md-6 pull-right" style="height: 130px;"> <img src="<c:url value="/resources/images/cert.jpg" />" width=50px/> Quality Points: <b><span id="userQP" class=" text-primary emp-qp"></span></b></h2>
				<br><br>
				<h2 class="jumbotron col-md-5 text-center" style="left: -150px;"><img src="<c:url value="/resources/images/gift.jpg" />" width=75px/><br><br> No of EMEE Gifts: <b><span id="userEmee" class="text-primary emp-eg"></span></b> </h2>
				
			</div>
			
			
			<div class="row">
			<br><br><br>			
			</div>			
			
		</div>			
	</div>
	
	<div>
	<br><br><br>
	</div>
	
	<div>
	<br><br><br>	
	</div>
	<%@ include file="Footer.jsp" %>
	<script type="text/javascript">
		/* alert(userData.giftCount); */
		/* document.getElementById("userName").innerHTML = userData.userName;
		document.getElementById("userId").innerHTML = userData.userId;
		document.getElementById("userQP").innerHTML = userData.qualityPoint;
		document.getElementById("userEmee").innerHTML = parseInt(userData.qualityPoint / 10, 10); */
		
		$.ajax({url: "user1", success: function(result){
			obj = JSON.parse(result);
	        document.getElementById("userName").innerHTML = obj.userName;
	        document.getElementById("userId").innerHTML = obj.userId;
	        document.getElementById("userQP").innerHTML = obj.qualityPoint;
	        document.getElementById("userEmee").innerHTML = parseInt(obj.qualityPoint / 10, 10);
	    }});
	</script>
  </body>
</html>