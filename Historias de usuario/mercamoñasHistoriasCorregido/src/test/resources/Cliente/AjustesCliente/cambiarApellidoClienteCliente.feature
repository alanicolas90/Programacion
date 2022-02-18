Feature: Como cliente quiero cambiar el apellido

  Scenario: cambio mi apellido con éxito

    Given mis datos
    # Nombre: Alan
    # Apellido: Mikolajczyk
    # Dni: 3427928
    And nuevo apellido Gabriel

    When cambio apellido de Mikolajczyk a Gabriel
    Then sale mensaje que si estoy seguro de cambiar el nombre a pepe
    And acepto
    And sale mensaje que el cambio ha sido un éxito
    And datos quedan así
    # Nombre: Alan
    # Apellido: Gabriel
    # Dni: 3427928


  Scenario: rechazo el cambio de mi apellido

    Given mis datos
    # Nombre: Alan
    # Apellido: Mikolajczyk
    # Dni: 3427928
    And nuevo apellido Gabriel

    When cambio apellido Mikolajczyk a Gabriel
    Then sale mensaje que si estoy seguro de cambiar el apellido a Gabriel
    And rechazo
    And sale mensaje que se ha anulado el cambio
    And los datos siguen igual