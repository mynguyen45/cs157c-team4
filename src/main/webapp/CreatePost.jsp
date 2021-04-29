<html>
	<head><title>Adoptable - Create Post</title></head>
	<body>
		<h1>Create Adoption Post</h1>
		
		<section>
			<form action="<%= request.getContextPath() %>/createPost" method="post">
				<label for="media">Media:</label><br>
				<input type="file" id="media" name="media" accept="image/png, image/jpeg">
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
		
	</body>
</html>