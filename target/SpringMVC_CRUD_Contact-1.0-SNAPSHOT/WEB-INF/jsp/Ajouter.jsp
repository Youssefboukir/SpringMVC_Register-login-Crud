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
        <title>ADD CONTACT</title>
    </head>
    <body>
        <div class="modal-dialog">
            <div class="modal-content">
                <form method="post" action="add">
                    <div class="modal-header">						
                        <h4 class="modal-title">Add BOOK</h4>
                    </div>
                    <div class="modal-body">					
                        <div class="form-group">
                            <label>auteur</label>
                            <input type="text" class="form-control" name="auteur" >
                        </div>
                        <div class="form-group">
                            <label>titre</label>
                            <input type="text"  class="form-control" name="titre" >
                        </div>
                        <div class="form-group">
                            <label>domaine</label>
                            <input type="text" class="form-control" name="domaine" >
                        </div>	
                           <div class="form-group">
                            <label>nb exemplaire</label>
                            <input type="text" class="form-control" name="nb_exemplaire" >
                        </div>
                          <div class="form-group">
                            <label>Date</label>
                            <input type="text" class="form-control" name="date" >
                        </div>
                    </div>
                    <div class="modal-footer">
                        <input type="button" class="btn btn-default" data-dismiss="modal" value="Cancel">
                        <input type="submit" class="btn btn-success" value="Add">
                    </div>
                </form>
            </div>
        </div>
    </body>
</html>
