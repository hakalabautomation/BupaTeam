#Author: Yordan Avila - yordan@hakalab.com
@AgendamientoHoraPorExamenSeleccionOpcionMasHorasDisponiblePorUnaPrestacionPacienteOCMPendiente
Feature: Se valida el agendamiento de una hora en tab examenes seleccionando opcion mas horas por una prestacion paciente OCM pendiente
  Quiero validar agendamiento de hora en tab examenes opcion mas horas por prestacion en paciente con OCM pendiente

  Scenario: Validacion agendamiento de una hora para examen
    Given Presiono boton he leido las indicaciones   
    When Valido visualizacion ventana emergente reserva de hora con exito
    And Valido visualizacion titulo reserva de hora con exito
    And Valido titulo reserva de hora con exito sea el correcto
    And Valido visualizacion imagen check reserva de hora con exito
    And Valido visualizacion mensaje sobre reserva de hora con exito    
    And Valido visualizacion boton aceptar reserva de hora con exito
    And Valido boton aceptar reserva de hora con exito a sea correcto
    And Valido boton aceptar reserva de hora con exito se encuentre habilitado
    Then Presiono boton aceptar reserva de hora con exito
    And Valido visualizacion nuevamente apartado informacion de paciente
    And Valido visualizacion nuevamente tabla de OCM pendientes
    And Valido visualizacion de ordenes de OCM pendientes