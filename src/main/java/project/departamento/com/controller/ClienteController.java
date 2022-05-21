package project.departamento.com.controller;

import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

	@Autowired
	private ClienteService service;

	@RequestMapping("/")
	public String index(Model model) {
		return "Usuario";
	}

	@RequestMapping("/registrar")
	public String registrarActualizaCliente(@RequestParam("codigo") int codigo, @RequestParam("nombre") String nombre,
			@RequestParam("apellidos") String apellidos, @RequestParam("documento") String documento,
			@RequestParam("tipoDocumento") int tipoDocumento, @RequestParam("telefono") String telefono,
			@RequestParam("estado") int estado, @RequestParam("correo") String correo,
			@RequestParam("tipoCliente") int tipoCliente, @RequestParam("sexo") String sexo,
			@RequestParam("departamento") int departamento, @RequestParam("usuario") int usuario,
			RedirectAttributes redirect) {

		try {
			Optional<Cliente> buscarDocuemento = service.buscarDocumento(documento);
			Optional<Cliente> buscarCorreo = service.buscarCorreo(correo);
			Optional<Cliente> buscarclientedepartamento = service.buscarClienteDepartamentoquenoExistan(departamento);
			Optional<Cliente> buscarTelefono = service.buscarTelefono(telefono);

			if (buscarDocuemento.isPresent()) {
				redirect.addFlashAttribute("Existen",
						"El documento que ingreso ya existe " + documento + " ingrese otro documento.");
			} else if (buscarCorreo.isPresent()) {
				redirect.addFlashAttribute("Existen",
						"El correo que ingreso ya existe " + correo + " ingrese otro correo.");
			} else if (buscarclientedepartamento.isPresent()) {
				redirect.addFlashAttribute("Existen",
						"Existe un cliente registrado en el departamento " + departamento);
			} else if (buscarTelefono.isPresent()) {
				redirect.addFlashAttribute("Existen",
						"El telefono que ingreso ya existe " + telefono + " ingrese otro telefono.");
			} else {
				Cliente registro = new Cliente();
				registro.setNombres(nombre);
				registro.setApellidos(apellidos);
				registro.setDocumento(documento);
				registro.setTipodocumento(new TipoDocumento(tipoDocumento));
				registro.setTelefono(telefono);
				registro.setEstado(new Estado(1));
				registro.setCorreo(correo);
				registro.setTipoCliente(new TipoCliente(tipoCliente));
				registro.setSexo(sexo);
				registro.setDepartamento(new Departamento(departamento));
				registro.setUsuario(new Usuario(usuario));
				registro.setFechaRegistro(new Date());
				registro.setEliminado(0);
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

}
