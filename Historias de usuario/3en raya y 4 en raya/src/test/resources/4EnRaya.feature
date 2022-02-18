Feature: Como usuario quiero poner ficha para hacer 4 en raya y ganar.

  Scenario: Elige columna y esta libre
    Given un tablero así
    # - - - - - - -
    # - - - - - - -
    # - - - - - - -
    # - - - - - - -
    # - - - - - - -
    # - - - - - - -

    When eliges la columna 3
    Then se pone el emoticono correspondiente en el fondo de la columna
    And cambio de jugador
    Then el tablero se queda así
    # - - - - - - -
    # - - - - - - -
    # - - - - - - -
    # - - - - - - -
    # - - - - - - -
    # - - - 0 - - -

  Scenario: Elige columna y esta ocupado
    Given un tablero así
    # x - - - - - -
    # x - - - - - -
    # x - - - - - -
    # 0 - - - - - -
    # 0 - - - - - -
    # 0 - - - - - -
    When elige la columna 0
    Then te pide que vuelvas a elegir otra columna
    And te muestra el tablero otra vez

  Scenario: Elige una columna fuera del limite del tablero
    Given un tablero así
    # - - - - - - -
    # - - - - - - -
    # - - - - - - -
    # - - - - - - -
    # - - - - - - -
    # - - - - - - -
    When eliges la columna 8
    Then te pide que vuelvas a elegir otra columna nuevamente
    And mostrando en números el tamaño del tablero

  Scenario: Elige columna y gana
    Given turno del jugador 0 y un tablero así
    # - - - - - - -
    # - - - - - - -
    # - - - - 0 - -
    # - - - - X - -
    # - - 0 0 X - -
    # X 0 X 0 X 0 X
    When elige la columna 3
    Then tablero se queda así
    # - - - - - - -
    # - - - - - - -
    # - - - - 0 - -
    # - - - 0 X - -
    # - - 0 0 X - -
    # X 0 X 0 X 0 X
    Then gana jugador de las fichas redondas
    And felicita al jugador por ganar
