Feature: como usuario quiero solicitar entrar en una billetera familiar
  Scenario: solicito entrar en billetera familiar
    Given lista de billeteras familiares
    #billeteraFamiliar{nombre:"ahorros", codBilletera:"1", dueño:"xxx@gmail.com"}
    #billeteraFamiliar{nombre:"compras", codBilletera:"2"
    When solicito entrar en billetera familiar con cod 1
    Then sale mensaje así
    # Usted ha hecho la solicitud , por favor espere la respuesta del dueño

  Scenario: no puedo solicitar entrar en una billetera familiar porque no existe
    Given lista de billeteras familiares
    #billeteraFamiliar{nombre:"ahorros", codBilletera:"1", dueño:"xxx@gmail.com"
    When solicito entrar en billetera familiar con cod 2
    Then sale mensaje así
    # La billetera familiar no existe, por favor intentelo de nuevo
