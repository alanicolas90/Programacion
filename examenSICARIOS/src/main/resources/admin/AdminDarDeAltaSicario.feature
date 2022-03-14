Feature: Como administrador quiero dar de alta a un sicario

  Scenario: doy de alta al sicario con éxito
    Given lista de sicarios
    #{José, Alsacia, 4, 8700$}
    #{Almudena, Parla, 5, 10000$}

    When introduzco nuevo sicario {Manuel, Getafe, 2, 400$}
    Then me sale un mensaje que ha sido un éxito
    And te lsa lista de sicarios así
    # {José, Alsacia, 4, 8700$}
    # {Almudena, Parla, 5, 10000$}
    # {Manuel, Getafe, 2, 400$}

  Scenario: el nivel de habilidad excede el máximo (5)
    Given lista de sicarios
    #{José, Alsacia, 4, 8700$}
    #{Almudena, Parla, 5, 10000$}

    When introduzco nuevo sicario {Manuel, Getafe, 7, 400$}
    Then me sale un mensaje que ha habido un error
    # Lo sentimos no se puede exceder el nivel de habilidad de 5 y usted ha puesto 7