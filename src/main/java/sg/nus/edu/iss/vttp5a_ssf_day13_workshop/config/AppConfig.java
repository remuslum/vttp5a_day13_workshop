package sg.nus.edu.iss.vttp5a_ssf_day13_workshop.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import sg.nus.edu.iss.vttp5a_ssf_day13_workshop.service.FileManager;

@Configuration
public class AppConfig {
    @Bean
    public FileManager fileManager(){
        return new FileManager();
    }
}
