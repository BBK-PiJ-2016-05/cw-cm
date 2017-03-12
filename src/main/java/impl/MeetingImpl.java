package main.java.impl;

import main.java.spec.Contact;
import main.java.spec.Meeting;

import java.util.Calendar;
import java.util.Set;

/**
 * Created by Duncan on 04/03/2017.
 */
public abstract class MeetingImpl implements Meeting {
    /**
     * constructor with three parameters:
     * @param ID
     * @param date a date
     * @param contacts a set of contacts that must be non-empty
     * @throws IllegalArgumentException if set of contacts is empty
     * @throws IllegalArgumentException if the ID provided was non-positive or zero
     * @throws NullPointerException if any of the references / pointers passed as parameters is null
     */
    MeetingImpl(int ID, Calendar date, Set<Contact> contacts){

    }

    MeetingImpl(){

    }

    public int getId(){
        return 0;
    }

    public Calendar getDate(){
        return null;
    }

    public Set<Contact> getContacts(){
        return null;
    }
}
