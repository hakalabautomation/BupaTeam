#Author: Yordan Avila - yavila@hakalab.com
@BusquedaPacienteRutIncorrecto
Feature: Se realiza la busqueda de un paciente ingresando como parametro el rut
  		Validar la busqueda de un paciente con su rut caso incorrecto

  Scenario Outline: Busqueda paciente por rut incorrecto
    Given Ingreso a pagina principal bcp <url>
    When Presiono item menu inicio
    And Ingreso rut paciente <rut>
    And Presiono boton buscar
    Then Valido visualizacion mensaje de error
    And Valido titulo visualizado
    And Valido imagen visualizado
    And Valido mensaje visualizado
    And Valido mensaje del servicio con el visualizado
    And Valido visualizacion boton aceptar
    And Valido que haga click boton aceptar
    And Valido que al presionar aceptar vuelvo a la pagina de inicio

    Examples: 
      | url                                    | rut         |
      | "https://bcp-qa.mybluemix.net/desktop" | "181864974" |
