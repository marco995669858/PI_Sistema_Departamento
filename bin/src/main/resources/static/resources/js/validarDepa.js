
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


function validarDepa() {
	
	var nroDepartamento = document.getElementById("idDepartamento").value;
	var habitaciones = document.getElementById("idhabitaciones").value;
	var cocinas = document.getElementById("idcocina").value;
	var lavanderia = document.getElementById("idlavanderia").value;
	var sala = document.getElementById("idsala").value;
	var banio = document.getElementById("idbanio").value;
	let tamanio = document.getElementById("idtamanio").value;
	    

	var regextamanio = /^[0-9]{1,6} \m²$/i;

	if (!nroDepartamento || !habitaciones || !cocinas || !lavanderia || !sala || !banio || !tamanio) {
		mensaje("Todos los campos son obligatorios");
		return false;
	}  else if (nroDepartamento.length < 4 || nroDepartamento.length >=5) {
		mensaje('El número del departamento acepta 4 digitos a 5 digitos del 1000 en adelante.');
		return false;
	} else if (!regextamanio.test(tamanio)) {
		mensaje('ejemplo: 120 m².');
		return false;
	}

	return true;
}