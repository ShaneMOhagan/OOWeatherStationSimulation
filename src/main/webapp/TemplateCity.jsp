<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.Random, webpage_package.*, decorator_temp.*"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="Styles.css">
	<meta charset="UTF-8">
	<title>Weather Simulator Home</title>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="/bower_components/bootstrap-horizon/bootstrap-horizon.css">
</head>
<body>
	<nav class="navbar navbar-expand-sm bg-dark">
	        <!-- Links -->
	        <a class="navbar-brand " href="#" style="color:gray">The Weather Station</a>
	        <ul class="navbar-nav mr-auto">
	            <li class="nav-item">
	                <a class="nav-link" href="index.jsp">Home</a>
	            </li>
	            <li class="nav-item">
	                <a class="nav-link" href="#">API</a>
	            </li>
	        </ul>
	</nav>
    
    <% 
    	String cityName = request.getParameter("nameid").toString();
    	String cityImage = request.getParameter("photoid").toString();
    	String cityDateTime = request.getParameter("datetimeid").toString();
    	String cityDateTemp = request.getParameter("tempid").toString();
    	String cityDateH = request.getParameter("hhid").toString();
    	String cityDateD = request.getParameter("ddid").toString();
    	String cityDateW = request.getParameter("wwid").toString();
    	double degreesK = Double.parseDouble(cityDateTemp); //Fahrenheit
    	Context context = new Context(new ConvertF());
    	double degreesF = context.executeStrategy(degreesK);
    	context = new Context(new ConvertC());
    	double degreesC = context.executeStrategy(degreesK);
    	
    %>
    <div class="container" style="margin-top: 50px">    
        <div class="row flex-row flex-nowrap">
                <div class="card card-block" style="width: 1000px">
                	<div class="card-header">
    					<h2><%= cityName%> </h2>
  					</div>
                    <img class="card-img-top" src=<%=cityImage%>
                        height="200px" width="800">
                   	<p><%= cityDateTime%></p>
					<div class="dropdown">
					  <button style= "width: 996px" class="btn btn-secondary dropdown-toggle" type="button" id="dropdownMenuButton" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
					    Filter Options 
					  </button>
					  <div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
					    <a class="dropdown-item" href="#">Temperature</a>
					    <a class="dropdown-item" href="#">Humidity</a>
					    <a class="dropdown-item" href="#">Air Quality Index</a>
					  </div>
					</div>
                </div>
        </div>
	  <div class="row" style="margin-right: 60px">
		  <div class="col-sm-3" style="margin-top: 40px">
		    <div class="card">
		      <div class="card-body">
		        <h5 class="card-title">Temperature</h5>
		        <p class="card-text">Degrees Fahrenheit:<%=degreesF%></p>
				  <!-- Trigger the modal with a button -->
				  <button type="button" class="btn btn-info btn-lg" data-toggle="modal" data-target="#myModal">Open Temperature Modal</button>
				
				  <!-- Modal -->
				  <div class="modal fade" id="myModal" role="dialog">
				    <div class="modal-dialog">
				    
				      <!-- Modal content-->
				      <div class="modal-content">
				        <div class="modal-header">
				          <button type="button" class="close" data-dismiss="modal">&times;</button>
				          <h4 class="modal-title">View Temps Modal</h4>
				        </div>
				        <div class="modal-body">
				            <p>Temperature degrees kelvin: <%=degreesK %></p>
				            <p>Temperature degrees fahrenheit: <%=degreesF %></p>
				            <p>Temperature degrees celsisus: <%=degreesC %></p>
				        </div>
				        <div class="modal-footer">
				          <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
				        </div>
				      </div>
				      
				    </div>
				  </div>
		      </div>
		    </div>
		  </div>
		  <div class="col-sm-3" style="margin-top: 40px">
		    <div class="card">
		      <div class="card-body">
		        <h5 class="card-title">Humidity</h5>
		        <p class="card-text"><%=cityDateH%></p>
		        <a href="#" class="btn btn-primary">Go somewhere</a>
		      </div>
		    </div>
		  </div>
		  <div class="col-sm-3" style="margin-top: 40px">
		    <div class="card">
		      <div class="card-body">
		        <h5 class="card-title">Wind Speed</h5>
		        <p class="card-text"><%=cityDateW%></p>
		        <a href="#" class="btn btn-primary">Go somewhere</a>
		      </div>
		    </div>
		  </div>
		  <div class="col-sm-3" style="margin-top: 40px">
		    <div class="card">
		      <div class="card-body">
		        <h5 class="card-title">Dew Point</h5>
		        <p class="card-text"><%=cityDateD%></p>
		        <a href="#" class="btn btn-primary">Go somewhere</a>
		      </div>
		    </div>
		  </div>
	</div>

	<ul class="list-group" style="margin-top: 50px">
	  <li class="list-group-item" style="height:90px">
	  Present Forecast
	  <p style="margin-top: 20px">Data</p>
	  </li>
	  <li class="list-group-item" style="height: 90px">
	  Future Forecast
	  <p style="margin-top: 20px">Data</p>
	  </li>
	  <li class="list-group-item" style="height: 90px">
	  Past Forecast
	  <p style="margin-top: 20px">Data</p>
	  </li> 
	 
	</ul>

</div>
</body>
<footer class="bg-light text-center text-lg-start" style="margin-top: 100px">
        <div class="text-center p-3" style="background-color: rgba(0, 0, 0, 0.2)">
            <p>Weather Station Web App - Sarthak Shukla & Shane O'Hagan</p>
        </div>
</footer>
</html>