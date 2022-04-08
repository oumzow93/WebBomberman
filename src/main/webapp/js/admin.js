var bouton = document.getElementsByClassName("btn btn-success");
//var bouton = document.getElementsByClassName("btn btn-success");


for(var i=0; i<bouton.length;i++){
        bouton[i].setAttribute("name","statut"+i)
       // console.log(bouton[i].name)
               
        //console.log(bouton[1])
        bouton[i].addEventListener("click", function(e) {
            if(e.target.innerHTML=="debloquer"){
                
                e.target.innerHTML="bloquer"
                e.target.setAttribute("class","btn btn-danger")
                e.target.setAttribute("value","bloquer")
                console.log(e.target.name)
                
            }else{
                e.target.innerHTML="debloquer"
                e.target.setAttribute("class","btn btn-success")
                e.target.setAttribute("value","debloquer")
                console.log(e.target.name)
                
                
            }
            
            
        })
        
}
    

    


