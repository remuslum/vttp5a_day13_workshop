package sg.nus.edu.iss.vttp5a_ssf_day13_workshop.repo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import sg.nus.edu.iss.vttp5a_ssf_day13_workshop.model.Contact;

@Repository
public class ContactRepo {
    List<Contact> contacts;

    public ContactRepo(){
        this.contacts = new ArrayList<>();
    }

    public List<Contact> getContacts(){
        return this.contacts;
    }

    public void addContact(Contact contact){
        this.contacts.add(contact);
    }

    public void deleteContact(Contact contact){
        this.contacts.remove(contact);
    }
}
