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




/*function validarModalVisitante() {
	
	let departamento = document.getElementById("").value;
	let nombre = document.getElementById("idNombre").value;
	let apellido = document.getElementById("idApellido").value;
	var dni = document.getElementById("idDocumento").value;
	var correo = document.getElementById("idCorreo").value;


	var regexcorreo = /^\w.+@\w+\.+[a-z]{2,3}$/;
	var regexnombre = /^[A-Za-zƒŠŒŽšœžñŸÀÁÂÃÄÅÆÈÉÊËÌÍÎÏÑÒÓÔÕÖØÙÚÛÜÝàáâãäåæçèé êëìíîïðñòóôõöùúûüýþÿ]*$/;

	if (!nombre ||!apellido || !dni || !correo) {
		mensaje("Todos los campos son obligatorios");
		return false;
	} 
	return true;
}*/
