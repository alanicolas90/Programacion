let button = document.getElementById('create field');
let rows = document.getElementById('rows');
let cols = document.getElementById('columns');
let level = document.getElementById('level');
let message = document.getElementById('message');

let buttonId = 0;

let roundNr = 0;
let win = false;
let winRound = false;
let humanSequence = [];
let robotSequence = [];

let m = 0;
let s = 0;
let h = 0;

function startGame() {


    let crono = document.getElementById('hms');
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


    playGame();
    console.log(humanSequence);
    console.log(robotSequence);
}

function drawField() {
    let field = document.getElementById('field');

    let btn = document.createElement('input');
    btn.type = 'button';
    btn.style.width = '75px';
    btn.style.height = '75px';
    btn.style.margin = '2px';

    for (let i = 0; i < rows.value; i++) {
        for (let j = 0; j < cols.value; j++) {
            btn.id = buttonId.toString();
            btn.className = 'buttons';
            btn.style.backgroundColor = randomColor()
            btn.style.color = btn.style.backgroundColor;
            field.innerHTML += btn.outerHTML;
            buttonId++;
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

function stopGame(text) {
    disableEventsField();
    if(win===true){
        message.innerText = 'YOU WON';
    }else{
        message.innerText = 'YOU LOST';
    }
    alert(text);
    //clearInterval(timer);
}

function playGame() {
    cronometro();
    roundNr += 1;

    let firstNum = Math.floor(Math.random() * (rows.value * cols.value));
    robotSequence.push(firstNum.toString());
    while(showSequence()){
        disableEventsField();
    }
}

function showSequence() {
    if (level.value == 1) {
        robotSequence.forEach(lightIt1);
    } else if (level.value == 2) {
        robotSequence.forEach(lightIt2);
    } else if (level.value == 3) {
        robotSequence.forEach(lightIt3);
    }
}

function lightIt1(buttonNum, i) {
    setTimeout(() => {
        if (buttonNum >= 0 && buttonNum < rows.value * cols.value) {
            setTimeout(function () {
                document.getElementById(buttonNum.toString()).style.backgroundColor = '#ffff';
            }, 500);
            setTimeout(function () {
                document.getElementById(buttonNum.toString()).style.backgroundColor = document.getElementById(buttonNum.toString()).style.color;
            }, 1000);
        }
    }, i * 1000);
}

function lightIt2(buttonNum, i) {
    setTimeout(() => {
        if (buttonNum >= 0 && buttonNum < rows.value * cols.value) {
            setTimeout(function () {
                document.getElementById(buttonNum.toString()).style.backgroundColor = '#ffff';
            }, 500);
            setTimeout(function () {
                document.getElementById(buttonNum.toString()).style.backgroundColor = document.getElementById(buttonNum.toString()).style.color;
            }, 1000);
        }
    }, i * 800);
}

function lightIt3(buttonNum, i) {
    setTimeout(() => {
        if (buttonNum >= 0 && buttonNum < rows.value * cols.value) {
            setTimeout(function () {
                document.getElementById(buttonNum.toString()).style.backgroundColor = '#ffff';
            }, 500);
            setTimeout(function () {
                document.getElementById(buttonNum.toString()).style.backgroundColor = document.getElementById(buttonNum.toString()).style.color;
            }, 1000);
        }
    }, i * 500);
}

function check(e) {
    document.getElementById('text').innerText = e.target.id;
    humanSequence.push(e.target.id);
    checkSolution();
}

function checkSolution() {
    if (humanSequence.length === robotSequence.length) {
        for (let i = 0; i < humanSequence.length; i++) {
            if (humanSequence[i] === robotSequence[i]) {
                winRound = true;
                if (roundNr == level.value * 5) {
                    win = true;
                    stopGame('You win!');
                    return winRound = false;
                }
            } else {
                win = false;
                stopGame('YOU LOSE');
            }
        }
        if ((winRound = true)) {
            let nextNum = Math.floor(Math.random() * (rows.value * cols.value));
            robotSequence.push(nextNum.toString());
            humanSequence = [];
            showSequence();
            roundNr += 1;
        }
    }
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
    for (const element of buttons) {
        element.removeEventListener('mouseup', changeColorOriginal);
        element.removeEventListener('mouseout', changeColorOriginal);
        element.removeEventListener('mousedown', changeColor);
        element.removeEventListener('click', check);
    }
}

//CRONOMETRO

function cronometro() {
    escribir();
    setInterval(escribir, 1000);

    //clearInterval(timer);

}

function escribir() {
    let hAux, mAux, sAux;
    s++;
    if (s > 59) {
        m++;
        s = 0;
    }
    if (m > 59) {
        h++;
        m = 0;
    }
    if (h > 24) {
        h = 0;
    }

    if (s < 10) {
        sAux = "0" + s;
    } else {
        sAux = s;
    }
    if (m < 10) {
        mAux = "0" + m;
    } else {
        mAux = m;
    }
    if (h < 10) {
        hAux = "0" + h;
    } else {
        hAux = h;
    }

    document.getElementById("hms").innerHTML = hAux + ":" + mAux + ":" + sAux;
}

function assignEvents() {
    button.addEventListener('click', startGame);
}

document.addEventListener('DOMContentLoaded', assignEvents);
