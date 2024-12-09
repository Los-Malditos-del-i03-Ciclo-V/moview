function increaseCount(counterId) {
    var counter = document.getElementById(counterId);
    counter.innerText = parseInt(counter.innerText) + 1;
}

function decreaseCount(counterId) {
    var counter = document.getElementById(counterId);
    if (parseInt(counter.innerText) > 0) {
        counter.innerText = parseInt(counter.innerText) - 1;
    }
}
