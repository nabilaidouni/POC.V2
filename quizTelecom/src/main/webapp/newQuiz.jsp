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
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
</head>
<body>
	<nav class="navbar navbar-light bg-light">
	  <span class="navbar-brand mb-0 h1">Bonjour</span>
	  <a class="navbar-brand" href="pageadmin">Home</a>
	  <a class="navbar-brand" href="index">Deconnexion</a>
	</nav>

	<div class="text-center"><h1 class="display-1">Création de quiz</h1></div>
	<div class= "container">
	</div>
	
	<form  action="inscriptionPost" method="post" class="container rounded">
	<div class="form-group">
	    <label for="nom">Intitulé du quiz:</label>
	    <input type="text" class="form-control" name="NOM" placeholder="Entrez l'intitulé" required>
	  </div>
	  <div class="form-group">
	    <label for="identifiant">Question 1:</label>
	    <input type="text" class="form-control" name="question" placeholder="Entrez votre question" required>
	  </div>
	  <c:forEach var="i" begin="0" end="3" step="1">
	  <div class="form-group">
	    <label for="identifiant">Reponse ${i+1}:</label>
	    <input type="text" class="form-control" name="question" placeholder="Entrez votre reponse" required>
	  </div>
	  </c:forEach>
	  <label>Veuillez cocher la bonne réponse</label>
	  <c:forEach var="i" begin="0" end="3" step="1">
	  <div class="form-group">
		  <input class="form-check-input" type="radio" name="exampleRadios" id="exampleRadios1" value="option1">
		  <label class="form-check-label" for="exampleRadios1">
		    Reponse ${i+1}
		  </label>
		</div>
		</c:forEach>
	  
	  <button type="submit" class="btn btn-primary">Créer le quiz</button>
	</form>
</body>
</html>