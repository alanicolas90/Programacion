Feature: como cliente con descuento quiero pagar el carrito de compra y se aplique mi descuento correspondiente

  Scenario: pago con éxito

    Given tu carrito de compra
    # {té, 25$, 5}
    # {azúcar, 4$, 2}
    # {chocolate, 5$, 4}
    And precio del carrito
    # 128$
    And precio total del carrito con el descuento
    # 102,4$
    And lista de tarjetas
    # {0550 0621, 700$}
    # {9876 1234, 50$}
    And número de tarjeta
    # 0550 0621
    And nombre/fecha de la compra
    # 27/04/2022

    When pago 102,4$ con la tarjeta 0550 0621  bajo el nombre de 27/04/2022
    Then sale un mensaje que ha sido un éxito
    And tu carrito de compra queda así
    #{}
    And lista de tarjetas queda así
    # {0550 0621, 572$}
    # {9876 1234, 50$}
    And historial de compras así
    #{27/04/2022, 128$}

  Scenario: poco dinero para pagar

    Given tu carrito de compra
    # {té, 25$, 5}
    # {azúcar, 4$, 2}
    # {chocolate, 5$, 4}
    And precio del carrito
    # 128$
    And precio total del carrito con el descuento
    # 102,4$
    And lista de tarjetas
    # {0550 0621, 700$}
    # {9876 1234, 50$}
    And número de tarjeta
    # 9876 1234
    And nombre/fecha de la compra
    # 27/04/2022

    When pago 102,4$ con la tarjeta 9876 1234  bajo el nombre de 27/04/2022
    Then sale un error porque no hay suficiente saldo en la tarjeta

  Scenario: tarjeta no existe

    Given tu carrito de compra
    # {té, 25$, 5}
    # {azúcar, 4$, 2}
    # {chocolate, 5$, 4}
    And precio del carrito
    # 128$
    And precio total del carrito con el descuento
    # 102,4$
    And lista de tarjetas
    # {0550 0621, 700$}
    # {9876 1234, 50$}
    And número de tarjeta
    # 0000 1111
    And nombre/fecha de la compra
    # 27/04/2022

    When pago 102,4$ con la tarjeta 0000 1111 bajo el nombre de 27/04/2022
    Then sale un error porque no existe esa tarjeta
