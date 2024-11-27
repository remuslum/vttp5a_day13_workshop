package sg.nus.edu.iss.vttp5a_ssf_day13_workshop.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import sg.nus.edu.iss.vttp5a_ssf_day13_workshop.model.Contact;
import sg.nus.edu.iss.vttp5a_ssf_day13_workshop.service.ContactService;

@Controller
@RequestMapping("/contact")
public class ContactList {

    @Autowired
    ContactService contactService;

    @GetMapping("/list")
    public String contactList(Model model) throws IOException{
        List<Contact> contacts = contactService.getContacts();
        model.addAttribute("contacts", contacts);
        return "ContactList";
    }

    @GetMapping("/save")
    public String saveContactList(Model model) throws IOException{
        List<Contact> contacts = contactService.getContacts();
        contactService.saveContacts(contacts);
        return "redirect:/contact/list";
    }

    @GetMapping("/save/{contact-identifier}")
    public String saveIndividualContact(@PathVariable("contact-identifier") String contactId) throws IOException{
        List<Contact> contacts = contactService.getContacts();
        Contact temp = new Contact();
        for(Contact contact:contacts){
            if(contact.getId().equals(contactId)){
                temp = contact;
                break;
            }
        }
        contactService.saveIndividualContact(temp);
        return "redirect:/contact/list";
    }
}
