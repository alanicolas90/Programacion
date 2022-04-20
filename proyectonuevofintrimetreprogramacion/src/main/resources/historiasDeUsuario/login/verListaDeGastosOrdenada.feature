Feature: ver lista de gastos ordenada de mas a menos

  Scenario: veo la lista de gastos ordenada
    Given lista de gastos así
    #gasto{"nombre": "cafe", "fecha": "2020-01-01", "importe": "10.00"}
  #gasto{"nombre": "quesos", "fecha": "2020-01-01", "importe": "20.00"}
  #gasto{"nombre": "luz", "fecha": "2020-01-01", "importe": "321.00"}
    When ordeno la lista de gastos
    Then veo la lista de gastos ordenada
    #gasto{"nombre": "luz", "fecha": "2020-01-01", "importe": "321.00"}
    #gasto{"nombre": "quesos", "fecha": "2020-01-01", "importe": "20.00"}
    #gasto{"nombre": "cafe", "fecha": "2020-01-01", "importe": "10.00"}
