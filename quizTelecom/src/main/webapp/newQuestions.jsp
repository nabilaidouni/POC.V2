<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Création de questions</title>
<link href="style/bootstrap/css/bootstrap.min.css" rel="stylesheet">
	<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
   	<!-- jQuery et popper toujours avant JS !	 -->
   	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
  	
	<link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/v/dt/dt-1.10.20/datatables.min.css"/>
	<script type="text/javascript" src="https://cdn.datatables.net/v/dt/dt-1.10.20/datatables.min.js"></script>

</head>
<body>

	<div class="text-center"><h1 class="display-1">Création de quiz</h1></div>
	
	<form  action="questionsNewPost" method="post" class="container rounded">
	<span class="border">
		<div class="form-group">
		    <label for="question">Question:</label>
			<input type="text" class="form-control" name="question" placeholder="Entrez votre question" required>
		</div>
		<c:forEach var="j" begin="1" end="4" step="1">
		  <div class="form-group">
		    <label for="reponse${j}">Reponse ${j}:</label>
		    <input type="text" class="form-control" name="reponse${j}" placeholder="Entrez votre reponse" required>
		  </div>
		  
		  
		  <div class="form-check">
			  <input class="form-check-input" type="radio" name="reponse${j}Check" id="exampleRadios1" value="0" checked>
			  <label class="form-check-label" for="exampleRadios1">
			    FAUX
			  </label>
			</div>
			<div class="form-check">
			  <input class="form-check-input" type="radio" name="reponse${j}Check" id="exampleRadios2" value="1">
			  <label class="form-check-label" for="exampleRadios2">
			    VRAI
			  </label>
			</div>
<!-- 		  <div class="form-group"> -->
<!-- 			  <input class="form-group" type="checkbox" name="reponse${j}Check" value=""> -->
<!-- 			  <label class="form-group" for="exampleRadios1">Réponse juste</label> -->
<!-- 		</div> -->
	 	</c:forEach>
	 </span>
	 <input type="number" name="idQuiz" value=${idQuiz} style="display: none;">
	 <input type="number" name="nbQuestions" value="${nbQuestions-1}" style="display: none;">
	 <button type="submit" class="btn btn-primary">Créer le quiz</button>
	</form>
</body>
</html>