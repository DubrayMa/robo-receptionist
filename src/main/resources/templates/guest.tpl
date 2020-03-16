<!DOCTYPE html>
<!-- Victor Germanov csd299 IT Project-->
<html>
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>Guest Page</title>
	<style>	
		body {background:rgb(255,255,255); font-size:1.5em;}
		h1 {font-size:2.2em; color:rgb(153,153,153); text-align:center;}
		h1 span {position:relative; top:0.2em;}
		.buttons {text-align:center;}
		.visitor {display:inline; float:left; text-align:right;}
		
		fieldset {
			position: relative; top:1em;
			background-color: rgb(255, 246, 205);
			border: 1px solid rgb(233, 69, 0);			
			margin: 10px 0px 10px 2.5%;
			width: 93%;
		}

		legend {
			background-color: rgb(233, 69, 0);
			color: white;
			padding: 3px 0px;
			text-align:left-side;
			text-indent: 5px;
			width: 100%;
		}

		label {			
			padding:0, 0, 10px, 0;
		}
		
		textarea {
			display: block;
			font-family: Arial, Helvetica, sans-serif;
			font-size: 1em;			
			float: left;
			height: 80px;
			margin: 10px 0px;
			width: 100%;
		}

		input[type="text"] {
			text-align:left;
			font-family: Arial, Helvetica, sans-serif;
			font-size: 1em;				
			margin: 7px 5px 0 5px;
			width: 50%;
		}*/
		
		.myradio {			
			vertical-align:center;
			margin: 30px 0px 3px 40px;
			width:17px;	
			height:17px;		
		}

		.radio {position:relative; left:0px;}

		.rlabel {padding: 0 30px 0 10px;}
		
		input[type="submit"], input[type="button"] {
		position: relative; top: 3.8em;
		display: inline;
		background: rgb(255, 246, 205);
		float: none;
		font-size: 0.9em;
		height: 40px;
		width: 200px;
		cursor:pointer;
		}

	</style>
	
</head>

<body>

	<h1><span>Visitor Page</span></h1>
		
	<form  action="/roboreceptionist/servlet?cmd=submitGuest" method="post">

		<fieldset id="guest1">
			<legend>Please enter your name and the name of your addressee:</legend>
			
			<label class="visitor" for="guest">
				Name of visitor:<input name="guest" type="text" />
			</label>
			<label class="visitor" for="employee">
				Name of employee:<input name="employee" type="text" />
			</label>
			<label class="visitor" for="company">
				Name of company:<input name="company" type="text" placeholder="optional"/>
			</label>
		</fieldset>
	
		<fieldset id="guest2" align="left">
			<legend>Enter a message or choose a ready-made option:</legend>	
			
			<textarea name="message" id="message"></textarea>

				<input type="radio" name="myradio" id="myradio" value="I'm here for a meeting.">I'm here for a meeting.</input>
				<input type="radio" name="myradio" id="myradio" value="I'm here for lunch.">I'm here for lunch.</input>
				<input type="radio" name="myradio" id="myradio" value="I'm here to see you.">I'm here to see you.</input>	
					
		</fieldset>
		
		<div class="buttons">	
			<input type="submit" class="button" value="Submit" />
			<input type="button" class="button" value="Cancel" onClick="window.location.replace('/roboreceptionist/servlet')"/>			
		</div>
	</form>
</body>
</html>
