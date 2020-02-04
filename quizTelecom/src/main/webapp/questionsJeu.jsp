<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Page Jeu</title>
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
	  <span class="navbar-brand mb-0 h1">Voux pouvez Jouer</span>
	  <a class="navbar-brand" href="">Home</a>
	  <a class="navbar-brand" href="index">Deconnexion</a>
	</nav>
	<h1>${quiz.intitule}</h1>

		    <div class="card text-center" style="width: 18rem;">
			  <div class="card-body">
			    <h5 class="card-title">${question.intitule }</h5>
			    <form action = "questionSuivante" method = "post">
			    <input type="hidden" name = "idQuestion" value="${question.id }"/>
			    <input type="hidden" name = "nQuestion" value="${nQuestion }"/>
			    <input type="hidden" name = "IDQ" value="${quiz.id }"/>
			    <input type="hidden" name = "IDU" value="${user.id }"/>
			    
			    
			    <table>
			    <tbody>
			    <c:forEach var = "i" begin ="0" end = "3" step="1">
			    	<tr>
			    		<td>
			    			${reponses[i].intitule }
			    		</td>
			    		<td>
			    			<input type="checkbox" value=${reponses[i].intitule } name="reponse${i }"/>
			    		</td>

			    	</tr>
			    </c:forEach>
			    	<tr><td><input type = "submit" value = "Suivant"/></td></tr>
			    </tbody>
			    </table>
			    </form>
			  </div>
		  </div>

</body>
</html>