package com.jiedaibao.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.jiedaibao.utils.WaitTool;


public class CommonHeaderPage{
	@FindBy(css = "#common-header a[href*='pcIndex']")
	private WebElement pcIndexLink;
	
	@FindBy(css = "#common-header a[href*='qiye']")
	private WebElement qiyeLink;
	
	@FindBy(css = "#common-header a[href*='chongzhi']")
	private WebElement chongzhiLink;
	
	@FindBy(css = "#common-header a[href*='functionDetail']")
	private WebElement functionDetailLink;
	
	@FindBy(css = "#common-header a[href*='pcNewsList']")
	private WebElement pcNewsListLink;
	
	@FindBy(css = "#common-header a[href*='promoterApply']")
	private WebElement promoterApplyLink;
	
	@FindBy(css = "#common-header a[href*='pcAbout']")
	private WebElement pcAboutLink;
	
	private WebDriver driver;
	private WaitTool waitTool;
	
	public CommonHeaderPage(WebDriver driver){
		PageFactory.initElements(driver, this);
		this.driver =  driver;
		waitTool = new WaitTool();
		waitTool.waitElement(driver, promoterApplyLink);
	}
	
	public PcIndexPage gotoPcIndexPage(){
		pcIndexLink.click();
		return new PcIndexPage(driver);
	}
	
	public QiyePage gotoQiyePage(){
		qiyeLink.click();
		return new QiyePage(driver);
	}
	
	public OpromoterApplyPage gotoOpromoterApplyPage(){
		promoterApplyLink.click();
		return new OpromoterApplyPage(driver);
	}
	
	public void closeDriver(){
		driver.close();
	}
	
}
