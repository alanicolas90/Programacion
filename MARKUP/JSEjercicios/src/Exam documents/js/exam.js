const button = document.getElementById('start');
const correct = document.getElementById('right');
const wrong = document.getElementById('wrong');

let brands = ["Coca cola", "Burger king", "Coca cola", "Firefox", "Heineken", "Hewlett Packard", "Lays", "Mitsubishi", "Nike", "Nissan", "Pepsi", "Pringles", "Puma", "Seat", "Volkswagen"];
let images = ["img/apple.jpg", "img/burger king.jpg", "img/coca cola.jpg", "img/firefox.jpg", "img/heineken.jpg", "img/hewlett packard.jpg", "img/lays.jpg", "img/mitsubishi.jpg", "img/nike.jpg", "img/nissan.jpg", "img/pepsi.jpg", "img/pringles.jpg", "img/puma.jpg", "img/seat.jpg", "img/volkswagen.jpg"];

let logos;

function startGame() {
    let level = document.getElementById('mode');
    let start = document.getElementById('start');

    //Disable buttons so you dont change nothing after starting the game
    level.disabled = true;
    start.disabled = true;

    //appear sequence of images
    showImagesSequence();

    //appear name so you have to click it
    changeBrandName();

    //you can click on the image and it will respond
    enableEventField();
}

//get a random number from the array of brands
function randomIndexBrand() {
    let number = brands.length;
    return Math.floor(Math.random() * number);
}

//gets a random number from the array of the images src
function randomIndexImage() {
    let number = images.length;
    return Math.floor(Math.random() * number);
}

// changes the brand in the html already random
function changeBrandName() {
    let brand = document.getElementById('brand');
    //brand[random] random is the function randomIndexBrand() returns number so get position of the array
    brand.innerText = brands[randomIndexBrand()];

}

//get a random image from the array created with all the existing images
function getImage(){
    let img = document.getElementById('ima');
    let att = document.createAttribute('src');
    //here you get the image
    att.value = images[randomIndexImage()];
    //and u put it in the src attribute
    img.attributes.setNamedItem(att);
}

//it will show the images changing because of the set interval
function showImagesSequence() {
    let level = document.getElementById('mode').value;
    getImage();
    logos = setInterval(() =>{
        //gets the random images
        getImage();
        //here it gets every x seconds depending on the level
        },500 + (level*500));
}

//acivate buttons of the image
function enableEventField(){
    let imageContainer = document.getElementById('ima');
    imageContainer.addEventListener('click',check)
}
//disable the buttons of the image
function disableEventField(){
    let imageContainer = document.getElementById('ima');
    imageContainer.removeEventListener('click',check)
}

//check what we clicked
function check(e){
    //when we click the image has the whole link so i did split and join so there are no problems when comparing strings
    let imageClicked = e.target.src.split("http://localhost:63342/JSEjercicios/src/Exam%20documents/img/").join('').split(".jpg").join('').split("%20").join('');
    checkSolution(imageClicked);
}
//when we click we check what we clicked
function checkSolution(imageClicked){
    let brand = document.getElementById('brand');

    //again the separation in the name made me do a split join so we could compare properly
    if(imageClicked.toLocaleLowerCase() === brand.innerText.toLocaleLowerCase().split(' ').join('')){
        changeBrandName();
        correct.value ++;
    }else if(imageClicked.toLocaleLowerCase() !== brand.innerText.toLocaleLowerCase()){
        wrong.value ++;
    }
    //when the game ends
    if(correct.value==3 || wrong.value ==3){
        clearInterval(logos);
        stopGame();
    }

}

//what happens when the game ends
function stopGame(){
    let att = document.createAttribute('src');
    let img = document.getElementById('ima');
    //show the image depending if it has 3 correct or 3 wrong
    if(wrong.value==3){
        att.value="img/gameOver.jpg";
    }else if(correct.value==3){
        att.value="img/wellDone.jpg";
    }
    img.attributes.setNamedItem(att);
    disableEventField();
}

function assignEvents() {
    button.addEventListener('click', startGame);
}

document.addEventListener('DOMContentLoaded', assignEvents);