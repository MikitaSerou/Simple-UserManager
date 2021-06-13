$(document).ready ( function(){
    let currStatus = document.getElementById('currentUserStatus').value;
    if(!currStatus){
        window.location = "/logout";
    }
});