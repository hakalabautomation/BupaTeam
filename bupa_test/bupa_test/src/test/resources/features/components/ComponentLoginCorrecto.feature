#Author: Yordan Avila - yorda@hakalab.com
@LoginCorrectoPaginaWebBCP
Feature: Se valida el ingreso a la pagina web bcp por login
  			Quiero poder ingresar a la pagina web con mi usuario y contraseña

  Scenario Outline: Ingreso a la pagina web
    Given Ingreso a la pagina login de bcp <url>
    And Valido que aparezca imagen logo bupa
    And Valido que aparezca imagen de login
    And Valido que aparezca titulo aplicativo
    And Valido que aparezca label rut
    And Valido que aparezca campo texto rut
    And Valido que aparezca label contraseña
    And Valido que aparezca campo texto contraseña
    And Valido que aparezca label olvide la contraseña
    And Valido que label olvide la contraseña contenga un link
    When Ingreso nombre usuario asesor <usuario>
    And Ingreso contraseña asesor <contraseña>
    And Valido datos del login con el servicios <usuario> <contraseña>
    And Valido que token del servicio devuelva valor
    And Valido que aparezca boton inicio de sesion
    And Valido que boton inicio sesion tenga habilitado el evento click
    And Dar click boton inicio sesion

    Examples: 
      | url                                  | usuario  | contraseña  |
      | "https://bcp-qa.mybluemix.net/login" | "YAVILA" | "password$" |

  Scenario: Visualizacion pagina de inicio
    Then Iniciar sesion en la pagina web
    And Visualizo pagina principal
    And Valido que nombre del asesor sea el mismo que aparece en pagina principal
