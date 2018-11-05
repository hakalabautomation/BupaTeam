package cl.bupa.qa.automation.web.poc.definition.components;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.codehaus.jettison.json.JSONObject;

import cl.bupa.qa.automation.web.business.flow.BaseFlow;
import cl.bupa.qa.automation.web.json.conn.EndPointConn;
import cl.bupa.qa.automation.web.poc.util.GenericMethods;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class DefinitionComponentLoginVacio {
	
	private String centroMedicoService = "";
	private String correoService = "";
	private String nombreService = "";
	private String telefonoService = "";
	private String usuarioService = "";
	private String rutService = "";
	private String tipoService = "";
	private String mensajeService = "";
	private String tokenService = "";
	
	@Given("^Ingreso a la pantalla login de bcp \"(.*?)\"$")
	public void ingreso_a_la_pantalla_login_de_bcp(String url) throws Throwable {
		//URL Bcp-QA
		assertEquals(BaseFlow.urlQa.toString().trim(), url);		
	}

	@Given("^Valido que se visualice imagen logo bupa$")
	public void valido_que_se_visualice_imagen_logo_bupa() throws Throwable {
		// Imagen -- Login
		//valido hasata que se visualice imagen 
		GenericMethods.waitTime(BaseFlow.pageModel.getImgLogoBupa());
		//valido que se encuentre presente
		GenericMethods.isElementPresent(BaseFlow.pageModel.getImgLogoBupa());
	}

	@Given("^Valido que se visualice imagen de login$")
	public void valido_que_se_visualice_imagen_de_login() throws Throwable {
		GenericMethods.isElementPresent(BaseFlow.pageModel.getImgLogin());
	}

	@Given("^Valido que se visualice titulo aplicativo$")
	public void valido_que_se_visualice_titulo_aplicativo() throws Throwable {
		// H1 -- Titulo bupa
		//validacion si se encuentra presente
	    GenericMethods.isElementPresent(BaseFlow.pageModel.gethOneTituloBupa());
	    //validacion que ambos label coincidan	    
	    if (BaseFlow.pageModel.gethOneTituloBupa().getText().trim().equals(BaseFlow.properties.getLabelTituloLogin())) {
	    	assertTrue(true);
	    } else {	    	
	    	System.out.println("Título Bupa no coinciden");
	    	assertTrue(false);
	    }
	}

	@Given("^Valido que se visualice label rut$")
	public void valido_que_se_visualice_label_rut() throws Throwable {
		// Label -- Usuario
		//valido que se encuentre presente
	    GenericMethods.isElementPresent(BaseFlow.pageModel.getLblUsuario());
		//validacion que ambos label coincidan	    
	    if (BaseFlow.pageModel.getLblUsuario().getText().trim().equals(BaseFlow.properties.getLabelUsuario())) {
	    	assertTrue(true);
	    } else {
	    	System.out.println("Label usuario no coincide");
	    	assertTrue(false);
	    }
	}

	@Given("^Valido que se visualice campo texto rut$")
	public void valido_que_se_visualice_campo_texto_rut() throws Throwable {
		// Input Text -- Usuario
		GenericMethods.isElementPresent(BaseFlow.pageModel.getTxtUsuario());
	}

	@Given("^Valido que se visualice label contraseña$")
	public void valido_que_se_visualice_label_contraseña() throws Throwable {		
		// Label -- Contraseña
		//valido que se encuentre presente
		GenericMethods.isElementPresent(BaseFlow.pageModel.getLblContraseña());
		//validacion que ambos label coincidan		
		if (BaseFlow.pageModel.getLblContraseña().getText().trim().equals(BaseFlow.properties.getLabelContraseña())) {
			assertTrue(true);
		} else {
			System.out.println("Label usuario no coincide");
	    	assertTrue(false);
		}
	}

	@Given("^Valido que se visualice campo texto contraseña$")
	public void valido_que_se_visualice_campo_texto_contraseña() throws Throwable {		
		// Input Text -- Contraseña
		GenericMethods.isElementPresent(BaseFlow.pageModel.getTxtContraseña());
	}

	@Given("^Valido que se visualice label olvide la contraseña$")
	public void valido_que_se_visualice_label_olvide_la_contraseña() throws Throwable {
		//no implementado aun
	}

	@Given("^Valido que label olvide contraseña contenga un link$")
	public void valido_que_label_olvide_contraseña_contenga_un_link() throws Throwable {
		//no implementado aun
	}

	@When("^Ingreso de usuario asesor \"(.*?)\"$")
	public void ingreso_de_usuario_asesor(String usuario) throws Throwable {
		// Input Text -- Usuario
		BaseFlow.pageModel.getTxtUsuario().sendKeys(usuario);
	}

	@When("^Ingreso de contraseña asesor \"(.*?)\"$")
	public void ingreso_de_contraseña_asesor(String arg1) throws Throwable {
		//no implementado aun
	}
	
	@Then("^Valido datos login con el servicio \"(.*?)\"$")
	public void valido_datos_login_con_el_servicio(String usuario) throws Throwable {
		/*
		BaseFlow.commJson.setConn(EndPointConn.endPointLoginQa); //La URL del servicio
		BaseFlow.commJson.setRequestMethod("POST"); //Metodo de servicio
		BaseFlow.commJson.setRequestProperty(EndPointConn.requestPropertyHeaderNameOneLoginQa, EndPointConn.requestPropertyHeaderValueOneLoginQa); //Headers y value 1 del servicio
		BaseFlow.commJson.setRequestProperty(EndPointConn.requestPropertyHeaderNameTwoLoginQa, EndPointConn.requestPropertyHeaderValueTwoLoginQa); //Headers y value 2 del servicio			
		String bodyPost = "{\"usuario\" : \""+ usuario +"\", \"contrasena\": \"\"}";
		BaseFlow.commJson.postParametros(bodyPost);		
		if (BaseFlow.commJson.getResponseCode() == 200) {
			assertTrue(true);			
			JSONObject obj = new JSONObject(BaseFlow.commJson.getJsonData());
			if (obj.length() > 0) {
				assertTrue(true);
				centroMedicoService = obj.getString("centroMedico");
				correoService = obj.getString("correo");
				nombreService = obj.getString("nombre");
				telefonoService = obj.getString("telefono");
				usuarioService = obj.getString("usuario");
				rutService = obj.getString("rut");
				tipoService = obj.getString("tipo");
				mensajeService = obj.getString("mensaje");
				tokenService = obj.getString("token");
			} else {
				System.out.println("Servicio login no devuelve datos");
				assertTrue(false);				
			}
		} else {
			System.out.println("Servicio login no responde");
			assertTrue(false);			
		}
		*/
	}

	@Then("^Valido que se visualice boton inicio de sesion$")
	public void valido_que_se_visualice_boton_inicio_de_sesion() throws Throwable {
		// Button -- Iniciar sesion
	    GenericMethods.isElementPresent(BaseFlow.pageModel.getBtnIniciarSesion());
	}

	@Then("^Valido que boton inicio sesion tenga habilitado evento click$")
	public void valido_que_boton_inicio_sesion_tenga_habilitado_evento_click() throws Throwable {
		// Button -- Iniciar sesion
		boolean condition = BaseFlow.pageModel.getBtnIniciarSesion().isEnabled();
	    if (condition == true) {
	    	assertTrue(true);
	    } else {
	    	System.out.println("Boton inicio sesión no se encuentra habilitado");
	    	assertTrue(false);
	    }
	}

	@Then("^Dar click en boton inicio sesion$")
	public void dar_click_en_boton_inicio_sesion() throws Throwable {
		// Button -- Iniciar sesion
		BaseFlow.pageModel.getBtnIniciarSesion().click();
	}

	@Then("^Valido que se visualice mensaje de error$")
	public void valido_que_se_visualice_mensaje_de_error() throws Throwable {
		// Div -- Ingresar rut valido
		//valido que se encuentre presente
	    GenericMethods.isElementPresent(BaseFlow.pageModel.getDivIngresarRutValido());
	    //valido que label coincidan	    
	    if (BaseFlow.pageModel.getDivIngresarRutValido().getAttribute("innerText").trim().equals(
	    		BaseFlow.properties.getLabelMensajeIngreseUsuario())) {
	    	assertTrue(true);
	    } else {
	    	System.out.println("Mensaje visualizado no coinciden");
	    	assertTrue(false);	    	
	    }
	}

	@Then("^Valido mensaje de error con el servicio$")
	public void valido_mensaje_de_error_con_el_servicio() throws Throwable {
		/*
	    if (BaseFlow.pageModel.getDivIngresarRutValido().getAttribute("innerText").trim().equals(
	    		mensajeService)) {
	    	assertTrue(true);
	    } else {
	    	System.out.println("Mensaje visualizado en la web no coincide con lo entregado en el servicio");
	    	assertTrue(false);	    	
	    }
	    */
	}

	@Then("^Valido tipo con el servicio$")
	public void valido_tipo_con_el_servicio() throws Throwable {
		/*
	    if (!tipoService.equals("") || tipoService != null) {
	    	assertTrue(true);
	    	if (tipoService.equals("E")) {
	    		assertTrue(true);
	    	} else {
	    		System.out.println("Tipo entregado del servicio es diferente a lo esperado (E)");
	    		assertTrue(false);	    		
	    	}
	    } else {
	    	System.out.println("Tipo entregado por el servicio viene vacío");
	    	assertTrue(false);	    	
	    }
	    */
	}
	
	@Then("^Valido que token venga vacio del servicio$")
	public void valido_que_token_venga_vacio_del_servicio() throws Throwable {
	    if (tokenService.equals("") || tokenService == null ) {
	    	assertTrue(true);
	    } else {
	    	System.out.println("Token entregado del servicio no es vacío");
	    	assertTrue(false);
	    }
	}
}
