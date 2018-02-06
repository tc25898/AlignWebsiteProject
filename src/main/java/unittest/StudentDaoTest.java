package unittest;

import org.junit.Test;
import org.mehaexample.asdDemo.dao.StudentDao;

import junit.framework.Assert;

public class StudentDaoTest {
	
	@Test
	public void testIfEmptyNuidExists() {
		System.out.println("hello test");
		StudentDao studentDao = new StudentDao();
		
		boolean exists = studentDao.ifNuidExists("");
		Assert.assertFalse(exists);
	}
	
	@Test
	public void testIfNullNuidExists() {
		
	}
	
	@Test
	public void testIfNullStudentCanBeInserted() {
		
	}
	
	@Test
	public void testIfNonExistingStudentCanBeDeleted() {
		
	}
}
