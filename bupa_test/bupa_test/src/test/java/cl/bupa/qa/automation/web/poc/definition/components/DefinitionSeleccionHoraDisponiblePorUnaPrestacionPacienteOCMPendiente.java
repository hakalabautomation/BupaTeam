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

public class DefinitionSeleccionHoraDisponiblePorUnaPrestacionPacienteOCMPendiente {
	
	@Given("^Realizar click boton de agendar hora$")
	public void realizar_click_boton_de_agendar_hora() throws Throwable {
		List<WebElement> content = BaseFlow.driver.findElements(By.xpath("//*[@id=\"0\"]/div/div[4]/div/app-table-exams/table/tbody/tr/td[5]/div/ul/li[1]"));
		content.get(0).click();
		//tiempo de espera
		Thread.sleep(5000);
	}

	@When("^Valido que se visualice la ventana leer indicaciones seleccion hora$")
	public void valido_que_se_visualice_la_ventana_leer_indicaciones_seleccion_hora() throws Throwable {
		// Div -- Leer indicaciones
		GenericMethods.isElementPresent(BaseFlow.pageModel.getDivLeerIndicaciones());
	}

	@When("^Valido que se visualice el titulo leer indicaciones seleccion hora$")
	public void valido_que_se_visualice_el_titulo_leer_indicaciones_seleccion_hora() throws Throwable {
		// H5 -- Leer indicaciones
	    GenericMethods.isElementPresent(BaseFlow.pageModel.gethFiveTituloLeerIndicaciones());
	}

	@When("^Valido que titulo leer indicaciones sea el correcto seleccion hora$")
	public void valido_que_titulo_leer_indicaciones_sea_el_correcto_seleccion_hora() throws Throwable {
		if (BaseFlow.pageModel.gethFiveTituloLeerIndicaciones().getAttribute("innerText").trim().equals(
	    		BaseFlow.properties.getLabelLeerIndicaciones())) {
	    	assertTrue(true);
	    } else {
	    	System.out.println("Título leer indicaciones no es correcto");
	    	assertTrue(false);
	    }
	}

	@When("^Valido que se visualice listado de indicaciones seleccion hora$")
	public void valido_que_se_visualice_listado_de_indicaciones_seleccion_hora() throws Throwable {
		// Div -- Listado leer indicaciones
		GenericMethods.isElementPresent(BaseFlow.pageModel.getDivListadoLeerIndicaciones());
	}

	@When("^Valido que se visualice el boton anular reserva seleccion hora$")
	public void valido_que_se_visualice_el_boton_anular_reserva_seleccion_hora() throws Throwable {
		// Button -- Anular reserva
		GenericMethods.isElementPresent(BaseFlow.pageModel.getBtnAnularReserva());
	}

	@When("^Valido que se visualice el boton he leido las indicaciones seleccion hora$")
	public void valido_que_se_visualice_el_boton_he_leido_las_indicaciones_seleccion_hora() throws Throwable {
		// Button -- He leido las indicaciones
		GenericMethods.isElementPresent(BaseFlow.pageModel.getBtnHeLeidoLasIndicaciones());
	}

	@When("^Valido que boton he leido las indicaciones sea correcto seleccion hora$")
	public void valido_que_boton_he_leido_las_indicaciones_sea_correcto_seleccion_hora() throws Throwable {
		if (BaseFlow.pageModel.getBtnHeLeidoLasIndicaciones().getAttribute("innerText").trim().equals(
	    		BaseFlow.properties.getLabelHeLeidoLasIndicaciones())) {
	    	assertTrue(true);
	    } else {
	    	System.out.println("Botón he leido las indiaciones no es correcto");
	    	assertTrue(false);
	    }
	}

	@When("^Valido que el boton he leido las indicaciones se encuentre habilitado seleccion hora$")
	public void valido_que_el_boton_he_leido_las_indicaciones_se_encuentre_habilitado_seleccion_hora() throws Throwable {
	    boolean condition = BaseFlow.pageModel.getBtnHeLeidoLasIndicaciones().isEnabled();
	    if (condition == true) {
	    	assertTrue(true);
	    } else {
	    	System.out.println("Botón he leido las indicaciones no se encuentra habilitado");
	    	assertTrue(false);
	    }
	}

	@Then("^Realizar click en he leido las indicaciones seleccion hora$")
	public void realizar_click_en_he_leido_las_indicaciones_seleccion_hora() throws Throwable {
		BaseFlow.pageModel.getBtnHeLeidoLasIndicaciones().click();
		//tiempo de espera
		Thread.sleep(5000);
	}

	@When("^Valido que se visualice ventana reserva exitosa$")
	public void valido_que_se_visualice_ventana_reserva_exitosa() throws Throwable {
		// Modal -- Reserva exitosa
	    GenericMethods.isElementPresent(BaseFlow.pageModel.getMdlRutFail());
	}

	@When("^Valido que se visualice titulo reserva exitosa$")
	public void valido_que_se_visualice_titulo_reserva_exitosa() throws Throwable {
		// Label -- Reserva exitosa
		GenericMethods.isElementPresent(BaseFlow.pageModel.getLblPacienteFail());
	}

	@When("^Valido que titulo sea correcto ventana reserva exitosa$")
	public void valido_que_titulo_sea_correcto_ventana_reserva_exitosa() throws Throwable {
	    if (BaseFlow.pageModel.getLblPacienteFail().getAttribute("innerText").trim().equals(
	    		BaseFlow.properties.getLabelMensajeDeReservaExito())) {
	    	assertTrue(true);
	    } else {
	    	System.out.println("Título reserva de hora con éxito no es correcto");
	    	assertTrue(false);
	    }
	}

	@When("^Valido que se visualice imagen check ventana reserva exitosa$")
	public void valido_que_se_visualice_imagen_check_ventana_reserva_exitosa() throws Throwable {
		// Imagen -- Icono check
		GenericMethods.isElementPresent(BaseFlow.pageModel.getImgIconoFail());
	}

	@When("^Valido que imagen check sea correcto ventana reserva exitosa$")
	public void valido_que_imagen_check_sea_correcto_ventana_reserva_exitosa() throws Throwable {
		String imagenSrc = "http://bcp-qa.mybluemix.net/assets/icons/icon-exit.svg";
	    if (BaseFlow.pageModel.getImgIconoFail().getAttribute("src").trim().equals(imagenSrc)) {
	    	assertTrue(true);
	    } else {
	    	System.out.println("Imagen de error mostrada no es correcto");
	    	assertTrue(false);
	    }
	}

	@When("^Valido que se visualice mensaje ventana reserva exitosa$")
	public void valido_que_se_visualice_mensaje_ventana_reserva_exitosa() throws Throwable {
		// Parrafo -- mensaje de hora anulado
		GenericMethods.isElementPresent(BaseFlow.pageModel.getPrfMensajeFail()); 
	}

	@When("^Valido que se visualice boton aceptar ventana reserva exitosa$")
	public void valido_que_se_visualice_boton_aceptar_ventana_reserva_exitosa() throws Throwable {
		// Button -- Aceptar fail
		GenericMethods.isElementPresent(BaseFlow.pageModel.getBtnAceptarFail());
	}

	@When("^Valido que boton aceptar sea el correcto reserva exitosa$")
	public void valido_que_boton_aceptar_sea_el_correcto_reserva_exitosa() throws Throwable {
		if (BaseFlow.pageModel.getBtnAceptarFail().getAttribute("innerText").trim().equals(
	    		BaseFlow.properties.getLabelAceptar())) {
	    	assertTrue(true);
	    } else {
	    	System.out.println("Botón aceptar no es correcto");
	    	assertTrue(false);
	    }
	}

	@When("^Valido que boton aceptar se encuentre habilitado ventana reserva exitosa$")
	public void valido_que_boton_aceptar_se_encuentre_habilitado_ventana_reserva_exitosa() throws Throwable {
		boolean condition = BaseFlow.pageModel.getBtnAceptarFail().isEnabled();
	    if (condition == true) {
	    	assertTrue(true);
	    } else {
	    	System.out.println("Botón aceptar no se encuentra habilitado");
	    }
	}

	@When("^Realizar click boton aceptar ventana reserva exitosa$")
	public void realizar_click_boton_aceptar_ventana_reserva_exitosa() throws Throwable {
		BaseFlow.pageModel.getBtnAceptarFail().click();
		//tiempo de espera
		Thread.sleep(5000);
	}

	@Then("^Valido que visualizar nuevamente apartado informacion de paciente$")
	public void valido_que_visualizar_nuevamente_apartado_informacion_de_paciente() throws Throwable {
		// Div -- Seccion informacion paciente
		GenericMethods.isElementPresent(BaseFlow.pageModel.getDivSeccionInformacionPaciente().get(0)); 
	}

	@Then("^Valido que visualizar nuevamente ventana ocm pendientes$")
	public void valido_que_visualizar_nuevamente_ventana_ocm_pendientes() throws Throwable {
		// Div -- Ocm pendientes paciente
		GenericMethods.isElementPresent(BaseFlow.pageModel.getDivOcmPendientesPacienteSeccionGeneral().get(0));
	}
}