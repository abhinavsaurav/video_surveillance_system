package com.vsnode.rest;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

@Path("/report")
public class ReportOperations
{
   @GET
   @Path("spaceavailable")
   public Response spaceAvailable()
   {
      File storagepath = new File(Constants.STORAGE_PATH);
      return Response.ok(storagepath.getFreeSpace()).build();
   }

   @GET
   @Path("heartbeat")
   public Response heartBeat()
   {
      return Response.ok("Hello").build();
   }

   @GET
   @Path("spaceconsumed")
   @Produces(MediaType.APPLICATION_JSON)
   public Response spaceconsumed()
   {
      Map<String, String> result = new HashMap<>();
      File storagepath = new File(Constants.STORAGE_PATH);
      for (String f : storagepath.list())
      {
         File file = new File(Constants.STORAGE_PATH + File.separator + f);
         result.put(f, String.valueOf(file.length() / 1000));
      }
      return Response.status(Status.OK).entity(result).build();
   }
}
