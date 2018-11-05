package cl.bupa.qa.automation.web.poc.definition.steps;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import cl.bupa.qa.automation.web.business.flow.BaseFlow;
import cl.bupa.qa.automation.web.poc.util.GenericMethods;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class DefinitionStepAgendamientoNuevaReservaHoraPorExamenEspecialidadRayos {
	
	private static String lblEspecialidad;
	private static String lblPrestacion;
	private static String lblRegion;
	private static String lblCentroMedico;
	
	@Given("^Valido visualizacion boton nueva reserva de hora$")
	public void valido_visualizacion_boton_nueva_reserva_de_hora() throws Throwable {
		// Button -- Nueva reserva hora
		GenericMethods.isElementPresent(BaseFlow.pageModel.getBtnNuevaReservaHora());
	}

	@Given("^Valido boton nueva reserva de hora se encuentre habilitado$")
	public void valido_boton_nueva_reserva_de_hora_se_encuentre_habilitado() throws Throwable {
	    boolean condition = BaseFlow.pageModel.getBtnNuevaReservaHora().isEnabled();
	    if (condition == true) {
	    	assertTrue(true);
	    } else {
	    	System.out.println("Botón nueva reserva de hora no se encuentra habilitado");
	    }
	}

	@When("^Presiono click en boton nueva reserva de hora$")
	public void presiono_click_en_boton_nueva_reserva_de_hora() throws Throwable {
		// Button -- Nueva reserva hora
		BaseFlow.pageModel.getBtnNuevaReservaHora().click();
	}

	@Then("^Eligo tab examenes$")
	public void eligo_tab_examenes() throws Throwable {
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
		//tiempo de espera explicito
		Thread.sleep(5000);
	}

	@Then("^Dar click combobox especialidad$")
	public void dar_click_combobox_especialidad() throws Throwable {
		// ListBox -- EspecialidadMedico
		BaseFlow.pageModel.getLbxEspecialidad().click();
	}

	@Then("^Seleccion de la especialidad \"(.*?)\"$")
	public void seleccion_de_la_especialidad(String seleccionEspecialidad) throws Throwable {
		// List -- Especialidad
		BaseFlow.pageModel.getListEspecialidad().get(Integer.parseInt(seleccionEspecialidad)).click();
		//tiempo explicito de espera
		Thread.sleep(8000);
	}

	@Then("^Valido seleccion de la especialidad \"(.*?)\"$")
	public void valido_seleccion_de_la_especialidad(String especialidad) throws Throwable {
		String preview = BaseFlow.pageModel.getLbxEspecialidad().getAttribute("innerText").trim();
		String[] especialidadSplit = preview.split("↵");
		String[] especialidadSplitFinally = especialidadSplit[0].split("×");
		lblEspecialidad = especialidadSplitFinally[0].trim();
		if (lblEspecialidad.equals(especialidad)) {
			assertTrue(true);
		} else {
			System.out.println("Selección especialidad no es correcto");
			assertTrue(false);
		}
	}

	@Then("^Dar click combobox prestacion$")
	public void dar_click_combobox_prestacion() throws Throwable {
		// ListBox -- Prestacion
		BaseFlow.pageModel.getLbxPrestacion().click();
	}

	@Then("^Seleccion de la prestacion \"(.*?)\"$")
	public void seleccion_de_la_prestacion(String seleccionPrestacion) throws Throwable {
		// List -- Prestacion
		BaseFlow.pageModel.getListPrestacion().get(Integer.parseInt(seleccionPrestacion)).click();
		//tiempo explicito de espera
		Thread.sleep(6000);
	}

	@Then("^Valido seleccion de la prestacion \"(.*?)\"$")
	public void valido_seleccion_de_la_prestacion(String prestacion) throws Throwable {
		String preview = BaseFlow.pageModel.getLbxPrestacion().getAttribute("innerText").trim();
		String[] prestacionSplit = preview.split("↵");
		String[] prestacionSplitFinally = prestacionSplit[0].split("×");
		lblPrestacion = prestacionSplitFinally[0].trim();
		if (lblPrestacion.equals(prestacion)) {
			assertTrue(true);
		} else {
			System.out.println("Selección prestación no es correcto");
			assertTrue(false);
		}
	}

	@Then("^Dar click combobox region$")
	public void dar_click_combobox_region() throws Throwable {
		// ListBox -- Region
		BaseFlow.pageModel.getLbxRegion().click();
	}

	@Then("^Seleccion de la region \"(.*?)\"$")
	public void seleccion_de_la_region(String seleccionRegion) throws Throwable {
		// List -- Region
		BaseFlow.pageModel.getListRegion().get(Integer.parseInt(seleccionRegion)).click();
		//tiempo explicito de espera
		Thread.sleep(6000);
	}

	@Then("^Valido seleccion de la region \"(.*?)\"$")
	public void valido_seleccion_de_la_region(String region) throws Throwable {
		String preview = BaseFlow.pageModel.getLbxRegion().getAttribute("innerText").trim();
		String[] regionSplit = preview.split("↵");
		String[] regionSplitFinally = regionSplit[0].split("×"); 
		lblRegion = regionSplitFinally[0].trim();
		if (lblRegion.equals(region)) {
			assertTrue(true);
		} else {
			System.out.println("Selección región no es correcto");
			assertTrue(false);
		}
	}

	@Then("^Dar click combobox centro medico$")
	public void dar_click_combobox_centro_medico() throws Throwable {
		// ListBox -- Centro medico
		BaseFlow.pageModel.getLbxCentroMedico().click();
	}

	@Then("^Seleccion del centro medico \"(.*?)\"$")
	public void seleccion_del_centro_medico(String seleccionCentroMedico) throws Throwable {
		// List -- Centro medico
		BaseFlow.pageModel.getListCentroMedico().get(Integer.parseInt(seleccionCentroMedico)).click();
		//tiempo explicito de espera
		Thread.sleep(8000);
	}

	@Then("^Valido seleccion del centro medico \"(.*?)\"$")
	public void valido_seleccion_del_centro_medico(String centroMedico) throws Throwable {
		String preview = BaseFlow.pageModel.getLbxCentroMedico().getAttribute("innerText").trim();
		String[] centroMedicoSplit = preview.split("↵");
		String[] centroMedicoSplitFinally = centroMedicoSplit[0].split("×");
		lblCentroMedico = centroMedicoSplitFinally[0].trim();
		if (lblCentroMedico.equals(centroMedico)) {
			assertTrue(true);
		} else {
			System.out.println("Selección centro médico no es correcto");
			assertTrue(false);
		}
	}

	@Then("^Seleccion de una hora$")
	public void seleccion_de_una_hora() throws Throwable {
		Thread.sleep(3000);
		List<WebElement> asd = BaseFlow.driver.findElements(By.className("container"));		
		for (WebElement a : asd) {
			a.click();			
			if(GenericMethods.isElementPresent(BaseFlow.pageModel.getDivResumenEspecialidad()))
			break;
		}
	}

	@Then("^Valido visualizacion boton agendar hora$")
	public void valido_visualizacion_boton_agendar_hora() throws Throwable {
	    GenericMethods.isElementPresent(BaseFlow.pageModel.getBtnAgendarExa());
	}
	
	@Then("^Dar click en boton agendar hora$")
	public void dar_click_en_boton_agendar_hora() throws Throwable {
		// Button -- Agendar
		BaseFlow.pageModel.getBtnAgendarExa().click();
		//tiempo de espera explicito
		Thread.sleep(5000);
	}
	
	@Then("^Valido visualizacion de ventana leer indicaciones$")
	public void valido_visualizacion_de_ventana_leer_indicaciones() throws Throwable {
		// Div -- Leer indicaciones
		GenericMethods.isElementPresent(BaseFlow.pageModel.getDivLeerIndicaciones());
	}

	@Then("^Valido visualizacion del boton anular reserva ventana leer indicaciones$")
	public void valido_visualizacion_del_boton_anular_reserva_ventana_leer_indicaciones() throws Throwable {
		// Button -- Anular reserva
		GenericMethods.isElementPresent(BaseFlow.pageModel.getBtnAnularReserva());
	}

	@Then("^Valido boton de anular reserva se encuentre habilitado ventana leer indicaciones$")
	public void valido_boton_de_anular_reserva_se_encuentre_habilitado_ventana_leer_indicaciones() throws Throwable {
	    boolean condition = BaseFlow.pageModel.getBtnAnularReserva().isEnabled();
	    if (condition == true) {
	    	assertTrue(true);
	    } else {
	    	System.out.println("Botón anular reserva no se encuentra habilitado");
	    	assertTrue(false);
	    }
	}

	@Then("^Dar click boton de anular reserva ventana leer indicaciones$")
	public void dar_click_boton_de_anular_reserva_ventana_leer_indicaciones() throws Throwable {
		// Button -- Anular reserva
		BaseFlow.pageModel.getBtnAnularReserva().click();
		//tiempo de espera explicito
		Thread.sleep(5000);
	}

	@Then("^Valido visualizacion ventana confirmacion anular cita$")
	public void valido_visualizacion_ventana_confirmacion_anular_cita() throws Throwable {
		// Modal -- Anular cita
		GenericMethods.isElementPresent(BaseFlow.pageModel.getMdlRutFail());
	}

	@Then("^Valido visualizacion boton aceptar ventana confirmacion anular cita$")
	public void valido_visualizacion_boton_aceptar_ventana_confirmacion_anular_cita() throws Throwable {
		// Button -- Aceptar fail
		GenericMethods.isElementPresent(BaseFlow.pageModel.getBtnAceptarFail());
	}

	@Then("^Valido boton aceptar se encuentre habilitado ventana confirmacion anular cita$")
	public void valido_boton_aceptar_se_encuentre_habilitado_ventana_confirmacion_anular_cita() throws Throwable {
		boolean condition = BaseFlow.pageModel.getBtnAceptarFail().isEnabled();
		if (condition == true) {
			assertTrue(true);
		} else {
			System.out.println("Botón aceptar se encuentra habilitado");
			assertTrue(false);
		}
	}

	@Then("^Dar click boton aceptar ventana confirmacion anular cita$")
	public void dar_click_boton_aceptar_ventana_confirmacion_anular_cita() throws Throwable {
		// Button -- Aceptar fail
		BaseFlow.pageModel.getBtnAceptarFail().click();
		//tiempo de espera explicito
		Thread.sleep(6000);
	}
	
	@Then("^Seleccion de una hora nuevamente$")
	public void seleccion_de_una_hora_nuevamente() throws Throwable {
		Thread.sleep(2000);
		List<WebElement> asd = BaseFlow.driver.findElements(By.className("container"));		
		for (WebElement a : asd) {
			a.click();			
			if(GenericMethods.isElementPresent(BaseFlow.pageModel.getDivResumenEspecialidad()))
			break;
		}
	}

	@Then("^Dar click en boton agendar hora nuevamente$")
	public void dar_click_en_boton_agendar_hora_nuevamente() throws Throwable {
		// Button -- Agendar
		BaseFlow.pageModel.getBtnAgendarExa().click();
		//tiempo de espera explicito
		Thread.sleep(5000);
	}

	@Then("^Dar click en boton he leido las indicaciones nuevamente$")
	public void dar_click_en_boton_he_leido_las_indicaciones_nuevamente() throws Throwable {
		// Button -- Anular reserva
		BaseFlow.pageModel.getBtnAnularReserva().click();
		//tiempo de espera explicito
		Thread.sleep(5000);
	}

	@Then("^Valido visualizacion ventana confirmacion hora reservada con exito$")
	public void valido_visualizacion_ventana_confirmacion_hora_reservada_con_exito() throws Throwable {
		// Modal -- Confirmación reserva de hora
		GenericMethods.isElementPresent(BaseFlow.pageModel.getMdlRutFail());
	}

	@Then("^Valido visualizacion boton aceptar ventana confirmacion hora reservada con exito$")
	public void valido_visualizacion_boton_aceptar_ventana_confirmacion_hora_reservada_con_exito() throws Throwable {
		// Button -- Aceptar
		GenericMethods.isElementPresent(BaseFlow.pageModel.getBtnAceptarFail());
	}

	@Then("^Valido boton aceptar se encuentre habilitado ventana confirmacion hora reservada con exito$")
	public void valido_boton_aceptar_se_encuentre_habilitado_ventana_confirmacion_hora_reservada_con_exito() throws Throwable {
	    boolean condition = BaseFlow.pageModel.getBtnAceptarFail().isEnabled();
	    if (condition == true) {
	    	assertTrue(true);
	    } else {
	    	System.out.println("Botón aceptar no se encuentra habilitado");
	    	assertTrue(false);
	    }
	}

	@Then("^Dar click en boton aceptar ventana confirmacion hora reservada con exito$")
	public void dar_click_en_boton_aceptar_ventana_confirmacion_hora_reservada_con_exito() throws Throwable {
		// Button -- Aceptar
		BaseFlow.pageModel.getBtnAceptarFail().click();
		//tiempo de espera explicito
		Thread.sleep(1000);
	}

	@Then("^Valido visualizacion menu inicial principal$")
	public void valido_visualizacion_menu_inicial_principal() throws Throwable {
		// Div - Menu inicial principal
		GenericMethods.isElementPresent(BaseFlow.pageModel.getDivMenuInicialPrincipal());
	}
}