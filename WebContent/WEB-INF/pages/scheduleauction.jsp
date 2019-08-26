<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Schedule Auction</title>
</head>
<body>
	<form action="list" method="post">
    Select a Product:&nbsp;
    <select name="product">
        <c:forEach items="${listProduct}" var="product">
            <option value="${product.name}"> ${product.name} </option>
        </c:forEach>
    </select>
    
    <div class="input-group">
	      <label>Minimum Bid Value : </label>
	      <input type="number" name="minbidvalue">
	</div>
	
	<div class="input-group">
	      <label>Bid Start Date : </label>
	      <input type="Date" name="bidstartdate">
	</div>
	
	<div class="input-group">
	      <label>Bid End Date : </label>
	      <input type="Date" name="bidenddate">
	</div>
    
    <br/><br/>
    <input type="submit" value="Submit" />
</form>
	
</body>
</html>