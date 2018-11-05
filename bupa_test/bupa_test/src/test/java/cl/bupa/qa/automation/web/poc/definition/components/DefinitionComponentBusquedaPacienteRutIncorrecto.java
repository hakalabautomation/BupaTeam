package cl.bupa.qa.automation.web.poc.definition.components;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.codehaus.jettison.json.JSONObject;
import org.openqa.selenium.Keys;

import cl.bupa.qa.automation.web.business.flow.BaseFlow;
import cl.bupa.qa.automation.web.poc.util.GenericMethods;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class DefinitionComponentBusquedaPacienteRutIncorrecto {
	
	@Given("^Ingreso a pagina principal bcp \"(.*?)\"$")
	public void ingreso_a_pagina_principal_bcp(String url) throws Throwable {		
		//URL Bcp-QA
	   assertEquals(BaseFlow.urlQa.toString().trim(), url);
	}

	@When("^Presiono item menu inicio$")
	public void presiono_item_menu_inicio() throws Throwable {
		//Imagen -- Icono inicio
	    BaseFlow.pageModel.getImgIconoInicio().click();
	    Thread.sleep(1000);
	}

	@When("^Ingreso rut paciente \"(.*?)\"$")
	public void ingreso_rut_paciente(String arg1) throws Throwable {
		//Input Text -- Rut a buscar
	    BaseFlow.pageModel.getTxtInputRut().sendKeys(arg1);
	    BaseFlow.pageModel.getTxtInputRut().sendKeys(Keys.TAB);
	    Thread.sleep(1000);
	}

	@When("^Presiono boton buscar$")
	public void presiono_boton_buscar() throws Throwable {
		//Button -- Consultar
		/** validacion si se encuentra presente **/
	    BaseFlow.pageModel.getBtnConsultar().sendKeys(Keys.ENTER);	   	    
	}

	@Then("^Valido visualizacion mensaje de error$")
	public void valido_visualizacion_mensaje_de_error() throws Throwable {
		Thread.sleep(7000);
		//Modal -- Rut fail
		/** validacion si se encuentra presente **/
	    GenericMethods.isElementPresent(BaseFlow.pageModel.getMdlRutFail());
	}

	@Then("^Valido titulo visualizado$")
	public void valido_titulo_visualizado() throws Throwable {
		//Label -- Paciente fail
		/** validacion si se encuentra presente **/
	    GenericMethods.isElementPresent(BaseFlow.pageModel.getLblPacienteFail());
	    /** validacion de comparacion **/	    	    	    
	    assertEquals(BaseFlow.pageModel.getLblPacienteFail().getText().trim(), 
	    		BaseFlow.properties.getLabelPaciente());
	}

	@Then("^Valido imagen visualizado$")
	public void valido_imagen_visualizado() throws Throwable {
		//Imagen -- Icono fail
		/** validacion si se encuentra presente **/
		GenericMethods.isElementPresent(BaseFlow.pageModel.getImgIconoFail());
	}

	@Then("^Valido mensaje visualizado$")
	public void valido_mensaje_visualizado() throws Throwable {
		//Parrafo -- Mensaje fail
		/** validacion si se encuentra presente **/
		GenericMethods.isElementPresent(BaseFlow.pageModel.getPrfMensajeFail());
		/** validacion de comparacion **/
		assertEquals(BaseFlow.pageModel.getPrfMensajeFail().getText().trim(), 
				BaseFlow.properties.getLabelMensajeRutNoExiste());
	}

	@Then("^Valido mensaje del servicio con el visualizado$")
	public void valido_mensaje_del_servicio_con_el_visualizado() throws Throwable {
		BaseFlow.commJson.setConn("https://service.us.apiconnect.ibmcloud.com/gws/apigateway/api/b5c81b37fc70b6096c072e030cbac360c5c34f3d7300bc3e076319d5c96544e8/paciente/buscar");
		BaseFlow.commJson.setRequestMethod("POST"); //Metodo de servicio
		BaseFlow.commJson.setRequestProperty("Content-Type", "application/json");// Headers de servicio
		BaseFlow.commJson.setRequestProperty("x-ibm-client-id", "c5811b35-789b-4b44-85f5-9e9ad9587d3f");	
		String bodyPost = "{\"paciente\" : \"8964454-2\"}";		
		BaseFlow.commJson.postParametros(bodyPost);
		String mensaje = "";
		if (BaseFlow.commJson.getResponseCode() == 200) {
			//Se genera array de body
			JSONObject obj = new JSONObject(BaseFlow.commJson.getJsonData());
			mensaje = obj.getJSONObject("pacienteresponse").getString("mensaje");						
			//System.out.println("nombre:"+nombre);			
		}
		//String test = "Paciente no exite";
		mensaje.equalsIgnoreCase(BaseFlow.properties.getLabelMensajeRutNoExisteService());
	}

	@Then("^Valido visualizacion boton aceptar$")
	public void valido_visualizacion_boton_aceptar() throws Throwable {
	    GenericMethods.isElementPresent(BaseFlow.pageModel.getBtnAceptarFail());
	}
	
	@Then("^Valido que haga click boton aceptar$")
	public void valido_que_haga_click_boton_aceptar() throws Throwable {
	    boolean condition = BaseFlow.pageModel.getBtnAceptarFail().isEnabled();
	    if (condition == true) {
	    	assertTrue(true);
	    } else {
	    	System.out.println("Botón aceptar no se encuentra habilitado");
			assertFalse(false);
	    }
	}
	
	@Then("^Valido que al presionar aceptar vuelvo a la pagina de inicio$")
	public void valido_que_al_presionar_aceptar_vuelvo_a_la_pagina_de_inicio() throws Throwable {		
		BaseFlow.pageModel.getBtnAceptarFail().click();
	}
}
