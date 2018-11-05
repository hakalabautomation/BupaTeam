package cl.bupa.qa.automation.web.poc.definition.components;

import static org.junit.Assert.assertTrue;

import cl.bupa.qa.automation.web.business.flow.BaseFlow;
import cl.bupa.qa.automation.web.poc.util.GenericMethods;
import cucumber.api.java.en.Then;

public class DefinitionComponentSeleccionPrimeraOpcionEnviarIndicacionesPorUnaPrestacionSinIndicacionesNoAgendablePacienteOCMPendiente {

	@Then("^Realizar click en multiopcion prestacion no agendable sin indicaciones \"(.*?)\"$")
	public void realizar_click_en_multiopcion_prestacion_no_agendable_sin_indicaciones(String multiOpcionprestacionNoAgendable) throws Throwable {
		// Img -- Icono multiopcion
		BaseFlow.pageModel.getImgIconoMultiopcion().get(Integer.parseInt(multiOpcionprestacionNoAgendable)).click();
	}
	
	@Then("^Valido que primera opcion enviar indicaciones se encuentre habilitado icono multiopcion prestacion no agendable sin indicaciones \"(.*?)\"$")
	public void valido_que_primera_opcion_enviar_indicaciones_se_encuentre_habilitado_icono_multiopcion_prestacion_no_agendable_sin_indicaciones(String opcionUnoEnviarIndicaciones) throws Throwable {
		boolean condition = BaseFlow.pageModel.getBtnOpcionEnviarIndicaciones().get(Integer.parseInt(opcionUnoEnviarIndicaciones)).isEnabled();
		if (condition == true) {
			assertTrue(true);
		} else {
			System.out.println("Primera opción enviar indicaciones no se encuentra habilitado");
			assertTrue(false);
		}
	}
	
	@Then("^Realizar click primera opcion enviar indicaciones icono multiopcion prestacion no agendable sin indicaciones \"(.*?)\"$")
	public void realizar_click_primera_opcion_enviar_indicaciones_icono_multiopcion_prestacion_no_agendable_sin_indicaciones(String opcionUnoEnviarIndicaciones) throws Throwable {
		// Button -- Opcion enviar indicaciones
		BaseFlow.pageModel.getBtnOpcionEnviarIndicaciones().get(Integer.parseInt(opcionUnoEnviarIndicaciones)).click();
		//tiempo de espera explicito
		Thread.sleep(8000);
	}
	
	@Then("^Valido que se visualice ventana no se envio el mail prestacion no agendable sin indicaciones$")
	public void valido_que_se_visualice_ventana_no_se_envio_el_mail_prestacion_no_agendable_sin_indicaciones() throws Throwable {
		// Modal -- Ventana no se envio mail
		GenericMethods.isElementPresent(BaseFlow.pageModel.getMdlRutFail());
	}
	
	@Then("^Valido que se visualice titulo ventana no se envio el mail prestacion no agendable sin indicaciones$")
	public void valido_que_se_visualice_titulo_ventana_no_se_envio_el_mail_prestacion_no_agendable_sin_indicaciones() throws Throwable {
		// Label -- No se envio mail
		GenericMethods.isElementPresent(BaseFlow.pageModel.getLblPacienteFail());
	}

	@Then("^Valido que titulo sea correcto ventana no se envio el mail prestacion no agendable sin indicaciones$")
	public void valido_que_titulo_sea_correcto_ventana_no_se_envio_el_mail_prestacion_no_agendable_sin_indicaciones() throws Throwable {
	    if (BaseFlow.pageModel.getLblPacienteFail().getAttribute("innerText").trim().equals(
	    		BaseFlow.properties.getLabelNoSeEnvioEmail())) {
	    	assertTrue(true);
	    } else {
	    	System.out.println("Título no se envió el e-mail no es correcto");
	    	assertTrue(false);
	    }
	}
	
	@Then("^Valido que se visualice imagen icono circulo check ventana no se envio el mail prestacion no agendable sin indicaciones$")
	public void valido_que_se_visualice_imagen_icono_circulo_check_ventana_no_se_envio_el_mail_prestacion_no_agendable_sin_indicaciones() throws Throwable {
		// Imagen -- Icono circulo check
		GenericMethods.isElementPresent(BaseFlow.pageModel.getImgIconoFail());
	}
	
	@Then("^Valido que se visualice mensaje prestacion no tiene indicaciones ventana no se envio el mail prestacion no agendable sin indicaciones$")
	public void valido_que_se_visualice_mensaje_prestacion_no_tiene_indicaciones_ventana_no_se_envio_el_mail_prestacion_no_agendable_sin_indicaciones() throws Throwable {
		// Parrafo -- Prestacion no tiene indicaciones
		GenericMethods.isElementPresent(BaseFlow.pageModel.getPrfMensajeFail());
	}
	
	@Then("^Valido que mensaje prestacion no tiene indicaciones sea correcto ventana no se envio el mail prestacion no agendable sin indicaciones$")
	public void valido_que_mensaje_prestacion_no_tiene_indicaciones_sea_correcto_ventana_no_se_envio_el_mail_prestacion_no_agendable_sin_indicaciones() throws Throwable {
	    if (BaseFlow.pageModel.getPrfMensajeFail().getAttribute("innerText").trim().equals(
	    		BaseFlow.properties.getLabelPrestacionNoTieneIndicacionesAsociadas())) {
	    	assertTrue(true);
	    } else {
	    	System.out.println("Mensaje prestación no tiene indicaciones no es correcto");
	    	assertTrue(false);
	    }
	}
	
	@Then("^Valido que se visualice boton aceptar ventana no se envio el mail prestacion no agendable sin indicaciones$")
	public void valido_que_se_visualice_boton_aceptar_ventana_no_se_envio_el_mail_prestacion_no_agendable_sin_indicaciones() throws Throwable {
		// Button -- Aceptar fail
		GenericMethods.isElementPresent(BaseFlow.pageModel.getBtnAceptarFail());
	}
	
	@Then("^Valido que boton aceptar sea el correcto ventana no se envio el mail prestacion no agendable sin indicaciones$")
	public void valido_que_boton_aceptar_sea_el_correcto_ventana_no_se_envio_el_mail_prestacion_no_agendable_sin_indicaciones() throws Throwable {
	    if (BaseFlow.pageModel.getBtnAceptarFail().getAttribute("innerText").trim().equals(
	    		BaseFlow.properties.getLabelAceptar())) {
	    	assertTrue(true);
	    } else {
	    	System.out.println("Botón aceptar no es correcto");
	    	assertTrue(false);
	    }
	}
	
	@Then("^Valido que boton aceptar se encuentra habilitado ventana no se envio el mail prestacion no agendable sin indicaciones$")
	public void valido_que_boton_aceptar_se_encuentra_habilitado_ventana_no_se_envio_el_mail_prestacion_no_agendable_sin_indicaciones() throws Throwable {
		boolean condition = BaseFlow.pageModel.getBtnAceptarFail().isEnabled();
		if (condition == true) {
			assertTrue(true);
		} else {
			System.out.println("Botón aceptar no se encuentra habilitado");
			assertTrue(false);
		}
	}
	
	@Then("^Realizar click boton aceptar ventana no se envio el mail prestacion no agendable sin indicaciones$")
	public void realizar_click_boton_aceptar_ventana_no_se_envio_el_mail_prestacion_no_agendable_sin_indicaciones() throws Throwable {
		// Button -- Aceptar fail
		BaseFlow.pageModel.getBtnAceptarFail().click();
		//tiempo de espera explicito
		Thread.sleep(8000);
	}
}
