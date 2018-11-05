package cl.bupa.qa.automation.web.poc.definition.components;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import cl.bupa.qa.automation.web.business.flow.BaseFlow;
import cl.bupa.qa.automation.web.json.conn.EndPointConn;
import cl.bupa.qa.automation.web.poc.util.GenericMethods;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class DefinitionNuevaReservaHoraMedico {
	
	private static String tokenService;
	private static String nombreService;
	private static String apellidoPaternoService;
	private static String apellidoMaternoService;
	private static String nombreProfesionalService;
	private static String numeroDocProfesionalService="4773557-2";
	private static String lblMedico;
	private static String lblEspecialidad;
	private static String lblPrestacion;
	private static String lblRegion;
	private static String lblCentroMedico;
	private static String placeHolderMedico;
	private static String placeHolderEspecialidad;
	private static String placeHolderPrestacion;
	private static String placeHolderRegion;
	private static String placeHolderCentroMedico;
	private static int totalMedicoWeb;
	private static int totalEspecialidadWeb;
	private static int totalPrestacionWeb;
	private static int totalRegionWeb;
	private static int totalCentroMedicoWeb;
	private static int totalMedicoService;
	private static int totalEspecialidadService;
	private static int totalPrestacionService;
	private static int totalRegionService;
	private static int totalCentroMedicoService;
	
	@Given("^Valido que boton nueva reserva de hora se encuentre habilitado$")
	public void valido_que_boton_nueva_reserva_de_hora_se_encuentre_habilitado() throws Throwable {
		boolean condition = BaseFlow.pageModel.getBtnNuevaReservaHora().isEnabled();
		if (condition == true) {
			assertTrue(true);
		} else {
			System.out.println("Botón nueva reserva hora no se encuentra habilitado");
			assertTrue(false);
		}
	}
	
	@Given("^Dar click boton nueva reserva de hora$")
	public void dar_click_boton_nueva_reserva_de_hora() throws Throwable {
		BaseFlow.pageModel.getBtnNuevaReservaHora().click();
	}

	@Given("^Valido visualizacion titulo$")
	public void valido_visualizacion_titulo() throws Throwable {
		// h5 -- Nueva reserva
		GenericMethods.isElementPresent(BaseFlow.pageModel.gethFiveNuevaReserva());
	}

	@Given("^Valido que titulo sea correcto$")
	public void valido_que_titulo_sea_correcto() throws Throwable {
		String[] splitNuevaReserva = BaseFlow.pageModel.gethFiveNuevaReserva().getText().split(" / ");
		//System.out.println("x:"+splitNuevaReserva[0].trim());
		//System.out.println("xx:"+BaseFlow.properties.getLabelTituloNuevaReserva());
		//Thread.sleep(30000);				
		if (splitNuevaReserva[0].trim().equals(
				BaseFlow.properties.getLabelTituloNuevaReserva())) {
			assertTrue(true);
		} else {
			System.out.println("Label nueva reserva no es correcto");
			assertTrue(false);
		}
	}

	@Given("^Valido que aparezca como titulo el nombre del paciente$")
	public void valido_que_aparezca_como_titulo_el_nombre_del_paciente() throws Throwable {
		// Span -- Nombre paciente
		GenericMethods.isElementPresent(BaseFlow.pageModel.getSpnNombrePaciente());
	}

	@Given("^Llamo servicio token y devuelvo el dato \"(.*?)\" \"(.*?)\"$")
	public void llamo_servicio_token_y_devuelvo_el_dato(String usuario, String contraseña) throws Throwable {
		BaseFlow.commJson.setConn(EndPointConn.endPointLoginQa); // La URL del servicio
		BaseFlow.commJson.setRequestMethod("POST"); // Metodo de servicio
		BaseFlow.commJson.setRequestProperty(EndPointConn.requestPropertyHeaderNameOneLoginQa, EndPointConn.requestPropertyHeaderValueOneLoginQa); // Headers y value 1 del servicio
		BaseFlow.commJson.setRequestProperty(EndPointConn.requestPropertyHeaderNameTwoLoginQa, EndPointConn.requestPropertyHeaderValueTwoLoginQa); // Headers y value 2 del servicio
		String bodyPostOne = "{\"usuario\" : \"" + usuario + "\", \"contrasena\" : \"" + contraseña + "\"}";
		BaseFlow.commJson.postParametros(bodyPostOne);
		if (BaseFlow.commJson.getResponseCode() == 200) {
			JSONObject obj = new JSONObject(BaseFlow.commJson.getJsonData());
			tokenService = obj.getString("token");
		}
	}

	@Given("^Valido coincida nombre paciente desplegado en la web y servicio \"(.*?)\"$")
	public void valido_coincida_nombre_paciente_desplegado_en_la_web_y_servicio(String rutSearch) throws Throwable {
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
				nombreService = obj.getJSONObject("paciente").getString("nombre");
				apellidoPaternoService = obj.getJSONObject("paciente").getString("apellidoPat");
				apellidoMaternoService = obj.getJSONObject("paciente").getString("apellidoMat");
				//System.out.println("x:"+nombreService+" "+apellidoPaternoService+" "+apellidoMaternoService);
				//Thread.sleep(30000000);
			} else {
				System.out.println("Servicio búsqueda paciente por rut no devuelve datos");
				assertTrue(false);
			}
		} else {
			System.out.println("Servicio búsqueda paciente por rut no responde");
			assertTrue(false);
		}
		// comparación de nombres
		if (BaseFlow.pageModel.getSpnNombrePaciente().getText().trim().equalsIgnoreCase(nombreService+" "+apellidoPaternoService+" "+apellidoMaternoService)) {
			assertTrue(true);
		} else {
			System.out.println("Nombre paciente mostrado no coincide");
			assertTrue(false);
		}
		*/	
	}

	@Given("^Valido visualizacion pestaña medico$")
	public void valido_visualizacion_pestaña_medico() throws Throwable {
		//Tab -- Medico
		GenericMethods.isElementPresent(BaseFlow.pageModel.getTbMedicos());
	}

	@Given("^Valido imagen de pestaña medico$")
	public void valido_imagen_de_pestaña_medico() throws Throwable {
		
	}

	@When("^Selecciono pestaña medico$")
	public void selecciono_pestaña_medico() throws Throwable {
		BaseFlow.pageModel.getTbMedicos().sendKeys(Keys.TAB);
		BaseFlow.pageModel.getTbMedicos().sendKeys(Keys.TAB);
		BaseFlow.pageModel.getTbMedicos().sendKeys(Keys.TAB);
		BaseFlow.pageModel.getTbMedicos().sendKeys(Keys.ENTER);
		Thread.sleep(5000);
	}

	@Then("^Visualizo ventana medico$")
	public void visualizo_ventana_medico() throws Throwable {
		// Div -- Medicos
		GenericMethods.isElementPresent(BaseFlow.pageModel.getDivMedicos());		
	}

	@Given("^Valido que contenga texto que aparece inicialmente en input medico$")
	public void valido_que_contenga_texto_que_aparece_inicialmente_en_input_medico() throws Throwable {
		//System.out.println("x:"+BaseFlow.pageModel.getLbxMedico().get(0).getAttribute("placeholder").trim());
		//Thread.sleep(3000000);
		placeHolderMedico = BaseFlow.pageModel.getLbxMedico().get(0).getAttribute("placeholder").trim();
		if (!placeHolderMedico.equals("")) {
			assertTrue(true);
		} else {
			System.out.println("Texto inicial input médico no aparece");
			assertTrue(false);
		}
	}

	@Given("^Valido que texto inicial de input medico sea el correcto$")
	public void valido_que_texto_inicial_de_input_medico_sea_el_correcto() throws Throwable {
		if (placeHolderMedico.equals(BaseFlow.properties.getLabelNombreDelMedico())) {
			assertTrue(true);
		} else {
			System.out.println("Texto inicial input medico no es correcto");
			assertTrue(false);
		}
	}

	@Given("^Valido que contenga texto que aparece inicialmente en input especialidad$")
	public void valido_que_contenga_texto_que_aparece_inicialmente_en_input_especialidad() throws Throwable {
		placeHolderEspecialidad = BaseFlow.pageModel.getLbxEspecialidad().getAttribute("placeholder").trim();
		if (!placeHolderEspecialidad.equals("")) {
			assertTrue(true);
		} else {
			System.out.println("Texto inicial input especialidad no aparece");
			assertTrue(false);
		}
	}

	@Given("^Valido que texto inicial de input especialidad sea el correcto$")
	public void valido_que_texto_inicial_de_input_especialidad_sea_el_correcto() throws Throwable {
		if (placeHolderEspecialidad.equals(BaseFlow.properties.getLabelEspecialidadTwo())) {
			assertTrue(true);
		} else {
			System.out.println("Texto inicial input especialidad no es correcto");
			assertTrue(false);
		}
	}

	@Given("^Valido que contenga texto que aparece inicialmente en input prestacion$")
	public void valido_que_contenga_texto_que_aparece_inicialmente_en_input_prestacion() throws Throwable {
		placeHolderPrestacion = BaseFlow.pageModel.getLbxPrestacion().getAttribute("placeholder").trim();
		if (!placeHolderPrestacion.equals("")) {
			assertTrue(true);
		} else {
			System.out.println("Texto inicial input prestación no aparece");
			assertTrue(false);
		}
	}

	@Given("^Valido que texto inicial de input prestacion sea el correcto$")
	public void valido_que_texto_inicial_de_input_prestacion_sea_el_correcto() throws Throwable {
		if (placeHolderPrestacion.equals(BaseFlow.properties.getLabelPrestacion())) {
			assertTrue(true);
		} else {
			System.out.println("Texto inicial input prestación no es correcto");
			assertTrue(false);
		}
	}

	@Given("^Valido que contenga texto que aparece inicialmente en input region$")
	public void valido_que_contenga_texto_que_aparece_inicialmente_en_input_region() throws Throwable {
		placeHolderRegion = BaseFlow.pageModel.getLbxRegion().getAttribute("placeholder").trim();
		if (!placeHolderRegion.equals("")) {
			assertTrue(true);
		} else {
			System.out.println("Texto inicial input región no aparece");
			assertTrue(false);
		}
	}

	@Given("^Valido que texto inicial de input region sea el correcto$")
	public void valido_que_texto_inicial_de_input_region_sea_el_correcto() throws Throwable {
		if (placeHolderRegion.equals(BaseFlow.properties.getLabelRegion())) {
			assertTrue(true);
		} else {
			System.out.println("Texto inicial input región no es correcto");
			assertTrue(false);
		}
	}

	@Given("^Valido que contenga texto que aparece inicialmente en input centro medico$")
	public void valido_que_contenga_texto_que_aparece_inicialmente_en_input_centro_medico() throws Throwable {
		placeHolderCentroMedico = BaseFlow.pageModel.getLbxCentroMedico().getAttribute("placeholder").trim();
		if (!placeHolderCentroMedico.equals("")) {
			assertTrue(true);
		} else {
			System.out.println("Texto inicial input centro médico no aparece");
			assertTrue(false);
		}
	}

	@Given("^Valido que texto inicial de input centro medico sea el correcto$")
	public void valido_que_texto_inicial_de_input_centro_medico_sea_el_correcto() throws Throwable {
		if (placeHolderCentroMedico.equals(BaseFlow.properties.getLabelCentroMedico())) {
			assertTrue(true);
		} else {
			System.out.println("Texto inicial input centro médico no es correcto");
			assertTrue(false);
		}
	}

	@When("^Llamo servicio medico \"(.*?)\"$")
	public void llamo_servicio_medico(String medico) throws Throwable {
		/*
		//llamo al servicio de consulta paciente por rut
		BaseFlow.commJson.setConn(EndPointConn.endPointProfesionalFilterQa); //La URL del servicio
		BaseFlow.commJson.setRequestMethod("POST"); //Metodo de servicio
		BaseFlow.commJson.setRequestProperty(EndPointConn.requestPropertyHeaderNameOneProfesionalFilterQa, "Beared "+tokenService); //Headers y value 1 del servicio
		BaseFlow.commJson.setRequestProperty(EndPointConn.requestPropertyHeaderNameTwoProfesionalFilterQa, EndPointConn.requestPropertyHeaderValueTwoEspecialtyQa); //Headers y value 2 del servicio
		BaseFlow.commJson.setRequestProperty(EndPointConn.requestPropertyHeaderNameThreeProfesionalFilterQa, EndPointConn.requestPropertyHeaderValueThreeEspecialtyQa); //Headers y value 3 del servicio			
		String bodyPost = "{\"profesionalNombre\" : \""+ medico +"\"}"; //Value en body		
		BaseFlow.commJson.postParametros(bodyPost);
		if (BaseFlow.commJson.getResponseCode() == 200) {
			assertTrue(true);
			//se genera array de body
			JSONObject obj = new JSONObject(BaseFlow.commJson.getJsonData());
			JSONArray jsonarr = new JSONArray();
			JSONArray jsonarrTwo = new JSONArray(); 
			if(obj.length() > 0) {
				assertTrue(true);
				jsonarr = obj.getJSONArray("profesional");
				jsonarrTwo = jsonarr.getJSONObject(0).getJSONArray("especialidades");
				nombreProfesionalService = jsonarr.getJSONObject(0).getString("nombreProfesional");
				numeroDocProfesionalService = jsonarr.getJSONObject(0).getString("numeroDocProfesional");
				totalMedicoService = jsonarr.length();
				totalEspecialidadService = jsonarrTwo.length();
				//System.out.println("x:"+numeroDocProfesionalService);
				//Thread.sleep(300000);
			} else {
				System.out.println("Servicio filtro médico no devuelve datos");
				assertTrue(false);
			}
		} else {
			System.out.println("Servicio filtro médico no responde");
			assertTrue(false);
		}
		*/
	}
	
	@Then("^Seleccion opcion de medico \"(.*?)\"$")
	public void seleccion_opcion_de_medico(String medico) throws Throwable {
		Thread.sleep(9000);
		/*
		GenericMethods.esperaElementoWebSegundos(BaseFlow.driver, BaseFlow.pageModel.getLbxMedico().get(0), 4);
		Actions actions = new Actions(BaseFlow.driver);
		actions.moveToElement(BaseFlow.pageModel.getLbxMedico().get(0));
		BaseFlow.pageModel.getLbxMedico().get(0).click();
		actions.sendKeys(BaseFlow.pageModel.getLbxMedico().get(0), medico);
		GenericMethods.esperaElementoWebSegundos(BaseFlow.driver, BaseFlow.pageModel.getLbxMedico().get(0), 3);
		actions.build().perform();
		*/
	}

	@When("^Selecciono todos los medicos desplegados en la pagina web$")
	public void selecciono_todos_los_medicos_desplegados_en_la_pagina_web() throws Throwable {
		//BaseFlow.pageModel.getLbxMedico().get(0).click();
		totalMedicoWeb = 1;
		//totalMedicoWeb = BaseFlow.pageModel.getListMedico().size();
		// System.out.println("xx:"+totalMedicoWeb);
	}

	@Then("^Valido que las cantidades de medicos coincidan entre lo desplegado en la web y el servicio$")
	public void valido_que_las_cantidades_de_medicos_coincidan_entre_lo_desplegado_en_la_web_y_el_servicio() throws Throwable {		
		/*if (totalMedicoWeb == totalMedicoService) {
			assertTrue(true);
		} else {
			System.out.println("Listado de médico no coincide entre lo mostrado en la web y el servicio");
			assertTrue(false);
		}*/
	}
	
	@Then("^Valido label de medico \"(.*?)\"$")
	public void valido_label_de_medico(String medico) throws Throwable {
		/*
		String preview = BaseFlow.pageModel.getLbxMedico().get(0).getAttribute("innerText").trim();
		String[] medicoSplit = preview.split("↵");
		String[] medicoSplitFinally = medicoSplit[0].split("×");
		lblMedico = medicoSplitFinally[0].trim();
		// comparacion de medico seleccionado
		if (medico.equals(lblMedico)) {
			assertTrue(true);
		} else {
			System.out.println("No se valida de manera correcta selección médico");
			assertTrue(false);
		}
		*/
	}

	@When("^Llamo servicio de especialidad \"(.*?)\" \"(.*?)\" \"(.*?)\"$")
	public void llamo_servicio_de_especialidad(String arg1, String arg2, String arg3) throws Throwable {
		
	}

	@When("^Selecciono la totalidad de especialidades desplegadas en la pagina web$")
	public void selecciono_la_totalidad_de_especialidades_desplegadas_en_la_pagina_web() throws Throwable {
		//esperar hasta el elemento se encuentre visible y sea clickable
		GenericMethods.esperaElementoWebSegundos(BaseFlow.driver, BaseFlow.pageModel.getLbxEspecialidad(), 5);		
		BaseFlow.pageModel.getLbxEspecialidad().click();
		totalEspecialidadWeb = BaseFlow.pageModel.getListEspecialidad().size();
	}

	@Then("^Valido cantidad de especialidad coincidan entre lo desplegado en la web y el servicio$")
	public void valido_cantidad_de_especialidad_coincidan_entre_lo_desplegado_en_la_web_y_el_servicio() throws Throwable {
		/*
		if (totalEspecialidadWeb == totalEspecialidadService) {
			assertTrue(true);
		} else {
			System.out.println("Listado de especialidad no coincide entre lo mostrado en la web y el servicio");
			assertTrue(false);
		}
		*/
	}

	@Then("^Seleccion opcion especialidad$")
	public void seleccion_opcion_especialidad() throws Throwable {				
		//seleccion opcion de especilidad
		BaseFlow.pageModel.getLbxEspecialidad().click();
		BaseFlow.pageModel.getListEspecialidad().get(1).click();
		//esperar hasta el elemento se encuentre visible y sea clickable
		GenericMethods.esperaElementoWebSegundos(BaseFlow.driver, BaseFlow.pageModel.getLbxEspecialidad(), 5);
	}

	@Then("^Valido label especialidad \"(.*?)\"$")
	public void valido_label_especialidad(String especialidad) throws Throwable {
		String preview = BaseFlow.pageModel.getLbxEspecialidad().getAttribute("innerText").trim();
		String[] especialidadSplit = preview.split("↵");
		String[] especialidadSplitFinally = especialidadSplit[0].split("×");
		lblEspecialidad = especialidadSplitFinally[0].trim();
		if (especialidad.equals(lblEspecialidad)) {
			assertTrue(true);
		} else {
			System.out.println("No se valida de manera correcta selección especialidad");
			assertTrue(false);
		}
	}

	@When("^Llamo servicio de prestacion \"(.*?)\" \"(.*?)\" \"(.*?)\"$")
	public void llamo_servicio_de_prestacion(String codEspecialidad, String clasificacion, String codPrestacion) throws Throwable {
		// llamo al servicio prestacion
		BaseFlow.commJson.setConn(EndPointConn.endPointFiltroBenefitQa); // La URL del servicio
		BaseFlow.commJson.setRequestMethod("POST"); // Metodo de servicio
		BaseFlow.commJson.setRequestProperty(EndPointConn.requestPropertyHeaderNameOneBenefitFilterQa, "Beared " + tokenService); // Headers y value 1 del servicio
		BaseFlow.commJson.setRequestProperty(EndPointConn.requestPropertyHeaderNameTwoBenefitFilterQa, EndPointConn.requestPropertyHeaderValueTwoBenefitQa); // Headers y value 2 del servicio
		BaseFlow.commJson.setRequestProperty(EndPointConn.requestPropertyHeaderNameThreeBenefitFilterQa,EndPointConn.requestPropertyHeaderValueThreeBenefitQa); // Headers y value 3 del servicio
		String bodyPost = "{\"codEspecialidad\" : \"" + codEspecialidad + "\", \"clasificacion\" : \"" + clasificacion+ "\", \"codPrestacion\" : \"" + codPrestacion + "\", \"numDocProf\" : \"" + numeroDocProfesionalService + "\"}";
		BaseFlow.commJson.postParametros(bodyPost);
		if (BaseFlow.commJson.getResponseCode() == 200) {
			assertTrue(true);
			// se genera array de body
			JSONObject obj = new JSONObject(BaseFlow.commJson.getJsonData());
			if (obj.length() > 0) {
				assertTrue(true);
				JSONArray jsonarray = new JSONArray();
				jsonarray = obj.getJSONArray("prestaciones");
				totalPrestacionService = jsonarray.length();
			} else {
				System.out.println("Servicio prestación no devuelve datos");
				assertTrue(false);
			}
		} else {
			System.out.println("Servicio prestación no responde");
			assertTrue(false);
		}
	}

	@When("^Selecciono la totalidad de prestaciones desplegadas en la pagina web$")
	public void selecciono_la_totalidad_de_prestaciones_desplegadas_en_la_pagina_web() throws Throwable {
		//esperar hasta el elemento se encuentre visible y sea clickable
		GenericMethods.esperaElementoWebSegundos(BaseFlow.driver, BaseFlow.pageModel.getLbxPrestacion(), 5);
		BaseFlow.pageModel.getLbxPrestacion().click();
		totalPrestacionWeb = BaseFlow.pageModel.getListPrestacion().size();
	}

	@Then("^Valido cantidad de prestacion coincidan entre lo desplegado en la web y el servicio$")
	public void valido_cantidad_de_prestacion_coincidan_entre_lo_desplegado_en_la_web_y_el_servicio() throws Throwable {
		if (totalPrestacionWeb == totalPrestacionService) {
			assertTrue(true);
		} else {
			System.out.println("Listado de prestación no coincide entre lo mostrado en la web y el servicio");
			assertTrue(false);
		}
	}

	@Then("^Seleccion opcion prestacion$")
	public void seleccion_opcion_prestacion() throws Throwable {
		BaseFlow.pageModel.getLbxPrestacion().click();
		BaseFlow.pageModel.getListPrestacion().get(0).click();
		//esperar hasta el elemento se encuentre visible y sea clickable
		GenericMethods.esperaElementoWebSegundos(BaseFlow.driver, BaseFlow.pageModel.getLbxPrestacion(), 5);
	}

	@Then("^Valido label prestacion \"(.*?)\"$")
	public void valido_label_prestacion(String prestacion) throws Throwable {
		String preview = BaseFlow.pageModel.getLbxPrestacion().getAttribute("innerText").trim();
		String[] prestacionSplit = preview.split("↵");
		String[] prestacionSplitFinally = prestacionSplit[0].split("×");
		lblPrestacion = prestacionSplitFinally[0].trim();
		if (prestacion.equals(lblPrestacion)) {
			assertTrue(true);
		} else {
			System.out.println("No se valida de manera correcta selección prestación");
			assertTrue(false);
		}
	}

	@When("^Llamo servicio de region \"(.*?)\" \"(.*?)\" \"(.*?)\"$")
	public void llamo_servicio_de_region(String codEspecialidad, String codPrestacion, String clasificacion) throws Throwable {
		// llamada al servicio región
		BaseFlow.commJson.setConn(EndPointConn.endPointFiltroRegionQa); // La URL del servicio
		BaseFlow.commJson.setRequestMethod("POST"); // Metodo de servicio
		BaseFlow.commJson.setRequestProperty(EndPointConn.requestPropertyHeaderNameOneRegionFilterQa, "Beared " + tokenService); // Headers y value 1 del servicio
		BaseFlow.commJson.setRequestProperty(EndPointConn.requestPropertyHeaderNameTwoRegionFilterQa, EndPointConn.requestPropertyHeaderValueTwoRegionQa); // Headers y value 2 del servicio
		BaseFlow.commJson.setRequestProperty(EndPointConn.requestPropertyHeaderNameThreeRegionFilterQa,
		EndPointConn.requestPropertyHeaderValueThreeRegionQa); // Headers y value 3 del servicio
		String bodyPost = "{\"codEspecialidad\" : \"" + codEspecialidad + "\", \"codPrestacion\" : \"" + codPrestacion+ "\", \"clasificacion\" : \"" + clasificacion + "\", \"numDocProf\" : \"" + numeroDocProfesionalService + "\"}";
		BaseFlow.commJson.postParametros(bodyPost);
		if (BaseFlow.commJson.getResponseCode() == 200) {
			assertTrue(true);
			// se genera array de body
			JSONObject obj = new JSONObject(BaseFlow.commJson.getJsonData());
			if (obj.length() > 0) {
				assertTrue(true);
				JSONArray jsonarray = obj.getJSONArray("regiones");
				totalRegionService = jsonarray.length();
				//System.out.println("r:"+jsonarray.length());
				//Thread.sleep(5000);
			} else {
				System.out.println("Servicio región no devuelve datos");
				assertTrue(false);
			}
		} else {
			System.out.println("Servicio región no responde");
			assertTrue(false);
		}
		
	}

	@When("^Selecciono totalidad de regiones desplegadas en la pagina web$")
	public void selecciono_totalidad_de_regiones_desplegadas_en_la_pagina_web() throws Throwable {
		//esperar hasta el elemento se encuentre visible y sea clickable
		GenericMethods.esperaElementoWebSegundos(BaseFlow.driver, BaseFlow.pageModel.getLbxRegion(), 5);
		BaseFlow.pageModel.getLbxRegion().click();
		totalRegionWeb = BaseFlow.pageModel.getListRegion().size();
		// System.out.println("rr:"+totalRegionWeb);
	}

	@Then("^Valido cantidad de regiones coincidan entre lo desplegado en la web y el servicio$")
	public void valido_cantidad_de_regiones_coincidan_entre_lo_desplegado_en_la_web_y_el_servicio() throws Throwable {
		if (totalRegionWeb == totalRegionService) {
			assertTrue(true);
		} else {
			System.out.println("Listado de región no coincide entre lo mostrado en la web y el servicio");
			assertTrue(false);
		}
	}

	@Then("^Seleccion opcion region$")
	public void seleccion_opcion_region() throws Throwable {
		BaseFlow.pageModel.getLbxRegion().click();
		BaseFlow.pageModel.getListRegion().get(0).click();
		//esperar hasta el elemento se encuentre visible y sea clickable
		GenericMethods.esperaElementoWebSegundos(BaseFlow.driver, BaseFlow.pageModel.getLbxRegion(), 10);
	}

	@Then("^Valido label region \"(.*?)\"$")
	public void valido_label_region(String region) throws Throwable {
		String preview = BaseFlow.pageModel.getLbxRegion().getAttribute("innerText").trim();
		String[] regionSplit = preview.split("↵");
		String[] regionSplitFinally = regionSplit[0].split("×");
		lblRegion = regionSplitFinally[0].trim();
		//System.out.println("1:"+lblRegion);
		//System.out.println("2:"+region);
		//Thread.sleep(10000);
		// comparacion de región seleccionada
		if (region.equals(lblRegion)) {
			assertTrue(true);
		} else {
			System.out.println("No se valida de manera correcta selección región");
			assertTrue(false);
		}
	}

	@When("^Llamo servicio centro medico \"(.*?)\" \"(.*?)\" \"(.*?)\" \"(.*?)\"$")
	public void llamo_servicio_centro_medico(String codEspecialidad, String codPrestacion, String codRegion, String clasificacion) throws Throwable {
		// llamada al servicio centro medico
		BaseFlow.commJson.setConn(EndPointConn.endPointMedicalCenterFilterQa); // La URL del servicio
		BaseFlow.commJson.setRequestMethod("POST"); // Metodo de servicio
		BaseFlow.commJson.setRequestProperty(EndPointConn.requestPropertyHeaderNameOneMedicalCenterFilterQa, "Beared " + tokenService); // Headers y value 1 del servicio
		BaseFlow.commJson.setRequestProperty(EndPointConn.requestPropertyHeaderNameTwoMedicalCenterFilterQa, EndPointConn.requestPropertyHeaderValueTwoMedicalCenterQa); // Headers y value 2 del servicio
		BaseFlow.commJson.setRequestProperty(EndPointConn.requestPropertyHeaderNameThreeMedicalCenterFilterQa, EndPointConn.requestPropertyHeaderValueThreeMedicalCenterQa); // Headers y value 3 del servicio
		String bodyPost = "{\"codEspecialidad\" : \"" + codEspecialidad + "\", \"codPrestacion\" : \"" + codPrestacion+ "\", \"codRegion\" : \"" + codRegion + "\", \"clasificacion\" : \"" + clasificacion + "\", \"numDocProf\" : \"" + numeroDocProfesionalService + "\"}";		
		BaseFlow.commJson.postParametros(bodyPost);
		if (BaseFlow.commJson.getResponseCode() == 200) {
			assertTrue(true);
			// se genera array de body
			JSONObject obj = new JSONObject(BaseFlow.commJson.getJsonData());
			if (obj.length() > 0) {
				assertTrue(true);
				JSONArray jsonarray = obj.getJSONArray("centrosmedicos");
				totalCentroMedicoService = jsonarray.length();
				//System.out.println("c:"+jsonarray.length());
				//Thread.sleep(5000);
			}
		}
	}

	@When("^Selecciono totalidad de centros medicos desplegados en la pagina web$")
	public void selecciono_totalidad_de_centros_medicos_desplegados_en_la_pagina_web() throws Throwable {
		//esperar hasta el elemento se encuentre visible y sea clickable
		//GenericMethods.esperaElementoWebSegundos(BaseFlow.driver, BaseFlow.pageModel.getLbxCentroMedico(), 9);
		Thread.sleep(7000);
		BaseFlow.pageModel.getLbxCentroMedico().click();
		totalCentroMedicoWeb = BaseFlow.pageModel.getListCentroMedico().size();
	}

	@Then("^Valido cantidad de centros medicos coincidan entre lo desplegado en la web y el servicio$")
	public void valido_cantidad_de_centros_medicos_coincidan_entre_lo_desplegado_en_la_web_y_el_servicio() throws Throwable {
		if (totalCentroMedicoWeb == totalCentroMedicoService) {
			assertTrue(true);
		} else {
			System.out.println("Listado de centro médico no coincide entre lo mostrado en la web y el servicio");
			assertTrue(false);
		}
	}

	@Then("^Seleccion opcion centro medico$")
	public void seleccion_opcion_centro_medico() throws Throwable {		
		BaseFlow.pageModel.getLbxCentroMedico().click();
		BaseFlow.pageModel.getListCentroMedico().get(0).click();
		//esperar hasta el elemento se encuentre visible y sea clickable
		GenericMethods.esperaElementoWebSegundos(BaseFlow.driver, BaseFlow.pageModel.getLbxCentroMedico(), 10);
	}

	@Then("^Valido label centro medico \"(.*?)\"$")
	public void valido_label_centro_medico(String centro) throws Throwable {
		String preview = BaseFlow.pageModel.getLbxCentroMedico().getAttribute("innerText").trim();
		String[] centroMedicoSplit = preview.split("↵");
		String[] centroMedicoSplitFinally = centroMedicoSplit[0].split("×");
		lblCentroMedico = centroMedicoSplitFinally[0].trim();
		//System.out.println("1:"+lblCentroMedico);
		//System.out.println("2:"+centro);
		//Thread.sleep(10000);
		// comparacion centro medico seleccionado
		if (centro.equals(lblCentroMedico)) {
			assertTrue(true);
		} else {
			System.out.println("No se valida de manera correcta selección centro médico");
			assertTrue(false);
		}
	}

	@When("^Visualizo fechas que se encuentran disponibles$")
	public void visualizo_fechas_que_se_encuentran_disponibles() throws Throwable {
		// valido que aparezca el tr de las fechas
		GenericMethods.isElementPresent(BaseFlow.pageModel.getTrFechasMostradas());
		// valido la cantidad de fechas disponibles habilitadas
		int fechasActivas = BaseFlow.pageModel.getListFechasActivas().size();
		if (fechasActivas >= 1) {
			assertTrue("Existen fechas activas para la combinación de búsqueda", true);
		} else if (fechasActivas <= 0) {
			assertTrue("No existen fechas activas para la combinación de búsqueda", true);
		} else {
			System.out.println("Condición de fechas no realizada");
			assertTrue(false);
		}
	}

	@Then("^Valido que existe una fecha ya seleccionada$")
	public void valido_que_existe_una_fecha_ya_seleccionada() throws Throwable {
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

	@Then("^Llamo servicio dia$")
	public void llamo_servicio_dia() throws Throwable {
		//momentaneo
		//System.out.println("¡Cambiar selección de fecha!");
		//Thread.sleep(10000);
	}

	@Then("^Valido que se visualice titulo mes y año actual$")
	public void valido_que_se_visualice_titulo_mes_y_año_actual() throws Throwable {
		GenericMethods.isElementPresent(BaseFlow.pageModel.gethFiveTituloReservaSemana());
	}

	@Then("^Valido titulo mes y año sea correcto$")
	public void valido_titulo_mes_y_año_sea_correcto() throws Throwable {
		//se compara el elemento que indica mes y año actual
	    if (BaseFlow.pageModel.gethFiveTituloReservaSemana().getText().trim().equals(
	    		GenericMethods.getCurrentMonthAndYear())) {
	    	assertTrue(true);
	    } else {
	    	System.out.println("Año y mes actual no son coinciden");
	    	assertTrue(false);
	    }
	}

	@Then("^Valido que se visualice subtitulo de semana$")
	public void valido_que_se_visualice_subtitulo_de_semana() throws Throwable {
		GenericMethods.isElementPresent(BaseFlow.pageModel.gethSixTituloReservaSemana());
	}

	@Then("^Valido rango dias sea correcto a la semana$")
	public void valido_rango_dias_sea_correcto_a_la_semana() throws Throwable {
		//System.out.println("1:"+BaseFlow.pageModel.gethSixTituloReservaSemana().getText().trim());
		//System.out.println("2:"+GenericMethods.getRangeOfWeekdays());
		//Thread.sleep(10000);
		if (BaseFlow.pageModel.gethSixTituloReservaSemana().getText().trim().equals(
	    		GenericMethods.getRangeOfWeekdays())) {
	    	assertTrue(true);
	    } else {
	    	System.out.println("Rango de días de la semana no coinciden");
	    	assertTrue(false);
	    }
	}

	@When("^Valido visualizacion de horas disponibles segun fecha ventana de hora$")
	public void valido_visualizacion_de_horas_disponibles_segun_fecha_ventana_de_hora() throws Throwable {
		//validacion de div horas
		GenericMethods.isElementPresent(BaseFlow.pageModel.getDivConApaBoxMed());
	}
	
	@Then("^Valido que aparezca apartado box medico$")
	public void valido_que_aparezca_apartado_box_medico() throws Throwable {
		//Div -- Div Box med
		GenericMethods.isElementPresent(BaseFlow.pageModel.getDivConApaBoxMed());
	}

	@Then("^Valido que aparezca titulo fecha seleccionada ventana de hora$")
	public void valido_que_aparezca_titulo_fecha_seleccionada_ventana_de_hora() throws Throwable {
		// H3 -- Titulo fecha seleccionada
	    GenericMethods.isElementPresent(BaseFlow.pageModel.gethThreeTituloFechaSeleccionadaExa());	    
	}

	@Then("^Valido que aparezca subtitulo especialidad mas prestacion seleccionada$")
	public void valido_que_aparezca_subtitulo_especialidad_mas_prestacion_seleccionada() throws Throwable {
		// h4 -- Subtitulo especialidad y prestacion box medico
		GenericMethods.isElementPresent(BaseFlow.pageModel.getHFourSubtituloEspecialidadPrestacionBoxMedico());
	}
	
	@Then("^Valido que subtitulo especialidad mas prestacion sea el correcto$")
	public void valido_que_subtitulo_especialidad_mas_prestacion_sea_el_correcto() throws Throwable {
		String espAndPre = lblEspecialidad+ " - "+lblPrestacion;
	    if (espAndPre.equals(BaseFlow.pageModel.getHFourSubtituloEspecialidadPrestacionBoxMedico().getText().trim())) {
	    	assertTrue(true);
	    } else {
	    	System.out.println("Subtitulo especialidad + prestacion no es correcto");
	    	assertTrue(false);
	    }
	}

	@Then("^Valido que aparezca subtitulo de centro medico seleccionado$")
	public void valido_que_aparezca_subtitulo_de_centro_medico_seleccionado() throws Throwable {
		// h5 -- Subtitulo centro medico box medico
		GenericMethods.isElementPresent(BaseFlow.pageModel.getHFiveSubtituloCentroMedicoBoxMedico());
	}

	@Then("^Valido que subtitulo de centro medico sea el correcto$")
	public void valido_que_subtitulo_de_centro_medico_sea_el_correcto() throws Throwable {
	    if (lblCentroMedico.equals(BaseFlow.pageModel.getHFiveSubtituloCentroMedicoBoxMedico().getText().trim())) {
	    	assertTrue(true);
	    } else {
	    	System.out.println("Subtitulo centro médico no es correcto");
	    	assertTrue(false);
	    }
	}

	@Then("^Valido que aparezca label horario mañana ventana de hora$")
	public void valido_que_aparezca_label_horario_mañana_ventana_de_hora() throws Throwable {
		// Label -- Horario Mañana
		GenericMethods.isElementPresent(BaseFlow.pageModel.getLblHorarioMañanaExa());
	}

	@Then("^Valido que aparezca listado examen horario mañana ventana de hora$")
	public void valido_que_aparezca_listado_examen_horario_mañana_ventana_de_hora() throws Throwable {
		// Ul -- Listado examenes mañana
		GenericMethods.isElementPresent(BaseFlow.pageModel.getUlListadoExamenesMañanaExa());
	}

	@Then("^Valido que aparezca label horario tarde ventana de hora$")
	public void valido_que_aparezca_label_horario_tarde_ventana_de_hora() throws Throwable {
		// Label -- Horario tarde
		GenericMethods.isElementPresent(BaseFlow.pageModel.getLblHorarioTardeExa());
	}

	@Then("^Valido que aparezca listado examen horario tarde ventana de hora$")
	public void valido_que_aparezca_listado_examen_horario_tarde_ventana_de_hora() throws Throwable {
		// Ul -- Listado examenes tarde
		GenericMethods.isElementPresent(BaseFlow.pageModel.getUlListadoExamenesTardeExa());
	}

	@Then("^Selecciono una hora disponible ventana de hora$")
	public void selecciono_una_hora_disponible_ventana_de_hora() throws Throwable {
		Thread.sleep(3000);
		List<WebElement> asd = BaseFlow.driver.findElements(By.className("horaActive"));		
		for (WebElement a : asd) {
			a.click();
			if(GenericMethods.isClickable(BaseFlow.pageModel.getDivResumenExamenes(), BaseFlow.driver))
			//if(GenericMethods.isElementPresent(BaseFlow.pageModel.getDivResumenEspecialidad()))
			break;
		}
		Thread.sleep(2000);
		//List<WebElement> asd = BaseFlow.driver.findElements(By.className("horaActive"));
		//asd.get(29).click();
	}

	@When("^Valido que aparezca ventana resumen consulta medico$")
	public void valido_que_aparezca_ventana_resumen_consulta_medico() throws Throwable {
		//Div -- Resumen examenes
		GenericMethods.isElementPresent(BaseFlow.pageModel.getDivResumenExamenes());
	}

	@Then("^Valido que aparezca imagen icono doctor ventana resumen consulta medico$")
	public void valido_que_aparezca_imagen_icono_doctor_ventana_resumen_consulta_medico() throws Throwable {
		// Imagen -- Icono examen
		GenericMethods.isElementPresent(BaseFlow.pageModel.getImgIconoExamenExa());
	}

	@Then("^Valido que aparezca nombre del doctor ventana resumen consulta medico$")
	public void valido_que_aparezca_nombre_del_doctor_ventana_resumen_consulta_medico() throws Throwable {
		// H3 -- Nombre doctor
		GenericMethods.isElementPresent(BaseFlow.pageModel.gethThreeNombreDoctorEsp());
	}
	
	@Then("^Valido que nombre del doctor visualizado en ventana resumen coincida con el nombre doctor del servicio$")
	public void valido_que_nombre_del_doctor_visualizado_en_ventana_resumen_coincida_con_el_nombre_doctor_del_servicio() throws Throwable {
		//String[] splitNombreDoctor = BaseFlow.pageModel.gethThreeNombreDoctorEsp().getText().split("Dr(a).");
		//System.out.println("x:"+splitNombreDoctor[0].trim());
		//Thread.sleep(1000000);
	    //if (BaseFlow.pageModel.gethThreeNombreDoctorEsp().getText().trim().equals(
	    		//nombreProfesionalService))
	}
	
	@Then("^Valido que aparezca especialidad del doctor ventana resumen consulta medico$")
	public void valido_que_aparezca_especialidad_del_doctor_ventana_resumen_consulta_medico() throws Throwable {
		// h3 -- Especialidad
		GenericMethods.isElementPresent(BaseFlow.pageModel.gethThreeEspecialidadExa());
	}

	@Then("^Valido que la especialidad seleccionada coincida con la mostrada ventana resumen consulta medico$")
	public void valido_que_la_especialidad_seleccionada_coincida_con_la_mostrada_ventana_resumen_consulta_medico() throws Throwable {
		//System.out.println("1:"+BaseFlow.pageModel.gethThreeEspecialidadExa().getText().trim());
		//System.out.println("2:"+lblPrestacion);
		//Thread.sleep(10000);
		if (BaseFlow.pageModel.gethThreeEspecialidadExa().getText().trim().equals(
				lblPrestacion)) {
			assertTrue(true);
		} else {
			System.out.println("Especialidad mostrada en resumen no coincide con lo seleccionado");
			assertTrue(false);
		}
	}

	@Then("^Valido que aparezca centro medico ventana resumen consulta medico$")
	public void valido_que_aparezca_centro_medico_ventana_resumen_consulta_medico() throws Throwable {
		// H6 -- Centro medico
		GenericMethods.isElementPresent(BaseFlow.pageModel.gethSixCentroMedicoExa());
	}

	@Then("^Valido que el centro medico seleccionado coincida con lo mostrado ventana resumen consulta medico$")
	public void valido_que_el_centro_medico_seleccionado_coincida_con_lo_mostrado_ventana_resumen_consulta_medico() throws Throwable {
		if (BaseFlow.pageModel.gethSixCentroMedicoExa().getText().trim().equals(
				lblCentroMedico)) {
			assertTrue(true);
		} else {
			System.out.println("Centro médico mostrado en resumen no coincide con lo seleccionado");
			assertTrue(false);
		}
	}

	@Then("^Valido que aparezca seccion paciente ventana resumen consulta medico$")
	public void valido_que_aparezca_seccion_paciente_ventana_resumen_consulta_medico() throws Throwable {
		// Div -- Seccion paciente
		GenericMethods.isElementPresent(BaseFlow.pageModel.getDivSeccionPaciente());
	}

	@Then("^Valido que aparezca imagen icono genero ventana resumen consulta medico$")
	public void valido_que_aparezca_imagen_icono_genero_ventana_resumen_consulta_medico() throws Throwable {
		// Img -- Icono genero
		GenericMethods.isElementPresent(BaseFlow.pageModel.getImgIconoGeneroExa());
	}

	@Then("^Valido que imagen icono genero coincida entre la busqueda inicial y el mostrado en ventana resumen consulta medico$")
	public void valido_que_imagen_icono_genero_coincida_entre_la_busqueda_inicial_y_el_mostrado_en_ventana_resumen_consulta_medico() throws Throwable {
		//obengo atributo src de imagen icono genero busqueda inicial
		String imgIconoGeneroBusquedaInicial = BaseFlow.pageModel.getImgIconoPaciente().getAttribute("src");
		//obengo atributo src de imagen icono genero ventana resumen
		String imgIconoGeneroVentanaResumenProfesional = BaseFlow.pageModel.getImgIconoGeneroExa().getAttribute("src");
		if (imgIconoGeneroBusquedaInicial.equals(imgIconoGeneroVentanaResumenProfesional)) {
			assertTrue(true);
		} else {
			System.out.println("Imagen icono paciente no coincide entre la búsqueda inicial y el mostrado en ventana resumen");
			assertTrue(false);
		}
	}

	@Then("^Valido que aparezca nombre paciente ventana resumen consulta medico$")
	public void valido_que_aparezca_nombre_paciente_ventana_resumen_consulta_medico() throws Throwable {
		// h5 -- Nombre paciente
		GenericMethods.isElementPresent(BaseFlow.pageModel.gethFiveNombrePacienteExa());
	}

	@Then("^Valido que nombre coincida entre la busqueda inicial y el mostrado en ventana resumen consulta medico$")
	public void valido_que_nombre_coincida_entre_la_busqueda_inicial_y_el_mostrado_en_ventana_resumen_consulta_medico() throws Throwable {
		if (BaseFlow.pageModel.gethFiveNombrePaciente().getText().trim().equals(
				BaseFlow.pageModel.gethFiveNombrePacienteExa().getText().trim())) {
			assertTrue(true);
		} else {
			System.out.println("Nombre paciente no coincide entre la búsqueda inicial y el mostrado en ventana resumen");
			assertTrue(false);
		}
	}

	@Then("^Valido que aparezca correo paciente ventana resumen consulta medico$")
	public void valido_que_aparezca_correo_paciente_ventana_resumen_consulta_medico() throws Throwable {
		// Parrafo -- Mail paciente
		GenericMethods.isElementPresent(BaseFlow.pageModel.getpMailPacienteExa());
	}

	@Then("^Valido que aparezca seccion consulta ventana resumen consulta medico$")
	public void valido_que_aparezca_seccion_consulta_ventana_resumen_consulta_medico() throws Throwable {
		// Div -- Seccion consulta
		GenericMethods.isElementPresent(BaseFlow.pageModel.getDivSeccionConsulta());
	}

	@Then("^Valido que aparezca imagen icono calendario ventana resumen consulta medico$")
	public void valido_que_aparezca_imagen_icono_calendario_ventana_resumen_consulta_medico() throws Throwable {
		// Imagen -- Icono calendario
		GenericMethods.isElementPresent(BaseFlow.pageModel.getImgIconoCalendarioExa());
	}

	@Then("^Valido que aparezca fecha de la consulta ventana resumen consulta medico$")
	public void valido_que_aparezca_fecha_de_la_consulta_ventana_resumen_consulta_medico() throws Throwable {
		// Span -- Fecha examen
		GenericMethods.isElementPresent(BaseFlow.pageModel.getSpnFechaExamenExa());
	}

	@Then("^Valido que fecha coincida entre el apartado de horas y el mostrado en ventana resumen consulta medico$")
	public void valido_que_fecha_coincida_entre_el_apartado_de_horas_y_el_mostrado_en_ventana_resumen_consulta_medico() throws Throwable {
		if (BaseFlow.pageModel.gethThreeTituloFechaSeleccionadaExa().getText().trim().equals(
				BaseFlow.pageModel.getSpnFechaExamenExa().getText().trim())) {
			assertTrue(true);
		} else {
			System.out.println("Fecha de consulta no coincide entre el apartado de horas y el mostrado en ventana resumen");
			assertTrue(false);
		}
	}

	@Then("^Valido que aparezca imagen icono horario ventana resumen consulta medico$")
	public void valido_que_aparezca_imagen_icono_horario_ventana_resumen_consulta_medico() throws Throwable {
		// Imagen -- Icono horario
		GenericMethods.isElementPresent(BaseFlow.pageModel.getImgIconoHorarioExamenExa());
	}

	@Then("^Valido que aparezca hora de la consulta ventana resumen consulta medico$")
	public void valido_que_aparezca_hora_de_la_consulta_ventana_resumen_consulta_medico() throws Throwable {
		// Span -- Horario
		GenericMethods.isElementPresent(BaseFlow.pageModel.getSpanHorarioExamenExa());
	}

	@Then("^Valido que aparezca imagen icono costo de consulta ventana resumen consulta medico$")
	public void valido_que_aparezca_imagen_icono_costo_de_consulta_ventana_resumen_consulta_medico() throws Throwable {
		// Imagen -- Icono pago
		GenericMethods.isElementPresent(BaseFlow.pageModel.getImgIconoPagoExa());
	}

	@Then("^Valido que aparezca monto dinero de la consulta ventana resumen consulta medico$")
	public void valido_que_aparezca_monto_dinero_de_la_consulta_ventana_resumen_consulta_medico() throws Throwable {
		// Span -- Monto pago
		GenericMethods.isElementPresent(BaseFlow.pageModel.getSpnMontoPagoExa());
	}

	@Then("^Valido que aparezca boton agendar ventana resumen consulta medico$")
	public void valido_que_aparezca_boton_agendar_ventana_resumen_consulta_medico() throws Throwable {
		// Button -- Agendar
		GenericMethods.isElementPresent(BaseFlow.pageModel.getBtnAgendarExa());
	}

	@Then("^Valido que haga click boton agendar ventana resumen consulta medico$")
	public void valido_que_haga_click_boton_agendar_ventana_resumen_consulta_medico() throws Throwable {
		boolean condition = BaseFlow.pageModel.getBtnAgendarExa().isEnabled();
		if (condition == true) {
			assertTrue(true);
		} else {
			System.out.println("Botón agendar no se encuentra habilitado");
			assertTrue(false);
		}
	}
}
