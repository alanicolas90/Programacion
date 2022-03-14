Feature: Como sicario quiero poner el encargo como cumplido

  Scenario: cambio el estado de un encargo con éxito
    Given sicario {Jose, Parla, 5, 900$}
    And su lista de encargos
    #1{foto.jpg,1500$,2,PAGADO}
    #2{foto.jpg,5000$,4,PAGADO}
    #3{foto.jpg,100000$, 5,PAGADO}
    #4{foto.jpg,100000$, 5,VALIDADO}

  When sicario {Jose, Parla, 5, 900$} quiere cambiar encargo #4{foto.jpg,100000$, 5,VALIDADO}
    Then sale un mensaje que ha sido un éxito
    And lista de encargos sale así
    #1{foto.jpg,1500$,2,PAGADO}
    #2{foto.jpg,5000$,4,PAGADO}
    #3{foto.jpg,100000$, 5,PAGADO}
    #4{foto.jpg,100000$, 5,CUMPLIDO}