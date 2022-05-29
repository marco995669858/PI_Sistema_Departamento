package project.departamento.com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/rest/consulta")
public class ConsultaVisitaController {

	
	@RequestMapping("/")
	public String index() {
		return "VisitaSalida";
	}
	
	
}
