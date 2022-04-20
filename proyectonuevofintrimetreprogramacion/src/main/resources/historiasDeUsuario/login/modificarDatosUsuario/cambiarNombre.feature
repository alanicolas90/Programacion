Feature: Cambiar el nombre de un miembro familiar

  Scenario: cambia el nombre del miembro
    Given usuario{nombre: "Juan", apellido: "Perez", email: "xxx@gmail.com",usuario:"juanpe123", password: "123456"}
    And nuevo nombre:"Jose" and contraseña:"123456"
    When cambiar nombre
    Then usuario{nombre: "Jose", apellido: "Perez", email: "xxx@gmail.com",usuario:"juanpe123", password: "123456"}

    Scenario: no se cambia el nombre del miembro porque la contraseña es incorrecta
      Given usuario{nombre: "Juan", apellido: "Perez", email: "xxx@gmail.com",usuario:"juanpe123", password: "123456"}
      And nuevo nombre:"Jose" and contraseña:"1234567"
      When cambiar nombre
      Then sale mensaje así
      #Lo sentimos la contraseña que ha ingresado es incorrecta, por favor intentelo de nuevo.