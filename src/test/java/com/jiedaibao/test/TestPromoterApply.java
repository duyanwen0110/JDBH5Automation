package com.jiedaibao.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Navigation;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.jiedaibao.beans.OpromoterBean;
import com.jiedaibao.pageobjects.CommonHeaderPage;
import com.jiedaibao.pageobjects.OpromoterApplyPage;

public class TestPromoterApply {
	WebDriver driver;
	CommonHeaderPage commonHeaderPage;
	OpromoterBean opromoterBean;
	OpromoterApplyPage opromoterApplyPage;
	Navigation navigation;
	

	@BeforeMethod
	public void init() {
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		String url = "http://www.jiedaibao.com";
		//driver.get(url);
		navigation = driver.navigate();
		navigation.to(url);
		commonHeaderPage = new CommonHeaderPage(driver);
	}

	//@Test(description = "申请为推广商个人版")
	public void testPersonPromoterApply() throws Exception {
		opromoterBean = new OpromoterBean("tester", "612657189910110389",
				"19100000012", "test@jiedaibao.com", "北京", "沙河", "cooperSource");
		opromoterApplyPage = commonHeaderPage.gotoOpromoterApplyPage();
		opromoterApplyPage.applyForPersonOpromoter(opromoterBean);
		// opromoterApplyPage.clickSubmitButton();
		commonHeaderPage.closeDriver();
	}
	
	//@Test(description = "申请为推广商企业版")
	public void testCompanyPromoterApply() throws Exception {
		opromoterBean = new OpromoterBean("tester", "612657189910110389",
				"19100000012", "test@jiedaibao.com", "北京", "沙河", "cooperSource");
		opromoterApplyPage = commonHeaderPage.gotoOpromoterApplyPage();
		opromoterApplyPage.applyForCompanyOpromoter(opromoterBean);
		// opromoterApplyPage.clickSubmitButton();
		commonHeaderPage.closeDriver();
	}
	
	@Test(description="个人版企业版连接")
	public void testPromoterLink(){
		opromoterApplyPage = commonHeaderPage.gotoOpromoterApplyPage();
		opromoterApplyPage.clickPersonOpromoterLink();
		navigation.back();
		opromoterApplyPage.clickCompanyOpromoterLink();
		commonHeaderPage.closeDriver();
	}
}
