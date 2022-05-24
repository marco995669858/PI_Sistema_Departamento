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


function validarDepartamentos() {
	
	let piso = document.getElementById("idPiso").value;
	let nroDepartamento = document.getElementById("idnroDepartamento").value;



	if (!piso || !nroDepartamento) {
		mensaje("Todos los campos son obligatorios");
		return false;
	}  else if (nroDepartamento.length < 3 || nroDepartamento.length >=5) {
		mensaje('El número del departamento acepta 4 digitos como máximo');
		return false;
	} 
	return true;
}