package cl.bupa.qa.automation.web.poc.definition.components;

import static org.junit.Assert.assertEquals;

import java.util.Calendar;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import cl.bupa.qa.automation.web.business.flow.BaseFlow;
import cl.bupa.qa.automation.web.poc.util.GenericMethods;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class DefinitionBusquedaFechaAvanzadaExamen {
	
	public static String yearSelected = "";
	public static String monthSelected = "";	
	public static String daySelected = "";	
	
	@Given("^Selecciono boton nueva reserva de hora$")
	public void selecciono_boton_nueva_reserva_de_hora() throws Throwable {
		GenericMethods.isElementPresent(BaseFlow.pageModel.getBtnNuevaReservaHora());
		BaseFlow.pageModel.getBtnNuevaReservaHora().click();
		Thread.sleep(6000);
	}

	@Given("^Selecciono opcion pestaña examenes$")
	public void selecciono_opcion_pestaña_examenes() throws Throwable {
		// Nav Item Menu -- Examenes
		GenericMethods.isElementPresent(BaseFlow.pageModel.getNvItMenuExamenes());
	}

	@When("^Selecciono especialidad \"(.*?)\"$")
	public void selecciono_especialidad(String arg1) throws Throwable {
		BaseFlow.pageModel.getLbxEspecialidad().click();
		BaseFlow.pageModel.getListEspecialidad().get(30).click();
		Thread.sleep(7000);
	}

	@Then("^Valido seleccion especialidad \"(.*?)\"$")
	public void valido_seleccion_especialidad(String especialidad) throws Throwable {
		String preview = BaseFlow.pageModel.getLbxEspecialidad().getAttribute("innerText").trim();
		String[] especialidadSplit = preview.split("↵");
		String[] especialidadSplitFinally = especialidadSplit[0].split("×");
		String lblEspecialidad = especialidadSplitFinally[0].trim();
		//System.out.println("especialidad:"+lblEspecialidad);
		//Thread.sleep(10000);
		assertEquals("No se valida de manera correcta seleccion especialidad", especialidad, lblEspecialidad);
	}

	@Then("^Valido el label de especialidad$")
	public void valido_el_label_de_especialidad() throws Throwable {
		String lblEspecialidad = BaseFlow.pageModel.getLblEspecialidad().getAttribute("placeholder");
		   assertEquals("Label especialidad no es igual", lblEspecialidad, BaseFlow.properties.getLabelEspecialidadTwo());
	}

	@When("^Seleccion de prestacion \"(.*?)\"$")
	public void seleccion_de_prestacion(String prestacion) throws Throwable {
		BaseFlow.pageModel.getLbxPrestacion().click();
		BaseFlow.pageModel.getListPrestacion().get(0).click();
		Thread.sleep(7000);
	}

	@Then("^Valido seleccion prestacion \"(.*?)\"$")
	public void valido_seleccion_prestacion(String prestacion) throws Throwable {
		String preview = BaseFlow.pageModel.getLbxPrestacion().getAttribute("innerText").trim();
		String[] prestacionSplit = preview.split("↵");
		String[] prestacionSplitFinally = prestacionSplit[0].split("×");
		String lblPrestacion = prestacionSplitFinally[0].trim();
		//System.out.println("prestacion:"+lblPrestacion);
		//Thread.sleep(10000);
		assertEquals("No se valida de manera correcta selección prestación", prestacion, lblPrestacion);
	}

	@Then("^Valido el label de prestacion$")
	public void valido_el_label_de_prestacion() throws Throwable {
		String lblPrestacion = BaseFlow.pageModel.getLblPrestacion().getAttribute("placeholder").trim();		
		assertEquals("Label prestacion no es igual", lblPrestacion, BaseFlow.properties.getLabelPrestacion());
	}

	@When("^Selecciono de region \"(.*?)\"$")
	public void selecciono_de_region(String arg1) throws Throwable {
		BaseFlow.pageModel.getLbxRegion().click();
		BaseFlow.pageModel.getListRegion().get(3).click();
		Thread.sleep(7000);
	}

	@Then("^Valido seleccion de region \"(.*?)\"$")
	public void valido_seleccion_de_region(String region) throws Throwable {
		String preview = BaseFlow.pageModel.getLbxRegion().getAttribute("innerText").trim();
		String[] regionSplit = preview.split("↵");
		String[] regionSplitFinally = regionSplit[0].split("×"); 
		String lblRegion = regionSplitFinally[0].trim();
		//System.out.println("Region:"+lblRegion);
		//Thread.sleep(10000);
		assertEquals("No se valida de manera correcta selección región", region, lblRegion);
	}

	@Then("^Valido el label de region$")
	public void valido_el_label_de_region() throws Throwable {
		String lblRegion = BaseFlow.pageModel.getLblRegion().getAttribute("placeholder");
	    assertEquals("Label región no es igual", lblRegion, BaseFlow.properties.getLabelRegion());
	}

	@When("^Selecciono un centro medico \"(.*?)\"$")
	public void selecciono_un_centro_medico(String arg1) throws Throwable {
		BaseFlow.pageModel.getLbxCentroMedico().click();
		BaseFlow.pageModel.getListCentroMedico().get(1).click();
		Thread.sleep(8000);
	}

	@Then("^Valido seleccion de centro medico \"(.*?)\"$")
	public void valido_seleccion_de_centro_medico(String centro) throws Throwable {
		String preview = BaseFlow.pageModel.getLbxCentroMedico().getAttribute("innerText").trim();
		String[] centroMedicoSplit = preview.split("↵");
		String[] centroMedicoSplitFinally = centroMedicoSplit[0].split("×");
		String lblCentroMedico = centroMedicoSplitFinally[0].trim();
		//System.out.println("Centro:"+lblCentroMedico);
		//	Thread.sleep(10000);
		assertEquals("No se valida de manera correcta selección centro médico", centro, lblCentroMedico);
	}

	@Then("^Valido el label de centro medico$")
	public void valido_el_label_de_centro_medico() throws Throwable {
		String lblCentroMedico = BaseFlow.pageModel.getLblCentroMedico().getAttribute("placeholder");
	    assertEquals("Label centro medico no es igual", lblCentroMedico, BaseFlow.properties.getLabelCentroMedico());
	}

	@When("^boton de busqueda fecha avanzada se encuentra habilitado$")
	public void boton_de_busqueda_fecha_avanzada_se_encuentra_habilitado() throws Throwable {
		// Button -- Calendario fecha avanzada
		//valido que se encuentre presente
		GenericMethods.isElementPresent(BaseFlow.pageModel.getBtnCalendarioFechaAvanzada());
		//valido que se encuentre habilitado
		BaseFlow.pageModel.getBtnCalendarioFechaAvanzada().isEnabled();
	}

	@Then("^Selecciono boton de busqueda fecha avanzada$")
	public void selecciono_boton_de_busqueda_fecha_avanzada() throws Throwable {
		BaseFlow.pageModel.getBtnCalendarioFechaAvanzada().click();
	}

	@Then("^Valido titulo label de busqueda avanzada$")
	public void valido_titulo_label_de_busqueda_avanzada() throws Throwable {
		// H4 -- Titulo busqueda avanzada
		//valido que se encuentre presente
		GenericMethods.isElementPresent(BaseFlow.pageModel.gethFourTituloBusquedaAvanzada());
		//valido que label sea el correcto
		assertEquals("Label búsqueda avanzada no es correcto", BaseFlow.properties.getLabelBusquedaAvanzada(),
				BaseFlow.pageModel.gethFourTituloBusquedaAvanzada().getText().trim());
	}

	@Then("^Valido subtitulo label mes y semana$")
	public void valido_subtitulo_label_mes_y_semana() throws Throwable {
		// H5 -- Subtitulo seleccion mes y semana
		//valido que se encuentre presente
		GenericMethods.isElementPresent(BaseFlow.pageModel.gethFiveSeleccionMesSemana());
		//valido que label sea el correcto
		assertEquals("Label selecciona mes y semana no es correcto", BaseFlow.properties.getLabelSeleccionMesSemana(),
				BaseFlow.pageModel.gethFiveSeleccionMesSemana().getText().trim());
	}

	@Then("^Selecciono año \"(.*?)\"$")
	public void selecciono_año(String año) throws Throwable {
		// Datepicker -- Año
		BaseFlow.pageModel.getDtpAño().get(1).click();
		Select dropdownYear = new Select(BaseFlow.pageModel.getDtpAño().get(1));
		dropdownYear.selectByIndex(0);
		//obtengo label del año
		yearSelected = dropdownYear.getFirstSelectedOption().getText();					
		//System.out.println(yearSelected);
		//Thread.sleep(10000000);
	}

	@Then("^Valido seleccion de año \"(.*?)\"$")
	public void valido_seleccion_de_año(String year) throws Throwable {
		assertEquals("Año seleccionado no coinciden", year, yearSelected);
	}

	@Then("^Selecciono mes \"(.*?)\"$")
	public void selecciono_mes(String month) throws Throwable {
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

	@Then("^Valido seleccion de mes \"(.*?)\"$")
	public void valido_seleccion_de_mes(String month) throws Throwable {
		assertEquals("Mes seleccionado no coincide", month, monthSelected);
	}

	@Then("^Selecciono dia \"(.*?)\"$")
	public void selecciono_dia(String day) throws Throwable {
		//seleccion de dia
		List<WebElement> asd = BaseFlow.driver.findElements(By.className("custom-day"));
		asd.get(11).click();
		daySelected = asd.get(11).getText().trim();
		//System.out.println(daySelected);
		Thread.sleep(5000);
	}

	@Then("^Valido seleccion de dia \"(.*?)\"$")
	public void valido_seleccion_de_dia(String day) throws Throwable {
	   assertEquals("Días seleccionados no coinciden", day, daySelected); 
	}

	@Then("^Valido titulo mes y año actual sea de acuerdo a la fecha seleccionada$")
	public void valido_titulo_mes_y_año_actual_sea_de_acuerdo_a_la_fecha_seleccionada() throws Throwable {
	    //formo el label mostrado como titulo mes y año
		assertEquals("Titulo mes y año seleccionado no coincide", BaseFlow.pageModel.gethFiveTituloReservaSemana().getText().trim(), 
				monthSelected+" de "+yearSelected);
	}

	@Then("^Valido que subtitulo de semana sea de acuerdo a la fecha seleccionada$")
	public void valido_que_subtitulo_de_semana_sea_de_acuerdo_a_la_fecha_seleccionada() throws Throwable {
	    //formo el label mostrado como subtitulo semana
		Calendar dayFuture = Calendar.getInstance();
		switch (monthSelected) {
		case "Enero": monthSelected = "01"; 	
			break;
		case "Febrero": monthSelected = "02";
			break;
		case "Marzo": monthSelected = "03";
			break;
		case "Abril": monthSelected = "04";
			break;
		case "Mayo": monthSelected = "05";
			break;
		case "Junio": monthSelected = "06";
			break;
		case "Julio": monthSelected = "07";
			break;
		case "Agosto": monthSelected = "08";
			break;
		case "Septiembre": monthSelected = "09";
			break;
		case "Octubre": monthSelected = "10";
			break;
		case "Noviembre": monthSelected = "11";
			break;
		case "Diciembre": monthSelected = "12";
			break;
		default: monthSelected = "Invalid month";
			break;
		}
		dayFuture.add(Calendar.YEAR, Integer.parseInt(yearSelected));
		dayFuture.add(Calendar.MONTH, Integer.parseInt(monthSelected));
	    dayFuture.add(Calendar.DATE, 7);
	    int dayFutureFinally = dayFuture.get(Calendar.DAY_OF_MONTH);	    	    
	    //String labelFinallyTwo = "Semana del "+daySelected+" al "+dayFutureFinally;
		assertEquals("Subtitulo semanas seleccionado no coincide", BaseFlow.pageModel.gethSixTituloReservaSemana().getText().trim(),
				"Semana del "+daySelected+" al "+dayFutureFinally);
	}

	@Then("^Valido que que primer dia mostrado en fecha sea de acuerdo a la fecha seleccionada$")
	public void valido_que_que_primer_dia_mostrado_en_fecha_sea_de_acuerdo_a_la_fecha_seleccionada() throws Throwable {		
				
	}
}
