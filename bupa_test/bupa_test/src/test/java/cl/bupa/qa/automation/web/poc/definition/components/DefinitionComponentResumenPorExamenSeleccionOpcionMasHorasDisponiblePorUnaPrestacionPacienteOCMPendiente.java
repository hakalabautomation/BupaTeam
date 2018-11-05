package cl.bupa.qa.automation.web.poc.definition.components;

import static org.junit.Assert.assertTrue;

import cl.bupa.qa.automation.web.business.flow.BaseFlow;
import cl.bupa.qa.automation.web.poc.util.GenericMethods;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class DefinitionComponentResumenPorExamenSeleccionOpcionMasHorasDisponiblePorUnaPrestacionPacienteOCMPendiente {

	@Given("^Valido visualizacion seccion resumen examen$")
	public void valido_visualizacion_seccion_resumen_examen() throws Throwable {
		// Div -- Resumen examenes
		GenericMethods.isElementPresent(BaseFlow.pageModel.getDivResumenExamenes());
	}

	@When("^Valido visualizacion seccion examen$")
	public void valido_visualizacion_seccion_examen() throws Throwable {
		// Div -- Seccion examen
		GenericMethods.isElementPresent(BaseFlow.pageModel.getDivSeccionExamen());
	}

	@Then("^Valido visualizacion imagen icono examen$")
	public void valido_visualizacion_imagen_icono_examen() throws Throwable {
		// Imagen -- Icono examen
		GenericMethods.isElementPresent(BaseFlow.pageModel.getImgIconoExamenExa());
	}

	@Then("^Valido visualizacion nombre del doctor$")
	public void valido_visualizacion_nombre_del_doctor() throws Throwable {
		// H3 -- Nombre doctor
		GenericMethods.isElementPresent(BaseFlow.pageModel.gethThreeNombreDoctorEsp());
	}

	@Then("^Valido visualizacion prestacion$")
	public void valido_visualizacion_prestacion() throws Throwable {
		// h3 -- Prestacion
		GenericMethods.isElementPresent(BaseFlow.pageModel.gethThreeEspecialidadExa());
	}

	@Then("^Valido prestacion sea igual a la prestaccion seleccionada anteriormente en filtro prestacion$")
	public void valido_prestacion_sea_igual_a_la_prestaccion_seleccionada_anteriormente_en_filtro_prestacion() throws Throwable {
		//obtengo seleccion de prestacion
		String previewTwo = BaseFlow.pageModel.getLbxPrestacion().getAttribute("innerText").trim();
		String[] prestacionSplit = previewTwo.split("↵");
		String[] prestacionSplitFinally = prestacionSplit[0].split("×");
		String lblPrestacion = prestacionSplitFinally[0].trim();
		
		if (BaseFlow.pageModel.gethThreeEspecialidadExa().getAttribute("innerText").trim().equals(
				lblPrestacion)) {
			assertTrue(true);
		} else {
			System.out.println("Prestación mostrada en resumen no es igual a la seleccionada en los filtros");
			assertTrue(false);
		}
	}

	@Then("^Valido visualizacion centro medico$")
	public void valido_visualizacion_centro_medico() throws Throwable {
		// h6 -- Centro medico
		GenericMethods.isElementPresent(BaseFlow.pageModel.gethSixCentroMedicoExa());
	}

	@Then("^Valido centro medico sea igual a la prestacion seleccionada anteriormente en fitro centro medico$")
	public void valido_centro_medico_sea_igual_a_la_prestacion_seleccionada_anteriormente_en_fitro_centro_medico() throws Throwable {
		//obtengo seleccion centro medico
		String preview = BaseFlow.pageModel.getLbxCentroMedico().getAttribute("innerText").trim();
		String[] centroMedicoSplit = preview.split("↵");
		String[] centroMedicoSplitFinally = centroMedicoSplit[0].split("×");
		String lblCentroMedico = centroMedicoSplitFinally[0].trim();
		
		if (BaseFlow.pageModel.gethSixCentroMedicoExa().getAttribute("innerText").trim().equals(
				lblCentroMedico)) {
			assertTrue(true);
		} else {
			System.out.println("Centro médico mostrada en resumen no es igual a la seleccionada en los filtros");
			assertTrue(false);
		}
	}

	@When("^Valido visualizacion seccion paciente$")
	public void valido_visualizacion_seccion_paciente() throws Throwable {
		// Div -- Seccion paciente
		GenericMethods.isElementPresent(BaseFlow.pageModel.getDivSeccionPaciente());
	}

	@When("^Valido visualizacion imagen icono del paciente$")
	public void valido_visualizacion_imagen_icono_del_paciente() throws Throwable {
		// Img -- Icono genero
		GenericMethods.isElementPresent(BaseFlow.pageModel.getImgIconoGeneroEsp());
	}

	@When("^Valido visualizacion nombre del paciente$")
	public void valido_visualizacion_nombre_del_paciente() throws Throwable {
		// H5 -- Nombre paciente
		GenericMethods.isElementPresent(BaseFlow.pageModel.gethFiveNombrePacienteExa());
	}

	@When("^Valido visualizacion correo del paciente$")
	public void valido_visualizacion_correo_del_paciente() throws Throwable {
		// Parrafo -- Mail paciente
		GenericMethods.isElementPresent(BaseFlow.pageModel.getpMailPacienteExa());
	}

	@When("^Valido visualizacion seccion consulta$")
	public void valido_visualizacion_seccion_consulta() throws Throwable {
		// Div -- Seccion consulta
		GenericMethods.isElementPresent(BaseFlow.pageModel.getDivSeccionConsulta());
	}

	@When("^Valido visualizacion imagen icono del calendario$")
	public void valido_visualizacion_imagen_icono_del_calendario() throws Throwable {
		// Imagen -- Icono calendario
		GenericMethods.isElementPresent(BaseFlow.pageModel.getImgIconoCalendarioExa());
	}

	@When("^Valido visualizacion fecha de consulta$")
	public void valido_visualizacion_fecha_de_consulta() throws Throwable {
		// Span -- Fecha examen
		GenericMethods.isElementPresent(BaseFlow.pageModel.getSpnFechaExamenExa());
	}

	@When("^Valido fecha consulta sea igual al titulo fecha visualizada en seccion de horas por doctor$")
	public void valido_fecha_consulta_sea_igual_al_titulo_fecha_visualizada_en_seccion_de_horas_por_doctor() throws Throwable {
	    if (BaseFlow.pageModel.getSpnFechaExamenExa().getAttribute("innerText").trim().equals(
	    		BaseFlow.pageModel.gethThreeFechaEspecialidad().getAttribute("innerText").trim())) {
	    	assertTrue(true);
	    } else {
	    	System.out.println("fecha mostrada en resumen no es igual a visualizada en apartado de horas");
			assertTrue(false);
	    }
	}

	@When("^Valido visualizacion imagen icono del dia$")
	public void valido_visualizacion_imagen_icono_del_dia() throws Throwable {
		// Imagen -- Icono horario examen
		GenericMethods.isElementPresent(BaseFlow.pageModel.getImgIconoHorarioExamenExa());
	}

	@When("^Valido visualizacion hora seleccionada$")
	public void valido_visualizacion_hora_seleccionada() throws Throwable {
		// Span -- Horario examen
		GenericMethods.isElementPresent(BaseFlow.pageModel.getSpanHorarioExamenExa());
	}

	@When("^Valido visualizacion imagen icono costo$")
	public void valido_visualizacion_imagen_icono_costo() throws Throwable {
		// Img -- Icono pago
		GenericMethods.isElementPresent(BaseFlow.pageModel.getImgIconoPagoExa());
	}

	@When("^Valido visualizacion costo$")
	public void valido_visualizacion_costo() throws Throwable {
		// Span -- Monto pago
	    GenericMethods.isElementPresent(BaseFlow.pageModel.getSpnMontoPagoExa());
	}

	@When("^Valido visualizacion boton agendar$")
	public void valido_visualizacion_boton_agendar() throws Throwable {
		// Button -- Agendar
		GenericMethods.isElementPresent(BaseFlow.pageModel.getBtnAgendarExa());
	}

	@When("^Valido boton agendar sea correcto$")
	public void valido_boton_agendar_sea_correcto() throws Throwable {
	    if (BaseFlow.pageModel.getBtnAgendarExa().getAttribute("innerText").trim().equals(
	    		BaseFlow.properties.getLabelAgendar())) {
	    	assertTrue(true);
	    } else {
	    	System.out.println("Botón agendar no es correcto");
	    	assertTrue(false);
	    }
	}

	@When("^Valido boton agendar se encuentre habilitado$")
	public void valido_boton_agendar_se_encuentre_habilitado() throws Throwable {
	    boolean condition = BaseFlow.pageModel.getBtnAgendarExa().isEnabled();
	    if (condition == true) {
	    	assertTrue(true);
	    } else {
	    	System.out.println("Botón agendar no se encuentra habilitado");
	    	assertTrue(false);
	    }
	}
	
	@When("^Presionar boton agendar$")
	public void presionar_boton_agendar() throws Throwable {
		// Button -- Agendar
		BaseFlow.pageModel.getBtnAgendarExa().click();
		//tiempo explicito
		Thread.sleep(4000);
	}
}
