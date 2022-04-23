Feature: como usuario quiero ver el porcentaje de lo que se me va en cada compra durante el mes

  Scenario: veo los porcentajes de todos mis gastos en el mes que quiera verlo
    Given mes en el que quiero ver los gastos
    And lista de gastos
    #gasto{"nombre": "cafe", "fecha": "2020-01-01", "importe": "10.00"}
    #gasto{"nombre": "cuadernos", "fecha": "2020-01-02", "importe": "7.00"}
    #gasto{"nombre": "comida", "fecha": "2020-01-03", "importe": "87.00"}
    When veo los porcentajes de gastos
    Then veo el porcentaje de gastos así:
      | gasto | porcentaje |
      | comida | 87.00% |
      | cafe | 10.00% |
      | cuadernos | 7.00% |
