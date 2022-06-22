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

import project.departamento.com.entity.Cliente;
import project.departamento.com.entity.Departamento;
import project.departamento.com.entity.Estado;
import project.departamento.com.entity.TipoCliente;
import project.departamento.com.entity.TipoDocumento;
import project.departamento.com.entity.Usuario;
import project.departamento.com.service.ClienteService;

@Controller
@RequestMapping("/rest/cliente")
public class ClienteController {
	//eo
	@Autowired
	private ClienteService service;

	@RequestMapping("/")
	public String index(Model model) {
		model.addAttribute("tabla", service.listarEliminadoactivo(1));
		model.addAttribute("comboTipoDocumento", service.listarTipoDocumento());
		model.addAttribute("comboTipoCliente", service.listarTipoClientes());
		model.addAttribute("comboDepartamento", service.listarDepartamento());
		
		return "cliente";
	}


	@RequestMapping("/registrar")
	public String registrarActualizaCliente(@RequestParam("codigo") int codigo,
			@RequestParam("nombres") String nombre, @RequestParam("apePaterno") String apellidos,
			@RequestParam("tipoDocumento") int tipoDocumento, @RequestParam("documento") String documento,
			@RequestParam("telefono") String telefono,
			@RequestParam("correo") String correo, @RequestParam("tipoCliente") int tipoCliente,
			@RequestParam("sexo") String sexo, @RequestParam("departamento") int departamento,
			@RequestParam("usuario") int usuario, RedirectAttributes redirect) {

		try {
			Optional<Cliente> buscarDocuemento = service.buscarDocumento(documento, codigo);
			Optional<Cliente> buscarCorreo = service.buscarCorreo(correo, codigo);
			Optional<Cliente> buscarclientedepartamento = service.buscarClienteDepartamentoquenoExistan(departamento,
					codigo);
			Optional<Cliente> buscarTelefono = service.buscarTelefono(telefono, codigo);

			if (buscarDocuemento.isPresent()) {
				redirect.addFlashAttribute("existen", "El documento que ingreso ya existe " + documento + " ingrese otro documento.");
			} else if (buscarCorreo.isPresent()) {
				redirect.addFlashAttribute("existen", "El correo que ingreso ya existe " + correo + " ingrese otro correo.");
			} else if (buscarclientedepartamento.isPresent()) {
				redirect.addFlashAttribute("existen", "El departamento que a seleccionado esta ocupado.");
			} else if (buscarTelefono.isPresent()) {
				redirect.addFlashAttribute("existen", "El telefono que ingreso ya existe " + telefono + " ingrese otro telefono.");
			} else {
				Cliente registro = new Cliente();
				registro.setNombres(nombre);
				registro.setApellidos(apellidos);
				registro.setDocumento(documento);
				registro.setTipodocumento(new TipoDocumento(tipoDocumento));
				registro.setTelefono(telefono);
				registro.setEstado(new Estado(3));
				registro.setCorreo(correo);
				registro.setTipoCliente(new TipoCliente(tipoCliente));
				registro.setSexo(sexo);
				registro.setDepartamento(new Departamento(departamento));
				registro.setUsuario(new Usuario(usuario));
				registro.setFechaRegistro(new Date());
				registro.setEliminado(1);
				if (codigo != 0) {
					registro.setIdCliente(codigo);
					service.registrarActualizarCliente(registro);
					redirect.addFlashAttribute("MENSAJE", "Se actualizo el cliente correctamente.");
				} else {
					service.registrarActualizarCliente(registro);
					redirect.addFlashAttribute("MENSAJE", "Se registro el cliente correctamente.");
				}

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return "redirect:/rest/cliente/";
	}

	@RequestMapping("/eliminar")
	public String eliminarCliente(@RequestParam("codigo") int codigo, RedirectAttributes redirect) {

		try {
			service.eliminarCliente(codigo);
			redirect.addFlashAttribute("MENSAJE", "Cliente eliminado");
		} catch (Exception e) {
			e.printStackTrace();
			redirect.addFlashAttribute("MENSAJE", "El cliente esta relacionado, no se puede eliminar.");
		}
		return "redirect:/rest/cliente/";
	}
	
	
	@RequestMapping("/buscar")
	@ResponseBody
	public Cliente buscarCliente(@RequestParam("codigo") int codigo) {
		Cliente bean = null;
		try {
			bean = service.buscarClienteparaactualizar(codigo);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return bean;
	}

}
