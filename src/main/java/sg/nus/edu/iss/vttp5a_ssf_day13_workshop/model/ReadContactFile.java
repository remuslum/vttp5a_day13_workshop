package sg.nus.edu.iss.vttp5a_ssf_day13_workshop.model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ReadContactFile {
    @Value("${dataDir}")
    private String dataDir;

    public List<Contact> readFile(){
        List<Contact> contacts = new ArrayList<>();
        try {
            BufferedReader br = new BufferedReader(new FileReader(new File(dataDir)));
            String line;
            while((line = br.readLine()) != null){
                Map<String, String> contactPairs = new HashMap<>();
                String[] split1 = line.split(",");
                for(String pair:split1){
                    String[] split2 = pair.split(":");
                    contactPairs.put(split2[0], split2[1]);
                }
                contacts.add(new Contact(contactPairs.get("name"), contactPairs.get("email"), contactPairs.get("phoneNumber"), LocalDate.parse(contactPairs.get("DateOfBirth"))));
            }
            br.close();
        } catch (FileNotFoundException e){
            System.out.println("File Not Found");
        } catch (IOException e){
            System.out.println("FIle cannot be read");
        }
        return contacts;
    }


}
