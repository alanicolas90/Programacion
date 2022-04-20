Feature: ver balance de la familia

  Scenario: veo el balance de la familia
    Given miembros de la familia así
    #{nombre: "Juan", apellido: "Perez", monedero:250$}
    #{nombre: "Jose", apellido: "Perez", monedero:1200$}
    #{nombre: "Maribel", apellido: "Perez", monedero:4800$}
    When veo el balance de la familia
    Then veo el balance de la familia
      #{balanceFamilia: 6250$}