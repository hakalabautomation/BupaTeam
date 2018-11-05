package cl.cencosud.publicsite.automation.poc.definition.steps;

import org.openqa.selenium.support.ui.Select;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cl.cencosud.publicsite.automation.poc.business.flow.BaseFlow;
import cl.cencosud.publicsite.automation.poc.business.flow.FlujoCompraCompletoTest;
import cl.cencosud.publicsite.automation.poc.util.FlujoCompraServices;
import cl.cencosud.publicsite.automation.poc.util.GenericMethods;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class FlujoCompraCompletoInvitadoDefinition {
	private static final Logger logger = LoggerFactory.getLogger(FlujoCompraCompletoTest.class);

	@When("^ingreso sku \"(.*?)\"$")
	public void ingreso_sku(String arg1) throws Throwable {
		try {
			BaseFlow.pageModel.getHomeTxtIngresobusqueda().sendKeys(arg1);
			BaseFlow.pageModel.getHomeBtnBuscar().click();

		} catch (Exception e) {
			logger.info("no se logra ingresar sku flujo invitado", e);
		}
	}

	@When("^selecciono cantidad \"(.*?)\"$")
	public void selecciono_cantidad(String cantidad) throws Throwable {
		try {
			GenericMethods.waitTime(BaseFlow.pageModel.getPdpCantidad());
			Select pdpCantidad = new Select(BaseFlow.pageModel.getPdpCantidad());
			pdpCantidad.selectByVisibleText(cantidad);
		} catch (Exception e) {
			logger.info("Flujo detenido en ingreso de cantidad por : " + e);
		}
	}

	@When("^selecciono color\"(.*?)\"\"(.*?)\"$")
	public void selecciono_color(String color, String tipoProducto) throws Throwable {
		try {
			if (tipoProducto.equals("standard")) {

			}

		} catch (Exception e) {
			logger.info("Flujo detenido en ingreso de color por : " + e);
		}
	}

	@When("^selecciono talla \"(.*?)\"\"(.*?)\"$")
	public void selecciono_talla(String talla, String tipoProducto) throws Throwable {
		try {
			if (tipoProducto.equals("standard")) {

			}

		} catch (Exception e) {
			logger.info("Flujo detenido en ingreso de talla por : " + e);
		}
	}

	@When("^se agrega producto al carro$")
	public void se_agrega_producto_al_carro() throws Throwable {
		try {

			BaseFlow.pageModel.getPdpAgregarCarro().click();

		} catch (Exception e) {
			logger.info("Flujo detenido en agregar al carro por : " + e);
		}
	}

	@When("^ingreso a pago automatico\"(.*?)\"$")
	public void ingreso_a_pago_automatico(String seleccionPago) throws Throwable {
		try {
			BaseFlow.pageModel.getFramePDP_btnCerrarFrame().click();
			if (seleccionPago.equals("true")) {
				BaseFlow.pageModel.getPdpBtnComprar().click();
			}
		} catch (Exception e) {
			logger.info("Flujo detenido en comprar por : " + e);
		}
	}

	@When("^ingreso al carro de compras\"(.*?)\"$")
	public void ingreso_al_carro_de_compras(String ingresoCarro) throws Throwable {
		try {
			if (ingresoCarro.equals("true")) {
				BaseFlow.pageModel.getPdpBtnVerCarro().click();
				BaseFlow.pageModel.getPdpBtnVerCarro().isDisplayed();
			}
		} catch (Exception e) {
			logger.info("Flujo detenido en ir al carro por : " + e);
		}
	}

	@When("^agregar codigo promocional \"(.*?)\"\"(.*?)\"\"(.*?)\"$")
	public void agregar_codigo_promocional(String cdoDscto, String ingresaCdo, String ingresoCarro) throws Throwable {
		try {
			if (ingresoCarro.equals("true") && ingresaCdo.equals("true")) {
				BaseFlow.pageModel.getPdpInputCuponCode().sendKeys(cdoDscto);
				BaseFlow.pageModel.getPdpBtnAplicar().click();
			}
		} catch (Exception e) {
			logger.info("Flujo detenido en ingreso de codigo promocional : " + e);
		}
	}

	@When("^selecciono ir a la caja \"(.*?)\"$")
	public void selecciono_ir_a_la_caja(String ingresoCarro) throws Throwable {
		try {
			if (ingresoCarro.equals("true")) {
				GenericMethods.scrollElement(BaseFlow.driver, BaseFlow.pageModel.getCarroBtnIrALaCaja());
				BaseFlow.pageModel.getCarroBtnIrALaCaja().click();
				// GenericMethods.scrollClickElement(BaseFlow.driver,
				// BaseFlow.pageModel.getCarroBtnIrALaCaja());
			}

		} catch (Exception e) {
			logger.info("Flujo detenido en seleccion continuara en modal : " + e);
		}
	}

	@When("^selecciono tipo de cliente \"(.*?)\"$")
	public void selecciono_tipo_de_cliente(String cliente) throws Throwable {
		try {
			if (cliente.equals("invitado")) {
				BaseFlow.pageModel.getCheckoutBtnInvitado().click();
			}

		} catch (Exception e) {
			logger.info("Flujo detenido en seleccion tipo de cliente : " + e);
		}
	}

	@When("^ingresamos datos de cliente \"(.*?)\"\"(.*?)\"\"(.*?)\"\"(.*?)\"\"(.*?)\"\"(.*?)\"$")
	public void ingresamos_datos_de_cliente(String nombreCliente, String apellidoCliente, String email, String telefono,
			String tipoDocumento, String nDocumento) throws Throwable {
		try {
			BaseFlow.pageModel.getCheckoutTextNombre().sendKeys(nombreCliente);
			BaseFlow.pageModel.getCheckoutTextApellido().sendKeys(apellidoCliente);
			BaseFlow.pageModel.getCheckoutTextEmail().sendKeys(email);
			BaseFlow.pageModel.getCheckoutTextTelefono().sendKeys(telefono);
			FlujoCompraServices.seleccionDcto(tipoDocumento, nDocumento);

		} catch (Exception e) {
			logger.info("Flujo detenido en ingreso datos del cliente : " + e);
		}
	}

	@When("^selecciono boton continuar$")
	public void selecciono_boton_continuar() throws Throwable {
		try {
			BaseFlow.pageModel.getCheckoutBtncontinuar().click();

		} catch (Exception e) {
			logger.info("Flujo detenido en seleccion boton continuar : " + e);
		}

	}

	@When("^seleciono tipo de entrega\"(.*?)\"$")
	public void seleciono_tipo_de_entrega(String tipoEntrega) throws Throwable {

		try {
			if (tipoEntrega.equals("Despacho a domicilio")) {
				BaseFlow.pageModel.getCheckoutBtnDespachoDomicilio().click();
			} else {
				BaseFlow.pageModel.getCheckoutBtnRetiroEnTienda().click();
			}

		} catch (Exception e) {
			logger.info("Flujo detenido en seleccion tipo de entrega : " + e);
		}
	}

	@When("^ingreso Datos Despacho o Tienda \"(.*?)\"\"(.*?)\"\"(.*?)\"\"(.*?)\"\"(.*?)\"\"(.*?)\"\"(.*?)\"\"(.*?)\"\"(.*?)\"$")
	public void ingreso_Datos_Despacho_o_Tienda(String tipoEntrega, String tipoDespacho, String tipoUbicacion,
			String ubicacion, String direccion, String numeroCasaDepto, String cdgPostal, String region, String comuna,
			String calle, String numeroCalle) throws Throwable {
		try {
			FlujoCompraServices.ingresoDatosDespachoTienda(tipoEntrega, tipoDespacho, tipoUbicacion, ubicacion,
					direccion, numeroCasaDepto, cdgPostal, region, comuna, calle, numeroCalle);
		} catch (Exception e) {
			logger.info("Flujo detenido en ingreso datos despacho o tienda : " + e);
		}
	}

	@When("^selecciono boton continuar compra \"(.*?)\"\"(.*?)\"$")
	public void selecciono_boton_continuar_compra(String tipoEntrega, String tipoDespacho) throws Throwable {

		try {
			if (tipoEntrega.equals("Despacho a domicilio")) {
				if (tipoDespacho.equals("Standard")) {
					BaseFlow.pageModel.getCheckoutRadioBtnStandardDespacho().click();
				} else {
					BaseFlow.pageModel.getCheckoutRadioBtnProgramDespacho().click();
				}
				BaseFlow.pageModel.getCheckoutBtnContinuarFacturacion().click();
			} else {// Retiro en tienda falta ingresar el flujo de retiro en tienda

				BaseFlow.pageModel.getCheckoutBtnContinuarFacturacion().click();
			}
		} catch (Exception e) {
			logger.info("Flujo detenido en seleccion boton continuar compra : " + e);
		}
	}

	@When("^ingreso datos novios bebe y casa \"(.*?)\"\"(.*?)\"\"(.*?)\"\"(.*?)\"\"(.*?)\"$")
	public void ingreso_datos_novios_bebe_y_casa(String nombreNovio, String apellidoNovio, String nombreNovia,
			String apellidoNovia, String mensajeNovios) throws Throwable {
		try {
			// Falta tomar los id de los objetos e ingresarlos a page model
			// BaseFlow.pageModel.getCheckoutInputNomNovio().sendKeys(nombreNovio);
			// BaseFlow.pageModel.getCheckoutInputApeNovio().sendKeys(apellidoNovio);
			// BaseFlow.pageModel.getCheckoutInputNomNovia().sendKeys(nombreNovia);
			// BaseFlow.pageModel.getCheckoutInputApeNovia().sendKeys(apellidoNovia);
			// BaseFlow.pageModel.getCheckoutTextMensajeNovios().sendKeys(mensajeNovios);
			// BaseFlow.pageModel.getCheckoutBtnContinue().click();
		} catch (Exception e) {
			logger.info("Flujo detenido en ingreso datos novios bebe casa : " + e);
		}

	}

	@When("^selecciono metodo pago\"(.*?)\"$")
	public void selecciono_metodo_pago(String metodoPago) throws Throwable {
		try {
			if (metodoPago.equals("Tarjeta Cencosud")) {
				// BaseFlow.pageModel.getCheckoutBtnCencosudCard.click();
			} else if (metodoPago.equals("Tarjeta de Credito")) {
				// BaseFlow.pageModel.getCheckoutBtnCreditCard.click();
			} else if (metodoPago.equals("RedCompra")) {
				// BaseFlow.pageModel.getCheckoutBtnRedcompraCard().click();
			}

		} catch (Exception e) {
			logger.info("Flujo detenido en seleccion metodo de pago : " + e);
		}
	}

	@When("^ingreso datos metodo pago \"(.*?)\"\"(.*?)\"\"(.*?)\"\"(.*?)\"\"(.*?)\"\"(.*?)\"\"(.*?)\"\"(.*?)\"\"(.*?)\"\"(.*?)\"\"(.*?)\"$")
	public void ingreso_datos_metodo_pago(String metodoPago, String nombre, String apellido, String nTarjeta,
			String fechaMes, String fechaAno, String cvv, String nCuotas, String guardarTarjeta,
			String TipoTarjetaCenco, String rut) throws Throwable {

		try {
			FlujoCompraServices.ingresoDatosMetodoPago(metodoPago, nombre, apellido, nTarjeta, fechaMes, fechaAno, cvv,
					nCuotas, guardarTarjeta, TipoTarjetaCenco, rut);
		} catch (Exception e) {
			logger.info("Flujo detenido en ingreso datos metodo pago : " + e);
		}

	}

	@Then("^I verify the <status> in step$")
	public void i_verify_the_status_in_step() throws Throwable {

	}

}
