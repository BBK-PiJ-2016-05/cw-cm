package impl;

import spec.Contact;

/**
 * Created by Duncan on 04/03/2017.
 * Implements the Contact interface
 */
public class ContactImpl implements Contact {
    /**
     * most general constructor with three parameters:
     * @param ID the ID provided by the ContactManager
     * @param name the name
     * @param initialNotes the initial set of notes about the contact
     * @throws IllegalArgumentException if the ID provided is zero or negative
     * @throws NullPointerException if any of the references / pointers passed as
     *      parameters to the constructor is null
     */
    ContactImpl(int ID, String name, String initialNotes){

    }

    /**
     * more restricted constructor with two parameters only:
     * @param ID the ID provided by the ContactManager
     * @param name the name
     * @throws IllegalArgumentException if the ID provided is zero or negative
     * @throws NullPointerException if any of the references / pointers passed as
     *      parameters to the constructor is null
     */
    ContactImpl(int ID, String name){

    }

    public int getId(){
        return 0;
    }

    public String getName(){
        return "";
    }

    public String getNotes(){
        return "";
    }

    public void addNotes(String note){

    }
}
