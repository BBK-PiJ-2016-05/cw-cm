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
    public void testSimpleContactConstructor(){
        try{
            Contact Duncan = new ContactImpl("Duncan");
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void testOtherContactConstructor(){
        try{
            Contact Duncan = new ContactImpl("Duncan", "Duncan is great");
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }


    @Test
    public void testContactGetName(){
        Contact Duncan = new ContactImpl("Duncan", "Duncan is great");
        assertEquals("Duncan",Duncan.getName());
    }

    @Test
    public void testContactGetNotes(){
        Contact Duncan = new ContactImpl("Duncan", "Duncan is great");
        assertEquals("Duncan is great",Duncan.getNotes());
    }

    @Test
    public void addNotes() throws Exception {

    }

    @Test
    public void testContactGetId(){

    }

}