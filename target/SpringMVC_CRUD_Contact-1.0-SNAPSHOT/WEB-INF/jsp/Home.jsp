<%@page import="Model.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<%@ include file="style.jsp"%>
<%@page import="java.util.List"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Welcome to Spring Web MVC project</title>
    </head>

    <body>
    <nav class="navbar navbar-expand-lg navbar-light bg-light">
        <a class="navbar-brand" href="#">GESTIONBOOKS</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>

        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav mr-auto">
                <li class="nav-item active">
                </li>
            </ul>
        </div>
    </nav>
    <div class="container-xl">
        <div class="table-responsive">
            <div class="table-wrapper">
                  
                <form method="POST" action="deleteall.htm">
                    <div class="table-title">
                        <div class="row">
                            <div class="col-sm-6">
                              
                                <h2>Manage <b>Books</b></h2>
                            </div>

                            <div class="col-sm-6">
                                <a href="Ajouter.htm" class="btn btn-success" ><i class="material-icons">&#xE147;</i> <span>Add New Book</span></a>
                                <input type="submit" class="btn btn-info" value="Delete">

                            </div>
                        </div>
                    </div>
                    <table class="table table-striped table-hover">
                        <thead>
                            <tr>
                                <td><div class="form-check"><input type="checkbox" id="checkBoxAll" ></div></td>
                                <td>ISBN</td>
                                <td>Date prod</td>
                                <td>Titre</td>
                                <td>Domaine</td>
                                <td>Nb exemplaire</td>
                                <td>Auteur</td>
                                <td>Operation</td>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach items="${listt}" var="mylist" >               
                                <tr>
                                    <td><div class="form-check">
                                            <input   type="checkbox" class="chkCheckBoxId" value="${mylist.id}" id="box" name="box"></div></td>
                                    <td>${mylist.id}</td>
                                    <td>${mylist.date}</td>
                                    <td>${mylist.titre}</td>
                                    <td>${mylist.domaine}</td>
                                    <td>${mylist.nb_exemplaire}</td>
                                    <td>${mylist.auteur}</td>
                                    <td>
                                        <a href="Update.htm?id=${mylist.id}" class="edit" ><i class="material-icons" data-toggle="tooltip" title="Edit">&#xE254;</i></a>
                                        <a href="Delete.htm?id=${mylist.id}" class="delete" ><i class="material-icons" data-toggle="tooltip" title="Delete">&#xE872;</i></a>
                                    </td>                             
                                </tr>
                            </c:forEach>
                        </tbody>

                    </table>

                </form>
            </div>
        </div>        
    </div>     
</body>
</html>
