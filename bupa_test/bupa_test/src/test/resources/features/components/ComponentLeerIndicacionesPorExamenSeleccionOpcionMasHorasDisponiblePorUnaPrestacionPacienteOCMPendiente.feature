#Author: Yordan Avila - yordan@hakalab.com
@LeerIndicacionesPorExamenSeleccionOpcionMasHorasDisponiblePorUnaPrestacionPacienteOCMPendiente
Feature: Se valida seccion leer indicaciones en tab examenes seleccionando opcion mas horas por una prestacion paciente OCM pendiente
  Quiero validar seccion leer indicaciones en tab examenes opcion mas horas por prestacion en paciente con OCM pendiente

  Scenario: Validacion ventana leer indicaciones
    Given Valido visualizacion la ventana leer indicaciones
    And Valido visualizacion el titulo leer indicaciones
    And Valido titulo leer indicaciones sea correcto
    When Valido visualizacion del listado de indicaciones
    Then Valido visualizacion boton he leido las indicaciones
    And Valido boton he leido las indicaciones sea correcto
    And Valido boton he leido las indicaciones se encuentre habilitado
    And Valido visualizacion el boton anular reserva
    And Valido boton anular reserva sea correcto
    And Valido boton de anular reserva se encuentre habilitado