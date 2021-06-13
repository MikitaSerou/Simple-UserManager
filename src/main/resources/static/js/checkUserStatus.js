$(window).bind('beforeunload', function(){
    let currStatus = document.getElementById('currentUserStatus').value;
    console.log(currStatus)
    if(currStatus === 'false'){
        window.location = '/logout';
    }
});