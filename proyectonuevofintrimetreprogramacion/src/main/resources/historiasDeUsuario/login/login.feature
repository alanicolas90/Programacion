Feature: Como usuario quiero entrar con usuario y contraseña porque ya existo
  Scenario: entro con el usuaio y contraseña
    Given usuario:"admin" and contraseña:"admin"
    When entro
    Then muestra mensaje así
    # "Bienvenido admin"

  Scenario: no entro porque no existo
    Given usuario:"admin" and contraseña:"admin"
    When entro
    Then muestra mensaje así
    # "Usuario no encontrrado, por favor intentelo de neuvo"

  Scenario:no entro porque la cotraseña es incorrecta
    Given usuario:"admin" and contraseña:"admin"
    When entro
    Then muestra mensaje así
    # "Usuario o contraseña incorrectos"