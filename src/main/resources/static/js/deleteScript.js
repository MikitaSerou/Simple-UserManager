$(function () {
    let currId = document.getElementById('currentUserId').value;
    console.log(currId)
    $('button#deleteButton[type=submit]').click(function (e) {
        console.log("Delete ajax");
        e.preventDefault();
        let form = document.forms['userManagementForm'];
        let formData = new FormData(form);
        let ajaxReq = $.ajax({
            url:document.getElementById('deleteUrl').value,
            type: 'DELETE',
            data: formData,
            cache: false,
            contentType: false,
            processData: false,
            xhr: function () {
                let xhr = $.ajaxSettings.xhr();
                return xhr;
            },
        });
        ajaxReq.done(function (msg) {
            formData.getAll('userId').forEach(element => {
                    if(element === currId){
                        window.location = "/logout";
                    }
                    jQuery('#row' + element).hide(700);
                }
            );
        });
        ajaxReq.fail(function (jqXHR) {
            console.log("Error when try to delete users")
        });
    });
});