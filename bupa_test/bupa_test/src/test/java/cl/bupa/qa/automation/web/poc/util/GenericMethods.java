package cl.bupa.qa.automation.web.poc.util;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.jboss.netty.handler.timeout.TimeoutException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.openqa.selenium.NoSuchElementException;

public final class GenericMethods {	
	
	/**
	 * <b>Nombre:</b> waitTime</br>
	 * </br>
	 * <b>Description:</b> Método para esperar un objeto cierto tiempo hasta que este se encuentre desplegado
	 * 
	 * @param driver
	 */
    public static void waitTime(WebElement object) throws InterruptedException {
        int i = 0;
        do {
            Thread.sleep(i + 1);
        } while (object.isDisplayed() == false);
    }
    
	public static void scrollClickElement(WebDriver driver, WebElement element) {
		try {
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * <b>Nombre:</b> cerrarProcesoWebDriver</br>
	 * </br>
	 * <b>Description:</b> Método cerrar proceso WebDriver 
	 * 
	 * @param driver
	 */
	public static void cerrarProcesoWebDriver(WebDriver driver)
	{
		driver.quit();
	}
	
	/**
	 * <b>Nombre:</b> isElementPresent</br>
	 * </br>
	 * <b>Description:</b> Verifica la existencia de un elemento
	 * 
	 * @param {@link
	 * 			WebElement} Objeto de tipo WebElement a buscar
	 * @return {@link Boolean} Retorna <b>True</b> si el elemento es encontrado, de lo contrario retorna <b>False</b>
	 **/
	public static boolean isElementPresent(WebElement webElement) {
		boolean resp = false;
		try {
			resp = webElement.isDisplayed();
		} catch (NoSuchElementException e) {
			resp = false;
		}
		return resp;
	}

	/**
	 * <b>Nombre:</b> isNotElementPresent</br>
	 * </br>
	 * <b>Description:</b> Verifica que no exista un elemento
	 * 
	 * @param {@link
	 * 			WebElement} Objeto de tipo WebElement a buscar
	 * @return {@link Boolean} Retorna <b>True</b> si el elemento es encontrado, de lo contrario retorna <b>False</b>
	 **/
	public static boolean isNotElementPresent(WebElement webElement) {
		boolean resp = false;
		try {
			resp = webElement.isDisplayed();
		} catch (NoSuchElementException e) {
			resp = true;
		}
		return resp;
	}
	
	/**
	 * <b>Nombre:</b> isElementPresentString</br>
	 * </br>
	 * <b>Description:</b> Verifica la existencia de un elemento
	 * 
	 * @param {@link
	 * 			WebElement} Objeto de tipo WebElement a buscar
	 * @return {@link Boolean} Retorna <b>True</b> si el elemento es encontrado, de lo contrario retorna <b>False</b>
	 **/
	public static boolean isElementPresentString(String texto) {
		boolean resp = false;
		try {
			resp = !texto.isEmpty();
		} catch (NoSuchElementException e) {
			resp = false;
		}
		return resp;
	}
	
	/**
	 * <b>Nombre:</b> isClickable</br>
	 * </br>
	 * <b>Description:</b> Verifica cuando un elemento se encuentra visible y habilitado para poder hacer click
	 * 
	 * @param {@link
	 * 			WebElement} Objeto de tipo WebElement a buscar
	 * @return {@link Boolean} Retorna <b>True</b> si el elemento es encontrado, de lo contrario retorna <b>False</b>
	 **/
	public static boolean isClickable(WebElement element, WebDriver driver) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 5);
			wait.until(ExpectedConditions.elementToBeClickable(element));
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	/**
	 * <b>Nombre:</b> getCurrentMonthAndYear</br>
	 * </br>
	 * <b>Description:</b> Retorna el mes y año actual
	 * 
	 * @return {@link String} Retorna <b>Mes y Año</b> actual
	 **/	
	public static String getCurrentMonthAndYear() {
		int month = 0;
		int year = 0;				
		String stringMonth = "";		
		//obtener año
	    Calendar calendar = Calendar.getInstance();
	    year = calendar.get(Calendar.YEAR);
	    month = calendar.get(Calendar.MONTH);
	    if(month == 0){
	    	stringMonth = "Enero";
	    }
	    else if(month == 1){
	    	stringMonth = "Febrero";
	    }
	    else if(month == 2){
	    	stringMonth = "Marzo";
	    }
	    else if(month == 3){
	    	stringMonth = "Abril";
	    }
	    else if(month == 4){
	    	stringMonth = "Mayo";
	    }
	    else if(month == 5){
	    	stringMonth = "Junio";
	    }
	    else if(month == 6){
	    	stringMonth = "Julio";
	    }
	    else if(month == 7){
	    	stringMonth = "Agosto";
	    }
	    else if(month == 8){
	    	stringMonth = "Septiembre";
	    }
	    else if(month == 9){
	    	stringMonth = "Octubre";
	    }
	    else if(month == 10){
	    	stringMonth = "Noviembre";
	    }
	    else if(month == 11){
	    	stringMonth = "Diciembre";
	    }
	    else {
	    	stringMonth = "MM";
	    }
	    return stringMonth+" de "+year;	    	
	}
	
	public static String getCurrentDateComplete() {
		int day = 0;
		int month = 0;
		int year = 0;
		Date fecha = new Date();	
		String stringDay = "";
		String stringMonth = "";			
		//obtener año
	    Calendar calendar = Calendar.getInstance();
	    year = calendar.get(Calendar.YEAR);
	    month = calendar.get(Calendar.MONTH);
	    //obtener mes
	    if(month == 0){
	    	stringMonth = "enero";
	    }
	    else if(month == 1){
	    	stringMonth = "febrero";
	    }
	    else if(month == 2){
	    	stringMonth = "marzo";
	    }
	    else if(month == 3){
	    	stringMonth = "abril";
	    }
	    else if(month == 4){
	    	stringMonth = "mayo";
	    }
	    else if(month == 5){
	    	stringMonth = "junio";
	    }
	    else if(month == 6){
	    	stringMonth = "julio";
	    }
	    else if(month == 7){
	    	stringMonth = "agosto";
	    }
	    else if(month == 8){
	    	stringMonth = "septiembre";
	    }
	    else if(month == 9){
	    	stringMonth = "octubre";
	    }
	    else if(month == 10){
	    	stringMonth = "noviembre";
	    }
	    else if(month == 11){
	    	stringMonth = "diciembre";
	    }
	    else {
	    	stringMonth = "MM";
	    }
	    month = fecha.getDate();	    
	    //obtener dia
	    day = fecha.getDay();
	    if(day == 0){
	    	stringDay = "Domingo";
	    }
	    else if(day == 1){
	    	stringDay = "Lunes";
	    }
	    else if(day == 2){
	    	stringDay = "Martes";
	    }
	    else if(day == 3){
	    	stringDay = "Miércoles";
	    }
	    else if(day == 4){
	    	stringDay = "Jueves";
	    }
	    else if(day == 5){
	    	stringDay = "Viernes";
	    }
	    else if(day == 6){
	    	stringDay = "Sábado";
	    }
	    else{
	    	stringDay = "DD";
	    }
	    return stringDay+", "+month+" de "+stringMonth+" de "+ year;
	}
	
	/**
	 * <b>Nombre:</b> getRangeOfWeekdays</br>
	 * </br>
	 * <b>Description:</b> Retorna el día inicial y el final (rango de 7 días) correspondiente a una semana
	 * 
	 * @return {@link String} Retorna <b>Día inicial y final de una rango de 7 días</b> de la semana
	 **/
	public static String getRangeOfWeekdays() {
		int today = 0;
		int dayFutureFinally = 0;
		Calendar calendar = Calendar.getInstance();
		today = calendar.get(Calendar.DAY_OF_MONTH);
	    Calendar dayFuture = Calendar.getInstance();
	    dayFuture.add(Calendar.DATE, 6);
	    dayFutureFinally = dayFuture.get(Calendar.DAY_OF_MONTH);	    
	    return "Semana del "+today+" al "+dayFutureFinally;
	}
	
	public static Date addDays() {
		GregorianCalendar c = new GregorianCalendar();
		c.add(GregorianCalendar.DATE, 6);			
		return c.getTime();
	}
	
	/**
	 * <b>Nombre:</b> esperaElementoWebSegundos</br>
	 * </br>
	 * <b>Description:</b> Tiempo explicito para verificar cuando un elemento se encuentra visible y se logra hacer click
	 * 
	 * @param {@link
	 * 			WebDriver} Objeto WebDriver
	 * @param {@link
	 * 			WebElement} Objeto de tipo WebElement a buscar
	 * @param {@link
	 * 			int} Tiempo explicito 
	 * @return {@link Boolean} Retorna <b>True</b> Cuando el elemento es visible y se logra hacer click, de lo contrario retorna <b>False</b>
	 **/
	public static boolean esperaElementoWebSegundos(WebDriver driver, WebElement webElement, int segundos) {
		WebDriverWait wait = new WebDriverWait(driver, segundos);
		try {
			wait.until(ExpectedConditions.elementToBeClickable(webElement));
			return true;
		} catch (TimeoutException e) {
			return false;
		}
	}
}