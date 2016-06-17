package com.jiedaibao.utils;

import java.io.File;
import java.io.IOException;
import org.openqa.selenium.OutputType;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.TakesScreenshot;

public class Snapshot {
	public void getSnapshot(TakesScreenshot drivername, String filename)
	  {
	    File scrFile = drivername.getScreenshotAs(OutputType.FILE);
	        try {
	            System.out.println("save snapshot path is:D:/"+filename);
	            FileUtils.copyFile(scrFile, new File("D:\\work\\H5Automation\\H5Automation\\test-output\\screenshots\\"+filename));
	        } catch (IOException e) {
	            System.out.println("Can't save screenshot");
	            e.printStackTrace();
	        }
	        finally
	        {
	            System.out.println("screen shot finished");
	        }
	  }
}
