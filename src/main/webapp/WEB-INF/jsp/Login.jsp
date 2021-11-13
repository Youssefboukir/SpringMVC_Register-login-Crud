<%-- 
    Document   : Ajouter
    Created on : 31 mars 2021, 13:12:00
    Author     : YOUSSEF
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ include file="style.jsp"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>ADD User</title>
    </head>
    <body>
        <div class="modal-dialog">
            <div class="modal-content">
                <form method="post" action="login" >
                    <div class="modal-header">						
                        <h4 class="modal-title">Login</h4>
                    </div>
                    <div class="modal-body">					
                   
                        <div class="form-group">
                            <label>EMAIL</label>
                            <input type="email" class="form-control" name="email" >
                        </div>	
                        <div class="form-group">
                            <label>PASSWORD</label>
                            <input type="password" class="form-control" name="password" >
                        </div>
                    </div>
                    <div class="modal-footer">
                        <input type="button" class="btn btn-default" data-dismiss="modal" value="Cancel">
                        <input type="submit" class="btn btn-success" value="Login">
                    </div>
                </form>
            </div>
        </div>
    </body>
</html>
