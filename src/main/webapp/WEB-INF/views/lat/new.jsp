<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--<script src="https://code.jquery.com/jquery-3.6.0.js"></script>--%>
<%--<script src="https://code.jquery.com/ui/1.13.2/jquery-ui.js"></script>--%>

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

function testCalrendar () {
    $("input[name='datetimes']").daterangepicker(
        {},
        function (start, end, label) {
            let startDate = start.format("YYYY-MM-DD").toString();
            let endDate = end.format("YYYY-MM-DD").toString();

            document.getElementById("startDate").innerHTML =
                "Start date: " + startDate;
            document.getElementById("endDate").innerHTML = "End date: " + endDate;

        }
    );
}

    $(document).ready(function () {
    // 	alert(${mv});
        testajax();

        testCalrendar();
    })

</script>

<h1>context</h1>
ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ
<h3>popup test</h3>


ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ
<h3>daterangepicker example</h3>
<input type="text" name="datetimes" />
<p id="startDate">Start Date:</p>
<p id="endDate">End Date:</p>
ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ
<h3>ckeditor example</h3>
<textarea id = "editor4" name = "editor4"></textarea>
<script>CKEDITOR.replace('editor4');</script>
ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ