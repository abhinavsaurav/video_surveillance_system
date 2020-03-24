package com.vsstor.service;

import com.vsstor.util.Constants;

public class StreamingService
{

   public static void run(int splittime)
   {

      try
      {
         new StreamingCaptureThread(Constants.TEMPORARY_LOC, Constants.VIDEO_FILE_NAME, splittime);
      }
      catch (Exception e)
      {
         e.printStackTrace();
      }
   }

   public static void stop()
   {
      StreamingCaptureThread.continueRunning = false;
   }
}
