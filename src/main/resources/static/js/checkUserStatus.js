$(window).bind('beforeunload', function(){
    let currStatus = document.getElementById('currentUserStatus').value;

    if(currStatus === 'false'){
        console.log(currStatus === 'false')
        window.location.href = '/logout';
    }
});