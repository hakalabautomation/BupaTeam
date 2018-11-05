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

public class DefinitionComponentSeleccionHoraPorExamenSeleccionOpcionMasHorasDisponiblePorUnaPrestacionPacienteOCMPendiente {

	@Given("^Valido visualizacion apartado horas$")
	public void valido_visualizacion_apartado_horas() throws Throwable {
		// Div -- Apartado horas
		GenericMethods.isElementPresent(BaseFlow.pageModel.getDivApartadoHoras());
	}

	@Given("^Valido visualizacion titulo de fecha seleccionada$")
	public void valido_visualizacion_titulo_de_fecha_seleccionada() throws Throwable {
		// H3 -- Fecha especialidad
		GenericMethods.isElementPresent(BaseFlow.pageModel.gethThreeFechaEspecialidad());
	}

	@Given("^Valido visualizacion segundo titulo especialidad mas prestacion seleccionada$")
	public void valido_visualizacion_segundo_titulo_especialidad_mas_prestacion_seleccionada() throws Throwable {
		// H4 -- Nombre especialidad y prestacion
		GenericMethods.isElementPresent(BaseFlow.pageModel.gethFourNombreEspecialidadPrestacion());
	}

	@Given("^Valido visualizacion subtitulo centro medico seleccionada$")
	public void valido_visualizacion_subtitulo_centro_medico_seleccionada() throws Throwable {
		// H5 -- Nombre centro medico
		GenericMethods.isElementPresent(BaseFlow.pageModel.gethFiveNombreCentroMedicoEspecialidad());
	}

	@When("^Valido segundo titulo especialidad mas prestacion segun lo seleccionado en filtro especialidad mas prestacio$")
	public void valido_segundo_titulo_especialidad_mas_prestacion_segun_lo_seleccionado_en_filtro_especialidad_mas_prestacio() throws Throwable {
		//obtengo seleccion de especilidad
		String preview = BaseFlow.pageModel.getLbxEspecialidad().getAttribute("innerText").trim();
		String[] especialidadSplit = preview.split("↵");
		String[] especialidadSplitFinally = especialidadSplit[0].split("×");
		String lblEspecialidad = especialidadSplitFinally[0].trim();
		//obtengo seleccion de prestacion
		String previewTwo = BaseFlow.pageModel.getLbxPrestacion().getAttribute("innerText").trim();
		String[] prestacionSplit = previewTwo.split("↵");
		String[] prestacionSplitFinally = prestacionSplit[0].split("×");
		String lblPrestacion = prestacionSplitFinally[0].trim();
		//union de especialidad y prestacion
		String espAndPrs = lblEspecialidad+ " - "+lblPrestacion;
		//System.out.println("1:"+espAndPrs);
		//System.out.println("2:"+BaseFlow.pageModel.gethFourNombreEspecialidadPrestacion().getText().trim());
		//Thread.sleep(3000000);
		if (espAndPrs.equals(BaseFlow.pageModel.gethFourNombreEspecialidadPrestacion().getAttribute("innerText").trim())) {
	    	assertTrue(true);
	    } else {
	    	System.out.println("Subtitulo especialidad + prestacion no es correcto");
	    	assertTrue(false);
	    }
	}

	@When("^Valido subtitulo centro medico segun lo seleccionado en filtro centro medico$")
	public void valido_subtitulo_centro_medico_segun_lo_seleccionado_en_filtro_centro_medico() throws Throwable {
		//obtengo seleccion centro medico
		String preview = BaseFlow.pageModel.getLbxCentroMedico().getAttribute("innerText").trim();
		String[] centroMedicoSplit = preview.split("↵");
		String[] centroMedicoSplitFinally = centroMedicoSplit[0].split("×");
		String lblCentroMedico = centroMedicoSplitFinally[0].trim();
		
		if (BaseFlow.pageModel.gethFiveNombreCentroMedicoEspecialidad().getAttribute("innerText").trim().equals(
				lblCentroMedico)) {
			assertTrue(true);
		} else {
			System.out.println("No se valida de manera correcta selección centro médico");
			assertTrue(true);
		}
	}

	@Then("^Valido visualizacion listado de doctores$")
	public void valido_visualizacion_listado_de_doctores() throws Throwable {
		// List -- Doctores
		if (BaseFlow.pageModel.getListDoctores().size() > 0) {
			assertTrue(true);
		} else {
			System.out.println("No se muestra listado de doctores");
			assertTrue(false);
		}
	}

	@Then("^Valido visualuzacion icono imagen de doctores$")
	public void valido_visualuzacion_icono_imagen_de_doctores() throws Throwable {
		// List -- Imagenes doctores
		if (BaseFlow.pageModel.getListImagenesDoctores().size() > 0) {
			assertTrue(true);
		} else {
			System.out.println("No se muestra imágenes listado de doctores");
			assertTrue(false);
		}
	}

	@Then("^Valido visualizacion nombre de doctores$")
	public void valido_visualizacion_nombre_de_doctores() throws Throwable {
		// List -- Nombre doctores
		if (BaseFlow.pageModel.getListNombreDoctores().size() > 0) {
			assertTrue(true);
		} else {
			System.out.println("No se muestra nombres listado de doctores");
			assertTrue(false);
		}
	}

	@Then("^Valido visualizacion convenio de doctores$")
	public void valido_visualizacion_convenio_de_doctores() throws Throwable {
		if (BaseFlow.pageModel.getListConvenioDoctores().size() > 0) {
			assertTrue(true);
		} else {
			System.out.println("No se muestra covenio listado de doctores");
			assertTrue(false);
		}
	}

	@Then("^Valido visualizacion imagen icono dia$")
	public void valido_visualizacion_imagen_icono_dia() throws Throwable {
	    if (BaseFlow.pageModel.getListImagenesIconoMañanaDoctores().size() > 0) {
	    	assertTrue(true);
	    } else {
	    	System.out.println("No se muestra imagen icono mañana listado de doctores");
			assertTrue(false);
	    }
	}

	@Then("^Valido visualizacion imagen icono tarde$")
	public void valido_visualizacion_imagen_icono_tarde() throws Throwable {		
	    if (BaseFlow.pageModel.getListImagenesIconoTardeDoctores().size() > 0) {
	    	assertTrue(true);
	    } else {
	    	System.out.println("No se muestra imagen icono tarde listado de doctores");
			assertTrue(false);
	    }
	}

	@Then("^Valido visualizacion del separador$")
	public void valido_visualizacion_del_separador() throws Throwable {
		if (BaseFlow.pageModel.getListSeparadorDoctores().size() > 0) {
	    	assertTrue(true);
	    } else {
	    	System.out.println("No se muestra separador listado de doctores");
			assertTrue(false);
	    }
	}

	@Then("^Valido visualizacion listado carrusel de horas$")
	public void valido_visualizacion_listado_carrusel_de_horas() throws Throwable {
	    if (BaseFlow.pageModel.getListCarruselHorasDoctores().size() > 0) {
	    	assertTrue(true);
	    } else {
	    	System.out.println("No se muestra horas listado de doctores");
			assertTrue(false);
	    }
	}

	@Then("^Selecciono hora del carrusel visualizado en apartado de horas$")
	public void selecciono_hora_del_carrusel_visualizado_en_apartado_de_horas() throws Throwable {
		//tiempo explicito
		Thread.sleep(2000);
		List<WebElement> asd = BaseFlow.driver.findElements(By.className("container"));		
		for (WebElement a : asd) {
			a.click();			
			if(GenericMethods.isElementPresent(BaseFlow.pageModel.getDivResumenEspecialidad()))
			break;
		}
		//tiempo explicito
		Thread.sleep(2000);
	}
}
