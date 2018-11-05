package cl.bupa.qa.automation.web.poc.definition.components;

import static org.junit.jupiter.api.Assertions.assertTrue;

import cl.bupa.qa.automation.web.business.flow.BaseFlow;
import cl.bupa.qa.automation.web.poc.util.GenericMethods;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class DefinitionComponentLeerIndicacionesPorExamenSeleccionOpcionMasHorasDisponiblePorUnaPrestacionPacienteOCMPendiente {

	@Given("^Valido visualizacion la ventana leer indicaciones$")
	public void valido_visualizacion_la_ventana_leer_indicaciones() throws Throwable {
		//Div -- Leer indicaciones
	    GenericMethods.isElementPresent(BaseFlow.pageModel.getDivLeerIndicaciones());
	}

	@Given("^Valido visualizacion el titulo leer indicaciones$")
	public void valido_visualizacion_el_titulo_leer_indicaciones() throws Throwable {
		//H5 -- Leer indicaciones
		GenericMethods.isElementPresent(BaseFlow.pageModel.gethFiveTituloLeerIndicaciones());
	}

	@Given("^Valido titulo leer indicaciones sea correcto$")
	public void valido_titulo_leer_indicaciones_sea_correcto() throws Throwable {
	    if (BaseFlow.pageModel.gethFiveTituloLeerIndicaciones().getAttribute("innerText").trim().equals(
	    		BaseFlow.properties.getLabelLeerIndicaciones())) {
	    	assertTrue(true);
	    } else {
	    	System.out.println("Títuño leer indicaciones no se correcto");
	    	assertTrue(false);
	    }
	}

	@When("^Valido visualizacion del listado de indicaciones$")
	public void valido_visualizacion_del_listado_de_indicaciones() throws Throwable {
		//Div -- Listado leer indicaciones
		GenericMethods.isElementPresent(BaseFlow.pageModel.getDivListadoLeerIndicaciones());
	}

	@Then("^Valido visualizacion boton he leido las indicaciones$")
	public void valido_visualizacion_boton_he_leido_las_indicaciones() throws Throwable {
		//Button -- He leido las indicaciones
		GenericMethods.isElementPresent(BaseFlow.pageModel.getBtnHeLeidoLasIndicaciones());
	}

	@Then("^Valido boton he leido las indicaciones sea correcto$")
	public void valido_boton_he_leido_las_indicaciones_sea_correcto() throws Throwable {
	    if (BaseFlow.pageModel.getBtnHeLeidoLasIndicaciones().getAttribute("innerText").trim().equals(
	    		BaseFlow.properties.getLabelHeLeidoLasIndicaciones())) {
	    	assertTrue(true);
	    } else {
	    	System.out.println("Botón he leído las indicaciones no es correcto");
	    	assertTrue(false);
	    }
	}

	@Then("^Valido boton he leido las indicaciones se encuentre habilitado$")
	public void valido_boton_he_leido_las_indicaciones_se_encuentre_habilitado() throws Throwable {
	    boolean condition = BaseFlow.pageModel.getBtnHeLeidoLasIndicaciones().isEnabled();
	    if (condition == true) {
	    	assertTrue(true);
	    } else {
	    	System.out.println("Botón he lído las indicaciones no se encuentra habilitado");
	    	assertTrue(false);
	    }
	}

	@Then("^Valido visualizacion el boton anular reserva$")
	public void valido_visualizacion_el_boton_anular_reserva() throws Throwable {
		//Button -- Anular reserva
		GenericMethods.isElementPresent(BaseFlow.pageModel.getBtnAnularReserva());
	}

	@Then("^Valido boton anular reserva sea correcto$")
	public void valido_boton_anular_reserva_sea_correcto() throws Throwable {
	    if (BaseFlow.pageModel.getBtnAnularReserva().getAttribute("innerText").trim().equals(
	    		BaseFlow.properties.getLabelAnularReserva())) {
	    	assertTrue(true);
	    } else {
	    	System.out.println("Botón anular reserva no es correcto");
	    }
	}

	@Then("^Valido boton de anular reserva se encuentre habilitado$")
	public void valido_boton_de_anular_reserva_se_encuentre_habilitado() throws Throwable {
		boolean condition = BaseFlow.pageModel.getBtnAnularReserva().isEnabled();
	    if (condition == true) {
	    	assertTrue(true);
	    } else {
	    	System.out.println("Botón anular reserva no se encuentra habilitado");
	    	assertTrue(false);
	    }
	}
}
