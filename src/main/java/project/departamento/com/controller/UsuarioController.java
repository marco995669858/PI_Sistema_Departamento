package project.departamento.com.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import project.departamento.com.entity.Rol;
import project.departamento.com.entity.Usuario;
import project.departamento.com.service.UsuarioService;

@RestController
@RequestMapping("/res/usuario")
public class UsuarioController {

	@Autowired
	private UsuarioService service;

	@RequestMapping("/")
	public String index() {
		return "usuario";
	}

	@RequestMapping("/")
	public ResponseEntity<Map<String, Object>> registraActualizaUsaurio(@RequestParam("codigo") int codigo,
			@RequestParam("nombreUsuario") String nombreUsuario, @RequestParam("nombres") String nombres,
			@RequestParam("apePaterno") String apePaterno, @RequestParam("apeMaterno") String apeMaterno,
			@RequestParam("correo") String correo, @RequestParam("password") String password,
			@RequestParam("telefono") String telefono, @RequestParam("rol") int rol,
			@RequestParam("fechaRegistro") Date fechaRegistro) {
		
			Map<String, Object> salida = new HashMap<>();
		try {

			Optional<Usuario> buscarCorreo = service.buscarCorreo(correo);
			Optional<Usuario> buscarTelefono = service.buscarTelefono(telefono);
			if (buscarCorreo.isPresent()) {
				salida.put("existen", "El correo que ingreso ya exite " + correo + " ingrese otro.");
			} else if (buscarTelefono.isPresent()) {
				salida.put("existen",
						"El tefelono que ingreso ya exites" + telefono + " ingrese otro.");
			} else {

				Usuario registro = new Usuario();
				registro.setNomUsuario(nombreUsuario);
				registro.setNombres(nombres);
				registro.setApePaterno(apePaterno);
				registro.setApeMaterno(apeMaterno);
				registro.setCuentaUsuario(correo);
				registro.setPasswordUsuario(password);
				registro.setRol(new Rol(rol));
				registro.setFechaRegistro(new Date());
				registro.setEliminado(0);
				if (codigo != 0) {
					registro.setIdUsuario(codigo);
					service.registrarActualizaUsuario(registro);
					salida.put("MENSAJE", "Se registro el usuario correctamente");
				} else {
					service.registrarActualizaUsuario(registro);
					salida.put("MENSAJE", "Se registro el usuario correctamente");
				}

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return ResponseEntity.ok(salida);
	}
}
