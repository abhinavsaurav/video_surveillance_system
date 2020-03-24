package com.vsstor.dao;

import java.util.List;

import com.vsstor.pojo.Configuration;

public interface ConfigurationDAO
{

   public void create(Configuration conf) throws Exception;

   public void delete(String host) throws Exception;

   public List<Configuration> getAllConfiguration() throws Exception;

   public void update(Configuration conf) throws Exception;
}
