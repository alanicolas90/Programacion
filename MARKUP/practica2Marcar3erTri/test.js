var assert = require('assert');
const practica2 = require("./practica2.js");
const jsdom = require("jsdom");
const { JSDOM } = jsdom;
var x = true;
const dom = new JSDOM(`<!DOCTYPE html><html><head></head><body></body></html>`);
const domFull = new JSDOM(
  `<!DOCTYPE html>
          <html><head></head>
                <body>
                <h1 id="ejemploh1" class="verde" style="color:red">Este es un h1</h1>
                <h1 class="rojo" style="color:red">Este es un h1 rojo</h1>
                <h1 class="clase">primero</h1>
                <h1 class="clase">segundo</h1>
                <h1 class="clase">3</h1>
                <h1 class="clase">4</h1>
                <div class="clase">puede</div>
                <p id="test" class="clase">ask</p>
                <h2 id="unh2" class="clase">puede</h2>
                </body>
            </html>`);
describe('Practica2', function () {
  describe('Ejercicio1', function () {
    it('Ejercicio misterio1', function () {
      assert.equal(practica2.misterio1(domFull.window.document,"ejemploh1"), "Este es un h1");
      assert.equal(practica2.misterio1(domFull.window.document,"unh2"), "puede");
      assert.equal(practica2.misterio1(domFull.window.document,"test"), "ask");
      assert.equal(practica2.misterio1(domFull.window.document,"testeo"), "No existe ese id");
    });
  });
  describe('Ejercicio2', function () {
    it('Ejercicio misterio2', function () {  
    assert.equal(practica2.misterio2(domFull.window.document,"rojo"), "red");
    assert.equal(practica2.misterio2(domFull.window.document,"verde"), "red");
    assert.equal(practica2.misterio2(domFull.window.document,"clase"), "");
 
    });
  });
  describe('Ejercicio3', function () {
    it('Ejercicio misterio3', function () {
      assert.equal(practica2.misterio3(domFull.window.document,"h3"), "No existen con esa etiqueta");
      practica2.misterio3(domFull.window.document,"h1");
      practica2.misterio3(domFull.window.document,"div")
      assert.equal(domFull.window.document.getElementById("elh11").innerHTML, "Este es un h1");
      assert.equal(domFull.window.document.getElementById("elh12").innerHTML, "Este es un h1 rojo");
      assert.equal(domFull.window.document.getElementById("elh14").innerHTML, "segundo");
      assert.equal(domFull.window.document.getElementById("eldiv1").innerHTML, "puede");
   
    });
  });
  describe('Ejercicio4', function () {
    it('Ejercicio misterio4', function () {
      
    assert.equal(practica2.misterio4(domFull.window.document,"p","clase"), true);
    assert.equal(practica2.misterio4(domFull.window.document,"div","clase"), true);
    assert.equal(practica2.misterio4(domFull.window.document,"h1","clase"), true);
    assert.equal(practica2.misterio4(domFull.window.document,"p","claserara"), false);
      
    });
  });
  describe('Ejercicio5', function () {
    it('Ejercicio misterio5', function () {
      assert.equal(practica2.misterio5(domFull.window.document,"rojo"), 1);
      assert.equal(practica2.misterio5(domFull.window.document,"verde"), 1);
      assert.equal(practica2.misterio5(domFull.window.document,"clase"), 7);
      assert.equal(practica2.misterio5(domFull.window.document,"claserara"), 0);
    });
  });
   describe('Ejercicio6', function () {
    it('Ejercicio misterio6', function () {
      practica2.misterio6(dom.window.document,"id");
      practica2.misterio6(dom.window.document,"uno");
      practica2.misterio6(dom.window.document,"dos");
      practica2.misterio6(dom.window.document,"otro");
   
      
      assert.equal(dom.window.document.getElementsByTagName("h1")[0].id,"id");
      assert.equal(dom.window.document.getElementsByTagName("h1")[1].id,"uno");
      assert.equal(dom.window.document.getElementsByTagName("h1")[2].id,"dos");
      assert.equal(dom.window.document.getElementsByTagName("h1")[3].id,"otro");
    });
  });
  describe('Ejercicio7', function () {
    it('Ejercicio misterio7', function () {
      practica2.misterio7(dom.window.document,"idEjemplo","texto","idpadre");
      practica2.misterio7(dom.window.document,"idhijo","texto2","idEjemplo");
        assert.equal(dom.window.document.getElementById("idEjemplo").innerHTML,`texto<h2 id="idhijo">texto2</h2>`);
        assert.equal(dom.window.document.getElementById("idhijo").innerHTML,"texto2");
        assert.equal(dom.window.document.getElementById("idEjemplo").parentElement.tagName,"BODY");
        assert.equal(dom.window.document.getElementById("idhijo").parentElement.tagName,"H2");
        });
  });
  describe('Ejercicio8', function () {
    it('Ejercicio misterio8', function () {
      
      practica2.misterio8(dom.window.document);
      assert.equal(dom.window.document.getElementsByTagName("ul").length,1);
      assert.equal(dom.window.document.getElementsByTagName("li").length,3);
      assert.equal(dom.window.document.getElementsByClassName("linea").length,3);
       
    });
  });
  describe('Ejercicio9', function () {
    it('Ejercicio misterio9', function () {
      practica2.misterio9(dom.window.document);
      assert.equal(dom.window.document.getElementById("primero").innerHTML,"primero");
      assert.equal(dom.window.document.getElementById("segundo").innerHTML,"segundo");
      assert.equal(dom.window.document.getElementById("tercero").innerHTML,"tercero");
     });
  });
  describe('Ejercicio10', function () {
    it('Ejercicio misterio10', function () {
      
      practica2.misterio10(dom.window.document,"h1","ej1","red","blue","texto");
      practica2.misterio10(dom.window.document,"h2","ej2","red","purple","texto");
      practica2.misterio10(dom.window.document,"h3","ej3","red","blue","textos");
      practica2.misterio10(dom.window.document,"h4","ej4","blue","yellow","cuarto");
      
      assert.equal(dom.window.document.getElementById("ej3").innerHTML,"textos");
      assert.equal(dom.window.document.getElementById("ej1").style.color,"red");
      assert.equal(dom.window.document.getElementById("ej2").style.backgroundColor,"purple");
      assert.equal(dom.window.document.getElementById("ej4").style.color,"blue");
      assert.equal(dom.window.document.getElementById("ej4").style.backgroundColor,"yellow");
      assert.equal(dom.window.document.getElementById("ej4").innerHTML,"cuarto");
      
     
    
    });
  });
  describe('Ejercicio11', function () {
    it('Ejercicio misterio11', function () {
      
      practica2.misterio11(dom.window.document,"ej1");
      practica2.misterio11(dom.window.document,"ej2");
      practica2.misterio11(dom.window.document,"ej3");
      practica2.misterio11(dom.window.document,"ej4");
      assert.equal(practica2.misterio11(dom.window.document,"algoraro"),"No existe ese id");
      assert.equal(dom.window.document.getElementById("ej1").classList,"clase");
      assert.equal(dom.window.document.getElementById("ej2").classList,"clase");
      assert.equal(dom.window.document.getElementById("ej3").classList,"clase");
      assert.equal(dom.window.document.getElementById("ej4").classList,"clase");
      });
  });
  describe('Ejercicio12', function () {
    it('Ejercicio misterio12', function () {
      
      assert.equal(practica2.misterio12(dom.window.document,"ej1"), 1);
      assert.equal(practica2.misterio12(dom.window.document,"ej2"), 1);
      assert.equal(practica2.misterio12(dom.window.document,"ej3"), 1);
      assert.equal(practica2.misterio12(dom.window.document,"ej4"), 1);
      assert.equal(practica2.misterio12(dom.window.document,"idEjemplo"), 2);
      assert.equal(practica2.misterio12(dom.window.document,"noexiste"), 0);
    });
  });
  describe('Ejercicio13', function () {
    it('Ejercicio misterio13', function () {
      practica2.misterio13(domFull.window.document,"titulo");
      assert.equal(domFull.window.document.title, "titulo");
        
      practica2.misterio13(dom.window.document,"titulo2");
      assert.equal(dom.window.document.title, "titulo2");
      
      practica2.misterio13(dom.window.document,"titulo3");
      assert.equal(dom.window.document.title, "titulo3");
       });
  });
  describe('Ejercicio14', function () {
    it('Ejercicio misterio14', function () {
      assert.equal(practica2.misterio14(dom.window.document,"clase"),"Eliminados:4");
      assert.equal(dom.window.document.getElementsByClassName("clase").length,0);
      assert.equal(practica2.misterio14(domFull.window.document,"clase"),"Eliminados:7");
      assert.equal(domFull.window.document.getElementsByClassName("clase").length,0);
    });
  });
});