let modif = document.getElementById("update");
let btn_valide=document.getElementById("valide");
let div = document.getElementById("form_cache");


let div_info = document.getElementById("infoUtilisateur");
let btn_info=document.getElementById("info");
//let div = document.getElementById("form_cache");

let div_formcache = document.getElementById("form_cache");
let btn_editer=document.getElementById("editer");
//let div = document.getElementById("form_cache");


//div.style.display = "none";
//modif.addEventListener("click", () => {
  
    //div.style.display = "block";
  
//})
div_info.style.display = "none";
btn_info.addEventListener("click", () => {
 if(getComputedStyle(div_info).display != "none"){
    div_info.style.display = "none";
  } else {
    div_info.style.display = "block";
  }
})

div_formcache.style.display = "none";
btn_editer.addEventListener("click", () => {
 if(getComputedStyle(div_formcache).display != "none"){
    div_formcache.style.display = "none";
  } else {
    div_formcache.style.display = "block";
  }
})


let div_partie = document.getElementById("div_partie");
let btn_partie=document.getElementById("partie");

div_partie.style.display = "none";

btn_partie.addEventListener("click", () => {
 if(getComputedStyle(div_partie).display != "none"){
    div_partie.style.display = "none";
  } else {
    div_partie.style.display = "block";
  }
})



