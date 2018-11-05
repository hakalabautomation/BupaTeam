#Author: Yordan Avila - yordan@hakalab.com
@AgendamientoNuevaReservaHoraPorExamenEspecialidadRayos
Feature: Se quiere validar el agendamiento nueva reserva de hora especialidad en rayos
  Quiero validar agendamiento nueva reserva de hora especialidad rayos

  Scenario Outline: Agendamiento especialidad rx extremidad superior con prestacion rx ambas escapulas ap
    Given Valido visualizacion boton nueva reserva de hora
    And Valido boton nueva reserva de hora se encuentre habilitado
    When Presiono click en boton nueva reserva de hora
    Then Eligo tab examenes
    And Dar click combobox especialidad
    And Seleccion de la especialidad <seleccionEspecialidad>
    And Valido seleccion de la especialidad <especialidad>
    And Dar click combobox prestacion
    And Seleccion de la prestacion <seleccionPrestacion>
    And Valido seleccion de la prestacion <prestacion>
    And Dar click combobox region
    And Seleccion de la region <seleccionRegion>
    And Valido seleccion de la region <region>
    And Dar click combobox centro medico
    And Seleccion del centro medico <seleccionCentroMedico>
    And Valido seleccion del centro medico <centroMedico>
    And Seleccion de una hora
    And Valido visualizacion boton agendar hora
    And Dar click en boton agendar hora
    And Valido visualizacion de ventana leer indicaciones
    And Valido visualizacion del boton anular reserva ventana leer indicaciones
    And Valido boton de anular reserva se encuentre habilitado ventana leer indicaciones
    And Dar click boton de anular reserva ventana leer indicaciones
    And Valido visualizacion ventana confirmacion anular cita
    And Valido visualizacion boton aceptar ventana confirmacion anular cita
    And Valido boton aceptar se encuentre habilitado ventana confirmacion anular cita
    And Dar click boton aceptar ventana confirmacion anular cita
    And Seleccion de una hora nuevamente
    And Dar click en boton agendar hora nuevamente
    And Dar click en boton he leido las indicaciones nuevamente
    And Valido visualizacion ventana confirmacion hora reservada con exito
    And Valido visualizacion boton aceptar ventana confirmacion hora reservada con exito
    And Valido boton aceptar se encuentre habilitado ventana confirmacion hora reservada con exito
    And Dar click en boton aceptar ventana confirmacion hora reservada con exito
    And Valido visualizacion menu inicial principal

    Examples: 
      | seleccionEspecialidad | especialidad             | seleccionPrestacion | prestacion              | seleccionRegion | region                 | seleccionCentroMedico | centroMedico            |
      | "28"                  | "Rx Extremidad Superior" | "1"                 | "Rx Ambas Escápulas Ap" | "0"             | "Región Metropolitana" | "0"                   | "Integramedica Alameda" |
