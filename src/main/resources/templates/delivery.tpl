<!DOCTYPE html>
<!-- Victor Germanov csd299 IT Project-->
<html>
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>Delivery Page</title>
	<style>
		body {background:rgb(255,255,255); font-size:1.5em;}
		h1{font-size: 2.2em; color:rgb(153,153,153); text-align:center;}
		h1 span{position: relative; top:0.2em;}

		p{text-align: center}

		/* Field set styles */

		fieldset {
			position: relative; top:1em;
			background-color: rgb(255, 246, 205);
			border: 1px solid rgb(233, 69, 0);
			float: left;
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
		
		input[type="submit"] {
			display: block;
			float: left;
			font-size: 0.9em;
			margin: 7px 0px;
			width: 100%;
			cursor:pointer;
		}

		.button {
		position: relative; top:2.5em;
		display: inline;
		background: rgb(255, 246, 205);
		font-size: 0.9em;
		float: none;
		height: 40px;
		width: 200px;
		cursor:pointer;
		}
		
	</style>	
</head>

<body>
	<h1><span>Delivery Page</span></h1>
	
	<form action="/roboreceptionist/servlet?cmd=deliveryPerson" method="post">
	
		<fieldset id="company" class="guest1">
			<legend>Please click your delivery company button:</legend>
			<p>		
					<input type="submit" class="button1" name="company" value="Amazon"> 
						<input type="hidden" name="name" value="John doe"/>
						<input type="hidden" name="employee" value="Liz bore"/>
					</input>

					<input type="submit" class="button1" name="company" value="FedEx">
						<input type="hidden" name="name" value="John doe"/>
						<input type="hidden" name="employee" value="Liz bore"/>
					</input>

					<input type="submit" class="button1" name="company" value="UPS">
						<input type="hidden" name="name" value="John doe"/>
						<input type="hidden" name="employee" value="Liz bore"/>
					</input>

					<input type="submit" class="button1" name="company" value="GrubHub">
						<input type="hidden" name="name" value="John doe"/>
						<input type="hidden" name="employee" value="Liz bore"/>
					</input>

					<input type="submit" class="button1" name="company" value="DoorDash">
						<input type="hidden" name="name" value="John doe"/>
						<input type="hidden" name="employee" value="Liz bore"/>
					</input>	

					<input type="submit" class="button1" value="Other">
						<input type="hidden" name="name" value="John doe"/>
						<input type="hidden" name="employee" value="Liz bore"/>
						<input type="hidden" name="company" value="unknown"/>
					</input>		
			</p>
		</fieldset>
		
		<p>				
			<input type="button" class="button" value="Cancel" onClick="window.location.replace('/roboreceptionist/servlet')">
		</p>
	</form>
</body>
</html>