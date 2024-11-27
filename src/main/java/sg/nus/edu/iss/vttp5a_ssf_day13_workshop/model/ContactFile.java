package sg.nus.edu.iss.vttp5a_ssf_day13_workshop.model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ContactFile {
    private final String dataDir;
    private final String outputFile = "output.txt";
    private static final String extension = ".txt";

    public ContactFile(String dataDir){
        this.dataDir = dataDir;
    }

    public List<Contact> readList() throws IOException{
        List<Contact> contacts = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader(new File(dataDir + File.separator + outputFile)));
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
        return contacts;
    }

    public void writeToFile(List<Contact> contacts) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter(new File(dataDir + File.separator + outputFile)));
        for(Contact contact:contacts){
            bw.write(contact.toString());
            bw.newLine();
        }
        bw.flush();
        bw.close();
    }

    public void writeIndividualContactFile(Contact contact) throws IOException{
        File file = new File(dataDir + File.separator + contact.getId() + extension);
        if(!file.exists()){
            file.createNewFile();
            BufferedWriter bw = new BufferedWriter(new FileWriter(file));
            bw.write(contact.toString());
            bw.newLine();
            bw.flush();
            bw.close();
        }  
    }

    public Contact readIndividualContactFile(String contactId) throws IOException {
        File file = new File(dataDir + File.separator + contactId + extension);
        BufferedReader br = new BufferedReader(new FileReader(file));
        String line;
        Map<String, String> contactPairs = new HashMap<>();
        while((line = br.readLine()) != null){
            String[] split1 = line.split(",");
            for(String pair:split1){
                String[] split2 = pair.split(":");
                contactPairs.put(split2[0], split2[1]);
            }
        }
        return new Contact(contactPairs.get("name"), contactPairs.get("email"), contactPairs.get("phoneNumber"), LocalDate.parse(contactPairs.get("DateOfBirth")));
    }
}
