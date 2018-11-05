#Author: Yordan Avila - yordan@hakalab.com
@LoginVacioPaginaWebBCP
Feature: Se valida el intento de ingreso usuario vacio a la pagina web bcp por login
  Quiero validar el intento de ingreso con usuario vacio

  Scenario Outline: Ingreso a la pagina web
    Given Ingreso a la pantalla login de bcp <url>
    And Valido que se visualice imagen logo bupa
    And Valido que se visualice imagen de login
    And Valido que se visualice titulo aplicativo
    And Valido que se visualice label rut
    And Valido que se visualice campo texto rut
    And Valido que se visualice label contraseña
    And Valido que se visualice campo texto contraseña
    And Valido que se visualice label olvide la contraseña
    And Valido que label olvide contraseña contenga un link
    When Ingreso de usuario asesor <usuario>
    And Ingreso de contraseña asesor <contraseña>
    Then Valido datos login con el servicio <usuario>
    And Valido que se visualice boton inicio de sesion
    And Valido que boton inicio sesion tenga habilitado evento click
    And Dar click en boton inicio sesion
    And Valido que se visualice mensaje de error
    And Valido mensaje de error con el servicio
    And Valido tipo con el servicio
    And Valido que token venga vacio del servicio

    Examples: 
      | url                                  | usuario | contraseña |
      | "https://bcp-qa.mybluemix.net/login" | ""      | ""         |
