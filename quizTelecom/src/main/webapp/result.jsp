  <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
 <link rel="stylesheet" type="text/css" href="style/theme1.css"/>  
 
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
  <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
  
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
<title>Result</title>
</head>

<title>Insert title here</title>
</head>
<body class="text-center" style='background-color:dimgray '>

<div class="cover-container d-flex h-100 p-3 mx-auto flex-column" style="margin-top:200px">
     

      <main role="main" class="inner cover">
        <h1 class="cover-heading">Felicitations ${user.identifiant}!</h1>
        <p class="lead">You have finished the ${quiz.intitule} quiz. </p>
        <p class="lead">This is your score: ${score.value}. </p>
        <p class="lead">
          <a href="#" class="btn btn-lg btn-secondary">Play again!</a>
        </p>
      </main>

     
    </div>
     
    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" crossorigin="anonymous"></script>
    <script>window.jQuery || document.write('<script src="../../assets/js/vendor/jquery-slim.min.js"><\/script>')</script>
    <script src="../../assets/js/vendor/popper.min.js"></script>
    <script src="../../dist/js/bootstrap.min.js"></script>
  
<style>
h1, p{color:white}
</style>
</body>
</html>


      


