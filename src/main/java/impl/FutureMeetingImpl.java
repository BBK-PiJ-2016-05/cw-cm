package main.java.impl;

import main.java.spec.Contact;
import main.java.spec.FutureMeeting;

import java.util.Calendar;
import java.util.Set;

/**
 * Created by Duncan on 04/03/2017.
 */
public class FutureMeetingImpl extends MeetingImpl implements FutureMeeting {
    public FutureMeetingImpl(int ID, Calendar date, Set<Contact> contacts){
        super(ID, date, contacts);
    }
}
