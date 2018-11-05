package cl.bupa.qa.automation.web.poc.definition.components;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import cl.bupa.qa.automation.web.business.flow.BaseFlow;
import cl.bupa.qa.automation.web.poc.util.GenericMethods;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class DefinitionBusquedaFechaAvanzadaMedico {

	public static String yearSelected = "";
	public static String monthSelected = "";	
	public static String daySelected = "";
	private static String lblMedico;
	private static String lblEspecialidad;
	private static String lblPrestacion;
	private static String lblRegion;
	private static String lblCentroMedico;	
	
	@Given("^Selecciono boton nueva reserva de hora para consulta medico$")
	public void selecciono_boton_nueva_reserva_de_hora_para_consulta_medico() throws Throwable {	    
		BaseFlow.pageModel.getBtnNuevaReservaHora().click();
	}

	@When("^Valido que muestre ventana nueva reserva$")
	public void valido_que_muestre_ventana_nueva_reserva() throws Throwable {
		// Div -- Nueva reserva
		GenericMethods.isElementPresent(BaseFlow.pageModel.getDivNuevaReserva());
	}

	@Then("^Seleccion pestaña medico$")
	public void seleccion_pestaña_medico() throws Throwable {	    
		BaseFlow.pageModel.getTbMedicos().sendKeys(Keys.TAB);
		BaseFlow.pageModel.getTbMedicos().sendKeys(Keys.TAB);
		BaseFlow.pageModel.getTbMedicos().sendKeys(Keys.TAB);
		BaseFlow.pageModel.getTbMedicos().sendKeys(Keys.ENTER);
		Thread.sleep(5000);		
	}

	@When("^Selecciono opcion medico \"(.*?)\"$")
	public void selecciono_opcion_medico(String medico) throws Throwable {
		Thread.sleep(10000);
	}

	@Then("^Valido seleccion medico pestaña medico \"(.*?)\"$")
	public void valido_seleccion_medico_pestaña_medico(String medico) throws Throwable {
		/*
		String preview = BaseFlow.pageModel.getLbxMedico().get(0).getAttribute("innerText").trim();
		String[] medicoSplit = preview.split("↵");
		String[] medicoSplitFinally = medicoSplit[0].split("×");
		lblMedico = medicoSplitFinally[0].trim();
		// comparacion de medico seleccionado
		if (medico.equals(lblMedico)) {
			assertTrue(true);
		} else {
			System.out.println("No se valida de manera correcta selección médico");
			assertTrue(false);
		}
		*/
	}

	@Then("^Valido el label de medico pestaña medico$")
	public void valido_el_label_de_medico_pestaña_medico() throws Throwable {
		String lblMedico = BaseFlow.pageModel.getLbxMedico().get(0).getAttribute("placeholder");		
		if (lblMedico.equals(BaseFlow.properties.getLabelNombreDelMedico())) {
			assertTrue(true);
		} else {
			System.out.println("Label médico no es igual");
			assertFalse(false);
		}
	}

	@When("^Seleccion de opcion especialidad$")
	public void seleccion_de_opcion_especialidad() throws Throwable {	    
		//esperar hasta que elemento se encuentra habilitado		
		Thread.sleep(7000);
		//seleccion especialidad
		BaseFlow.pageModel.getLbxEspecialidad().click();
		BaseFlow.pageModel.getListEspecialidad().get(1).click();
	}

	@Then("^Valido seleccion especialidad pestaña medico \"(.*?)\"$")
	public void valido_seleccion_especialidad_pestaña_medico(String especialidad) throws Throwable {
		String preview = BaseFlow.pageModel.getLbxEspecialidad().getAttribute("innerText").trim();
		String[] especialidadSplit = preview.split("↵");
		String[] especialidadSplitFinally = especialidadSplit[0].split("×");
		String lblEspecialidad = especialidadSplitFinally[0].trim();
		// comparacion de especialidad seleccionada
		if (especialidad.equals(lblEspecialidad)) {
			assertTrue(true);
		} else {
			System.out.println("No se valida de manera correcta selección especialidad");
			assertTrue(false);
		}
	}

	@Then("^Valido el label de especialidad pestaña medico$")
	public void valido_el_label_de_especialidad_pestaña_medico() throws Throwable {
		String lblEspecialidad = BaseFlow.pageModel.getLbxEspecialidad().getAttribute("placeholder").trim();		
		if (lblEspecialidad.equals(BaseFlow.properties.getLabelEspecialidadTwo())) {
			assertTrue(true);
		} else {
			System.out.println("Label especialidad no es igual");
			assertTrue(false);
		}	    
	}

	@When("^Selecciono de opcion prestacion$")
	public void selecciono_de_opcion_prestacion() throws Throwable {
		//esperar hasta que elemento se encuentra habilitado
		Thread.sleep(7000);
		//seleccion prestacion
		BaseFlow.pageModel.getLbxPrestacion().click();
		BaseFlow.pageModel.getListPrestacion().get(0).click();    
	}

	@Then("^Valido seleccion prestacion pestaña medico \"(.*?)\"$")
	public void valido_seleccion_prestacion_pestaña_medico(String prestacion) throws Throwable {
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

	@Then("^Valido el label prestacion pestaña medico$")
	public void valido_el_label_prestacion_pestaña_medico() throws Throwable {
		String lblPrestacion = BaseFlow.pageModel.getLblPrestacion().getAttribute("placeholder").trim();
		if (lblPrestacion.equals(BaseFlow.properties.getLabelPrestacion())) {
			assertTrue(true);
		} else {
			System.out.println("Label prestación no es igual");
			assertFalse(false);
		}
	}

	@When("^Seleccion de opcion region$")
	public void seleccion_de_opcion_region() throws Throwable {
		//esperar hasta que elemento se encuentra habilitado
		Thread.sleep(5000);
		//seleccion region
		BaseFlow.pageModel.getLbxRegion().click();
		BaseFlow.pageModel.getListRegion().get(0).click();	    
	}

	@Then("^Valido seleccion region pestaña medico \"(.*?)\"$")
	public void valido_seleccion_region_pestaña_medico(String region) throws Throwable {
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

	@Then("^Valido el label region pestaña medico$")
	public void valido_el_label_region_pestaña_medico() throws Throwable {
		String lblRegion = BaseFlow.pageModel.getLblRegion().getAttribute("placeholder");
		if (lblRegion.equals(BaseFlow.properties.getLabelRegion())) {
			assertTrue(true);
		} else {
			System.out.println("Label región no es igual");
			assertFalse(false);
		}
	}

	@When("^Seleccion de opcion centro medico$")
	public void seleccion_de_opcion_centro_medico() throws Throwable {	    
		//esperar hasta que elemento se encuentra habilitado
		Thread.sleep(7000);
		//seleccion centro medico
		BaseFlow.pageModel.getLbxCentroMedico().click();
		BaseFlow.pageModel.getListCentroMedico().get(0).click();
	}

	@Then("^Valido seleccion centro medico pestaña medico \"(.*?)\"$")
	public void valido_seleccion_centro_medico_pestaña_medico(String centro) throws Throwable {
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

	@Then("^Valido el label centro medico pestaña medico$")
	public void valido_el_label_centro_medico_pestaña_medico() throws Throwable {
		String lblCentroMedico = BaseFlow.pageModel.getLblCentroMedico().getAttribute("placeholder");
		if (lblCentroMedico.equals(BaseFlow.properties.getLabelCentroMedico())) {
			assertTrue(true);
		} else {
			System.out.println("Label centro médico no es igual");
			assertFalse(false);
		}
	}

	@When("^Valido boton de fecha busqueda avanzada se encuentro habilitado$")
	public void valido_boton_de_fecha_busqueda_avanzada_se_encuentro_habilitado() throws Throwable {
		//tiempo de espera
		Thread.sleep(7000);
		boolean condition = BaseFlow.pageModel.getBtnCalendarioFechaAvanzada().isEnabled();
	    if (condition == true) {
	    	assertTrue(true);
	    } else {
	    	System.out.println("Botón calendario fecha avanzada no se encuentra habilitado");
	    	assertTrue(false);
	    }
	}

	@Then("^Presiono boton fecha busqueda avanzada pestaña medico$")
	public void presiono_boton_fecha_busqueda_avanzada_pestaña_medico() throws Throwable {	    
		BaseFlow.pageModel.getBtnCalendarioFechaAvanzada().click();
	}

	@Then("^Valido que muestre calendario extendido pestaña medico$")
	public void valido_que_muestre_calendario_extendido_pestaña_medico() throws Throwable {
		// Div -- Calendario extendido
		GenericMethods.isElementPresent(BaseFlow.pageModel.getDivCalendarioExtendido());    
	}

	@Then("^Valido que se visualice titulo busqueda avanzada pestaña medico$")
	public void valido_que_se_visualice_titulo_busqueda_avanzada_pestaña_medico() throws Throwable {
		// H4 -- Titulo busqueda avanzada		
		GenericMethods.isElementPresent(BaseFlow.pageModel.gethFourTituloBusquedaAvanzada());    
	}

	@Then("^Valido titulo de busqueda avanzada pestaña medico$")
	public void valido_titulo_de_busqueda_avanzada_pestaña_medico() throws Throwable {
		if (BaseFlow.pageModel.gethFourTituloBusquedaAvanzada().getText().trim().equals(
				BaseFlow.properties.getLabelBusquedaAvanzada())) {
			assertTrue(true);
		} else {
			System.out.println("Título búsqueda avanzada no es correcto");
			assertTrue(false);
		}
	}

	@Then("^Valido que se visualice mes y semana pestaña medico$")
	public void valido_que_se_visualice_mes_y_semana_pestaña_medico() throws Throwable {	    
		// H5 -- Subtitulo seleccion mes y semana
		GenericMethods.isElementPresent(BaseFlow.pageModel.gethFiveSeleccionMesSemana());
	}

	@Then("^Valido subtitulo mes y semana pestaña medico$")
	public void valido_subtitulo_mes_y_semana_pestaña_medico() throws Throwable {
		if (BaseFlow.pageModel.gethFiveSeleccionMesSemana().getText().trim().equals(
	    		BaseFlow.properties.getLabelSeleccionMesSemana())) {
	    	assertTrue(true);
	    } else {
	    	System.out.println("Subtitulo selecciona mes y semana no es correcto");
	    	assertTrue(false);
	    }
	}

	@Then("^Selecciono año pestaña medico$")
	public void selecciono_año_pestaña_medico() throws Throwable {
		// Datepicker -- Año
		BaseFlow.pageModel.getDtpAño().get(1).click();
		Select dropdownYear = new Select(BaseFlow.pageModel.getDtpAño().get(1));
		dropdownYear.selectByIndex(0);
		//obtengo label del año
		yearSelected = dropdownYear.getFirstSelectedOption().getText(); 
	}

	@Then("^Valido seleccion de año pestaña medico \"(.*?)\"$")
	public void valido_seleccion_de_año_pestaña_medico(String year) throws Throwable {
		if (year.equals(yearSelected)) {
	    	assertTrue(true);
	    } else {
	    	System.out.println("Año seleccionado no coincide");
	    	assertTrue(false);
	    }	    
	}

	@Then("^Selecciono mes pestaña medico$")
	public void selecciono_mes_pestaña_medico() throws Throwable {	    
		// Datepicker -- Mes
		BaseFlow.pageModel.getDtpMes().get(0).click();
		Select dropdownMonth = new Select(BaseFlow.pageModel.getDtpMes().get(0));
		dropdownMonth.selectByIndex(0);
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

	@Then("^Valido seleccion de mes pestaña medico \"(.*?)\"$")
	public void valido_seleccion_de_mes_pestaña_medico(String month) throws Throwable {
		if (month.equals(monthSelected)) {
	    	assertTrue(true);
	    } else {
	    	System.out.println("Mes seleccionado no coincide");
	    	assertTrue(false);
	    }	    
	}

	@Then("^Selecciono dia pestaña medico$")
	public void selecciono_dia_pestaña_medico() throws Throwable {	    
		//seleccion de dia
		List<WebElement> asd = BaseFlow.driver.findElements(By.className("custom-day"));
		asd.get(11).click();
		daySelected = asd.get(11).getText().trim();		
		//System.out.println(daySelected);
		Thread.sleep(6000);
	}

	@Then("^Valido seleccion de dia pestaña medico \"(.*?)\"$")
	public void valido_seleccion_de_dia_pestaña_medico(String day) throws Throwable {
		if (day.equals(daySelected)) {
	    	assertTrue(true);
	    } else {
	    	System.out.println("Días seleccionados no coinciden");
	    	assertTrue(false);
	    }	    
	}

	@Then("^Valido titulo mes y año actual sea de acuerdo a la fecha seleccionada pestaña medico$")
	public void valido_titulo_mes_y_año_actual_sea_de_acuerdo_a_la_fecha_seleccionada_pestaña_medico() throws Throwable {
		String monthAndYearSelected = monthSelected+" de "+yearSelected;
	    if (monthAndYearSelected.equals(BaseFlow.pageModel.gethFiveTituloReservaSemana().getText().trim())) {
	    	assertTrue(true);
	    } else {
	    	System.out.println("Titulo mes y año seleccionado no coincide");
	    	assertTrue(false);
	    }	    
	}

	@Then("^Valido que subtitulo de semana sea de acuerdo a la fecha seleccionada pestaña medico$")
	public void valido_que_subtitulo_de_semana_sea_de_acuerdo_a_la_fecha_seleccionada_pestaña_medico() throws Throwable {
	    
	    
	}

	@Then("^Valido que que primer dia mostrado en fecha sea de acuerdo a la fecha seleccionada pestaña medico$")
	public void valido_que_que_primer_dia_mostrado_en_fecha_sea_de_acuerdo_a_la_fecha_seleccionada_pestaña_medico() throws Throwable {
	    
	    
	}
}
