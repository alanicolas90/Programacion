Feature: como cliente quiero comprar un producto

  Scenario: Compro un producto con éxito
    Given lista de productos
    #{té, 25$, 150}
    #{azúcar, 4$, 500}
    #{chocolate, 5$, 50}
    And tu carrito de compra así
    #{}
    And nombre del producto que quiero comprar
    #chocolate
    And cantidad del producto que quiero comprar
    #10

    When compro 10 de chocolate
    Then sale un mensaje que ha sido un éxito
    And lista de producto queda así
    #{té, 25$, 150}
    #{azúcar, 4$, 500}
    #{chocolate, 5$, 40}
    And tu carrito de compra queda así
    #{chocolate, 5$, 10}

  Scenario: nombre del producto no existe
    Given lista de productos
    #{té, 25$, 150}
    #{azúcar, 4$, 500}
    #{chocolate, 5$, 50}
    And tu carrito de compra así
    #{}
    And nombre del producto que quiero comprar
    #cacao
    And cantidad del producto que quiero comprar
    #10

    When compro 10 de cacao
    Then sale error porque no hay un producto con ese nombre

  Scenario: no hay suficiente stock
    Given lista de productos
    #{té, 25$, 150}
    #{azúcar, 4$, 500}
    #{cacao, 5$, 5}
    And tu carrito de compra así
    #{}
    And nombre del producto que quiero comprar
    #cacao
    And cantidad del producto que quiero comprar
    #10

    When compro 10 de cacao
    Then sale error porque no hay suficiente cantidad
