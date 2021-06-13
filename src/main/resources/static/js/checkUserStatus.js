$(window).bind('beforeunload', function(){
    let currStatus = document.getElementById('currentUserStatus').value;
    $(window).on('unload', function() {
        if(currStatus === 'false'){
            window.location.href = '/logout';
        }
    });
});