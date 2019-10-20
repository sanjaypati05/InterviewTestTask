package pageObject.challengingDOM;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import utility.BaseClass;
import utility.UserActions;

public class ChallengingDOMPage extends BaseClass {
	UserActions actions = new UserActions();

	public ChallengingDOMPage() {
		PageFactory.initElements(driver, this);

	}

	@FindBy(how = How.TAG_NAME, using = "h3")
	private WebElement headerChllengingDOM;

	// Get the header text

	public String getHeaderOfThePage() {
		return actions.getText(headerChllengingDOM);
	}

	@FindBy(how = How.TAG_NAME, using = "p")
	private WebElement paragraphChllengingDOM;

	// Get the paragraph text

	public String getParagraphOfThePage() {
		return actions.getText(paragraphChllengingDOM);
	}

	@FindBy(how = How.XPATH, using = "//img[@alt='Fork me on GitHub']")
	private WebElement imageGitHub;

	// Get the attribute to verify the GitHUB text

	public String getGITImageText() {
		return actions.getAttribute("alt", imageGitHub);
	}

	@FindBy(how = How.XPATH, using = "//a[@href='https://github.com/tourdedave/the-internet']")
	private WebElement linkGitHub;

	// Verify the GitHub Link Present

	public boolean verifyGitHubLinkIsDispalyAndEnable() {
		return actions.isEnbleAndDisplay(linkGitHub);
	}

	public String clickOnGitHubAndVerifyTheBaseURL() {
		actions.javascriptClick(linkGitHub);
		return driver.getCurrentUrl();
	}

	@FindBy(how = How.CLASS_NAME, using = "button")
	private WebElement linkButton;

	@FindBy(how = How.XPATH, using = "//a[@class='button alert']")
	private WebElement linkButtonAlert;

	@FindBy(how = How.XPATH, using = "//a[@class='button success']")
	private WebElement linkButtonSuccess;

	public boolean verifyButtonsIsEnabledAndDisplay() {
		return actions.isEnbleAndDisplay(linkButton);
	}

	public boolean verifyAlertButtonsIsEnabledAndDisplay() {
		return actions.isEnbleAndDisplay(linkButtonAlert);
	}

	public boolean verifyButtonSuccessIsEnabledAndDisplay() {
		return actions.isEnbleAndDisplay(linkButtonSuccess);
	}

	public String verifyButtonColor() {
		return linkButton.getCssValue("background-color");
	}

	public String verifyAlertButtonColor() {
		return linkButtonAlert.getCssValue("background-color");
	}

	public String verifySuccessButtonColor() {
		return linkButtonSuccess.getCssValue("background-color");
	}

	// Get the list of header

	@FindBy(how = How.XPATH, using = "//table//th")
	private List<WebElement> tableHeader;

	public List<String> getTheTableHeader() {
		List<String> headerList = new ArrayList<String>();

		for (WebElement ele : tableHeader) {
			headerList.add(ele.getText());
		}
		return headerList;
	}

	@FindBy(how = How.XPATH, using = "//table//tbody//tr//td[1]")
	private List<WebElement> numberOfColumn;

	public ArrayList<List<String>> getTheEachColumnData() {
		ArrayList<List<String>> eachColumnData = new ArrayList<List<String>>();

		// Loop for the number of column
		for (int i = 1; i < tableHeader.size(); i++) {
			String xpath = "//table//tbody//tr//td[" + i + "]";
			eachColumnData.add(actions.getTheListOfStringFromFindElements(xpath));

		}
		return eachColumnData;
	}

	@FindBy(how = How.XPATH, using = "//table//tbody//tr")
	private List<WebElement> numberOfRow;

	public List<WebElement> getNumberOfRows() {
		return numberOfRow;
	}

	@FindBy(how = How.XPATH, using = "//div[@id='page-footer']//div[contains(@style,'text-align')]")
	private WebElement pageFooter;

	public String getFooterText() {
		return pageFooter.getText();
	}

	@FindBy(how = How.LINK_TEXT, using = "Elemental Selenium")
	private WebElement linkElementalSelenium;

	public void clickfooterLinkAndVerifyTheLink() {
		actions.actionclick(linkElementalSelenium);
	}

	@FindBy(how = How.ID, using = "canvas")
	private WebElement canvasID;

	@FindBy(how = How.XPATH, using = "(//script)[last()]")
	private WebElement canvasScript;

	public boolean verifytheAnswerBlockisDisplay() {
		return actions.isEnbleAndDisplay(canvasID);
	}
}
