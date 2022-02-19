Feature: Como cliente quiero ver cual es mi gasto total en la tienda

  Scenario: Veo la suma total de mis gastos con éxito
    Given dnie cliente
    # {3427928, alan, mikolajczyk, Historial compra{LineaCompra{"Pescado","2.50","4"}}

    When pido ver gasto total en tienda
    Then sale un mensaje con lo que he gastado
    #Usted ha gaastado 10 $ en la tienda en total.