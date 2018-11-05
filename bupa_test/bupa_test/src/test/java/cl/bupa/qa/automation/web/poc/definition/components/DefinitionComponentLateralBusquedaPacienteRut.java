package cl.bupa.qa.automation.web.poc.definition.components;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import cl.bupa.qa.automation.web.business.flow.BaseFlow;
import cl.bupa.qa.automation.web.poc.util.GenericMethods;
import cucumber.api.java.en.Then;

public class DefinitionComponentLateralBusquedaPacienteRut {
	
	@Then("^Valido que se visualiza boton inicio$")
	public void valido_que_se_visualiza_boton_inicio() throws Throwable {
		//Imagen -- Icono inicio
		//esperar hasta que se se visulice y se encuentre habilitado
		GenericMethods.waitTime(BaseFlow.pageModel.getImgIconoInicio());
		//se valida cuando el componente se visualice
		assertTrue(GenericMethods.isElementPresent(BaseFlow.pageModel.getImgIconoInicio()));
		//Span -- Inicio
		//assertTrue(GenericMethods.isElementPresent(BaseFlow.pageModel.getSpnInicio()));
		//String inicio = BaseFlow.pageModel.getSpnInicio().getText().trim();
		//assertEquals(inicio, BaseFlow.properties.getLabelInicio());
	}

	@Then("^Valido que boton inicio se encuentre habilitado$")
	public void valido_que_boton_inicio_se_encuentre_habilitado() throws Throwable {
		//se oculta para el sprint 2 - 09-08-17	    
		boolean condition = BaseFlow.pageModel.getImgIconoInicio().isEnabled();
	    if (condition == true) {
	    	assertTrue(true);
	    	BaseFlow.pageModel.getImgIconoInicio().click();
	    } else {
	    	System.out.println("Botón inicio no se encuentra habilitado");
	    	assertTrue(false);
	    }	    
	}

	@Then("^Valido que se visualiza boton asignados$")
	public void valido_que_se_visualiza_boton_asignados() throws Throwable {
		//se oculta para el sprint 2 - 09-08-17
		//Imagen -- Icono asignados
		//assertTrue(GenericMethods.isElementPresent(BaseFlow.pageModel.getImgIconoAsignados()));
		//Span -- Asignados
		//assertTrue(GenericMethods.isElementPresent(BaseFlow.pageModel.getSpnAsignados()));
		//String asignados = BaseFlow.pageModel.getSpnAsignados().getText().trim();
		//assertEquals(asignados, BaseFlow.properties.getLabelAsignados());
	}

	@Then("^Valido que boton asignados se encuentre habilitado$")
	public void valido_que_boton_asignados_se_encuentre_habilitado() throws Throwable {
		//se oculta para el sprint 2 - 09-08-17
		/*
		boolean condition = BaseFlow.pageModel.getImgIconoAsignados().isEnabled();
	    if (condition == true) {
	    	assertTrue(true);
	    } else {
	    	System.out.println("Botón asignados no se encuentra habilitado");
	    	assertTrue(false);
	    }
	    */
	}

	@Then("^Valido que se visualiza boton promociones$")
	public void valido_que_se_visualiza_boton_promociones() throws Throwable {
		//se oculta para el sprint 2 - 09-08-17
		//Imagen -- Icono promociones
		//assertTrue(GenericMethods.isElementPresent(BaseFlow.pageModel.getImgIconoPromociones()));
		//Span -- promociones
		//assertTrue(GenericMethods.isElementPresent(BaseFlow.pageModel.getSpnPromociones()));
		//String promociones = BaseFlow.pageModel.getSpnPromociones().getText().trim();
		//assertEquals(promociones, BaseFlow.properties.getLabelPromociones());
	}

	@Then("^Valido que boton promociones se encuentre habilitado$")
	public void valido_que_boton_promociones_se_encuentre_habilitado() throws Throwable {
		//se oculta para el sprint 2 - 09-08-17
		/*
		boolean condition = BaseFlow.pageModel.getImgIconoPromociones().isEnabled();
	    if (condition == true) {
	    	assertTrue(true);
	    } else {
	    	System.out.println("Botón promociones no se encuentra habilitado");
	    	assertTrue(false);
	    }
	    */
	}

	@Then("^Valido que se visualiza boton CBClic$")
	public void valido_que_se_visualiza_boton_CBClic() throws Throwable {
		//se oculta para el sprint 2 - 09-08-17
		//Imagen -- Icono CB Clic
		//assertTrue(GenericMethods.isElementPresent(BaseFlow.pageModel.getImgIconoCbClic()));
		//Span -- CB Clic
		//assertTrue(GenericMethods.isElementPresent(BaseFlow.pageModel.getSpnCbClic()));
		//String cbClic = BaseFlow.pageModel.getSpnCbClic().getText().trim();
		//assertEquals(cbClic, BaseFlow.properties.getLabelCBClic());
	}

	@Then("^Valido que boton CBClic se encuentre habilitado$")
	public void valido_que_boton_CBClic_se_encuentre_habilitado() throws Throwable {
		//se oculta para el sprint 2 - 09-08-17
		/*
		boolean condition = BaseFlow.pageModel.getImgIconoCbClic().isEnabled();
	    if (condition == true) {
	    	assertTrue(true);
	    } else {
	    	System.out.println("Botón CBClic no se encuentra habilitado");
	    	assertTrue(false);
	    }
	    */
	}

	@Then("^Valido que se visualiza boton configuracion$")
	public void valido_que_se_visualiza_boton_configuracion() throws Throwable {
		//Imagen -- Icono configuracion
		//assertTrue(GenericMethods.isElementPresent(BaseFlow.pageModel.getImgIconoConfiguracion()));
		//Span -- Configuracion
		//assertTrue(GenericMethods.isElementPresent(BaseFlow.pageModel.getSpnConfiguracion()));
		//String configuracion = BaseFlow.pageModel.getSpnConfiguracion().getText().trim();
		//assertEquals(configuracion, BaseFlow.properties.getLabelConfiguracion());	
	}

	@Then("^Valido que boton configuracion se encuentre habilitado$")
	public void valido_que_boton_configuracion_se_encuentre_habilitado() throws Throwable {
		//se oculta para el sprint 2 - 09-08-17
		/*
		boolean condition = BaseFlow.pageModel.getImgIconoConfiguracion().isEnabled();
	    if (condition == true) {
	    	assertTrue(true);
	    } else {
	    	System.out.println("Botón configuración no se encuentra habilitado");
	    	assertTrue(false);
	    }
	    */
	}


	@Then("^Valido que se visualiza boton cerrar sesion$")
	public void valido_que_se_visualiza_boton_cerrar_sesion() throws Throwable {
		//Imagen -- Icono cerrar sesion
		assertTrue(GenericMethods.isElementPresent(BaseFlow.pageModel.getImgIconoCerrarSesion()));
		//Span -- Cerrar sesion
		assertTrue(GenericMethods.isElementPresent(BaseFlow.pageModel.getSpnCerrarSesion()));
		String cerrarSesion = BaseFlow.pageModel.getSpnCerrarSesion().getText().trim();
		assertEquals(cerrarSesion, BaseFlow.properties.getLabelCerrarSesion());
	}

	@Then("^Valido que boton cerrar sesion se encuentre habilitado$")
	public void valido_que_boton_cerrar_sesion_se_encuentre_habilitado() throws Throwable {
		boolean condition = BaseFlow.pageModel.getImgIconoCerrarSesion().isEnabled();
	    if (condition == true) {
	    	assertTrue(true);
	    } else {
	    	System.out.println("Botón cerrar sesión no se encuentra habilitado");
	    	assertTrue(false);
	    }
	}
}