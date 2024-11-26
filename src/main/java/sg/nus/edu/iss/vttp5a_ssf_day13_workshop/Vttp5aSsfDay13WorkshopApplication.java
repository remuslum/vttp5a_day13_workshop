package sg.nus.edu.iss.vttp5a_ssf_day13_workshop;

import java.io.IOException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Vttp5aSsfDay13WorkshopApplication {

	public static void main(String[] args) throws IOException{
		// SpringApplication app = new SpringApplication(Vttp5aSsfDay13WorkshopApplication.class);
		// ApplicationArguments argsOptions = new DefaultApplicationArguments(args);
		// String dirPath;

		// if(!argsOptions.containsOption("dataDir")){
		// 	System.err.println("Error; --dataDir argument is required");
		// 	System.exit(1);
		// }
		// dirPath = argsOptions.getOptionValues("dataDir").get(0);
		// Path pathOfDir = Paths.get(dirPath);
		// if(!Files.exists(pathOfDir)){
		// 	Files.createFile(pathOfDir);
		// }
		// app.run(args);

		SpringApplication.run(Vttp5aSsfDay13WorkshopApplication.class, args);
		
	}
}


