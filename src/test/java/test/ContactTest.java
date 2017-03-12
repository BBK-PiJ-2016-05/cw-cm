package test.java.test;

import main.java.impl.ContactImpl;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import main.java.spec.Contact;

import static org.junit.Assert.*;

/**
 * Created by Duncan on 04/03/2017.
 */
public class ContactTest {
    private Contact duncan;

    @Before
    public void setUp(){
        duncan = new ContactImpl(1, "Duncan", "Duncan is great");
    }

    @After
    public void tearDown(){

    }

    @Test
    public void testSimpleContactConstructor(){
        try{
            Contact robert = new ContactImpl(2, "Robert");
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void testOtherContactConstructor(){
        try{
            Contact robert = new ContactImpl(2, "Robert", "Duncan is okay");
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }


    @Test
    public void testContactGetName(){
        assertEquals("Duncan",duncan.getName());
    }

    @Test
    public void testContactGetNotes(){
        assertEquals("Duncan is great",duncan.getNotes());
    }

    @Test
    public void testContactAddNotes(){
        duncan.addNotes("at programming in Java");
        assertEquals("Duncan is great at programming in Java", duncan.getNotes());
    }

    @Test
    public void testContactGetId(){
        assertEquals(1,duncan.getId());
    }

}