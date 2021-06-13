$(window).bind('beforeunload', function(){
    let currStatus = document.getElementById('currentUserStatus').value;
    if(!currStatus){
        console.log("User Blocked")
        window.location = "/logout";
    }
    if(currStatus){
        console.log("User NOT Blocked")
    }
});