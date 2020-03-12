<!DOCTYPE html>
<!-- Victor Germanov csd299 IT Project-->
<html>
<head>
	<meta charset="UTF-8">
	<title>Delivery Page</title>
	<style>
		body {background:rgb(255,255,255); font-size:1.5em;}
		h1{font-size: 2.5em; color:rgb(153,153,153); border:500px; text-align:center;}
		h1 span{position: relative; top:1.5em;}
		p{text-align: center}

		/* Field set styles */

		fieldset {
			position: relative; top:3em;
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
		
		/* Label styles */

		label {
			clear: left;
			display: block;
			float: left;
			font-size: 0.9em
			margin: 7px 4% 7px 5px;
			width: 40%;
		}

		/* Input control styles */

		input {
			display: block;
			float: left;
			font-size: 0.9em;
			margin: 7px 0px;
			width: 90%;
		}

		input#state {
			width: 50px;
		}

		input[type="button1"] {
		position: relative; top:1.5em;
		display: inline;
		background: rgb(255, 246, 205);
		float: none;
		height: 40px;
		width: 150px;
		margin:10px;
		}
		
		input[type="button2"] {
		position: relative; top:5em;
		display: inline;
		background: rgb(255, 246, 205);
		float: none;
		height: 40px;
		width: 200px;
		}
		
	</style>	
</head>

<body>
	<h1><span>Delivery Page</span></h1>
	
	<form action="servlet" method="get">
	
		<fieldset id="guest1" class="guest1">
			<legend>Please click your delivery company button:</legend>
			<p>		
				<a href="/roboreceptionist/servlet?cmd=deliveryPerson">
					<input type="button1" class="button" value="Amazon" />
				</a>
				<a href="/roboreceptionist/servlet?cmd=deliveryPerson">
					<input type="button1" class="button" value="FedEx" />
				</a>
				<a href="/roboreceptionist/servlet?cmd=deliveryPerson">
					<input type="button1" class="button" value="UPS" />
				</a>
				<a href="/roboreceptionist/servlet?cmd=deliveryPerson">
					<input type="button1" class="button" value="GrubHub" />
				</a>
				<a href="/roboreceptionist/servlet?cmd=deliveryPerson">
					<input type="button1" class="button" value="DoorDash" />	
				</a>
				<a href="/roboreceptionist/servlet?cmd=deliveryPerson">	
					<input type="button1" class="button" value="Other" />
				</a>		
			</p>
		</fieldset>
		
		<p>				
				<input type="button2" class="button" value="Cancel" onClick="window.location.replace('/roboreceptionist/servlet')">
		</p>
	</form>
</body>
</html>