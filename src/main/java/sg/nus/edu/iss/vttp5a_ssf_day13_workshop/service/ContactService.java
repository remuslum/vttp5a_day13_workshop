package sg.nus.edu.iss.vttp5a_ssf_day13_workshop.service;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sg.nus.edu.iss.vttp5a_ssf_day13_workshop.model.Contact;
import sg.nus.edu.iss.vttp5a_ssf_day13_workshop.repo.ContactRepo;

@Service
public class ContactService {
    
    @Autowired
    ContactRepo contactRepo;

    public List<Contact> getContacts(String dataDir) throws IOException{
        return contactRepo.getContacts(dataDir);
    }

    public void addContact(Contact contact){
        contactRepo.addContact(contact);
    }

    public void deleteContact(Contact contact){
        contactRepo.deleteContact(contact);
    }

    public void saveContacts(List<Contact> contacts, String dataDir) throws IOException {
        contactRepo.saveContacts(contacts, dataDir);
    }
}
