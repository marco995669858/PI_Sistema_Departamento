//Para acceder a la camara

// Get DOM Elements
const modal = document.querySelector('#my-modal');
const modalBtn = document.querySelector('#modal-btn');
const closeBtn = document.querySelector('.close');

// Events
modalBtn.addEventListener('click', openModal);
closeBtn.addEventListener('click', closeModal);
window.addEventListener('click', outsideClick);

// Open
function openModal() {
  modal.style.display = 'block';
}

// Close
function closeModal() {
  modal.style.display = 'none';
}

// Close If Outside Click
function outsideClick(e) {
  if (e.target == modal) {
    modal.style.display = 'none';
  }
}
function myFunction() {
      var fecha = new Date();
      var output = (fecha.getHours()<10 ? '0' : '') +fecha.getHours()+ ":"+ (fecha.getMinutes()<10 ? '0' : '')+fecha.getMinutes();
    document.getElementById("minor2").value = output;
  }
  