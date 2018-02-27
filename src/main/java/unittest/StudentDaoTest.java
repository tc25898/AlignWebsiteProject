package unittest;

import org.junit.Test;
import org.mehaexample.asdDemo.model.Student;
import java.sql.SQLException;
import org.junit.Assert;
import utils.StudentDaoJdbc;

public class StudentDaoTest {
	
	@Test
	public void testIfEmptyNuidExists() {
		System.out.println("hello test");
		StudentDaoJdbc studentDao = new StudentDaoJdbc();
		
		boolean exists = studentDao.ifNuidExists("");
		Assert.assertFalse(exists);
	}
	
	@Test
	public void testIfNullNuidExists() throws SQLException {
		StudentDaoJdbc studentDao = new StudentDaoJdbc();
		
		boolean exists = studentDao.ifNuidExists(null);
		Assert.assertFalse(exists);
	}
	
	@Test
	public void testIfNullStudentCanBeInserted() {
		StudentDaoJdbc studentDao = new StudentDaoJdbc();
		
		Student studentRecordAdded = studentDao.addStudentRecord(null);
		Assert.assertNull(studentRecordAdded);
	}
	
	@Test
	public void testIfNullNuidCanBeDeleted() {
		StudentDaoJdbc studentDao = new StudentDaoJdbc();
		
		boolean isDeleted = studentDao.deleteStudentRecord(null);
		Assert.assertFalse(isDeleted);
	}
	
	@Test
	public void testIfBlankNuidStudentCanBeDeleted() {
		StudentDaoJdbc studentDao = new StudentDaoJdbc();
		
		boolean isDeleted = studentDao.deleteStudentRecord("");
		Assert.assertFalse(isDeleted);
	}
	
	
}
