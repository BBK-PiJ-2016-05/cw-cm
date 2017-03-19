package test.java.test;

import main.java.impl.ContactImpl;
import main.java.impl.FutureMeetingImpl;
import main.java.impl.PastMeetingImpl;
import main.java.spec.Contact;
import main.java.spec.Meeting;
import main.java.spec.PastMeeting;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

import java.util.Calendar;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * Created by Duncan on 04/03/2017.
 */
public class MeetingTest {

    private Calendar todaysDate;
    private Set<Contact> contacts;

    @Before
    public void setUp(){
        todaysDate = Calendar.getInstance();
        contacts = new LinkedHashSet<Contact>();
        contacts.add(new ContactImpl(1, "Duncan", "Duncan is great"));
        contacts.add(new ContactImpl(2, "Robert", "Robert is Duncan's brother"));
    }

    @Test
    public void testFutureMeetingConstructor(){

        try{
            Meeting myMeeting = new FutureMeetingImpl(1,todaysDate, contacts);
        }
        catch (Exception e){
            fail(e.getMessage());
        }

        try{
            Meeting myMeeting = new FutureMeetingImpl(0,todaysDate, contacts);
            fail();
        }
        catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }

        try{
            Meeting myMeeting = new FutureMeetingImpl(1,null, contacts);
            fail();
        }
        catch (NullPointerException e){
            System.out.println(e.getMessage());
        }

        Set<Contact> emptyContacts = new LinkedHashSet<Contact>();
        try{
            Meeting myMeeting = new FutureMeetingImpl(1,todaysDate, emptyContacts);
            fail();
        }
        catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void testPastMeetingConstructor(){
        try{
            Meeting myMeeting = new PastMeetingImpl(1,todaysDate, contacts,"Meeting notes");
        }
        catch (Exception e){
            fail(e.getMessage());
        }
    }

    @Test
    public void testGetters() throws Exception {
        Meeting myMeeting = new PastMeetingImpl(1,todaysDate, contacts,"Meeting notes");
        assertEquals(todaysDate, myMeeting.getDate());
        assertEquals(contacts, myMeeting.getContacts());
        assertEquals("Meeting notes", ((PastMeeting) myMeeting).getNotes());
    }

}