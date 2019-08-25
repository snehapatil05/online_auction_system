
<!DOCTYPE html>
<html>
<head>
  <title>Register</title>
  <link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>
  <div class="header">
    <h2>Register</h2>
  </div>
  
  <form method="post" action="">
   
    <div class="input-group">
      <label>Name</label>
      <input type="text" name="name" required>
    </div>
    <div class="input-group">
      <label>Date of Birth</label>
      <input type="Date" name="dateofbirth" required>
    </div>
    
    <div class="input-group">
      <label>Email</label>
      <input type="email" name="email" required >
    </div>
    <div class="input-group">
      <label>Phone number</label>
      <input type="text" name="phonenumber" required >
    </div>

    <div class="input-group">
      <label>Username</label>
      <input type="text" name="username" required >
    </div>


    <div class="input-group">
      <label>Password</label>
      <input type="password" name="password1" required>
    </div>
    <div class="input-group">
      <label>Confirm password</label>
      <input type="password" name="password2" required>
    </div>
    
      <label>Type of user</label>
      <br>
      <br>
      <input type="radio" name="category" value="Buyer"> Buyer <br>
  <input type="radio" name="category" value="Seller"> Seller
    

    <div class="input-group">
      <button type="submit" class="btn" name="reg_user">Register</button>
    </div>
    <p>
      Already a member? <a href="login.html">Login</a>
    </p>
  </form>
</body>
</html>
