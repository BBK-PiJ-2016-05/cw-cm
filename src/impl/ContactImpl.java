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
     * most general constructor with three parameters:
     * @param id the ID provided by the ContactManager
     * @param name the name
     * @param initialNotes the initial set of notes about the contact
     * @throws IllegalArgumentException if the ID provided is zero or negative
     * @throws NullPointerException if any of the references / pointers passed as
     *      parameters to the constructor is null
     */
    public ContactImpl(int id, String name, String initialNotes){

        if (name==null || initialNotes==null){
            throw new NullPointerException("one or more parameter was null");
        }
        if (id<=0){
            throw new IllegalArgumentException("ID provided is zero or negative");
        }

        this.name = name;
        this.notes = initialNotes;
        this.id = id;
    }

    /**
     * more restricted constructor where the ID is provided by the ContactManager
     * @param name the name
     * @throws IllegalArgumentException if the ID provided is zero or negative
     * @throws NullPointerException if any of the references / pointers passed as
     *      parameters to the constructor is null
     */
    public ContactImpl(int id, String name){
        this.name = name;
        this.notes = "";
        this.id = id;

    }

    public int getId(){
        return id;
    }

    public String getName(){
        return name;
    }

    public String getNotes(){
        return notes;
    }

    public void addNotes(String note){
        notes = notes + " " + note;
    }
}
