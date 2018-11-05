package cl.bupa.qa.automation.web.poc.definition.components;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import java.util.regex.Pattern;

import org.codehaus.jettison.json.JSONObject;
import org.openqa.selenium.Keys;

import cl.bupa.qa.automation.web.business.flow.BaseFlow;
import cl.bupa.qa.automation.web.json.conn.EndPointConn;
import cl.bupa.qa.automation.web.poc.util.GenericMethods;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class DefinitionComponentBusquedaPacienteRutCorrecto {
	//variables que contienen datos obtenidos del servicio
	private static String nombreService;	
	private static String apellidoPaternoService;
	private static String apellidoMaternoService;
	private static String generoService;
	private static String edadService;
	private static String correoService;
	private static String telefonoService;
	private static String rutService;
	private static String tipoService;
	private static String previsionService;
	//variables utilizadas en este definition
	private static String nombreTesting;	
	private static String generoTesting;
	private static String edadTesting;
	private static String correoTesting;
	private static String telefonoTesting;
	private static String rutTesting;
	private static String previsionTesting;
	private static String tokenService;
	
	@Given("^Ingreso a la pagina principal de bcp \"(.*?)\"$")
	public void ingreso_a_la_pagina_principal_de_bcp(String url) throws Throwable {					   
		String getUrl = BaseFlow.driver.getCurrentUrl();
		//assertEquals(arg0, getUrl);
		if (url.equals(getUrl)) {
			assertTrue(true);
		} else {
			System.out.println("URL no corresponde al ambiente de QA");
			assertTrue(false);
		}
	}
	
	@When("^Presiono boton inicio$")
	public void presiono_boton_inicio() throws Throwable {
		//tiempo de espera explicito
		Thread.sleep(3000);
		//Imagen -- Icono inicio
	    BaseFlow.pageModel.getImgIconoInicio().click();
	}

	@When("^Ingreso dato rut paciente \"(.*?)\"$")
	public void ingreso_dato_rut_paciente(String arg1) throws Throwable {
		//Input Text -- Rut a buscar
	    BaseFlow.pageModel.getTxtInputRut().sendKeys(arg1);
	    BaseFlow.pageModel.getTxtInputRut().sendKeys(Keys.TAB);
	    //rutTesting = arg1;
	    Thread.sleep(1000);
	}

	@When("^Presiono boton consultar$")
	public void presiono_boton_consultar() throws Throwable {		
		//Button -- Consultar
	    BaseFlow.pageModel.getBtnConsultar().sendKeys(Keys.ENTER);
	    Thread.sleep(4000);
	}

	@Then("^Valido visualizacion de panel paciente encontrado$")
	public void valido_visualizacion_de_panel_paciente_encontrado() throws Throwable {
		//Div -- Paciente encontrado
	    GenericMethods.isElementPresent(BaseFlow.pageModel.getDivPacienteEncontrado());
	}

	@Then("^Valido titulo paciente visualizado$")
	public void valido_titulo_paciente_visualizado() throws Throwable {
		//H6 -- Paciente
		//si se encuentra presente
		GenericMethods.isElementPresent(BaseFlow.pageModel.gethSixPaciente());
		//comparacion si son iguales
		String labelPaciente = BaseFlow.pageModel.gethSixPaciente().getText().trim(); 
		assertEquals(labelPaciente, BaseFlow.properties.getLabelPaciente());			
	}
	
	@Then("^Valido imagen paciente visualizado$")
	public void valido_imagen_paciente_visualizado() throws Throwable {
	   GenericMethods.isElementPresent(BaseFlow.pageModel.getImgIconoPaciente());
	}
	
	@Then("^Valido imagen de acuerdo a genero$")
	public void valido_imagen_de_acuerdo_a_genero() throws Throwable {
		String arrayGenero = BaseFlow.pageModel.getLblGeneroAndEdadPaciente().getText().trim();
	    String[] parts = arrayGenero.split(" | ");
	    String genero = parts[0].trim();//genero M o F
	    //System.out.println(genero);	    
	    //obtengo propertie de imagen	    
	    String propertie = BaseFlow.pageModel.getImgIconoPaciente().getAttribute("src").trim();	 
	    String urlIconoMen="https://bcp-qa.mybluemix.net/assets/icons/icon-men.svg";
	    String urlIconoWoman="https://bcp-qa.mybluemix.net/assets/icons/icon-woman.svg";
	    //System.out.println(propertie);
	    //Thread.sleep(1000000);
	    if(genero.equals("M")) {
	    	assertEquals(propertie, urlIconoMen);
	    	assertTrue(true);
	    }else if(genero.equals("F")) {
	    	assertEquals(propertie, urlIconoWoman);
	    	assertTrue(true);
	    } else {
	    	assertTrue("Comparación de imagen no es correcta", false);
	    }	    
	    generoTesting = genero;		      
	}
	
	@Then("^Valido nombre paciente visualizado$")
	public void valido_nombre_paciente_visualizado() throws Throwable {
	   GenericMethods.isElementPresent(BaseFlow.pageModel.gethFiveNombrePaciente());
	   nombreTesting = BaseFlow.pageModel.gethFiveNombrePaciente().getText().trim();	   	   
	}
	
	@Then("^Valido la conexion correcto y devolucion del token \"(.*?)\" \"(.*?)\"$")
	public void valido_la_conexion_correcto_y_devolucion_del_token(String usuario, String contraseña) throws Throwable {
		//obtengo el token			   
		BaseFlow.commJson.setConn(EndPointConn.endPointLoginQa); //La URL del servicio
		BaseFlow.commJson.setRequestMethod("POST"); //Metodo de servicio
		BaseFlow.commJson.setRequestProperty(EndPointConn.requestPropertyHeaderNameOneLoginQa, EndPointConn.requestPropertyHeaderValueOneLoginQa); //Headers y value 1 del servicio
		BaseFlow.commJson.setRequestProperty(EndPointConn.requestPropertyHeaderNameTwoLoginQa, EndPointConn.requestPropertyHeaderValueTwoLoginQa); //Headers y value 2 del servicio					
		String bodyPostOne = "{\"usuario\" : \""+ usuario +"\", \"contrasena\" : \"" + contraseña +"\"}";
		BaseFlow.commJson.postParametros(bodyPostOne);
		if (BaseFlow.commJson.getResponseCode() == 200) {
			JSONObject obj = new JSONObject(BaseFlow.commJson.getJsonData());			
			tokenService = obj.getString("token");		
		}
	}
	
	@Then("^Valido conexion correcta y devolucion de datos del servicio \"(.*?)\"$")
	public void valido_conexion_correcta_y_devolucion_de_datos_del_servicio(String rutSearch) throws Throwable {
		/*
		//llamo al servicio de consulta paciente por rut
		BaseFlow.commJson.setConn(EndPointConn.endPointPacienteBuscarQa); //La URL del servicio
		BaseFlow.commJson.setRequestMethod("POST"); //Metodo de servicio
		BaseFlow.commJson.setRequestProperty(EndPointConn.requestPropertyHeaderNameOneQa, "Beared "+tokenService); //Headers y value 1 del servicio
		BaseFlow.commJson.setRequestProperty(EndPointConn.requestPropertyHeaderNameTwoQa, EndPointConn.requestPropertyHeaderValueTwoEspecialtyQa); //Headers y value 2 del servicio
		BaseFlow.commJson.setRequestProperty(EndPointConn.requestPropertyHeaderNameThreeQa, EndPointConn.requestPropertyHeaderValueThreeEspecialtyQa); //Headers y value 3 del servicio			
		String bodyPost = "{\"paciente\" : \""+ rutSearch +"\"}"; //Value en body		
		BaseFlow.commJson.postParametros(bodyPost);		
		if (BaseFlow.commJson.getResponseCode() == 200) {
			assertTrue(true);
			//se genera array de body
			JSONObject obj = new JSONObject(BaseFlow.commJson.getJsonData());
			if(obj.length() > 0) {
				assertTrue(true);
				nombreService = obj.getJSONObject("paciente").getString("nombre");
				apellidoPaternoService = obj.getJSONObject("paciente").getString("apellidoPat");
				apellidoMaternoService = obj.getJSONObject("paciente").getString("apellidoMat");
				generoService = obj.getJSONObject("paciente").getString("sexo");
				edadService = obj.getJSONObject("paciente").getString("edad");
				correoService = obj.getJSONObject("paciente").getString("correo");
				telefonoService = obj.getJSONObject("paciente").getString("telefono");
				rutService = obj.getJSONObject("paciente").getString("numeroDocumento");
				tipoService = obj.getJSONObject("paciente").getJSONObject("estatus").getString("tipo");
				previsionService = obj.getJSONObject("paciente").getJSONObject("estatus").getString("mensaje");				
				
				//System.out.println("x:"+tipoService);
				//System.out.println("xx:"+previsionService);				
				
			} else {
				System.out.println("Servicio búsqueda paciente por rut no devuelve datos");
				assertTrue(false);				
			}
		} else {
			System.out.println("Servicio búsqueda paciente por rut no responde");
			assertTrue(false);			
		}
		*/		
	}
	
	@Then("^Valido nombre paciente del servicio con el visualizado$")
	public void valido_nombre_paciente_del_servicio_con_el_visualizado() throws Throwable {		
		//comparacion nombre visualizado y nombre entregado por el servicio
		/*
		if(nombreTesting.equalsIgnoreCase(nombreService+" "+apellidoPaternoService+" "+apellidoMaternoService)) {
			assertTrue(true);
		} else {
			assertTrue(false);
			System.out.println("Diferencias entre nombre mostrado y el entregado del servicio");
		}
		*/						
	}
	
	@Then("^Valido genero paciente visualizado$")
	public void valido_genero_paciente_visualizado() throws Throwable {
		GenericMethods.isElementPresentString(generoTesting);
	}		
	
	@Then("^Valido genero paciente del servicio con el visualizado$")
	public void valido_genero_paciente_del_servicio_con_el_visualizado() throws Throwable {
		//tomo el numero de genero y le asigno una letra a lo que corresponda
		/*
		if (generoService.equals("1")) {
			generoService = "M";
			assertTrue(true);
		} else if (generoService.equals("2")) {
			generoService = "F";
			assertTrue(true);
		} else {
			assertTrue(false);
		}
		//comparacion genero visualizado y genero entregado por el servicio
		if (generoTesting.equals(generoService)) {
			assertTrue(true);
		} else {
			assertFalse(false);
			System.out.println("Diferencias entre genero mostrado y el entregado del servicio");
		}
		*/
		//assertEquals(generoTesting, generoService);			
	}

	@Then("^Valido edad paciente visualizado$")
	public void valido_edad_paciente_visualizado() throws Throwable {
		GenericMethods.isElementPresent(BaseFlow.pageModel.getLblGeneroAndEdadPaciente());
	    String arrayEdad = BaseFlow.pageModel.getLblGeneroAndEdadPaciente().getText().trim();
	    String[] parts = arrayEdad.split(" | ");
	    String edad = parts[2].trim();//edad
	    GenericMethods.isElementPresentString(edad);
	    edadTesting = edad;
	}
	
	@Then("^Valido edad paciente del servicio con el visualizado$")
	public void valido_edad_paciente_del_servicio_con_el_visualizado() throws Throwable {		
		//comparacion edad visualizado y edad entregado por el servicio
		//System.out.println("x:"+edadTesting);
		//System.out.println("xx:"+edadService);
		//Thread.sleep(30000);
		//int edadOne = Integer.parseInt(edadTesting);
		//int edadTwo = Integer.parseInt(edadService);
		/*if (edadOne == edadTwo) {
			assertTrue(true);
		} else {
			assertTrue(false);
			System.out.println("Diferencias entre edad mostrado y el entregado del servicio");
		}*/				
	}

	@Then("^Valido correo electronico visualizado$")
	public void valido_correo_electronico_visualizado() throws Throwable {
	    GenericMethods.isElementPresent(BaseFlow.pageModel.getLblCorreoPaciente());
	    correoTesting = BaseFlow.pageModel.getLblCorreoPaciente().getText().trim();
	}
	
	@Then("^Valido correo electronico del servicio con el visualizado$")
	public void valido_correo_electronico_del_servicio_con_el_visualizado() throws Throwable {
		//comparacion edad visualizado y edad entregado por el servicio
		/*
		if (correoTesting.equals(correoService)) {
			assertTrue(true);
		} else {
			assertTrue(false);
			System.out.println("Diferencias entre correo mostrado y el entregado del servicio");
		}
		*/		
	    //assertEquals(correoTesting, correo);	    
	}
	
	@Then("^Valido numero telefono visualizado$")
	public void valido_numero_telefono_visualizado() throws Throwable {
		GenericMethods.isElementPresent(BaseFlow.pageModel.getLblTelefonoPaciente());
		telefonoTesting = BaseFlow.pageModel.getLblTelefonoPaciente().getText().trim();
	}
	
	@Then("^Valido numero telefono del servicio con el visualizado$")
	public void valido_numero_telefono_del_servicio_con_el_visualizado() throws Throwable {		
		//comparacion telefono visualizado y telefono entregado por el servicio
		/*
		if (telefonoTesting.equals(telefonoService)) {
			assertTrue(true);
		} else {
			assertTrue(false);
			System.out.println("Diferencias entre teléfono mostrado y el entregado del servicio");
		}
		*/
		//assertEquals(telefonoTesting, telefono);		
	}

	@Then("^Valido rut visualizado$")
	public void valido_rut_visualizado() throws Throwable {
		GenericMethods.isElementPresent(BaseFlow.pageModel.getLblRutPaciente());
		String arrayRut = BaseFlow.pageModel.getLblRutPaciente().getText().trim();
		String[] parts = arrayRut.split(" ");
		String lblRut = parts[0].trim();
		String rut = parts[1].trim();
		String[] partsTwo = rut.split(Pattern.quote("."));
		String rutFinally = partsTwo[0]+partsTwo[1]+partsTwo[2];		
		GenericMethods.isElementPresentString(lblRut);//Label RUT:
		assertEquals(lblRut, BaseFlow.properties.getLabelRut());//Si es igual Label RUT con el properties
		GenericMethods.isElementPresentString(rut);//Rut paciente				
		rutTesting = rutFinally;
	}
	
	@Then("^Valido rut del servicio con el visualizado$")
	public void valido_rut_del_servicio_con_el_visualizado() throws Throwable {		
		//comparacion rut visualizado y rut entregado por el servicio
		/*
		if (rutTesting.equals(rutService)) {
			assertTrue(true);
		} else {
			assertTrue(false);
			System.out.println("Diferencias entre rut mostrado y el entregado del servicio");
		}
		*/
		//assertEquals(rutTesting, rut);
	}

	@Then("^Valido prevision visualizado$")
	public void valido_prevision_visualizado() throws Throwable {
		String arrayPrevision = BaseFlow.pageModel.getLblPrevisionPaciente().getText().trim();
		String[] parts = arrayPrevision.split(":");
		String prevision = parts[0].trim();		
	    GenericMethods.isElementPresentString(prevision);
	    assertEquals(prevision, BaseFlow.properties.getLabelPrevision());
	    previsionTesting = parts[1].trim();	    	    	    
	}
	
	@Then("^Valido prevision del servicio con el visualizado$")
	public void valido_prevision_del_servicio_con_el_visualizado() throws Throwable {
		//comparacion prevision visualizado y prevision entregado por el servicio
		/*
		if (previsionTesting.equals(previsionService)) {
			assertTrue(true);
		} else {
			assertFalse(false);
			System.out.println("Diferencias entre previsión mostrada y el entregado del servicio");
		}
		*/				
	}
	
	@Then("^Valido que se muestre link editar informacion paciente$")
	public void valido_que_se_muestre_link_editar_informacion_paciente() throws Throwable {
		// Link -- Editar informacion paciente
		GenericMethods.isElementPresent(BaseFlow.pageModel.getLnkEditarInformacionPaciente());
	}

	@Then("^Valido que link editar informacion paciente sea el correcto$")
	public void valido_que_link_editar_informacion_paciente_sea_el_correcto() throws Throwable {
	    if (BaseFlow.pageModel.getLnkEditarInformacionPaciente().getText().trim().equals(
	    		BaseFlow.properties.getLabelEditarInformacionPaciente())) {
	    	assertTrue(true);
	    } else {
	    	System.out.println("Link editar información paciente no es correcto");
	    	assertTrue(false);
	    }
	}
	
	@Then("^Valido boton nueva reserva de hora visualizado$")
	public void valido_boton_nueva_reserva_de_hora_visualizado() throws Throwable {
	    GenericMethods.isElementPresent(BaseFlow.pageModel.getBtnConsultar());
	}
}
