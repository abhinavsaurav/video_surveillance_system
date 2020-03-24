<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.vsstor.pojo.Configuration"%>
<%@page import="java.util.List"%>
<%@page import="com.vsstor.pojo.User"%>
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
                    <li >
                        <a href="welcome.jsp"> <i class="menu-icon fa fa-dashboard"></i>Dashboard </a>
                    </li>
                    <li>
						<h3 class="menu-title">Nodes Operations</h3><!-- /.menu-title -->
						</li>
                    <li class="active">
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
                    <li >
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
                        <h1>Configuration</h1>
                    </div>
                </div>
            </div>
        </div>

        <div class="content mt-3">          
	  <div class="col-sm-6 col-lg-12" >
                <div class="card" style='min-height:600px;'>                
                    <div class="card-body pb-0">
					<h4>Node Configurations can be done here</h4>
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
					
					
					
					<%
						List<Configuration> configurations = (List<Configuration>) request.getAttribute("configurations");
						SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy | hh:mm");
						if (configurations==null || configurations.size()==0)
						{
						   %>
						   	<h4>No Nodes have been configured yet. You can do it by clicking on 'Add node' below.</h4>
						   	<br/><br/>
						   	<a href='#' data-toggle="modal" data-target="#addNode">Add Node</a>
						   	
						   <%
						}
						else
						{
						   %>
						   		<a href='#' data-toggle="modal" data-target="#addNode">Add a New Node</a>
						   		<br/><br/>
						   		<%
						   			int i=0;
						   			for (Configuration conf: configurations)
						   			{
						   		%>
								   		<div class='col-md-3' >
								   			<br/>
								   			<ul class="list-group" >
											  <li class="list-group-item" > <img src='images/node.png' width='70%'/></li>
											  <li class="list-group-item"> <i class="menu-icon fa fa-cloud"></i>&nbsp;<%= conf.getHost() %></li>
											  <li class="list-group-item"> <i class="menu-icon fa fa-plug"></i>&nbsp;<%=conf.getPort() %></li>
											  <li class="list-group-item"> <i class="menu-icon fa fa-code"></i>&nbsp;<%=conf.getContextroot() %></li>
											  <li class="list-group-item"> <i class="menu-icon fa fa-user"></i>&nbsp;<%=conf.getCreated_by() %></li>
											  <li class="list-group-item"> <i class="menu-icon fa fa-clock-o"></i>&nbsp;<%=sdf.format(conf.getEntry_time())%></li>
											  <li class="list-group-item"> <a href='#' data-toggle="modal" data-target="#editNode<%=i%>"><i class="menu-icon fa fa-pencil-square-o"></i>&nbsp;Edit</a> &nbsp;&nbsp;&nbsp;&nbsp; | &nbsp;&nbsp;&nbsp;&nbsp;<a href='#' data-toggle="modal" data-target="#deleteNode<%=i%>"><i class="menu-icon fa fa-remove"></i>&nbsp;Delete</a></li>
											</ul>								   			
								   		</div>
								   		
																	<!-- Modal -->
												<div class="modal fade" id="editNode<%=i %>" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
												  <div class="modal-dialog" role="document">
												    <div class="modal-content">
												      <div class="modal-header">
												        
												        <h4 class="modal-title" id="myModalLabel">Update Node</h4>
												      </div>
													<form action='configuration' method="post">
														<input type=hidden name='requestType' value='update' />
												      <div class="modal-body">
															<label>Host Address</label>
															<input type=text name='host' value="<%=conf.getHost()%>" readonly="readonly" class='form-control' />
															<br/>
															<label>Port Number</label>
															<input type=text name='port' value="<%=conf.getPort()%>" class='form-control' />
															<br/>
															<label>Context Root</label>
															<input type=text name='context_root' value="<%=conf.getContextroot()%>" class='form-control' />
															<br/>
												      </div>
												      <div class="modal-footer">
												        <button type="button" class="btn btn-default" data-dismiss="modal">Cancel</button>
												        <button type="submit" class="btn btn-primary">Update Node</button>
												      </div>
												      </form>
												    </div>
												  </div>
												</div>	

																	<!-- Modal -->
												<div class="modal fade" id="deleteNode<%=i %>" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
												  <div class="modal-dialog" role="document">
												    <div class="modal-content">
												      <div class="modal-header">
												        
												        <h4 class="modal-title" id="myModalLabel">Delete Node</h4>
												      </div>
													<form action='configuration' method="post">
														<input type=hidden name='requestType' value='delete' />
														<input type=hidden name='host' value='<%=conf.getHost()%>' />
												      <div class="modal-body">
																	Are you sure you want to delete this Node?
												      </div>
												      <div class="modal-footer">
												        <button type="button" class="btn btn-default" data-dismiss="modal">Cancel</button>
												        <button type="submit" class="btn btn-primary">Delete Node</button>
												      </div>
												      </form>
												    </div>
												  </div>
												</div>	
												<%i++; %>							   		
						   		<% } %>
						   <%						   
						}
					%>
					
					
					
					<!-- Modal -->
<div class="modal fade" id="addNode" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        
        <h4 class="modal-title" id="myModalLabel">Add a New Node to the Cluster</h4>
      </div>
	<form action='configuration' method="post">
		<input type=hidden name='requestType' value='create' />
      <div class="modal-body">
			<label>Host Address</label>
			<input type=text name='host' placeholder="Ex: 192.168.0.1" class='form-control' />
			<br/>
			<label>Port Number</label>
			<input type=text name='port' placeholder="Ex: 8080" class='form-control' />
			<br/>
			<label>Context Root</label>
			<input type=text name='context_root' placeholder="Ex: NodeApp" class='form-control' />
			<br/>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">Cancel</button>
        <button type="submit" class="btn btn-primary">Add Node</button>
      </div>
      </form>
    </div>
  </div>
</div>
					
					<br/><br/><br/><br/>
					</div>
					<br/><br/><br/>
					</div>
					<br/><br/><br/>
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