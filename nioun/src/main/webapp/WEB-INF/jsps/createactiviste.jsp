<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Create Activiste</title>
</head>
<body>
<form action="saveActiviste" method="post">
<pre>
Nom:<input type="text" name="nom" />
Prenom:<input type="text" name="prenom">
Addresse:<input type="text" name="addresse"/>
Email:<input type="text" name="mail"/>
Numero:<input type="text" name="numtel"/>
Organisation:Y' en a Marre<input type="radio" name="organisation" value="Y' en a Marre"/>
	Aar Lii Nu Book<input type="radio" name="organisation" value="Aar Lii Nu Book"/>
	 No Lank<input type="radio" name="organisation" value="No Lank"/>
	 Gilets Rouges<input type="radio" name="organisation" value="Gilets Rouges"/>
	 Non Aligné<input type="radio" name="organisation" value="Non Aligné"/>
<input type="text" value="save">
</pre>
</form>
${msg}
<a href="displayActivistes">Voir la liste des  Activistes</a>
</body>
</html>