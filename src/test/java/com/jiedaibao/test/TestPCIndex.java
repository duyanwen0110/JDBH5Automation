package com.jiedaibao.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.jiedaibao.pageobjects.CommonHeaderPage;
import com.jiedaibao.pageobjects.PcIndexPage;

public class TestPCIndex {
	WebDriver driver;
	CommonHeaderPage commonHeaderPage;

	@BeforeMethod
	public void beforMethod() {
//		System.setProperty("webdriver.firefox.bin",
//				"D:/work/programFiles/firefox/firefox.exe");
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		String url = "http://www.jiedaibao.com";
		driver.get(url);
		commonHeaderPage = new CommonHeaderPage(driver);
	}
	

	@Test(description="立刻下载、观看视频、前往企业版")
	public void testDownload(){
		PcIndexPage pcIndexPage = commonHeaderPage.gotoPcIndexPage();
		pcIndexPage.verifyDownloadButton();
		pcIndexPage.verifyVideoButton();
		pcIndexPage.verifyGotoQiyeButton();
	}
	
	@Test(description="首页的功能介绍验证")
	public void testFunction() {
		PcIndexPage pcIndexPage = commonHeaderPage.gotoPcIndexPage();
		pcIndexPage.verifySweepQRCodeDownload();
		pcIndexPage.verifyDownloadBySystem();
	}
	
	@AfterMethod
	public void afterMethod(){
		commonHeaderPage.closeDriver();
	}
}
