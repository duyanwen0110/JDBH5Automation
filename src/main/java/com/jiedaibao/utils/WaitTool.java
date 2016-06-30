package com.jiedaibao.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitTool {
	public Boolean waitElement(final WebDriver driver, final WebElement element) {
		return new WebDriverWait(driver, 90).until(new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver driver) {
				try {
					return element.isDisplayed();
				} catch (Exception e) {
					e.printStackTrace();
				}
				return false;
			}
		});
	}
}
