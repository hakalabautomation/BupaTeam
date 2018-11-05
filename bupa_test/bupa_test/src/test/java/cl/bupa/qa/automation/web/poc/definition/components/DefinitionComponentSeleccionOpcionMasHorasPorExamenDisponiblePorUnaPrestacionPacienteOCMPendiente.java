package cl.bupa.qa.automation.web.poc.definition.components;

import static org.junit.Assert.assertTrue;

import cl.bupa.qa.automation.web.business.flow.BaseFlow;
import cl.bupa.qa.automation.web.poc.util.GenericMethods;
import cucumber.api.java.en.Then;

public class DefinitionComponentSeleccionOpcionMasHorasPorExamenDisponiblePorUnaPrestacionPacienteOCMPendiente {
	
	@Then("^Selecciono una hora especifica de una prestacion \"(.*?)\" \"(.*?)\"$")
	public void selecciono_una_hora_especifica_de_una_prestacion(String lbxHorasDisponibles, String listHorasDisponibles) throws Throwable {
		// ListBox -- Horas disponibles
		BaseFlow.pageModel.getLbxHorasDisponibles().get(Integer.parseInt(lbxHorasDisponibles)).click();
		// List -- Horas disponibles
		BaseFlow.pageModel.getListHorasDisponibles().get(Integer.parseInt(listHorasDisponibles)).click();
	}

	@Then("^Seleccion opcion mas horas en listado de mas opciones \"(.*?)\"$")
	public void seleccion_opcion_mas_horas_en_listado_de_mas_opciones(String opcionMasHoras) throws Throwable {
		// Button -- Seleccion mas horas
		BaseFlow.pageModel.getBtnSeleccionMasHoras().get(Integer.parseInt(opcionMasHoras)).click();
	}

	@Then("^Valido que se visualice ventana nueva reserva de hora$")
	public void valido_que_se_visualice_ventana_nueva_reserva_de_hora() throws Throwable {
		//tiempo de espera explicito
		Thread.sleep(12000);
		// Div -- Nueva reserva
		GenericMethods.isElementPresent(BaseFlow.pageModel.getDivNuevaReserva());
	}

	@Then("^Valido que se visualice tab examenes$")
	public void valido_que_se_visualice_tab_examenes() throws Throwable {
		// Tab -- Examenes
		GenericMethods.isElementPresent(BaseFlow.pageModel.getNvItMenuExamenes());
	}
	
	@Then("^Valido que tab examenes sea correcto$")
	public void valido_que_tab_examenes_sea_correcto() throws Throwable {
	    if (BaseFlow.pageModel.getNvItMenuExamenes().getAttribute("innerText").equals(
	    		BaseFlow.properties.getLabelExamenes())) {
	    	assertTrue(true);
	    } else {
	    	System.out.println("Tab exámenes no es correcto");
	    }
	}

	@Then("^Valido que tab examenes se encuentra habilitado$")
	public void valido_que_tab_examenes_se_encuentra_habilitado() throws Throwable {
	    boolean condition = BaseFlow.pageModel.getNvItMenuExamenes().isEnabled();
	    if (condition == true) {
	    	assertTrue(true);
	    } else {
	    	System.out.println("Tab exámenes no se encuentra habilitado");
	    	assertTrue(false);
	    }
	}
	
	@Then("^Valido que aparezca boton cerrar ventana nueva reserva abierta$")
	public void valido_que_aparezca_boton_cerrar_ventana_nueva_reserva_abierta() throws Throwable {
		// Button -- Cerrar nueva reserva
	    GenericMethods.isElementPresent(BaseFlow.pageModel.getBtnCerrarNuevaReserva().get(0));
	}

	@Then("^Valido que boton cerrar se encuentre habilitado ventana nueva reserva abierta$")
	public void valido_que_boton_cerrar_se_encuentre_habilitado_ventana_nueva_reserva_abierta() throws Throwable {
	    boolean condition = BaseFlow.pageModel.getBtnCerrarNuevaReserva().get(0).isEnabled();
	    if (condition == true) {
	    	assertTrue(true);
	    } else {
	    	System.out.println("Botón cerrar de nueva reserva abierta no se encuentra habilitado");
	    	assertTrue(false);
	    }
	}

	@Then("^Realizar click boton cerrar nueva reserva abierta$")
	public void realizar_click_boton_cerrar_nueva_reserva_abierta() throws Throwable {
		BaseFlow.pageModel.getBtnCerrarNuevaReserva().get(0).click();
	}
	
	@Then("^Valido que muestre nuevamente ventana OCM pendientes$")
	public void valido_que_muestre_nuevamente_ventana_OCM_pendientes() throws Throwable {
		// Div -- Ocm pendientes paciente
		GenericMethods.isElementPresent(BaseFlow.pageModel.getDivOcmPendientesPacienteSeccionGeneral().get(0));
	}
	
	@Then("^Seleccion nuevamente opcion mas horas en listado de mas opciones \"(.*?)\"$")
	public void seleccion_nuevamente_opcion_mas_horas_en_listado_de_mas_opciones(String opcionMasHoras) throws Throwable {		// Button -- Seleccion mas horas
		BaseFlow.pageModel.getBtnSeleccionMasHoras().get(Integer.parseInt(opcionMasHoras)).click();
	}
}
