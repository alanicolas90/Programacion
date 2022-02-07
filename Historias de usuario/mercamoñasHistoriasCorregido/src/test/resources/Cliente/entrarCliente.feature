Feature: Como usuario quiero entrar como cliente

  Scenario: Entro como cliente
    Given lista de clientes (oculta para usuario)
    # {3427928, alan, mikolajczyk}
    # {2399876, paula, mikolajczyk}

    When introduzco dni 3427928
    Then entras
    And te sale un mensaje así
    # Bienvenido alan
    And te sale una lista así
    # 1) Comprar
    # 2) Ajustes


  Scenario: Cliente datos incorrectos
    Given lista de clientes (oculta para usuario)
    # {3427928, alan, mikolajczyk}
    # {2399876, paula, mikolajczyk}

    When introduzco dni 0000000
    Then me da error porque no existe un cliente con ese dni
    And te sale un mensaje así
    # No existe un cliente con esos datos, por favor inténtelo de nuevo


