#Author: Yordan Avila - yordan@hakalab.com
@BusquedaFechaAvanzadaMedico
Feature: Se valida la seleccion de un dia a traves de la busqueda de la fecha avanzada en consulta medico
  Quiero poder seleccionar una fecha avanzada por seleccionar año, mes y dia

  Scenario: Seleccion boton nueva reserva hora y seleccion pestaña medico
    Given Selecciono boton nueva reserva de hora para consulta medico
    When Valido que muestre ventana nueva reserva
    Then Seleccion pestaña medico

  Scenario Outline: Seleccion medico
    When Selecciono opcion medico <medico>
    Then Valido seleccion medico pestaña medico <medico>
    And Valido el label de medico pestaña medico

    Examples: 
      | medico                   |
      | "burmeister , alejandro" |

  Scenario Outline: Seleccion especialidad
    When Seleccion de opcion especialidad
    Then Valido seleccion especialidad pestaña medico <especialidad>
    And Valido el label de especialidad pestaña medico

    Examples: 
      | especialidad              |
      | "TEST DE ESFUERZO ADULTO" |

  Scenario Outline: Seleccion prestacion
    When Selecciono de opcion prestacion
    Then Valido seleccion prestacion pestaña medico <prestacion>
    And Valido el label prestacion pestaña medico

    Examples: 
      | prestacion         |
      | "Test De Esfuerzo" |
      
  Scenario Outline: Selecciono region
    When Seleccion de opcion region
    Then Valido seleccion region pestaña medico <region>
    And Valido el label region pestaña medico

    Examples: 
      | region                 |
      | "Región Metropolitana" |

  Scenario Outline: Selecciono centro medico
    When Seleccion de opcion centro medico
    Then Valido seleccion centro medico pestaña medico <centro>
    And Valido el label centro medico pestaña medico

    Examples: 
      | centro                    |
      | "Integramedica Barcelona" |

  Scenario Outline: Seleccion de fecha opcion busqueda avanzada
    When Valido boton de fecha busqueda avanzada se encuentro habilitado
    Then Presiono boton fecha busqueda avanzada pestaña medico
    And Valido que muestre calendario extendido pestaña medico
    And Valido que se visualice titulo busqueda avanzada pestaña medico
    And Valido titulo de busqueda avanzada pestaña medico
    And Valido que se visualice mes y semana pestaña medico 
    And Valido subtitulo mes y semana pestaña medico
    And Selecciono año pestaña medico
    And Valido seleccion de año pestaña medico <año>
    And Selecciono mes pestaña medico
    And Valido seleccion de mes pestaña medico <mes>
    And Selecciono dia pestaña medico
    And Valido seleccion de dia pestaña medico <dia>
    And Valido titulo mes y año actual sea de acuerdo a la fecha seleccionada pestaña medico
    And Valido que subtitulo de semana sea de acuerdo a la fecha seleccionada pestaña medico
    And Valido que que primer dia mostrado en fecha sea de acuerdo a la fecha seleccionada pestaña medico

    Examples: 
      | año    | mes          | dia |
      | "2018" | "Septiembre" | "7" |