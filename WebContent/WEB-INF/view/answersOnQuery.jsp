<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8">
    <title>Flash Notes | Answers</title>
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
		input,label,h1,textarea{
			background-color:transparent !important;
			font-weight: inherit;
			color: #bfbfbf !important;	
		}
    </style>
    <script type="text/javascript">
	   $(function() {
	       $( "#accordion" ).accordion();
	     });
    </script>
  </head>
  <body>
	
	<%@ include file="Header.jsp" %>
	<div class="container-fluid">
		<div class="col-lg-9 col-md-9 col-lg-offset-1 col-md-offset-1">
			<div class = "answers-name-rating row">
				<!-- <h1 class="col-xs-6 glyphicon"><strong>Answers<span class="glyphicon glyphicon-question-sign"></span></strong></h1> -->	
				<a href="javascript:history.back()"> Return Back to Queries</a>
			</div>
			<div class="row">
				<h3 style="color:white;">Query:</h3>
				<div class="query well">
					<p id="query"></p>
				</div>
			</div>
			
			<h3 style="color:white;">Answers</h3>
			<div id="answerContainer">
				<!-- <div class="row panel panel-primary one-answer-container">
					<div class="answer panel-body col-xs-9 pull-left">
						<p id="answer1">Dummy Answer</p>
					</div>
					<div class="well panel-body col-xs-3 text-center">
						<h4 >Likes :<span id="like1"> 5</span></h4>
						<button id="likeBtn1" type="button" class="btn btn-primary col-xs-5 glyphicon glyphicon-thumbs-up" style="float: none;"> Like</button>
					</div>
				</div> -->
			</div>
			
			<div class="input-group col-xs-12">
				<!-- <form id="ansFormId" action="" method="post"> -->
					<textarea required id="answer" name="answer" class="form-control" rows="5"  placeholder="Your Answer"></textarea>
					<br><br><br><br>
					<button id="answerBtn" class="btn btn-default" type="submit" style="float: right;" data-toggle="tooltip" title="Post your answer">Post Answer</button>
				<!-- </form> -->
			</div>
		</div>
	</div>
	<hr>
	<div class="footer " >
		<div class="panel-body text-center" align="center">
			<h3 class="glyphicon glyphicon-copyright-mark col-lg-12 text-center" align="center">
			<a class="pull-left btn-link btn-lg glyphicon glyphicon-info-sign"
					href="#" data-toggle="tooltip" title="About us ">About</a>  Managers of Mayhem 
			<a	class="pull-right btn-link btn-lg glyphicon glyphicon-question-sign "
					href="#" data-toggle="tooltip" title="Help">Help</a>
			</h3>
		</div>
	</div>
	
	<script>
	
	function updateLike(id) {
		$.get({url: "../updateAnswerLikes1/" + id,success: function(result){
			
			location.reload(true);
	    }, failure: function(result){
	    	window.location.reload(true);
	    }
		});
	}
	
	$(document).ready(function(){
		
		/* function updateLike(id) {
			alert("Btn Clicked!");
			$.get({url: "../updateAnswerLikes1/" + id,success: function(result){
				alert("Pass");
				window.location.reload(true);
		    }, failure: function(result){
		    	alert("Fail");
		    	window.location.reload(true);
		    }
			});
		} */
		
		$("#query").html(${query}.question);
	/* 	$("#ansFormId").attr("action", "../addAnswer/" + ${query}.queryId); */
		for(var i=0; i<${answerList}.length; i++){
			$("#answerContainer").append("<div class=\"row panel panel-primary one-answer-container\"><div class=\"answer panel-body col-xs-9 pull-left\"><p id=\"answer"+ ${answerList}[i].answerId +"\">"+ ${answerList}[i].answerContent + "</p></div><div class=\"well panel-body col-xs-3 text-center\"><h4 >Likes :<span id=\"like"+ ${answerList}[i].answerId +"\"> "+ ${answerList}[i].likes + "</span></h4><div id=\"likesContainer\"><button id=\"likeBtn" + ${answerList}[i].answerId +"\" type=\"button\" onclick=\"updateLike(" + ${answerList}[i].answerId + ")\" class=\"btn btn-primary col-xs-5 glyphicon glyphicon-thumbs-up\" style=\"float: none;\">Like</button></div></div></div>");
		}
		/* for(var i=0; i<${answerList}.length; i++){
			// Disable Like Btn TO BE DONE
			if(${answerList}[i].user.userId == ${loggedInUser}){
				$("#likeBtn" + ${answerList}[i].answerId).attr("disabled");
			}
		} */
		
		$("#answerBtn").click(function () {
			$.post({url: "../addAnswer1/" + ${query}.queryId, data: {answer : $("#answer").val()} ,success: function(result){
				alert("Thank You for Posting! You will now earn a point for every like you accumulate on your answer.")
				window.location.reload(true);
		    }, failure: function(result){
		    	//window.location.reload(true);
		    }
			});
		});
	});	
	</script>
	
  </body>
</html>

