package com.jiedaibao.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitTool {
     public void waitElement(final WebDriver driver,final WebElement element){
    	WebDriverWait wait = new WebDriverWait(driver, 30);
 		wait.until(new ExpectedCondition<WebElement>() {
 			public WebElement apply(WebDriver d){
 		        return element; 
 			}
 		});
     }
}
