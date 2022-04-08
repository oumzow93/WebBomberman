<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Moncompte</title>
<link
    href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
    rel="stylesheet"
    integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
    crossorigin="anonymous">

</head>
<body>
    <%@ include file="../navigation/navbar.jsp"%>
    
         <div class="row">
                <div class="col col-md-4 mx-auto shadow"  style="background-color: #e5e7e9; margin-top: 60px"></div>
        </div>

    
    
  

    
    <div class="container mb-5">
        <div class="d-grid gap-2 mb-2 mt-2">
            <button class="btn btn-outline-info" type="button" id="info">Informations Utilisateurs</button>
            
        </div>

        <div id="infoUtilisateur">
            <div class="row" >
            
                <div class="col-3">
                    PSEUDO : ${MonUtilisateur.pseudo}
                </div>
                
                <div class="col-3">
                    NOM : ${MonUtilisateur.nom}
                </div>
                
                <div class="col-3">
                    PRENOM : ${MonUtilisateur.prenom}
                </div>
                
                 <div class="col-3">
                    EMAIL : ${MonUtilisateur.email}
                </div>
            </div>
                
            
  
            
        </div>  
        
       
        

        <div class ="mt-1">
             <div class="d-grid gap-2 mb-2 mt-2">
                    <button class="btn btn-outline-info" type="button" id="partie">Parties Jouées</button>
            
            </div>
            <div id ="div_partie">
            
               <table class="table">
                    <thead class="table-info">
                         <tr>
                            <th>Partie</th>
                            <th>Debut</th>
                            <th>Fin</th>
                            <th>Mode</th>
                            <th>Score</th>
                            <th>Resultat</th>
                        </tr>
                    </thead>
                    <tbody>
    
                        <c:forEach items="${Parties}" var="partie" varStatus="vs">
     
                              <tr>
                                <td>${vs.count}</td>
                                 <td>${partie.dateDebut}</td>
                                 <td>${partie.dateFin}</td>
                                 <td>${partie.mode}</td>
                                 <td>${partie.score}</td>
                                 <td>${partie.resultat}</td>
                             </tr>
                        </c:forEach>
                    </tbody>
                </table>
            
            
                    
            </div>
                

            </div>
       
        
        <div class="d-grid gap-2 mb-2 mt-2">
            <button class="btn btn-outline-info" type="button" id="editer">Editer</button>
            
        </div>
        
        <div class="mt-1" id="form_cache">
            
                
                <form method="post">
                <div class="form-group mb-3 bg-Secondary">
                        
                        <input type="text" value="${nom_utilisateur }" name="pseudo" id="utilisateur" class="form-control" required autofocus placeholder="pseudo">
                        
                 </div>
                 <div class="form-group mb-3 ">
                        
                        <input type="text" value="${nom }" name="nom" id="nom" class="form-control" required placeholder="Nom">
                  </div>
                   <div class="form-group mb-3">
                        
                        <input type="text" value="${prenom }" name="prenom" id="prenom" class="form-control" required placeholder="Prenom">
                  </div>
                   <div class="form-group mb-3 bg-Secondary">
                        
                        <input type="email" value="${email }" name="email" id="Email" class="form-control" required autofocus placeholder="Adress e-mail">
                        
                    </div>

                    <div class="form-group mb-3">
                        
                        <input type="password" value="" name="password" id="Password" class="form-control" required placeholder="Mot de passe">
                    </div>
                    <div class="form-group mb-3 bg-Secondary">
                        
                        <button type="submit" class="btn btn-info" id="valide" name="update">Update</button>
                        
                    </div>
            </form>
                
            
            

        </div>
        
        

        <div>
            <form method="post">
                        <button type="submit" name="supprimer" class ="mt-3" >
                            <svg xmlns="http://www.w3.org/2000/svg" width="40" height="40"
                                fill="currentColor" class="bi bi-trash" viewBox="0 0 16 16">
                                <path
                                    d="M5.5 5.5A.5.5 0 0 1 6 6v6a.5.5 0 0 1-1 0V6a.5.5 0 0 1 .5-.5zm2.5 0a.5.5 0 0 1 .5.5v6a.5.5 0 0 1-1 0V6a.5.5 0 0 1 .5-.5zm3 .5a.5.5 0 0 0-1 0v6a.5.5 0 0 0 1 0V6z" />
                                <path fill-rule="evenodd"
                                    d="M14.5 3a1 1 0 0 1-1 1H13v9a2 2 0 0 1-2 2H5a2 2 0 0 1-2-2V4h-.5a1 1 0 0 1-1-1V2a1 1 0 0 1 1-1H6a1 1 0 0 1 1-1h2a1 1 0 0 1 1 1h3.5a1 1 0 0 1 1 1v1zM4.118 4 4 4.059V13a1 1 0 0 0 1 1h6a1 1 0 0 0 1-1V4.059L11.882 4H4.118zM2.5 3V2h11v1h-11z" />
                                </svg>
                        </button>

                       
                    </form>
        
            
        </div>
     </div>            

        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
    <script type="text/javascript"> <%@include file="/js/formulaire.js" %></script> 

</body>

</html>