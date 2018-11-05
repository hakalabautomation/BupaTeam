#Author: Yordan Avila - yordan@hakalab.com
@AnulacionNuevaReservaHoraExamen
Feature: Se valida la anulacion de reserva de hora de un examen a traves de la web
  Validacion de la anulacion de reserva de hora de una examen 

  Scenario: Seleccion opcion anular reserva
    Given Visualizo apartado resumen de examen    
    When Hago click boton de agendar    
    Then Valido despliegue ventana leer indicaciones
    And Valido titulo leer indicaciones
    And Valido listado de indicaciones
    And Valido que aparezca boton anular reserva
    And Valido que haga click boton anular reserva
    And Valido que aparezca ventana emergente anular cita
    And Valido que aparezca titulo de anular cita
    And Valido que aprezca imagen check de anular cita
    And Valido que aparezca parrafo de anular cita
    And Valido que aparezca boton aceptar de anular cita
    And Valido que haga click boton aceptar de anular cita
    And Valido que aparezca apartado de horas