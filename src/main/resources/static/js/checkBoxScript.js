$('#checkAll').click(function(){
    if ($(this).is(':checked')){
        $('#usersTable input:checkbox').prop('checked', true);
    } else {
        $('#usersTable input:checkbox').prop('checked', false);
    }
});