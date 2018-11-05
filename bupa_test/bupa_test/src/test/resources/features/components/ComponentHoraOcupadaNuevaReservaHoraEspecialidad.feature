#Author: Yordan Avila - yordan@hakalab.com
@HoraOcupadaReservaNuevaHoraEspecialidad
Feature: Se valida que hora se encuentre ocupada al momento agendar una nueva hora por especialidad 
  Validacion de hora ocupada al agendar una nueva hora en especialidad

  Scenario: Seleccion de reserva nueva hora ocupada especialidad
    Given Visualizo pantalla resumen especialidad
    When Presiono el boton agendar
    Then Valido que se visualice ventana emergente hora no ha podido ser agendada
    And Valido que se visualice el titulo de hora no ha podido ser agendada
    And Valido que titulo coincidan segun lo descrito 
    And Valido que se visualice imagen fail de hora no ha podido ser agendada
    And Valido que se visualice parrafo detalle de hora no ha podido ser agendada
    And Valido que parrafo detalle coincida segun lo descrito
    And Valido que se visualice boton aceptar de hora no ha podido ser agendada
    And Valido que click boton aceptar la hora no ha podido ser agendada
    And Dar click boton aceptar la hora no ha podido ser agendada
    And Valido que se visualice nuevamente apartado de horas