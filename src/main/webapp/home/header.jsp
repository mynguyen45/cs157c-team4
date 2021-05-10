

<link rel="stylesheet" href="css/style.css"/>
<div id="header">
	<div style="text-align: center; font-size: 35px; color:lightskyblue ;">Header</div>
	
	<div style="position: fixed;right: 20px; top: 10px; color: lightskyblue;">Hello '<% ((RegularUser)session.getAttribute("CURRENT_USER")).getUserame()%>'</div>
	<div style="position: fixed;right: 20px; top: 30px; color: lightskyblue;"><a href="#">Logout</a></div>

</div>

