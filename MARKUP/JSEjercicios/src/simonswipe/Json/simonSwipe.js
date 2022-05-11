let button = document.getElementById('create field');
let roundNr = 3;

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
    enableEventsField();
    generateSequence(cols.value, rows.value, level.value);
}

function generateSequence(width, height, level) {
    let realLevel = level * 5;
    var sequence = new Array(realLevel);
    //let text = document.getElementById('text');

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
        //para ver las coordenadas de la secuencia
        //text.innerText = text.innerText + sequence[i][0] + ','+ sequence[i][1]+ '\n ';
    }

    playGame(sequence);
    showElement(sequence);
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
    disableEventsField();

    if (roundNr < sequence.length / 2) {
        setInterval(showElement, 1000);
    } else if (roundNr === sequence.length) {
        alert('You win!');
    } else {
        alert('GAME OVER');
    }
    roundNr++;
    enableEventsField();
}

function showElement(sequence) {
    disableEventsField();
    let element = document.getElementById(sequence[i][0] + '_' + sequence[i][1]);

}

function check(e) {
    let paragraph = document.getElementById('text');
    paragraph.innerText = 'You clicked the button: (' + e.target.id.split('_')[0] + ',' + e.target.id.split('_')[1] + ')';
}

function changeColorOriginal(e) {
    e.target.style.backgroundColor = e.target.style.color;
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
