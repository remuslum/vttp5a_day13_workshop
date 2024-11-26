package sg.nus.edu.iss.vttp5a_ssf_day13_workshop.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import sg.nus.edu.iss.vttp5a_ssf_day13_workshop.model.Contact;
import sg.nus.edu.iss.vttp5a_ssf_day13_workshop.service.ContactService;

@Controller
@RequestMapping("/contact")
public class ContactList {
    @Value("${dataDir}")
    private String dataDir;
    
    @Autowired
    ContactService contactService;

    @GetMapping("/list")
    public String contactList(Model model) throws IOException{
        List<Contact> contacts = contactService.getContacts(dataDir);
        model.addAttribute("contacts", contacts);
        return "ContactList";
    }
}
