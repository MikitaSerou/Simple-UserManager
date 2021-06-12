$(function () {
    $('button#unlockButton[type=submit]').click(function (e) {
        console.log("Unlock ajax");
        e.preventDefault();
        let form = document.forms['userManagementForm'];
        let formData = new FormData(form);
        let ajaxReq = $.ajax({
            url:document.getElementById('unlockUrl').value,
            type: 'PATCH',
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
                    jQuery('#row' + element.toString()).removeClass("table-warning");
                    jQuery('#statusCell' + element.toString()).html('<svg xmlns="http://www.w3.org/2000/svg"' +
                        ' width="16" height="16" fill="currentColor"class="bi bi-check2" viewBox="0 0 16 16">' +
                        ' <path d="M13.854 3.646a.5.5 0 0 1 0 .708l-7 7a.5.5 0 0 1-.708 0l-3.5-3.5a.5.5 0 1 1.708-' +
                        '.708L6.5 10.293l6.646-6.647a.5.5 0 0 1 .708 0z"></path> </svg>' +
                        ' </svg>');
                }
            );
        });
        ajaxReq.fail(function (jqXHR) {
            console.log("Error when try to block  users")
        });
    });
});