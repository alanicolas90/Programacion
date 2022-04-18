Feature: como usuario quiero registrame como nuevo miembro

  Scenario: registrarme como nuevo miembro
    Given nombre: "Juan", apellido: "Perez", email: "xxx@gmail.com",usuario:"juanpe123", password: "123456"
    When registrarme
    Then el usuario deberia ser registrado y salir mensaje asi
    # felicidades Juan, te has registrado correctamente

  Scenario: no se ha registrado como nuevo miembro porque el email ya existe
    Given nombre: "Juan", apellido: "Perez", email: "xxx@gmail.com",usuario:"juanpe123", password: "123456" and lista usuarios asi
    # [{nombre: "Pedro", apellido: "Lopez", email: "xxx@gmail.com",usuario:"pelopez223", password: "123456"}]
    When registrarme
    Then sale mensaje así
    # lo sentimos, ha ocurrido un error, el correo que nos ha dado ya existe

  Scenario: no se ha registrado como nuevo miembro porque el usuario ya existe
    Given nombre: "Juan", apellido: "Perez", email: "xxx@gmail.com",usuario:"juanpe123", password: "123456" and lista usuarios asi
    # [{nombre: "Pedro", apellido: "Lopez", email: "abc@gmail.com", usuario:"juanpe123", password: "123456"}]
    When registrarme
    Then sale mensaje así
    # lo sentimos, ha ocurrido un error, el usuario que nos ha dado ya existe