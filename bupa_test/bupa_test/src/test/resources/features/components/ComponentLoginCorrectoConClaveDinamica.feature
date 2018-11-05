#Author: Yordan Avila - yorda@hakalab.com
@LoginCorrectoConClaveDinmicaPaginaWebBCP
Feature: Se valida el ingreso a la pagina web bcp por login
  			Quiero poder ingresar a la pagina web con mi usuario y contraseña mmas la clave dinamica

  Scenario Outline: Ingreso a la pagina web bcp
    Given Ingreso al login de bcp <url>
    And Valido visualizacion imagen logo bupa
    And Valido visualizacion imagen de login
    And Valido visualizacion titulo aplicativo
    And Valido que titulo del aplicativo sea correcto
    And Valido visualizacion de label usuario
    And Valido que label usuario sea correcto
    And Valido visualizacion campo texto usuario
    And Valido visualizacion label contraseña
    And Valido que label contraseña sea correcto
    And Valido visualizacion campo texto contraseña
    And Valido visualizacion label olvide la contraseña
    And Valido label olvide la contraseña contenga un link
    When Ingreso el nombre usuario asesor <usuario>
    And Ingreso la contraseña asesor <contraseña>
    Then Valido datos del login con el servicio <usuario> <contraseña>
    And Valido que el token del servicio devuelva valor
    And Valido visualizacion boton inicio de sesion
    And Valido que el boton inicio sesion tenga habilitado el evento click
    And Presionar boton inicio sesion

    Examples: 
      | url                                  | usuario  | contraseña  |
      | "https://bcp-qa.mybluemix.net/login" | "YAVILA" | "password$" |

  Scenario Outline: Validacion boton volver
    Given Valido visualizacion link volver
    When Valido link volver sea correcto
    Then Valido link volver se encuentre habilitado
    And Presionar link volver
    And Valido que se visualice nuevamente campo usuario
    And Valido que se visualice nuevamente campo contraseña
    And Valido que campo usuario se encuentre limpio
    And Valido que campo contraseña se encuentre limpio
    And Ingreso nuevamente dato nombre usuario asesor <usu>
    And Ingreso nuevamente dato contraseña asesor <pass>
    And Valido visualizacion boton inicio de sesion
    And Valido que el boton inicio sesion tenga habilitado el evento click
    And Presionar boton inicio sesion

    Examples: 
      | usu      | pass        |
      | "YAVILA" | "password$" |

  Scenario Outline: Visualizacion campo de clave dinamica
    Given Valido nueva url que se muestra en el navegador <urlOtp>
    When Tiempo de espera explicito para el ingreso del token de forma manual
    Then Valido visualizacion contenedor formulario clave dinamica
    And Valido visualizacion imagen logo de bupa
    And Valido visualizacion imagen logo de login
    And Valido visualizacion titulo del aplicativo
    And Valido que titulo del aplicativo sea el correcto
    And Valido visualizacion label clave dinamica
    And Valido que label clave dinamica sea correcto
    And Valido visualizacion del campo clave dinamica
    And Valido campo clave dinamica se encuentre habilitado
    And Valido visualizacion boton validar token
    And Valido boton validar token sea correcto
    And Valido boton validar token se encuentre habilitado
    And Presionar boton validar token

    Examples: 
      | urlOtp                             |
      | "https://bcp-qa.mybluemix.net/otp" |
