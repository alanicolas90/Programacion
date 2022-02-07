Feature: Como usuario quiero poner ficha para hacer 3 en raya y ganar.

  Scenario: Elige casilla y esta libre
    Given un tablero así
    # 0 - -
    # - - -
    # - - -
    When eliges la celda 2,2
    Then se pone el emoticono correspondiente en las coordenadas
    And cambio de jugador
    Then el tablero se queda así
    # 0 - -
    # - - -
    # - - X

  Scenario: Elige casilla y esta ocupado
    Given un tablero así
    # 0 - -
    # - - -
    # - - -
    When elige la celda 0,0
    Then te pide que vuelvas a poner otra coordenada nuevamente

  Scenario: Elige una coordenada fuera del limite del tablero
    Given un tablero así
    # 0 - -
    # - - -
    # - - -
    When eliges la celda 4,3
    Then te pide que vuelvas a poner otra coordenada nuevamente
    And mostrando en números el tamaño del tablero

  Scenario: Elige casilla y gana
    Given turno del jugador 0 y un tablero así
    # 0 X X
    # 0 0 x
    # X - -
    When elige la celda 2,2
    Then tablero se queda así
    # 0 X X
    # 0 0 x
    # X - 0
    Then gana jugador de las fichas redondas
    And felicita al jugador por ganar
