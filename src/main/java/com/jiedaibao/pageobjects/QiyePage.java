package com.jiedaibao.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class QiyePage {

	public QiyePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

}
