const CODIGO = 25;

function misterio1(edad) {
    if (typeof (edad) === "number" && edad >= 18 && edad <= 120) {
        return "Puedes conducir";
    } else {
        return "Introduce un numero válido";
    }
}

function misterio2(mes) {
    if (mes >= 1 && mes <= 12) {
        if(mes == 1){
            return "Enero";
        }
        else if(mes == 2){
            return "Febrero";
        }
        else if(mes == 3){
            return "Marzo";
        }
        else if(mes == 4){
            return "Abril";
        }
        else if(mes == 5){
            return "Mayo";
        }
        else if(mes == 6){
            return "Junio";
        }
        else if(mes == 7){
            return "Julio";
        }
        else if(mes == 8){
            return "Agosto";
        }
        else if(mes == 9){
            return "Septiembre";
        }
        else if(mes == 10){
            return "Octubre";
        }
        else if(mes == 11){
            return "Noviembre";
        }
        else if(mes == 12){
            return "Diciembre";
        }
    } else {
        return "No es un mes";
    }
}

function misterio3(operacion, num1, num2) {
    if (typeof (num1) === "number" && typeof (num2) === "number") {
        if(operacion == "suma"){
            return num1 + num2;
        }
        else if(operacion == "resta"){
            return num1 - num2;
        }
        else if(operacion == "multiplicación"){
            return num1 * num2;
        }
        else if(operacion == "división"){
            if(num2 == 0){
                return "No dividir por 0";
            }
            else{
                return num1 / num2;
            }
        }
        else{
            return "Introduce operación válida";
        }

    } else {
        return "Los valores no son números";
    }
}

function misterio4(numero, letra) {
    const letras = ['T', 'R', 'W', 'G', 'M', 'Y', 'P', 'D', 'X', 'B', 'N', 'J', 'Z', 'S', 'Q', 'V', 'H', 'L', 'C', 'K', 'E', 'T'];
    if (numero >= 0 && numero <= 999999999){
        if(letras.indexOf(letra.toUpperCase()) === -1){
            return "La letra o el número proporcionados no son correctos";
        }
        else{
            return "El DNI es correcto";
        }
    }else{
        return "El número no es válido";
    }
}

function misterio5(lista) {
    if(Array.isArray(lista)){
        if(lista.length > 2){
            return lista[2];
        }
        else{
            return "No es posible";
        }
    }
    else{
        return "No es posible";
    }
}

function misterio6(letra) {
    const letras = ['A', 'B', 'C', 'D', 'E'];
    if(letras.indexOf(letra) !== -1){
        switch (letra) {
            case 'A':
                return "Nota entre 8 y 10";
            case 'B':
                return "Nota entre 6.5 y 8";
            case 'C':
                return "Nota entre 5 y 6.5";
            case 'D':
                return "Nota entre 4 y 5";
            case 'E':
                return "Nota entre 0 y 4";
        }
    }
    else{
        return "Introduce una nota válida";
    }
}

function misterio7(number) {
    if(typeof number == "number" && number >= 0 ){
       if(number > 100){
           return 1;
       } else{
           return Math.round((100/number)+(100%number));
       }
    }
    else{
        return "Introduce un número positivo";
    }
}

function misterio8(number) {
    if(number> 0 && number < 10){
        return "1x" + number+ "=" + number +",2x" + number + "=" + number*2 + ",3x" + number + "=" + number*3 + ",4x" + number + "=" + number*4 + ",5x" + number + "=" + number*5 + ",6x" + number + "=" + number*6 + ",7x" + number + "=" + number*7 + ",8x" + number + "=" + number*8 + ",9x" + number + "=" + number*9 + ".";
    }
    else{
        return "Introduce un número de 1 a 9";
    }
}

function misterio9(rows, columns) {
    if(typeof rows == "number" && typeof columns == "number" && rows >= 0 && columns >= 0 && rows < 10 && columns < 10){
        let table = "<table>";
        for(let i = 0; i < rows; i++){
            table += "<tr>";
            for(let j = 0; j < columns; j++){
                table += "<td>";
                table += "</td>";
            }
            table += "</tr>";
        }
        table += "</table>";
        return table;
    }
    else{
        return "Introduce dos números positivos menores que 10";
    }
}

function misterio10() {
    return "Hoy es el día "+new Date().getDay()+" del mes "+new Date().getMonth();
}

function misterio11(string) {
    if(typeof string == "string"){
        if(string.length > 10){
            return "substring:"+string.substring(1,4);
        }else if(string.length <= 10){
            return "longitud:"+string.length;
        }
    }
    else{
        return "Mete un string";
    }
}

function misterio12(palabra) {
    function reverse(string) {
        return string.split("").reverse().join("");
    }

    if(typeof palabra == "string"){
       return reverse(palabra);
    }
    else{
        return "Mete un string";
    }
}


function misterio13(string) {
    if(typeof string == "string"){
        return string.toUpperCase();
    }
    else{
        return "Mete un string";
    }
}

function misterio14(string) {
    if(typeof string == "string"){
        return string.includes("DAM");
    }
    else{
        return "Mete un string";
    }
}


function misterio15(nombre,apellido1,apellido2) {
    if(typeof nombre == "string" && typeof apellido1 == "string" && typeof apellido2 == "string"){
        return "{\"nombre\":\""+nombre+"\",\"apellido1\":\""+apellido1+"\",\"apellido2\":\""+apellido2+"\"}";
    }
    else{
        return "Alguno no es string";
    }
}


function misterio16(string) {
    if(typeof string == "string"){
        if(string.includes("suspender")){
            return string.replace("suspender","aprobar");
        }
    }
    else{
        return "Mete un string";
    }
}

function misterio17(array) {
    if(typeof array == "object"){
        var html = "<ul>";
        for(var i = 0; i < array.length; i++){
            html += "<li>"+array[i]+"</li>";
        }
        html += "</ul>";
        return html;
    }
    else{
        return "Mete un array";
    }
}

function misterio18(array) {
    if(array.length > 0){
        var html = "<ol>";
        for(var i = array.length-1; i >= 0; i--){
            html += "<li>"+array[i]+"</li>";
        }
        html += "</ol>";
        return html;
    }
    else{
        return "Array vacío";
    }
}

function misterio19(json) {
    return json.nombre + " " + json.apellido1 + " " + json.apellido2+".";
}

function misterio20(arraylist,number) {
    if(arraylist.length > number){
        if(typeof arraylist[number] =="number"){
            return "{\"resultado\":"+arraylist[number]+"}";
        }
        else if(typeof arraylist[number] =="undefined"){
            return "No es posible";
        }
        else{
            return "{\"resultado\":\""+arraylist[number]+"\"}";
        }
    }
    else{
        return "No es posible";
    }
}


module.exports = {
    misterio1,
    misterio2,
    misterio3,
    misterio4,
    misterio5,
    misterio6,
    misterio7,
    misterio8,
    misterio9,
    misterio10,
    misterio11,
    misterio12,
    misterio13,
    misterio14,
    misterio15,
    misterio16,
    misterio17,
    misterio18,
    misterio19,
    misterio20,
    CODIGO
}