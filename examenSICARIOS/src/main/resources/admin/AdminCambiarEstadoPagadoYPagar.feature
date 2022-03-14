Feature: Como administrador quiero cambiar el estado del encargo a pagado

  Scenario: cambio el estado con éxito
    Given lista de encargos
    # {foto.jpg,3.000$ 2, CUMPLIDO}
    # {fotoS.jpg,20.000$, 5, PAGADO}
    And sicario {Manuel, Parla, 5, 7.000$}

    When cambio el estado del encargo {foto.jpg,3000$ 2, CUMPLIDO} a PAGADO
    Then sale un mensaje que ha sido un éxito
    And lista de escargos queda así
    # {foto.jpg,3000$ 2, PAGADO}
    # {fotoS.jpg,20000$, 5, PAGADO}
    And sicario así
    #{Manuel, Parla, 5, 10.000$}