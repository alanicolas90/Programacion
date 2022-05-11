let button = document.getElementById('create field');

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
    playGame();
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
            field.innerHTML += btn.outerHTML;
        }
        field.innerHTML += '<br>';
    }
}

function random(number){
    return Math.floor(Math.random()*number);;
}
function randomColor(){
    return 'rgb('+random(255)+','+random(255)+','+random(255)+')';
}

function playGame() {
    let buttons = document.getElementsByClassName('buttons');
    for (const element of buttons) {
        element.addEventListener('click', check);
    }
}

function check(e) {
    let paragraph = document.getElementById('text');
    paragraph.innerText = 'You clicked the button: (' + e.target.id.split('_')[0] + ',' + e.target.id.split('_')[1]+')';
}

function assignEvents() {
    button.addEventListener('click', startGame);
}

document.addEventListener('DOMContentLoaded', assignEvents);

// function disableEventsField() {
//     let buttons = document.getElementsByClassName('buttons');
//     for (let i = 0; i < buttons.length; i++) {
//         buttons[i].removeEventListener('mousedown', check);
//     }
// }
