Feature: como cliente quiero agregar dinero a una tarjeta

  Scenario: agrego dinero con éxito

    Given lista de tarjetas
    # {0550 0621, 0$}
    # {9876 1234, 0$}
    And número de cuenta 0550 0621
    And dinero a ingresar 15

    When ingreso 15 en número de cuenta 0550 0621
    Then sale mensaje que ha sido un éxito
    And lista de tarjetas queda así
    # {0550 0621, 15$}
    # {9876 1234, 0$}

  Scenario: no encuentra número de cuenta

    Given lista de tarjetas
    # {0550 0621, 0$}
    # {9876 1234, 0$}
    And número de cuenta 1212 1212
    And dinero a ingresar 15

    When ingreso 15 en número de cuenta 1212 1212
    Then sale error porque no existe un número de cuenta así
    And lista de tarjetas queda igual