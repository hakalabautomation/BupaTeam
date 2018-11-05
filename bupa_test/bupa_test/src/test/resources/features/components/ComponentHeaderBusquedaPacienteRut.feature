@componentHeaderBusquedaPacienteRut
Feature: Se realiza validacion de componentes de la seccion del header en la pantalla de busqueda de paciente por rut
  		Validar componentes seccion header pantalla busqueda por rut
  		
  Scenario: Validar boton menu
    Then Valido que se visualiza boton menu
    And Valido que al dar click en boton se depliega menu lateral

  Scenario: Validar logo bupa
    Then Valido que el logo de bupa se visualice
    And valido que link de logo este activo

  Scenario: Validar titulo
    Then Valido que el titulo se visualice

  Scenario: Validar imagen y nombre de usuario
    Then Valido que se visualice imagen de usuario
    And Valido nombre de usuario
    And Valido centro medico de usuario

  Scenario: Validar notificaciones
    Then Valido que se visualice icono de notificaciones
    And Valido que al dar click a icono notificaciones se desplieguen las notificaciones del cliente
