Feature: como cliente quiero ver la lista de tarjetas

  Scenario: veo la lista de tarjetas
    Given lista de tarjetas
    # {0550 0621, 0$}
    # {9876 1234, 0$}

    When pido ver la lista de tarjetas
    Then te sale la lista así
    Given lista de tarjetas
    # {0550 0621, 0$}
    # {9876 1234, 0$}
