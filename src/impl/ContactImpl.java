package impl;

import spec.Contact;

/**
 * Created by Duncan on 04/03/2017.
 * Implements the Contact interface
 */
public class ContactImpl implements Contact {

    private String name;
    private String notes;
    private int id;

    /**
     * most general constructor where the ID is provided by the ContactManager
     * @param name the name
     * @param initialNotes the initial set of notes about the contact
     * @throws IllegalArgumentException if the ID provided is zero or negative
     * @throws NullPointerException if any of the references / pointers passed as
     *      parameters to the constructor is null
     */
    public ContactImpl(String name, String initialNotes){
        this.name = name;
        this.notes = initialNotes;
        //this.id = myContactManager.addNewContact(name, initialNotes);
    }

    /**
     * more restricted constructor where the ID is provided by the ContactManager
     * @param name the name
     * @throws IllegalArgumentException if the ID provided is zero or negative
     * @throws NullPointerException if any of the references / pointers passed as
     *      parameters to the constructor is null
     */
    public ContactImpl(String name){
        this.name = name;
        this.notes = "";
        //this.id = myContactManager.addNewContact(name, initialNotes);

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
