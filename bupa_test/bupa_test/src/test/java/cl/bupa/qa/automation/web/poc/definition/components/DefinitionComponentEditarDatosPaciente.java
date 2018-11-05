package cl.bupa.qa.automation.web.poc.definition.components;

import static org.junit.jupiter.api.Assertions.assertTrue;

import cl.bupa.qa.automation.web.business.flow.BaseFlow;
import cl.bupa.qa.automation.web.poc.util.GenericMethods;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class DefinitionComponentEditarDatosPaciente {
	
	private static String value;
	private static int totalGenero;
	private static int totalPrevision;
	private static int totalNacionalidad;
	private static int totalRegiones;
	
	@Given("^Valido que rut ya se visualice en campo \"(.*?)\"$")
	public void valido_que_rut_ya_se_visualice_en_campo(String rut) throws Throwable {
		Thread.sleep(10000);
	   if (BaseFlow.pageModel.getTxtInputRut().getAttribute("value").trim().equals(rut)) {
		   assertTrue(true);
	   } else {
		   System.out.println("Campo ingreso rut contiene otro dato distinto");
		   assertTrue(false);
	   }
	}

	@Given("^Validar boton buscar se encuentra habilitado$")
	public void validar_boton_buscar_se_encuentra_habilitado() throws Throwable {
	    boolean condition = BaseFlow.pageModel.getBtnConsultar().isEnabled();
	    if (condition == true) {
	    	assertTrue(true);
	    } else {
	    	System.out.println("Botón consultar no se encuentra habilitado");
	    	assertTrue(false);
	    }
	}

	@When("^click en boton buscar$")
	public void click_en_boton_buscar() throws Throwable {
		BaseFlow.pageModel.getBtnConsultar().click();
	}

	@Then("^Visualizo apartado datos paciente$")
	public void visualizo_apartado_datos_paciente() throws Throwable {
		//Div -- Paciente encontrado
	    GenericMethods.isElementPresent(BaseFlow.pageModel.getDivPacienteEncontrado());
	}

	@Then("^Valido que se visualice link editar datos paciente$")
	public void valido_que_se_visualice_link_editar_datos_paciente() throws Throwable {
		// Link -- Editar informacion pacinete
		GenericMethods.isElementPresent(BaseFlow.pageModel.getLnkEditarInformacionPaciente());
	}

	@Then("^Valido que link editar datos paciente se encuentre habilitado$")
	public void valido_que_link_editar_datos_paciente_se_encuentre_habilitado() throws Throwable {
	    boolean condition = BaseFlow.pageModel.getLnkEditarInformacionPaciente().isEnabled();
	    if (condition == true) {
	    	assertTrue(true);
	    } else {
	    	System.out.println("Link editar datos paciente no se encuentra habilitado");
	    	assertTrue(false);
	    }
	}

	@Then("^Dar click en link editar datos paciente$")
	public void dar_click_en_link_editar_datos_paciente() throws Throwable {
		BaseFlow.pageModel.getLnkEditarInformacionPaciente().click();
	}

	@Given("^Valido que se visualice ventana de edicion de datos$")
	public void valido_que_se_visualice_ventana_de_edicion_de_datos() throws Throwable {
		//espero hasta que ventana de crear y editar paciente se despliegue
		GenericMethods.waitTime(BaseFlow.pageModel.getDivCrearEditarPaciente());
		//valido que se visualice
		GenericMethods.isElementPresent(BaseFlow.pageModel.getDivCrearEditarPaciente());
	}

	@When("^Valido que se visualice titulo editar datos paciente$")
	public void valido_que_se_visualice_titulo_editar_datos_paciente() throws Throwable {
		//H5 -- Crear y editar datos paciente
		GenericMethods.isElementPresent(BaseFlow.pageModel.gethFiveTituloCrearEditarDatosPaciente());
	}

	@Then("^Valido que titulo editar datos paciente sea el correcto$")
	public void valido_que_titulo_editar_datos_paciente_sea_el_correcto() throws Throwable {
	    if (BaseFlow.pageModel.gethFiveTituloCrearEditarDatosPaciente().getText().trim().equals(
	    		BaseFlow.properties.getLabelEditarDatosPaciente())) {
	    	assertTrue(true);
	    } else {
	    	System.out.println("Título editar datos paciente no es correo");
	    	assertTrue(false);
	    }
	}

	@Then("^Valido visualizacion label rut$")
	public void valido_visualizacion_label_rut() throws Throwable {
		// Label -- Rut paciente
		GenericMethods.isElementPresent(BaseFlow.pageModel.getLblRut());
	}

	@Then("^Valido que label rut sea el correcto$")
	public void valido_que_label_rut_sea_el_correcto() throws Throwable {
		if (BaseFlow.pageModel.getLblRut().getText().trim().equals(
				BaseFlow.properties.getLabelRutDatosPaciente())) {
			assertTrue(true);
		} else {
			System.out.println("Label rut no es correcto");
			assertTrue(false);
		}
	}

	@Then("^Valido visualizacion campo rut$")
	public void valido_visualizacion_campo_rut() throws Throwable {
		//Input text -- Rut
		GenericMethods.isElementPresent(BaseFlow.pageModel.getTxtRut());
	}

	@Then("^Valido que campo rut muestre rut correcto \"(.*?)\"$")
	public void valido_que_campo_rut_muestre_rut_correcto(String rut) throws Throwable {
		if (BaseFlow.pageModel.getTxtRut().getAttribute("value").trim().equals(rut)) {
			assertTrue(true);
		} else {
			System.out.println("Rut mostrado en campo no es idéntico");
			assertTrue(false);
		}
	}

	@Then("^Valido que campo rut contenga rut del paciente buscado previamente$")
	public void valido_que_campo_rut_contenga_rut_del_paciente_buscado_previamente() throws Throwable {
		if (BaseFlow.pageModel.getTxtInputRut().getText().trim().equals(
				BaseFlow.pageModel.getTxtRut().getText().trim())) {
			assertTrue(true);
		} else {
			System.out.println("Rut mostrado en ambos campos no es idéntico");
			assertTrue(false);
		}
	}

	@Then("^Valido que campo rut se encuentre estado deshabilitado$")
	public void valido_que_campo_rut_se_encuentre_estado_deshabilitado() throws Throwable {
		boolean condition = BaseFlow.pageModel.getTxtRut().isEnabled();
		if (condition == false) {
			assertTrue(true);
		} else {
			System.out.println("Campo rut no se encuentra deshabilitado");
			assertTrue(false);
		}
	}

	@Then("^Valido que se visualice label nombres$")
	public void valido_que_se_visualice_label_nombres() throws Throwable {
		//Label -- Nombres
		GenericMethods.isElementPresent(BaseFlow.pageModel.getLblNombres());
	}

	@Then("^Valido que label nombres sea el correcto$")
	public void valido_que_label_nombres_sea_el_correcto() throws Throwable {
		if (BaseFlow.pageModel.getLblNombres().getText().trim().equals(
				BaseFlow.properties.getLabelNombres())) {
			assertTrue(true);
		} else {
			System.out.println("Label nombres no es correcto");
			assertTrue(false);
		}
	}

	@Then("^Valido que se visualice el campo nombres$")
	public void valido_que_se_visualice_el_campo_nombres() throws Throwable {
		//Input text -- Nombres
		GenericMethods.isElementPresent(BaseFlow.pageModel.getTxtNombres());
	}

	@Then("^Valido que campo nombres contenga datos$")
	public void valido_que_campo_nombres_contenga_datos() throws Throwable {
	    int data = BaseFlow.pageModel.getTxtNombres().getAttribute("value").length();
	    if (data > 0) {
	    	assertTrue(true);
	    } else {
	    	System.out.println("Campo nombres no contiene datos");
	    	assertTrue(false);
	    }
	}

	@Then("^Valido que campo nombres se encuentre estado habilitado$")
	public void valido_que_campo_nombres_se_encuentre_estado_habilitado() throws Throwable {
		boolean condition = BaseFlow.pageModel.getTxtNombres().isEnabled();
		if (condition == true) {
			assertTrue(true);
		} else {
			System.out.println("Campo nombres no se encuentra habilitado");
			assertTrue(false);
		}
	}

	@Then("^Valido que se visualice label apellidos$")
	public void valido_que_se_visualice_label_apellidos() throws Throwable {
		//Label -- Apellidos
		GenericMethods.isElementPresent(BaseFlow.pageModel.getLblApellidos());
	}

	@Then("^Valido que label apellidos sea el correcto$")
	public void valido_que_label_apellidos_sea_el_correcto() throws Throwable {
		if (BaseFlow.pageModel.getLblApellidos().getText().trim().equals(
				BaseFlow.properties.getLabelApellidos())) {
			assertTrue(true);
		} else {
			System.out.println("Label apellidos no es correcto");
			assertTrue(false);
		}
	}

	@Then("^Valido que se visualice campo apellido materno$")
	public void valido_que_se_visualice_campo_apellido_materno() throws Throwable {
		//Input text -- Apellido materno
		GenericMethods.isElementPresent(BaseFlow.pageModel.getTxtApellidoMaterno());
	}

	@Then("^Valido que campo apellido materno contenga datos$")
	public void valido_que_campo_apellido_materno_contenga_datos() throws Throwable {
		int data = BaseFlow.pageModel.getTxtApellidoMaterno().getAttribute("value").length();
	    if (data > 0) {
	    	assertTrue(true);
	    } else {
	    	System.out.println("Campo apellido materno no contiene datos");
	    	assertTrue(false);
	    }
	}

	@Then("^Valido que campo apellido materno se encuentre habilitado$")
	public void valido_que_campo_apellido_materno_se_encuentre_habilitado() throws Throwable {
		boolean condition = BaseFlow.pageModel.getTxtApellidoMaterno().isEnabled();
		if (condition == true) {
			assertTrue(true);
		} else {
			System.out.println("Campo apellido materno no se encuentra habilitado");
			assertTrue(false);
		}
	}

	@Given("^Valido que se visualice campo apellido paterno$")
	public void valido_que_se_visualice_campo_apellido_paterno() throws Throwable {
		//Input text -- Apellido paterno
		GenericMethods.isElementPresent(BaseFlow.pageModel.getTxtApellidoPaterno());
	}

	@Given("^Valido que campo apellido paterno contenga datos$")
	public void valido_que_campo_apellido_paterno_contenga_datos() throws Throwable {
		int data = BaseFlow.pageModel.getTxtApellidoPaterno().getAttribute("value").length();
	    if (data > 0) {
	    	assertTrue(true);
	    } else {
	    	System.out.println("Campo apellido paterno no contiene datos");
	    	assertTrue(false);
	    }
	}

	@Given("^Valido que campo apellido paterno se encuentre habilitado$")
	public void valido_que_campo_apellido_paterno_se_encuentre_habilitado() throws Throwable {
	    boolean condition = BaseFlow.pageModel.getTxtApellidoPaterno().isEnabled();
	    if (condition == true) {
	    	assertTrue(true);
	    } else {
	    	System.out.println("Campo apellido paterno no se encuentra habilitado");
	    	assertTrue(false);
	    }
	}

	@Then("^Valido que se visualice label fecha de nacimiento$")
	public void valido_que_se_visualice_label_fecha_de_nacimiento() throws Throwable {
		//Label -- Fecha nacimiento
		GenericMethods.isElementPresent(BaseFlow.pageModel.getLblFechaNacimiento());
	}

	@Then("^Valido que label fecha de nacimiento sea el correcto$")
	public void valido_que_label_fecha_de_nacimiento_sea_el_correcto() throws Throwable {
		if (BaseFlow.pageModel.getLblFechaNacimiento().getText().trim().equals(
				BaseFlow.properties.getLabelFechaDeNacimiento())) {
			assertTrue(true);
		} else {
			System.out.println("Label fecha nacimiento no es el correcto");
			assertTrue(false);
		}
	}

	@Then("^Valido que se visualice campo dia fecha de nacimiento$")
	public void valido_que_se_visualice_campo_dia_fecha_de_nacimiento() throws Throwable {
		//Input text -- Fecha dia
		GenericMethods.isElementPresent(BaseFlow.pageModel.getTxtFechaDia());
	}

	@Then("^Valido que campo dia fecha de nacimiento contenga datos$")
	public void valido_que_campo_dia_fecha_de_nacimiento_contenga_datos() throws Throwable {
		int data = BaseFlow.pageModel.getTxtFechaDia().getAttribute("value").length();
	    if (data > 0) {
	    	assertTrue(true);
	    } else {
	    	System.out.println("Campo fecha día no contiene datos");
	    	assertTrue(false);
	    }
	}

	@Then("^Valido que campo dia fecha se encuentre habilitado$")
	public void valido_que_campo_dia_fecha_se_encuentre_habilitado() throws Throwable {
		boolean condition = BaseFlow.pageModel.getTxtFechaDia().isEnabled();
		if (condition == true) {
			assertTrue(true);
		} else {
			System.out.println("Campo dìa fecha no se encuentra habilitado");
			assertTrue(false);
		}
	}

	@Then("^Valido que se visualice campo mes de fecha de nacimiento$")
	public void valido_que_se_visualice_campo_mes_de_fecha_de_nacimiento() throws Throwable {
		//Input text -- Fecha mes
		GenericMethods.isElementPresent(BaseFlow.pageModel.getTxtFechaMes());
	}

	@Then("^Valido que campo mes fecha de nacimiento contenga datos$")
	public void valido_que_campo_mes_fecha_de_nacimiento_contenga_datos() throws Throwable {
		int data = BaseFlow.pageModel.getTxtFechaMes().getAttribute("value").length();
	    if (data > 0) {
	    	assertTrue(true);
	    } else {
	    	System.out.println("Campo fecha mes no contiene datos");
	    	assertTrue(false);
	    }
	}

	@Then("^Valido que campo mes fecha de nacimiento se encuentre habilitado$")
	public void valido_que_campo_mes_fecha_de_nacimiento_se_encuentre_habilitado() throws Throwable {
		boolean condition = BaseFlow.pageModel.getTxtFechaDia().isEnabled();
		if (condition == true) {
			assertTrue(true);
		} else {
			System.out.println("Campo dìa fecha no se encuentra habilitado");
			assertTrue(false);
		}
	}

	@Then("^Valido que se visualice campo año fecha de nacimiento$")
	public void valido_que_se_visualice_campo_año_fecha_de_nacimiento() throws Throwable {
		//Input text -- Fecha año
		GenericMethods.isElementPresent(BaseFlow.pageModel.getTxtFechaAño());
	}

	@Then("^Valido que campo año fecha de nacimiento contenga datos$")
	public void valido_que_campo_año_fecha_de_nacimiento_contenga_datos() throws Throwable {
		int data = BaseFlow.pageModel.getTxtFechaAño().getAttribute("value").length();
	    if (data > 0) {
	    	assertTrue(true);
	    } else {
	    	System.out.println("Campo fecha año no contiene datos");
	    	assertTrue(false);
	    }
	}

	@Then("^Valido que campo año de fecha de nacimiento se encuentre habilitado$")
	public void valido_que_campo_año_de_fecha_de_nacimiento_se_encuentre_habilitado() throws Throwable {
		boolean condition = BaseFlow.pageModel.getTxtFechaAño().isEnabled();
		if (condition == true) {
			assertTrue(true);
		} else {
			System.out.println("Campo año fecha no se encuentra habilitado");
			assertTrue(false);
		}
	}

	@Then("^Valido que se visualice label genero$")
	public void valido_que_se_visualice_label_genero() throws Throwable {
		//Label -- Genero
		GenericMethods.isElementPresent(BaseFlow.pageModel.getLblGenero());
	}

	@Then("^Valido que label genero sea el correcto$")
	public void valido_que_label_genero_sea_el_correcto() throws Throwable {
		if (BaseFlow.pageModel.getLblGenero().getText().trim().equals(
				BaseFlow.properties.getLabelGenero())) {
			assertTrue(true);
		} else {
			System.out.println("Label genero no es el correcto");
			assertTrue(false);
		}
	}

	@Then("^Valido visualizacion campo genero$")
	public void valido_visualizacion_campo_genero() throws Throwable {
		// ListBox -- Genero
		GenericMethods.isElementPresent(BaseFlow.pageModel.getLbxGenero());
	}

	@Then("^Valido que el campo genero se encuentre habilitado$")
	public void valido_que_el_campo_genero_se_encuentre_habilitado() throws Throwable {
		boolean condition = BaseFlow.pageModel.getLbxGenero().isEnabled();
		if (condition == true) {
			assertTrue(true);
		} else {
			System.out.println("Campo genero no se encuentra habilitado");
			assertTrue(false);
		}
	}

	@Then("^Valido que el campo genero no se encuentre vacio$")
	public void valido_que_el_campo_genero_no_se_encuentre_vacio() throws Throwable {
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

	@Then("^Valido que se visualice label prevision$")
	public void valido_que_se_visualice_label_prevision() throws Throwable {
		//Label -- Prevision
		GenericMethods.isElementPresent(BaseFlow.pageModel.getLblPrevision());
	}

	@Then("^Valido que label prevision sea el correcto$")
	public void valido_que_label_prevision_sea_el_correcto() throws Throwable {
		if (BaseFlow.pageModel.getLblPrevision().getText().trim().equals(
				BaseFlow.properties.getLabelPrevisionDatosPaciente())) {
			assertTrue(true);
		} else {
			System.out.println("Label previsión no es correcto");
			assertTrue(false);
		}
	}

	@Then("^Valido visualizacion campo prevision$")
	public void valido_visualizacion_campo_prevision() throws Throwable {
		// ListBox -- Prevision
		GenericMethods.isElementPresent(BaseFlow.pageModel.getLbxPrevision());
	}

	@Then("^Valido que el campo prevision se encuentre habilitado$")
	public void valido_que_el_campo_prevision_se_encuentre_habilitado() throws Throwable {
		boolean condition = BaseFlow.pageModel.getLbxPrevision().isEnabled();
		if (condition == true) {
			assertTrue(true);
		} else {
			System.out.println("Campo previsión no se encuentra habilitado");
		}
	}

	@Then("^Valido que el campo prevision no se encuentre vacio$")
	public void valido_que_el_campo_prevision_no_se_encuentre_vacio() throws Throwable {
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

	@Then("^Valido que se visualice label correo$")
	public void valido_que_se_visualice_label_correo() throws Throwable {
		// Label -- Correo
		GenericMethods.isElementPresent(BaseFlow.pageModel.getLblCorreo());
	}

	@Then("^Valido que label correo sea el correcto$")
	public void valido_que_label_correo_sea_el_correcto() throws Throwable {
		if (BaseFlow.pageModel.getLblCorreo().getText().trim().equals(
				BaseFlow.properties.getLabelCorreo())) {
			assertTrue(true);
		} else {
			System.out.println("Label correo no es correcto");
			assertTrue(false);
		}
	}

	@Then("^Valido visualizacion campo correo$")
	public void valido_visualizacion_campo_correo() throws Throwable {
		// Input text -- Correo
		GenericMethods.isElementPresent(BaseFlow.pageModel.getTxtCorreo());
	}

	@Then("^Valido que campo correo cotenga datos$")
	public void valido_que_campo_correo_cotenga_datos() throws Throwable {
		int data = BaseFlow.pageModel.getTxtCorreo().getAttribute("value").length();
	    if (data > 0) {
	    	assertTrue(true);
	    } else {
	    	System.out.println("Campo correo no contiene datos");
	    	assertTrue(false);
	    }
	}

	@Then("^Valido que el campo correo se encuentre habilitado$")
	public void valido_que_el_campo_correo_se_encuentre_habilitado() throws Throwable {
		boolean condition = BaseFlow.pageModel.getTxtCorreo().isEnabled();
		if (condition == true) {
			assertTrue(true);
		} else {
			System.out.println("Campo correo no se encuentra habilitado");
			assertTrue(false);
		}
	}

	@Then("^Valido que se visualice label telefono$")
	public void valido_que_se_visualice_label_telefono() throws Throwable {
		// Label -- Telefono
		GenericMethods.isElementPresent(BaseFlow.pageModel.getLblTelefono());
	}

	@Then("^Valido que label telefono sea el correcto$")
	public void valido_que_label_telefono_sea_el_correcto() throws Throwable {
		if (BaseFlow.pageModel.getLblTelefono().getText().trim().equals(
				BaseFlow.properties.getLabelTelefono())) {
			assertTrue(true);
		} else {
			System.out.println("Label teléfono no es correcto");
			assertTrue(false);
		}
	}

	@Then("^Valido visualizacion campo telefono$")
	public void valido_visualizacion_campo_telefono() throws Throwable {
		// Input text -- Telefono
		GenericMethods.isElementPresent(BaseFlow.pageModel.getTxtTelefono());
	}

	@Then("^Valido que campo telefono contenga datos$")
	public void valido_que_campo_telefono_contenga_datos() throws Throwable {
		int data = BaseFlow.pageModel.getTxtTelefono().getAttribute("value").length();
	    if (data > 0) {
	    	assertTrue(true);
	    } else {
	    	System.out.println("Campo teléfono no contiene datos");
	    	assertTrue(false);
	    }
	}

	@Then("^Valido que el campo telefono se encuentre habilitado$")
	public void valido_que_el_campo_telefono_se_encuentre_habilitado() throws Throwable {
		boolean condition = BaseFlow.pageModel.getTxtTelefono().isEnabled();
		if (condition == true) {
			assertTrue(true);
		} else {
			System.out.println("Campo teléfono no se encuentra habilitado");
			assertTrue(false);
		}
	}

	@Then("^Valido que se visualice label nacionalidad$")
	public void valido_que_se_visualice_label_nacionalidad() throws Throwable {
		// Label -- Nacionalidad
		GenericMethods.isElementPresent(BaseFlow.pageModel.getLblNacionalidad());
	}

	@Then("^Valido que label nacionalidad sea el correcto$")
	public void valido_que_label_nacionalidad_sea_el_correcto() throws Throwable {
		if (BaseFlow.pageModel.getLblNacionalidad().getText().trim().equals(
				BaseFlow.properties.getLabelNacionalidad())) {
			assertTrue(true);
		} else {
			System.out.println("Label nacionalidad no es correcto");
			assertTrue(false);
		}
	}

	@Then("^Valido visualizacion campo nacionalidad$")
	public void valido_visualizacion_campo_nacionalidad() throws Throwable {
		// ListBox -- Nacionalidad
		GenericMethods.isElementPresent(BaseFlow.pageModel.getLbxNacionalidad());
	}

	@Then("^Valido que el campo nacionalidad se encuentre habilitado$")
	public void valido_que_el_campo_nacionalidad_se_encuentre_habilitado() throws Throwable {
		boolean condition = BaseFlow.pageModel.getLbxNacionalidad().isEnabled();
		if (condition == true) {
			assertTrue(true);
		} else {
			System.out.println("Campo nacionalidad no se encuentra habilitado");
			assertTrue(false);
		}
	}

	@Then("^Valido que el campo nacionalidad no se encuentre vacio$")
	public void valido_que_el_campo_nacionalidad_no_se_encuentre_vacio() throws Throwable {
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

	@Then("^Valido que se visualice label direccion$")
	public void valido_que_se_visualice_label_direccion() throws Throwable {
		// Label -- Direccion
		GenericMethods.isElementPresent(BaseFlow.pageModel.getLblDireccion());
	}

	@Then("^Valido que label direccion sea el correcto$")
	public void valido_que_label_direccion_sea_el_correcto() throws Throwable {
		if(BaseFlow.pageModel.getLblDireccion().getText().trim().equals(
				BaseFlow.properties.getLabelDireccion())) {
			assertTrue(true);
		} else {
			System.out.println("Label dirección no es correcto");
			assertTrue(false);
		}
	}

	@Then("^Valido visualizacion campo direccion$")
	public void valido_visualizacion_campo_direccion() throws Throwable {
		// Input text -- Direccion
		GenericMethods.isElementPresent(BaseFlow.pageModel.getTxtDireccion());
	}

	@Then("^Valido que campo direccion contenga datos$")
	public void valido_que_campo_direccion_contenga_datos() throws Throwable {
		int data = BaseFlow.pageModel.getTxtDireccion().getAttribute("value").length();
	    if (data > 0) {
	    	assertTrue(true);
	    } else {
	    	System.out.println("Campo dirección no contiene datos");
	    	assertTrue(false);
	    }
	}

	@Then("^Valido que el campo direccion se encuentre habilitado$")
	public void valido_que_el_campo_direccion_se_encuentre_habilitado() throws Throwable {
		boolean condition = BaseFlow.pageModel.getTxtDireccion().isEnabled();
		if (condition == true) {
			assertTrue(true);
		} else {
			System.out.println("Campo dirección no se encuentra habilitado");
			assertTrue(false);
		}
	}

	@Then("^Valido visualizacion campo comuna$")
	public void valido_visualizacion_campo_comuna() throws Throwable {
		// Input text -- Comuna
		GenericMethods.isElementPresent(BaseFlow.pageModel.getTxtComuna());
	}

	@Then("^Valido que campo comuna contenga datos$")
	public void valido_que_campo_comuna_contenga_datos() throws Throwable {
		int data = BaseFlow.pageModel.getTxtComuna().getAttribute("value").length();
	    if (data > 0) {
	    	assertTrue(true);
	    } else {
	    	System.out.println("Campo comuna no contiene datos");
	    	assertTrue(false);
	    }
	}

	@Then("^Valido que el campo comuna se encuentre habilitado$")
	public void valido_que_el_campo_comuna_se_encuentre_habilitado() throws Throwable {
		boolean condition = BaseFlow.pageModel.getTxtComuna().isEnabled();
		if (condition == true) {
			assertTrue(true);
		} else {
			System.out.println("Campo comuna no se encuentra habilitado");
			assertTrue(false);
		}
	}

	@Then("^Valido visualizacion campo region$")
	public void valido_visualizacion_campo_region() throws Throwable {
		// ListBox -- Regiones
		GenericMethods.isElementPresent(BaseFlow.pageModel.getLbxRegiones());
	}

	@Then("^Valido que el campo region se encuentre habilitado$")
	public void valido_que_el_campo_region_se_encuentre_habilitado() throws Throwable {
		boolean condition = BaseFlow.pageModel.getLbxRegiones().isEnabled();
		if (condition == true) {
			assertTrue(true);
		} else {
			System.out.println("Campo región no se encuentra habilitado");
			assertTrue(false);
		}
	}

	@Then("^Valido que el campo region no se encuentre vacio$")
	public void valido_que_el_campo_region_no_se_encuentre_vacio() throws Throwable {
		BaseFlow.pageModel.getLbxRegiones().click();
		totalRegiones = BaseFlow.pageModel.getListRegiones().size();
		if (totalRegiones > 0) {
			assertTrue(true);
		} else {
			System.out.println("Campo región se encuentra vacío");
			assertTrue(false);
		}
	}

	@When("^Ingreso dato editado nombres \"(.*?)\"$")
	public void ingreso_dato_editado_nombres(String nombres) throws Throwable {
		BaseFlow.pageModel.getTxtNombres().clear();
		BaseFlow.pageModel.getTxtNombres().sendKeys(nombres);
	}

	@When("^Ingreso dato editado apellido materno \"(.*?)\"$")
	public void ingreso_dato_editado_apellido_materno(String apellidoMaterno) throws Throwable {
		BaseFlow.pageModel.getTxtApellidoMaterno().clear();
		BaseFlow.pageModel.getTxtApellidoMaterno().sendKeys(apellidoMaterno);
	}

	@When("^Ingreso dato editado apellido paterno \"(.*?)\"$")
	public void ingreso_dato_editado_apellido_paterno(String apellidoPaterno) throws Throwable {
		BaseFlow.pageModel.getTxtApellidoPaterno().clear();
		BaseFlow.pageModel.getTxtApellidoPaterno().sendKeys(apellidoPaterno);
	}

	@When("^Ingreso dato editado dia fecha nacimiento \"(.*?)\"$")
	public void ingreso_dato_editado_dia_fecha_nacimiento(String dia) throws Throwable {
		BaseFlow.pageModel.getTxtFechaDia().clear();
		BaseFlow.pageModel.getTxtFechaDia().sendKeys(dia);
	}

	@When("^Ingreso dato editado mes fecha nacimiento \"(.*?)\"$")
	public void ingreso_dato_editado_mes_fecha_nacimiento(String mes) throws Throwable {
		BaseFlow.pageModel.getTxtFechaMes().clear();
		BaseFlow.pageModel.getTxtFechaMes().sendKeys(mes);
	}

	@When("^Ingreso dato editado año fecha nacimiento \"(.*?)\"$")
	public void ingreso_dato_editado_año_fecha_nacimiento(String año) throws Throwable {
		BaseFlow.pageModel.getTxtFechaAño().clear();
		BaseFlow.pageModel.getTxtFechaAño().sendKeys(año);
	}

	@When("^Seleccion dato editado genero \"(.*?)\"$")
	public void seleccion_dato_editado_genero(String genero) throws Throwable {
		BaseFlow.pageModel.getLbxGenero().click();
	    BaseFlow.pageModel.getListGenero().get(Integer.parseInt(genero)).click();;
	}

	@When("^Seleccion dato editado prevision \"(.*?)\"$")
	public void seleccion_dato_editado_prevision(String prevision) throws Throwable {
		BaseFlow.pageModel.getLbxPrevision().click();
	    BaseFlow.pageModel.getListPrevision().get(Integer.parseInt(prevision)).click();
	}

	@When("^Ingreso dato editado correo \"(.*?)\"$")
	public void ingreso_dato_editado_correo(String correo) throws Throwable {
		BaseFlow.pageModel.getTxtCorreo().clear();
		BaseFlow.pageModel.getTxtCorreo().sendKeys(correo);
	}

	@When("^Ingreso dato editado telefono \"(.*?)\"$")
	public void ingreso_dato_editado_telefono(String telefono) throws Throwable {
		BaseFlow.pageModel.getTxtTelefono().clear();
		BaseFlow.pageModel.getTxtTelefono().sendKeys(telefono);
	}

	@When("^Seleccion dato editado nacionalidad \"(.*?)\"$")
	public void seleccion_dato_editado_nacionalidad(String nacionalidad) throws Throwable {
		BaseFlow.pageModel.getLbxNacionalidad().click();
	    BaseFlow.pageModel.getListNacionalidad().get(Integer.parseInt(nacionalidad)).click();
	}

	@When("^Ingreso dato editado direccion \"(.*?)\"$")
	public void ingreso_dato_editado_direccion(String direccion) throws Throwable {
		BaseFlow.pageModel.getTxtDireccion().clear();
		BaseFlow.pageModel.getTxtDireccion().sendKeys(direccion);   
	}

	@When("^Ingreso dato editado comuna \"(.*?)\"$")
	public void ingreso_dato_editado_comuna(String comuna) throws Throwable {
		BaseFlow.pageModel.getTxtComuna().clear();
		BaseFlow.pageModel.getTxtComuna().sendKeys(comuna);
	}

	@When("^Seleccion dato editado region \"(.*?)\"$")
	public void seleccion_dato_editado_region(String region) throws Throwable {
		BaseFlow.pageModel.getLbxRegiones().click();
	    BaseFlow.pageModel.getListRegiones().get(Integer.parseInt(region)).click();
	}

	@Then("^Valido visualizacion boton guardar$")
	public void valido_visualizacion_boton_guardar() throws Throwable {
		// Button -- Guardar
		GenericMethods.isElementPresent(BaseFlow.pageModel.getBtnGuardar());
	}

	@Then("^Valido que el boton guardar se encuentre habilitado$")
	public void valido_que_el_boton_guardar_se_encuentre_habilitado() throws Throwable {
		boolean condition = BaseFlow.pageModel.getBtnGuardar().isEnabled();
	    if (condition == true) {
	    	assertTrue(true);
	    } else {
	    	System.out.println("Botón guardar no se encuentra habilitado");
	    	assertTrue(false);
	    }
	}

	@Then("^Dar click en boton guardar$")
	public void dar_click_en_boton_guardar() throws Throwable {
		BaseFlow.pageModel.getBtnGuardar().click();
	}

	@When("^Valido visualizacion ventana edicion de exito$")
	public void valido_visualizacion_ventana_edicion_de_exito() throws Throwable {
		//espero hasta que ventana de crear y editar paciente se despliegue
		GenericMethods.waitTime(BaseFlow.pageModel.getMdlRutFail());
		GenericMethods.isElementPresent(BaseFlow.pageModel.getMdlRutFail());
	}

	@Then("^Valido visualizacion titulo de la ventana edicion de exito$")
	public void valido_visualizacion_titulo_de_la_ventana_edicion_de_exito() throws Throwable {
		GenericMethods.isElementPresent(BaseFlow.pageModel.getLblPacienteFail());
	}
	
	@Then("^Valido que el titulo sea correcto$")
	public void valido_que_el_titulo_sea_correcto() throws Throwable {
		if (BaseFlow.pageModel.getLblPacienteFail().getText().trim().equals(
	    		BaseFlow.properties.getLabelDatosGuardados())) {
			assertTrue(true);
		} else {
			System.out.println("Tìtulo datos guardaos no es correcto");
			assertTrue(false);
		}
	}

	@Then("^Valido visualizacion imagen de edicion de exito$")
	public void valido_visualizacion_imagen_de_edicion_de_exito() throws Throwable {
		GenericMethods.isElementPresent(BaseFlow.pageModel.getImgIconoFail());
	}

	@Then("^Valido visualizacion mensaje de edicion de exito$")
	public void valido_visualizacion_mensaje_de_edicion_de_exito() throws Throwable {
		GenericMethods.isElementPresent(BaseFlow.pageModel.getPrfMensajeFail());
	}
	
	@Then("^Valido la visualizacion boton aceptar$")
	public void valido_la_visualizacion_boton_aceptar() throws Throwable {
		GenericMethods.isElementPresent(BaseFlow.pageModel.getBtnAceptarFail());
	}

	@Then("^Valido que el boton aceptar se encuentre habilitado$")
	public void valido_que_el_boton_aceptar_se_encuentre_habilitado() throws Throwable {
		boolean condition = BaseFlow.pageModel.getBtnAceptarFail().isEnabled();
	    if (condition == true) {
	    	assertTrue(true);
	    } else {
	    	System.out.println("Botón aceptar no se encuentra habilitado");
	    	assertTrue(false);
	    }
	}

	@Then("^Precionar el boton aceptar$")
	public void precionar_el_boton_aceptar() throws Throwable {
		BaseFlow.pageModel.getBtnAceptarFail().click();
	}
	
	@Then("^Valido visualizacion ventana de inicio$")
	public void valido_visualizacion_ventana_de_inicio() throws Throwable {
		Thread.sleep(2000);
		// Div - Menu inicial principal
	    GenericMethods.isElementPresent(BaseFlow.pageModel.getDivMenuInicialPrincipal());
	}

	@Then("^Valido que campo busqueda por rut no este vacio$")
	public void valido_que_campo_busqueda_por_rut_no_este_vacio() throws Throwable {
		value = BaseFlow.pageModel.getTxtInputRut().getAttribute("value");
		if (value != null || !value.equals("")) {
			assertTrue(true);
		} else {
			assertTrue(false);
			System.out.println("Campo ingreso rut no muestra rut y se encuentra vacío");
		}
	}

	@Then("^Valido que campo busqueda por rut muestre el rut del paciente editado \"(.*?)\"$")
	public void valido_que_campo_busqueda_por_rut_muestre_el_rut_del_paciente_editado(String rutEdit) throws Throwable {
	    if(value.equals(rutEdit)) {
	    	assertTrue(true);
	    } else {
	    	System.out.println("Campo búsqueda rut muestra un rut distinto al creado en datos paciente");
	    	assertTrue(false);
	    }
	}
}