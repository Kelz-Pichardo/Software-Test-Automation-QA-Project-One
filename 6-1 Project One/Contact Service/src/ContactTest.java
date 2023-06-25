import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.Ignore;
import static org.junit.Assert.*;

public class ContactTest {

	@Test
	public void testContactClass() {
		Contact contact = new Contact("0000000000001", "Jason David Frank", "Green Ranger", "9781234545", "123 Power Drive");
		assertTrue(contact.getAddress().equals("123 Power Drive"));
		assertTrue(contact.getFirstName().equals("Jason David Frank"));
		assertTrue(contact.getID().equals("0000000000001"));
		assertTrue(contact.getLastName().equals("Green Ranger"));
		assertTrue(contact.getPhone().equals("9781234545"));
	}
	
	@Test
	public void testExceptions() {
		
		// id too short
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			Contact contact = new Contact("001", "Jason David Frank", "Green Ranger", "9781234545", "123 Power Drive");
		});
		
		// first name too short
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			Contact contact = new Contact("0000000000001", "Jason", "Green Ranger", "9781234545", "123 Power Drive");
		});
		
		// last name too short
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			Contact contact = new Contact("0000000000001", "Jason David Frank", "Green", "9781234545", "123 Power Drive");
		});
		
		
		// number is 11
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			Contact contact = new Contact("0000000000001", "Jason David Frank", "Green Ranger", "97812345450", "123 Power Drive");
		});
		
		
		// number is 9
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			Contact contact = new Contact("0000000000001", "Jason David Frank", "Green Ranger", "978123454", "123 Power Drive");
		});
		
		// address is too long
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			Contact contact = new Contact("0000000000001", "Jason David Frank", "Green Ranger", "9781234545", "123123123123123123123123123123123123123 Power Drive");
		});
		
		// id is null
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			Contact contact = new Contact(null, "Jason David Frank", "Green Ranger", "9781234545", "123 Power Drive");
		});
		
		// first null
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			Contact contact = new Contact("0000000000001", null, "Green Ranger", "9781234545", "123 Power Drive");
		});
		
		// last null
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			Contact contact = new Contact("0000000000001", "Jason David Frank", null, "9781234545", "123 Power Drive");
		});
		
		// number is null
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			Contact contact = new Contact("0000000000001", "Jason David Frank", "Green Ranger", null, "123 Power Drive");
		});
		
		// address is null
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			Contact contact = new Contact("0000000000001", "Jason David Frank", "Green Ranger", "9781234545", null);
		});
		
	}
		
		
	
}
