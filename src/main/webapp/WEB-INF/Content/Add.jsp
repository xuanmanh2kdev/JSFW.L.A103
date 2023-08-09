<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8" />
  <meta http-equiv="X-UA-Compatible" content="IE=edge" />
  <title>Add content</title>
  <meta name="viewport" content="width=device-width, initial-scale=1" />
  <link
          rel="stylesheet"
          href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap/4.6.2/css/bootstrap.min.css"
          integrity="sha512-rt/SrQ4UNIaGfDyEXZtNcyWvQeOq0QLygHluFQcSjaGB04IxWhal71tKuzP6K8eYXYB6vJV4pHkXcmFGGQ1/0w=="
          crossorigin="anonymous"
          referrerpolicy="no-referrer"
  />

  <link
          rel="stylesheet"
          href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css"
          integrity="sha512-1ycn6IcaQQ40/MKBW2W4Rhis/DbILU74C1vSrLJxCq57o941Ym01SwNsOMqvEBFlcgUa6xLiPY/NS5R+E6ztJQ=="
          crossorigin="anonymous"
          referrerpolicy="no-referrer"
  />

  <script
          src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js"
          integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
          crossorigin="anonymous"
  ></script>
  <script
          src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"
          integrity="sha384-Fy6S3B9q64WdZWQUiU+q4/2Lc9npb8tCaSX9FK7E8HnRr0Jz8D6OP9dO5Vg3Q9ct"
          crossorigin="anonymous"
  ></script>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/normalize.css" />
  <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/login.css" />
</head>
<body class="bg-light">
<div class="container-fluid">
  <nav
          class="navbar navbar-expand-lg navbar-light bg-light border-bottom d-flex justify-content-between"
  >
    <a class="navbar-brand text-secondary" href="${pageContext.request.contextPath}/edit">CMS</a>

    <div class="dropdown">
      <button
              class="btn dropdown-toggle"
              type="button"
              id="dropdownMenuButton"
              data-toggle="dropdown"
              aria-haspopup="true"
              aria-expanded="false"
      >
        <i class="fas fa-user"></i>
      </button>
      <div
              class="dropdown-menu dropdown-menu-right shadow"
              aria-labelledby="dropdownMenuButton"
      >
        <a class="dropdown-item border-bottom" href="${pageContext.request.contextPath}/edit"
        ><i class="fas fa-user"></i> User Profile</a
        >
        <a class="dropdown-item pt-0" href="${pageContext.request.contextPath}/logout"
        ><i class="fas fa-sign-out-alt"></i> Logout</a
        >
      </div>
    </div>
  </nav>

  <div class="row mb-3 d-flex justify-content-between">
    <div class="col-sm-2 bg-light">
      <form
              class="form-inline mt-4 pb-2 border-bottom"
              action="/action_page.php"
      >
        <input class="form-control w-75" type="text" placeholder="Search" />
        <button class="btn border" type="submit">
          <i class="fas fa-search"></i>
        </button>
      </form>

      <div class="container-fluid pt-2 pb-2 border mt-4">
        <a href="view.html">
          <i class="fas fa-table"></i>
          View contents
        </a>
      </div>

      <div
              class="container-fluid pt-2 pb-2 border border-top-0 form-content"
      >
        <a href="${pageContext.request.contextPath}/form">
          <i class="fas fa-edit"></i>
          Form content
        </a>
      </div>
    </div>

    <div class="col-sm-10 bg-white">
      <p class="h2 mt-5 mb-5 border-bottom">Add Content</p>
      <div class="container-fluid border rounded">
        <form id="login-form" class="form" action="${pageContext.request.contextPath}/form" method="post">
          <p class="bg-light ml-02 mr-02 border-bottom pt-2 pb-2 pl-2">
            Content Form Elements
          </p>

          <div class="form-group">
            <label for="title" class="font-weight-bold"> Title </label>
            <input
                    name="title"
                    type="text"
                    id="title"
                    class="form-control w-75"
                    placeholder="Enter the title"
                    minlength="10"
                    maxlength="200"
                    required
            />
          </div>

          <div class="form-group">
            <label for="brief" class="font-weight-bold"> Brief </label>
            <br />
            <textarea
                    name="brief"
                    id="brief"
                    class="w-75"
                    cols="30"
                    rows="5"
                    minlength="30"
                    maxlength="150"
                    required
            ></textarea>
          </div>

          <div class="form-group">
            <label for="content" class="font-weight-bold"> Content </label>
            <br />
            <textarea
                    name="content"
                    id="content"
                    class="w-75"
                    cols="30"
                    rows="10"
                    minlength="50"
                    maxlength="1000"
                    required
            ></textarea>
          </div>

          <div class="form-group">
            <button class="btn bg-white border-secondary" type="submit">
              Submit Button
            </button>
            <button class="btn bg-white border-secondary" type="reset">
              Reset Button
            </button>
          </div>
        </form>
      </div>
    </div>
  </div>
</div>
</body>
</html>
