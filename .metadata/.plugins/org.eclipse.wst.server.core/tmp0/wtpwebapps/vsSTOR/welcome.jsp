<%@page import="com.vsstor.pojo.User"%>		<!--about page directive Defines page-dependent attributes, such as scripting language, error page, and buffering requirements. -->
<%
	User u1 = (User) session.getAttribute("user");
	if (u1 == null) {
		response.sendRedirect("login.jsp?msg=Session expired. Login again");
	} else {
%>
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
                <a class="navbar-brand" href="welcome.jsp">VS-STOR</a>
                <a class="navbar-brand hidden" href="./">V</a>
            </div>

            <div id="main-menu" class="main-menu collapse navbar-collapse">
                <ul class="nav navbar-nav">
                    <li class="active">
                        <a href="welcome.jsp"> <i class="menu-icon fa fa-dashboard"></i>Dashboard </a>
                    </li>
                    <li>
						<h3 class="menu-title">Nodes Operations</h3><!-- /.menu-title -->
						</li>
                    <li>
                        <a href="configuration?requestType=get"> <i class="menu-icon fa fa-cog"></i>Configuration </a>
                    </li>
                    <li>
                        <a href="health"> <i class="menu-icon fa fa-heart"></i>Health Check </a>
                    </li>
                    <li>
                    <h3 class="menu-title">Storage Operations</h3><!-- /.menu-title -->
                    </li>
                    <li>
                        <a href="upload"> <i class="menu-icon fa fa-upload"></i>Upload </a>
                    </li>
                    <li>
                        <a href="process"> <i class="menu-icon fa fa-arrows-alt"></i>Process </a>
                    </li>
                    <li>
                    <h3 class="menu-title">Video Streaming</h3><!-- /.menu-title -->
                    </li>
                    <li>
                        <a href="control.jsp"> <i class="menu-icon fa fa-camera"></i>Control</a>
                    </li>

                    <li>
                    <h3 class="menu-title">Statistics Operations</h3><!-- /.menu-title -->
                    </li>
                    <li>
                        <a href="report"> <i class="menu-icon fa fa-database"></i>Report </a>
                    </li>

                    <li>
					<h3 class="menu-title">Profile Operations</h3><!-- /.menu-title -->
					</li>
				
                    <li class="menu-item-has-children dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"> <i class="menu-icon fa fa-tasks"></i><%=u1.getFname() %> <%=u1.getLname() %></a>
                        <ul class="sub-menu children dropdown-menu">
                            <li><i class="menu-icon fa fa-user"></i><a href="updateprofile.jsp">Edit Profile</a></li>
                            <li><i class="menu-icon fa fa-eye"></i><a href="changepassword.jsp">Change Password</a></li>
                            <li><i class="menu-icon fa fa-user-times"></i><a href="account?request_type=deleteprofile">Delete Profile</a></li>
                            <li><i class="menu-icon fa fa-hand-o-left"></i><a href="account?request_type=logout">Logout</a></li>
                        </ul>
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
                        <h1>Dashboard</h1>
                    </div>
                </div>
            </div>
        </div>

        <div class="content mt-3">          
	  <div class="col-sm-6 col-lg-12" >
                <div class="card" style='min-height:600px;'>
                    <div class="card-body pb-0">
					
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
<% } %>