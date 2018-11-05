package cl.bupa.qa.automation.web.poc.definition.components;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import cl.bupa.qa.automation.web.business.flow.BaseFlow;
import cl.bupa.qa.automation.web.poc.util.GenericMethods;
import cucumber.api.java.en.Then;

public class DefinitionSeleccionHoraOcupadaPorUnaPrestacionPacienteOCMPendiente {
	
	@Then("^Selecciono boton agendar hora$")
	public void selecciono_boton_agendar_hora() throws Throwable {
		List<WebElement> content = BaseFlow.driver.findElements(By.xpath("//*[@id=\"0\"]/div/div[4]/div/app-table-exams/table/tbody/tr/td[5]/div/ul/li[1]"));
		content.get(0).click();
		//tiempo de espera
		Thread.sleep(5000);
	}

	@Then("^Valido que se visualice ventana hora ocupada$")
	public void valido_que_se_visualice_ventana_hora_ocupada() throws Throwable {
		// Modal -- Hora no agendada
	    GenericMethods.isElementPresent(BaseFlow.pageModel.getMdlRutFail());
	}

	@Then("^Valido que se visualice titulo ventana hora ocupada$")
	public void valido_que_se_visualice_titulo_ventana_hora_ocupada() throws Throwable {
		// Label -- anular cita
		GenericMethods.isElementPresent(BaseFlow.pageModel.getLblPacienteFail());

	}

	@Then("^Valido que titulo sea correcto ventana hora ocupada$")
	public void valido_que_titulo_sea_correcto_ventana_hora_ocupada() throws Throwable {
	    if (BaseFlow.pageModel.getLblPacienteFail().getAttribute("innerText").trim().equals(
	    		BaseFlow.properties.getLabelMensajeDeHoraNoAgendada())) {
	    	assertTrue(true);
	    } else {
	    	System.out.println("Título de hora no agendad no es correcto");
	    	assertTrue(false);
	    }
	}

	@Then("^Valido que se visualice imagen de error ventana hora ocupada$")
	public void valido_que_se_visualice_imagen_de_error_ventana_hora_ocupada() throws Throwable {
		// Imagen -- Icono check
		GenericMethods.isElementPresent(BaseFlow.pageModel.getImgIconoFail());
	}

	@Then("^Valido que la imagen de error sea la correcta ventana hora ocupada$")
	public void valido_que_la_imagen_de_error_sea_la_correcta_ventana_hora_ocupada() throws Throwable {
	    String imagenSrc = "http://bcp-qa.mybluemix.net/assets/icons/icon-error.svg";
	    if (BaseFlow.pageModel.getImgIconoFail().getAttribute("src").trim().equals(imagenSrc)) {
	    	assertTrue(true);
	    } else {
	    	System.out.println("Imagen de error mostrada no es correcto");
	    	assertTrue(false);
	    }
	}

	@Then("^Valido que se visualice mensaje error ventana hora ocupada$")
	public void valido_que_se_visualice_mensaje_error_ventana_hora_ocupada() throws Throwable {
		// Parrafo -- mensaje de hora anulado
		GenericMethods.isElementPresent(BaseFlow.pageModel.getPrfMensajeFail());
	}
	
	@Then("^Valido que aparezca boton aceptar ventana hora ocupada$")
	public void valido_que_aparezca_boton_aceptar_ventana_hora_ocupada() throws Throwable {
		// Button -- Aceptar fail
		GenericMethods.isElementPresent(BaseFlow.pageModel.getBtnAceptarFail());
	}

	@Then("^Valido que boton aceptar sea correcto ventana hora ocupada$")
	public void valido_que_boton_aceptar_sea_correcto_ventana_hora_ocupada() throws Throwable {
		if (BaseFlow.pageModel.getBtnAceptarFail().getAttribute("innerText").trim().equals(
	    		BaseFlow.properties.getLabelAceptar())) {
	    	assertTrue(true);
	    } else {
	    	System.out.println("Botón aceptar no es correcto");
	    	assertTrue(false);
	    }
	}

	@Then("^Valido que boton aceptar se encuentre habilitado ventana hora ocupada$")
	public void valido_que_boton_aceptar_se_encuentre_habilitado_ventana_hora_ocupada() throws Throwable {
		boolean condition = BaseFlow.pageModel.getBtnAceptarFail().isEnabled();
	    if (condition == true) {
	    	assertTrue(true);
	    } else {
	    	System.out.println("Botón aceptar no se encuentra habilitado");
	    }
	}

	@Then("^Realizar click boton aceptar ventana hora ocupada$")
	public void realizar_click_boton_aceptar_ventana_hora_ocupada() throws Throwable {
		BaseFlow.pageModel.getBtnAceptarFail().click();
		//tiempo de espera
		Thread.sleep(5000);
	}

	@Then("^Valido que muestre nuevamente ventana de OCM pendientes de paciente$")
	public void valido_que_muestre_nuevamente_ventana_de_OCM_pendientes_de_paciente() throws Throwable {
		// Div -- Ocm pendientes paciente
		GenericMethods.isElementPresent(BaseFlow.pageModel.getDivOcmPendientesPacienteSeccionGeneral().get(0));
	}
}
