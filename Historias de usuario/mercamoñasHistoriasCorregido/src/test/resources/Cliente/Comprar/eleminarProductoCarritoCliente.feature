Feature: como cliente quiero eliminar un producto de mi carrito

  Scenario: elimino un producto de mi carrito con éxito
    Given carrito de compra
    # {té, 25$, 5}
    # {azúcar, 4$, 2}
    # {chocolate, 5$, 4}
    And nombre del producto a eliminar
    # chocolate
    And cantidad a eliminar
    # 2

    When elimino 2 de chocolate
    Then sale un mensaje que ha sido un éxito
    And carrito de compra queda así
    # {té, 25$, 5}
    # {azúcar, 4$, 2}
    # {chocolate, 5$, 2}

  Scenario: nombre de producto no existe
    Given carrito de compra
    # {té, 25$, 5}
    # {azúcar, 4$, 2}
    # {chocolate, 5$, 4}
    And nombre del producto a eliminar
    # cacao
    And cantidad a eliminar
    # 2

    When elimino 2 de cacao
    Then sale un error porque no existe

  Scenario: cantidad de producto a eliminar es demasiado
    Given carrito de compra
    # {té, 25$, 5}
    # {azúcar, 4$, 2}
    # {chocolate, 5$, 4}
    And nombre del producto a eliminar
    # chocolate
    And cantidad a eliminar
    # 5

    When elimino 5 de chocolate
    Then sale error porque no hay tanto producto