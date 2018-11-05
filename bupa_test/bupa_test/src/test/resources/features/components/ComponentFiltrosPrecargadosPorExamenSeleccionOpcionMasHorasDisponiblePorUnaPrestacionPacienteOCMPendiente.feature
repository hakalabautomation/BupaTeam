#Author: Yordan Avila - yordan@hakalab.com
@FiltrosPrecargadosPorExamenSeleccionOpcionMasHorasDisponiblePorUnaPrestacionPacienteOCMPendiente
Feature: Se valida el precargado de los filtros en tab examenes seleccionando opcion mas horas por una prestacion paciente OCM pendiente
  Quiero validar filtros precargados en tab examenes opcion mas horas por prestacion en paciente con OCM pendiente

  Scenario: Validacion visualizacion y dato inicial filtros precargados
    When Valido visualiacion filtro especialidad
    And Valido visualizacion filtro prestacion
    And Valido visualizacion filtro region
    And Valido visualizacion filtro centro medico
    Then Valido dato inicial filtro especialidad
    And Valido dato inicial filtro prestacion
    And Valido dato inicial filtro region
    And Valido dato inicial filtro centro medico

  Scenario: Validacion campos filtros precargados especialidad y prestacion
    Then Valido filtro especialidad no se encuentre vacio
    And Valido filtro prestacion no se encuentre vacio

  Scenario: Validacion campos habilitados y no habilitados filtros precargados
    Then Valido filtro especialidad no se encuentre habilitado
    And Valido filtro prestacion no se encuentre habilitado
    And Valido filtro region se encuentre habilitado

  Scenario Outline: Seleccion opcion filtro region
    When Dar click en filtro region
    Then Selecciono opcion filtro region <listRegion>

    Examples: 
      | listRegion |
      | "5"        |

  Scenario Outline: Seleccion opcion centro medico
    Given Valido centro medico se encuentre habilitado
    When Dar click en filtro centro medico
    Then Selecciono opcion filtro centro medico <listCentro>

    Examples: 
      | listCentro |
      | "7"        |
