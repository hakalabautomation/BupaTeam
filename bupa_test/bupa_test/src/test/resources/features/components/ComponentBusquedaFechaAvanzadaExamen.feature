#Author: Yordan Avila - yordan@hakalab.com
@BusquedaFechaAvanzada
Feature: Se valida la seleccion de un dia a traves de la busqueda de fecha avanzada
  Quiero poder seleccionar una fecha avanzada por seleccionando año, mes y dia

  Scenario Outline: Seleccion especialidad
    Given Selecciono boton nueva reserva de hora
    And Selecciono opcion pestaña examenes
    When Selecciono especialidad <especialidad>
    Then Valido seleccion especialidad <especialidad>
    And Valido el label de especialidad

    Examples: 
      | especialidad              |
      | "Test De Esfuerzo Adulto" |

  Scenario Outline: Seleccion prestacion
    When Seleccion de prestacion <prestacion>
    Then Valido seleccion prestacion <prestacion>
    And Valido el label de prestacion

    Examples: 
      | prestacion         |
      | "Test De Esfuerzo" |

  Scenario Outline: Selecciono region
    When Selecciono de region <region>
    Then Valido seleccion de region <region>
    And Valido el label de region

    Examples: 
      | region                 |
      | "Región Metropolitana" |

  Scenario Outline: Selecciono centro medico
    When Selecciono un centro medico <centro>
    Then Valido seleccion de centro medico <centro>
    And Valido el label de centro medico

    Examples: 
      | centro                    |
      | "Integramedica Barcelona" |

  Scenario Outline: Seleccion fecha opcion busqueda avanzada
    When boton de busqueda fecha avanzada se encuentra habilitado
    Then Selecciono boton de busqueda fecha avanzada
    And Valido titulo label de busqueda avanzada
    And Valido subtitulo label mes y semana
    And Selecciono año <año>
    And Valido seleccion de año <año>
    And Selecciono mes <mes>
    And Valido seleccion de mes <mes>
    And Selecciono dia <dia>
    And Valido seleccion de dia <dia>
    And Valido titulo mes y año actual sea de acuerdo a la fecha seleccionada
    And Valido que subtitulo de semana sea de acuerdo a la fecha seleccionada
    And Valido que que primer dia mostrado en fecha sea de acuerdo a la fecha seleccionada

    Examples: 
      | año    | mes          | dia |
      | "2018" | "Septiembre" | "5" |
