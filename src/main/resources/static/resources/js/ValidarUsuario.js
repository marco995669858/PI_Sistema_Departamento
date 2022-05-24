function mensaje(msj) {
	const Toast = Swal.mixin({
		toast: true,
		position: 'top-end',
		showConfirmButton: false,
		timer: 3000,
		timerProgressBar: true,
		didOpen: (toast) => {
			toast.addEventListener('mouseenter', Swal.stopTimer)
			toast.addEventListener('mouseleave', Swal.resumeTimer)
		}
	})

	Toast.fire({
		icon: 'error',
		title: msj
	})
}




function validarUsuario() {


    let nombreUsuario = document.getElementById("idNomusuario").value;
	let nombre = document.getElementById("idNombres").value;
	let apellidoPaterno = document.getElementById("idapePaterno").value;
	let apellidoMaterno = document.getElementById("idapeMaterno").value;
	var correo = document.getElementById("idCuentausuario").value;
	var contraseña = document.getElementById("idPassword").value;
	var telefono = document.getElementById("idTelefono").value;
	
		//var dni = document.getElementById("idDni").value;

	var regexcorreo = /^\w+@\w+\.+[a-z]{2,3}$/;
	var regexnombre = /^[A-Za-zƒŠŒŽšœžñŸÀÁÂÃÄÅÆÈÉÊËÌÍÎÏÑÒÓÔÕÖØÙÚÛÜÝàáâãäåæçèé êëìíîïðñòóôõöùúûüýþÿ]*$/;

	if (!nombreUsuario || !nombre || !apellidoPaterno || !apellidoMaterno || !correo || !contraseña || !telefono) {
		mensaje("Todos los campos son obligatorios");
		return false;
		
		} else if (nombreUsuario.length < 3 || nombreUsuario.length > 30) {
		mensaje('El Nombre de Usuario debe tener minimo 3 caracteres');
		return false;
		
		
	} else if (nombre.length < 3 || nombre.length >= 30) {
		mensaje('El nombre solo acepta como minimo 3 y maximo 30.');
		return false;
	} else if (!regexnombre.test(nombre)) {
		mensaje('Ingrese solo letras.');
		return false;
		
	} else if (apellidoPaterno.length < 3 || apellidoPaterno.length >= 30) {
		mensaje('El apellido paterno solo acepta como minimo 3 y maximo 30.');
		return false;
	} else if (!regexnombre.test(apellidoPaterno)) {
		mensaje('Ingrese solo un apellido paterno, tampoco se acepta espacios en blanco.');
		return false;
		} else if (apellidoMaterno.length < 3 || apellidoMaterno.length >= 30) {
		mensaje('El apellido paterno solo acepta como minimo 3 y maximo 30.');
		return false;
	} else if (!regexnombre.test(apellidoMaterno)) {
		mensaje('Ingrese solo un apellido paterno, tampoco se acepta espacios en blanco.');
		return false;
		} else if (correo.length < 20 || correo.length >= 50) {
		mensaje('El correo solo acepta como minimo 20 y maximo 50.');
		return false;
	} else if (!regexcorreo.test(correo)) {
		mensaje('El correo no es valido, ejemplo : example123@example.com');
		return false;
		
	} else if (contraseña.length < 9 || contraseña.length > 9) {
		mensaje('La constraseña debe tener minimo 3 caracteres');
		return false;
		
	} else if (telefono.length < 9 || telefono.length > 9) {
		mensaje('El celular  no tiene que ser menor a 9 digitos.');
		return false;
	
		
	}

	return true;
}
