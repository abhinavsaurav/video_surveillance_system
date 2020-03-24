package com.vsstor.servlet;

import java.io.IOException;
import java.util.LinkedHashMap;
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

public class ProcessServlet extends HttpServlet
{
   private static final long serialVersionUID = 1L;

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
         ConfigurationDAO confDao = new ConfigurationDAOImpl();
         List<Configuration> configurations = confDao.getAllConfiguration();
         Map<Configuration, Map<String, String>> result = new LinkedHashMap<>();
         for (Configuration conf : configurations)
         {
            try
            {
               String url = "http://" + conf.getHost() + ":" + conf.getPort() + "/" + conf.getContextroot() + Constants.API_LIST_FILES;
               String response = APIService.makeCallAndGetResponse(url);
               Map<String, String> file_list = APIService.jsonToMap(response);
               result.put(conf, file_list);

            }
            catch (Exception e)
            {
               // IGNORE: The Node may not be reachable
               e.printStackTrace();
            }
         }
         req.setAttribute("result", result);
         req.getRequestDispatcher("process.jsp").forward(req, resp);
      }
      catch (Exception e)
      {
         e.printStackTrace();
         resp.sendRedirect("error.jsp?msg=Error: " + e.getMessage());
      }
   }

}
