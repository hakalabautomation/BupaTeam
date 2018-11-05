package cl.bupa.qa.automation.web.properties;

import java.io.InputStream;
import java.util.Properties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PropertiesInit {

	private static final Logger LOGGER = LoggerFactory.getLogger(PropertiesInit.class);
	/*** PAGINA WEB ***/
	private String labelTituloLogin;
	private String labelUsuario;
	private String labelContraseña;
	private String labelIniciarSesion;
	private String labelIngresarClaveDinamica;
	private String labelValidarClaveDinamica;
	private String labelVolver;
	private String labelSubTitulo;
	private String labelInicio;
	private String labelAsignados;
	private String labelPromociones;
	private String labelCBClic;
	private String labelConfiguracion;
	private String labelCerrarSesion;
	private String labelPacientes;
	private String labelPaciente;
	private String labelRut;
	private String labelPrevision;
	private String labelMensajeRutNoValido;
	private String labelMensajeRutNoExiste;
	private String labelMensajeSinPrevision;
	private String labelEditarInformacionPaciente;
	private String labelTituloNuevaReserva;
	private String labelEspecialidad;
	private String labelMedicos;
	private String labelExamenes;
	private String labelCamposObligatorios;
	private String labelPrestacion;
	private String labelNombreDelMedico;
	private String labelEspecialidadTwo;
	private String labelRegion;
	private String labelComuna;
	private String labelCentroMedico;
	private String labelDisponibilidadDeHorasMedico;
	private String labelHorarioMañana;
	private String labelHorarioTarde;
	private String labelBusquedaAvanzada;
	private String labelSeleccionMesSemana;
	private String labelLeerIndicaciones;
	private String labelAnularCita;
	private String labelMensajeDeAnulacion;
	private String labelMensajeDeReservaExito;
	private String labelMensajeDeHoraNoAgendada;
	private String labelMensajeIngreseUsuario;
	private String labelMensajeUsuarioNoRegistradoSap;
	private String labelHoraYaNoSeEncuentraDisponible;
	private String labelRutNoEncontradoCrearPaciente;
	private String labelSiPacienteSeEncuentraRegistradoRevisarRut;
	private String labelEditarDatosPaciente;
	private String labelRutDatosPaciente;
	private String labelNombres;
	private String labelApellidos;
	private String labelFechaDeNacimiento;
	private String labelGenero;
	private String labelPrevisionDatosPaciente;
	private String labelCorreo;
	private String labelTelefono;
	private String labelNacionalidad;
	private String labelDireccion;
	private String labelDatosGuardados;
	private String labelNuevaReservaDeHora;
	private String labelPorGestionar;
	private String labelLoGestionado;
	private String labelOrdenMedica;
	private String labelPrestacionTwo;
	private String labelFecha;
	private String labelProfesional;
	private String labelPrestador;
	private String labelHora;
	private String labelProximaHora;
	private String labelCopago;
	private String labelAgendarHora;
	private String labelMasHoras;
	private String labelAnular;
	private String labelHeLeidoLasIndicaciones;
	private String labelAnularReserva;
	private String labelAnularReservaDeHora;
	private String labelCancelar;
	private String labelAceptar;
	private String labelAgendar;
	private String labelNoAgendable;
	private String labelLeerIndicacionesTwo;
	private String labelNoHayDisponibilidadProximosSieteDias;
	private String labelEnviarIndicaciones;
	private String labelRechazarAsesoria;
	private String labelPrestacionSinIndicaciones;
	private String labelNoSeEnvioEmail;
	private String labelPrestacionNoTieneIndicacionesAsociadas;
	private String labelExito;
	/*** SERVICIO ***/
	private String labelMensajeRutNoExisteService;
	private String labelMensajeRutExisteService;
	private String labelTipoAceptadoService;
	private String labelTipoAceptadoServiceTwo;
	
	public PropertiesInit() {
		Properties parametros = new Properties();
		String propFileName = "config/config.properties";
		InputStream inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);
		
		try {
			parametros.load(inputStream);
			labelTituloLogin = parametros.getProperty("labelTituloLogin");
			labelUsuario = parametros.getProperty("labelUsuario");
			labelContraseña = parametros.getProperty("labelContraseña");
			labelIniciarSesion = parametros.getProperty("labelIniciarSesion");
			labelIngresarClaveDinamica = parametros.getProperty("labelIngresarClaveDinamica");
			labelValidarClaveDinamica = parametros.getProperty("labelValidarClaveDinamica");
			labelVolver = parametros.getProperty("labelVolver");
			labelSubTitulo = parametros.getProperty("labelSubTitulo");
			labelInicio = parametros.getProperty("labelInicio");
			labelAsignados = parametros.getProperty("labelAsignados");
			labelPromociones = parametros.getProperty("labelPromociones");
			labelCBClic = parametros.getProperty("labelCBClic");
			labelConfiguracion = parametros.getProperty("labelConfiguracion");
			labelCerrarSesion = parametros.getProperty("labelCerrarSesion");
			labelPacientes = parametros.getProperty("labelPacientes");
			labelPaciente = parametros.getProperty("labelPaciente");
			labelRut = parametros.getProperty("labelRut");
			labelPrevision = parametros.getProperty("labelPrevision");
			labelMensajeRutNoValido = parametros.getProperty("labelMensajeRutNoValido");
			labelMensajeRutNoExiste = parametros.getProperty("labelMensajeRutNoExiste");
			labelMensajeSinPrevision = parametros.getProperty("labelMensajeSinPrevision");
			labelEditarInformacionPaciente = parametros.getProperty("labelEditarInformacionPaciente");
			labelTituloNuevaReserva = parametros.getProperty("labelTituloNuevaReserva");
			labelEspecialidad = parametros.getProperty("labelEspecialidad");
			labelMedicos = parametros.getProperty("labelMedicos");
			labelExamenes = parametros.getProperty("labelExamenes");
			labelCamposObligatorios = parametros.getProperty("labelCamposObligatorios");
			labelNombreDelMedico = parametros.getProperty("labelNombreDelMedico");
			labelEspecialidadTwo = parametros.getProperty("labelEspecialidadTwo");
			labelPrestacion = parametros.getProperty("labelPrestacion");			
			labelRegion = parametros.getProperty("labelRegion");
			labelComuna = parametros.getProperty("labelComuna");
			labelCentroMedico = parametros.getProperty("labelCentroMedico");
			labelDisponibilidadDeHorasMedico = parametros.getProperty("labelDisponibilidadDeHorasMedico");
			labelHorarioMañana = parametros.getProperty("labelHorarioMañana");
			labelHorarioTarde = parametros.getProperty("labelHorarioTarde");
			labelBusquedaAvanzada = parametros.getProperty("labelBusquedaAvanzada");
			labelSeleccionMesSemana = parametros.getProperty("labelSeleccionMesSemana");
			labelLeerIndicaciones = parametros.getProperty("labelLeerIndicaciones");
			labelAnularCita = parametros.getProperty("labelAnularCita");
			labelMensajeDeAnulacion = parametros.getProperty("labelMensajeDeAnulacion");
			labelMensajeDeReservaExito = parametros.getProperty("labelMensajeDeReservaExito");
			labelMensajeDeHoraNoAgendada = parametros.getProperty("labelMensajeDeHoraNoAgendada");
			labelMensajeIngreseUsuario = parametros.getProperty("labelMensajeIngreseUsuario");
			labelMensajeUsuarioNoRegistradoSap = parametros.getProperty("labelMensajeUsuarioNoRegistradoSap");
			labelHoraYaNoSeEncuentraDisponible = parametros.getProperty("labelHoraYaNoSeEncuentraDisponible");
			labelRutNoEncontradoCrearPaciente = parametros.getProperty("labelRutNoEncontradoCrearPaciente");			
			labelSiPacienteSeEncuentraRegistradoRevisarRut = parametros.getProperty("labelSiPacienteSeEncuentraRegistradoRevisarRut");
			labelEditarDatosPaciente = parametros.getProperty("labelEditarDatosPaciente");
			labelRutDatosPaciente = parametros.getProperty("labelRutDatosPaciente");
			labelNombres = parametros.getProperty("labelNombres");
			labelApellidos = parametros.getProperty("labelApellidos");
			labelFechaDeNacimiento = parametros.getProperty("labelFechaDeNacimiento");
			labelGenero = parametros.getProperty("labelGenero");
			labelPrevisionDatosPaciente = parametros.getProperty("labelPrevisionDatosPaciente");
			labelCorreo = parametros.getProperty("labelCorreo");
			labelTelefono = parametros.getProperty("labelTelefono");
			labelNacionalidad = parametros.getProperty("labelNacionalidad");
			labelDireccion = parametros.getProperty("labelDireccion");
			labelDatosGuardados = parametros.getProperty("labelDatosGuardados");
			labelNuevaReservaDeHora = parametros.getProperty("labelNuevaReservaDeHora");
			labelPorGestionar = parametros.getProperty("labelPorGestionar");
			labelLoGestionado = parametros.getProperty("labelLoGestionado");
			labelOrdenMedica = parametros.getProperty("labelOrdenMedica");
			labelPrestacionTwo = parametros.getProperty("labelPrestacionTwo");
			labelFecha = parametros.getProperty("labelFecha");
			labelProfesional = parametros.getProperty("labelProfesional");
			labelPrestador = parametros.getProperty("labelPrestador");
			labelHora = parametros.getProperty("labelHora");
			labelProximaHora = parametros.getProperty("labelProximaHora");
			labelCopago = parametros.getProperty("labelCopago");
			labelAgendarHora = parametros.getProperty("labelAgendarHora");
			labelMasHoras = parametros.getProperty("labelMasHoras");
			labelAnular = parametros.getProperty("labelAnular");
			labelHeLeidoLasIndicaciones = parametros.getProperty("labelHeLeidoLasIndicaciones");
			labelAnularReserva = parametros.getProperty("labelAnularReserva");
			labelAnularReservaDeHora = parametros.getProperty("labelAnularReservaDeHora");
			labelCancelar = parametros.getProperty("labelCancelar");
			labelAceptar = parametros.getProperty("labelAceptar");
			labelAgendar = parametros.getProperty("labelAgendar");
			labelNoAgendable = parametros.getProperty("labelNoAgendable");
			labelLeerIndicacionesTwo = parametros.getProperty("labelLeerIndicacionesTwo");
			labelNoHayDisponibilidadProximosSieteDias = parametros.getProperty("labelNoHayDisponibilidadProximosSieteDias");
			labelEnviarIndicaciones = parametros.getProperty("labelEnviarIndicaciones");
			labelRechazarAsesoria = parametros.getProperty("labelRechazarAsesoria");
			labelPrestacionSinIndicaciones = parametros.getProperty("labelPrestacionSinIndicaciones");
			labelNoSeEnvioEmail = parametros.getProperty("labelNoSeEnvioEmail");
			labelPrestacionNoTieneIndicacionesAsociadas = parametros.getProperty("labelPrestacionNoTieneIndicacionesAsociadas");
			labelExito = parametros.getProperty("labelExito");
			labelMensajeRutNoExisteService = parametros.getProperty("labelMensajeRutNoExisteService");
			labelMensajeRutExisteService = parametros.getProperty("labelMensajeRutExisteService");
			labelTipoAceptadoService = parametros.getProperty("labelTipoAceptadoService");
			labelTipoAceptadoServiceTwo = parametros.getProperty("labelTipoAceptadoServiceTwo");
		} catch (Exception e) {
			LOGGER.info(e.toString());
		}
	}	

	public String getLabelTituloLogin() {
		return labelTituloLogin;
	}

	public void setLabelTituloLogin(String labelTituloLogin) {
		this.labelTituloLogin = labelTituloLogin;
	}

	public String getLabelUsuario() {
		return labelUsuario;
	}

	public void setLabelUsuario(String labelUsuario) {
		this.labelUsuario = labelUsuario;
	}

	public String getLabelContraseña() {
		return labelContraseña;
	}

	public void setLabelContraseña(String labelContraseña) {
		this.labelContraseña = labelContraseña;
	}

	public String getLabelIniciarSesion() {
		return labelIniciarSesion;
	}

	public void setLabelIniciarSesion(String labelIniciarSesion) {
		this.labelIniciarSesion = labelIniciarSesion;
	}
	
	public String getLabelIngresarClaveDinamica() {
		return labelIngresarClaveDinamica;
	}

	public void setLabelIngresarClaveDinamica(String labelIngresarClaveDinamica) {
		this.labelIngresarClaveDinamica = labelIngresarClaveDinamica;
	}

	public String getLabelValidarClaveDinamica() {
		return labelValidarClaveDinamica;
	}

	public void setLabelValidarClaveDinamica(String labelValidarClaveDinamica) {
		this.labelValidarClaveDinamica = labelValidarClaveDinamica;
	}

	public String getLabelVolver() {
		return labelVolver;
	}

	public void setLabelVolver(String labelVolver) {
		this.labelVolver = labelVolver;
	}

	public String getLabelSubTitulo() {
		return labelSubTitulo;
	}

	public void setLabelSubTitulo(String labelSubTitulo) {
		this.labelSubTitulo = labelSubTitulo;
	}

	public String getLabelInicio() {
		return labelInicio = "Inicio";
	}

	public void setLabelInicio(String labelInicio) {
		this.labelInicio = labelInicio;
	}

	public String getLabelAsignados() {
		return labelAsignados;
	}

	public void setLabelAsignados(String labelAsignados) {
		this.labelAsignados = labelAsignados;
	}

	public String getLabelPromociones() {
		return labelPromociones;
	}

	public void setLabelPromociones(String labelPromociones) {
		this.labelPromociones = labelPromociones;
	}

	public String getLabelCBClic() {
		return labelCBClic;
	}

	public void setLabelCBClic(String labelCBClic) {
		this.labelCBClic = labelCBClic;
	}

	public String getLabelConfiguracion() {
		return labelConfiguracion;
	}

	public void setLabelConfiguracion(String labelConfiguracion) {
		this.labelConfiguracion = labelConfiguracion;
	}

	public String getLabelCerrarSesion() {
		return labelCerrarSesion;
	}

	public void setLabelCerrarSesion(String labelCerrarSesion) {
		this.labelCerrarSesion = labelCerrarSesion;
	}

	public String getLabelPacientes() {
		return labelPacientes;
	}

	public void setLabelPacientes(String labelPacientes) {
		this.labelPacientes = labelPacientes;
	}

	public String getLabelPaciente() {
		return labelPaciente;
	}

	public void setLabelPaciente(String labelPaciente) {
		this.labelPaciente = labelPaciente;
	}

	public String getLabelRut() {
		return labelRut;
	}

	public void setLabelRut(String labelRut) {
		this.labelRut = labelRut;
	}

	public String getLabelPrevision() {
		return labelPrevision;
	}

	public void setLabelPrevision(String labelPrevision) {
		this.labelPrevision = labelPrevision;
	}

	public String getLabelMensajeRutNoValido() {
		return labelMensajeRutNoValido;
	}

	public void setLabelMensajeRutNoValido(String labelMensajeRutNoValido) {
		this.labelMensajeRutNoValido = labelMensajeRutNoValido;
	}

	public String getLabelMensajeRutNoExiste() {
		return labelMensajeRutNoExiste;
	}

	public void setLabelMensajeRutNoExiste(String labelMensajeRutNoExiste) {
		this.labelMensajeRutNoExiste = labelMensajeRutNoExiste;
	}

	public String getLabelMensajeSinPrevision() {
		return labelMensajeSinPrevision;
	}

	public void setLabelMensajeSinPrevision(String labelMensajeSinPrevision) {
		this.labelMensajeSinPrevision = labelMensajeSinPrevision;
	}
	
	public String getLabelEditarInformacionPaciente() {
		return labelEditarInformacionPaciente;
	}

	public void setLabelEditarInformacionPaciente(String labelEditarInformacionPaciente) {
		this.labelEditarInformacionPaciente = labelEditarInformacionPaciente;
	}

	public String getLabelTituloNuevaReserva() {
		return labelTituloNuevaReserva;
	}

	public void setLabelTituloNuevaReserva(String labelTituloNuevaReserva) {
		this.labelTituloNuevaReserva = labelTituloNuevaReserva;
	}

	public String getLabelEspecialidad() {
		return labelEspecialidad;
	}

	public void setLabelEspecialidad(String labelEspecialidad) {
		this.labelEspecialidad = labelEspecialidad;
	}

	public String getLabelMedicos() {
		return labelMedicos;
	}

	public void setLabelMedicos(String labelMedicos) {
		this.labelMedicos = labelMedicos;
	}

	public String getLabelExamenes() {
		return labelExamenes;
	}

	public void setLabelExamenes(String labelExamenes) {
		this.labelExamenes = labelExamenes;
	}

	public String getLabelCamposObligatorios() {
		return labelCamposObligatorios;
	}

	public void setLabelCamposObligatorios(String labelCamposObligatorios) {
		this.labelCamposObligatorios = labelCamposObligatorios;
	}

	public String getLabelPrestacion() {
		return labelPrestacion;
	}

	public void setLabelPrestacion(String labelPrestacion) {
		this.labelPrestacion = labelPrestacion;
	}
	
	public String getLabelNombreDelMedico() {
		return labelNombreDelMedico;
	}

	public void setLabelNombreDelMedico(String labelNombreDelMedico) {
		this.labelNombreDelMedico = labelNombreDelMedico;
	}

	public String getLabelEspecialidadTwo() {
		return labelEspecialidadTwo;
	}

	public void setLabelEspecialidadTwo(String labelEspecialidadTwo) {
		this.labelEspecialidadTwo = labelEspecialidadTwo;
	}
	
	public String getLabelRegion() {
		return labelRegion;
	}

	public void setLabelRegion(String labelRegion) {
		this.labelRegion = labelRegion;
	}

	public String getLabelComuna() {
		return labelComuna;
	}

	public void setLabelComuna(String labelComuna) {
		this.labelComuna = labelComuna;
	}

	public String getLabelCentroMedico() {
		return labelCentroMedico;
	}

	public void setLabelCentroMedico(String labelCentroMedico) {
		this.labelCentroMedico = labelCentroMedico;
	}	

	public String getLabelDisponibilidadDeHorasMedico() {
		return labelDisponibilidadDeHorasMedico;
	}

	public void setLabelDisponibilidadDeHorasMedico(String labelDisponibilidadDeHorasMedico) {
		this.labelDisponibilidadDeHorasMedico = labelDisponibilidadDeHorasMedico;
	}

	public String getLabelHorarioMañana() {
		return labelHorarioMañana;
	}

	public void setLabelHorarioMañana(String labelHorarioMañana) {
		this.labelHorarioMañana = labelHorarioMañana;
	}

	public String getLabelHorarioTarde() {
		return labelHorarioTarde;
	}

	public void setLabelHorarioTarde(String labelHorarioTarde) {
		this.labelHorarioTarde = labelHorarioTarde;
	}	
	
	public String getLabelBusquedaAvanzada() {
		return labelBusquedaAvanzada;
	}

	public void setLabelBusquedaAvanzada(String labelBusquedaAvanzada) {
		this.labelBusquedaAvanzada = labelBusquedaAvanzada;
	}

	public String getLabelSeleccionMesSemana() {
		return labelSeleccionMesSemana;
	}

	public void setLabelSeleccionMesSemana(String labelSeleccionMesSemana) {
		this.labelSeleccionMesSemana = labelSeleccionMesSemana;
	}

	public String getLabelMensajeRutNoExisteService() {
		return labelMensajeRutNoExisteService;
	}

	public void setLabelMensajeRutNoExisteService(String labelMensajeRutNoExisteService) {
		this.labelMensajeRutNoExisteService = labelMensajeRutNoExisteService;
	}
	
	public String getLabelMensajeRutExisteService() {
		return labelMensajeRutExisteService;
	}

	public void setLabelMensajeRutExisteService(String labelMensajeRutExisteService) {
		this.labelMensajeRutExisteService = labelMensajeRutExisteService;
	}	

	public String getLabelLeerIndicaciones() {
		return labelLeerIndicaciones;
	}

	public void setLabelLeerIndicaciones(String labelLeerIndicaciones) {
		this.labelLeerIndicaciones = labelLeerIndicaciones;
	}
	
	public String getLabelAnularCita() {
		return labelAnularCita;
	}

	public void setLabelAnularCita(String labelAnularCita) {
		this.labelAnularCita = labelAnularCita;
	}

	public String getLabelMensajeDeAnulacion() {
		return labelMensajeDeAnulacion;
	}

	public void setLabelMensajeDeAnulacion(String labelMensajeDeAnulacion) {
		this.labelMensajeDeAnulacion = labelMensajeDeAnulacion;
	}
	
	public String getLabelMensajeDeReservaExito() {
		return labelMensajeDeReservaExito;
	}

	public void setLabelMensajeDeReservaExito(String labelMensajeDeReservaExito) {
		this.labelMensajeDeReservaExito = labelMensajeDeReservaExito;
	}
	
	public String getLabelMensajeDeHoraNoAgendada() {
		return labelMensajeDeHoraNoAgendada;
	}

	public void setLabelMensajeDeHoraNoAgendada(String labelMensajeDeHoraNoAgendada) {
		this.labelMensajeDeHoraNoAgendada = labelMensajeDeHoraNoAgendada;
	}
	
	public String getLabelMensajeIngreseUsuario() {
		return labelMensajeIngreseUsuario;
	}

	public void setLabelMensajeIngreseUsuario(String labelMensajeIngreseUsuario) {
		this.labelMensajeIngreseUsuario = labelMensajeIngreseUsuario;
	}
	
	public String getLabelMensajeUsuarioNoRegistradoSap() {
		return labelMensajeUsuarioNoRegistradoSap;
	}

	public void setLabelMensajeUsuarioNoRegistradoSap(String labelMensajeUsuarioNoRegistradoSap) {
		this.labelMensajeUsuarioNoRegistradoSap = labelMensajeUsuarioNoRegistradoSap;
	}
		
	public String getLabelHoraYaNoSeEncuentraDisponible() {
		return labelHoraYaNoSeEncuentraDisponible;
	}

	public void setLabelHoraYaNoSeEncuentraDisponible(String labelHoraYaNoSeEncuentraDisponible) {
		this.labelHoraYaNoSeEncuentraDisponible = labelHoraYaNoSeEncuentraDisponible;
	}

	public String getLabelTipoAceptadoService() {
		return labelTipoAceptadoService;
	}

	public void setLabelTipoAceptadoService(String labelTipoAceptadoService) {
		this.labelTipoAceptadoService = labelTipoAceptadoService;
	}	
	
	public String getLabelTipoAceptadoServiceTwo() {
		return labelTipoAceptadoServiceTwo;
	}

	public void setLabelTipoAceptadoServiceTwo(String labelTipoAceptadoServiceTwo) {
		this.labelTipoAceptadoServiceTwo = labelTipoAceptadoServiceTwo;
	}

	public String getLabelRutNoEncontradoCrearPaciente() {
		return labelRutNoEncontradoCrearPaciente;
	}

	public void setLabelRutNoEncontradoCrearPaciente(String labelRutNoEncontradoCrearPaciente) {
		this.labelRutNoEncontradoCrearPaciente = labelRutNoEncontradoCrearPaciente;
	}

	public String getLabelSiPacienteSeEncuentraRegistradoRevisarRut() {
		return labelSiPacienteSeEncuentraRegistradoRevisarRut;
	}

	public void setLabelSiPacienteSeEncuentraRegistradoRevisarRut(String labelSiPacienteSeEncuentraRegistradoRevisarRut) {
		this.labelSiPacienteSeEncuentraRegistradoRevisarRut = labelSiPacienteSeEncuentraRegistradoRevisarRut;
	}

	public String getLabelEditarDatosPaciente() {
		return labelEditarDatosPaciente;
	}

	public void setLabelEditarDatosPaciente(String labelEditarDatosPaciente) {
		this.labelEditarDatosPaciente = labelEditarDatosPaciente;
	}
	
	public String getLabelRutDatosPaciente() {
		return labelRutDatosPaciente;
	}

	public void setLabelRutDatosPaciente(String labelRutDatosPaciente) {
		this.labelRutDatosPaciente = labelRutDatosPaciente;
	}

	public String getLabelNombres() {
		return labelNombres;
	}

	public void setLabelNombres(String labelNombres) {
		this.labelNombres = labelNombres;
	}

	public String getLabelApellidos() {
		return labelApellidos;
	}

	public void setLabelApellidos(String labelApellidos) {
		this.labelApellidos = labelApellidos;
	}

	public String getLabelFechaDeNacimiento() {
		return labelFechaDeNacimiento;
	}

	public void setLabelFechaDeNacimiento(String labelFechaDeNacimiento) {
		this.labelFechaDeNacimiento = labelFechaDeNacimiento;
	}

	public String getLabelGenero() {
		return labelGenero;
	}

	public void setLabelGenero(String labelGenero) {
		this.labelGenero = labelGenero;
	}

	public String getLabelPrevisionDatosPaciente() {
		return labelPrevisionDatosPaciente;
	}

	public void setLabelPrevisionDatosPaciente(String labelPrevisionDatosPaciente) {
		this.labelPrevisionDatosPaciente = labelPrevisionDatosPaciente;
	}

	public String getLabelCorreo() {
		return labelCorreo;
	}

	public void setLabelCorreo(String labelCorreo) {
		this.labelCorreo = labelCorreo;
	}

	public String getLabelTelefono() {
		return labelTelefono;
	}

	public void setLabelTelefono(String labelTelefono) {
		this.labelTelefono = labelTelefono;
	}

	public String getLabelNacionalidad() {
		return labelNacionalidad;
	}

	public void setLabelNacionalidad(String labelNacionalidad) {
		this.labelNacionalidad = labelNacionalidad;
	}

	public String getLabelDireccion() {
		return labelDireccion;
	}

	public void setLabelDireccion(String labelDireccion) {
		this.labelDireccion = labelDireccion;
	}
	
	public String getLabelDatosGuardados() {
		return labelDatosGuardados;
	}

	public void setLabelDatosGuardados(String labelDatosGuardados) {
		this.labelDatosGuardados = labelDatosGuardados;
	}	
		
	public String getLabelNuevaReservaDeHora() {
		return labelNuevaReservaDeHora;
	}

	public void setLabelNuevaReservaDeHora(String labelNuevaReservaDeHora) {
		this.labelNuevaReservaDeHora = labelNuevaReservaDeHora;
	}
	
	public String getLabelPorGestionar() {
		return labelPorGestionar;
	}

	public void setLabelPorGestionar(String labelPorGestionar) {
		this.labelPorGestionar = labelPorGestionar;
	}

	public String getLabelLoGestionado() {
		return labelLoGestionado;
	}

	public void setLabelLoGestionado(String labelLoGestionado) {
		this.labelLoGestionado = labelLoGestionado;
	}

	public String getLabelOrdenMedica() {
		return labelOrdenMedica;
	}

	public void setLabelOrdenMedica(String labelOrdenMedica) {
		this.labelOrdenMedica = labelOrdenMedica;
	}

	public String getLabelPrestacionTwo() {
		return labelPrestacionTwo;
	}

	public void setLabelPrestacionTwo(String labelPrestacionTwo) {
		this.labelPrestacionTwo = labelPrestacionTwo;
	}

	public String getLabelFecha() {
		return labelFecha;
	}

	public void setLabelFecha(String labelFecha) {
		this.labelFecha = labelFecha;
	}
	
	public String getLabelProfesional() {
		return labelProfesional;
	}

	public void setLabelProfesional(String labelProfesional) {
		this.labelProfesional = labelProfesional;
	}

	public String getLabelPrestador() {
		return labelPrestador;
	}

	public void setLabelPrestador(String labelPrestador) {
		this.labelPrestador = labelPrestador;
	}

	public String getLabelHora() {
		return labelHora;
	}

	public void setLabelHora(String labelHora) {
		this.labelHora = labelHora;
	}

	public String getLabelProximaHora() {
		return labelProximaHora;
	}

	public void setLabelProximaHora(String labelProximaHora) {
		this.labelProximaHora = labelProximaHora;
	}

	public String getLabelCopago() {
		return labelCopago;
	}

	public void setLabelCopago(String labelCopago) {
		this.labelCopago = labelCopago;
	}

	public String getLabelAgendarHora() {
		return labelAgendarHora;
	}

	public void setLabelAgendarHora(String labelAgendarHora) {
		this.labelAgendarHora = labelAgendarHora;
	}

	public String getLabelMasHoras() {
		return labelMasHoras;
	}

	public void setLabelMasHoras(String labelMasHoras) {
		this.labelMasHoras = labelMasHoras;
	}
	
	public String getLabelAnular() {
		return labelAnular;
	}

	public void setLabelAnular(String labelAnular) {
		this.labelAnular = labelAnular;
	}

	public String getLabelHeLeidoLasIndicaciones() {
		return labelHeLeidoLasIndicaciones;
	}

	public void setLabelHeLeidoLasIndicaciones(String labelHeLeidoLasIndicaciones) {
		this.labelHeLeidoLasIndicaciones = labelHeLeidoLasIndicaciones;
	}

	public String getLabelAnularReserva() {
		return labelAnularReserva;
	}

	public void setLabelAnularReserva(String labelAnularReserva) {
		this.labelAnularReserva = labelAnularReserva;
	}

	public String getLabelAnularReservaDeHora() {
		return labelAnularReservaDeHora;
	}

	public void setLabelAnularReservaDeHora(String labelAnularReservaDeHora) {
		this.labelAnularReservaDeHora = labelAnularReservaDeHora;
	}

	public String getLabelCancelar() {
		return labelCancelar;
	}

	public void setLabelCancelar(String labelCancelar) {
		this.labelCancelar = labelCancelar;
	}

	public String getLabelAceptar() {
		return labelAceptar;
	}

	public void setLabelAceptar(String labelAceptar) {
		this.labelAceptar = labelAceptar;
	}

	public String getLabelAgendar() {
		return labelAgendar;
	}

	public void setLabelAgendar(String labelAgendar) {
		this.labelAgendar = labelAgendar;
	}

	public String getLabelNoAgendable() {
		return labelNoAgendable;
	}

	public void setLabelNoAgendable(String labelNoAgendable) {
		this.labelNoAgendable = labelNoAgendable;
	}

	public String getLabelLeerIndicacionesTwo() {
		return labelLeerIndicacionesTwo;
	}

	public void setLabelLeerIndicacionesTwo(String labelLeerIndicacionesTwo) {
		this.labelLeerIndicacionesTwo = labelLeerIndicacionesTwo;
	}

	public String getLabelNoHayDisponibilidadProximosSieteDias() {
		return labelNoHayDisponibilidadProximosSieteDias;
	}

	public void setLabelNoHayDisponibilidadProximosSieteDias(String labelNoHayDisponibilidadProximosSieteDias) {
		this.labelNoHayDisponibilidadProximosSieteDias = labelNoHayDisponibilidadProximosSieteDias;
	}

	public String getLabelEnviarIndicaciones() {
		return labelEnviarIndicaciones;
	}

	public void setLabelEnviarIndicaciones(String labelEnviarIndicaciones) {
		this.labelEnviarIndicaciones = labelEnviarIndicaciones;
	}

	public String getLabelRechazarAsesoria() {
		return labelRechazarAsesoria;
	}

	public void setLabelRechazarAsesoria(String labelRechazarAsesoria) {
		this.labelRechazarAsesoria = labelRechazarAsesoria;
	}

	public String getLabelPrestacionSinIndicaciones() {
		return labelPrestacionSinIndicaciones;
	}

	public void setLabelPrestacionSinIndicaciones(String labelPrestacionSinIndicaciones) {
		this.labelPrestacionSinIndicaciones = labelPrestacionSinIndicaciones;
	}

	public String getLabelNoSeEnvioEmail() {
		return labelNoSeEnvioEmail;
	}

	public void setLabelNoSeEnvioEmail(String labelNoSeEnvioEmail) {
		this.labelNoSeEnvioEmail = labelNoSeEnvioEmail;
	}

	public String getLabelPrestacionNoTieneIndicacionesAsociadas() {
		return labelPrestacionNoTieneIndicacionesAsociadas;
	}

	public void setLabelPrestacionNoTieneIndicacionesAsociadas(String labelPrestacionNoTieneIndicacionesAsociadas) {
		this.labelPrestacionNoTieneIndicacionesAsociadas = labelPrestacionNoTieneIndicacionesAsociadas;
	}	

	public String getLabelExito() {
		return labelExito;
	}

	public void setLabelExito(String labelExito) {
		this.labelExito = labelExito;
	}

	public static Logger getLogger() {
		return LOGGER;
	}
}
