package project.departamento.com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/Principal")
public class HomeController {
	

	
	@RequestMapping("/")
    public String getHomepage() {

			return "Principal";
    }
}
