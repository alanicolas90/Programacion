Feature: como administrador quiero cambiar el nombre al cliente

  Scenario: cambio de nombre con éxito
    Given lista de clientes
    # {3427928, alan, mikolajczyk}
    # {2399876, paula, mikolajczyk}
    And dni cliente cambiar nombre 3427928
    And nuevo nombre pepe

    When cambio el nombre de alan a pepe
    Then sale mensaje de éxito
    And lista de clientes queda así
    # {3427928, pepe, mikolajczyk}
    # {2399876, paula, mikolajczyk}

  Scenario: no encuentra cliente
    Given lista de clientes
    # {3427928, alan, mikolajczyk}
    # {2399876, paula, mikolajczyk}
    And dni cliente cambiar nombre 0000000
    And nuevo nombre pepe

    When cambio el nombre de alan a pepe
    Then sale mensaje de error porque no hay cliente con ese dni

