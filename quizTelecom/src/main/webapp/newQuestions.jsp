<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Création de questions</title>
		<link href="style/bootstrap/css/bootstrap.min.css" rel="stylesheet">
	<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
   	<!-- jQuery et popper toujours avant JS !	 -->
   	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
  	  <meta content='width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no' name='viewport'>

  <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css" rel="stylesheet" type="text/css" />
  
	<link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/v/dt/dt-1.10.20/datatables.min.css"/>
	<script type="text/javascript" src="https://cdn.datatables.net/v/dt/dt-1.10.20/datatables.min.js"></script>
   <!--<script type="text/javascript">$(document).ready(function() {$('#tableau').DataTable({"pageLength": 4} );} );</script>-->
	</head>
	<body style="background-color:#f5f5f5">
	<header class="navbar navbar-light bg-light">
  <div class="navbar-nav-scroll">
    <ul class="navbar-nav bd-navbar-nav flex-row">
      <li class="nav-item">
        <a class="navbar-brand" href="pageadmin">Home</a>
      </li>
      <li class="nav-item">
        <a class="navbar-brand" href="newQuiz">Quiz</a>
      </li>
    </ul>
  </div>
  <ul class="navbar-nav ml-md-auto">
    <li class="nav-item">
    	<span class="navbar-brand mb-0 h1">Bonjour ${userConnecte.identifiant} </span>
    </li>
  </ul>
 <a class="btn d-none d-lg-inline-block mb-3 mb-md-0 ml-md-3" href="index">Deconnexion</a>
</header>
		<div class="container" style="margin-left:600px; margin-top:50px">
		<div class="login-logo">
    		<h2 style= "color: #333"><b>Création de question</b><br>Question ${nbQuestions}</h2>
  		</div>
  		
  		<div class="row">
 			 <div class="col-6" style="border: solid #333; margin-bottom:50px" >
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

	 	</c:forEach>
	 </span>
	 
		   <div style="float:right; margin-bottom:20px" class="col-xs-4">
		   <input type="number" name="idQuiz" value=${idQuiz} style="display: none;">
	 		<input type="number" name="nbQuestions" value="${nbQuestions-1}" style="display: none;">
	 		<button type="submit" class="btn btn-primary" style="background-color:#333; border:white;">Créer le quiz</button>
		  </div>
		</form>
		
		</div>
		</div>
		</div>
	</body>



	
	
	
</body>
</html>