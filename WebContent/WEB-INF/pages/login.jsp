
<!DOCTYPE html>
<html>
<head>
  <title>LoginL</title>
  <link rel="stylesheet" type="text/css" href="../styles/style.css">
  <script>
  </script>
</head>
<body>
  <div class="header">
  	<h2>Login</h2>
  </div>
	 
  <form method="post" action=Loginvalidation.java">
  	
  	<div class="input-group">
  		<label>Username</label>
  		<input type="text" name="username" required >
  	</div>
  	<div class="input-group">
  		<label>Password</label>
  		<input type="password" name="password" required>
  	</div>
  	<div class="input-group">
  		<button type="submit" class="btn" name="login_user">Login</button>
  	</div>
  	<p>
  		Not yet registered? <a href="register.jsp">Sign up</a>
  	</p>
  </form>
</body>
</html>
