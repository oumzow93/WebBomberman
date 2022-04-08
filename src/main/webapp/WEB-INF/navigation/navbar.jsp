<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div class="bg-dark shadow mb-5">
  <div class=" container">
    <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
      <a class="navbar-brand" href="home">BOMBERMAN</a>
      <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNavDropdown" aria-controls="navbarNavDropdown" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
      </button>
    <div class="collapse navbar-collapse" id="navbarNavDropdown">
        <ul class="navbar-nav" style="margin-left: auto;" >

            <c:if test="${empty sessionScope.utilisateur }">
	            <li class="nav-item ">
	              <a class="nav-link active" href="Inscription">Inscription</a>
	            </li>
	            <li class="nav-item">
	              <a class="nav-link active" href="Connexion">Se connecter</a>
	            </li>
            </c:if>
           
            
            <c:if test="${!empty sessionScope.utilisateur }">
                <c:if test="${!empty sessionScope.Admin}">
                    <li class="nav-item">
                        <a class="nav-link active" href="Membres">Utilisateurs</a>
                    </li>
                </c:if>

             <!--   <li class="nav-item ">
                  <a class="nav-link active" href="#">Historique</a>
                </li> -->
                <li class="nav-item">
                  <a class="nav-link active" href="Moncompt">Mon compte</a>
                </li>
                <li class="nav-item">
                  <a class="nav-link active" href="Deconnexion">Deconnexion</a>
                </li>
            </c:if>
         
          </ul>
    </div>
</nav>

  </div>
</div>

