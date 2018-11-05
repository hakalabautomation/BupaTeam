package cl.bupa.qa.automation.web.poc.definition.components;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import cl.bupa.qa.automation.web.business.flow.BaseFlow;
import cl.bupa.qa.automation.web.poc.util.GenericMethods;
import cucumber.api.java.en.Then;

public class DefinitionComponentHeaderBusquedaPacienteRut {

	@Then("^Valido que se visualiza boton menu$")
	public void valido_que_se_visualiza_boton_menu() throws Throwable {
		Thread.sleep(4000);
		//Button -- Menu 
	    assertTrue(GenericMethods.isElementPresent(BaseFlow.pageModel.getBtnMenu()));
	}

	@Then("^Valido que al dar click en boton se depliega menu lateral$")
	public void valido_que_al_dar_click_en_boton_se_depliega_menu_lateral() throws Throwable {
		//Button -- Menu
		assertTrue(BaseFlow.pageModel.getBtnMenu().isDisplayed());
	}

	@Then("^Valido que el logo de bupa se visualice$")
	public void valido_que_el_logo_de_bupa_se_visualice() throws Throwable {
	    assertTrue(GenericMethods.isElementPresent(BaseFlow.pageModel.getImgCorporativa()));
	}

	@Then("^valido que link de logo este activo$")
	public void valido_que_link_de_logo_este_activo() throws Throwable {
	    assertTrue(BaseFlow.pageModel.getImgCorporativa().isEnabled());
	}

	@Then("^Valido que el titulo se visualice$")
	public void valido_que_el_titulo_se_visualice() throws Throwable {
	    assertTrue(GenericMethods.isElementPresent(BaseFlow.pageModel.gethOneSubTitulo()));
	    //H1 -- SubTitulo
	    String subTitulo = BaseFlow.pageModel.gethOneSubTitulo().getText().trim();	    
		assertEquals(subTitulo, BaseFlow.properties.getLabelSubTitulo());
	}

	@Then("^Valido que se visualice imagen de usuario$")
	public void valido_que_se_visualice_imagen_de_usuario() throws Throwable {
		assertTrue(GenericMethods.isElementPresent(BaseFlow.pageModel.getImgSesionUsuario()));
	}

	@Then("^Valido nombre de usuario$")
	public void valido_nombre_de_usuario() throws Throwable {
		assertTrue(GenericMethods.isElementPresent(BaseFlow.pageModel.getpNombreUsuario()));
	}

	@Then("^Valido centro medico de usuario$")
	public void valido_centro_medico_de_usuario() throws Throwable {
	    assertTrue(GenericMethods.isElementPresent(BaseFlow.pageModel.getpCentroMedico()));
	}

	@Then("^Valido que se visualice icono de notificaciones$")
	public void valido_que_se_visualice_icono_de_notificaciones() throws Throwable {
	    //assertTrue(GenericMethods.isElementPresent(BaseFlow.pageModel.getImgIconoNotificaciones()));
	}

	@Then("^Valido que al dar click a icono notificaciones se desplieguen las notificaciones del cliente$")
	public void valido_que_al_dar_click_a_icono_notificaciones_se_desplieguen_las_notificaciones_del_cliente() throws Throwable {
	    //assertTrue(BaseFlow.pageModel.getImgIconoNotificaciones().isEnabled());
	}
}
