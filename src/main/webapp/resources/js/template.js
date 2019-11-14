$(document).ready(function() {
	$("button").removeClass("ui-button ui-widget ui-state-default ui-corner-all ui-button-text-only");
	
	if(window.location.pathname == "/" || window.location.pathname == "/faces/index.xhtml" ){
		$("#notFound").hide();
	}
});


