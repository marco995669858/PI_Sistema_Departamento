function validarCliente() {

	let nombre = document.getElementById("idnombres").value;
	let apellido = document.getElementById("idapellidos").value;
	var dni = document.getElementById("idDni").value;
	var celular = document.getElementById("idcelular").value;
	var correo = document.getElementById("idcorreo").value;
	var password = document.getElementById("idpassword").value;
	var descripcionRaza = document.getElementById("iddescripcion").value;

	var regexemail = /^\w+@\w+\.+[a-z]{2,3}$/;
	var regexnombre = /^[A-Za-zƒŠŒŽšœžñŸÀÁÂÃÄÅÆÈÉÊËÌÍÎÏÑÒÓÔÕÖØÙÚÛÜÝàáâãäåæçèé êëìíîïðñòóôõöùúûüýþÿ]*$/;

	if (!nombre || !apellido || !dni || !celular || !correo || !password) {
		alert("Todos los campos son obligatorios");
		return false;
	} else if (nombre.length < 3 || nombre.length >= 30) {
		alert('El nombre solo acepta como minimo 3 y maximo 30.');
		return false;
	} else if (!regexnombre.test(nombre)) {
		alert('Ingrese solo letras.');
		return false;
	} else if (apellido.length < 3 || apellido.length >= 30) {
		alert('El apellido paterno solo acepta como minimo 3 y maximo 30.');
		return false;
	} else if (!regexnombre.test(apellido)) {
		alert('Ingrese solo un apellido paterno, tampoco se acepta espacios en blanco.');
		return false;
	} else if (dni.length < 8 || dni.length > 8) {
		alert('El dni no tiene que ser menor a 8 o mayor a 8 digitos.');
		return false;
	} else if (celular.length < 9 || celular.length > 9) {
		alert('El celular  no tiene que ser menor a 9 digitos.');
		return false;
	} else if (correo.length < 20 || correo.length >= 50) {
		alert('El correo solo acepta como minimo 20 y maximo 50.');
		return false;
	} else if (!regexemail.test(correo)) {
		alert('El correo no es valido, ejemplo : example123@example.com');
		return false;
	} else if (password.length < 8 || password.length >= 20) {
		alert('El password solo acepta como minimo 8 y maximo 20.');
		return false;
	}else if(isNaN(descripcionRaza)){
		alert("Ingrese solo letras en la descripción de mascota.");
		return false;
	}

	return true;
}
