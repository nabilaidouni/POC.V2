<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Page Client</title>
<link href="style/bootstrap/css/bootstrap.min.css" rel="stylesheet">
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<!-- jQuery et popper toujours avant JS !	 -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
<link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/v/dt/dt-1.10.20/datatables.min.css"/>
<script type="text/javascript" src="https://cdn.datatables.net/v/dt/dt-1.10.20/datatables.min.js"></script>
</head>
<body>
	<nav class="navbar navbar-light bg-light">
	  <span class="navbar-brand mb-0 h1">Bonjour ${userConnecte.identifiant }</span>
	  <a class="navbar-brand" href="">Home</a>
	  <a class="navbar-brand" href="index">Deconnexion</a>
	</nav>
	<table class="table text-center">
	  <tbody>
		<c:forEach items="${Quiz}" var="quiz" varStatus="status">
	    <tr>	
	    <td>
		    <div class="card text-center" style="width: 18rem;">
			  <div class="card-body">
			    <h5 class="card-title">${quiz.intitule}</h5>
			    <a href="/questionsJeu?IDQ=${quiz.id }&IDU=${userConnecte.id}" class="btn btn-primary">Faire ce Quiz</a>
			  </div>
		  </div>
		</td>
	    </tr>
	    </c:forEach>
	  </tbody>
	</table>
</body>
</html>