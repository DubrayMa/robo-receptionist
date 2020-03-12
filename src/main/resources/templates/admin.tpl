<!DOCTYPE html>
<!-- Victor Germanov csd299 IT Project-->
<html>
<head>
	<meta charset="UTF-8">
	<title>Admin Page</title>
	<style>
		body {background:rgb(255,255,255); font-size:1em;}
		h2{font-size: 2.5em; color:rgb(153,153,153); border:50px; text-align:center;}
		h2 span{position: relative; top:0.4em;}
		p{text-align: center}
		
		table {
			position: relative; top:0px;
			left: 50%;
			transform: translate(-50%, 0);			
		
		}
		
		.button {			
			display: inline;
			background: rgb(255, 246, 205);
			float: none;
			height: 30px;
			width: 100px;
		}
		
		input {
			type:text;
			value:test;
			width:300px;
		}
		
		#buttons {
			position: fixed; bottom:50px;
			left: 50%;
			transform: translate(-50%, 0);
		}
	</style>
	
	<script type="text/javascript">
		function addRow(id){
			var tbody = document.getElementById(id).getElementsByTagName("TBODY")[0];
			var table = document.getElementById("emplTable");
			
			var row = document.createElement("TR");
			var td1 = document.createElement("TD");
			
			var lastRow = table.rows.length;			
					
			td1.appendChild(document.createTextNode(lastRow))
			var td2 = document.createElement("TD")
			td2.appendChild (document.createElement("input"))
			var td3 = document.createElement("TD")
			td3.appendChild (document.createElement("input"))
			var td4 = document.createElement("TD")
			td4.appendChild (document.createElement("input"))
			row.appendChild(td1);
			row.appendChild(td2);
			row.appendChild(td3);
			row.appendChild(td4);
			tbody.appendChild(row);
		}
		
		function editClick(){
			document.forms["form1"].submit();
		}
		function delClick(){
			document.forms["form1"].submit();
		}
		function saveClick(){
			document.forms["form1"].submit();
		}
		function cancelClick(){
			document.forms["form1"].submit();
		}
	</script>
	
	<link href="r.css" rel="stylesheet" />
</head>

<body align="center">
	<h2><span>The Employee List</span></h2>
	
	<form name="employeeForm" action="admin.html" method="post">
		
		<table name="emplTable" id="emplTable" cellspacing="0" border="1">
			<tbody>
				<tr>
					<th class="1" width="100px">ID</th> <th  width="300px">Name</th> <th width="300px">Email</th> <th width="300px">Department</th>
				</tr>				
			</tbody>
        </table>

		<fieldset name="buttons" id="buttons" width="100%">
			<p>		
				<button name="new" id="new" class="button" value="New" onclick="addRow('emplTable');return false;" >New</button>
				<button name="edit" id="edit" class="button" value="New" onclick="editClick()return false;;" >Edit</button>
				<button name="del" id="del" class="button" value="New" onclick="delClick();return false;" >Del</button>
				<button name="save" id="save" class="button" value="New" onclick="saveClick();return false;" >Save</button>
				
				<button type="button" class="button" value="Cancel" onClick="window.location.replace('/roboreceptionist/servlet')"/>Cancel		
			</p>
		</fieldset>
	
	</form>
</body>
</html>