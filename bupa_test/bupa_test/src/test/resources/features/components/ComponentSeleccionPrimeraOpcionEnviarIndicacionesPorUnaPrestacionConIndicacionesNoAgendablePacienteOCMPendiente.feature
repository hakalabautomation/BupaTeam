#Author: Yordan Avila - yordan@hakalab.com
@ComponentSeleccionPrimeraOpcionEnviarIndicacionesPorPrestacionConIndicacionesNoAgendablePacienteOCMPendiente
Feature: Se valida la seleccion primera opcion enviar indicaciones sobre una prestacion no agendable que tiene indicaciones en un paciente con OCM pendiente
  Quiero poder seleccionar primera opcion enviar indicaciones por prestacion no agendable con indicaciones paciente con OCM pendiente

  Scenario Outline: Validacion primera opcion enviar indicaciones en multiopcion prestacion no agendable con indicaciones
    Then Realizar click en multiopcion prestacion no agendable con indicaciones <multiOpcionprestacionNoAgendableConIndicaciones>
    And Valido que primera opcion enviar indicaciones se encuentre habilitado icono multiopcion prestacion no agendable con indicaciones <opcionUnoEnviarIndicaciones>
    And Realizar click primera opcion enviar indicaciones icono multiopcion prestacion no agendable con indicaciones <opcionUnoEnviarIndicaciones>
    And Valido que se visualice ventana se envio el mail prestacion no agendable con indicaciones
    And Valido que se visualice titulo ventana se envio el mail prestacion no agendable con indicaciones
    And Valido que titulo sea correcto ventana se envio el mail prestacion no agendable con indicaciones
    And Valido que se visualice imagen icono circulo check ventana se envio el mail prestacion no agendable con indicaciones
    And Valido que se visualice componente contenedor de indicaciones ventana se envio el mail prestacion no agendable con indicaciones
    And Valido que se visualice listado indicaciones ventana se envio el mail prestacion no agendable con indicaciones
    And Valido que se visualice boton aceptar ventana se envio el mail prestacion no agendable con indicaciones
    And Valido que boton aceptar sea el correcto ventana se envio el mail prestacion no agendable con indicaciones
    And Valido que boton aceptar se encuentra habilitado ventana se envio el mail prestacion no agendable con indicaciones
    And Realizar click boton aceptar ventana se envio el mail prestacion no agendable con indicaciones

    Examples: 
      | multiOpcionprestacionNoAgendableConIndicaciones | opcionUnoEnviarIndicaciones |
      | "1"                                             | "1"                         |
