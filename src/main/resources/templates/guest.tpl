<!DOCTYPE html>
<!-- Victor Germanov csd299 IT Project-->
<html>
<head>
	<meta charset="UTF-8">
	<title>Guest Page</title>
	<style>
		body {background:rgb(255,255,255); font-size:1.5em;}
		
		div{text-align: center}

		/* Field set styles */

		fieldset {
			position: relative; top:1em;
			background-color: rgb(255, 246, 205);
			border: 1px solid rgb(233, 69, 0);
			text-align:left-side;
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
			display: block;
			align: center;
			font-size: 0.9em
			margin: 7px 2% 7px 5px;
			width: 100%;
		}
		
		/* Text area styles */

		textarea {
			display: block;
			font-family: areal;
			font-size: 1.2em;
			font-weight: bolder;
			float: left;
			height: 75px;
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
			margin: 0px 10px 0px 0px;
			width:10px;			
		}
		
		/* Submit button styles */

		input[type="submit"], input[type="button"] {
		position: relative; top: 2.8em;
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
		
	<form  action="/roboreceptionist/servlet?cmd=submitGuest" method="post">

		<fieldset id="guest1">
			<legend>Please enter your name and the name of your addressee:</legend>
			<label for="guest">Name of visitor:</label>
			<input name="guest" id="guest" />
			<label for="employee">Name of empolyee:</label>
			<input name="employee" id="employee" />
		</fieldset>
	
		<fieldset id="guest2" align="left">
			<legend>Enter a message or choose a ready-made option:</legend>	
			
			<textarea name="message" id="message"></textarea>
			
			<input type="radio" name="message" id="message" value="I'm here for a meeting." />
			<label for="radio">I'm here for a meeting.</label><br />
			<input type="radio" name="message" id="message" value="I'm here for lunch." />
			<label for="radio">I'm here for lunch.</label><br />
			<input type="radio" name="message" id="message" value="I'm here to see you." />
			<label for="radio">I'm here to see you.</label>			
		</fieldset>
		
		<div>	
			<input type="submit" class="button" value="Submit" />
			<input type="button" class="button" value="Cancel" onClick="window.location.replace('/roboreceptionist/servlet')"/>
			</a>
		</div>
	</form>
</body>
</html>