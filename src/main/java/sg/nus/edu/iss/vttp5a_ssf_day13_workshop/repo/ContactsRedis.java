package sg.nus.edu.iss.vttp5a_ssf_day13_workshop.repo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import sg.nus.edu.iss.vttp5a_ssf_day13_workshop.model.Contact;

@Repository
public class ContactsRedis {
    
    @Autowired
    @Qualifier("Contact")
    private RedisTemplate<String, Contact> redisTemplate;

    public List<Contact> getContactList(String key){
        return redisTemplate.opsForList().range(key, 0, -1);
    }

    public void addContact(String key, Contact contact){
        redisTemplate.opsForList().rightPush(key, contact);
    }

    public Contact findContact(String key, String identifier){
        List<Contact> contacts = getContactList(key);
        Contact temp = new Contact();
        for(Contact contact:contacts){
            if(contact.getId().equals(identifier)){
                temp = contact;
                break;
            }
        }
        return temp;
    }

    public void removeContact(String key, Contact contact){
        redisTemplate.opsForList().remove(key, 1, contact);
    }

    public void updateContact(String key, Contact contact){
        Contact currentContact = findContact(key, contact.getId());
        if(currentContact != null){
            removeContact(key, currentContact);
            addContact(key, contact);
        }
    }
}
