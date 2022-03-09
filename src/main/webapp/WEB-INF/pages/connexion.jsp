<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Connexion</title>
 <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
 
</head>
<body>
    <div class="container">


        <div class="row">
            <div class="col col-md-6 mx-auto shadow bg-white"  style="margin: 0 auto;">
               <!-- <div class="mt-3 mb-3">
                    <img src="image/logo.png" alt="">
                </div>-->
                <h1 class="text-center mb-5">Please sign in</h1>
                

                <form method="post">
   
                


                    <div class="form-group mb-3">
                        <label for="Email">Email</label>
                        <input type="email"  name="email" id="Email" class="form-control" required autofocus>
                    </div>

                    <div class="form-group mb-3">
                        <label for="Password">Password</label>
                        <input type="password" name="password" id="Password" class="form-control" required>
                    </div>
                    <input type="hidden" name="_csrf_token" value="{{ csrf_token('authenticate') }}" >

                    <div class="d-flex mb-3 justify-content-between">
                        <div class="checkbox mb-3">
                            <label>
                                <input type="checkbox" name="_remember_me"> Remember me
                            </label>
                        </div>
                        <a href="#">Mot de passe oublier ?</a>

                    </div>


                    <div class="d-grid gap-2 mb-5">
                        <button class="btn btn-lg btn-primary" type="submit">Se connecter</button>
                      </div>

                      <p class="text-center text-muted mt-5 mb-3"> Pas de compte ? <a href="{{path('inscription')}}">Inscription</a></p>

                </form>
            </div>
        </div>





   
    </div>
    </div>
    
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>



</body>
</html>