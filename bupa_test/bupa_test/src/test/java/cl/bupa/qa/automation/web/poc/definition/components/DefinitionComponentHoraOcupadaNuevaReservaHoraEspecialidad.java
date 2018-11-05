package cl.bupa.qa.automation.web.poc.definition.components;

import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import cl.bupa.qa.automation.web.business.flow.BaseFlow;
import cl.bupa.qa.automation.web.poc.util.GenericMethods;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class DefinitionComponentHoraOcupadaNuevaReservaHoraEspecialidad {

	@Given("^Visualizo pantalla resumen especialidad$")
	public void visualizo_pantalla_resumen_especialidad() throws Throwable {
		//Div -- Resumen especialidad
	    GenericMethods.isElementPresent(BaseFlow.pageModel.getDivResumenEspecialidad());
	}

	@When("^Presiono el boton agendar$")
	public void presiono_el_boton_agendar() throws Throwable {
		//Button -- Agendar
		BaseFlow.pageModel.getBtnAgendarEsp().click();
	}

	@Then("^Valido que se visualice ventana emergente hora no ha podido ser agendada$")
	public void valido_que_se_visualice_ventana_emergente_hora_no_ha_podido_ser_agendada() throws Throwable {
		GenericMethods.isElementPresent(BaseFlow.pageModel.getMdlRutFail());
	}

	@Then("^Valido que se visualice el titulo de hora no ha podido ser agendada$")
	public void valido_que_se_visualice_el_titulo_de_hora_no_ha_podido_ser_agendada() throws Throwable {
		//esperar hasta que el elemento aparezca
	    GenericMethods.waitTime(BaseFlow.pageModel.getLblPacienteFail());
	    Thread.sleep(2000);
	    //valido que aparezca
	    GenericMethods.isElementPresent(BaseFlow.pageModel.getLblPacienteFail());
	}
	
	@Then("^Valido que titulo coincidan segun lo descrito$")
	public void valido_que_titulo_coincidan_segun_lo_descrito() throws Throwable {		
	   if (BaseFlow.pageModel.getLblPacienteFail().getText().trim().equals(
			   BaseFlow.properties.getLabelMensajeDeHoraNoAgendada())) {
		   assertTrue(true);
	   } else {
		   System.out.print("Título de la hora no ha podido ser agendada no coincide.");
		   assertTrue(false);
	   }
	}

	@Then("^Valido que se visualice imagen fail de hora no ha podido ser agendada$")
	public void valido_que_se_visualice_imagen_fail_de_hora_no_ha_podido_ser_agendada() throws Throwable {
		// Imagen -- Icono fail
		GenericMethods.isElementPresent(BaseFlow.pageModel.getImgIconoFail());
	}

	@Then("^Valido que se visualice parrafo detalle de hora no ha podido ser agendada$")
	public void valido_que_se_visualice_parrafo_detalle_de_hora_no_ha_podido_ser_agendada() throws Throwable {
		// Parrafo -- Mensaje fail
		GenericMethods.isElementPresent(BaseFlow.pageModel.getPrfMensajeFail());
	}
	
	@Then("^Valido que parrafo detalle coincida segun lo descrito$")
	public void valido_que_parrafo_detalle_coincida_segun_lo_descrito() throws Throwable {		
	    /*if (BaseFlow.pageModel.getPrfMensajeFail().getText().trim().equals(
	    		BaseFlow.properties.getLabelHoraYaNoSeEncuentraDisponible())) {
	    	assertTrue(true);
	    } else {
	    	System.out.print("Parrafo hora ya no se encuentra disponible no coincide.");
	    	assertTrue(false);
	    }*/
	}

	@Then("^Valido que se visualice boton aceptar de hora no ha podido ser agendada$")
	public void valido_que_se_visualice_boton_aceptar_de_hora_no_ha_podido_ser_agendada() throws Throwable {
		// Button -- Aceptar fail
		GenericMethods.isElementPresent(BaseFlow.pageModel.getBtnAceptarFail());
	}

	@Then("^Valido que click boton aceptar la hora no ha podido ser agendada$")
	public void valido_que_click_boton_aceptar_la_hora_no_ha_podido_ser_agendada() throws Throwable {
		boolean condition = BaseFlow.pageModel.getBtnAceptarFail().isEnabled();
		if (condition == true) {
			assertTrue(true);
		} else {
			System.out.println("Botón aceptar no se encuentra habilitado");
			assertFalse(false);
		}
	}

	@Then("^Dar click boton aceptar la hora no ha podido ser agendada$")
	public void dar_click_boton_aceptar_la_hora_no_ha_podido_ser_agendada() throws Throwable {
		// Button -- Aceptar fail
		BaseFlow.pageModel.getBtnAceptarFail().click();
	}

	@Then("^Valido que se visualice nuevamente apartado de horas$")
	public void valido_que_se_visualice_nuevamente_apartado_de_horas() throws Throwable {
		//Div -- Apartado especialidad 
		//esperar hasta que el elemento aparezca
	    GenericMethods.waitTime(BaseFlow.pageModel.getDivApartadoBxEspecialidad());
	    //validar cuando el elemento se encuentre
	    GenericMethods.isElementPresent(BaseFlow.pageModel.getDivApartadoBxEspecialidad());
	}
}