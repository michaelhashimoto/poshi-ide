<html>
	<head>
		<style>
			#form {
				margin-top: 50px;
				text-align: center;
			}
		</style>
	</head>
	<body>
		<form action="path" id="form" method="post">
			<p>Please enter your Path Key (JSP Response): <input type="text" name="pathKey" size="30px" /></p>
			<input type="submit" value="Submit" />
		</form>

		<form action="path/json" method="post">
			<p>Please enter your Path Key (JSON Response): <input type="text" name="pathKey" size="30px" /></p>
			<input type="submit" value="Submit" />
		</form>

		<form>
			<p>Please enter your Path Key (AJAX Response): <input type="text" id="pathKey" size="30px" /></p>
			<button type="button" onclick="loadDoc()">Change Content</button>
		</form>

		<div id="result"></div>

		<script>
			function loadDoc() {
				var xhttp = new XMLHttpRequest();

				xhttp.onreadystatechange = function() {
					if (this.readyState == 4 && this.status == 200) {
						document.getElementById("result").innerHTML = this.responseText;
					}
				};

				xhttp.open("post", "path/ajax", true);

				var pathKey = document.getElementById("pathKey").value;

				console.log(xhttp);
				console.log(xhttp.responseText);

				xhttp.send(pathKey);
			}
		</script>
	</body>
</html>