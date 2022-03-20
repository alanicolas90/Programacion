Feature: Como cliente quiero dar de alta un encargo

  Scenario: doy de alta encargo con éxito
    Given lista de encargos así
    # {foto.jpg(tmñ. 30KB), 4000$, 3, VALIDADO}
    # {foto.jpg(tmñ. 70KB), 20000$, 5, PAGADO}
    # {foto.jpg(tmñ. 50KB), 3000$, 2, ESPERANDO CONFIRMACIÓN}

    When introduzco nuevo encargo {foto.jpg(tmñ. 50KB), 8000$, 4}
    Then sale un mensaje que ha sido un éxito
    And lista de encargos así
    # {foto.jpg(tmñ. 30KB), 4000$, 3, VALIDADO}
    # {foto.jpg(tmñ. 70KB), 20000$, 5, PAGADO}
    # {foto.jpg(tmñ. 50KB), 3000$, 2, ESPERANDO CONFIRMACIÓN}
    #{foto.jpg(tmñ. 50KB), 8000$, 4, ENTRADA}

  Scenario: Tamaño de la foto demasiado grande
    Given lista de encargos así
    # {foto.jpg(tmñ. 30KB), 4000$, 3, VALIDADO}
    # {foto.jpg(tmñ. 70KB), 20000$, 5, PAGADO}
    # {foto.jpg(tmñ. 50KB), 3000$, 2, ESPERANDO CONFIRMACIÓN}

    When introduzco nuevo encargo {foto.jpg(tmñ. 110KB), 8000$, 4}
    Then sale un mensaje que ha habido un error
    #lo sentimos pero el tamaño de la foto no puede exceder los 100KB y usted ha puesto un archivo de 110KB

  Scenario: El nivel de habilidad del encargo es demasiado grande
    Given lista de encargos así
    # {foto.jpg(tmñ. 30KB), 4000$, 3, VALIDADO}
    # {foto.jpg(tmñ. 70KB), 20000$, 5, PAGADO}
    # {foto.jpg(tmñ. 50KB), 3000$, 2, ESPERANDO CONFIRMACIÓN}

    When introduzco nuevo encargo {foto.jpg(tmñ. 50KB), 8000$, 6}
    Then sale un mensaje que ha habido un error
    # lo sentimos pero el nivel de habilidad del encargo solo puede ser desde 1 al 5 usted a puesto 7

  Scenario: El nivel de habilidad del encargo es demasiado pequeño
    Given lista de encargos así
    # {foto.jpg(tmñ. 30KB), 4000$, 3, VALIDADO}
    # {foto.jpg(tmñ. 70KB), 20000$, 5, PAGADO}
    # {foto.jpg(tmñ. 50KB), 3000$, 2, ESPERANDO CONFIRMACIÓN}

    When introduzco nuevo encargo {foto.jpg(tmñ. 50KB), 8000$, 0}
    Then sale un mensaje que ha habido un error
        # lo sentimos pero el nivel de habilidad del encargo solo puede ser desde 1 al 5 usted a puesto 0

  Scenario: El dinero introducido es inferior al mínimo
    Given lista de encargos así
    # {foto.jpg(tmñ. 30KB), 4000$, 3, VALIDADO}
    # {foto.jpg(tmñ. 70KB), 20000$, 5, PAGADO}
    # {foto.jpg(tmñ. 50KB), 3000$, 2, ESPERANDO CONFIRMACIÓN}

    When introduzco nuevo encargo {foto.jpg(tmñ. 50KB), 800$, 4}
    Then sale un mensaje que ha habido un error
    #el precio mínimo de un encargo es de 1000$ y usted ha puesto 800$.
