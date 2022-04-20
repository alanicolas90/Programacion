Feature: Crear grupo familiar
  Scenario: Se crea grupo familiar
    Given grrupofamiliar{nombre:"Perez", codigo:"123456789"}
    When crear_grupo_familiar
    Then sale mensaje así
    #GRUPO FAMILIAR CREADO CON EXITO

  Scenario: Se crea grupo familiar ya existe
    Given grrupofamiliar{nombre:"Perez", codigo:"123456789"}
    And lista de grupos familiares asi
    #grrupofamiliar{nombre:"Perez", codigo:"123456789"}
    #grrupofamiliar{nombre:"Suarez", codigo:"123456789"}
    When crear_grupo_familiar
    Then sale mensaje así
    #no se ha podido crear el grupo familiar porque ya existe
