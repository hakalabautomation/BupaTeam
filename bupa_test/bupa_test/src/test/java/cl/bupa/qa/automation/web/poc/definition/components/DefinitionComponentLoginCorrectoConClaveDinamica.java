package cl.bupa.qa.automation.web.poc.definition.components;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.codehaus.jettison.json.JSONObject;

import cl.bupa.qa.automation.web.business.flow.BaseFlow;
import cl.bupa.qa.automation.web.json.conn.EndPointConn;
import cl.bupa.qa.automation.web.poc.util.GenericMethods;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class DefinitionComponentLoginCorrectoConClaveDinamica {
	private String centroMedicoService = "";
	private String correoService = "";
	private String nombreService = "";
	private String telefonoService = "";
	private String usuarioService = "";
	private String rutService = "";
	private String tipoService = "";
	private String mensajeService = "";
	private String tokenService = "";

	@Given("^Ingreso al login de bcp \"(.*?)\"$")
	public void ingreso_al_login_de_bcp(String url) throws Throwable {
		//URL Bcp-QA
		if (BaseFlow.urlQa.toString().trim().equals(url)) {
			assertTrue(true);
		} else {
			System.out.println("La url no es correcta");
			assertTrue(false);
		}
	}

	@Given("^Valido visualizacion imagen logo bupa$")
	public void valido_visualizacion_imagen_logo_bupa() throws Throwable {
		// Imagen -- Login
		//valido que se visualice imagen
		GenericMethods.waitTime(BaseFlow.pageModel.getImgLogoBupa());
		//valido que se encuentre presente
		GenericMethods.isElementPresent(BaseFlow.pageModel.getImgLogoBupa());
	}

	@Given("^Valido visualizacion imagen de login$")
	public void valido_visualizacion_imagen_de_login() throws Throwable {
		// Imagen -- Login
	    GenericMethods.isElementPresent(BaseFlow.pageModel.getImgLogin());
	}

	@Given("^Valido visualizacion titulo aplicativo$")
	public void valido_visualizacion_titulo_aplicativo() throws Throwable {
		// H1 -- Titulo bupa
		GenericMethods.isElementPresent(BaseFlow.pageModel.gethOneTituloBupa());
	}

	@Given("^Valido que titulo del aplicativo sea correcto$")
	public void valido_que_titulo_del_aplicativo_sea_correcto() throws Throwable {
		if (BaseFlow.pageModel.gethOneTituloBupa().getText().trim().equals(BaseFlow.properties.getLabelTituloLogin())) {
			assertTrue(true);
		} else {
			System.out.println("Título Bupa no es correcto");
			assertTrue(false);
		}
	}
	
	@Given("^Valido visualizacion de label usuario$")
	public void valido_visualizacion_de_label_usuario() throws Throwable {
		// Label -- Usuario
		GenericMethods.isElementPresent(BaseFlow.pageModel.getLblUsuario());
	}
	
	@Given("^Valido que label usuario sea correcto$")
	public void valido_que_label_usuario_sea_correcto() throws Throwable {
		if (BaseFlow.pageModel.getLblUsuario().getText().trim().equals(BaseFlow.properties.getLabelUsuario())) {
			assertTrue(true);
		} else {
			System.out.println("Label usurio no es correcto");
			assertTrue(false);
		}
	}

	@Given("^Valido visualizacion campo texto usuario$")
	public void valido_visualizacion_campo_texto_usuario() throws Throwable {
		// Input Text -- Usuario
		GenericMethods.isElementPresent(BaseFlow.pageModel.getTxtUsuario());
	}

	@Given("^Valido visualizacion label contraseña$")
	public void valido_visualizacion_label_contraseña() throws Throwable {
		// Label -- Contraseña
		GenericMethods.isElementPresent(BaseFlow.pageModel.getLblContraseña());
	}	
	
	@Given("^Valido que label contraseña sea correcto$")
	public void valido_que_label_contraseña_sea_correcto() throws Throwable {
		if (BaseFlow.pageModel.getLblContraseña().getText().trim().equals(BaseFlow.properties.getLabelContraseña())) {
			assertTrue(true);
		} else {
			System.out.println("Label usuario no coincide");
			assertTrue(false);
		}
	}

	@Given("^Valido visualizacion campo texto contraseña$")
	public void valido_visualizacion_campo_texto_contraseña() throws Throwable {
		// Input Text -- Contraseña
		GenericMethods.isElementPresent(BaseFlow.pageModel.getTxtContraseña());
	}

	@Given("^Valido visualizacion label olvide la contraseña$")
	public void valido_visualizacion_label_olvide_la_contraseña() throws Throwable {
		//no implementado aun
	}

	@Given("^Valido label olvide la contraseña contenga un link$")
	public void valido_label_olvide_la_contraseña_contenga_un_link() throws Throwable {
		//no implementado aun
	}

	@When("^Ingreso el nombre usuario asesor \"(.*?)\"$")
	public void ingreso_el_nombre_usuario_asesor(String usuario) throws Throwable {
		// Input Text -- Usuario
		//limpio campo
		BaseFlow.pageModel.getTxtUsuario().clear();
		//ingreso nuevos datos
	    BaseFlow.pageModel.getTxtUsuario().sendKeys(usuario);
	}

	@When("^Ingreso la contraseña asesor \"(.*?)\"$")
	public void ingreso_la_contraseña_asesor(String contraseña) throws Throwable {
		// Input Text -- Contraseña
		//limpieza de campo
		BaseFlow.pageModel.getTxtContraseña().clear();
		String pass="password$";
		//envio de datos al campo
		BaseFlow.pageModel.getTxtContraseña().sendKeys(contraseña);
		
	}

	@Then("^Valido datos del login con el servicio \"(.*?)\" \"(.*?)\"$")
	public void valido_datos_del_login_con_el_servicio(String usuario, String contraseña) throws Throwable {
		BaseFlow.commJson.setConn(EndPointConn.endPointLoginQa); //La URL del servicio
		BaseFlow.commJson.setRequestMethod("POST"); //Metodo de servicio
		BaseFlow.commJson.setRequestProperty(EndPointConn.requestPropertyHeaderNameOneLoginQa, EndPointConn.requestPropertyHeaderValueOneLoginQa); //Headers y value 1 del servicio
		BaseFlow.commJson.setRequestProperty(EndPointConn.requestPropertyHeaderNameTwoLoginQa, EndPointConn.requestPropertyHeaderValueTwoLoginQa); //Headers y value 2 del servicio					
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

	@Then("^Valido que el token del servicio devuelva valor$")
	public void valido_que_el_token_del_servicio_devuelva_valor() throws Throwable {
		if (!tokenService.equals("") || tokenService != null) {
			assertTrue(true);
		} else {
			System.out.println("Valor token no es devuelto por el servicio");
			assertTrue(false);
		}
	}

	@Then("^Valido visualizacion boton inicio de sesion$")
	public void valido_visualizacion_boton_inicio_de_sesion() throws Throwable {
		// Button -- Iniciar sesion
	    GenericMethods.isElementPresent(BaseFlow.pageModel.getBtnIniciarSesion());   
	}

	@Then("^Valido que el boton inicio sesion tenga habilitado el evento click$")
	public void valido_que_el_boton_inicio_sesion_tenga_habilitado_el_evento_click() throws Throwable {
		boolean condition = BaseFlow.pageModel.getBtnIniciarSesion().isEnabled();
	    if (condition == true) {
	    	assertTrue(true);
	    } else {
	    	System.out.println("Boton inicio sesión no se encuentra habilitado");
	    	assertTrue(false);
	    }
	}

	@Then("^Presionar boton inicio sesion$")
	public void presionar_boton_inicio_sesion() throws Throwable {
		// Button -- Iniciar sesion
		BaseFlow.pageModel.getBtnIniciarSesion().click();
		//tiempo explicito de espera
		Thread.sleep(5000);
	}

	@Given("^Valido visualizacion link volver$")
	public void valido_visualizacion_link_volver() throws Throwable {
		// Link -- Volver
		GenericMethods.isElementPresent(BaseFlow.pageModel.getLnkVolverOpt());
	}

	@When("^Valido link volver sea correcto$")
	public void valido_link_volver_sea_correcto() throws Throwable {
	    if (BaseFlow.pageModel.getLnkVolverOpt().getAttribute("innerText").trim().equals(
	    		BaseFlow.properties.getLabelVolver())) {
	    	assertTrue(true);
	    } else {
	    	System.out.println("Link volver no es correcto");
	    	assertTrue(false);
	    }
	}

	@Then("^Valido link volver se encuentre habilitado$")
	public void valido_link_volver_se_encuentre_habilitado() throws Throwable {
	    boolean condition = BaseFlow.pageModel.getLnkVolverOpt().isEnabled();
	    if (condition == true) {
	    	assertTrue(true);
	    } else {
	    	System.out.println("Link volver no se encuentra habilitado");
	    	assertTrue(false);
	    }
	}

	@Then("^Presionar link volver$")
	public void presionar_link_volver() throws Throwable {
		// Link -- Volver
		BaseFlow.pageModel.getLnkVolverOpt().click();
	}

	@Then("^Valido que se visualice nuevamente campo usuario$")
	public void valido_que_se_visualice_nuevamente_campo_usuario() throws Throwable {
		//tiempo de espera explicito
		Thread.sleep(3000);
		// Input Text -- Usuario
		GenericMethods.isElementPresent(BaseFlow.pageModel.getTxtUsuario());
	}

	@Then("^Valido que se visualice nuevamente campo contraseña$")
	public void valido_que_se_visualice_nuevamente_campo_contraseña() throws Throwable {
		// Input Text -- Contraseña
		GenericMethods.isElementPresent(BaseFlow.pageModel.getTxtContraseña());
	}

	@Then("^Valido que campo usuario se encuentre limpio$")
	public void valido_que_campo_usuario_se_encuentre_limpio() throws Throwable {
		if (BaseFlow.pageModel.getTxtUsuario().getText().equals("")) {
	    	assertTrue(true);
	    } else {
	    	System.out.println("Campo usuario no se encuentra limpio");
	    	assertTrue(false);
	    }
	}

	@Then("^Valido que campo contraseña se encuentre limpio$")
	public void valido_que_campo_contraseña_se_encuentre_limpio() throws Throwable {
		if (BaseFlow.pageModel.getTxtContraseña().getText().equals("")) {
			assertTrue(true);
		} else {
			System.out.println("Campo contraseña no se encuentra limpio");
			assertTrue(false);
		}
	}

	@Then("^Ingreso nuevamente dato nombre usuario asesor \"(.*?)\"$")
	public void ingreso_nuevamente_dato_nombre_usuario_asesor(String usu) throws Throwable {
		BaseFlow.pageModel.getTxtUsuario().sendKeys(usu);
	}

	@Then("^Ingreso nuevamente dato contraseña asesor \"(.*?)\"$")
	public void ingreso_nuevamente_dato_contraseña_asesor(String pass) throws Throwable {
		BaseFlow.pageModel.getTxtContraseña().sendKeys(pass);
	}

	@Given("^Valido nueva url que se muestra en el navegador \"(.*?)\"$")
	public void valido_nueva_url_que_se_muestra_en_el_navegador(String urlOtp) throws Throwable {
	    if (urlOtp.equals(BaseFlow.driver.getCurrentUrl())) {
	    	assertTrue(true);
	    } else {
	    	System.out.println("URL mostrada no es correcta");
	    	assertTrue(false);
	    }
	}

	@When("^Tiempo de espera explicito para el ingreso del token de forma manual$")
	public void tiempo_de_espera_explicito_para_el_ingreso_del_token_de_forma_manual() throws Throwable {
	    Thread.sleep(12000);
	}
	
	@Then("^Valido visualizacion contenedor formulario clave dinamica$")
	public void valido_visualizacion_contenedor_formulario_clave_dinamica() throws Throwable {
		// Div -- Login opt
	    GenericMethods.isElementPresent(BaseFlow.pageModel.getDivLoginOpt());
	}
	
	@Then("^Valido visualizacion imagen logo de bupa$")
	public void valido_visualizacion_imagen_logo_de_bupa() throws Throwable {
		// Imagen -- Logo
		GenericMethods.isElementPresent(BaseFlow.pageModel.getImgLogoBupaOpt());
	}
	
	@Then("^Valido visualizacion imagen logo de login$")
	public void valido_visualizacion_imagen_logo_de_login() throws Throwable {
		// Imagen -- Login
		GenericMethods.isElementPresent(BaseFlow.pageModel.getImgLoginOpt());
	}

	@Then("^Valido visualizacion titulo del aplicativo$")
	public void valido_visualizacion_titulo_del_aplicativo() throws Throwable {
		// H1 -- Titulo bupa
		GenericMethods.isElementPresent(BaseFlow.pageModel.gethOneTituloBupaOpt());
	}

	@Then("^Valido que titulo del aplicativo sea el correcto$")
	public void valido_que_titulo_del_aplicativo_sea_el_correcto() throws Throwable {
	    if (BaseFlow.pageModel.gethOneTituloBupaOpt().getAttribute("innerText").trim().equals(
	    		BaseFlow.properties.getLabelSubTitulo())) {
	    	assertTrue(true);
	    } else {
	    	System.out.println("Título del aplicativo no es el correcto");
	    	assertTrue(false);
	    }
	}
	
	@Then("^Valido visualizacion label clave dinamica$")
	public void valido_visualizacion_label_clave_dinamica() throws Throwable {
		// Label -- Clave dinamica
		GenericMethods.isElementPresent(BaseFlow.pageModel.getLblClaveDinamicaOpt());
	}

	@Then("^Valido que label clave dinamica sea correcto$")
	public void valido_que_label_clave_dinamica_sea_correcto() throws Throwable {
	    if (BaseFlow.pageModel.getLblClaveDinamicaOpt().getAttribute("innerText").trim().equals(
	    		BaseFlow.properties.getLabelIngresarClaveDinamica())) {
	    			assertTrue(true);
	    		} else {
	    			System.out.println("Label ingresar clave dinámica no es correcto");
	    			assertTrue(false);
	    		}
	}

	@Then("^Valido visualizacion del campo clave dinamica$")
	public void valido_visualizacion_del_campo_clave_dinamica() throws Throwable {
		// Input Text -- ClaveDinamica
		GenericMethods.isElementPresent(BaseFlow.pageModel.getTxtClaveDinamicaOpt());
	}

	@Then("^Valido campo clave dinamica se encuentre habilitado$")
	public void valido_campo_clave_dinamica_se_encuentre_habilitado() throws Throwable {
	    boolean condition = BaseFlow.pageModel.getTxtClaveDinamicaOpt().isEnabled();
	    if (condition == true) {
	    	assertTrue(true);
	    } else {
	    	System.out.println("Campo ingresar clave dinámica no se encuentra habilitado");
	    	assertTrue(false);
	    }
	}

	@Then("^Valido visualizacion boton validar token$")
	public void valido_visualizacion_boton_validar_token() throws Throwable {
		// Button -- Validar token
		GenericMethods.isElementPresent(BaseFlow.pageModel.getBtnValidarTokenOpt());
	}

	@Then("^Valido boton validar token sea correcto$")
	public void valido_boton_validar_token_sea_correcto() throws Throwable {
	    if (BaseFlow.pageModel.getBtnValidarTokenOpt().getAttribute("innerText").trim().equals(
	    		BaseFlow.properties.getLabelValidarClaveDinamica())) {
	    	assertTrue(true);
	    } else {
	    	System.out.println("Botón validar clave dinámica no es correcto");
	    	assertTrue(false);
	    }
	}

	@Then("^Valido boton validar token se encuentre habilitado$")
	public void valido_boton_validar_token_se_encuentre_habilitado() throws Throwable {
	    boolean condition = BaseFlow.pageModel.getBtnValidarTokenOpt().isEnabled();
	    if (condition == true) {
	    	assertTrue(true);
	    } else {
	    	System.out.println("Botón validar clave dinámica no se encuentra habilitado");
	    	assertTrue(false);
	    }
	}

	@Then("^Presionar boton validar token$")
	public void presionar_boton_validar_token() throws Throwable {
		// Button -- Validar token
		BaseFlow.pageModel.getBtnValidarTokenOpt().click();
	}
}
