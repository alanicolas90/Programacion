Feature: como usuario quiero añadir dinero a mi cartera

  Scenario: añado dinero a la cartera
    Given usuario{nombre: "Juan", apellido: "Perez", email: "xxx@gmail.com",usuario:"juanpe123", password: "123456", cartera:50}
    And dinero a añadir {dinero: "100"}
    When añado dinero a la cartera
    Then el dinero de la cartera debe ser {dinero: "150"}

    Scenario: nose añade dinero a la cartera porque mete un valor negativo
      Given usuario{nombre: "Juan", apellido: "Perez", email: "xxx@gmail.com",usuario:"juanpe123", password: "123456", cartera:50}
      And dinero a añadir {dinero: "-100"}
      When añado dinero a la cartera
      Then el dinero de la cartera debe ser {dinero: "50"}
      And sale mensaje así
      #Ha ocurrido un error, el valor a añadir dinero debe ser positivo y tiene que ser un numeroç

  Scenario: nose añade dinero a la cartera porque mete un valor no numérico
    Given usuario{nombre: "Juan", apellido: "Perez", email: "xxx@gmail.com",usuario:"juanpe123", password: "123456", cartera:50}
    And dinero a añadir {dinero: "-100"}
    When añado dinero a la cartera
    Then el dinero de la cartera debe ser {dinero: "50"}
    And sale mensaje así
      #Ha ocurrido un error, el valor a añadir dinero debe ser positivo y tiene que ser un numero
