#Author: Yordan Avila - yordan@hakalab.com
@BusquedaAvanzadaEspecialidad
Feature: Se valida la seleccion de un dia a traves de la busqueda de la fecha avanzada en especialidad
  Quiero poder seleccionar una fecha avanzada por seleccionar año, mes y dia

  Scenario Outline: Seleccion especialidad
    Given Selecciono boton nueva reserva de hora para especialidad
    And Selecciono opcion pestaña especialidad
    When Selecciono una especialidad
    Then Valido seleccion especialidad pestaña especialidad <especialidad>
    And Valido el label de especialidad pestaña especialidad

    Examples: 
      | especialidad         |
      | "Cardiologia Adulto" |

  Scenario Outline: Seleccion prestacion
    When Selecciono una prestacion
    Then Valido seleccion prestacion pestaña especialidad <prestacion>
    And Valido el label prestacion pestaña especialidad

    Examples: 
      | prestacion                    |
      | "Consulta Cardiologia Adulto" |

  Scenario Outline: Selecciono region
    When Selecciono una region
    Then Valido seleccion region pestaña especialidad <region>
    And Valido el label region pestaña especialidad

    Examples: 
      | region                 |
      | "Región Metropolitana" |

  Scenario Outline: Selecciono centro medico
    When Selecciono un centro medico
    Then Valido seleccion centro medico pestaña especialidad <centro>
    And Valido el label centro medico pestaña especialidad

    Examples: 
      | centro                    |
      | "Integramedica Barcelona" |

  Scenario Outline: Seleccion de fecha opcion busqueda avanzada
    When Valido que boton de fecha busqueda avanzada se encuentro habilitado
    Then Doy click en boton fecha busqueda avanzada pestaña especialidad
    And Valido que muestre calendario extendido pestaña especialidad
    And Valido que se visualice titulo busqueda avanzada pestaña especialidad
    And Valido titulo de busqueda avanzada pestaña especialidad
    And Valido que se visualice mes y semana pestaña especialidad 
    And Valido subtitulo mes y semana pestaña especialidad
    And Selecciono año pestaña especialidad
    And Valido seleccion de año pestaña especialidad <año>
    And Selecciono mes pestaña especialidad
    And Valido seleccion de mes pestaña especialidad <mes>
    And Selecciono dia pestaña especialidad
    And Valido seleccion de dia pestaña especialidad <dia>
    And Valido titulo mes y año actual sea de acuerdo a la fecha seleccionada pestaña especialidad
    And Valido que subtitulo de semana sea de acuerdo a la fecha seleccionada pestaña especialidad
    And Valido que que primer dia mostrado en fecha sea de acuerdo a la fecha seleccionada pestaña especialidad

    Examples: 
      | año    | mes          | dia |
      | "2018" | "Septiembre" | "7" |
