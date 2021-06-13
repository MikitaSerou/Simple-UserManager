$(window).bind('beforeunload', function(){
    let currStatus = document.getElementById('currentUserStatus').value;
    if(currStatus === true){
        console.log("User Blocked")
        window.location = "/logout";
    }
});