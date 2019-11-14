$("#myInitiativeTable").DataTable();
$(function () {
  $('[data-toggle="tooltip"]').tooltip()
})

$(".modify-Initiative").on('click',function(){
	var nombre = $(this).parent().parent().children()[0];
	var area = $(this).parent().parent().children()[1];
	var desc = $(this).parent().parent().children()[3];
	$("#InitiativeStatus\\:nombre").val(nombre.innerText);
	$("#InitiativeStatus\\:areaIn").val(area.innerText);
	$("#InitiativeStatus\\:description").val(desc.innerText);
});

$("#keywordInsert").on( 'change',function(){
	$("#addInitiative\\:keywordIn").val($("#keywordInsert").val())
});

$("#modifyInitiative").on('shown.bs.modal', function(){
	$("#InitiativeStatus\\:inStatus").val($("#inStatus").val())
});

$("#modifyInitiative").on('hidden.bs.modal', function(){
	$(".ui-messages-info").remove();
});



$(document).on("click", ".modify-Initiative", function () {
     var inStatus = $(this).data('id');
     $(".modal-body #inStatus").val( inStatus );
});