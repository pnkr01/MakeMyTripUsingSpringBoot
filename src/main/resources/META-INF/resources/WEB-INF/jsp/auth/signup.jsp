<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Sign Up</title>
    <script>
        function showError(message) {
            var errorDiv = document.getElementById("error-message");
            if (message) {
                errorDiv.innerHTML = message;
                errorDiv.style.display = "block";
            }
        }
    </script>
    <style>
        .container {
            width: 50%;
            margin: auto;
            padding: 20px;
            border: 1px solid #ccc;
            border-radius: 10px;
            background-color: #f9f9f9;
        }
        .form-group {
            margin-bottom: 15px;
        }
        label {
            display: block;
            margin-bottom: 5px;
        }
        input[type="text"], input[type="email"], input[type="password"], input[type="number"], select {
            width: 100%;
            padding: 10px;
            margin: 5px 0 10px 0;
            border: 1px solid #ccc;
            border-radius: 5px;
            box-sizing: border-box;
            max-width: 100%;
        }
        input[type="submit"] {
            width: 100%;
            background-color: #4CAF50;
            color: white;
            padding: 10px;
            border: none;
            border-radius: 5px;
            cursor: pointer;
        }
        input[type="submit"]:hover {
            background-color: #45a049;
        }
        .login-link {
            text-align: center;
            margin-top: 10px;
        }
    </style>
</head>
<body>

<div class="container">
    <div id="error-message" style="color:red; display:none;"></div>
    <h2>Sign Up</h2>
    <form action="signup" method="post">

        <!-- Name -->
        <div class="form-group">
            <label for="user_name">Name:</label>
            <input type="text" id="user_name" name="name" placeholder="Enter your name" required>
        </div>

        <!-- Email -->
        <div class="form-group">
            <label for="user_email">Email:</label>
            <input type="email" id="user_email" name="userEmail" placeholder="Enter Email" required>
        </div>

        <!-- Age -->
        <div class="form-group">
            <label for="user_age">Age:</label>
            <input type="number" id="user_age" name="userAge" min="1" max="120" placeholder="Enter age" required>
        </div>

        <!-- Phone Number -->
        <div class="form-group">
            <label for="user_phone">Phone Number:</label>
            <input type="text" id="user_phone" name="userPhone" pattern="\d{10}" required placeholder="10-digit number">
        </div>

        <!-- Username -->
        <div class="form-group">
            <label for="user_username">Username:</label>
            <input type="text" id="user_username" name="userName" placeholder="Choose a username" required>
        </div>

        <!-- Password -->
        <div class="form-group">
            <label for="user_password">Password:</label>
            <input type="password" id="user_password" name="userPassword" placeholder="Enter strong password" required>
        </div>

        <!-- User Type -->
        <div class="form-group">
            <label for="user_type">User Type:</label>
            <select id="user_type" name="userType" required>
                <option value="Admin">Admin</option>
                <option value="User">User</option>
                <option value="Agent">Agent</option>
            </select>
        </div>

        <input type="submit" value="Sign Up">
    </form>
    <div class="login-link">
        <a href="login">Already have an account? Login</a>
    </div>
</div>
<script>
    var errorMessage = "${error}";
    showError(errorMessage);
</script>
</body>
</html>
