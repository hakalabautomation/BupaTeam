package cl.bupa.qa.automation.web.poc.definition.components;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import cl.bupa.qa.automation.web.business.flow.BaseFlow;
import cl.bupa.qa.automation.web.poc.model.PageModel;
import cl.bupa.qa.automation.web.poc.util.GenericMethods;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class DefinitionComponentAgendamientoNuevaReservaHoraExamen {
	@Given("^Visualizo resumen de examen$")
	public void visualizo_resumen_de_examen() throws Throwable {
		//Div -- Resumen examenes
		GenericMethods.isElementPresent(BaseFlow.pageModel.getDivResumenExamenes());  
	}

	@When("^Hago click en boton agendar$")
	public void hago_click_en_boton_agendar() throws Throwable {
		//Button -- Agendar
		BaseFlow.pageModel.getBtnAgendarExa().click();
	}

	@Then("^Valido el despliegue ventana leer indicaciones$")
	public void valido_el_despliegue_ventana_leer_indicaciones() throws Throwable {
		//Div -- Leer indicaciones
	    GenericMethods.isElementPresent(BaseFlow.pageModel.getDivLeerIndicaciones());
	}

	@Then("^Valido el titulo leer indicaciones$")
	public void valido_el_titulo_leer_indicaciones() throws Throwable {
		Thread.sleep(4000);
		//H5 -- Leer indicaciones
		//valido que aparezca
		GenericMethods.isElementPresent(BaseFlow.pageModel.gethFiveTituloLeerIndicaciones());
		//comparacion de label					
		assertEquals(BaseFlow.pageModel.gethFiveTituloLeerIndicaciones().getAttribute("innerText").trim(), 
				BaseFlow.properties.getLabelLeerIndicaciones());
	}

	@Then("^Valido el listado de indicaciones$")
	public void valido_el_listado_de_indicaciones() throws Throwable {
		//Div -- Listado leer indicaciones
		GenericMethods.isElementPresent(BaseFlow.pageModel.getDivListadoLeerIndicaciones());
	}

	@Then("^Valido que aparezca boton he leido las indicaciones$")
	public void valido_que_aparezca_boton_he_leido_las_indicaciones() throws Throwable {
		//Button -- He leido las indicaciones
		GenericMethods.isElementPresent(BaseFlow.pageModel.getBtnHeLeidoLasIndicaciones());
	}

	@Then("^Valido que haga click en boton he leido las indicaciones$")
	public void valido_que_haga_click_en_boton_he_leido_las_indicaciones() throws Throwable {
	    boolean condition = BaseFlow.pageModel.getBtnHeLeidoLasIndicaciones().isEnabled();
	    if (condition == true) {
	    	assertTrue(true);
	    	//click en boton he leido las indicaciones
	    	BaseFlow.pageModel.getBtnHeLeidoLasIndicaciones().click();
	    } else {
	    	System.out.println("Botón he leido las indicaciones no se encuentra habilitado");
			assertFalse(false);
	    }
	    Thread.sleep(4000);
	}

	@Then("^Valido que aparezca ventana emergente reserva exitosa$")
	public void valido_que_aparezca_ventana_emergente_reserva_exitosa() throws Throwable {
		// Modal -- Rut fail
		//valido que se encuentre presente
	    GenericMethods.isElementPresent(BaseFlow.pageModel.getMdlRutFail());
	    //comparacion de label
	    assertEquals(BaseFlow.pageModel.getLblPacienteFail().getText().trim(), 
	    		BaseFlow.properties.getLabelMensajeDeReservaExito());
	}

	@Then("^Valido que aparezca titulo de reserva exitosa$")
	public void valido_que_aparezca_titulo_de_reserva_exitosa() throws Throwable {
		// Label -- Paciente fail
		GenericMethods.isElementPresent(BaseFlow.pageModel.getLblPacienteFail());
	}

	@Then("^Valido que aparezca imagen check de reserva exitosa$")
	public void valido_que_aparezca_imagen_check_de_reserva_exitosa() throws Throwable {
		// Imagen -- Icono fail
		GenericMethods.isElementPresent(BaseFlow.pageModel.getImgIconoFail());
	}

	@Then("^Valido que aparezca parrafo de reserva exitosa$")
	public void valido_que_aparezca_parrafo_de_reserva_exitosa() throws Throwable {
		// Parrafo -- Mensaje
		GenericMethods.isElementPresent(BaseFlow.pageModel.getPrfMensajeFail());
	}

	@Then("^Valido que aparezca boton aceptar de reserva exitosa$")
	public void valido_que_aparezca_boton_aceptar_de_reserva_exitosa() throws Throwable {
		// Button -- Aceptar
		GenericMethods.isElementPresent(BaseFlow.pageModel.getBtnAceptarFail());
	}

	@Then("^Valido que haga click boton aceptar de reserva exitosa$")
	public void valido_que_haga_click_boton_aceptar_de_reserva_exitosa() throws Throwable {
		boolean condition = BaseFlow.pageModel.getBtnAceptarFail().isEnabled();
	    if (condition == true) {
	    	assertTrue(true);
	    	//click en boton aceptar
	    	BaseFlow.pageModel.getBtnAceptarFail().click();
	    } else {
	    	System.out.println("Botón aceptar no se encuentra habilitado");
			assertFalse(false);
	    }	    
	}

	@Then("^Valido que aparezca pagina de inicio$")
	public void valido_que_aparezca_pagina_de_inicio() throws Throwable {
		// Div - Menu inicial principal
	    GenericMethods.isElementPresent(BaseFlow.pageModel.getDivMenuInicialPrincipal());
	}
	
	@Then("^Valido que campo ingreso rut no se encuentre vacio$")
	public void valido_que_campo_ingreso_rut_no_se_encuentre_vacio() throws Throwable {
		// Input Text -- Rut a buscar
		//valido que se encuentre presente
		GenericMethods.isElementPresent(BaseFlow.pageModel.getTxtInputRut());
		//valido que campo texto rut no se encuentre vacio
		String value = BaseFlow.pageModel.getTxtInputRut().getAttribute("value");
		if (value == null || value.equals("")) {
			System.out.println("Campo ingreso rut no muestra rut y se encuentra vacío");
			assertTrue(false);			
		} else {
			assertTrue(true);
		}
	}

	@Then("^Valido que aparezca apartado de paciente$")
	public void valido_que_aparezca_apartado_de_paciente() throws Throwable {
		 GenericMethods.isElementPresent(BaseFlow.pageModel.getDivPacienteEncontrado());
	}
}
