#Author: Yordan Avila - yordan-avila@hakalab.com
@SeleccionHoraDisponiblePorUnaPrestacionPacienteOCMPendiente
Feature: Se valida la seleccion de hora especifica de una prestacion paciente OCM pendiente
  Quiero poder validar seleccion de una hora especifica de una prestacion paciente OCM pendiente

  Scenario: Seleccion de hora disponible
    Given Realizar click boton de agendar hora
    When Valido que se visualice la ventana leer indicaciones seleccion hora
    And Valido que se visualice el titulo leer indicaciones seleccion hora
    And Valido que titulo leer indicaciones sea el correcto seleccion hora
    And Valido que se visualice listado de indicaciones seleccion hora
    And Valido que se visualice el boton anular reserva seleccion hora
    And Valido que se visualice el boton he leido las indicaciones seleccion hora
    And Valido que boton he leido las indicaciones sea correcto seleccion hora
    And Valido que el boton he leido las indicaciones se encuentre habilitado seleccion hora
    Then Realizar click en he leido las indicaciones seleccion hora

  Scenario: Ventana informacion reserva exitosa
    When Valido que se visualice ventana reserva exitosa
    And Valido que se visualice titulo reserva exitosa
    And Valido que titulo sea correcto ventana reserva exitosa
    And Valido que se visualice imagen check ventana reserva exitosa
    And Valido que imagen check sea correcto ventana reserva exitosa
    And Valido que se visualice mensaje ventana reserva exitosa
    And Valido que se visualice boton aceptar ventana reserva exitosa
    And Valido que boton aceptar sea el correcto reserva exitosa
    And Valido que boton aceptar se encuentre habilitado ventana reserva exitosa
    And Realizar click boton aceptar ventana reserva exitosa

  Scenario: Ventana paciente con OCM pendientes
    Then Valido que visualizar nuevamente apartado informacion de paciente
    And Valido que visualizar nuevamente ventana ocm pendientes
