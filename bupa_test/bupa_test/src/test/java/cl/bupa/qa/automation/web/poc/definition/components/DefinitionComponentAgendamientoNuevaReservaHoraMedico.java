package cl.bupa.qa.automation.web.poc.definition.components;

import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import cl.bupa.qa.automation.web.business.flow.BaseFlow;
import cl.bupa.qa.automation.web.poc.util.GenericMethods;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class DefinitionComponentAgendamientoNuevaReservaHoraMedico {
	
	private String value;

	@Given("^Visualizo resumen de consulta por medico$")
	public void visualizo_resumen_de_consulta_por_medico() throws Throwable {
		// Div -- Resumen examenes
		GenericMethods.isElementPresent(BaseFlow.pageModel.getDivResumenExamenes());
	}

	@When("^Hago click en boton agender$")
	public void hago_click_en_boton_agender() throws Throwable {
		BaseFlow.pageModel.getBtnAgendarExa().click();
	}

	@Then("^Valido que se visualice ventana leer indicaciones$")
	public void valido_que_se_visualice_ventana_leer_indicaciones() throws Throwable {
		//tiempo de espera
		Thread.sleep(5000);
		// Div -- Leer indicaciones
		GenericMethods.isElementPresent(BaseFlow.pageModel.getDivLeerIndicaciones());
	}

	@Then("^Valido que se visualice titulo leer indicaciones$")
	public void valido_que_se_visualice_titulo_leer_indicaciones() throws Throwable {
		// H5 -- Leer indicaciones
		GenericMethods.isElementPresent(BaseFlow.pageModel.gethFiveTituloLeerIndicaciones());
	}

	@Then("^Valido que titulo leer indicaciones sea correcto$")
	public void valido_que_titulo_leer_indicaciones_sea_correcto() throws Throwable {
		if (BaseFlow.pageModel.gethFiveTituloLeerIndicaciones().getAttribute("innerText").trim().equals(
				BaseFlow.properties.getLabelLeerIndicaciones())) {
			assertTrue(true);
		} else {
			System.out.println("Titulo leer indicaciones no es correcto");
			assertTrue(false);
		}
	}

	@Then("^Valido que se visualice listado indicaciones$")
	public void valido_que_se_visualice_listado_indicaciones() throws Throwable {
		//Div -- Listado leer indicaciones
		GenericMethods.isElementPresent(BaseFlow.pageModel.getDivListadoLeerIndicaciones());
	}

	@Then("^Valido que se visualice boton he leido las indicaciones$")
	public void valido_que_se_visualice_boton_he_leido_las_indicaciones() throws Throwable {
		//Button -- He leido las indicaciones
		GenericMethods.isElementPresent(BaseFlow.pageModel.getBtnHeLeidoLasIndicaciones());
	}

	@Then("^Valido que boton he leido las indicaciones se encuentre habilitado$")
	public void valido_que_boton_he_leido_las_indicaciones_se_encuentre_habilitado() throws Throwable {
		boolean condition = BaseFlow.pageModel.getBtnHeLeidoLasIndicaciones().isEnabled();
	    if (condition == true) {
	    	assertTrue(true);
	    } else {
	    	System.out.println("Botón he leido las indicaciones no se encuentra habilitado");
			assertFalse(false);
	    }
	}

	@Then("^Valido que se visualice boton anular reserva$")
	public void valido_que_se_visualice_boton_anular_reserva() throws Throwable {
		// Button -- Anular reserva
		GenericMethods.isElementPresent(BaseFlow.pageModel.getBtnAnularReserva());
	}

	@Then("^Valido que boton anular reserva se encuentre habilitado$")
	public void valido_que_boton_anular_reserva_se_encuentre_habilitado() throws Throwable {
		boolean condition = BaseFlow.pageModel.getBtnAnularReserva().isEnabled();
		if (condition == true) {
			assertTrue(true);
		} else {
			System.out.println("Botón anular reserva no se encuentra habilitado");
			assertTrue(false);
		}
	}

	@Then("^Hago click en boton he leido las indicaciones$")
	public void hago_click_en_boton_he_leido_las_indicaciones() throws Throwable {
		BaseFlow.pageModel.getBtnHeLeidoLasIndicaciones().click();
	}

	@Then("^Valido que se visualice ventana emergente reserva exitosa$")
	public void valido_que_se_visualice_ventana_emergente_reserva_exitosa() throws Throwable {
		//tiempo de espera
		Thread.sleep(4000);
		//valido que se encuentre presente
	    GenericMethods.isElementPresent(BaseFlow.pageModel.getMdlRutFail());
	}

	@Then("^Valido que se visualice titulo de reserva exitosa$")
	public void valido_que_se_visualice_titulo_de_reserva_exitosa() throws Throwable {
		//titulo de reserva exitosa
		GenericMethods.isElementPresent(BaseFlow.pageModel.getLblPacienteFail());
	}
	
	@Then("^Valido que titulo reserva exitosa sea correcto$")
	public void valido_que_titulo_reserva_exitosa_sea_correcto() throws Throwable {
	    if (BaseFlow.pageModel.getLblPacienteFail().getText().trim().equals( 
	    		BaseFlow.properties.getLabelMensajeDeReservaExito())) {
	    	assertTrue(true);
	    } else {
	    	System.out.println("Título reserva exitosa no es correcto");
	    	assertTrue(false);
	    }
	}
	
	@Then("^Valido que se visualice imagen check de reserva exitosa$")
	public void valido_que_se_visualice_imagen_check_de_reserva_exitosa() throws Throwable {
		// Imagen -- Icono check
		GenericMethods.isElementPresent(BaseFlow.pageModel.getImgIconoFail());
	}

	@Then("^Valido que se visualice parrafo de reserva exitosa$")
	public void valido_que_se_visualice_parrafo_de_reserva_exitosa() throws Throwable {
		// Parrafo -- Mensaje
		GenericMethods.isElementPresent(BaseFlow.pageModel.getPrfMensajeFail());
	}

	@Then("^Valido que se visualice boton aceptar de reserva exitosa$")
	public void valido_que_se_visualice_boton_aceptar_de_reserva_exitosa() throws Throwable {
		// Button -- Aceptar
		GenericMethods.isElementPresent(BaseFlow.pageModel.getBtnAceptarFail());
	}

	@Then("^Valido que boton aceptar de reserva exitosa se encuentre habilitado$")
	public void valido_que_boton_aceptar_de_reserva_exitosa_se_encuentre_habilitado() throws Throwable {
		boolean condition = BaseFlow.pageModel.getBtnAceptarFail().isEnabled();
		if (condition == true) {
			assertTrue(true);
		} else {
			System.out.println("Botón aceptar reserva no se encuentra habilitado");
		}
	}
	
	@Then("^Hago click en boton aceptar$")
	public void hago_click_en_boton_aceptar() throws Throwable {
		BaseFlow.pageModel.getBtnAceptarFail().click();
	}
	
	@Then("^Valido visualizacion pagina de inicio$")
	public void valido_visualizacion_pagina_de_inicio() throws Throwable {
		// Div - Menu inicial principal
	    GenericMethods.isElementPresent(BaseFlow.pageModel.getDivMenuInicialPrincipal());
	}

	@Then("^Valido campo ingreso rut no se encuentre vacio$")
	public void valido_campo_ingreso_rut_no_se_encuentre_vacio() throws Throwable {
		// Input Text -- Rut a buscar
		//valido que se encuentre presente
		GenericMethods.isElementPresent(BaseFlow.pageModel.getTxtInputRut());
		value = BaseFlow.pageModel.getTxtInputRut().getAttribute("value");
		if (value != null || !value.equals("")) {
			assertTrue(true);
		} else {
			System.out.println("Campo ingreso rut no muestra rut y se encuentra vacío");
			assertTrue(false);
		}
	}

	@Then("^Valido que se visualice aparezca apartado de paciente$")
	public void valido_que_se_visualice_aparezca_apartado_de_paciente() throws Throwable {
		GenericMethods.isElementPresent(BaseFlow.pageModel.getDivPacienteEncontrado());
	}
}