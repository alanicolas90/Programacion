Feature: como usuario quiero aceptar una solicitud de entrada a la billetera

  Scenario: acepto solicitud a entrar en la billetera
    Given list of solicitudes así
    #solicitudes abiertas{ usuario{nombre:"jose", correo:"xxx@gmail.com"}}
    When acepto solicitud con el correo de "xxx@gmail.com"
    Then sale un mensaje así
    #Has aceptado a jose a tu billetera con éxito.

  Scenario: no se puede aceptar solicitud porque no hay solicitudes pendientes
    Given list of solicitudes así
      #solicitudes abiertas{}
    When acpeto solicitud
    Then sale un mensaje así
      #no hay solicitudes pendientes

  Scenario: no se puede aceptar solicitud porque no existe usuario con ese correo
    Given list of solicitudes así
      #solicitudes abiertas{usuario{nombre:"jose", correo:"xxx@gmail.com"}}
    When acpeto solicitud con el correo de "xxs@gmail.com"
    Then sale un mensaje así
    #no existe usuario con ese correo
