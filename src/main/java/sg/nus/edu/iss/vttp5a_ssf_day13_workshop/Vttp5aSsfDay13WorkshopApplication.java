package sg.nus.edu.iss.vttp5a_ssf_day13_workshop;

import java.io.IOException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Vttp5aSsfDay13WorkshopApplication {

	public static void main(String[] args) throws IOException{
		SpringApplication app = new SpringApplication(Vttp5aSsfDay13WorkshopApplication.class);
		// ApplicationArguments argsOptions = new DefaultApplicationArguments(args);
		// String dirPath;

		// if(argsOptions.containsOption("dataDir")){
		// 	dirPath = argsOptions.getOptionValues("dataDir").get(0);

		// 	File file = new File(dirPath);
		// 	if(!file.exists()){
		// 		file.createNewFile();
		// 		System.out.println("File created");
		// 	} else {
		// 		System.out.println("File already created");
		// 	}
		// } else {
		// 	System.out.println("No --dataDir argument provided");
		// 	System.exit(1);
		// }
		app.run(args);
	}
}

