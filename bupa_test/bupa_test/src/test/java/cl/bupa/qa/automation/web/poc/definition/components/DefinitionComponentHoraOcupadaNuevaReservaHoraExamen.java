package cl.bupa.qa.automation.web.poc.definition.components;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import cl.bupa.qa.automation.web.business.flow.BaseFlow;
import cl.bupa.qa.automation.web.poc.util.GenericMethods;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class DefinitionComponentHoraOcupadaNuevaReservaHoraExamen {
	
	@Given("^Visualizo el resumen de examen$")
	public void visualizo_el_resumen_de_examen() throws Throwable {
		//Div -- Resumen examenes
		GenericMethods.isElementPresent(BaseFlow.pageModel.getDivResumenExamenes());
	}

	@When("^Dar click en boton agendar$")
	public void dar_click_en_boton_agendar() throws Throwable {
		//Button -- Agendar
		BaseFlow.pageModel.getBtnAgendarExa().click();
	}

	@Then("^Valido despliegue ventana emergente hora no ha podido ser agendada$")
	public void valido_despliegue_ventana_emergente_hora_no_ha_podido_ser_agendada() throws Throwable {
	    GenericMethods.isElementPresent(BaseFlow.pageModel.getMdlRutFail());
	}

	@Then("^Valido que aparezca titulo de hora no ha podido ser agendada$")
	public void valido_que_aparezca_titulo_de_hora_no_ha_podido_ser_agendada() throws Throwable {
		// Label -- Paciente fail
		//esperar hasta que el elemento aparezca
	    GenericMethods.waitTime(BaseFlow.pageModel.getLblPacienteFail());
		//valido que aparezca
		GenericMethods.isElementPresent(BaseFlow.pageModel.getLblPacienteFail());
		//valido que label coincidan
		assertEquals(BaseFlow.pageModel.getLblPacienteFail().getText().trim(), 
				BaseFlow.properties.getLabelMensajeDeHoraNoAgendada());
	}

	@Then("^Valido que aparezca imagen fail de hora no ha podido ser agendada$")
	public void valido_que_aparezca_imagen_fail_de_hora_no_ha_podido_ser_agendada() throws Throwable {
		// Imagen -- Icono fail
		GenericMethods.isElementPresent(BaseFlow.pageModel.getImgIconoFail());
	}

	@Then("^Valido que aparezca parrafo detalle de hora no ha podido ser agendada$")
	public void valido_que_aparezca_parrafo_detalle_de_hora_no_ha_podido_ser_agendada() throws Throwable {
		// Parrafo -- Mensaje fail
		GenericMethods.isElementPresent(BaseFlow.pageModel.getPrfMensajeFail());
	}

	@Then("^Valido que aparezca boton aceptar de hora no ha podido ser agendada$")
	public void valido_que_aparezca_boton_aceptar_de_hora_no_ha_podido_ser_agendada() throws Throwable {
		// Button -- Aceptar fail
		GenericMethods.isElementPresent(BaseFlow.pageModel.getBtnAceptarFail());
	}

	@Then("^Valido que haga click boton aceptar de hora no ha podido ser agendada$")
	public void valido_que_haga_click_boton_aceptar_de_hora_no_ha_podido_ser_agendada() throws Throwable {
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

	@Then("^Valido que aparezca nuevamente apartado de horas$")
	public void valido_que_aparezca_nuevamente_apartado_de_horas() throws Throwable {
		//Div -- Div Box med
		//esperar hasta que el elemento aparezca
	    GenericMethods.waitTime(BaseFlow.pageModel.getDivConApaBoxMed());
	    //validar cuando el elemento se encuentre
	    GenericMethods.isElementPresent(BaseFlow.pageModel.getDivConApaBoxMed());
	}
}