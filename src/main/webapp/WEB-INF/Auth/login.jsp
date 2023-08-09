<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <title>Login</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css"
          integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N" crossorigin="anonymous">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/normalize.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/login.css"/>
</head>
<body class="bg-light">
<div class="container text-dark">
    <div id="login-row" class="row justify-content-center align-items-center">
        <div id="login-column" class="col-md-6">
            <div id="login-box" class="col-md-12 border rounded mt-5 bg-white">
                <p
                        class="h3 text-left ml-02 mr-02 bg-light pl-3 mb-3 border border-bottom"
                >
                    Please Sign In
                </p>
                <form method="POST" name="loginForm" action="${pageContext.request.contextPath}/login">
                    <div class="form-group">
                        <input
                                type="text"
                                id="account"
                                name="account"
                                class="form-control"
                                placeholder="Account"
                                minlength="5"
                                maxlength="50"
                                required
                        />
                    </div>
                    <div class="form-group">
                        <input
                                type="password"
                                id="password"
                                name="password"
                                class="form-control"
                                placeholder="Password"
                                minlength="8"
                                maxlength="50"
                                required
                        />
                    </div>
                    <div class="form-check mb-2">
                        <input
                                id="remember-me"
                                type="checkbox"
                                class="form-check-input"
                        />
                        <label class="form-check-label" for="remember-me"
                        >Remember Me</label
                        >
                    </div>
                    <%
                        String error = (String) request.getAttribute("errorInvalidAccount");
                        if (error != null) { %>
                    <p class="text-danger"><%=error%>
                    </p>
                    <%}%>
                    <button
                            class="btn btn-primary w-100 pt-2 pb-2 bg-success mb-2"
                            type="submit"
                    >
                        Login
                    </button>
                    <div id="register-link" class="text-left pb-2">
                        <a href="${pageContext.request.contextPath}/register">Click here to Register</a>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>
</body>
</html>
