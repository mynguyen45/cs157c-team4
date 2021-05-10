<%@page import="beans.Post" %>
<%@page import="java.util.ArrayList" %>
<%@page import="java.util.Base64" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Adoptable - Home</title>
</head>
<body><p style="text-align:center;">
	<h1>Home Page</h1>
        <%-- Fetching the attributes of the request object
             which was previously set by the servlet 
              "HomeServlet.java"
        --%> 
        <%	ArrayList<Post> posts = (ArrayList<Post>)request.getAttribute("posts");
	    	for(Post p: posts) {
				String encodedImg = Base64.getEncoder().encodeToString(p.getMedia().array());
				String image = "data:image/jpeg;base64, " + encodedImg;
        %>
            <section>
                <h3><b><%=p.getPosterUsername()%></b></h3>
                <img src="<%=image %>" width="300px" height="300px" alt="Image unavailable"><br>
                <text><%=p.getDescription()%></text><br>
                <b>Adoptable: <%=p.getAdoptionStatus() %></b>
            </section><br><br>
            <%}%>
</p></body>
</html>