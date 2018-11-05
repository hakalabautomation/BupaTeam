package cl.bupa.qa.automation.web.poc.definition.components;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import cl.bupa.qa.automation.web.business.flow.BaseFlow;
import cl.bupa.qa.automation.web.poc.util.GenericMethods;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class DefinitionComponentAgendamientoNuevaReservaHoraEspecialidad {
	
	@Given("^Doy click en boton agendar$")
	public void doy_click_en_boton_agendar() throws Throwable {		
		//Button -- Agendar
		BaseFlow.pageModel.getBtnAgendarEsp().click();
	}

	@When("^Visualizo pantalla de agendamiento exitoso$")
	public void visualizo_pantalla_de_agendamiento_exitoso() throws Throwable {
		//Thread.sleep(4000);
		//espero por el elemento hasta que se encuentre desplegado
		GenericMethods.waitTime(BaseFlow.pageModel.getMdlRutFail());
		//valido si se encuentre desplegado
		GenericMethods.isElementPresent(BaseFlow.pageModel.getMdlRutFail());
	}
	
	@Then("^Valido que aparezca titulo de la hora fue reservada con exito$")
	public void valido_que_aparezca_titulo_de_la_hora_fue_reservada_con_exito() throws Throwable {
	    GenericMethods.isElementPresent(BaseFlow.pageModel.getMdlRutFail());
	}

	@Then("^Valido titulo de la hora fue reservada con exito$")
	public void valido_titulo_de_la_hora_fue_reservada_con_exito() throws Throwable {		
	    if (BaseFlow.pageModel.getLblPacienteFail().getText().trim().equals(
	    		BaseFlow.properties.getLabelMensajeDeReservaExito())) {
	    	assertTrue(true);
	    } else {
	    	System.out.println("Título de la hora fue reservada con éxito no coincide");
	    	assertTrue(false);
	    }
	}

	@Then("^Valido que aparezca imagen check  de reserva exitosa$")
	public void valido_que_aparezca_imagen_check_de_reserva_exitosa() throws Throwable {
		// Imagen -- Icono fail
		GenericMethods.isElementPresent(BaseFlow.pageModel.getImgIconoFail());
	}

	@Then("^Valido que aparezca parrafo de cita ha sido enviada al correo$")
	public void valido_que_aparezca_parrafo_de_cita_ha_sido_enviada_al_correo() throws Throwable {
		// Parrafo -- Mensaje fail
		GenericMethods.isElementPresent(BaseFlow.pageModel.getPrfMensajeFail());
	}

	@Then("^Valido que aparezca el boton aceptar de reserva exitosa$")
	public void valido_que_aparezca_el_boton_aceptar_de_reserva_exitosa() throws Throwable {
		// Button -- Aceptar fail
		GenericMethods.isElementPresent(BaseFlow.pageModel.getBtnAceptarFail());
	}

	@Then("^Valido que boton aceptar haga click$")
	public void valido_que_boton_aceptar_haga_click() throws Throwable {
		boolean condition = BaseFlow.pageModel.getBtnAceptarFail().isEnabled();
	    if (condition == true) {
	    	assertTrue(true);	    		    	
	    } else {
	    	System.out.println("Botón aceptar no se encuentra habilitado");
			assertFalse(false);
	    }
	}

	@Then("^Dar click en boton aceptar$")
	public void dar_click_en_boton_aceptar() throws Throwable {
		// Button -- Aceptar fail
		BaseFlow.pageModel.getBtnAceptarFail().click();
	}

	@Then("^Valido que se visualice pagina de inicio$")
	public void valido_que_se_visualice_pagina_de_inicio() throws Throwable {
		// Div - Menu inicial principal
	    GenericMethods.isElementPresent(BaseFlow.pageModel.getDivMenuInicialPrincipal());
	}

	@Then("^Valido que campo de ingreso rut no se encuentre vacio$")
	public void valido_que_campo_de_ingreso_rut_no_se_encuentre_vacio() throws Throwable {
		// Input Text -- Rut a buscar
		//valido que se encuentre presente
		GenericMethods.isElementPresent(BaseFlow.pageModel.getTxtInputRut());
		//valido que campo texto rut no se encuentre vacio
		String value = BaseFlow.pageModel.getTxtInputRut().getAttribute("value");
		if (value == null || value.equals("")) {
			assertTrue(false);
			System.out.println("Campo ingreso rut no muestra rut y se encuentra vacío");
		} else {
			assertTrue(true);
		}
	}

	@Then("^Valido que aparezca apartado paciente$")
	public void valido_que_aparezca_apartado_paciente() throws Throwable {
		GenericMethods.isElementPresent(BaseFlow.pageModel.getDivPacienteEncontrado());
	}
}
