package cl.bupa.qa.automation.web.poc.definition.components;

import static org.junit.jupiter.api.Assertions.assertTrue;

import cl.bupa.qa.automation.web.business.flow.BaseFlow;
import cl.bupa.qa.automation.web.poc.util.GenericMethods;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class DefinitionComponentAgendamientoHoraPorExamenSeleccionOpcionMasHorasDisponiblePorUnaPrestacionPacienteOCMPendiente {

	@Given("^Presiono boton he leido las indicaciones$")
	public void presiono_boton_he_leido_las_indicaciones() throws Throwable {
		// Button -- He leido las indicaciones
		BaseFlow.pageModel.getBtnHeLeidoLasIndicaciones().click();
		//tiempo explicito
		Thread.sleep(5000);
	}

	@When("^Valido visualizacion ventana emergente reserva de hora con exito$")
	public void valido_visualizacion_ventana_emergente_reserva_de_hora_con_exito() throws Throwable {
		// Modal -- Reserva hora exitosa
		GenericMethods.isElementPresent(BaseFlow.pageModel.getMdlRutFail());
	}

	@When("^Valido visualizacion titulo reserva de hora con exito$")
	public void valido_visualizacion_titulo_reserva_de_hora_con_exito() throws Throwable {
		// Label -- Paciente fail
		GenericMethods.isElementPresent(BaseFlow.pageModel.getLblPacienteFail());
	}

	@When("^Valido titulo reserva de hora con exito sea el correcto$")
	public void valido_titulo_reserva_de_hora_con_exito_sea_el_correcto() throws Throwable {
		if (BaseFlow.pageModel.getLblPacienteFail().getAttribute("innerText").trim().equals(
				BaseFlow.properties.getLabelMensajeDeReservaExito())) {
			assertTrue(true);
		} else {
			System.out.println("Título reserva de hora con éxito no es correcto");
			assertTrue(false);
		}
	}

	@When("^Valido visualizacion imagen check reserva de hora con exito$")
	public void valido_visualizacion_imagen_check_reserva_de_hora_con_exito() throws Throwable {
		// Imagen -- Icono check
		GenericMethods.isElementPresent(BaseFlow.pageModel.getImgIconoFail());
	}

	@When("^Valido visualizacion mensaje sobre reserva de hora con exito$")
	public void valido_visualizacion_mensaje_sobre_reserva_de_hora_con_exito() throws Throwable {
		// Parrafo -- Mensaje
		GenericMethods.isElementPresent(BaseFlow.pageModel.getPrfMensajeFail());
	}

	@When("^Valido visualizacion boton aceptar reserva de hora con exito$")
	public void valido_visualizacion_boton_aceptar_reserva_de_hora_con_exito() throws Throwable {
		// Button -- Aceptar
		GenericMethods.isElementPresent(BaseFlow.pageModel.getBtnAceptarFail());
	}

	@When("^Valido boton aceptar reserva de hora con exito a sea correcto$")
	public void valido_boton_aceptar_reserva_de_hora_con_exito_a_sea_correcto() throws Throwable {
	    if (BaseFlow.pageModel.getBtnAceptarFail().getAttribute("innerText").trim().equals(
	    		BaseFlow.properties.getLabelAceptar())) {
	    	assertTrue(true);
	    } else {
	    	System.out.println("Botón aceptar reserva de hora con éxito no es correcto");
	    	assertTrue(false);
	    }
	}

	@When("^Valido boton aceptar reserva de hora con exito se encuentre habilitado$")
	public void valido_boton_aceptar_reserva_de_hora_con_exito_se_encuentre_habilitado() throws Throwable {
	    boolean condition = BaseFlow.pageModel.getBtnAceptarFail().isEnabled();
	    if (condition == true) {
	    	assertTrue(true);
	    } else {
	    	System.out.println("Botón aceptar reserva de hora con éxito no se encuentra habilitado");
	    	assertTrue(false);
	    }
	}

	@Then("^Presiono boton aceptar reserva de hora con exito$")
	public void presiono_boton_aceptar_reserva_de_hora_con_exito() throws Throwable {
		// Button -- Aceptar
		BaseFlow.pageModel.getBtnAceptarFail().click();
		//tiempo explicito de espera
		Thread.sleep(6000);
	}

	@Then("^Valido visualizacion nuevamente apartado informacion de paciente$")
	public void valido_visualizacion_nuevamente_apartado_informacion_de_paciente() throws Throwable {
		// Div -- Seccion informacion paciente
		if (BaseFlow.pageModel.getDivSeccionInformacionPaciente().size() > 0) {
			assertTrue(true);
		} else {
			System.out.println("No se muestra sección información paciente");
			assertTrue(false);
		}
	}

	@Then("^Valido visualizacion nuevamente tabla de OCM pendientes$")
	public void valido_visualizacion_nuevamente_tabla_de_OCM_pendientes() throws Throwable {
		// Table -- Agendar
		GenericMethods.isElementPresent(BaseFlow.pageModel.getTblAgendar());
	}

	@Then("^Valido visualizacion de ordenes de OCM pendientes$")
	public void valido_visualizacion_de_ordenes_de_OCM_pendientes() throws Throwable {
		// Table -- Cuerpo de ordenes por gestionar
		if (BaseFlow.pageModel.getTbCuerpoOrdenesPorGestionar().size() > 0) {
			assertTrue(true);
		} else {
			System.out.println("No se muestra ordenes OCM pendientes");
			assertTrue(false);
		}
	}
}
