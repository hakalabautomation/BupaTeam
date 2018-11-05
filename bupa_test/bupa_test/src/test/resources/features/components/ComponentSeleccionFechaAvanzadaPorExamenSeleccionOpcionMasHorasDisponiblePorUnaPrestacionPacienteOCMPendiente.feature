#Author: Yordan Avila - yordan@hakalab.com
@SeleccionFechaAvanzadaPorExamenSeleccionOpcionMasHorasDisponiblePorUnaPrestacionPacienteOCMPendiente
Feature: Se valida la seleccion de fecha avanzada en tab examenes seleccionando opcion mas horas por una prestacion paciente OCM pendiente
  Quiero validar seleccion de fecha avanzada en tab examenes opcion mas horas por prestacion en paciente con OCM pendiente

  Scenario: Validacion de componentes ventana de fecha avanzada
    Given Valido la visualizacion icono de fecha avanzada
    When Valido que icono fecha avanzada se encuentre habilitado
    Then Seleccion icono fecha avanzada
    And Valido visualizacion ventana busqueda fecha avanzada en calendario extendido
    And Valido visualizacion titulo de busqueda fecha avanzada
    And Valido titulo de busqueda fecha avanzada sea correcto
    And Valido visualizacion mes y semana de busqueda fecha avanzada
    And Valido mes y semana de busqueda fecha avanzada sea correcto

  Scenario Outline: Seleccion y validacion año
    Then Doy click en año de busqueda fecha avanzada
    And Selecciono año del listado de busqueda fecha avanzada <añoSelect>
    And Valido seleccion de año de busqueda fecha avanzada <año>

    Examples: 
      | añoSelect | año    |
      | "1"       | "2018" |

  Scenario Outline: Seleccion y validacion mes
    Then Doy click en mes de busqueda fecha avanzada
    And Selecciono mes del listado de busqueda fecha avanzada <mesSelect>
    And Valido seleccion de mes de busqueda fecha avanzada <mes>

    Examples: 
      | mesSelect | mes       |
      | "1"       | "Octubre" |

  Scenario Outline: Seleccion y validacion dia
    Then Selecciono dia del listado de busqueda fecha avanzada <diaSelect>
    And Valido seleccion de dia de busqueda fecha avanzada <dia>

    Examples: 
      | diaSelect | dia  |
      | "16"      | "17" |
