<!doctype html>
<!--[if lt IE 7]>      <html class="no-js lt-ie9 lt-ie8 lt-ie7" lang=""> <![endif]-->
<!--[if IE 7]>         <html class="no-js lt-ie9 lt-ie8" lang=""> <![endif]-->
<!--[if IE 8]>         <html class="no-js lt-ie9" lang=""> <![endif]-->
<!--[if gt IE 8]><!-->
<html class="no-js" lang="en">
<!--<![endif]-->

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>vs-STOR</title>

    <link rel="stylesheet" href="vendors/bootstrap/dist/css/bootstrap.min.css">
    <link rel="stylesheet" href="vendors/font-awesome/css/font-awesome.min.css">
    <link rel="stylesheet" href="vendors/themify-icons/css/themify-icons.css">
    <link rel="stylesheet" href="vendors/flag-icon-css/css/flag-icon.min.css">
    <link rel="stylesheet" href="vendors/selectFX/css/cs-skin-elastic.css">
    <link rel="stylesheet" href="vendors/jqvmap/dist/jqvmap.min.css">


    <link rel="stylesheet" href="assets/css/style.css">

    <link href='https://fonts.googleapis.com/css?family=Open+Sans:400,600,700,800' rel='stylesheet' type='text/css'>

</head>

<body>


    <!-- Left Panel -->

    <aside id="left-panel" class="left-panel">
        <nav class="navbar navbar-expand-sm navbar-default">

            <div class="navbar-header">
                <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#main-menu" aria-controls="main-menu" aria-expanded="false" aria-label="Toggle navigation">
                    <i class="fa fa-bars"></i>
                </button>
                <a class="navbar-brand" href="./">VS-STOR</a>
                <a class="navbar-brand hidden" href="./">V</a>
            </div>

            <div id="main-menu" class="main-menu collapse navbar-collapse">
                <ul class="nav navbar-nav">
                    <li >
                        <a href="index.jsp"> <i class="menu-icon fa fa-info-circle"></i>About </a>
                    </li>
                    <li >
						<h3 class="menu-title">User Operations</h3><!-- /.menu-title -->
						</li>
                    <li class="active">
                        <a href="register.jsp"> <i class="menu-icon fa fa-user-plus"></i>Register </a>
                    </li>
                    <li>
                        <a href="login.jsp"> <i class="menu-icon fa fa-user"></i>Login </a>
                    </li>
                </ul>
            </div><!-- /.navbar-collapse -->
        </nav>
    </aside><!-- /#left-panel -->

    <!-- Left Panel -->

    <!-- Right Panel -->

    <div id="right-panel" class="right-panel">

    
        <div class="breadcrumbs">
            <div class="col-sm-4">
                <div class="page-header float-left">
                    <div class="page-title">
                        <h1>New User Registration</h1>
                    </div>
                </div>
            </div>
        </div>

        <div class="content mt-3">          
	  <div class="col-sm-6 col-lg-12" >
                <div class="card" style='min-height:600px;'>
                    <div class="card-body pb-0">
					
					<h4>Please fill out the below form to create your profile</h4>
					<hr/>
					
				<%
					String msg = request.getParameter("msg");
				%>
				<%
					if (msg != null)
					{
				%>
				<div class="alert alert-success alert-dismissable">
					<a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
					<strong>Message!</strong>
					<%=msg%>.
				</div>
				<%
					}
				%>
					
				<form method="post" action="account" class='col-md-6'>
						<input type="hidden" name='request_type' value='register' /> <label>Email:</label>
						<input type="text" name="email" class="form-control" /> <br /> <label>Password:</label>
						<input type="password" name="password"
							class="validate-email form-control" /> <br /> <label>First
							name:</label> <input type="text" name="fname" class="form-control" /> <br />
						<label>Last name:</label> <input type="text" name="lname"
							class="form-control" /> <br /> <label>Gender:</label> <br />
						<input type="radio" name='gender' value='Male' /> Male <input
							type="radio" name='gender' value='Female' /> Female <br />
						<br /> <label>Mobile:</label> <input type="text" name="mobile"
							class="form-control" /> <br /> <label>Address:</label>
						<textarea name="addr" rows=3 class="form-control"></textarea>
						<br /><br />
						<button class="btn btn-primary btn-lg btn-block" type="submit">Register</button>
				</form>
					
					
					
					</div>
					</div>
					</div>
           
        </div> <!-- .content -->
    </div><!-- /#right-panel -->

    <!-- Right Panel -->

    <script src="vendors/jquery/dist/jquery.min.js"></script>
    <script src="vendors/popper.js/dist/umd/popper.min.js"></script>
    <script src="vendors/bootstrap/dist/js/bootstrap.min.js"></script>
    <script src="assets/js/main.js"></script>


    <script src="vendors/chart.js/dist/Chart.bundle.min.js"></script>
    <script src="assets/js/dashboard.js"></script>
    <script src="assets/js/widgets.js"></script>
    <script src="vendors/jqvmap/dist/jquery.vmap.min.js"></script>
    <script src="vendors/jqvmap/examples/js/jquery.vmap.sampledata.js"></script>
    <script src="vendors/jqvmap/dist/maps/jquery.vmap.world.js"></script>
    <script>
        (function($) {
            "use strict";

            jQuery('#vmap').vectorMap({
                map: 'world_en',
                backgroundColor: null,
                color: '#ffffff',
                hoverOpacity: 0.7,
                selectedColor: '#1de9b6',
                enableZoom: true,
                showTooltip: true,
                values: sample_data,
                scaleColors: ['#1de9b6', '#03a9f5'],
                normalizeFunction: 'polynomial'
            });
        })(jQuery);
    </script>

</body>

</html>
