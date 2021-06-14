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
                    jQuery('#statusCell' + element.toString()).html('<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-unlock" viewBox="0 0 16 16">' +
                        '<path d="M11 1a2 2 0 0 0-2 2v4a2 2 0 0 1 2 2v5a2 2 0 0 1-2 2H3a2 2 0 0 1-2-2V9a2 2 0 0 1 2-2h5V3a3 3 0 0 1 6 0v4a.5.5 0 0 1-1 0V3a2 2 0 0 0-2-2zM3 8a1 1 0 0 0-1 1v5a1 1 0 0 0 1 1h6a1 1 0 0 0 1-1V9a1 1 0 0 0-1-1H3z"/>' +
                    '</svg>');
                }
            );
        });
        ajaxReq.fail(function (jqXHR) {
            console.log("Error when try to unlock  users")
        });
    });
});