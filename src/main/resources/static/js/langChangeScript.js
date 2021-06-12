$(document).ready(function() {
    const queryString = window.location.search;
    const urlParams = new URLSearchParams(queryString);
    const product = urlParams.get('lang')
    console.log(product);
    console.log(queryString);
    $("#locales").change(function () {
        var selectedOption = $('#locales').val();
        if (selectedOption != ''){
            window.location.replace(window.location.href + '?lang='  + selectedOption);
        }
    });
});