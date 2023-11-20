<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<h1>context</h1>

<h3>calendar테스트</h3>

<h3>daterangepicker - get date example</h3>
<input type="text" name="datetimes" />
<p id="startDate">Start Date:</p>
<p id="endDate">End Date:</p>

<script>
	$(document).ready(function () {

		console.log("222");

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
	});

</script>
