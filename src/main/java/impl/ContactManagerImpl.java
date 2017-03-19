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
    private boolean contactExist(Contact contact){
        Set<Contact> setOfOneContact = new LinkedHashSet<Contact>();
        setOfOneContact.add(contact);
        return contactsExist(setOfOneContact);
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

        if(!contactsExist(contacts)){
            throw new IllegalArgumentException("a contact is unknown or non-existent");
        }

        Calendar nowDate = Calendar.getInstance();
        if(date.before(nowDate)){
            throw new IllegalArgumentException("the meeting is set for a time in the past");
        }

        allMeetings.add(meetingToAdd);
        return meetingId;
    }

    public PastMeeting getPastMeeting(int id){
        Calendar nowDate = Calendar.getInstance();
        Meeting meetingToReturn = getMeeting(id);
        if (meetingToReturn==null){
            return null;
        }
        if (meetingToReturn.getDate().after(nowDate)){
            throw new IllegalStateException("there is a meeting with this ID that happening in the future");
        }
        else{
            return ((PastMeeting) meetingToReturn);
        }

    }

    public FutureMeeting getFutureMeeting(int id){
        Calendar nowDate = Calendar.getInstance();
        Meeting meetingToReturn = getMeeting(id);
        if (meetingToReturn==null){
            return null;
        }
        if (meetingToReturn.getDate().before(nowDate)){
            throw new IllegalStateException("there is a meeting with this ID that happened in the past");
        }
        else{
            return ((FutureMeeting) meetingToReturn);
        }


    }

    public Meeting getMeeting(int id){

        for (Meeting eachMeeting : allMeetings){
            if (eachMeeting.getId()==id){
                return eachMeeting;
            }
        }
        return null;
    }

    public List<Meeting> getFutureMeetingList(Contact contact){

        if(contact==null){
            throw new NullPointerException("contact is null");
        }
        if(!contactExist(contact)){
            throw new IllegalArgumentException("a contact is unknown or non-existent");
        }

        Calendar nowDate = Calendar.getInstance();
        List<Meeting> meetingsToReturn = new ArrayList<Meeting>();

        for (Meeting eachMeeting : allMeetings){
            if (eachMeeting.getDate().after(nowDate)) {
                for (Contact eachContact : eachMeeting.getContacts()) {
                    if (eachContact.equals(contact)) {
                        meetingsToReturn.add(eachMeeting);
                    }
                }
            }
        }

        return meetingsToReturn;
    }

    public List<Meeting> getMeetingListOn(Calendar date){
        if(date == null){
            throw new NullPointerException(("date is null"));
        }
        List<Meeting> meetingsToReturn = new ArrayList<Meeting>();
        for (Meeting eachMeeting : allMeetings){
            if (eachMeeting.getDate().equals(date)){
                meetingsToReturn.add(eachMeeting);
            }
        }
        return meetingsToReturn;
    }

    public List<PastMeeting> getPastMeetingListFor(Contact contact){
        if(contact==null){
            throw new NullPointerException("contact is null");
        }
        if(!contactExist(contact)){
            throw new IllegalArgumentException("a contact is unknown or non-existent");
        }

        Calendar nowDate = Calendar.getInstance();
        List<PastMeeting> meetingsToReturn = new ArrayList<PastMeeting>();

        for (Meeting eachMeeting : allMeetings){
            if (eachMeeting.getDate().before(nowDate)) {
                for (Contact eachContact : eachMeeting.getContacts()) {
                    if (eachContact.equals(contact)) {
                        meetingsToReturn.add((PastMeeting) eachMeeting);
                    }
                }
            }
        }

        return meetingsToReturn;
    }

    public int addNewPastMeeting(Set<Contact> contacts, Calendar date, String text){
        Meeting meetingToAdd;
        int meetingId;

        if (allMeetings.isEmpty()){
            meetingId=1;
        }
        else{
            meetingId=allMeetings.size()+1;
        }

        try {
            meetingToAdd = new PastMeetingImpl(meetingId, date, contacts, text);
        }
        catch (NullPointerException e){
            throw e;
        }

        if(!contactsExist(contacts)){
            throw new IllegalArgumentException("a contact is unknown or non-existent");
        }

        Calendar nowDate = Calendar.getInstance();
        if(date.after(nowDate)){
            throw new IllegalArgumentException("the meeting is set for a time in the future");
        }

        allMeetings.add(meetingToAdd);
        return meetingId;
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
