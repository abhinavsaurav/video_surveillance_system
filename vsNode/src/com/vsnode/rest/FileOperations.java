package com.vsnode.rest;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.StreamingOutput;

import org.glassfish.jersey.media.multipart.FormDataContentDisposition;
import org.glassfish.jersey.media.multipart.FormDataParam;

@Path("/operations")
public class FileOperations
{

   @POST
   @Path("/upload")
   @Consumes({ MediaType.MULTIPART_FORM_DATA })
   public void upload(@FormDataParam("file") InputStream fileInputStream,
            @FormDataParam("file") FormDataContentDisposition fileMetaData) throws Exception
   {
      try
      {
         System.out.println("GOT A FILE TO UPLOAD: "+fileMetaData);
         int read = 0;
         byte[] bytes = new byte[1024];

         OutputStream out = new FileOutputStream(
                  new File(Constants.STORAGE_PATH + File.separator + fileMetaData.getFileName()));
         while ((read = fileInputStream.read(bytes)) != -1)
         {
            out.write(bytes, 0, read);
         }
         out.flush();
         out.close();
         
         System.out.println("UPLOAD DONE");
      }
      catch (IOException e)
      {
         throw new WebApplicationException("Error while uploading file. Please try again !!");
      }
      // return Response.ok("Data uploaded successfully !!").build();
   }

   @GET
   @Path("/download")
   public Response download(@QueryParam("filename") String filename)
   {
      StreamingOutput fileStream = new StreamingOutput()
      {
         @Override
         public void write(java.io.OutputStream output) throws IOException, WebApplicationException
         {
            try
            {
               java.nio.file.Path path = Paths.get(Constants.STORAGE_PATH + File.separator + filename);
               byte[] data = Files.readAllBytes(path);
               output.write(data);
               output.flush();
            }
            catch (Exception e)
            {
               throw new WebApplicationException("File Not Found !!");
            }
         }
      };
      return Response.ok(fileStream, MediaType.APPLICATION_OCTET_STREAM)
               .header("content-disposition", "attachment; filename = " + filename).build();
   }

   @GET
   @Path("/listfiles")
   @Produces(MediaType.APPLICATION_JSON)
   public Response listFiles()
   {
      Map<String, String> file_list = new LinkedHashMap<>();
      try
      {
         File path = new File(Constants.STORAGE_PATH);
         for (String f : path.list())
         {
            File file = new File(Constants.STORAGE_PATH + File.separator + f);
            BasicFileAttributes attr = Files.readAttributes(file.toPath(),
                     BasicFileAttributes.class);
            file_list.put(f, String.valueOf(file.length() / 1000) + "<><>" + String.valueOf(attr.creationTime().toMillis()));
         }
      }
      catch (Exception e)
      {
         e.printStackTrace();
      }
      return Response.status(Status.OK).entity(file_list).build();
   }

   @GET
   @Path("/delete")
   public void delete(@QueryParam("filename") String filename)
   {
      try
      {

         File file = new File(Constants.STORAGE_PATH + File.separator + filename);
         if (file.exists() && file.isFile())
         {
            file.delete();

         }
         else
         {

         }
      }
      catch (Exception e)
      {
         e.printStackTrace();
      }

   }
}
