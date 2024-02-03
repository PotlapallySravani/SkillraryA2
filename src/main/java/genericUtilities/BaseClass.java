package genericUtilities;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import pomPages.AddCategoryPage;
import pomPages.AddNewCoursePage;
import pomPages.AddNewUserPage;
import pomPages.CategoryPage;
import pomPages.CourseListpage;
import pomPages.Homepage;
import pomPages.Loginpage;
import pomPages.UsersPage;

public class BaseClass {
	 protected WebDriver driver;
	 protected PropertiesUtility property;
	 protected JavaUtility jutil;
	 protected WebDriverUtility web;
	// protected Excelutility excel;
	 
	 protected Loginpage login;
	 protected Homepage home;
	 protected UsersPage users;
	 protected CourseListpage courseList;
	 protected CategoryPage category;
	 protected AddNewUserPage adduser;
	 protected AddNewCoursePage addCourse;
	 protected AddCategoryPage addCategory;
	 
	 public static WebDriver sdriver;
	 public static JavaUtility sjutil;
	 
	//@BeforeSuite
	//@BeforeTest
	@BeforeClass
	public void classSetUp()
	{
		web = new WebDriverUtility();
		jutil=new JavaUtility();
		property=new PropertiesUtility();
		//excel=new ExcelUtility();
		
		property.propertiesInit(IConstantPath.PROPERTIES_FILE_PATH);
		driver = web.launchbrowser(property.readFromProperties("browsers"));
		web.waitTillElementFound(Long.parseLong(property.readFromProperties("timeouts")));
		sdriver=driver;
		sjutil=jutil;
		
		
	}
	@BeforeMethod
	public void methodSetup(){
		login = new Loginpage(driver);
		home = new Homepage(driver);
		users = new UsersPage(driver);
		courseList = new CourseListpage(driver);
		category = new CategoryPage(driver);
		adduser = new AddNewUserPage(driver);
		addCourse= new AddNewCoursePage(driver);
		addCategory= new AddCategoryPage(driver);
		
		excel.excelInit(iconstantpath.EXCEL_PATH,"Sheet1");
		web.navigateToApp(property.readFromProperties("url"));
		Assert.assertEquals(login.getPageHeader(), "Login");
		login.loginToApp(property.readFromProperties("username"),property.readFromProperties("password"));
		Assert.assertEquals(home.getPageHeader(), "Home");
	}
	
	
	
	@AfterTest
	//@AfterSuite
	@AfterMethod
	public void methodTearDown() {
		excel.closeExcel();
		home.signoutOfApplication();
	}

	@AfterClass
	public void classTearDown() {
		web.quitAllWindows();
	}
	// @AfterTest
	// @AfterSuite

}

}

}
