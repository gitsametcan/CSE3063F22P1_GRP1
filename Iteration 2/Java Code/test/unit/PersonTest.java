package test.unit;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import person.Student;

public class PersonTest {

	@Test
	public void test_person_first_name() {
		Student testPersonClass = new Student("John","Green",null,null,null,null);
		
		testPersonClass.setFirstName("John");
		assertEquals("John", testPersonClass.getFirstName());
	}
	@Test
	public void test_person_last_name() {
		Student testPersonClass = new Student("John","Green",null,null,null,null);
		
		testPersonClass.setLastName("Green");
		assertEquals("Green", testPersonClass.getLastName());
		
	}
	@Test
	public void test_person_full_name() {
		Student testPersonClass = new Student("John","Green",null,null,null,null);
		
		testPersonClass.setFirstName("John");
		
		testPersonClass.setLastName("Green");
		
		assertEquals("John Green", testPersonClass.getFullName());
	}
}
