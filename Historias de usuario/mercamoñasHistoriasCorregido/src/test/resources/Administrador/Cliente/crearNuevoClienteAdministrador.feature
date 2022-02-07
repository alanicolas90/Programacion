Feature: Como administrador quiero registrar a un nuevo cliente

  Scenario: registro a un nuevo cliente con éxito
    Given lista de clientes
    # {3427928, alan, mikolajczyk}
    # {2399876, paula, mikolajczyk}
    And dni nuevo cliente 2798712
    And nombre nuevo cliente joanna
    And apellido nuevo cliente mikolajczyk

    When agrego nuevo cliente
    Then sale mensaje de éxito
    And lista de clientes queda así
    # {3427928, alan, mikolajczyk}
    # {2399876, paula, mikolajczyk}
    # {2798712, joanna, mikolajczyk}

  Scenario:cliente ya existe
    Given lista de clientes
    # {3427928, alan, mikolajczyk}
    # {2399876, paula, mikolajczyk}
    And dni nuevo cliente 3427928
    And nombre nuevo cliente joanna
    And apellido nuevo cliente mikolajczyk

    When agrego nuevo cliente
    Then sale error porque ya hay un cliente con un dni igual
