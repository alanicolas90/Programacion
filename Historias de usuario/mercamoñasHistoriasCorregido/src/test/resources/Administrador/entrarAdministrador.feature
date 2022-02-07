Feature: Como usuario quiero entrar como administrador

  Scenario: Entro como administrador
    Given lista de administradores {admin, 1234}

    When introduzco los datos del login
    Then entras
    And te sale un mensaje así
    # Bienvenido ADMINISTRADOR
    And te sale una lista así
    # 1) Administrar productos
    # 2) Administrar clientes

  Scenario: Contraseña incorrecta
    Given lista de administradores {admin, 1234}
    And contraseña 2929

    When introduzco contraseña
    Then me da error porque no existe esa contraseña con ese usuario
    And te sale un mensaje así
    # La contraseña introducida es incorrecta, por favor inténtelo de nuevo

  Scenario: Usuario incorrecto
    Given lista de administradores {admin, 1234}
    And usuario jefazo

    When introduzco usuario jefazo
    Then me da error porque no existe un usuario así
    And te sale un mensaje así
    # La usuario introducida no existe, por favor inténtelo de nuevo


