Feature: Como cliente quiero cambiar el nombre

  Scenario: cambio mi nombre con éxito

    Given mis datos
    # Nombre: Alan
    # Apellido: Mikolajczyk
    # Dni: 3427928
    And nuevo nombre Pepe

    When cambio nombre de alan a pepe
    Then sale mensaje que si estoy seguro de cambiar el nombre a pepe
    And acepto
    And sale mensaje que el cambio ha sido un éxito
    And datos quedan así
    # Nombre: Pepe
    # Apellido: Mikolajczyk
    # Dni: 3427928


  Scenario: rechazo el cambio de mi nombre

    Given mis datos
    # Nombre: Alan
    # Apellido: Mikolajczyk
    # Dni: 3427928
    And nuevo nombre Pepe

    When cambio nombre de alan a pepe
    Then sale mensaje que si estoy seguro de cambiar el nombre a pepe
    And rechazo
    And sale mensaje que se ha anulado el cambio
    And los datos siguen igual