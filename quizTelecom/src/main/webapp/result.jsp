<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Result Client</title>
<link href="style/bootstrap/css/bootstrap.min.css" rel="stylesheet">
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<!-- jQuery et popper toujours avant JS !	 -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
<link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/v/dt/dt-1.10.20/datatables.min.css"/>
<script type="text/javascript" src="https://cdn.datatables.net/v/dt/dt-1.10.20/datatables.min.js"></script>

</head>
<body style="background-color: #e9ecef">
<header class="navbar navbar-light bg-light">
  <div class="navbar-nav-scroll">
    <ul class="navbar-nav bd-navbar-nav flex-row">
      <li class="nav-item">
        <a class="navbar-brand" href="pageclient?IDU=${userConnecte.identifiant}">Home</a>
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

	<div class="text-center cover-container d-flex h-100 p-3 mx-auto flex-column" style="margin-top:200px" >
	
        <div class="container">
          <h1 class="jumbotron-heading">Félicitations ${userConnecte.identifiant}!</h1>
          <p class="lead text-muted">Vous avez terminé le quiz ${quiz.intitule}.</p>
          <h1 class="jumbotron-heading">Voici votre score: ${score.value}.</h1>
        <br>
          <a href="/pageclient?IDU=${userConnecte.identifiant}" class="btn btn-lg btn-outline-secondary">Rejouer!</a>
        </div>
 
      </div>

</body>
</html>

      


