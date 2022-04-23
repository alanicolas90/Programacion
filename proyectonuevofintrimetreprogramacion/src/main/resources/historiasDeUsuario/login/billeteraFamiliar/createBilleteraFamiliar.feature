Feature: como usuario quiero crear una billetera familiar

  Scenario: creo billetera familiar
    Given billeteraFamiliar{nombre:"ahorros", codBilletera:"10120102", password:"1234", dinero:7000}
    When I create a billetera familiar
    Then sale mensaje así
    #su billetera familiar ha sido creada con éxito
    And lista billeteras familiares asi
    #su lista de billeteras familiares es:
    #billeterasFamiliares{
    # billeteraFamiliar{nombre:"ahorros", codBilletera:"10120102", password:"1234", dinero:7000
    # }

  Scenario: no se crea billetera familiar porque codigo de billetera ya existe
    Given billeteraFamiliar{nombre:"comidaFueraDeCasa", codBilletera:"1", password:"4000", dinero:455}
    And list of all billeteras existentes
    #billeteraFamiliar{nombre:"ahorros", codBilletera:"1", password:"1234", dinero:7000}
    #billeteraFamiliar{nombre:"ahorros", codBilletera:"2", password:"1234", dinero:7000}
    When I create a billetera familiar
    Then sale mensaje así
    #lo sentimos no se ha podido crear la billetera familiar, intentelo de nuevo

  Scenario: no se crea billetera familiar porque el dinero no ha sido puesto en valor no numérico
    Given billeteraFamiliar{nombre:"comidaFueraDeCasa", codBilletera:"1", password:"4000", dinero:"cuatrocientos"}
    When I create a billetera familiar
    Then sale mensaje así
    #lo sentimos no se ha podido crear la billetera familiar, inténtelo de nuevo
