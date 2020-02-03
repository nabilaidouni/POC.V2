<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Nouveau Quizz</title>
<link href="style/bootstrap/css/bootstrap.min.css" rel="stylesheet">
	<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
   	<!-- jQuery et popper toujours avant JS !	 -->
   	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
  	
	<link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/v/dt/dt-1.10.20/datatables.min.css"/>
	<script type="text/javascript" src="https://cdn.datatables.net/v/dt/dt-1.10.20/datatables.min.js"></script>
   <!--<script type="text/javascript">$(document).ready(function() {$('#tableau').DataTable({"pageLength": 10} );} );</script>-->
</head>
<body>
	<nav class="navbar navbar-light bg-light">
	  <span class="navbar-brand mb-0 h1">Bonjour</span>
	  <a class="navbar-brand" href="pageadmin">Home</a>
	  <a class="navbar-brand" href="index">Deconnexion</a>
	</nav>

	<div class="text-center"><h1 class="display-1">Création de quiz</h1></div>
	
	<form  action="newQuizPost" method="post" class="container rounded">
	<div class="form-group">
	    <label for="intitule">Intitulé du quiz:</label>
	    <input type="text" class="form-control" name="intitule" placeholder="Entrez l'intitulé" required>
	  </div>
	  <div class="form-group">
		  <div class="input-group-prepend">
		    <label class="input-group-text" for="nbQuestions">Choisir le nombre de questions</label>
		  </div>
		  <select class="custom-select" name="nbQuestions">
		    <option selected>Choisissez...</option>
		    <option value="1">Une</option>
		    <option value="2">Deux</option>
		    <option value="3">Trois</option>
		    <option value="4">Quatre</option>
		    <option value="5">Cinq</option>
		    <option value="6">Six</option>
		  </select>
	</div>
	  
	  <button type="submit" class="btn btn-primary">Suivant</button>
	</form>
</body>
</html>