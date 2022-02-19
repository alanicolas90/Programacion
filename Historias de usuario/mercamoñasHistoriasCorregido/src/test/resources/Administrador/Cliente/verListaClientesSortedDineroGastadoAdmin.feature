Feature: como administrador quiero ver la lista de clientes ordenada por el dinero gastado en total

  Scenario: ver toda la lista de clientes ordenada por el dinero total que han gastado en total en la tienda
    Given lista de clientes
    # {3427928, alan, mikolajczyk}
    # {2399876, paula, mikolajczyk}

    When pido la lista de todos los clientes ordenada por el dinero total que han gastado en total en la tienda
    Then te sale toda la lista de clientes ordenada por el dinero total que han gastado en total en la tienda
    # {3427928, alan, mikolajczyk}
    # {2399876, paula, mikolajczyk}