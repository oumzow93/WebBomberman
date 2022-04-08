<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

    
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <title>Athentification</title>
        <link rel="shortcut icon" href="#" />
       
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">


   
    
   
   
  </head>
  <body >
     <%@ include file="../navigation/navbar.jsp" %>
     
   
     
    <div class="container text-center col col-md-3" >
    
        <c:if test="${!empty sessionScope.SuccesCreation }">
              <div class="alert alert-success" role="alert" id="altert-Sucess">
                <c:out value="${sessionScope.SuccesCreation }" />
             </div>
       </c:if>
    
    
    
        <c:if test="${ !empty erreur }">
            <div class="alert alert-danger" role="alert">
                <c:out value="${erreur}" />
             </div>
          </c:if>        
     </div>
    
    
    <div class="container mb-3">


        <div class="row">
            <div class="col col-md-4 mx-auto shadow" style="background-color:#e5e7e9; margin-top:60px">
               <div class="mt-3 text-center">
                    <img src="img/images.png" alt="" width="60">
                 
                </div>
                <h4 class="text-center mb-5">Veuillez vous connecter</h4>
                

                <form method="post">

                


                    <div class="form-group mb-3 bg-Secondary">
                        
                        <input type="text" value="" name="pseudo" id="Email" class="form-control" required autofocus placeholder="Pseudo">
                        
                    </div>

                    <div class="form-group mb-3">
                        
                        <input type="password" value="" name="password" id="Password" class="form-control" required placeholder="Mot de passe">
                    </div>
                    <input type="hidden" name="_csrf_token" value="{{ csrf_token('authenticate') }}" >

                    <div class="d-flex mb-3 justify-content-between">
                        <div class="checkbox mb-3">
                            <label>
                                <input type="checkbox" name="_remember_me"> Remember me
                            </label>
                        </div>
                        <a href="#">Mot de passe oublier?</a>

                    </div>


                    <div class="d-grid gap-2 mb-5">
                        <button class="btn btn-lg btn-primary" type="submit">S'identifier</button>
                      </div>

                      <p class="text-center text-muted mt-5 mb-3"> Pas de compte ? <a href="Inscription">Inscription</a></p>

                </form>
            </div>
        </div>





   
    </div>

    
    
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
</body>
   
</html>