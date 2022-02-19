Feature: Como administrador quiero poner los ingredientes al producto

  Scenario: Agrego  ingredientes al producto con éxito
    Given nombre del producto
    And  nombre ingredientes
    And lista de productos
    #{té, 25$, 150}
    #{azúcar, 4$, 500}

    When introduzco nuevo ingrediente "vitamina C" al producto "tè"
    Then sale un mensaje que ha sido un éxito
    And sale lista así
    #{té, 25$, 150, Ingredientes="vitamina C"}
    #{azúcar, 4$, 500}

  Scenario: el ingrediente ya existe en ese producto
    Given nombre del producto
    And  nombre ingredientes
    And lista de productos
     #{té, 25$, 150, Ingredientes="vitamina C"}
    #{azúcar, 4$, 500}

    When introduzco nuevo ingrediente "vitamina C" al producto "tè"
    Then sale un mensaje que ha ocurrido un error
    #Lo sentimos no se pude agregar el ingrediente por que ya existe.


  Scenario: el prodcuto al que quiero añadir el ingrediente no existe
    Given nombre del producto
    And  nombre ingredientes
    And lista de productos
    #{té, 25$, 150}
    #{azúcar, 4$, 500}

    When introduzco nuevo ingrediente "vitamina C" al producto "pulpo"
    Then sale un mensaje que ha ocurridoun error
    #Lo sentimos no se pude agregar el producto no existe.