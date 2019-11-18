$("#keyword2").on( 'change',function(){
	$("#initiativeByKeywords_form\\:keyword").val($("#keyword2").val())
});

$("#modifyInitiative").on('shown.bs.modal', function(){
	$("#InitiativeStatus\\:inStatus").val($("#inStatus").val())
});

$("#description_initiative\\:boton").on( 'click',function(){
	$("#description_initiative\\:idInitiative").val($("#idInitiative").val())
});

$('#select').on('change', function() {
	$(".status").val($('#select').val());
});

$("#modifyInitiative").draggable({
      handle: ".modal-header"
  });
$(document).ready(function() {
    $("#initiativeTable").DataTable();
	$("#keyinitiative").DataTable();
	$("#interestedTable").DataTable();
	$("#commentTable").DataTable();
	$("#relatedTable").DataTable();
} );

$(document).on("click", ".open-DescriptionInitiative", function () {
     var initiativeId = $(this).data('id');
     $(".modal-body #idInitiative").val( initiativeId );
});


$(document).on("keypress", ":input", function(event) {
    if (event.keyCode == 13) {
        event.preventDefault();
    }
});

$(document).on("click", ".modify-Initiative", function () {
     var inStatus = $(this).data('id');
     $(".modal-body #inStatus").val( inStatus );
});

$(document).ready(function() {
    var table = $('#initiativeTable').DataTable();
     
	$('#initiativeTable tbody').on('click', 'td.details', function () {
	    var tr = $(this).closest('tr');
	    var sp = $(this).children().eq(1);
	    var row = table.row(tr);
	    if ( row.child.isShown() ) {
			$(this).children().children().first().removeClass("fa fa-arrow-up fa-2x").addClass("fa fa-cog fa-spin fa-2x fa-fw");
	        row.child.hide();
	        tr.removeClass('shown');
	    }
	    else {
	        row.child(sp.html()).show();
	        tr.addClass('shown');
			$(this).children().children().first().removeClass("fa fa-cog fa-spin fa-2x fa-fw").addClass("fa fa-arrow-up fa-2x");
	    }
	} );
} );







