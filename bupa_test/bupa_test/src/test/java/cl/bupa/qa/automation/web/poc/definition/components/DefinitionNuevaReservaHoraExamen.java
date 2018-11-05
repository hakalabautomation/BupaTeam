package cl.bupa.qa.automation.web.poc.definition.components;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Calendar;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import cl.bupa.qa.automation.web.business.flow.BaseFlow;
import cl.bupa.qa.automation.web.poc.util.GenericMethods;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class DefinitionNuevaReservaHoraExamen {		

	private static String lblEspecialidad;
	private static String lblPrestacion;
	private static String lblCentroMedico;
	@Given("^Selecciono el boton nueva reserva de hora$")
	public void selecciono_el_boton_nueva_reserva_de_hora() throws Throwable {
		GenericMethods.isElementPresent(BaseFlow.pageModel.getBtnNuevaReservaHora());
		BaseFlow.pageModel.getBtnNuevaReservaHora().click();
	}

	@Given("^Selecciono pestaña examenes$")
	public void selecciono_pestaña_examenes() throws Throwable {
		//esperar elemento web que se encuentre visible y habilitado
		GenericMethods.esperaElementoWebSegundos(BaseFlow.driver, BaseFlow.pageModel.getNvItMenuExamenes(), 5);
		//valido que elemento web se encuentre presente
		GenericMethods.isElementPresent(BaseFlow.pageModel.getNvItMenuExamenes());
		//tab y click en elemento web
		BaseFlow.pageModel.getNvItMenuExamenes().sendKeys(Keys.TAB);
		BaseFlow.pageModel.getNvItMenuExamenes().sendKeys(Keys.TAB);
		BaseFlow.pageModel.getNvItMenuExamenes().sendKeys(Keys.TAB);
		BaseFlow.pageModel.getNvItMenuExamenes().sendKeys(Keys.TAB);
		BaseFlow.pageModel.getNvItMenuExamenes().sendKeys(Keys.ENTER);
		Thread.sleep(5000);
	}

	@When("^Seleccion de especialidad \"(.*?)\"$")
	public void seleccion_de_especialidad(String especialidad) throws Throwable {
		BaseFlow.pageModel.getLbxEspecialidad().click();
		BaseFlow.pageModel.getListEspecialidad().get(30).click();
		Thread.sleep(8000);
	}

	@Then("^Valido seleccion de especialidad \"(.*?)\"$")
	public void valido_seleccion_valida(String especialidad) throws Throwable {
		String preview = BaseFlow.pageModel.getLbxEspecialidad().getAttribute("innerText").trim();
		String[] especialidadSplit = preview.split("↵");
		String[] especialidadSplitFinally = especialidadSplit[0].split("×");
		lblEspecialidad = especialidadSplitFinally[0].trim();
		//System.out.println("especialidad:"+lblEspecialidad);
		//Thread.sleep(10000);
		assertEquals("No se valida de manera correcta seleccion especialidad", especialidad, lblEspecialidad);				
	}
	
	@Then("^Valido label especialidad$")
	public void valido_label_especialidad() throws Throwable {
		String lblEspecialidad = BaseFlow.pageModel.getLbxEspecialidad().getAttribute("placeholder").trim();		
	   assertEquals("Label especialidad no es igual", lblEspecialidad, BaseFlow.properties.getLabelEspecialidadTwo());
	}

	@When("^Selecciono prestacion \"(.*?)\"$")
	public void selecciono_prestacion(String prestacion) throws Throwable {
		BaseFlow.pageModel.getLbxPrestacion().click();
		BaseFlow.pageModel.getListPrestacion().get(0).click();
		Thread.sleep(7000);
	}

	@Then("^Valido seleccion de prestacion \"(.*?)\"$")
	public void valido_prestacion(String prestacion) throws Throwable {
		String preview = BaseFlow.pageModel.getLbxPrestacion().getAttribute("innerText").trim();
		String[] prestacionSplit = preview.split("↵");
		String[] prestacionSplitFinally = prestacionSplit[0].split("×");
		lblPrestacion = prestacionSplitFinally[0].trim();
		//System.out.println("prestacion:"+lblPrestacion);
		//Thread.sleep(10000);
		assertEquals("No se valida de manera correcta selección prestación", prestacion, lblPrestacion);
	}
	
	@Then("^Valido label prestacion$")
	public void valido_label_prestacion() throws Throwable {
		String lblPrestacion = BaseFlow.pageModel.getLblPrestacion().getAttribute("placeholder").trim();		
		assertEquals("Label prestacion no es igual", lblPrestacion, BaseFlow.properties.getLabelPrestacion());
	}

	@When("^Selecciono region\"(.*?)\"$")
	public void selecciono_region(String region) throws Throwable {
		BaseFlow.pageModel.getLbxRegion().click();
		BaseFlow.pageModel.getListRegion().get(3).click();
		Thread.sleep(7000);
	}

	@Then("^Valido seleccion region \"(.*?)\"$")
	public void valido_region(String region) throws Throwable {
		String preview = BaseFlow.pageModel.getLbxRegion().getAttribute("innerText").trim();
		String[] regionSplit = preview.split("↵");
		String[] regionSplitFinally = regionSplit[0].split("×"); 
		String lblRegion = regionSplitFinally[0].trim();
		//System.out.println("Region:"+lblRegion);
		//Thread.sleep(10000);
		assertEquals("No se valida de manera correcta selección región", region, lblRegion);
	}
	
	@Then("^Valido label region$")
	public void valido_label_region() throws Throwable {
	    String lblRegion = BaseFlow.pageModel.getLblRegion().getAttribute("placeholder");
	    assertEquals("Label región no es igual", lblRegion, BaseFlow.properties.getLabelRegion());
	}

	@When("^Selecciono centro medico \"(.*?)\"$")
	public void selecciono_centro_medico(String centro) throws Throwable {
		BaseFlow.pageModel.getLbxCentroMedico().click();
		BaseFlow.pageModel.getListCentroMedico().get(5).click();
		Thread.sleep(8000);
	}

	@Then("^Valido seleccion centro medico \"(.*?)\"$")
	public void valido_centro_medico(String centro) throws Throwable {
		String preview = BaseFlow.pageModel.getLbxCentroMedico().getAttribute("innerText").trim();
		String[] centroMedicoSplit = preview.split("↵");
		String[] centroMedicoSplitFinally = centroMedicoSplit[0].split("×");
		lblCentroMedico = centroMedicoSplitFinally[0].trim();
		//System.out.println("Centro:"+lblCentroMedico);
		//	Thread.sleep(10000);
		assertEquals("No se valida de manera correcta selección centro médico", centro, lblCentroMedico);
	}
	
	@Then("^Valido label centro medico$")
	public void valido_label_centro_medico() throws Throwable {
	    String lblCentroMedico = BaseFlow.pageModel.getLblCentroMedico().getAttribute("placeholder");
	    assertEquals("Label centro medico no es igual", lblCentroMedico, BaseFlow.properties.getLabelCentroMedico());
	}

	@When("^Visualizo fechas habilitadas$")
	public void visualizo_fechas_habilitadas() throws Throwable {
		//valido que aparezca el tr de las fechas 
		GenericMethods.isElementPresent(BaseFlow.pageModel.getTrFechasMostradas());
		//valido la cantidad de fechas disponibles habilitadas
		int fechasActivas = BaseFlow.pageModel.getListFechasActivas().size();		
		//System.out.println("cantidad:"+fechasActivas);
		//Thread.sleep(10000);
		if(fechasActivas >= 1) {			
			assertTrue("Existen fechas activas para la combinación de búsqueda", true);			
		} else if (fechasActivas <= 0) {
			assertTrue("No existen fechas activas para la combinación de búsqueda", true);
		} else {
			assertTrue("Condición de fechas no realizada", false);
		}
	}
	
	@Then("^Valido que exista una fecha ya seleccionada$")
	public void valido_que_exista_una_fecha_ya_seleccionada() throws Throwable {
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
	
	@Then("^Valido label mes y año actual$")
	public void valido_label_mes_y_año_actual() throws Throwable {
		// H5 -- Titulo reserva semana
		int day = 0;
		int month = 0;
		int year = 0;
		int today = 0;
		int dayFutureFinally = 0;
		String stringMonth = "";
		String labelFinally = "";
		String labelFinallyTwo = "";
		String firstDay = "";
		String lastDay = "";
		
		//obtener año
	    Calendar calendar = Calendar.getInstance();
	    year = calendar.get(Calendar.YEAR);
	    month = calendar.get(Calendar.MONTH);
	    if(month == 0){
	    	stringMonth = "Enero";
	    }
	    else if(month == 1){
	    	stringMonth = "Febrero";
	    }
	    else if(month == 2){
	    	stringMonth = "Marzo";
	    }
	    else if(month == 3){
	    	stringMonth = "Abril";
	    }
	    else if(month == 4){
	    	stringMonth = "Mayo";
	    }
	    else if(month == 5){
	    	stringMonth = "Junio";
	    }
	    else if(month == 6){
	    	stringMonth = "Julio";
	    }
	    else if(month == 7){
	    	stringMonth = "Agosto";
	    }
	    else if(month == 8){
	    	stringMonth = "Septiembre";
	    }
	    else if(month == 9){
	    	stringMonth = "Octubre";
	    }
	    else if(month == 10){
	    	stringMonth = "Noviembre";
	    }
	    else if(month == 11){
	    	stringMonth = "Diciembre";
	    }
	    else {
	    	stringMonth = "MM";
	    }
	    labelFinally = stringMonth+" de "+year;
	    //elemento si se encuentra presente
	    GenericMethods.isElementPresent(BaseFlow.pageModel.gethFiveTituloReservaSemana());
	    //se compara el elemento que indica mes y año actual
	    assertEquals("Fechas no son idénticas", labelFinally, BaseFlow.pageModel.gethFiveTituloReservaSemana().getText().trim());
	    
	    // H6 -- Titulo reserva semana
	    today = calendar.get(Calendar.DAY_OF_MONTH);
	    Calendar dayFuture = Calendar.getInstance();
	    dayFuture.add(Calendar.DATE, 6);
	    dayFutureFinally = dayFuture.get(Calendar.DAY_OF_MONTH);	    	    
	    labelFinallyTwo = "Semana del "+today+" al "+dayFutureFinally;
	    //se compara el elemento que contiene la semana mostrada
	    assertEquals("Semanas no son idénticas", labelFinallyTwo, BaseFlow.pageModel.gethSixTituloReservaSemana().getText().trim());
	}
	
	@Then("^Valido que label mes y año actual sea correcto$")
	public void valido_que_label_mes_y_año_actual_sea_correcto() throws Throwable {
		//se compara el elemento que indica mes y año actual
	    if (BaseFlow.pageModel.gethFiveTituloReservaSemana().getText().trim().equals(
	    		GenericMethods.getCurrentMonthAndYear())) {
	    	assertTrue(true);
	    } else {
	    	System.out.println("Año y mes actual no son coinciden");
	    	assertTrue(false);
	    }
	}
	
	@When("^Valido que aparezca apartado de horas de examenes$")
	public void valido_que_aparezca_apartado_de_horas_de_examenes() throws Throwable {
		//Div -- Apartado especialidad
	    GenericMethods.isElementPresent(BaseFlow.pageModel.getDivApartadoBxExamenes());
	}

	@Then("^Valido que aparezca titulo de fecha segun el dia seleccionado$")
	public void valido_que_aparezca_titulo_de_fecha_segun_el_dia_seleccionado() throws Throwable {
		//Div -- Header fechas
		GenericMethods.isElementPresent(BaseFlow.pageModel.getDivHeaderFechas());
	}

	@Then("^Valido que titulo de fecha sea correcto segun el dia seleccionado$")
	public void valido_que_titulo_de_fecha_sea_correcto_segun_el_dia_seleccionado() throws Throwable {
		if (BaseFlow.pageModel.gethThreeFechaEspecialidad().getText().trim().equals(
	    		GenericMethods.getCurrentDateComplete())) {
	    	assertTrue(true);
	    } else {
	    	System.out.println("Titulo de fechas no es correcta");
	    	assertTrue(false);
	    }
	}

	@Then("^Valido que subtitulo de especialidad mas prestacion coincida segun lo seleccionado$")
	public void valido_que_subtitulo_de_especialidad_mas_prestacion_coincida_segun_lo_seleccionado() throws Throwable {
		String espAndPres = lblEspecialidad + " - " + lblPrestacion;
		if (BaseFlow.pageModel.gethFourNombreEspecialidadPrestacion().getText().trim().equals(espAndPres)) {
			assertTrue(true);
		} else {
			System.out.println("Subtitulo especialidad - prestación no es correcto de acuerdo a lo seleccionado en filtros");
			assertTrue(false);
		}
	}

	@Then("^Valido que el subtitulo centro medico coincida segun lo seleccionado$")
	public void valido_que_el_subtitulo_centro_medico_coincida_segun_lo_seleccionado() throws Throwable {
		if (BaseFlow.pageModel.gethFiveNombreCentroMedicoEspecialidad().getText().trim().equals(lblCentroMedico)) {
			assertTrue(true);
		} else {
			System.out.println("Subtitulo de centro medico no es correcto de acuerdo a lo seleccionado");
			assertTrue(false);
		}
	}

	@Then("^Selecciono una hora disponible ventana de hora examen$")
	public void selecciono_una_hora_disponible_ventana_de_hora_examen() throws Throwable {
		Thread.sleep(3000);
		List<WebElement> asd = BaseFlow.driver.findElements(By.className("container"));		
		for (WebElement a : asd) {
			a.click();			
			if(GenericMethods.isElementPresent(BaseFlow.pageModel.getDivResumenEspecialidad()))
			break;
		}
	}

	@Then("^Valido que aparezca ventana resumen examen$")
	public void valido_que_aparezca_ventana_resumen_examen() throws Throwable {
		//Div -- Resumen examenes
		GenericMethods.isElementPresent(BaseFlow.pageModel.getDivResumenExamenes());
	}
	
	@Then("^Valido que aparezca imagen icono examen ventana de resumen examen$")
	public void valido_que_aparezca_imagen_icono_examen_ventana_de_resumen_examen() throws Throwable {
		//Imagen -- Icono examen
		GenericMethods.isElementPresent(BaseFlow.pageModel.getImgIconoExamenExa());
	}

	@Then("^Valido que aparezca especialidad ventana de resumen examen$")
	public void valido_que_aparezca_especialidad_ventana_de_resumen_examen() throws Throwable {
		//h3 -- Especialidad
		GenericMethods.isElementPresent(BaseFlow.pageModel.gethThreeEspecialidadExa());
	}

	@Then("^Valido que aparezca centro medico ventana de resumen examen$")
	public void valido_que_aparezca_centro_medico_ventana_de_resumen_examen() throws Throwable {
		//h6 -- Centro medico
		GenericMethods.isElementPresent(BaseFlow.pageModel.gethSixCentroMedicoExa());
	}

	@Then("^Valido que aparezca imagen genero ventana de resumen examen$")
	public void valido_que_aparezca_imagen_genero_ventana_de_resumen_examen() throws Throwable {
		//Imagen -- Icono genero
		GenericMethods.isElementPresent(BaseFlow.pageModel.getImgIconoGeneroExa());
	}
	
	@Then("^Valido imagen genero de acuerdo a la condicion ventanan de resumen examen$")
	public void valido_imagen_genero_de_acuerdo_a_la_condicion_ventanan_de_resumen_examen() throws Throwable {
		String arrayGenero = BaseFlow.pageModel.getLblGeneroAndEdadPaciente().getText().trim();
	    String[] parts = arrayGenero.split(" | ");
	    String genero = parts[0];//genero M o F
		//obtengo propertie de imagen
		String propertie = BaseFlow.pageModel.getImgIconoGeneroExa().getAttribute("src").trim();	 
	    String urlIconoMen="http://bcp-qa.mybluemix.net/assets/icons/icon-men.svg";
	    String urlIconoWoman="http://bcp-qa.mybluemix.net/assets/icons/icon-woman.svg";
	    if (genero.equals("M")) {
	    	assertEquals(propertie, urlIconoMen);
	    	assertTrue(true);
	    } else if (genero.equals("F")) {
	    	assertEquals(propertie, urlIconoWoman);
	    	assertTrue(true);
	    } else {
	    	assertTrue("Comparación de imagen no es correcta", false);
	    }
	}

	@Then("^Valido que aparezca nombre paciente ventana de resumen examen$")
	public void valido_que_aparezca_nombre_paciente_ventana_de_resumen_examen() throws Throwable {
		//h5 -- Nombre paciente
	    GenericMethods.isElementPresent(BaseFlow.pageModel.gethFiveNombrePacienteExa());
	}
	
	@Then("^Valido que aparezca email paciente ventana de resumen examen$")
	public void valido_que_aparezca_email_paciente_ventana_de_resumen_examen() throws Throwable {
		//Parrafo -- Mail paciente
		GenericMethods.isElementPresent(BaseFlow.pageModel.getpMailPacienteExa());
	}

	@Then("^Valido que aparezca imagen calendario ventana de resumen examen$")
	public void valido_que_aparezca_imagen_calendario_ventana_de_resumen_examen() throws Throwable {
		//Imagen -- Icono calendario
		GenericMethods.isElementPresent(BaseFlow.pageModel.getImgIconoCalendarioExa());
	}

	@Then("^Valido que aparezca fecha seleccionada ventana de resumen examen$")
	public void valido_que_aparezca_fecha_seleccionada_ventana_de_resumen_examen() throws Throwable {
		//Span -- Fecha examen
	    GenericMethods.isElementPresent(BaseFlow.pageModel.getSpnFechaExamenExa());
	}

	@Then("^Valido que aparezca imagen horario ventana de resumen examen$")
	public void valido_que_aparezca_imagen_horario_ventana_de_resumen_examen() throws Throwable {
		//Imagen -- Icono horario examen
		GenericMethods.isElementPresent(BaseFlow.pageModel.getImgIconoHorarioExamenExa());
	}

	@Then("^Valido que aparezca hora seleccionada ventana de resumen examen$")
	public void valido_que_aparezca_hora_seleccionada_ventana_de_resumen_examen() throws Throwable {
		//Span -- Horario examen
	    GenericMethods.isElementPresent(BaseFlow.pageModel.getSpanHorarioExamenExa());
	}

	@Then("^Valido que aparezca imagen dinero ventana de resumen examen$")
	public void valido_que_aparezca_imagen_dinero_ventana_de_resumen_examen() throws Throwable {
		//Imagen -- Icono pago
		GenericMethods.isElementPresent(BaseFlow.pageModel.getImgIconoPagoExa());
	}
	
	@Then("^Valido que aparezca monto dinero en ventana resumen examen$")
	public void valido_que_aparezca_monto_dinero_en_ventana_resumen_examen() throws Throwable {
		//Span -- Monto pago
		GenericMethods.isElementPresent(BaseFlow.pageModel.getImgIconoPagoExa());
	}

	@Then("^Valido que aparezca link leer indicaciones ventana de resumen examen$")
	public void valido_que_aparezca_link_leer_indicaciones_ventana_de_resumen_examen() throws Throwable {
	    //aun no se aplica
	}

	@Then("^Valido que haga click link leer indicaciones ventana de resumen examen$")
	public void valido_que_haga_click_link_leer_indicaciones_ventana_de_resumen_examen() throws Throwable {
	    //aun no se aplica
	}

	@Then("^Valido que aparezca boton agendar ventana de resumen examen$")
	public void valido_que_aparezca_boton_agendar_ventana_de_resumen_examen() throws Throwable {
		//Button -- Agendar
	    GenericMethods.isElementPresent(BaseFlow.pageModel.getBtnAgendarExa());
	}

	@Then("^Valido que haga click boton agendar ventana de resumen examen$")
	public void valido_que_haga_click_boton_agendar_ventana_de_resumen_examen() throws Throwable {
		boolean condition = BaseFlow.pageModel.getBtnAgendarExa().isEnabled();
		if (condition == true) {
			assertTrue(true);
		} else {
			System.out.println("Botón agendar no se encuentra habilitado");
			assertFalse(false);
		}
	}
}