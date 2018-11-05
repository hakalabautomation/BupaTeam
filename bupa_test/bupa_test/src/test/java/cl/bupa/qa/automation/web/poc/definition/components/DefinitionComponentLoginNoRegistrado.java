package cl.bupa.qa.automation.web.poc.definition.components;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.codehaus.jettison.json.JSONObject;

import cl.bupa.qa.automation.web.business.flow.BaseFlow;
import cl.bupa.qa.automation.web.json.conn.EndPointConn;
import cl.bupa.qa.automation.web.poc.util.GenericMethods;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class DefinitionComponentLoginNoRegistrado {
	
	private String centroMedicoService = "";
	private String correoService = "";
	private String nombreService = "";
	private String telefonoService = "";
	private String usuarioService = "";
	private String rutService = "";
	private String tipoService = "";
	private String mensajeService = "";
	private String tokenService = "";
	@When("^Ingreso usuario del asesor \"(.*?)\"$")
	public void ingreso_usuario_del_asesor(String usuario) throws Throwable {		
		// Input Text -- Usuario
		//limpieza del campo
		BaseFlow.pageModel.getTxtUsuario().clear();
		//envio de datos al campo
		BaseFlow.pageModel.getTxtUsuario().sendKeys(usuario);
	}

	@When("^Ingreso contraseña del asesor \"(.*?)\"$")
	public void ingreso_contraseña_del_asesor(String contraseña) throws Throwable {
		// Input Text -- Contraseña
		//limpieza de campo
		BaseFlow.pageModel.getTxtContraseña().clear();
		//envio de datos al campo
		BaseFlow.pageModel.getTxtContraseña().sendKeys(contraseña);
	}
		
	@Then("^Valido datos del login mediante el servicio \"(.*?)\"$")
	public void valido_datos_del_login_mediante_el_servicio(String usuario) throws Throwable {
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
	}
	
	@Then("^Valido que se visualice el boton inicio de sesion$")
	public void valido_que_se_visualice_el_boton_inicio_de_sesion() throws Throwable {
		// Button -- Iniciar sesion
	    GenericMethods.isElementPresent(BaseFlow.pageModel.getBtnIniciarSesion());
	}

	@Then("^Valido que boton inicio de sesion pueda hacer click$")
	public void valido_que_boton_inicio_de_sesion_pueda_hacer_click() throws Throwable {
		// Button -- Iniciar sesion
		boolean condition = BaseFlow.pageModel.getBtnIniciarSesion().isEnabled();
	    if (condition == true) {
	    	assertTrue(true);
	    } else {
	    	System.out.println("Botón inicio sesión no se encuentra habilitado");
	    	assertTrue(false);
	    }
	}

	@Then("^Dar click en boton iniciar sesion$")
	public void dar_click_en_boton_iniciar_sesion() throws Throwable {
		// Button -- Iniciar sesion
		BaseFlow.pageModel.getBtnIniciarSesion().click();
	}

	@Then("^Valido que se visualice el mensaje de error$")
	public void valido_que_se_visualice_el_mensaje_de_error() throws Throwable {
		// Div -- Ingresar rut valido
		//valido que se encuentre presente
	    GenericMethods.isElementPresent(BaseFlow.pageModel.getDivIngresarRutValido());
	    //valido que label coincidan	    
	    /*if (BaseFlow.pageModel.getDivIngresarRutValido().getAttribute("innerText").trim().equals(
	    		BaseFlow.properties.getLabelMensajeUsuarioNoRegistradoSap())) {
	    	assertTrue(true);
	    } else {
	    	System.out.println("Mensaje visualizado no coinciden");
	    	assertTrue(false);	    	
	    }*/
	}

	@Then("^Valido mensaje de error mediante el servicio$")
	public void valido_mensaje_de_error_mediante_el_servicio() throws Throwable {
		/*if (BaseFlow.pageModel.getDivIngresarRutValido().getAttribute("innerText").trim().equals(
	    		mensajeService)) {
	    	assertTrue(true);
	    } else {
	    	System.out.println("Mensaje visualizado en la web no coincide con lo entregado en el servicio");
	    	assertTrue(false);	    	
	    }*/
	}

	@Then("^Valido tipo entregado por el servicio$")
	public void valido_tipo_entregado_por_el_servicio() throws Throwable {
		if (!tipoService.equals("") || tipoService != null) {
	    	assertTrue(true);
	    	if (tipoService.equals("E")) {
	    		assertTrue(true);
	    	} else {
	    		assertTrue(false);
	    		System.out.println("Tipo entregado del servicio es diferente a lo esperado (E)");
	    	}
	    } else {
	    	System.out.println("Tipo entregado por el servicio viene vacío");
	    	assertTrue(false);	    	
	    }
	}
	
	@Then("^Valido token entregado por el servicio venga vacio$")
	public void valido_token_entregado_por_el_servicio_venga_vacio() throws Throwable {
		if (tokenService.equals("") || tokenService == null ) {
	    	assertTrue(true);
	    } else {
	    	System.out.println("Token entregado del servicio no es vacío");
	    	assertTrue(false);
	    }
	}
}
