<!DOCTYPE html>
<!-- Victor Germanov csd299 IT Project -->
<html>
    <head>
        <title>Home Page</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <style>
            body{background-color:rgb(0,102,204); text-align:center; font-size:3em;}
            h1{color:rgb(255,255,0); font-size:3em; border:500px;}
            h1 span{position:relative; top:1em;}
            p{text-align:center;}
            .button{
                position:relative; top:5em; background-color:rgb(255,255,0); 
                border:none; color:black; padding:15px 32px; text-aling:center;
                text-decoration:none; display:inline-block; font-size:24px;
                margin:0px 70px 0px 70px; cursor:pointer;
            }
        </style>
    </head>
    <body>
        <h1><span>Welcome!</span></h1>
        
        <p>
            <a href="/roboreceptionist/servlet?cmd=showGuest">
            <button class="button">Guest</button>            
            </a>
            <a href="/roboreceptionist/servlet?cmd=showDelivery">        
            <button class="button">Delivery</button>
            </a>  
            <a href="/roboreceptionist/servlet?cmd=showAdmin">        
            <button class="button">Admin</button>
            </a>  
        </p>      
    </body>
</html>