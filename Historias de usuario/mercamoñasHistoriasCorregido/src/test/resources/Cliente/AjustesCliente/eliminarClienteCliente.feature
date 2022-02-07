Feature: como cliente quiero eliminar mi cuenta

  Scenario: elimino mi cuenta con éxito
    Given mis datos

    When elimino mi cuenta
    Then sale mensaje si estoy seguro de eliminar mi cuenta
    And acepto
    And sale mensaje así
    # Su cuenta ha sido eliminada con éxito

  Scenario: cancelo mi eliminación de la cuenta
    Given mis datos

    When elimino mi cuenta
    Then te sale mensaje si estoy seguro de eliminar mi cuento
    And rechazo
    And sale mensaje así
    # Ha cancelado la eliminación de la cuenta