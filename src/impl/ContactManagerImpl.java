package impl;

import spec.*;

import java.util.*;

/**
 * Created by Duncan on 04/03/2017.
 */
public class ContactManagerImpl implements ContactManager {

    private int nextContactID=1;
    private Set<Contact> allContacts = new LinkedHashSet<Contact>();

    public int addFutureMeeting(Set<Contact> contacts, Calendar date){
        return 0;
    }

    public PastMeeting getPastMeeting(int id){
        return null;
    }

    public FutureMeeting getFutureMeeting(int id){
        return null;
    }

    public Meeting getMeeting(int id){
        return null;
    }

    public List<Meeting> getFutureMeetingList(Contact contact){
        return null;
    }

    public List<Meeting> getMeetingListOn(Calendar date){
        return null;
    }

    public List<PastMeeting> getPastMeetingListFor(Contact contact){
        return null;
    }

    public int addNewPastMeeting(Set<Contact> contact, Calendar date, String text){
        return 0;
    }

    public PastMeeting addMeetingNotes(int id, String text){
        return null;
    }

    public int addNewContact(String name, String notes){

        Contact contactToAdd;

        try {
            contactToAdd = new ContactImpl(nextContactID, name, notes);
        }
        catch (NullPointerException|IllegalArgumentException e){
            throw e;
        }

        if (name.equals("") || notes.equals("")){
            throw new IllegalArgumentException("one or more of the parameters was blank");
        }

        allContacts.add(contactToAdd);
        nextContactID ++;
        return contactToAdd.getId();
    }

    public Set<Contact> getContacts(String name){
        return null;
    }

    public Set<Contact> getContacts(int... ids){
        return null;
    }

    public void flush(){

    }

}
