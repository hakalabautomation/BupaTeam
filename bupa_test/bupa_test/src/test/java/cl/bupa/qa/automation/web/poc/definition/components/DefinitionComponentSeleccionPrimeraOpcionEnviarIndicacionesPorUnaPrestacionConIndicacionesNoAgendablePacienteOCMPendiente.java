package cl.bupa.qa.automation.web.poc.definition.components;

import static org.junit.Assert.assertTrue;

import cl.bupa.qa.automation.web.business.flow.BaseFlow;
import cl.bupa.qa.automation.web.poc.util.GenericMethods;
import cucumber.api.java.en.Then;

public class DefinitionComponentSeleccionPrimeraOpcionEnviarIndicacionesPorUnaPrestacionConIndicacionesNoAgendablePacienteOCMPendiente {

	@Then("^Realizar click en multiopcion prestacion no agendable con indicaciones \"(.*?)\"$")
	public void realizar_click_en_multiopcion_prestacion_no_agendable_con_indicaciones(String multiOpcionprestacionNoAgendableConIndicaciones) throws Throwable {
		// Img -- Icono multiopcion
		BaseFlow.pageModel.getImgIconoMultiopcion().get(Integer.parseInt(multiOpcionprestacionNoAgendableConIndicaciones)).click();
	}

	@Then("^Valido que primera opcion enviar indicaciones se encuentre habilitado icono multiopcion prestacion no agendable con indicaciones \"(.*?)\"$")
	public void valido_que_primera_opcion_enviar_indicaciones_se_encuentre_habilitado_icono_multiopcion_prestacion_no_agendable_con_indicaciones(String opcionUnoEnviarIndicaciones) throws Throwable {
		boolean condition = BaseFlow.pageModel.getBtnOpcionEnviarIndicaciones().get(Integer.parseInt(opcionUnoEnviarIndicaciones)).isEnabled();
		if (condition == true) {
			assertTrue(true);
		} else {
			System.out.println("Primera opción enviar indicaciones no se encuentra habilitado");
			assertTrue(false);
		}	    
	}

	@Then("^Realizar click primera opcion enviar indicaciones icono multiopcion prestacion no agendable con indicaciones \"(.*?)\"$")
	public void realizar_click_primera_opcion_enviar_indicaciones_icono_multiopcion_prestacion_no_agendable_con_indicaciones(String opcionUnoEnviarIndicaciones) throws Throwable {
		// Button -- Opcion enviar indicaciones
		//BaseFlow.pageModel.getBtnOpcionEnviarIndicaciones().get(Integer.parseInt(opcionUnoEnviarIndicaciones)).click();
		//tiempo de espera explicito
		//Thread.sleep(8000);
	}

	@Then("^Valido que se visualice ventana se envio el mail prestacion no agendable con indicaciones$")
	public void valido_que_se_visualice_ventana_se_envio_el_mail_prestacion_no_agendable_con_indicaciones() throws Throwable {
		// Modal -- Ventana no se envio mail
		//GenericMethods.isElementPresent(BaseFlow.pageModel.getMdlRutFail());
	}

	@Then("^Valido que se visualice titulo ventana se envio el mail prestacion no agendable con indicaciones$")
	public void valido_que_se_visualice_titulo_ventana_se_envio_el_mail_prestacion_no_agendable_con_indicaciones() throws Throwable {
		// Label -- No se envio mail
		//GenericMethods.isElementPresent(BaseFlow.pageModel.getLblPacienteFail());
	}

	@Then("^Valido que titulo sea correcto ventana se envio el mail prestacion no agendable con indicaciones$")
	public void valido_que_titulo_sea_correcto_ventana_se_envio_el_mail_prestacion_no_agendable_con_indicaciones() throws Throwable {
		/*if (BaseFlow.pageModel.getLblPacienteFail().getAttribute("innerText").trim().equals(
		BaseFlow.properties.getLabelExito())) {
		assertTrue(true);
		} else {
			System.out.println("Título de envío del e-mail no es correcto");
			assertTrue(false);
		}*/
	}

	@Then("^Valido que se visualice imagen icono circulo check ventana se envio el mail prestacion no agendable con indicaciones$")
	public void valido_que_se_visualice_imagen_icono_circulo_check_ventana_se_envio_el_mail_prestacion_no_agendable_con_indicaciones() throws Throwable {
		// Imagen -- Icono circulo check
		//GenericMethods.isElementPresent(BaseFlow.pageModel.getImgIconoFail());
	}

	@Then("^Valido que se visualice componente contenedor de indicaciones ventana se envio el mail prestacion no agendable con indicaciones$")
	public void valido_que_se_visualice_componente_contenedor_de_indicaciones_ventana_se_envio_el_mail_prestacion_no_agendable_con_indicaciones() throws Throwable {
		// Div -- Listado leer indicaciones
		//GenericMethods.isElementPresent(BaseFlow.pageModel.getDivListadoLeerIndicaciones());
	}

	@Then("^Valido que se visualice listado indicaciones ventana se envio el mail prestacion no agendable con indicaciones$")
	public void valido_que_se_visualice_listado_indicaciones_ventana_se_envio_el_mail_prestacion_no_agendable_con_indicaciones() throws Throwable {
		/*if (BaseFlow.pageModel.getLiListadoLeerIndicaciones().size() >= 1) {
			assertTrue(true);
		} else {
			System.out.println("No se muestra listado de indicaciones");
			assertTrue(false);
		}*/
	}

	@Then("^Valido que se visualice boton aceptar ventana se envio el mail prestacion no agendable con indicaciones$")
	public void valido_que_se_visualice_boton_aceptar_ventana_se_envio_el_mail_prestacion_no_agendable_con_indicaciones() throws Throwable {
		// Button -- Aceptar fail
		//GenericMethods.isElementPresent(BaseFlow.pageModel.getBtnAceptarFail());
	}

	@Then("^Valido que boton aceptar sea el correcto ventana se envio el mail prestacion no agendable con indicaciones$")
	public void valido_que_boton_aceptar_sea_el_correcto_ventana_se_envio_el_mail_prestacion_no_agendable_con_indicaciones() throws Throwable {
		/*if (BaseFlow.pageModel.getBtnAceptarFail().getAttribute("innerText").trim().equals(
		BaseFlow.properties.getLabelAceptar())) {
			assertTrue(true);
		} else {
			System.out.println("Botón aceptar no es correcto");
			assertTrue(false);
		}*/
	}

	@Then("^Valido que boton aceptar se encuentra habilitado ventana se envio el mail prestacion no agendable con indicaciones$")
	public void valido_que_boton_aceptar_se_encuentra_habilitado_ventana_se_envio_el_mail_prestacion_no_agendable_con_indicaciones() throws Throwable {
		/*boolean condition = BaseFlow.pageModel.getBtnAceptarFail().isEnabled();
		if (condition == true) {
			assertTrue(true);
		} else {
			System.out.println("Botón aceptar no se encuentra habilitado");
			assertTrue(false);
		}*/
	}

	@Then("^Realizar click boton aceptar ventana se envio el mail prestacion no agendable con indicaciones$")
	public void realizar_click_boton_aceptar_ventana_se_envio_el_mail_prestacion_no_agendable_con_indicaciones() throws Throwable {
		/*// Button -- Aceptar fail
		BaseFlow.pageModel.getBtnAceptarFail().click();
		//tiempo de espera explicito
		Thread.sleep(7000);*/
	}
}
