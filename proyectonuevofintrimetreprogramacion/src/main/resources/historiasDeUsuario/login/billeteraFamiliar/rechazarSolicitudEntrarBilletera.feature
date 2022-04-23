Feature: como usuario quiero rechazar una solicitud de entrar a mi billetera

  Scenario: rechazo solicitud a entrar en la billetera
    Given list of solicitudes así
    #solicitudes abiertas{ usuario{nombre:"jose", correo:"xxx@gmail.com"}}
    When rechazo solicitud del usuario jode con el correo "xxx@gmail.com"
    Then sale un mensaje así
    #Has rechazado la solcitud con éxito

  Scenario: no se puede rechazar solicitud porque no hay solicitudes pendientes
    Given list of solicitudes así
      #solicitudes abiertas{}
    When acpeto solicitud
    Then sale un mensaje así
      #no hay solicitudes pendientes

  Scenario: no se puede rechazar solicitud porque no existe usuario con ese correo
    Given list of solicitudes así
      #solicitudes abiertas{usuario{nombre:"jose", correo:"xxx@gmail.com"}}
    When rechazo solicitud con el correo de "xxs@gmail.com"
    Then sale un mensaje así
    #no existe usuario con ese correo