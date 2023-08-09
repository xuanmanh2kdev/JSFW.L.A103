<%--
  Created by IntelliJ IDEA.
  User: aaaaaaaaaaa
  Date: 4/23/2023
  Time: 11:04 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <meta charset="utf-8"/>
  <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
  <title>Register</title>
  <meta name="viewport" content="width=device-width, initial-scale=1"/>

  <link
          rel="stylesheet"
          href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap/4.6.2/css/bootstrap.min.css"
          integrity="sha512-rt/SrQ4UNIaGfDyEXZtNcyWvQeOq0QLygHluFQcSjaGB04IxWhal71tKuzP6K8eYXYB6vJV4pHkXcmFGGQ1/0w=="
          crossorigin="anonymous"
          referrerpolicy="no-referrer"
  />

  <link href="${pageContext.request.contextPath}/assets/css/normalize.css" rel="stylesheet">
  <link href="${pageContext.request.contextPath}/assets/css/style.css" rel="stylesheet">
</head>
<body class="bg-light">
<div class="container text-dark">
  <div id="login-row" class="row justify-content-center align-items-center">
    <div id="login-column" class="col-md-6">
      <div id="login-box" class="col-md-12 border rounded mt-5 bg-white">
        <p
                class="h3 text-left ml-02 mr-02 bg-light pl-3 mb-3 border border-bottom"
        >
          Register
        </p>
        <form action="${pageContext.request.contextPath}/register" method="post">
          <div class="form-group">
            <input
                    type="text"
                    id="username"
                    name="username"
                    class="form-control"
                    placeholder="User name"
                    minlength="3"
                    maxlength="30"
                    required
            />
          </div>
          <div class="form-group">
            <input
                    type="email"
                    id="email"
                    name="email"
                    class="form-control"
                    placeholder="E-mail"
                    minlength="5"
                    required
            />
          </div>
          <div class="form-group">
            <input
                    type="password"
                    id="firstSecPass"
                    name="password"
                    class="form-control"
                    placeholder="Password"
                    minlength="8"
                    maxlength="30"
                    required
            />
          </div>
          <div class="form-group">
            <input
                    type="password"
                    id="ConfirmSecPass"
                    name="confirmPassword"
                    class="form-control"
                    placeholder="Confirm Password"
                    minlength="8"
                    maxlength="30"
                    required
            />
          </div>
          <button
                  class="btn btn-primary w-100 pt-2 pb-2 bg-success mb-2"
                  onclick="return Validate()"
          >
            Register
          </button>
          <div id="register-link" class="text-left pb-2">
            <a href="${pageContext.request.contextPath}/login">Click here to Login</a>
          </div>
        </form>
      </div>
    </div>
  </div>
</div>
<script type="text/javascript">
  function Validate() {
    var SecPass = document.getElementById("firstSecPass").value;
    var confirmSecPass = document.getElementById("ConfirmSecPass").value;
    if (SecPass != confirmSecPass) {
      alert(
              "You first Passwords is not similar with second password. Please enter same password in both"
      );
      return false;
    }
    return true;
  }
</script>
</body>
</html>