<!DOCTYPE html>
<!-- Victor Germanov csd299 IT Project-->
<html>
<head>
	<meta charset="UTF-8">
	<title>Guest2 Page</title>
	<style>
		body {background:rgb(255,255,255); font-size:1.5em;}
		h1{font-size: 2.5em; color:rgb(153,153,153); border:500px; text-align:center;}
		h1 span{position: relative; top:1.5em;}
		div{text-align: center}

		/* Field set styles */

		fieldset {
			position: relative; top:3em;
			background-color: rgb(255, 246, 205);
			border: 1px solid rgb(233, 69, 0);
			text-align:center;
			float: none;
			margin: 10px 0px 10px 2.5%;
			width: 93%;
		}

		legend {
			background-color: rgb(233, 69, 0);
			color: white;
			padding: 3px 0px;
			text-indent: 5px;
			width: 100%;
		}
		
		/* Label styles */

		label {
			clear: left;
			display: block;
			float: left;
			font-size: 0.9em
			margin: 7px 4% 7px 5px;
			width: 100%;
		}
		
		/* Text area styles */

		textarea {
			display: block;
			font-size: 0.9em;
			float: left;
			height: 150px;
			margin: 10px 0px;
			width: 100%;
		}

		/* Input control styles */

		/*input {
			display: block;
			float: left;
			font-size: 0.9em;
			margin: 7px 0px;
			width: 100%;
		}*/
		
		/* Option button styles */

		input["radio"] {			
			display: block;
			float: left;
			font-size: 0.9em;
			margin: 0px 20px 0px 0px;
			width:10px;			
		}
		
		/* Submit button styles */

		input[type="submit"], input[type="button"] {
		position: relative; top:5em;
		display: inline;
		background: rgb(255, 246, 205);
		float: none;
		font-size: 0.9em;
		height: 40px;
		width: 200px;
		}
		
	</style>	
</head>

<body>
	<h1><span>Message Page</span></h1>
	
	<form action="http://sign-in-please.com" method="get">
	
		<fieldset id="guest1" class="guest1" align="left">
			<legend>Enter a message or choose a ready-made option:</legend>	
			
			<textarea name="message" id="message"></textarea>
			
			<input type="radio" name="radio" id="radio" value="1" />
			<label for="radio">I'm here for a meeting.</label><br />
			<input type="radio" name="radio" id="radio" value="2" />
			<label for="radio">I'm here for lunch.</label><br />
			<input type="radio" name="radio" id="radio" value="3" />
			<label for="radio">I'm here to see you.</label>			
		</fieldset>
		
		<div>		
			<input type="submit" class="button" value="Submit" />
			<a href="home.html"><input type="button" class="button" value="Cancel" /></a>
		</div>
	</form>
</body>
</html>