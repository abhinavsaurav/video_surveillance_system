/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.2
 * Generated at: 2019-06-10 17:41:26 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.text.SimpleDateFormat;
import com.vsstor.pojo.Configuration;
import java.util.List;
import com.vsstor.pojo.User;

public final class configuration_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = new java.util.HashSet<>();
    _jspx_imports_classes.add("java.util.List");
    _jspx_imports_classes.add("java.text.SimpleDateFormat");
    _jspx_imports_classes.add("com.vsstor.pojo.User");
    _jspx_imports_classes.add("com.vsstor.pojo.Configuration");
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    final java.lang.String _jspx_method = request.getMethod();
    if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method) && !javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSPs only permit GET POST or HEAD");
      return;
    }

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");

	User u1 = (User) session.getAttribute("user");
	if (u1 == null) {
		response.sendRedirect("login.jsp?msg=Session expired. Login again");
	} else {

      out.write("\r\n");
      out.write("<!doctype html>\r\n");
      out.write("<!--[if lt IE 7]>      <html class=\"no-js lt-ie9 lt-ie8 lt-ie7\" lang=\"\"> <![endif]-->\r\n");
      out.write("<!--[if IE 7]>         <html class=\"no-js lt-ie9 lt-ie8\" lang=\"\"> <![endif]-->\r\n");
      out.write("<!--[if IE 8]>         <html class=\"no-js lt-ie9\" lang=\"\"> <![endif]-->\r\n");
      out.write("<!--[if gt IE 8]><!-->\r\n");
      out.write("<html class=\"no-js\" lang=\"en\">\r\n");
      out.write("<!--<![endif]-->\r\n");
      out.write("\r\n");
      out.write("<head>\r\n");
      out.write("    <meta charset=\"utf-8\">\r\n");
      out.write("    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\r\n");
      out.write("    <title>vs-STOR</title>\r\n");
      out.write("\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"vendors/bootstrap/dist/css/bootstrap.min.css\">\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"vendors/font-awesome/css/font-awesome.min.css\">\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"vendors/themify-icons/css/themify-icons.css\">\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"vendors/flag-icon-css/css/flag-icon.min.css\">\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"vendors/selectFX/css/cs-skin-elastic.css\">\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"vendors/jqvmap/dist/jqvmap.min.css\">\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"assets/css/style.css\">\r\n");
      out.write("\r\n");
      out.write("    <link href='https://fonts.googleapis.com/css?family=Open+Sans:400,600,700,800' rel='stylesheet' type='text/css'>\r\n");
      out.write("\r\n");
      out.write("</head>\r\n");
      out.write("\r\n");
      out.write("<body>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("    <!-- Left Panel -->\r\n");
      out.write("\r\n");
      out.write("    <aside id=\"left-panel\" class=\"left-panel\">\r\n");
      out.write("        <nav class=\"navbar navbar-expand-sm navbar-default\">\r\n");
      out.write("\r\n");
      out.write("            <div class=\"navbar-header\">\r\n");
      out.write("                <button class=\"navbar-toggler\" type=\"button\" data-toggle=\"collapse\" data-target=\"#main-menu\" aria-controls=\"main-menu\" aria-expanded=\"false\" aria-label=\"Toggle navigation\">\r\n");
      out.write("                    <i class=\"fa fa-bars\"></i>\r\n");
      out.write("                </button>\r\n");
      out.write("                <a class=\"navbar-brand\" href=\"welcome.jsp\">VS-STOR</a>\r\n");
      out.write("                <a class=\"navbar-brand hidden\" href=\"./\">V</a>\r\n");
      out.write("            </div>\r\n");
      out.write("\r\n");
      out.write("            <div id=\"main-menu\" class=\"main-menu collapse navbar-collapse\">\r\n");
      out.write("                <ul class=\"nav navbar-nav\">\r\n");
      out.write("                    <li >\r\n");
      out.write("                        <a href=\"welcome.jsp\"> <i class=\"menu-icon fa fa-dashboard\"></i>Dashboard </a>\r\n");
      out.write("                    </li>\r\n");
      out.write("                    <li>\r\n");
      out.write("\t\t\t\t\t\t<h3 class=\"menu-title\">Nodes Operations</h3><!-- /.menu-title -->\r\n");
      out.write("\t\t\t\t\t\t</li>\r\n");
      out.write("                    <li class=\"active\">\r\n");
      out.write("                        <a href=\"configuration?requestType=get\"> <i class=\"menu-icon fa fa-cog\"></i>Configuration </a>\r\n");
      out.write("                    </li>\r\n");
      out.write("                    <li>\r\n");
      out.write("                        <a href=\"health\"> <i class=\"menu-icon fa fa-heart\"></i>Health Check </a>\r\n");
      out.write("                    </li>\r\n");
      out.write("                    <li>\r\n");
      out.write("                    <h3 class=\"menu-title\">Storage Operations</h3><!-- /.menu-title -->\r\n");
      out.write("                    </li>\r\n");
      out.write("                    <li>\r\n");
      out.write("                        <a href=\"upload\"> <i class=\"menu-icon fa fa-upload\"></i>Upload </a>\r\n");
      out.write("                    </li>\r\n");
      out.write("                    <li>\r\n");
      out.write("                        <a href=\"process\"> <i class=\"menu-icon fa fa-arrows-alt\"></i>Process </a>\r\n");
      out.write("                    </li>\r\n");
      out.write("                     <li>\r\n");
      out.write("                    <h3 class=\"menu-title\">Video Streaming</h3><!-- /.menu-title -->\r\n");
      out.write("                    </li>\r\n");
      out.write("                    <li >\r\n");
      out.write("                        <a href=\"control.jsp\"> <i class=\"menu-icon fa fa-camera\"></i>Control</a>\r\n");
      out.write("                    </li>\r\n");
      out.write("                    \r\n");
      out.write("                    <li>\r\n");
      out.write("                    <h3 class=\"menu-title\">Statistics Operations</h3><!-- /.menu-title -->\r\n");
      out.write("                    </li>\r\n");
      out.write("                    <li>\r\n");
      out.write("                        <a href=\"report\"> <i class=\"menu-icon fa fa-database\"></i>Report </a>\r\n");
      out.write("                    </li>\r\n");
      out.write("                    <li>\r\n");
      out.write("\t\t\t\t\t<h3 class=\"menu-title\">Profile Operations</h3><!-- /.menu-title -->\r\n");
      out.write("\t\t\t\t\t</li>\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("                    <li class=\"menu-item-has-children dropdown\">\r\n");
      out.write("                        <a href=\"#\" class=\"dropdown-toggle\" data-toggle=\"dropdown\" aria-haspopup=\"true\" aria-expanded=\"false\"> <i class=\"menu-icon fa fa-tasks\"></i>");
      out.print(u1.getFname() );
      out.write(' ');
      out.print(u1.getLname() );
      out.write("</a>\r\n");
      out.write("                        <ul class=\"sub-menu children dropdown-menu\">\r\n");
      out.write("                            <li><i class=\"menu-icon fa fa-user\"></i><a href=\"updateprofile.jsp\">Edit Profile</a></li>\r\n");
      out.write("                            <li><i class=\"menu-icon fa fa-eye\"></i><a href=\"changepassword.jsp\">Change Password</a></li>\r\n");
      out.write("                            <li><i class=\"menu-icon fa fa-user-times\"></i><a href=\"account?request_type=deleteprofile\">Delete Profile</a></li>\r\n");
      out.write("                            <li><i class=\"menu-icon fa fa-hand-o-left\"></i><a href=\"account?request_type=logout\">Logout</a></li>\r\n");
      out.write("                        </ul>\r\n");
      out.write("                    </li>\r\n");
      out.write("                </ul>\r\n");
      out.write("            </div><!-- /.navbar-collapse -->\r\n");
      out.write("        </nav>\r\n");
      out.write("    </aside><!-- /#left-panel -->\r\n");
      out.write("\r\n");
      out.write("    <!-- Left Panel -->\r\n");
      out.write("\r\n");
      out.write("    <!-- Right Panel -->\r\n");
      out.write("\r\n");
      out.write("    <div id=\"right-panel\" class=\"right-panel\">\r\n");
      out.write("\r\n");
      out.write("    \r\n");
      out.write("        <div class=\"breadcrumbs\">\r\n");
      out.write("            <div class=\"col-sm-4\">\r\n");
      out.write("                <div class=\"page-header float-left\">\r\n");
      out.write("                    <div class=\"page-title\">\r\n");
      out.write("                        <h1>Configuration</h1>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("        <div class=\"content mt-3\">          \r\n");
      out.write("\t  <div class=\"col-sm-6 col-lg-12\" >\r\n");
      out.write("                <div class=\"card\" style='min-height:600px;'>                \r\n");
      out.write("                    <div class=\"card-body pb-0\">\r\n");
      out.write("\t\t\t\t\t<h4>Node Configurations can be done here</h4>\r\n");
      out.write("\t\t\t\t\t<hr/>\r\n");
      out.write("                    \r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t\t");

					String msg = request.getParameter("msg");
				
      out.write("\r\n");
      out.write("\t\t\t\t");

					if (msg != null)
					{
				
      out.write("\r\n");
      out.write("\t\t\t\t<div class=\"alert alert-success alert-dismissable\">\r\n");
      out.write("\t\t\t\t\t<a href=\"#\" class=\"close\" data-dismiss=\"alert\" aria-label=\"close\">&times;</a>\r\n");
      out.write("\t\t\t\t\t<strong>Message!</strong>\r\n");
      out.write("\t\t\t\t\t");
      out.print(msg);
      out.write(".\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t");

					}
				
      out.write("\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t");

						List<Configuration> configurations = (List<Configuration>) request.getAttribute("configurations");
						SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy | hh:mm");
						if (configurations==null || configurations.size()==0)
						{
						   
      out.write("\r\n");
      out.write("\t\t\t\t\t\t   \t<h4>No Nodes have been configured yet. You can do it by clicking on 'Add node' below.</h4>\r\n");
      out.write("\t\t\t\t\t\t   \t<br/><br/>\r\n");
      out.write("\t\t\t\t\t\t   \t<a href='#' data-toggle=\"modal\" data-target=\"#addNode\">Add Node</a>\r\n");
      out.write("\t\t\t\t\t\t   \t\r\n");
      out.write("\t\t\t\t\t\t   ");

						}
						else
						{
						   
      out.write("\r\n");
      out.write("\t\t\t\t\t\t   \t\t<a href='#' data-toggle=\"modal\" data-target=\"#addNode\">Add a New Node</a>\r\n");
      out.write("\t\t\t\t\t\t   \t\t<br/><br/>\r\n");
      out.write("\t\t\t\t\t\t   \t\t");

						   			int i=0;
						   			for (Configuration conf: configurations)
						   			{
						   		
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t\t   \t\t<div class='col-md-3' >\r\n");
      out.write("\t\t\t\t\t\t\t\t   \t\t\t<br/>\r\n");
      out.write("\t\t\t\t\t\t\t\t   \t\t\t<ul class=\"list-group\" >\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t  <li class=\"list-group-item\" > <img src='images/node.png' width='70%'/></li>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t  <li class=\"list-group-item\"> <i class=\"menu-icon fa fa-cloud\"></i>&nbsp;");
      out.print( conf.getHost() );
      out.write("</li>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t  <li class=\"list-group-item\"> <i class=\"menu-icon fa fa-plug\"></i>&nbsp;");
      out.print(conf.getPort() );
      out.write("</li>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t  <li class=\"list-group-item\"> <i class=\"menu-icon fa fa-code\"></i>&nbsp;");
      out.print(conf.getContextroot() );
      out.write("</li>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t  <li class=\"list-group-item\"> <i class=\"menu-icon fa fa-user\"></i>&nbsp;");
      out.print(conf.getCreated_by() );
      out.write("</li>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t  <li class=\"list-group-item\"> <i class=\"menu-icon fa fa-clock-o\"></i>&nbsp;");
      out.print(sdf.format(conf.getEntry_time()));
      out.write("</li>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t  <li class=\"list-group-item\"> <a href='#' data-toggle=\"modal\" data-target=\"#editNode");
      out.print(i);
      out.write("\"><i class=\"menu-icon fa fa-pencil-square-o\"></i>&nbsp;Edit</a> &nbsp;&nbsp;&nbsp;&nbsp; | &nbsp;&nbsp;&nbsp;&nbsp;<a href='#' data-toggle=\"modal\" data-target=\"#deleteNode");
      out.print(i);
      out.write("\"><i class=\"menu-icon fa fa-remove\"></i>&nbsp;Delete</a></li>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t</ul>\t\t\t\t\t\t\t\t   \t\t\t\r\n");
      out.write("\t\t\t\t\t\t\t\t   \t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t   \t\t\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<!-- Modal -->\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"modal fade\" id=\"editNode");
      out.print(i );
      out.write("\" tabindex=\"-1\" role=\"dialog\" aria-labelledby=\"myModalLabel\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t  <div class=\"modal-dialog\" role=\"document\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t    <div class=\"modal-content\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t      <div class=\"modal-header\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t        \r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t        <h4 class=\"modal-title\" id=\"myModalLabel\">Update Node</h4>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t      </div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t<form action='configuration' method=\"post\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t<input type=hidden name='requestType' value='update' />\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t      <div class=\"modal-body\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<label>Host Address</label>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<input type=text name='host' value=\"");
      out.print(conf.getHost());
      out.write("\" readonly=\"readonly\" class='form-control' />\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<br/>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<label>Port Number</label>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<input type=text name='port' value=\"");
      out.print(conf.getPort());
      out.write("\" class='form-control' />\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<br/>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<label>Context Root</label>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<input type=text name='context_root' value=\"");
      out.print(conf.getContextroot());
      out.write("\" class='form-control' />\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<br/>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t      </div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t      <div class=\"modal-footer\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t        <button type=\"button\" class=\"btn btn-default\" data-dismiss=\"modal\">Cancel</button>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t        <button type=\"submit\" class=\"btn btn-primary\">Update Node</button>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t      </div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t      </form>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t    </div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t  </div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t</div>\t\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<!-- Modal -->\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"modal fade\" id=\"deleteNode");
      out.print(i );
      out.write("\" tabindex=\"-1\" role=\"dialog\" aria-labelledby=\"myModalLabel\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t  <div class=\"modal-dialog\" role=\"document\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t    <div class=\"modal-content\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t      <div class=\"modal-header\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t        \r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t        <h4 class=\"modal-title\" id=\"myModalLabel\">Delete Node</h4>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t      </div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t<form action='configuration' method=\"post\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t<input type=hidden name='requestType' value='delete' />\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t<input type=hidden name='host' value='");
      out.print(conf.getHost());
      out.write("' />\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t      <div class=\"modal-body\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tAre you sure you want to delete this Node?\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t      </div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t      <div class=\"modal-footer\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t        <button type=\"button\" class=\"btn btn-default\" data-dismiss=\"modal\">Cancel</button>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t        <button type=\"submit\" class=\"btn btn-primary\">Delete Node</button>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t      </div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t      </form>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t    </div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t  </div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t</div>\t\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t");
i++; 
      out.write("\t\t\t\t\t\t\t   \t\t\r\n");
      out.write("\t\t\t\t\t\t   \t\t");
 } 
      out.write("\r\n");
      out.write("\t\t\t\t\t\t   ");
						   
						}
					
      out.write("\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t<!-- Modal -->\r\n");
      out.write("<div class=\"modal fade\" id=\"addNode\" tabindex=\"-1\" role=\"dialog\" aria-labelledby=\"myModalLabel\">\r\n");
      out.write("  <div class=\"modal-dialog\" role=\"document\">\r\n");
      out.write("    <div class=\"modal-content\">\r\n");
      out.write("      <div class=\"modal-header\">\r\n");
      out.write("        \r\n");
      out.write("        <h4 class=\"modal-title\" id=\"myModalLabel\">Add a New Node to the Cluster</h4>\r\n");
      out.write("      </div>\r\n");
      out.write("\t<form action='configuration' method=\"post\">\r\n");
      out.write("\t\t<input type=hidden name='requestType' value='create' />\r\n");
      out.write("      <div class=\"modal-body\">\r\n");
      out.write("\t\t\t<label>Host Address</label>\r\n");
      out.write("\t\t\t<input type=text name='host' placeholder=\"Ex: 192.168.0.1\" class='form-control' />\r\n");
      out.write("\t\t\t<br/>\r\n");
      out.write("\t\t\t<label>Port Number</label>\r\n");
      out.write("\t\t\t<input type=text name='port' placeholder=\"Ex: 8080\" class='form-control' />\r\n");
      out.write("\t\t\t<br/>\r\n");
      out.write("\t\t\t<label>Context Root</label>\r\n");
      out.write("\t\t\t<input type=text name='context_root' placeholder=\"Ex: NodeApp\" class='form-control' />\r\n");
      out.write("\t\t\t<br/>\r\n");
      out.write("      </div>\r\n");
      out.write("      <div class=\"modal-footer\">\r\n");
      out.write("        <button type=\"button\" class=\"btn btn-default\" data-dismiss=\"modal\">Cancel</button>\r\n");
      out.write("        <button type=\"submit\" class=\"btn btn-primary\">Add Node</button>\r\n");
      out.write("      </div>\r\n");
      out.write("      </form>\r\n");
      out.write("    </div>\r\n");
      out.write("  </div>\r\n");
      out.write("</div>\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t<br/><br/><br/><br/>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t<br/><br/><br/>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t<br/><br/><br/>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("           \r\n");
      out.write("        </div> <!-- .content -->\r\n");
      out.write("    </div><!-- /#right-panel -->\r\n");
      out.write("\r\n");
      out.write("    <!-- Right Panel -->\r\n");
      out.write("\r\n");
      out.write("    <script src=\"vendors/jquery/dist/jquery.min.js\"></script>\r\n");
      out.write("    <script src=\"vendors/popper.js/dist/umd/popper.min.js\"></script>\r\n");
      out.write("    <script src=\"vendors/bootstrap/dist/js/bootstrap.min.js\"></script>\r\n");
      out.write("    <script src=\"assets/js/main.js\"></script>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("    <script src=\"vendors/chart.js/dist/Chart.bundle.min.js\"></script>\r\n");
      out.write("    <script src=\"assets/js/dashboard.js\"></script>\r\n");
      out.write("    <script src=\"assets/js/widgets.js\"></script>\r\n");
      out.write("    <script src=\"vendors/jqvmap/dist/jquery.vmap.min.js\"></script>\r\n");
      out.write("    <script src=\"vendors/jqvmap/examples/js/jquery.vmap.sampledata.js\"></script>\r\n");
      out.write("    <script src=\"vendors/jqvmap/dist/maps/jquery.vmap.world.js\"></script>\r\n");
      out.write("    <script>\r\n");
      out.write("        (function($) {\r\n");
      out.write("            \"use strict\";\r\n");
      out.write("\r\n");
      out.write("            jQuery('#vmap').vectorMap({\r\n");
      out.write("                map: 'world_en',\r\n");
      out.write("                backgroundColor: null,\r\n");
      out.write("                color: '#ffffff',\r\n");
      out.write("                hoverOpacity: 0.7,\r\n");
      out.write("                selectedColor: '#1de9b6',\r\n");
      out.write("                enableZoom: true,\r\n");
      out.write("                showTooltip: true,\r\n");
      out.write("                values: sample_data,\r\n");
      out.write("                scaleColors: ['#1de9b6', '#03a9f5'],\r\n");
      out.write("                normalizeFunction: 'polynomial'\r\n");
      out.write("            });\r\n");
      out.write("        })(jQuery);\r\n");
      out.write("    </script>\r\n");
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("\r\n");
      out.write("</html>\r\n");
 } 
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}