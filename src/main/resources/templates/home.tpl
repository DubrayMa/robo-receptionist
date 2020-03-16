<!DOCTYPE html>
<!-- Victor Germanov csd299 IT Project -->
<html>
    <head>
        <title>Home Page</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <style>
            body{background-color:rgb(0,102,204); align:center; font-size:3em;}
            h1{color:rgb(255,255,0); font-size:3.5em; border:none;}
            .span1 {position:absolute; top:30%; left:50%; transform:translate(-45%, -50%);}
            .span2 {display:inline;float:left;
                position:absolute; top:55%; left:50%; transform:translate(-45%, -50%);}
            .admin {
                float:left; position:relative; left:5px; top:5px;
                background-color:rgb(0,102,204); color:rgb(255,255,0); border:3px #CCCCCC solid;
                border-radius:5px; width:70px; height:50px; cursor:pointer;
            }            
            .button{
                width:200px; background-color:rgb(255,255,0); border:3px #CCCCCC solid; 
                border-radius:10px; color:black; padding:15px 32px; text-aling:center;
                text-decoration:none; font-size:24px;
                margin:0 30px 0 30px; cursor:pointer;
            }
            input[type="image"] {width:70px; border:3px #CCCCCC solid; border-radius:5px;}
        </style>
    </head>
    <body>

        <a href="/roboreceptionist/servlet?cmd=showAdmin">                
            <button name="admin" class="admin">Admin</button>                
        </a>

        <span class="span1"><h1>Welcome!</h1></span>
        
        <span class="span2">
            <a href="/roboreceptionist/servlet?cmd=showGuest">
                <button class="button">Guest</button>
            </a>
            <a href="/roboreceptionist/servlet?cmd=showDelivery">        
                <button class="button">Delivery</button>
            </a>           
        </span>

    </body>
</html>