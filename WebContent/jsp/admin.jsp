<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="fr">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Administration</title>
</head>
<body>

		<font size=6>Administration</font>
		
			<form action="" method="post">
	
		<input type="text" name="user_name" placeholder="Nom"> <br>
		<input type="text" name="user_first_name" placeholder="Prénom"> <br>
		<input type="text" name="user_mail" placeholder="Mail"> <br>		

		<button type="submit" id="btnAddUser" formaction="<%=request.getContextPath()%>/administration/addUser">Ajouter Utilisateur</button>
		
			</form>	

</body>
</html>