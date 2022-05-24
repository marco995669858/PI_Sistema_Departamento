package project.departamento.com.controller;

import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import project.departamento.com.entity.Departamento;
import project.departamento.com.entity.Estado;
import project.departamento.com.entity.TipoDepartamento;
import project.departamento.com.entity.Usuario;
import project.departamento.com.service.DepartamentoService;

@Controller
@RequestMapping("/rest/departamento")
public class DepartamentoController {
	
	@Autowired
	private DepartamentoService service;
	
	@RequestMapping("/")
	public String index(Model model) {
		model.addAttribute("tipodepartamento", service.listarTipoDepartamento());
		model.addAttribute("listaDepartamento", service.DepartamentosActivos(1));
		return "departamento";
	}
	
	@RequestMapping("/registrar")
	public String registraActualizaDepartamento(@RequestParam("codigo") int codigo,@RequestParam("tipoDepartamento") int tipoDepartamento,
												@RequestParam("piso") String piso,@RequestParam("nroDepartamento") String nroDepartamento,
												@RequestParam("nroHabitaciones") int nroHabitaciones,RedirectAttributes redirect) {
		 try {
			
			 Optional<Departamento> buscarNrodepartamento = service.buscarNroDepartamento(nroDepartamento);
			 if(buscarNrodepartamento.isPresent()) {
				 redirect.addFlashAttribute("existen", "El numero del departamento ya existe ingrese otro numero.");
			 }else {
				 Departamento bean = new Departamento();
				 bean.setTipoDepartamento(new TipoDepartamento(tipoDepartamento));
				 bean.setPiso(piso);
				 bean.setNroDepartamento(nroDepartamento);
				 bean.setNroHabitaciones(nroHabitaciones);
				 bean.setUsuario(new Usuario(1));
				 bean.setFecharegistro(new Date());
				 bean.setEstado(new Estado(2));
				 bean.setEliminado(1);
				 if(codigo != 0) {
					 bean.setIdDepartamento(codigo);
					 service.registraActualizaDepartamento(bean);
					 redirect.addFlashAttribute("MENSAJE", "Se actualizo el departamento correctamente");
				 }else {
					 service.registraActualizaDepartamento(bean);
					 redirect.addFlashAttribute("MENSAJE", "Se registro el departamento correctamente");
					 
				 }
			 }
			 
		} catch (Exception e) {
			e.printStackTrace();
		}
		 return "redirect:/rest/departamento/";
	}
	
	@RequestMapping("/eliminar")
	public String eliminar(@RequestParam("codigo") int codigo, RedirectAttributes redirect) {
		try {
			Departamento bean = service.buscarDepartamentoporcodigo(codigo);
			bean.setEliminado(0);
			service.eliminarDepartamento(bean);
			redirect.addFlashAttribute("MENSAJE", "Departamento eliminado");
		} catch (Exception e) {
			
		}
		return  "redirect:/rest/departamento/";
	}
	
	@RequestMapping(value = "/buscar")
	@ResponseBody
	public Departamento buscar(@RequestParam("idDepartamento") int cod) {
		Departamento bean=null;
		try {
			bean=service.buscarDepartamentoporcodigo(cod);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return bean;
	}
}
