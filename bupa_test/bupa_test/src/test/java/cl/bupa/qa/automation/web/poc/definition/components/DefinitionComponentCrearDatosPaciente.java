package cl.bupa.qa.automation.web.poc.definition.components;

import static org.junit.Assert.assertTrue;

import org.codehaus.jettison.json.JSONObject;

import cl.bupa.qa.automation.web.business.flow.BaseFlow;
import cl.bupa.qa.automation.web.json.conn.EndPointConn;
import cl.bupa.qa.automation.web.poc.util.GenericMethods;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class DefinitionComponentCrearDatosPaciente {
	
	private String tokenService = "";
	private static String numeroDocumentoService;
	private static String tipoService;
	private static String previsionService;
	private static String value;
	private static int totalGenero;
	private static int totalPrevision;
	private static int totalNacionalidad;
	private static int totalRegiones;		
	
	@Given("^Ingreso un rut de un paciente \"(.*?)\"$")
	public void ingreso_un_rut_de_un_paciente(String rut) throws Throwable {
		//limpiar el campo
		BaseFlow.pageModel.getTxtInputRut().clear();
		// Input Text -- Rut a buscar
		BaseFlow.pageModel.getTxtInputRut().sendKeys(rut);
	}

	@Given("^Valido que boton buscar se encuentre habilitado$")
	public void valido_que_boton_buscar_se_encuentre_habilitado() throws Throwable {
		boolean condition = BaseFlow.pageModel.getBtnConsultar().isEnabled();
		if (condition == true) {
			assertTrue(true);
		} else {
			System.out.println("Botón consultar no se encuentra habilitado");
			assertTrue(false);			
		}
	}

	@When("^Dar click en boton buscar$")
	public void dar_click_en_boton_buscar() throws Throwable {
		// Button -- Consultar
		BaseFlow.pageModel.getBtnConsultar().click();
	}

	@Then("^Visualizo ventana crear datos paciente$")
	public void visualizo_ventana_crear_datos_paciente() throws Throwable {
		//espero hasta que ventana de crear y editar paciente se despliegue
		GenericMethods.waitTime(BaseFlow.pageModel.getDivCrearEditarPaciente());
		//valido que se visualice
		GenericMethods.isElementPresent(BaseFlow.pageModel.getDivCrearEditarPaciente());
	}
	
	@Then("^Valido datos del servicio token \"(.*?)\" \"(.*?)\"$")
	public void valido_datos_del_servicio_token(String usuario, String contraseña) throws Throwable {
		BaseFlow.commJson.setConn(EndPointConn.endPointLoginQa); //La URL del servicio
		BaseFlow.commJson.setRequestMethod("POST"); //Metodo de servicio
		BaseFlow.commJson.setRequestProperty(EndPointConn.requestPropertyHeaderNameOneLoginQa, EndPointConn.requestPropertyHeaderValueOneLoginQa); //Headers y value 1 del servicio
		BaseFlow.commJson.setRequestProperty(EndPointConn.requestPropertyHeaderNameTwoLoginQa, EndPointConn.requestPropertyHeaderValueTwoLoginQa); //Headers y value 2 del servicio					
		String bodyPostOne = "{\"usuario\" : \""+ usuario +"\", \"contrasena\" : \"" + contraseña +"\"}";
		BaseFlow.commJson.postParametros(bodyPostOne);
		if (BaseFlow.commJson.getResponseCode() == 200) {
			assertTrue(true);
			JSONObject obj = new JSONObject(BaseFlow.commJson.getJsonData());
			if (obj.length() > 0) {
				assertTrue(true);				
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

	@Then("^Valido que servicio token devuelva valor$")
	public void valido_que_servicio_token_devuelva_valor() throws Throwable {
		if (!tokenService.equals("") || tokenService != null) {
			assertTrue(true);
		} else {
			System.out.println("Valor token no es devuelto por el servicio");
			assertTrue(false);
		}
	}
	
	@Then("^Realizo llamada consulta paciente \"(.*?)\"$")
	public void realizo_llamada_consulta_paciente(String rutService) throws Throwable {
		/*
		BaseFlow.commJson.setConn(EndPointConn.endPointPacienteBuscarQa); //La URL del servicio
		BaseFlow.commJson.setRequestMethod("POST"); //Metodo de servicio
		BaseFlow.commJson.setRequestProperty(EndPointConn.requestPropertyHeaderNameOneQa, "Beared "+tokenService); //Headers y value 1 del servicio
		BaseFlow.commJson.setRequestProperty(EndPointConn.requestPropertyHeaderNameTwoQa, EndPointConn.requestPropertyHeaderValueTwoEspecialtyQa); //Headers y value 2 del servicio
		BaseFlow.commJson.setRequestProperty(EndPointConn.requestPropertyHeaderNameThreeQa, EndPointConn.requestPropertyHeaderValueThreeEspecialtyQa); //Headers y value 3 del servicio			
		String bodyPost = "{\"paciente\" : \""+ rutService +"\"}"; //Value en body		
		BaseFlow.commJson.postParametros(bodyPost);		
		if (BaseFlow.commJson.getResponseCode() == 200) {
			assertTrue(true);
			//se genera array de body
			JSONObject obj = new JSONObject(BaseFlow.commJson.getJsonData());
			if(obj.length() > 0) {
				assertTrue(true);			
				//rutService = obj.getJSONObject("paciente").getString("numeroDocumento");
				tipoService = obj.getJSONObject("paciente").getJSONObject("estatus").getString("tipo");
				previsionService = obj.getJSONObject("paciente").getJSONObject("estatus").getString("mensaje");
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

	@Then("^Valido rut paciente consultado no exista$")
	public void valido_rut_paciente_consultado_no_exista() throws Throwable {
		/*
	    if (tipoService.equals(BaseFlow.properties.getLabelTipoAceptadoServiceTwo()) && 
	    		previsionService.equals(BaseFlow.properties.getLabelMensajeRutExisteService())) {
	    	assertTrue(true);
	    } else {
	    	System.out.println("Rut paciente consultado existe de acuerdo al servicio");
	    	assertTrue(false);
	    }
	    */
	}
	
	@Given("^Valido visualizacion boton cerrar ventana$")
	public void valido_visualizacion_boton_cerrar_ventana() throws Throwable {
		// Button -- Close
		GenericMethods.isElementPresent(BaseFlow.pageModel.getBtnClose());
	}

	@Given("^Valido que boton x se encuentre habilitado$")
	public void valido_que_boton_x_se_encuentre_habilitado() throws Throwable {
		boolean condition = BaseFlow.pageModel.getBtnClose().isEnabled();
	    if (condition == true) {
	    	assertTrue(true);
	    } else {
	    	System.out.println("Botón close no se encuentra habilitado");
	    	assertTrue(false);
	    }
	}

	@When("^Presiono boton x despliegue ventana emergente$")
	public void presiono_boton_x_despliegue_ventana_emergente() throws Throwable {
		BaseFlow.pageModel.getBtnClose().click();
	}
	
	@Then("^Valido que muestre ventana de inicio$")
	public void valido_que_muestre_ventana_de_inicio() throws Throwable {
		// Div - Menu inicial principal
		GenericMethods.isElementPresent(BaseFlow.pageModel.getDivMenuInicialPrincipal());
	}
	
	@When("^Valido que campo busqueda paciente por rut no se encuentre vacio$")
	public void valido_que_campo_busqueda_paciente_por_rut_no_se_encuentre_vacio() throws Throwable {
	    String value = BaseFlow.pageModel.getTxtInputRut().getAttribute("value");
	    if (!value.equals("")) {
	    	assertTrue(true);
	    } else {
	    	System.out.print("Campo búsqueda paciente por rut se encuentra vacío");
	    	assertTrue(false);
	    }
	}

	@Then("^Ingreso nuevamente el rut del paciente \"(.*?)\"$")
	public void ingreso_nuevamente_el_rut_del_paciente(String rutEmpy) throws Throwable {
		//tiempo de esperar hasta que el elemento se encuentre visible y habilitado
		GenericMethods.isClickable(BaseFlow.pageModel.getTxtInputRut(), BaseFlow.driver);
		// Input Text -- Rut a buscar
		BaseFlow.pageModel.getTxtInputRut().sendKeys(rutEmpy);
	}

	@Then("^Preciono boton buscar$")
	public void preciono_boton_buscar() throws Throwable {
		//Thread.sleep(3000);
		// Button -- Consultar
		BaseFlow.pageModel.getBtnConsultar().click();
	}

	@Then("^Visualizo la ventanan crear datos paciente$")
	public void visualizo_la_ventanan_crear_datos_paciente() throws Throwable {
		//espero hasta que ventana de crear y editar paciente se despliegue
		GenericMethods.waitTime(BaseFlow.pageModel.getDivCrearEditarPaciente());
		//valido que se visualice
		GenericMethods.isElementPresent(BaseFlow.pageModel.getDivCrearEditarPaciente());
	}
	
	@Then("^Valido que se visualice titulo rut no encontrado crear paciente$")
	public void valido_que_se_visualice_titulo_rut_no_encontrado_crear_paciente() throws Throwable {
		//H5 -- Crear y editar datos paciente
		GenericMethods.isElementPresent(BaseFlow.pageModel.gethFiveTituloCrearEditarDatosPaciente());
	}

	@Then("^Valido que titulo rut no encontrado crear paciente sea el correcto$")
	public void valido_que_titulo_rut_no_encontrado_crear_paciente_sea_el_correcto() throws Throwable {
		if (BaseFlow.pageModel.gethFiveTituloCrearEditarDatosPaciente().getText().trim().equals(
				BaseFlow.properties.getLabelRutNoEncontradoCrearPaciente())) {
			assertTrue(true);
		} else {
			System.out.println("Título de rut no encontrado crear paciente no es correo");
			assertTrue(false);
		}
	}

	@Then("^Valido que se visualice subtitulo si paciente se encuentra registrado proceda revisar rut$")
	public void valido_que_se_visualice_subtitulo_si_paciente_se_encuentra_registrado_proceda_revisar_rut() throws Throwable {
		//H6 -- Paciente registrado revisar rut
		GenericMethods.isElementPresent(BaseFlow.pageModel.gethSixSubTituloPacienteRegistradoRevisarRut());	
	}

	@Then("^Valido que subtitulo si paciente se encuentra registrado proceda revisar rut sea al correcto$")
	public void valido_que_subtitulo_si_paciente_se_encuentra_registrado_proceda_revisar_rut_sea_al_correcto() throws Throwable {
		if (BaseFlow.pageModel.gethSixSubTituloPacienteRegistradoRevisarRut().getText().trim().equals(
				BaseFlow.properties.getLabelSiPacienteSeEncuentraRegistradoRevisarRut())) {
			assertTrue(true);
		} else {
			System.out.println("Subtitulo paciente no se encuentra regisrado no es correcto");
			assertTrue(false);
		}
	}

	@Then("^Valido que se visualice el label rut$")
	public void valido_que_se_visualice_el_label_rut() throws Throwable {
		// Label -- Rut paciente
		GenericMethods.isElementPresent(BaseFlow.pageModel.getLblRut());	
	}

	@Then("^Valido que el label rut sea el correcto$")
	public void valido_que_el_label_rut_sea_el_correcto() throws Throwable {
		if (BaseFlow.pageModel.getLblRut().getText().trim().equals(
				BaseFlow.properties.getLabelRutDatosPaciente())) {
			assertTrue(true);
		} else {
			System.out.println("Label rut no es correcto");
			assertTrue(false);
		}
	}

	@Then("^Valido que se visualice campo rut$")
	public void valido_que_se_visualice_campo_rut() throws Throwable {
		//Input text -- Rut
		GenericMethods.isElementPresent(BaseFlow.pageModel.getTxtRut());
	}

	@Then("^Valido que campo rut muestre el rut correcto \"(.*?)\"$")
	public void valido_que_campo_rut_muestre_el_rut_correcto(String rutSearch) throws Throwable {
		if (BaseFlow.pageModel.getTxtRut().getAttribute("value").trim().equals(rutSearch)) {
			assertTrue(true);
		} else {
			System.out.println("Rut mostrado en campo no es idéntico");
			assertTrue(false);
		}
	}

	@Then("^Valido que campo rut contenga el rut del paciente buscado previamente$")
	public void valido_que_campo_rut_contenga_el_rut_del_paciente_buscado_previamente() throws Throwable {
		if (BaseFlow.pageModel.getTxtInputRut().getText().trim().equals(
				BaseFlow.pageModel.getTxtRut().getText().trim())) {
			assertTrue(true);
		} else {
			System.out.println("Rut mostrado en ambos campos no es idéntico");
			assertTrue(false);
		}
	}

	@Then("^Valido que campo rut se encuentre deshabilitado$")
	public void valido_que_campo_rut_se_encuentre_deshabilitado() throws Throwable {
		boolean condition = BaseFlow.pageModel.getTxtRut().isEnabled();
		if (condition == false) {
			assertTrue(true);
		} else {
			System.out.println("Campo rut no se encuentra deshabilitado");
			assertTrue(false);
		}
	}

	@Then("^Valido que se visualice el label nombres$")
	public void valido_que_se_visualice_el_label_nombres() throws Throwable {
		//Label -- Nombres
		GenericMethods.isElementPresent(BaseFlow.pageModel.getLblNombres());
	}

	@Then("^Valido que el label nombres sea el correcto$")
	public void valido_que_el_label_nombres_sea_el_correcto() throws Throwable {
		if (BaseFlow.pageModel.getLblNombres().getText().trim().equals(
				BaseFlow.properties.getLabelNombres())) {
			assertTrue(true);
		} else {
			System.out.println("Label nombres no es correcto");
			assertTrue(false);
		}
	}

	@Then("^Valido que se visualice campo nombres$")
	public void valido_que_se_visualice_campo_nombres() throws Throwable {
		//Input text -- Nombres
		GenericMethods.isElementPresent(BaseFlow.pageModel.getTxtNombres());
	}

	@Then("^Valido que campo nombres se encuentre habilitado$")
	public void valido_que_campo_nombres_se_encuentre_habilitado() throws Throwable {
		boolean condition = BaseFlow.pageModel.getTxtNombres().isEnabled();
		if (condition == true) {
			assertTrue(true);
		} else {
			System.out.println("Campo nombres no se encuentra habilitado");
			assertTrue(false);
		}
	}

	@Then("^Valido que se visualice el label apellidos$")
	public void valido_que_se_visualice_el_label_apellidos() throws Throwable {
		//Label -- Apellidos
		GenericMethods.isElementPresent(BaseFlow.pageModel.getLblApellidos());
	}

	@Then("^Valido que el label apellidos sea el correcto$")
	public void valido_que_el_label_apellidos_sea_el_correcto() throws Throwable {
		if (BaseFlow.pageModel.getLblApellidos().getText().trim().equals(
				BaseFlow.properties.getLabelApellidos())) {
			assertTrue(true);
		} else {
			System.out.println("Label apellidos no es correcto");
			assertTrue(false);
		}
	}

	@Then("^Valido que se visualice campo apellido uno$")
	public void valido_que_se_visualice_campo_apellido_uno() throws Throwable {
		//Input text -- Apellido materno
		GenericMethods.isElementPresent(BaseFlow.pageModel.getTxtApellidoMaterno());
	}

	@Then("^Valido que se visualice campo apellido dos$")
	public void valido_que_se_visualice_campo_apellido_dos() throws Throwable {
		//Input text -- Apellido paterno
		GenericMethods.isElementPresent(BaseFlow.pageModel.getTxtApellidoPaterno());
	}

	@Then("^Valido que campo apellido uno se encuentre habilitado$")
	public void valido_que_campo_apellido_uno_se_encuentre_habilitado() throws Throwable {
		boolean condition = BaseFlow.pageModel.getTxtApellidoMaterno().isEnabled();
		if (condition == true) {
			assertTrue(true);
		} else {
			System.out.println("Campo apellido materno no se encuentra habilitado");
			assertTrue(false);
		}
	}

	@Then("^Valido que campo apellido dos se encuentre habilitado$")
	public void valido_que_campo_apellido_dos_se_encuentre_habilitado() throws Throwable {
		boolean condition = BaseFlow.pageModel.getTxtApellidoPaterno().isEnabled();
		if (condition == true) {
			assertTrue(true);
		} else {
			System.out.println("Campo apellido paterno no se encuentra habilitado");
			assertTrue(false);
		}
	}

	@Then("^Valido que se visualice el label fecha de nacimiento$")
	public void valido_que_se_visualice_el_label_fecha_de_nacimiento() throws Throwable {
		//Label -- Fecha nacimiento
		GenericMethods.isElementPresent(BaseFlow.pageModel.getLblFechaNacimiento());
	}

	@Then("^Valido que el label fecha de nacimiento sea el correcto$")
	public void valido_que_el_label_fecha_de_nacimiento_sea_el_correcto() throws Throwable {
		if (BaseFlow.pageModel.getLblFechaNacimiento().getText().trim().equals(
				BaseFlow.properties.getLabelFechaDeNacimiento())) {
			assertTrue(true);
		} else {
			System.out.println("Label fecha nacimiento no es el correcto");
			assertTrue(false);
		}
	}

	@Then("^Valido que se visualice campo dia de fecha$")
	public void valido_que_se_visualice_campo_dia_de_fecha() throws Throwable {
		//Input text -- Fecha dia
		GenericMethods.isElementPresent(BaseFlow.pageModel.getTxtFechaDia());
	}

	@Then("^Valido que campo dia de fecha se encuentre habilitado$")
	public void valido_que_campo_dia_de_fecha_se_encuentre_habilitado() throws Throwable {
		boolean condition = BaseFlow.pageModel.getTxtFechaDia().isEnabled();
		if (condition == true) {
			assertTrue(true);
		} else {
			System.out.println("Campo día fecha no se encuentra habilitado");
			assertTrue(false);
		}
	}

	@Then("^Valido que se visualice campo mes de fecha$")
	public void valido_que_se_visualice_campo_mes_de_fecha() throws Throwable {
		//Input text -- Fecha mes
		GenericMethods.isElementPresent(BaseFlow.pageModel.getTxtFechaMes());
	}

	@Then("^Valido que campo mes de fecha se encuentre habilitado$")
	public void valido_que_campo_mes_de_fecha_se_encuentre_habilitado() throws Throwable {
		boolean condition = BaseFlow.pageModel.getTxtFechaMes().isEnabled();
		if (condition == true) {
			assertTrue(true);
		} else {
			System.out.println("Campo mes fecha no se encuentra habilitado");
			assertTrue(false);
		}
	}

	@Then("^Valido que se visualice campo año de fecha$")
	public void valido_que_se_visualice_campo_año_de_fecha() throws Throwable {
		//Input text -- Fecha año
		GenericMethods.isElementPresent(BaseFlow.pageModel.getTxtFechaAño());
	}

	@Then("^Valido que campo año de fecha se encuentre habilitado$")
	public void valido_que_campo_año_de_fecha_se_encuentre_habilitado() throws Throwable {
		boolean condition = BaseFlow.pageModel.getTxtFechaAño().isEnabled();
		if (condition == true) {
			assertTrue(true);
		} else {
			System.out.println("Campo año fecha no se encuentra habilitado");
			assertTrue(false);
		}
	}

	@Then("^Valido que se visualice el label genero$")
	public void valido_que_se_visualice_el_label_genero() throws Throwable {
		//Label -- Genero
		GenericMethods.isElementPresent(BaseFlow.pageModel.getLblGenero());
	}

	@Then("^Valido que el label genero sea el correcto$")
	public void valido_que_el_label_genero_sea_el_correcto() throws Throwable {
		if (BaseFlow.pageModel.getLblGenero().getText().trim().equals(
				BaseFlow.properties.getLabelGenero())) {
			assertTrue(true);
		} else {
			System.out.println("Label genero no es el correcto");
			assertTrue(false);
		}
	}

	@Then("^Valido que se visualice campo genero$")
	public void valido_que_se_visualice_campo_genero() throws Throwable {
		// ListBox -- Genero
		GenericMethods.isElementPresent(BaseFlow.pageModel.getLbxGenero());
	}

	@Then("^Valido que campo genero se encuentre habilitado$")
	public void valido_que_campo_genero_se_encuentre_habilitado() throws Throwable {
		boolean condition = BaseFlow.pageModel.getLbxGenero().isEnabled();
		if (condition == true) {
			assertTrue(true);
		} else {
			System.out.println("Campo genero no se encuentra habilitado");
			assertTrue(false);
		}
	}

	@Then("^Valido que campo genero no se encuentre vacio$")
	public void valido_que_campo_genero_no_se_encuentre_vacio() throws Throwable {
		BaseFlow.pageModel.getLbxGenero().click();
		totalGenero = BaseFlow.pageModel.getListGenero().size();
		//System.out.println("x:"+totalGenero);
		//Thread.sleep(5000);
		if (totalGenero > 0) {
			assertTrue(true);
		} else {
			System.out.println("Campo genero se encuentra vacío");
			assertTrue(false);
		}
	}

	@Then("^Valido que se visualice el label prevision$")
	public void valido_que_se_visualice_el_label_prevision() throws Throwable {
		//Label -- Prevision
		GenericMethods.isElementPresent(BaseFlow.pageModel.getLblPrevision());
	}

	@Then("^Valido que el label prevision sea el correcto$")
	public void valido_que_el_label_prevision_sea_el_correcto() throws Throwable {
		if (BaseFlow.pageModel.getLblPrevision().getText().trim().equals(
				BaseFlow.properties.getLabelPrevisionDatosPaciente())) {
			assertTrue(true);
		} else {
			System.out.println("Label previsión no es correcto");
			assertTrue(false);
		}
	}

	@Then("^Valido que se visualice campo prevision$")
	public void valido_que_se_visualice_campo_prevision() throws Throwable {
		// ListBox -- Prevision
		GenericMethods.isElementPresent(BaseFlow.pageModel.getLbxPrevision());
	}

	@Then("^Valido que campo prevision se encuentre habilitado$")
	public void valido_que_campo_prevision_se_encuentre_habilitado() throws Throwable {
		boolean condition = BaseFlow.pageModel.getLbxPrevision().isEnabled();
		if (condition == true) {
			assertTrue(true);
		} else {
			System.out.println("Campo previsión no se encuentra habilitado");
			assertTrue(false);
		}
	}

	@Then("^Valido que campo prevision no se encuentre vacio$")
	public void valido_que_campo_prevision_no_se_encuentre_vacio() throws Throwable {
		BaseFlow.pageModel.getLbxPrevision().click();
		totalPrevision = BaseFlow.pageModel.getListPrevision().size();
		if (totalPrevision > 0) {
			BaseFlow.pageModel.getListPrevision().get(0).click();
			assertTrue(true);
		} else {
			System.out.println("Campo previsión se encuentra vacío");
			assertTrue(false);
		}
	}

	@Then("^Valido que se visualice el label correo$")
	public void valido_que_se_visualice_el_label_correo() throws Throwable {
		// Label -- Correo
		GenericMethods.isElementPresent(BaseFlow.pageModel.getLblCorreo());
	}

	@Then("^Valido que el label correo sea el correcto$")
	public void valido_que_el_label_correo_sea_el_correcto() throws Throwable {
		if (BaseFlow.pageModel.getLblCorreo().getText().trim().equals(
				BaseFlow.properties.getLabelCorreo())) {
			assertTrue(true);
		} else {
			System.out.println("Label correo no es correcto");
			assertTrue(false);
		}
	}

	@Then("^Valido que se visualice campo correo$")
	public void valido_que_se_visualice_campo_correo() throws Throwable {
		// Input text -- Correo
		GenericMethods.isElementPresent(BaseFlow.pageModel.getTxtCorreo());
	}

	@Then("^Valido que campo correo se encuentre habilitado$")
	public void valido_que_campo_correo_se_encuentre_habilitado() throws Throwable {
		boolean condition = BaseFlow.pageModel.getTxtCorreo().isEnabled();
		if (condition == true) {
			assertTrue(true);
		} else {
			System.out.println("Campo correo no se encuentra habilitado");
			assertTrue(false);
		}
	}

	@Then("^Valido que se visualice el label telefono$")
	public void valido_que_se_visualice_el_label_telefono() throws Throwable {
		// Label -- Telefono
		GenericMethods.isElementPresent(BaseFlow.pageModel.getLblTelefono());
	}

	@Then("^Valido que el label telefono sea el correcto$")
	public void valido_que_el_label_telefono_sea_el_correcto() throws Throwable {
		if (BaseFlow.pageModel.getLblTelefono().getText().trim().equals(
				BaseFlow.properties.getLabelTelefono())) {
			assertTrue(true);
		} else {
			System.out.println("Label teléfono no es correcto");
			assertTrue(false);
		}
	}

	@Then("^Valido que se visualice campo telefono$")
	public void valido_que_se_visualice_campo_telefono() throws Throwable {
		// Input text -- Telefono
		GenericMethods.isElementPresent(BaseFlow.pageModel.getTxtTelefono());
	}

	@Then("^Valido que campo telefono se encuentre habilitado$")
	public void valido_que_campo_telefono_se_encuentre_habilitado() throws Throwable {
		boolean condition = BaseFlow.pageModel.getTxtTelefono().isEnabled();
		if (condition == true) {
			assertTrue(true);
		} else {
			System.out.println("Campo teléfono no se encuentra habilitado");
			assertTrue(false);
		}
	}

	@Then("^Valido que se visualice el label nacionalidad$")
	public void valido_que_se_visualice_el_label_nacionalidad() throws Throwable {
		// Label -- Nacionalidad
		GenericMethods.isElementPresent(BaseFlow.pageModel.getLblNacionalidad());
	}

	@Then("^Valido que el label nacionalidad sea el correcto$")
	public void valido_que_el_label_nacionalidad_sea_el_correcto() throws Throwable {
		if (BaseFlow.pageModel.getLblNacionalidad().getText().trim().equals(
				BaseFlow.properties.getLabelNacionalidad())) {
			assertTrue(true);
		} else {
			System.out.println("Label nacionalidad no es correcto");
			assertTrue(false);
		}
	}

	@Then("^Valido que se visualice campo nacionalidad$")
	public void valido_que_se_visualice_campo_nacionalidad() throws Throwable {
		// ListBox -- Nacionalidad
		GenericMethods.isElementPresent(BaseFlow.pageModel.getLbxNacionalidad());
	}

	@Then("^Valido que campo nacionalidad se encuentre habilitado$")
	public void valido_que_campo_nacionalidad_se_encuentre_habilitado() throws Throwable {
		boolean condition = BaseFlow.pageModel.getLbxNacionalidad().isEnabled();
		if (condition == true) {
			assertTrue(true);
		} else {
			System.out.println("Campo nacionalidad no se encuentra habilitado");
			assertTrue(false);
		}
	}

	@Then("^Valido que campo nacionalidad no se encuentre vacio$")
	public void valido_que_campo_nacionalidad_no_se_encuentre_vacio() throws Throwable {
		BaseFlow.pageModel.getLbxNacionalidad().click();
		totalNacionalidad = BaseFlow.pageModel.getListNacionalidad().size();
		if (totalNacionalidad > 0) {
			BaseFlow.pageModel.getListNacionalidad().get(0).click();
			assertTrue(true);
		} else {
			System.out.println("Campo nacionalidad se encuentra vacío");
			assertTrue(false);
		}
	}

	@Then("^Valido que se visualice el label direccion$")
	public void valido_que_se_visualice_el_label_direccion() throws Throwable {
		// Label -- Direccion
		GenericMethods.isElementPresent(BaseFlow.pageModel.getLblDireccion());
	}

	@Then("^Valido que el label direccion sea el correcto$")
	public void valido_que_el_label_direccion_sea_el_correcto() throws Throwable {
		if(BaseFlow.pageModel.getLblDireccion().getText().trim().equals(
				BaseFlow.properties.getLabelDireccion())) {
			assertTrue(true);
		} else {
			System.out.println("Label dirección no es correcto");
			assertTrue(false);
		}
	}

	@Then("^Valido que se visualice campo direccion$")
	public void valido_que_se_visualice_campo_direccion() throws Throwable {
		// Input text -- Direccion
		GenericMethods.isElementPresent(BaseFlow.pageModel.getTxtDireccion());
	}

	@Then("^Valido que campo direccion se encuentre habilitado$")
	public void valido_que_campo_direccion_se_encuentre_habilitado() throws Throwable {
		boolean condition = BaseFlow.pageModel.getTxtDireccion().isEnabled();
		if (condition == true) {
			assertTrue(true);
		} else {
			System.out.println("Campo dirección no se encuentra habilitado");
			assertTrue(false);
		}
	}

	@Then("^Valido que se visualice campo comuna$")
	public void valido_que_se_visualice_campo_comuna() throws Throwable {
		// Input text -- Comuna
		GenericMethods.isElementPresent(BaseFlow.pageModel.getTxtComuna());
	}

	@Then("^Valido que campo comuna se encuentre habilitado$")
	public void valido_que_campo_comuna_se_encuentre_habilitado() throws Throwable {
		boolean condition = BaseFlow.pageModel.getTxtComuna().isEnabled();
		if (condition == true) {
			assertTrue(true);
		} else {
			System.out.println("Campo comuna no se encuentra habilitado");
			assertTrue(false);
		}
	}

	@Then("^Valido que se visualice campo region$")
	public void valido_que_se_visualice_campo_region() throws Throwable {
		// ListBox -- Regiones
		GenericMethods.isElementPresent(BaseFlow.pageModel.getLbxRegiones());
	}

	@Then("^Valido que campo region se encuentre habilitado$")
	public void valido_que_campo_region_se_encuentre_habilitado() throws Throwable {
		boolean condition = BaseFlow.pageModel.getLbxRegiones().isEnabled();
		if (condition == true) {
			assertTrue(true);
		} else {
			System.out.println("Campo región no se encuentra habilitado");
			assertTrue(false);
		}
	}

	@Then("^Valido que campo region no se encuentre vacio$")
	public void valido_que_campo_region_no_se_encuentre_vacio() throws Throwable {
		BaseFlow.pageModel.getLbxRegiones().click();
		Thread.sleep(1000);
		totalRegiones = BaseFlow.pageModel.getListRegiones().size();
		if (totalRegiones > 0) {
			assertTrue(true);
		} else {
			System.out.println("Campo región se encuentra vacío");
			assertTrue(false);
		}
	}

	@Then("^Valido que se visualice boton guardar$")
	public void valido_que_se_visualice_boton_guardar() throws Throwable {
		// Button -- Guardar
		GenericMethods.isElementPresent(BaseFlow.pageModel.getBtnGuardar());
	}

	@Then("^Llamada al servicio genero$")
	public void llamada_al_servicio_genero() throws Throwable {
		/*
		//llamo al servicio de consulta paciente por rut
		BaseFlow.commJson.setConn(EndPointConn.endPointMasterQa); //La URL del servicio
		BaseFlow.commJson.setRequestMethod("POST"); //Metodo de servicio
		BaseFlow.commJson.setRequestProperty(EndPointConn.requestPropertyHeaderNameOneMasterQa, "Bearer "+tokenService); //Headers y value 1 del servicio
		BaseFlow.commJson.setRequestProperty(EndPointConn.requestPropertyHeaderNameTwoMasterQa, EndPointConn.requestPropertyHeaderValueTwoMasterQa); //Headers y value 2 del servicio
		BaseFlow.commJson.setRequestProperty(EndPointConn.requestPropertyHeaderNameThreeMasterQa, EndPointConn.requestPropertyHeaderValueThreeMasterQa); //Headers y value 3 del servicio			
		//String bodyPost = "{\"tipo\" : \""+ 02 +"\"}"; //Value en body
		String bodyPost = "{\"tipo\" : \"02\"}"; //Value en body
		BaseFlow.commJson.postParametros(bodyPost);
		if (BaseFlow.commJson.getResponseCode() == 200) {
			assertTrue(true);
			//se genera array de body
			JSONObject obj = new JSONObject(BaseFlow.commJson.getJsonData());
			if(obj.length() > 0) {
				assertTrue(true);
			} else {
				System.out.println("Servicio maestro genero por rut no devuelve datos");
				assertTrue(false);
			}
		} else {
			System.out.println("Servicio maestro genero por rut no responde");
			assertTrue(false);
		}
		*/
	}

	@Then("^Selecciono todas las opciones de genero$")
	public void selecciono_todas_las_opciones_de_genero() throws Throwable {
	
	}

	@Then("^Valido que las cantidades de genero coincidan entre lo desplegado en la web y el servicio$")
	public void valido_que_las_cantidades_de_genero_coincidan_entre_lo_desplegado_en_la_web_y_el_servicio() throws Throwable {
	
	}

	@Then("^Llamada al servicio prevision$")
	public void llamada_al_servicio_prevision() throws Throwable {
	
	}

	@Then("^Selecciono todas las opciones de prevision$")
	public void selecciono_todas_las_opciones_de_prevision() throws Throwable {
	
	}

	@Then("^Valido que las cantidades de prevision coincidan entre lo desplegado en la web y el servicio$")
	public void valido_que_las_cantidades_de_prevision_coincidan_entre_lo_desplegado_en_la_web_y_el_servicio() throws Throwable {
	
	}

	@Then("^Llamada al servicio region$")
	public void llamada_al_servicio_region() throws Throwable {
	
	}

	@Then("^Selecciono todas las opciones de region$")
	public void selecciono_todas_las_opciones_de_region() throws Throwable {
	
	}

	@Then("^Valido que las cantidades de region coincidan entre lo desplegado en la web y el servicio$")
	public void valido_que_las_cantidades_de_region_coincidan_entre_lo_desplegado_en_la_web_y_el_servicio() throws Throwable {
	
	}
	
	@When("^Ingreso dato nombres \"(.*?)\"$")
	public void ingreso_dato_nombres(String nombres) throws Throwable {
	    BaseFlow.pageModel.getTxtNombres().sendKeys(nombres);
	}

	@When("^Valido que campo nombres no se encuentre vacio$")
	public void valido_que_campo_nombres_no_se_encuentre_vacio() throws Throwable {
	    int data = BaseFlow.pageModel.getTxtNombres().getAttribute("value").length();	    	    
	    if (data > 0) {
	    	assertTrue(true);
	    } else {
	    	System.out.println("Campo nombres se encuentra vacío");
	    	assertTrue(false);
	    }
	}

	@When("^Ingreso dato apellido materno \"(.*?)\"$")
	public void ingreso_dato_apellido_materno(String apellidoMaterno) throws Throwable {		
		BaseFlow.pageModel.getTxtApellidoMaterno().sendKeys(apellidoMaterno);
	}

	@When("^Valido campo apellido matereno no se encuentre vacio$")
	public void valido_campo_apellido_matereno_no_se_encuentre_vacio() throws Throwable {
	    int data = BaseFlow.pageModel.getTxtApellidoMaterno().getAttribute("value").length();
	    if (data > 0) {
	    	assertTrue(true);
	    } else {
	    	System.out.println("Campo apellido materno se encuentra vacío");
	    	assertTrue(false);
	    }
	}

	@When("^Ingreso dato apellido paterno \"(.*?)\"$")
	public void ingreso_dato_apellido_paterno(String apellidoPaterno) throws Throwable {
		BaseFlow.pageModel.getTxtApellidoPaterno().sendKeys(apellidoPaterno);
	}

	@When("^Valido que campo apellido paterno no se encuentre vacio$")
	public void valido_que_campo_apellido_paterno_no_se_encuentre_vacio() throws Throwable {
		int data = BaseFlow.pageModel.getTxtApellidoPaterno().getAttribute("value").length();
	    if (data > 0) {
	    	assertTrue(true);
	    } else {
	    	System.out.println("Campo apellido paterno se encuentra vacío");
	    	assertTrue(false);
	    }
	}

	@When("^Ingreso dato dia fecha nacimiento \"(.*?)\"$")
	public void ingreso_dato_dia_fecha_nacimiento(String dia) throws Throwable {
	    BaseFlow.pageModel.getTxtFechaDia().sendKeys(dia);
	}

	@When("^Valido que campo dia fecha nacimiento no se encuentre vacio$")
	public void valido_que_campo_dia_fecha_nacimiento_no_se_encuentre_vacio() throws Throwable {
		int data = BaseFlow.pageModel.getTxtFechaDia().getAttribute("value").length();
	    if (data > 0) {
	    	assertTrue(true);
	    } else {
	    	System.out.println("Campo dia fecha nacimiento se encuentra vacío");
	    	assertTrue(false);
	    }
	}

	@When("^Ingreso dato mes fecha nacimiento \"(.*?)\"$")
	public void ingreso_dato_mes_fecha_nacimiento(String mes) throws Throwable {
		BaseFlow.pageModel.getTxtFechaMes().sendKeys(mes);
	}

	@When("^Valido que campo mes fecha nacimiento no se encuentre vacio$")
	public void valido_que_campo_mes_fecha_nacimiento_no_se_encuentre_vacio() throws Throwable {
		int data = BaseFlow.pageModel.getTxtFechaMes().getAttribute("value").length();
	    if (data > 0) {
	    	assertTrue(true);
	    } else {
	    	System.out.println("Campo mes fecha nacimiento se encuentra vacío");
	    	assertTrue(false);
	    }
	}

	@When("^Ingreso dato año fecha nacimiento \"(.*?)\"$")
	public void ingreso_dato_año_fecha_nacimiento(String año) throws Throwable {
		BaseFlow.pageModel.getTxtFechaAño().sendKeys(año);
	}

	@When("^Valido que campo año fecha nacimiento no se encuentre vacio$")
	public void valido_que_campo_año_fecha_nacimiento_no_se_encuentre_vacio() throws Throwable {
		int data = BaseFlow.pageModel.getTxtFechaAño().getAttribute("value").length();
	    if (data > 0) {
	    	assertTrue(true);
	    } else {
	    	System.out.println("Campo año fecha nacimiento se encuentra vacío");
	    	assertTrue(false);
	    }
	}

	@When("^Seleccion genero \"(.*?)\"$")
	public void seleccion_genero(String genero) throws Throwable {
	    BaseFlow.pageModel.getLbxGenero().click();
	    //BaseFlow.pageModel.getListGenero().get(0);
	    BaseFlow.pageModel.getListGenero().get(Integer.parseInt(genero)).click();
	}

	@When("^Seleccion prevision \"(.*?)\"$")
	public void seleccion_prevision(String prevision) throws Throwable {
	    BaseFlow.pageModel.getLbxPrevision().click();
	    BaseFlow.pageModel.getListPrevision().get(Integer.parseInt(prevision)).click();
	}

	@When("^Ingreso dato correo \"(.*?)\"$")
	public void ingreso_dato_correo(String correo) throws Throwable {
	    BaseFlow.pageModel.getTxtCorreo().sendKeys(correo);
	}

	@When("^Valido que campo correo no se encuentre vacio$")
	public void valido_que_campo_correo_no_se_encuentre_vacio() throws Throwable {
	    int data = BaseFlow.pageModel.getTxtCorreo().getAttribute("value").length();
	    if(data > 0) {
	    	assertTrue(true);
	    } else {
	    	System.out.println("Campo correo se encuentra vacío");
	    	assertTrue(false);
	    }
	}

	@When("^Ingreso dato telefono \"(.*?)\"$")
	public void ingreso_dato_telefono(String telefono) throws Throwable {
	    BaseFlow.pageModel.getTxtTelefono().sendKeys(telefono);
	}

	@When("^Valido que campo telefono no se encuentre vacio$")
	public void valido_que_campo_telefono_no_se_encuentre_vacio() throws Throwable {
		int data = BaseFlow.pageModel.getTxtTelefono().getAttribute("value").length();
	    if(data > 0) {
	    	assertTrue(true);
	    } else {
	    	System.out.println("Campo teléfono se encuentra vacío");
	    	assertTrue(false);
	    }
	}

	@When("^Seleccion nacionalidad \"(.*?)\"$")
	public void seleccion_nacionalidad(String nacionalidad) throws Throwable {
		BaseFlow.pageModel.getLbxNacionalidad().click();
	    BaseFlow.pageModel.getListNacionalidad().get(Integer.parseInt(nacionalidad)).click();
	}

	@When("^Ingreso dato direccion \"(.*?)\"$")
	public void ingreso_dato_direccion(String direccion) throws Throwable {
	    BaseFlow.pageModel.getTxtDireccion().sendKeys(direccion);
	}

	@When("^Valido que campo dirfeccion no se encuentre vacio$")
	public void valido_que_campo_dirfeccion_no_se_encuentre_vacio() throws Throwable {
		int data = BaseFlow.pageModel.getTxtDireccion().getAttribute("value").length();
	    if(data > 0) {
	    	assertTrue(true);
	    } else {
	    	System.out.println("Campo dirección se encuentra vacío");
	    	assertTrue(false);
	    }
	}

	@When("^Ingreso dato comuna \"(.*?)\"$")
	public void ingreso_dato_comuna(String comuna) throws Throwable {
	    BaseFlow.pageModel.getTxtComuna().sendKeys(comuna);
	}

	@When("^Valido que campo comuna no se encuentre vacio$")
	public void valido_que_campo_comuna_no_se_encuentre_vacio() throws Throwable {
		int data = BaseFlow.pageModel.getTxtComuna().getAttribute("value").length();
	    if(data > 0) {
	    	assertTrue(true);
	    } else {
	    	System.out.println("Campo comuna se encuentra vacío");
	    	assertTrue(false);
	    }
	}

	@When("^Seleccion region \"(.*?)\"$")
	public void seleccion_region(String region) throws Throwable {
	    BaseFlow.pageModel.getLbxRegiones().click();
	    BaseFlow.pageModel.getListRegiones().get(Integer.parseInt(region)).click();
	}

	@Then("^Valido que boton guardar se encuentre habilitado$")
	public void valido_que_boton_guardar_se_encuentre_habilitado() throws Throwable {
	    boolean condition = BaseFlow.pageModel.getBtnGuardar().isEnabled();
	    if (condition == true) {
	    	assertTrue(true);
	    } else {
	    	System.out.println("Botón guardar no se encuentra habilitado");
	    	assertTrue(false);
	    }
	}

	@Then("^Precionar boton guardar$")
	public void precionar_boton_guardar() throws Throwable {
		BaseFlow.pageModel.getBtnGuardar().click();
	}

	@When("^Valido despliegue ventana$")
	public void valido_despliegue_ventana() throws Throwable {
		//espero hasta que ventana de crear y editar paciente se despliegue
		GenericMethods.waitTime(BaseFlow.pageModel.getMdlRutFail());
		GenericMethods.isElementPresent(BaseFlow.pageModel.getMdlRutFail());
	}

	@Then("^Valido que aparezca titulo de la ventana desplegada$")
	public void valido_que_aparezca_titulo_de_la_ventana_desplegada() throws Throwable {
	    GenericMethods.isElementPresent(BaseFlow.pageModel.getLblPacienteFail());
	}
	
	@Then("^Valido que titulo sea el correcto$")
	public void valido_que_titulo_sea_el_correcto() throws Throwable {
	    if (BaseFlow.pageModel.getLblPacienteFail().getText().trim().equals(
	    		BaseFlow.properties.getLabelDatosGuardados())) {
	    	assertTrue(true);
	    } else {
	    	System.out.println("Tìtulo datos guardaos no es correcto");
	    	assertTrue(false);
	    }
	}
	
	@Then("^Valido que aparezca imagen de exito$")
	public void valido_que_aparezca_imagen_de_exito() throws Throwable {
	    GenericMethods.isElementPresent(BaseFlow.pageModel.getImgIconoFail());
	}

	@Then("^Valido que aparezca mensaje de exito$")
	public void valido_que_aparezca_mensaje_de_exito() throws Throwable {
	    GenericMethods.isElementPresent(BaseFlow.pageModel.getPrfMensajeFail());
	}
	
	@Then("^Valido que aparezca boton aceptar$")
	public void valido_que_aparezca_boton_aceptar() throws Throwable {
	    GenericMethods.isElementPresent(BaseFlow.pageModel.getBtnAceptarFail());
	}

	@Then("^Valido que boton aceptar se encuentre habilitado$")
	public void valido_que_boton_aceptar_se_encuentre_habilitado() throws Throwable {
	    boolean condition = BaseFlow.pageModel.getBtnAceptarFail().isEnabled();
	    if (condition == true) {
	    	assertTrue(true);
	    } else {
	    	System.out.println("Botón aceptar no se encuentra habilitado");
	    	assertTrue(false);
	    }
	}

	@Then("^Presionar boton aceptar$")
	public void presionar_boton_aceptar() throws Throwable {
		BaseFlow.pageModel.getBtnAceptarFail().click();
	}
	
	@Then("^Valido que aparezca ventana de inicio$")
	public void valido_que_aparezca_ventana_de_inicio() throws Throwable {
		Thread.sleep(2000);
		// Div - Menu inicial principal
	    GenericMethods.isElementPresent(BaseFlow.pageModel.getDivMenuInicialPrincipal());
	}
	
	@Then("^Valido que campo rut no se encuentre vacio$")
	public void valido_que_campo_rut_no_se_encuentre_vacio() throws Throwable {
		value = BaseFlow.pageModel.getTxtInputRut().getAttribute("value");
		if (value != null || !value.equals("")) {
			assertTrue(true);			
		} else {
			assertTrue(false);
			System.out.println("Campo ingreso rut no muestra rut y se encuentra vacío");
		}
	}

	@Then("^Valido que en campo busqueda rut muestre el rut del paciente \"(.*?)\"$")
	public void valido_que_en_campo_busqueda_rut_muestre_el_rut_del_paciente(String rutSearchSearch) throws Throwable {
	    if (value.equals(rutSearchSearch)) {
	    	assertTrue(true);
	    } else {
	    	System.out.println("Campo búsqueda rut muestra un rut distinto al creado en datos paciente");
	    	assertTrue(false);
	    }
	}
}