#Author: Yordan Avila - yordan@hakalab.com
@SeleccionOpcionAnularBusquedaPacienteOCMPendientesPestañaLoGestionado
Feature: Se valida la anulacion reserva hora de una prestacion pestaña lo gestionado a traves de la web
  Validacion de la anulacion reserva hora de una prestacion pestaña lo gestionado a traves de la web

  Scenario Outline: Seleccion opcion anular reserva hora de una prestacion
    Given Visualizo opcion de anular <opcionAnular>
    When Hago click en opcion anular <opcionAnular>
    Then Valido visualizacion ventana anular reserva de hora
    And Valido visualizacion titulo ventana anular resererva de hora
    And Valido titulo anular sea correcto ventana reserva de hora
    And Valido visualizacion imagen alerta ventana anular reserva de hora
    And Valido visualizacion mensaje ventana anular reserva de hora
    And Valido mensaje sea correcto ventana anular reserva de hora <prestacionAnular> <horaAnular> <fechaAnular>
    And Valido visualizacion boton cancelar ventana anular reserva de hora <botonCancelar>
    And Valido boton cancelar sea correcto ventana anular reserva de hora <botonCancelar>
    And Valido visualizacion boton anular ventana reserva de hora <botonAnular>
    And Valido boton anular sea correcto ventana anular reserva de hora <botonAnular>

    Examples: 
      | opcionAnular | prestacionAnular | horaAnular | fechaAnular | botonCancelar | botonAnular |
      | "0"          | "2"              | "4"        | "2"         | "0"           | "0"         |

  Scenario Outline: Validacion boton cancelar ventana anular reserva
    Then Valido boton cancelar se encuentre habilitado ventana anular reserva de hora <botonCancelar>
    And Hago click en boton cancelar ventana anular reserva de hora <botonCancelar>

    Examples: 
      | botonCancelar |
      | "0"           |

  Scenario Outline: Validacion componentes tabla gestionado y mas opciones
    Then Valido que se muestre tabla gestionado
    And Valido visualizacion boton mas opciones
    And Hago click en boton mas opciones tabla ordenes gestionado <masOpciones>
    And Valido visualizacion opcion anular en mas opciones tabla ordenes gestionado <opcionAnular>
    And Hago click en opcion anular em mas opciones tabla ordenes gestionado <opcionAnular>

    Examples: 
      | masOpciones | opcionAnular |
      | "2"         | "0"          |

  Scenario Outline: Validacion boton anular  ventana anular reserva
    Then Valido visualizacion ventana anular reserva de hora
    And Valido visualizacion titulo ventana anular resererva de hora
    And Valido titulo anular sea correcto ventana reserva de hora
    And Valido visualizacion imagen alerta ventana anular reserva de hora
    And Valido visualizacion mensaje ventana anular reserva de hora
    And Valido mensaje sea correcto ventana anular reserva de hora <prestacionAnular> <horaAnular> <fechaAnular>
    And Valido visualizacion boton anular ventana reserva de hora <botonAnular>
    And Valido boton anular sea correcto ventana anular reserva de hora <botonAnular>
    And Valido boton anular se encuentre habilitado ventana anular reserva de hora <botonAnular>
    And Hago click en boton anular ventana anular reserva de hora <botonAnular>

    Examples: 
      | prestacionAnular | horaAnular | fechaAnular | botonAnular |
      | "2"              | "4"        | "2"         | "0"         |
 
  Scenario: Validacion componentes ventana informacion a la anulacion reserva de hora
  	Then Valido visualizacion vetanana informacion anulacion reserva de hora
  	And Valido visualizacion titulo anular reserva de hora ventana informacion anulacion reserva de hora
  	And Valido titulo anular reserva de hora sea correcto ventana informacion anulacion reserva de hora
  	And Valido visualizacion imagen anulacion correcta ventana informacion anulacion reserva de hora
  	And Valido mensaje anulacion ventana informacion anulacion reserva de hora
  	And Valido mensaje anulacion sea correcto ventana informacion anulacion reserva de hora
  	And Valido visualizacion boton aceptar ventana informacion anulacion reserva de hora
  	And Valido boton aceptar sea correcto ventana informacion anulacion reserva de hora
  	And Valido boton aceptar se encuentre habilitado ventana informacion anulacion reserva de hora
  	And Hago click en boton aceptar ventana informacion anulacion reserva de hora
  	And Valido visualizacion nuevamente seccion informacion paciente
  	And Valido visualizacion nuevamente tab por gestionar
  	And Valido visualizacion nuevamente tab gestionado 
  	And Valido visualizacion nuevamente tabla lo agendado