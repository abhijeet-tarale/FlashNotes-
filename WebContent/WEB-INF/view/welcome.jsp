<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8">
    <title>Welcome to Flash Notes</title>
    <link rel=icon href="<c:url value="/resources/favicon/64.ico"/>">
	<link rel=icon href="<c:url value="/resources/favicon/64.ico" />">
    <%@ include file="staticFiles.jsp" %>
    <style>
      body {
        background: url(res/images/lgo.png) rgb(0,30,30);
        background-repeat: no-repeat;
        background-clip: border-box;
        background-position: top;
        background-size: auto;

      }
    </style>
    
  </head>
  <body>
	<%@ include file="Header.jsp" %>
	<hr>
	<div class="container-fluid">
		<div class="col-md-8">
			<div class="row">
				<div class="text-center text-danger col-md-8 col-md-offset-2">
					<h1 class="jumbotron" style="background-color:rgb(200,150,20);">
						Available Courses
					</h1>
				</div>
			</div>
			<hr><br>
			<div class="row" id="topCourses">
			</div>
			<br><br><br>
			<div class="row text-center">
					<a href="getAllCourse">
						<button class="btn btn-success btn-lg btn-lg" data-toggle="tooltip" title="view all courses">
								View All Courses
						</button>
					</a>
			</div>
		</div>
		
		<div class="container col-md-4">
			<div class="well" style="background-color:rgb(200,50,20); border:2px">
				<div class="h1 well well-lg text-center text-danger">
				Top Members<span class="glyphicon glyphicon-education pull-right" aria-hidden="true"></span>
				</div>
				<div id="topMembersSection">
					
				</div>
			</div>
		</div>
	</div>
	
	<!-- Footer Code -->
	
	<%@ include file="Footer.jsp" %>
	
	<!-- /Footer Code -->
	<script type="text/javascript">
		/* alert("Members: " + ${topMembers});
		alert("Courses: " + ${courseList}); */

		for(var i = 0; i < ${topMembers}.length; i++){
			$("#topMembersSection").append("<div class=\"well h4\"><span class=\"glyphicon glyphicon-user pull-left\"> " + ${topMembers}[i].userName + " </span><span data-toggle=\"tooltip\" title=\"Quality Points\" class=\"glyphicon glyphicon-star pull-right\"> " + ${topMembers}[i].qualityPoint + " </span><br></div>");
		}
		
		for(var i = 0; i < ${courseList}.length; i++){
			$("#topCourses").append("<div class=\"well col-md-3 col-md-offset-1 text-center\"><br><br><br><a href=\"getCourseById/" + ${courseList}[i].courseId +"\"><h2 id=\"course" + ${courseList}[i].courseId + "\">" + ${courseList}[i].courseName + "</h2></a><br><br><br></div>");
		}
	</script>
  </body>
</html>

