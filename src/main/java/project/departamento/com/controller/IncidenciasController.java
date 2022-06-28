package project.departamento.com.controller;

import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import project.departamento.com.entity.Cliente;
import project.departamento.com.entity.Departamento;
import project.departamento.com.entity.Estado;
import project.departamento.com.entity.Incidencias;
import project.departamento.com.entity.TipoIncidencias;
import project.departamento.com.entity.Usuario;
import project.departamento.com.service.IncidenciasService;

@Controller
@RequestMapping("/rest/incidencias")
public class IncidenciasController {

	@Autowired
	private IncidenciasService service;

	@RequestMapping("/")
	public String index(Model model) {
		model.addAttribute("combDepartamento", service.listarDepartamento());
		model.addAttribute("comTipIncidencias", service.listarTipoIncidencias());
		model.addAttribute("combCliente", service.listarClientes());
		model.addAttribute("combEstado", service.listarEstadoIncidencias(7, 8, 9));
		model.addAttribute("tbIncidencias", service.listarIncidencias());
		return "incidencias";
	}

	@RequestMapping("/registrar")
	public String registrarIncidencias(@RequestParam("tipoIncidencias") int tipoIncidencias,
			@RequestParam("departamento") int departamento, @RequestParam("comentario") String comentario,
			@RequestParam("informante") int informante, @RequestParam("fecha") Date fecha,
			@RequestParam("usuario") int usuario, RedirectAttributes redirect) {

		try {
			Incidencias bean = new Incidencias();
			bean.setTipoIncidencias(new TipoIncidencias(tipoIncidencias));
			bean.setDepartamento(new Departamento(departamento));
			bean.setEstado(new Estado(8));
			bean.setComentario(comentario);
			bean.setCliente(new Cliente(informante));
			bean.setFechaIncidencia(fecha);
			bean.setUsuario(new Usuario(usuario));
			service.registrarIncidencias(bean);
			redirect.addFlashAttribute("MENSAJE", "Se registro la incidencia correctamente.");
		} catch (Exception e) {
			e.printStackTrace();
		}

		return "redirect:/rest/incidencias/";
	}

	@RequestMapping("/buscar")
	@ResponseBody
	public Incidencias buscarIncidencias(@RequestParam("codigo") int codigo) {
		Incidencias bean = null;
		try {
			bean = service.buscarIncidencias(codigo);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return bean;
	}

	@RequestMapping("/actualizar")
	public String actualizarIncidencias(@RequestParam("tipoincidencias") int codigo,
			@RequestParam("tipIncidentes") int tipoincidente, @RequestParam("depa") int departamento,
			@RequestParam("estadp") int estado, @RequestParam("descripcion") String comentario,
			@RequestParam("usuario") int usuario, RedirectAttributes redirect) {

		try {
			Incidencias buscar = service.buscarIncidencias(codigo);
			buscar.setIdincidente(codigo);
			buscar.setTipoIncidencias(new TipoIncidencias(tipoincidente));
			buscar.setDepartamento(new Departamento(departamento));
			buscar.setEstado(new Estado(estado));
			buscar.setComentario(comentario);
			buscar.setUsuario(new Usuario(usuario));
			service.registrarIncidencias(buscar);
			redirect.addFlashAttribute("MENSAJE", "La incidencia a sido atendida correctamente.");
		} catch (Exception e) {
			e.printStackTrace();
		}

		return "redirect:/rest/incidencias/";
	}
	
	@RequestMapping("/eliminar")
	public String eliminarVisitante(@RequestParam("codigo") int codigo, RedirectAttributes redirect) {

		try {
			service.eliminarIncidencia(codigo);
			redirect.addFlashAttribute("MENSAJE", "Se elimino el incidente");
		} catch (Exception e) {
			e.printStackTrace();
		}

		return "redirect:/rest/incidencias/";
	}
}
