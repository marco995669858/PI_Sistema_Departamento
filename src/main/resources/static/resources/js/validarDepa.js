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
	let departamento=document.getElementById("idTipodepatamento").value;
	let piso = document.getElementById("idpiso").value;
	let nroDepartamento = document.getElementById("idnroDepartamento").value;
	let habitaciones = document.getElementById("idnro").value;
	let banio = document.getElementById("idBanio").value;
	let lavanderia = document.getElementById("idlavanderia").value;

	if (!piso || !nroDepartamento) {
		mensaje("Todos los campos son obligatorios");
		return false;
	}  
}