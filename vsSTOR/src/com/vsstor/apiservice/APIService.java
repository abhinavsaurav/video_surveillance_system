package com.vsstor.apiservice;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.json.JSONException;
import org.json.JSONObject;

public class APIService
{

   public static String makeCallAndGetResponse(String str) throws Exception

   {
      URL url = new URL(str);

      HttpURLConnection conn = (HttpURLConnection) url.openConnection();
      conn.setRequestMethod("GET");
      conn.setRequestProperty("Accept", "application/json");

      if (conn.getResponseCode() != 200)
      {
         throw new RuntimeException("Failed : HTTP error code : "
                  + conn.getResponseCode());
      }

      BufferedReader br = new BufferedReader(new InputStreamReader(
               (conn.getInputStream())));

      String output = "";
      String line = "";
      while ((line = br.readLine()) != null)
      {
         output += line;
      }

      conn.disconnect();
      return output;
   }

   public static Map<String, String> jsonToMap(String t) throws JSONException
   {

      HashMap<String, String> map = new HashMap<String, String>();
      JSONObject jObject = new JSONObject(t);
      Iterator<?> keys = jObject.keys();

      while (keys.hasNext())
      {
         String key = (String) keys.next();
         String value = jObject.getString(key);
         map.put(key, value);

      }
      return map;
   }

}
