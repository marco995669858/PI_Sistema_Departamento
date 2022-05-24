
function mensaje(msj){
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


function validarClientes() {

	let nombre = document.getElementById("idnombres").value;
	let apellido = document.getElementById("idapePaterno").value;
	var dni = document.getElementById("idDocumento").value;
	var celular = document.getElementById("idTelefono").value;
	var correo = document.getElementById("idCorreo").value;
	

	var regexemail = /^\w+@\w+\.+[a-z]{2,3}$/;
	var regexnombre = /^[A-Za-zƒŠŒŽšœžñŸÀÁÂÃÄÅÆÈÉÊËÌÍÎÏÑÒÓÔÕÖØÙÚÛÜÝàáâãäåæçèé êëìíîïðñòóôõöùúûüýþÿ]*$/;

	if (!nombre || !apellido || !dni || !celular || !correo) {
		mensaje("Todos los campos son obligatorios");
		return false;
	} else if (nombre.length < 3 || nombre.length >= 30) {
		mensaje('El nombre solo acepta como minimo 3 y maximo 30.');
		return false;
	} else if (!regexnombre.test(nombre)) {
		mensaje('Ingrese solo letras.');
		return false;
	} else if (apellido.length < 3 || apellido.length >= 30) {
		mensaje('El apellido paterno solo acepta como minimo 3 y maximo 30.');
		return false;
	} else if (!regexnombre.test(apellido)) {
		mensaje('Ingrese solo un apellido paterno, tampoco se acepta espacios en blanco.');
		return false;
	} else if (dni.length < 8 || dni.length > 8) {
		mensaje('El dni debe tener 8 dígitos y no se aceptan letras');
		return false;
	} else if (celular.length < 9 || celular.length > 9) {
		mensaje('El celular  no tiene que ser menor a 9 digitos.');
		return false;
	} else if (correo.length < 20 || correo.length >= 50) {
		mensaje('El correo solo acepta como minimo 20 y maximo 50.');
		return false;
	} else if (!regexemail.test(correo)) {
		mensaje('El correo no es valido, ejemplo : example123@example.com');
		return false;
		
		
	}

	return true;
}