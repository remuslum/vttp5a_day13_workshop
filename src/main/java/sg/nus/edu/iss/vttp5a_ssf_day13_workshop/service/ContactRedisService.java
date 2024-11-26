package sg.nus.edu.iss.vttp5a_ssf_day13_workshop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sg.nus.edu.iss.vttp5a_ssf_day13_workshop.model.Contact;
import sg.nus.edu.iss.vttp5a_ssf_day13_workshop.repo.ContactsRedis;

@Service
public class ContactRedisService {
    
    @Autowired
    ContactsRedis contactRedis;

    public List<Contact> getContactList(String key){
        return contactRedis.getContactList(key);
    }

    public void addContact(String key, Contact contact){
        contactRedis.addContact(key, contact);
    }

    public Contact findContact(String key, String identifier){
        return contactRedis.findContact(key, identifier); 
    }

    public void removeContact(String key, Contact contact){
        contactRedis.removeContact(key, contact);
    }

    public void updateContact(String key, Contact contact){
        contactRedis.updateContact(key, contact);
    }
}
