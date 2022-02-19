Feature: como usuario quiero ver la lista de productos con sus ingredientes

  Scenario: ver toda la lista de productos con sus ingredientes
    Given lista de productos
    #{té, 25$, 150 Ingredientes="camelia sinesis"}
    #{chocolate, 5$ ,600, Ingredientes="leche, cacao, azúcar"}

    When pido la lista de todos los productos con sus ingredientes
    Then te sale toda la lista de productos con sus ingredientes
    #{té, 25$, 150 Ingredientes="camelia sinesis"}
    #{chocolate, 5$ ,600, Ingredientes="leche, cacao, azúcar"}