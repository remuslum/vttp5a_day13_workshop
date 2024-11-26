package sg.nus.edu.iss.vttp5a_ssf_day13_workshop.repo;

import java.io.IOException;
import java.util.List;

import org.springframework.stereotype.Repository;

import sg.nus.edu.iss.vttp5a_ssf_day13_workshop.model.Contact;
import sg.nus.edu.iss.vttp5a_ssf_day13_workshop.model.ContactFile;

@Repository
public class ContactRepo {
    List<Contact> contacts;

    public List<Contact> getContacts(String dataDir) throws IOException{
        this.contacts = new ContactFile(dataDir).readList();
        return contacts;
    }

    public void addContact(Contact contact){
        this.contacts.add(contact);
    }

    public void deleteContact(Contact contact){
        this.contacts.remove(contact);
    }

    public void saveContacts(List<Contact> contacts, String dataDir) throws IOException{
        ContactFile fileManager = new ContactFile(dataDir);
        fileManager.writeToFile(contacts);
    }
}
