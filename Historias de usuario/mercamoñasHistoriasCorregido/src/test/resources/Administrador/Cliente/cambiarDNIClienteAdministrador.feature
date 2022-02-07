Feature: como administrador quiero cambiar el dni al cliente

  Scenario: cambio de dni con éxito
    Given lista de clientes
    # {3427928, alan, mikolajczyk}
    # {2399876, paula, mikolajczyk}
    And dni del cliente 3427928
    And nuevo dni 0000000

    When cambio el dni de 3427928 a 0000000
    Then sale mensaje de éxito
    And lista de clientes queda así
    # {0000000, alan, mikolajczyk}
    # {2399876, paula, mikolajczyk}

  Scenario: no encuentra cliente
    Given lista de clientes
    # {3427928, alan, mikolajczyk}
    # {2399876, paula, mikolajczyk}
    And el deni del cliente 0022200
    And nuevo nuevo dni 0000000

    When cambio el dni de 0022200 a 0000000
    Then sale mensaje de error porque no hay cliente con ese dni

