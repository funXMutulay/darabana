<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Create Activiste</title>

<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
	integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh"
	crossorigin="anonymous">

<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"
	integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6"
	crossorigin="anonymous"></script>

<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js"
	integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n"
	crossorigin="anonymous"></script>

<script
	src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
	integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo"
	crossorigin="anonymous"></script>
	
<link href="/nioun/css/niounCss.css" rel="stylesheet" type="text/css" />

</head>


<body>
	<div id="inscription">
	
	<p> Inscrivez vous pour la constitution du "FORT NOMBRE " à même de soulever des montagnes , afin de mettre
	les choses à l'endroit </p>
	
	
	
		<form action="/nioun/activiste/saveactiviste" method="post">
			<pre>


<div clas ="form-group row">
<div class="form-group col-md-4">
<LABEL for="nom">Nom</LABEL>
<input type="text" class="form-control" id="nom" placeholder=" nom">
</div> 

<div class="form-group col-md-4">
<LABEL for="prenom">Prenom</LABEL>
<input type="text" class="form-control" id="prenom"
						placeholder=" prenom">
</div> 

</div>


<div clas ="form-group row">

<div class="form-group col-md-4">
<LABEL for="addresse">Addresse</LABEL>
<input type="text" class="form-control" id="addresse"
						placeholder=" addresse">
</div>
 
<div class=" form-group col-md-4">
<label for="mail">Email:</label> 
<input type="email" id="mail" class="form-control" placeholder="email ">
</div>

</diV>


<div clas ="form-group row">


<div class="form-group col-md-4">
<label for="numTel">Numero:</label>
<input type="number" id="numtel" class="form-control"
						placeholder="numero telephone" />
</div>
  
  <div class="form-group col-md-4">
    <label for="organisation">Organisation</label>
    <select class="form-control" id="organisation">
      <option>Y' en a Marre</option>
      <option>FRAPP</option>
      <option>Aar Lii Nu Book</option>
      <option>No Lank</option>
      <option>Gilets Rouges</option>
      <option>Non Aligné</option>
    </select>
  </div>
  
 <div class="form-group col-md-4">
 <label>  </label>
<button type="submit" class="btn btn-primary">SAUVER</button>
</div>

</div>

</form>
		${msg} <a href="listeActiviste">Voir la liste des Activistes</a>
	</div>
	


	
</body>
</html>