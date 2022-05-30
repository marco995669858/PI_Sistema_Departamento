package project.departamento.com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import project.departamento.com.entity.Estado;
import project.departamento.com.entity.Usuario;
import project.departamento.com.entity.Visita;
import project.departamento.com.service.ConsultaVisitaService;

@Controller
@RequestMapping("/rest/consulta")
public class ConsultaVisitaController {

	@Autowired
	private ConsultaVisitaService service;

	@RequestMapping("/")
	public String index(Model model) {
		model.addAttribute("comboVisitante", service.listarVisitante());
		model.addAttribute("comboCliente", service.listarCliente());
		model.addAttribute("comboEstado", service.listarEstado(5, 6));
		return "VisitaSalida";
	}

	@RequestMapping("/consultaVisitante")
	@ResponseBody
	public List<Visita> listarmascotasporparametros(
			@RequestParam(name = "visita", required = false, defaultValue = "-1") int visita,
			@RequestParam(name = "cliente", required = false, defaultValue = "-1") int cliente,
			@RequestParam(name = "estado", required = false, defaultValue = "-1") int estado) {
		List<Visita> lista = service.consultaVisita(visita, cliente, estado);
		return lista;
	}
	
	@RequestMapping("/buscar")
	@ResponseBody
	public Visita buscarVisitaporCodigo(@RequestParam("codigo") int codigo) {
		Visita buscar = null;
		try {
			buscar = service.buscarporCodigo(codigo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return buscar;
	}

	@RequestMapping("/actualizarFechaSalida")
	public String actulizarControlVisitante(@RequestParam("codigo") int codigo,@RequestParam("usuario") int usuario,
			@RequestParam("fechaSalida") String fechaSalida, @RequestParam("comentario") String comentario,
			RedirectAttributes redirect) {
		
		try {
			Visita visita = service.buscarporCodigo(codigo);
			visita.setUsuario(new Usuario(usuario));
			visita.setHoraSalida(fechaSalida);
			visita.setEstado(new Estado(5));
			visita.setComentario(comentario);
			service.actualizarVistaFecheSalida(visita);
			redirect.addFlashAttribute("MENSAJE", "Se actualizo la salida del visitante.");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "redirect:/rest/consulta/";
	}

}
