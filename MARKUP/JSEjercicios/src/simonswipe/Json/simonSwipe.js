let button = document.getElementById('create field');
let roundNr = 0;

let humanSequence = [];

function startGame() {
    let rows = document.getElementById('rows');
    let cols = document.getElementById('columns');
    let level = document.getElementById('level');
    let message = document.getElementById('message');
    let crono = document.getElementById('crono');
    let score = document.getElementById('score');

    rows.disabled = true;
    cols.disabled = true;
    level.disabled = true;
    button.disabled = true;
    message.innerText = 'PLAYING...';
    crono.innerText = crono.innerText + '00:00:00';
    score.innerText = score.innerText + '0';
    drawField();

    const myArray = generateSequence(cols.value, rows.value, level.value);

    showSequence(myArray,roundNr);

    playGame(myArray);

    console.log(roundNr);
}

function drawField() {
    let field = document.getElementById('field');
    let rows = document.getElementById('rows');
    let cols = document.getElementById('columns');
    let btn = document.createElement('input');
    btn.type = 'button';
    btn.style.width = '75px';
    btn.style.height = '75px';
    btn.style.margin = '2px';

    for (let i = 0; i < rows.value; i++) {
        for (let j = 0; j < cols.value; j++) {
            btn.id = i + "_" + j;
            btn.className = 'buttons';
            btn.style.backgroundColor = randomColor()
            btn.style.color = btn.style.backgroundColor;
            field.innerHTML += btn.outerHTML;
        }
        field.innerHTML += '<br>';
    }
}

function generateSequence(width, height, level) {
    let realLevel = level * 5;
    const sequence = new Array(realLevel);

    for (let i = 0; i < realLevel; i++) {
        sequence[i] = new Array(2);
        for (let j = 0; j < 2; j++) {
            if (j === 0) {
                sequence[i][j] = Math.floor(Math.random() * (height));
            }
            if (j === 1) {
                sequence[i][j] = Math.floor(Math.random() * (width));
            }
        }
    }
    console.log(sequence);

    return sequence;
}

function random(number) {
    return Math.floor(Math.random() * number);

}

function changeColor(e) {
    e.target.style.backgroundColor = "#ffff";
}

function randomColor() {
    return 'rgb(' + random(255) + ',' + random(255) + ',' + random(255) + ')';
}

function playGame(sequence) {

    enableEventsField();
    if (roundNr < sequence.length) {

        roundNr++;

    } else if (roundNr === sequence.length) {
        alert('You win!');
    } else {
        alert('GAME OVER');
    }
}

function showSequence(sequence,roundNr) {
    setTimeout(showElement, 500, sequence);
    setTimeout(hideElement, 1000, sequence);
    roundNr++;
}

function hideElement(sequence) {
    let element = document.getElementById(sequence[1][0] + '_' + sequence[1][1]);
    element.style.backgroundColor = element.style.color;

}

function showElement(sequence) {

    let element = document.getElementById(sequence[1][0] + '_' + sequence[1][1]);
    element.style.backgroundColor = "#ffff";


}

function check(e) {
    let paragraph = document.getElementById('text');
    paragraph.innerText = 'You clicked the button: (' + e.target.id.split('_')[0] + ',' + e.target.id.split('_')[1] + ')';
}

function changeColorOriginal(e) {
    e.target.style.backgroundColor = e.target.style.color;
}

function nextRound() {
    roundNr ++;
}

function enableEventsField() {
    let buttons = document.getElementsByClassName('buttons');
    for (const element of buttons) {
        element.addEventListener('mouseup', changeColorOriginal);
        element.addEventListener('mouseout', changeColorOriginal);
        element.addEventListener('mousedown', changeColor);
        element.addEventListener('click', check);
    }
}

function disableEventsField() {
    let buttons = document.getElementsByClassName('buttons');
    for (let i = 0; i < buttons.length; i++) {
        buttons[i].removeEventListener('click', check);
    }
}

function assignEvents() {
    button.addEventListener('click', startGame);
}

document.addEventListener('DOMContentLoaded', assignEvents);
