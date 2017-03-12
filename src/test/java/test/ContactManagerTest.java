package test.java.test;

import main.java.spec.Contact;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import main.java.spec.ContactManager;
import main.java.impl.ContactManagerImpl;

import java.util.Set;

import static org.junit.Assert.*;

/**
 * Created by Duncan on 04/03/2017.
 */
public class ContactManagerTest {
    private ContactManager myContactManager;


    @Before
    public void setUp() throws Exception {
        myContactManager = new ContactManagerImpl();
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void addFutureMeeting() throws Exception {

    }

    @Test
    public void getPastMeeting() throws Exception {

    }

    @Test
    public void getFutureMeeting() throws Exception {

    }

    @Test
    public void getMeeting() throws Exception {

    }

    @Test
    public void getFutureMeetingList() throws Exception {

    }

    @Test
    public void getMeetingListOn() throws Exception {

    }

    @Test
    public void getPastMeetingListFor() throws Exception {

    }

    @Test
    public void addNewPastMeeting() throws Exception {

    }

    @Test
    public void addMeetingNotes() throws Exception {

    }

    @Test
    public void testAddNewContactExceptionsNoName(){
        try{
            myContactManager.addNewContact(null, "Duncan is great");
            fail();
        } catch (NullPointerException e){
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void testAddNewContactExceptionsNoNotes(){
        try{
            myContactManager.addNewContact("Duncan", null);
            fail();
        } catch (NullPointerException e){
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void testAddNewContactExceptionsEmptyName(){
        try{
            myContactManager.addNewContact("", "Duncan is great");
            fail();
        } catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void testAddNewContactExceptionsEmptyNotes(){
        try{
            myContactManager.addNewContact("Duncan", "");
            fail();
        } catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void testAddNewContact(){
        myContactManager.addNewContact("Duncan", "Duncan is great");
    }



    @Test
    public void testGetContactsUsingNames() {
        myContactManager.addNewContact("Duncan Jones", "Duncan is great");
        myContactManager.addNewContact("Robert Jones", "Robert is Duncan's brother");
        myContactManager.addNewContact("Geoff Jones", "Geoff is Duncan's father");
        myContactManager.addNewContact("Jenny Denman", "Jenny is Duncan's aunt");
        myContactManager.addNewContact("Phil Denman", "Phil is Duncan's uncle");
        Set<Contact> theDenmans = myContactManager.getContacts("Denman");
        Set<Contact> theJoneses = myContactManager.getContacts("Jones");
        assertEquals(2, theDenmans.size());
        assertEquals(3, theJoneses.size());
        assertEquals("Duncan Jones", ((Contact) theJoneses.toArray()[0]).getName());
        assertEquals("Phil is Duncan's aunt", ((Contact) theDenmans.toArray()[1]).getNotes());
    }

    @Test
    public void getContacts1() throws Exception {

    }

    @Test
    public void flush() throws Exception {

    }

}