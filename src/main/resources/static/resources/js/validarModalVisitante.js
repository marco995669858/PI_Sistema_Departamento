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




function validarModalVisitante() {


    
	let nombre = document.getElementById("idNombre").value;
	let apellido = document.getElementById("idApellido").value;
	var dni = document.getElementById("idDocumento").value;
	var correo = document.getElementById("idCorreo").value;
	
	
    
 
	var regexcorreo = /^\w.+@\w+\.+[a-z]{2,3}$/;
	var regexnombre = /^[A-Za-zƒŠŒŽšœžñŸÀÁÂÃÄÅÆÈÉÊËÌÍÎÏÑÒÓÔÕÖØÙÚÛÜÝàáâãäåæçèé êëìíîïðñòóôõöùúûüýþÿ]*$/;

	if (!nombre || !apellido || !dni || !correo) {
		mensaje("Todos los campos son obligatorios");
		return false;	
	}  if (nombre.length < 3 || nombres.length >= 30) {
		mensaje('El nombre solo acepta como minimo 3 y maximo 30.');
		return false;
	}  if (!regexnombre.test(nombre)) {
		mensaje('Ingrese solo letras.');
		return false;
	
	}  if (apellido.length < 3 || apellido.length >= 30) {
		mensaje('Los apellidos solo acepta como minimo 3 y maximo 30.');
		return false;
	}  if (!regexnombre.test(apellido)) {
		mensaje('Ingrese los apellidos, tampoco se acepta espacios en blanco.');
		return false;
		
	}  if (dni.length < 8 || dni.length > 8) {
	mensaje('El DNI debe tener 8 digitos');
	return false;
	
		
	}  if (correo.length < 10|| correo.length >= 50) {
	mensaje('El correo solo acepta como minimo 20 y maximo 50.');
	return false;
	}  if (!regexcorreo.test(correo)) {
		mensaje('El correo no es valido, ejemplo : example123@example.com');
		return false;
		
		
	//} else if (contraseña.length < 9 || contraseña.length > 9) {
		//mensaje('La constraseña debe tener minimo 3 caracteres');
	//	return false
		
	//} else if (telefono.length < 9 || telefono.length > 9) {
	//	mensaje('El celular  no tiene que ser menor a 9 digitos.');
	//	return false;
	
		
	}

	return true;
}
