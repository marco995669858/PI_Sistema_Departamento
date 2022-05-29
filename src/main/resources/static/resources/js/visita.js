var now = new Date();
now.setMinutes(now.getMinutes() - now.getTimezoneOffset());
document.getElementById('minor2').value = now.toISOString().slice(0,16);