#Author: Yordan Avila - yordan@hakalab.com
@CrearDatosPaciente
Feature: Se realiza la creacion de datos paciente cuando este no se encuentre registrado previamente
   Quiero poder registrar datos del paciente cuando no se encuentre en las bases de integramedica

  Scenario Outline: Visualizacion de ventana busqueda paciente por rut
    Given Ingreso un rut de un paciente <rut>
    And Valido que boton buscar se encuentre habilitado
    When Dar click en boton buscar
    Then Visualizo ventana crear datos paciente

    Examples: 
      | rut         |
      | "181864974" |

  Scenario Outline: Llamo servicio token
    Then Valido datos del servicio token <usuario> <contraseña>
    And Valido que servicio token devuelva valor

    Examples: 
      | usuario     | contraseña  |
      | "RGONZALES" | "password$" |

  Scenario Outline: Llamo servicio consulta paciente
    Then Realizo llamada consulta paciente <rutService>
    And Valido rut paciente consultado no exista

    Examples: 
      | rutService   |
      | "18186497-4" |

  Scenario Outline: Validacion boton cerrar
    Given Valido visualizacion boton cerrar ventana
    And Valido que boton x se encuentre habilitado
    When Presiono boton x despliegue ventana emergente
    And Valido que muestre ventana de inicio
    And Valido que campo busqueda paciente por rut no se encuentre vacio
    And Ingreso nuevamente el rut del paciente <rutEmpty>
    And Preciono boton buscar
    And Visualizo la ventanan crear datos paciente

    Examples: 
      | rutEmpty    |
      | "181864974" |

  Scenario: Visualizacion ventana crear datos paciente
    Then Valido que se visualice titulo rut no encontrado crear paciente
    And Valido que titulo rut no encontrado crear paciente sea el correcto
    And Valido que se visualice subtitulo si paciente se encuentra registrado proceda revisar rut
    And Valido que subtitulo si paciente se encuentra registrado proceda revisar rut sea al correcto

  Scenario Outline: Validacion label y campo rut
    Then Valido que se visualice el label rut
    And Valido que el label rut sea el correcto
    And Valido que se visualice campo rut
    And Valido que campo rut muestre el rut correcto <rutSearch>
    And Valido que campo rut contenga el rut del paciente buscado previamente
    And Valido que campo rut se encuentre deshabilitado

    Examples: 
      | rutSearch      |
      | "18.186.497-4" |

  Scenario: Validacion label y campo nombres
    Then Valido que se visualice el label nombres
    And Valido que el label nombres sea el correcto
    And Valido que se visualice campo nombres
    And Valido que campo nombres se encuentre habilitado

  Scenario: Validacion label y campo apellidos
    Then Valido que se visualice el label apellidos
    And Valido que el label apellidos sea el correcto
    And Valido que se visualice campo apellido uno
    And Valido que se visualice campo apellido dos
    And Valido que campo apellido uno se encuentre habilitado
    And Valido que campo apellido dos se encuentre habilitado

  Scenario: Validacion label y campos fecha de nacimiento
    Then Valido que se visualice el label fecha de nacimiento
    And Valido que el label fecha de nacimiento sea el correcto
    And Valido que se visualice campo dia de fecha
    And Valido que campo dia de fecha se encuentre habilitado
    And Valido que se visualice campo mes de fecha
    And Valido que campo mes de fecha se encuentre habilitado
    And Valido que se visualice campo año de fecha
    And Valido que campo año de fecha se encuentre habilitado

  Scenario: Validacion label y campo genero
    Then Valido que se visualice el label genero
    And Valido que el label genero sea el correcto
    And Valido que se visualice campo genero
    And Valido que campo genero se encuentre habilitado
    And Valido que campo genero no se encuentre vacio

  Scenario: Validacion label y campo prevision
    Then Valido que se visualice el label prevision
    And Valido que el label prevision sea el correcto
    And Valido que se visualice campo prevision
    And Valido que campo prevision se encuentre habilitado
    And Valido que campo prevision no se encuentre vacio

  Scenario: Validacion label y campo correo
    Then Valido que se visualice el label correo
    And Valido que el label correo sea el correcto
    And Valido que se visualice campo correo
    And Valido que campo correo se encuentre habilitado

  Scenario: Validacion label y campo telefono
    Then Valido que se visualice el label telefono
    And Valido que el label telefono sea el correcto
    And Valido que se visualice campo telefono
    And Valido que campo telefono se encuentre habilitado

  Scenario: Validacion label y campo nacionalidad
    Then Valido que se visualice el label nacionalidad
    And Valido que el label nacionalidad sea el correcto
    And Valido que se visualice campo nacionalidad
    And Valido que campo nacionalidad se encuentre habilitado
    And Valido que campo nacionalidad no se encuentre vacio

  Scenario: Validacion label y campo direccion
    Then Valido que se visualice el label direccion
    And Valido que el label direccion sea el correcto
    And Valido que se visualice campo direccion
    And Valido que campo direccion se encuentre habilitado

  Scenario: Validacion campo comuna
    Then Valido que se visualice campo comuna
    And Valido que campo comuna se encuentre habilitado

  Scenario: Validacion campo region
    Then Valido que se visualice campo region
    And Valido que campo region se encuentre habilitado
    And Valido que campo region no se encuentre vacio

  Scenario: Validacion de boton guardar
    Then Valido que se visualice boton guardar    

  Scenario: Validacion del servicio genero
    Then Llamada al servicio genero
    And Selecciono todas las opciones de genero
    And Valido que las cantidades de genero coincidan entre lo desplegado en la web y el servicio

  Scenario: Validacion del servicio prevision
    Then Llamada al servicio prevision
    And Selecciono todas las opciones de prevision
    And Valido que las cantidades de prevision coincidan entre lo desplegado en la web y el servicio

  Scenario: Validacion del servicio genero
    Then Llamada al servicio genero
    And Selecciono todas las opciones de genero
    And Valido que las cantidades de genero coincidan entre lo desplegado en la web y el servicio

  Scenario: Validacion del servicio region
    Then Llamada al servicio region
    And Selecciono todas las opciones de region
    And Valido que las cantidades de region coincidan entre lo desplegado en la web y el servicio

  Scenario Outline: Validacion ingreso de datos nuevo paciente
    When Ingreso dato nombres <nombres>
    And Valido que campo nombres no se encuentre vacio
    And Ingreso dato apellido materno <apellidoMaterno>
    And Valido campo apellido matereno no se encuentre vacio
    And Ingreso dato apellido paterno <apellidoPaterno>
    And Valido que campo apellido paterno no se encuentre vacio
    And Ingreso dato dia fecha nacimiento <dia>
    And Valido que campo dia fecha nacimiento no se encuentre vacio
    And Ingreso dato mes fecha nacimiento <mes>
    And Valido que campo mes fecha nacimiento no se encuentre vacio
    And Ingreso dato año fecha nacimiento <año>
    And Valido que campo año fecha nacimiento no se encuentre vacio
    And Seleccion genero <genero>
    And Seleccion prevision <prevision>
    And Ingreso dato correo <correo>
    And Valido que campo correo no se encuentre vacio
    And Ingreso dato telefono <telefono>
    And Valido que campo telefono no se encuentre vacio
    And Seleccion nacionalidad <nacionalidad>
    And Ingreso dato direccion <direccion>
    And Valido que campo dirfeccion no se encuentre vacio
    And Ingreso dato comuna <comuna>
    And Valido que campo comuna no se encuentre vacio
    And Seleccion region <region>
    Then Valido que boton guardar se encuentre habilitado
    And Precionar boton guardar

    Examples: 
      | nombres         | apellidoMaterno | apellidoPaterno | dia  | mes  | año    | genero | prevision | correo                     | telefono    | nacionalidad | direccion        | comuna       | region |
      | "Jordan Andres" | "Aviiila"       | "Mirandaaa"     | "03" | "06" | "1994" | "0"    | "0"       | "yordan.miranda@gmail.com" | "973772065" | "1"          | "C.Arrayan 4043" | "La Florida" | "1"    |

  Scenario: Validacion despliegue mensaje de exito
    When Valido despliegue ventana
    Then Valido que aparezca titulo de la ventana desplegada
    And Valido que titulo sea el correcto
    And Valido que aparezca imagen de exito
    And Valido que aparezca mensaje de exito
    And Valido que aparezca boton aceptar
    And Valido que boton aceptar se encuentre habilitado
    And Presionar boton aceptar

  Scenario Outline: Validacion despliegue ventana de inicio
    Then Valido que aparezca ventana de inicio
    And Valido que campo rut no se encuentre vacio
    And Valido que en campo busqueda rut muestre el rut del paciente <rutSearchSearch>

    Examples: 
      | rutSearchSearch |
      | "18.186.497-4"  |
