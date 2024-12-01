const burger = document.querySelector('.burguer');
const sidebar = document.getElementById('sidebar');
const closeSidebar = document.getElementById('closeSidebar');

// Abrir el sidebar
burger.addEventListener('click', () => {
    sidebar.classList.remove('translate-x-full');
});

// Cerrar el sidebar
closeSidebar.addEventListener('click', () => {
    sidebar.classList.add('translate-x-full');
});