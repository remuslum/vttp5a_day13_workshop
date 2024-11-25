package sg.nus.edu.iss.vttp5a_ssf_day13_workshop.model;

import java.time.LocalDate;
import java.util.UUID;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import sg.nus.edu.iss.vttp5a_ssf_day13_workshop.validation.ValidDate;

public class Contact {

    private String id;

    @NotBlank(message = "Name cannot be empty")
    @Size(min = 3, max = 64, message = "Name must be between 3 and 64")
    private String name;

    @NotBlank(message = "Email cannot be empty")
    @Email(message = "Email does not conform to email format")
    private String email;

    @NotBlank(message = "Phone number cannot be empty")
    @Pattern(regexp = "(8|9)[0-9]{6}", message = "Phone number must start with 8 or 9 followed by 6 digits")
    private String phoneNumber;

    @Past(message = "Date of Birth must be in the past")
    @ValidDate
    private LocalDate dateOfBirth;

    public Contact(){

    }

    public Contact(String name, String email, String phoneNumber, LocalDate dateOfBirth) {
        this.id = UUID.randomUUID().toString().replace("-","").substring(0,8);
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.dateOfBirth = dateOfBirth;
    } 
    
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPhoneNumber() {
        return phoneNumber;
    }
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }
    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString(){
        return "Id:" + this.id + ",name:" + this.name + ",email:" + this.email + ",phoneNumber:" + this.phoneNumber + ",DateOfBirth:" + this.dateOfBirth;
    }

    
}
