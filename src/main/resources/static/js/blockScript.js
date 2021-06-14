$(function () {
    let currId = document.getElementById('currentUserId').value;
    console.log(currId)
    $('button#blockButton[type=submit]').click(function (e) {
        console.log("Block ajax");
        e.preventDefault();
        let form = document.forms['userManagementForm'];
        let formData = new FormData(form);
        let ajaxReq = $.ajax({
            url:document.getElementById('blockUrl').value,
            type: 'PATCH',
            data: formData,
            cache: false,
            contentType: false,
            processData: false,
            statusCode: {
                423: function () {
                    window.location='/logout';
                },
            },
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
                    jQuery('#row' + element.toString()).addClass("table-warning");
                    jQuery('#statusCell' + element.toString()).html('<svg xmlns="http://www.w3.org/2000/svg" width="16" ' +
                        'height="16" fill="currentColor" class="bi bi-lock-fill" viewBox="0 0 16 16">' +
                        ' <path d="M8 1a2 2 0 0 1 2 2v4H6V3a2 2 0 0 1 2-2zm3 6V3a3 3 0 0 0-6 0v4a2 2' +
                        ' 0 0 0-2 2v5a2 2 0 0 0 2 2h6a2 2 0 0 0 2-2V9a2 2 0 0 0-2-2z"/>' +
                        ' </svg>');
                }
            );
        });
        ajaxReq.fail(function (jqXHR) {
            console.log("Error when try to block  users")
        });
    });
});