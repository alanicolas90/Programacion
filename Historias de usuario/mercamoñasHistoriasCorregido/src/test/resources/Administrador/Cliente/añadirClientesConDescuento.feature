Feature: Como administrador quiero registrar a un nuevo cliente con descuento

  Scenario: registro a un nuevo cliente con éxito
    Given lista de clientes
    # {3427928, alan, mikolajczyk}
    # {2399876, paula, mikolajczyk}
    And dni nuevo cliente 2798712
    And nombre nuevo cliente joanna
    And apellido nuevo cliente mikolajczyk
    And descuento 50%

    When agrego nuevo cliente
    Then sale mensaje de éxito
    And lista de clientes queda así
    # {3427928, alan, mikolajczyk}
    # {2399876, paula, mikolajczyk}
    # {{2798712, joanna, mikolajczyk,} 50%}

  Scenario:cliente ya existe
    Given lista de clientes
    # {3427928, alan, mikolajczyk}
    # {2399876, paula, mikolajczyk}
    And dni nuevo cliente 3427928
    And nombre nuevo cliente joanna
    And apellido nuevo cliente mikolajczyk
    And descuento 50%

    When agrego nuevo cliente
    Then sale error porque ya hay un cliente con un dni igual

  Scenario: descuento no es válido porque es demasiado
    Given lista de clientes
    # {3427928, alan, mikolajczyk}
    # {2399876, paula, mikolajczyk}
    And dni nuevo cliente 3427928
    And nombre nuevo cliente joanna
    And apellido nuevo cliente mikolajczyk
    And descuento 101%

    When agrego nuevo cliente
    Then sale error porque el descuento es demasiado

  Scenario: descuento no es válido porque es demasiado poco
    Given lista de clientes
    # {3427928, alan, mikolajczyk}
    # {2399876, paula, mikolajczyk}
    And dni nuevo cliente 3427928
    And nombre nuevo cliente joanna
    And apellido nuevo cliente mikolajczyk
    And descuento -12%

    When agrego nuevo cliente
    Then sale error porque el descuento es demasiado poco