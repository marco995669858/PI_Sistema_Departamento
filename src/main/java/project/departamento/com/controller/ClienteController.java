package project.departamento.com.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
		return "cliente";
	}

	@RequestMapping("/listar")
	public ResponseEntity<List<Cliente>> listarClientes() {
		List<Cliente> salida = service.listarTodoslosClientes();
		return ResponseEntity.ok(salida);

	}

	@RequestMapping("/registrar")
	public ResponseEntity<Map<String, Object>> registrarActualizaCliente(@RequestParam("codigo") int codigo,
			@RequestParam("nombre") String nombre, @RequestParam("apellidos") String apellidos,
			@RequestParam("documento") String documento, @RequestParam("tipoDocumento") int tipoDocumento,
			@RequestParam("telefono") String telefono, @RequestParam("estado") int estado,
			@RequestParam("correo") String correo, @RequestParam("tipoCliente") int tipoCliente,
			@RequestParam("sexo") String sexo, @RequestParam("departamento") int departamento,
			@RequestParam("usuario") int usuario) {

		Map<String, Object> salida = new HashMap<>();
		try {
			Optional<Cliente> buscarDocuemento = service.buscarDocumento(documento, codigo);
			Optional<Cliente> buscarCorreo = service.buscarCorreo(correo, codigo);
			Optional<Cliente> buscarclientedepartamento = service.buscarClienteDepartamentoquenoExistan(departamento,
					codigo);
			Optional<Cliente> buscarTelefono = service.buscarTelefono(telefono, codigo);

			if (buscarDocuemento.isPresent()) {
				salida.put("existen", "El documento que ingreso ya existe " + documento + " ingrese otro documento.");
			} else if (buscarCorreo.isPresent()) {
				salida.put("Existen", "El correo que ingreso ya existe " + correo + " ingrese otro correo.");
			} else if (buscarclientedepartamento.isPresent()) {
				salida.put("Existen", "El departamento que a seleccionado esta ocupado.");
			} else if (buscarTelefono.isPresent()) {
				salida.put("Existen", "El telefono que ingreso ya existe " + telefono + " ingrese otro telefono.");
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
				registro.setEliminado(0);
				if (codigo != 0) {
					registro.setIdCliente(codigo);
					service.registrarActualizarCliente(registro);
					salida.put("MENSAJE", "Se actualizo el cliente correctamente.");
				} else {
					service.registrarActualizarCliente(registro);
					salida.put("MENSAJE", "Se registro el cliente correctamente.");
				}

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return ResponseEntity.ok(salida);
	}

	@RequestMapping("/eliminar")
	public ResponseEntity<Map<String, Object>> eliminarCliente(@RequestParam("codigo") int codigo) {

		Map<String, Object> salida = new HashMap<>();

		try {

			List<Cliente> buscarIdcliente = service.buscarClienteporid(codigo);
			if (CollectionUtils.isEmpty(buscarIdcliente)) {

				salida.put("MENSAJE", "El codigo esta eliminado o ingreso un codigo erroneo");

			} else {

				service.eliminarCliente(codigo);
				salida.put("MENSAJE", "El cliente se elimino exitosamente");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return ResponseEntity.ok(salida);
	}

}
