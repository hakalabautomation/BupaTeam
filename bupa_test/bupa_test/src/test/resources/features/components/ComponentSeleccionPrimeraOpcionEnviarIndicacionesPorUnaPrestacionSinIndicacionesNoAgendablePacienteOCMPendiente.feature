#Author: Yordan Avila - yordan@hakalab.com
@ComponentSeleccionPrimeraOpcionEnviarIndicacionesPorPrestacionSinIndicacionesNoAgendablePacienteOCMPendiente
Feature: Se valida la seleccion primera opcion enviar indicaciones sobre una prestacion no agendable que no tiene indicaciones en un paciente con OCM pendiente
  Quiero poder seleccionar primera opcion enviar indicaciones por prestacion no agendable sin indicaciones paciente con OCM pendiente

  Scenario Outline: Validacion primera opcion enviar indicaciones en multiopcion prestacion no agendable sin indicaciones
    Then Realizar click en multiopcion prestacion no agendable sin indicaciones <multiOpcionprestacionNoAgendable>
    And Valido que primera opcion enviar indicaciones se encuentre habilitado icono multiopcion prestacion no agendable sin indicaciones <opcionUnoEnviarIndicaciones>
    And Realizar click primera opcion enviar indicaciones icono multiopcion prestacion no agendable sin indicaciones <opcionUnoEnviarIndicaciones>
    And Valido que se visualice ventana no se envio el mail prestacion no agendable sin indicaciones 
    And Valido que se visualice titulo ventana no se envio el mail prestacion no agendable sin indicaciones
    And Valido que titulo sea correcto ventana no se envio el mail prestacion no agendable sin indicaciones
    And Valido que se visualice imagen icono circulo check ventana no se envio el mail prestacion no agendable sin indicaciones
    And Valido que se visualice mensaje prestacion no tiene indicaciones ventana no se envio el mail prestacion no agendable sin indicaciones
    And Valido que mensaje prestacion no tiene indicaciones sea correcto ventana no se envio el mail prestacion no agendable sin indicaciones
    And Valido que se visualice boton aceptar ventana no se envio el mail prestacion no agendable sin indicaciones
    And Valido que boton aceptar sea el correcto ventana no se envio el mail prestacion no agendable sin indicaciones
    And Valido que boton aceptar se encuentra habilitado ventana no se envio el mail prestacion no agendable sin indicaciones
    And Realizar click boton aceptar ventana no se envio el mail prestacion no agendable sin indicaciones

    Examples: 
      | multiOpcionprestacionNoAgendable | opcionUnoEnviarIndicaciones |
      | "1"                              | "1"                         |