<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<title>Flash Notes | Course</title>
	<link rel=icon href="<c:url value="/resources/favicon/64.ico" />">
    <%@ include file="staticFiles.jsp" %>
	</head>
	<body>
		<%@ include file="Header.jsp" %>
		<div class="container-fluid">
			<div class="row"> <!-- Course Heading -->
				<div class="col-md-12 col-lg-12 text-center text-danger">
					<h1 class="jumbotron" style="background-color:rgb(200,150,20);">
						<!-- <span class="glyphicon glyphicon-star pull-right" aria-hidden="true">246_Views</span> -->
						<span style="color: black;" id="courseName"></span>
					</h1>
				</div>
			</div> <!-- End of Course Heading -->
			<div class="row">
				<div class="col-md-8 col-sm-12"> <!-- Course Content PDF -->
					<div class="embed-responsive embed-responsive16by9 embed-responsive-item text-center col-md-offset-" style="height:500px; width:800px">
						<object class="embed-responsive-item" data="<c:url value="../resources/docs/doc.pdf" /> " type="application/pdf" width="800px" height="700px">
							<p>It appears you don't have a PDF plugin for this browser. No biggie... you can <a target="_blank" href="<c:url value="../resources/docs/doc.pdf" /> ">click here to download the PDF file.</a></p>
						</object>
					</div>
				</div> <!-- End of Course Content PDF -->
				
				<div class="container col-md-4 col-sm-12"> <!-- Create Note Container -->
					<div class="well" style="background-color:rgb(200,50,20); border:2px; height:500px;">
						<h3>Make a Note</h3>
						<div class="row">
							<div id="formID" class="navbar-form navbar-left">
								<div>
									<input id="noteHeading" name="noteHeading" type="text" required style="width:100%; height:100%;" class="form-control" placeholder="Note Heading">
								</div>
								<br>
								<div>
									<input id="noteCategory" name="noteCategory" type="text" required style="width:100%; height:100%;" class="form-control" placeholder="Note Category">
								</div>
								<br>
								<div class="input">
									<textarea id="noteBody" name="noteBody" class="form-control" required placeholder="You can take down some important notes here.." rows="10" cols="40"></textarea>
								</div>
								<br>
								<button data-toggle="tooltip" title="Add Note" id="addAnsSubmitBtn" type="submit" class="btn btn-primary btn-lg">Submit</button>
							</div>
							<!-- <a href="../getAllNotes">
								<button type="submit" id="viewNotesBtn" class="btn btn-default btn-block">
									View All Notes
								</button>
							</a> -->
						</div>
					</div>
				</div> <!-- End of Create Note Container -->
			</div>
			<br><br><br><br>
			<div class="container-fluid"> <!-- Related Notes Container -->
				<div class="h1 text-center text-danger">
					<span class="glyphicon glyphicon-tasks"></span>
					Course Related Notes
				</div>
				<br><br><br>
				<div class="well" style="background-color:rgb(59,111,193);">
					<br><br>
					<div class="well text-center text-warning col-md-3 col-lg-3">
						<a id="noteHref1" href="#"><h2 id="note1">Dummy Note 1</h2></a>
						No_of_Views : <span class="glyphicon glyphicon-eye" id="note1Views">2,708</span>
						<br><br>
					</div>
					<div class="well text-center text-warning col-md-3 col-lg-3 col-md-offset-1 col-lg-offset-1">
						<a id="noteHref2" href="#"><h2 id="note2">Dummy Note 2</h2></a>
						No_of_Views : <span class="glyphicon glyphicon-eye" id="note2Views">2,708</span>
						<br><br>
					</div>
					<div class="well text-center text-warning col-md-3 col-lg-3 col-md-offset-1 col-lg-offset-1">
						<a id="noteHref3" href="#"><h2 id="note3">Dummy Note 3</h2></a>
						No_of_Views : <span class="glyphicon glyphicon-eye" id="note3Views">2,708</span>
						<br><br>
					</div>
					<div class="text-center">
						<a id="viewAllid" href="../getAllNotes/" data-toggle="tooltip" title="View All Notes">
							<button class="btn btn-primary btn-lg">
								View All Notes
							</button>
						</a>
					</div>
				</div>  
			</div> <!-- End of Related Notes Container -->
		</div>
		<script type="text/javascript">
			document.getElementById("courseName").innerHTML = ${course}.courseName;
			document.getElementById("formID").setAttribute('action', "../addNote/" + ${course}.courseId);
			document.getElementById("viewAllid").setAttribute('href', "../getAllNotes/" + ${course}.courseId);
			for(i=0; i<${topNotes}.length; i++){
				var j = i+1;
				document.getElementById("note"+j).innerHTML = ${topNotes}[i].noteHeading;
				document.getElementById("note"+j+"Views").innerHTML = ${topNotes}[i].noOfViews;
				document.getElementById("noteHref"+j).setAttribute('href', "../getNotesById/"+${topNotes}[i].noteId);
			}

			$(document).ready(function (){
			
				$("#addAnsSubmitBtn").click(function () {
				$.post({url: "../addNote1/" + ${course}.courseId,
					data: {
						noteHeading : $("#noteHeading").val(),
						noteCategory : $("#noteCategory").val(),
						noteBody : $("#noteBody").val()
					},
					success: function(result){
						alert("Successfully Added!");
						//window.setTimeOut(2000);
						window.location.reload(true);
			    	},
			    	failure: function(result){
			    		//window.location.reload(true);
			    	}
				});
			});
			});
			
		</script>
	</body>
</html>

