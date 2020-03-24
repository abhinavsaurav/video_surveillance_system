package com.vsstor.servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
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

public class ReportServlet extends HttpServlet
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
      String total_nodes_configured;
      String total_healthy_nodes;
      String cumulative_total_space;
      String cumulative_space_occupied;
      String total_files;

      Map<String, String> cumulative_report = new LinkedHashMap<>();

      Map<Configuration, Map<String, String>> nodes_report = new LinkedHashMap<>();

      try
      {
         ConfigurationDAO confDao = new ConfigurationDAOImpl();
         List<Configuration> configurations = confDao.getAllConfiguration();

         cumulative_report.put("Total Nodes Configured", String.valueOf(configurations.size()));
         int healthy = 0;
         double total_space_available = 0;
         double total_sapce_occupied = 0;
         for (Configuration conf : configurations)
         {
            Map<String, String> report = new LinkedHashMap<String, String>();
            try
            {
               String host = conf.getHost();
               String port = conf.getPort();
               String context_root = conf.getContextroot();

               String output = APIService.makeCallAndGetResponse("http://" + host + ":" + port + "/" + context_root + Constants.API_SPACE_AVAILABLE);
               double total = Double.parseDouble(output);
               total_space_available += total;
               report.put("Maximum Space", String.valueOf(total / 1000000000) + " GB");

               String output2 = APIService.makeCallAndGetResponse("http://" + host + ":" + port + "/" + context_root + Constants.API_SPACE_CONSUMED);
               Map<String, String> json = APIService.jsonToMap(output2);
               Iterator<String> it = json.keySet().iterator();
               double used = 0;
               while (it.hasNext())
               {
                  used += Double.parseDouble(json.get(it.next()));
               }
               
               total_sapce_occupied += used;
               report.put("Space Used", String.valueOf(used / 1) + " KB");

               report.put("Free Space", String.valueOf((total - used) / 1000000000) + " GB");

               String output3 = APIService.makeCallAndGetResponse("http://" + host + ":" + port + "/" + context_root + Constants.API_LIST_FILES);
               Map<String, String> map = APIService.jsonToMap(output3);
               report.put("Total Files on this Node", String.valueOf(map.size()));

               healthy++;
            }
            catch (Exception e)
            {
               e.printStackTrace();
            }
            nodes_report.put(conf, report);
         }

         cumulative_report.put("Total Healthy nodes", String.valueOf(healthy));
         cumulative_report.put("Total Broken Nodes", String.valueOf(configurations.size() - healthy));
         cumulative_report.put("Cumulative Maximum Space ", String.valueOf(total_space_available / 1000000000) + " GB");
         cumulative_report.put("Cumulative Space Used ", String.valueOf(total_sapce_occupied / 1) + " KB");
         cumulative_report.put("Cumulative Free Space ", String.valueOf((total_space_available - total_sapce_occupied) / 1000000000) + " GB");

         req.setAttribute("cumulative_report", cumulative_report);
         req.setAttribute("nodes_report", nodes_report);
         req.getRequestDispatcher("report.jsp").forward(req, resp);

      }
      catch (Exception e)
      {
         e.printStackTrace();
         resp.sendRedirect("error.jsp?msg=Error: " + e.getMessage());
      }
   }

}
