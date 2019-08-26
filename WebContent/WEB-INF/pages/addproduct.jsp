<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Product</title>
</head>
<body>
	<form method="post" action="">
   
	    <div class="input-group">
	      <label>Name</label>
	      <input type="text" name="Name" >
	    </div>
	    <div class="input-group">
	      <label>Category</label>
	      <select name="category">
 	 <option value="contemporary">Contemporary</option>
  	<option value="illustration">Illustration</option>
  	<option value="animation">Animation</option>
  	<option value="naturescience">Nature and Science</option>
	</select>
	    </div>
	    
	    <div class="input-group">
	      <label>Description</label>
	      <input type="text" name="description" >
	    </div>
	    <div class="input-group">
	      <label>Actual Price</label>
	      <input type="text" name="actualprice" >
	    </div>
	
	    <div class="input-group">
	      <label>Quantity</label>
	      <input type="number" name="quantity" required >
	    </div>	    
	
	    <div class="input-group">
	      <button type="submit" class="btn" name="addproduct">Add Product</button>
	    </div>
  </form>
  
  response.sendRedirect(addproduct.jsp);
</body>
</html>