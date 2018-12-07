function quantityModifier() {
    var getCell = document.querySelector('#plus');
    var getMinusCell = document.querySelector('#remove');
    var getCounter = document.querySelector('#counter');
    var number = getCounter.innerText;
    getCell.addEventListener('click', function (evt) {
        number++;
        getCounter.innerText = number;
    });
    getMinusCell.addEventListener('click', function (evt) {
        number--;
        getCounter.innerText = number;
    })
}
quantityModifier();