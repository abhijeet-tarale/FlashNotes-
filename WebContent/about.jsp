<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8">
    <title>Flash Notes | About Us</title>
    <link rel=icon href="res/favicon/64.ico">
    
    <script type="text/javascript" src="<c:url value="/resources/jQuery/jquery-1.12.1.min.js" />">
    <script	src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.5/angular.min.js"></script>
    <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
    <script	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
    <style>
		body {
			background: rgb(0,30,30);
		}
		.mem-name{
			color:#bfbfbf !important;
			background-color:black;
			color:white;
			position: absolute;
			 opacity: 0.9;
			left: 10px;
			top: 0px;
			width:140px;
			height:160px;
			font-size: 25px;
			visibility:hidden;
			z-index: 1000;
		}
		
    </style>
  </head>
  <body>
  	<nav class="navbar navbar-inverse">
		<div class="container-fluid">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
				<span class="sr-only">Toggle navigation</span>
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>                        
				</button>
			  <a class="navbar-brand" href="home">Flash Notes</a>
			</div>
			
			<div class="collapse navbar-collapse" id="myNavbar">			
			<ul class="nav navbar-nav navbar-right">
			  <li><a href="/FlashNotes/user"><span class="glyphicon glyphicon-user"></span> Profile</a></li>
			  <li><a href="/FlashNotes/logout"><span class="glyphicon glyphicon-log-out"></span> Logout</a></li>     
			  
				<!-- <form class="navbar-form col-xs-10" role="search">
				<div class="input-group">
					<input id="search_txt " type="text" class="form-control col-sm-6" placeholder="Search Courses/Notes" name="q">
					<div class="input-group-btn">
						<button id="search_btn " class="btn btn-default" type="submit" name="search" alt="Search"><i class="glyphicon glyphicon-search glyphicon-search "></i></button>
					</div>
				</div>
				</form> -->			 
		   </ul>
		   </div>
		</div>
	</nav>
	<div class="container-fluid">
		<div class="row text-center">
			<h1 class="jumbotron glyphicon glyphicon-info-sign" style="background-color:rgb(200,150,20);">
				<span style="color:rgb(255,255,255);">
					About FlashNotes
				</span>
			</h1>
		</div>
		<div class="col-md-12">
			<div class="row col-md-8 col-md-offset-2">
				<marquee><h3 class="text-center text-primary">Now, Savor the entire knowledge of a Course in a FLASH!</h3></marquee>
			</div>
			<div class="col-md-2">
			<br><br><br><br>
			</div>
			<br><br><br><br>
			<div class="well col-md-10 col-md-offset-1" style="background-color:rgb(220,255,255);">
				<b><h3 class="text-danger">What is FlashNotes?</h3></strong>
					<p>A User can Upload his/her notes after going through the Knowledge Center (KC) courses.
					A User can go through the notes, rate and also ask any queries related to the notes to the author.
					Any user can answer queries and also rate the answers of other users.
					A user can mark notes as his favorites for quick future reference.
					</p>
				<b><h3 class="text-danger">Why FlashNotes? </h3></b>
					<p>A user gains Quality Points (QP) and rises up on the Leaderboard,
					when he either gets a new like on his notes or when any other user rates his answers to any queries. 
					These QPs are then aggregated to add up to the Users Credit Points. (Say 1 CP for Every 10 QP)
					</p>
			</div>
			<div class="row col-md-10 col-md-offset-1">
				<div class="row">
				<br>
				</div>
				<h1 class="text-center text-danger">
					Members
				</h1>
				<br>
				<div class="row ">
					<div class="members col-md-2" >
						<img class="col-md-offset-1 mem-img" src="<c:url value="/resources/Members/abhijeet_tarale.jpg" />" style="width:128px;height:160px;">
						<span class="col-md-offset-1 mem-name tetx-center" >Abhijeet Tarale </span>
					</div>
					<div class="members col-md-2" >
						<img class="col-md-offset-1 mem-img" src="<c:url value="/resources/Members/akshatha_s.jpg" />" style="width:132px;height:160px;">
						<span class="col-md-offset-1 mem-name" >Akshatha s </span>
					</div>
					<div class="members col-md-2" >
						<img class="col-md-offset-1 mem-img" src="<c:url value="/resources/Members/jahnvi_mahuli.jpg" />" style="width:128px;height:160px;">
						<span class="col-md-offset-1 mem-name" >Jahnvi Mahuli</span>
					</div>
					<div class="members col-md-2" >
						<img class="col-md-offset-1 mem-img" src="<c:url value="/resources/Members/nikhil_patil.jpg" />" style="width:132px;height:160px;">
						<span class="col-md-offset-1 mem-name" >Nikhil Patil</span>
					</div>
					
					<div class="members col-md-2" >					
						<img class="col-md-offset-1 mem-img" src="<c:url value="/resources/Members/ritesh_kumar.jpg" />" style="width:132px;height:160px;">
						<span class="col-md-offset-1 mem-name" >Ritesh Kumar</span>
					</div>
					<div class="members col-md-2" >
						<img class="col-md-offset-1 mem-img" src="<c:url value="/resources/Members/shruti_phatak.jpg" />" style="width:128px;height:160px;">
						<span class="col-md-offset-1 mem-name" >Shruti Phatak</span>
					</div>
				</div>
			</div>
			<div class="row">
			<br><br><br>			
			</div>			
		</div>			
	</div>
	<div class="footer">
		<hr>
		<div class="text-center" align="center">
			<h3 class="glyphicon glyphicon-copyright-mark col-lg-12 text-center" align="center">
			<a class="pull-left btn-link btn-lg glyphicon glyphicon-info-sign"
					href="about.jsp" >About</a>  Managers of Mayhem 
			<a	class="pull-right btn-link btn-lg glyphicon glyphicon-question-sign "
					href="#">Help</a>		
			</h3>	
		</div>
	</div>
		
	<script>
		$(document).ready(function(){
			$(".mem-img").hover(function(){	
					clearTimeout($(this).data('timeout'));
					$(".mem-name").css("visibility","visible");				
			},function(){	
				var t = setTimeout(function() {
				$(".mem-name").css("visibility","hidden");
				}, 500);
				$(this).data('timeout', t);
			});
		});
	</script>
  </body>
</html>