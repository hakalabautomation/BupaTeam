#Author: Yordan Avila - yordan@hakalab.com
@SeleccionFechaPorExamenSeleccionOpcionMasHorasDisponiblePorUnaPrestacionPacienteOCMPendiente
Feature: Se valida la seleccion de fecha en tab examenes seleccionando opcion mas horas por una prestacion paciente OCM pendiente
  Quiero validar seleccion fecha en tab examenes opcion mas horas por prestacion en paciente con OCM pendiente

  Scenario: Validacion seleccion de fecha
    Given Valido visualizacion icono calendario    
    When Valido visualizacion titulo mes y año
    And Valido visualizacion subtitulo semana
    Then Valido visualizacion columna nombre dias
    And Valido visualizacion columna numero dias
    And Valido visualizacion dias activos
    And Valido que ya exista una fecha seleccionada    