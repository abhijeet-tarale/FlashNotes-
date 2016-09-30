<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8">
    <title>Flash Notes | Notes</title>
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
		a {
			font: bold;
			text-decoration: blink;
			color: maroon;
		}
	    .form-control{
			height: 34px;
		}
		.panel-sm{
			boder-color:white;
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
						Notes on <b><span id="courseName" style="color: white;"></span></b>
					</h1>
				</div>
			</div>
			<hr><br>
			
			<div id="notesContainer" class="row col-md-12"></div>
		</div>
	</div>			
	
	
	<!-- <div class="row col-md-2 col-xs-10 col-md-offset-5 col-xs-offset-1 text-center">	
		<button id="create-note-btn" name="create-note" class="btn btn-primary btn-lg btn-block ">
			Create Note
		</button>
	</div -->>
	
	
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
			$("#courseName").html(${noteList}[0].course.courseName);
			for(var i = 0; i<${noteList}.length;i++){
				var id = ${noteList}[i].noteId;
				var noteHeading = ${noteList}[i].noteHeading; 
				$("#notesContainer").append("<div id=\"note\"" + id + "\" class=\"well col-md-2 col-md-offset-1 col-xs-10 col-xs-offset-1 text-center \"><h3 style=\"rgb(0,30,30);\"><a href=\"../getNotesById/" + id + "\">" +noteHeading+ "</a></h3><span class=\"glyphicon glyphicon-eye-open\" aria-hidden=\"true\" style=\"float:left;\"> " +${noteList}[i].noOfViews+ "</span><span class=\"glyphicon glyphicon-thumbs-up\" aria-hidden=\"true\" style=\"float:right;\"> " +${noteList}[i].likes+ "</span><br></div>");
			}
		});
	</script>
  </body>
</html>

