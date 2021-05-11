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
<body>
  <h1>Home Page</h1>  
  <%	
    ArrayList<Post> posts = (ArrayList<Post>)request.getAttribute("posts");
    for(Post p: posts) {		
      String encodedImg = Base64.getEncoder().encodeToString(p.getMedia().array());
      String image = "data:image/jpeg;base64, " + encodedImg;
        %>
        <section>
          <h3><b><%=p.getPosterUsername()%></b></h3>
            <img src="<%=image %>" width="300px" height="300px" alt="Image unavailable"><br>        
            <text><%=p.getDescription()%></text><br>
            <b>Adoptable: <%=p.getAdoptionStatus() %></b>
            <br>

            <form action="<%= request.getContextPath() %>/home" method="post">
              <input type="hidden" name="postId" value="<%=p.getPostId() %>">
              <input type="submit" name="button" value="Like"><br>
              <textarea rows="3" cols="100" id="comment" name="comment">Create Comment</textarea><br>
              <input type="submit" name="button" value="Comment"> 	
            </form>
        </section><br><br>
  <%}%>
</body>
</html>