package testScripts;

import java.util.Map;

import org.testng.annotations.Test;

import pomPages.BaseClass;

public class AddUserTest extends BaseClass{
	@Test
	
	public void addUserTest() {
		home.clickUsersTab();
		users.clickNewButton();
		
		Map<String, String>map = excel.readFromExcel("Add User");
		
		adduser.setEmail(map.get("Email"));
		adduser.setPassword(map.get("Password"));
		adduser.setfirstname(map.get("Firstname"));
		adduser.setlastname(map.get("Lastname"));
		adduser.setaddress(map.get("Address"));
		adduser.setContactInfo(map.get("Contact Info"));
		adduser.uploadPhoto(map.get("Photo"));
		
		adduser.clicksave();
	}

}
