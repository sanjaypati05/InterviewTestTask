package pageObject.elementalSelenium;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import utility.BaseClass;
import utility.UserActions;

public class ElementalSelenium extends BaseClass {

	UserActions actions = new UserActions();

	public ElementalSelenium() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(how = How.TAG_NAME, using = "h1")
	private WebElement textElementalSelenium;

	public String getHeadear() {
		return textElementalSelenium.getText();
	}

	public String getBaseURL() {
		return driver.getCurrentUrl();
	}
}
