package com.vsstor.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.vsstor.service.StreamingService;

public class ControlServlet extends HttpServlet
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
         String req_type = req.getParameter("request_type");
         if (req_type == null)
         {
            resp.sendRedirect("control.jsp?msg=Bad Request");
         }
         else
         {
            if (req_type.equals("set"))
            {
               String splittime = req.getParameter("splittime");
               req.getSession().setAttribute("split", splittime);
               resp.sendRedirect("control.jsp?msg=Split Frequency Set");
            }
            else if (req_type.equals("start"))
            {
               req.getSession().setAttribute("running", "yes");
               StreamingService.run(Integer.parseInt((String) req.getSession().getAttribute("split")));
               resp.sendRedirect("control.jsp?msg=Video Streaming Started");

            }
            else if (req_type.equals("stop"))
            {
               req.getSession().removeAttribute("running");
               StreamingService.stop();
               resp.sendRedirect("control.jsp?msg=Video Streaming Stopped");
            }
         }
      }
      catch (Exception e)
      {
         e.printStackTrace();
         resp.sendRedirect("control.jsp?msg=Something went wrong: " + e.getMessage());
      }
   }

}
