<%@page import="com.google.gson.JsonObject"%>
<%@page import="com.psl.flashnotes.bean.Notes"%>
<%@page import="com.psl.flashnotes.dao.NotesDAO"%>

<%
	NotesDAO dao=new NotesDAO();
	Notes note=new Notes();
	
	int id=Integer.parseInt(request.getParameter("noteId"));
	
	note=dao.getNotesById(id);
	String heading=note.getNoteHeading();
	String body=note.getNoteBody();
	JsonObject json=new JsonObject();
	json.addProperty("noteHeading",heading);
	json.addProperty("noteBody",body);
 	out.println(json); 
%>