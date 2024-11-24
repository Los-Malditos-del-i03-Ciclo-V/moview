const hamburger = document.getElementById('hamburger');
const dropdownMenu = document.getElementById('dropdownMenu');
const hamburgerIcon = document.getElementById('hamburgerIcon');
const servicesMenuBtn = document.getElementById('servicesMenuBtn');
const servicesDropdown = document.getElementById('servicesDropdown');
const servicesMenuBtnMobile = document.getElementById('servicesMenuBtnMobile');
const servicesDropdownMobile = document.getElementById('servicesDropdownMobile');

hamburger.addEventListener('click', () => {
    dropdownMenu.classList.toggle('hidden');
    if (dropdownMenu.classList.contains('hidden')) {
        hamburgerIcon.classList.remove('fa-xmark');
        hamburgerIcon.classList.add('fa-bars');
    } else {
        hamburgerIcon.classList.remove('fa-bars');
        hamburgerIcon.classList.add('fa-xmark');
    }
});

servicesMenuBtn.addEventListener('click', () => {
    servicesDropdown.classList.toggle('hidden');
});

servicesMenuBtnMobile.addEventListener('click', () => {
    servicesDropdownMobile.classList.toggle('hidden');
});