<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<script src="https://code.highcharts.com/highcharts.js"></script>
<script src="https://code.highcharts.com/modules/exporting.js"></script>
<script src="https://code.highcharts.com/modules/export-data.js"></script>
<script src="https://code.highcharts.com/modules/accessibility.js"></script>

<figure class="highcharts-figure">
    <div id="MoviePie"></div>
</figure>
<script>
	var xhr9 = new XMLHttpRequest();
	xhr9.open("GET","<c:url value='moviePie' />", true);
	xhr9.setRequestHeader("Content-type","application/x-www-form-urlencoded");
	xhr9.send();
	console.log("jalfshkjadnfjl");
	xhr9.onreadystatechange = function() {
		if (xhr9.readyState == 4 && xhr9.status == 200) {
			var movies = JSON.parse(xhr9.responseText);
			var list = new Array();
			for(var i=0; i<movies.length; i++){
				list.push({name: movies[i].name, y: parseFloat(movies[i].percent)});
			}
			console.log("inside");
			movieRank(list);
	//			var divs = document.getElementById("somedivS");
	//			divs.innerHTML = content;
		}
	}
	

	function movieRank(content){
		Highcharts.chart('MoviePie', {
		    chart: {
		        plotBackgroundColor: null,
		        plotBorderWidth: null,
		        plotShadow: false,
		        type: 'pie'
		    },
		    title: {
		        text: 'Browser market shares in January, 2018'
		    },
		    tooltip: {
		        pointFormat: '{series.name}: <b>{point.percentage:.1f}%</b>'
		    },
		    accessibility: {
		        point: {
		            valueSuffix: '%'
		        }
		    },
		    plotOptions: {
		        pie: {
		            allowPointSelect: true,
		            cursor: 'pointer',
		            dataLabels: {
		                enabled: true,
		                format: '<b>{point.name}</b>: {point.percentage:.1f} %'
		            }
		        }
		    },
		    series: [{
		        name: '百分比',
		        colorByPoint: true,
		        data: content
		    }]
		});
	
	}
	
</script>
</body>
</html>