package cl.cencosud.publicsite.automation.poc.util;

import org.openqa.selenium.support.ui.Select;

import cl.cencosud.publicsite.automation.poc.business.flow.BaseFlow;

public final class FlujoCompraServices {

	public static void seleccionDcto(String TipoDcto, String nDcto) {

		switch (TipoDcto) {
		case "DNI":
			BaseFlow.pageModel.getCheckoutRadioBtnDni().click();
			BaseFlow.pageModel.getCheckoutInputDni().sendKeys(nDcto);
			break;

		case "RUT":
			BaseFlow.pageModel.getCheckoutRadioBtnRut().click();
			BaseFlow.pageModel.getCheckoutInputRut().sendKeys(nDcto);
			break;

		default:
			BaseFlow.pageModel.getCheckoutRadioBtnRut().click();
			BaseFlow.pageModel.getCheckoutInputRut().sendKeys(nDcto);
			break;
		}

	}

	public static void ingresoDatosDespachoTienda(String tipoEntrega, String tipoDespacho,String tipoUbicacion, String ubicacion,
			String direccion, String numeroCasaDepto, String cdgPostal, String region, String comuna, String calle,
			String numeroCalle) {

		switch (tipoEntrega) {
		case "Despacho a domicilio":
			if (tipoUbicacion.equals("Manual")) {
				BaseFlow.pageModel.getCheckoutBtnDireccionManual().click();
				BaseFlow.pageModel.getCheckoutInputDireccionDespacho().sendKeys(direccion);
				BaseFlow.pageModel.getCheckoutInputNumCasaDepartamento().sendKeys(numeroCasaDepto);
				BaseFlow.pageModel.getCheckoutInputCodPostal().sendKeys(cdgPostal);
				Select checkoutRegion = new Select(BaseFlow.pageModel.getCheckoutSelectRegion());
				checkoutRegion.selectByVisibleText(region);
				Select checkoutComuna = new Select(BaseFlow.pageModel.getCheckoutSelectComuna());
				checkoutComuna.selectByVisibleText(comuna);
				BaseFlow.pageModel.getCheckoutInputCalle().sendKeys(calle);
				BaseFlow.pageModel.getCheckoutInputNumero().sendKeys(numeroCalle);
			} else {
				BaseFlow.pageModel.getCheckoutInputIntroduceUbicacion().sendKeys(ubicacion);
				BaseFlow.pageModel.getCheckoutInputDireccionDespacho().sendKeys(direccion);
				BaseFlow.pageModel.getCheckoutInputNumCasaDepartamento().sendKeys(numeroCasaDepto);
				BaseFlow.pageModel.getCheckoutInputCodPostal().sendKeys(cdgPostal);
			}

			break;

		case "Retiro en tienda":
				
			break;

		}

	}

	public static void ingresoDatosMetodoPago(String metodoPago, String nombre, String apellido, String nTarjeta,
			String fechaMes, String fechaAno, String cvv, String nCuotas, String guardarTarjeta,
			String TipoTarjetaCenco, String rut) {

		switch (metodoPago) {
		 
		case "T.Cencosud Visa o MasterCard":
//			BaseFlow.pageModel.getCheckoutInputNombre().sendKeys(nombre);
//			BaseFlow.pageModel.getCheckoutInputApellido().sendKeys(apellido);
//			BaseFlow.pageModel.getCheckoutInputNumTarjeta().sendKeys(nTarjeta);
//			BaseFlow.pageModel.getCheckoutInputFechaMes().sendKeys(fechaMes);
//			BaseFlow.pageModel.getCheckoutInputFechaAno().sendKeys(fechaAno);
//			BaseFlow.pageModel.getCheckoutInputCvv().sendKeys(cvv);
//			Select numeroCuotas = new Select(BaseFlow.pageModel.getCheckoutSelectNumCuotas());
//			numeroCuotas.selectByVisibleText(nCuotas);
			if (guardarTarjeta.equals("true")) {
//				BaseFlow.pageModel.getCheckoutRadioBtnGuardarTarjeta.click(); radio guardar tarjeta
			}
//			BaseFlow.pageModel.getCheckoutBtnDireccionManual().click(); boton pagar
			break;

		case "Tarjeta Cencosud":
//			BaseFlow.pageModel.getCheckoutBtnDireccionManual().click(); boton pagar
			break;
		
		case "Tarjeta de Credito":
//			BaseFlow.pageModel.getCheckoutInputNombre().sendKeys(nombre);
//			BaseFlow.pageModel.getCheckoutInputApellido().sendKeys(apellido);
//			BaseFlow.pageModel.getCheckoutInputNumTarjeta().sendKeys(nTarjeta);
//			BaseFlow.pageModel.getCheckoutInputFechaMes().sendKeys(fechaMes);
//			BaseFlow.pageModel.getCheckoutInputFechaAno().sendKeys(fechaAno);
//			BaseFlow.pageModel.getCheckoutInputCvv().sendKeys(cvv);
//			Select numeroCuotas = new Select(BaseFlow.pageModel.getCheckoutSelectNumCuotas());
//			numeroCuotas.selectByVisibleText(nCuotas);
			if (guardarTarjeta.equals("true")) {
//				BaseFlow.pageModel.getCheckoutRadioBtnGuardarTarjeta.click(); radio guardar tarjeta
			}
//			BaseFlow.pageModel.getCheckoutBtnDireccionManual().click(); boton pagar
			break;
			
		case "RedCompra":
//			BaseFlow.pageModel.getCheckoutBtnDireccionManual().click(); boton pagar
			break;

		}

	}

}
