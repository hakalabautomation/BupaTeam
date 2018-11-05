#Author: Yordan Avila - yorda@hakalab.com
@BusquedaPacienteRutCorrecto
Feature: Se realiza la busqueda de un paciente ingresando como parametro el rut
  		Validar la busqueda de un paciente con su rut caso correcto

  Scenario Outline: Busqueda paciente por rut correcto
    Given Ingreso a la pagina principal de bcp <url>
    When Presiono boton inicio
    And Ingreso dato rut paciente <rut>
    And Presiono boton consultar
    Then Valido visualizacion de panel paciente encontrado
    And Valido titulo paciente visualizado
    And Valido imagen paciente visualizado
    And Valido imagen de acuerdo a genero
    And Valido nombre paciente visualizado
    And Valido la conexion correcto y devolucion del token <usuario> <contraseña>
    And Valido conexion correcta y devolucion de datos del servicio <rutSearch>
    And Valido nombre paciente del servicio con el visualizado
    And Valido genero paciente visualizado
    And Valido genero paciente del servicio con el visualizado
    And Valido edad paciente visualizado
    And Valido edad paciente del servicio con el visualizado
    And Valido correo electronico visualizado
    And Valido correo electronico del servicio con el visualizado
    And Valido numero telefono visualizado
    And Valido numero telefono del servicio con el visualizado
    And Valido rut visualizado
    And Valido rut del servicio con el visualizado
    And Valido prevision visualizado
    And Valido prevision del servicio con el visualizado
    And Valido que se muestre link editar informacion paciente
    And Valido que link editar informacion paciente sea el correcto
    And Valido boton nueva reserva de hora visualizado

    Examples: 
      | url                                      | rut         | usuario     | contraseña  | rutSearch    |
      | "https://bcp-qa.mybluemix.net/dashboard" | "111111111" | "RGONZALES" | "password$" | "11111111-1" |
