package sg.nus.edu.iss.vttp5a_ssf_day13_workshop.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.validation.Valid;
import sg.nus.edu.iss.vttp5a_ssf_day13_workshop.model.Contact;
import sg.nus.edu.iss.vttp5a_ssf_day13_workshop.service.ContactRedisService;
import sg.nus.edu.iss.vttp5a_ssf_day13_workshop.util.ContactKey;

@Controller
@RequestMapping("/contact")
public class CreateContactController {

    @Autowired
    ContactRedisService contactRedisService;

    @GetMapping()
    public String creatContactForm(Model model){
        model.addAttribute("contact", new Contact());
        return "CreateContact";
    }
    
    @PostMapping()
    public String createContact(@Valid Contact contact, BindingResult bindingResult) throws IOException{
        if(bindingResult.hasErrors()){
            return "CreateContact";
        } else {
            Contact c = new Contact(contact.getName(), contact.getEmail(), contact.getPhoneNumber(), contact.getDateOfBirth());
            contactRedisService.addContact(ContactKey.KEY, c);
            // FileManager fileManager = new FileManager();
            // fileManager.writeToFile(contactService.getContacts());
            return "redirect:/contact/list";
        }
    }
    
}
