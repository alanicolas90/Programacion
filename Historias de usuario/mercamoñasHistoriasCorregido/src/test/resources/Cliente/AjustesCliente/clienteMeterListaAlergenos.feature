Feature: Como cliente quiero poder meter una lista de alergenos

  Scenario: Agrego  alergeno a mis datos de cliente

    Given nombre el dni del cliente
    And  nombre alérgeno
    And lista de alérgenos del cliente
    #Cliente{dni = "1", nombre = "Alan", alergias={"anafilaxia"}}

    When introduzco nueva alergia "trigo"
    Then sale un mensaje que ha sido un éxito
    And sale lista así
    #Cliente{dni = "1", nombre = "Alan", alergias={"anafilaxia", "trigo"}}

  Scenario: La alergia ya existe

    Given nombre el dni del cliente
    And  nombre alérgeno
    And lista de alérgenos del cliente
    #Cliente{dni = "1", nombre = "Alan", alergias={"anafilaxia"}}

    When introduzco nueva alergia "trigo"
    Then sale un mensaje que ha ocurrido un error
    #Lo sentimos no se pude agregar la alergia por que ya la tienes intrducida.
