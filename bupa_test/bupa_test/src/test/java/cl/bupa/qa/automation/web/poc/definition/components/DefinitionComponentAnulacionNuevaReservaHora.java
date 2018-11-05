package cl.bupa.qa.automation.web.poc.definition.components;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import cl.bupa.qa.automation.web.business.flow.BaseFlow;
import cl.bupa.qa.automation.web.poc.util.GenericMethods;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class DefinitionComponentAnulacionNuevaReservaHora {

	@Given("^Visualizo apartado resumen de examen$")
	public void visualizo_apartado_resumen_de_examen() throws Throwable {
		//Div -- Resumen examenes
		GenericMethods.isElementPresent(BaseFlow.pageModel.getDivResumenExamenes());
	}

	@When("^Hago click boton de agendar$")
	public void hago_click_boton_de_agendar() throws Throwable {
		//Button -- Agendar
	    BaseFlow.pageModel.getBtnAgendarExa().click();
	}

	@Then("^Valido despliegue ventana leer indicaciones$")
	public void valido_despliegue_ventana_leer_indicaciones() throws Throwable {
		//Div -- Leer indicaciones
	    GenericMethods.isElementPresent(BaseFlow.pageModel.getDivLeerIndicaciones());
	}

	@Then("^Valido titulo leer indicaciones$")
	public void valido_titulo_leer_indicaciones() throws Throwable {
		Thread.sleep(4000);
		//H5 -- Leer indicaciones
		//valido que aparezca
		GenericMethods.isElementPresent(BaseFlow.pageModel.gethFiveTituloLeerIndicaciones());
		//comparacion de label					
		assertEquals(BaseFlow.pageModel.gethFiveTituloLeerIndicaciones().getAttribute("innerText").trim(), 
				BaseFlow.properties.getLabelLeerIndicaciones());
	}

	@Then("^Valido listado de indicaciones$")
	public void valido_listado_de_indicaciones() throws Throwable {
		//Div -- Listado leer indicaciones
		GenericMethods.isElementPresent(BaseFlow.pageModel.getDivListadoLeerIndicaciones());
	}

	@Then("^Valido que aparezca boton anular reserva$")
	public void valido_que_aparezca_boton_anular_reserva() throws Throwable {
		//Button -- Anular reserva
		GenericMethods.isElementPresent(BaseFlow.pageModel.getBtnAnularReserva());
	}

	@Then("^Valido que haga click boton anular reserva$")
	public void valido_que_haga_click_boton_anular_reserva() throws Throwable {
	    boolean condition = BaseFlow.pageModel.getBtnAnularReserva().isEnabled();
	    if (condition == true) {
			assertTrue(true);
			//click en boton anular reserva
			BaseFlow.pageModel.getBtnAnularReserva().click();
		} else {
			System.out.println("Botón anular reserva no se encuentra habilitado");
			assertFalse(false);
		}
	    Thread.sleep(3000);
	}

	@Then("^Valido que aparezca ventana emergente anular cita$")
	public void valido_que_aparezca_ventana_emergente_anular_cita() throws Throwable {
		// Modal -- Anular cita
	    GenericMethods.isElementPresent(BaseFlow.pageModel.getMdlRutFail());
	}

	@Then("^Valido que aparezca titulo de anular cita$")
	public void valido_que_aparezca_titulo_de_anular_cita() throws Throwable {
		// Label -- Titulo anular cita
		//valido que se encuentre presente
	    GenericMethods.isElementPresent(BaseFlow.pageModel.getLblPacienteFail());
	    //comparacion de label
	    assertEquals(BaseFlow.pageModel.getLblPacienteFail().getText().trim(), 
	    		BaseFlow.properties.getLabelAnularCita());
	}

	@Then("^Valido que aprezca imagen check de anular cita$")
	public void valido_que_aprezca_imagen_check_de_anular_cita() throws Throwable {
		// Imagen -- Icono check anular cita
		GenericMethods.isElementPresent(BaseFlow.pageModel.getImgIconoFail());
	}

	@Then("^Valido que aparezca parrafo de anular cita$")
	public void valido_que_aparezca_parrafo_de_anular_cita() throws Throwable {
		// Parrafo -- Mensaje fail
		//valido que se encuentre presente
		GenericMethods.isElementPresent(BaseFlow.pageModel.getPrfMensajeFail());
		//comparacion de label
		assertEquals(BaseFlow.pageModel.getPrfMensajeFail().getText().trim(), 
				BaseFlow.properties.getLabelMensajeDeAnulacion());
	}

	@Then("^Valido que aparezca boton aceptar de anular cita$")
	public void valido_que_aparezca_boton_aceptar_de_anular_cita() throws Throwable {
		// Button -- Aceptar fail
		GenericMethods.isElementPresent(BaseFlow.pageModel.getBtnAceptarFail());
	}

	@Then("^Valido que haga click boton aceptar de anular cita$")
	public void valido_que_haga_click_boton_aceptar_de_anular_cita() throws Throwable {
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

	@Then("^Valido que aparezca apartado de horas$")
	public void valido_que_aparezca_apartado_de_horas() throws Throwable {
		//Div -- Div Box med
		//espero hasta que elemento sea desplegado
		GenericMethods.waitTime(BaseFlow.pageModel.getDivConApaBoxMed());
		//valido que se encuentre presente
	    GenericMethods.isElementPresent(BaseFlow.pageModel.getDivConApaBoxMed());
	}
}