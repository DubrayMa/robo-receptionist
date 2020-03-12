<!DOCTYPE html>
<!-- Victor Germanov csd299 IT Project-->
<html>
<head>
	<meta charset="UTF-8">
	<title>Guest1 Page</title>
	<style>
		body {background:rgb(255,255,255); font-size:1.5em;}
		h1{font-size: 2.5em; color:rgb(153,153,153); border:500px; text-align:center;}
		h1 span{position: relative; top:1.5em;}
		p{text-align: center}

		

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
		
		

		label {
			clear: left;
			display: block;
			float: left;
			font-size: 0.9em
			margin: 7px 4% 7px 5px;
			width: 40%;
		}

		

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

		input[type="submit"], input[type="button"] {
		position: relative; top:5em;
		display: inline;
		background: rgb(255, 246, 205);
		float: none;
		height: 40px;
		width: 200px;
		}
		
	</style>
	<script type="text/javascript">
		function btnClick(){
			document.forms["form1"].submit();
		}
	</script>	
</head>

<body>
	<h1><span>Visitor Input Page</span></h1>
	
	<form name="form1" action="/roboreceptionist/servlet?cmd=submitGuest" method="post">
	
		<fieldset id="guest1" class="guest1">
			<legend>Please enter your name and the name of your visitor:</legend>
			<label for="guest">Name of visitor:</label>
			<input name="guest" id="guest" />
			<label for="employee">Name of empolyee:</label>
			<input name="employee" id="employee" />
		</fieldset>
		
		<p>	
			<input type="button" class="button" value="Submit" onClick="btnClick();" />
			<input type="button" class="button" value="Cancel" onClick="window.location.replace('/roboreceptionist/servlet')"/>
		</p>
	</form>
</body>
</html>