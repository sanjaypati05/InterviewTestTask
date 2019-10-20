package com.test.challengingDOM;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import pageObject.challengingDOM.ChallengingDOMPage;
import pageObject.elementalSelenium.ElementalSelenium;
import utility.BaseClass;
import utility.UserActions;
import utility.Utility;

public class ChallengingDOM extends BaseClass {

	Utility ut = new Utility();
	UserActions actions = new UserActions();

	@Test(description = "Verify the header and paragraph for the page")
	public void testToVerifyTheHeaderAndParagraph() {

		ChallengingDOMPage challengingDOMPage = new ChallengingDOMPage();
		Assert.assertEquals(challengingDOMPage.getHeaderOfThePage(), ut.readProperty("headerText", "testdata"));
		Assert.assertEquals(challengingDOMPage.getParagraphOfThePage(), ut.readProperty("paragraph", "testdata"));
		Reporter.log("Test case to verify the header and paragraph for the page is pass");

	}

	@Test(description = "Verify the text and hyperlink of the GIT Hub")
	public void testToVerifyTheTextAndHyperlinkOfTheGITHub() {
		ChallengingDOMPage challengingDOMPage = new ChallengingDOMPage();
		Assert.assertEquals(challengingDOMPage.verifyGitHubLinkIsDispalyAndEnable(), true);
		Assert.assertEquals(challengingDOMPage.getGITImageText(), "Fork me on GitHub");
		Assert.assertEquals(challengingDOMPage.clickOnGitHubAndVerifyTheBaseURL(),
				"https://github.com/tourdedave/the-internet");
		driver.navigate().back();
	}

	@Test(description = "Verify the buttons- display ,enable ,color")

	public void verifyTheButtons() {
		ChallengingDOMPage challengingDOMPage = new ChallengingDOMPage();

		Assert.assertEquals(challengingDOMPage.verifyButtonsIsEnabledAndDisplay(), true);
		Assert.assertEquals(challengingDOMPage.verifyAlertButtonsIsEnabledAndDisplay(), true);
		Assert.assertEquals(challengingDOMPage.verifyButtonSuccessIsEnabledAndDisplay(), true);

		System.out.println(challengingDOMPage.verifyButtonColor());
		System.out.println(ut.readProperty("buttonColor", "testdata"));
		Assert.assertEquals(challengingDOMPage.verifyButtonColor(), ut.readProperty("buttonColor", "testdata"));

		System.out.println(challengingDOMPage.verifyAlertButtonColor());
		System.out.println(ut.readProperty("buttonAlertColor", "testdata"));
		Assert.assertEquals(challengingDOMPage.verifyAlertButtonColor(),
				ut.readProperty("buttonAlertColor", "testdata"));

		System.out.println(challengingDOMPage.verifySuccessButtonColor());
		System.out.println(ut.readProperty("buttonSuccessColor", "testdata"));
		Assert.assertEquals(challengingDOMPage.verifySuccessButtonColor(),
				ut.readProperty("buttonSuccessColor", "testdata"));

		challengingDOMPage.verifyAlertButtonColor();
		challengingDOMPage.verifySuccessButtonColor();
	}

	@Test(description = "verify the table header -name")
	public void verifyTheHeader() {
		ChallengingDOMPage challengingDOMPage = new ChallengingDOMPage();
		String[] expectedHeader = ut.readProperty("tableHeader", "testdata").split(",");
		List<String> actualHeader = challengingDOMPage.getTheTableHeader();
		for (int i = 0; i < expectedHeader.length; i++) {
			Assert.assertEquals(actualHeader.get(i), expectedHeader[i]);
		}
	}

	@Test(description = "verify each column columnsequence")
	public void verifyEachColumnDataSequence() {
		ChallengingDOMPage challengingDOMPage = new ChallengingDOMPage();
		System.out.println(challengingDOMPage.getTheEachColumnData());
		ArrayList<List<String>> columnData = challengingDOMPage.getTheEachColumnData();

		for (int i = 0; i < columnData.size(); i++) {
			for (int j = 0; j < columnData.get(i).size(); j++) {
				System.out.println(columnData.get(i).get(j));
				System.out.println(ut.readProperty("tableColumn" + i, "testdata").split(",")[j]);
				Assert.assertEquals(columnData.get(i).get(j),
						ut.readProperty("tableColumn" + i, "testdata").split(",")[j]);
			}
		}

	}

	@Test(description = "verify end of each row edit button is present")
	public void verifyEditButtonInEachRow() {
		ChallengingDOMPage challengingDOMPage = new ChallengingDOMPage();
		for (int i = 1; i <= challengingDOMPage.getNumberOfRows().size(); i++) {
			String editXpath = "//table//tbody//tr[" + i + "]//td/a[text()='edit']";
			actions.isEnbleAndDisplay(driver.findElement(By.xpath(editXpath)));
		}

	}

	@Test(description = "verify end of each row delete button is present")
	public void verifyDeleteButtonInEachRow() {
		ChallengingDOMPage challengingDOMPage = new ChallengingDOMPage();
		for (int i = 1; i <= challengingDOMPage.getNumberOfRows().size(); i++) {
			String deleteXpath = "//table//tbody//tr[" + i + "]//td/a[text()='delete']";
			actions.isEnbleAndDisplay(driver.findElement(By.xpath(deleteXpath)));
		}

	}

	@Test(description = "Verify the edit click functionality -base url change")
	public void verifyEditButtonClickInEachRow() {
		ChallengingDOMPage challengingDOMPage = new ChallengingDOMPage();
		for (int i = 1; i <= challengingDOMPage.getNumberOfRows().size(); i++) {
			String editXpath = "//table//tbody//tr[" + i + "]//td/a[text()='edit']";
			actions.actionclick(driver.findElement(By.xpath(editXpath)));
			String actualCurrentURL = driver.getCurrentUrl();
			String expectedCurrentURL = ut.readProperty("baseURLAfterEditClick", "testdata");
			Assert.assertEquals(actualCurrentURL, expectedCurrentURL);
			driver.navigate().back();

		}

	}

	@Test(description = "Verify the delete click functionality -base url change")
	public void verifyDeleteButtonClickInEachRow() {
		ChallengingDOMPage challengingDOMPage = new ChallengingDOMPage();
		for (int i = 1; i <= challengingDOMPage.getNumberOfRows().size(); i++) {
			String editXpath = "//table//tbody//tr[" + i + "]//td/a[text()='delete']";
			actions.actionclick(driver.findElement(By.xpath(editXpath)));
			String actualCurrentURL = driver.getCurrentUrl();
			String expectedCurrentURL = ut.readProperty("baseURLAfterDeleteClick", "testdata");
			Assert.assertEquals(actualCurrentURL, expectedCurrentURL);
			driver.navigate().back();

		}
	}

	@Test(description = "Verify the presence of Answer block")
	public void verifyAnswerBlock() {
		ChallengingDOMPage challengingDOMPage = new ChallengingDOMPage();
		Assert.assertEquals(challengingDOMPage.verifytheAnswerBlockisDisplay(), true);

	}

	@Test(description = "Verify the prsence of Footer and it's hyper link")

	public void verifyFooter() {
		ChallengingDOMPage challengingDOMPage = new ChallengingDOMPage();
		ElementalSelenium elementalSelenium = new ElementalSelenium();
		Assert.assertEquals(challengingDOMPage.getFooterText(), ut.readProperty("footerTRext", "testdata"));
		challengingDOMPage.clickfooterLinkAndVerifyTheLink();
		actions.switchToChildWindow();
		System.out.println(elementalSelenium.getBaseURL());
		Assert.assertEquals(elementalSelenium.getBaseURL(), ut.readProperty("baseURL", "testdata"));
		Assert.assertEquals(elementalSelenium.getHeadear(), ut.readProperty("headerTextElementalSelenium", "testdata"));

	}

}