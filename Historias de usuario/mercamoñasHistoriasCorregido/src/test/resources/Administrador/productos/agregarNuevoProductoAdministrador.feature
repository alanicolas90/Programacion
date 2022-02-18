Feature: Como administrador quiero agregar nuevo producto

  Scenario: Agrego el producto con éxito
    Given lista de productos
    #{té, 25$, 150}
    #{azúcar, 4$, 500}

    When introduzco nuevo producto {sal, 4$,750}
    Then me sale mensaje que ha sido un éxito
    And sale lista de productos así
    #{té, 25$, 150}
    #{azúcar, 4$, 500}
    #{sal, 4$,750}

  Scenario: El producto ya existe
    Given lista de productos
    #{té, 25$, 150}
    #{azúcar, 4$, 500}

    When introduzco nuevo producto {té, 20$, 750}
    Then me da un error que el producto ya existe
    And te sale un mensaje así
    #Lo sentimos no se pude agregar el producto por que ya existe.

  Scenario: El precio ha sido mal introducido
    Given lista de productos
    #{té, 25$, 150}
    #{azúcar, 4$, 500}

    When introduzco nuevo producto {sal, siete$,750}
    Then me da un error que el precio no está bien escrito
    And te sale un mensaje así
    #Lo sentimos el precio está escrito en un formato inválido, por favor inténtelo de nuevo

  Scenario: El stock ha sido mal introducido
    Given lista de productos
    #{té, 25$, 150}
    #{azúcar, 4$, 500}

    When introduzco nuevo producto {sal, 4$, mil}
    Then me da un error que el stock no está bien escrito
    And te sale un mensaje así
    #Lo sentimos el stock está escrito en un formato inválido, por favor inténtelo de nuevo

