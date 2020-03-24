package com.vsstor.servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONException;
import org.json.JSONObject;

import com.vsstor.apiservice.APIService;
import com.vsstor.dao.ConfigurationDAO;
import com.vsstor.daoimpl.ConfigurationDAOImpl;
import com.vsstor.pojo.Configuration;
import com.vsstor.util.Constants;

public class UploadServlet extends HttpServlet
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
         Configuration target = null;
         double available_space_max = 0;
         for (Configuration conf : configurations)
         {
            try
            {
               String host = conf.getHost();
               String port = conf.getPort();
               String context_root = conf.getContextroot();

               double space_available = (Double.parseDouble(APIService.makeCallAndGetResponse("http://" + host + ":" + port + "/" + context_root + Constants.API_SPACE_AVAILABLE)))
                        / 1000000000;

               if (available_space_max == 0 || space_available > available_space_max)
               {
                  target = conf;
                  available_space_max = space_available;
               }
            }
            catch (Exception e)
            {
               // IGNORE
            }
         }
         req.setAttribute("target", target);
         req.setAttribute("available_space_max", available_space_max);
         req.getRequestDispatcher("upload.jsp").forward(req, resp);
      }
      catch (Exception e)
      {
         e.printStackTrace();
         resp.sendRedirect("upload.jsp");
      }
   }

}
