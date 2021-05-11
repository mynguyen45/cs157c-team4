<link rel="stylesheet" href="../css/style.css"/>
<div id="nav" class="vmenu">
	<a class="menu_link active" href="#">Homepage</a>
	<a class="menu_link" href="#">Your profile</a>
	<a class="menu_link" href="#">Photos</a>
	<a class="menu_link" href="#">Friends</a>
</div>

<script>
// add active to the the current button highlight it
var header = document.getElementById("nav");
var links = header.getElementsByClassName("menu_link");
for(var i = 0;i < links.length; i++){
	links[i].addEventListener("click", function(){
		var current = document.getElementsByClassName("active");
    	current[0].className = current[0].className.replace(" active", "");
		this.className += " active";
	});
}
</script>