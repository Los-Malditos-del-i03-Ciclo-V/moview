document.addEventListener("DOMContentLoaded", () => {
    // Encuentra todos los carruseles en la página
    const carousels = document.querySelectorAll(".carousel");
    
    carousels.forEach(carousel => {
        const movies = Array.from(carousel.children);

        // Duplicar las imágenes para crear un carrusel infinito
        movies.forEach((movie) => {
            const clone = movie.cloneNode(true);
            carousel.appendChild(clone);
        });

        let scrollPosition = 0;
        const scrollSpeed = 1.5; // Ajusta la velocidad

        function scrollCarousel() {
            scrollPosition += scrollSpeed;

            // Reiniciar al inicio al llegar a la mitad del carrusel
            if (scrollPosition >= carousel.scrollWidth / 2) {
                scrollPosition = 0;
            }

            carousel.scrollLeft = scrollPosition;
            requestAnimationFrame(scrollCarousel);
        }

        scrollCarousel();
    });
});
