package project.departamento.com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/rest/controlvisita")
public class ControlVisitaController {
	
	@RequestMapping
	public String index() {
		return "visita";
	}

}
