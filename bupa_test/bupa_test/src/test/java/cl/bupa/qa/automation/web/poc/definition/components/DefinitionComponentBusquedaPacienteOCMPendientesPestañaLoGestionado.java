package cl.bupa.qa.automation.web.poc.definition.components;

import static org.junit.Assert.assertTrue;

import cl.bupa.qa.automation.web.business.flow.BaseFlow;
import cl.bupa.qa.automation.web.poc.util.GenericMethods;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class DefinitionComponentBusquedaPacienteOCMPendientesPestañaLoGestionado {

	private int masOpciones;
	
	@Given("^Valido visualizacion apartado con informacion paciente$")
	public void valido_visualizacion_apartado_con_informacion_paciente() throws Throwable {
		// Div -- Seccion informacion paciente
		GenericMethods.isElementPresent(BaseFlow.pageModel.getDivSeccionInformacionPaciente().get(0));
	}

	@Given("^Valido visualizacion apartado ocm por gestionar$")
	public void valido_visualizacion_apartado_ocm_por_gestionar() throws Throwable {
		// Div -- Seccion box agendamiento
		GenericMethods.isElementPresent(BaseFlow.pageModel.getDivOcmSeccionBoxAgendamiento().get(0));
	}

	@When("^Valido visualizacion tabla ordenes ocm por gestionar$")
	public void valido_visualizacion_tabla_ordenes_ocm_por_gestionar() throws Throwable {
		// Table -- Agendar
		GenericMethods.isElementPresent(BaseFlow.pageModel.getTblAgendar());
	}

	@Then("^Valido visualizacion header orden medica tabla ordenes ocm por gestionar \"(.*?)\"$")
	public void valido_visualizacion_header_orden_medica_tabla_ordenes_ocm_por_gestionar(String headerOrdenMedica) throws Throwable {
		// Table header -- Cabecera orden medica tabla agendar
		GenericMethods.isElementPresent(BaseFlow.pageModel.getTbhCabezaraTablaAgendar().get(Integer.parseInt(headerOrdenMedica)));
	}

	@Then("^Valido visualizacion header fecha tabla ordenes ocm por gestionar \"(.*?)\"$")
	public void valido_visualizacion_header_fecha_tabla_ordenes_ocm_por_gestionar(String headerFecha) throws Throwable {
		// Table header -- Cabecera fecha tabla agendar
		GenericMethods.isElementPresent(BaseFlow.pageModel.getTbhCabezaraTablaAgendar().get(Integer.parseInt(headerFecha)));
	}

	@Then("^Valido visualizacion header profesional tabla ordenes ocm por gestionar \"(.*?)\"$")
	public void valido_visualizacion_header_profesional_tabla_ordenes_ocm_por_gestionar(String headerProfesional) throws Throwable {
		// Table header -- Cabecera medico tabla agendar
		GenericMethods.isElementPresent(BaseFlow.pageModel.getTbhCabezaraTablaAgendar().get(Integer.parseInt(headerProfesional)));
	}

	@Given("^Valido visualizacion pestaña gestionado$")
	public void valido_visualizacion_pestaña_gestionado() throws Throwable {
		// Tab -- Gestionado
		GenericMethods.isElementPresent(BaseFlow.pageModel.getTabGestionado());
	}

	@Given("^Valido que pestaña gestionado sea correcto$")
	public void valido_que_pestaña_gestionado_sea_correcto() throws Throwable {
		if (BaseFlow.pageModel.getTabGestionado().getText().trim().equals(
	    		BaseFlow.properties.getLabelLoGestionado())) {
			assertTrue(true);
		} else {
			System.out.println("Tab gestionado no es correcto");
			assertTrue(false);
		}
	}

	@When("^Valido que pestaña gestionado se encuentre habilitado$")
	public void valido_que_pestaña_gestionado_se_encuentre_habilitado() throws Throwable {
	    boolean condition = BaseFlow.pageModel.getTabGestionado().isEnabled();
		if (condition == true) {
			assertTrue(true);
		} else {
			System.out.println("Tab gestionado no se encuentra disponible");
			assertTrue(false);
		}
	}

	@Then("^Dar click en pestaña gestionado$")
	public void dar_click_en_pestaña_gestionado() throws Throwable {
		// Tab -- Lo gestionado
		BaseFlow.pageModel.getTabGestionado().click();
		//tiempo de espera explicito
		Thread.sleep(5000);
	}

	@Then("^Valido que pestaña gestionado se encuentre seleccionada$")
	public void valido_que_pestaña_gestionado_se_encuentre_seleccionada() throws Throwable {
	    if (BaseFlow.pageModel.getTabGestionado().getAttribute("aria-selected").trim().equals("true")) {
	    	assertTrue(true);
	    } else {
	    	System.out.println("Tab gestionado no se encuentra seleccionado");
			assertTrue(false);
	    }
	}

	@Then("^Valido que se visualice nuevamente seccion informacion paciente$")
	public void valido_que_se_visualice_nuevamente_seccion_informacion_paciente() throws Throwable {
		// Div -- Seccion informacion paciente
		GenericMethods.isElementPresent(BaseFlow.pageModel.getDivSeccionInformacionPaciente().get(0));
	}

	@Then("^Valido que se visualice nuevamente imagen de paciente$")
	public void valido_que_se_visualice_nuevamente_imagen_de_paciente() throws Throwable {
		// Img -- Icono paciente ocm pendiente
		GenericMethods.isElementPresent(BaseFlow.pageModel.getImgIconoPacienteOcmPendiente());
	}

	@Then("^Valido que se visualice nuevamente nombre de paciente$")
	public void valido_que_se_visualice_nuevamente_nombre_de_paciente() throws Throwable {
		// H5 -- Nombre paciente ocm pendiente
		GenericMethods.isElementPresent(BaseFlow.pageModel.gethFiveNombrePacienteOcmPendiente());
	}

	@Then("^Valido que se visualice nuevamente genero y años de paciente$")
	public void valido_que_se_visualice_nuevamente_genero_y_años_de_paciente() throws Throwable {
		// Label -- Genero y fecha nacimiento
		GenericMethods.isElementPresent(BaseFlow.pageModel.getLblGeneroFechaNacimientoOcmPendiente());
	}

	@Then("^Valido que se visualice nuevamente correo de paciente$")
	public void valido_que_se_visualice_nuevamente_correo_de_paciente() throws Throwable {
		// Label -- Correo
		GenericMethods.isElementPresent(BaseFlow.pageModel.getLblCorreoOcmPendiente());
	}

	@Then("^Valido que se visualice nuevamente telefono de paciente$")
	public void valido_que_se_visualice_nuevamente_telefono_de_paciente() throws Throwable {
		// Label -- Telefono
		GenericMethods.isElementPresent(BaseFlow.pageModel.getLblTelefonoOcmPendiente());
	}

	@Then("^Valido que se visualice nuevamente rut de paciente$")
	public void valido_que_se_visualice_nuevamente_rut_de_paciente() throws Throwable {
		// Label -- Rut
		GenericMethods.isElementPresent(BaseFlow.pageModel.getLblRutOcmPendiente());
	}

	@Then("^Valido que se visualice nuevamente prevision de paciente$")
	public void valido_que_se_visualice_nuevamente_prevision_de_paciente() throws Throwable {
		// Label -- Prevision
		GenericMethods.isElementPresent(BaseFlow.pageModel.getLblPrevisionOcmPendiente());
	}

	@Then("^Valido que se visualice nuevamente link editar informacion paciente de paciente \"(.*?)\"$")
	public void valido_que_se_visualice_nuevamente_link_editar_informacion_paciente_de_paciente(String linkEditarDatosPaciente) throws Throwable {
		// Link -- Datos paciente
		GenericMethods.isElementPresent(BaseFlow.pageModel.getLnkDatosPacienteOcmPendiente().get(Integer.parseInt(linkEditarDatosPaciente)));
	}
	
	@Then("^Valido que se visualice nuevamente seccion botonera acciones reservas \"(.*?)\"$")
	public void valido_que_se_visualice_nuevamente_seccion_botonera_acciones_reservas(String seccionBotoneraAccionesReservar) throws Throwable {
		// Div -- Botonora nuevas reservas
		GenericMethods.isElementPresent(BaseFlow.pageModel.getDivBotoneraNuevasReservasOcmPendiente().get(Integer.parseInt(seccionBotoneraAccionesReservar)));
	}

	@Then("^Valido que se visualice nuevamente boton nueva reserva de hora de paciente$")
	public void valido_que_se_visualice_nuevamente_boton_nueva_reserva_de_hora_de_paciente() throws Throwable {
		// Button -- Nueva reserva hora
		GenericMethods.isElementPresent(BaseFlow.pageModel.getBtnNuevaReservaHoraOcmPendiente());
	}
	
	@Then("^Valido que se visualice tabla de ordenes gestionado$")
	public void valido_que_se_visualice_tabla_de_ordenes_gestionado() throws Throwable {
		// Table -- Agendado
		GenericMethods.isElementPresent(BaseFlow.pageModel.getTblAgendado());
	}
	
	@Then("^Valido que se visualice componente de tabla de ordenes gestionado \"(.*?)\"$")
	public void valido_que_se_visualice_componente_de_tabla_de_ordenes_gestionado(String ordenesBody) throws Throwable {
		// Table -- Item listado gestionados
		GenericMethods.isElementPresent(BaseFlow.pageModel.getTbListadoGestionados().get(Integer.parseInt(ordenesBody)));
	}

	@Then("^Valido que se visualice header prestacion tabla ordenes gestionado \"(.*?)\"$")
	public void valido_que_se_visualice_header_prestacion_tabla_ordenes_gestionado(String headerPrestacion) throws Throwable {
		// Table header -- Cabecera tabla gestionado
		GenericMethods.isElementPresent(BaseFlow.pageModel.getTbhCabeceraTablaGestionado().get(Integer.parseInt(headerPrestacion)));
	}

	@Then("^Valido que prestacion medica en tabla ordenes gestionado sea correcto \"(.*?)\"$")
	public void valido_que_prestacion_medica_en_tabla_ordenes_gestionado_sea_correcto(String headerPrestacion) throws Throwable {
	    if (BaseFlow.pageModel.getTbhCabeceraTablaGestionado().get(Integer.parseInt(headerPrestacion)).getAttribute("innerText").trim().equals(
	    		BaseFlow.properties.getLabelPrestacionTwo())) {
	    	assertTrue(true);
	    } else {
	    	System.out.println("Header prestación no es correcto");
	    	assertTrue(false);
	    }
	}

	@Then("^Valido que se visualice imagen icono orden header prestacion tabla ordenes gestionado \"(.*?)\"$")
	public void valido_que_se_visualice_imagen_icono_orden_header_prestacion_tabla_ordenes_gestionado(String iconoPrestacion) throws Throwable {
		// Table header -- Cabecera tabla gestionado icono orden
		GenericMethods.isElementPresent(BaseFlow.pageModel.getTbhCabeceraTablaGestionadoIconoOrden().get(Integer.parseInt(iconoPrestacion)));
	}

	@Then("^Valido que se visualice header prestador tabla ordenes gestionado \"(.*?)\"$")
	public void valido_que_se_visualice_header_prestador_tabla_ordenes_gestionado(String headerPrestador) throws Throwable {
		// Table header -- Cabecera tabla gestionado
		GenericMethods.isElementPresent(BaseFlow.pageModel.getTbhCabeceraTablaGestionado().get(Integer.parseInt(headerPrestador)));
	}

	@Then("^Valido que header prestador en tabla ordenes gestionado sea correcto \"(.*?)\"$")
	public void valido_que_header_prestador_en_tabla_ordenes_gestionado_sea_correcto(String headerPrestador) throws Throwable {
		if (BaseFlow.pageModel.getTbhCabeceraTablaGestionado().get(Integer.parseInt(headerPrestador)).getAttribute("innerText").trim().equals(
	    		BaseFlow.properties.getLabelPrestador())) {
	    	assertTrue(true);
	    } else {
	    	System.out.println("Header prestador no es correcto");
	    	assertTrue(false);
	    }
	}

	@Then("^Valido que se visualice imagen icono orden header prestador tabla ordenes gestionado \"(.*?)\"$")
	public void valido_que_se_visualice_imagen_icono_orden_header_prestador_tabla_ordenes_gestionado(String iconoOrdenPrestador) throws Throwable {
		// Table header -- Cabecera tabla gestionado icono orden
		GenericMethods.isElementPresent(BaseFlow.pageModel.getTbhCabeceraTablaGestionadoIconoOrden().get(Integer.parseInt(iconoOrdenPrestador)));
	}

	@Then("^Valido que se visualice header hora tabla ordenes gestionado \"(.*?)\"$")
	public void valido_que_se_visualice_header_hora_tabla_ordenes_gestionado(String headerHora) throws Throwable {
		// Table header -- Cabecera tabla gestionado
		GenericMethods.isElementPresent(BaseFlow.pageModel.getTbhCabeceraTablaGestionado().get(Integer.parseInt(headerHora)));
	}

	@Then("^Valido que header hora en tabla ordenes gestionado sea correcto \"(.*?)\"$")
	public void valido_que_header_hora_en_tabla_ordenes_gestionado_sea_correcto(String headerHora) throws Throwable {
		if (BaseFlow.pageModel.getTbhCabeceraTablaGestionado().get(Integer.parseInt(headerHora)).getAttribute("innerText").trim().equals(
	    		BaseFlow.properties.getLabelHora())) {
	    	assertTrue(true);
	    } else {
	    	System.out.println("Header hora no es correcto");
	    	assertTrue(false);
	    }
	}

	@Then("^Valido que se visualice imagen icono orden header hora tabla ordenes gestionado \"(.*?)\"$")
	public void valido_que_se_visualice_imagen_icono_orden_header_hora_tabla_ordenes_gestionado(String iconoOrdenHora) throws Throwable {
		// Table header -- Cabecera tabla gestionado icono orden
		GenericMethods.isElementPresent(BaseFlow.pageModel.getTbhCabeceraTablaGestionadoIconoOrden().get(Integer.parseInt(iconoOrdenHora)));
	}

	@Then("^Valido que se visualice header copago tabla ordenes gestionado \"(.*?)\"$")
	public void valido_que_se_visualice_header_copago_tabla_ordenes_gestionado(String headerCopago) throws Throwable {
		// Table header -- Cabecera tabla gestionado
		GenericMethods.isElementPresent(BaseFlow.pageModel.getTbhCabeceraTablaGestionado().get(Integer.parseInt(headerCopago)));
	}

	@Then("^Valido que header copago tabla ordenes gestionado sea correcto \"(.*?)\"$")
	public void valido_que_header_copago_tabla_ordenes_gestionado_sea_correcto(String headerCopago) throws Throwable {
		if (BaseFlow.pageModel.getTbhCabeceraTablaGestionado().get(Integer.parseInt(headerCopago)).getAttribute("innerText").trim().equals(
	    		BaseFlow.properties.getLabelCopago())) {
	    	assertTrue(true);
	    } else {
	    	System.out.println("Header copago no es correcto");
	    	assertTrue(false);
	    }
	}

	@Then("^Valido que se visualice imagen icono orden header copago tabla ordenes gestionado \"(.*?)\"$")
	public void valido_que_se_visualice_imagen_icono_orden_header_copago_tabla_ordenes_gestionado(String iconoOrdenCopago) throws Throwable {
		// Table header -- Cabecera tabla gestionado icono orden
		GenericMethods.isElementPresent(BaseFlow.pageModel.getTbhCabeceraTablaGestionadoIconoOrden().get(Integer.parseInt(iconoOrdenCopago)));
	}

	@Then("^Valido que se visualice header profesional tabla ordenes gestionado \"(.*?)\"$")
	public void valido_que_se_visualice_header_profesional_tabla_ordenes_gestionado(String headerProfesional) throws Throwable {
		// Table header -- Cabecera tabla gestionado
		GenericMethods.isElementPresent(BaseFlow.pageModel.getTbhCabeceraTablaGestionado().get(Integer.parseInt(headerProfesional)));
	}

	@Then("^Valido que header profesional tabla ordenes gestionado sea correcto \"(.*?)\"$")
	public void valido_que_header_profesional_tabla_ordenes_gestionado_sea_correcto(String headerProfesional) throws Throwable {
		if (BaseFlow.pageModel.getTbhCabeceraTablaGestionado().get(Integer.parseInt(headerProfesional)).getAttribute("innerText").trim().equals(
	    		BaseFlow.properties.getLabelProfesional())) {
	    	assertTrue(true);
	    } else {
	    	System.out.println("Header profesional no es correcto");
	    	assertTrue(false);
	    }
	}

	@Then("^Valido que se visualice imagen icono orden header profesional tabla ordenes gestionado \"(.*?)\"$")
	public void valido_que_se_visualice_imagen_icono_orden_header_profesional_tabla_ordenes_gestionado(String iconoOrdenProfesional) throws Throwable {
		// Table header -- Cabecera tabla gestionado icono orden
		GenericMethods.isElementPresent(BaseFlow.pageModel.getTbhCabeceraTablaGestionadoIconoOrden().get(Integer.parseInt(iconoOrdenProfesional)));
	}
	
	@Then("^Valido que se visualice opcion mas opciones tabla ordenes gestionado$")
	public void valido_que_se_visualice_opcion_mas_opciones_tabla_ordenes_gestionado() throws Throwable {
		masOpciones = BaseFlow.pageModel.getBtnMasOpciones().size();
		if (masOpciones > 0) {
			assertTrue(true);
		} else {
			System.out.println("Tabla ordenes gestionado de prestaciones no contiene botón más opciones");
			assertTrue(false);
		}
	}

	@Then("^Dar click en opcion mas opciones tabla ordenes gestionado \"(.*?)\"$")
	public void dar_click_en_opcion_mas_opciones_tabla_ordenes_gestionado(String masOpciones) throws Throwable {
		// Button -- Mas opciones
		BaseFlow.pageModel.getBtnMasOpciones().get(Integer.parseInt(masOpciones)).click();
	}

	@Then("^Valido que se visualice opcion anular en mas opciones tabla ordenes gestionado \"(.*?)\"$")
	public void valido_que_se_visualice_opcion_anular_en_mas_opciones_tabla_ordenes_gestionado(String opcionAnular) throws Throwable {
		// Button -- Seleccion anular prestacion
		GenericMethods.isElementPresent(BaseFlow.pageModel.getBtnSeleccionAnular().get(Integer.parseInt(opcionAnular)));
	}

	@Then("^Valido que opcion anular en mas opciones sea correcto tabla ordenes gestionado \"(.*?)\"$")
	public void valido_que_opcion_anular_en_mas_opciones_sea_correcto_tabla_ordenes_gestionado(String opcionAnular) throws Throwable {
	    if (BaseFlow.pageModel.getBtnSeleccionAnular().get(Integer.parseInt(opcionAnular)).getAttribute("innerText").trim().equals(
	    		BaseFlow.properties.getLabelAnular())) {
	    	assertTrue(true);
	    } else {
	    	System.out.println("Opción anular en más opciones no es correcto");
	    	assertTrue(false);
	    }
	}

	@Then("^Valido que opcion anular en mas opciones se encuentre habilitado tabla ordenes gestionado \"(.*?)\"$")
	public void valido_que_opcion_anular_en_mas_opciones_se_encuentre_habilitado_tabla_ordenes_gestionado(String opcionAnular) throws Throwable {
	    boolean condition = BaseFlow.pageModel.getBtnSeleccionAnular().get(Integer.parseInt(opcionAnular)).isEnabled();
	    if (condition == true) {
	    	assertTrue(true);
	    } else {
	    	System.out.println("Opción anular de más opciones no se encuentra habilitado");
	    	assertTrue(false);
	    }
	}
}
