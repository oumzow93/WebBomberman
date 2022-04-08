<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>inscription</title>
    
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
</head>
<body >
     <%@ include file="../navigation/navbar.jsp" %>
 
      

     <div class="container text-center col col-md-3" >
	    <c:if test="${ !empty erreur }">
	        <div class="alert alert-danger" role="alert">
	            <c:out value="${erreur}" />
	         </div>
	      </c:if>

        
     </div>
    <div class="row">
        <div class="col col-md-3 mx-auto shadow " style="background-color:#e5e7e9; margin-top:60px;">
            <div class="mt-3 mb-3 text-center">
                    <img src="img/images.png" alt="" width="60">
                 
            </div>
            <h4 class="text-center mb-5">Créer un nouveau compte</h4>
            <form method="post" action="Inscription" >
                <div class="form-group mb-3 bg-Secondary">
                        
                        <input type="text" value="" name="nom_utilisateur" id="utilisateur" class="form-control" required autofocus placeholder="Nom d'utilisateur">
                        
                 </div>
                 <div class="form-group mb-3">
                        
                        <input type="text" value="" name="nom" id="nom" class="form-control" required placeholder="Nom">
                  </div>
                   <div class="form-group mb-3">
                        
                        <input type="text" value="" name="prenom" id="nom" class="form-control" required placeholder="Prenom">
                  </div>
                   <div class="form-group mb-3 bg-Secondary">
                        
                        <input type="email" value="" name="email" id="Email" class="form-control" required autofocus placeholder="Adress e-mail">
                        
                    </div>

                    <div class="form-group mb-3">
                        
                        <input type="password" value="" name="password" id="Password" class="form-control" required placeholder="Mot de passe">
                    </div>
                    <div class="form-group mb-3 bg-Secondary">
                        
                        <input type="password" value="" name="confirmation" id="confirmation" class="form-control" required autofocus placeholder="Confirmer le mot de passe">
                        
                    </div>
                    <div class="d-grid gap-2 mb-5">
                        <button class="btn btn-lg btn-primary" type="submit">S'inscrire</button>
                      </div>

                      <p class="text-center text-muted mt-5 mb-3"> Vous avez dejà un compte ? <a href="Connexion">Connexion</a></p>
            </form>
        </div>
    </div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
</body>
</html>