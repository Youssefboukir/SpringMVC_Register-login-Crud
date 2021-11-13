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
        <title>Update CONTACT</title>
    </head>
    <body>
	<div class="modal-dialog">
		<div class="modal-content">
			<form method="post" action="editt"  enctype="multipart/form-data">
				<div class="modal-header">						
					<h4 class="modal-title">Update Contact</h4>
				</div>
				<div class="modal-body">					
					<div class="form-group">
						<input type="hidden" class="form-control" name="id" value="${listt.getId()}">
					</div>
					<div class="form-group">
						<label>Auteur</label>
						<input type="text" class="form-control" name="auteur" value="${listt.getAuteur()}">
					</div>
					<div class="form-group">
						<label>Titre</label>
						<input type="text"  class="form-control" name="titre" value="${listt.getTitre()}">
					</div>
					<div class="form-group">
						<label>Domaine</label>
						<input type="text" class="form-control" name="domaine" value="${listt.getDomaine()}">
					</div>
                                        
                                        <div class="form-group">
						<label>Nb_exemplaire</label>
						<input type="text"  class="form-control" name="nb_exemplaire" value="${listt.getNb_exemplaire()}">
					</div>
					<div class="form-group">
						<label>Date</label>
						<input type="text" class="form-control" name="date" value="${listt.getDate()}">
					</div>	
                                  
				</div>
				<div class="modal-footer">
					<input type="button" class="btn btn-default" data-dismiss="modal" value="Cancel">
					<input type="submit" class="btn btn-success" value="Save">
				</div>
			</form>
		</div>
</div>
    </body>
</html>
