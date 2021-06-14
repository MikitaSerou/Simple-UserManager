$(function () {
    let currStatus = document.getElementById('currentUserStatus').value;
    if (currStatus === 'false') {
        window.location = "/logout";
    }
});