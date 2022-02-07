Feature: como administrador quiero cambiar el stock del producto

  Scenario: Cambio el stock del producto con éxito
    Given una lista de productos así
    #{té, 25$, 150}
    #{azúcar, 4$, 500}
    #{chocolate, 5$ ,600}
    And nombre de producto chocolate
    And nuevo stock 1050

    When cambio el stock de chocolate a 1050
    Then sale un mensaje de que ha sido un éxito
    And la lista de productos queda así
    #{té, 25$, 150}
    #{azúcar, 4$, 500}
    #{chocolate, 5$ ,1050}

  Scenario: No encuentra el nombre del producto
    Given una lista de producto así
    #{té, 25$, 150}
    #{azúcar, 4$, 500}
    #{chocolate, 5$ ,600}
    And nombre de producto vermut
    And nuevo stock 1050

    When cambio el stock de vermut a 1050
    Then sale error porque no hay un vermut en la lista de productos

  Scenario: Valor incorrecto en el nuevo stock
    Given una lista de producto así
    #{té, 25$, 150}
    #{azúcar, 4$, 500}
    #{chocolate, 5$ ,600}
    And nombre de producto chocolate
    And nuevo stock mil cincuenta

    When cambio el stock de chocolate a mil cincuenta
    Then sale error porque el valor no es numérico

