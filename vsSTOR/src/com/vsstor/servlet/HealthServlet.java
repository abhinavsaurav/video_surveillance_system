package com.vsstor.servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.vsstor.apiservice.APIService;
import com.vsstor.dao.ConfigurationDAO;
import com.vsstor.daoimpl.ConfigurationDAOImpl;
import com.vsstor.pojo.Configuration;
import com.vsstor.util.Constants;

public class HealthServlet extends HttpServlet
{

   @Override
   protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
   {
      doPost(req, resp);
   }

   @Override
   protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
   {
      try
      {
         Map<Configuration, String> healthreport = new HashMap<>();
         ConfigurationDAO cDao = new ConfigurationDAOImpl();
         List<Configuration> confs = cDao.getAllConfiguration();
         for (Configuration c : confs)
         {
            try
            {
               APIService.makeCallAndGetResponse("http://" + c.getHost() + ":" + c.getPort() + "/" + c.getContextroot() + Constants.API_HEALTH_CHECK);
               healthreport.put(c, "HEALTHY");
            }
            catch (Exception e)
            {
               healthreport.put(c, "NOTREACHABLE");
            }
         }

         req.setAttribute("healthreport", healthreport);
         req.getRequestDispatcher("healthcheck.jsp").forward(req, resp);
      }
      catch (Exception e)
      {
         e.printStackTrace();
         resp.sendRedirect("error.jsp?msg=Something went wrong: " + e.getMessage());
      }
   }

}