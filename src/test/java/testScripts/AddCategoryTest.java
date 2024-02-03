package testScripts;

import java.util.Locale.Category;
import java.util.Map;

import org.testng.annotations.Test;

import genericUtilities.BaseClass;

public class AddCategoryTest extends BaseClass{
	@Test
	public void addcategoryTest() {
		home.clickCoursesTab();
		home.clickcategoryLink();
		Soft.assertEquals(category.getPageHeader(),"category");
		category.clickNewButton();
		soft.assertEquals (addCategory.getPageHeader(),"category");
		Map<String,String>map  = excel.readFromExcel("Add Category");
		addCategory.setName(map.get("Name"));
		addCategory.clickSave();
		
		System.out.println(Category.getSuccessMessage());
		soft.assertEquals (Category.getSuccessMessage(),"Success");
		category.deleteCategory(web,map.get("Name"));
		soft.assertEquals (Category.getSuccessMessage(),"Success");
		System.out.println(Category.getSuccessMessage());
	}
	

}
