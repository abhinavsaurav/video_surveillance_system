package com.vsstor.service;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import com.vsstor.apiservice.APIService;
import com.vsstor.dao.ConfigurationDAO;
import com.vsstor.daoimpl.ConfigurationDAOImpl;
import com.vsstor.pojo.Configuration;
import com.vsstor.util.Constants;

public class StreamingUploadThread implements Runnable
{

   String file;

   public StreamingUploadThread(String file)
   {
      this.file = file;
      Thread t = new Thread(this);
      t.start();
   }

   @Override
   public void run()
   {
      
      System.out.println("Starting upload of "+file);
      try
      {
         ConfigurationDAO confDao = new ConfigurationDAOImpl();
         List<Configuration> configurations = confDao.getAllConfiguration();
         Configuration target = null;
         double available_space_max = 0;
         for (Configuration conf : configurations)
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

         
         URL serverUrl = new URL("http://" + target.getHost() + ":" + target.getPort() + "/" + target.getContextroot() + Constants.API_FILE_UPLOAD);
         HttpURLConnection urlConnection = (HttpURLConnection) serverUrl.openConnection();
         System.out.println("Target: "+serverUrl.toString());
         
         String boundaryString = "----SomeRandomText";
         File fileToUpload = new File(file);
         
         System.out.println("FILE: "+file);

         // Indicate that we want to write to the HTTP request body
         urlConnection.setDoOutput(true);
         urlConnection.setRequestMethod("POST");
         urlConnection.addRequestProperty("Content-Type", "multipart/form-data; boundary=" + boundaryString);

         OutputStream outputStreamToRequestBody = urlConnection.getOutputStream();
         BufferedWriter httpRequestBodyWriter = new BufferedWriter(new OutputStreamWriter(outputStreamToRequestBody));

         // Include value from the myFileDescription text area in the post data
         httpRequestBodyWriter.write("\n\n--" + boundaryString + "\n");
         httpRequestBodyWriter.write("Content-Disposition: form-data; name=\"myFileDescription\"");
         httpRequestBodyWriter.write("\n\n");
         httpRequestBodyWriter.write("Video Stream");

         // Include the section to describe the file
         httpRequestBodyWriter.write("\n--" + boundaryString + "\n");
         httpRequestBodyWriter.write("Content-Disposition: form-data;"
                  + "name=\"file\";"
                  + "filename=\"" + fileToUpload.getName() + "\""
                  + "\nContent-Type: text/plain\n\n");
         httpRequestBodyWriter.flush();

         // Write the actual file contents
         FileInputStream inputStreamToFile = new FileInputStream(fileToUpload);

         int bytesRead;
         byte[] dataBuffer = new byte[1024];
         while ((bytesRead = inputStreamToFile.read(dataBuffer)) != -1)
         {
            outputStreamToRequestBody.write(dataBuffer, 0, bytesRead);
         }

         outputStreamToRequestBody.flush();

         // Mark the end of the multipart http request
         httpRequestBodyWriter.write("\n--" + boundaryString + "--\n");
         httpRequestBodyWriter.flush();

         // Close the streams
         outputStreamToRequestBody.close();
         httpRequestBodyWriter.close();

      // Read response from web server, which will trigger the multipart HTTP request to be sent.
         BufferedReader httpResponseReader =
             new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
         String lineRead;
         while((lineRead = httpResponseReader.readLine()) != null) {
             System.out.println(lineRead);
         }
         System.out.println("Upload of " + file + " is DONE to " + target.getHost());

         inputStreamToFile.close();
         fileToUpload.delete();
      }
      catch (Exception e)
      {
         e.printStackTrace();
      }

   }

}
