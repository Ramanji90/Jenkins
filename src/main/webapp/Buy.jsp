<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Buy Share</title>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
<style type="text/css">
h3{color:white;background-color:#007bff;height:50px;padding-top:5px;}
#form-submit{margin-top:20%;}
#butn{padding-left:30px;margin-bottom:10px;}
#buy{width:100px;}
#cancel{width:100px;}
</style>

</head>
<body>
<div class="container">
<div class="row">
<div class="col-sm-3"></div>
<div class="col-sm-6 ">
<form action="" method="post" id="form-submit" class="text-center border">
<h3>BUY STOCKS</h3>
<h5 id="message"></h5>
<table class="table text-right">
<tr>
<td><label>Name :</label></td>
<td><input type="text" class="form-control" placeholder="Enter Share Name" id="name" name="name"></td>
<td id="errname"></td>
</tr>

<tr>
<td><label>Rate :</label></td>
<td><input type="text" class="form-control" placeholder="Enter Share Rate" id="rate" name="rate"></td>
<td id="errrate"></td>
</tr>

<tr>
<td><label>Quantity :</label></td>
<td><input type="text" class="form-control" placeholder="Enter Share Quantity" id="quantity" name="quantity"></td>
<td id="errquantity"></td>
</tr>

</table>
<div id="butn">
<input type="submit" value="Buy" id="buy" class=" btn btn-primary btn-lg"> <input type="submit" value="Cancel" id="cancel" class="btn btn-danger btn-lg">
</div>
</form>
</div>
<div class="col-sm-3"></div>

</div>
</div>
<!-- jQuery library -->



<!-- Popper JS -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>

<!-- Latest compiled JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</body>

<script type="text/javascript">
$(document).ready(function(){
	$('#name').change(function(){
		if($(this).val().length<3)
			{
			   $('#errname').text("Required minimum 3 characters");
			   $('#errname').css({"color":"red"});
			   return false;
			}
		else if(!(isNaN($(this).val())))
				{
			         $('#errname').text("Only characters are allowed");
			         $('#errname').css({"color":"red"});
			         return false; 
				}
		else
			{
			   $('#errname').text("");
			}
	}
	);
		$('#rate').change(function(){
			if(isNaN($(this).val()))
				{
				   $('#errrate').text("Only numbers are allowed");
				   $('#errrate').css({"color":"red"});
				   return false;
				}
			else
			{
			   $('#errrate').text("");
			   return true
			}
			
		});
			$('#quantity').change(function(){
				if(isNaN($(this).val()))
					{
					   $('#errquantity').text("Only numbers are allowed");
					   $('#errquantity').css({"color":"red"});
					   return false;
					}
				else
				{
				   $('#errquantity').text("");
				   return true
				}
				
			}
			);
		
			$('#form-submit').submit(function(event){
				event.preventDefault();
				
				  if(($('#name').val()==null || $('#name').val()=='') || ($('#rate').val()==null || $('#rate').val()=='') || ($('#quantity').val()==null || $('#quantity').val()==''))
				  {
				
				if($('#name').val() == ''){
					   $('#errname').text("Field is required");
					   $('#errname').css({"color":"red"});
					/*    event.preventDefault();
					   return false; */
				}
				
				if($('#rate').val()== ''){
					   $('#errrate').text("Field is required");
					   $('#errrate').css({"color":"red"});
					  /*  event.preventDefault();
					   return false; */
				}
				if($('#quantity').val() == ''){
					   $('#errquantity').text("Field is required");
					   $('#errquantity').css({"color":"red"});
					  /*  event.preventDefault();
					   return false; */
					
				}
					   
					   
					   return false;
					}
				    
				else{
				 
					    $('#errname').text("");
					    $('#errrate').text("");
					    $('#errquantity').text("");
					    
					    
					    var name=$('#name').val();
						var rate=$('#rate').val();
						var quantity=$('#quantity').val();
						
						var stockDetails={name:name,rate:rate,quantity:quantity};
						var json=JSON.stringify(stockDetails);
						
						$.ajax({
							
							type:"POST",
							contentType: "application/json",
							data:json,
							dataType: 'json',
							url:"/api/stockmarket/buystock",
							success:function(data){
								$('#message').text(data);
								$('#message').css({"color":"green"});
							},
							error:function(jqXHR,errorThrowns,textStatus){
								$('#message').text(textStatus);
								$('#message').css({"color":"red"});
							}
							
							
						});
						}
					    //return true;
					 
					
			
			
		});
			$('#cancel').click(function(){
				window.history.back();
			});
	});

</script>

</html>
