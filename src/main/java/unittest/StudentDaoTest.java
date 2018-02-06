package unittest;

import org.junit.Test;
import org.mehaexample.asdDemo.dao.StudentDao;
import org.mehaexample.asdDemo.model.Student;
import java.sql.SQLException;
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
	public void testIfNullNuidExists() throws SQLException {
		StudentDao studentDao = new StudentDao();
		
		boolean exists = studentDao.ifNuidExists(null);
		Assert.assertFalse(exists);
	}
	
	@Test
	public void testIfNullStudentCanBeInserted() {
		StudentDao studentDao = new StudentDao();
		
		Student studentRecordAdded = studentDao.addStudentRecord(null);
		Assert.assertNull(studentRecordAdded);
	}
	
	@Test
	public void testIfNullNuidCanBeDeleted() {
		StudentDao studentDao = new StudentDao();
		
		boolean isDeleted = studentDao.deleteStudentRecord(null);
		Assert.assertFalse(isDeleted);
	}
	
	@Test
	public void testIfBlankNuidStudentCanBeDeleted() {
		StudentDao studentDao = new StudentDao();
		
		boolean isDeleted = studentDao.deleteStudentRecord("");
		Assert.assertFalse(isDeleted);
	}
	
	
}
