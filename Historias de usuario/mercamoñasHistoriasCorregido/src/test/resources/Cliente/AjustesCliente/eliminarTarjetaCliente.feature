Feature: como cliente quiero eliminar una tarjeta

  Scenario: elimino tarjeta con éxito

    Given lista de tarjetas
    # {0550 0621, 0$}
    # {9876 1234, 0$}
    And número de cuenta 0550 0621

    When elimino tarjeta con número de cuenta 0550 0621
    Then sale mensaje que ha sido un éxito
    And lista de tarjetas queda así
    # {9876 1234, 0$}

  Scenario: no encuentra número de cuenta

    Given lista de tarjetas
    # {0550 0621, 0$}
    # {9876 1234, 0$}
    And número de cuenta 1212 1212

    When elimino tarjeta con número de cuenta 1212 1212
    Then sale error porque no existe número de cuenta con ese número