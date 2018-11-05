#Author: Yordan Avila - yordan@hakalab.com
@BusquedaPacienteOCMPendientesPestañaLoGestionado
Feature: Se valida la busqueda paciente con OCM pendientes pestaña lo gestionado
  Quiero poder validar si el paciente tiene con OCM pendientes pestaña lo gestionado

  Scenario Outline: Validacion preliminar pestaña por gestionar
    Given Valido visualizacion apartado con informacion paciente
    And Valido visualizacion apartado ocm por gestionar
    When Valido visualizacion tabla ordenes ocm por gestionar
    Then Valido visualizacion header orden medica tabla ordenes ocm por gestionar <headerOrdenMedica>
    And Valido visualizacion header fecha tabla ordenes ocm por gestionar <headerFecha>
    And Valido visualizacion header profesional tabla ordenes ocm por gestionar <headerProfesional>

    Examples: 
      | headerOrdenMedica | headerFecha | headerProfesional |
      | "0"               | "1"         | "2"               |

  Scenario: Validacion pestaña y componentes apartado tab gestionado
    Given Valido visualizacion pestaña gestionado
    And Valido que pestaña gestionado sea correcto
    When Valido que pestaña gestionado se encuentre habilitado
    Then Dar click en pestaña gestionado
    And Valido que pestaña gestionado se encuentre seleccionada

  Scenario Outline: Validacion visualizacion seccion informacion paciente
    Then Valido que se visualice nuevamente seccion informacion paciente
    And Valido que se visualice nuevamente imagen de paciente
    And Valido que se visualice nuevamente nombre de paciente
    And Valido que se visualice nuevamente genero y años de paciente
    And Valido que se visualice nuevamente correo de paciente
    And Valido que se visualice nuevamente telefono de paciente
    And Valido que se visualice nuevamente rut de paciente
    And Valido que se visualice nuevamente prevision de paciente
    And Valido que se visualice nuevamente link editar informacion paciente de paciente <linkEditarDatosPaciente>

    Examples: 
      | linkEditarDatosPaciente |
      | "0"                     |

  Scenario Outline: Validacion visualizacion seccion botonera acciones reservas
    Then Valido que se visualice nuevamente seccion botonera acciones reservas <seccionBotoneraAccionesReservar>
    And Valido que se visualice nuevamente boton nueva reserva de hora de paciente

    Examples: 
      | seccionBotoneraAccionesReservar |
      | "0"                             |

  Scenario Outline: Validacion componentes elementos tabla ordenes tab lo gestionado
    Then Valido que se visualice tabla de ordenes gestionado
    And Valido que se visualice componente de tabla de ordenes gestionado <ordenesBody>
    And Valido que se visualice header prestacion tabla ordenes gestionado <headerPrestacion>
    And Valido que prestacion medica en tabla ordenes gestionado sea correcto <headerPrestacion>
    And Valido que se visualice imagen icono orden header prestacion tabla ordenes gestionado <iconoPrestacion>
    And Valido que se visualice header prestador tabla ordenes gestionado <headerPrestador>
    And Valido que header prestador en tabla ordenes gestionado sea correcto <headerPrestador>
    And Valido que se visualice imagen icono orden header prestador tabla ordenes gestionado <iconoOrdenPrestador>
    And Valido que se visualice header hora tabla ordenes gestionado <headerHora>
    And Valido que header hora en tabla ordenes gestionado sea correcto <headerHora>
    And Valido que se visualice imagen icono orden header hora tabla ordenes gestionado <iconoOrdenHora>
    And Valido que se visualice header copago tabla ordenes gestionado <headerCopago>
    And Valido que header copago tabla ordenes gestionado sea correcto <headerCopago>
    And Valido que se visualice imagen icono orden header copago tabla ordenes gestionado <iconoOrdenCopago>
    And Valido que se visualice header profesional tabla ordenes gestionado <headerProfesional>
    And Valido que header profesional tabla ordenes gestionado sea correcto <headerProfesional>
    And Valido que se visualice imagen icono orden header profesional tabla ordenes gestionado <iconoOrdenProfesional>

    Examples: 
      | ordenesBody | headerPrestacion | iconoPrestacion | headerPrestador | iconoOrdenPrestador | headerHora | iconoOrdenHora | headerCopago | iconoOrdenCopago | headerProfesional | iconoOrdenProfesional |
      | "0"         | "10"             | "3"             | "11"            | "4"                 | "12"       | "5"            | "13"         | "6"              | "14"              | "7"                   |

  Scenario Outline: Validacion de componente mas opciones y opcion de anulacion
    Then Valido que se visualice opcion mas opciones tabla ordenes gestionado
    And Dar click en opcion mas opciones tabla ordenes gestionado <masOpciones>
    And Valido que se visualice opcion anular en mas opciones tabla ordenes gestionado <opcionAnular>
    And Valido que opcion anular en mas opciones sea correcto tabla ordenes gestionado <opcionAnular>
    And Valido que opcion anular en mas opciones se encuentre habilitado tabla ordenes gestionado <opcionAnular>

    Examples: 
      | masOpciones | opcionAnular |
      | "2"         | "0"          |
