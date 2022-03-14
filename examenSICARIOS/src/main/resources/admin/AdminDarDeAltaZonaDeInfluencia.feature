Feature: Como administrador quiero dar de alta zona de influencia

  Scenario: Añado zona de influencia con éxito
    Given lista de zonas de influencia
    # {Parla, 5}
    # {Getafe, 2}

    When introduzco nueva zona de influencia {Alsacia, 4}
    Then te sale un mensaje que ha sido un éxito
    And lista de zonas de influencia así
    # {Parla, 5}
    # {Getafe, 2}
    # {Alsacia, 4}

  Scenario: la cantidad de máximos sicarios en la zona supera el número máximo que se puede tener(5)
    Given lista de zonas de influencia
    # {Parla, 5}
    # {Getafe, 2}

    When introduzco nueva zona de influencia {Alsacia, 7}
    Then te sale un mensaje que ha habido un error
    # Lo sentimos pero la capacidad máxima de sicarios en una zona es 5 y usted ha puesto 7