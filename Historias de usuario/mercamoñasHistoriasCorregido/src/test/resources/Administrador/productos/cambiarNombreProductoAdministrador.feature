Feature: como administrador quiero cambiar el nombre del producto

  Scenario: Cambio del nombre del producto con éxito
    Given una lista de productos así
    #{té, 25$, 150}
    #{azúcar, 4$, 500}
    #{chocolate, 5$ ,600}
    And nombre de producto chocolate
    And nuevo nombre de producto cacao

    When cambio el nombre chocolate a cacao
    Then sale un mensaje de que ha sido un éxito
    And la lista de productos queda así
    #{té, 25$, 150}
    #{azúcar, 4$, 500}
    #{cacao, 5$ ,600}

  Scenario: No encuentra el nombre del producto
    Given una lista de producto así
    #{té, 25$, 150}
    #{azúcar, 4$, 500}
    #{chocolate, 5$ ,600}
    And nombre de producto vermut
    And nuevo nombre de producto cacao

    When cambio el nombre de producto de vermut a cacao
    Then sale error porque no hay un vermut en la lista de productos
