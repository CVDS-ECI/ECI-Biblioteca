$('#select').on('change', function() {
	$(".rol").val($('#select').val());
});

$(document).on("click", ".modify-User", function () {
     var emailUser = $(this).data('id');
     $(".modal-body #emailUser").val( emailUser );
});

$("#modifyUs").on('shown.bs.modal', function(){
	$("#rol_form\\:emailUser").val($("#emailUser").val())
});

$(document).ready(function() {
    $("#usersTable").DataTable();
} );


