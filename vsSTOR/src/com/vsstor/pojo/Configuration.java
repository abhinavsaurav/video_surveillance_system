package com.vsstor.pojo;

import java.sql.Timestamp;

public class Configuration
{

   String host;
   String port;
   String contextroot;
   String created_by;
   Timestamp entry_time;

   public String getHost()
   {
      return host;
   }

   public void setHost(String host)
   {
      this.host = host;
   }

   public String getPort()
   {
      return port;
   }

   public void setPort(String port)
   {
      this.port = port;
   }

   public String getContextroot()
   {
      return contextroot;
   }

   public void setContextroot(String contextroot)
   {
      this.contextroot = contextroot;
   }

   public String getCreated_by()
   {
      return created_by;
   }

   public void setCreated_by(String created_by)
   {
      this.created_by = created_by;
   }

   public Timestamp getEntry_time()
   {
      return entry_time;
   }

   public void setEntry_time(Timestamp entry_time)
   {
      this.entry_time = entry_time;
   }

}
