<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<c:set var="funcName" value="index" scope="session"/>
	<head>
		<meta charset="UTF-8">
		<title>首頁</title>
		<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
<script src="https://code.highcharts.com/highcharts.js"></script>
<script src="https://code.highcharts.com/highcharts-more.js"></script>
<script src="https://code.highcharts.com/modules/exporting.js"></script>
<script src="https://code.highcharts.com/modules/export-data.js"></script>
<script src="https://code.highcharts.com/modules/accessibility.js"></script>
<script src="https://code.highcharts.com/modules/solid-gauge.js"></script>

<style type="text/css">
credits: {
enabled:false
}
</style>
	</head>
	<body class="bg-theme bg-theme1">
		<c:set var="funcName" value="index" scope="session"/>
		<div id="wrapper">
			<jsp:include page="../Manager/Manager.jsp" />
			<div class="content-wrapper">
    <div class="container-fluid">

  <!--Start Dashboard Content-->

	<div class="card mt-3">
    <div class="card-content">
        <div class="row row-group m-0">
<!--             <div class="col-12 col-lg-6 col-xl-3 border-light"> -->
<!--                 <div class="card-body"> -->
<!--                   <h5 class="text-white mb-0">10000 <span class="float-right"><i class="fa fa-shopping-cart"></i></span></h5> -->
<!--                     <div class="progress my-3" style="height:3px;"> -->
<!--                        <div class="progress-bar" style="width:55%"></div> -->
<!--                     </div> -->
<!--                   <p class="mb-0 text-white small-font">Total Orders <span class="float-right">+4.2% <i class="zmdi zmdi-long-arrow-up"></i></span></p> -->
<!--                 </div> -->
<!--             </div> -->
            <div class="col-12 col-lg-6 col-xl-3 border-light">
                <div class="card-body">
                  <h3 class="text-white mb-0">${AllMoney} <span class="float-right"><i class="fa fa-usd"></i></span></h3>
                    <div class="progress my-3" style="height:3px; font-size: 18px;">
                       <div class="progress-bar" style="width:100%"></div>
                    </div>
                  <p class="mb-0 text-white small-font" style="font-size: 18px">銷售總額</p>
                </div>
            </div>
            <div class="col-12 col-lg-6 col-xl-3 border-light">
                <div class="card-body">
                  <h3 class="text-white mb-0">${AllRoomQua}<span class="float-right"><i class="zmdi zmdi-card-travel"></i></span></h3>
                    <div class="progress my-3" style="height:3px;">
                       <div class="progress-bar" style="width:100%"></div>
                    </div>
                  <p class="mb-0 text-white small-font" style="font-size: 18px">預約包廂</p>
                </div>
            </div>
            <div class="col-12 col-lg-6 col-xl-3 border-light">
                <div class="card-body">
                  <h3 class="text-white mb-0">${AllMemberQua}<span class="float-right"><i class="zmdi zmdi-account"></i></span></h3>
                    <div class="progress my-3" style="height:3px;">
                       <div class="progress-bar" style="width:100%"></div>
                    </div>
                  <p class="mb-0 text-white small-font" style="font-size: 18px">會員總數</p>
                </div>
            </div>
        </div>
    </div>
 </div>  
	  
	<div class="row">
     <div class="col-12 col-lg-8 col-xl-8">
	    <div class="card">
		 <div class="card-header" style="font-size: 20px">訂單分析圖
		   <div class="card-action">
			 <div class="dropdown">
			 <a href="javascript:void();" class="dropdown-toggle dropdown-toggle-nocaret" data-toggle="dropdown">
			  <i class="icon-options"></i>
			 </a>
				<div class="dropdown-menu dropdown-menu-right">
				<a class="dropdown-item" href="javascript:void();">Action</a>
				<a class="dropdown-item" href="javascript:void();">Another action</a>
				<a class="dropdown-item" href="javascript:void();">Something else here</a>
				<div class="dropdown-divider"></div>
				<a class="dropdown-item" href="javascript:void();">Separated link</a>
			   </div>
			  </div>
		   </div>
		 </div>
<!-- 		 <button id="plain">Plain</button> -->
<!-- 			  <button id="inverted">Inverted</button> -->
			  <ul class="nav nav-tabs" id="mySelect" role="tablist">
                  <li class="nav-item">
                      <a style="font-size: 20px" class="nav-link active" id="plain" data-toggle="tab" href="#description" role="tab" aria-controls="description" aria-selected="true" >長條圖</a>
                  </li>
                  <li class="nav-item">
                      <a style="font-size: 20px" class="nav-link" id="inverted" data-toggle="tab" href="#specification" role="tab" aria-controls="specification" aria-selected="false" >行條統計圖</a>
                  </li>
                  <li class="nav-item">
                      <a style="font-size: 20px" class="nav-link" id="PieMovie" data-toggle="tab" href="#specification" role="tab" aria-controls="specification" aria-selected="false" >電影圓餅圖</a>
                  </li>
              </ul>
			  
<!-- 			  <button id="polar">Polar</button> -->
		 <div id="container" class="card-body">
		    <!-- <ul class="list-inline">
			  <li class="list-inline-item"><i class="fa fa-circle mr-2 text-white"></i>New Visitor</li>
			  <li class="list-inline-item"><i class="fa fa-circle mr-2 text-light"></i>Old Visitor</li>
			</ul> -->
			<div class="chart-container-1">
<%--         	<canvas id="chart1"> --%>
        		<div ></div>
<%--         	</canvas> --%>
			</div>
		 </div>
		 <div id="MoviePie" class="card-body" style="display:none"> </div>
		 
		 <div class="row m-0 row-group text-center border-top border-light-3">
<!-- 		   <div class="col-12 col-lg-4"> -->
<!-- 		     <div class="p-3"> -->
<!-- 		       <h5 class="mb-0">45.87M</h5> -->
<!-- 			   <small class="mb-0">Overall Visitor <span> <i class="fa fa-arrow-up"></i> 2.43%</span></small> -->
<!-- 		     </div> -->
<!-- 		   </div> -->
<!-- 		   <div class="col-12 col-lg-4"> -->
<!-- 		     <div class="p-3"> -->
<!-- 		       <h5 class="mb-0">15:48</h5> -->
<!-- 			   <small class="mb-0">Visitor Duration <span> <i class="fa fa-arrow-up"></i> 12.65%</span></small> -->
<!-- 		     </div> -->
<!-- 		   </div> -->
<!-- 		   <div class="col-12 col-lg-4"> -->
<!-- 		     <div class="p-3"> -->
<!-- 		       <h5 class="mb-0">245.65</h5> -->
<!-- 			   <small class="mb-0">Pages/Visit <span> <i class="fa fa-arrow-up"></i> 5.62%</span></small> -->
<!-- 		     </div> -->
<!-- 		   </div> -->
		 </div>
		 
		</div>
	 </div>

     <div class="col-12 col-lg-4 col-xl-4">
        <div class="card">
           <div class="card-header" style="font-size: 20px">評分總平均
             <div class="card-action">
             <div class="dropdown">
             <a href="javascript:void();" class="dropdown-toggle dropdown-toggle-nocaret" data-toggle="dropdown">
              <i class="icon-options"></i>
             </a>
              <div class="dropdown-menu dropdown-menu-right">
              <a class="dropdown-item" href="javascript:void();">Action</a>
              <a class="dropdown-item" href="javascript:void();">Another action</a>
              <a class="dropdown-item" href="javascript:void();">Something else here</a>
              <div class="dropdown-divider"></div>
              <a class="dropdown-item" href="javascript:void();">Separated link</a>
               </div>
              </div>
             </div>
           </div>
           <div id="strat" class="card-body">
		     <div class="chart-container-2">
<%--                <canvas id="chart2"></canvas> --%>
    			<div ></div>
			  </div>
           </div>
           <div class="table-responsive">
             <table class="table align-items-center">
               <tbody>
                 <tr style="font-size: 20px">
                   <td><i class="fa fa-circle text-white mr-2"></i> 評分總數</td>
                   <td>${AllStar}</td>
                 </tr>
                 <tr style="font-size: 20px">
                   <td><i class="fa fa-circle text-white mr-2"></i> 評分人數</td>
                   <td>${AllRateMemberQua}</td>
                 </tr>
               </tbody>
             </table>
           </div>
         </div>
     </div>
	</div><!--End Row-->
	
	<div class="row">
	 <div class="col-12 col-lg-12">
	   <div class="card">
	     <div class="card-header" style="font-size: 20px">預約單資訊
		  <div class="card-action">
             <div class="dropdown">
             <a href="javascript:void();" class="dropdown-toggle dropdown-toggle-nocaret" data-toggle="dropdown">
              <i class="icon-options"></i>
             </a>
              <div class="dropdown-menu dropdown-menu-right">
              <a class="dropdown-item" href="javascript:void();">Action</a>
              <a class="dropdown-item" href="javascript:void();">Another action</a>
              <a class="dropdown-item" href="javascript:void();">Something else here</a>
              <div class="dropdown-divider"></div>
              <a class="dropdown-item" href="javascript:void();">Separated link</a>
               </div>
              </div>
             </div>
		 </div>
	       <div class="table-responsive">
              <table class="table align-items-center table-flush table-borderless">
<!--                   <thead> -->
	                   <tr style="font-size: 20px">
	                     <th>訂單編號</th>
	                     <th>使用者帳號</th>
	                     <th>預約包廂名稱</th>
	                     <th>預約電影名稱</th>
	                     <th>預約日期</th>
	                     <th>預約開始時間</th>
	                     <th>預約結束時間</th>
	                   </tr>
<!--                    </thead> -->
                   <tbody>
                   		<c:forEach var="CartOrderBean" items="${CartOrderBean}">
                   			<tr style="font-size: 20px">
                   				<td>${CartOrderBean.value.orderNo}</td>
                   				<td>${CartOrderBean.value.member.memberId}</td>
                   				<td>${CartOrderBean.value.room.roomName}</td>
                   				<td>${CartOrderBean.value.movie.movieName}</td>
                   				<td>${CartOrderBean.value.orderDate}</td>
                   				<td>${CartOrderBean.value.orderDateStart}</td>
                   				<td>${CartOrderBean.value.orderDateEnd}</td>
                   			</tr>
                   		</c:forEach>
                   </tbody>
                 </table>
            </div>
	   </div>
	 </div>
	</div>
	<div class="row">
	 <div class="col-12 col-lg-12">
	   <div class="card">
	     <div class="card-header" style="font-size: 20px">評分與評論
		  <div class="card-action">
             <div class="dropdown">
             <a href="javascript:void();" class="dropdown-toggle dropdown-toggle-nocaret" data-toggle="dropdown">
              <i class="icon-options"></i>
             </a>
              <div class="dropdown-menu dropdown-menu-right">
              <a class="dropdown-item" href="javascript:void();">Action</a>
              <a class="dropdown-item" href="javascript:void();">Another action</a>
              <a class="dropdown-item" href="javascript:void();">Something else here</a>
              <div class="dropdown-divider"></div>
              <a class="dropdown-item" href="javascript:void();">Separated link</a>
               </div>
              </div>
             </div>
		 </div>
	       <div class="table-responsive">
              <table class="table align-items-center table-flush table-borderless">
<!--                   <thead> -->
	                   <tr style="font-size: 20px">
	                     <th>訂單編號</th>
	                     <th>預約日期</th>
	                     <th>評分(分數)</th>
	                     <th>評論內容</th>
	                   </tr>
<!--                    </thead> -->
                   <tbody>
                   		<c:forEach var="survey" items="${SurveyBean}">
                   			<tr style="font-size: 20px">
                   				<td>${survey.value.orderNo}</td>
                   				<td>${survey.value.date}</td>
                   				<td>${survey.value.satisfaction}分</td>
                   				<td>${survey.value.comment}</td>
                   			</tr>
                   		</c:forEach>
                   </tbody>
                 </table>
            </div>
	   </div>
	 </div>
	</div>
	<!--End Row-->

      <!--End Dashboard Content-->
	  
	<!--start overlay-->
		  <div class="overlay toggle-menu"></div>
		<!--end overlay-->
		
    </div>
    <!-- End container-fluid-->
    
    </div><!--End content-wrapper--></div>
    <script src="assets/plugins/Chart.js/Chart.min.js"></script>
  <!-- Index js -->
  	<script src="assets/js/index.js"></script>
    <script>
    function wdithChane(){
    	var scriptJSON = document.createElement('script');
		var xhr = new XMLHttpRequest();
		xhr.open("GET","<c:url value='roomAnalysis' />", true);
		xhr.setRequestHeader("Content-type","application/x-www-form-urlencoded");
		xhr.send();
		console.log("jalfshkjadnfjl");
		xhr.onreadystatechange = function() {
			if (xhr.readyState == 4 && xhr.status == 200) {
				var rooms = JSON.parse(xhr.responseText);
				var roomName = new Array();
				var roomRate = new Array();
				console.log(rooms);
				for (var i = 0; i < rooms.length; i++) {
					roomName.push(rooms[i].roomName);
					roomRate.push(Math.round(rooms[i].roomRate));
					
					console.log(rooms[i].roomName +" , "+ rooms[i].roomRate);
				}
				analysisF(roomName,roomRate);
			}
		}
    }
// 		var container = document.getElementById("hiFigure");
		var scriptJSON = document.createElement('script');
		var xhr = new XMLHttpRequest();
		var xhr1 = new XMLHttpRequest();
		xhr1.open("GET","<c:url value='roomAnalysis' />", true);
		xhr1.setRequestHeader("Content-type","application/x-www-form-urlencoded");
		xhr1.send();
		console.log("jalfshkjadnfjl");
		xhr1.onreadystatechange = function() {
			if (xhr1.readyState == 4 && xhr1.status == 200) {
				var rooms = JSON.parse(xhr1.responseText);
				var roomName = new Array();
				var roomRate = new Array();
				console.log(rooms);
				for (var i = 0; i < rooms.length; i++) {
					roomName.push(rooms[i].roomName);
					roomRate.push(Math.round(rooms[i].roomRate));
					
					console.log(rooms[i].roomName +" , "+ rooms[i].roomRate);
				}
				analysisF(roomName,roomRate);
				
			}
		}
		function analysisF(roomName,roomRate){
			console.log(roomName)
			console.log(roomRate)
			var chart = Highcharts.chart("container", {
				chart: {
			        height: 350,
			        type: 'line',
			        backgroundColor: 'rgba(0,0,0,0)',
			    },
			    title: {
			        text: '包廂使用率(%)',
			        style: {
		                color: '#FFFFFF'
		            }
			    },
			    xAxis: {
			    	title:{
			    	       text:'包廂名稱',
		    	    	   style: {
				                color: '#FFFFFF'
				            }
			    	   },
			        categories: roomName,
			        labels: {
			            style: {
			                color: '#FFFFFF'
			            }
			        }
			    },
			    yAxis:{
		    	   title:{
		    	       text:'使用率(%)',
		    	       style: {
			                color: '#FFFFFF'
			            }
		    	   },
		    	   labels: {
			            style: {
			                color: '#FFFFFF'
			            }
			        }
			    },
			    credits: { enabled:false },   //去掉右下角highchart.com
			    exporting: { enabled:false },   //去掉右上角的打印及导出按钮
			    series: [{
			        type: 'column',
			        colorByPoint: true,
			        data: roomRate,
			        showInLegend: false
			    }],
			 
			});
			$('#plain').click(function () {
				$("#MoviePie").hide();
				$("#container").show();
			    chart.update({
			        chart: {
			            inverted: false,
			            polar: false
			        },
// 			        subtitle: {
// 			            text: 'Plain'
// 			        }
			    });
			});

			$('#inverted').click(function () {
				$("#MoviePie").hide();
				$("#container").show();
			    chart.update({
			        chart: {
			            inverted: true,
			            polar: false
			        },
// 			        subtitle: {
// 			            text: 'Inverted'
// 			        }
			    });
			});

			$('#polar').click(function () {
				$("#MoviePie").hide();
				$("#container").show();
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
			
			//	$('#container').highcharts().reflow();
		}
		window.onresize = function() {
	        $('#container').highcharts().reflow();
	    }
		$('#PieMovie').click(function () {
			//alert("fuck");
			$("#MoviePie").show();
			$("#container").hide();
// 			container MoviePie
		});
// 		var xhr = new XMLHttpRequest();
		xhr.open("GET","<c:url value='satisfyRate' />", true);
		xhr.setRequestHeader("Content-type","application/x-www-form-urlencoded");
		xhr.send();
		console.log("jalfshkjadnfjl");
		xhr.onreadystatechange = function() {
			if (xhr.readyState == 4 && xhr.status == 200) {
				console.log("inside");
				var rate = JSON.parse(xhr.responseText);
				getPie(rate);
			}
		}
		
	    function renderIcons() {
	        if (!this.series[0].icon) {
	            this.series[0].icon = this.renderer.path(['M', -8, 0, 'L', 8, 0, 'M', 0, -8, 'L', 8, 0, 0, 8])
	                .attr({
	                    stroke: '#303030',
	                    'stroke-linecap': 'round',
	                    'stroke-linejoin': 'round',
	                    'stroke-width': 2,
	                    zIndex: 10
	                });
	                //.add(this.series[2].group);
	        }
	        this.series[0].icon.translate(
	            this.chartWidth / 2 - 10,
	            this.plotHeight / 2 - this.series[0].points[0].shapeArgs.innerR -
	                (this.series[0].points[0].shapeArgs.r - this.series[0].points[0].shapeArgs.innerR) / 2
	        );

	    }
	    function getPie(number) {
	    Highcharts.chart('strat', {
	        chart: {
	            type: 'solidgauge',
	            height: "100%",
	            backgroundColor: 'rgba(0,0,0,0)',
	            events: {
	                render: renderIcons
	            }
	        },

	        title: {
	            text: null,
	        },
	        
	        tooltip: {
	            borderWidth: 0,
	            backgroundColor: 'none',
	            shadow: false,
	            
	            style: {
	                fontSize: '16px'
	            },
	            valueSuffix: '/5',
	            pointFormat: '{series.name}<br><span style="font-size:2em; color: {point.color}; font-weight: bold">{point.y}</span>',
	            positioner: function (labelWidth) {
	                return {
	                    x: (this.chart.chartWidth - labelWidth) / 2,
	                    y: (this.chart.plotHeight / 2)
	                };
	            },
	        },

	        pane: {
	            startAngle: 0,
	            endAngle: 360,
	            background: [{ // Track for Move
	                outerRadius: '110%',
	                innerRadius: '90%',
	                backgroundColor: Highcharts.color(Highcharts.getOptions().colors[0])
	                    .setOpacity(0.3)
	                    .get(),
	                borderWidth: 0
	            }]
	        },

	        yAxis: {
	            min: 0,
	            max: 5,
	            lineWidth: 0,
	            tickPositions: []
	        },

	        plotOptions: {
	            solidgauge: {
	                dataLabels: {
	                    enabled: false
	                },
	                linecap: 'round',
	                stickyTracking: false,
	                rounded: true
	            }
	        },
	        credits: { enabled:false },   //去掉右下角highchart.com
		    exporting: { enabled:false },   //去掉右上角的打印及导出按钮
	        series: [{
	            name: '',
	            data: [{
	                color: "#FFFFFF",
	                radius: '112%',
	                innerRadius: '88%',
	                y: number
	            }]
	        }]
	    });
	    
	    }
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
			        type: 'pie',
			        height: 350,
			        backgroundColor: 'rgba(0,0,0,0)',
			    },
			    title: {
			        text: '電影觀賞率(%)',
			        style: {
		                color: '#FFFFFF'
		            }
			    },
			    tooltip: {
			        pointFormat: '{series.name}: <b>{point.percentage:.1f}%</b>'
			    },
			    accessibility: {
			        point: {
			            valueSuffix: '%',
			            style: {
			                color: '#FFFFFF'
			            }
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
			    credits: { enabled:false },   //去掉右下角highchart.com
			    exporting: { enabled:false },   //去掉右上角的打印及导出按钮
			    series: [{
			        name: '百分比',
			        colorByPoint: true,
			        data: content,
			        style: {
		                color: '#FFFFFF'
		            }
			    }]
			});
		
		}
			
</script>
    
 	</body>
</html>