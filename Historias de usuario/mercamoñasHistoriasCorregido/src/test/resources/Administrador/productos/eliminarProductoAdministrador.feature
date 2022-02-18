Feature: Como administrador quiero eliminar un producto
Las listas de productos tienen formato {nombre, precio, stock}

  Scenario: Agrego el producto con éxito
    Given lista de productos
    #{té, 25$, 150}
    #{azúcar, 4$, 500}

    When introduzco producto para eliminar "tè"
    Then me sale mensaje que ha sido un éxito
    And sale lista de productos así
    #{azúcar, 4$, 500}

  Scenario: No encuentra el nombre del producto
    Given lista de productos
    #{té, 25$, 150}
    #{azúcar, 4$, 500}

    When escribo producto vodka
    Then sale error porque lo existe un producto así
    And te sale un mensaje así
    #Lo sentimos mucho no existe un producto con un nombre así. Inténtelo de nuevo
