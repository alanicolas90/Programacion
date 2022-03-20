Feature: Como administrador quiero dar de baja a un sicario

  Scenario: das de baja a un sicario con misión en curso con éxito
    Given lista de encargos
    #{foto1.jpg, 8000,3,validado}

    And lista de sicarios
    #{Pepe, Alsacia, 2, 200$}
    #{Jose, Parla, 4, 3000}

    When doy de baja sicario con nombre Jose
    Then sale un mensaje que ha sido un éxito
    And lista de encargos así
    #{foto1.jpg, 8000,3, entrada}
    And lista de sicarios
    #{Pepe, Alsacia, 2, 200$}

  Scenario: das de baja a un sicario sin misión en curso con éxito
    Given lista de sicarios
    #{Pepe, Alsacia, 2, 200$}
    #{Jose, Parla, 4, 3000}

    When doy de baja sicario con nombre Jose
    Then sale un mensaje que ha sido un éxito
    And lista de sicarios
    #{Pepe, Alsacia, 2, 200$}