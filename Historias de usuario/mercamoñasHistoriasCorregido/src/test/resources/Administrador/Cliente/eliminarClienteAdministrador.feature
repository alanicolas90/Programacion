Feature: Como administrador quiero eliminar a un cliente

  Scenario: elimino a un cliente
    Given lista de clientes
    # {3427928, alan, mikolajczyk}
    # {2399876, paula, mikolajczyk}
    And dni cliente eliminar 3427928

    When elimino cliente 3427928
    Then sale mensaje de éxito
    And lista de clientes queda así
    # {2399876, paula, mikolajczyk}

  Scenario: no encuentra cliente
    Given lista de clientes
    # {3427928, alan, mikolajczyk}
    # {2399876, paula, mikolajczyk}
    And dni nuevo cliente 0000000

    When elimino cliente 0000000
    Then sale error porque no hay cliente con ese dni
