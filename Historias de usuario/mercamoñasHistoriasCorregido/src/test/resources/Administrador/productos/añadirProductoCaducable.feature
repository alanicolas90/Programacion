Feature: Como administrador quiero agregar nuevo producto caducable

  Scenario: Agrego el producto con éxito
    Given lista de productos
    #{té, 25$, 150}
    #{azúcar, 4$, 500}

    When introduzco nuevo producto caducable{{sal, 4$,750} 01-01-2023}
    Then me sale mensaje que ha sido un éxito
    And sale lista de productos así
    #{té, 25$, 150}
    #{azúcar, 4$, 500}
    #{{sal, 4$,750}01-01-2023}

  Scenario: El producto caducable ya existe
    Given lista de productos
    #{té, 25$, 150}
    #{azúcar, 4$, 500}

    When introduzco nuevo producto {{té, 20$, 750} 01-01-2023}
    Then me da un error que el producto ya existe
    And te sale un mensaje así
    #Lo sentimos no se pude agregar el producto por que ya existe.

  Scenario: El precio ha sido mal introducido
    Given lista de productos
    #{té, 25$, 150}
    #{azúcar, 4$, 500}

    When introduzco nuevo producto {{sal, siete$,750}01-01-2023}
    Then me da un error que el precio no está bien escrito
    And te sale un mensaje así
    #Lo sentimos el precio está escrito en un formato inválido, por favor inténtelo de nuevo

  Scenario: El stock ha sido mal introducido
    Given lista de productos
    #{té, 25$, 150}
    #{azúcar, 4$, 500}

    When introduzco nuevo producto {{sal, 4$, mil} 01-01-2023}
    Then me da un error que el stock no está bien escrito
    And te sale un mensaje así
    #Lo sentimos el stock está escrito en un formato inválido, por favor inténtelo de nuevo

  Scenario: formato de fecha incorrecto
    Given lista de productos
    #{té, 25$, 150}
    #{azúcar, 4$, 500}

    When introduzco nuevo producto {{sal, 4$, mil} 2023-01-01}
    Then me da un error porque el formato de la fecha es incorrecta
    And te sale un mensaje así
    #Lo sentimos el formato de fecha es in correcto (es dd-mm-yyyy)

  Scenario: fecha de caducidad es anterior a hoy
    Given lista de productos
    #{té, 25$, 150}
    #{azúcar, 4$, 500}

    When introduzco nuevo producto {{sal, 4$, mil} 01-01-2021}
    Then me da un error porque el formato de la fecha es incorrecta
    And te sale un mensaje así
    #Lo sentimos el producto ay está caducado por favor introduce un producto que no esté caducado