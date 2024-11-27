package sg.nus.edu.iss.vttp5a_ssf_day13_workshop.repo;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import jakarta.annotation.PostConstruct;
import sg.nus.edu.iss.vttp5a_ssf_day13_workshop.model.Contact;
import sg.nus.edu.iss.vttp5a_ssf_day13_workshop.model.ContactFile;

@Repository
public class ContactRepo {

    @Value("${dataDir}")
    private String dataDir;

    List<Contact> contacts;

    @PostConstruct
    public void init() throws IOException{
        this.contacts = getContacts(dataDir);
    }

    private List<Contact> getContacts(String dataDir) throws IOException{
        this.contacts = new ContactFile(dataDir).readList();
        return contacts;
    }

    public void addContact(Contact contact){
        this.contacts.add(contact);
    }

    public void deleteContact(Contact contact){
        this.contacts.remove(contact);
    }

    public List<Contact> getContacts(){
        return this.contacts;
    }

    public void saveContacts(List<Contact> contacts) throws IOException{
        ContactFile fileManager = new ContactFile(dataDir);
        fileManager.writeToFile(contacts);
    }

    public void saveIndividualContact(Contact contact) throws IOException{
        ContactFile fileManager = new ContactFile(dataDir);
        fileManager.writeIndividualContactFile(contact);
    }

    public Contact readIndividualContactFile(String contactId) throws IOException{
        return new ContactFile(dataDir).readIndividualContactFile(contactId);
    }
}
