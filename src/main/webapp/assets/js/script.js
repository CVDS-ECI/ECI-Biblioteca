$(document).ready(function() {
    var table = $('#example').DataTable();
     
	$('#example tbody').on('click', 'td.details', function () {
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
} );