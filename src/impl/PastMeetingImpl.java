package impl;

import spec.Contact;
import spec.PastMeeting;

import java.util.Calendar;
import java.util.Set;

/**
 * Created by Duncan on 04/03/2017.
 */
public class PastMeetingImpl extends MeetingImpl implements PastMeeting {
    PastMeetingImpl(int ID, Calendar date, Set<Contact> contacts, String notes){

    }
    public String getNotes(){
        return "";
    }
}
