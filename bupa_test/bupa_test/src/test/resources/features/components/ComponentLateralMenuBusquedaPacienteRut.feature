@componentLateralBusquedaPacienteRut
Feature: Se realiza validacion de componentes de la seccion menu lateral en la pantalla de busqueda de paciente por rut
				Validar componentes seccion menu lateral pantalla busqueda por rut

  Scenario: Validar boton inicio
    Then Valido que se visualiza boton inicio
    And Valido que boton inicio se encuentre habilitado

  Scenario: Validar boton asignados
    Then Valido que se visualiza boton asignados
    And Valido que boton asignados se encuentre habilitado    
    
  Scenario: Validar boton promociones
    Then Valido que se visualiza boton promociones
    And Valido que boton promociones se encuentre habilitado

  Scenario: Validar boton CBClic
    Then Valido que se visualiza boton CBClic
    And Valido que boton CBClic se encuentre habilitado    
    
  Scenario: Validar boton configuracion
    Then Valido que se visualiza boton configuracion
    And Valido que boton configuracion se encuentre habilitado

  Scenario: Validar boton cerrar sesion
    Then Valido que se visualiza boton cerrar sesion
    And Valido que boton cerrar sesion se encuentre habilitado