Feature: como cliente quiero agregar tarjeta

  Scenario: agrego la tarjeta con éxito

    Given lista de tarjetas
    # {0550 0621}
    # {9876 1234}
    And nueva tarjeta 9876 4321

    When agrego nueva tarjeta
    Then sale un mensaje que ha sido un éxito
    And lista de tarjetas queda así
    # {0550 0621}
    # {9876 1234}
    # {9876 4321}
