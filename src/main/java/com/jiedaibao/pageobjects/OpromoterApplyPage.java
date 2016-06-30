package com.jiedaibao.pageobjects;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.jiedaibao.beans.OpromoterBean;
import com.jiedaibao.utils.Snapshot;
import com.jiedaibao.utils.WaitTool;

public class OpromoterApplyPage {
	@FindBy(css="#check i[id='0']")
	private WebElement personRadioButton;
	
	@FindBy(css="#check i[id='1']")
	private WebElement companyRadioButton;
	
	@FindBy(css="#promoterName")
	private WebElement promoterNameTextFiled;
	
	@FindBy(css="#IdCardNo")
	private WebElement IdCardNoTextFiled;
	
	@FindBy(css="#telePhoneNo")
	private WebElement telePhoneNoTextFiled;
	
	@FindBy(css="#email")
	private WebElement emailTextFiled;
	
	//@FindBy(xpath="//input[@id='province']/parent::div")
	@FindBy(css = "#province")
	private WebElement provinceTextFiled;
	
	@FindBy(css=".provinceContainer:not([style*='display: none']) .provinceA")
	private List<WebElement> provinceSelectList;
	
	@FindBy(css="#city")
	private WebElement cityTextFiled;
	
	@FindBy(css="#cooperSource")
	private WebElement cooperSourceTextFiled;
	
	@FindBy(css=".submit")
	private WebElement submitButton;
	
	@FindBy(css="a[href*='person']")
	private WebElement personOpromoterLink;
	
	@FindBy(css="a[href*='company']")
	private WebElement companyOpromoterLink;
	
	@FindBy(css="#typeText")
	private WebElement typeTextLabel;
	
	@FindBy(css=".blue_toast")
	private WebElement sucessToastLabel;
	
	private WebDriver driver;
	private WaitTool waitTool;
	
	public OpromoterApplyPage(WebDriver driver){
		PageFactory.initElements(driver, this);
		this.driver = driver;
		waitTool = new WaitTool();
		waitTool.waitElement(driver, submitButton);
	}
	
	public void applyForPersonOpromoter(OpromoterBean opromoter)throws Exception{
		personRadioButton.click();
		fillOpromoterInformation(opromoter);
		Snapshot.createScreenshots(driver);
	}
	
	
	public void applyForCompanyOpromoter(OpromoterBean opromoter)throws Exception{
		companyRadioButton.click();
		fillOpromoterInformation(opromoter);
		Thread.sleep(1000);
		Snapshot.createScreenshots(driver);
	}
	
    public void fillOpromoterInformation(OpromoterBean opromoter) throws Exception{
    	if(!opromoter.getPromoterName().equals("") || opromoter.getPromoterName()!=null){
    		promoterNameTextFiled.sendKeys(opromoter.getPromoterName());
    	}
    	if(!opromoter.getIdCardNo().equals("") || opromoter.getIdCardNo()!=null){
    		IdCardNoTextFiled.sendKeys(opromoter.getIdCardNo());
    	}
    	if(!opromoter.getTelePhoneNo().equals("") || opromoter.getTelePhoneNo()!=null){
    		telePhoneNoTextFiled.sendKeys(opromoter.getTelePhoneNo());
    	}
    	if(!opromoter.getEmail().equals("") || opromoter.getEmail()!=null){
    		emailTextFiled.sendKeys(opromoter.getEmail());
    	}
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView()", emailTextFiled);
    	if(!opromoter.getProvince().equals("") || opromoter.getProvince()!=null){
    		selectProvinceByLabel(opromoter.getProvince());
    	}
    	if(!opromoter.getCity().equals("") || opromoter.getCity()!=null){
    		cityTextFiled.sendKeys(opromoter.getCity());
    	}
    	if(!opromoter.getCooperSource().equals("") || opromoter.getCooperSource()!=null){
    		cooperSourceTextFiled.sendKeys(opromoter.getCooperSource());
    	}
	}
	
    public void selectProvinceByLabel(String option) throws Exception{
    	provinceTextFiled.click();
    	waitTool.waitElement(driver, provinceSelectList.get(0));
    	for (WebElement optionElement : provinceSelectList) {
            if (optionElement.getText().trim().equals(option)) {
                optionElement.click();
                return;
            }
        }
    	throw new Exception("The expected option is not listed in select list options");
    }
    
	public void clickSubmitButton() throws InterruptedException{
		submitButton.click();
		//Thread.sleep(3000);
		waitTool.waitElement(driver, sucessToastLabel);
		Snapshot.createScreenshots(driver);
	}
	
	public void clickPersonOpromoterLink(){
		personOpromoterLink.click();
		waitTool.waitElement(driver, typeTextLabel);
		Snapshot.createScreenshots(driver);
	}
	
	public void clickCompanyOpromoterLink(){
		companyOpromoterLink.click();
		waitTool.waitElement(driver, typeTextLabel);
		Snapshot.createScreenshots(driver);
	}
}
