Feature: como administrador quiero cambiar el apellido al cliente

  Scenario: cambio de apellido con éxito
    Given lista de clientes
    # {3427928, alan, mikolajczyk}
    # {2399876, paula, mikolajczyk}
    And el dni del cliente al que voy a cambiar apellido 3427928
    And nuevo apellido nogales

    When cambio el apellido de mikolajczyk a nogales
    Then sale mensaje de éxito
    And lista de clientes queda así
    # {3427928, alan, nogales}
    # {2399876, paula, mikolajczyk}

  Scenario: no encuentra cliente
    Given lista de clientes
    # {3427928, alan, mikolajczyk}
    # {2399876, paula, mikolajczyk}
    And el dni del cliente al que voy a cambiar apellido 0000000
    And nuevo apellido nogales

    When cambio el apellido de mikolajczyk a nogales
    Then sale mensaje de error porque no hay cliente con ese dni

