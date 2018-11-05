#Author:Yordan Avila - yordan@hakalab.com
@NuevaReservaHoraMedico
Feature: Se valida la reserva de hora de un paciente por medico a traves de la web
  Quiero poder validar la reserva de hora de un paciente por medico

  Scenario Outline: Seleccion de boton nueva reserva de hora
    Given Valido que boton nueva reserva de hora se encuentre habilitado
    And Dar click boton nueva reserva de hora
    And Valido visualizacion titulo
    And Valido que titulo sea correcto
    And Valido que aparezca como titulo el nombre del paciente
    And Llamo servicio token y devuelvo el dato <usuario> <contraseña>
    And Valido coincida nombre paciente desplegado en la web y servicio <rutSearch>
    And Valido visualizacion pestaña medico
    And Valido imagen de pestaña medico
    When Selecciono pestaña medico
    Then Visualizo ventana medico

    Examples: 
      | usuario     | contraseña  | rutSearch    |
      | "RGONZALES" | "password$" | "11111111-1" |

  Scenario: Validacion inicial de los inputs
    Given Valido que contenga texto que aparece inicialmente en input medico
    And Valido que texto inicial de input medico sea el correcto
    And Valido que contenga texto que aparece inicialmente en input especialidad
    And Valido que texto inicial de input especialidad sea el correcto
    And Valido que contenga texto que aparece inicialmente en input prestacion
    And Valido que texto inicial de input prestacion sea el correcto
    And Valido que contenga texto que aparece inicialmente en input region
    And Valido que texto inicial de input region sea el correcto
    And Valido que contenga texto que aparece inicialmente en input centro medico
    And Valido que texto inicial de input centro medico sea el correcto

  Scenario Outline: Seleccion de medico
    When Llamo servicio medico <medico>
    Then Seleccion opcion de medico <medico>
    And Selecciono todos los medicos desplegados en la pagina web
    And Valido que las cantidades de medicos coincidan entre lo desplegado en la web y el servicio
    And Valido label de medico <medico>

    Examples: 
      | medico                   |
      | "burmeister , alejandro" |

  Scenario Outline: Seleccion de especialidad
    When Llamo servicio de especialidad <opcion1> <opcion2> <opcion3>
    And Selecciono la totalidad de especialidades desplegadas en la pagina web
    Then Valido cantidad de especialidad coincidan entre lo desplegado en la web y el servicio
    And Seleccion opcion especialidad
    And Valido label especialidad <especialidad>

    Examples: 
      | opcion1 | opcion2 | opcion3 | especialidad              |
      | ""      | ""      | ""      | "TEST DE ESFUERZO ADULTO" |

  Scenario Outline: Seleccion de prestacion
    When Llamo servicio de prestacion <codEspecialidad> <clasificacion> <codPrestacion>
    And Selecciono la totalidad de prestaciones desplegadas en la pagina web
    Then Valido cantidad de prestacion coincidan entre lo desplegado en la web y el servicio
    And Seleccion opcion prestacion
    And Valido label prestacion <prestacion>

    Examples: 
      | codEspecialidad | clasificacion | codPrestacion | prestacion         |
      | "2140"          | "4"           | ""            | "Test De Esfuerzo" |

  Scenario Outline: Seleccion de region
    When Llamo servicio de region <codEspecialidad> <codPrestacion> <clasificacion>
    And Selecciono totalidad de regiones desplegadas en la pagina web
    Then Valido cantidad de regiones coincidan entre lo desplegado en la web y el servicio
    And Seleccion opcion region
    And Valido label region <region>

    Examples: 
      | codEspecialidad | codPrestacion | clasificacion | region                 |
      | "2140"          | "1701003"     | "4"           | "Región Metropolitana" |

  Scenario Outline: Seleccion de centro medico
    When Llamo servicio centro medico <codEspecialidad> <codPrestacion> <codRegion> <clasificacion>
    And Selecciono totalidad de centros medicos desplegados en la pagina web
    Then Valido cantidad de centros medicos coincidan entre lo desplegado en la web y el servicio
    And Seleccion opcion centro medico
    And Valido label centro medico <centro>

    Examples: 
      | codEspecialidad | codPrestacion | codRegion | clasificacion | centro                    |
      | "2140"          | "1701003"     | "XIII"    | "4"           | "Integramedica Barcelona" |

  Scenario: Seleccion de fechas disponibles
    When Visualizo fechas que se encuentran disponibles
    Then Valido que existe una fecha ya seleccionada
    And Llamo servicio dia
    And Valido que se visualice titulo mes y año actual
    And Valido titulo mes y año sea correcto
    And Valido que se visualice subtitulo de semana
    And Valido rango dias sea correcto a la semana

  Scenario: Seleccion de horas disponibles
    When Valido visualizacion de horas disponibles segun fecha ventana de hora
    Then Valido que aparezca apartado box medico
    And Valido que aparezca titulo fecha seleccionada ventana de hora
    And Valido que aparezca subtitulo especialidad mas prestacion seleccionada
    And Valido que subtitulo especialidad mas prestacion sea el correcto
    And Valido que aparezca subtitulo de centro medico seleccionado
    And Valido que subtitulo de centro medico sea el correcto
    And Valido que aparezca label horario mañana ventana de hora
    And Valido que aparezca listado examen horario mañana ventana de hora
    And Valido que aparezca label horario tarde ventana de hora
    And Valido que aparezca listado examen horario tarde ventana de hora
    And Selecciono una hora disponible ventana de hora

  Scenario: Validacion pantalla resumen consulta medico segun los datos seleccionados
    When Valido que aparezca ventana resumen consulta medico
    Then Valido que aparezca imagen icono doctor ventana resumen consulta medico
    And Valido que aparezca nombre del doctor ventana resumen consulta medico
    And Valido que nombre del doctor visualizado en ventana resumen coincida con el nombre doctor del servicio
    And Valido que aparezca especialidad del doctor ventana resumen consulta medico
    And Valido que la especialidad seleccionada coincida con la mostrada ventana resumen consulta medico
    And Valido que aparezca centro medico ventana resumen consulta medico
    And Valido que el centro medico seleccionado coincida con lo mostrado ventana resumen consulta medico
    And Valido que aparezca seccion paciente ventana resumen consulta medico
    And Valido que aparezca imagen icono genero ventana resumen consulta medico
    And Valido que imagen icono genero coincida entre la busqueda inicial y el mostrado en ventana resumen consulta medico
    And Valido que aparezca nombre paciente ventana resumen consulta medico
    And Valido que nombre coincida entre la busqueda inicial y el mostrado en ventana resumen consulta medico
    And Valido que aparezca correo paciente ventana resumen consulta medico
    And Valido que aparezca seccion consulta ventana resumen consulta medico
    And Valido que aparezca imagen icono calendario ventana resumen consulta medico
    And Valido que aparezca fecha de la consulta ventana resumen consulta medico
    And Valido que fecha coincida entre el apartado de horas y el mostrado en ventana resumen consulta medico
    And Valido que aparezca imagen icono horario ventana resumen consulta medico
    And Valido que aparezca hora de la consulta ventana resumen consulta medico
    And Valido que aparezca imagen icono costo de consulta ventana resumen consulta medico
    And Valido que aparezca monto dinero de la consulta ventana resumen consulta medico
    And Valido que aparezca boton agendar ventana resumen consulta medico
    And Valido que haga click boton agendar ventana resumen consulta medico
