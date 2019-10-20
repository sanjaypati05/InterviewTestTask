package utility;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UserActions extends BaseClass {

	Utility utility=new Utility();
	int explicitWait=Integer.parseInt(utility.readProperty("explicitWaitTime", "config"));
	// Get text for the web element
	public String getText(WebElement ele) {
		WebDriverWait wait=new WebDriverWait(driver,explicitWait);
		wait.until(ExpectedConditions.elementToBeClickable(ele));
		return ele.getText();
	}

	// Get attribute for the web element
	public String getAttribute(String attribute, WebElement ele) {
		WebDriverWait wait=new WebDriverWait(driver,explicitWait);
		wait.until(ExpectedConditions.elementToBeClickable(ele));
		return ele.getAttribute(attribute);
	}

	// Verify the element is enable and displayed

	public boolean isEnbleAndDisplay(WebElement ele) {
		WebDriverWait wait=new WebDriverWait(driver,explicitWait);
		wait.until(ExpectedConditions.elementToBeClickable(ele));
		boolean status = false;
		try {
			if (ele.isDisplayed() && ele.isEnabled()) {
				status = true;
			}
		} catch (Exception e) {
			System.out.println("Element is not enabled and displayed");
		}

		return status;
	}

	public void actionclick(WebElement ele) {
		WebDriverWait wait=new WebDriverWait(driver,explicitWait);
		wait.until(ExpectedConditions.elementToBeClickable(ele));
		ele.click();
	}

	public void javascriptClick(WebElement ele) {
		WebDriverWait wait=new WebDriverWait(driver,explicitWait);
		wait.until(ExpectedConditions.elementToBeClickable(ele));
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", ele);
	}

	public List<String> getTheListOfStringFromFindElements(String xpath) {
		List<String> list = new ArrayList<String>();
		List<WebElement> we = driver.findElements(By.xpath(xpath));
		for (int i = 0; i < we.size(); i++) {
			list.add(we.get(i).getText());
		}
		return list;
	}

	// Switch to child window

	public void switchToChildWindow() {

		String parentWindow = driver.getWindowHandle();
		for (String s : driver.getWindowHandles()) {
			if (!s.equals(parentWindow)) {
				driver.switchTo().window(s);
			}
		}
	}
}
