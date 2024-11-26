package sg.nus.edu.iss.vttp5a_ssf_day13_workshop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import sg.nus.edu.iss.vttp5a_ssf_day13_workshop.model.Contact;
import sg.nus.edu.iss.vttp5a_ssf_day13_workshop.service.ContactRedisService;
import sg.nus.edu.iss.vttp5a_ssf_day13_workshop.util.ContactKey;
@Controller
@RequestMapping("/contact")
public class ContactList {
    
    @Autowired
    ContactRedisService contactRedisService;

    @GetMapping("/list")
    public String contactList(Model model){
        List<Contact> contacts = contactRedisService.getContactList(ContactKey.KEY);
        model.addAttribute("contacts", contacts);
        return "ContactList";
    }
}
