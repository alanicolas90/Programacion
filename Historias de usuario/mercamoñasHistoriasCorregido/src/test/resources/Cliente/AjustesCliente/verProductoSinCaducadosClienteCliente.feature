Feature: como cliente quiero ver todos los productos sin los productos caducados

  Scenario: ver toda la lista de productos sin los caducados
    Given lista de productos
    #{{té, 25$, 150} 01-01-2023}
    #{{azúcar, 4$, 500} 01-02-2024}
    #{{chocolate, 5$ ,600} 10-08-2018}

    When pido la lista de todos los productos
    Then te sale toda la lista de productos
    #{{té, 25$, 150} 01-01-2023}
    #{{azúcar, 4$, 500} 01-02-2024}