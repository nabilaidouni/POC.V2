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
<body style="background-color:#f5f5f5">
	<header class="navbar navbar-light bg-light">
  <div class="navbar-nav-scroll">
    <ul class="navbar-nav bd-navbar-nav flex-row">
      <li class="nav-item">
        <a class="navbar-brand" href="pageclient?IDU=${user.identifiant}">Home</a>
      </li>
    </ul>
  </div>
  <ul class="navbar-nav ml-md-auto">
    <li class="nav-item">
    	<span class="navbar-brand mb-0 h1">Bonjour ${user.identifiant} </span>
    </li>
  </ul>
 <a class="btn d-none d-lg-inline-block mb-3 mb-md-0 ml-md-3" href="index">Deconnexion</a>
</header>
<div class="container" style=" margin-top:150px;">
		<div class="text-center login-logo">
    		<h2 style= "color: #333"><b>${quiz.intitule}</b></h2>
  		</div>
	
	<div class="row">
 			 <div class="col-6" style="border: solid #333 ; margin: auto;">
 			 
			    <form action = "questionSuivante" method = "post">
			    
			    <div class="form-group" style="margin-top:20px; margin-bottom:20px"">
			    <div class="card mb-2 box-shadow">
				      <img src="style/${question.media}">
				</div>
		    		<h4 class="card-title">${question.intitule }?</h4>
				<hr>
				
			    <input type="hidden" name = "idQuestion" value="${question.id }"/>
			    <input type="hidden" name = "nQuestion" value="${nQuestion }"/>
			    <input type="hidden" name = "IDQ" value="${quiz.id }"/>
			    <input type="hidden" name = "IDU" value="${userConnecte.id }"/>
			    </div>
			    
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
			    
			    	
			    </tbody>
			    </table>
			    <div style="float:right; margin-bottom:20px" class="col-xs-4">
		  			<button type="submit" class="btn btn-primary" style="background-color:#333; border:white;">Suivant</button>
		  			
		  		</div>
			    </form>
			  </div>
		  </div>
</div>
</body>

  		

</html>

