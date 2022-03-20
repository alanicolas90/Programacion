Feature: Como sicario quiero ver la lista de encargos que sea de un nivel igual o inferior a su nivel de habilidad

  Background: Los estados ESPERANDO CONFIRMACIÓN, VALIDADO,CUMPLIDO,PAGADO también se filtran (no aparecen).
  Scenario: veo la lista filtrada
    Given sicario {Jose, Parla, 3, 800$}
    And lista de encargos
    # {foto.jpg, 2, ENTRADA}
    # {fotoS.jpg, 5, ENTRADA}
    # {fotoT.jpg, 1, ENTRADA}
    # {fotoH.jpg, 3, ENTRADA}
    # {fotoC.jpg, 4, ENTRADA}
    # {foto.jpg, 1, ESPERANDO CONFIRMACIÓN}

    When sicario {Jose, Parla, 3, 800$} ve la lista de encargos
    Then lista de encargos sale así
    # {foto.jpg, 2, ENTRADA}
    # {fotoT.jpg, 1, ENTRADA}
    # {fotoH.jpg, 3, ENTRADA}