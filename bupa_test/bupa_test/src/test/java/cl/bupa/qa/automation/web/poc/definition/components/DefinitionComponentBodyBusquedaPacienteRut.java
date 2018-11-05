package cl.bupa.qa.automation.web.poc.definition.components;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Calendar;
import java.util.Date;

import org.bouncycastle.jcajce.provider.symmetric.ARC4.Base;
import org.openqa.selenium.Keys;

import cl.bupa.qa.automation.web.business.flow.BaseFlow;
import cl.bupa.qa.automation.web.poc.util.GenericMethods;
import cucumber.api.java.en.Then;

public class DefinitionComponentBodyBusquedaPacienteRut {
	
	@Then("^Valido que se visualice fecha actual$")
	public void valido_que_se_visualice_fecha_actual() throws Throwable {
		Thread.sleep(5000);
		//Span - fechaActual
		assertTrue(GenericMethods.isElementPresent(BaseFlow.pageModel.getSpnFechaActual()));
	}

	@Then("^Valido que la fecha mostrada sea actual$")
	public void valido_que_la_fecha_mostrada_sea_actual() throws Throwable {
		Date fecha = new Date();
	    int day = 0;
	    int month = 0;
	    int year = 0;
	    String stringDay = "";
	    String stringMonth = "";
	    String dateComplete= "";
	    //obtener dia
	    day = fecha.getDay();
	    if(day == 0){
	    	stringDay = "Domingo";
	    }
	    else if(day == 1){
	    	stringDay = "Lunes";
	    }
	    else if(day == 2){
	    	stringDay = "Martes";
	    }
	    else if(day == 3){
	    	stringDay = "Miércoles";
	    }
	    else if(day == 4){
	    	stringDay = "Jueves";
	    }
	    else if(day == 5){
	    	stringDay = "Viernes";
	    }
	    else if(day == 6){
	    	stringDay = "Sábado";
	    }
	    else{
	    	stringDay = "DD";
	    }
	    //obtener mes
	    month = fecha.getMonth();
	    if(month == 0){
	    	stringMonth = "enero";
	    }
	    else if(month == 1){
	    	stringMonth = "febrero";
	    }
	    else if(month == 2){
	    	stringMonth = "marzo";
	    }
	    else if(month == 3){
	    	stringMonth = "abril";
	    }
	    else if(month == 4){
	    	stringMonth = "mayo";
	    }
	    else if(month == 5){
	    	stringMonth = "junio";
	    }
	    else if(month == 6){
	    	stringMonth = "julio";
	    }
	    else if(month == 7){
	    	stringMonth = "agosto";
	    }
	    else if(month == 8){
	    	stringMonth = "septiembre";
	    }
	    else if(month == 9){
	    	stringMonth = "octubre";
	    }
	    else if(month == 10){
	    	stringMonth = "noviembre";
	    }
	    else if(month == 11){
	    	stringMonth = "diciembre";
	    }
	    else {
	    	stringMonth = "MM";
	    }
	    month = fecha.getDate();
	    //obtener año
	    Calendar calendar = Calendar.getInstance();
	    year = calendar.get(Calendar.YEAR);
	    dateComplete = stringDay+", "+month+" de "+stringMonth+" de "+ year;
	    String dateMachine = BaseFlow.pageModel.getSpnFechaActual().getText().trim();
	    assertEquals(dateMachine, dateComplete);
	}

	@Then("^Valido que se visualice imagen paciente$")
	public void valido_que_se_visualice_imagen_paciente() throws Throwable {
		//Imagen -- Asignados
		assertTrue(GenericMethods.isElementPresent(BaseFlow.pageModel.getImgAsignados()));
	}

	@Then("^Valido que se visualice campo texto ingresar rut$")
	public void valido_que_se_visualice_campo_texto_ingresar_rut() throws Throwable {
		//Span --Pacientes
		assertTrue(GenericMethods.isElementPresent(BaseFlow.pageModel.getSpanPacientes()));
		String pacientes = BaseFlow.pageModel.getSpanPacientes().getText().trim();
		assertEquals(pacientes, BaseFlow.properties.getLabelPacientes());
		//Input Text -- Rut a buscar
		assertTrue(GenericMethods.isElementPresent(BaseFlow.pageModel.getTxtInputRut()));
	}
	
	@Then("^Valido que campo texto ingresar rut permita nueve digitos como maximo$")
	public void valido_que_campo_texto_ingresar_rut_permita_nueve_digitos_como_maximo() throws Throwable {
	    String maxlenght = BaseFlow.pageModel.getTxtInputRut().getAttribute("maxlength").trim();
	    //System.out.println("maxlength: "+maxlenght);	    
	    assertEquals(maxlenght, "9");
	}

	@Then("^Valido que al ingresar rut mal escrito y perder el foco muestre mensaje de error$")
	public void valido_que_al_ingresar_rut_mal_escrito_y_perder_el_foco_muestre_mensaje_de_error() throws Throwable {
		BaseFlow.pageModel.getTxtInputRut().click();
		BaseFlow.pageModel.getTxtInputRut().sendKeys(Keys.TAB);		
		assertTrue(GenericMethods.isElementPresent(BaseFlow.pageModel.getDivIngresarRutValido()));
		String mensajeIngresarRutValido = BaseFlow.pageModel.getDivIngresarRutValido().getAttribute("innerText");
		assertEquals(BaseFlow.properties.getLabelMensajeRutNoValido(), mensajeIngresarRutValido);
	}

	@Then("^Valido que se visualice boton buscar$")
	public void valido_que_se_visualice_boton_buscar() throws Throwable {
		//Button -- Consultar
		assertTrue(GenericMethods.isElementPresent(BaseFlow.pageModel.getBtnConsultar()));
	}

	@Then("^Valido que boton se encuentre deshabilitado$")
	public void valido_que_boton_se_encuentre_deshabilitado() throws Throwable {
		//Button -- Consultar
		assertTrue(!BaseFlow.pageModel.getBtnConsultar().isEnabled());
	}
}
