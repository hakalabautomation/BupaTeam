#Author: Yordan Avila - yordan@hakalab.com
@NuevaReservaHoraEspecialidad
Feature: Se valida la reserva de hora de un paciente por especialidad a traves de la web
  Quiero poder validar la reserva de hora de un paciente por especialidad

  Scenario Outline: Seleccion de boton nueva reserva de hora
    Given Presiono boton nueva reserva de hora
    And Valido que se visualice titulo
    And Valido que aparezca como titulo nombre del paciente
    And Llamo al servicio token y devuelvo el dato <usuario> <contraseña>
    And Valido que coincida nombre paciente desplegado en la web y servicio <rutSearch>
    And Valido visualizacion pestaña especialidad
    And Valido imagen de pestaña especialidad
    When Selecciono pestaña especialidad
    Then Visualizo ventana especialidad

    Examples: 
      | usuario     | contraseña  | rutSearch    |
      | "RGONZALES" | "password$" | "11111111-1" |

  Scenario Outline: Seleccion de especialidad
    When Llamo servicio especialidad <codEspacialidad> <tipoClasificacion>
    And Selecciono todas las especialidades desplegadas en la pagina web
    Then Valido que las cantidades de especialidad coincidan entre lo desplegado en la web y el servicio
    And Seleccion opcion de especialidad
    And Valido label de especialidad <especialidad>

    Examples: 
      | codEspacialidad | tipoClasificacion | especialidad         |
      | ""              | "1"               | "Cardiologia Adulto" |

  Scenario Outline: Seleccion de prestacion
    When Llamo al servicio prestacion <codEspacialidad> <clasificacion> <codPrestacion>
    And Selecciono todas las prestaciones desplegadas en la pagina web
    Then Valido que las cantidades prestacion coincidan entre lo desplegado en la web y el servicio
    And Seleccion opcion de prestacion
    And Valido label de prestacion <prestacion>

    Examples: 
      | codEspacialidad | clasificacion | codPrestacion | prestacion                 |
      | "1080"          | "1"           | ""            | "Cons. Cardiologia Adulto" |

  Scenario Outline: Seleccion de region
    When Llamo al servicio region <codEspecialidad> <codPrestacion> <clasificacion>
    And Selecciono todas las regiones desplegadas en la pagina web
    Then Valido que las cantidades region coincidan entre lo desplegado en la web y el servicio
    And Seleccion opcion de region
    And Valido label de region <region>

    Examples: 
      | codEspecialidad | codPrestacion | clasificacion | region                 |
      | "1080"          | "0000000012"  | "1"           | "Región Metropolitana" |

  Scenario Outline: Seleccion de centro medico
    When Llamo al servicio centro medico <codEspecialidad> <codPrestacion> <codRegion> <clasificacion>
    And Selecciono todos los centros medicos desplegados en la pagina web
    Then Valido que las cantidades de centros medicos coincidan entre lo desplegado en la web y el servicio
    And Seleccion opcion de centro medico
    And Valido label de centro medico <centro>

    Examples: 
      | codEspecialidad | codPrestacion | codRegion | clasificacion | centro                    |
      | "1080"          | "0000000012"  | "XIII"    | "1"           | "Integramedica Barcelona" |

  Scenario: Seleccion de fechas disponibles
    When Visualizo fechas disponibles
    Then Valido que existe una fecha seleccionada
    And Llamo al servicio dia
    And Valido que aparezca titulo mes y año actual
    And Valido el titulo mes y año sea correcto
    And Valido que aparezca subtitulo de semana
    And Valido rango de dias sea correcto a la semana

  Scenario: Validacion de horas disponibles segun fecha seleccionada
    When Valido que aparezca apartado de horas de especialidad
    Then Valido que aparezca titulo de fecha segun dia seleccionado
    And Valido que titulo de fecha sea correcto segun dia seleccionado
    And Valido que subtitulo especialidad mas prestacion coincida segun lo seleccionado
    And Valido que subtitulo centro medico coincida segun lo seleccionado
    And Selecciono una hora disponible ventana de hora especialidad

  Scenario: Validacion pantalla resumen especialidad segun los datos seleccionados
    When Valido que aparezca ventana resumen de la especialidad
    Then Valido que aparezca imagen icono doctor ventana resumen especialidad
    And Valido que aparezca nombre del doctor ventana resumen especialidad
    And Valido que aparezca especialidad del doctor ventana resumen especialidad
    And Valido que la prestacion seleccionada coincida con la mostrada ventana resumen especialidad
    And Valido que aparezca centro medico ventana resumen especialidad
    And Valido que el centro medico seleccionado coincida con lo mostrado ventana resumen especialidad
    And Valido que aparezca seccion paciente ventana resumen especialidad
    And Valido que aparezca imagen icono genero ventana resumen especialidad
    And Valido que imagen icono genero coincida entre la busqueda inicial y el mostrado en ventana resumen especialidad
    And Valido que aparezca nombre paciente ventana resumen especialidad
    And Valido que nombre coincida entre la busqueda inicial y el mostrado en ventana resumen especialidad
    And Valido que aparezca correo paciente ventana resumen especialidad
    And Valido que aparezca seccion consulta ventana resumen especialidad
    And Valido que aparezca imagen icono calendario ventana resumen especialidad
    And Valido que aparezca fecha de la consulta ventana resumen especialidad
    And Valido que fecha coincida entre el apartado de horas y el mostrado en ventana resumen especialidad
    And Valido que aparezca imagen icono horario ventana resumen especialidad
    And Valido que aparezca hora de la consulta ventana resumen especialidad
    And Valido que aparezca imagen icono costo de consulta ventana resumen especialidad
    And Valido que aparezca monto dinero de la consulta ventana resumen especialidad
    And Valido que aparezca boton agendar ventana resumen especialidad
    And Valido que haga click boton agendar ventana resumen especialidad
