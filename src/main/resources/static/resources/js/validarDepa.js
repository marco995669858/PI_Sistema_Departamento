function validarDepa() {

	var habitaciones = document.getElementById("idhabitaciones").value;
	var cocinas = document.getElementById("idcocinas").value;
	var lavanderia = document.getElementById("idlavanderia").value;
	var sala = document.getElementById("idsala").value;
	var baño = document.getElementById("idbaño").value;
	let tamaño = document.getElementById("idtamaño").value;
	

	var regextamaño = /^[A-Za-zƒŠŒŽšœžñŸÀÁÂÃÄÅÆÈÉÊËÌÍÎÏÑÒÓÔÕÖØÙÚÛÜÝàáâãäåæçèé êëìíîïðñòóôõöùúûüýþÿ]*$/;

	if (!habitaciones || !cocinas || !lavanderia || !sala || !baño || !tamaño) {
		alert("Todos los campos son obligatorios");
		return false;
	} else if (habitaciones.length >= 1 || habitaciones.length <= 4) {
		alert('Las habitaciones solo acepta como minimo 1 y maximo 4.');
		return false;
	} else if (cocinas.length >= 1 || cocinas.length <= 3) {
		alert('Las cocinas solo acepta como minimo 1 y maximo 3.');
		return false;
	} else if (lavanderia.length >= 1 || lavanderia.length <= 4) {
		alert('Lavanderia solo acepta como minimo 1 y maximo 4');
		return false;
	} else if (sala.length >= 1 || sala.length <= 3) {
		alert('La Cantidad de salas solo acepta com minimo 1 y maximo 3.');
		return false;
	} else if (baño.length >= 1 || cocinas.length <= 3) {
		alert('La cantidad de Baños solo acepta como min 1 y max 3.');
		return false;
	} else if (tamaño.length < 4 || tamaño.length >= 10) {
		alert('El tamaño de Departamento es de 4 digitos como min y 10 max');
		return false;
	} else if (!regextamaño.test(tamaño)) {
		alert('Ingrese solo letras.');
		return false;
	}

	return true;
}