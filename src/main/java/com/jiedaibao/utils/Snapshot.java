package com.jiedaibao.utils;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.Augmenter;
import org.openqa.selenium.remote.RemoteWebDriver;

public class Snapshot {
	public static void createScreenshots(final WebDriver driver) {
		final String fileName = String.valueOf(System.currentTimeMillis())
				.substring(5);
		try {
			File scrFile;

			if (driver.getClass().equals(RemoteWebDriver.class)) {
				scrFile = ((TakesScreenshot) new Augmenter().augment(driver))
						.getScreenshotAs(OutputType.FILE);
			} else {
				scrFile = ((TakesScreenshot) driver)
						.getScreenshotAs(OutputType.FILE);
			}

			final File saved = new File("resources/", fileName + ".png");
			FileUtils.copyFile(scrFile, saved);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void getSnapshot(TakesScreenshot drivername, String filename) {
		File scrFile = drivername.getScreenshotAs(OutputType.FILE);
		try {
			System.out.println("save snapshot path is:D:/" + filename);
			FileUtils.copyFile(scrFile, new File(
					"D:\\work\\H5Automation\\JDBH5Automation\\test-output\\screenshots\\"
							+ filename));
		} catch (IOException e) {
			System.out.println("Can't save screenshot");
			e.printStackTrace();
		} finally {
			System.out.println("screen shot finished");
		}
	}
}
