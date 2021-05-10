<html>
	<head><title>Adoptable - Create Post</title></head>
	<body>
		<h1>Create Adoption Post</h1>
		
		<section>
			<form action="<%= request.getContextPath() %>/createPost" method="post" enctype="multipart/form-data">
				<label for="media">Media:</label><br>
				<input type="file" id="media" name="media" accept="image/jpeg">	<!-- Add 'multiple' as an attr to input to allow multiple file uploading -->
				<br><br>
				
				<label for="description">Description:</label><br>
				<textarea rows="5" cols="50" id="description" name="description">Description</textarea><br>
				<br>
				
				<label >Adoption Status:</label><br>
				<input type="radio" id="adoptable" name="adoptionStatus" value="true">	<!-- value="adoptable" if needs to be this, convert from string to boolean in postservlet -->
				<label for="adoptable">Adoptable</label><br>
				<input type="radio" id="adopted" name="adoptionStatus" value="false">	<!-- value="adopted" -->
				<label for="adopted">Adopted</label><br>
				<br>
				
				<input type="submit" value="Post">
			</form>
		</section>
		<h2 style="color:red"><%=request.getAttribute("isError") != null ? "Unable to create post: You must upload an IMAGE file." : ""%></h2>
		
	</body>
</html>