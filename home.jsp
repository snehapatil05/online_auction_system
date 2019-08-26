<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.List"%>

<!DOCTYPE html>
<% List prodList = (List)request.getAttribute("productList");
   request.setAttribute("prodList", prodList);
%>

<html>
    
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <title>HOMEPAGE</title>
        <meta name="description" content="An interactive getting started guide for Brackets.">
        <link rel="stylesheet" href="main1.css">
        <script>
            filterSelection("all") // Execute the function and show all columns
            function filterSelection(c) {
              var x, i;
              x = document.getElementsByClassName("column");
              if (c == "all") c = "";
              // Add the "show" class (display:block) to the filtered elements, and remove the "show" class from the elements that are not selected
              for (i = 0; i < x.length; i++) {
                w3RemoveClass(x[i], "show");
                if (x[i].className.indexOf(c) > -1) w3AddClass(x[i], "show");
              }
            }

            // Show filtered elements
            function w3AddClass(element, name) {
              var i, arr1, arr2;
              arr1 = element.className.split(" ");
              arr2 = name.split(" ");
              for (i = 0; i < arr2.length; i++) {
                if (arr1.indexOf(arr2[i]) == -1) {
                  element.className += " " + arr2[i];
                }
              }
            }

            // Hide elements that are not selected
            function w3RemoveClass(element, name) {
              var i, arr1, arr2;
              arr1 = element.className.split(" ");
              arr2 = name.split(" ");
              for (i = 0; i < arr2.length; i++) {
                while (arr1.indexOf(arr2[i]) > -1) {
                  arr1.splice(arr1.indexOf(arr2[i]), 1); 
                }
              }
              element.className = arr1.join(" ");
            }

            // Add active class to the current button (highlight it)
            var btnContainer = document.getElementById("myBtnContainer");
            var btns = btnContainer.getElementsByClassName("btn");
            for (var i = 0; i < btns.length; i++) {
              btns[i].addEventListener("click", function(){
                var current = document.getElementsByClassName("active");
                current[0].className = current[0].className.replace(" active", "");
                this.className += " active";
              });
            }
        </script>
    </head>
    <body>
        
        <h2>PORTFOLIO</h2>
        <div id="myBtnContainer">
            <button class="btn active" onclick="filterSelection('all')"> Show all Art</button>
            <button class="btn" onclick="filterSelection('contemporary')"> Contemporary Art</button>
            <button class="btn" onclick="filterSelection('illustration')"> Illustration Art</button>
            <button class="btn" onclick="filterSelection('animation')"> Animation Art</button>
            <button class="btn" onclick="filterSelection('science')"> Nature and Science Art</button>
            <button class="login" onclick="filterSelection('login')"> Login</button>
            <button class="register" onclick="filterSelection('register')"> Register</button>
        </div>

        <!-- Portfolio Gallery Grid -->
        
        <div class="row">
        	<%   if(prodList.category.equals("contemporary")){	%>
	        	<c:forEach items="${prodList}" var="product">
			        <div class="column contemporary">
				        <div class="content">
				            <!--  <img src="./w3images/contemporary1.jpg" alt="Contemporary1" style="width:100%"> -->
				            <h4>Product Name : <c:out value="${product.name}"/></h4>
				            <p>Price : <c:out value="${product.actualPrice}"/></p>				        
			
				        </div>
			        </div>
			    </c:forEach>
			<% } %>
			
			<%   if(prodList.category.equals("illustration")){	%>
	        	<c:forEach items="${prodList}" var="product">
			        <div class="column illustration">
				        <div class="content">
				            <!--  <img src="./w3images/contemporary1.jpg" alt="Contemporary1" style="width:100%"> -->
				            <h4>Product Name : <c:out value="${product.name}"/></h4>
				            <p>Price : <c:out value="${product.actualPrice}"/></p>				        
			
				        </div>
			        </div>
			    </c:forEach>
			<% } %>
			
			<%   if(prodList.category.equals("animation")){	%>
	        	<c:forEach items="${prodList}" var="product">
			        <div class="column animation">
				        <div class="content">
				            <!--  <img src="./w3images/contemporary1.jpg" alt="Contemporary1" style="width:100%"> -->
				            <h4>Product Name : <c:out value="${product.name}"/></h4>
				            <p>Price : <c:out value="${product.actualPrice}"/></p>				        
			
				        </div>
			        </div>
			    </c:forEach>
			<% } %>
			
			<%   if(prodList.category.equals("nature and science")){	%>
	        	<c:forEach items="${prodList}" var="product">
			        <div class="column science">
				        <div class="content">
				            <!--  <img src="./w3images/contemporary1.jpg" alt="Contemporary1" style="width:100%"> -->
				            <h4>Product Name : <c:out value="${product.name}"/></h4>
				            <p>Price : <c:out value="${product.actualPrice}"/></p>				        
			
				        </div>
			        </div>
			    </c:forEach>
			<% } %>
        <!-- END GRID -->
        </div>
        
    </body>
</html>