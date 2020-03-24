package com.vsstor.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.vsstor.dao.ConfigurationDAO;
import com.vsstor.pojo.Configuration;
import com.vsstor.util.MySQLUtility;

public class ConfigurationDAOImpl implements ConfigurationDAO
{

   @Override
   public void create(Configuration conf) throws Exception
   {
      Connection con = null;
      try
      {
         con = MySQLUtility.connect();
         PreparedStatement ps = con.prepareStatement("insert into configuration values (?,?,?,?,?)");
         ps.setString(1, conf.getHost());
         ps.setString(2, conf.getPort());
         ps.setString(3, conf.getContextroot());
         ps.setString(4, conf.getCreated_by());
         ps.setTimestamp(5, conf.getEntry_time());
         ps.execute();

      }
      catch (Exception e)
      {
         e.printStackTrace();
         throw e;
      }
      finally
      {
         con.close();
      }
   }

   @Override
   public void delete(String host) throws Exception
   {
      Connection con = null;
      try
      {
         con = MySQLUtility.connect();
         con.createStatement().execute("delete from configuration where host='" + host + "' ");
      }
      catch (Exception e)
      {
         e.printStackTrace();
         throw e;
      }
      finally
      {
         con.close();
      }
   }

   @Override
   public List<Configuration> getAllConfiguration() throws Exception
   {
      Connection con = null;
      List<Configuration> result = new ArrayList<>();
      try
      {
         con = MySQLUtility.connect();
         ResultSet rs = con.createStatement().executeQuery("select * from configuration");
         while (rs.next())
         {
            Configuration conf = new Configuration();
            conf.setContextroot(rs.getString("contextroot"));
            conf.setCreated_by(rs.getString("created_by"));
            conf.setEntry_time(rs.getTimestamp("entry_time"));
            conf.setHost(rs.getString("host"));
            conf.setPort(rs.getString("port"));
            result.add(conf);
         }
      }
      catch (Exception e)
      {
         e.printStackTrace();
         throw e;
      }
      finally
      {
         con.close();
      }

      return result;
   }

   @Override
   public void update(Configuration conf) throws Exception
   {
      Connection con = null;
      try
      {
         con = MySQLUtility.connect();
         PreparedStatement ps = con.prepareStatement("update configuration set port=?, contextroot=? where host=?");
         ps.setString(1, conf.getPort());
         ps.setString(2, conf.getContextroot());
         ps.setString(3, conf.getHost());
         ps.execute();
      }
      catch (Exception e)
      {
         e.printStackTrace();
         throw e;
      }
      finally
      {
         con.close();
      }

   }

}
