package project.departamento.com.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

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
	 

	 
	 @RequestMapping(value = "/Ingresar")
		public String menu(Authentication auth,HttpServletRequest  request) {	
			// recuperar nombre del usuario
			String nomUsu = auth.getName();
			// invocar al metodo "iniciarsession"
			Usuario bean = loginService.buscarUsuario(nomUsu);
			// traer enlace segun el rol
			List<Enlace> lista = loginService.traenEnlaces(bean.getRol().getIdRol());
			HttpSession session = request.getSession();
			session.setAttribute("menus", lista);
			session.setAttribute("usuario", bean);
			
			return "redirect:/Principal/";
		}
			
	 
	 
	 
}
