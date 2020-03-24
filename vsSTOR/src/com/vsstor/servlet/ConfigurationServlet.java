package com.vsstor.servlet;

import java.io.IOException;
import java.sql.Timestamp;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.vsstor.dao.ConfigurationDAO;
import com.vsstor.daoimpl.ConfigurationDAOImpl;
import com.vsstor.pojo.Configuration;
import com.vsstor.pojo.User;

public class ConfigurationServlet extends HttpServlet
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
      User user = (User) req.getSession().getAttribute("user");
      ConfigurationDAO confDao = new ConfigurationDAOImpl();
      try
      {
         String requestType = req.getParameter("requestType");
         if (requestType == null)
         {
            resp.sendRedirect("error.jsp?msg=Error: Bad Request");
         }
         else
         {
            if (requestType.equals("create"))
            {
               Configuration conf = new Configuration();
               conf.setContextroot(req.getParameter("context_root"));
               conf.setHost(req.getParameter("host"));
               conf.setPort(req.getParameter("port"));
               conf.setCreated_by(user.getEmail());
               conf.setEntry_time(new Timestamp(System.currentTimeMillis()));
               confDao.create(conf);
               resp.sendRedirect("configuration?requestType=get&msg=Added the Node successfully");
            }
            else if (requestType.equals("get"))
            {
               req.setAttribute("configurations", confDao.getAllConfiguration());
               req.getRequestDispatcher("configuration.jsp").forward(req, resp);
            }
            else if (requestType.equals("delete"))
            {
               confDao.delete(req.getParameter("host"));
               resp.sendRedirect("configuration?requestType=get&msg=Deleted the Node successfully");

            }
            else if (requestType.equals("update"))
            {
               Configuration conf = new Configuration();
               conf.setContextroot(req.getParameter("context_root"));
               conf.setPort(req.getParameter("port"));
               conf.setHost(req.getParameter("host"));
               confDao.update(conf);
               resp.sendRedirect("configuration?requestType=get&msg=Updated the Node successfully");
            }

         }
      }
      catch (Exception e)
      {
         resp.sendRedirect("configuration.jsp?msg=Error: "+e.getMessage());
      }
   }

}
