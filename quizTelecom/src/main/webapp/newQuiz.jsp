<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Création de quiz</title>
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
 
 <a class="btn d-none d-lg-inline-block mb-3 mb-md-0 ml-md-3" href="index">Deconnexion</a>
</header>
<div class="container" style="margin-left:600px; margin-top:50px">
		<div class="login-logo">
    		<h2 style= "color: #333"><b>Création de quiz</b></h2>
  		</div>
  		
  		<div class="row">
 			 <div class="col-6" style="border: solid #333; margin-bottom:50px" >

	
	<form  action="newQuizPost" method="post" class="container rounded">
	<div class="form-group" style=" margin-top:30px">
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
	  
	 

	   <div style="float:right; margin-bottom:20px" class="col-xs-4">
		    <button type="submit" class="btn btn-primary"  style="background-color:#333; border:white;">Suivant</button>
	 	
		  </div>
		</form>
		
		</div>
		</div>
		</div>
</body>
</html>