<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="style/bootstrap/css/bootstrap.min.css" rel="stylesheet">
	<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
   	<!-- jQuery et popper toujours avant JS !	 -->
   	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
  	
	<link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/v/dt/dt-1.10.20/datatables.min.css"/>
	<script type="text/javascript" src="https://cdn.datatables.net/v/dt/dt-1.10.20/datatables.min.js"></script>
<title>Result</title>
</head>
<body class="text-center" >

<div class="cover-container d-flex h-100 p-3 mx-auto flex-column" >
     

      <main role="main" class="inner cover">
        <h1 class="cover-heading">Félicitations ${user.identifiant}!</h1>
        <p class="lead">Vous avez terminé le quiz ${quiz.intitule}. </p>
        <p class="lead">Voici votre score: ${score.value}. </p>
        <p class="lead">
          <a href="/pageclient?IDU=${user.identifiant}" class="btn btn-lg btn-secondary">Rejouer!</a>
        </p>
      </main>

     
    </div>
 
  

</body>
</html>
<style>

.cover {
    padding: 0 1.5rem;
}

 .text-center {
    text-align: center !important;}
   .lead {
    font-size: 1.25rem;
    font-weight: 300;
}
    body {
margin-top: 200px;
   justify-content: center;
text-shadow: 0 .05rem .1rem
rgba(0, 0, 0, .5);
height: 100%;
background-color:#333;
color: #fff;
font-family: -apple-system,BlinkMacSystemFont,"Segoe UI",Roboto,"Helvetica Neue",Arial,sans-serif,"Apple Color Emoji","Segoe UI Emoji","Segoe UI Symbol";
font-size: 1rem;
font-weight: 400;
line-height: 1.5;
}
 h1 {
    font-size: 2.5rem;
    margin-bottom: .5rem;
    font-family: inherit;
    font-weight: 500;
    line-height: 1.2;
    color: inherit;
}


</style>

      


