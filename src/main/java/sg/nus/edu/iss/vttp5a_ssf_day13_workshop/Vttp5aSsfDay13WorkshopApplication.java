package sg.nus.edu.iss.vttp5a_ssf_day13_workshop;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.DefaultApplicationArguments;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Vttp5aSsfDay13WorkshopApplication {

	public static void main(String[] args) throws IOException{
		SpringApplication app = new SpringApplication(Vttp5aSsfDay13WorkshopApplication.class);
		ApplicationArguments argsOptions = new DefaultApplicationArguments(args);
		String dirPath;

		if(!argsOptions.containsOption("dataDir")){
			System.err.println("Error; --dataDir argument is required");
			System.exit(1);
		}
		dirPath = argsOptions.getOptionValues("dataDir").get(0);
		Path pathOfDir = Paths.get(dirPath);
		if(!Files.exists(pathOfDir)){
			Files.createFile(pathOfDir);
		}
		app.run(args);
		// SpringApplication.run(Vttp5aSsfDay13WorkshopApplication.class, args);
	}

	@Bean
	public String dirPath(){
		return System.getProperty("dataDir");
	}

}
