function showPopup(id) {
	$('#'+id).fadeIn('slow');
	$('#blackout').fadeIn('slow');
}
$(document).ready(function(){
	$('#blackout').click(function(){
		$('.popup').each(function(){
			$(this).fadeOut('slow');
		})
	})
})