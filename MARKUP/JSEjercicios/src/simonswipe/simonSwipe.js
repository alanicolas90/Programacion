function assignEvents() {

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
    }

    function drawField() {
        let field = document.getElementById('field');
        let rows = document.getElementById('rows');
        let cols = document.getElementById('columns');
        let btn = document.createElement('input');
        btn.type = 'button';
        btn.style.width = '75px';
        btn.style.height = '75px';
        btn.style.display = 'auto';
        btn.style.margin = '2px';

        for (let i = 0; i < rows.value; i++) {
            for (let j = 0; j < cols.value; j++) {
                btn.id = i + "_" + j;
                btn.className = 'buttons';
                btn.style.backgroundColor = '#' + Math.floor(Math.random() * 16777215).toString(16);
                field.innerHTML += btn.outerHTML;
            }
            field.innerHTML += '<br>';
        }
    }

    function playGame() {
        let buttons = document.getElementsByClassName('buttons');
        for (const element of buttons) {
            element.addEventListener('click', check);
        }

        function check() {
            let paragraph = document.getElementById('text');
            paragraph.innerText = 'You clicked the button!';
        }
    }



    button.addEventListener('click', playGame);
    button.addEventListener('click', startGame);
    button.addEventListener('click', drawField);
}

document.addEventListener('DOMContentLoaded', assignEvents);

// function disableEventsField() {
//     let buttons = document.getElementsByClassName('buttons');
//     for (let i = 0; i < buttons.length; i++) {
//         buttons[i].removeEventListener('mousedown', check);
//     }
// }
