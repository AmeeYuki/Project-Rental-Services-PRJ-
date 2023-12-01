<!DOCTYPE html>
<html>
    <head>
        <title>Start Page</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <style>
            #logout{
                float: right;
                background-color: #EF6262;
                padding:10px  20px;
                border: none;
                border-radius: 5px;
                font-weight: bolder;
                color: white;
                
            }
        </style>
    </head>
    <body>
        <form action="LogoutController" method='POST'>
           <button id="logout" name="action" value="LogoutController">Logout</button>
        </form>
    </body>
</html>
