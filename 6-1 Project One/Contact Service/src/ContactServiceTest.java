import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.Ignore;
import static org.junit.Assert.*;

public class ContactServiceTest {

	@Test
	public void testAddContact() {
		Contact contact = new Contact("0000000000001", "Jason David Frank", "Green Ranger", "9781234545", "123 Power Drive");
		Contact contact2 = new Contact("0000000000002", "Austin St John", "Red Ranger", "9781234543", "125 Power Drive");
		Contact contact3 = new Contact("0000000000003", "Walter Emanuel Jones", "Black Ranger", "9781234542", "127 Power Drive");
		ContactService service = new ContactService();
		assertEquals(true, service.addContact(contact));
		assertEquals(true, service.addContact(contact2));
		assertEquals(false, service.addContact(contact2));
		assertEquals(true, service.addContact(contact3));
		assertEquals(false, service.addContact(contact3));

	}
	
	@Test
	public void testDeleteContact() {
		Contact contact = new Contact("0000000000001", "Jason David Frank", "Green Ranger", "9781234545", "123 Power Drive");
		Contact contact2 = new Contact("0000000000002", "Austin St John", "Red Ranger", "9781234543", "125 Power Drive");
		Contact contact3 = new Contact("0000000000003", "Walter Emanuel Jones", "Black Ranger", "9781234542", "127 Power Drive");
		ContactService service = new ContactService();
		assertEquals(true, service.addContact(contact));
		assertEquals(true, service.addContact(contact2));
		assertEquals(true, service.addContact(contact3));
		assertEquals(true, service.deleteContact("0000000000001"));
		assertEquals(true, service.deleteContact("0000000000002"));
		assertEquals(true, service.deleteContact("0000000000003"));
	}
	
	@Test
	public void testUpdateContact() {
		Contact contact = new Contact("0000000000001", "Jason David Frank", "Green Ranger", "9781234545", "123 Power Drive");
		Contact contact2 = new Contact("0000000000002", "Austin St John", "Red Ranger", "9781234543", "125 Power Drive");
		Contact contact3 = new Contact("0000000000003", "Walter Emanuel Jones", "Black Ranger", "9781234542", "127 Power Drive");
		ContactService service = new ContactService();
		assertEquals(true, service.addContact(contact));
		assertEquals(true, service.addContact(contact2));
		assertEquals(true, service.addContact(contact3));
		//update first
		assertEquals(true, service.updateContact("0000000000001", "Jason Frank", "Green Ranger", "9781234545", "123 Power Drive" ));
		assertEquals(contact.getFirstName(), "Jason Frank");
		
		// update number
		assertEquals(true, service.updateContact("0000000000001", "Jason Frank", "Green Ranger", "0000000000", "123 Power Drive" ));
		assertEquals(contact.getPhone(), "0000000000");
		
		
		// update first, last
		assertEquals(true, service.updateContact("0000000000002", "Thuy Trang", "Yellow Ranger", "9781234543", "125 Power Drive"));
		assertEquals(contact2.getLastName(), "Yellow Ranger");
		assertEquals(contact2.getFirstName(), "Thuy Trang");
		
		
		
		// update first, last, address
		assertEquals(true, service.updateContact("0000000000003", "David Yost", "Blue Ranger", "9101234542", "123 Rangers Drive"));
		assertEquals(contact3.getLastName(), "Blue Ranger");
		assertEquals(contact3.getFirstName(), "David Yost");
		assertEquals(contact3.getAddress(), "123 Rangers Drive");
	}
	
}
