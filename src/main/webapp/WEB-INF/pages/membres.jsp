<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<title>Utilisateurs</title>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">


</head>
<body>

    <%@ include file="../navigation/navbar.jsp"%>
    <div class="container mb-3">
        <div class="row">
            <div class="col col-md-4 mx-auto shadow"
                style="background-color: #e5e7e9; margin-top: 60px"></div>
        </div>
    </div>

    <c:out value=""></c:out>
    <div class="text-center">
        <br />
        <h1>Utilisateurs</h1>
    </div>
    
    
    <div class="container">
        <form method="post" action="Membres">
        <table class="table">
        <thead class="table">
            <thead class="table-info">
                <tr>
                    <th>PSEUDO</th>
                    <th>NOM</th>
                    <th>PRENOM</th>
                    <th>EMAIL</th>
                    <th>STATUT</th>
                </tr>
    
        </thead>
        <tbody class ="${nombre}" id ="nombreUtilisateur">
            <c:forEach items="${utilisateurs}" var="user" varStatus="vs">
                <tr>
                    <td>${user.pseudo}</td>
                    <td>${user.nom}</td>
                    <td>${user.prenom}</td>
                    <td>${user.email }</td>
                     <c:if test ="${statut[vs.index]=='debloquer' }">
                        <td><input type="button" class="btn btn-success"   value ="debloquer"></td>
                      <!--   <input type ="hidden"  value="debloquer">  -->
                        
                     </c:if>
                     
                     <c:if test ="${statut[vs.index]=='bloquer' }">
                        <td><input type="button" class="btn btn-danger"  value="bloquer">BLOQUER</td>
                      <!--   <input type ="hidden"  name="wele" value="bloquer">  -->
                     </c:if>
                    
                </tr>
                
            </c:forEach>
            
    
        </tbody>
        </table>
        <button type="submit" class="btn btn-info mt-5  " name="Valider" >VALIDER LES MODIFICATION</button>
        
       </form>
    </div>
            
            
            <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
    <script type="text/javascript"> <%@include file="/js/admin.js" %></script> 
            
            
            

</body>

</html>



