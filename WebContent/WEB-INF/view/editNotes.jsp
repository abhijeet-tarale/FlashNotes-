<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>FlashNotes | Edit Note</title>
			<link rel=icon href="<c:url value="/resources/favicon/64.ico" />">
		    <%@ include file="staticFiles.jsp" %>
	
	
	</head>
	<body>
	 <form action="editNotes" method="post">
	
	Note ID :<input type="text" id="noteId" name="id">
	<%-- <% request.setAttribute("noteId",request.getParameter("noteId"));%> --%>
	Note Heading :<input type="text" id="noteHeading" name="heading">
	Note Body :<textarea id="noteBody" rows="5" cols="5" name="area"></textarea>
	<input type="submit" id="update" value="SUBMIT">
	
	 </form> 
	 
	<script type="text/javascript">
	
	document.getElementById("noteId").onblur=fetchNotes;
	function fetchNotes() {
		xmlHttp=new XMLHttpRequest();
		var noteId=document.getElementById("noteId").value;
		var url="processNotes.jsp?noteId="+noteId;
		xmlHttp.open("POST", url, true);
		xmlHttp.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
		xmlHttp.onreadystatechange=processResponse;
		xmlHttp.send(null);
	}
	
	function processResponse(){
		if(xmlHttp.readyState==4&&xmlHttp.status==200) {
		var response=xmlHttp.responseText;
		var jsonData=JSON.parse(response);
		document.getElementById("noteHeading").value=jsonData.noteHeading;
		document.getElementById("noteBody").value=jsonData.noteBody;
		}
		
	}
	</script>
	</body>
</html>