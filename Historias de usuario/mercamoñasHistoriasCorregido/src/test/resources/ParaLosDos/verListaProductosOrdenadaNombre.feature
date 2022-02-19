Feature: como usuario quiero ver la lista de productos ordenada por nombre

  Scenario: ver toda la lista de productos ordenada por nombre
    Given lista de productos
    #{té, 25$, 150}
    #{azúcar, 4$, 500}
    #{chocolate, 5$ ,600}

    When pido la lista de todos los productos ordenada por nombre
    Then te sale toda la lista de productos ordenada por nombre
    #{azúcar, 4$, 500}
    #{chocolate, 5$ ,600}
    #{té, 25$, 150}
