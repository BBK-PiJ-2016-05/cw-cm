package main.java.impl;

import main.java.spec.Contact;
import main.java.spec.PastMeeting;

import java.util.Calendar;
import java.util.Set;

/**
 * Created by Duncan on 04/03/2017.
 */
public class PastMeetingImpl extends MeetingImpl implements PastMeeting {
    private String notes;

    public PastMeetingImpl(int ID, Calendar date, Set<Contact> contacts, String notes){
        super(ID, date, contacts);
        this.notes = notes;
    }

    public String getNotes(){
        return notes;
    }
}
