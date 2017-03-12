package test.java.test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import main.java.spec.ContactManager;
import main.java.impl.ContactManagerImpl;

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
    public void getContacts() throws Exception {

    }

    @Test
    public void getContacts1() throws Exception {

    }

    @Test
    public void flush() throws Exception {

    }

}