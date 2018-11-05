#Author: Yordan Avila - yordan@hakalab.com
@AgendamientoNuevaReservaHoraMedico
Feature: Se valida el agendamiento de reserva de hora por medico a traves de la web
	Validacion del agendamiento de reserva de hora por medico

  Scenario: Seleccion opcion agendar reserva
    Given Visualizo resumen de consulta por medico
    When Hago click en boton agender
    Then Valido que se visualice ventana leer indicaciones
    And Valido que se visualice titulo leer indicaciones
    And Valido que titulo leer indicaciones sea correcto
    And Valido que se visualice listado indicaciones
    And Valido que se visualice boton he leido las indicaciones
    And Valido que boton he leido las indicaciones se encuentre habilitado
    And Valido que se visualice boton anular reserva
    And Valido que boton anular reserva se encuentre habilitado
    And Hago click en boton he leido las indicaciones
		And Valido que se visualice ventana emergente reserva exitosa
    And Valido que se visualice titulo de reserva exitosa
    And Valido que titulo reserva exitosa sea correcto
    And Valido que se visualice imagen check de reserva exitosa
    And Valido que se visualice parrafo de reserva exitosa
    And Valido que se visualice boton aceptar de reserva exitosa
    And Valido que boton aceptar de reserva exitosa se encuentre habilitado
    And Hago click en boton aceptar
    And Valido visualizacion pagina de inicio
    And Valido campo ingreso rut no se encuentre vacio
    And Valido que se visualice aparezca apartado de paciente