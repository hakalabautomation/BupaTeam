#Author: your.email@your.domain.com
@AnulacionPorExamenSeleccionOpcionMasHorasDisponiblePorUnaPrestacionPacienteOCMPendiente
Feature: Se valida la anulacion de una hora en tab examenes seleccionando opcion mas horas por una prestacion paciente OCM pendiente
  Quiero validar anulacion de hora en tab examenes opcion mas horas por prestacion en paciente con OCM pendiente

  Scenario: Validacion de anulacion de hora
    Given Presiono boton anular reserva de hora
    When Valido visualizacion ventana emergente de anular cita
    And Valido visualizacion titulo anular cita 
    And Valido titulo anular cita sea el correcto
    And Valido visualizacion imagen check sobre anular cita
    And Valido visualizacion mensaje anular cita
    And Valido mensaje anular cita sea correcto
    And Valido visualizacion boton aceptar anular cita
    And Valido boton aceptar anular cita sea correcto
    And Valido boton aceptar anular cita se encuentre habilitado
    Then Presiono boton aceptar anular cita
    And Valido visualizacion nuevamente el apartado de horas
    And Valido visualizacion nuevamente el listado doctores
    And Valido visualizacion nuevamente el listado carrusel horas