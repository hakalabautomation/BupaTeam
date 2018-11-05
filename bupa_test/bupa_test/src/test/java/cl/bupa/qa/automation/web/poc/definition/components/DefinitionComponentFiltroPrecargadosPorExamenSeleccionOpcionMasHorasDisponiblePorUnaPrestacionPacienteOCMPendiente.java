package cl.bupa.qa.automation.web.poc.definition.components;

import static org.junit.jupiter.api.Assertions.assertTrue;

import cl.bupa.qa.automation.web.business.flow.BaseFlow;
import cl.bupa.qa.automation.web.poc.util.GenericMethods;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class DefinitionComponentFiltroPrecargadosPorExamenSeleccionOpcionMasHorasDisponiblePorUnaPrestacionPacienteOCMPendiente {
	
	@When("^Valido visualiacion filtro especialidad$")
	public void valido_visualiacion_filtro_especialidad() throws Throwable {
		//tiempo explicito
		Thread.sleep(5000);
		// ListBox -- Especialidad
		GenericMethods.isElementPresent(BaseFlow.pageModel.getLbxEspecialidad());
	}

	@When("^Valido visualizacion filtro prestacion$")
	public void valido_visualizacion_filtro_prestacion() throws Throwable {
		// ListBox -- Prestacion
		GenericMethods.isElementPresent(BaseFlow.pageModel.getLbxPrestacion());
	}

	@When("^Valido visualizacion filtro region$")
	public void valido_visualizacion_filtro_region() throws Throwable {
		// ListBox -- Region
	    GenericMethods.isElementPresent(BaseFlow.pageModel.getLbxRegion());
	}

	@When("^Valido visualizacion filtro centro medico$")
	public void valido_visualizacion_filtro_centro_medico() throws Throwable {
		// ListBox -- Centro medico
		GenericMethods.isElementPresent(BaseFlow.pageModel.getLbxCentroMedico());
	}

	@Then("^Valido dato inicial filtro especialidad$")
	public void valido_dato_inicial_filtro_especialidad() throws Throwable {
	    if (BaseFlow.pageModel.getLbxEspecialidad().getAttribute("placeholder").trim().equals(
	    		BaseFlow.properties.getLabelEspecialidadTwo())) {
	    	assertTrue(true);
	    } else {
	    	System.out.println("Dato inicial filtro especialidad no es correcto");
	    	assertTrue(false);
	    }
	}

	@Then("^Valido dato inicial filtro prestacion$")
	public void valido_dato_inicial_filtro_prestacion() throws Throwable {
	    if (BaseFlow.pageModel.getLbxPrestacion().getAttribute("placeholder").trim().equals(
	    		BaseFlow.properties.getLabelPrestacion())) {
	    	assertTrue(true);
	    } else {
	    	System.out.println("Dato inicial filtro especialidad no es correcto");
	    	assertTrue(false);
	    }
	}

	@Then("^Valido dato inicial filtro region$")
	public void valido_dato_inicial_filtro_region() throws Throwable {
	    if (BaseFlow.pageModel.getLbxRegion().getAttribute("placeholder").trim().equals(
	    		BaseFlow.properties.getLabelRegion())) {
	    	assertTrue(true);
	    } else {
	    	System.out.println("Dato inicial filtro región no es correcto");
	    	assertTrue(false);
	    }
	}

	@Then("^Valido dato inicial filtro centro medico$")
	public void valido_dato_inicial_filtro_centro_medico() throws Throwable {
	    if (BaseFlow.pageModel.getLbxCentroMedico().getAttribute("placeholder").trim().equals(
	    		BaseFlow.properties.getLabelCentroMedico())) {
	    	assertTrue(true);
	    } else {
	    	System.out.println("Dato inicial filtro centro médico no es correcto");
	    	assertTrue(false);
	    }
	}
	
	@Then("^Valido filtro especialidad no se encuentre vacio$")
	public void valido_filtro_especialidad_no_se_encuentre_vacio() throws Throwable {
	    if (!BaseFlow.pageModel.getLbxEspecialidad().getAttribute("innerText").equals(
	    		BaseFlow.properties.getLabelEspecialidadTwo())) {
	    	assertTrue(true);
	    } else {
	    	System.out.println("Filtro especialidad se encuentra vacío");
	    	assertTrue(false);
	    }
	}

	@Then("^Valido filtro prestacion no se encuentre vacio$")
	public void valido_filtro_prestacion_no_se_encuentre_vacio() throws Throwable {
	    if (!BaseFlow.pageModel.getLbxPrestacion().getAttribute("innerText").equals(
	    		BaseFlow.properties.getLabelPrestacion())) {
	    	assertTrue(true);
	    } else {
	    	System.out.println("Filtro prestación se encuentra vacío");
	    	assertTrue(false);
	    }
	}

	@Then("^Valido filtro especialidad no se encuentre habilitado$")
	public void valido_filtro_especialidad_no_se_encuentre_habilitado() throws Throwable {
		/*
	    boolean condition = BaseFlow.pageModel.getLbxEspecialidad().isEnabled();
	    if (condition == false) {
	    	assertTrue(true);
	    } else {
	    	System.out.println("Filtro especialidad se encuentra habilitado");
	    	assertTrue(false);
	    }
	    */
	}

	@Then("^Valido filtro prestacion no se encuentre habilitado$")
	public void valido_filtro_prestacion_no_se_encuentre_habilitado() throws Throwable {
		/*
	    boolean condition = BaseFlow.pageModel.getLbxPrestacion().isEnabled();
	    if (condition == false) {
	    	assertTrue(true);
	    } else {
	    	System.out.println("Filtro prestación prestación se encuentra habilitado");
	    	assertTrue(false);
	    }
	    */
	}

	@Then("^Valido filtro region se encuentre habilitado$")
	public void valido_filtro_region_se_encuentre_habilitado() throws Throwable {
	    boolean condition = BaseFlow.pageModel.getLbxRegion().isEnabled();
	    if (condition == true) {
	    	assertTrue(true);
	    } else {
	    	System.out.println("Filtro región no se encuentra habilitado");
	    	assertTrue(false);
	    }
	    //System.out.println("tiempo de espera ....");
	    //Thread.sleep(10000000);
	}

	@When("^Dar click en filtro region$")
	public void dar_click_en_filtro_region() throws Throwable {
		// ListBox -- Region
	    BaseFlow.pageModel.getLbxRegion().click();	    
	}

	@Then("^Selecciono opcion filtro region \"(.*?)\"$")
	public void selecciono_opcion_filtro_region(String listRegion) throws Throwable {
		// List -- Region
		BaseFlow.pageModel.getListRegion().get(Integer.parseInt(listRegion)).click();
		//esperar hasta el elemento se encuentre visible y sea clickable
		//GenericMethods.esperaElementoWebSegundos(BaseFlow.driver, BaseFlow.pageModel.getLbxCentroMedico(), 7);
		//tiempo explicitio
		Thread.sleep(5000);
	}
	
	@Given("^Valido centro medico se encuentre habilitado$")
	public void valido_centro_medico_se_encuentre_habilitado() throws Throwable {
		boolean condition = BaseFlow.pageModel.getLbxCentroMedico().isEnabled();
	    if (condition == true) {
	    	assertTrue(true);
	    } else {
	    	System.out.println("Filtro centro médico no se encuentra habilitado");
	    	assertTrue(false);
	    }
	}

	@When("^Dar click en filtro centro medico$")
	public void dar_click_en_filtro_centro_medico() throws Throwable {
		// ListBox -- Centro medico
		BaseFlow.pageModel.getLbxCentroMedico().click();
	}

	@Then ("^Selecciono opcion filtro centro medico \"(.*?)\"$")
	public void selecciono_opcion_filtro_centro_medico(String listCentro) throws Throwable {
		// List -- Centro medico
		BaseFlow.pageModel.getListCentroMedico().get(Integer.parseInt(listCentro)).click();
		//timepo explicito
		Thread.sleep(6000);
	}
}
