package cl.bupa.qa.automation.web.poc.definition.components;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ById;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.WebElement;

import cl.bupa.qa.automation.web.business.flow.BaseFlow;
import cl.bupa.qa.automation.web.poc.util.GenericMethods;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class DefinitionBusquedaFechaAvanzadaEspecialidad {

	private static String yearSelected = "";
	private static String monthSelected = "";	
	private static String daySelected = "";
	
	@Given("^Selecciono boton nueva reserva de hora para especialidad$")
	public void selecciono_boton_nueva_reserva_de_hora_para_especialidad() throws Throwable {		
		BaseFlow.pageModel.getBtnNuevaReservaHora().click();		
	}

	@Given("^Selecciono opcion pestaña especialidad$")
	public void selecciono_opcion_pestaña_especialidad() throws Throwable {
	    //pestaña especialidad seleccionada
	}

	@When("^Selecciono una especialidad$")
	public void selecciono_una_especialidad() throws Throwable {
		//esperar hasta que elemento se encuentra habilitado		
		Thread.sleep(6000);
		//seleccion especialidad
		BaseFlow.pageModel.getLbxEspecialidad().click();
		BaseFlow.pageModel.getListEspecialidad().get(3).click();
	}

	@Then("^Valido seleccion especialidad pestaña especialidad \"(.*?)\"$")
	public void valido_seleccion_especialidad_pestaña_especialidad(String especialidad) throws Throwable {
		String preview = BaseFlow.pageModel.getLbxEspecialidad().getAttribute("innerText").trim();
		String[] especialidadSplit = preview.split("↵");
		String[] especialidadSplitFinally = especialidadSplit[0].split("×");
		String lblEspecialidad = especialidadSplitFinally[0].trim();
		// comparacion de especialidad seleccionada
		if (especialidad.equals(lblEspecialidad)) {
			assertTrue(true);
		} else {
			System.out.println("No se valida de manera correcta selección especialidad");
			assertFalse(false);
		}
	}

	@Then("^Valido el label de especialidad pestaña especialidad$")
	public void valido_el_label_de_especialidad_pestaña_especialidad() throws Throwable {
		String lblEspecialidad = BaseFlow.pageModel.getLblEspecialidad().getAttribute("placeholder");		
		if (lblEspecialidad.equals(BaseFlow.properties.getLabelEspecialidadTwo())) {
			assertTrue(true);
		} else {
			System.out.println("Label especialidad no es igual");
			assertFalse(false);
		}
	}

	@When("^Selecciono una prestacion$")
	public void selecciono_una_prestacion() throws Throwable {
		//esperar hasta que elemento se encuentra habilitado
		Thread.sleep(4000);
		//seleccion prestacion
		BaseFlow.pageModel.getLbxPrestacion().click();
		BaseFlow.pageModel.getListPrestacion().get(0).click();
	}

	@Then("^Valido seleccion prestacion pestaña especialidad \"(.*?)\"$")
	public void valido_seleccion_prestacion_pestaña_especialidad(String prestacion) throws Throwable {
		String preview = BaseFlow.pageModel.getLbxPrestacion().getAttribute("innerText").trim();
		String[] prestacionSplit = preview.split("↵");
		String[] prestacionSplitFinally = prestacionSplit[0].split("×");
		String lblPrestacion = prestacionSplitFinally[0].trim();
		// comparacion de prestacion seleccionada
		if (prestacion.equals(lblPrestacion)) {
			assertTrue(true);
		} else {
			System.out.println("No se valida de manera correcta selección prestación");
			assertFalse(false);
		}
	}

	@Then("^Valido el label prestacion pestaña especialidad$")
	public void valido_el_label_prestacion_pestaña_especialidad() throws Throwable {
		String lblPrestacion = BaseFlow.pageModel.getLblPrestacion().getAttribute("placeholder").trim();
		   //assertEquals("Label especialidad no es igual", lblEspecialidad, BaseFlow.properties.getLabelEspecialidadTwo());
		if (lblPrestacion.equals(BaseFlow.properties.getLabelPrestacion())) {
			assertTrue(true);
		} else {
			System.out.println("Label prestación no es igual");
			assertFalse(false);
		}
	}

	@When("^Selecciono una region$")
	public void selecciono_una_region() throws Throwable {
		//esperar hasta que elemento se encuentra habilitado
		Thread.sleep(4000);
		//seleccion region
		BaseFlow.pageModel.getLbxRegion().click();
		BaseFlow.pageModel.getListRegion().get(3).click();
	}

	@Then("^Valido seleccion region pestaña especialidad \"(.*?)\"$")
	public void valido_seleccion_region_pestaña_especialidad(String region) throws Throwable {
		String preview = BaseFlow.pageModel.getLbxRegion().getAttribute("innerText").trim();
		String[] regionSplit = preview.split("↵");
		String[] regionSplitFinally = regionSplit[0].split("×");
		String lblRegion = regionSplitFinally[0].trim();
		// comparacion de región seleccionada
		if (region.equals(lblRegion)) {
			assertTrue(true);
		} else {
			System.out.println("No se valida de manera correcta selección región");
			assertTrue(false);
		}
	}

	@Then("^Valido el label region pestaña especialidad$")
	public void valido_el_label_region_pestaña_especialidad() throws Throwable {
		String lblRegion = BaseFlow.pageModel.getLblRegion().getAttribute("placeholder");	    
		if (lblRegion.equals(BaseFlow.properties.getLabelRegion())) {
			assertTrue(true);
		} else {
			System.out.println("Label región no es igual");
			assertFalse(false);
		}
	}

	@When("^Selecciono un centro medico$")
	public void selecciono_un_centro_medico() throws Throwable {
		//esperar hasta que elemento se encuentra habilitado
		Thread.sleep(4000);
		//seleccion centro medico
		BaseFlow.pageModel.getLbxCentroMedico().click();
		BaseFlow.pageModel.getListCentroMedico().get(2).click();
		//tiempo de espera
		Thread.sleep(6000);
	}

	@Then("^Valido seleccion centro medico pestaña especialidad \"(.*?)\"$")
	public void valido_seleccion_centro_medico_pestaña_especialidad(String centro) throws Throwable {
		String preview = BaseFlow.pageModel.getLbxCentroMedico().getAttribute("innerText").trim();
		String[] centroMedicoSplit = preview.split("↵");
		String[] centroMedicoSplitFinally = centroMedicoSplit[0].split("×");
		String lblCentroMedico = centroMedicoSplitFinally[0].trim();
		// comparacion centro medico seleccionado
		if (centro.equals(lblCentroMedico)) {
			assertTrue(true);
		} else {
			System.out.println("No se valida de manera correcta selección centro médico");
			assertTrue(false);
		}
	}

	@Then("^Valido el label centro medico pestaña especialidad$")
	public void valido_el_label_centro_medico_pestaña_especialidad() throws Throwable {
		String lblCentroMedico = BaseFlow.pageModel.getLblCentroMedico().getAttribute("placeholder");
		if (lblCentroMedico.equals(BaseFlow.properties.getLabelCentroMedico())) {
			assertTrue(true);
		} else {
			System.out.println("Label centro médico no es igual");
			assertFalse(false);
		}
	}

	@When("^Valido que boton de fecha busqueda avanzada se encuentro habilitado$")
	public void valido_que_boton_de_fecha_busqueda_avanzada_se_encuentro_habilitado() throws Throwable {
	    boolean condition = BaseFlow.pageModel.getBtnCalendarioFechaAvanzada().isEnabled();
	    if (condition == true) {
	    	assertTrue(true);
	    } else {
	    	System.out.println("Botón calendario fecha avanzada no se encuentra habilitado");
	    	assertTrue(false);
	    }
	}

	@Then("^Doy click en boton fecha busqueda avanzada pestaña especialidad$")
	public void doy_click_en_boton_fecha_busqueda_avanzada_pestaña_especialidad() throws Throwable {
		BaseFlow.pageModel.getBtnCalendarioFechaAvanzada().click();
	}
	
	@Then("^Valido que muestre calendario extendido pestaña especialidad$")
	public void valido_que_muestre_calendario_extendido_pestaña_especialidad() throws Throwable {
		// Div -- Calendario extendido
		GenericMethods.isElementPresent(BaseFlow.pageModel.getDivCalendarioExtendido());
	}

	@Then("^Valido que se visualice titulo busqueda avanzada pestaña especialidad$")
	public void valido_que_se_visualice_titulo_busqueda_avanzada_pestaña_especialidad() throws Throwable {
		// H4 -- Titulo busqueda avanzada		
		GenericMethods.isElementPresent(BaseFlow.pageModel.gethFourTituloBusquedaAvanzada());
	}
	
	@Then("^Valido titulo de busqueda avanzada pestaña especialidad$")
	public void valido_titulo_de_busqueda_avanzada_pestaña_especialidad() throws Throwable {
		if (BaseFlow.pageModel.gethFourTituloBusquedaAvanzada().getText().trim().equals(
				BaseFlow.properties.getLabelBusquedaAvanzada())) {
			assertTrue(true);
		} else {
			System.out.println("Título búsqueda avanzada no es correcto");
			assertTrue(false);
		}
	}

	@Then("^Valido que se visualice mes y semana pestaña especialidad$")
	public void valido_que_se_visualice_mes_y_semana_pestaña_especialidad() throws Throwable {
		// H5 -- Subtitulo seleccion mes y semana
		GenericMethods.isElementPresent(BaseFlow.pageModel.gethFiveSeleccionMesSemana());
	}

	@Then("^Valido subtitulo mes y semana pestaña especialidad$")
	public void valido_subtitulo_mes_y_semana_pestaña_especialidad() throws Throwable {
	    if (BaseFlow.pageModel.gethFiveSeleccionMesSemana().getText().trim().equals(
	    		BaseFlow.properties.getLabelSeleccionMesSemana())) {
	    	assertTrue(true);
	    } else {
	    	System.out.println("Subtitulo selecciona mes y semana no es correcto");
	    	assertTrue(false);
	    }
	}

	@Then("^Selecciono año pestaña especialidad$")
	public void selecciono_año_pestaña_especialidad() throws Throwable {
		// Datepicker -- Año
		BaseFlow.pageModel.getDtpAño().get(1).click();
		Select dropdownYear = new Select(BaseFlow.pageModel.getDtpAño().get(1));
		dropdownYear.selectByIndex(0);
		//obtengo label del año
		yearSelected = dropdownYear.getFirstSelectedOption().getText();
	}

	@Then("^Valido seleccion de año pestaña especialidad \"(.*?)\"$")
	public void valido_seleccion_de_año_pestaña_especialidad(String year) throws Throwable {
	    if (year.equals(yearSelected)) {
	    	assertTrue(true);
	    } else {
	    	System.out.println("Año seleccionado no coincide");
	    	assertTrue(false);
	    }
	}

	@Then("^Selecciono mes pestaña especialidad$")
	public void selecciono_mes_pestaña_especialidad() throws Throwable {
		// Datepicker -- Mes
		BaseFlow.pageModel.getDtpMes().get(0).click();
		Select dropdownMonth = new Select(BaseFlow.pageModel.getDtpMes().get(0));
		dropdownMonth.selectByIndex(1);
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

	@Then("^Valido seleccion de mes pestaña especialidad \"(.*?)\"$")
	public void valido_seleccion_de_mes_pestaña_especialidad(String month) throws Throwable {
	    if (month.equals(monthSelected)) {
	    	assertTrue(true);
	    } else {
	    	System.out.println("Mes seleccionado no coincide");
	    	assertTrue(false);
	    }
	}

	@Then("^Selecciono dia pestaña especialidad$")
	public void selecciono_dia_pestaña_especialidad() throws Throwable {
		//seleccion de dia
		List<WebElement> asd = BaseFlow.driver.findElements(By.className("custom-day"));
		asd.get(11).click();
		daySelected = asd.get(11).getText().trim();		
		//System.out.println(daySelected);
		Thread.sleep(6000);
	}

	@Then("^Valido seleccion de dia pestaña especialidad \"(.*?)\"$")
	public void valido_seleccion_de_dia_pestaña_especialidad(String day) throws Throwable {
	    if (day.equals(daySelected)) {
	    	assertTrue(true);
	    } else {
	    	System.out.println("Días seleccionados no coinciden");
	    	assertTrue(false);
	    }
	}

	@Then("^Valido titulo mes y año actual sea de acuerdo a la fecha seleccionada pestaña especialidad$")
	public void valido_titulo_mes_y_año_actual_sea_de_acuerdo_a_la_fecha_seleccionada_pestaña_especialidad() throws Throwable {
	    String monthAndYearSelected = monthSelected+" de "+yearSelected;
	    if (monthAndYearSelected.equals(BaseFlow.pageModel.gethFiveTituloReservaSemana().getText().trim())) {
	    	assertTrue(true);
	    } else {
	    	System.out.println("Titulo mes y año seleccionado no coincide");
	    	assertTrue(false);
	    }
	}

	@Then("^Valido que subtitulo de semana sea de acuerdo a la fecha seleccionada pestaña especialidad$")
	public void valido_que_subtitulo_de_semana_sea_de_acuerdo_a_la_fecha_seleccionada_pestaña_especialidad() throws Throwable {
		
	}

	@Then("^Valido que que primer dia mostrado en fecha sea de acuerdo a la fecha seleccionada pestaña especialidad$")
	public void valido_que_que_primer_dia_mostrado_en_fecha_sea_de_acuerdo_a_la_fecha_seleccionada_pestaña_especialidad() throws Throwable {
	    
	}
}