package com.jiedaibao.pageobjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.jiedaibao.utils.Snapshot;
import com.jiedaibao.utils.WaitTool;

public class PcIndexPage {

	@FindBy(css = ".pointContainr>img:last-child")
	private WebElement lastArrowButton;

	@FindBy(css = ".bannerChoice.peopleBanner .downloadNow .innerContainer")
	private WebElement downloadButton;

	@FindBy(css = ".bannerChoice.peopleBanner .innerContainer.videoInner>span")
	private WebElement videoButton;

	@FindBy(css = ".close")
	private WebElement closeButton;

	@FindBy(css = ".pointContainr>img:first-child")
	private WebElement firstArrowButton;

	@FindBy(css = ".active #downloadContainer .innerContainer.videoInner>span")
	private WebElement gotoQiyeButton;

	@FindBy(css = ".downloads .qr-area>.has-tips .custom-button-text")
	private WebElement sweepQRCodeDownloadButton;

	@FindBy(css = ".downloads .buttons-area .download .custom-button-text")
	private WebElement downloadBySystemButton;

	private WebDriver driver;
	private Snapshot snapshot;
	private WaitTool waitTool;
	private Actions action;

	public PcIndexPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
		snapshot = new Snapshot();
		waitTool = new WaitTool();
		waitTool.waitElement(driver, lastArrowButton);
		action = new Actions(driver);
	}

	public void verifyDownloadButton() {
		lastArrowButton.click();
		action.moveToElement(downloadButton).clickAndHold().build().perform();
		snapshot.getSnapshot((TakesScreenshot) driver,
				"verifyDownloadButton.png");
		action.release(downloadButton).build().perform();
	}

	public void verifyVideoButton() {
		action.moveToElement(videoButton).clickAndHold().build().perform();
		action.release(videoButton).build().perform();
		Assert.assertEquals(videoButton.getText().trim(), "观看视频");
		snapshot.getSnapshot((TakesScreenshot) driver, "verifyVideoButton.png");
		closeButton.click();
	}

	public void verifyGotoQiyeButton() {
		firstArrowButton.click();
		snapshot.getSnapshot((TakesScreenshot) driver,
				"verifyGotoQiyeButton.png");
		Assert.assertEquals(gotoQiyeButton.getText().trim(), "前往企业版",
				"前往企业版控件验证成功");
	}

	public void verifySweepQRCodeDownload() {
		((JavascriptExecutor) driver).executeScript(
				"arguments[0].scrollIntoView()", firstArrowButton);
		action.moveToElement(sweepQRCodeDownloadButton).build().perform();
		snapshot.getSnapshot((TakesScreenshot) driver,
				"verifySweepQRCodeDownload.png");
	}

	public void verifyDownloadBySystem() {
		action.moveToElement(downloadBySystemButton).build().perform();
		snapshot.getSnapshot((TakesScreenshot) driver,
				"verifyDownloadBySystem.png");
	}

}
