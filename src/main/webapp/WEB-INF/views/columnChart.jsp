<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
#container {
  height: 400px; 
}

.highcharts-figure, .highcharts-data-table table {
  min-width: 320px; 
  max-width: 800px;
  margin: 1em auto;
}

.highcharts-data-table table {
  font-family: Verdana, sans-serif;
  border-collapse: collapse;
  border: 1px solid #EBEBEB;
  margin: 10px auto;
  text-align: center;
  width: 100%;
  max-width: 500px;
}
.highcharts-data-table caption {
  padding: 1em 0;
  font-size: 1.2em;
  color: #555;
}
.highcharts-data-table th {
	font-weight: 600;
  padding: 0.5em;
}
.highcharts-data-table td, .highcharts-data-table th, .highcharts-data-table caption {
  padding: 0.5em;
}
.highcharts-data-table thead tr, .highcharts-data-table tr:nth-child(even) {
  background: #f8f8f8;
}
.highcharts-data-table tr:hover {
  background: #f1f7ff;
}
</style>
</head>
<body>
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
<script src="https://code.highcharts.com/highcharts.js"></script>
<script src="https://code.highcharts.com/highcharts-more.js"></script>
<script src="https://code.highcharts.com/modules/exporting.js"></script>
<script src="https://code.highcharts.com/modules/export-data.js"></script>
<script src="https://code.highcharts.com/modules/accessibility.js"></script>

<figure id="hiFigure" class="highcharts-figure">
  <div id="container"></div>
  <p class="highcharts-description">
    Chart with buttons to modify options, showing how options can be changed
    on the fly. This flexibility allows for more dynamic charts.
  </p>

  <button id="plain">Plain</button>
  <button id="inverted">Inverted</button>
  <button id="polar">Polar</button>
</figure>







<script>
// 		var container = document.getElementById("hiFigure");
		var scriptJSON = document.createElement('script');
		var xhr = new XMLHttpRequest();
		xhr.open("GET","<c:url value='roomAnalysis' />", true);
		xhr.setRequestHeader("Content-type","application/x-www-form-urlencoded");
		xhr.send();
		console.log("jalfshkjadnfjl");
		xhr.onreadystatechange = function() {
			if (xhr.readyState == 4 && xhr.status == 200) {
				console.log("inside");
				var rooms = JSON.parse(xhr.responseText);
				analysisF(rooms);
// 				var divs = document.getElementById("somedivS");
// 				divs.innerHTML = content;
			}
		}
		
		function analysisF(content){
		var figure ="";
		figure += "var chart = Highcharts.chart('container', {" + 

		  "title: {" + 
		    "text: '包廂使用率(%)'" + 
		  "}," + 

		  "subtitle: {" + 
		    "text: 'hi'" + 
		  "}," + 

		  "xAxis: {" + 
		    "categories: ["+content.roomName+"]" + 
		  "}," + 

		  "series: [{" + 
		    "type: 'column'," + 
		    "colorByPoint: true," + 
		    "data: ["+content.roomRate+"]," + 
		    "showInLegend: false" + 
		  "}]" + 

		"});";

				scriptJSON.innerHTML = figure;
				$("#hiFigure").before(scriptJSON);
		}


			$('#plain').click(function () {
			  chart.update({
			    chart: {
			      inverted: false,
			      polar: false
			    },
			    subtitle: {
			      text: 'Plain'
			    }
			  });
			});

			$('#inverted').click(function () {
			  chart.update({
			    chart: {
			      inverted: true,
			      polar: false
			    },
			    subtitle: {
			      text: 'Inverted'
			    }
			  });
			});

			$('#polar').click(function () {
			  chart.update({
			    chart: {
			      inverted: false,
			      polar: true
			    },
			    subtitle: {
			      text: 'Polar'
			    }
			  });
			});
</script>

</body>
</html>