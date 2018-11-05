#Author: Yordan Avila - yordan@hakalab.com
@ComponentVentanaAsignados
Feature: Se valida los componentes de la ventana asignados
  Quiero poder validar los componentes de la ventana asignados

  Scenario: Validacion en ventana principal busqueda paciente
    Given Estoy en la ventana principal de bcp
    And Valido visualizacion contenedor de ingreso rut de busqueda paciente
    When Valido visualizacion imagen busqueda paciente
    And Valido visualizacion titulo pacientes busqueda paciente
    Then Valido visualizacion campo texto ingreso rut busqueda paciente
    And Valido visualizacion boton buscar busqueda paciente

	Scenario: Validacion boton asignados
		Then Valido visualizacion boton asignados
		And Valido boton asignados se encuentre habilitado
		And Dar click en boton asignados
		
	Scenario: Validacion busqueda rut paciente parte superarior ventana asignados 
		Then Valido visualizacion titulo asignados parte superior ventana asignados
		And Valido titulo asignados sea correcto parte superior ventana asignados
		And Valido visualizacion titulo fecha parte superior ventana asignados
		And Valido que titulo fecha sea correcto parte superior ventana asignados
		And Valido visualizacion contenedor busqueda rut paciente parte superior ventana asignados
		And Valido visualizacion imagen busqueda rut paciente parte superior ventana asignados
		And Valido visualizacion titulo busqueda rut paciente parte superior ventana asignados
		And Valido que titulo busqueda rut paciente sea correcto parte superior ventana asignados
		And Valido visualizacion campo texto ingreso rut busqueda rut paciente parte superior ventana asignados
		And Valiodo que campo texto ingreso rut se encuentre habilitado busqueda rut paciente parte superior ventana asignados
		And Valido que campo texto ingreso rut tenga la propiedad placeholder busqueda rut paciente parte superior ventana asignados
		And Valido que propiedad placeholder campo texto ingreso rut busqueda rut paciente sea correcto parte superior ventana asignados
		And Valido visualizacion boton buscar busqueda rut paciente parte superior ventana asignados
		And Valido que boton buscar sea correcto busqueda rut paciente parte superior ventana asignados
		And Valido que boton buscar se encuentre habilitado busqueda rut paciente parte superior ventana asignados

	Scenario: Validacion componente filtro parte superarior ventana asignados
		Then Valido visualizacion contenedor de filtro ventana asignados
		And Valido visualizacion imagen icono de filtro ventana asignados
		And Valido visualizacion boton filtro ventana asignados
		And Valido que boton filtro se encuentre habilitado ventana asignados
		And Dar click en boton filtro ventana asignados
	
	Scenario: Valido componentes ventana filtro seccion estado parte superarior ventana asignados
		Then Valido visualizacion ventana filtro seccion estado parte superior ventana asignados
		And Valido visualizacion titulo estado seccion estado parte superior ventana asignados
		And Valido que titulo estado sea correcto seccion estado parte superior ventana asignados
		And Valido visualizacion filtro casilla check gestionado filtro seccion estado parte superior ventana asignados
		And Valido visualizacion filtro gestionado filtro seccion estado parte superior ventana asignados
		And Valido que filtro gestionado sea correcto filtro seccion estado parte superior ventana asignados
		And Valido visualizacion filtro casilla check pendiente filtro seccion estado parte superior ventana asignados
		And Valido visualizacion filtro pendiente filtro seccion estado parte superior ventana asignados
		And Valido que filtro pendiente sea correcto filtro seccion estado parte superior ventana asignados		
		And Valido visualizacion filtro casilla check no quiere contacto filtro seccion estado parte superior ventana asignados
		And Valido visualizacion filtro no quiere contacto filtro seccion estado parte superior ventana asignados
		And Valido que filtro no quiere contacto sea correcto filtro seccion estado parte superior ventana asignados		
		And Valido visualizacion filtro casilla check llamar en otro momento filtro seccion estado parte superior ventana asignados
		And Valido visualizacion filtro llamar en otro momento filtro seccion estado parte superior ventana asignados
		And Valido que filtro llamar en otro momento sea correcto filtro seccion estado parte superior ventana asignados
		
	Scenario: Valido componentes ventana filtro seccion prevision parte superarior ventana asignados
		Then Valido visualizacion titulo prevision seccion prevision parte superior ventana asignados
		And Valido que titulo prevision sea correcto seccion prevision parte superior ventana asignados
		And Valido visualizacion filtro casilla check cruz blanca filtro seccion prevision parte superior ventana asignados
		And Valido visualizacion filtro cruz blanca filtro seccion prevision parte superior ventana asignados
		And Valido que filtro cruz blanca sea correcto filtro seccion prevision parte superior ventana asignados		
		And Valido visualizacion filtro casilla check colmena filtro seccion prevision parte superior ventana asignados
		And Valido visualizacion filtro colmena filtro seccion prevision parte superior ventana asignados
		And Valido que filtro colmena sea correcto filtro seccion prevision parte superior ventana asignados		
		And Valido visualizacion filtro casilla check fondo nacional de salud filtro seccion prevision parte superior ventana asignados
		And Valido visualizacion filtro fondo nacional de salud filtro seccion prevision parte superior ventana asignados
		And Valido que filtro fondo nacional de salud sea correcto filtro seccion prevision parte superior ventana asignados		
		And Valido visualizacion filtro casilla check fonasa filtro seccion prevision parte superior ventana asignados
		And Valido visualizacion filtro fonasa filtro seccion prevision parte superior ventana asignados
		And Valido que filtro fonasa sea correcto filtro seccion prevision parte superior ventana asignados		
		And Valido visualizacion filtro casilla check banmedica filtro seccion prevision parte superior ventana asignados
		And Valido visualizacion filtro banmedica filtro seccion prevision parte superior ventana asignados
		And Valido que filtro banmedica sea correcto filtro seccion prevision parte superior ventana asignados

	Scenario: Valido componentes ventana filtro seccion centro medico parte superarior ventana asignados
		Then Valido que titulo centro medico sea correcto seccion centro medico parte superior ventana asignados
		And Valido visualizacion titulo centro medico seccion centro medico parte superior ventana asignados

	Scenario: Valido componentes ventana filtro seccion fecha parte superarior ventana asignados
		Then Valido visualizacion titulo fecha seccion fecha parte superior ventana asignados
		And Valido que titulo fecha sea correcto seccion fecha parte superior ventana asignados		
 		And Valido visualizacion subtitulo desde seccion fecha parte superior ventana asignados
 		And Valido que subtitulo desde sea correcto seccion fecha parte superior ventana asignados 		
 		And Valido visualizacion campo dia fecha desde seccion fecha parte superior ventana asignados
 		And Valido que campo dia fecha desde tenga la propiedad placeholder seccion fecha parte superior ventana asignados
		And Valido que propiedad placeholder campo dia fecha desde sea correcto seccion fecha parte superior ventana asignados
 		And Valido que campo dia fecha desde se encuentre habilitado seccion fecha parte superior ventana asignados 		
 		And Valido visualizacion campo mes fecha desde seccion fecha parte superior ventana asignados
 		And Valido que campo mes fecha desde tenga la propiedad placeholder seccion fecha parte superior ventana asignados
		And Valido que propiedad placeholder campo mes fecha desde sea correcto seccion fecha parte superior ventana asignados
 		And Valido que campo mes fecha desde se encuentre habilitado seccion fecha parte superior ventana asignados 		
 		And Valido visualizacion campo año fecha desde seccion fecha parte superior ventana asignados
 		And Valido que campo año fecha desde tenga la propiedad placeholder seccion fecha parte superior ventana asignados
		And Valido que propiedad placeholder campo año fecha desde sea correcto seccion fecha parte superior ventana asignados
 		And Valido que campo año fecha desde se encuentre habilitado seccion fecha parte superior ventana asignados
 		And Valido visualizacion icono calendario fecha desde seccion fecha parte superior ventana asignados
 		And Valido visualizacion subtitulo hasta seccion fecha parte superior ventana asignados
 		And Valido que subtitulo hasta sea correcto seccion fecha parte superior ventana asignados
 		And Valido visualizacion campo dia fecha hasta seccion fecha parte superior ventana asignados
 		And Valido que campo dia fecha hasta tenga la propiedad placeholder seccion fecha parte superior ventana asignados
		And Valido que propiedad placeholder campo dia fecha hasta sea correcto seccion fecha parte superior ventana asignados		
 		And Valido que campo dia fecha hasta se encuentre habilitado seccion fecha parte superior ventana asignados 				
 		And Valido visualizacion campo mes fecha hasta seccion fecha parte superior ventana asignados
 		And Valido que campo mes fecha hasta tenga la propiedad placeholder seccion fecha parte superior ventana asignados
		And Valido que propiedad placeholder campo mes fecha hasta sea correcto seccion fecha parte superior ventana asignados
 		And Valido que campo mes fecha hasta se encuentre habilitado seccion fecha parte superior ventana asignados 		
 		And Valido visualizacion campo año fecha hasta seccion fecha parte superior ventana asignados
 		And Valido que campo año fecha hasta tenga la propiedad placeholder seccion fecha parte superior ventana asignados
		And Valido que propiedad placeholder campo año fecha hasta sea correcto seccion fecha parte superior ventana asignados
 		And Valido que campo año fecha hasta se encuentre habilitado seccion fecha parte superior ventana asignados 		
 		And Valido visualizacion icono calendario fecha hasta seccion fecha parte superior ventana asignados
 		 		
	Scenario: Valido componentes ventana filtro seccion botones parte superarior ventana asignados
		Then Valido visualizacion boton limpiar filtro seccion botones parte superarior ventana asignados
		And Valido que boton limpiar filtro sea correcto seccion botones parte superarior ventana asignados
		And Valido visualizacion boton aplicar seccion botones parte superarior ventana asignados
		And Valido que boton aplicar sea correcto seccion botones parte superarior ventana asignados
		And Valido visualizacion boton cancelar seccion botones parte superarior ventana asignados
		And Valido que boton cancelar sea correcto seccion botones parte superarior ventana asignados
		And Salir de seccion de botones
	
	Scenario: Valido componentes tabla de asignados
		Then Valido visualizacion tabla de asignados
		And Valido visualizacion header estado tabla de asignados
		And Valido que header estado sea correcto tabla de asignados
		And Valido visualizacion header telefono tabla de asignados
		And Valido que header telefono sea correcto tabla de asignados
		And Valido visualizacion header nombre tabla de asignados
		And Valido que header nombre sea correcto tabla de asignados
		And Valido visualizacion header edad tabla de asignados
		And Valido que header edad sea correcto tabla de asignados
		And Valido visualizacion header rut tabla de asignados