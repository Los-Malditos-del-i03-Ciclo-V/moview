const cart = {};

function updateSummary() {
    const summaryContainer = document.querySelector('.summary');
    const totalPriceEl = document.getElementById('total-price');
    let totalPrice = 0;

    summaryContainer.innerHTML = '';

    Object.keys(cart).forEach((id) => {
        if (cart[id].quantity > 0) {
            const itemTotal = cart[id].quantity * cart[id].price;
            totalPrice += itemTotal;

            const summaryItem = document.createElement('div');
            summaryItem.className = 'flex justify-between';
            summaryItem.innerHTML = `
                <span>${cart[id].name} (x${cart[id].quantity})</span>
                <span>$${itemTotal.toFixed(2)}</span>
            `;
            summaryContainer.appendChild(summaryItem);
        }
    });

    totalPriceEl.textContent = `$${totalPrice.toFixed(2)}`;
}

document.addEventListener('click', (e) => {
    if (e.target.classList.contains('increase') || e.target.classList.contains('decrease')) {
        const card = e.target.closest('.card');
        const counter = card.querySelector('.counter');
        const productId = card.getAttribute('data-id');
        const productName = card.getAttribute('data-name');
        const productPrice = parseFloat(card.getAttribute('data-price'));

        if (!cart[productId]) {
            cart[productId] = {
                name: productName,
                price: productPrice,
                quantity: 0,
            };
        }

        if (e.target.classList.contains('increase')) {
            cart[productId].quantity++;
        } else if (e.target.classList.contains('decrease') && cart[productId].quantity > 0) {
            cart[productId].quantity--;
        }

        counter.textContent = cart[productId].quantity;

        updateSummary();
    }
});
