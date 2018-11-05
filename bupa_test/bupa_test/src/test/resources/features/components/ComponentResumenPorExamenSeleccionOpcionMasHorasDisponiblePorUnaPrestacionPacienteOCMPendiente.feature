#Author: Yordan Avila - yordan@hakalab.com
@ResumenPorExamenSeleccionOpcionMasHorasDisponiblePorUnaPrestacionPacienteOCMPendiente
Feature: Se valida seccion resumen en tab examenes seleccionando opcion mas horas por una prestacion paciente OCM pendiente
  Quiero validar seccion resumen en tab examenes opcion mas horas por prestacion en paciente con OCM pendiente

  Scenario: Validacion seccion examen del resumen
  	Given Valido visualizacion seccion resumen examen
    When Valido visualizacion seccion examen
    Then Valido visualizacion imagen icono examen
    And Valido visualizacion nombre del doctor
    And Valido visualizacion prestacion
    And Valido prestacion sea igual a la prestaccion seleccionada anteriormente en filtro prestacion
    And Valido visualizacion centro medico
    And Valido centro medico sea igual a la prestacion seleccionada anteriormente en fitro centro medico

  Scenario: Validacion seccion paciente del resumen
    When Valido visualizacion seccion paciente
    And Valido visualizacion imagen icono del paciente
    And Valido visualizacion nombre del paciente
    And Valido visualizacion correo del paciente
    
  Scenario: Validacion seccion consulta del resumen
    When Valido visualizacion seccion consulta
    And Valido visualizacion imagen icono del calendario
    And Valido visualizacion fecha de consulta
    And Valido fecha consulta sea igual al titulo fecha visualizada en seccion de horas por doctor
    And Valido visualizacion imagen icono del dia
    And Valido visualizacion hora seleccionada
    And Valido visualizacion imagen icono costo
    And Valido visualizacion costo
    And Valido visualizacion boton agendar
    And Valido boton agendar sea correcto
    And Valido boton agendar se encuentre habilitado
    And Presionar boton agendar
    