package base;

import static org.junit.Assert.*;


import java.util.UUID;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import base.PersonDAL;
import base.StudentDAL;
import domain.PersonDomainModel;

public class Person_Test {
	
	private static PersonDomainModel person1;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		Date dDate = null;
		try{
			dDate = new SimpleDateFormat("dd-MM-yyyy").parse("04-16-1996");
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		person1 = new PersonDomainModel();
		person1.setFirstName("Josh");
		person1.setLastName("Nachlis");
		person1.setBirthday(dDate);
		person1.setCity("Wilmington");
		person1.setPostalCode(19810);
		person1.setStreet("204 Beau Tree Dr.");		

	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
		PersonDomainModel per;	
		PersonDAL.deletePerson(per1.getPersonID());
		per = PersonDAL.getPerson(per1.getPersonID());
		assertNull("The Person shouldn't have been in the database",per);
	}

	@Test
	public void testaddPerson() {
		PersonDAL.addPerson(person1);
		assertTrue(person1 == person1);
		
	}
	@Test
	public void testdeletePerson() {
		PersonDAL.deletePerson(randomUUID1);
		
		assertTrue(PersonDAL.deletePerson(randomUUID1) == PersonDAL.deletePerson(randomUUID1));
	}
	
	@Test
	public void testupdatePerson() {
		PersonDAL.updatePerson(person1.firstNameProperty("Aaron"));
		assertTrue((PersonDAL.getPerson(randomUUID1) == person1;
	}
	
	@Test
	public void testgetPerson() {
		
		assertTrue(PersonDAL.updatePerson(per)) == session.update(per));
	}

}