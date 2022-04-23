package project.departamento.com.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import project.departamento.com.entity.Usuario;
import project.departamento.com.service.LoginService;
import project.departamento.com.util.EncryptPassword;
@Controller
@RequestMapping("/login")
public class LoginController {
	@Autowired
	private LoginService loginService;
	@Autowired 
	private EncryptPassword encryptPassword;

	@RequestMapping("/")
	public String Index(Model model) {
		return "login";
	}
	
	@RequestMapping("/verificar")
	public String Verificar(String gmail, String password, HttpSession session, HttpServletRequest request) {
		Usuario usuario = loginService.buscarUsuario(gmail);
		if(usuario == null) {
			request.setAttribute("mensaje", "El Usuario no existe");
			System.out.println("El Usuario no existe");
			return "login";
		}else {
			boolean passCheck = encryptPassword.VerificarPassword(password, usuario.getPasswords());
			if(passCheck == true) {
				session.setAttribute("objUsuario", usuario);
				
				return  "cliente";
			}else {
				request.setAttribute("mensaje", "Contraseña Incorrecta");
				System.out.println("Contraseña Incorrecta");
				
				return "login";
			}
		}
	}
	
	@RequestMapping("/logout")
	public String logout(HttpSession session, HttpServletRequest request, HttpServletResponse response) {
		session.invalidate();

		response.setHeader("Cache-control", "no-cache");
		response.setHeader("Expires", "0");
		response.setHeader("Pragma", "no-cache");

		request.setAttribute("mensaje", "El usuario salió de sesión");
		return "login";

	}
	 
}
