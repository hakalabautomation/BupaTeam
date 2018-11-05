#Author: Yordan Avila - yordan@hakalab.com
@AnularHoraSeleccionHoraDisponiblePorUnaPrestacionPacienteOCMPendiente
Feature: Se valida la anulacion de hora especifica de una prestacion paciente OCM pendiente
  Quiero poder validar anulacion de una hora especifica de una prestacion paciente OCM pendiente

  Scenario: Anulacion de hora
    Given Realizar click boton agendar hora     
    When Valido que se visualice la ventana leer indicaciones
    And Valido que se visualice el titulo leer indicaciones
    And Valido que titulo leer indicaciones sea el correcto
    And Valido que se visualice listado de indicaciones
    And Valido que se visualice el boton he leido las indicaciones
    And Valido que boton he leido las indicaciones sea correcto
    And Valido que se visualice el boton anular reserva
    And Valido que boton anular reserva sea correcto
    And Valido que el boton anular reserva se encuentre habilitado 
    Then Realizar click en boton anular reserva

  Scenario: Ventana informacion de anulacion    
    When Valido que se visualice ventana de anulacion
    And Valido que se visualice titulo ventana de anulacion
    And Valido que titulo sea correcto ventana de anulacion
    And Valido que se visualice imagen check ventana de anulacion
    And Valido que se visualice mensaje ventana de anulacion
    And Valido que mensaje sea correcto ventana de anulacion
    And Valido que se visualice boton aceptar ventana de anulacion
    And Valido que boton aceptar sea el correcto ventana de anulacion
    And Valido que boton aceptar se encuentre habilitado ventana de anulacion
    And Realizar click boton aceptar ventana de anulacion
  
  Scenario: Ventana paciente con OCM pendientes
  	Then Valido que se visualice nuevamente apartado informacion de paciente
  	And Valido que se visualice nuevamente ventana ocm pendientes