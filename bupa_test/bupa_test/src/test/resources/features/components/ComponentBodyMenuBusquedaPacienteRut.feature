@componentBodyBusquedaPacienteRut
Feature: Se realiza validacion de componentes de la seccion del body en la pantalla de busqueda de paciente por rut
  		Validar componentes seccion body pantalla busqueda por rut

  Scenario: Validar fecha actual
    Then Valido que se visualice fecha actual
    And Valido que la fecha mostrada sea actual

  Scenario: Validar imagen paciente
    Then Valido que se visualice imagen paciente

  Scenario: Validar campo texto ingresar rut
    Then Valido que se visualice campo texto ingresar rut
    And Valido que campo texto ingresar rut permita nueve digitos como maximo
    And Valido que al ingresar rut mal escrito y perder el foco muestre mensaje de error

  Scenario: Validar boton buscar
    Then Valido que se visualice boton buscar
    And Valido que boton se encuentre deshabilitado