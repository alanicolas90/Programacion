Feature: como administrador quiero cambiar el precio del producto

  Scenario: Cambio el precio del producto con éxito
    Given una lista de productos así
    #{té, 25$, 150}
    #{azúcar, 4$, 500}
    #{chocolate, 5$ ,600}
    And nombre de producto chocolate
    And nuevo precio 7

    When cambio el precio de chocolate a 7
    Then sale un mensaje de que ha sido un éxito
    And la lista de productos queda así
    #{té, 25$, 150}
    #{azúcar, 4$, 500}
    #{chocolate, 7$ ,600}

  Scenario: No encuentra el nombre del producto
    Given una lista de producto así
    #{té, 25$, 150}
    #{azúcar, 4$, 500}
    #{chocolate, 5$ ,600}
    And nombre de producto vermut
    And nuevo precio 7

    When cambio el precio de vermut a 7
    Then sale error porque no hay un vermut en la lista de productos

  Scenario: Valor incorrecto en el nuevo precio
    Given una lista de producto así
    #{té, 25$, 150}
    #{azúcar, 4$, 500}
    #{chocolate, 5$ ,600}
    And nombre de producto chocolate
    And nuevo precio siete

    When cambio el precio de chocolate a siete
    Then sale error porque el valor no es numérico

