Feature: como usuario quiero añadir un gasto normal

  Scenario: añado un gasto
    Given gasto{"nombre": "cafe", "fecha": "2020-01-01", "importe": "10.00"}
    When añado el gasto
    Then el gasto se añade correctamente

  Scenario: error al añadir gasto por la fecha
    Given gasto{"nombre": "cafe", "fecha": "2020-01-01", "importe": "10.00"}
    And estamos a 2019-01-01
    When añado el gasto
    Then el gasto no se añade
    And sale mensaje así
    #lo sentimos la fecha introducida no es válida

  Scenario: error al añadir gasto por el importe
    Given gasto{"nombre": "cafe", "fecha": "2020-01-01", "importe": "hola"}
    When añado el gasto
    Then el gasto no se añade
    And sale mensaje así
    #lo sentimos el importe introducido no es válido

