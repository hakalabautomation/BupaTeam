package cl.bupa.qa.automation.web.poc.definition.components;

import static org.junit.jupiter.api.Assertions.assertTrue;

import cl.bupa.qa.automation.web.business.flow.BaseFlow;
import cl.bupa.qa.automation.web.poc.util.GenericMethods;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class DefinitionComponentAnulacionPorExamenSeleccionOpcionMasHorasDisponiblePorUnaPrestacionPacienteOCMPendiente {

	@Given("^Presiono boton anular reserva de hora$")
	public void presiono_boton_anular_reserva_de_hora() throws Throwable {
		// Button -- Anular reserva
		BaseFlow.pageModel.getBtnAnularReserva().click();
		//tiempo explicito
		Thread.sleep(4000);
	}

	@When("^Valido visualizacion ventana emergente de anular cita$")
	public void valido_visualizacion_ventana_emergente_de_anular_cita() throws Throwable {
		// Modal -- Anular cita
	    GenericMethods.isElementPresent(BaseFlow.pageModel.getMdlRutFail());
	}

	@When("^Valido visualizacion titulo anular cita$")
	public void valido_visualizacion_titulo_anular_cita() throws Throwable {
		// Label -- Titulo anular cita
	    GenericMethods.isElementPresent(BaseFlow.pageModel.getLblPacienteFail());
	}

	@When("^Valido titulo anular cita sea el correcto$")
	public void valido_titulo_anular_cita_sea_el_correcto() throws Throwable {
	    if (BaseFlow.pageModel.getLblPacienteFail().getAttribute("innerText").trim().equals(
	    		BaseFlow.properties.getLabelAnularCita())) {
	    	assertTrue(true);
	    } else {
	    	System.out.println("Título anular cita no es correcto");
	    	assertTrue(false);
	    }
	}

	@When("^Valido visualizacion imagen check sobre anular cita$")
	public void valido_visualizacion_imagen_check_sobre_anular_cita() throws Throwable {
		// Imagen -- Icono check anular cita
		GenericMethods.isElementPresent(BaseFlow.pageModel.getImgIconoFail());
	}

	@When("^Valido visualizacion mensaje anular cita$")
	public void valido_visualizacion_mensaje_anular_cita() throws Throwable {
		// Parrafo -- Mensaje fail
		GenericMethods.isElementPresent(BaseFlow.pageModel.getPrfMensajeFail());
	}
	
	@When("^Valido mensaje anular cita sea correcto$")
	public void valido_mensaje_anular_cita_sea_correcto() throws Throwable {
	    if (BaseFlow.pageModel.getPrfMensajeFail().getAttribute("innerText").trim().equals(
	    		BaseFlow.properties.getLabelMensajeDeAnulacion())) {
	    	assertTrue(true);
	    } else {
	    	System.out.println("mensaje anular cita no es correcto");
	    	assertTrue(false);
	    }
	}

	@When("^Valido visualizacion boton aceptar anular cita$")
	public void valido_visualizacion_boton_aceptar_anular_cita() throws Throwable {
		// Button -- Aceptar fail
		GenericMethods.isElementPresent(BaseFlow.pageModel.getBtnAceptarFail());
	}
	
	@When("^Valido boton aceptar anular cita sea correcto$")
	public void valido_boton_aceptar_anular_cita_sea_correcto() throws Throwable {
	    if (BaseFlow.pageModel.getBtnAceptarFail().getAttribute("innerText").trim().equals(
	    		BaseFlow.properties.getLabelAceptar())) {
	    	assertTrue(true);
	    } else {
	    	System.out.println("Botón aceptar anular cita no es correcto");
	    	assertTrue(false);
	    }
	}

	@When("^Valido boton aceptar anular cita se encuentre habilitado$")
	public void valido_boton_aceptar_anular_cita_se_encuentre_habilitado() throws Throwable {
	    boolean condition = BaseFlow.pageModel.getBtnAceptarFail().isEnabled();
	    if (condition == true) {
	    	assertTrue(true);
	    } else {
	    	System.out.println("Botón aceptar anular cita no se encuentra habilitado");
	    }
	}

	@Then("^Presiono boton aceptar anular cita$")
	public void presiono_boton_aceptar_anular_cita() throws Throwable {
		// Button -- Aceptar fail
		BaseFlow.pageModel.getBtnAceptarFail().click();
	}

	@Then("^Valido visualizacion nuevamente el apartado de horas$")
	public void valido_visualizacion_nuevamente_el_apartado_de_horas() throws Throwable {
		// Div -- Apartado horas
		//espero hasta que elemento sea desplegado
		GenericMethods.waitTime(BaseFlow.pageModel.getDivApartadoHoras());
		//valido que se encuentre presente
	    GenericMethods.isElementPresent(BaseFlow.pageModel.getDivApartadoHoras());
	}

	@Then("^Valido visualizacion nuevamente el listado doctores$")
	public void valido_visualizacion_nuevamente_el_listado_doctores() throws Throwable {
		// List -- Doctores
		if (BaseFlow.pageModel.getListDoctores().size() > 0) {
			assertTrue(true);
		} else {
			System.out.println("No se muestra listado de doctores");
			assertTrue(false);
		}
	}

	@Then("^Valido visualizacion nuevamente el listado carrusel horas$")
	public void valido_visualizacion_nuevamente_el_listado_carrusel_horas() throws Throwable {
		if (BaseFlow.pageModel.getListCarruselHorasDoctores().size() > 0) {
			assertTrue(true);
		} else {
			System.out.println("No se muestra horas listado de doctores");
			assertTrue(false);
		}
	}
}
