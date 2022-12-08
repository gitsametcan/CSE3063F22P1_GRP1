package test.unit;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import person.Person;

public class PersonTest {

	@Test
	public void test_person_default_conscructor() {
		Person testPersonClass = new Person("John","Green");
		
		testPersonClass.setLastName("John");
		assertEquals("John", testPersonClass.getLastName());
		
		testPersonClass.setLastName("Green");
		assertEquals("Green", testPersonClass.getLastName());
		
		assertEquals("John Green", testPersonClass.getFullName());
	}
}
