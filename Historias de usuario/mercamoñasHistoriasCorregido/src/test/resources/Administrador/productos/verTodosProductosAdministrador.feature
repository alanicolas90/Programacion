Feature: como administrador quiero ver todos los productos

  Scenario: ver toda la lista de productos
    Given lista de productos
    #{té, 25$, 150}
    #{azúcar, 4$, 500}
    #{chocolate, 5$ ,600}

    When pido la lista de todos los productos
    Then te sale toda la lista de productos
    #{té, 25$, 150}
    #{azúcar, 4$, 500}
    #{chocolate, 5$ ,600}