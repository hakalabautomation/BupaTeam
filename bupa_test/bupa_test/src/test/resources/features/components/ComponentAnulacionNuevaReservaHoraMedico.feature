#Author: Yordan Avila - yordan@hakalab.com
@AnulacionNuevaReservaHoraMedico
Feature: Se valida la anulacion de reserva de hora de un medico a traves de la web
  Validacion de la anulacion de reserva de hora de un medico

  Scenario: Seleccion opcion anular reserva
    Given Valido visualizacion resumen de consulta medico
    When Presiono boton agendar
    Then Valido visualizacion ventana leer indicaciones
    And Valido visualizacion titulo leer indicaciones
    And Valido visualizacion listado de indicaciones
    And Valido visualizacion boton anular reserva
    And Valido boton anular reserva se encuentre habilitado
    And Presiono boton anular reserva
    And Valido visualizacion ventana emergente anular cita
    And Valido visualizacion titulo de anular cita
    And Valido que titulo de anular cita sea correcto
    And Valido visualizacion imagen check de anular cita
    And Valido visualizacion parrafo de anular cita
    And Valido que parrafo de anular cita sea el correcto
    And Valido visualizacion boton aceptar de anular cita
    And Valido boton aceptar de anular cita se encuentre habilitado
    And Presiono boton aceptar
    And Valido visualizacion apartado de horas