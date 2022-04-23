Feature: como usuario quiero agregar dinero a mi billetera familiar

  Scenario: como usuario quiero agregar dinero a mi billetera familiar
    Given lista de billeteras familiares
    #billeteraFamiliar{nombre:"ahorros", codBilletera:"1", password:"1234", dinero:7000}
    #billeteraFamiliar{nombre:"ahorros", codBilletera:"2", password:"1234", dinero:7000}
    And monedero propio
    #monedero: {dinero:5000}
    When agregar dinero (500) a mi billetera familiar con cod 1
    And pongo la contraseña de confirmación de mi billetera familiar (1234)
    Then sale mensaje así
    # Se ha agregado el dinero correctamente
    And monedero queda así
    #monedero: {dinero:4500}
    And billetera familiar queda así
    #billeteraFamiliar{nombre:"ahorros", codBilletera:"1", password:"1234", dinero:7500}
    #billeteraFamiliar{nombre:"ahorros", codBilletera:"2", password:"1234", dinero:7000}

  Scenario: no puedo agregar dinero a mi billetera familiar porque no existe billetera con ese codigo
    Given lista de billeteras familiares
    #billeteraFamiliar{nombre:"ahorros", codBilletera:"1", password:"1234", dinero:7000}
    #billeteraFamiliar{nombre:"ahorros", codBilletera:"2", password:"1234", dinero:7000}
    And monedero propio
    #monedero: {dinero:5000}
    When agregar dinero (500) a mi billetera familiar con cod 3
    And pongo la contraseña de confirmación de mi billetera familiar (1234)
    Then sale mensaje así
    # No se ha agregado el dinero, por favor inténtelo de nuevo

  Scenario: no puedo agregar dinero a mi billetera familiar porque la contraseña que he escrito a la billetera es incorrecta
    Given lista de billeteras familiares
    #billeteraFamiliar{nombre:"ahorros", codBilletera:"1", password:"1234", dinero:7000}
    #billeteraFamiliar{nombre:"ahorros", codBilletera:"2", password:"1234", dinero:7000}
    And monedero propio
    #monedero: {dinero:5000}
    When agregar dinero (500) a mi billetera familiar con cod 1
    And pongo la contraseña de confirmación de mi billetera familiar (12346789)
    Then sale mensaje así
    # No se ha agregado el dinero, por favor inténtelo de nuevo

  Scenario: no puedo agregar dinero a mi billetera familiar porque no tengo dinero suficiente para agregar
  Given lista de billeteras familiares
    #billeteraFamiliar{nombre:"ahorros", codBilletera:"1", password:"1234", dinero:7000}
    #billeteraFamiliar{nombre:"ahorros", codBilletera:"2", password:"1234", dinero:7000}
    And monedero propio
    #monedero: {dinero:300}
    When agregar dinero (500) a mi billetera familiar con cod 1
    And pongo la contraseña de confirmación de mi billetera familiar (1234)
    Then sale mensaje así
    # No se ha agregado el dinero, por favor inténtelo de nuevo

