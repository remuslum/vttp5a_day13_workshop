package sg.nus.edu.iss.vttp5a_ssf_day13_workshop.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.validation.Valid;
import sg.nus.edu.iss.vttp5a_ssf_day13_workshop.model.Contact;
import sg.nus.edu.iss.vttp5a_ssf_day13_workshop.service.ContactService;

@Controller
@RequestMapping("/contact")
public class CreateContactController {
    @Value("${dataDir}")
    private String dataDir;

    @Autowired
    ContactService contactService;

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
            contactService.addContact(c);
            System.out.println(contactService.getContacts(dataDir));
            contactService.saveContacts(contactService.getContacts(dataDir), dataDir);
            // FileManager fileManager = new FileManager();
            // fileManager.writeToFile(contactService.getContacts());
            return "redirect:/contact/list";
        }
    }
    
}
