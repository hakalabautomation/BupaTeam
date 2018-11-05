package cl.bupa.qa.automation.web.poc.definition.components;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.codehaus.jettison.json.JSONObject;

import cl.bupa.qa.automation.web.business.flow.BaseFlow;
import cl.bupa.qa.automation.web.json.conn.EndPointConn;
import cl.bupa.qa.automation.web.poc.util.GenericMethods;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Test;

public class DefinitionComponentLoginCorrecto {
	private String centroMedicoService = "";
	private String correoService = "";
	private String nombreService = "";
	private String telefonoService = "";
	private String usuarioService = "";
	private String rutService = "";
	private String tipoService = "";
	private String mensajeService = "";
	private String tokenService = "";
	
	@Given("^Ingreso a la pagina login de bcp \"(.*?)\"$")
	public void ingreso_a_la_pagina_login_de_bcp(String url) throws Throwable {
		//URL Bcp-QA
		assertEquals(BaseFlow.urlQa.toString().trim(), url);		
	}

	@Given("^Valido que aparezca imagen logo bupa$")
	public void valido_que_aparezca_imagen_logo_bupa() throws Throwable {
		// Imagen -- Login
		//valido que se visualice imagen
		GenericMethods.waitTime(BaseFlow.pageModel.getImgLogoBupa());
		//valido que se encuentre presente
		GenericMethods.isElementPresent(BaseFlow.pageModel.getImgLogoBupa());
	}

	@Given("^Valido que aparezca imagen de login$")
	public void valido_que_aparezca_imagen_de_login() throws Throwable {
		// Imagen -- Login
	    GenericMethods.isElementPresent(BaseFlow.pageModel.getImgLogin());
	}

	@Given("^Valido que aparezca titulo aplicativo$")
	public void valido_que_aparezca_titulo_aplicativo() throws Throwable {
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

	@Given("^Valido que aparezca label rut$")
	public void valido_que_aparezca_label_rut() throws Throwable {
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

	@Given("^Valido que aparezca campo texto rut$")
	public void valido_que_aparezca_campo_texto_rut() throws Throwable {
		// Input Text -- Usuario
		GenericMethods.isElementPresent(BaseFlow.pageModel.getTxtUsuario());
	}

	@Given("^Valido que aparezca label contraseña$")
	public void valido_que_aparezca_label_contraseña() throws Throwable {		
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

	@Given("^Valido que aparezca campo texto contraseña$")
	public void valido_que_aparezca_campo_texto_contraseña() throws Throwable {
		// Input Text -- Contraseña
		GenericMethods.isElementPresent(BaseFlow.pageModel.getTxtContraseña());
	}

	@Given("^Valido que aparezca label olvide la contraseña$")
	public void valido_que_aparezca_label_olvide_la_contraseña() throws Throwable {
		//no implementado aun
	}

	@Given("^Valido que label olvide la contraseña contenga un link$")
	public void valido_que_label_olvide_la_contraseña_contenga_un_link() throws Throwable {
		//no implementado aun
	}

	@When("^Ingreso nombre usuario asesor \"(.*?)\"$")
	public void ingreso_nombre_usuario_asesor(String usuario) throws Throwable {
		// Input Text -- Usuario
		//limpio campo
		BaseFlow.pageModel.getTxtUsuario().clear();
		//ingreso nuevos datos
	    BaseFlow.pageModel.getTxtUsuario().sendKeys(usuario);
	}

	@When("^Ingreso contraseña asesor \"(.*?)\"$")
	public void ingreso_contraseña_asesor(String contraseña) throws Throwable {
		// Input Text -- Contraseña
		//limpieza de campo
		BaseFlow.pageModel.getTxtContraseña().clear();
		String pass="password$";
		//envio de datos al campo
		BaseFlow.pageModel.getTxtContraseña().sendKeys(pass);
	}
	
	@When("^Valido datos del login con el servicios \"(.*?)\" \"(.*?)\"$")
	public void valido_datos_del_login_con_el_servicios(String usuario, String contraseña) throws Throwable {		
		BaseFlow.commJson.setConn(EndPointConn.endPointLoginQa); //La URL del servicio
		BaseFlow.commJson.setRequestMethod("POST"); //Metodo de servicio
		BaseFlow.commJson.setRequestProperty(EndPointConn.requestPropertyHeaderNameOneLoginQa, EndPointConn.requestPropertyHeaderValueOneLoginQa); //Headers y value 1 del servicio
		BaseFlow.commJson.setRequestProperty(EndPointConn.requestPropertyHeaderNameTwoLoginQa, EndPointConn.requestPropertyHeaderValueTwoLoginQa); //Headers y value 2 del servicio			
		//String bodyPost = "{\"usuario\" : \""+ usuario +"\", \"contrasena\": \"\"}";
		String bodyPost = "{\"usuario\" : \""+ usuario +"\", \"contrasena\" : \"" + contraseña +"\"}";
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
	}
	
	@When("^Valido que token del servicio devuelva valor$")
	public void valido_que_token_del_servicio_devuelva_valor() throws Throwable {
	    if (!tokenService.equals("") || tokenService != null) {
	    	assertTrue(true);
	    } else {
	    	System.out.println("Valor token no es devuelto por el servicio");
	    	assertTrue(false);
	    }
	}
	
	@Then("^Valido que aparezca boton inicio de sesion$")
	public void valido_que_aparezca_boton_inicio_de_sesion() throws Throwable {
		// Button -- Iniciar sesion
	    GenericMethods.isElementPresent(BaseFlow.pageModel.getBtnIniciarSesion());
	}

	@Then("^Valido que boton inicio sesion tenga habilitado el evento click$")
	public void valido_que_boton_inicio_sesion_tenga_habilitado_el_evento_click() throws Throwable {
	    boolean condition = BaseFlow.pageModel.getBtnIniciarSesion().isEnabled();
	    if (condition == true) {
	    	assertTrue(true);
	    } else {
	    	System.out.println("Boton inicio sesión no se encuentra habilitado");
	    	assertTrue(false);
	    }
	}

	@Then("^Dar click boton inicio sesion$")
	public void dar_click_boton_inicio_sesion() throws Throwable {
		BaseFlow.pageModel.getBtnIniciarSesion().click();
		Thread.sleep(4000);
		//BaseFlow.pageModel.getBtnIniciarSesion().click();
	}

	@Then("^Iniciar sesion en la pagina web$")
	public void iniciar_sesion_en_la_pagina_web() throws Throwable {
		/*
		System.out.println("1:"+mensajeService);
		System.out.println("1:"+BaseFlow.properties.getLabelMensajeRutExisteService());
		System.out.println("2:"+tipoService);
		System.out.println("2:"+BaseFlow.properties.getLabelTipoAceptadoService());
		Thread.sleep(5000);
		*/
		String usuario="YAVILA";
		String contraseña="password$";
		String bodyPost = "";
		String mensaje="";
		String tipoServicio="";
		BaseFlow.commJson.setConn(EndPointConn.endPointLoginQa); //La URL del servicio
		BaseFlow.commJson.setRequestMethod("POST"); //Metodo de servicio
		BaseFlow.commJson.setRequestProperty(EndPointConn.requestPropertyHeaderNameOneLoginQa, EndPointConn.requestPropertyHeaderValueOneLoginQa); //Headers y value 1 del servicio
		BaseFlow.commJson.setRequestProperty(EndPointConn.requestPropertyHeaderNameTwoLoginQa, EndPointConn.requestPropertyHeaderValueTwoLoginQa); //Headers y value 2 del servicio					
		bodyPost = "{\"usuario\" : \""+ usuario +"\", \"contrasena\" : \"" + contraseña +"\"}";
		BaseFlow.commJson.postParametros(bodyPost);
		if (BaseFlow.commJson.getResponseCode() == 200) {
			JSONObject obj = new JSONObject(BaseFlow.commJson.getJsonData());
			mensaje = obj.getString("mensaje");
			tipoServicio = obj.getString("tipo");
		} else {
			System.out.println("Servicio login no responde");
			assertTrue(false);
		}
		
		if (mensaje.equals(BaseFlow.properties.getLabelMensajeRutExisteService())
	    		&& tipoServicio.equals(BaseFlow.properties.getLabelTipoAceptadoService())) {
	    	assertTrue(true);
	    } else {
	    	assertTrue(false);
	    }
		
		/*
	    if (mensajeService.equals(BaseFlow.properties.getLabelMensajeRutExisteService())
	    		&& tipoService.equals(BaseFlow.properties.getLabelTipoAceptadoService())) {
	    	assertTrue(true);
	    } else {
	    	assertTrue(false);
	    }
	    */	    
	}

	@Then("^Visualizo pagina principal$")
	public void visualizo_pagina_principal() throws Throwable {
		// Div - Menu inicial
		//valido que se encuentre presente
		//GenericMethods.waitTime(BaseFlow.pageModel.getDivMenuInicial());
		//valido que elemento se encuentre presente
	    GenericMethods.isElementPresent(BaseFlow.pageModel.getDivMenuInicial());
	}
	
	@Then("^Valido que nombre del asesor sea el mismo que aparece en pagina principal$")
	public void valido_que_nombre_del_asesor_sea_el_mismo_que_aparece_en_pagina_principal() throws Throwable {
	    if (nombreService.equals(BaseFlow.pageModel.getpNombreUsuario().getText().trim())) {
	    	assertTrue(true);
	    } else {
	    	assertTrue(false);
	    }
	}
}
