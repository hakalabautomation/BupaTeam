package cl.bupa.qa.automation.web.poc.definition.components;

import static org.junit.Assert.assertTrue;

import org.codehaus.jettison.json.JSONObject;

import cl.bupa.qa.automation.web.business.flow.BaseFlow;
import cl.bupa.qa.automation.web.json.conn.EndPointConn;
import cl.bupa.qa.automation.web.poc.util.GenericMethods;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class DefinitionComponentAnulacionNuevaReservaHoraIndicacionesEspecialidad {
	
	public static String tokenService;
	public static String nombreService;
	public static String lblEspecialidad;
	public static String lblPrestacion;
	public static String lblCentroMedico;
	public static int totalEspecialidadWeb;
	public static int totalPrestacionWeb;
	public static int totalRegionWeb;
	public static int totalCentroMedicoWeb;
	public static int totalEspecialidadService;
	public static int totalPrestacionService;
	public static int totalRegionService;
	public static int totalCentroMedicoService;
	
	@Given("^Doy click en boton nueva reserva de hora$")
	public void doy_click_en_boton_nueva_reserva_de_hora() throws Throwable {
		boolean condition = BaseFlow.pageModel.getBtnNuevaReservaHora().isEnabled();
		if (condition == true) {
			assertTrue(true);
			BaseFlow.pageModel.getBtnNuevaReservaHora().click();			
		} else {
			System.out.println("Botón nueva reserva hora no se encuentra habilitado");
			assertTrue(false);
		}
	}

	@Given("^Valido que se muestre titulo$")
	public void valido_que_se_muestre_titulo() throws Throwable {
		
	}

	@Given("^Valido que se visualice como titulo nombre del paciente$")
	public void valido_que_se_visualice_como_titulo_nombre_del_paciente() throws Throwable {
		// Span -- Nombre paciente
		GenericMethods.isElementPresent(BaseFlow.pageModel.getSpnNombrePaciente());
	}

	@Given("^Llamo al servicio token y devuelvo datos \"(.*?)\" \"(.*?)\"$")
	public void llamo_al_servicio_token_y_devuelvo_datos(String usuario, String contraseña) throws Throwable {
		BaseFlow.commJson.setConn(EndPointConn.endPointLoginQa); // La URL del servicio
		BaseFlow.commJson.setRequestMethod("POST"); // Metodo de servicio
		BaseFlow.commJson.setRequestProperty(EndPointConn.requestPropertyHeaderNameOneLoginQa,
				EndPointConn.requestPropertyHeaderValueOneLoginQa); // Headers y value 1 del servicio
		BaseFlow.commJson.setRequestProperty(EndPointConn.requestPropertyHeaderNameTwoLoginQa,
				EndPointConn.requestPropertyHeaderValueTwoLoginQa); // Headers y value 2 del servicio
		String bodyPostOne = "{\"usuario\" : \"" + usuario + "\", \"contrasena\" : \"" + contraseña + "\"}";
		BaseFlow.commJson.postParametros(bodyPostOne);
		if (BaseFlow.commJson.getResponseCode() == 200) {
			JSONObject obj = new JSONObject(BaseFlow.commJson.getJsonData());
			tokenService = obj.getString("token");
		}
	}

	@Given("^Valido que coincida el nombre paciente desplegado en la web y servicio \"(.*?)\"$")
	public void valido_que_coincida_el_nombre_paciente_desplegado_en_la_web_y_servicio(String rutSearch) throws Throwable {
		// llamo al servicio de consulta paciente por rut
		BaseFlow.commJson.setConn(EndPointConn.endPointPacienteBuscarQa); // La URL del servicio
		BaseFlow.commJson.setRequestMethod("POST"); // Metodo de servicio
		BaseFlow.commJson.setRequestProperty(EndPointConn.requestPropertyHeaderNameOneQa, "Beared " + tokenService); // Headers y value 1 del servicio
		BaseFlow.commJson.setRequestProperty(EndPointConn.requestPropertyHeaderNameTwoQa,
				EndPointConn.requestPropertyHeaderValueTwoEspecialtyQa); // Headers y value 2 del servicio
		BaseFlow.commJson.setRequestProperty(EndPointConn.requestPropertyHeaderNameThreeQa,
				EndPointConn.requestPropertyHeaderValueThreeEspecialtyQa); // Headers y value 3 del servicio
		String bodyPost = "{\"paciente\" : \"" + rutSearch + "\"}"; // Value en body
		BaseFlow.commJson.postParametros(bodyPost);
		if (BaseFlow.commJson.getResponseCode() == 200) {
			assertTrue(true);
			// se genera array de body
			JSONObject obj = new JSONObject(BaseFlow.commJson.getJsonData());
			if (obj.length() > 0) {
				assertTrue(true);
				nombreService = obj.getJSONObject("pacienteresponse").getString("nombre");
			} else {
				System.out.println("Servicio búsqueda paciente por rut no devuelve datos");
				assertTrue(false);
			}
		} else {
			System.out.println("Servicio búsqueda paciente por rut no responde");
			assertTrue(false);
		}
		// comparación de nombres
		if (BaseFlow.pageModel.getSpnNombrePaciente().getText().trim().equalsIgnoreCase(nombreService)) {
			assertTrue(true);
		} else {
			System.out.println("Nombre paciente mostrado no coincide");
			assertTrue(false);
		}
	}

	@Given("^Valido que se visualice pestaña especialidad$")
	public void valido_que_se_visualice_pestaña_especialidad() throws Throwable {
		// Tab -- Especialidad
		GenericMethods.isElementPresent(BaseFlow.pageModel.getTbEspecialidad());
	}

	@Given("^Valido imagen mostrada en pestaña especialidad$")
	public void valido_imagen_mostrada_en_pestaña_especialidad() throws Throwable {
		// Imagen -- Icono espacialidad
		GenericMethods.isElementPresent(BaseFlow.pageModel.getImgIconoEspecialidadEsp());
	}

	@When("^Seleccion pestaña especialidad$")
	public void seleccion_pestaña_especialidad() throws Throwable {
		// por defecto muestra especialidad
		// BaseFlow.pageModel.getTbEspecialidad().click();
	}

	@Then("^Visualizo ventana de especialidad$")
	public void visualizo_ventana_de_especialidad() throws Throwable {
	    
	}

	@When("^Llamo al servicio de especialidad \"(.*?)\" \"(.*?)\"$")
	public void llamo_al_servicio_de_especialidad(String arg1, String arg2) throws Throwable {
	    
	}

	@When("^Selecciono lista de especialidades desplegadas en la pagina web$")
	public void selecciono_lista_de_especialidades_desplegadas_en_la_pagina_web() throws Throwable {
	    
	}

	@Then("^Valido que la cantidad del listado especialidad coincida entre lo desplegado en la web y el servicio$")
	public void valido_que_la_cantidad_del_listado_especialidad_coincida_entre_lo_desplegado_en_la_web_y_el_servicio() throws Throwable {
	    
	}

	@Then("^Selecciono opcion de especialidad$")
	public void selecciono_opcion_de_especialidad() throws Throwable {
	    
	}

	@Then("^Valido el label de especialidad \"(.*?)\"$")
	public void valido_el_label_de_especialidad(String arg1) throws Throwable {
	    
	}

	@When("^Llamo al servicio de prestacion \"(.*?)\" \"(.*?)\" \"(.*?)\"$")
	public void llamo_al_servicio_de_prestacion(String arg1, String arg2, String arg3) throws Throwable {
	    
	}

	@When("^Selecciono lista de prestaciones desplegadas en la pagina web$")
	public void selecciono_lista_de_prestaciones_desplegadas_en_la_pagina_web() throws Throwable {
	    
	}

	@Then("^Valido que la cantidad del listado prestacion coincida entre lo desplegado en la web y el servicio$")
	public void valido_que_la_cantidad_del_listado_prestacion_coincida_entre_lo_desplegado_en_la_web_y_el_servicio() throws Throwable {
	    
	}

	@Then("^Selecciono opcion de prestacion$")
	public void selecciono_opcion_de_prestacion() throws Throwable {
	    
	}

	@Then("^Valido el label de prestacion \"(.*?)\"$")
	public void valido_el_label_de_prestacion(String arg1) throws Throwable {
	    
	}

	@When("^Llamo al servicio de region \"(.*?)\" \"(.*?)\" \"(.*?)\"$")
	public void llamo_al_servicio_de_region(String arg1, String arg2, String arg3) throws Throwable {
	    
	}

	@When("^Selecciono lista de regiones desplegados en la pagina web$")
	public void selecciono_lista_de_regiones_desplegados_en_la_pagina_web() throws Throwable {
	    
	}

	@Then("^Valido que la cantidad del listado region coincida entre lo desplegado en la web y el servicio$")
	public void valido_que_la_cantidad_del_listado_region_coincida_entre_lo_desplegado_en_la_web_y_el_servicio() throws Throwable {
	    
	}

	@Then("^Selecciono opcion de region$")
	public void selecciono_opcion_de_region() throws Throwable {
	    
	}

	@Then("^Valido el label de region \"(.*?)\"$")
	public void valido_el_label_de_region(String arg1) throws Throwable {
	    
	}

	@When("^Llamo al servicio de centro medico \"(.*?)\" \"(.*?)\" \"(.*?)\" \"(.*?)\"$")
	public void llamo_al_servicio_de_centro_medico(String arg1, String arg2, String arg3, String arg4) throws Throwable {
	    
	}

	@When("^Selecciono lista de centros medicos desplegados en la pagina web$")
	public void selecciono_lista_de_centros_medicos_desplegados_en_la_pagina_web() throws Throwable {
	    
	}

	@Then("^Valido que la cantidade de centros medicos coincidan entre lo desplegado en la web y el servicio$")
	public void valido_que_la_cantidade_de_centros_medicos_coincidan_entre_lo_desplegado_en_la_web_y_el_servicio() throws Throwable {
	    
	}

	@Then("^Selecciono opcion de centro medico$")
	public void selecciono_opcion_de_centro_medico() throws Throwable {
	    
	}

	@Then("^Valido el label de centro medico \"(.*?)\"$")
	public void valido_el_label_de_centro_medico(String arg1) throws Throwable {
	    
	}

	@When("^Visualizo fechas que estan disponibles$")
	public void visualizo_fechas_que_estan_disponibles() throws Throwable {
	    
	}

	@Then("^Valido que existe una fecha especifica seleccionada$")
	public void valido_que_existe_una_fecha_especifica_seleccionada() throws Throwable {
	    
	}

	@Then("^Llamo al servicio de dia$")
	public void llamo_al_servicio_de_dia() throws Throwable {
	    
	}

	@Then("^Valido que aparezca titulo de mes y año actual$")
	public void valido_que_aparezca_titulo_de_mes_y_año_actual() throws Throwable {
	    
	}

	@Then("^Valido el titulo mes y año que sea correcto$")
	public void valido_el_titulo_mes_y_año_que_sea_correcto() throws Throwable {
	    
	}

	@Then("^Valido que aparezca el subtitulo de semana$")
	public void valido_que_aparezca_el_subtitulo_de_semana() throws Throwable {
	    
	}

	@Then("^Valido que rango de dias sea correcto a la semana$")
	public void valido_que_rango_de_dias_sea_correcto_a_la_semana() throws Throwable {
	    
	}

	@When("^Valido que aparezca apartado de horas de la especialidad$")
	public void valido_que_aparezca_apartado_de_horas_de_la_especialidad() throws Throwable {
	    
	}

	@Then("^Valido que aparezca titulo fecha segun dia seleccionado$")
	public void valido_que_aparezca_titulo_fecha_segun_dia_seleccionado() throws Throwable {
	    
	}

	@Then("^Valido que titulo fecha sea correcto segun dia seleccionado$")
	public void valido_que_titulo_fecha_sea_correcto_segun_dia_seleccionado() throws Throwable {
	    
	}

	@Then("^Valido que subtitulo compuesto entre especialidad mas prestacion coincida segun lo seleccionado$")
	public void valido_que_subtitulo_compuesto_entre_especialidad_mas_prestacion_coincida_segun_lo_seleccionado() throws Throwable {
	    
	}

	@Then("^Valido que subtitulo de centro medico coincida segun lo seleccionado$")
	public void valido_que_subtitulo_de_centro_medico_coincida_segun_lo_seleccionado() throws Throwable {
	    
	}

	@Then("^Selecciono una hora disponible en ventana de hora especialidad$")
	public void selecciono_una_hora_disponible_en_ventana_de_hora_especialidad() throws Throwable {
	    
	}

	@When("^Valido que se visualice ventana resumen de la especialidad$")
	public void valido_que_se_visualice_ventana_resumen_de_la_especialidad() throws Throwable {
	    
	}

	@Then("^Valido que se visualice imagen icono doctor ventana resumen especialidad$")
	public void valido_que_se_visualice_imagen_icono_doctor_ventana_resumen_especialidad() throws Throwable {
	    
	}

	@Then("^Valido que se visualice nombre del doctor ventana resumen especialidad$")
	public void valido_que_se_visualice_nombre_del_doctor_ventana_resumen_especialidad() throws Throwable {
	    
	}

	@Then("^Valido que se visualice especialidad del doctor ventana resumen especialidad$")
	public void valido_que_se_visualice_especialidad_del_doctor_ventana_resumen_especialidad() throws Throwable {
	    
	}

	@Then("^Valido que especialidad seleccionada coincida con la mostrada ventana resumen especialidad$")
	public void valido_que_especialidad_seleccionada_coincida_con_la_mostrada_ventana_resumen_especialidad() throws Throwable {
	    
	}

	@Then("^Valido que se visualice centro medico ventana resumen especialidad$")
	public void valido_que_se_visualice_centro_medico_ventana_resumen_especialidad() throws Throwable {
	    
	}

	@Then("^Valido que centro medico seleccionado coincida con lo mostrado ventana resumen especialidad$")
	public void valido_que_centro_medico_seleccionado_coincida_con_lo_mostrado_ventana_resumen_especialidad() throws Throwable {
	    
	}

	@Then("^Valido que se visualice seccion paciente ventana resumen especialidad$")
	public void valido_que_se_visualice_seccion_paciente_ventana_resumen_especialidad() throws Throwable {
	    
	}

	@Then("^Valido que se visualice imagen icono genero ventana resumen especialidad$")
	public void valido_que_se_visualice_imagen_icono_genero_ventana_resumen_especialidad() throws Throwable {
	    
	}

	@Then("^Valido que imagen icono de genero coincida entre la busqueda inicial y el mostrado en ventana resumen especialidad$")
	public void valido_que_imagen_icono_de_genero_coincida_entre_la_busqueda_inicial_y_el_mostrado_en_ventana_resumen_especialidad() throws Throwable {
	    
	}

	@Then("^Valido que se visualice nombre paciente ventana resumen especialidad$")
	public void valido_que_se_visualice_nombre_paciente_ventana_resumen_especialidad() throws Throwable {
	    
	}

	@Then("^Valido que nombre paciente coincida entre la busqueda inicial y el mostrado en ventana resumen especialidad$")
	public void valido_que_nombre_paciente_coincida_entre_la_busqueda_inicial_y_el_mostrado_en_ventana_resumen_especialidad() throws Throwable {
	    
	}

	@Then("^Valido que se visualice correo paciente ventana resumen especialidad$")
	public void valido_que_se_visualice_correo_paciente_ventana_resumen_especialidad() throws Throwable {
	    
	}

	@Then("^Valido que se visualice seccion consulta ventana resumen especialidad$")
	public void valido_que_se_visualice_seccion_consulta_ventana_resumen_especialidad() throws Throwable {
	    
	}

	@Then("^Valido que se visualice imagen icono calendario ventana resumen especialidad$")
	public void valido_que_se_visualice_imagen_icono_calendario_ventana_resumen_especialidad() throws Throwable {
	    
	}

	@Then("^Valido que se visualice fecha de la consulta ventana resumen especialidad$")
	public void valido_que_se_visualice_fecha_de_la_consulta_ventana_resumen_especialidad() throws Throwable {
	    
	}

	@Then("^Valido que fecha mostrada coincida entre el apartado de horas y el mostrado en ventana resumen especialidad$")
	public void valido_que_fecha_mostrada_coincida_entre_el_apartado_de_horas_y_el_mostrado_en_ventana_resumen_especialidad() throws Throwable {
	    
	}

	@Then("^Valido que se visualice imagen icono horario ventana resumen especialidad$")
	public void valido_que_se_visualice_imagen_icono_horario_ventana_resumen_especialidad() throws Throwable {
	    
	}

	@Then("^Valido que se visualice hora de la consulta ventana resumen especialidad$")
	public void valido_que_se_visualice_hora_de_la_consulta_ventana_resumen_especialidad() throws Throwable {
	    
	}

	@Then("^Valido que se visualice imagen icono costo de consulta ventana resumen especialidad$")
	public void valido_que_se_visualice_imagen_icono_costo_de_consulta_ventana_resumen_especialidad() throws Throwable {
	    
	}

	@Then("^Valido que se visualice monto dinero de la consulta ventana resumen especialidad$")
	public void valido_que_se_visualice_monto_dinero_de_la_consulta_ventana_resumen_especialidad() throws Throwable {
	    
	}

	@Then("^Valido que se visualice boton agendar ventana resumen especialidad$")
	public void valido_que_se_visualice_boton_agendar_ventana_resumen_especialidad() throws Throwable {
	    
	}

	@Then("^Valido que se haga click boton agendar ventana resumen especialidad$")
	public void valido_que_se_haga_click_boton_agendar_ventana_resumen_especialidad() throws Throwable {
	    
	}

	@When("^Doy click al boton agendar ventana resumen especialidad$")
	public void doy_click_al_boton_agendar_ventana_resumen_especialidad() throws Throwable {
	    
	}

	@Then("^Valido que se visualice ventana indicaciones$")
	public void valido_que_se_visualice_ventana_indicaciones() throws Throwable {
	    
	}

	@Then("^Valido que se visualice titulo leer indicaciones ventana indicaciones$")
	public void valido_que_se_visualice_titulo_leer_indicaciones_ventana_indicaciones() throws Throwable {
	    
	}

	@Then("^Valido que titulo leer indicaciones sea correcto ventana indicaciones$")
	public void valido_que_titulo_leer_indicaciones_sea_correcto_ventana_indicaciones() throws Throwable {
	    
	}

	@Then("^Valido que se visualice texto indicaciones ventana indicaciones$")
	public void valido_que_se_visualice_texto_indicaciones_ventana_indicaciones() throws Throwable {
	    
	}

	@Then("^Valido que se visualice boton he leido las indicaciones ventana indicaciones$")
	public void valido_que_se_visualice_boton_he_leido_las_indicaciones_ventana_indicaciones() throws Throwable {
	    
	}

	@Then("^Valido que boton he leido indicaciones haga click ventana indicaciones$")
	public void valido_que_boton_he_leido_indicaciones_haga_click_ventana_indicaciones() throws Throwable {
	    
	}

	@Then("^Valido que se visualice boton anular reserva ventana indicaciones$")
	public void valido_que_se_visualice_boton_anular_reserva_ventana_indicaciones() throws Throwable {
	    
	}

	@Then("^Valido que boton anular reserva haga click ventana indicaciones$")
	public void valido_que_boton_anular_reserva_haga_click_ventana_indicaciones() throws Throwable {
	    
	}

	@Then("^Doy click al boton anular resereva ventana indicaciones$")
	public void doy_click_al_boton_anular_resereva_ventana_indicaciones() throws Throwable {
	    
	}

	@Then("^Valido que se visualice vetana anulacion cita$")
	public void valido_que_se_visualice_vetana_anulacion_cita() throws Throwable {
	    
	}

	@Then("^Valido que se visualice titulo ventana anulacion cita$")
	public void valido_que_se_visualice_titulo_ventana_anulacion_cita() throws Throwable {
	    
	}

	@Then("^Valido que titulo de anulacion cita sea el correcto ventana anulacion cita$")
	public void valido_que_titulo_de_anulacion_cita_sea_el_correcto_ventana_anulacion_cita() throws Throwable {
	    
	}

	@Then("^Valido que se visualice imagen check ventana anulacion cita$")
	public void valido_que_se_visualice_imagen_check_ventana_anulacion_cita() throws Throwable {
	    
	}

	@Then("^Valido que se visualice parrafo ventana anulacion cita$")
	public void valido_que_se_visualice_parrafo_ventana_anulacion_cita() throws Throwable {
	    
	}

	@Then("^Valido que parrafo de hora anulada sea el correcto ventana anulacion cita$")
	public void valido_que_parrafo_de_hora_anulada_sea_el_correcto_ventana_anulacion_cita() throws Throwable {
	    
	}

	@Then("^Valido que se muestre boton aceptar ventana anulacion cita$")
	public void valido_que_se_muestre_boton_aceptar_ventana_anulacion_cita() throws Throwable {
	    
	}

	@Then("^Valido boton aceptar haga click ventana anulacion cita$")
	public void valido_boton_aceptar_haga_click_ventana_anulacion_cita() throws Throwable {
	    
	}

	@Then("^Doy click boton aceptar ventana anulacion cita$")
	public void doy_click_boton_aceptar_ventana_anulacion_cita() throws Throwable {
	    
	}

	@Then("^Valido que se visualice apartado de horas de especialidad$")
	public void valido_que_se_visualice_apartado_de_horas_de_especialidad() throws Throwable {
	    
	}
}
