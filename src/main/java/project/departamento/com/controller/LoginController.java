package project.departamento.com.controller;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import project.departamento.com.entity.Enlace;
import project.departamento.com.entity.Usuario;
import project.departamento.com.service.LoginService;

@Controller
public class LoginController {

	@Autowired
	private LoginService loginService;
	
	 @RequestMapping(value = "/login")
	 public String home() {
		 return "login";
	 }
	 
	@GetMapping(value = "/")
	 public String menu(Authentication auth,Model model, HttpSession session, RedirectAttributes redirect) {
		 String usu = auth.getName();
		 Usuario user = loginService.buscarUsuario(usu);
		 session.setAttribute("usuario", user);
	
		 String fullname = user.getNombres() + " " + user.getApeMaterno();
		 model.addAttribute("fullNameUser", fullname);
		
		 model.addAttribute("rol", user.getRol().getIdRol());
		 model.addAttribute("rolDesc", user.getRol().getDescripcion());
		 
		 
		 return "redirect:/rest/usuario/";

	 }
			
	 
	 
	 
}
