#Author: Yordan Avila - yordan@hakalab.com
@AgendamientoNuevaReservaHoraEspecialidad
Feature: Se valida el agendamiento de reserva hora por especialidad a traves de la web 
  Validacion del agendamiento de reserva hora por especialidad

  Scenario: Seleccion opcino agendar por especialidad
    Given Doy click en boton agendar     
    When Visualizo pantalla de agendamiento exitoso    
    Then Valido que aparezca titulo de la hora fue reservada con exito
    And Valido titulo de la hora fue reservada con exito   
    And Valido que aparezca imagen check  de reserva exitosa
    And Valido que aparezca parrafo de cita ha sido enviada al correo
    And Valido que aparezca el boton aceptar de reserva exitosa
    And Valido que boton aceptar haga click
    And Dar click en boton aceptar
    And Valido que se visualice pagina de inicio
    And Valido que campo de ingreso rut no se encuentre vacio
    And Valido que aparezca apartado paciente 