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
	<section class="jumbotron text-center">
        <div class="container">
          <h1 class="jumbotron-heading">Bienvenue à La Main: Quiz!</h1>
          <p class="lead text-muted">Choisissez le quiz auquel vous souhaitez jouer.</p>
          <button type="button" class="btn btn-lg btn-outline-secondary">Amuse toi bien!</button>
        </div>
      </section>
      
<div class="album py-5 bg-light">
        <div class="container">
          <div class="row">
          <c:forEach items="${Quiz}" var="quiz" varStatus="status">
            <div class="col-md-4">
              <div class="card mb-4 box-shadow">
        
                <div class="card-body box-shadow"  style="height: 200px; width: 100%; display: block; background-color:#55595c;">
                 <p class="card-text"><h5 class="card-title" style="color:white; margin-top:50px; text-align: center;">${quiz.intitule}</h5></p>
                </div>
                <div class="card-body">
                  <div class="d-flex justify-content-between align-items-center" style="float:right">
    				<a href="/questionsJeu?IDQ=${quiz.id }&IDU=${userConnecte.id}" class="btn btn-primary"  style="background-color:#333; border:white;">Faire ce Quiz</a>
                    </div>
                    
                  </div>
                </div>
              </div>
              </c:forEach>
            </div>
           
           
            
          </div>
        </div>

</body>
</html>
