#Author: Yordan Avila - yordan@hakalab.com
@SeleccionHoraPorExamenSeleccionOpcionMasHorasDisponiblePorUnaPrestacionPacienteOCMPendiente
Feature: Se valida la seleccion de hora en tab examenes seleccionando opcion mas horas por una prestacion paciente OCM pendiente
  Quiero validar seleccion hora en tab examenes opcion mas horas por prestacion en paciente con OCM pendiente

  Scenario: Validacion seleccion de hora
    Given Valido visualizacion apartado horas
    And Valido visualizacion titulo de fecha seleccionada
    And Valido visualizacion segundo titulo especialidad mas prestacion seleccionada
    And Valido visualizacion subtitulo centro medico seleccionada
    When Valido segundo titulo especialidad mas prestacion segun lo seleccionado en filtro especialidad mas prestacio    
    And Valido subtitulo centro medico segun lo seleccionado en filtro centro medico
    Then Valido visualizacion listado de doctores
    And Valido visualuzacion icono imagen de doctores
    And Valido visualizacion nombre de doctores
    And Valido visualizacion convenio de doctores
    And Valido visualizacion imagen icono dia
    And Valido visualizacion imagen icono tarde
    And Valido visualizacion del separador
    And Valido visualizacion listado carrusel de horas
    And Selecciono hora del carrusel visualizado en apartado de horas
    