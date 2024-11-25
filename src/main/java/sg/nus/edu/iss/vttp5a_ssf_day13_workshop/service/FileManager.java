package sg.nus.edu.iss.vttp5a_ssf_day13_workshop.service;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import sg.nus.edu.iss.vttp5a_ssf_day13_workshop.model.Contact;

@Service
public class FileManager {
    
    @Value("${dataDir:contacts.txt}")
    private String dirPath;
    
    public void writeToFile(List<Contact> contacts) throws IOException{
        BufferedWriter bw = new BufferedWriter(new FileWriter(new File(dirPath)));
        for(Contact contact:contacts){
            bw.write(contact.toString());
            bw.newLine();
        }
        bw.flush();
        bw.close();
    }


}
