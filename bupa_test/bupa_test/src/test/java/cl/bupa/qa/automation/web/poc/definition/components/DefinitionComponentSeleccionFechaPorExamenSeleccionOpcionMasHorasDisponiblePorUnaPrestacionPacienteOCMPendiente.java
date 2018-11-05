package cl.bupa.qa.automation.web.poc.definition.components;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import cl.bupa.qa.automation.web.business.flow.BaseFlow;
import cl.bupa.qa.automation.web.poc.util.GenericMethods;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class DefinitionComponentSeleccionFechaPorExamenSeleccionOpcionMasHorasDisponiblePorUnaPrestacionPacienteOCMPendiente {
	
	@Given("^Valido visualizacion icono calendario$")
	public void valido_visualizacion_icono_calendario() throws Throwable {
		// Button -- Calendario fecha avanzada
		GenericMethods.isElementPresent(BaseFlow.pageModel.getBtnCalendarioFechaAvanzada());
	}

	@When("^Valido visualizacion titulo mes y año$")
	public void valido_visualizacion_titulo_mes_y_año() throws Throwable {
		// H5 -- Titulo reserva semana
		GenericMethods.isElementPresent(BaseFlow.pageModel.gethFiveTituloReservaSemana());
	}

	@When("^Valido visualizacion subtitulo semana$")
	public void valido_visualizacion_subtitulo_semana() throws Throwable {
		// H6 -- Titulo reserva semana
		GenericMethods.isElementPresent(BaseFlow.pageModel.gethSixTituloReservaSemana());
	}

	@Then("^Valido visualizacion columna nombre dias$")
	public void valido_visualizacion_columna_nombre_dias() throws Throwable {
		// Tr -- Nombre dia
		GenericMethods.isElementPresent(BaseFlow.pageModel.getTrNombreDia());
	}

	@Then("^Valido visualizacion columna numero dias$")
	public void valido_visualizacion_columna_numero_dias() throws Throwable {
		// Tr -- Fechas mostradas
		GenericMethods.isElementPresent(BaseFlow.pageModel.getTrFechasMostradas());
	}
	
	@Then("^Valido visualizacion dias activos$")
	public void valido_visualizacion_dias_activos() throws Throwable {
		// valido la cantidad de fechas disponibles habilitadas
		int fechasActivas = BaseFlow.pageModel.getListFechasActivas().size();
		if (fechasActivas >= 1) {
			assertTrue("Existen fechas activas para la combinación de búsqueda", true);
		} else if (fechasActivas <= 0) {
			assertTrue("No existen fechas activas para la combinación de búsqueda", true);
		} else {
			System.out.println("Condición de fechas no realizada");
			assertTrue(false);
		}
	}

	@Then("^Valido que ya exista una fecha seleccionada$")
	public void valido_que_ya_exista_una_fecha_seleccionada() throws Throwable {
		//día seleccionado
		List<WebElement> asd = BaseFlow.driver.findElements(By.className("selected"));	
		for (WebElement a : asd) {
			if (a.isDisplayed()) {
				assertTrue(true);
			} else {
				System.out.println("Día seleccionado no se encuentra desplegado");
				assertTrue(false);
			}
		}
	}
}
