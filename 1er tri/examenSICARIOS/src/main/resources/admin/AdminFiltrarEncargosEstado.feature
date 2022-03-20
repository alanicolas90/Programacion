Feature: Como administrador quiero filtrar la lista de encargos por su estado

  Scenario: se muestra la lista de encargos filtrada por entrada
    Given lista de encargos
    # {foto.jpg, 2, ENTRADA}
    # {fotoS.jpg, 5, PAGADO}
    # {fotoT.jpg, 1, ENTRADA}
    # {fotoH.jpg, 3, CUMPLIDO}
    # {fotoC.jpg, 4, ENTRADA}
    # {foto.jpg, 1, ESPERANDO CONFIRMACIÓN}
    # {foto.jpg, 4, PAGADO}
    # {foto.jpg, 2, VALIDADO}
    # {foto.jpg, 5, ESPERANDO CONFIRMACIÓN}
    # {foto.jpg, 2, VALIDADO}
    # {foto.jpg, 3, ESPERANDO CONFIRMACIÓN}
    # {foto.jpg, 3, PAGADO}

    When pido lista filtrada por entrada
    Then sale la lista así
    # {foto.jpg, 2, ENTRADA}
    # {fotoT.jpg, 1, ENTRADA}
    # {fotoC.jpg, 4, ENTRADA}


  Scenario: se muestra la lista de encargos filtrada por el estado esperando confirmación
    Given lista de encargos
    # {foto.jpg, 2, ENTRADA}
    # {fotoS.jpg, 5, PAGADO}
    # {fotoT.jpg, 1, ENTRADA}
    # {fotoH.jpg, 3, CUMPLIDO}
    # {fotoC.jpg, 4, ENTRADA}
    # {foto.jpg, 1, ESPERANDO CONFIRMACIÓN}
    # {foto.jpg, 4, PAGADO}
    # {foto.jpg, 2, VALIDADO}
    # {foto.jpg, 5, ESPERANDO CONFIRMACIÓN}
    # {foto.jpg, 2, VALIDADO}
    # {foto.jpg, 3, ESPERANDO CONFIRMACIÓN}
    # {foto.jpg, 3, PAGADO}

    When pido lista filtrada por el estado esperando confirmación
    Then sale la lista así
    # {foto.jpg, 1, ESPERANDO CONFIRMACIÓN}
    # {foto.jpg, 5, ESPERANDO CONFIRMACIÓN}
    # {foto.jpg, 3, ESPERANDO CONFIRMACIÓN}

  Scenario: se muestra la lista de encargos filtrada por el estado validado
    Given lista de encargos
    # {foto.jpg, 2, ENTRADA}
    # {fotoS.jpg, 5, PAGADO}
    # {fotoT.jpg, 1, ENTRADA}
    # {fotoH.jpg, 3, CUMPLIDO}
    # {fotoC.jpg, 4, ENTRADA}
    # {foto.jpg, 1, ESPERANDO CONFIRMACIÓN}
    # {foto.jpg, 4, PAGADO}
    # {foto.jpg, 2, VALIDADO}
    # {foto.jpg, 5, ESPERANDO CONFIRMACIÓN}
    # {foto.jpg, 2, VALIDADO}
    # {foto.jpg, 3, ESPERANDO CONFIRMACIÓN}
    # {foto.jpg, 3, PAGADO}

    When pido lista filtrada por el estado validado
    Then sale la lista así
    # {foto.jpg, 2, VALIDADO}
    # {foto.jpg, 2, VALIDADO}

  Scenario: se muestra la lista de encargos filtrada por el estado cumplido
    Given lista de encargos
    # {foto.jpg, 2, ENTRADA}
    # {fotoS.jpg, 5, PAGADO}
    # {fotoT.jpg, 1, ENTRADA}
    # {fotoH.jpg, 3, CUMPLIDO}
    # {fotoC.jpg, 4, ENTRADA}
    # {foto.jpg, 1, ESPERANDO CONFIRMACIÓN}
    # {foto.jpg, 4, PAGADO}
    # {foto.jpg, 2, VALIDADO}
    # {foto.jpg, 5, ESPERANDO CONFIRMACIÓN}
    # {foto.jpg, 2, VALIDADO}
    # {foto.jpg, 3, ESPERANDO CONFIRMACIÓN}
    # {foto.jpg, 3, PAGADO}

    When pido lista filtrada por el estado cumplido
    Then sale la lista así
    # {fotoH.jpg, 3, CUMPLIDO}

  Scenario: se muestra la lista de encargos filtrada por el estado pagado
    Given lista de encargos
    # {foto.jpg, 2, ENTRADA}
    # {fotoS.jpg, 5, PAGADO}
    # {fotoT.jpg, 1, ENTRADA}
    # {fotoH.jpg, 3, CUMPLIDO}
    # {fotoC.jpg, 4, ENTRADA}
    # {foto.jpg, 1, ESPERANDO CONFIRMACIÓN}
    # {foto.jpg, 4, PAGADO}
    # {foto.jpg, 2, VALIDADO}
    # {foto.jpg, 5, ESPERANDO CONFIRMACIÓN}
    # {foto.jpg, 2, VALIDADO}
    # {foto.jpg, 3, ESPERANDO CONFIRMACIÓN}
    # {foto.jpg, 3, PAGADO}

    When pido lista filtrada por el estado pagado
    Then sale la lista así
    # {fotoS.jpg, 5, PAGADO}
    # {foto.jpg, 4, PAGADO}
    # {foto.jpg, 3, PAGADO}

