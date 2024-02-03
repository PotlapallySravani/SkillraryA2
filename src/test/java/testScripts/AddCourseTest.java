package testScripts;

import java.util.Map;

import org.testng.annotations.Test;

import pomPages.CourseListpage;

public class AddCourseTest {
	@Test
	public void AddcourseTest() {
		
	
	home.clickCoursesTab();
	home.clickCourseListLink();
	sofa.assertTrue(courseList.getPageHeader(). contains("Course List"));
	
	courseList.clickNewButton();
	sofa.assertTrue(addCourse.getPageHeader(),"Add New Course");
	
	Map<String,String> map =excel.readFromExcel("Add Course");
	addCourse.setName(map.get("Name"));
	addCourse.selectCategory(web,map.get("Category"));
	addCourse.setPrice(map.get("price"));
	addCourse.setDescription(map.get("Description"),web);
	addCourse.clickSave();
	
	soft.assertEquals(CourseListpage.getsuccessMessage(), "Success!");
	//System.out.println(CourseListpage.getsuccessMessage());
	CourseListpage.deleteCourse(web,map.get("Name"));
	soft.assertEquals(CourseListpage.getsuccessMessage(), "Success!");
	//System.out.println(courseList.getsuccessMessage());
	if(courseList.getSuccessMessage().equals("Succes!"))
		excel.updateTestStatus("Add Course", "Pass", ICpnstantPath.EXCEL_PATH);
	else
		excel.updateTestStatus("Add Course", "Fail", ICpnstantPath.EXCEL_PATH);
	soft.asserAll();
		
}

