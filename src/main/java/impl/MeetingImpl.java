package main.java.impl;

import main.java.spec.Contact;
import main.java.spec.Meeting;

import java.util.Calendar;
import java.util.Set;

/**
 * Created by Duncan on 04/03/2017.
 */
public abstract class MeetingImpl implements Meeting {

    private int id;
    private Calendar date;
    private Set<Contact> contacts;

    /**
     * constructor with three parameters:
     * @param ID
     * @param date a date
     * @param contacts a set of contacts that must be non-empty
     * @throws IllegalArgumentException if set of contacts is empty
     * @throws IllegalArgumentException if the ID provided was non-positive or zero
     * @throws NullPointerException if any of the references / pointers passed as parameters is null
     */
    public MeetingImpl(int ID, Calendar date, Set<Contact> contacts){

        if(date==null||contacts==null){
            throw new NullPointerException("the contact list or the date is null");
        }
        if(contacts.isEmpty()){
            throw new IllegalArgumentException("the set of contacts is empty");
        }
        if(ID<=0){
            throw new IllegalArgumentException("the ID provided was non-positive or zero");
        }

        this.id = ID;
        this.date = date;
        this.contacts = contacts;

    }

    public MeetingImpl(){

    }

    public int getId(){
        return id;
    }

    public Calendar getDate(){
        return date;
    }

    public Set<Contact> getContacts(){
        return contacts;
    }
}
