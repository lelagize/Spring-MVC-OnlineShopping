
$(document).ready(function(){
	
	$("#submit").click(function(){
	var toAdd = $("input[name=search]").val();
	if(toAdd.length !=0){
		$(".list").append("<div class='item'><h3> Your search result for:" + toAdd + "</h3></div>");
		}
	});
});

$(document).ready(function() {
    $( '.dropdown' ).hover(
        function(){
            $(this).children('.sub-menu').slideDown(200);
        },
        function(){
            $(this).children('.sub-menu').slideUp(200);
        }
    );
});