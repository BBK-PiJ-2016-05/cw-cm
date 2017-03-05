package test;

import impl.ContactImpl;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import spec.Contact;

import static org.junit.Assert.*;

/**
 * Created by Duncan on 04/03/2017.
 */
public class ContactTest {
    @Before
    public void setUp(){

    }

    @After
    public void tearDown(){

    }

    @Test
    public void testSimpleContactInstructor(){
        try{
            Contact Duncan = new ContactImpl("Duncan");
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void getId() throws Exception {

    }

    @Test
    public void getName() throws Exception {

    }

    @Test
    public void getNotes() throws Exception {

    }

    @Test
    public void addNotes() throws Exception {

    }

}