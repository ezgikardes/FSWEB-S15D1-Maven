package org.example.mobile;

import java.util.ArrayList;
import java.util.List;

public class MobilePhone {
    private String myNumber;
    private List<Contact> myContacts; //

    public MobilePhone(String myNumber, List<Contact> myContacts) {
        this.myNumber = myNumber;
        this.myContacts = myContacts != null ? myContacts : new ArrayList<>();
        //constructor'da listeyi başlatmasaydık nullPointerException hatası alırdık.
    }

    public String getMyNumber() {
        return myNumber;
    }

    public void setMyNumber(String myNumber) {
        this.myNumber = myNumber;
    }

    public List<Contact> getMyContacts() {
        return myContacts;
    }

    public void setMyContacts(ArrayList<Contact> myContacts) {
        this.myContacts = myContacts;
    }

    public boolean addNewContact(Contact contact){
        if (!myContacts.contains(contact)){
            myContacts.add(contact);
            return true;
        } return false;
    }

    public boolean updateContact(Contact oldContact, Contact newContact){
        return true;
    }

    public boolean removeContact(Contact contact){
        if(myContacts.contains(contact)){
            myContacts.remove(contact);
            return true;
        } return false;
    }

    public int findContact(Contact contact){
        if (myContacts.contains(contact)){
            return myContacts.indexOf(contact);
        } return -1;
    }

    public int findContact(String name){
        for(int i = 0; i<myContacts.size(); i++){
            if (myContacts.get(i).getName().equals(name)){
                return i;
            }
        }
        return -1;
    }


    public Contact queryContact(String name){
        for(int i = 0; i<myContacts.size(); i++){
            if (myContacts.get(i).getName().equals(name)){
                return myContacts.get(i);
            }
        }
        return null;
    }

    public void printContact(){
        for(int i = 0; i < myContacts.size(); i++){
            Contact currentContact = myContacts.get(i);
            System.out.println(currentContact.getName() + " ->" + currentContact.getPhoneNumber());
        }
    }

}
