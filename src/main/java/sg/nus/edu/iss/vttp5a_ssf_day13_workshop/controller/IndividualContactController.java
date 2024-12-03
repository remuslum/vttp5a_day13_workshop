package sg.nus.edu.iss.vttp5a_ssf_day13_workshop.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import sg.nus.edu.iss.vttp5a_ssf_day13_workshop.model.Contact;
import sg.nus.edu.iss.vttp5a_ssf_day13_workshop.service.ContactService;

@Controller
@RequestMapping("/contact")
public class IndividualContactController {

    @Value("${dataDir}")
    private String dataDir;
    
    @Autowired
    ContactService contactService;

    @GetMapping("/linkpage")
    public String displayListofContacts(Model model){
        File folder = new File(dataDir);
        File[] files = folder.listFiles();
        List<String> fileName = new ArrayList<>();
        for(File file:files){
            if(file.getName().contains(".txt")){
                fileName.add(file.getName().substring(0, file.getName().length() - 4));
            }
        }
        model.addAttribute("files", fileName);
        return "LinkPage";
    }

    @GetMapping("/{contact-identifier}")
    public String findIndividualContact(@PathVariable("contact-identifier") String contactId, Model model) throws IOException{
        try {
            Contact contact = contactService.readIndividualContactFile(contactId);
            model.addAttribute("contact", contact);
            return "Contacts";
        } catch (FileNotFoundException e) {
            System.out.println("Contact does not exist");
            return "redirect:/contact/list";
        }
    }
}
