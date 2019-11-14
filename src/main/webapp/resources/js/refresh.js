var table = $('#keyinitiative').DataTable();
     
	$('#keyinitiative tbody').on('click', 'td.details', function () {
	    var tr = $(this).closest('tr');
	    var sp = $(this).children().eq(1);
	    var row = table.row(tr);
	    if ( row.child.isShown() ) {
			$(this).children().children().first().removeClass("fa-minus-square").addClass("fa-plus-square");
	        row.child.hide();
	        tr.removeClass('shown');
	    }
	    else {
	        row.child(sp.html()).show();
	        tr.addClass('shown');
			$(this).children().children().first().removeClass("fa-plus-square").addClass("fa-minus-square");
	    }
	} );

$("#myInitiativeTable").DataTable();

$(".modify-Initiative").on('click',function(){
	var nombre = $(this).parent().parent().children()[0];
	var area = $(this).parent().parent().children()[1];
	var desc = $(this).parent().parent().children()[3];
	$("#InitiativeStatus\\:nombre").val(nombre.innerText);
	$("#InitiativeStatus\\:areaIn").val(area.innerText);
	$("#InitiativeStatus\\:description").val(desc.innerText);
});
