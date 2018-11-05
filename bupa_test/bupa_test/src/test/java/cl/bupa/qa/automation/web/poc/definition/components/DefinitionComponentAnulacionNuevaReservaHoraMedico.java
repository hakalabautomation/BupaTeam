package cl.bupa.qa.automation.web.poc.definition.components;

import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import cl.bupa.qa.automation.web.business.flow.BaseFlow;
import cl.bupa.qa.automation.web.poc.util.GenericMethods;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class DefinitionComponentAnulacionNuevaReservaHoraMedico {

	@Given("^Valido visualizacion resumen de consulta medico$")
	public void valido_visualizacion_resumen_de_consulta_medico() throws Throwable {
		//Div -- Resumen examenes
		GenericMethods.isElementPresent(BaseFlow.pageModel.getDivResumenExamenes());
	}

	@When("^Presiono boton agendar$")
	public void presiono_boton_agendar() throws Throwable {
		//Button -- Agendar
	    BaseFlow.pageModel.getBtnAgendarExa().click();
	}

	@Then("^Valido visualizacion ventana leer indicaciones$")
	public void valido_visualizacion_ventana_leer_indicaciones() throws Throwable {
		//tiempo de espera
		Thread.sleep(5000);
		// Div -- Leer indicaciones
		GenericMethods.isElementPresent(BaseFlow.pageModel.getDivLeerIndicaciones());
	}

	@Then("^Valido visualizacion titulo leer indicaciones$")
	public void valido_visualizacion_titulo_leer_indicaciones() throws Throwable {
		// H5 -- Leer indicaciones
		GenericMethods.isElementPresent(BaseFlow.pageModel.gethFiveTituloLeerIndicaciones());	    
	}

	@Then("^Valido visualizacion listado de indicaciones$")
	public void valido_visualizacion_listado_de_indicaciones() throws Throwable {
		//Div -- Listado leer indicaciones
		GenericMethods.isElementPresent(BaseFlow.pageModel.getDivListadoLeerIndicaciones());
	}

	@Then("^Valido visualizacion boton anular reserva$")
	public void valido_visualizacion_boton_anular_reserva() throws Throwable {
		// Button -- Anular reserva
		GenericMethods.isElementPresent(BaseFlow.pageModel.getBtnAnularReserva());
	}

	@Then("^Valido boton anular reserva se encuentre habilitado$")
	public void valido_boton_anular_reserva_se_encuentre_habilitado() throws Throwable {
		boolean condition = BaseFlow.pageModel.getBtnAnularReserva().isEnabled();
		if (condition == true) {
			assertTrue(true);
		} else {
			System.out.println("Botón anular reserva no se encuentra habilitado");
			assertTrue(false);
		}
	}

	@Then("^Presiono boton anular reserva$")
	public void presiono_boton_anular_reserva() throws Throwable {
		BaseFlow.pageModel.getBtnAnularReserva().click();
	}

	@Then("^Valido visualizacion ventana emergente anular cita$")
	public void valido_visualizacion_ventana_emergente_anular_cita() throws Throwable {
		//tiempo de espera
		Thread.sleep(4000);
		//valido que se encuentre presente
	    GenericMethods.isElementPresent(BaseFlow.pageModel.getMdlRutFail());
	}

	@Then("^Valido visualizacion titulo de anular cita$")
	public void valido_visualizacion_titulo_de_anular_cita() throws Throwable {
		// Label -- Paciente fail
		//valido que se encuentre presente
	    GenericMethods.isElementPresent(BaseFlow.pageModel.getLblPacienteFail());
	}
	
	@Then("^Valido que titulo de anular cita sea correcto$")
	public void valido_que_titulo_de_anular_cita_sea_correcto() throws Throwable {
	    if (BaseFlow.pageModel.getLblPacienteFail().getText().trim().equals(
	    		BaseFlow.properties.getLabelAnularCita())) {
	    	assertTrue(true);
	    } else {
	    	System.out.println("Título de anular cita no es correcto");
	    	assertTrue(false);
	    }
	}
	
	@Then("^Valido visualizacion imagen check de anular cita$")
	public void valido_visualizacion_imagen_check_de_anular_cita() throws Throwable {
		// Imagen -- Icono
		GenericMethods.isElementPresent(BaseFlow.pageModel.getImgIconoFail());
	}

	@Then("^Valido visualizacion parrafo de anular cita$")
	public void valido_visualizacion_parrafo_de_anular_cita() throws Throwable {
		// Parrafo -- Mensaje fail
		GenericMethods.isElementPresent(BaseFlow.pageModel.getPrfMensajeFail());
	}
	
	@Then("^Valido que parrafo de anular cita sea el correcto$")
	public void valido_que_parrafo_de_anular_cita_sea_el_correcto() throws Throwable {
	    if (BaseFlow.pageModel.getPrfMensajeFail().getText().trim().equals(
	    		BaseFlow.properties.getLabelMensajeDeAnulacion())) {
	    	assertTrue(true);
	    } else {
	    	System.out.println("Párrafp de anular cita no es correcto");
	    	assertTrue(false);
	    }
	}
	
	@Then("^Valido visualizacion boton aceptar de anular cita$")
	public void valido_visualizacion_boton_aceptar_de_anular_cita() throws Throwable {
		// Button -- Aceptar fail
		GenericMethods.isElementPresent(BaseFlow.pageModel.getBtnAceptarFail());
	}

	@Then("^Valido boton aceptar de anular cita se encuentre habilitado$")
	public void valido_boton_aceptar_de_anular_cita_se_encuentre_habilitado() throws Throwable {
		boolean condition = BaseFlow.pageModel.getBtnAceptarFail().isEnabled();
	    if (condition == true) {
	    	assertTrue(true);
	    } else {
	    	System.out.println("Botón aceptar no se encuentra habilitado");
			assertFalse(false);
	    }
	}

	@Then("^Presiono boton aceptar$")
	public void presiono_boton_aceptar() throws Throwable {
		BaseFlow.pageModel.getBtnAceptarFail().click();
	}

	@Then("^Valido visualizacion apartado de horas$")
	public void valido_visualizacion_apartado_de_horas() throws Throwable {
		//Div -- Div Box med
		//espero hasta que elemento sea desplegado
		GenericMethods.waitTime(BaseFlow.pageModel.getDivConApaBoxMed());
		//valido que se encuentre presente
	    GenericMethods.isElementPresent(BaseFlow.pageModel.getDivConApaBoxMed());
	}
}
