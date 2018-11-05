#Author: Yordan Avila - yordan@hakalab.com
@AgendamientoNuevaReservaHoraExamen
Feature: Se valida el agendamiento de reserva de hora de una examen a traves de la web
	Validacion del agendamiento de reserva de hora de un examen
	
  Scenario: Seleccion opcion agendar reserva
    Given Visualizo resumen de examen    
    When Hago click en boton agendar    
    Then Valido el despliegue ventana leer indicaciones
    And Valido el titulo leer indicaciones
    And Valido el listado de indicaciones
    And Valido que aparezca boton he leido las indicaciones
    And Valido que haga click en boton he leido las indicaciones
    And Valido que aparezca ventana emergente reserva exitosa
    And Valido que aparezca titulo de reserva exitosa
    And Valido que aparezca imagen check de reserva exitosa
    And Valido que aparezca parrafo de reserva exitosa
    And Valido que aparezca boton aceptar de reserva exitosa
    And Valido que haga click boton aceptar de reserva exitosa
    And Valido que aparezca pagina de inicio
    And Valido que campo ingreso rut no se encuentre vacio
    And Valido que aparezca apartado de paciente