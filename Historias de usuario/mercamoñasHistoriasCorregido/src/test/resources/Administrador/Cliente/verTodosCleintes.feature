Feature: como administrador quiero ver todos los clientes

  Scenario: ver toda la lista de clientes
    Given lista de clientes
    # {3427928, alan, mikolajczyk}
    # {2399876, paula, mikolajczyk}

    When pido la lista de todos los clientes
    Then te sale toda la lista de clientes
    # {3427928, alan, mikolajczyk}
    # {2399876, paula, mikolajczyk}