package test.unit;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import person.Person;

public class PersonTest {

	@Test
	public void test_person_first_name() {
		Person testPersonClass = new Person("John","Green");
		
		testPersonClass.setFirstName("John");
		assertEquals("John", testPersonClass.getFirstName());
	}
	@Test
	public void test_person_last_name() {
		Person testPersonClass = new Person("John","Green");
		
		testPersonClass.setLastName("Green");
		assertEquals("Green", testPersonClass.getLastName());
		
	}
	@Test
	public void test_person_full_name() {
		Person testPersonClass = new Person("John","Green");
		
		testPersonClass.setFirstName("John");
		
		testPersonClass.setLastName("Green");
		
		assertEquals("John Green", testPersonClass.getFullName());
	}
}
