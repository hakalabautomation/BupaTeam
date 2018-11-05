#Author: Yordan Avila - yordan@hakalab.com
@BusquedaPacienteOCMPendientesPestañaPorGestionar
Feature: Se valida la búsqueda paciente con OCM pendientes
  Quiero poder validar si el paciente tiene con OCM pendientes

  Scenario: Realizar un refresh a la pagina
    When Realizo un refresco a la pagina principal
    Then Valido que no se visualice seccion datos del paciente
    And Valido que no se muestre imagen paciente
    And Valido que no se muestre nombre paciente
    And Valido que no se muestre genero y edad paciente
    And Valido que no se muestre correo
    And Valido que no se muestre telefono
    And Valido que no se muestre rut
    And Valido que no se muestre prevision
    And Valido que no se muestre link editar informacion paciente
    And Valido que no se muestre boton nueva reserva de hora

  Scenario Outline: Busqueda paciente con OCM pendientes
    Given Ingreso rut de paciente a buscar <rut>
    When Llamo a servicio obtencion de token <usuario> <contraseña>
    Then Valido que paciente exista en el servicio
    And Presiono boton de buscar

    Examples: 
      | rut        | usuario     | contraseña  |
      | "93155297" | "RGONZALES" | "password$" |

  Scenario Outline: Llamada del servicio paciente con OCM pendientes
    Given Llamo al servicio de paciente con ocm pendientes <rut>
    When Valido que servicio paciente con OCM pendientes retorne datos
    Then Valido que paciente tenga ocm pendientes

    Examples: 
      | rut         | usuario     | contraseña  |
      | "9315529-7" | "RGONZALES" | "password$" |

  Scenario: Validacion de componentes pantalla de OCM pendientes seccion informacion pacientes
    Given Valido que se visualice pantalla OCM pendientes
    And Valido que se visualice seccion informacion pacientes
    When Valido que se visualice imagen de paciente
    Then Valido que se visualice nombre del paciente
    And Valido que se visualice genero del paciente
    And Valido que se visualice años del paciente
    And Valido que se visualice correo del paciente
    And Valido que se visualice numero telefono del paciente
    And Valido que se visualice rut del paciente
    And Valido que se visualice prevision del paciente
    And Valido que se visualice link datos del paciente
    And Valido que link datos del paciente sea correcto
    And Valido que se visualice seccion de botoneras acciones reservas
    And Valido que se visualice boton nueva reserva de hora
    And Valido que boton nueva reserva de hora sea correcto
    And Valido que boton nueva reserva de hora se encuentre estado habilitado
    And Valido que se visualice boton reservar por hora y precio
    And Valido que boton reservar por hora y precio sea correcto
    And Valido que boton reservar por hora y precio se encuentre estado habilitado
    And Valido que se visualice boton reenviar email agendar
    And Valido que boton reenviar email agendar sea correcto
    And Valido que boton reenviar email agendar se encuentre estado habilitado
    And Valido que se visualice checkbox llamar en otro momento
    And Valido que texto llamar en otro momento sea correcto
    And Valido que se visualice checkbox no quiero hacer los examenes
    And Valido que texto no quiero hacer los examenes sea correcto
    And Valido que se visualice checkbox no quiero que lo contacten
    And Valido que texto no quiero que lo contacten sea correcto
    And Valido que se visualice checkbox paciente incontactable
    And Valido que texto paciente incontactable sea correcto

  Scenario: Validacion link datos paciente y apertura ventana edicion datos paciente
    Given Valido que link datos del paciente se encuentre habilitado
    When Realizar click en  link datos del paciente
    Then Valido que se visualice despliegue ventana editar paciente
    And Valido que se visualice el boton x para cerrar ventana
    And Valido que se visualice titulo de editar datos paciente
    And Valido que titulo que se visualiza sobre editar datos paciente sea el correcto
    And Valido que se visualice label de rut
    And Valido que el label rut sea correcto
    And Valido que se visualice campo de rut
    And Valido que campo de rut no se encuentre habilitado
    And Valido que se visualice label de nombres
    And Valido que el label nombres sea correcto
    And Valido que se visualice campo de nombres
    And Valido que se visualice label de apellidos
    And Valido que el label apellidos sea correcto
    And Valido que se visualice campo de apellido paterno
    And Valido que se visualice campo de apellido materno
    And Valido que se visualice label de fecha de nacimiento
    And Valido que el label fecha de nacimiento sea correcto
    And Valido que se visualice campo de fecha dia
    And Valido que se visualice campo de fecha mes
    And Valido que se visualice campo de fecha año
    And Valido que se visualice label de genero
    And Valido que el label genero sea correcto
    And Valido que se visualice campo de genero
    And Valido campo genero no se encuentre vacio
    And Valido que se visualice label de prevision
    And Valido que el label prevision sea correcto
    And Valido que se visualice campo de prevision
    And Valido campo prevision no se encuentre vacio
    And Valido que se visualice label de correo
    And Valido que el label correo sea correcto
    And Valido que se visualice campo de correo
    And Valido que se visualice label de telefono
    And Valido que el label telefono sea correcto
    And Valido que se visualice campo de telefono
    And Valido que se visualice label de nacionalidad
    And Valido que el label nacionalidad sea correcto
    And Valido que se visualice campo de nacionalidad
    And Valido campo nacionalidad no se encuentre vacio
    And Valido que se visualice label de direccion
    And Valido que el label direccion sea correcto
    And Valido que se visualice campo de direccion
    And Valido que se visualice campo de comuna
    And Valido que se visualice campo de region
    And Valido campo region no se encuentre vacio
    And Valido que se visualice el boton guardar

  Scenario Outline: Ingreso nuevo datos en seccion edicion datos paciente
    Then Ingreso nuevo valor en campo nombres <nombres>
    And Ingreso nuevo valor en campo apellido paterno <apellidoPaterno>
    And Ingreso nuevo valor en campo apellido materno <apellidoMaterno>
    And Ingreso nuevo valor en campo fecha de nacimiento dia <dia>
    And Ingreso nuevo valor en campo fecha de nacimiento mes <mes>
    And Ingreso nuevo valor en campo fecha de nacimiento año <año>
    And Ingreso nuevo valor en campo genero <genero>
    And Ingreso nuevo valor en campo prevision <prevision>
    And Ingreso nuevo valor en campo correo <correo>
    And Ingreso nuevo valor en campo telefono <telefono>
    And Ingreso nuevo valor en campo nacionalidad <nacionalidad>
    And Ingreso nuevo valor en campo direccion <direccion>
    And Ingreso nuevo valor en campo comuna <comuna>
    And Ingreso nuevo valor en campo region <region>
    And Realizar click en boton guardar

    Examples: 
      | nombres | apellidoPaterno | apellidoMaterno | dia  | mes  | año    | genero | prevision | correo          | telefono   | nacionalidad | direccion          | comuna        | region |
      | "Chase" | "Hernandez"     | "Hernandez"     | "18" | "11" | "1962" | "1"    | "4"       | "hola@hola.com" | "64367268" | "43"         | "Av .Napoles 1426" | "Cerro Navia" | "12"   |

  Scenario: Validacion de componentes pantalla confirmacion edicion datos paciente
    When Valido que se visualice ventana de confirmacion exitosa edicion datos paciente
    Then Valido que se visualice titulo ventana en edicion de datos
    And Valido que titulo ventana en edicion de datos sea correcto
    And Valido que se visualice imagen ventana en edicion de datos
    And Valido que se visualice mensaje ventana en edicion de datos
    And Valido que se visualice  boton aceptar
    And Valido que boton aceptar este habilitado
    And Realizar click en boton aceptar
    And Valido que se visualice nuevamente pantalla OCM pendientes

  Scenario: Validacion boton nueva reserva de hora
    When Valido que boton nueva reserva de hora se encuentra habilitado
    Then Hago click en boton nueva reserva de hora
    And Valido la visualizacion ventana nueva reserva
    And Valido la visualizacion del tab consulta
    And Valido la visualizacion del tab profesional
    And Valido la visualizacion del tab examenes
    And Valido la visualizacion del boton close ventana nueva reserva
    And Valido que boton close se encuentre habilitado ventana nueva reserva
    And Hagoo click en boton close ventana nueva reserva
    And Valido que se visualice nuevamente ventana OCM pendientes

  Scenario: Validacion de componentes pantalla de OCM pendientes seccion box agendamiento
    Given Valido que se visualice seaccion box agendamiento
    When Valido que se visualice elemento que contiene los tab
    Then Valido que se visualice tab por gestionar
    And Valido que tab por gestionar sea correcto
    And Valido que se visualice tab gestionado
    And Valido que tab gestionado sea correcto

  Scenario Outline: Validacion de componente tabla ordenes tab por gestionar
    Then Valido que se visualice tabla de ordenes por gestionar
    And Valido que se visualice header orden medica tabla ordenes por gestionar
    And Valido que header orden medica en tabla ordenes por gestionar sea correcto
    And Valido que se visualice header fecha tabla ordenes por gestionar
    And Valido que header fecha en tabla ordenes por gestionar sea correcto
    And Valido que se visualice header profesional tabla ordenes por gestionar
    And Valido que header profesional en tabla ordenes por gestionar sea correcto
    And Valido que tabla de ordenes por gestionar contenga ordenes pendientes
    And Valido que tabla de ordenes por gestionar contenga boton apertura detalle orden
    And Realizar click en boton apertura detalle orden tabla ordenes por gestionar <orden>
    And Valido que tabla de ordenes por gestionar contenga el detalle de las prestaciones

    Examples: 
      | orden |
      | "2"   |

  Scenario Outline: Validacion prestacion no agendable
    Then Valido que se visualice link leer indicaciones prestacion no agendable <linkLeerIndicacionesPrestacionNoAgendable>
    And Valido que link leer indicaciones sea correcto prestacion no agendable <linkLeerIndicacionesPrestacionNoAgendable>
    And Realizar click link leer indicaciones <linkLeerIndicacionesPrestacionNoAgendable>
    And Valido que se visualice ventana leer todas las indicaciones
    And Valido que se visualice titulo ventana leer todas las indicaciones
    And Valido titulo sea correcto ventana leer todas las indicaciones
    And Valido que se visualice elemento contenedor listado de indicaciones ventana leer todas las indicaciones
    And Valido que se visualice listado indicaciones ventana leer todas las indicaciones
    And Valido que se visualice texto prestacion sin indicaciones ventana leer todas las indicaciones
    And Valido texto prestacion sin indicaciones sea correcto ventana leer todas las indicaciones
    And Valido que se visualice boton he leido las indicaciones ventana leer todas las indicaciones
    And Valido boton he leido las indicaciones se encuentre habilitado ventana leer todas las indicaciones
    And Realizar click boton he leido las indicaciones ventana leer todas las indicaciones
    And Valido que se visualice imagen icono no agendable prestacion no agendable <iconoPrestacionNoAgendable>
    And Valido mensaje imagen no agendable sea correcto prestacion no agendable <iconoPrestacionNoAgendable>
    And Valido que se visualice imagen icono multiopcion prestacion no agendable <iconoMultiOpcionPrestacionNoAgendable>
    And Realizar click icono multiopcion prestacion no agendable <iconoMultiOpcionPrestacionNoAgendable>
    And Valido que se visualice primera opcion enviar indicaciones icono multiopcion prestacion no agendable <opcionUnoEnviarIndicaciones>
    And Valido que se visualice segunda opcion rechazar asesoria icono multiopcion prestacion no agendable <opcionDosRechazarAsesoria>
    And Valido que segunda opcion rechazar asesoria se encuentre habilitado icono multiopcion prestacion no agendable <opcionDosRechazarAsesoria>
    And Valido que no se pueda hacer click prestacion no agendable <detallePrestacionNoAgendable>

    Examples: 
      | linkLeerIndicacionesPrestacionNoAgendable | iconoPrestacionNoAgendable | iconoMultiOpcionPrestacionNoAgendable | opcionUnoEnviarIndicaciones | opcionDosRechazarAsesoria | detallePrestacionNoAgendable |
      | "0"                                       | "0"                        | "0"                                   | "0"                         | "1"                       | "0"                          |

  Scenario Outline: Validacion prestacion no disponibilidad para los proximos 7 dias
    Then Valido que se visualice icono imagen pestaña apertura prestacion no disponibilidad para proximos dias <pestañaAperturaPrestacionSinDisponibilidad>
    And Valido que icono imagen pestaña apertura se encuentre habilitado prestacion no disponibilidad para proximos dias <pestañaAperturaPrestacionSinDisponibilidad>
    And Valido que se visualice link leer indicaciones prestacion no disponibilidad para proximos dias <linkLeerIndicacionesPrestacionSinDisponibilidad>
    And Valido que link leer indicaciones sea correcto prestacion no disponibilidad para proximos dias <linkLeerIndicacionesPrestacionSinDisponibilidad>
    And Realizar click link leer indicaciones prestacion no disponibilidad para proximos dias <linkLeerIndicacionesPrestacionSinDisponibilidad>
    And Valido que se visualice ventana leer las indicaciones
    And Valido que se visualice titulo ventana leer indicaciones
    And Valido que titulo sea correcto ventana leer indicaciones
    And Valido que se visualice elemento contenedor listado de indicaciones ventana leer indicaciones
    And Valido que se visualice listado de indicaciones ventana leer indicaciones
    And Valido que se visualice boton he leido las indicaciones ventana leer indicaciones
    And Valido boton he leido las indicaciones se encuentre habilitado ventana leer indicaciones
    And Realizar click boton he leido las indicaciones ventana leer indicaciones
    And Realizar click en detalle de prestacion no disponibilidad para proximos dias <detallePrestacionSinDisponibilidad>
    And Valido que se visualice header prestador no disponibilidad para proximos dias <headerPrestadorSinDisponibilidad>
    And Valido que header prestador listado de no disponibilidad para proximos dias <headerPrestadorSinDisponibilidad>
    And Valido que se visualice imagen icono orden header prestador listado de no disponibilidad para proximos dias <iconoPrestadorSinDisponibilidad>
    And Valido que se visualice header proxima hora listado no disponibilidad para proximos dias <headerProximaHoraSinDisponibilidad>
    And Valido que header proxima hora listado no disponibilidad para proximos dias <headerProximaHoraSinDisponibilidad>
    And Valido que se visualice imagen icono orden header proxima hora listado de no disponibilidad para proximos dias <iconoProximaHoraSinDisponibilidad>
    And Valido que se visualice header copago listado no disponibilidad para proximos dias <headerCopagoSinDisponibilidad>
    And Valido que header copago listado no disponibilidad para proximos dias <headerCopagoSinDisponibilidad>
    And Valido que se visualice imagen icono orden header copago listado de no disponibilidad para proximos dias <iconoCopagoSinDisponibilidad>
    And Valido que se visualice header profesional listado no disponibilidad para proximos dias <headerProfesionalSinDisponibilidad>
    And Valido que header profesional listado no disponibilidad para proximos dias <headerProfesionalSinDisponibilidad>
    And Valido que se visualice imagen icono orden header profesional listado de no disponibilidad para proximos dias <iconoProfesionalSinDisponibilidad>
    And Valido visualizacion mensaje no hay disponibilidad listado no disponibilidad para proximos dias <mensajeNoHayDisponibilidadListadoSinDisponibilidad>
    And Valido mensaje no hay disponibilidad listado no disponibilidad para proximos dias sea correcto <mensajeNoHayDisponibilidadListadoSinDisponibilidad>
    And Valido visualizacion boton mas opciones listado no disponibilidad para proximos dias
    And Realizar click en boton mas opciones listado no disponibilidad para proximos dias <botonMasOpcionesListadoSinDisponibilidad>
    And Valido visualizacion listado mas opciones listado no disponibilidad para proximos dias
    And Valido no visualizacion primera opcion agendar hora listado no disponibilidad para proximos dias <opcionAgendarBotonMasOpcionesListadoSinDisponibilidad>
    And Valido visualizacion segunda opcion mas horas listado no disponibilidad para proximos dias <opcionMasHorasBotonMasOpcionesListadoSinDisponibilidad>
    And Valido segunda opcion mas horas sea correcto listado no disponibilidad para proximos dias <opcionMasHorasBotonMasOpcionesListadoSinDisponibilidad>
    And Valido segunda opcion mas horas se encuentre habilitado listado no disponibilidad para proximos dias <opcionMasHorasBotonMasOpcionesListadoSinDisponibilidad>
    And Realizar click segunda opcion mas horas listado no disponibilidad para proximos dias <opcionMasHorasBotonMasOpcionesListadoSinDisponibilidad>
    And Valido visualizacion ventana nueva reserva de hora
    And Realizar click boton cerrar ventana nueva reserva de hora <botonCerrarVentanaNuevaReservaHora>
    And Realizar click nuevamente en detalle de prestacion no disponibilidad para proximos dias <detallePrestacionSinDisponibilidad>

    Examples: 
      | pestañaAperturaPrestacionSinDisponibilidad | linkLeerIndicacionesPrestacionSinDisponibilidad | detallePrestacionSinDisponibilidad | headerPrestadorSinDisponibilidad | iconoPrestadorSinDisponibilidad | headerProximaHoraSinDisponibilidad | iconoProximaHoraSinDisponibilidad | headerCopagoSinDisponibilidad | iconoCopagoSinDisponibilidad | headerProfesionalSinDisponibilidad | iconoProfesionalSinDisponibilidad | mensajeNoHayDisponibilidadListadoSinDisponibilidad | botonMasOpcionesListadoSinDisponibilidad | opcionAgendarBotonMasOpcionesListadoSinDisponibilidad | opcionMasHorasBotonMasOpcionesListadoSinDisponibilidad | botonCerrarVentanaNuevaReservaHora |
      | "2"                                        | "7"                                             | "7"                                | "0"                              | "3"                             | "1"                                | "4"                               | "2"                           | "5"                          | "3"                                | "6"                               | "0"                                                | "0"                                      | "0"                                                   | "2"                                                    | "0"                                |

  Scenario Outline: Validacion listado proximas horas disponibles
    Then Valido que se visualice icono imagen pestaña apertura prestacion listado de las proximas horas disponibles <pestañaAperturaPrestacionProximasHorasDisponible>
    And Valido que icono imagen pestaña apertura se encuentre habilitado prestacion listado de las proximas horas disponibles <pestañaAperturaPrestacionProximasHorasDisponible>
    And Valido que se visualice link leer indicaciones listado de las proximas horas disponibles <linkLeerIndicacionesProximasHorasDisponible>
    And Valido que link leer indicaciones sea correcto listado de las proximas horas disponibles <linkLeerIndicacionesProximasHorasDisponible>
    And Realizar click link leer indicaciones listado de las proximas horas disponibles <linkLeerIndicacionesProximasHorasDisponible>
    And Valido la visualizacion ventana leer las indicaciones
    And Valido la visualizacion titulo ventana leer indicaciones
    And Valido que el titulo indicaciones sea correcto ventana leer indicaciones
    And Valido la visualizacion elemento contenedor listado de indicaciones ventana leer indicaciones
    And Valido la visualizacion listado de indicaciones ventana leer indicaciones
    And Valido la visualizacion boton he leido las indicaciones ventana leer indicaciones
    And Valido que boton he leido las indicaciones se encuentre habilitado ventana leer indicaciones
    And Realizar click en boton he leido las indicaciones ventana leer indicaciones
    And Realizar click en detalle de prestacion listado de las proximas horas disponibles <detallePrestacionListadoProximasHorasDisponible>
    And Valido que el detalle de prestacion contenga listado de las proximas horas disponibles
    And Valido que se visualice header prestador listado de las proximas horas disponibles <headerPrestadorProximasHorasDisponible>
    And Valido que header prestador listado de las proximas horas disponibles <headerPrestadorProximasHorasDisponible>
    And Valido que se visualice imagen icono orden header prestador listado de las proximas horas disponibles <iconoPrestadorProximasHorasDisponible>
    And Valido que se visualice header proxima hora listado de las proximas horas disponibles <headerProximaHoraProximasHorasDisponible>
    And Valido que header proxima hora listado de las proximas horas disponibles <headerProximaHoraProximasHorasDisponible>
    And Valido que se visualice imagen icono orden header proxima hora listado de las proximas horas disponibles <iconoProximaHoraProximasHorasDisponible>
    And Valido que se visualice header copago listado de las proximas horas disponibles <headerCopagoProximasHorasDisponible>
    And Valido que header copago listado de las proximas horas disponibles <headerCopagoProximasHorasDisponible>
    And Valido que se visualice imagen icono orden header copago listado de las proximas horas disponibles <iconoCopagoProximasHorasDisponible>
    And Valido que se visualice header profesional listado de las proximas horas disponibles <headerProfesionalProximasHorasDisponible>
    And Valido que header profesional listado de las proximas horas disponibles <headerProfesionalProximasHorasDisponible>
    And Valido que se visualice imagen icono orden header profesional listado de las proximas horas disponibles <iconoProfesionalProximasHorasDisponible>
    And Valido que aparezca centros medicos de una prestacion
    And Valido que aparezca listado de horas de una prestacion <listadoHoraDePrestacion>
    And Valido que se visualice boton mas opciones
    And Valido que boton mas opciones se encuentre habilitado
    And Realizar click boton mas opciones <masOpciones>
    And Valido que se visualice en listado de mas opciones agendar hora <masOpcionesAgendarHora>
    And Valido que primera opcion agendar hora sea correcto <masOpcionesAgendarHora>
    And Valido que se visualice en listado de mas opciones mas horas <masOpcionesMasHoras>
    And Valido que segunda opcion mas horas sea correcto <masOpcionesMasHoras>

    Examples: 
      | pestañaAperturaPrestacionProximasHorasDisponible | linkLeerIndicacionesProximasHorasDisponible | detallePrestacionListadoProximasHorasDisponible | headerPrestadorProximasHorasDisponible | iconoPrestadorProximasHorasDisponible | headerProximaHoraProximasHorasDisponible | iconoProximaHoraProximasHorasDisponible | headerCopagoProximasHorasDisponible | iconoCopagoProximasHorasDisponible | headerProfesionalProximasHorasDisponible | iconoProfesionalProximasHorasDisponible | listadoHoraDePrestacion | masOpciones | masOpcionesAgendarHora | masOpcionesMasHoras |
      | "2"                                              | "7"                                         | "8"                                             | "0"                                    | "3"                                   | "1"                                      | "4"                                     | "2"                                 | "5"                                | "3"                                      | "6"                                     | "0"                     | "0"         | "0"                    | "2"                 |
