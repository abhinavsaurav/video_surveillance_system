/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.2
 * Generated at: 2019-06-10 03:56:11 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class login_jsp extends org.apache.jasper.runtime.HttpJspBase
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
    _jspx_imports_classes = null;
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
      out.write("                <a class=\"navbar-brand\" href=\"./\">VS-STOR</a>\r\n");
      out.write("                <a class=\"navbar-brand hidden\" href=\"./\">V</a>\r\n");
      out.write("            </div>\r\n");
      out.write("\r\n");
      out.write("            <div id=\"main-menu\" class=\"main-menu collapse navbar-collapse\">\r\n");
      out.write("                <ul class=\"nav navbar-nav\">\r\n");
      out.write("                    <li >\r\n");
      out.write("                        <a href=\"index.jsp\"> <i class=\"menu-icon fa fa-info-circle\"></i>About </a>\r\n");
      out.write("                    </li>\r\n");
      out.write("                    <li >\r\n");
      out.write("\t\t\t\t\t\t<h3 class=\"menu-title\">User Operations</h3><!-- /.menu-title -->\r\n");
      out.write("\t\t\t\t\t\t</li>\r\n");
      out.write("                    <li >\r\n");
      out.write("                        <a href=\"register.jsp\"> <i class=\"menu-icon fa fa-user-plus\"></i>Register </a>\r\n");
      out.write("                    </li>\r\n");
      out.write("                    <li class=\"active\">\r\n");
      out.write("                        <a href=\"login.jsp\"> <i class=\"menu-icon fa fa-user\"></i>Login </a>\r\n");
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
      out.write("                        <h1>Existing User Login</h1>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("        <div class=\"content mt-3\">          \r\n");
      out.write("\t  <div class=\"col-sm-6 col-lg-12\" >\r\n");
      out.write("                <div class=\"card\" style='min-height:600px;'>\r\n");
      out.write("                    <div class=\"card-body pb-0\">\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t<h4>Please provide your credentials for logging you in</h4>\r\n");
      out.write("\t\t\t\t\t<hr/>\r\n");
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
      out.write("\t\t\t\t<form method=\"post\" action=\"account\" class='col-md-6'>\r\n");
      out.write("\t\t\t\t\t\t<input type=\"hidden\" name='request_type' value='login' /> <label>Email:</label>\r\n");
      out.write("\t\t\t\t\t\t<input type=\"text\" name=\"email\" class=\"form-control\" /> <br /> <label>Password:</label>\r\n");
      out.write("\t\t\t\t\t\t<input type=\"password\" name=\"password\"\r\n");
      out.write("\t\t\t\t\t\t\tclass=\"validate-email form-control\" /> <br/>\r\n");
      out.write("\t\t\t\t\t\t<button class=\"btn btn-success btn-lg btn-block\" type=\"submit\">Login</button>\r\n");
      out.write("\t\t\t\t</form>\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
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