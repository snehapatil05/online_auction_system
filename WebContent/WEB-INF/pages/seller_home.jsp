<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.List"%>

<!DOCTYPE html>
<% List sellerList = (List)request.getAttribute("sellerList");
   request.setAttribute("sellerList", sellerList);
   
   List sellerProdList = (List)request.getAttribute("sellerProdList");
   request.setAttribute("sellerProdList", sellerProdList);
%>

<html>
<head>
<meta charset="ISO-8859-1">
<title>Seller Home Page</title>
</head>
<body>
	<c:forEach items="${sellerList}" var="seller">
		<h4>Name : <c:out value="${seller.name}"/></h4>
		<h4>Name : <c:out value="${seller.email}"/></h4>
		<h4>Name : <c:out value="${seller.phone}"/></h4>
		<h4>Name : <c:out value="${seller.lastLoggedin}"/></h4>
	</c:forEach>
	
	<c:forEach items="${sellerProdList}" var="sellerprodlist">
		<h4>Product Name : <c:out value="${sellerprodlist.name}"/></h4>
		<h4>Highest Current Bid : <c:out value="${sellerprodlist.highestcurrentbid}"/></h4>
		<h4>Number of Bidders : <c:out value="${sellerprodlist.biddercount}"/></h4>
		<h4>Bid End Date : <c:out value="${sellerprodlist.bidenddate}"/></h4>
	</c:forEach>
	
	<a href="addproduct.jsp"><button> Add Product</button></a>
</body>
</html>