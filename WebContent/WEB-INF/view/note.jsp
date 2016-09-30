<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Flash Notes | Note</title>
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
	.form-control{
		height: 34px;
	}
	span{
		color:#bfbfbf !important;
	}
	input,label,button,h1,textarea{
		background-color:transparent !important;
		font-weight: inherit;
		color: #bfbfbf !important;	
	}
	#edit-btn{
		visibility: hidden;
	}
	#noteSubmitBtn{
		visibility: hidden;
	}
	#updateNoteBtn{
		visibility: hidden;
	}
    </style>
  </head>
  <body>
	
	<%@ include file="Header.jsp" %>
	
	<div class="container-fluid">
		<div class="note-container">	
			<div class="col-lg-9 col-md-9 col-lg-offset-1 col-md-offset-1 ">
				<div class = "note-name-rating row">
					<h1 id="note-name" data-toggle="tooltip" title="Note Heading"class="col-xs-6 "><strong></strong></h1>
					<h1 id="note-likes" data-toggle="tooltip" title="Number of likes" class="glyphicon glyphicon-star pull-right col-xs-6" align="right">Rating</h1>
				</div>
				<textarea class="form-control" rows="10" cols="115" name="noteBody" id="noteBody" readonly="readonly" data-toggle="tooltip" title="Note body"></textarea>
				<br>
				<button id="updateNoteBtn" class="btn btn-primary btn-lg" style="float: right;" data-toggle="tooltip" title="Update Notes">
					Update Note
				</button>
				<!-- Button trigger modal data-toggle="modal" data-target="#myModal" -->
				<!-- <div id="ncdiv" class="embed-responsive embed-responsive-16by9">			
					<embed id="note-content" class="embed-responsive-item" align="middle" width="800px" height="700px">
					<object class="embed-responsive-item" data="doc.pdf" type="application/pdf" width="800px" height="700px">
								 
								  <p>It appears you don't have a PDF plugin for this browser.
								  No biggie... you can <a href="doc.pdf">click here to
								  download the PDF file.</a></p>
								  
					</object>
				</div> -->
				
				<div>
					<br>
					<br>
				</div>
			
				<div class="panel panel-default" align="center" style="background-color: transparent; border-color: transparent;">
					<div class="panel-body text-center">
						
						<a  id="queriesBtn" href="">
							<button type="button" class="btn btn-default col-xs-3" style="float: left;" data-toggle="tooltip" title="Ask Queries">Queries</button>
						</a>

						<button id="edit-btn" type="button" class="btn btn-default col-xs-3" style="float: none;" data-toggle="tooltip" title="Edit Note">Edit Note</button>

						<!-- <a id="updateLikeBtn" href=""> -->
						<button id="likeBtn" type="button" class="btn btn-default col-xs-3 glyphicon glyphicon-thumbs-up" style="float: right;" data-toggle="tooltip" title="Like Note">Like</button>
						<!-- </a> -->
					</div>
				</div>			
				
				<h2 class="well row" style="background-color: orange;">Comments Section</h2>
				<div class="comments">
					<div class="panel panel-default">
						<div id="commentSection" class="panel-body" style="background-color : white;">
						</div>
					</div>
					<div class="input-group col-xs-12">
						<form id="commentFormId" action="" method="post">
							<textarea required id="comment" name="comment" class="form-control" rows="5" placeholder="Your Comment goes here"></textarea>
							<br>					
							<button id="commentBtn" class="btn btn-default" type="submit" style="float: right;" data-toggle="tooltip" title="Add your Comment">Comment</button>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
	<hr>
	<div class="footer">
		<div class="panel-body text-center" align="center">
			<h3 class="glyphicon glyphicon-copyright-mark col-lg-12 text-center" align="center">
			<a class="pull-left btn-link btn-lg glyphicon glyphicon-info-sign"
					href="#" data-toggle="tooltip" title="About us">About</a>  Managers of Mayhem 
			<a	class="pull-right btn-link btn-lg glyphicon glyphicon-question-sign "
					href="#" data-toggle="tooltip" title="Help">Help</a>		
			</h3>	
		</div>
	</div>
	
	<script>
	$(document).ready(function(){
		$("#note-name").html(${note}.noteHeading);
		$("#note-likes").html(${note}.likes);
		$("#noteBody").html(${note}.noteBody);
		if(${loggedInUser} == ${note}.user.userId){
			$("#edit-btn").css("visibility", "visible");
		}
		$("#edit-btn").click(function(){
			$("#noteBody").removeAttr("readonly");
			$("#noteSubmitBtn").css("visibility", "visible");
			$("#updateNoteBtn").css("visibility", "visible");
		});
		
		/* $("#formSubmit").attr("action","../editNotes/" + ${note}.noteId); */
		
		/* $("#updateLikeBtn").attr("href","../updateLikes1/" + ${note}.noteId); */

		$("#queriesBtn").attr("href","../getAllQueries/" + ${note}.noteId);

		//$("#commentFormId").attr("action","../addComment/" + ${note}.noteId);
		
		for(var i = 0; i < ${commentList}.length; i++){
			$("#commentSection").append(" <h4>" + ${commentList}[i].user.userName + "</h4><p>" + ${commentList}[i].comment + "</p>");
		}
		
		$("#likeBtn").click(function () {
			$.get({url: "../updateLikes1/" + ${note}.noteId, success: function(result){
				window.location.reload(true);
				//$("#note-likes").html(result.noteId);
		    }});
		});
		
		$("#commentBtn").click(function () {
			
			$.post({url: "../addComment1/" + ${note}.noteId, data: {comment: $("#comment").val()},success: function(result){
				window.location.reload(true);
		    }});
		});
		
		$("#updateNoteBtn").click(function () {
			$.post({url: "../editNotes1/" + ${note}.noteId, data: {noteBody: $("#noteBody").val()},success: function(result){
				window.location.reload(true);
		    }});
		});
	});
	
	
	</script>
  </body>
</html>