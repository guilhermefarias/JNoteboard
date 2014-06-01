var Note = {
	setup: function(){
		jQuery('.note').draggable({
			scroll: false ,
			handle: ".header",
			cursor: "move",
			stop: function (event, ui) {
			}
		});
	}
};

jQuery(document).ready(function(){
	Note.setup();
});
