#Author: Yordan Avila - yordan@hakalab.com
@AnulacionNuevaReservaHoraIndicacionesEspecialidad
Feature: Se valida la anulacion de reserva de hora de especialdiad que contiene indicaciones a traves de la web
  Validacion de la anulacion de reserva de hora de especialidad contiene indicaciones

  Scenario Outline: Seleccion boton de nueva reserva de hora
    Given Doy click en boton nueva reserva de hora
    And Valido que se muestre titulo
    And Valido que se visualice como titulo nombre del paciente
    And Llamo al servicio token y devuelvo datos <usuario> <contraseña>
    And Valido que coincida el nombre paciente desplegado en la web y servicio <rutSearch>
    And Valido que se visualice pestaña especialidad
    And Valido imagen mostrada en pestaña especialidad
    When Seleccion pestaña especialidad
    Then Visualizo ventana de especialidad

    Examples: 
      | usuario     | contraseña  | rutSearch    |
      | "RGONZALES" | "password$" | "11111111-1" |

  Scenario Outline: Seleccion de especialidad
    When Llamo al servicio de especialidad <codEspacialidad> <tipoClasificacion>
    And Selecciono lista de especialidades desplegadas en la pagina web
    Then Valido que la cantidad del listado especialidad coincida entre lo desplegado en la web y el servicio
    And Selecciono opcion de especialidad
    And Valido el label de especialidad <especialidad>

    Examples: 
      | codEspacialidad | tipoClasificacion | especialidad         |
      | ""              | "1"               | "Medicina General" |
      
   Scenario Outline: Seleccion de prestacion
    When Llamo al servicio de prestacion <codEspacialidad> <clasificacion> <codPrestacion>
    And Selecciono lista de prestaciones desplegadas en la pagina web
    Then Valido que la cantidad del listado prestacion coincida entre lo desplegado en la web y el servicio
    And Selecciono opcion de prestacion
    And Valido el label de prestacion <prestacion>

    Examples: 
      | codEspacialidad | clasificacion | codPrestacion | prestacion                    |
      | "2690"          | "1"           | ""            | "Cons. Medicina General" |   
      
   Scenario Outline: Seleccion de region
    When Llamo al servicio de region <codEspecialidad> <codPrestacion> <clasificacion>
    And Selecciono lista de regiones desplegados en la pagina web
    Then Valido que la cantidad del listado region coincida entre lo desplegado en la web y el servicio
    And Selecciono opcion de region
    And Valido el label de region <region>

    Examples: 
      | codEspecialidad | codPrestacion | clasificacion | region                 |
      | "2690"          | "0101814A"    | "1"           | "Región Metropolitana" |
      
   Scenario Outline: Seleccion de centro medico
    When Llamo al servicio de centro medico <codEspecialidad> <codPrestacion> <codRegion> <clasificacion>
    And Selecciono lista de centros medicos desplegados en la pagina web
    Then Valido que la cantidade de centros medicos coincidan entre lo desplegado en la web y el servicio
    And Selecciono opcion de centro medico
    And Valido el label de centro medico <centro>

    Examples: 
      | codEspecialidad | codPrestacion | codRegion | clasificacion | centro                    |
      | "2690"          | "0101814A"    | "XIII"    | "1"           | "Integramedica Alameda" |
      
   Scenario: Seleccion de fechas disponibles
    When Visualizo fechas que estan disponibles
    Then Valido que existe una fecha especifica seleccionada
    And Llamo al servicio de dia
    And Valido que aparezca titulo de mes y año actual
    And Valido el titulo mes y año que sea correcto
    And Valido que aparezca el subtitulo de semana
    And Valido que rango de dias sea correcto a la semana
   
  Scenario: Validacion de horas disponibles segun fecha seleccionada
    When Valido que aparezca apartado de horas de la especialidad
    Then Valido que aparezca titulo fecha segun dia seleccionado
    And Valido que titulo fecha sea correcto segun dia seleccionado
    And Valido que subtitulo compuesto entre especialidad mas prestacion coincida segun lo seleccionado
    And Valido que subtitulo de centro medico coincida segun lo seleccionado
    And Selecciono una hora disponible en ventana de hora especialidad
   
  Scenario: Validacion pantalla resumen especialidad segun los datos seleccionados
    When Valido que se visualice ventana resumen de la especialidad
    Then Valido que se visualice imagen icono doctor ventana resumen especialidad
    And Valido que se visualice nombre del doctor ventana resumen especialidad
    And Valido que se visualice especialidad del doctor ventana resumen especialidad
    And Valido que especialidad seleccionada coincida con la mostrada ventana resumen especialidad
    And Valido que se visualice centro medico ventana resumen especialidad
    And Valido que centro medico seleccionado coincida con lo mostrado ventana resumen especialidad
    And Valido que se visualice seccion paciente ventana resumen especialidad
    And Valido que se visualice imagen icono genero ventana resumen especialidad
    And Valido que imagen icono de genero coincida entre la busqueda inicial y el mostrado en ventana resumen especialidad
    And Valido que se visualice nombre paciente ventana resumen especialidad
    And Valido que nombre paciente coincida entre la busqueda inicial y el mostrado en ventana resumen especialidad
    And Valido que se visualice correo paciente ventana resumen especialidad
    And Valido que se visualice seccion consulta ventana resumen especialidad
    And Valido que se visualice imagen icono calendario ventana resumen especialidad
    And Valido que se visualice fecha de la consulta ventana resumen especialidad
    And Valido que fecha mostrada coincida entre el apartado de horas y el mostrado en ventana resumen especialidad
    And Valido que se visualice imagen icono horario ventana resumen especialidad
    And Valido que se visualice hora de la consulta ventana resumen especialidad
    And Valido que se visualice imagen icono costo de consulta ventana resumen especialidad
    And Valido que se visualice monto dinero de la consulta ventana resumen especialidad
    And Valido que se visualice boton agendar ventana resumen especialidad
    And Valido que se haga click boton agendar ventana resumen especialidad
    
  Scenario: Validacion de ventana que muestra las indicaciones
    When Doy click al boton agendar ventana resumen especialidad
    Then Valido que se visualice ventana indicaciones
    And Valido que se visualice titulo leer indicaciones ventana indicaciones
    And Valido que titulo leer indicaciones sea correcto ventana indicaciones
    And Valido que se visualice texto indicaciones ventana indicaciones
    And Valido que se visualice boton he leido las indicaciones ventana indicaciones
    And Valido que boton he leido indicaciones haga click ventana indicaciones
    And Valido que se visualice boton anular reserva ventana indicaciones
    And Valido que boton anular reserva haga click ventana indicaciones
    And Doy click al boton anular resereva ventana indicaciones
    
  Scenario: Validacion de ventana informativa anulacion de reserva
  	Then Valido que se visualice vetana anulacion cita
  	And Valido que se visualice titulo ventana anulacion cita
  	And Valido que titulo de anulacion cita sea el correcto ventana anulacion cita
  	And Valido que se visualice imagen check ventana anulacion cita
  	And Valido que se visualice parrafo ventana anulacion cita
  	And Valido que parrafo de hora anulada sea el correcto ventana anulacion cita
  	And Valido que se muestre boton aceptar ventana anulacion cita
  	And Valido boton aceptar haga click ventana anulacion cita
  	And Doy click boton aceptar ventana anulacion cita
  	And Valido que se visualice apartado de horas de especialidad
      
          