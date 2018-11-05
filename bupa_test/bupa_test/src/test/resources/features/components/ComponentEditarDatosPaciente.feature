#Author: Yordan Avila - yordan@hakalab.com
@EditarDatosPaciente
Feature: Se realiza la edicion de datos paciente cuando este se encuentre registrado previamente
   Quiero poder editar datos del paciente cuando se encuentre en las bases de integramedica

  Scenario Outline: Visualizacion de ventana busqueda de paciente por rut
    Given Valido que rut ya se visualice en campo <rut>
    And Validar boton buscar se encuentra habilitado
    When click en boton buscar
    Then Visualizo apartado datos paciente
    And Valido que se visualice link editar datos paciente
    And Valido que link editar datos paciente se encuentre habilitado
    And Dar click en link editar datos paciente

    Examples: 
      | rut            |
      | "18.186.497-4" |

  Scenario: Visualizacion ventana de edicion de datos paciente
    Given Valido que se visualice ventana de edicion de datos
    When Valido que se visualice titulo editar datos paciente
    Then Valido que titulo editar datos paciente sea el correcto

  Scenario Outline: Validacion label y campo rut
    Then Valido visualizacion label rut
    And Valido que label rut sea el correcto
    And Valido visualizacion campo rut
    And Valido que campo rut muestre rut correcto <rutSearch>
    And Valido que campo rut contenga rut del paciente buscado previamente
    And Valido que campo rut se encuentre estado deshabilitado

    Examples: 
      | rutSearch      |
      | "18.186.497-4" |

  Scenario: Validacion label y campo nombres
    Then Valido que se visualice label nombres
    And Valido que label nombres sea el correcto
    And Valido que se visualice el campo nombres
    And Valido que campo nombres contenga datos
    And Valido que campo nombres se encuentre estado habilitado

  Scenario: Validacion label y campo apellido materno
    Then Valido que se visualice label apellidos
    And Valido que label apellidos sea el correcto
    And Valido que se visualice campo apellido materno
    And Valido que campo apellido materno contenga datos
    And Valido que campo apellido materno se encuentre habilitado

  Scenario: Validacion campo apellido paterno
    And Valido que se visualice campo apellido paterno
    And Valido que campo apellido paterno contenga datos
    And Valido que campo apellido paterno se encuentre habilitado

  Scenario: Validacion label y campos fecha de nacimiento
    Then Valido que se visualice label fecha de nacimiento
    And Valido que label fecha de nacimiento sea el correcto
    And Valido que se visualice campo dia fecha de nacimiento
    And Valido que campo dia fecha de nacimiento contenga datos
    And Valido que campo dia fecha se encuentre habilitado
    And Valido que se visualice campo mes de fecha de nacimiento
    And Valido que campo mes fecha de nacimiento contenga datos
    And Valido que campo mes fecha de nacimiento se encuentre habilitado
    And Valido que se visualice campo año fecha de nacimiento
    And Valido que campo año fecha de nacimiento contenga datos
    And Valido que campo año de fecha de nacimiento se encuentre habilitado

  Scenario: Validacion label y campo genero
    Then Valido que se visualice label genero
    And Valido que label genero sea el correcto
    And Valido visualizacion campo genero
    And Valido que el campo genero se encuentre habilitado
    And Valido que el campo genero no se encuentre vacio

  Scenario: Validacion label y campo prevision
    Then Valido que se visualice label prevision
    And Valido que label prevision sea el correcto
    And Valido visualizacion campo prevision
    And Valido que el campo prevision se encuentre habilitado
    And Valido que el campo prevision no se encuentre vacio

  Scenario: Validacion label y campo correo
    Then Valido que se visualice label correo
    And Valido que label correo sea el correcto
    And Valido visualizacion campo correo
    And Valido que campo correo cotenga datos
    And Valido que el campo correo se encuentre habilitado

  Scenario: Validacion label y campo telefono
    Then Valido que se visualice label telefono
    And Valido que label telefono sea el correcto
    And Valido visualizacion campo telefono
    And Valido que campo telefono contenga datos
    And Valido que el campo telefono se encuentre habilitado

  Scenario: Validacion label y campo nacionalidad
    Then Valido que se visualice label nacionalidad
    And Valido que label nacionalidad sea el correcto
    And Valido visualizacion campo nacionalidad
    And Valido que el campo nacionalidad se encuentre habilitado
    And Valido que el campo nacionalidad no se encuentre vacio

  Scenario: Validacion label y campo direccion
    Then Valido que se visualice label direccion
    And Valido que label direccion sea el correcto
    And Valido visualizacion campo direccion
    And Valido que campo direccion contenga datos
    And Valido que el campo direccion se encuentre habilitado

  Scenario: Validacion campo comuna
    Then Valido visualizacion campo comuna
    And Valido que campo comuna contenga datos
    And Valido que el campo comuna se encuentre habilitado

  Scenario: Validacion campo region
    Then Valido visualizacion campo region
    And Valido que el campo region se encuentre habilitado
    And Valido que el campo region no se encuentre vacio

  Scenario Outline: Validacion ingreso de datos nuevo paciente
    When Ingreso dato editado nombres <nombres>
    And Ingreso dato editado apellido materno <apellidoMaterno>
    And Ingreso dato editado apellido paterno <apellidoPaterno>
    And Ingreso dato editado dia fecha nacimiento <dia>
    And Ingreso dato editado mes fecha nacimiento <mes>
    And Ingreso dato editado año fecha nacimiento <año>
    And Seleccion dato editado genero <genero>
    And Seleccion dato editado prevision <prevision>
    And Ingreso dato editado correo <correo>
    And Ingreso dato editado telefono <telefono>
    And Seleccion dato editado nacionalidad <nacionalidad>
    And Ingreso dato editado direccion <direccion>
    And Ingreso dato editado comuna <comuna>
    And Seleccion dato editado region <region>

    Examples: 
      | nombres         | apellidoMaterno | apellidoPaterno | dia  | mes  | año    | genero | prevision | correo                           | telefono    | nacionalidad | direccion           | comuna        | region |
      | "Yordan Michel" | "Avila"         | "Miranda"       | "02" | "05" | "1992" | "1"    | "1"       | "yordan.avila.miranda@gmail.com" | "973970256" | "0"          | "Cerro Arrayan 443" | "Puente Alto" | "0"    |

  Scenario: Validacion de boton guardar
    Then Valido visualizacion boton guardar
    And Valido que el boton guardar se encuentre habilitado
    And Dar click en boton guardar

  Scenario: Validacion despliegue mensaje de exito
    When Valido visualizacion ventana edicion de exito
    Then Valido visualizacion titulo de la ventana edicion de exito
    And Valido que el titulo sea correcto
    And Valido visualizacion imagen de edicion de exito
    And Valido visualizacion mensaje de edicion de exito
    And Valido la visualizacion boton aceptar
    And Valido que el boton aceptar se encuentre habilitado
    And Precionar el boton aceptar

  Scenario Outline: Validacion despliegue ventana de inicio
    Then Valido visualizacion ventana de inicio
    And Valido que campo busqueda por rut no este vacio
    And Valido que campo busqueda por rut muestre el rut del paciente editado <rutEdit>

    Examples: 
      | rutEdit        |
      | "18.186.497-4" |
