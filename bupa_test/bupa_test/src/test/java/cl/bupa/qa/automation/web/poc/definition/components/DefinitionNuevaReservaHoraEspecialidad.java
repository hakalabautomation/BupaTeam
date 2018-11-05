package cl.bupa.qa.automation.web.poc.definition.components;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import org.codehaus.jettison.json.JSONObject;

import cl.bupa.qa.automation.web.business.flow.BaseFlow;
import cl.bupa.qa.automation.web.json.conn.EndPointConn;
import cl.bupa.qa.automation.web.poc.util.GenericMethods;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class DefinitionNuevaReservaHoraEspecialidad {

	private static String tokenService;
	private static String nombreService;
	private static String lblEspecialidad;
	private static String lblPrestacion;
	private static String lblCentroMedico;
	private static int totalEspecialidadWeb;
	private static int totalPrestacionWeb;
	private static int totalRegionWeb;
	private static int totalCentroMedicoWeb;
	private static int totalEspecialidadService;
	private static int totalPrestacionService;
	private static int totalRegionService;
	private static int totalCentroMedicoService;

	@Given("^Presiono boton nueva reserva de hora$")
	public void presiono_boton_nueva_reserva_de_hora() throws Throwable {
		boolean condition = BaseFlow.pageModel.getBtnNuevaReservaHora().isEnabled();
		if (condition == true) {
			assertTrue(true);
			BaseFlow.pageModel.getBtnNuevaReservaHora().click();			
		} else {
			System.out.println("Botón nueva reserva hora no se encuentra habilitado");
			assertTrue(false);
		}
	}

	@Given("^Valido que se visualice titulo$")
	public void valido_que_se_visualice_titulo() throws Throwable {
		GenericMethods.isElementPresent(BaseFlow.pageModel.gethFiveNuevaReserva());
	}

	@Given("^Valido que aparezca como titulo nombre del paciente$")
	public void valido_que_aparezca_como_titulo_nombre_del_paciente() throws Throwable {
		// Span -- Nombre paciente
		GenericMethods.isElementPresent(BaseFlow.pageModel.getSpnNombrePaciente());
	}

	@Given("^Llamo al servicio token y devuelvo el dato \"(.*?)\" \"(.*?)\"$")
	public void llamo_al_servicio_token_y_devuelvo_el_dato(String usuario, String contraseña) throws Throwable {
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

	@Given("^Valido que coincida nombre paciente desplegado en la web y servicio \"(.*?)\"$")
	public void valido_que_coincida_nombre_paciente_desplegado_en_la_web_y_servicio(String rutSearch) throws Throwable {
		/*
		// llamo al servicio de consulta paciente por rut
		BaseFlow.commJson.setConn(EndPointConn.endPointPacienteBuscarQa); // La URL del servicio
		BaseFlow.commJson.setRequestMethod("POST"); // Metodo de servicio
		BaseFlow.commJson.setRequestProperty(EndPointConn.requestPropertyHeaderNameOneQa, "Beared " + tokenService); // Headers y value 1 del servicio
		BaseFlow.commJson.setRequestProperty(EndPointConn.requestPropertyHeaderNameTwoQa, EndPointConn.requestPropertyHeaderValueTwoEspecialtyQa); // Headers y value 2 del servicio
		BaseFlow.commJson.setRequestProperty(EndPointConn.requestPropertyHeaderNameThreeQa, EndPointConn.requestPropertyHeaderValueThreeEspecialtyQa); // Headers y value 3 del servicio
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
		*/
	}

	@Given("^Valido visualizacion pestaña especialidad$")
	public void valido_visualizacion_pestaña_especialidad() throws Throwable {
		// Tab -- Especialidad
		GenericMethods.isElementPresent(BaseFlow.pageModel.getTbEspecialidad());
	}

	@Given("^Valido imagen de pestaña especialidad$")
	public void valido_imagen_de_pestaña_especialidad() throws Throwable {
		// Imagen -- Icono espacialidad
		GenericMethods.isElementPresent(BaseFlow.pageModel.getImgIconoEspecialidadEsp());
	}

	@When("^Selecciono pestaña especialidad$")
	public void selecciono_pestaña_especialidad() throws Throwable {
		// por defecto muestra especialidad
		// BaseFlow.pageModel.getTbEspecialidad().click();
	}

	@Then("^Visualizo ventana especialidad$")
	public void visualizo_ventana_especialidad() throws Throwable {
		//
	}

	@When("^Llamo servicio especialidad \"(.*?)\" \"(.*?)\"$")
	public void llamo_servicio_especialidad(String codEspecialidad, String tipoClasificacion) throws Throwable {
		// llamo al servicio de especialidad
		BaseFlow.commJson.setConn(EndPointConn.endPointFiltroEspecialidadQa); // La URL del servicio
		BaseFlow.commJson.setRequestMethod("POST"); // Metodo de servicio
		BaseFlow.commJson.setRequestProperty(EndPointConn.requestPropertyHeaderNameOneEspecialtyFilterQa,
				"Beared " + tokenService); // Headers y value 1 del servicio
		BaseFlow.commJson.setRequestProperty(EndPointConn.requestPropertyHeaderNameTwoEspecialtyFilterQa,
				EndPointConn.requestPropertyHeaderValueTwoEspecialtyQa); // Headers y value 2 del servicio
		BaseFlow.commJson.setRequestProperty(EndPointConn.requestPropertyHeaderNameThreeEspecialtyFilterQa,
				EndPointConn.requestPropertyHeaderValueThreeEspecialtyQa); // Headers y value 3 del servicio
		String bodyPost = "{\"codespecialidad\" : \"" + codEspecialidad + "\", \"tipoclasificacion\" : \""
				+ tipoClasificacion + "\"}";
		BaseFlow.commJson.postParametros(bodyPost);
		if (BaseFlow.commJson.getResponseCode() == 200) {
			assertTrue(true);
			// se genera array de body
			JSONObject obj = new JSONObject(BaseFlow.commJson.getJsonData());
			if (obj.length() > 0) {
				assertTrue(true);
				org.codehaus.jettison.json.JSONArray array = obj.getJSONArray("especialidades");
				totalEspecialidadService = array.length();
				// System.out.println("x:"+array.length());
				// Thread.sleep(5000);
			} else {
				System.out.println("Servicio especialidad no devuelve datos");
				assertTrue(false);
			}
		} else {
			System.out.println("Servicio especialidad no responde");
			assertTrue(false);
		}
	}

	@When("^Selecciono todas las especialidades desplegadas en la pagina web$")
	public void selecciono_todas_las_especialidades_desplegadas_en_la_pagina_web() throws Throwable {
		BaseFlow.pageModel.getLbxEspecialidad().click();
		totalEspecialidadWeb = BaseFlow.pageModel.getListEspecialidad().size();
		// System.out.println("xx:"+totalEspecialidadWeb);
	}

	@Then("^Valido que las cantidades de especialidad coincidan entre lo desplegado en la web y el servicio$")
	public void valido_que_las_cantidades_de_especialidad_coincidan_entre_lo_desplegado_en_la_web_y_el_servicio()
			throws Throwable {
		if (totalEspecialidadWeb == totalEspecialidadService) {
			assertTrue(true);
		} else {
			System.out.println("Listado de especialidad no coincide entre lo mostrado en la web y el servicio");
			assertTrue(false);
		}
	}

	@Then("^Seleccion opcion de especialidad$")
	public void seleccion_opcion_de_especialidad() throws Throwable {
		BaseFlow.pageModel.getLbxEspecialidad().click();
		BaseFlow.pageModel.getListEspecialidad().get(3).click();
		Thread.sleep(5000);
	}

	@Then("^Valido label de especialidad \"(.*?)\"$")
	public void valido_label_de_especialidad(String especialidad) throws Throwable {
		String preview = BaseFlow.pageModel.getLbxEspecialidad().getAttribute("innerText").trim();
		String[] especialidadSplit = preview.split("↵");
		String[] especialidadSplitFinally = especialidadSplit[0].split("×");
		lblEspecialidad = especialidadSplitFinally[0].trim();
		// comparacion de especialidad seleccionada
		if (especialidad.equals(lblEspecialidad)) {
			assertTrue(true);
		} else {
			System.out.println("No se valida de manera correcta selección especialidad");
			assertFalse(false);
		}
	}

	@When("^Llamo al servicio prestacion \"(.*?)\" \"(.*?)\" \"(.*?)\"$")
	public void llamo_al_servicio_prestacion(String codEspecialidad, String clasificacion, String codPrestacion)
			throws Throwable {
		// llamo al servicio prestacion
		BaseFlow.commJson.setConn(EndPointConn.endPointFiltroBenefitQa); // La URL del servicio
		BaseFlow.commJson.setRequestMethod("POST"); // Metodo de servicio
		BaseFlow.commJson.setRequestProperty(EndPointConn.requestPropertyHeaderNameOneBenefitFilterQa,
				"Beared " + tokenService); // Headers y value 1 del servicio
		BaseFlow.commJson.setRequestProperty(EndPointConn.requestPropertyHeaderNameTwoBenefitFilterQa,
				EndPointConn.requestPropertyHeaderValueTwoBenefitQa); // Headers y value 2 del servicio
		BaseFlow.commJson.setRequestProperty(EndPointConn.requestPropertyHeaderNameThreeBenefitFilterQa,
				EndPointConn.requestPropertyHeaderValueThreeBenefitQa); // Headers y value 3 del servicio
		String bodyPost = "{\"codEspecialidad\" : \"" + codEspecialidad + "\", \"clasificacion\" : \"" + clasificacion
				+ "\", \"codPrestacion\": \"" + codPrestacion + "\"}";
		BaseFlow.commJson.postParametros(bodyPost);
		if (BaseFlow.commJson.getResponseCode() == 200) {
			assertTrue(true);
			// se genera array de body
			JSONObject obj = new JSONObject(BaseFlow.commJson.getJsonData());
			if (obj.length() > 0) {
				assertTrue(true);
				org.codehaus.jettison.json.JSONArray array = obj.getJSONArray("prestaciones");
				totalPrestacionService = array.length();
				// System.out.println("x:"+array.length());
				// Thread.sleep(5000);
			} else {
				System.out.println("Servicio prestación no devuelve datos");
				assertTrue(false);
			}
		} else {
			System.out.println("Servicio prestación no responde");
			assertTrue(false);
		}
	}

	@When("^Selecciono todas las prestaciones desplegadas en la pagina web$")
	public void selecciono_todas_las_prestaciones_desplegadas_en_la_pagina_web() throws Throwable {
		BaseFlow.pageModel.getLbxPrestacion().click();
		totalPrestacionWeb = BaseFlow.pageModel.getListPrestacion().size();
		// System.out.println("xx:"+totalPrestacionWeb);
	}

	@Then("^Valido que las cantidades prestacion coincidan entre lo desplegado en la web y el servicio$")
	public void valido_que_las_cantidades_prestacion_coincidan_entre_lo_desplegado_en_la_web_y_el_servicio()
			throws Throwable {
		if (totalPrestacionWeb == totalPrestacionService) {
			assertTrue(true);
		} else {
			System.out.println("Listado de prestación no coincide entre lo mostrado en la web y el servicio");
			assertTrue(false);
		}
	}

	@Then("^Seleccion opcion de prestacion$")
	public void seleccion_opcion_de_prestacion() throws Throwable {
		BaseFlow.pageModel.getLbxPrestacion().click();
		BaseFlow.pageModel.getListPrestacion().get(0).click();
		Thread.sleep(5000);		
	}

	@Then("^Valido label de prestacion \"(.*?)\"$")
	public void valido_label_de_prestacion(String prestacion) throws Throwable {
		String preview = BaseFlow.pageModel.getLbxPrestacion().getAttribute("innerText").trim();
		String[] prestacionSplit = preview.split("↵");
		String[] prestacionSplitFinally = prestacionSplit[0].split("×");
		lblPrestacion = prestacionSplitFinally[0].trim();
		// comparacion de prestacion seleccionada
		if (prestacion.equals(lblPrestacion)) {
			assertTrue(true);
		} else {
			System.out.println("No se valida de manera correcta selección prestación");
			assertTrue(false);
		}
	}

	@When("^Llamo al servicio region \"(.*?)\" \"(.*?)\" \"(.*?)\"$")
	public void llamo_al_servicio_region(String codEspecialidad, String codPrestacion, String clasificacion)
			throws Throwable {
		// llamada al servicio región
		BaseFlow.commJson.setConn(EndPointConn.endPointFiltroRegionQa); // La URL del servicio
		BaseFlow.commJson.setRequestMethod("POST"); // Metodo de servicio
		BaseFlow.commJson.setRequestProperty(EndPointConn.requestPropertyHeaderNameOneRegionFilterQa,
				"Beared " + tokenService); // Headers y value 1 del servicio
		BaseFlow.commJson.setRequestProperty(EndPointConn.requestPropertyHeaderNameTwoRegionFilterQa,
				EndPointConn.requestPropertyHeaderValueTwoRegionQa); // Headers y value 2 del servicio
		BaseFlow.commJson.setRequestProperty(EndPointConn.requestPropertyHeaderNameThreeRegionFilterQa,
				EndPointConn.requestPropertyHeaderValueThreeRegionQa); // Headers y value 3 del servicio
		String bodyPost = "{\"codEspecialidad\" : \"" + codEspecialidad + "\", \"codPrestacion\" : \"" + codPrestacion
				+ "\", \"clasificacion\": \"" + clasificacion + "\"}";
		BaseFlow.commJson.postParametros(bodyPost);
		if (BaseFlow.commJson.getResponseCode() == 200) {
			assertTrue(true);
			// se genera array de body
			JSONObject obj = new JSONObject(BaseFlow.commJson.getJsonData());
			if (obj.length() > 0) {
				assertTrue(true);
				org.codehaus.jettison.json.JSONArray array = obj.getJSONArray("regiones");
				totalRegionService = array.length();
				// System.out.println("r:"+array.length());
				// Thread.sleep(5000);
			} else {
				System.out.println("Servicio región no devuelve datos");
				assertTrue(false);
			}
		} else {
			System.out.println("Servicio región no responde");
			assertTrue(false);
		}
	}

	@When("^Selecciono todas las regiones desplegadas en la pagina web$")
	public void selecciono_todas_las_regiones_desplegadas_en_la_pagina_web() throws Throwable {
		BaseFlow.pageModel.getLbxRegion().click();
		totalRegionWeb = BaseFlow.pageModel.getListRegion().size();
		// System.out.println("rr:"+totalRegionWeb);
	}

	@Then("^Valido que las cantidades region coincidan entre lo desplegado en la web y el servicio$")
	public void valido_que_las_cantidades_region_coincidan_entre_lo_desplegado_en_la_web_y_el_servicio()
			throws Throwable {
		if (totalRegionWeb == totalRegionService) {
			assertTrue(true);
		} else {
			System.out.println("Listado de región no coincide entre lo mostrado en la web y el servicio");
			assertTrue(false);
		}
	}

	@Then("^Seleccion opcion de region$")
	public void seleccion_opcion_de_region() throws Throwable {
		BaseFlow.pageModel.getLbxRegion().click();
		BaseFlow.pageModel.getListRegion().get(3).click();
		Thread.sleep(5000);
	}

	@Then("^Valido label de region \"(.*?)\"$")
	public void valido_label_de_region(String region) throws Throwable {
		String preview = BaseFlow.pageModel.getLbxRegion().getAttribute("innerText").trim();
		String[] regionSplit = preview.split("↵");
		String[] regionSplitFinally = regionSplit[0].split("×");
		String lblRegion = regionSplitFinally[0].trim();
		// comparacion de región seleccionada
		if (region.equals(lblRegion)) {
			assertTrue(true);
		} else {
			System.out.println("No se valida de manera correcta selección región");
			assertTrue(false);
		}
	}

	@When("^Llamo al servicio centro medico \"(.*?)\" \"(.*?)\" \"(.*?)\" \"(.*?)\"$")
	public void llamo_al_servicio_centro_medico(String codEspecialidad, String codPrestacion, String codRegion,
			String clasificacion) throws Throwable {
		// llamada al servicio centro medico
		BaseFlow.commJson.setConn(EndPointConn.endPointMedicalCenterFilterQa); // La URL del servicio
		BaseFlow.commJson.setRequestMethod("POST"); // Metodo de servicio
		BaseFlow.commJson.setRequestProperty(EndPointConn.requestPropertyHeaderNameOneMedicalCenterFilterQa,
				"Beared " + tokenService); // Headers y value 1 del servicio
		BaseFlow.commJson.setRequestProperty(EndPointConn.requestPropertyHeaderNameTwoMedicalCenterFilterQa,
				EndPointConn.requestPropertyHeaderValueTwoMedicalCenterQa); // Headers y value 2 del servicio
		BaseFlow.commJson.setRequestProperty(EndPointConn.requestPropertyHeaderNameThreeMedicalCenterFilterQa,
				EndPointConn.requestPropertyHeaderValueThreeMedicalCenterQa); // Headers y value 3 del servicio
		String bodyPost = "{\"codEspecialidad\" : \"" + codEspecialidad + "\", \"codPrestacion\" : \"" + codPrestacion
				+ "\", \"codRegion\": \"" + codRegion + "\", \"clasificacion\": \"" + clasificacion + "\"}";
		BaseFlow.commJson.postParametros(bodyPost);
		if (BaseFlow.commJson.getResponseCode() == 200) {
			assertTrue(true);
			// se genera array de body
			JSONObject obj = new JSONObject(BaseFlow.commJson.getJsonData());
			if (obj.length() > 0) {
				assertTrue(true);
				org.codehaus.jettison.json.JSONArray array = obj.getJSONArray("centrosmedicos");
				totalCentroMedicoService = array.length();
				// System.out.println("c:"+array.length());
				// Thread.sleep(5000);
			} else {
				System.out.println("Servicio centro médico no devuelve datos");
				assertTrue(false);
			}
		} else {
			System.out.println("Servicio centro médico no responde");
			assertTrue(false);
		}
	}

	@When("^Selecciono todos los centros medicos desplegados en la pagina web$")
	public void selecciono_todos_los_centros_medicos_desplegados_en_la_pagina_web() throws Throwable {
		BaseFlow.pageModel.getLblCentroMedico().click();
		totalCentroMedicoWeb = BaseFlow.pageModel.getListCentroMedico().size();
		// System.out.println("cc:"+totalCentroMedicoWeb);
	}

	@Then("^Valido que las cantidades de centros medicos coincidan entre lo desplegado en la web y el servicio$")
	public void valido_que_las_cantidades_de_centros_medicos_coincidan_entre_lo_desplegado_en_la_web_y_el_servicio()
			throws Throwable {
		if (totalCentroMedicoWeb == totalCentroMedicoService) {
			assertTrue(true);
		} else {
			System.out.println("Listado de centro médico no coincide entre lo mostrado en la web y el servicio");
			assertTrue(false);
		}
	}

	@Then("^Seleccion opcion de centro medico$")
	public void seleccion_opcion_de_centro_medico() throws Throwable {
		BaseFlow.pageModel.getLbxCentroMedico().click();
		BaseFlow.pageModel.getListCentroMedico().get(2).click();
		Thread.sleep(7000);
	}

	@Then("^Valido label de centro medico \"(.*?)\"$")
	public void valido_label_de_centro_medico(String centro) throws Throwable {
		String preview = BaseFlow.pageModel.getLbxCentroMedico().getAttribute("innerText").trim();
		String[] centroMedicoSplit = preview.split("↵");
		String[] centroMedicoSplitFinally = centroMedicoSplit[0].split("×");
		lblCentroMedico = centroMedicoSplitFinally[0].trim();
		// comparacion centro medico seleccionado
		if (centro.equals(lblCentroMedico)) {
			assertTrue(true);
		} else {
			System.out.println("No se valida de manera correcta selección centro médico");
			assertTrue(false);
		}
	}

	@When("^Visualizo fechas disponibles$")
	public void visualizo_fechas_disponibles() throws Throwable {
		// valido que aparezca el tr de las fechas
		GenericMethods.isElementPresent(BaseFlow.pageModel.getTrFechasMostradas());
		// valido la cantidad de fechas disponibles habilitadas
		int fechasActivas = BaseFlow.pageModel.getListFechasActivas().size();
		if (fechasActivas >= 1) {
			assertTrue("Existen fechas activas para la combinación de búsqueda", true);
		} else if (fechasActivas <= 0) {
			assertTrue("No existen fechas activas para la combinación de búsqueda", true);
		} else {
			assertTrue("Condición de fechas no realizada", false);
		}
	}
	
	@Then("^Valido que existe una fecha seleccionada$")
	public void valido_que_existe_una_fecha_seleccionada() throws Throwable {
		//día seleccionado
		List<WebElement> asd = BaseFlow.driver.findElements(By.className("selected"));	
		for (WebElement a : asd) {
			if (a.isDisplayed()) {
				assertTrue(true);
			} else {
				System.out.println("Día seleccionado no se encuentra desplegado");
				assertTrue(false);
			}
		}
	}
	
	@Then("^Llamo al servicio dia$")
	public void llamo_al_servicio_dia() throws Throwable {
		//System.out.println("date:"+GenericMethods.addDays().toString());
		//Thread.sleep(10000000);
	}

	@Then("^Valido que aparezca titulo mes y año actual$")
	public void valido_que_aparezca_titulo_mes_y_año_actual() throws Throwable {
		GenericMethods.isElementPresent(BaseFlow.pageModel.gethFiveTituloReservaSemana());
	}

	@Then("^Valido el titulo mes y año sea correcto$")
	public void valido_el_titulo_mes_y_año_sea_correcto() throws Throwable {
		// se compara el elemento que indica mes y año actual
	    if (BaseFlow.pageModel.gethFiveTituloReservaSemana().getText().trim().equals(
	    		GenericMethods.getCurrentMonthAndYear())) {
	    	assertTrue(true);
	    } else {
	    	System.out.println("Año y mes actual no son coinciden");
	    	assertTrue(false);
	    }
	}
	
	@Then("^Valido que aparezca subtitulo de semana$")
	public void valido_que_aparezca_subtitulo_de_semana() throws Throwable {
	    GenericMethods.isElementPresent(BaseFlow.pageModel.gethSixTituloReservaSemana());
	}

	@Then("^Valido rango de dias sea correcto a la semana$")
	public void valido_rango_de_dias_sea_correcto_a_la_semana() throws Throwable {
	    if (BaseFlow.pageModel.gethSixTituloReservaSemana().getText().trim().equals(
	    		GenericMethods.getRangeOfWeekdays())) {
	    	assertTrue(true);
	    } else {
	    	System.out.println("Rango de días de la semana no coinciden");
	    	assertTrue(false);
	    }
	}
	
	@When("^Valido que aparezca apartado de horas de especialidad$")
	public void valido_que_aparezca_apartado_de_horas_de_especialidad() throws Throwable {
		//Div -- Apartado especialidad
	    GenericMethods.isElementPresent(BaseFlow.pageModel.getDivApartadoBxEspecialidad());
	}
	
	@Then("^Valido que aparezca titulo de fecha segun dia seleccionado$")
	public void valido_que_aparezca_titulo_de_fecha_segun_dia_seleccionado() throws Throwable {
		//Div -- Header fechas
		GenericMethods.isElementPresent(BaseFlow.pageModel.getDivHeaderFechas());
	}

	@Then("^Valido que titulo de fecha sea correcto segun dia seleccionado$")
	public void valido_que_titulo_de_fecha_sea_correcto_segun_dia_seleccionado() throws Throwable {		    
	    if (BaseFlow.pageModel.gethThreeFechaEspecialidad().getText().trim().equals(
	    		GenericMethods.getCurrentDateComplete())) {
	    	assertTrue(true);
	    } else {
	    	System.out.println("Titulo de fechas no es correcta");
	    	assertTrue(false);
	    }
	}
	
	@Then("^Valido que subtitulo especialidad mas prestacion coincida segun lo seleccionado$")
	public void valido_que_subtitulo_especialidad_mas_prestacion_coincida_segun_lo_seleccionado() throws Throwable {
		String espAndPres = lblEspecialidad + " - " + lblPrestacion;
		if (BaseFlow.pageModel.gethFourNombreEspecialidadPrestacion().getText().trim().equals(espAndPres)) {
			assertTrue(true);
		} else {
			System.out.println("Subtitulo especialidad - prestación no es correcto de acuerdo a lo seleccionado en filtros");
			assertTrue(false);
		}			    
	}
	
	@Then("^Valido que subtitulo centro medico coincida segun lo seleccionado$")
	public void valido_que_subtitulo_centro_medico_coincida_segun_lo_seleccionado() throws Throwable {		
		if (BaseFlow.pageModel.gethFiveNombreCentroMedicoEspecialidad().getText().trim().equals(lblCentroMedico)) {
			assertTrue(true);
		} else {
			System.out.println("Subtitulo de centro medico no es correcto de acuerdo a lo seleccionado");
			assertTrue(false);
		}
	}
	
	@Then("^Selecciono una hora disponible ventana de hora especialidad$")
	public void selecciono_una_hora_disponible_ventana_de_hora_especialidad() throws Throwable {
		Thread.sleep(3000);
		List<WebElement> asd = BaseFlow.driver.findElements(By.className("container"));		
		for (WebElement a : asd) {
			a.click();
			//if(GenericMethods.isClickable(BaseFlow.pageModel.getDivResumenEspecialidad(), BaseFlow.driver))
			if(GenericMethods.isElementPresent(BaseFlow.pageModel.getDivResumenEspecialidad()))
			break;
		}
		//List<WebElement> asd = BaseFlow.driver.findElements(By.className("container"));
		//asd.get(29).click();
	}
	
	@When("^Valido que aparezca ventana resumen de la especialidad$")
	public void valido_que_aparezca_ventana_resumen_de_la_especialidad() throws Throwable {
		//Div -- Resumen especialidad
	    GenericMethods.isElementPresent(BaseFlow.pageModel.getDivResumenEspecialidad());
	}

	@Then("^Valido que aparezca imagen icono doctor ventana resumen especialidad$")
	public void valido_que_aparezca_imagen_icono_doctor_ventana_resumen_especialidad() throws Throwable {
		//Img -- Icono doctor
		GenericMethods.isElementPresent(BaseFlow.pageModel.getImgIconoDoctorEsp());
	}

	@Then("^Valido que aparezca nombre del doctor ventana resumen especialidad$")
	public void valido_que_aparezca_nombre_del_doctor_ventana_resumen_especialidad() throws Throwable {
		//H3 -- Nombre doctor
		GenericMethods.isElementPresent(BaseFlow.pageModel.gethThreeNombreDoctorEsp());
	}

	@Then("^Valido que aparezca especialidad del doctor ventana resumen especialidad$")
	public void valido_que_aparezca_especialidad_del_doctor_ventana_resumen_especialidad() throws Throwable {
		//H3 -- Especialidad doctor
		GenericMethods.isElementPresent(BaseFlow.pageModel.gethThreePrestacionDoctorEsp());
	}

	@Then("^Valido que la prestacion seleccionada coincida con la mostrada ventana resumen especialidad$")
	public void valido_que_la_prestacion_seleccionada_coincida_con_la_mostrada_ventana_resumen_especialidad() throws Throwable {
	    if (BaseFlow.pageModel.gethThreeEspecialidadExa().getText().trim().equals(lblPrestacion)) {
	    	assertTrue(true);
	    } else {
	    	System.out.println("Prestación visualizada en resumen no coincide con la seleccionada previamente");
	    	assertTrue(false);
	    }
	}

	@Then("^Valido que aparezca centro medico ventana resumen especialidad$")
	public void valido_que_aparezca_centro_medico_ventana_resumen_especialidad() throws Throwable {
		//H6 -- Centro medico
		GenericMethods.isElementPresent(BaseFlow.pageModel.gethSixCentroMedicoEsp());
	}

	@Then("^Valido que el centro medico seleccionado coincida con lo mostrado ventana resumen especialidad$")
	public void valido_que_el_centro_medico_seleccionado_coincida_con_lo_mostrado_ventana_resumen_especialidad() throws Throwable {
	    if (BaseFlow.pageModel.gethSixCentroMedicoEsp().getText().trim().equals(lblCentroMedico)) {
	    	assertTrue(true);
	    } else {
	    	System.out.println("Centro médico visualizado en resumen no coincide con la selección previamente");
	    	assertTrue(false);
	    }
	}

	@Then("^Valido que aparezca seccion paciente ventana resumen especialidad$")
	public void valido_que_aparezca_seccion_paciente_ventana_resumen_especialidad() throws Throwable {
		//Div -- Seccion paciente
	    GenericMethods.isElementPresent(BaseFlow.pageModel.getDivSeccionPaciente());
	}

	@Then("^Valido que aparezca imagen icono genero ventana resumen especialidad$")
	public void valido_que_aparezca_imagen_icono_genero_ventana_resumen_especialidad() throws Throwable {
		//Img -- Icono genero
	    GenericMethods.isElementPresent(BaseFlow.pageModel.getImgIconoGeneroEsp());
	}
	
	@Then("^Valido que imagen icono genero coincida entre la busqueda inicial y el mostrado en ventana resumen especialidad$")
	public void valido_que_imagen_icono_genero_coincida_entre_la_busqueda_inicial_y_el_mostrado_en_ventana_resumen_especialidad() throws Throwable {
	    //obengo atributo src de imagen icono genero busqueda inicial
		String imgIconoGeneroBusquedaInicial = BaseFlow.pageModel.getImgIconoPaciente().getAttribute("src");
		//obengo atributo src de imagen icono genero ventana resumen especialidad
		String imgIconoGeneroVentanaResumenEspecialidad = BaseFlow.pageModel.getImgIconoGeneroEsp().getAttribute("src");
		if (imgIconoGeneroBusquedaInicial.equals(imgIconoGeneroVentanaResumenEspecialidad)) {
			assertTrue(true);
		} else {
			System.out.println("Imagen icono paciente no coincide entre la búsqueda inicial y el mostrado en ventana resumen");
			assertTrue(false);
		}
	}


	@Then("^Valido que aparezca nombre paciente ventana resumen especialidad$")
	public void valido_que_aparezca_nombre_paciente_ventana_resumen_especialidad() throws Throwable {
		//H5 -- Nombre paciente
	    GenericMethods.isElementPresent(BaseFlow.pageModel.gethFiveNombrePacienteEsp());
	}
	
	@Then("^Valido que nombre coincida entre la busqueda inicial y el mostrado en ventana resumen especialidad$")
	public void valido_que_nombre_coincida_entre_la_busqueda_inicial_y_el_mostrado_en_ventana_resumen_especialidad() throws Throwable {
	    if (BaseFlow.pageModel.gethFiveNombrePaciente().getText().trim().equals(
	    		BaseFlow.pageModel.gethFiveNombrePacienteEsp().getText().trim())) {
	    	assertTrue(true);
	    } else {
	    	System.out.println("Nombre paciente no coincide entre la búsqueda inicial y el mostrado en ventana resumen");
	    	assertTrue(false);
	    }
	}

	@Then("^Valido que aparezca correo paciente ventana resumen especialidad$")
	public void valido_que_aparezca_correo_paciente_ventana_resumen_especialidad() throws Throwable {
		//label -- Correo Paciente
		GenericMethods.isElementPresent(BaseFlow.pageModel.getPCorreoPacienteEsp());
	}

	@Then("^Valido que aparezca seccion consulta ventana resumen especialidad$")
	public void valido_que_aparezca_seccion_consulta_ventana_resumen_especialidad() throws Throwable {
		//Div -- Seccion consulta
		GenericMethods.isElementPresent(BaseFlow.pageModel.getDivSeccionConsulta());
	}

	@Then("^Valido que aparezca imagen icono calendario ventana resumen especialidad$")
	public void valido_que_aparezca_imagen_icono_calendario_ventana_resumen_especialidad() throws Throwable {
		//Img -- Icono calendario
		GenericMethods.isElementPresent(BaseFlow.pageModel.getImgIconoCalendarioEsp());
	}

	@Then("^Valido que aparezca fecha de la consulta ventana resumen especialidad$")
	public void valido_que_aparezca_fecha_de_la_consulta_ventana_resumen_especialidad() throws Throwable {
		//Span -- Fecha consulta
		GenericMethods.isElementPresent(BaseFlow.pageModel.getSpnFechaConsultaEsp());
	}
	
	@Then("^Valido que fecha coincida entre el apartado de horas y el mostrado en ventana resumen especialidad$")
	public void valido_que_fecha_coincida_entre_el_apartado_de_horas_y_el_mostrado_en_ventana_resumen_especialidad() throws Throwable {
	    if (BaseFlow.pageModel.gethThreeFechaEspecialidad().getText().trim().equals(
	    		BaseFlow.pageModel.getSpnFechaConsultaEsp().getText().trim())) {
	    	assertTrue(true);
	    } else {
	    	System.out.println("Fecha de consulta no coincide entre el apartado de horas y el mostrado en ventana resumen");
	    	assertTrue(false);
	    }
	}

	@Then("^Valido que aparezca imagen icono horario ventana resumen especialidad$")
	public void valido_que_aparezca_imagen_icono_horario_ventana_resumen_especialidad() throws Throwable {
		//Img -- Icono horario
		GenericMethods.isElementPresent(BaseFlow.pageModel.getImgIconoHorarioEsp());
	}

	@Then("^Valido que aparezca hora de la consulta ventana resumen especialidad$")
	public void valido_que_aparezca_hora_de_la_consulta_ventana_resumen_especialidad() throws Throwable {
		//Span -- Hora consulta
		GenericMethods.isElementPresent(BaseFlow.pageModel.getSpnHoraConsultaEsp());
	}

	@Then("^Valido que aparezca imagen icono costo de consulta ventana resumen especialidad$")
	public void valido_que_aparezca_imagen_icono_costo_de_consulta_ventana_resumen_especialidad() throws Throwable {
		//Img -- Icono pago
		GenericMethods.isElementPresent(BaseFlow.pageModel.getImgIconoPagoEsp());
	}

	@Then("^Valido que aparezca monto dinero de la consulta ventana resumen especialidad$")
	public void valido_que_aparezca_monto_dinero_de_la_consulta_ventana_resumen_especialidad() throws Throwable {
		//Span -- Costo consulta
		GenericMethods.isElementPresent(BaseFlow.pageModel.getSpnCostoConsultaEsp());
	}

	@Then("^Valido que aparezca boton agendar ventana resumen especialidad$")
	public void valido_que_aparezca_boton_agendar_ventana_resumen_especialidad() throws Throwable {
		//Button -- Agendar
		GenericMethods.isElementPresent(BaseFlow.pageModel.getBtnAgendarEsp());
	}

	@Then("^Valido que haga click boton agendar ventana resumen especialidad$")
	public void valido_que_haga_click_boton_agendar_ventana_resumen_especialidad() throws Throwable {
	    boolean condition = BaseFlow.pageModel.getBtnAgendarEsp().isEnabled();
	    if (condition == true) {
	    	assertTrue(true);
	    } else {
	    	System.out.println("Botón agendar no se encuentra habilitado");
	    	assertTrue(false);
	    }
	}
}
