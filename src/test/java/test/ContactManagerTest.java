package test.java.test;

import main.java.impl.ContactImpl;
import main.java.spec.Contact;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import main.java.spec.ContactManager;
import main.java.impl.ContactManagerImpl;

import java.util.Calendar;
import java.util.LinkedHashSet;
import java.util.Set;

import static org.junit.Assert.*;

/**
 * Created by Duncan on 04/03/2017.
 */
public class ContactManagerTest {
    private ContactManager myContactManager;
    private Calendar todaysDate;
    private Calendar futureDate;
    private Calendar pastDate;
    private Set<Contact> unknownPeople;
    private Set<Contact> everyone;


    @Before
    public void setUp() throws Exception {
        myContactManager = new ContactManagerImpl();
        todaysDate = Calendar.getInstance();
        myContactManager.addNewContact("Duncan Jones", "Duncan is great");
        myContactManager.addNewContact("Robert Jones", "Robert is Duncan's brother");
        myContactManager.addNewContact("Geoff Jones", "Geoff is Duncan's father");
        myContactManager.addNewContact("Jenny Denman", "Jenny is Duncan's aunt");
        myContactManager.addNewContact("Phil Denman", "Phil is Duncan's uncle");
        futureDate = Calendar.getInstance();
        futureDate.add(Calendar.MONTH, 3);
        pastDate = Calendar.getInstance();
        pastDate.add(Calendar.MONTH, -3);
        Contact unknownContact = new ContactImpl(12, "Freddie", "No one knows Freddie");
        unknownPeople = new LinkedHashSet<Contact>();
        unknownPeople.add(unknownContact);
        everyone = myContactManager.getContacts("");

    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void testAddFutureMeetingExceptions(){

        if(pastDate==null){
            System.out.println("pastDate is null");
        }

        try {
            myContactManager.addFutureMeeting(everyone, pastDate);
            fail();
        }
        catch (IllegalArgumentException e){
            assertEquals("the meeting is set for a time in the past",e.getMessage());
        }

        try {
            myContactManager.addFutureMeeting(unknownPeople, futureDate);
            fail();
        }
        catch (IllegalArgumentException e){
            assertEquals("a contact is unknown or non-existent",e.getMessage());
        }

        try {
            myContactManager.addFutureMeeting(null, futureDate);
            fail();
        }
        catch (NullPointerException e){
            assertEquals("the contact list or the date is null",e.getMessage());
        }

        try {
            myContactManager.addFutureMeeting(everyone, null);
            fail();
        }
        catch (NullPointerException e){
            assertEquals("the contact list or the date is null",e.getMessage());
        }

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
        Set<Contact> theDenmans = myContactManager.getContacts("Denman");
        Set<Contact> theJoneses = myContactManager.getContacts("Jones");
        assertEquals(2, theDenmans.size());
        assertEquals(3, theJoneses.size());
        assertEquals(5, everyone.size());
        assertEquals("Duncan Jones", ((Contact) theJoneses.toArray()[0]).getName());
        assertEquals("Phil is Duncan's uncle", ((Contact) theDenmans.toArray()[1]).getNotes());
    }

    @Test
    public void testGetContactsException(){
        String emptyNameString = null;
        try{
            Set<Contact> emptySet = myContactManager.getContacts(emptyNameString);
            fail();
        } catch (NullPointerException e){
            System.out.println(e.getMessage());
        }
    }


    @Test
    public void testGetContactsUsingIds() {
        Set<Contact> theDenmans = myContactManager.getContacts(4, 5);
        Set<Contact> theJoneses = myContactManager.getContacts(1, 2, 3);
        Set<Contact> everyone = myContactManager.getContacts(1,2,3,4,5);
        assertEquals(2, theDenmans.size());
        assertEquals(3, theJoneses.size());
        assertEquals(5, everyone.size());
        assertEquals("Duncan Jones", ((Contact) theJoneses.toArray()[0]).getName());
        assertEquals("Phil is Duncan's uncle", ((Contact) theDenmans.toArray()[1]).getNotes());

        try{
            Set<Contact> emptySet = myContactManager.getContacts();
            fail();
        } catch (IllegalArgumentException e){
            assertEquals("no IDs are provided",e.getMessage());
        }

        try{
            Set<Contact> wrongId = myContactManager.getContacts(6);
            fail();
        } catch (IllegalArgumentException e){
            assertEquals("one of the provided IDs does not correspond to a real contact",e.getMessage());
        }

    }



    @Test
    public void flush() throws Exception {

    }
}