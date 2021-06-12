$("#checkAll").change(function () {
    if ($(this).is(':checked'))
        $(".form-check-input").attr('checked', true);
    else
        $(".form-check-input").removeAttr('checked');
});