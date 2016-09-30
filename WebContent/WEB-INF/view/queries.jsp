<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8">
    <title>Flash Notes | Query</title>
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
	input,label,button,h1,textarea,h3{
		background-color:transparent !important;
		font-weight: inherit;
		color: #bfbfbf !important;	
	}

    </style>
  </head>
  <body>
	<%@ include file="Header.jsp" %>
	<div class="container-fluid">
		<div class="query-container">
			<div class="col-lg-9 col-md-9 col-lg-offset-1 col-md-offset-1 ">
				<div class = "query-name-rating row">
					<h1 class="col-xs-10 glyphicon">
						<strong>
							Queries on 
							<a id="noteHeadingHref" href="">
								<span id="noteHeading"></span>
							</a>
							<span class="glyphicon glyphicon-question-sign"></span>
						</strong>
					</h1>	
				</div>
				<br>
				
				<div id="queryContainer" class="row one-query-container"></div>
				
				<!-- <div class="answers col-xs-3 text-center">
					<h4 class="">Answers :<span id="no-of-ans" name="no-of-ans"> 5</span></h4>
				</div> -->
				
				<h3 >Ask Query</h3>
				<div class="input-group col-xs-9">				
					<!-- <form id="queryFormId" action="" method="post"> -->
						<textarea required id="question" name="question" class="form-control" rows="5" placeholder="Your Query Goes here"></textarea>
						<br><br><br><br>
						<button id="query_btn" class="btn btn-default" type="submit" style="float: right;" data-toggle="tooltip" title="Ask your query">Submit Query</button>
					<!-- </form> -->						
				</div>
			</div>	
		</div>
	</div>
	<hr>
	<div class="footer" >
		<div class="panel-body text-center" align="center">
			<h3 class="glyphicon glyphicon-copyright-mark col-lg-12 text-center" align="center">
			<a class="pull-left btn-link btn-lg glyphicon glyphicon-info-sign"
					href="#" data-toggle="tooltip" title="About us">About</a>  Managers of Mayhem 
			<a	class="pull-right btn-link btn-lg glyphicon glyphicon-question-sign "
					href="#"data-toggle="tooltip" title="Help">Help</a>		
			</h3>	
		</div>
	</div>
	
	<script>
	
	function sleep(milliseconds) {
		  var start = new Date().getTime();
		  for (var i = 0; i < 1e7; i++) {
		    if ((new Date().getTime() - start) > milliseconds){
		      break;
		    }
		  }
		}
	
	$(document).ready(function(){

		for(var i=0; i<${queryList}.length; i++){
			$("#queryContainer").append("<a href=\"../getAnswer/" + ${queryList}[i].queryId + "\"><div class=\"well query col-xs-9 pull-left\"><h4 id=\"queryid\" name=\"queries\">" + ${queryList}[i].question + "</h4></div></a>");
		}
		$("#noteHeading").html(${note}.noteHeading.toUpperCase());
		$("#noteHeadingHref").attr("href", "../getNotesById/" + ${note}.noteId);
		/* $("#queryFormId").attr("action", "../addQuery/" + ${note}.noteId); */
		
		$("#query_btn").click(function () {
			$.post({url: "../addQuery1/" + ${note}.noteId, data: {question: $("#question").val()},success: function(result){
				alert("Your Query was posted! Please Check back later for replies.")
				window.location.reload(true);
		    }, failure: function(result){
		    	window.location.reload(true);
		    }
			});
		});
	});	
	</script>
  </body>
</html>

