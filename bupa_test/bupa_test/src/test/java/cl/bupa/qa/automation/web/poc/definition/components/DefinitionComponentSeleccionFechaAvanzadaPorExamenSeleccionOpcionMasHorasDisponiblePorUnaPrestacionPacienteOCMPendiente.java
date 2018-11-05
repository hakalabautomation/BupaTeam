package cl.bupa.qa.automation.web.poc.definition.components;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import cl.bupa.qa.automation.web.business.flow.BaseFlow;
import cl.bupa.qa.automation.web.poc.util.GenericMethods;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class DefinitionComponentSeleccionFechaAvanzadaPorExamenSeleccionOpcionMasHorasDisponiblePorUnaPrestacionPacienteOCMPendiente {

	private static String yearSelected = "";
	private static String monthSelected = "";	
	private static String daySelected = "";
	
	@Given("^Valido la visualizacion icono de fecha avanzada$")
	public void valido_la_visualizacion_icono_de_fecha_avanzada() throws Throwable {
		// Button -- Calendario fecha avanzada
		GenericMethods.isElementPresent(BaseFlow.pageModel.getBtnCalendarioFechaAvanzada());
	}

	@When("^Valido que icono fecha avanzada se encuentre habilitado$")
	public void valido_que_icono_fecha_avanzada_se_encuentre_habilitado() throws Throwable {
	    boolean condition = BaseFlow.pageModel.getBtnCalendarioFechaAvanzada().isEnabled();
	    if (condition == true) {
	    	assertTrue(true);
	    } else {
	    	System.out.println("Botón fecha búsqueda avanzada no se encuentra habilitado");
	    	assertTrue(false);
	    }
	}

	@Then("^Seleccion icono fecha avanzada$")
	public void seleccion_icono_fecha_avanzada() throws Throwable {
		// Button -- Calendario fecha avanzada
		BaseFlow.pageModel.getBtnCalendarioFechaAvanzada().click();
	}

	@Then("^Valido visualizacion ventana busqueda fecha avanzada en calendario extendido$")
	public void valido_visualizacion_ventana_busqueda_fecha_avanzada_en_calendario_extendido() throws Throwable {
		// Div -- Calendario extendido
		GenericMethods.isElementPresent(BaseFlow.pageModel.getDivCalendarioExtendido());
	}

	@Then("^Valido visualizacion titulo de busqueda fecha avanzada$")
	public void valido_visualizacion_titulo_de_busqueda_fecha_avanzada() throws Throwable {
		// H4 -- Titulo busqueda avanzada		
		GenericMethods.isElementPresent(BaseFlow.pageModel.gethFourTituloBusquedaAvanzada());
	}

	@Then("^Valido titulo de busqueda fecha avanzada sea correcto$")
	public void valido_titulo_de_busqueda_fecha_avanzada_sea_correcto() throws Throwable {
		if (BaseFlow.pageModel.gethFourTituloBusquedaAvanzada().getText().trim().equals(
				BaseFlow.properties.getLabelBusquedaAvanzada())) {
			assertTrue(true);
		} else {
			System.out.println("Título búsqueda avanzada no es correcto");
			assertTrue(false);
		}
	}

	@Then("^Valido visualizacion mes y semana de busqueda fecha avanzada$")
	public void valido_visualizacion_mes_y_semana_de_busqueda_fecha_avanzada() throws Throwable {
		// H5 -- Subtitulo seleccion mes y semana
		GenericMethods.isElementPresent(BaseFlow.pageModel.gethFiveSeleccionMesSemana());
	}

	@Then("^Valido mes y semana de busqueda fecha avanzada sea correcto$")
	public void valido_mes_y_semana_de_busqueda_fecha_avanzada_sea_correcto() throws Throwable {
		 if (BaseFlow.pageModel.gethFiveSeleccionMesSemana().getText().trim().equals(
		    		BaseFlow.properties.getLabelSeleccionMesSemana())) {
			 assertTrue(true);
		 } else {
			 System.out.println("Subtitulo selecciona mes y semana no es correcto");
				assertTrue(false);
		}
	}

	@Then("^Doy click en año de busqueda fecha avanzada$")
	public void doy_click_en_año_de_busqueda_fecha_avanzada() throws Throwable {
		// Datepicker -- Año
		BaseFlow.pageModel.getDtpAño().get(1).click();
	}

	@Then("^Selecciono año del listado de busqueda fecha avanzada \"(.*?)\"$")
	public void selecciono_año_del_listado_de_busqueda_fecha_avanzada(String añoSelect) throws Throwable {
		Select dropdownYear = new Select(BaseFlow.pageModel.getDtpAño().get(1));
		dropdownYear.selectByIndex(Integer.parseInt(añoSelect));
		//obtengo label del año
		yearSelected = dropdownYear.getFirstSelectedOption().getText();
	}

	@Then("^Valido seleccion de año de busqueda fecha avanzada \"(.*?)\"$")
	public void valido_seleccion_de_año_de_busqueda_fecha_avanzada(String año) throws Throwable {
	    if (año.equals(yearSelected)) {
	    	assertTrue(true);
	    } else {
	    	System.out.println("Año seleccionado no coincide");
	    	assertTrue(false);
	    }
	}

	@Then("^Doy click en mes de busqueda fecha avanzada$")
	public void doy_click_en_mes_de_busqueda_fecha_avanzada() throws Throwable {
		// Datepicker -- Mes
		BaseFlow.pageModel.getDtpMes().get(0).click();
	}

	@Then("^Selecciono mes del listado de busqueda fecha avanzada \"(.*?)\"$")
	public void selecciono_mes_del_listado_de_busqueda_fecha_avanzada(String mesSelect) throws Throwable {
		Select dropdownMonth = new Select(BaseFlow.pageModel.getDtpMes().get(0));
		dropdownMonth.selectByIndex(Integer.parseInt(mesSelect));
		//obtengo label del mes
		monthSelected = dropdownMonth.getFirstSelectedOption().getText();
		//System.out.println(monthSelected);
		//Thread.sleep(10000000);
		switch (monthSelected) {
		case "Ene": monthSelected = "Enero"; 	
			break;
		case "Feb": monthSelected = "Febrero";
			break;
		case "Mar": monthSelected = "Marzo";
			break;
		case "Abr": monthSelected = "Abril";
			break;
		case "May": monthSelected = "Mayo";
			break;
		case "Jun": monthSelected = "Junio";
			break;
		case "Jul": monthSelected = "Julio";
			break;
		case "Ago": monthSelected = "Agosto";
			break;
		case "Sep": monthSelected = "Septiembre";
			break;
		case "Oct": monthSelected = "Octubre";
			break;
		case "Nov": monthSelected = "Noviembre";
			break;
		case "Dic": monthSelected = "Diciembre";
			break;
		default: monthSelected = "Invalid month";
			break;
		}
	}

	@Then("^Valido seleccion de mes de busqueda fecha avanzada \"(.*?)\"$")
	public void valido_seleccion_de_mes_de_busqueda_fecha_avanzada(String mes) throws Throwable {
		if (mes.equals(monthSelected)) {
			assertTrue(true);
		} else {
			System.out.println("Mes seleccionado no coincide");
			assertTrue(false);
		}
	}

	@Given("^Selecciono dia del listado de busqueda fecha avanzada \"(.*?)\"$")
	public void selecciono_dia_del_listado_de_busqueda_fecha_avanzada(String diaSelect) throws Throwable {
		//seleccion de dia
		List<WebElement> asd = BaseFlow.driver.findElements(By.className("custom-day"));
		asd.get(Integer.parseInt(diaSelect)).click();
		daySelected = asd.get(Integer.parseInt(diaSelect)).getText().trim();		
		//System.out.println(daySelected);
		Thread.sleep(7000);
	}

	@Given("^Valido seleccion de dia de busqueda fecha avanzada \"(.*?)\"$")
	public void valido_seleccion_de_dia_de_busqueda_fecha_avanzada(String dia) throws Throwable {
		if (dia.equals(daySelected)) {
			assertTrue(true);
		} else {
			System.out.println("Días seleccionados no coinciden");
			assertTrue(false);
		}
	}
}
