<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8">
    <title>Flash Notes | Courses</title>
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
				<div class="text-center text-danger col-md-10 col-md-offset-1 ">
					<h1 class="jumbotron" style="background-color:rgb(200,150,20);">
						Available <span style="color: white;">Courses</span>
					</h1>
				</div>
			</div>
			<hr><br>
			
			<div class="row col-md-12">
				<div id="courseContainer"></div>
			</div>
		</div>
	</div>
	<div>
	<br><br><br>
	<br><br><br>
	</div>
	<hr>
	<div class="footer " >
		<div class="panel-body text-center" align="center">
			<h3 class="glyphicon glyphicon-copyright-mark col-lg-12 text-center" align="center">
			<a class="pull-left btn-link btn-lg glyphicon glyphicon-info-sign"
					href="#" data-toggle="tooltip" title="About us">About</a>  Managers of Mayhem 
			<a	class="pull-right btn-link btn-lg glyphicon glyphicon-question-sign "
					href="#" data-toggle="tooltip" title="Help">Help</a>		
			</h3>	
		</div>
	</div>
	
	<script type="text/javascript">
		$(document).ready(function(){
			for(var i = 0; i<${courseList}.length;i++){
				var id = ${courseList}[i].courseId;
				var courseName = ${courseList}[i].courseName; 
				$("#courseContainer").append("<a href=\"getCourseById/" + id + "\"><div id=\"course\""+id+"\" style=\"color:#800000;\" class=\"well col-md-2 col-xs-10 col-xs-offset-1 text-center text-primary\"><h3>" +courseName+ "</h3><br></div></a>");
			}
		});
	</script>
	
	</body>
</html>

