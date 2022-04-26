const CODIGO = 25;

function misterio1(document, id) {
    if (document.getElementById(id)) {
        return document.getElementById(id).innerHTML;
    } else {
        return "No existe ese id";
    }
}

function misterio2(document, string) {
    if (document.getElementsByClassName(string)) {
        return document.getElementsByClassName(string)[0].style.color;
    } else {
        return "No existen con esa clase";
    }
}

function misterio3(document, tag) {

    var elementos = document.getElementsByTagName(tag);

    if (elementos.length > 0) {
        for (let i = 0; i < elementos.length; i++) {
            elementos[i].id = "el" + tag + (i + 1);
        }
    } else {
        return "No existen con esa etiqueta";
    }

}

function misterio4(document, string, clase) {
    if (document.querySelector(string + "." + clase)) {
        return true;
    } else {
        return false;
    }
}

function misterio5(document, string) {
    return document.getElementsByClassName(string).length;
}


function misterio6(document, id) {
    var h1 = document.createElement("h1");
    h1.id = id;
    document.body.appendChild(h1);
}


function misterio7(document, id, text, parentId) {
    var h2 = document.createElement("h2");
    h2.id = id;
    h2.innerHTML = text;
    if (document.getElementById(parentId)) {
        document.getElementById(parentId).appendChild(h2);
    } else {
        document.body.appendChild(h2);
    }
}

function misterio8(document) {
    var ul = document.createElement("ul");
    var li1 = document.createElement("li");
    li1.className = "linea";
    li1.innerHTML = "HOLA";
    var li2 = document.createElement("li");
    li2.className = "linea";
    li2.innerHTML = "HOLA";
    var li3 = document.createElement("li");
    li3.className = "linea";
    li3.innerHTML = "HOLA";
    ul.appendChild(li1);
    ul.appendChild(li2);
    ul.appendChild(li3);
    document.body.appendChild(ul);
}

function misterio9(document) {
    var lista = document.getElementsByTagName("li");
    lista[0].id = "primero";
    lista[0].innerHTML = "primero";
    lista[1].id = "segundo";
    lista[1].innerHTML = "segundo";
    lista[2].id = "tercero";
    lista[2].innerHTML = "tercero";
}

function misterio10(document, tag, id, color, backgroundColor, text) {
    var element = document.createElement(tag);
    element.id = id;
    element.style.color = color;
    element.style.backgroundColor = backgroundColor;
    element.innerHTML = text;
    document.body.appendChild(element);
}

function misterio11(document, id) {
    if (document.getElementById(id)) {
        var element = document.getElementById(id);
        element.className = "clase";
    } else {
        return "No existe ese id";
    }
}

function misterio12(document, id) {
    if (document.getElementById(id)) {
        var element = document.getElementById(id);
        return element.childNodes.length;
    } else {
        return 0;
    }
}

function misterio13(document, string) {
    document.title = string;
}

function misterio14(document, className) {
    var element = document.getElementsByClassName(className);
    var cantidadEliminados = element.length;
    document.body.remove(element);
    return "Eliminados:" + cantidadEliminados;
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
    misterio14
}