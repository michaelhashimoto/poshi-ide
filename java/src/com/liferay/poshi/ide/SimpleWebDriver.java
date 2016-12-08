package com.liferay.poshi.ide;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SimpleWebDriver {

	public static void toggle(String xpath) {
		start(xpath);
	}

	public static void start(String xpath) {
		System.out.println("Starting WebDriver...");

		System.setProperty("webdriver.gecko.driver","/opt/dev/projects/github/poshi-ide/dependencies/geckodriver");

		if (_webDriver == null) {
			_webDriver = new FirefoxDriver();

			String baseUrl = "http://www.liferay.com/";

			_webDriver.get(baseUrl);
		}

		try {
			_webDriver.findElement(By.xpath(xpath));
		}
		catch (Exception e) {
			_webDriver = new FirefoxDriver();

			String baseUrl = "http://www.liferay.com/";

			_webDriver.get(baseUrl);
		}

		WebElement element = _webDriver.findElement(By.xpath(xpath));

		//element.click();

		JavascriptExecutor js=(JavascriptExecutor)_webDriver;

		// call the executeScript methodJavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].style.border='2px groove green'", element);

		try {
			Thread.sleep(1000);
		}
		catch (Exception e) {
		}

		js.executeScript("arguments[0].style.border=''", element);
	}

	public static void stop() {
		System.out.println("Stopping WebDriver...");

		_webDriver.quit();

		_webDriver = null;
	}

	private static boolean _started = false;
	private static WebDriver _webDriver;

}