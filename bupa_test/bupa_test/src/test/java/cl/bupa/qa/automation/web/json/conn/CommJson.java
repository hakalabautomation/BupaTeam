package cl.bupa.qa.automation.web.json.conn;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class CommJson {

	private URL url = null;
	private URLConnection urlOC = null;
	private StringBuilder builder = null;	

	/**
	 * Function: getJson Description: Accesa al servicio Rest mediante la Url
	 * entregada
	 * 
	 * @param String
	 *            urlSrv
	 * @return void
	 **/
	public void setConn(String urlSrv) {

		try {
			url = new URL(urlSrv);
			urlOC = url.openConnection();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Function: getJsonData Description: Retorna una cadena con formato JSON
	 * 
	 * @param void
	 * @return String
	 **/
	public String getJsonData() throws IOException {
		String line;
		builder = new StringBuilder();
		BufferedReader bfr = new BufferedReader(new InputStreamReader(urlOC.getInputStream()));
		while ((line = bfr.readLine()) != null) {
			builder.append(line);
		}
		return builder.toString();
	}

	/**
	 * Function: getResponseCode Description: Retorna el codigo de respuesta
	 * http
	 * 
	 * @param void
	 * @return int
	 **/
	public int getResponseCode() throws IOException {
		HttpURLConnection httpConnection = (HttpURLConnection) urlOC;
		return httpConnection.getResponseCode();
	}

	/**
	 * Setear parametros para servicios que van por POST
	 * 
	 * @param parametros
	 *            Patrametros que recibe por via POST
	 */
	public void postParametros(String parametros) {
		try {
			DataOutputStream wr = new DataOutputStream(urlOC.getOutputStream());
			wr.writeBytes(parametros);
			wr.flush();
			wr.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Setear metodo a utilizar como GET o POST, etc
	 * 
	 * @param metodo
	 *            Metodo a utilizar
	 */
	public void setRequestMethod(String metodo) {
		try {
			((HttpURLConnection) urlOC).setRequestMethod(metodo);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Setear parametros de header
	 * 
	 * @param key
	 * @param value
	 */
	public void setRequestProperty(String key, String value) {
		try {
			urlOC.setRequestProperty(key, value);
			urlOC.setDoOutput(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}		
}
