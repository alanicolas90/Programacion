Feature: Como administrador quiero ver la lista de Clientes ordenada por dni

  Scenario: veo la lista de clientes ordenada
    Given lista de clientes
    # {3427928, alan, mikolajczyk}
    # {2399876, paula, mikolajczyk}

    When pido la lista de todos los clientes ordenada por dni
    Then te sale toda la lista de cliente ordenada por dni
    # {2399876, paula, mikolajczyk}
    # {3427928, alan, mikolajczyk}
