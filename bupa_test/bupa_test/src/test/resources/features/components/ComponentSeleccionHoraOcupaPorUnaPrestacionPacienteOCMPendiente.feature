#Author: Yordan Avila - yordan.avila@hakalab.com
@ComponentSeleccionHoraOcupadaPorPrestacionPacienteOCMPendiente
Feature: Se valida la seleccion de una hora ocupada sobre una prestacion en un paciente con OCM pendiente
  Quiero poder validar seleccion hora ocupada en una prestacion de paciente con OCM pendiente  

  Scenario: Seleccion de una hora ocupada en una prestacion especifica y seleccion de mas horas
    Then Selecciono boton agendar hora
    And Valido que se visualice ventana hora ocupada
    And Valido que se visualice titulo ventana hora ocupada
    And Valido que titulo sea correcto ventana hora ocupada
    And Valido que se visualice imagen de error ventana hora ocupada
    And Valido que la imagen de error sea la correcta ventana hora ocupada
    And Valido que se visualice mensaje error ventana hora ocupada
    And Valido que aparezca boton aceptar ventana hora ocupada
    And Valido que boton aceptar sea correcto ventana hora ocupada
    And Valido que boton aceptar se encuentre habilitado ventana hora ocupada
    And Realizar click boton aceptar ventana hora ocupada
    And Valido que muestre nuevamente ventana de OCM pendientes de paciente