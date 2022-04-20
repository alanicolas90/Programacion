Feature: como usuario quiero cambiar el correo de un miembro familiar

  Scenario: cambia el correo del miembro
    Given usuario{nombre: "Juan", apellido: "Perez", email: "xxx@gmail.com",usuario:"juanpe123", password: "123456"}
    And nuevo correo:"xxs@gmail.com" and contraseña:"123456"
    When cambiar correo
    Then usuario{nombre: "Jose", apellido: "Perez", email: "xxx@gmail.com",usuario:"juanpe123", password: "123456"}

  Scenario: no se cambia el correo del miembro porque la contraseña es incorrecta
    Given usuario{nombre: "Juan", apellido: "Perez", email: "xxx@gmail.com",usuario:"juanpe123", password: "123456"}
    And nuevo correo:"xxs@gmail.com" and contraseña:"1234567"
    When cambiar correo
    Then sale mensaje así
      #Lo sentimos la contraseña que ha ingresado es incorrecta, por favor intentelo de nuevo.