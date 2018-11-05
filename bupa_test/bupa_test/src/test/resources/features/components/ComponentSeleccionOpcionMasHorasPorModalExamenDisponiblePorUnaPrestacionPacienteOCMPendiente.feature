#Author: Yordan Avila - yordan-avila@hakalab.com
@ComponentSeleccionMasHorasPorModalExamenDisponiblePorPrestacionPacienteOCMPendiente
Feature: Se valida la seleccion opcion mas horas modal examen disponible sobre una prestacion en un paciente con OCM pendiente
  Quiero poder seleccion opcion mas horas modal examen por prestacion de paciente con OCM pendiente

  Scenario Outline: Seleccion opcion mas horas y validacion modal examen
    Then Selecciono una hora especifica de una prestacion <lbxHorasDisponibles> <listHorasDisponibles>
    And Seleccion opcion mas horas en listado de mas opciones <opcionMasHoras>
    And Valido que se visualice ventana nueva reserva de hora
    And Valido que se visualice tab examenes
    And Valido que tab examenes sea correcto
    And Valido que tab examenes se encuentra habilitado
    And Valido que aparezca boton cerrar ventana nueva reserva abierta
    And Valido que boton cerrar se encuentre habilitado ventana nueva reserva abierta
    And Realizar click boton cerrar nueva reserva abierta
    And Valido que muestre nuevamente ventana OCM pendientes
    And Seleccion nuevamente opcion mas horas en listado de mas opciones <opcionMasHoras>

    Examples: 
      | lbxHorasDisponibles | listHorasDisponibles | opcionMasHoras |
      | "0"                 | "2"                  | "2"            |
