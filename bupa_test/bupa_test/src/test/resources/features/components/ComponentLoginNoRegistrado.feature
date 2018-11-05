#Author: Yordan Avila - yordan@hakalab.com
@LoginNoRegistradoPaginaWebBCP
Feature: Se valida el intento de ingreso usuario no registrado en la pagina web bcp por login
  Quiero validar el intento de ingreso usuario que no se encuentra registrado

  Scenario Outline: Me encuentro en la pagina web
    When Ingreso usuario del asesor <usuario>
    And Ingreso contraseña del asesor <contraseña>
    Then Valido datos del login mediante el servicio <usuario>
    And Valido que se visualice el boton inicio de sesion
    And Valido que boton inicio de sesion pueda hacer click
    And Dar click en boton iniciar sesion
    And Valido que se visualice el mensaje de error
    And Valido mensaje de error mediante el servicio
    And Valido tipo entregado por el servicio
    And Valido token entregado por el servicio venga vacio

    Examples: 
      | usuario | contraseña  |
      | "TEST"  | ""          |
      | ""      | "password$" |
      | "TEST"  | "password$" |
