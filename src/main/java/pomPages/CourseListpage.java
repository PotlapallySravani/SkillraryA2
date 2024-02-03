package pomPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericUtilities.WebDriverUtility;

public class CourseListpage {

	// Declaration
	@FindBy(xpath = "//h1[normalize-space(text())='Course List']")
	private WebElement pageHeader;

	@FindBy(xpath = "//a[text()=' New']")
	private WebElement newButton;

	private String deletePath="td[text()='+courseName+']/ancestor::tr/descendant::button[text()=' Delete']";

	@FindBy(name = "delete")
	private WebElement deleteButton;

	@FindBy(xpath = "//h4[text()=' Success']")
	private WebElement successMessage;

	// initialization
	public CourseListpage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	// Utilization
	public String getPageHeader() {
		return pageHeader.getText(); 
		
	}
	public void clickNewButton () {
		newButton.click();
	}
	public void deleteCourse(WebDriverUtility web, String CourseName) {
		web.convertpathToWebElement(deletePath, CourseName).click();
		deleteButton.click();
	}
	public String getsuccessMessage () {
		return successMessage.getText();
	}

}
