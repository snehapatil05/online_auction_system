
<!DOCTYPE html>
<html>
<head>
<title>Register</title>
<link rel="stylesheet" type="text/css" href="../styles/style.css">
<script>
  
  function validateRegisterForm(){
	  
	 
				var phonenumber = document.forms["registerform"]["phonenumber"].value;
				var username = document.forms["registerform"]["username"].value;
				var node = document.createElement("LI");
				var flag = 0;

				if (username.length < 3) {
					// alert("Username length should be atleast three.");
					//var value = document.getElementById("error").value;
					var textnode = document
							.createTextNode("Username length should be atleast three");
					node.appendChild(textnode);
					document.getElementById("mylist").appendChild(node);
					//document.getElementById("mylist").appendChild("\n");
					//document.getElementById("username").innerHTMl = "Username length should be atleast three";

					flag = 1;

					//document.getElementById("error").innerHTML= value + "Username length should be atleast three";

				}

				if (phonenumber.length != 10) {
					//alert("Phone number should contain only 10 digits");
					var newvalue = document
							.createTextNode("Phone number should contain only 10 digits")
					node.appendChild(newvalue);
					document.getElementById("mylist").appendChild(node);
					//document.getElementById("mylist").appendChild("\n");
					flag = 1;

				}

				for (var i = 0; i < phonenumber.length; i++) {

					if (phonenumber.charCodeAt(i) <= 48
							|| phonenumber.charCodeAt(i) >= 57) {
						console.log("false");
						//window.alert("Invalid format of phonenumber");
						var newvalue = document
								.createTextNode("Invalid format of phonenumber");
						node.appendChild(newvalue);
						document.getElementById("mylist").appendChild(node);
						//
						//	document.getElementById("mylist").appendChild("\n");
						flag = 1;

					}
				}
				if (flag == 1) {
					return false;

				}
				return true;

			}
		</script>
</head>
<body>
	<header id="error">
		<div>
			<ul id="mylist">



			</ul>

		</div>
	</header>
	<div class="header">
		<h2>Register</h2>
	</div>

	<form name="registerform" method="post"
		action="/AUCTION/src/com/oas/validations/Registervalidation.java"
		onsubmit="return validateRegisterForm()">

		<div class="input-group">
			<label>Name</label> <input type="text" name="name">
		</div>
		<div class="input-group">
			<label>Date of Birth</label> <input type="Date" name="dateofbirth">
		</div>

		<div class="input-group">
			<label>Email</label> <input type="email" name="email" required>
		</div>
		<div class="input-group">
			<label>Phone number</label> <input type="text" name="phonenumber"
				required>
		</div>

		<div class="input-group">
			<label>Username</label> <input type="text" name="username">
		</div>


		<div class="input-group">
			<label>Password</label> <input type="password" name="password1">
		</div>
		<div class="input-group">
			<label>Confirm password</label> <input type="password"
				name="password2">
		</div>
		<div class="input-group">
			<label>Address</label> <input type="text" name="address">
		</div>

		<label>Type of user</label> <br> <br> <input type="radio"
			name="category" value="Buyer"> Buyer <br> <input
			type="radio" name="category" value="Seller"> Seller <br>
		<div class="input-group">
			<label>Walletamount</label> <input type="number" name="walletamount"
				required>
		</div>

		<div class="input-group">
			<button type="submit" class="btn" name="reg_user">Register</button>
		</div>
		<p>
			Already a member? <a href="login.jsp">Login</a>
		</p>
	</form>
</body>
</html>
