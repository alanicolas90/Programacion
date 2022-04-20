Feature: como usuario quiero añadir un gasto recurrente

  Scenario: añado un gasto
    Given gasto{"nombre": "cafe", "fecha": "2020-01-01", "importe": "10.00", "recurrencia": "mensual"}
    When añado el gasto
    Then el gasto se añade correctamente
    When añado un gasto recurrente
    Then el gasto recurrente se añade correctamente
    When añado el gasto
    Then el gasto se añade correctamente

  Scenario: error al añadir gasto por la fecha
    Given gasto{"nombre": "cafe", "fecha": "2020-01-01", "importe": "10.00", "recurrencia": "mensual"}
    And estamos a 2019-01-01
    When añado el gasto
    Then el gasto no se añade
    And sale mensaje así
    #lo sentimos la fecha introducida no es válida

  Scenario: error al añadir gasto por el importe
    Given gasto{"nombre": "cafe", "fecha": "2020-01-01", "importe": "hola", "recurrencia": "mensual"}
    When añado el gasto
    Then el gasto no se añade
    And sale mensaje así
    #lo sentimos el importe introducido no es válido

