package cl.bupa.qa.automation.web.poc.definition.components;

import static org.junit.Assert.assertTrue;

import cl.bupa.qa.automation.web.business.flow.BaseFlow;
import cl.bupa.qa.automation.web.poc.util.GenericMethods;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class DefinitionComponentSeleccionOpcionAnularBusquedaPacienteOCMPendientesPestañaLoGestionado {
	
	private String mensajeAnulacion;
	private int masOpciones;
	
	@Given("^Visualizo opcion de anular \"(.*?)\"$")
	public void visualizo_opcion_de_anular(String opcionAnular) throws Throwable {
		// Button -- Seleccion anular prestacion
		GenericMethods.isElementPresent(BaseFlow.pageModel.getBtnSeleccionAnular().get(Integer.parseInt(opcionAnular)));
	}

	@When("^Hago click en opcion anular \"(.*?)\"$")
	public void hago_click_en_opcion_anular(String opcionAnular) throws Throwable {
		// Button -- Seleccion anular prestacion
		BaseFlow.pageModel.getBtnSeleccionAnular().get(Integer.parseInt(opcionAnular)).click();
	}

	@Then("^Valido visualizacion ventana anular reserva de hora$")
	public void valido_visualizacion_ventana_anular_reserva_de_hora() throws Throwable {
		// Modal -- Anular reserva de hora
		GenericMethods.isElementPresent(BaseFlow.pageModel.getMdlRutFail());
	}

	@Then("^Valido visualizacion titulo ventana anular resererva de hora$")
	public void valido_visualizacion_titulo_ventana_anular_resererva_de_hora() throws Throwable {
		// Label -- Anular reserva de hora
		GenericMethods.isElementPresent(BaseFlow.pageModel.getLblPacienteFail());
	}

	@Then("^Valido titulo anular sea correcto ventana reserva de hora$")
	public void valido_titulo_anular_sea_correcto_ventana_reserva_de_hora() throws Throwable {
	    if (BaseFlow.pageModel.getLblPacienteFail().getAttribute("innerText").trim().equals(
	    		BaseFlow.properties.getLabelAnularReservaDeHora())) {
	    	assertTrue(true);
	    } else {
	    	System.out.println("Título anular reserva de hora no es correcto");
	    	assertTrue(false);
	    }
	}

	@Then("^Valido visualizacion imagen alerta ventana anular reserva de hora$")
	public void valido_visualizacion_imagen_alerta_ventana_anular_reserva_de_hora() throws Throwable {
		// Imagen -- Icono atencion reserva de hora
		GenericMethods.isElementPresent(BaseFlow.pageModel.getImgIconoFail());
	}

	@Then("^Valido visualizacion mensaje ventana anular reserva de hora$")
	public void valido_visualizacion_mensaje_ventana_anular_reserva_de_hora() throws Throwable {
		// Parrafo -- Mensaje fail
		GenericMethods.isElementPresent(BaseFlow.pageModel.getPrfMensajeFail());
	}

	@Then("^Valido mensaje sea correcto ventana anular reserva de hora \"(.*?)\" \"(.*?)\" \"(.*?)\"$")
	public void valido_mensaje_sea_correcto_ventana_anular_reserva_de_hora(String prestacionAnular, String horaAnular, String fechaAnular) throws Throwable {
		mensajeAnulacion = "¿Está seguro(a) que desea eliminar " + BaseFlow.pageModel.getLblOcmPrestacionGestionado().get(Integer.parseInt(prestacionAnular)).getAttribute("innerText") + 
				" para las " + BaseFlow.pageModel.getLblOcmHoraGestionado().get(Integer.parseInt(horaAnular)).getAttribute("innerText") + " el " + BaseFlow.pageModel.getLblOcmFechaGestionado().get(Integer.parseInt(fechaAnular)).getAttribute("innerText") + "?";
		
		if (BaseFlow.pageModel.getPrfMensajeFail().getAttribute("innerText").equalsIgnoreCase(
				mensajeAnulacion)) {
			assertTrue(true);
		} else {
			System.out.println("Mensaje de pregunta sobre anulación no es correcto");
			assertTrue(false);
		}
	}

	@Then("^Valido visualizacion boton cancelar ventana anular reserva de hora \"(.*?)\"$")
	public void valido_visualizacion_boton_cancelar_ventana_anular_reserva_de_hora(String botonCancelar) throws Throwable {
		// Button -- Cancelar anular reserva hora
		GenericMethods.isElementPresent(BaseFlow.pageModel.getBtnCancelarAnularReservaHora().get(Integer.parseInt(botonCancelar)));
	}

	@Then("^Valido boton cancelar sea correcto ventana anular reserva de hora \"(.*?)\"$")
	public void valido_boton_cancelar_sea_correcto_ventana_anular_reserva_de_hora(String botonCancelar) throws Throwable {
	    if (BaseFlow.pageModel.getBtnCancelarAnularReservaHora().get(Integer.parseInt(botonCancelar)).getAttribute("innerText").trim().equals(
	    		BaseFlow.properties.getLabelCancelar())) {
	    	assertTrue(true);
	    } else {
	    	System.out.println("Botón cancelar no es correcto");
	    	assertTrue(false);
	    }
	}

	@Then("^Valido visualizacion boton anular ventana reserva de hora \"(.*?)\"$")
	public void valido_visualizacion_boton_anular_ventana_reserva_de_hora(String botonAnular) throws Throwable {
		// Button -- Anular reserva hora
		GenericMethods.isElementPresent(BaseFlow.pageModel.getBtnAnularReservaHora().get(Integer.parseInt(botonAnular)));
	}

	@Then("^Valido boton anular sea correcto ventana anular reserva de hora \"(.*?)\"$")
	public void valido_boton_anular_sea_correcto_ventana_anular_reserva_de_hora(String botonAnular) throws Throwable {
	    if (BaseFlow.pageModel.getBtnAnularReservaHora().get(Integer.parseInt(botonAnular)).getAttribute("innerText").trim().equals(
	    		BaseFlow.properties.getLabelAnular())) {
	    	assertTrue(true);
	    } else {
	    	System.out.println("Botón anular no es correcto");
	    }
	}

	@Then("^Valido boton cancelar se encuentre habilitado ventana anular reserva de hora \"(.*?)\"$")
	public void valido_boton_cancelar_se_encuentre_habilitado_ventana_anular_reserva_de_hora(String botonCancelar) throws Throwable {
		boolean condition = BaseFlow.pageModel.getBtnCancelarAnularReservaHora().get(Integer.parseInt(botonCancelar)).isEnabled();
		if (condition == true) {
			assertTrue(true);
		} else {
			System.out.println("Botón cancelar no se encuentra habilitado");
			assertTrue(false);
		}
	}

	@Then("^Hago click en boton cancelar ventana anular reserva de hora \"(.*?)\"$")
	public void hago_click_en_boton_cancelar_ventana_anular_reserva_de_hora(String botonCancelar) throws Throwable {
		// Button -- Cancelar anular reserva hora
		BaseFlow.pageModel.getBtnCancelarAnularReservaHora().get(Integer.parseInt(botonCancelar)).click(); 
	}

	@Then("^Valido que se muestre tabla gestionado$")
	public void valido_que_se_muestre_tabla_gestionado() throws Throwable {
	    //tiempo espera explicito
		Thread.sleep(1000);
		// Table -- Agendado
		GenericMethods.isElementPresent(BaseFlow.pageModel.getTblAgendado());
	}

	@Then("^Valido visualizacion boton mas opciones$")
	public void valido_visualizacion_boton_mas_opciones() throws Throwable {
		masOpciones = BaseFlow.pageModel.getBtnMasOpciones().size();
		if (masOpciones > 0) {
			assertTrue(true);
		} else {
			System.out.println("Tabla ordenes gestionado de prestaciones no contiene botón más opciones");
			assertTrue(false);
		}
	}

	@Then("^Hago click en boton mas opciones tabla ordenes gestionado \"(.*?)\"$")
	public void hago_click_en_boton_mas_opciones_tabla_ordenes_gestionado(String masOpciones) throws Throwable {
		// Button -- Mas opciones
		BaseFlow.pageModel.getBtnMasOpciones().get(Integer.parseInt(masOpciones)).click();
	}

	@Then("^Valido visualizacion opcion anular en mas opciones tabla ordenes gestionado \"(.*?)\"$")
	public void valido_visualizacion_opcion_anular_en_mas_opciones_tabla_ordenes_gestionado(String opcionAnular) throws Throwable {
		// Button -- Seleccion anular prestacion
		GenericMethods.isElementPresent(BaseFlow.pageModel.getBtnSeleccionAnular().get(Integer.parseInt(opcionAnular)));
	}

	@Then("^Hago click en opcion anular em mas opciones tabla ordenes gestionado \"(.*?)\"$")
	public void hago_click_en_opcion_anular_em_mas_opciones_tabla_ordenes_gestionado(String opcionAnular) throws Throwable {
		// Button -- Seleccion anular prestacion
		BaseFlow.pageModel.getBtnSeleccionAnular().get(Integer.parseInt(opcionAnular)).click();
		//tiempo explicito
		Thread.sleep(1000);
	}

	@Then("^Valido boton anular se encuentre habilitado ventana anular reserva de hora \"(.*?)\"$")
	public void valido_boton_anular_se_encuentre_habilitado_ventana_anular_reserva_de_hora(String botonAnular) throws Throwable {
	    boolean condition = BaseFlow.pageModel.getBtnAnularReservaHora().get(Integer.parseInt(botonAnular)).isEnabled();
	    if (condition == true) {
	    	assertTrue(true);
	    } else {
	    	System.out.println("Botón anular no se encuentra habilitado");
	    	assertTrue(false);
	    }
	}

	@Then("^Hago click en boton anular ventana anular reserva de hora \"(.*?)\"$")
	public void hago_click_en_boton_anular_ventana_anular_reserva_de_hora(String botonAnular) throws Throwable {
		// Button -- Anular reserva hora
		BaseFlow.pageModel.getBtnAnularReservaHora().get(Integer.parseInt(botonAnular)).click();
		//tiempo espera explicito
		Thread.sleep(7000);
	}
	
	@Then("^Valido visualizacion vetanana informacion anulacion reserva de hora$")
	public void valido_visualizacion_vetanana_informacion_anulacion_reserva_de_hora() throws Throwable {
		// Modal -- Anular reserva de hora
	    GenericMethods.isElementPresent(BaseFlow.pageModel.getMdlRutFail());
	}

	@Then("^Valido visualizacion titulo anular reserva de hora ventana informacion anulacion reserva de hora$")
	public void valido_visualizacion_titulo_anular_reserva_de_hora_ventana_informacion_anulacion_reserva_de_hora() throws Throwable {
		// Label -- Anular reserva de hora
	    GenericMethods.isElementPresent(BaseFlow.pageModel.getLblPacienteFail());
	}

	@Then("^Valido titulo anular reserva de hora sea correcto ventana informacion anulacion reserva de hora$")
	public void valido_titulo_anular_reserva_de_hora_sea_correcto_ventana_informacion_anulacion_reserva_de_hora() throws Throwable {
	    if (BaseFlow.pageModel.getLblPacienteFail().getAttribute("innerText").trim().equals(
	    		BaseFlow.properties.getLabelAnularReservaDeHora())) {
	    	assertTrue(true);
	    } else {
	    	System.out.println("Título anular reserva de hora no es correcto");
	    	assertTrue(false);
	    }
	    
	}

	@Then("^Valido visualizacion imagen anulacion correcta ventana informacion anulacion reserva de hora$")
	public void valido_visualizacion_imagen_anulacion_correcta_ventana_informacion_anulacion_reserva_de_hora() throws Throwable {
		// Imagen -- Imagen anulación 
		GenericMethods.isElementPresent(BaseFlow.pageModel.getImgIconoFail());
	}

	@Then("^Valido mensaje anulacion ventana informacion anulacion reserva de hora$")
	public void valido_mensaje_anulacion_ventana_informacion_anulacion_reserva_de_hora() throws Throwable {
		// Parrafo -- La hora fue anulada
		GenericMethods.isElementPresent(BaseFlow.pageModel.getPrfMensajeFail());
	}

	@Then("^Valido mensaje anulacion sea correcto ventana informacion anulacion reserva de hora$")
	public void valido_mensaje_anulacion_sea_correcto_ventana_informacion_anulacion_reserva_de_hora() throws Throwable {
	    if (BaseFlow.pageModel.getPrfMensajeFail().getAttribute("innerText").trim().equals(
	    		BaseFlow.properties.getLabelMensajeDeAnulacion())) {
	    	assertTrue(true);
	    } else {
	    	System.out.println("Mensaje de anulación no es correcto");
	    	assertTrue(false);
	    }
	}

	@Then("^Valido visualizacion boton aceptar ventana informacion anulacion reserva de hora$")
	public void valido_visualizacion_boton_aceptar_ventana_informacion_anulacion_reserva_de_hora() throws Throwable {
		// Button -- Aceptar fail
		GenericMethods.isElementPresent(BaseFlow.pageModel.getBtnAceptarFail());
	}

	@Then("^Valido boton aceptar sea correcto ventana informacion anulacion reserva de hora$")
	public void valido_boton_aceptar_sea_correcto_ventana_informacion_anulacion_reserva_de_hora() throws Throwable {
	    if (BaseFlow.pageModel.getBtnAceptarFail().getAttribute("innerText").trim().equals(
	    		BaseFlow.properties.getLabelAceptar())) {
	    	assertTrue(true);
	    } else {
	    	System.out.println("Botón aceptar no es correcto");
	    	assertTrue(false);
	    }
	}

	@Then("^Valido boton aceptar se encuentre habilitado ventana informacion anulacion reserva de hora$")
	public void valido_boton_aceptar_se_encuentre_habilitado_ventana_informacion_anulacion_reserva_de_hora() throws Throwable {
	    boolean condition = BaseFlow.pageModel.getBtnAceptarFail().isEnabled();
	    if (condition == true) {
	    	assertTrue(true);
	    } else {
	    	System.out.println("Botón aceptar no se encuentra habilitado");
	    	assertTrue(false);
	    }
	}

	@Then("^Hago click en boton aceptar ventana informacion anulacion reserva de hora$")
	public void hago_click_en_boton_aceptar_ventana_informacion_anulacion_reserva_de_hora() throws Throwable {
		// Button -- Aceptar fail
		BaseFlow.pageModel.getBtnAceptarFail().click();
	}
	
	@Then("^Valido visualizacion nuevamente seccion informacion paciente$")
	public void valido_visualizacion_nuevamente_seccion_informacion_paciente() throws Throwable {
		// Div -- Seccion informacion paciente
	    GenericMethods.isElementPresent(BaseFlow.pageModel.getDivSeccionInformacionPaciente().get(0));
	}

	@Then("^Valido visualizacion nuevamente tab por gestionar$")
	public void valido_visualizacion_nuevamente_tab_por_gestionar() throws Throwable {
		// Tab -- Por gestionar
		GenericMethods.isElementPresent(BaseFlow.pageModel.getTabPorGestionar());
	}

	@Then("^Valido visualizacion nuevamente tab gestionado$")
	public void valido_visualizacion_nuevamente_tab_gestionado() throws Throwable {
		// Tab -- Gestionado
		GenericMethods.isElementPresent(BaseFlow.pageModel.getTabGestionado());
	}
	
	@Then("^Valido visualizacion nuevamente tabla lo agendado$")
	public void valido_visualizacion_nuevamente_tabla_lo_agendado() throws Throwable {
		// Table -- Agendado
		GenericMethods.isElementPresent(BaseFlow.pageModel.getTblAgendado());
	}
}
