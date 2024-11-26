package sg.nus.edu.iss.vttp5a_ssf_day13_workshop.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/data")
public class DataController {
    @Value("${dataDir:No value provided}")
    private String dataDir;

    @GetMapping
    public String showDataDir(Model model){
        model.addAttribute("dataDir", dataDir);
        return "DataDirPage";
    }
}
