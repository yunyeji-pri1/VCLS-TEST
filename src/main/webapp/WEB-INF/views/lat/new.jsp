<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
<script src="https://code.jquery.com/ui/1.13.2/jquery-ui.js"></script>

<script>

function testajax(){
	
	var param ={};
	
	$.ajax({
		type:"POST",
	    contentType: "application/json",
	    data: JSON.stringify(param),
		url: "/aaa/bbb.json",
        dataType: "json",
        success: function(data){
        	console.log(data);
        }
	})
}

$(document).ready(function () {
// 	alert(${mv});
	testajax();
})


</script>

	<h1>context</h1>		

