<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Stock Dashboard</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.0/css/bootstrap.min.css">
<script src="https://code.jquery.com/jquery-3.1.1.min.js">
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" ></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.0/js/bootstrap.min.js"></script>

<style type="text/css">
#thead{background:#007bff;color:white}
#buy,#sale{width:100px;}
h3{color:white;background:orange;height:50px;margin-top:20px;padding-top:5px;}


</style>
<script type="text/javascript">
$(document).ready(function()
		{
	     setInterval(function(){
	    	  $.ajax({
					url:"/getallstocks",
					type:"GET",
					success:function(result)
					{ 
				    	  $("table tbody").empty();
				    		
							  $.each(result,function(i,stock)
								{ 
								  
								  $("<tr id='table"+i+"'><td>"+stock.name+"</td><td>"+stock.rate+"</td><td id='status"
								  +i+"'>"+stock.status+"</td><td>"+stock.quantity+"</td><td><a href='Buy.jsp' class='btn btn-primary' id='buy'>Buy</a>  <a href='Sale.jsp' class='btn btn-success' id='sale'>Sale</a></td></tr>").appendTo('table tbody');
								  var status=$('#status'+i).text();
								  if(status.charAt(0)=='+' || status.charAt(0)=='0')
									  {
									     $('#status'+i).css({"color":"darkgreen","font-weight": "bold"});
									  }
								  else
									  {
									  
									     $('#status'+i).css({"color":"red"});
									  }
								 
								 
								}
							  
							  );
							  		 						
					},
					error:function(jqXHR,textStatus,errorThrown)
					{
						alert(textStatus);
					}
				}
				);
      
	     
	     },2000);
			
		}
		
		);
</script>
</head>
<body>
<div class="container text-center">
<h3>STOCK DETAILS</h3>
<table class="table text-center border">
<thead id="thead">
<tr>
<th>NAME</th>
<th>RATE</th>
<th>STATUS</th>
<th>QUANTITY</th>
<th>OPERATIONS</th>
</tr>
</thead>
<tbody>

</tbody>

</table>
</div>
</body>
</html>