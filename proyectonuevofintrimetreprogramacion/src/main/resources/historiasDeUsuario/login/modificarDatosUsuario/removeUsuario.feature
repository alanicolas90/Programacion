Feature: como usuario quiero eliminar a un miembro

  Scenario: elimino un usuario
    Given contraseña del usuario es "123"
    And escribes la contraseña "123"
    When presionas el boton "Eliminar"
    Then el usuario es eliminado

    Scenario: no se elimina el usuario porque la contraseña es incorrecta
    Given contraseña del usuario es "1234"
    And escribes la contraseña "123"
    When presionas el boton "Eliminar"
    Then el usuario no es eliminado
    And sale un mensaje así
      #contraseña incorrecta, intentelo de nuevo