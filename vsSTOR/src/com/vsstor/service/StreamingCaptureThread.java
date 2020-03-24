package com.vsstor.service;

import java.awt.image.BufferedImage;
import java.io.File;

import org.bytedeco.javacpp.avcodec;
import org.bytedeco.javacpp.opencv_core.IplImage;
import org.bytedeco.javacv.FFmpegFrameRecorder;
import org.bytedeco.javacv.FrameRecorder;
import org.bytedeco.javacv.Java2DFrameConverter;
import org.bytedeco.javacv.OpenCVFrameConverter;
import org.bytedeco.javacv.OpenCVFrameConverter.ToIplImage;
import org.bytedeco.javacv.OpenCVFrameGrabber;

public class StreamingCaptureThread implements Runnable
{

   private IplImage snapIm = null;

   boolean run = true;

   ToIplImage iplConverter = new OpenCVFrameConverter.ToIplImage();

   FrameRecorder record;
   FrameRecorder record2;
   
   String filepath;
   String filename;
   int splitTime;

   public static boolean continueRunning = true;

   public StreamingCaptureThread(String filepath, String filename, int splittime) throws Exception
   {
      this.filename = filename;
      this.filepath = filepath;
      this.splitTime = splittime;
      new Thread(this).start();
   }

   IplImage toIplImage(BufferedImage bufImage)
   {

      Java2DFrameConverter java2dConverter = new Java2DFrameConverter();
      IplImage iplImage = iplConverter.convert(java2dConverter.convert(bufImage));
      return iplImage;
   }

   public void run()
   {
      try
      {
         int i=0;
         while (true)
         {

            long millis = System.currentTimeMillis();
            record = new FFmpegFrameRecorder(filepath + File.separator + filename+millis+".avi", 1280, 720);

            record.setVideoOption("tune", "zerolatency");
            record.setVideoOption("preset", "ultrafast");
            record.setVideoOption("crf", "28");
            record.setVideoBitrate(50000);
            record.setVideoCodec(avcodec.AV_CODEC_ID_H264);
            record.setFormat("flv");
            record.setFrameRate(24);
            record.start();


            OpenCVFrameGrabber grabber = new OpenCVFrameGrabber(0);
            OpenCVFrameConverter.ToIplImage converter = new OpenCVFrameConverter.ToIplImage();
            grabber.start();

            long ct = System.currentTimeMillis();
            while (true)
            {
               long ct2 = System.currentTimeMillis();
               if ( (ct2 - ct) > splitTime*1000 )
               {
                  break;
               }
               snapIm = converter.convert(grabber.grab());
               record.record(iplConverter.convert(snapIm));
            }
            try
            {
               System.out.println("Finished a split");
               record.stop();

            }
            catch (Exception e)
            {
               e.printStackTrace();
            }

            grabber.close();
            
            
            new StreamingUploadThread(filepath + File.separator + filename+millis+".avi");
            
            i++;
            if (!continueRunning)
            {
               break;
            }

         }

      }
      catch (Exception e)
      {
         e.printStackTrace();
      }
   }

   public static void main(String arg[]) throws Exception
   {
      System.out.println("Starting");
      new StreamingCaptureThread("C:/temp", "sample", 10);
      Thread.sleep(30000);
      StreamingCaptureThread.continueRunning = false;
      System.out.println("Done");

   }

}