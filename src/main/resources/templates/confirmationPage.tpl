
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
            background-color: rgb(51,0,204);
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
        .message {
            display: block;
            font-size: 0.9em;
            float: left;
            height: 150px;
            margin: 10px 0px;
            width: 100%;
        }
        /* Input control styles */
        input {
            display: block;
            float: left;
            font-size: 0.9em;
            margin: 7px 0px;
            width: 100%;
        }
        
        /* Submit button styles */
        input[type="submit"], input[type="button"] {
        position: relative; top:5em;
        display: inline;
        background: rgb(255, 246, 205);
        float: none;
        height: 40px;
        width: 200px;
        }
        
    </style>
    <link href="r.css" rel="stylesheet" />
</head>
<body>
    <h1><span>Confirmation Page</span></h1>
    
    <fieldset id="guest1" align="left">
        <legend>Read the request confirmation and click OK:</legend>            
        <div  name="message" class="message">
            <p>
                ${confirmationMessage}<br>            
            </p>
        </div>                    
    </fieldset>        
    
    <div>            
        <a href="home.html"><input type="button" class="button" value="OK" /></a>
    </div>
    
</body>
</html>
 
 
