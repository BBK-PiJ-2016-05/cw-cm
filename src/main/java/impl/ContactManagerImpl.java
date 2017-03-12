package main.java.impl;

import main.java.spec.*;

import java.util.*;

/**
 * Created by Duncan on 04/03/2017.
 */
public class ContactManagerImpl implements ContactManager {

    private Set<Contact> allContacts = new LinkedHashSet<Contact>();
    private Set<Meeting> allMeetings = new LinkedHashSet<Meeting>();

    private boolean contactsExist(Set<Contact> contacts){
        for (Contact contactToTest : contacts){
            boolean contactExists = false;
            for (Contact contactThatExists: allContacts){
                if(contactToTest.equals(contactThatExists)){
                    contactExists = true;
                }
            }
            if (!contactExists){
                return false;
            }
        }
        return true;
    }

    public int addFutureMeeting(Set<Contact> contacts, Calendar date){
        Meeting meetingToAdd;
        int meetingId;

        if (allMeetings.isEmpty()){
            meetingId=1;
        }
        else{
            meetingId=allMeetings.size()+1;
        }

        try {
            meetingToAdd = new FutureMeetingImpl(meetingId, date, contacts);
        }
        catch (NullPointerException e){
            throw new NullPointerException("the contact list or the date is null");
        }

        Calendar nowDate = Calendar.getInstance();
        if(date.before(nowDate)){
            throw new IllegalArgumentException("the meeting is set for a time in the past");
        }

        if(!contactsExist(contacts)){
            throw new IllegalArgumentException("a contact is unknown or non-existent");
        }

        allMeetings.add(meetingToAdd);
        return meetingId;
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
        int contactId;

        if (allContacts.isEmpty()){
            contactId = 1;
        }
        else{
            contactId = allContacts.size()+1;
        }

        try {
            contactToAdd = new ContactImpl(contactId, name, notes);
        }
        catch (NullPointerException|IllegalArgumentException e){
            throw e;
        }

        if (name.equals("") || notes.equals("")){
            throw new IllegalArgumentException("one or more of the parameters was blank");
        }

        allContacts.add(contactToAdd);
        return contactToAdd.getId();
    }

    public Set<Contact> getContacts(String name){

        Set<Contact> contactsToReturn = new LinkedHashSet<Contact>();

        if(name==null){
            throw new NullPointerException("the parameter is null");
        }

        for (Contact eachContact : allContacts){
            if(eachContact.getName().contains(name)){
                contactsToReturn.add(eachContact);
            }
        }
        return contactsToReturn;
    }

    public Set<Contact> getContacts(int... ids){

        if(ids==null || ids.length == 0){
            throw new IllegalArgumentException("no IDs are provided");
        }

        Set<Contact> contactsToReturn = new LinkedHashSet<Contact>();
        boolean isReal;

        for (int id : ids) {
            isReal = false;
            for (Contact eachContact : allContacts) {
                if (id == eachContact.getId()) {
                    contactsToReturn.add(eachContact);
                    isReal = true;
                }
            }
            if (!isReal){
                throw new IllegalArgumentException("one of the provided IDs does not correspond to a real contact");
            }
        }

        return contactsToReturn;

    }

    public void flush(){

    }

}
