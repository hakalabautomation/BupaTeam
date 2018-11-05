package cl.bupa.qa.automation.web.poc.definition.components;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.codehaus.jettison.json.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import cl.bupa.qa.automation.web.business.flow.BaseFlow;
import cl.bupa.qa.automation.web.json.conn.EndPointConn;
import cl.bupa.qa.automation.web.poc.util.GenericMethods;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class DefinitionComponentBusquedaPacienteOCMPendientesPestañaPorGestionar {
	
	private static String tokenService;
	private static String generoInit;
	private static String[] parts;
	private static String genero;
	private static String edad;
	private static int totalGenero;
	private static int totalPrevision;
	private static int totalNacionalidad;
	private static int totalRegiones;
	private static int totalOrdenesPorGestionar;
	private static int totalBotonesAperturaOrdenesPorAgendar;
	private static int totalItemDetallePrestaciones;
	private static int totalListadoHorasDisponibles;
	private static int totalBotonMasOpciones;
	private static int totalCentrosMedico;
	private static int totalListadoMasOpciones;
	
	@When("^Realizo un refresco a la pagina principal$")
	public void realizo_un_refresco_a_la_pagina_principal() throws Throwable {
	    BaseFlow.driver.navigate().refresh();
	    //tiempo de espera
	    Thread.sleep(3000);
	}

	@Then("^Valido que no se visualice seccion datos del paciente$")
	public void valido_que_no_se_visualice_seccion_datos_del_paciente() throws Throwable {
		// Div -- Paciente encontrado
		GenericMethods.isNotElementPresent(BaseFlow.pageModel.getDivPacienteEncontrado());
	}

	@Then("^Valido que no se muestre imagen paciente$")
	public void valido_que_no_se_muestre_imagen_paciente() throws Throwable {
		// Img -- Icono Paciente
		GenericMethods.isNotElementPresent(BaseFlow.pageModel.getImgIconoPaciente());
	}

	@Then("^Valido que no se muestre nombre paciente$")
	public void valido_que_no_se_muestre_nombre_paciente() throws Throwable {
		// H5 -- Nombre paciente
		GenericMethods.isNotElementPresent(BaseFlow.pageModel.gethFiveNombrePaciente());
	}

	@Then("^Valido que no se muestre genero y edad paciente$")
	public void valido_que_no_se_muestre_genero_y_edad_paciente() throws Throwable {
		// Label -- Genero/Edad paciente
		GenericMethods.isNotElementPresent(BaseFlow.pageModel.getLblGeneroAndEdadPaciente());
	}

	@Then("^Valido que no se muestre correo$")
	public void valido_que_no_se_muestre_correo() throws Throwable {
		// Label -- Correo paciente
		GenericMethods.isNotElementPresent(BaseFlow.pageModel.getLblCorreoPaciente());
	}

	@Then("^Valido que no se muestre telefono$")
	public void valido_que_no_se_muestre_telefono() throws Throwable {	    
		// Label -- Telefono paciente
		GenericMethods.isNotElementPresent(BaseFlow.pageModel.getLblTelefono());
	}

	@Then("^Valido que no se muestre rut$")
	public void valido_que_no_se_muestre_rut() throws Throwable {
		// Label -- Rut paciente
		GenericMethods.isNotElementPresent(BaseFlow.pageModel.getLblRutPaciente());
	}

	@Then("^Valido que no se muestre prevision$")
	public void valido_que_no_se_muestre_prevision() throws Throwable {
		// Label -- Prevision paciente
		GenericMethods.isNotElementPresent(BaseFlow.pageModel.getLblPrevisionPaciente());
	}

	@Then("^Valido que no se muestre link editar informacion paciente$")
	public void valido_que_no_se_muestre_link_editar_informacion_paciente() throws Throwable {
		// Link -- Editar informacion paciente
		GenericMethods.isNotElementPresent(BaseFlow.pageModel.getLnkEditarInformacionPaciente());
	}

	@Then("^Valido que no se muestre boton nueva reserva de hora$")
	public void valido_que_no_se_muestre_boton_nueva_reserva_de_hora() throws Throwable {
		// Button -- Nueva reserva hora
		GenericMethods.isNotElementPresent(BaseFlow.pageModel.getBtnNuevaReservaHora());
	}
	
	@Given("^Ingreso rut de paciente a buscar \"(.*?)\"$")
	public void ingreso_rut_de_paciente_a_buscar(String rut) throws Throwable {
		//borrar campo rut
		BaseFlow.pageModel.getTxtInputRut().clear();
		//Input Text -- Rut a buscar		
	    BaseFlow.pageModel.getTxtInputRut().sendKeys(rut);
	    BaseFlow.pageModel.getTxtInputRut().sendKeys(Keys.TAB);	   
	    Thread.sleep(2000);
	}

	@When("^Llamo a servicio obtencion de token \"(.*?)\" \"(.*?)\"$")
	public void llamo_a_servicio_obtencion_de_token(String usuario, String contraseña) throws Throwable {
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

	@Then("^Valido que paciente exista en el servicio$")
	public void valido_que_paciente_exista_en_el_servicio() throws Throwable {
	    
	}

	@Then("^Presiono boton de buscar$")
	public void presiono_boton_de_buscar() throws Throwable {
		//Button -- Consultar
	    BaseFlow.pageModel.getBtnConsultar().sendKeys(Keys.ENTER);
	    Thread.sleep(4000);    
	}

	@Given("^Llamo al servicio de paciente con ocm pendientes \"(.*?)\"$")
	public void llamo_al_servicio_de_paciente_con_ocm_pendientes(String rut) throws Throwable {
	    
	    
	}

	@When("^Valido que servicio paciente con OCM pendientes retorne datos$")
	public void valido_que_servicio_paciente_con_OCM_pendientes_retorne_datos() throws Throwable {
	    
	    
	}

	@Then("^Valido que paciente tenga ocm pendientes$")
	public void valido_que_paciente_tenga_ocm_pendientes() throws Throwable {
	    
	}

	@Given("^Valido que se visualice pantalla OCM pendientes$")
	public void valido_que_se_visualice_pantalla_OCM_pendientes() throws Throwable {
		// Div -- Ocm pendientes paciente
		GenericMethods.isElementPresent(BaseFlow.pageModel.getDivOcmPendientesPacienteSeccionGeneral().get(0));
	}

	@Given("^Valido que se visualice seccion informacion pacientes$")
	public void valido_que_se_visualice_seccion_informacion_pacientes() throws Throwable {
		// Div -- Seccion informacion paciente
		GenericMethods.isElementPresent(BaseFlow.pageModel.getDivSeccionInformacionPaciente().get(0));
	}

	@When("^Valido que se visualice imagen de paciente$")
	public void valido_que_se_visualice_imagen_de_paciente() throws Throwable {
		// Img -- Icono paciente ocm pendiente
		GenericMethods.isElementPresent(BaseFlow.pageModel.getImgIconoPacienteOcmPendiente());
	}


	@Then("^Valido que se visualice nombre del paciente$")
	public void valido_que_se_visualice_nombre_del_paciente() throws Throwable {
		// H5 -- Nombre paciente ocm pendiente
	    GenericMethods.isElementPresent(BaseFlow.pageModel.gethFiveNombrePacienteOcmPendiente());
	}

	@Then("^Valido que se visualice genero del paciente$")
	public void valido_que_se_visualice_genero_del_paciente() throws Throwable {	    
		// Label -- Genero y fecha nacimiento
		generoInit = BaseFlow.pageModel.getLblGeneroFechaNacimientoOcmPendiente().getText().trim();
	    parts = generoInit.split(" | ");
	    genero = parts[0].trim();//genero M o F
	    if (genero.equals("M") || genero.equals("F")) {
	    	assertTrue(true);
	    } else {
	    	System.out.println("No se muestra genero de paciente con OCM pendiente");
	    	assertTrue(false);
	    }
	}

	@Then("^Valido que se visualice años del paciente$")
	public void valido_que_se_visualice_años_del_paciente() throws Throwable {
	    edad = parts[2].trim();
	    if (!edad.equals("") || edad != null) {
	    	assertTrue(true);
	    } else {
	    	System.out.println("No se muestra edad de paciente con OCM pendiente");
	    	assertTrue(false);
	    }
	}

	@Then("^Valido que se visualice correo del paciente$")
	public void valido_que_se_visualice_correo_del_paciente() throws Throwable {
		// Label -- Correo
		GenericMethods.isElementPresent(BaseFlow.pageModel.getLblCorreoOcmPendiente());
	}

	@Then("^Valido que se visualice numero telefono del paciente$")
	public void valido_que_se_visualice_numero_telefono_del_paciente() throws Throwable {
		// Label -- Telefono
		GenericMethods.isElementPresent(BaseFlow.pageModel.getLblTelefonoOcmPendiente());
	}

	@Then("^Valido que se visualice rut del paciente$")
	public void valido_que_se_visualice_rut_del_paciente() throws Throwable {
		// Label -- Rut
	    GenericMethods.isElementPresent(BaseFlow.pageModel.getLblRutOcmPendiente());
	}

	@Then("^Valido que se visualice prevision del paciente$")
	public void valido_que_se_visualice_prevision_del_paciente() throws Throwable {
		// Label -- Prevision
	    GenericMethods.isElementPresent(BaseFlow.pageModel.getLblPrevisionOcmPendiente());
	}

	@Then("^Valido que se visualice link datos del paciente$")
	public void valido_que_se_visualice_link_datos_del_paciente() throws Throwable {
		// Link -- Datos paciente
	    GenericMethods.isElementPresent(BaseFlow.pageModel.getLnkDatosPacienteOcmPendiente().get(0));
	}

	@Then("^Valido que link datos del paciente sea correcto$")
	public void valido_que_link_datos_del_paciente_sea_correcto() throws Throwable {
	    if (BaseFlow.pageModel.getLnkDatosPacienteOcmPendiente().get(0).getAttribute("innerText").equals(
	    		BaseFlow.properties.getLabelEditarInformacionPaciente())) {
	    	assertTrue(true);
	    } else {
	    	System.out.println("Link de datos del paciente no es correcto");
	    	assertTrue(false);
	    }
	}
	
	@Then("^Valido que se visualice seccion de botoneras acciones reservas$")
	public void valido_que_se_visualice_seccion_de_botoneras_acciones_reservas() throws Throwable {
		// Div -- Botonora nuevas reservas
		GenericMethods.isElementPresent(BaseFlow.pageModel.getDivBotoneraNuevasReservasOcmPendiente().get(0));
	}

	@Then("^Valido que se visualice boton nueva reserva de hora$")
	public void valido_que_se_visualice_boton_nueva_reserva_de_hora() throws Throwable {
		// Button -- Nueva reserva hora
		GenericMethods.isElementPresent(BaseFlow.pageModel.getBtnNuevaReservaHoraOcmPendiente());
	}

	@Then("^Valido que boton nueva reserva de hora sea correcto$")
	public void valido_que_boton_nueva_reserva_de_hora_sea_correcto() throws Throwable {	    
	    if (BaseFlow.pageModel.getBtnNuevaReservaHoraOcmPendiente().getAttribute("innerText").equals(
	    		BaseFlow.properties.getLabelNuevaReservaDeHora())) {
	    	assertTrue(true);
	    } else {
	    	System.out.println("Botón nueva reserva de hora no es correcto");
	    	assertTrue(false);
	    }
	}

	@Then("^Valido que boton nueva reserva de hora se encuentre estado habilitado$")
	public void valido_que_boton_nueva_reserva_de_hora_se_encuentre_estado_habilitado() throws Throwable {
	    boolean condition = BaseFlow.pageModel.getBtnNuevaReservaHoraOcmPendiente().isEnabled();
	    if (condition == true) {
	    	assertTrue(true);
	    } else {
	    	System.out.println("Botón nueva reserva de hora no se encuentra habilitado");
	    	assertTrue(false);
	    }
	}

	@Then("^Valido que se visualice boton reservar por hora y precio$")
	public void valido_que_se_visualice_boton_reservar_por_hora_y_precio() throws Throwable {
		
	}

	@Then("^Valido que boton reservar por hora y precio sea correcto$")
	public void valido_que_boton_reservar_por_hora_y_precio_sea_correcto() throws Throwable {
	    	    
	}

	@Then("^Valido que boton reservar por hora y precio se encuentre estado habilitado$")
	public void valido_que_boton_reservar_por_hora_y_precio_se_encuentre_estado_habilitado() throws Throwable {
		
	}

	@Then("^Valido que se visualice boton reenviar email agendar$")
	public void valido_que_se_visualice_boton_reenviar_email_agendar() throws Throwable {
	    	    
	}

	@Then("^Valido que boton reenviar email agendar sea correcto$")
	public void valido_que_boton_reenviar_email_agendar_sea_correcto() throws Throwable {
	    
	    
	}

	@Then("^Valido que boton reenviar email agendar se encuentre estado habilitado$")
	public void valido_que_boton_reenviar_email_agendar_se_encuentre_estado_habilitado() throws Throwable {
	    
	    
	}

	@Then("^Valido que se visualice checkbox llamar en otro momento$")
	public void valido_que_se_visualice_checkbox_llamar_en_otro_momento() throws Throwable {
	    
	}

	@Then("^Valido que texto llamar en otro momento sea correcto$")
	public void valido_que_texto_llamar_en_otro_momento_sea_correcto() throws Throwable {
	    
	}

	@Then("^Valido que se visualice checkbox no quiero hacer los examenes$")
	public void valido_que_se_visualice_checkbox_no_quiero_hacer_los_examenes() throws Throwable {
	    
	}

	@Then("^Valido que texto no quiero hacer los examenes sea correcto$")
	public void valido_que_texto_no_quiero_hacer_los_examenes_sea_correcto() throws Throwable {
	    
	}

	@Then("^Valido que se visualice checkbox no quiero que lo contacten$")
	public void valido_que_se_visualice_checkbox_no_quiero_que_lo_contacten() throws Throwable {
	    
	}

	@Then("^Valido que texto no quiero que lo contacten sea correcto$")
	public void valido_que_texto_no_quiero_que_lo_contacten_sea_correcto() throws Throwable {
	    
	}

	@Then("^Valido que se visualice checkbox paciente incontactable$")
	public void valido_que_se_visualice_checkbox_paciente_incontactable() throws Throwable {
	    
	}

	@Then("^Valido que texto paciente incontactable sea correcto$")
	public void valido_que_texto_paciente_incontactable_sea_correcto() throws Throwable {
	    
	}

	@Given("^Valido que link datos del paciente se encuentre habilitado$")
	public void valido_que_link_datos_del_paciente_se_encuentre_habilitado() throws Throwable {
		// Link -- Datos paciente
		boolean condition = BaseFlow.pageModel.getLnkDatosPacienteOcmPendiente().get(0).isEnabled();
		if (condition == true) {
			assertTrue(true);
		} else {
			System.out.println("Link datos del paciente no se encuentra habilitado");
			assertTrue(false);
		}
	}

	@When("^Realizar click en  link datos del paciente$")
	public void realizar_click_en_link_datos_del_paciente() throws Throwable {
		BaseFlow.pageModel.getLnkDatosPacienteOcmPendiente().get(0).click();
	}

	@Then("^Valido que se visualice despliegue ventana editar paciente$")
	public void valido_que_se_visualice_despliegue_ventana_editar_paciente() throws Throwable {
		//espero hasta que ventana de crear y editar paciente se despliegue
		GenericMethods.waitTime(BaseFlow.pageModel.getDivCrearEditarPaciente());
		// Div -- Crear y editar paciente
		GenericMethods.isElementPresent(BaseFlow.pageModel.getDivCrearEditarPaciente());
	}
	
	@Then("^Valido que se visualice el boton x para cerrar ventana$")
	public void valido_que_se_visualice_el_boton_x_para_cerrar_ventana() throws Throwable {
		// Button -- Close
		GenericMethods.isElementPresent(BaseFlow.pageModel.getBtnClose());
	}
	
	@Then("^Valido que se visualice titulo de editar datos paciente$")
	public void valido_que_se_visualice_titulo_de_editar_datos_paciente() throws Throwable {
		//H5 -- Crear y editar datos paciente
		GenericMethods.isElementPresent(BaseFlow.pageModel.gethFiveTituloCrearEditarDatosPaciente());
	}
	
	@Then("^Valido que titulo que se visualiza sobre editar datos paciente sea el correcto$")
	public void valido_que_titulo_que_se_visualiza_sobre_editar_datos_paciente_sea_el_correcto() throws Throwable {
	    if (BaseFlow.pageModel.gethFiveTituloCrearEditarDatosPaciente().getText().trim().equals(
	    		BaseFlow.properties.getLabelEditarDatosPaciente())) {
	    	assertTrue(true);
	    } else {
	    	System.out.println("Título editar datos paciente no es correcto");
	    	assertTrue(false);
	    }
	}
	
	@Then("^Valido que se visualice label de rut$")
	public void valido_que_se_visualice_label_de_rut() throws Throwable {
		// Label -- Rut paciente
		GenericMethods.isElementPresent(BaseFlow.pageModel.getLblRut());
	}
	
	@Then("^Valido que el label rut sea correcto$")
	public void valido_que_el_label_rut_sea_correcto() throws Throwable {
		if (BaseFlow.pageModel.getLblRut().getText().trim().equals(
				BaseFlow.properties.getLabelRutDatosPaciente())) {
			assertTrue(true);
		} else {
			System.out.println("Label rut no es correcto");
			assertTrue(false);
		}
	}

	@Then("^Valido que se visualice campo de rut$")
	public void valido_que_se_visualice_campo_de_rut() throws Throwable {
		//Input text -- Rut
		GenericMethods.isElementPresent(BaseFlow.pageModel.getTxtRut());
	}

	@Then("^Valido que campo de rut no se encuentre habilitado$")
	public void valido_que_campo_de_rut_no_se_encuentre_habilitado() throws Throwable {
		boolean condition = BaseFlow.pageModel.getTxtRut().isEnabled();
		if (condition == false) {
			assertTrue(true);
		} else {
			System.out.println("Campo rut no se encuentra deshabilitado");
			assertTrue(false);
		}
	}

	@Then("^Valido que se visualice label de nombres$")
	public void valido_que_se_visualice_label_de_nombres() throws Throwable {
		//Label -- Nombres
		GenericMethods.isElementPresent(BaseFlow.pageModel.getLblNombres());
	}
	
	@Then("^Valido que el label nombres sea correcto$")
	public void valido_que_el_label_nombres_sea_correcto() throws Throwable {
		if (BaseFlow.pageModel.getLblNombres().getText().trim().equals(
				BaseFlow.properties.getLabelNombres())) {
			assertTrue(true);
		} else {
			System.out.println("Label nombres no es correcto");
			assertTrue(false);
		}
	}

	@Then("^Valido que se visualice campo de nombres$")
	public void valido_que_se_visualice_campo_de_nombres() throws Throwable {
		//Input text -- Nombres
		GenericMethods.isElementPresent(BaseFlow.pageModel.getTxtNombres());
	}

	@Then("^Valido que se visualice label de apellidos$")
	public void valido_que_se_visualice_label_de_apellidos() throws Throwable {
		//Label -- Apellidos
		GenericMethods.isElementPresent(BaseFlow.pageModel.getLblApellidos());
	}
	
	@Then("^Valido que el label apellidos sea correcto$")
	public void valido_que_el_label_apellidos_sea_correcto() throws Throwable {
		if (BaseFlow.pageModel.getLblApellidos().getText().trim().equals(
				BaseFlow.properties.getLabelApellidos())) {
			assertTrue(true);
		} else {
			System.out.println("Label apellidos no es correcto");
			assertTrue(false);
		}
	}

	@Then("^Valido que se visualice campo de apellido paterno$")
	public void valido_que_se_visualice_campo_de_apellido_paterno() throws Throwable {
		//Input text -- Apellido paterno
		GenericMethods.isElementPresent(BaseFlow.pageModel.getTxtApellidoPaterno());
	}

	@Then("^Valido que se visualice campo de apellido materno$")
	public void valido_que_se_visualice_campo_de_apellido_materno() throws Throwable {
		//Input text -- Apellido materno
		GenericMethods.isElementPresent(BaseFlow.pageModel.getTxtApellidoMaterno());
	}

	@Then("^Valido que se visualice label de fecha de nacimiento$")
	public void valido_que_se_visualice_label_de_fecha_de_nacimiento() throws Throwable {
		//Label -- Fecha nacimiento
		GenericMethods.isElementPresent(BaseFlow.pageModel.getLblFechaNacimiento());    
	}

	@Then("^Valido que el label fecha de nacimiento sea correcto$")
	public void valido_que_el_label_fecha_de_nacimiento_sea_correcto() throws Throwable {
		if (BaseFlow.pageModel.getLblFechaNacimiento().getText().trim().equals(
				BaseFlow.properties.getLabelFechaDeNacimiento())) {
			assertTrue(true);
		} else {
			System.out.println("Label fecha nacimiento no es el correcto");
			assertTrue(false);
		}
	}
	
	@Then("^Valido que se visualice campo de fecha dia$")
	public void valido_que_se_visualice_campo_de_fecha_dia() throws Throwable {
		//Input text -- Fecha dia
		GenericMethods.isElementPresent(BaseFlow.pageModel.getTxtFechaDia());
	}

	@Then("^Valido que se visualice campo de fecha mes$")
	public void valido_que_se_visualice_campo_de_fecha_mes() throws Throwable {
		//Input text -- Fecha mes
		GenericMethods.isElementPresent(BaseFlow.pageModel.getTxtFechaMes());
	}
	
	@Then("^Valido que se visualice campo de fecha año$")
	public void valido_que_se_visualice_campo_de_fecha_año() throws Throwable {
		//Input text -- Fecha año
		GenericMethods.isElementPresent(BaseFlow.pageModel.getTxtFechaAño());
	}
	
	@Then("^Valido que se visualice label de genero$")
	public void valido_que_se_visualice_label_de_genero() throws Throwable {
		//Label -- Genero
		GenericMethods.isElementPresent(BaseFlow.pageModel.getLblGenero());
	}
	
	@Then("^Valido que el label genero sea correcto$")
	public void valido_que_el_label_genero_sea_correcto() throws Throwable {
		if (BaseFlow.pageModel.getLblGenero().getText().trim().equals(
				BaseFlow.properties.getLabelGenero())) {
			assertTrue(true);
		} else {
			System.out.println("Label genero no es el correcto");
			assertTrue(false);
		}		
	}

	@Then("^Valido que se visualice campo de genero$")
	public void valido_que_se_visualice_campo_de_genero() throws Throwable {
		// ListBox -- Genero
		GenericMethods.isElementPresent(BaseFlow.pageModel.getLbxGenero());
	}
	
	@Then("^Valido campo genero no se encuentre vacio$")
	public void valido_campo_genero_no_se_encuentre_vacio() throws Throwable {
		BaseFlow.pageModel.getLbxGenero().click();
		totalGenero = BaseFlow.pageModel.getListGenero().size();
		if (totalGenero > 0) {
			BaseFlow.pageModel.getListGenero().get(1).click();			
			assertTrue(true);
		} else {
			System.out.println("Campo genero se encuentra vacío");
			assertTrue(false);
		}
	}

	@Then("^Valido que se visualice label de prevision$")
	public void valido_que_se_visualice_label_de_prevision() throws Throwable {	    
		//Label -- Prevision
		GenericMethods.isElementPresent(BaseFlow.pageModel.getLblPrevision());
	}
	
	@Then("^Valido que el label prevision sea correcto$")
	public void valido_que_el_label_prevision_sea_correcto() throws Throwable {
		if (BaseFlow.pageModel.getLblPrevision().getText().trim().equals(
				BaseFlow.properties.getLabelPrevisionDatosPaciente())) {
			assertTrue(true);
		} else {
			System.out.println("Label previsión no es correcto");
			assertTrue(false);
		}
	}

	@Then("^Valido que se visualice campo de prevision$")
	public void valido_que_se_visualice_campo_de_prevision() throws Throwable {
		// ListBox -- Prevision
		GenericMethods.isElementPresent(BaseFlow.pageModel.getLbxPrevision());    
	}
	
	@Then("^Valido campo prevision no se encuentre vacio$")
	public void valido_campo_prevision_no_se_encuentre_vacio() throws Throwable {
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

	@Then("^Valido que se visualice label de correo$")
	public void valido_que_se_visualice_label_de_correo() throws Throwable {
		// Label -- Correo
		GenericMethods.isElementPresent(BaseFlow.pageModel.getLblCorreo());
	}
	
	@Then("^Valido que el label correo sea correcto$")
	public void valido_que_el_label_correo_sea_correcto() throws Throwable {
	    if (BaseFlow.pageModel.getLblCorreo().getText().trim().equals(
	    		BaseFlow.properties.getLabelCorreo())) {
	    	assertTrue(true);
	    } else {
	    	System.out.println("Label correo no es correcto");
			assertTrue(false);
	    }
	}

	@Then("^Valido que se visualice campo de correo$")
	public void valido_que_se_visualice_campo_de_correo() throws Throwable {
		// Input text -- Correo
		GenericMethods.isElementPresent(BaseFlow.pageModel.getTxtCorreo());	    
	}

	@Then("^Valido que se visualice label de telefono$")
	public void valido_que_se_visualice_label_de_telefono() throws Throwable {
		// Label -- Telefono
		GenericMethods.isElementPresent(BaseFlow.pageModel.getLblTelefono());
	}
	
	@Then("^Valido que el label telefono sea correcto$")
	public void valido_que_el_label_telefono_sea_correcto() throws Throwable {
		if (BaseFlow.pageModel.getLblTelefono().getText().trim().equals(
				BaseFlow.properties.getLabelTelefono())) {
			assertTrue(true);
		} else {
			System.out.println("Label teléfono no es correcto");
			assertTrue(false);
		}
	}

	@Then("^Valido que se visualice campo de telefono$")
	public void valido_que_se_visualice_campo_de_telefono() throws Throwable {
		// Input text -- Telefono
		GenericMethods.isElementPresent(BaseFlow.pageModel.getTxtTelefono());
	}

	@Then("^Valido que se visualice label de nacionalidad$")
	public void valido_que_se_visualice_label_de_nacionalidad() throws Throwable {
		// Label -- Nacionalidad
		GenericMethods.isElementPresent(BaseFlow.pageModel.getLblNacionalidad());
	}
	
	@Then("^Valido que el label nacionalidad sea correcto$")
	public void valido_que_el_label_nacionalidad_sea_correcto() throws Throwable {
		if (BaseFlow.pageModel.getLblNacionalidad().getText().trim().equals(
				BaseFlow.properties.getLabelNacionalidad())) {
			assertTrue(true);
		} else {
			System.out.println("Label nacionalidad no es correcto");
			assertTrue(false);
		}
	}
	
	@Then("^Valido que se visualice campo de nacionalidad$")
	public void valido_que_se_visualice_campo_de_nacionalidad() throws Throwable {
		// ListBox -- Nacionalidad
		GenericMethods.isElementPresent(BaseFlow.pageModel.getLbxNacionalidad());
	}
	
	@Then("^Valido campo nacionalidad no se encuentre vacio$")
	public void valido_campo_nacionalidad_no_se_encuentre_vacio() throws Throwable {
		BaseFlow.pageModel.getLbxNacionalidad().click();
		totalNacionalidad = BaseFlow.pageModel.getListNacionalidad().size();
		if (totalNacionalidad > 0) {
			BaseFlow.pageModel.getListNacionalidad().get(43).click();
			assertTrue(true);
		} else {
			System.out.println("Campo nacionalidad se encuentra vacío");
			assertTrue(false);
		}
	}

	@Then("^Valido que se visualice label de direccion$")
	public void valido_que_se_visualice_label_de_direccion() throws Throwable {
		// Label -- Direccion
		GenericMethods.isElementPresent(BaseFlow.pageModel.getLblDireccion());
	}
	
	@Then("^Valido que el label direccion sea correcto$")
	public void valido_que_el_label_direccion_sea_correcto() throws Throwable {
		if(BaseFlow.pageModel.getLblDireccion().getText().trim().equals(
				BaseFlow.properties.getLabelDireccion())) {
			assertTrue(true);
		} else {
			System.out.println("Label dirección no es correcto");
			assertTrue(false);
		}
	}

	@Then("^Valido que se visualice campo de direccion$")
	public void valido_que_se_visualice_campo_de_direccion() throws Throwable {
		// Input text -- Direccion
		GenericMethods.isElementPresent(BaseFlow.pageModel.getTxtDireccion());	    
	}

	@Then("^Valido que se visualice campo de comuna$")
	public void valido_que_se_visualice_campo_de_comuna() throws Throwable {
		// Input text -- Comuna
		GenericMethods.isElementPresent(BaseFlow.pageModel.getTxtComuna());
	}

	@Then("^Valido que se visualice campo de region$")
	public void valido_que_se_visualice_campo_de_region() throws Throwable {
		// ListBox -- Regiones
		GenericMethods.isElementPresent(BaseFlow.pageModel.getLbxRegiones());
	}
	
	@Then("^Valido campo region no se encuentre vacio$")
	public void valido_campo_region_no_se_encuentre_vacio() throws Throwable {
		BaseFlow.pageModel.getLbxRegiones().click();
		totalRegiones = BaseFlow.pageModel.getListRegiones().size();
		if (totalRegiones > 0) {
			BaseFlow.pageModel.getListRegiones().get(11).click();
			assertTrue(true);
		} else {
			System.out.println("Campo región se encuentra vacío");
			assertTrue(false);
		}
	}
	
	@Then("^Valido que se visualice el boton guardar$")
	public void valido_que_se_visualice_el_boton_guardar() throws Throwable {
		// Button -- Guardar
		GenericMethods.isElementPresent(BaseFlow.pageModel.getBtnGuardar());
	}

	@Then("^Ingreso nuevo valor en campo nombres \"(.*?)\"$")
	public void ingreso_nuevo_valor_en_campo_nombres(String nombres) throws Throwable {
		//tiempo implicito
		Thread.sleep(1000);
		//limpieza de campo
		BaseFlow.pageModel.getTxtNombres().clear();
		//ingreso de datos
		BaseFlow.pageModel.getTxtNombres().sendKeys(nombres);
	}

	@Then("^Ingreso nuevo valor en campo apellido paterno \"(.*?)\"$")
	public void ingreso_nuevo_valor_en_campo_apellido_paterno(String apellidoPaterno) throws Throwable {
		//tiempo implicito
		Thread.sleep(1000);
		//limpieza de campo
		BaseFlow.pageModel.getTxtApellidoPaterno().clear();
		//ingreso de datos
		BaseFlow.pageModel.getTxtApellidoPaterno().sendKeys(apellidoPaterno);
	}

	@Then("^Ingreso nuevo valor en campo apellido materno \"(.*?)\"$")
	public void ingreso_nuevo_valor_en_campo_apellido_materno(String apellidoMaterno) throws Throwable {
		//tiempo implicito
		Thread.sleep(1000);
		//limpieza de campo
		BaseFlow.pageModel.getTxtApellidoMaterno().clear();
		//ingreso de datos
		BaseFlow.pageModel.getTxtApellidoMaterno().sendKeys(apellidoMaterno);
	}

	@Then("^Ingreso nuevo valor en campo fecha de nacimiento dia \"(.*?)\"$")
	public void ingreso_nuevo_valor_en_campo_fecha_de_nacimiento_dia(String dia) throws Throwable {
		//tiempo implicito
		Thread.sleep(1000);
		//limpieza de campo
		BaseFlow.pageModel.getTxtFechaDia().clear();
		//ingreso de datos
		BaseFlow.pageModel.getTxtFechaDia().sendKeys(dia);
	}

	@Then("^Ingreso nuevo valor en campo fecha de nacimiento mes \"(.*?)\"$")
	public void ingreso_nuevo_valor_en_campo_fecha_de_nacimiento_mes(String mes) throws Throwable {
		//tiempo implicito
		Thread.sleep(1000);
		//limpieza de campo
		BaseFlow.pageModel.getTxtFechaMes().clear();
		//ingreso de datos
		BaseFlow.pageModel.getTxtFechaMes().sendKeys(mes);
	}

	@Then("^Ingreso nuevo valor en campo fecha de nacimiento año \"(.*?)\"$")
	public void ingreso_nuevo_valor_en_campo_fecha_de_nacimiento_año(String año) throws Throwable {
		//tiempo implicito
		Thread.sleep(1000);
		//limpieza de campo
		BaseFlow.pageModel.getTxtFechaAño().clear();
	    //ingreso de datos
		BaseFlow.pageModel.getTxtFechaAño().sendKeys(año);
	}
	
	@Then("^Ingreso nuevo valor en campo genero \"(.*?)\"$")
	public void ingreso_nuevo_valor_en_campo_genero(String genero) throws Throwable {
		//tiempo implicito
		Thread.sleep(1000);
		//hago click en el listado
		BaseFlow.pageModel.getLbxGenero().click();
		//seleccion de opcion
		BaseFlow.pageModel.getListGenero().get(Integer.parseInt(genero)).click();
	}

	@Then("^Ingreso nuevo valor en campo prevision \"(.*?)\"$")
	public void ingreso_nuevo_valor_en_campo_prevision(String prevision) throws Throwable {
		//tiempo implicito
		Thread.sleep(1000);
		//hago click en el listado
		BaseFlow.pageModel.getLbxPrevision().click();
		//seleccion de opcion
		BaseFlow.pageModel.getListPrevision().get(Integer.parseInt(prevision)).click();
	}

	@Then("^Ingreso nuevo valor en campo correo \"(.*?)\"$")
	public void ingreso_nuevo_valor_en_campo_correo(String correo) throws Throwable {
		//tiempo implicito
		Thread.sleep(1000);
		//limpieza de campo
		BaseFlow.pageModel.getTxtCorreo().clear();
		//ingreso de datos
		BaseFlow.pageModel.getTxtCorreo().sendKeys(correo);
	}

	@Then("^Ingreso nuevo valor en campo telefono \"(.*?)\"$")
	public void ingreso_nuevo_valor_en_campo_telefono(String telefono) throws Throwable {
		//tiempo implicito
		Thread.sleep(1000);
		//limpieza de campo
		BaseFlow.pageModel.getTxtTelefono().clear();
		//ingreso de datos
		BaseFlow.pageModel.getTxtTelefono().sendKeys(telefono);
	}

	@Then("^Ingreso nuevo valor en campo nacionalidad \"(.*?)\"$")
	public void ingreso_nuevo_valor_en_campo_nacionalidad(String nacionalidad) throws Throwable {
		//tiempo implicito
		Thread.sleep(1000);
		//hago click en el listado
		BaseFlow.pageModel.getLbxNacionalidad().click();
		//seleccion de opcion
		BaseFlow.pageModel.getListNacionalidad().get(Integer.parseInt(nacionalidad)).click();
	}

	@Then("^Ingreso nuevo valor en campo direccion \"(.*?)\"$")
	public void ingreso_nuevo_valor_en_campo_direccion(String direccion) throws Throwable {
		//tiempo implicito
		Thread.sleep(1000);
		//limpieza de campo
		BaseFlow.pageModel.getTxtDireccion().clear();
		//ingreso de datos
		BaseFlow.pageModel.getTxtDireccion().sendKeys(direccion);
	}

	@Then("^Ingreso nuevo valor en campo comuna \"(.*?)\"$")
	public void ingreso_nuevo_valor_en_campo_comuna(String comuna) throws Throwable {
		//tiempo implicito
		Thread.sleep(1000);
		//limpieza de campo
		BaseFlow.pageModel.getTxtComuna().clear();
		//ingreso de datos
		BaseFlow.pageModel.getTxtComuna().sendKeys(comuna);
	}

	@Then("^Ingreso nuevo valor en campo region \"(.*?)\"$")
	public void ingreso_nuevo_valor_en_campo_region(String region) throws Throwable {
		//tiempo implicito
		Thread.sleep(1000);
		//hago click en el listado
		BaseFlow.pageModel.getLbxRegiones().click();
		//seleccion de opcion
		BaseFlow.pageModel.getListRegiones().get(Integer.parseInt(region)).click();
	}

	@Then("^Realizar click en boton guardar$")
	public void realizar_click_en_boton_guardar() throws Throwable {
		BaseFlow.pageModel.getBtnGuardar().click();
	}
	


	@When("^Valido que se visualice ventana de confirmacion exitosa edicion datos paciente$")
	public void valido_que_se_visualice_ventana_de_confirmacion_exitosa_edicion_datos_paciente() throws Throwable {
		//espero hasta que ventana de crear y editar paciente se despliegue
		GenericMethods.waitTime(BaseFlow.pageModel.getMdlRutFail());
		//tiempo de espera explícito
		Thread.sleep(2000);
		//Ventana de edicion de datos exitoso
		GenericMethods.isElementPresent(BaseFlow.pageModel.getMdlRutFail());	    
	}

	@Then("^Valido que se visualice titulo ventana en edicion de datos$")
	public void valido_que_se_visualice_titulo_ventana_en_edicion_de_datos() throws Throwable {
		GenericMethods.isElementPresent(BaseFlow.pageModel.getLblPacienteFail());	    
	}

	@Then("^Valido que titulo ventana en edicion de datos sea correcto$")
	public void valido_que_titulo_ventana_en_edicion_de_datos_sea_correcto() throws Throwable {
		if (BaseFlow.pageModel.getLblPacienteFail().getText().trim().equals(
	    		BaseFlow.properties.getLabelDatosGuardados())) {
			assertTrue(true);
		} else {
			System.out.println("Tìtulo datos guardaos no es correcto");
			assertTrue(false);
		}
	}

	@Then("^Valido que se visualice imagen ventana en edicion de datos$")
	public void valido_que_se_visualice_imagen_ventana_en_edicion_de_datos() throws Throwable {
		GenericMethods.isElementPresent(BaseFlow.pageModel.getImgIconoFail());
	}

	@Then("^Valido que se visualice mensaje ventana en edicion de datos$")
	public void valido_que_se_visualice_mensaje_ventana_en_edicion_de_datos() throws Throwable {
		GenericMethods.isElementPresent(BaseFlow.pageModel.getPrfMensajeFail());
	}

	@Then("^Valido que se visualice  boton aceptar$")
	public void valido_que_se_visualice_boton_aceptar() throws Throwable {
		GenericMethods.isElementPresent(BaseFlow.pageModel.getBtnAceptarFail());
	}

	@Then("^Valido que boton aceptar este habilitado$")
	public void valido_que_boton_aceptar_este_habilitado() throws Throwable {
		boolean condition = BaseFlow.pageModel.getBtnAceptarFail().isEnabled();
	    if (condition == true) {
	    	assertTrue(true);
	    } else {
	    	System.out.println("Botón aceptar no se encuentra habilitado");
	    	assertTrue(false);
	    }
	}

	@Then("^Realizar click en boton aceptar$")
	public void realizar_click_en_boton_aceptar() throws Throwable {
		BaseFlow.pageModel.getBtnAceptarFail().click();
		//tiempo de espera explicito
		Thread.sleep(2000);
	}
	
	@Then("^Valido que se visualice nuevamente pantalla OCM pendientes$")
	public void valido_que_se_visualice_nuevamente_pantalla_OCM_pendientes() throws Throwable {
		// Div -- Ocm pendientes paciente
		GenericMethods.isElementPresent(BaseFlow.pageModel.getDivOcmPendientesPacienteSeccionGeneral().get(0));
	}

	@When("^Valido que boton nueva reserva de hora se encuentra habilitado$")
	public void valido_que_boton_nueva_reserva_de_hora_se_encuentra_habilitado() throws Throwable {
		boolean condition = BaseFlow.pageModel.getBtnNuevaReservaHoraOcmPendiente().isEnabled();
		if (condition == true) {
			assertTrue(true);
		} else {
			System.out.println("Botón nueva reserva de hora no se encuentra habilitado");
			assertTrue(false);
		}
	}

	@Then("^Hago click en boton nueva reserva de hora$")
	public void hago_click_en_boton_nueva_reserva_de_hora() throws Throwable {
		BaseFlow.pageModel.getBtnNuevaReservaHoraOcmPendiente().click();
		//tiempo de espera explicito
		Thread.sleep(9000);
	}

	@Then("^Valido la visualizacion ventana nueva reserva$")
	public void valido_la_visualizacion_ventana_nueva_reserva() throws Throwable {
		// Div -- Nueva reserva
		GenericMethods.isElementPresent(BaseFlow.pageModel.getDivNuevaReserva());
	}

	@Then("^Valido la visualizacion del tab consulta$")
	public void valido_la_visualizacion_del_tab_consulta() throws Throwable {
		// Tab -- Especialidad
		GenericMethods.isElementPresent(BaseFlow.pageModel.getTbEspecialidad());
	}

	@Then("^Valido la visualizacion del tab profesional$")
	public void valido_la_visualizacion_del_tab_profesional() throws Throwable {
		// Tab -- Medicos
		GenericMethods.isElementPresent(BaseFlow.pageModel.getTbMedicos());
	}

	@Then("^Valido la visualizacion del tab examenes$")
	public void valido_la_visualizacion_del_tab_examenes() throws Throwable {
		// Nav Item Menu -- Examenes
		GenericMethods.isElementPresent(BaseFlow.pageModel.getNvItMenuExamenes());
	}

	@Then("^Valido la visualizacion del boton close ventana nueva reserva$")
	public void valido_la_visualizacion_del_boton_close_ventana_nueva_reserva() throws Throwable {
		// Button -- Cerrar nueva reserva
		GenericMethods.isElementPresent(BaseFlow.pageModel.getBtnCerrarNuevaReserva().get(0));
	}

	@Then("^Valido que boton close se encuentre habilitado ventana nueva reserva$")
	public void valido_que_boton_close_se_encuentre_habilitado_ventana_nueva_reserva() throws Throwable {
	    boolean condition = BaseFlow.pageModel.getBtnCerrarNuevaReserva().get(0).isEnabled();
	    if (condition == true) {
	    	assertTrue(true);
	    } else {
	    	System.out.println("Botón close no se encuentra habilitado");
	    	assertTrue(false);
	    }
	}

	@Then("^Hagoo click en boton close ventana nueva reserva$")
	public void hagoo_click_en_boton_close_ventana_nueva_reserva() throws Throwable {
		BaseFlow.pageModel.getBtnCerrarNuevaReserva().get(0).click();
	}

	@Then("^Valido que se visualice nuevamente ventana OCM pendientes$")
	public void valido_que_se_visualice_nuevamente_ventana_OCM_pendientes() throws Throwable {
		// Div -- Ocm pendientes paciente
		GenericMethods.isElementPresent(BaseFlow.pageModel.getDivOcmPendientesPacienteSeccionGeneral().get(0));
	}
	
	@Given("^Valido que se visualice seaccion box agendamiento$")
	public void valido_que_se_visualice_seaccion_box_agendamiento() throws Throwable {
		// Div -- Seccion box agendamiento
		GenericMethods.isElementPresent(BaseFlow.pageModel.getDivOcmSeccionBoxAgendamiento().get(0));
	}

	@When("^Valido que se visualice elemento que contiene los tab$")
	public void valido_que_se_visualice_elemento_que_contiene_los_tab() throws Throwable {
		// Tab -- Contenedor tab agendamiento
		GenericMethods.isElementPresent(BaseFlow.pageModel.getTabContenedorTabAgendamiento());
	}

	@Then("^Valido que se visualice tab por gestionar$")
	public void valido_que_se_visualice_tab_por_gestionar() throws Throwable {
		// Tab -- Por gestionars
		GenericMethods.isElementPresent(BaseFlow.pageModel.getTabPorGestionar());
	}
	
	@Then("^Valido que tab por gestionar sea correcto$")
	public void valido_que_tab_por_gestionar_sea_correcto() throws Throwable {
	    if (BaseFlow.pageModel.getTabPorGestionar().getText().trim().equals(
	    		BaseFlow.properties.getLabelPorGestionar())) {
	    	assertTrue(true);
	    } else {
	    	System.out.println("Tab por gestionar no es correcto");
	    	assertTrue(false);
	    }
	}

	@Then("^Valido que se visualice tab gestionado$")
	public void valido_que_se_visualice_tab_gestionado() throws Throwable {
		// Tab -- Gestionado
	    GenericMethods.isElementPresent(BaseFlow.pageModel.getTabGestionado());
	}
	
	@Then("^Valido que tab gestionado sea correcto$")
	public void valido_que_tab_gestionado_sea_correcto() throws Throwable {
	    if (BaseFlow.pageModel.getTabGestionado().getText().trim().equals(
	    		BaseFlow.properties.getLabelLoGestionado())) {
	    	assertTrue(true);
	    } else {
	    	System.out.println("Tab gestionado no es correcto");
	    	assertTrue(false);
	    }
	}

	@Then("^Valido que se visualice tabla de ordenes por gestionar$")
	public void valido_que_se_visualice_tabla_de_ordenes_por_gestionar() throws Throwable {
		// Table -- Agendar
	    GenericMethods.isElementPresent(BaseFlow.pageModel.getTblAgendar());
	}

	@Then("^Valido que se visualice header orden medica tabla ordenes por gestionar$")
	public void valido_que_se_visualice_header_orden_medica_tabla_ordenes_por_gestionar() throws Throwable {
		// Table header -- Cabezara tabla agendar
		GenericMethods.isElementPresent(BaseFlow.pageModel.getTbhCabezaraTablaAgendar().get(0));
	}

	@Then("^Valido que header orden medica en tabla ordenes por gestionar sea correcto$")
	public void valido_que_header_orden_medica_en_tabla_ordenes_por_gestionar_sea_correcto() throws Throwable {
	    if (BaseFlow.pageModel.getTbhCabezaraTablaAgendar().get(0).getAttribute("innerText").trim().equals(
	    		BaseFlow.properties.getLabelOrdenMedica())) {
	    	assertTrue(true);
	    } else {
	    	System.out.println("Header orden médico no es correcto");
	    	assertTrue(false);
	    }
	}

	@Then("^Valido que se visualice header fecha tabla ordenes por gestionar$")
	public void valido_que_se_visualice_header_fecha_tabla_ordenes_por_gestionar() throws Throwable {
		// Table header -- Cabezara tabla agendar
		GenericMethods.isElementPresent(BaseFlow.pageModel.getTbhCabezaraTablaAgendar().get(1));
	}

	@Then("^Valido que header fecha en tabla ordenes por gestionar sea correcto$")
	public void valido_que_header_fecha_en_tabla_ordenes_por_gestionar_sea_correcto() throws Throwable {
		if (BaseFlow.pageModel.getTbhCabezaraTablaAgendar().get(1).getAttribute("innerText").trim().equals(
				BaseFlow.properties.getLabelFecha())) {
			assertTrue(true);
		} else {
			System.out.println("Header fecha no es correcto");
	    	assertTrue(false);
		}	    
	}

	@Then("^Valido que se visualice header profesional tabla ordenes por gestionar$")
	public void valido_que_se_visualice_header_profesional_tabla_ordenes_por_gestionar() throws Throwable {
		// Table header -- Cabezara tabla agendar
		GenericMethods.isElementPresent(BaseFlow.pageModel.getTbhCabezaraTablaAgendar().get(2)); 	    
	}

	@Then("^Valido que header profesional en tabla ordenes por gestionar sea correcto$")
	public void valido_que_header_profesional_en_tabla_ordenes_por_gestionar_sea_correcto() throws Throwable {
		if (BaseFlow.pageModel.getTbhCabezaraTablaAgendar().get(2).getAttribute("innerText").trim().equals(
				BaseFlow.properties.getLabelProfesional())) {
			assertTrue(true);
		} else {
			System.out.println("Header profesional no es correcto");
	    	assertTrue(false);
		}
	}

	@Then("^Valido que tabla de ordenes por gestionar contenga ordenes pendientes$")
	public void valido_que_tabla_de_ordenes_por_gestionar_contenga_ordenes_pendientes() throws Throwable {
	    totalOrdenesPorGestionar = BaseFlow.pageModel.getTbCuerpoOrdenesPorGestionar().size();
	    if (totalOrdenesPorGestionar > 0) {
	    	assertTrue(true);
	    } else {
	    	System.out.println("Tabla no contiene ordenes por gestionar pendientes");
	    	assertTrue(false);
	    }
	}

	@Then("^Valido que tabla de ordenes por gestionar contenga boton apertura detalle orden$")
	public void valido_que_tabla_de_ordenes_por_gestionar_contenga_boton_apertura_detalle_orden() throws Throwable {
		totalBotonesAperturaOrdenesPorAgendar = BaseFlow.pageModel.getBtnAperturaOrdenesPorGestionar().size();
		if (totalBotonesAperturaOrdenesPorAgendar > 0) {
			assertTrue(true);
		} else {
			System.out.println("Botón de apertura ordenes por gestionar no se encuentra");
	    	assertTrue(false);
		}
	}

	@Then("^Realizar click en boton apertura detalle orden tabla ordenes por gestionar \"(.*?)\"$")
	public void realizar_click_en_boton_apertura_detalle_orden_tabla_ordenes_por_gestionar(String orden) throws Throwable {
		/*
		List<WebElement> acordeon = BaseFlow.driver.findElements(By.className("accordion"));
	    for (WebElement a : BaseFlow.pageModel.getBtnAperturaOrdenesPorAgendar()) {
	    	a.click();
	    	if(GenericMethods.isElementPresent(acordeon.get(0)));
			break;
	    }
	    */
		BaseFlow.pageModel.getBtnAperturaOrdenesPorGestionar().get(Integer.parseInt(orden)).click();
		//tiempo de espera explicito
		Thread.sleep(5000);
	}

	@Then("^Valido que tabla de ordenes por gestionar contenga el detalle de las prestaciones$")
	public void valido_que_tabla_de_ordenes_por_gestionar_contenga_el_detalle_de_las_prestaciones() throws Throwable {
		totalItemDetallePrestaciones = BaseFlow.pageModel.getTbItemDetallePrestaciones().size();
	    if (totalItemDetallePrestaciones > 0) {
	    	assertTrue(true);
	    } else {
	    	System.out.println("Tabla no contiene detalle de las prestaciones relacionadas a las ordenes pendientes por agendar");
	    	assertTrue(false);
	    }
	}
	
	@Then("^Valido que se visualice link leer indicaciones prestacion no agendable \"(.*?)\"$")
	public void valido_que_se_visualice_link_leer_indicaciones_prestacion_no_agendable(String linkLeerIndicacionesPrestacionNoAgendable) throws Throwable {
		// Button -- Link leer indicaciones
		GenericMethods.isElementPresent(BaseFlow.pageModel.getBtnLinkLeerIndicaciones().get(Integer.parseInt(linkLeerIndicacionesPrestacionNoAgendable)));
	}
	
	@Then("^Valido que link leer indicaciones sea correcto prestacion no agendable \"(.*?)\"$")
	public void valido_que_link_leer_indicaciones_sea_correcto_prestacion_no_agendable(String linkLeerIndicacionesPrestacionNoAgendable) throws Throwable {
	    if (BaseFlow.pageModel.getBtnLinkLeerIndicaciones().get(Integer.parseInt(linkLeerIndicacionesPrestacionNoAgendable)).getAttribute("innerText").trim().equals(
	    		BaseFlow.properties.getLabelLeerIndicacionesTwo())) {
	    	assertTrue(true);
	    } else {
	    	System.out.println("Link leer indicaciones no es correcto");
	    	assertTrue(false);
	    }
	}
	
	@Then("^Realizar click link leer indicaciones \"(.*?)\"$")
	public void realizar_click_link_leer_indicaciones(String linkLeerIndicacionesPrestacionNoAgendable) throws Throwable {
		// Button -- Link leer indicaciones
		BaseFlow.pageModel.getBtnLinkLeerIndicaciones().get(Integer.parseInt(linkLeerIndicacionesPrestacionNoAgendable)).click();
		//tiempo de espera explicito
		Thread.sleep(3000);
	}

	@Then("^Valido que se visualice ventana leer todas las indicaciones$")
	public void valido_que_se_visualice_ventana_leer_todas_las_indicaciones() throws Throwable {
		// Div -- Leer indicaciones
		GenericMethods.isElementPresent(BaseFlow.pageModel.getDivLeerIndicaciones());
	}

	@Then("^Valido que se visualice titulo ventana leer todas las indicaciones$")
	public void valido_que_se_visualice_titulo_ventana_leer_todas_las_indicaciones() throws Throwable {
		// H5 -- Leer indicaciones
		GenericMethods.isElementPresent(BaseFlow.pageModel.gethFiveTituloLeerIndicaciones());
	}

	@Then("^Valido titulo sea correcto ventana leer todas las indicaciones$")
	public void valido_titulo_sea_correcto_ventana_leer_todas_las_indicaciones() throws Throwable {
	    if (BaseFlow.pageModel.gethFiveTituloLeerIndicaciones().getAttribute("innerText").trim().equals(
	    		BaseFlow.properties.getLabelLeerIndicaciones())) {
	    	assertTrue(true);
	    } else {
	    	System.out.println("Título leer indicaciones no es correcto");
	    	assertTrue(false);
	    }
	}
	
	@Then("^Valido que se visualice elemento contenedor listado de indicaciones ventana leer todas las indicaciones$")
	public void valido_que_se_visualice_elemento_contenedor_listado_de_indicaciones_ventana_leer_todas_las_indicaciones() throws Throwable {
		// Div -- Listado leer indicaciones
		GenericMethods.isElementPresent(BaseFlow.pageModel.getDivListadoLeerIndicaciones());
	}

	@Then("^Valido que se visualice listado indicaciones ventana leer todas las indicaciones$")
	public void valido_que_se_visualice_listado_indicaciones_ventana_leer_todas_las_indicaciones() throws Throwable {
		if (BaseFlow.pageModel.getLiListadoLeerIndicaciones().size() >= 1) {
			assertTrue(true);
		} else {
			System.out.println("No se visualiza listado de indicaciones");
			assertTrue(false);
		}
	}

	@Then("^Valido que se visualice texto prestacion sin indicaciones ventana leer todas las indicaciones$")
	public void valido_que_se_visualice_texto_prestacion_sin_indicaciones_ventana_leer_todas_las_indicaciones() throws Throwable {
		// Label -- Prestacion sin indicaciones
		GenericMethods.isElementPresent(BaseFlow.pageModel.getLblPrestacionSinIndicaciones());
	}

	@Then("^Valido texto prestacion sin indicaciones sea correcto ventana leer todas las indicaciones$")
	public void valido_texto_prestacion_sin_indicaciones_sea_correcto_ventana_leer_todas_las_indicaciones() throws Throwable {
	    /*if (BaseFlow.pageModel.getLblPrestacionSinIndicaciones().getAttribute("innerText").trim().equals(
	    		BaseFlow.properties.getLabelPrestacionSinIndicaciones())) {
	    	assertTrue(true);
	    } else {
	    	System.out.println("Texto prestación sin indicaciones no es correcto");
	    	assertTrue(false);
	    }*/
	}

	@Then("^Valido que se visualice boton he leido las indicaciones ventana leer todas las indicaciones$")
	public void valido_que_se_visualice_boton_he_leido_las_indicaciones_ventana_leer_todas_las_indicaciones() throws Throwable {
		// Button -- He leido las indicaciones en OCM
		GenericMethods.isElementPresent(BaseFlow.pageModel.getBtnHeLeidoLasIndicacionesOcm());
	}

	@Then("^Valido boton he leido las indicaciones se encuentre habilitado ventana leer todas las indicaciones$")
	public void valido_boton_he_leido_las_indicaciones_se_encuentre_habilitado_ventana_leer_todas_las_indicaciones() throws Throwable {
	    boolean condition = BaseFlow.pageModel.getBtnHeLeidoLasIndicacionesOcm().isEnabled();
	    if (condition == true) {
	    	assertTrue(true);
	    } else {
	    	System.out.println("Boton he leido las indicaciones no se encuentra habilitado");
	    	assertTrue(false);
	    }
	}

	@Then("^Realizar click boton he leido las indicaciones ventana leer todas las indicaciones$")
	public void realizar_click_boton_he_leido_las_indicaciones_ventana_leer_todas_las_indicaciones() throws Throwable {
		// Button -- He leido las indicaciones en OCM
		BaseFlow.pageModel.getBtnHeLeidoLasIndicacionesOcm().click();
		//tiempo de espera explicito
		Thread.sleep(1000);
	}
	
	@Then("^Valido que se visualice imagen icono no agendable prestacion no agendable \"(.*?)\"$")
	public void valido_que_se_visualice_imagen_icono_no_agendable_prestacion_no_agendable(String iconoPrestacionNoAgendable) throws Throwable {
		// Img -- Icono prestacion no agendable
		GenericMethods.isElementPresent(BaseFlow.pageModel.getImgIconoPrestacionNoAgendable().get(Integer.parseInt(iconoPrestacionNoAgendable)));
	}

	@Then("^Valido mensaje imagen no agendable sea correcto prestacion no agendable \"(.*?)\"$")
	public void valido_mensaje_imagen_no_agendable_sea_correcto_prestacion_no_agendable(String iconoPrestacionNoAgendable) throws Throwable {
	    if (BaseFlow.pageModel.getImgIconoPrestacionNoAgendable().get(Integer.parseInt(iconoPrestacionNoAgendable)).getAttribute("innerText").trim().equals(
	    		BaseFlow.properties.getLabelNoAgendable())) {
	    	assertTrue(true);
	    } else {
	    	System.out.println("Mensaje no agendable no es correcto");
	    	assertTrue(false);
	    }
	}

	@Then("^Valido que se visualice imagen icono multiopcion prestacion no agendable \"(.*?)\"$")
	public void valido_que_se_visualice_imagen_icono_multiopcion_prestacion_no_agendable(String iconoMultiOpcionPrestacionNoAgendable) throws Throwable {
		// Img -- Icono multiopcion
		GenericMethods.isElementPresent(BaseFlow.pageModel.getImgIconoMultiopcion().get(Integer.parseInt(iconoMultiOpcionPrestacionNoAgendable)));
	}

	@Then("^Realizar click icono multiopcion prestacion no agendable \"(.*?)\"$")
	public void realizar_click_icono_multiopcion_prestacion_no_agendable(String iconoMultiOpcionPrestacionNoAgendable) throws Throwable {
		// Img -- Icono multiopcion
		BaseFlow.pageModel.getImgIconoMultiopcion().get(Integer.parseInt(iconoMultiOpcionPrestacionNoAgendable)).click();
	}
	
	@Then("^Valido que se visualice primera opcion enviar indicaciones icono multiopcion prestacion no agendable \"(.*?)\"$")
	public void valido_que_se_visualice_primera_opcion_enviar_indicaciones_icono_multiopcion_prestacion_no_agendable(String opcionUnoEnviarIndicaciones) throws Throwable {
		// Button -- Opcion enviar indicaciones
		GenericMethods.isElementPresent(BaseFlow.pageModel.getBtnOpcionEnviarIndicaciones().get(Integer.parseInt(opcionUnoEnviarIndicaciones)));
	}

	@Then("^Valido que se visualice segunda opcion rechazar asesoria icono multiopcion prestacion no agendable \"(.*?)\"$")
	public void valido_que_se_visualice_segunda_opcion_rechazar_asesoria_icono_multiopcion_prestacion_no_agendable(String opcionDosRechazarAsesoria) throws Throwable {
		// Button -- Opcion rechazar asesoria
		//GenericMethods.isElementPresent(BaseFlow.pageModel.getBtnOpcionRechazarAsesoria().get(Integer.parseInt(opcionDosRechazarAsesoria)));
	}	

	@Then("^Valido que segunda opcion rechazar asesoria se encuentre habilitado icono multiopcion prestacion no agendable \"(.*?)\"$")
	public void valido_que_segunda_opcion_rechazar_asesoria_se_encuentre_habilitado_icono_multiopcion_prestacion_no_agendable(String opcionDosRechazarAsesoria) throws Throwable {
	    /*
		boolean condition = BaseFlow.pageModel.getBtnOpcionRechazarAsesoria().get(Integer.parseInt(opcionDosRechazarAsesoria)).isEnabled();
	    if (condition == true) {
	    	assertTrue(true);
	    } else {
	    	System.out.println("Segunda opción rechazar asesoria no se encuentra habilitado");
	    	assertTrue(false);
	    }
	    */
	}
	
	@Then("^Valido que no se pueda hacer click prestacion no agendable \"(.*?)\"$")
	public void valido_que_no_se_pueda_hacer_click_prestacion_no_agendable(String detallePrestacionNoAgendable) throws Throwable {
		
	}	
		
	@Then("^Valido que se visualice icono imagen pestaña apertura prestacion no disponibilidad para proximos dias \"(.*?)\"$")
	public void valido_que_se_visualice_icono_imagen_pestaña_apertura_prestacion_no_disponibilidad_para_proximos_dias(String pestañaAperturaPrestacionSinDisponibilidad) throws Throwable {
		// Imagen -- Icono pestaña apertura prestacion
		GenericMethods.isElementPresent(BaseFlow.pageModel.getImgIconoPestañaAperturaPrestacion().get(Integer.parseInt(pestañaAperturaPrestacionSinDisponibilidad)));
	}

	@Then("^Valido que icono imagen pestaña apertura se encuentre habilitado prestacion no disponibilidad para proximos dias \"(.*?)\"$")
	public void valido_que_icono_imagen_pestaña_apertura_se_encuentre_habilitado_prestacion_no_disponibilidad_para_proximos_dias(String pestañaAperturaPrestacionSinDisponibilidad) throws Throwable {
	    boolean condition = BaseFlow.pageModel.getImgIconoPestañaAperturaPrestacion().get(Integer.parseInt(pestañaAperturaPrestacionSinDisponibilidad)).isEnabled();
	    if (condition == true) {
	    	assertTrue(true);
	    } else {
	    	System.out.println("Icono imágen pestaña apertura no se encuentra habilitado");
	    	assertTrue(false);
	    }
	}
	
	@Then("^Valido que se visualice link leer indicaciones prestacion no disponibilidad para proximos dias \"(.*?)\"$")
	public void valido_que_se_visualice_link_leer_indicaciones_prestacion_no_disponibilidad_para_proximos_dias(String linkLeerIndicacionesPrestacionSinDisponibilidad) throws Throwable {
		// Button -- Link leer indicaciones
		GenericMethods.isElementPresent(BaseFlow.pageModel.getBtnLinkLeerIndicaciones().get(Integer.parseInt(linkLeerIndicacionesPrestacionSinDisponibilidad)));
	}

	@Then("^Valido que link leer indicaciones sea correcto prestacion no disponibilidad para proximos dias \"(.*?)\"$")
	public void valido_que_link_leer_indicaciones_sea_correcto_prestacion_no_disponibilidad_para_proximos_dias(String linkLeerIndicacionesPrestacionSinDisponibilidad) throws Throwable {
		if (BaseFlow.pageModel.getBtnLinkLeerIndicaciones().get(Integer.parseInt(linkLeerIndicacionesPrestacionSinDisponibilidad)).getAttribute("innerText").trim().equals(
	    		BaseFlow.properties.getLabelLeerIndicacionesTwo())) {
	    	assertTrue(true);
	    } else {
	    	System.out.println("Link leer indicaciones no es correcto");
	    	assertTrue(false);
	    }
	}

	@Then("^Realizar click link leer indicaciones prestacion no disponibilidad para proximos dias \"(.*?)\"$")
	public void realizar_click_link_leer_indicaciones_prestacion_no_disponibilidad_para_proximos_dias(String linkLeerIndicacionesPrestacionSinDisponibilidad) throws Throwable {
		// Button -- Link leer indicaciones
		BaseFlow.pageModel.getBtnLinkLeerIndicaciones().get(Integer.parseInt(linkLeerIndicacionesPrestacionSinDisponibilidad)).click();
		//tiempo de espera explicito
		Thread.sleep(3000);
	}

	@Then("^Valido que se visualice ventana leer las indicaciones$")
	public void valido_que_se_visualice_ventana_leer_las_indicaciones() throws Throwable {
		// Div -- Leer indicaciones
		GenericMethods.isElementPresent(BaseFlow.pageModel.getDivLeerIndicaciones());
	}

	@Then("^Valido que se visualice titulo ventana leer indicaciones$")
	public void valido_que_se_visualice_titulo_ventana_leer_indicaciones() throws Throwable {
		// H5 -- Leer indicaciones
		GenericMethods.isElementPresent(BaseFlow.pageModel.gethFiveTituloLeerIndicaciones());
	}

	@Then("^Valido que titulo sea correcto ventana leer indicaciones$")
	public void valido_que_titulo_sea_correcto_ventana_leer_indicaciones() throws Throwable {
		if (BaseFlow.pageModel.gethFiveTituloLeerIndicaciones().getAttribute("innerText").trim().equals(
	    		BaseFlow.properties.getLabelLeerIndicaciones())) {
	    	assertTrue(true);
	    } else {
	    	System.out.println("Título leer indicaciones no es correcto");
	    	assertTrue(false);
	    }
	}
	
	@Then("^Valido que se visualice elemento contenedor listado de indicaciones ventana leer indicaciones$")
	public void valido_que_se_visualice_elemento_contenedor_listado_de_indicaciones_ventana_leer_indicaciones() throws Throwable {
		// Div -- Listado leer indicaciones
	    GenericMethods.isElementPresent(BaseFlow.pageModel.getDivListadoLeerIndicaciones());
	}

	@Then("^Valido que se visualice listado de indicaciones ventana leer indicaciones$")
	public void valido_que_se_visualice_listado_de_indicaciones_ventana_leer_indicaciones() throws Throwable {
		if (BaseFlow.pageModel.getLiListadoLeerIndicaciones().size() > 1) {
			assertTrue(true);
		} else {
			System.out.println("No se visualiza listado de indicaciones");
			assertTrue(false);
		}
	}

	@Then("^Valido que se visualice boton he leido las indicaciones ventana leer indicaciones$")
	public void valido_que_se_visualice_boton_he_leido_las_indicaciones_ventana_leer_indicaciones() throws Throwable {
		// Button -- He leido las indicaciones en OCM
		GenericMethods.isElementPresent(BaseFlow.pageModel.getBtnHeLeidoLasIndicacionesOcm());
	}

	@Then("^Valido boton he leido las indicaciones se encuentre habilitado ventana leer indicaciones$")
	public void valido_boton_he_leido_las_indicaciones_se_encuentre_habilitado_ventana_leer_indicaciones() throws Throwable {
		boolean condition = BaseFlow.pageModel.getBtnHeLeidoLasIndicacionesOcm().isEnabled();
	    if (condition == true) {
	    	assertTrue(true);
	    } else {
	    	System.out.println("Boton he leido las indicaciones no se encuentra habilitado");
	    	assertTrue(false);
	    }
	}

	@Then("^Realizar click boton he leido las indicaciones ventana leer indicaciones$")
	public void realizar_click_boton_he_leido_las_indicaciones_ventana_leer_indicaciones() throws Throwable {
		// Button -- He leido las indicaciones en OCM
		BaseFlow.pageModel.getBtnHeLeidoLasIndicacionesOcm().click();
		//tiempo de espera explicito
		Thread.sleep(1000);
	}
		
	@Then("^Realizar click en detalle de prestacion no disponibilidad para proximos dias \"(.*?)\"$")
	public void realizar_click_en_detalle_de_prestacion_no_disponibilidad_para_proximos_dias(String detallePrestacionSinDisponibilidad) throws Throwable {
		/*
		List<WebElement> acordeonBody = BaseFlow.driver.findElements(By.className("accordion-body"));
	    for (WebElement a : BaseFlow.pageModel.getTbItemDetallePrestaciones()) {
	    	a.click();
	    	if(GenericMethods.isElementPresent(acordeonBody.get(0)));
			break;
	    }
	    */
		BaseFlow.pageModel.getTbItemDetallePrestaciones().get(Integer.parseInt(detallePrestacionSinDisponibilidad)).click();
		//tiempo explicito
		Thread.sleep(8000);
	}

	@Then("^Valido que se visualice header prestador no disponibilidad para proximos dias \"(.*?)\"$")
	public void valido_que_se_visualice_header_prestador_no_disponibilidad_para_proximos_dias(String headerPrestadorSinDisponibilidad) throws Throwable {
		// Table header -- Cabezara listado proximas horas disponibles
		GenericMethods.isElementPresent(BaseFlow.pageModel.getTbhCabezaraListadoProximasHorasDisponibles().get(Integer.parseInt(headerPrestadorSinDisponibilidad)));
	}

	@Then("^Valido que header prestador listado de no disponibilidad para proximos dias \"(.*?)\"$")
	public void valido_que_header_prestador_listado_de_no_disponibilidad_para_proximos_dias(String headerPrestadorSinDisponibilidad) throws Throwable {
		if (BaseFlow.pageModel.getTbhCabezaraListadoProximasHorasDisponibles().get(Integer.parseInt(headerPrestadorSinDisponibilidad)).getAttribute("innerText").trim().equals(
				BaseFlow.properties.getLabelPrestador())) {
			assertTrue(true);
		} else {
			System.out.println("Header prestador no es correcto");
	    	assertTrue(false);
		}
	}
	
	@Then("^Valido que se visualice imagen icono orden header prestador listado de no disponibilidad para proximos dias \"(.*?)\"$")
	public void valido_que_se_visualice_imagen_icono_orden_header_prestador_listado_de_no_disponibilidad_para_proximos_dias(String iconoPrestadorSinDisponibilidad) throws Throwable {
		// Table header -- Cabecera tabla por gestionar icono orden
		GenericMethods.isElementPresent(BaseFlow.pageModel.getTbhCabeceraTablaPorGestionarIconoOrden().get(Integer.parseInt(iconoPrestadorSinDisponibilidad)));
	}

	@Then("^Valido que se visualice header proxima hora listado no disponibilidad para proximos dias \"(.*?)\"$")
	public void valido_que_se_visualice_header_proxima_hora_listado_no_disponibilidad_para_proximos_dias(String headerProximaHoraSinDisponibilidad) throws Throwable {
		// Table header -- Cabezara listado proximas horas disponibles
		GenericMethods.isElementPresent(BaseFlow.pageModel.getTbhCabezaraListadoProximasHorasDisponibles().get(Integer.parseInt(headerProximaHoraSinDisponibilidad)));		
	}

	@Then("^Valido que header proxima hora listado no disponibilidad para proximos dias \"(.*?)\"$")
	public void valido_que_header_proxima_hora_listado_no_disponibilidad_para_proximos_dias(String headerProximaHoraSinDisponibilidad) throws Throwable {
		if (BaseFlow.pageModel.getTbhCabezaraListadoProximasHorasDisponibles().get(Integer.parseInt(headerProximaHoraSinDisponibilidad)).getAttribute("innerText").trim().equals(
				BaseFlow.properties.getLabelProximaHora())) {
			assertTrue(true);
		} else {
			System.out.println("Header próxima hora no es correcto");
	    	assertTrue(false);
		}
	}
	
	@Then("^Valido que se visualice imagen icono orden header proxima hora listado de no disponibilidad para proximos dias \"(.*?)\"$")
	public void valido_que_se_visualice_imagen_icono_orden_header_proxima_hora_listado_de_no_disponibilidad_para_proximos_dias(String iconoProximaHoraSinDisponibilidad) throws Throwable {
		// Table header -- Cabecera tabla por gestionar icono orden
		GenericMethods.isElementPresent(BaseFlow.pageModel.getTbhCabeceraTablaPorGestionarIconoOrden().get(Integer.parseInt(iconoProximaHoraSinDisponibilidad)));
	}

	@Then("^Valido que se visualice header copago listado no disponibilidad para proximos dias \"(.*?)\"$")
	public void valido_que_se_visualice_header_copago_listado_no_disponibilidad_para_proximos_dias(String headerCopagoSinDisponibilidad) throws Throwable {
		// Table header -- Cabezara listado proximas horas disponibles
		GenericMethods.isElementPresent(BaseFlow.pageModel.getTbhCabezaraListadoProximasHorasDisponibles().get(Integer.parseInt(headerCopagoSinDisponibilidad)));
	}

	@Then("^Valido que header copago listado no disponibilidad para proximos dias \"(.*?)\"$")
	public void valido_que_header_copago_listado_no_disponibilidad_para_proximos_dias(String headerCopagoSinDisponibilidad) throws Throwable {
		if (BaseFlow.pageModel.getTbhCabezaraListadoProximasHorasDisponibles().get(Integer.parseInt(headerCopagoSinDisponibilidad)).getAttribute("innerText").trim().equals(
	    		BaseFlow.properties.getLabelCopago())) {
	    	assertTrue(true);
	    } else {
	    	System.out.println("Header copago no es correcto");
	    	assertTrue(false);
	    }
	}
	
	@Then("^Valido que se visualice imagen icono orden header copago listado de no disponibilidad para proximos dias \"(.*?)\"$")
	public void valido_que_se_visualice_imagen_icono_orden_header_copago_listado_de_no_disponibilidad_para_proximos_dias(String iconoCopagoSinDisponibilidad) throws Throwable {
		// Table header -- Cabecera tabla por gestionar icono orden
		GenericMethods.isElementPresent(BaseFlow.pageModel.getTbhCabeceraTablaPorGestionarIconoOrden().get(Integer.parseInt(iconoCopagoSinDisponibilidad)));
	}

	@Then("^Valido que se visualice header profesional listado no disponibilidad para proximos dias \"(.*?)\"$")
	public void valido_que_se_visualice_header_profesional_listado_no_disponibilidad_para_proximos_dias(String headerProfesionalSinDisponibilidad) throws Throwable {
		// Table header -- Cabezara listado proximas horas disponibles
		GenericMethods.isElementPresent(BaseFlow.pageModel.getTbhCabezaraListadoProximasHorasDisponibles().get(Integer.parseInt(headerProfesionalSinDisponibilidad)));
	}

	@Then("^Valido que header profesional listado no disponibilidad para proximos dias \"(.*?)\"$")
	public void valido_que_header_profesional_listado_no_disponibilidad_para_proximos_dias(String headerProfesionalSinDisponibilidad) throws Throwable {
		if (BaseFlow.pageModel.getTbhCabezaraListadoProximasHorasDisponibles().get(Integer.parseInt(headerProfesionalSinDisponibilidad)).getAttribute("innerText").trim().equals(
	    		BaseFlow.properties.getLabelProfesional())) {
	    	assertTrue(true);
	    } else {
	    	System.out.println("Header profesional no es correcto");
	    	assertTrue(false);
	    }
	}
	
	@Then("^Valido que se visualice imagen icono orden header profesional listado de no disponibilidad para proximos dias \"(.*?)\"$")
	public void valido_que_se_visualice_imagen_icono_orden_header_profesional_listado_de_no_disponibilidad_para_proximos_dias(String iconoProfesionalSinDisponibilidad) throws Throwable {
		// Table header -- Cabecera tabla por gestionar icono orden
		GenericMethods.isElementPresent(BaseFlow.pageModel.getTbhCabeceraTablaPorGestionarIconoOrden().get(Integer.parseInt(iconoProfesionalSinDisponibilidad)));
	}

	@Then("^Valido visualizacion mensaje no hay disponibilidad listado no disponibilidad para proximos dias \"(.*?)\"$")
	public void valido_visualizacion_mensaje_no_hay_disponibilidad_listado_no_disponibilidad_para_proximos_dias(String mensajeNoHayDisponibilidadListadoSinDisponibilidad) throws Throwable {
		// Label -- No hay disponibilidad para proximos siete dias
		GenericMethods.isElementPresent(BaseFlow.pageModel.getLblNoDisponibilidadProximosSieteDias().get(Integer.parseInt(mensajeNoHayDisponibilidadListadoSinDisponibilidad)));
	}

	@Then("^Valido mensaje no hay disponibilidad listado no disponibilidad para proximos dias sea correcto \"(.*?)\"$")
	public void valido_mensaje_no_hay_disponibilidad_listado_no_disponibilidad_para_proximos_dias_sea_correcto(String mensajeNoHayDisponibilidadListadoSinDisponibilidad) throws Throwable {
	    if (BaseFlow.pageModel.getLblNoDisponibilidadProximosSieteDias().get(Integer.parseInt(mensajeNoHayDisponibilidadListadoSinDisponibilidad)).getAttribute("innerText").trim().equals(
	    		BaseFlow.properties.getLabelNoHayDisponibilidadProximosSieteDias())) {
	    	assertTrue(true);
	    } else {
	    	System.out.println("Mensaje no hay disponibilidad para los próximos 7 días no es correcto");
	    	assertTrue(false);
	    }
	}
	
	@Then("^Valido visualizacion boton mas opciones listado no disponibilidad para proximos dias$")
	public void valido_visualizacion_boton_mas_opciones_listado_no_disponibilidad_para_proximos_dias() throws Throwable {
		totalBotonMasOpciones = 0;
		totalBotonMasOpciones = BaseFlow.pageModel.getBtnMasOpciones().size();
	    if (totalBotonMasOpciones > 0) {
	    	assertTrue(true);
	    } else {
	    	System.out.println("Tabla listado próximas horas de una prestación no contiene botón más opciones");
	    	assertTrue(false);
	    }
	}
	
	@Then("^Realizar click en boton mas opciones listado no disponibilidad para proximos dias \"(.*?)\"$")
	public void realizar_click_en_boton_mas_opciones_listado_no_disponibilidad_para_proximos_dias(String botonMasOpcionesListadoSinDisponibilidad) throws Throwable {
		// Button -- Mas opciones
		BaseFlow.pageModel.getBtnMasOpciones().get(Integer.parseInt(botonMasOpcionesListadoSinDisponibilidad)).click();
	}

	@Then("^Valido visualizacion listado mas opciones listado no disponibilidad para proximos dias$")
	public void valido_visualizacion_listado_mas_opciones_listado_no_disponibilidad_para_proximos_dias() throws Throwable {
		totalListadoMasOpciones = BaseFlow.pageModel.getListMasOpciones().size();
	    if (totalBotonMasOpciones > 0) {
	    	assertTrue(true);
	    } else {
	    	System.out.println("Opción de más opciones no contiene opciones");
	    	assertTrue(false);
	    }
	}

	@Then("^Valido no visualizacion primera opcion agendar hora listado no disponibilidad para proximos dias \"(.*?)\"$")
	public void valido_no_visualizacion_primera_opcion_agendar_hora_listado_no_disponibilidad_para_proximos_dias(String opcionAgendarBotonMasOpcionesListadoSinDisponibilidad) throws Throwable {
		// Button -- Seleccion agendar hora
		try {
				GenericMethods.isNotElementPresent(BaseFlow.pageModel.getBtnSeleccionAgendarHora().get(Integer.parseInt(opcionAgendarBotonMasOpcionesListadoSinDisponibilidad)));
		} catch (IndexOutOfBoundsException e) {
			assertTrue(true);
		}
	}

	@Then("^Valido visualizacion segunda opcion mas horas listado no disponibilidad para proximos dias \"(.*?)\"$")
	public void valido_visualizacion_segunda_opcion_mas_horas_listado_no_disponibilidad_para_proximos_dias(String opcionMasHorasBotonMasOpcionesListadoSinDisponibilidad) throws Throwable {
		// Button -- Seleccion mas horas
		GenericMethods.isElementPresent(BaseFlow.pageModel.getBtnSeleccionMasHoras().get(Integer.parseInt(opcionMasHorasBotonMasOpcionesListadoSinDisponibilidad)));
	}

	@Then("^Valido segunda opcion mas horas sea correcto listado no disponibilidad para proximos dias \"(.*?)\"$")
	public void valido_segunda_opcion_mas_horas_sea_correcto_listado_no_disponibilidad_para_proximos_dias(String opcionMasHorasBotonMasOpcionesListadoSinDisponibilidad) throws Throwable {
		if (BaseFlow.pageModel.getBtnSeleccionMasHoras().get(Integer.parseInt(opcionMasHorasBotonMasOpcionesListadoSinDisponibilidad)).getAttribute("innerText").trim().equals(
	    		BaseFlow.properties.getLabelMasHoras())) {
	    	assertTrue(true);
	    } else {
	    	System.out.println("Opción más horas no es correcto");
			assertTrue(false);
	    }
	}

	@Then("^Valido segunda opcion mas horas se encuentre habilitado listado no disponibilidad para proximos dias \"(.*?)\"$")
	public void valido_segunda_opcion_mas_horas_se_encuentre_habilitado_listado_no_disponibilidad_para_proximos_dias(String opcionMasHorasBotonMasOpcionesListadoSinDisponibilidad) throws Throwable {
		boolean condition = BaseFlow.pageModel.getBtnSeleccionMasHoras().get(Integer.parseInt(opcionMasHorasBotonMasOpcionesListadoSinDisponibilidad)).isEnabled();
	    if (condition == true) {
	    	assertTrue(true);
	    } else {
	    	System.out.println("Opción más horas no se encuentra habilitado");
			assertTrue(false);
	    }
	}

	@Then("^Realizar click segunda opcion mas horas listado no disponibilidad para proximos dias \"(.*?)\"$")
	public void realizar_click_segunda_opcion_mas_horas_listado_no_disponibilidad_para_proximos_dias(String opcionMasHorasBotonMasOpcionesListadoSinDisponibilidad) throws Throwable {
		// Button -- Seleccion mas horas
		BaseFlow.pageModel.getBtnSeleccionMasHoras().get(Integer.parseInt(opcionMasHorasBotonMasOpcionesListadoSinDisponibilidad)).click();
	}

	@Then("^Valido visualizacion ventana nueva reserva de hora$")
	public void valido_visualizacion_ventana_nueva_reserva_de_hora() throws Throwable {
	    //tiempo de espera
		Thread.sleep(13000);
		// Div -- Nueva reserva
		GenericMethods.isElementPresent(BaseFlow.pageModel.getDivNuevaReserva());
	}

	@Then("^Realizar click boton cerrar ventana nueva reserva de hora \"(.*?)\"$")
	public void realizar_click_boton_cerrar_ventana_nueva_reserva_de_hora(String botonCerrarVentanaNuevaReservaHora) throws Throwable {
		// Button -- Cerrar nueva reserva
		BaseFlow.pageModel.getBtnCerrarNuevaReserva().get(Integer.parseInt(botonCerrarVentanaNuevaReservaHora)).click();
		//tiempo de espera
		Thread.sleep(2000);
	}

	@Then("^Realizar click nuevamente en detalle de prestacion no disponibilidad para proximos dias \"(.*?)\"$")
	public void realizar_click_nuevamente_en_detalle_de_prestacion_no_disponibilidad_para_proximos_dias(String detallePrestacionSinDisponibilidad) throws Throwable {
		/*
		List<WebElement> acordeonBody = BaseFlow.driver.findElements(By.className("accordion-body"));
	    for (WebElement a : BaseFlow.pageModel.getTbItemDetallePrestaciones()) {
	    	a.click();
	    	if(GenericMethods.isElementPresent(acordeonBody.get(0)));
			break;
	    }
	    */
		BaseFlow.pageModel.getTbItemDetallePrestaciones().get(Integer.parseInt(detallePrestacionSinDisponibilidad)).click();
		//tiempo espera explicito
		Thread.sleep(2000);
	}
	
	@Then("^Valido que se visualice icono imagen pestaña apertura prestacion listado de las proximas horas disponibles \"(.*?)\"$")
	public void valido_que_se_visualice_icono_imagen_pestaña_apertura_prestacion_listado_de_las_proximas_horas_disponibles(String pestañaAperturaPrestacionProximasHorasDisponible) throws Throwable {
		// Imagen -- Icono pestaña apertura prestacion
		GenericMethods.isElementPresent(BaseFlow.pageModel.getImgIconoPestañaAperturaPrestacion().get(Integer.parseInt(pestañaAperturaPrestacionProximasHorasDisponible)));
	}

	@Then("^Valido que icono imagen pestaña apertura se encuentre habilitado prestacion listado de las proximas horas disponibles \"(.*?)\"$")
	public void valido_que_icono_imagen_pestaña_apertura_se_encuentre_habilitado_prestacion_listado_de_las_proximas_horas_disponibles(String pestañaAperturaPrestacionProximasHorasDisponible) throws Throwable {
		boolean condition = BaseFlow.pageModel.getImgIconoPestañaAperturaPrestacion().get(Integer.parseInt(pestañaAperturaPrestacionProximasHorasDisponible)).isEnabled();
	    if (condition == true) {
	    	assertTrue(true);
	    } else {
	    	System.out.println("Icono imágen pestaña apertura no se encuentra habilitado");
	    	assertTrue(false);
	    }
	}
	
	@Then("^Valido que se visualice link leer indicaciones listado de las proximas horas disponibles \"(.*?)\"$")
	public void valido_que_se_visualice_link_leer_indicaciones_listado_de_las_proximas_horas_disponibles(String linkLeerIndicacionesProximasHorasDisponible) throws Throwable {
		// Button -- Link leer indicaciones
		GenericMethods.isElementPresent(BaseFlow.pageModel.getBtnLinkLeerIndicaciones().get(Integer.parseInt(linkLeerIndicacionesProximasHorasDisponible)));
	}

	@Then("^Valido que link leer indicaciones sea correcto listado de las proximas horas disponibles \"(.*?)\"$")
	public void valido_que_link_leer_indicaciones_sea_correcto_listado_de_las_proximas_horas_disponibles(String linkLeerIndicacionesProximasHorasDisponible) throws Throwable {
		if (BaseFlow.pageModel.getBtnLinkLeerIndicaciones().get(Integer.parseInt(linkLeerIndicacionesProximasHorasDisponible)).getAttribute("innerText").trim().equals(
	    		BaseFlow.properties.getLabelLeerIndicacionesTwo())) {
	    	assertTrue(true);
	    } else {
	    	System.out.println("Link leer indicaciones no es correcto");
	    	assertTrue(false);
	    }
	}

	@Then("^Realizar click link leer indicaciones listado de las proximas horas disponibles \"(.*?)\"$")
	public void realizar_click_link_leer_indicaciones_listado_de_las_proximas_horas_disponibles(String linkLeerIndicacionesProximasHorasDisponible) throws Throwable {
		// Button -- Link leer indicaciones
		BaseFlow.pageModel.getBtnLinkLeerIndicaciones().get(Integer.parseInt(linkLeerIndicacionesProximasHorasDisponible)).click();
		//tiempo de espera explicito
		Thread.sleep(5000);
	}

	@Then("^Valido la visualizacion ventana leer las indicaciones$")
	public void valido_la_visualizacion_ventana_leer_las_indicaciones() throws Throwable {
		// Div -- Leer indicaciones
		GenericMethods.isElementPresent(BaseFlow.pageModel.getDivLeerIndicaciones());
	}

	@Then("^Valido la visualizacion titulo ventana leer indicaciones$")
	public void valido_la_visualizacion_titulo_ventana_leer_indicaciones() throws Throwable {
		// H5 -- Leer indicaciones
		GenericMethods.isElementPresent(BaseFlow.pageModel.gethFiveTituloLeerIndicaciones());
	}

	@Then("^Valido que el titulo indicaciones sea correcto ventana leer indicaciones$")
	public void valido_que_el_titulo_indicaciones_sea_correcto_ventana_leer_indicaciones() throws Throwable {
		if (BaseFlow.pageModel.gethFiveTituloLeerIndicaciones().getAttribute("innerText").trim().equals(
	    		BaseFlow.properties.getLabelLeerIndicaciones())) {
	    	assertTrue(true);
	    } else {
	    	System.out.println("Título leer indicaciones no es correcto");
	    	assertTrue(false);
	    }
	}

	@Then("^Valido la visualizacion elemento contenedor listado de indicaciones ventana leer indicaciones$")
	public void valido_la_visualizacion_elemento_contenedor_listado_de_indicaciones_ventana_leer_indicaciones() throws Throwable {
		// Div -- Listado leer indicaciones
	    GenericMethods.isElementPresent(BaseFlow.pageModel.getDivListadoLeerIndicaciones());
	}

	@Then("^Valido la visualizacion listado de indicaciones ventana leer indicaciones$")
	public void valido_la_visualizacion_listado_de_indicaciones_ventana_leer_indicaciones() throws Throwable {
		if (BaseFlow.pageModel.getLiListadoLeerIndicaciones().size() > 1) {
			assertTrue(true);
		} else {
			System.out.println("No se visualiza listado de indicaciones");
			assertTrue(false);
		}
	}

	@Then("^Valido la visualizacion boton he leido las indicaciones ventana leer indicaciones$")
	public void valido_la_visualizacion_boton_he_leido_las_indicaciones_ventana_leer_indicaciones() throws Throwable {
		// Button -- He leido las indicaciones en OCM
		GenericMethods.isElementPresent(BaseFlow.pageModel.getBtnHeLeidoLasIndicacionesOcm());
	}

	@Then("^Valido que boton he leido las indicaciones se encuentre habilitado ventana leer indicaciones$")
	public void valido_que_boton_he_leido_las_indicaciones_se_encuentre_habilitado_ventana_leer_indicaciones() throws Throwable {
		boolean condition = BaseFlow.pageModel.getBtnHeLeidoLasIndicacionesOcm().isEnabled();
	    if (condition == true) {
	    	assertTrue(true);
	    } else {
	    	System.out.println("Boton he leido las indicaciones no se encuentra habilitado");
	    	assertTrue(false);
	    }
	}

	@Then("^Realizar click en boton he leido las indicaciones ventana leer indicaciones$")
	public void realizar_click_en_boton_he_leido_las_indicaciones_ventana_leer_indicaciones() throws Throwable {
		// Button -- He leido las indicaciones en OCM
		BaseFlow.pageModel.getBtnHeLeidoLasIndicacionesOcm().click();
		//tiempo de espera explicito
		Thread.sleep(1000);
	}
	
	@Then("^Realizar click en detalle de prestacion listado de las proximas horas disponibles \"(.*?)\"$")
	public void realizar_click_en_detalle_de_prestacion_listado_de_las_proximas_horas_disponibles(String detallePrestacionListadoProximasHorasDisponible) throws Throwable {
		/*
		List<WebElement> acordeonBody = BaseFlow.driver.findElements(By.className("accordion-body"));
	    for (WebElement a : BaseFlow.pageModel.getTbItemDetallePrestaciones()) {
	    	a.click();
	    	if(GenericMethods.isElementPresent(acordeonBody.get(0)));
			break;
	    }
	    */
		BaseFlow.pageModel.getTbItemDetallePrestaciones().get(Integer.parseInt(detallePrestacionListadoProximasHorasDisponible)).click();
		//tiempo espera explicito
		Thread.sleep(20000);
	}

	@Then("^Valido que el detalle de prestacion contenga listado de las proximas horas disponibles$")
	public void valido_que_el_detalle_de_prestacion_contenga_listado_de_las_proximas_horas_disponibles() throws Throwable {
	    totalListadoHorasDisponibles = BaseFlow.pageModel.getTbListadoProximasHorasDisponibles().size();
	    if (totalListadoHorasDisponibles > 0) {
	    	assertTrue(true);
	    } else {
	    	System.out.println("Tabla no contiene listado próximas horas a una prestación y esta a las ordenes pendientes por agendar");
	    	assertTrue(false);
	    }
	}

	@Then("^Valido que se visualice header prestador listado de las proximas horas disponibles \"(.*?)\"$")
	public void valido_que_se_visualice_header_prestador_listado_de_las_proximas_horas_disponibles(String headerPrestadorProximasHorasDisponible) throws Throwable {	    
		// Table header -- Cabezara listado proximas horas disponibles
		GenericMethods.isElementPresent(BaseFlow.pageModel.getTbhCabezaraListadoProximasHorasDisponibles().get(Integer.parseInt(headerPrestadorProximasHorasDisponible)));
	}

	@Then("^Valido que header prestador listado de las proximas horas disponibles \"(.*?)\"$")
	public void valido_que_header_prestador_listado_de_las_proximas_horas_disponibles(String headerPrestadorProximasHorasDisponible) throws Throwable {
		//System.out.println("x:"+BaseFlow.pageModel.getTbhCabezaraListadoProximasHorasDisponibles().get(Integer.parseInt(headerPrestadorProximasHorasDisponible)).getAttribute("innerText").trim());
		//System.out.println("xx:"+BaseFlow.properties.getLabelPrestador());
		//Thread.sleep(10000000);
		if (BaseFlow.pageModel.getTbhCabezaraListadoProximasHorasDisponibles().get(Integer.parseInt(headerPrestadorProximasHorasDisponible)).getAttribute("innerText").trim().equals(
				BaseFlow.properties.getLabelPrestador())) {
			assertTrue(true);
		} else {
			System.out.println("Header prestador no es correcto");
	    	assertTrue(false);
		}
	}
	
	@Then("^Valido que se visualice imagen icono orden header prestador listado de las proximas horas disponibles \"(.*?)\"$")
	public void valido_que_se_visualice_imagen_icono_orden_header_prestador_listado_de_las_proximas_horas_disponibles(String iconoPrestadorProximasHorasDisponible) throws Throwable {
		// Table header -- Cabecera tabla por gestionar icono orden
		GenericMethods.isElementPresent(BaseFlow.pageModel.getTbhCabeceraTablaPorGestionarIconoOrden().get(Integer.parseInt(iconoPrestadorProximasHorasDisponible)));
	}

	@Then("^Valido que se visualice header proxima hora listado de las proximas horas disponibles \"(.*?)\"$")
	public void valido_que_se_visualice_header_proxima_hora_listado_de_las_proximas_horas_disponibles(String headerProximaHoraProximasHorasDisponible) throws Throwable {
		// Table header -- Cabezara listado proximas horas disponibles
		GenericMethods.isElementPresent(BaseFlow.pageModel.getTbhCabezaraListadoProximasHorasDisponibles().get(Integer.parseInt(headerProximaHoraProximasHorasDisponible)));
	}

	@Then("^Valido que header proxima hora listado de las proximas horas disponibles \"(.*?)\"$")
	public void valido_que_header_proxima_hora_listado_de_las_proximas_horas_disponibles(String headerProximaHoraProximasHorasDisponible) throws Throwable {
	    if (BaseFlow.pageModel.getTbhCabezaraListadoProximasHorasDisponibles().get(Integer.parseInt(headerProximaHoraProximasHorasDisponible)).getAttribute("innerText").trim().equals(
	    		BaseFlow.properties.getLabelProximaHora())) {
	    	assertTrue(true);
	    } else {
	    	System.out.println("Header próxima hora no es correcto");
	    	assertTrue(false);
	    }
	}
	
	@Then("^Valido que se visualice imagen icono orden header proxima hora listado de las proximas horas disponibles \"(.*?)\"$")
	public void valido_que_se_visualice_imagen_icono_orden_header_proxima_hora_listado_de_las_proximas_horas_disponibles(String iconoProximaHoraProximasHorasDisponible) throws Throwable {
		// Table header -- Cabecera tabla por gestionar icono orden
		GenericMethods.isElementPresent(BaseFlow.pageModel.getTbhCabeceraTablaPorGestionarIconoOrden().get(Integer.parseInt(iconoProximaHoraProximasHorasDisponible)));
	}

	@Then("^Valido que se visualice header copago listado de las proximas horas disponibles \"(.*?)\"$")
	public void valido_que_se_visualice_header_copago_listado_de_las_proximas_horas_disponibles(String headerCopagoProximasHorasDisponible) throws Throwable {
		// Table header -- Cabezara listado proximas horas disponibles
		GenericMethods.isElementPresent(BaseFlow.pageModel.getTbhCabezaraListadoProximasHorasDisponibles().get(Integer.parseInt(headerCopagoProximasHorasDisponible)));
	}

	@Then("^Valido que header copago listado de las proximas horas disponibles \"(.*?)\"$")
	public void valido_que_header_copago_listado_de_las_proximas_horas_disponibles(String headerCopagoProximasHorasDisponible) throws Throwable {
	    if (BaseFlow.pageModel.getTbhCabezaraListadoProximasHorasDisponibles().get(Integer.parseInt(headerCopagoProximasHorasDisponible)).getAttribute("innerText").trim().equals(
	    		BaseFlow.properties.getLabelCopago())) {
	    	assertTrue(true);
	    } else {
	    	System.out.println("Header copago no es correcto");
	    	assertTrue(false);
	    }	    
	}
	
	@Then("^Valido que se visualice imagen icono orden header copago listado de las proximas horas disponibles \"(.*?)\"$")
	public void valido_que_se_visualice_imagen_icono_orden_header_copago_listado_de_las_proximas_horas_disponibles(String iconoCopagoProximasHorasDisponible) throws Throwable {
		// Table header -- Cabecera tabla por gestionar icono orden
		GenericMethods.isElementPresent(BaseFlow.pageModel.getTbhCabeceraTablaPorGestionarIconoOrden().get(Integer.parseInt(iconoCopagoProximasHorasDisponible)));
	}

	@Then("^Valido que se visualice header profesional listado de las proximas horas disponibles \"(.*?)\"$")
	public void valido_que_se_visualice_header_profesional_listado_de_las_proximas_horas_disponibles(String headerProfesionalProximasHorasDisponible) throws Throwable {
		// Table header -- Cabezara listado proximas horas disponibles
		GenericMethods.isElementPresent(BaseFlow.pageModel.getTbhCabezaraListadoProximasHorasDisponibles().get(Integer.parseInt(headerProfesionalProximasHorasDisponible)));
	}

	@Then("^Valido que header profesional listado de las proximas horas disponibles \"(.*?)\"$")
	public void valido_que_header_profesional_listado_de_las_proximas_horas_disponibles(String headerProfesionalProximasHorasDisponible) throws Throwable {
	    if (BaseFlow.pageModel.getTbhCabezaraListadoProximasHorasDisponibles().get(Integer.parseInt(headerProfesionalProximasHorasDisponible)).getAttribute("innerText").trim().equals(
	    		BaseFlow.properties.getLabelProfesional())) {
	    	assertTrue(true);
	    } else {
	    	System.out.println("Header profesional no es correcto");
	    	assertTrue(false);
	    }
	}
	
	@Then("^Valido que se visualice imagen icono orden header profesional listado de las proximas horas disponibles \"(.*?)\"$")
	public void valido_que_se_visualice_imagen_icono_orden_header_profesional_listado_de_las_proximas_horas_disponibles(String iconoProfesionalProximasHorasDisponible) throws Throwable {
		// Table header -- Cabecera tabla por gestionar icono orden
		GenericMethods.isElementPresent(BaseFlow.pageModel.getTbhCabeceraTablaPorGestionarIconoOrden().get(Integer.parseInt(iconoProfesionalProximasHorasDisponible)));
	}
	
	@Then("^Valido que aparezca centros medicos de una prestacion$")
	public void valido_que_aparezca_centros_medicos_de_una_prestacion() throws Throwable {
		totalCentrosMedico = BaseFlow.pageModel.getTbCentrosMedicos().size();
		if (totalCentrosMedico > 0) {
			assertTrue(true);
		} else {
			System.out.println("Tabla no contiene centros médicos asociado a una prestación específica");
			assertTrue(false);
		}
	}
	
	@Then("^Valido que aparezca listado de horas de una prestacion \"(.*?)\"$")
	public void valido_que_aparezca_listado_de_horas_de_una_prestacion(String listadoHoraDePrestacion) throws Throwable {
		// ListBox -- Horas disponibles
		GenericMethods.isElementPresent(BaseFlow.pageModel.getLbxHorasDisponibles().get(Integer.parseInt(listadoHoraDePrestacion)));
		//tiempo de espera
		Thread.sleep(4000);
	}
	
	@Then("^Valido que se visualice boton mas opciones$")
	public void valido_que_se_visualice_boton_mas_opciones() throws Throwable {
		totalBotonMasOpciones = 0;
	    totalBotonMasOpciones = BaseFlow.pageModel.getBtnMasOpciones().size();
	    if (totalBotonMasOpciones > 0) {
	    	assertTrue(true);
	    } else {
	    	System.out.println("Tabla listado próximas horas de una prestación no contiene botón más opciones");
	    	assertTrue(false);
	    }
	}

	@Then("^Valido que boton mas opciones se encuentre habilitado$")
	public void valido_que_boton_mas_opciones_se_encuentre_habilitado() throws Throwable {
		// Button -- Mas opciones
		boolean condition = BaseFlow.pageModel.getBtnMasOpciones().get(0).isEnabled();
		if (condition == true) {
			assertTrue(true);
		} else {
			System.out.println("Botón más opciones no se encuentra habilitado");
		}
	}

	@Then("^Realizar click boton mas opciones \"(.*?)\"$")
	public void realizar_click_boton_mas_opciones(String masOpciones) throws Throwable {
		/*
		List<WebElement> contenedorOpciones = BaseFlow.driver.findElements(By.className("container-popover"));
	    for (WebElement a : BaseFlow.pageModel.getBtnMasOpciones()) {
	    	a.click();
	    	if(GenericMethods.isElementPresent(contenedorOpciones.get(0)));
			break;
	    }
	    */
		BaseFlow.pageModel.getBtnMasOpciones().get(Integer.parseInt(masOpciones)).click();
	}

	@Then("^Valido que se visualice en listado de mas opciones agendar hora \"(.*?)\"$")
	public void valido_que_se_visualice_en_listado_de_mas_opciones_agendar_hora(String masOpcionesAgendarHora) throws Throwable {		
		// Button -- Seleccion agendar hora		
		GenericMethods.isElementPresent(BaseFlow.pageModel.getBtnSeleccionAgendarHora().get(Integer.parseInt(masOpcionesAgendarHora)));
	}

	@Then("^Valido que primera opcion agendar hora sea correcto \"(.*?)\"$")
	public void valido_que_primera_opcion_agendar_hora_sea_correcto(String masOpcionesAgendarHora) throws Throwable {
		//List<WebElement> BtnSeleccionAgendarHora = BaseFlow.driver.findElements(By.cssSelector("[data-target=\"#modal-success\"]"));
		/*
		if (BaseFlow.pageModel.getBtnSeleccionAgendarHora().get(0).getAttribute("innerText").trim().equals(
				BaseFlow.properties.getLabelAgendarHora())) {
			assertTrue(true);
		} else {
			System.out.println("Opción agendar hora no es correcto");
			assertTrue(false);
		}
		*/		
		if (BaseFlow.pageModel.getBtnSeleccionAgendarHora().get(Integer.parseInt(masOpcionesAgendarHora)).getAttribute("innerText").trim().equals(BaseFlow.properties.getLabelAgendarHora())) {
			assertTrue(true);
		} else {
			System.out.println("Opción agendar hora no es correcto");
			assertTrue(false);
		}
	}
	
	@Then("^Valido que se visualice en listado de mas opciones mas horas \"(.*?)\"$")
	public void valido_que_se_visualice_en_listado_de_mas_opciones_mas_horas(String masOpcionesMasHoras) throws Throwable {		
		// Button -- Seleccion mas horas
		GenericMethods.isElementPresent(BaseFlow.pageModel.getBtnSeleccionMasHoras().get(Integer.parseInt(masOpcionesMasHoras)));
	}

	@Then("^Valido que segunda opcion mas horas sea correcto \"(.*?)\"$")
	public void valido_que_segunda_opcion_mas_horas_sea_correcto(String masOpcionesMasHoras) throws Throwable {		
		if (BaseFlow.pageModel.getBtnSeleccionMasHoras().get(Integer.parseInt(masOpcionesMasHoras)).getAttribute("innerText").trim().equals(
	    		BaseFlow.properties.getLabelMasHoras())) {
	    	assertTrue(true);
	    } else {
	    	System.out.println("Opción más horas no es correcto");
			assertTrue(false);
	    }
	}
}
