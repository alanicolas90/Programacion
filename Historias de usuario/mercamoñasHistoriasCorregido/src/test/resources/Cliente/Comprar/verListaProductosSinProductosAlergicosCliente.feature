Feature: como cliente quiero ver todos los productos sin alergias a las que tiene

  Scenario: ver toda la lista de productos sin alergias
    Given lista de productos
    #{té, 25$, 150, Ingredientes="herbalife"}
    #{azúcar, 4$, 500}
    #{chocolate, 5$ ,600,Ingredientes="lactosa"}
    And alergias cliente
    #Alergenos{"lactosa"}

    When pido la lista de todos los productos sin alergias
    Then te sale toda la lista de productos sin alergias
    #{té, 25$, 150, Ingredientes="herbalife"}
    #{azúcar, 4$, 500}