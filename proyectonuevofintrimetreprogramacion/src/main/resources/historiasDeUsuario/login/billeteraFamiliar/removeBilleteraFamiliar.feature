Feature: como usuario quiero eliminar una billetera familiar

  Scenario: elimino una billetera familiar
    Given lista de billeteras familiares
    # billeteraFamiliar{nombre:"ahorros", codBilletera:"1", password:"1234", dinero:7000}
    # billeteraFamiliar{nombre:"ahorros", codBilletera:"2", password:"1234", dinero:7000}
    When elimino billetera familiar con codigo "1"
    Then sale mensaje así
    # Billetera familiar eliminada con éxito
    And lista de billeteras familiares queda así
    # billeteraFamiliar{nombre:"ahorros", codBilletera:"2", password:"1234", dinero:7000}

  Scenario: no elimino una billetera familiar porque no existe el codigo
    Given lista de billeteras familiares
    # billeteraFamiliar{nombre:"ahorros", codBilletera:"1", password:"1234", dinero:7000}
    # billeteraFamiliar{nombre:"ahorros", codBilletera:"2", password:"1234", dinero:7000}
    When elimino billetera familiar con codigo "3"
    Then sale mensaje así
    # Billetera familiar no se ha podido eliminar, por favor inténtelo de nuevo.