#Author: Yordan Avila - yordan@hakalab.com
@HoraOcupadaReservaNuevaHora
Feature: Se valida la hora que se encuentra ocupada al momento de agendar una nueva hora
  Validacion de hora ocupada al agendar una nueva hora

  Scenario: Seleccion de reserva de hora ocupada
    Given Visualizo el resumen de examen
    When Dar click en boton agendar
    Then Valido despliegue ventana emergente hora no ha podido ser agendada
    And Valido que aparezca titulo de hora no ha podido ser agendada
    And Valido que aparezca imagen fail de hora no ha podido ser agendada
    And Valido que aparezca parrafo detalle de hora no ha podido ser agendada
    And Valido que aparezca boton aceptar de hora no ha podido ser agendada
    And Valido que haga click boton aceptar de hora no ha podido ser agendada
    And Valido que aparezca nuevamente apartado de horas
