#Author: Yordan Avila - yordan@hakalab.com
@NuevaReservaDeHoraExamen
Feature: Se valida la Reserva de hora de un paciente un examen a traves de la web
  			Validacion de reserva de hora de paciente por examen

  Scenario Outline: Seleccion de especialidad
    Given Selecciono el boton nueva reserva de hora
    And Selecciono pestaña examenes
    When Seleccion de especialidad <especialidad>
    Then Valido seleccion de especialidad <especialidad>
    And Valido label especialidad

    Examples: 
      | especialidad              |
      | "Test De Esfuerzo Adulto" |

  Scenario Outline: Selecciono prestacion
    When Selecciono prestacion <prestacion>
    Then Valido seleccion de prestacion <prestacion>
    And Valido label prestacion

    Examples: 
      | prestacion         |
      | "Test De Esfuerzo" |

  Scenario Outline: Selecciono region
    When Selecciono region<region>
    Then Valido seleccion region <region>
    And Valido label region

    Examples: 
      | region                 |
      | "Región Metropolitana" |

  Scenario Outline: Selecciono centro medico
    When Selecciono centro medico <centro>
    Then Valido seleccion centro medico <centro>
    And Valido label centro medico

    Examples: 
      | centro                    |
      | "Integramedica Manquehue" |

  Scenario: Seleccion de fechas
    When Visualizo fechas habilitadas
    Then Valido que exista una fecha ya seleccionada
    And Valido label mes y año actual
    And Valido que label mes y año actual sea correcto    

  Scenario: Validacion de horas disponible segun fecha
    When Valido que aparezca apartado de horas de examenes
    Then Valido que aparezca titulo de fecha segun el dia seleccionado
    And Valido que titulo de fecha sea correcto segun el dia seleccionado
    And Valido que subtitulo de especialidad mas prestacion coincida segun lo seleccionado
    And Valido que el subtitulo centro medico coincida segun lo seleccionado
    And Selecciono una hora disponible ventana de hora examen
    
 Scenario: Validacion pantalla resumen examen segun los datos seleccionados previamente
    And Valido que aparezca ventana resumen examen
    And Valido que aparezca imagen icono examen ventana de resumen examen
    And Valido que aparezca especialidad ventana de resumen examen
    And Valido que aparezca centro medico ventana de resumen examen
    And Valido que aparezca imagen genero ventana de resumen examen
    And Valido imagen genero de acuerdo a la condicion ventanan de resumen examen
    And Valido que aparezca nombre paciente ventana de resumen examen
    And Valido que aparezca email paciente ventana de resumen examen
    And Valido que aparezca imagen calendario ventana de resumen examen
    And Valido que aparezca fecha seleccionada ventana de resumen examen
    And Valido que aparezca imagen horario ventana de resumen examen
    And Valido que aparezca hora seleccionada ventana de resumen examen
    And Valido que aparezca imagen dinero ventana de resumen examen
    And Valido que aparezca monto dinero en ventana resumen examen
    And Valido que aparezca link leer indicaciones ventana de resumen examen
    And Valido que haga click link leer indicaciones ventana de resumen examen
    And Valido que aparezca boton agendar ventana de resumen examen
    And Valido que haga click boton agendar ventana de resumen examen
