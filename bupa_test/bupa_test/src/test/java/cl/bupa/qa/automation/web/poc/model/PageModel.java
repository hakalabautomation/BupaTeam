package cl.bupa.qa.automation.web.poc.model;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class PageModel {
	/** LOGIN **/
	/** -- HEADER & BODY -- **/
	// Imagen -- Logo bupa
	@FindBy(how = How.ID, using = "logImghom")
	private WebElement imgLogoBupa;
	
	// Imagen -- Login
	@FindBy(how = How.ID, using = "logImgBup")
	private WebElement imgLogin;
	
	// H1 -- Titulo bupa
	@FindBy(how = How.ID, using = "logTilConPeo")
	private WebElement hOneTituloBupa;
	
	// Label -- Usuario
	@FindBy(how = How.ID, using = "logTextUsu")
	private WebElement lblUsuario;
	
	// Input Text -- Usuario
	@FindBy(how = How.ID, using = "logInpUsu")
	private WebElement txtUsuario;
	
	// Label -- Contraseña
	@FindBy(how = How.ID, using = "logTextPass")
	private WebElement lblContraseña;
	
	// Input Text -- Contraseña
	@FindBy(how = How.ID, using = "logInpPass")
	private WebElement txtContraseña;
	
	// Button -- Iniciar sesion
	@FindBy(how = How.ID, using = "logButIniSes")
	private WebElement btnIniciarSesion;
	
	/** LOGIN - CLAVE DINAMICA **/
	// Div -- Login opt
	@FindBy(how = How.ID, using = "otpLogin")
	private WebElement divLoginOpt;
	
	// Imagen -- Logo 
	@FindBy(how = How.ID, using = "otpLoginImg")
	private WebElement imgLogoBupaOpt;
	
	// Imagen -- Login
	@FindBy(how = How.ID, using = "otpLoginBotHo")
	private WebElement imgLoginOpt;
	
	// H1 -- Titulo bupa
	@FindBy(how = How.ID, using = "otpLoginTitulo")
	private WebElement hOneTituloBupaOpt;

	// Label -- Clave dinamica
	@FindBy(how = How.ID, using = "otpLoginTextClav")
	private WebElement lblClaveDinamicaOpt;
	
	// Input Text -- ClaveDinamica
	@FindBy(how = How.ID, using = "otpLoginInp")
	private WebElement txtClaveDinamicaOpt;

	// Button -- Validar token
	@FindBy(how = How.ID, using = "otpLoginBotVali")
	private WebElement btnValidarTokenOpt;
	
	// Link -- Volver
	@FindBy(how = How.ID, using = "otpLoginBotVelv")
	private WebElement lnkVolverOpt;

	
	/** BUSQUEDA PACIENTE POR RUT - PANTALLA 1 - HOME **/
	/** -- HEADER -- **/
	// Button -- Menu
	@FindBy(how = How.ID, using = "heaBotHam")
	private WebElement btnMenu;

	// Imagen -- Corporativa
	@FindBy(how = How.ID, using = "heaImgBupa")
	private WebElement imgCorporativa;

	// H1 -- SubTitulo
	@FindBy(how = How.ID, using = "heaH1Sub")
	private WebElement hOneSubTitulo;

	// Imagen -- Sesion usuario
	@FindBy(how = How.ID, using = "heaImgUser")
	private WebElement imgSesionUsuario;

	// Parrafo -- Nombre usuario
	@FindBy(how = How.ID, using = "heaNomUser")
	private WebElement pNombreUsuario;

	// Parrafo -- Centro medico
	@FindBy(how = How.ID, using = "heaNameCentMed")
	private WebElement pCentroMedico;

	// Imagen -- Icono notificaciones
	@FindBy(how = How.ID, using = "heaImgNotif")
	private WebElement imgIconoNotificaciones;

	/** -- BODY/SIDEBAR -- **/
	// Imagen -- Icono inicio
	@FindBy(how = How.ID, using = "sidImgHom")
	private WebElement imgIconoInicio;

	// Span -- Inicio
	@FindBy(how = How.ID, using = "sidSpaHom")
	private WebElement spnInicio;

	// Imagen -- Icono asignados
	@FindBy(how = How.ID, using = "sidImgAsi")
	private WebElement imgIconoAsignados;

	// Span -- Asignados
	@FindBy(how = How.ID, using = "sidSpaAsi")
	private WebElement spnAsignados;

	// Imagen -- Icono Promociones
	@FindBy(how = How.ID, using = "sidImgPro")
	private WebElement imgIconoPromociones;

	// Span -- Promociones
	@FindBy(how = How.ID, using = "sidSpaPro")
	private WebElement spnPromociones;

	// Imagen -- Icono CB Clic
	@FindBy(how = How.ID, using = "sidImgCruBlan")
	private WebElement imgIconoCbClic;

	// Span -- CB Clic
	@FindBy(how = How.ID, using = "sidSpaCruBlan")
	private WebElement spnCbClic;

	// Imagen -- Icono Configuracion
	@FindBy(how = How.ID, using = "sidImgCon")
	private WebElement imgIconoConfiguracion;

	// Span -- Configuracion
	@FindBy(how = How.ID, using = "sidSpaCon")
	private WebElement spnConfiguracion;

	// Imagen -- Icono Cerrar sesion
	@FindBy(how = How.ID, using = "sidImgCer")
	private WebElement imgIconoCerrarSesion;

	// Span -- Cerrar sesion
	@FindBy(how = How.ID, using = "sidSpaCer")
	private WebElement spnCerrarSesion;

	/** -- BODY/GENERAL -- **/
	// Div - Menu inicial
	@FindBy(how = How.CLASS_NAME, using = "divMenuInicial")
	private WebElement divMenuInicial;
	
	// Div - Menu inicial principal
	@FindBy(how = How.CLASS_NAME, using = "menuInicial")
	private WebElement divMenuInicialPrincipal;
	
	// Span - fechaActual
	@FindBy(how = How.ID, using = "desSpaFec")
	private WebElement spnFechaActual;

	// Imagen -- Asignados
	@FindBy(how = How.ID, using = "ingRutImgAsig")
	private WebElement imgAsignados;

	// Span --Pacientes
	@FindBy(how = How.ID, using = "ingRutPas")
	private WebElement SpanPacientes;

	// Input Text -- Rut a buscar
	@FindBy(how = How.ID, using = "ingRutimRut")
	private WebElement txtInputRut;

	// Button -- Consultar
	@FindBy(how = How.ID, using = "ingRutBotBus")
	private WebElement btnConsultar;

	// Div -- Paciente encontrado
	@FindBy(how = How.ID, using = "pacEncDivCon")
	private WebElement divPacienteEncontrado;

	// Div -- Ingresar rut valido
	@FindBy(how = How.ID, using = "aleDivErr")
	private WebElement divIngresarRutValido;

	// H6 -- Paciente
	@FindBy(how = How.ID, using = "pacEncTit")
	private WebElement hSixPaciente;

	// Img -- Icono Paciente
	@FindBy(how = How.ID, using = "InfPacIco")
	private WebElement imgIconoPaciente;

	// H5 -- Nombre paciente
	@FindBy(how = How.ID, using = "InfPacNom")
	private WebElement hFiveNombrePaciente;

	// Label -- Genero/Edad paciente
	@FindBy(how = How.ID, using = "InfPacSexFec")
	private WebElement lblGeneroAndEdadPaciente;

	// Label -- Correo paciente
	@FindBy(how = How.ID, using = "InfPacMai")
	private WebElement lblCorreoPaciente;

	// Label -- Telefono paciente
	@FindBy(how = How.ID, using = "InfPacTlf")
	private WebElement lblTelefonoPaciente;

	// Label -- Rut paciente
	@FindBy(how = How.ID, using = "InfPacRut")
	private WebElement lblRutPaciente;

	// Label -- Prevision paciente
	@FindBy(how = How.ID, using = "InfPacPre")
	private WebElement lblPrevisionPaciente;
	
	// Link -- Editar informacion paciente
	@FindBy(how = How.ID, using = "pacEncEditPac")
	private WebElement lnkEditarInformacionPaciente;

	// Button -- Nueva reserva hora
	@FindBy(how = How.ID, using = "botAcyMenNueva")
	private WebElement btnNuevaReservaHora;

	// Button -- Reservar por hora y precio
	@FindBy(how = How.ID, using = "")
	private WebElement btnReservarPorHoraAndPrecio;

	/** -- FAIL -- **/
	// Modal -- Rut fail
	@FindBy(how = How.ID, using = "modal-fail")
	private WebElement mdlRutFail;

	// Label -- Paciente fail
	@FindBy(how = How.ID, using = "modFaiTit")
	private WebElement lblPacienteFail;

	// Imagen -- Icono fail
	@FindBy(how = How.ID, using = "modFaiIco")
	private WebElement imgIconoFail;

	// Parrafo -- Mensaje fail
	@FindBy(how = How.ID, using = "modFaiMen")
	private WebElement prfMensajeFail;

	// Button -- Aceptar fail
	@FindBy(how = How.ID, using = "modFaiBotAce")
	private WebElement btnAceptarFail;

	/**
	 * BUSQUEDA PACIENTE POR RUT - PANTALLA 2 - AGENDAMIENTO EXAMEN PACIENTE POR RUT - FILTROS
	 **/
	/** -- HEADER -- **/
	// Nav Item Menu -- Examenes
	@FindBy(how = How.ID, using = "examenes-tab")
	private WebElement nvItMenuExamenes;

	// Button -- Cerrar
	@FindBy(how = How.ID, using = "")
	private WebElement btnCerrar;

	// H5 -- Titulo nueva reserva
	@FindBy(how = How.ID, using = "")
	private WebElement hFiveTituloOneNuevaReserva;

	// Span -- Titulo nombre paciente
	@FindBy(how = How.ID, using = "")
	private WebElement spnaTituloTwoNombrePaciente;

	// Imagen -- Icono especialidad
	@FindBy(how = How.ID, using = "")
	private WebElement imgIconoEspecialidad;

	// Span -- Especialidad
	@FindBy(how = How.ID, using = "")
	private WebElement spnEspecialidad;

	// Imagen -- Icono medicos
	@FindBy(how = How.ID, using = "")
	private WebElement imgIconoMedicos;

	// Span -- Medicos
	@FindBy(how = How.ID, using = "")
	private WebElement spnMedicos;

	// Imagen -- Icono examenes
	@FindBy(how = How.ID, using = "")
	private WebElement imgIconoExamenes;

	// Span -- Examenes
	@FindBy(how = How.ID, using = "")
	private WebElement spnExamenes;

	/** -- BODY/GENERAL -- **/
	// H6 -- Campos obligatorios
	@FindBy(how = How.ID, using = "")
	private WebElement hsixCamposObligatorios;

	// Imagen -- Icono busqueda
	@FindBy(how = How.ID, using = "")
	private WebElement imgIconoBusqueda;

	// Label -- Especialidad
	@FindBy(how = How.ID, using = "filModMedicoNueResEsp")
	private WebElement lblEspecialidad;

	// ListBox -- EspecialidadMedico
	@FindBy(how = How.ID, using = "filModNueResEsp")
	private WebElement lbxEspecialidad;
	
	// List -- Especialidad
	@FindBy(how = How.CLASS_NAME, using = "ng-option-label")
	private List<WebElement> listEspecialidad;
	
	// Label -- Prestacion
	@FindBy(how = How.ID, using = "filModNueResPre")
	private WebElement lblPrestacion;

	// ListBox -- Prestacion
	@FindBy(how = How.ID, using = "filModNueResPre")
	private WebElement lbxPrestacion;
	
	// List -- Prestacion
	@FindBy(how = How.CLASS_NAME, using = "ng-option-label")
	private List<WebElement> listPrestacion;

	// Label -- Region
	@FindBy(how = How.ID, using = "filModNueResReg")
	private WebElement lblRegion;

	// ListBox -- Region
	@FindBy(how = How.ID, using = "filModNueResReg")
	private WebElement lbxRegion;
	
	// List -- Region
	@FindBy(how = How.CLASS_NAME, using = "ng-option-label")
	private List<WebElement> listRegion;

	// Label -- Centro medico
	@FindBy(how = How.ID, using = "filModNueResCenMed")
	private WebElement lblCentroMedico;

	// ListBox -- Centro medico
	@FindBy(how = How.ID, using = "filModNueResCenMed")
	private WebElement lbxCentroMedico;
	
	// List -- Centro medico
	@FindBy(how = How.CLASS_NAME, using = "ng-option-label")
	private List<WebElement> listCentroMedico;

	// Button -- Calendario fecha avanzada
	@FindBy(how = How.ID, using = "botModNueResShoBigCal")
	private WebElement btnCalendarioFechaAvanzada;
	
	//Div -- Div Box med
	@FindBy(how = How.ID, using = "divConApaBoxMed")
	private WebElement divConApaBoxMed;
	
	// h4 -- Subtitulo especialidad y prestacion box medico
	@FindBy(how = How.ID, using = "h4ConApaBoxMedCabecera")
	private WebElement hFourSubtituloEspecialidadPrestacionBoxMedico;
	
	// h5 -- Subtitulo centro medico box medico
	@FindBy(how = How.ID, using = "h5ConApaBoxMedCentMedi")
	private WebElement hFiveSubtituloCentroMedicoBoxMedico;
	
	// Tr -- Nombre dia
	@FindBy(how = How.ID, using = "trModNueResSelSem")
	private WebElement TrNombreDia;
	
	// Tr -- Fechas mostradas
	@FindBy(how = How.ID, using = "trModNueResSelDay")
	private WebElement trFechasMostradas;
	
	// List -- Listado de fechas activas
	@FindBy(how = How.CLASS_NAME, using = "active-b")
	private List<WebElement> listFechasActivas;
	
	// List -- Listado de fechas inactivas
	@FindBy(how = How.ID, using = "")
	private List<WebElement> listFechasInactivas;		
	
	// List -- Listado de horarios
	@FindBy(how = How.ID, using = "")
	private List<WebElement> listHorarios;
	
	// H5 -- Titulo reserva semana
	@FindBy(how = How.ID, using = "h5ModNueResSem")
	private WebElement hFiveTituloReservaSemana;
	
	// H6 -- Titulo reserva semana
	@FindBy(how = How.ID, using = "h6ModNueResSem")
	private WebElement hSixTituloReservaSemana;
	
	// Div -- Calendario extendido
	@FindBy(how = How.ID, using = "calExt")
	private WebElement divCalendarioExtendido;
	
	// H4 -- Titulo busqueda avanzada
	@FindBy(how = How.ID, using = "calExtTitBus")
	private WebElement hFourTituloBusquedaAvanzada;
	
	// H5 -- Subtitulo seleccion mes y semana
	@FindBy(how = How.ID, using = "calExtTilSelMesyAno")
	private WebElement hFiveSeleccionMesSemana;
	
	// Button -- Mes anterior
	@FindBy(how = How.ID, using = "")
	private WebElement btnMesAnterior;
	
	// Datepicker -- Mes
	@FindBy(how = How.CLASS_NAME, using = "custom-select")
	private List<WebElement> dtpMes;
	
	// List -- Mes
	@FindBy(how = How.CLASS_NAME, using = "")
	private List<WebElement> listMes;
	
	// Datepicker -- Año
	@FindBy(how = How.CLASS_NAME, using = "custom-select")
	private List<WebElement> dtpAño;
	
	// List -- Año
	@FindBy(how = How.CLASS_NAME, using = "")
	private List<WebElement> listAño;
	
	// Button -- Mes anterior
	@FindBy(how = How.ID, using = "")
	private WebElement btnMesSiguiente;
	
	// Span -- dia activo
	@FindBy(how = How.CLASS_NAME, using = "custom-day")
	private List<WebElement> listDiaActivo;
	
	// Div -- Apartado box examenes 
	@FindBy(how = How.CLASS_NAME, using = "apartado-bxmedico")
	private WebElement divApartadoBxExamenes;
	
	/**
	 * BUSQUEDA PACIENTE POR RUT - PANTALLA 2 - AGENDAMIENTO EXAMEN PACIENTE POR RUT - DIV HORAS
	 **/
	// H3 -- Titulo fecha seleccionada
	@FindBy(how = How.ID, using = "h3ConApaBoxMedFecExa")
	private WebElement hThreeTituloFechaSeleccionadaExa;
	
	// H4 -- Subtitulo disponibilidad hora medico
	@FindBy(how = How.ID, using = "h4ConApaBoxMedDis")
	private WebElement hFourDisponibilidadHoraMedicoExa;
	
	// Label -- Horario Mañana
	@FindBy(how = How.ID, using = "h4ConApaBoxMedMan")
	private WebElement lblHorarioMañanaExa;
	
	// Ul -- Listado examenes mañana
	@FindBy(how = How.ID, using = "listConApaBoxMedMan")
	private WebElement ulListadoExamenesMañanaExa;
	
	// Label -- Horario tarde
	@FindBy(how = How.ID, using = "h4ConApaBoxMedTar")
	private WebElement lblHorarioTardeExa;
	
	// Ul -- Listado examenes tarde
	@FindBy(how = How.ID, using = "listConApaBoxMedTar")
	private WebElement ulListadoExamenesTardeExa;
	
	/**
	 * BUSQUEDA PACIENTE POR RUT - PANTALLA 2 - AGENDAMIENTO EXAMEN PACIENTE POR RUT - DIV EXAMENES
	 **/
	
	// Div -- Resumen examenes
	@FindBy(how = How.ID, using = "resExaDiv")
	private WebElement divResumenExamenes;
	
	// Div -- Seccion examen
	@FindBy(how = How.CLASS_NAME, using = "section-examen")
	private WebElement divSeccionExamen;
	
	// Imagen -- Icono examen
	@FindBy(how = How.ID, using = "resExaImaExa")
	private WebElement imgIconoExamenExa;	
	
	// h3 -- Especialidad
	@FindBy(how = How.ID, using = "resExaEsp")
	private WebElement hThreeEspecialidadExa;
	
	// h6 -- Centro medico
	@FindBy(how = How.ID, using = "resExaCenMed")
	private WebElement hSixCentroMedicoExa;
	
	// Imagen -- Icono genero
	@FindBy(how = How.ID, using = "resExaPacIco")
	private WebElement imgIconoGeneroExa;
	
	// h5 -- Nombre paciente
	@FindBy(how = How.ID, using = "resExaPacNom")
	private WebElement hFiveNombrePacienteExa;
	
	// Parrafo -- Mail paciente
	@FindBy(how = How.ID, using = "resExaPacMail")
	private WebElement pMailPacienteExa;	
	
	// Imagen -- Icono calendario
	@FindBy(how = How.ID, using = "resExaIconCal")
	private WebElement imgIconoCalendarioExa;
	
	// Span -- Fecha examen
	@FindBy(how = How.ID, using = "resExaFecExa")
	private WebElement spnFechaExamenExa;
	
	// Imagen -- Icono horario examen
	@FindBy(how = How.ID, using = "resExaiconHor")
	private WebElement imgIconoHorarioExamenExa;
	
	// Span -- Horario examen
	@FindBy(how = How.ID, using = "resExaHor")
	private WebElement spanHorarioExamenExa;
	
	// Imagen -- Icono pago
	@FindBy(how = How.ID, using = "resExaIconPag")
	private WebElement imgIconoPagoExa;
	
	// Span -- Monto pago
	@FindBy(how = How.ID, using = "resExaPago")
	private WebElement spnMontoPagoExa;
	
	// Button -- Agendar
	@FindBy(how = How.ID, using = "resExaBotAge")
	private WebElement btnAgendarExa;
	
	/**
	 * BUSQUEDA PACIENTE POR RUT - PANTALLA 2 - AGENDAMIENTO EXAMEN PACIENTE POR RUT - DIV LEER INDICACIONES
	 **/
	// Div -- Leer indicaciones
	@FindBy(how = How.ID, using = "modal-indications-back2new")
	private WebElement divLeerIndicaciones;
	
	// H5 -- Leer indicaciones
	@FindBy(how = How.ID, using = "indTitLee")
	private WebElement hFiveTituloLeerIndicaciones;
	
	// Div -- Listado leer indicaciones
	@FindBy(how = How.ID, using = "indTexInd")
	private WebElement divListadoLeerIndicaciones;
	
	// Li -- Listado leer indicaciones
	@FindBy(how = How.CLASS_NAME, using = "progress-step")
	private List<WebElement> liListadoLeerIndicaciones;
	
	// Label -- Prestacion sin indicaciones
	@FindBy(how = How.CLASS_NAME, using = "progress-text")
	private WebElement lblPrestacionSinIndicaciones;
	
	// Button -- He leido las indicaciones
	@FindBy(how = How.ID, using = "indBotAcep")
	private WebElement btnHeLeidoLasIndicaciones;
	
	// Button -- He leido las indicaciones en OCM
	@FindBy(how = How.ID, using = "indBotAcepOCM")
	private WebElement btnHeLeidoLasIndicacionesOcm;
	
	// Button -- Anular reserva
	@FindBy(how = How.ID, using = "indBotAnu")
	private WebElement btnAnularReserva;
	
	/**
	 * BUSQUEDA PACIENTE POR RUT - PANTALLA 2 - AGENDAMIENTO ESPECIALIDAD PACIENTE POR RUT - FILTROS
	 **/
	// Div -- Nueva reserva
	@FindBy(how = How.ID, using = "nuevaReserva")
	private WebElement divNuevaReserva;
	
	// Button -- Cerrar nueva reserva
	@FindBy(how = How.CLASS_NAME, using = "close")
	private List<WebElement> btnCerrarNuevaReserva;
	
	// h5 -- Nueva reserva
	@FindBy(how = How.ID, using = "h5ModNueResTitNuevRes")
	private WebElement hFiveNuevaReserva;
	
	// Span -- Nombre paciente
	@FindBy(how = How.ID, using = "spaModNueResNomPas")
	private WebElement spnNombrePaciente;
	
	// Imagen -- Icono espacialidad
	@FindBy(how = How.ID, using = "BONOS->-CARO-2*****")
	private WebElement imgIconoEspecialidadEsp;
	
	// Tab -- Especialidad
	@FindBy(how = How.ID, using = "especialidad-tab")
	private WebElement tbEspecialidad;
			
	/**
	 * BUSQUEDA PACIENTE POR RUT - PANTALLA 2 - AGENDAMIENTO ESPECIALIDAD PACIENTE POR RUT - HORAS DISPONIBLES
	 **/
	// Div -- Header fechas
	@FindBy(how = How.CLASS_NAME, using = "header")
	private WebElement divHeaderFechas;
	
	// Div -- Apartado horas
	@FindBy(how = How.ID, using = "ApaBoxEsp")
	private WebElement divApartadoHoras;
	
	// H3 -- Fecha especialidad
	@FindBy(how = How.ID, using = "ApaBoxEspFecCon")
	private WebElement hThreeFechaEspecialidad;
	
	// H4 -- Nombre especialidad y prestacion
	@FindBy(how = How.ID, using = "ApaBoxEspNomEsp")
	private WebElement hFourNombreEspecialidadPrestacion;
	
	// H5 -- Nombre centro medico 
	@FindBy(how = How.ID, using = "ApaBoxEspNomCenMed")
	private WebElement hFiveNombreCentroMedicoEspecialidad;
	
	// Div -- Apartado especialidad 
	@FindBy(how = How.CLASS_NAME, using = "apartado-bxespecialidad")
	private WebElement divApartadoBxEspecialidad;
	
	// List -- Doctores 
	@FindBy(how = How.CLASS_NAME, using = "list-doctors")
	private List<WebElement> listDoctores;
	
	// List -- Imagenes doctores 
	@FindBy(how = How.CLASS_NAME, using = "ApaBoxEspIcoDoc")
	private List<WebElement> listImagenesDoctores;
	
	// List -- Nombre doctores 
	@FindBy(how = How.CLASS_NAME, using = "ApaBoxEspNomDoc")
	private List<WebElement> listNombreDoctores;
	
	// List -- Convenio doctores 
	@FindBy(how = How.CLASS_NAME, using = "ApaBoxEspConvenio")
	private List<WebElement> listConvenioDoctores;
	
	// List -- Imagenes icono mañana doctores
	@FindBy(how = How.CLASS_NAME, using = "ApaBoxEspImaDay")
	private List<WebElement> listImagenesIconoMañanaDoctores;
	
	// List -- Imagenes icono tarde doctores
	@FindBy(how = How.CSS, using = "[lass=\"ApaBoxEspImaAfte\"]")
	private List<WebElement> listImagenesIconoTardeDoctores;	
	
	// List -- Separador doctores
	@FindBy(how = How.CLASS_NAME, using = "separador")
	private List<WebElement> listSeparadorDoctores;

	// List -- Carrusel horas doctores
	@FindBy(how = How.CLASS_NAME, using = "carrusel-horas")
	private List<WebElement> listCarruselHorasDoctores;
	
	//Div -- Resumen especialidad
	@FindBy(how = How.ID, using = "resExaDiv")
	private WebElement divResumenEspecialidad;
	
	//Img -- Icono doctor	
	@FindBy(how = How.ID, using = "imagenDoctor")
	private WebElement imgIconoDoctorEsp;
	
	// H3 -- Nombre doctor	
	@FindBy(how = How.ID, using = "resExaEspNomDoc")
	private WebElement hThreeNombreDoctorEsp;
	
	// H3 -- Especialidad doctor	
	@FindBy(how = How.ID, using = "resExaEspEsp")
	private WebElement hThreePrestacionDoctorEsp;
	
	// H6 -- Centro medico	
	@FindBy(how = How.ID, using = "resExaCenMed")
	private WebElement hSixCentroMedicoEsp;
	
	// Div -- Seccion paciente
	@FindBy(how = How.CLASS_NAME, using = "section-paciente")
	private WebElement divSeccionPaciente;
	
	// Img -- Icono genero
	@FindBy(how = How.ID, using = "resExaPacIco")
	private WebElement imgIconoGeneroEsp;
	
	// H5 -- Nombre paciente
	@FindBy(how = How.ID, using = "resExaPacNom")
	private WebElement hFiveNombrePacienteEsp;
	
	//p -- Correo Paciente
	@FindBy(how = How.ID, using = "resExaPacMail")
	private WebElement pCorreoPacienteEsp;
	
	// Div -- Seccion consulta
	@FindBy(how = How.CLASS_NAME, using = "section-consulta")
	private WebElement divSeccionConsulta;
	
	// Img -- Icono calendario
	@FindBy(how = How.ID, using = "resExaIconCal")
	private WebElement imgIconoCalendarioEsp;
	
	// Span -- Fecha consulta
	@FindBy(how = How.ID, using = "resExaFecExa")
	private WebElement spnFechaConsultaEsp;
	
	// Img -- Icono horario
	@FindBy(how = How.ID, using = "resExaFecExa")
	private WebElement imgIconoHorarioEsp;
	
	// Span -- Hora consulta
	@FindBy(how = How.ID, using = "resExaHor")
	private WebElement spnHoraConsultaEsp;
	
	// Img -- Icono pago
	@FindBy(how = How.ID, using = "resExaIconPag")
	private WebElement imgIconoPagoEsp;
	
	// Span -- Costo consulta
	@FindBy(how = How.ID, using = "resExaPago")
	private WebElement spnCostoConsultaEsp;
	
	// Button -- Agendar
	@FindBy(how = How.ID, using = "resExaBotAge")
	private WebElement btnAgendarEsp;
	
	/**
	 * CREAR & EDITAR PACIENTE
	 **/
	// Div -- Crear y editar paciente
	@FindBy(how = How.ID, using = "modal-crearPaciente")
	private WebElement divCrearEditarPaciente;
	
	// Button -- Close
	@FindBy(how = How.ID, using = "creaPacButClos")
	private WebElement btnClose;
	
	//H5 -- Crear y editar datos paciente
	@FindBy(how = How.ID, using = "creaPacTitu")
	private WebElement hFiveTituloCrearEditarDatosPaciente;
	
	//H6 -- Paciente registrado revisar rut
	@FindBy(how = How.ID, using = "creaPacTituIns")
	private WebElement hSixSubTituloPacienteRegistradoRevisarRut;
 	
	//Label -- Rut
	@FindBy(how = How.ID, using = "creaPacLabRut")
	private WebElement lblRut;

	//Input text -- Rut
	@FindBy(how = How.ID, using = "creaPacInpRut")
	private WebElement txtRut;
	
	//Label -- Nombres
	@FindBy(how = How.ID, using = "creaPacLabNom")
	private WebElement lblNombres;

	//Input text -- Nombres
	@FindBy(how = How.ID, using = "creaPacInpbNom")
	private WebElement txtNombres;
	
	//Label -- Apellidos
	@FindBy(how = How.ID, using = "creaPacLabApelli")
	private WebElement lblApellidos;

	//Input text -- Apellido materno
	@FindBy(how = How.ID, using = "creaPacInpApellMat")
	private WebElement txtApellidoMaterno;

	//Input text -- Apellido paterno
	@FindBy(how = How.ID, using = "creaPacInpApellPat")
	private WebElement txtApellidoPaterno;
	
	//Label -- Fecha nacimiento
	@FindBy(how = How.ID, using = "creaPacLabFecNac")
	private WebElement lblFechaNacimiento;

	//Input text -- Fecha dia
	@FindBy(how = How.ID, using = "creaPacInpDiaNac")
	private WebElement txtFechaDia;

	//Input text -- Fecha mes
	@FindBy(how = How.ID, using = "creaPacInpMesNac")
	private WebElement txtFechaMes;

	//Input text -- Fecha año
	@FindBy(how = How.ID, using = "creaPacInpAnoNac")
	private WebElement txtFechaAño;

	// Label -- Genero
	@FindBy(how = How.ID, using = "creaPacLabGen")
	private WebElement lblGenero;

	// ListBox -- Genero
	@FindBy(how = How.ID, using = "creaPacSelGen")
	private WebElement lbxGenero;
	
	// List -- Genero
	@FindBy(how = How.CLASS_NAME, using = "ng-option-label")
	private List<WebElement> listGenero;

	// Label -- Prevision
	@FindBy(how = How.ID, using = "creaPacLabPre")
	private WebElement lblPrevision;

	// ListBox -- Prevision
	@FindBy(how = How.ID, using = "creaPacSelPrev")
	private WebElement lbxPrevision;
	
	// List -- Prevision
	@FindBy(how = How.CLASS_NAME, using = "ng-option-label")
	private List<WebElement> listPrevision;

	// Label -- Correo
	@FindBy(how = How.ID, using = "creaPacLabCorr")
	private WebElement lblCorreo;

	// Input text -- Correo
	@FindBy(how = How.ID, using = "creaPacInpcorr")
	private WebElement txtCorreo;
	
	// Label -- Telefono
	@FindBy(how = How.ID, using = "creaPacLabTlf")
	private WebElement lblTelefono;

	// Input text -- Telefono
	@FindBy(how = How.ID, using = "creaPacInpTlf")
	private WebElement txtTelefono;

	// Label -- Nacionalidad
	@FindBy(how = How.ID, using = "creaPacLabNac")
	private WebElement lblNacionalidad;

	// ListBox -- Nacionalidad
	@FindBy(how = How.ID, using = "creaPacselNac")
	private WebElement lbxNacionalidad;
	
	// List -- Nacionalidad
	@FindBy(how = How.CLASS_NAME, using = "ng-option-label")
	private List<WebElement> listNacionalidad;

	// Label -- Direccion
	@FindBy(how = How.ID, using = "creaPacLabDirec")
	private WebElement lblDireccion;

	// Input text -- Direccion
	@FindBy(how = How.ID, using = "creaPacInpDirec")
	private WebElement txtDireccion;

	// Input text -- Comuna
	@FindBy(how = How.ID, using = "creaPacInpComu")
	private WebElement txtComuna;

	// ListBox -- Regiones
	@FindBy(how = How.ID, using = "creaPacSelRegion")
	private WebElement lbxRegiones;
	
	// List -- Regiones
	@FindBy(how = How.CLASS_NAME, using = "ng-option-label")
	private List<WebElement> listRegiones;
	
	// Button -- Guardar
	@FindBy(how = How.ID, using = "creaPacButEnv")
	private WebElement btnGuardar;

	/**
	 * BUSQUEDA PACIENTE POR RUT - PANTALLA 2 - AGENDAMIENTO ESPECIALIDAD PACIENTE POR RUT - FILTROS
	 **/
	
	// Imagen -- Icono medico
	@FindBy(how = How.ID, using = "")
	private WebElement imgIconoMedico;
	
	// Tab -- Medicos
	@FindBy(how = How.ID, using = "medicos-tab")
	private WebElement tbMedicos;
	
	// Div -- Medicos
	@FindBy(how = How.ID, using = "newTabContent")
	private WebElement divMedicos;
	
	// ListBox -- Medicos
	@FindBy(how = How.CLASS_NAME, using = "ng-select-searchable")
	private List<WebElement> lbxMedico;
	
	// List -- Medicos
	@FindBy(how = How.CLASS_NAME, using = "ng-option-label")
	private List<WebElement> listMedico;
	
	/**
	 * OCM PENDIENTES POR PACIENTE - SECCION INFORMACION DE PACIENTE
	 **/
	// Div -- Ocm pendientes paciente
	@FindBy(how = How.CLASS_NAME, using = "container-views")
	private List<WebElement> divOcmPendientesPacienteSeccionGeneral;
	
	// Div -- Seccion informacion paciente
	@FindBy(how = How.CLASS_NAME, using = "info-patients")
	private List<WebElement> divSeccionInformacionPaciente;

	// Img -- Icono paciente ocm pendiente
	@FindBy(how = How.ID, using = "carruselpacienteimag")
	private WebElement imgIconoPacienteOcmPendiente;
	
	// H5 -- Nombre paciente ocm pendiente
	@FindBy(how = How.ID, using = "carruselpacienteNom")
	private WebElement hFiveNombrePacienteOcmPendiente;	
	
	// Label -- Genero y fecha nacimiento
	@FindBy(how = How.ID, using = "carruselpacienteSex")
	private WebElement lblGeneroFechaNacimientoOcmPendiente;
	
	// Label -- Correo
	@FindBy(how = How.ID, using = "carruselpacienteCorreo")
	private WebElement lblCorreoOcmPendiente;
	
	// Label -- Telefono
	@FindBy(how = How.ID, using = "carruselpacienteTlf")
	private WebElement lblTelefonoOcmPendiente;
	
	// Label -- Rut
	@FindBy(how = How.ID, using = "carruselpacienteNumDoc")
	private WebElement lblRutOcmPendiente;
	
	// Label -- Prevision
	@FindBy(how = How.ID, using = "carruselpacientePrev")
	private WebElement lblPrevisionOcmPendiente;
	
	// Link -- Datos paciente
	@FindBy(how = How.CLASS_NAME, using = "datos-paciente")
	private List<WebElement> lnkDatosPacienteOcmPendiente;
	
	// Div -- Botonora nuevas reservas
	@FindBy(how = How.CLASS_NAME, using = "botonera-acciones_reserva")
	private List<WebElement> divBotoneraNuevasReservasOcmPendiente;
	
	// Button -- Nueva reserva hora
	@FindBy(how = How.ID, using = "botoOcembotonNuevHor")
	private WebElement btnNuevaReservaHoraOcmPendiente;
	
	// Button -- Reserva por hora y precio
	@FindBy(how = How.CLASS_NAME, using = "patients-buttons")
	private List<WebElement> btnReservaHoraAndPrecioOcmPendiente;
	
	// Button -- Reenviar email agendar	
	@FindBy(how = How.CLASS_NAME, using = "patients-buttons")
	private List<WebElement> btnReenviarEmailAgendarOcmPendiente;
	
	// Div -- Seccion box agendamiento
	@FindBy(how = How.CLASS_NAME, using = "container-box")
	private List<WebElement> divOcmSeccionBoxAgendamiento;
	
	// Tab -- Contenedor tab agendamiento
	@FindBy(how = How.ID, using = "myTab")
	private WebElement tabContenedorTabAgendamiento;
	
	// Tab -- Por gestionar
	@FindBy(how = How.ID, using = "agendar-tab")
	private WebElement tabPorGestionar;
	
	// Tab -- Gestionado
	@FindBy(how = How.ID, using = "agendado-tab")
	private WebElement tabGestionado;
	
	// Table -- Agendar
	@FindBy(how = How.ID, using = "agendar")
	private WebElement tblAgendar;
	
	// Table -- Agendado
	@FindBy(how = How.ID, using = "agendado")
	private WebElement tblAgendado;
	
	// Table header -- Cabecera tabla agendar
	@FindBy(how = How.CLASS_NAME, using = "table-header-order")
	private List<WebElement> tbhCabezaraTablaAgendar;
	
	// Table header -- Cabecera tabla por gestionar icono orden
	@FindBy(how = How.CLASS_NAME, using = "icon_orden")
	private List<WebElement> tbhCabeceraTablaPorGestionarIconoOrden;
	
	// Table header -- Cabecera tabla gestionado
	@FindBy(how = How.CLASS_NAME, using = "table-header")
	private List<WebElement> tbhCabeceraTablaGestionado;

	// Table header -- Cabecera tabla gestionado icono orden
	@FindBy(how = How.CLASS_NAME, using = "icon_orden")
	private List<WebElement> tbhCabeceraTablaGestionadoIconoOrden;
	
	// Table -- Cuerpo de ordenes por gestionar
	@FindBy(how = How.CLASS_NAME, using = "table-body-order")
	private List<WebElement> tbCuerpoOrdenesPorGestionar;
	
	// Button -- Apertura ordenes por gestionar
	@FindBy(how = How.CLASS_NAME, using = "icon_bottom")
	private List<WebElement> btnAperturaOrdenesPorGestionar;
	
	// Button -- Link leer indicaciones
	@FindBy(how = How.CLASS_NAME, using = "accordion-subtitle")
	private List<WebElement> btnLinkLeerIndicaciones;
	
	// Img -- Icono prestacion no agendable
	@FindBy(how = How.CLASS_NAME, using = "alertMsg")
	private List<WebElement> ImgIconoPrestacionNoAgendable;

	// Img -- Icono multiopcion
	@FindBy(how = How.CLASS_NAME, using = "icon_mail")
	private List<WebElement> ImgIconoMultiopcion;
	
	// Button -- Opcion enviar indicaciones
	@FindBy(how = How.CLASS_NAME, using = "option-popover")
	private List<WebElement> BtnOpcionEnviarIndicaciones;
	
	// Button -- Opcion rechazar asesoria
	@FindBy(how = How.CLASS_NAME, using = "option-popover")
	private List<WebElement> BtnOpcionRechazarAsesoria;
	
	// Imagen -- Icono pestaña apertura prestacion
	@FindBy(how = How.CSS, using = "[style=\"opacity: 1;\"]")
	private List<WebElement> imgIconoPestañaAperturaPrestacion;
	
	// Table -- Item detalle prestaciones
	@FindBy(how = How.CLASS_NAME, using = "accordion-item")
	private List<WebElement> tbItemDetallePrestaciones;
		
	// Label -- No hay disponibilidad para proximos siete dias
	@FindBy(how = How.CLASS_NAME, using = "table-typo_strong")
	private List<WebElement> lblNoDisponibilidadProximosSieteDias;
	
	// Label -- Ocm prestacion gestionado
	@FindBy(how = How.CLASS_NAME, using = "table-typo_strong")
	private List<WebElement> lblOcmPrestacionGestionado;
	
	// Label -- Ocm hora gestionado
	@FindBy(how = How.CLASS_NAME, using = "table-typo_strong")
	private List<WebElement> lblOcmHoraGestionado;
	
	// Label -- Ocm fecha gestionado
	@FindBy(how = How.CLASS_NAME, using = "table-typo-light_blue_dark")
	private List<WebElement> lblOcmFechaGestionado;
	
	// Button -- Cancelar anular reserva hora
	@FindBy(how = How.CLASS_NAME, using = "modal-button_white")
	private List<WebElement> btnCancelarAnularReservaHora;
	
	// Button -- Anular reserva hora
	@FindBy(how = How.CSS, using = "[data-target=\"#modal-fail\"]")
	private List<WebElement> btnAnularReservaHora;
	
	// Table -- Item listado proximas horas disponibles
	@FindBy(how = How.CLASS_NAME, using = "table-body")
	private List<WebElement> tbListadoProximasHorasDisponibles;
	
	// Table -- Item listado gestionados
	@FindBy(how = How.CLASS_NAME, using = "table-body")
	private List<WebElement> tbListadoGestionados;
	
	// Table header -- Cabezara listado proximas horas disponibles
	@FindBy(how = How.CLASS_NAME, using = "table-header")
	private List<WebElement> tbhCabezaraListadoProximasHorasDisponibles;
	
	// ListBox -- Horas disponibles
	@FindBy(how = How.CLASS_NAME, using = "ng-select-container")
	private List<WebElement> lbxHorasDisponibles;
	
	// List -- Horas disponibles
	@FindBy(how = How.CLASS_NAME, using = "ng-option")
	private List<WebElement> listHorasDisponibles;
	
	// Table -- Centros medicos
	@FindBy(how = How.CLASS_NAME, using = "info-centro")
	private List<WebElement> tbCentrosMedicos;
	
	// Button -- Mas opciones
	@FindBy(how = How.CLASS_NAME, using = "icon_dots")
	private List<WebElement> btnMasOpciones;
	
	// List -- Mas opciones
	@FindBy(how = How.CLASS_NAME, using = "center-options")
	private List<WebElement> listMasOpciones;
	
	// Button -- Seleccion agendar hora
	@FindBy(how = How.CSS, using = "[class=\"ClassAgendar\"]")
	private List<WebElement> BtnSeleccionAgendarHora;

	// Button -- Seleccion mas horas
	@FindBy(how = How.CSS, using = "[data-target=\"#nuevaReserva\"]")
	private List<WebElement> BtnSeleccionMasHoras;
	
	// Button -- Seleccion anular prestacion
	@FindBy(how = How.CSS, using = "[data-target=\"#modal-confirmar\"]")
	private List<WebElement> BtnSeleccionAnular;
	
	/*
	 * 
	 * Metodos Getter y Setter
	 * 
	 */	
	
	public WebElement getBtnMenu() {
		return btnMenu;
	}

	public WebElement getImgLogoBupa() {
		return imgLogoBupa;
	}

	public void setImgLogoBupa(WebElement imgLogoBupa) {
		this.imgLogoBupa = imgLogoBupa;
	}

	public WebElement getImgLogin() {
		return imgLogin;
	}

	public void setImgLogin(WebElement imgLogin) {
		this.imgLogin = imgLogin;
	}

	public WebElement gethOneTituloBupa() {
		return hOneTituloBupa;
	}

	public void sethOneTituloBupa(WebElement hOneTituloBupa) {
		this.hOneTituloBupa = hOneTituloBupa;
	}

	public WebElement getLblUsuario() {
		return lblUsuario;
	}

	public void setLblUsuario(WebElement lblUsuario) {
		this.lblUsuario = lblUsuario;
	}

	public WebElement getTxtUsuario() {
		return txtUsuario;
	}

	public void setTxtUsuario(WebElement txtUsuario) {
		this.txtUsuario = txtUsuario;
	}

	public WebElement getLblContraseña() {
		return lblContraseña;
	}

	public void setLblContraseña(WebElement lblContraseña) {
		this.lblContraseña = lblContraseña;
	}

	public WebElement getTxtContraseña() {
		return txtContraseña;
	}

	public void setTxtContraseña(WebElement txtContraseña) {
		this.txtContraseña = txtContraseña;
	}

	public WebElement getBtnIniciarSesion() {
		return btnIniciarSesion;
	}

	public void setBtnIniciarSesion(WebElement btnIniciarSesion) {
		this.btnIniciarSesion = btnIniciarSesion;
	}
	
	public WebElement getDivLoginOpt() {
		return divLoginOpt;
	}

	public void setDivLoginOpt(WebElement divLoginOpt) {
		this.divLoginOpt = divLoginOpt;
	}

	public WebElement getImgLogoBupaOpt() {
		return imgLogoBupaOpt;
	}

	public void setImgLogoBupaOpt(WebElement imgLogoBupaOpt) {
		this.imgLogoBupaOpt = imgLogoBupaOpt;
	}
	
	public WebElement getImgLoginOpt() {
		return imgLoginOpt;
	}

	public void setImgLoginOpt(WebElement imgLoginOpt) {
		this.imgLoginOpt = imgLoginOpt;
	}

	public WebElement gethOneTituloBupaOpt() {
		return hOneTituloBupaOpt;
	}

	public void sethOneTituloBupaOpt(WebElement hOneTituloBupaOpt) {
		this.hOneTituloBupaOpt = hOneTituloBupaOpt;
	}

	public WebElement getLblClaveDinamicaOpt() {
		return lblClaveDinamicaOpt;
	}

	public void setLblClaveDinamicaOpt(WebElement lblClaveDinamicaOpt) {
		this.lblClaveDinamicaOpt = lblClaveDinamicaOpt;
	}

	public WebElement getTxtClaveDinamicaOpt() {
		return txtClaveDinamicaOpt;
	}

	public void setTxtClaveDinamicaOpt(WebElement txtClaveDinamicaOpt) {
		this.txtClaveDinamicaOpt = txtClaveDinamicaOpt;
	}

	public WebElement getBtnValidarTokenOpt() {
		return btnValidarTokenOpt;
	}

	public void setBtnValidarTokenOpt(WebElement btnValidarTokenOpt) {
		this.btnValidarTokenOpt = btnValidarTokenOpt;
	}

	public WebElement getLnkVolverOpt() {
		return lnkVolverOpt;
	}

	public void setLnkVolverOpt(WebElement lnkVolverOpt) {
		this.lnkVolverOpt = lnkVolverOpt;
	}

	public void setBtnMenu(WebElement btnMenu) {
		this.btnMenu = btnMenu;
	}

	public WebElement getImgCorporativa() {
		return imgCorporativa;
	}

	public void setImgCorporativa(WebElement imgCorporativa) {
		this.imgCorporativa = imgCorporativa;
	}

	public WebElement gethOneSubTitulo() {
		return hOneSubTitulo;
	}

	public void sethOneSubTitulo(WebElement hOneSubTitulo) {
		this.hOneSubTitulo = hOneSubTitulo;
	}

	public WebElement getImgSesionUsuario() {
		return imgSesionUsuario;
	}

	public void setImgSesionUsuario(WebElement imgSesionUsuario) {
		this.imgSesionUsuario = imgSesionUsuario;
	}

	public WebElement getpNombreUsuario() {
		return pNombreUsuario;
	}

	public void setpNombreUsuario(WebElement pNombreUsuario) {
		this.pNombreUsuario = pNombreUsuario;
	}

	public WebElement getpCentroMedico() {
		return pCentroMedico;
	}

	public void setpCentroMedico(WebElement pCentroMedico) {
		this.pCentroMedico = pCentroMedico;
	}

	public WebElement getImgIconoNotificaciones() {
		return imgIconoNotificaciones;
	}

	public void setImgIconoNotificaciones(WebElement imgIconoNotificaciones) {
		this.imgIconoNotificaciones = imgIconoNotificaciones;
	}

	public WebElement getImgIconoInicio() {
		return imgIconoInicio;
	}

	public void setImgIconoInicio(WebElement imgIconoInicio) {
		this.imgIconoInicio = imgIconoInicio;
	}

	public WebElement getSpnInicio() {
		return spnInicio;
	}

	public void setSpnInicio(WebElement spnInicio) {
		this.spnInicio = spnInicio;
	}

	public WebElement getImgIconoAsignados() {
		return imgIconoAsignados;
	}

	public void setImgIconoAsignados(WebElement imgIconoAsignados) {
		this.imgIconoAsignados = imgIconoAsignados;
	}

	public WebElement getSpnAsignados() {
		return spnAsignados;
	}

	public void setSpnAsignados(WebElement spnAsignados) {
		this.spnAsignados = spnAsignados;
	}

	public WebElement getImgIconoPromociones() {
		return imgIconoPromociones;
	}

	public void setImgIconoPromociones(WebElement imgIconoPromociones) {
		this.imgIconoPromociones = imgIconoPromociones;
	}

	public WebElement getSpnPromociones() {
		return spnPromociones;
	}

	public void setSpnPromociones(WebElement spnPromociones) {
		this.spnPromociones = spnPromociones;
	}

	public WebElement getImgIconoCbClic() {
		return imgIconoCbClic;
	}

	public void setImgIconoCbClic(WebElement imgIconoCbClic) {
		this.imgIconoCbClic = imgIconoCbClic;
	}

	public WebElement getSpnCbClic() {
		return spnCbClic;
	}

	public void setSpnCbClic(WebElement spnCbClic) {
		this.spnCbClic = spnCbClic;
	}

	public WebElement getImgIconoConfiguracion() {
		return imgIconoConfiguracion;
	}

	public void setImgIconoConfiguracion(WebElement imgIconoConfiguracion) {
		this.imgIconoConfiguracion = imgIconoConfiguracion;
	}

	public WebElement getSpnConfiguracion() {
		return spnConfiguracion;
	}

	public void setSpnConfiguracion(WebElement spnConfiguracion) {
		this.spnConfiguracion = spnConfiguracion;
	}

	public WebElement getImgIconoCerrarSesion() {
		return imgIconoCerrarSesion;
	}

	public void setImgIconoCerrarSesion(WebElement imgIconoCerrarSesion) {
		this.imgIconoCerrarSesion = imgIconoCerrarSesion;
	}

	public WebElement getSpnCerrarSesion() {
		return spnCerrarSesion;
	}

	public void setSpnCerrarSesion(WebElement spnCerrarSesion) {
		this.spnCerrarSesion = spnCerrarSesion;
	}
	
	public WebElement getDivMenuInicial() {
		return divMenuInicial;
	}

	public void setDivMenuInicial(WebElement divMenuInicial) {
		this.divMenuInicial = divMenuInicial;
	}
	
	public WebElement getDivMenuInicialPrincipal() {
		return divMenuInicialPrincipal;
	}

	public void setDivMenuInicialPrincipal(WebElement divMenuInicialPrincipal) {
		this.divMenuInicialPrincipal = divMenuInicialPrincipal;
	}

	public WebElement getSpnFechaActual() {
		return spnFechaActual;
	}

	public void setSpnFechaActual(WebElement spnFechaActual) {
		this.spnFechaActual = spnFechaActual;
	}

	public WebElement getImgAsignados() {
		return imgAsignados;
	}

	public void setImgAsignados(WebElement imgAsignados) {
		this.imgAsignados = imgAsignados;
	}

	public WebElement getSpanPacientes() {
		return SpanPacientes;
	}

	public void setSpanPacientes(WebElement spanPacientes) {
		SpanPacientes = spanPacientes;
	}

	public WebElement getTxtInputRut() {
		return txtInputRut;
	}

	public void setTxtInputRut(WebElement txtInputRut) {
		this.txtInputRut = txtInputRut;
	}

	public WebElement getBtnConsultar() {
		return btnConsultar;
	}

	public void setBtnConsultar(WebElement btnConsultar) {
		this.btnConsultar = btnConsultar;
	}

	public WebElement getDivPacienteEncontrado() {
		return divPacienteEncontrado;
	}

	public void setDivPacienteEncontrado(WebElement divPacienteEncontrado) {
		this.divPacienteEncontrado = divPacienteEncontrado;
	}

	public WebElement getDivIngresarRutValido() {
		return divIngresarRutValido;
	}

	public void setDivIngresarRutValido(WebElement divIngresarRutValido) {
		this.divIngresarRutValido = divIngresarRutValido;
	}

	public WebElement gethSixPaciente() {
		return hSixPaciente;
	}

	public void sethSixPaciente(WebElement hSixPaciente) {
		this.hSixPaciente = hSixPaciente;
	}

	public WebElement getImgIconoPaciente() {
		return imgIconoPaciente;
	}

	public void setImgIconoPaciente(WebElement imgIconoPaciente) {
		this.imgIconoPaciente = imgIconoPaciente;
	}

	public WebElement gethFiveNombrePaciente() {
		return hFiveNombrePaciente;
	}

	public void sethFiveNombrePaciente(WebElement hFiveNombrePaciente) {
		this.hFiveNombrePaciente = hFiveNombrePaciente;
	}

	public WebElement getLblGeneroAndEdadPaciente() {
		return lblGeneroAndEdadPaciente;
	}

	public void setLblGeneroAndEdadPaciente(WebElement lblGeneroAndEdadPaciente) {
		this.lblGeneroAndEdadPaciente = lblGeneroAndEdadPaciente;
	}

	public WebElement getLblCorreoPaciente() {
		return lblCorreoPaciente;
	}

	public void setLblCorreoPaciente(WebElement lblCorreoPaciente) {
		this.lblCorreoPaciente = lblCorreoPaciente;
	}

	public WebElement getLblTelefonoPaciente() {
		return lblTelefonoPaciente;
	}

	public void setLblTelefonoPaciente(WebElement lblTelefonoPaciente) {
		this.lblTelefonoPaciente = lblTelefonoPaciente;
	}

	public WebElement getLblRutPaciente() {
		return lblRutPaciente;
	}

	public void setLblRutPaciente(WebElement lblRutPaciente) {
		this.lblRutPaciente = lblRutPaciente;
	}

	public WebElement getLblPrevisionPaciente() {
		return lblPrevisionPaciente;
	}

	public void setLblPrevisionPaciente(WebElement lblPrevisionPaciente) {
		this.lblPrevisionPaciente = lblPrevisionPaciente;
	}
	
	public WebElement getLnkEditarInformacionPaciente() {
		return lnkEditarInformacionPaciente;
	}

	public void setLnkEditarInformacionPaciente(WebElement lnkEditarInformacionPaciente) {
		this.lnkEditarInformacionPaciente = lnkEditarInformacionPaciente;
	}

	public WebElement getBtnNuevaReservaHora() {
		return btnNuevaReservaHora;
	}

	public void setBtnNuevaReservaHora(WebElement btnNuevaReservaHora) {
		this.btnNuevaReservaHora = btnNuevaReservaHora;
	}

	public WebElement getBtnReservarPorHoraAndPrecio() {
		return btnReservarPorHoraAndPrecio;
	}

	public void setBtnReservarPorHoraAndPrecio(WebElement btnReservarPorHoraAndPrecio) {
		this.btnReservarPorHoraAndPrecio = btnReservarPorHoraAndPrecio;
	}

	public WebElement getMdlRutFail() {
		return mdlRutFail;
	}

	public void setMdlRutFail(WebElement mdlRutFail) {
		this.mdlRutFail = mdlRutFail;
	}

	public WebElement getLblPacienteFail() {
		return lblPacienteFail;
	}

	public void setLblPacienteFail(WebElement lblPacienteFail) {
		this.lblPacienteFail = lblPacienteFail;
	}

	public WebElement getImgIconoFail() {
		return imgIconoFail;
	}

	public void setImgIconoFail(WebElement imgIconoFail) {
		this.imgIconoFail = imgIconoFail;
	}

	public WebElement getPrfMensajeFail() {
		return prfMensajeFail;
	}

	public void setPrfMensajeFail(WebElement prfMensajeFail) {
		this.prfMensajeFail = prfMensajeFail;
	}

	public WebElement getBtnAceptarFail() {
		return btnAceptarFail;
	}

	public void setBtnAceptarFail(WebElement btnAceptarFail) {
		this.btnAceptarFail = btnAceptarFail;
	}

	public WebElement getNvItMenuExamenes() {
		return nvItMenuExamenes;
	}

	public void setNvItMenuExamenes(WebElement nvItMenuExamenes) {
		this.nvItMenuExamenes = nvItMenuExamenes;
	}

	public WebElement getBtnCerrar() {
		return btnCerrar;
	}

	public void setBtnCerrar(WebElement btnCerrar) {
		this.btnCerrar = btnCerrar;
	}

	public WebElement gethFiveTituloOneNuevaReserva() {
		return hFiveTituloOneNuevaReserva;
	}

	public void sethFiveTituloOneNuevaReserva(WebElement hFiveTituloOneNuevaReserva) {
		this.hFiveTituloOneNuevaReserva = hFiveTituloOneNuevaReserva;
	}

	public WebElement getSpnaTituloTwoNombrePaciente() {
		return spnaTituloTwoNombrePaciente;
	}

	public void setSpnaTituloTwoNombrePaciente(WebElement spnaTituloTwoNombrePaciente) {
		this.spnaTituloTwoNombrePaciente = spnaTituloTwoNombrePaciente;
	}

	public WebElement getImgIconoEspecialidad() {
		return imgIconoEspecialidad;
	}

	public void setImgIconoEspecialidad(WebElement imgIconoEspecialidad) {
		this.imgIconoEspecialidad = imgIconoEspecialidad;
	}

	public WebElement getSpnEspecialidad() {
		return spnEspecialidad;
	}

	public void setSpnEspecialidad(WebElement spnEspecialidad) {
		this.spnEspecialidad = spnEspecialidad;
	}

	public WebElement getImgIconoMedicos() {
		return imgIconoMedicos;
	}

	public void setImgIconoMedicos(WebElement imgIconoMedicos) {
		this.imgIconoMedicos = imgIconoMedicos;
	}

	public WebElement getSpnMedicos() {
		return spnMedicos;
	}

	public void setSpnMedicos(WebElement spnMedicos) {
		this.spnMedicos = spnMedicos;
	}

	public WebElement getImgIconoExamenes() {
		return imgIconoExamenes;
	}

	public void setImgIconoExamenes(WebElement imgIconoExamenes) {
		this.imgIconoExamenes = imgIconoExamenes;
	}

	public WebElement getSpnExamenes() {
		return spnExamenes;
	}

	public void setSpnExamenes(WebElement spnExamenes) {
		this.spnExamenes = spnExamenes;
	}

	public WebElement getHsixCamposObligatorios() {
		return hsixCamposObligatorios;
	}

	public void setHsixCamposObligatorios(WebElement hsixCamposObligatorios) {
		this.hsixCamposObligatorios = hsixCamposObligatorios;
	}

	public WebElement getImgIconoBusqueda() {
		return imgIconoBusqueda;
	}

	public void setImgIconoBusqueda(WebElement imgIconoBusqueda) {
		this.imgIconoBusqueda = imgIconoBusqueda;
	}

	public WebElement getLblEspecialidad() {
		return lblEspecialidad;
	}

	public void setLblEspecialidad(WebElement lblEspecialidad) {
		this.lblEspecialidad = lblEspecialidad;
	}

	public WebElement getLbxEspecialidad() {
		return lbxEspecialidad;
	}

	public void setLbxEspecialidad(WebElement lbxEspecialidad) {
		this.lbxEspecialidad = lbxEspecialidad;
	}

	public List<WebElement> getListEspecialidad() {
		return listEspecialidad;
	}

	public void setListEspecialidad(List<WebElement> listEspecialidad) {
		this.listEspecialidad = listEspecialidad;
	}		

	public WebElement getLblPrestacion() {
		return lblPrestacion;
	}

	public void setLblPrestacion(WebElement lblPrestacion) {
		this.lblPrestacion = lblPrestacion;
	}

	public WebElement getLbxPrestacion() {
		return lbxPrestacion;
	}

	public void setLbxPrestacion(WebElement lbxPrestacion) {
		this.lbxPrestacion = lbxPrestacion;
	}

	public List<WebElement> getListPrestacion() {
		return listPrestacion;
	}

	public void setListPrestacion(List<WebElement> listPrestacion) {
		this.listPrestacion = listPrestacion;
	}

	public WebElement getLblRegion() {
		return lblRegion;
	}

	public void setLblRegion(WebElement lblRegion) {
		this.lblRegion = lblRegion;
	}

	public WebElement getLbxRegion() {
		return lbxRegion;
	}

	public void setLbxRegion(WebElement lbxRegion) {
		this.lbxRegion = lbxRegion;
	}	

	public List<WebElement> getListRegion() {
		return listRegion;
	}

	public void setListRegion(List<WebElement> listRegion) {
		this.listRegion = listRegion;
	}

	public WebElement getLblCentroMedico() {
		return lblCentroMedico;
	}

	public void setLblCentroMedico(WebElement lblCentroMedico) {
		this.lblCentroMedico = lblCentroMedico;
	}

	public WebElement getLbxCentroMedico() {
		return lbxCentroMedico;
	}

	public void setLbxCentroMedico(WebElement lbxCentroMedico) {
		this.lbxCentroMedico = lbxCentroMedico;
	}		

	public List<WebElement> getListCentroMedico() {
		return listCentroMedico;
	}

	public void setListCentroMedico(List<WebElement> listCentroMedico) {
		this.listCentroMedico = listCentroMedico;
	}

	public WebElement getBtnCalendarioFechaAvanzada() {
		return btnCalendarioFechaAvanzada;
	}

	public void setBtnCalendarioFechaAvanzada(WebElement btnCalendarioFechaAvanzada) {
		this.btnCalendarioFechaAvanzada = btnCalendarioFechaAvanzada;
	}		
	
	public WebElement getDivConApaBoxMed() {
		return divConApaBoxMed;
	}
	
	public WebElement getHFourSubtituloEspecialidadPrestacionBoxMedico() {
		return hFourSubtituloEspecialidadPrestacionBoxMedico;
	}

	public void setHFourSubtituloEspecialidadPrestacionBoxMedico(WebElement hFourSubtituloEspecialidadPrestacionBoxMedico) {
		this.hFourSubtituloEspecialidadPrestacionBoxMedico = hFourSubtituloEspecialidadPrestacionBoxMedico;
	}

	public WebElement getHFiveSubtituloCentroMedicoBoxMedico() {
		return hFiveSubtituloCentroMedicoBoxMedico;
	}

	public void setHFiveSubtituloCentroMedicoBoxMedico(WebElement hFiveSubtituloCentroMedicoBoxMedico) {
		this.hFiveSubtituloCentroMedicoBoxMedico = hFiveSubtituloCentroMedicoBoxMedico;
	}

	public void setDivConApaBoxMed(WebElement divConApaBoxMed) {
		this.divConApaBoxMed = divConApaBoxMed;
	}

	public WebElement getTrNombreDia() {
		return TrNombreDia;
	}

	public void setTrNombreDia(WebElement trNombreDia) {
		TrNombreDia = trNombreDia;
	}

	public WebElement getTrFechasMostradas() {
		return trFechasMostradas;
	}

	public void setTrFechasMostradas(WebElement trFechasMostradas) {
		this.trFechasMostradas = trFechasMostradas;
	}

	public List<WebElement> getListFechasActivas() {
		return listFechasActivas;
	}

	public void setListFechasActivas(List<WebElement> listFechasActivas) {
		this.listFechasActivas = listFechasActivas;
	}

	public List<WebElement> getListFechasInactivas() {
		return listFechasInactivas;
	}

	public void setListFechasInactivas(List<WebElement> listFechasInactivas) {
		this.listFechasInactivas = listFechasInactivas;
	}

	public List<WebElement> getListHorarios() {
		return listHorarios;
	}

	public void setListHorarios(List<WebElement> listHorarios) {
		this.listHorarios = listHorarios;
	}	

	public WebElement gethFiveTituloReservaSemana() {
		return hFiveTituloReservaSemana;
	}

	public void sethFiveTituloReservaSemana(WebElement hFiveTituloReservaSemana) {
		this.hFiveTituloReservaSemana = hFiveTituloReservaSemana;
	}

	public WebElement gethSixTituloReservaSemana() {
		return hSixTituloReservaSemana;
	}

	public void sethSixTituloReservaSemana(WebElement hSixTituloReservaSemana) {
		this.hSixTituloReservaSemana = hSixTituloReservaSemana;
	}	
	
	public WebElement getDivCalendarioExtendido() {
		return divCalendarioExtendido;
	}

	public void setDivCalendarioExtendido(WebElement divCalendarioExtendido) {
		this.divCalendarioExtendido = divCalendarioExtendido;
	}

	public WebElement gethFourTituloBusquedaAvanzada() {
		return hFourTituloBusquedaAvanzada;
	}

	public void sethFourTituloBusquedaAvanzada(WebElement hFourTituloBusquedaAvanzada) {
		this.hFourTituloBusquedaAvanzada = hFourTituloBusquedaAvanzada;
	}

	public WebElement gethFiveSeleccionMesSemana() {
		return hFiveSeleccionMesSemana;
	}

	public void sethFiveSeleccionMesSemana(WebElement hFiveSeleccionMesSemana) {
		this.hFiveSeleccionMesSemana = hFiveSeleccionMesSemana;
	}

	public WebElement getBtnMesAnterior() {
		return btnMesAnterior;
	}

	public void setBtnMesAnterior(WebElement btnMesAnterior) {
		this.btnMesAnterior = btnMesAnterior;
	}	
	
	public List<WebElement> getDtpMes() {
		return dtpMes;
	}

	public void setDtpMes(List<WebElement> dtpMes) {
		this.dtpMes = dtpMes;
	}

	public List<WebElement> getListMes() {
		return listMes;
	}

	public void setListMes(List<WebElement> listMes) {
		this.listMes = listMes;
	}
	
	public List<WebElement> getDtpAño() {
		return dtpAño;
	}

	public void setDtpAño(List<WebElement> dtpAño) {
		this.dtpAño = dtpAño;
	}

	public List<WebElement> getListAño() {
		return listAño;
	}

	public void setListAño(List<WebElement> listAño) {
		this.listAño = listAño;
	}

	public WebElement getBtnMesSiguiente() {
		return btnMesSiguiente;
	}

	public void setBtnMesSiguiente(WebElement btnMesSiguiente) {
		this.btnMesSiguiente = btnMesSiguiente;
	}	
	
	public List<WebElement> getListDiaActivo() {
		return listDiaActivo;
	}

	public void setListDiaActivo(List<WebElement> listDiaActivo) {
		this.listDiaActivo = listDiaActivo;
	}
	
	public WebElement getDivApartadoBxExamenes() {
		return divApartadoBxExamenes;
	}

	public void setDivApartadoBxExamenes(WebElement divApartadoBxExamenes) {
		this.divApartadoBxExamenes = divApartadoBxExamenes;
	}

	public WebElement gethThreeTituloFechaSeleccionadaExa() {
		return hThreeTituloFechaSeleccionadaExa;
	}

	public void sethThreeTituloFechaSeleccionadaExa(WebElement hThreeTituloFechaSeleccionadaExa) {
		this.hThreeTituloFechaSeleccionadaExa = hThreeTituloFechaSeleccionadaExa;
	}

	public WebElement gethFourDisponibilidadHoraMedicoExa() {
		return hFourDisponibilidadHoraMedicoExa;
	}

	public void sethFourDisponibilidadHoraMedicoExa(WebElement hFourDisponibilidadHoraMedicoExa) {
		this.hFourDisponibilidadHoraMedicoExa = hFourDisponibilidadHoraMedicoExa;
	}

	public WebElement getLblHorarioMañanaExa() {
		return lblHorarioMañanaExa;
	}

	public void setLblHorarioMañanaExa(WebElement lblHorarioMañanaExa) {
		this.lblHorarioMañanaExa = lblHorarioMañanaExa;
	}

	public WebElement getUlListadoExamenesMañanaExa() {
		return ulListadoExamenesMañanaExa;
	}

	public void setUlListadoExamenesMañanaExa(WebElement ulListadoExamenesMañanaExa) {
		this.ulListadoExamenesMañanaExa = ulListadoExamenesMañanaExa;
	}

	public WebElement getLblHorarioTardeExa() {
		return lblHorarioTardeExa;
	}

	public void setLblHorarioTardeExa(WebElement lblHorarioTardeExa) {
		this.lblHorarioTardeExa = lblHorarioTardeExa;
	}

	public WebElement getUlListadoExamenesTardeExa() {
		return ulListadoExamenesTardeExa;
	}

	public void setUlListadoExamenesTardeExa(WebElement ulListadoExamenesTardeExa) {
		this.ulListadoExamenesTardeExa = ulListadoExamenesTardeExa;
	}

	public WebElement getDivResumenExamenes() {
		return divResumenExamenes;
	}

	public void setDivResumenExamenes(WebElement divResumenExamenes) {
		this.divResumenExamenes = divResumenExamenes;
	}

	public WebElement getDivSeccionExamen() {
		return divSeccionExamen;
	}

	public void setDivSeccionExamen(WebElement divSeccionExamen) {
		this.divSeccionExamen = divSeccionExamen;
	}

	public WebElement getImgIconoExamenExa() {
		return imgIconoExamenExa;
	}

	public void setImgIconoExamenExa(WebElement imgIconoExamenExa) {
		this.imgIconoExamenExa = imgIconoExamenExa;
	}

	public WebElement gethThreeEspecialidadExa() {
		return hThreeEspecialidadExa;
	}

	public void sethThreeEspecialidadExa(WebElement hThreeEspecialidadExa) {
		this.hThreeEspecialidadExa = hThreeEspecialidadExa;
	}

	public WebElement gethSixCentroMedicoExa() {
		return hSixCentroMedicoExa;
	}

	public void sethSixCentroMedicoExa(WebElement hSixCentroMedicoExa) {
		this.hSixCentroMedicoExa = hSixCentroMedicoExa;
	}

	public WebElement getImgIconoGeneroExa() {
		return imgIconoGeneroExa;
	}

	public void setImgIconoGeneroExa(WebElement imgIconoGeneroExa) {
		this.imgIconoGeneroExa = imgIconoGeneroExa;
	}

	public WebElement gethFiveNombrePacienteExa() {
		return hFiveNombrePacienteExa;
	}

	public void sethFiveNombrePacienteExa(WebElement hFiveNombrePacienteExa) {
		this.hFiveNombrePacienteExa = hFiveNombrePacienteExa;
	}

	public WebElement getpMailPacienteExa() {
		return pMailPacienteExa;
	}

	public void setpMailPacienteExa(WebElement pMailPacienteExa) {
		this.pMailPacienteExa = pMailPacienteExa;
	}

	public WebElement getImgIconoCalendarioExa() {
		return imgIconoCalendarioExa;
	}

	public void setImgIconoCalendarioExa(WebElement imgIconoCalendarioExa) {
		this.imgIconoCalendarioExa = imgIconoCalendarioExa;
	}

	public WebElement getSpnFechaExamenExa() {
		return spnFechaExamenExa;
	}

	public void setSpnFechaExamenExa(WebElement spnFechaExamenExa) {
		this.spnFechaExamenExa = spnFechaExamenExa;
	}

	public WebElement getImgIconoHorarioExamenExa() {
		return imgIconoHorarioExamenExa;
	}

	public void setImgIconoHorarioExamenExa(WebElement imgIconoHorarioExamenExa) {
		this.imgIconoHorarioExamenExa = imgIconoHorarioExamenExa;
	}

	public WebElement getSpanHorarioExamenExa() {
		return spanHorarioExamenExa;
	}

	public void setSpanHorarioExamenExa(WebElement spanHorarioExamenExa) {
		this.spanHorarioExamenExa = spanHorarioExamenExa;
	}

	public WebElement getImgIconoPagoExa() {
		return imgIconoPagoExa;
	}

	public void setImgIconoPagoExa(WebElement imgIconoPagoExa) {
		this.imgIconoPagoExa = imgIconoPagoExa;
	}

	public WebElement getSpnMontoPagoExa() {
		return spnMontoPagoExa;
	}

	public void setSpnMontoPagoExa(WebElement spnMontoPagoExa) {
		this.spnMontoPagoExa = spnMontoPagoExa;
	}

	public WebElement getBtnAgendarExa() {
		return btnAgendarExa;
	}

	public void setBtnAgendarExa(WebElement btnAgendarExa) {
		this.btnAgendarExa = btnAgendarExa;
	}

	public WebElement getDivLeerIndicaciones() {
		return divLeerIndicaciones;
	}

	public void setDivLeerIndicaciones(WebElement divLeerIndicaciones) {
		this.divLeerIndicaciones = divLeerIndicaciones;
	}

	public WebElement gethFiveTituloLeerIndicaciones() {
		return hFiveTituloLeerIndicaciones;
	}

	public void sethFiveTituloLeerIndicaciones(WebElement hFiveTituloLeerIndicaciones) {
		this.hFiveTituloLeerIndicaciones = hFiveTituloLeerIndicaciones;
	}

	public WebElement getDivListadoLeerIndicaciones() {
		return divListadoLeerIndicaciones;
	}

	public void setDivListadoLeerIndicaciones(WebElement divListadoLeerIndicaciones) {
		this.divListadoLeerIndicaciones = divListadoLeerIndicaciones;
	}
	
	public List<WebElement> getLiListadoLeerIndicaciones() {
		return liListadoLeerIndicaciones;
	}

	public void setLiListadoLeerIndicaciones(List<WebElement> liListadoLeerIndicaciones) {
		this.liListadoLeerIndicaciones = liListadoLeerIndicaciones;
	}

	public WebElement getLblPrestacionSinIndicaciones() {
		return lblPrestacionSinIndicaciones;
	}

	public void setLblPrestacionSinIndicaciones(WebElement lblPrestacionSinIndicaciones) {
		this.lblPrestacionSinIndicaciones = lblPrestacionSinIndicaciones;
	}

	public WebElement getBtnHeLeidoLasIndicaciones() {
		return btnHeLeidoLasIndicaciones;
	}

	public void setBtnHeLeidoLasIndicaciones(WebElement btnHeLeidoLasIndicaciones) {
		this.btnHeLeidoLasIndicaciones = btnHeLeidoLasIndicaciones;
	}

	public WebElement getBtnHeLeidoLasIndicacionesOcm() {
		return btnHeLeidoLasIndicacionesOcm;
	}

	public void setBtnHeLeidoLasIndicacionesOcm(WebElement btnHeLeidoLasIndicacionesOcm) {
		this.btnHeLeidoLasIndicacionesOcm = btnHeLeidoLasIndicacionesOcm;
	}

	public WebElement getBtnAnularReserva() {
		return btnAnularReserva;
	}

	public void setBtnAnularReserva(WebElement btnAnularReserva) {
		this.btnAnularReserva = btnAnularReserva;
	}
	
	public WebElement getDivNuevaReserva() {
		return divNuevaReserva;
	}

	public void setDivNuevaReserva(WebElement divNuevaReserva) {
		this.divNuevaReserva = divNuevaReserva;
	}
	
	public List<WebElement> getBtnCerrarNuevaReserva() {
		return btnCerrarNuevaReserva;
	}

	public void setBtnCerrarNuevaReserva(List<WebElement> btnCerrarNuevaReserva) {
		this.btnCerrarNuevaReserva = btnCerrarNuevaReserva;
	}

	public WebElement gethFiveNuevaReserva() {
		return hFiveNuevaReserva;
	}

	public void sethFiveNuevaReserva(WebElement hFiveNuevaReserva) {
		this.hFiveNuevaReserva = hFiveNuevaReserva;
	}

	public WebElement getSpnNombrePaciente() {
		return spnNombrePaciente;
	}

	public void setSpnNombrePaciente(WebElement spnNombrePaciente) {
		this.spnNombrePaciente = spnNombrePaciente;
	}

	public WebElement getImgIconoEspecialidadEsp() {
		return imgIconoEspecialidadEsp;
	}

	public void setImgIconoEspecialidadEsp(WebElement imgIconoEspecialidadEsp) {
		this.imgIconoEspecialidadEsp = imgIconoEspecialidadEsp;
	}

	public WebElement getTbEspecialidad() {
		return tbEspecialidad;
	}

	public void setTbEspecialidad(WebElement tbEspecialidad) {
		this.tbEspecialidad = tbEspecialidad;
	}

	public WebElement getDivHeaderFechas() {
		return divHeaderFechas;
	}

	public void setDivHeaderFechas(WebElement divHeaderFechas) {
		this.divHeaderFechas = divHeaderFechas;
	}	
	
	public WebElement getDivApartadoHoras() {
		return divApartadoHoras;
	}

	public void setDivApartadoHoras(WebElement divApartadoHoras) {
		this.divApartadoHoras = divApartadoHoras;
	}

	public WebElement gethThreeFechaEspecialidad() {
		return hThreeFechaEspecialidad;
	}

	public void sethThreeFechaEspecialidad(WebElement hThreeFechaEspecialidad) {
		this.hThreeFechaEspecialidad = hThreeFechaEspecialidad;
	}

	public WebElement gethFourNombreEspecialidadPrestacion() {
		return hFourNombreEspecialidadPrestacion;
	}

	public void sethFourNombreEspecialidadPrestacion(WebElement hFourNombreEspecialidadPrestacion) {
		this.hFourNombreEspecialidadPrestacion = hFourNombreEspecialidadPrestacion;
	}

	public WebElement gethFiveNombreCentroMedicoEspecialidad() {
		return hFiveNombreCentroMedicoEspecialidad;
	}

	public void sethFiveNombreCentroMedicoEspecialidad(WebElement hFiveNombreCentroMedicoEspecialidad) {
		this.hFiveNombreCentroMedicoEspecialidad = hFiveNombreCentroMedicoEspecialidad;
	}

	public WebElement getDivApartadoBxEspecialidad() {
		return divApartadoBxEspecialidad;
	}

	public void setDivApartadoBxEspecialidad(WebElement divApartadoBxEspecialidad) {
		this.divApartadoBxEspecialidad = divApartadoBxEspecialidad;
	}
	
	public List<WebElement> getListDoctores() {
		return listDoctores;
	}

	public void setListDoctores(List<WebElement> listDoctores) {
		this.listDoctores = listDoctores;
	}

	public List<WebElement> getListImagenesDoctores() {
		return listImagenesDoctores;
	}

	public void setListImagenesDoctores(List<WebElement> listImagenesDoctores) {
		this.listImagenesDoctores = listImagenesDoctores;
	}

	public List<WebElement> getListNombreDoctores() {
		return listNombreDoctores;
	}

	public void setListNombreDoctores(List<WebElement> listNombreDoctores) {
		this.listNombreDoctores = listNombreDoctores;
	}

	public List<WebElement> getListConvenioDoctores() {
		return listConvenioDoctores;
	}

	public void setListConvenioDoctores(List<WebElement> listConvenioDoctores) {
		this.listConvenioDoctores = listConvenioDoctores;
	}
	
	public List<WebElement> getListImagenesIconoMañanaDoctores() {
		return listImagenesIconoMañanaDoctores;
	}

	public void setListImagenesIconoMañanaDoctores(List<WebElement> listImagenesIconoMañanaDoctores) {
		this.listImagenesIconoMañanaDoctores = listImagenesIconoMañanaDoctores;
	}

	public List<WebElement> getListImagenesIconoTardeDoctores() {
		return listImagenesIconoTardeDoctores;
	}

	public List<WebElement> getListSeparadorDoctores() {
		return listSeparadorDoctores;
	}

	public void setListSeparadorDoctores(List<WebElement> listSeparadorDoctores) {
		this.listSeparadorDoctores = listSeparadorDoctores;
	}

	public List<WebElement> getListCarruselHorasDoctores() {
		return listCarruselHorasDoctores;
	}

	public void setListCarruselHorasDoctores(List<WebElement> listCarruselHorasDoctores) {
		this.listCarruselHorasDoctores = listCarruselHorasDoctores;
	}

	public void setListImagenesIconoTardeDoctores(List<WebElement> listImagenesIconoTardeDoctores) {
		this.listImagenesIconoTardeDoctores = listImagenesIconoTardeDoctores;
	}

	public WebElement getDivResumenEspecialidad() {
		return divResumenEspecialidad;
	}

	public void setDivResumenEspecialidad(WebElement divResumenEspecialidad) {
		this.divResumenEspecialidad = divResumenEspecialidad;
	}

	public WebElement getImgIconoDoctorEsp() {
		return imgIconoDoctorEsp;
	}

	public void setImgIconoDoctorEsp(WebElement imgIconoDoctorEsp) {
		this.imgIconoDoctorEsp = imgIconoDoctorEsp;
	}

	public WebElement gethThreeNombreDoctorEsp() {
		return hThreeNombreDoctorEsp;
	}

	public void sethThreeNombreDoctorEsp(WebElement hThreeNombreDoctorEsp) {
		this.hThreeNombreDoctorEsp = hThreeNombreDoctorEsp;
	}

	public WebElement gethThreePrestacionDoctorEsp() {
		return hThreePrestacionDoctorEsp;
	}

	public void sethThreePrestacionDoctorEsp(WebElement hThreePrestacionDoctorEsp) {
		this.hThreePrestacionDoctorEsp = hThreePrestacionDoctorEsp;
	}

	public WebElement gethSixCentroMedicoEsp() {
		return hSixCentroMedicoEsp;
	}

	public void sethSixCentroMedicoEsp(WebElement hSixCentroMedicoEsp) {
		this.hSixCentroMedicoEsp = hSixCentroMedicoEsp;
	}

	public WebElement getDivSeccionPaciente() {
		return divSeccionPaciente;
	}

	public void setDivSeccionPaciente(WebElement divSeccionPaciente) {
		this.divSeccionPaciente = divSeccionPaciente;
	}

	public WebElement getImgIconoGeneroEsp() {
		return imgIconoGeneroEsp;
	}

	public void setImgIconoGeneroEsp(WebElement imgIconoGeneroEsp) {
		this.imgIconoGeneroEsp = imgIconoGeneroEsp;
	}

	public WebElement gethFiveNombrePacienteEsp() {
		return hFiveNombrePacienteEsp;
	}

	public void sethFiveNombrePacienteEsp(WebElement hFiveNombrePacienteEsp) {
		this.hFiveNombrePacienteEsp = hFiveNombrePacienteEsp;
	}

	public WebElement getPCorreoPacienteEsp() {
		return pCorreoPacienteEsp;
	}

	public void setPCorreoPacienteEsp(WebElement pCorreoPacienteEsp) {
		this.pCorreoPacienteEsp = pCorreoPacienteEsp;
	}

	public WebElement getpCorreoPacienteEsp() {
		return pCorreoPacienteEsp;
	}

	public void setpCorreoPacienteEsp(WebElement pCorreoPacienteEsp) {
		this.pCorreoPacienteEsp = pCorreoPacienteEsp;
	}

	public WebElement getDivSeccionConsulta() {
		return divSeccionConsulta;
	}

	public void setDivSeccionConsulta(WebElement divSeccionConsulta) {
		this.divSeccionConsulta = divSeccionConsulta;
	}

	public WebElement getImgIconoCalendarioEsp() {
		return imgIconoCalendarioEsp;
	}

	public void setImgIconoCalendarioEsp(WebElement imgIconoCalendarioEsp) {
		this.imgIconoCalendarioEsp = imgIconoCalendarioEsp;
	}

	public WebElement getSpnFechaConsultaEsp() {
		return spnFechaConsultaEsp;
	}

	public void setSpnFechaConsultaEsp(WebElement spnFechaConsultaEsp) {
		this.spnFechaConsultaEsp = spnFechaConsultaEsp;
	}

	public WebElement getImgIconoHorarioEsp() {
		return imgIconoHorarioEsp;
	}

	public void setImgIconoHorarioEsp(WebElement imgIconoHorarioEsp) {
		this.imgIconoHorarioEsp = imgIconoHorarioEsp;
	}

	public WebElement getSpnHoraConsultaEsp() {
		return spnHoraConsultaEsp;
	}

	public void setSpnHoraConsultaEsp(WebElement spnHoraConsultaEsp) {
		this.spnHoraConsultaEsp = spnHoraConsultaEsp;
	}

	public WebElement getImgIconoPagoEsp() {
		return imgIconoPagoEsp;
	}

	public void setImgIconoPagoEsp(WebElement imgIconoPagoEsp) {
		this.imgIconoPagoEsp = imgIconoPagoEsp;
	}

	public WebElement getSpnCostoConsultaEsp() {
		return spnCostoConsultaEsp;
	}

	public void setSpnCostoConsultaEsp(WebElement spnCostoConsultaEsp) {
		this.spnCostoConsultaEsp = spnCostoConsultaEsp;
	}

	public WebElement getBtnAgendarEsp() {
		return btnAgendarEsp;
	}

	public void setBtnAgendarEsp(WebElement btnAgendarEsp) {
		this.btnAgendarEsp = btnAgendarEsp;
	}

	public WebElement getDivCrearEditarPaciente() {
		return divCrearEditarPaciente;
	}

	public void setDivCrearEditarPaciente(WebElement divCrearEditarPaciente) {
		this.divCrearEditarPaciente = divCrearEditarPaciente;
	}
	
	public WebElement getBtnClose() {
		return btnClose;
	}

	public void setBtnClose(WebElement btnClose) {
		this.btnClose = btnClose;
	}

	public WebElement gethFiveTituloCrearEditarDatosPaciente() {
		return hFiveTituloCrearEditarDatosPaciente;
	}

	public void sethFiveTituloCrearEditarDatosPaciente(WebElement hFiveTituloCrearEditarDatosPaciente) {
		this.hFiveTituloCrearEditarDatosPaciente = hFiveTituloCrearEditarDatosPaciente;
	}

	public WebElement gethSixSubTituloPacienteRegistradoRevisarRut() {
		return hSixSubTituloPacienteRegistradoRevisarRut;
	}

	public void sethSixSubTituloPacienteRegistradoRevisarRut(WebElement hSixSubTituloPacienteRegistradoRevisarRut) {
		this.hSixSubTituloPacienteRegistradoRevisarRut = hSixSubTituloPacienteRegistradoRevisarRut;
	}

	public WebElement getLblRut() {
		return lblRut;
	}

	public void setLblRut(WebElement lblRut) {
		this.lblRut = lblRut;
	}

	public WebElement getTxtRut() {
		return txtRut;
	}

	public void setTxtRut(WebElement txtRut) {
		this.txtRut = txtRut;
	}

	public WebElement getLblNombres() {
		return lblNombres;
	}

	public void setLblNombres(WebElement lblNombres) {
		this.lblNombres = lblNombres;
	}

	public WebElement getTxtNombres() {
		return txtNombres;
	}

	public void setTxtNombres(WebElement txtNombres) {
		this.txtNombres = txtNombres;
	}

	public WebElement getLblApellidos() {
		return lblApellidos;
	}

	public void setLblApellidos(WebElement lblApellidos) {
		this.lblApellidos = lblApellidos;
	}

	public WebElement getTxtApellidoMaterno() {
		return txtApellidoMaterno;
	}

	public void setTxtApellidoMaterno(WebElement txtApellidoMaterno) {
		this.txtApellidoMaterno = txtApellidoMaterno;
	}

	public WebElement getTxtApellidoPaterno() {
		return txtApellidoPaterno;
	}

	public void setTxtApellidoPaterno(WebElement txtApellidoPaterno) {
		this.txtApellidoPaterno = txtApellidoPaterno;
	}

	public WebElement getLblFechaNacimiento() {
		return lblFechaNacimiento;
	}

	public void setLblFechaNacimiento(WebElement lblFechaNacimiento) {
		this.lblFechaNacimiento = lblFechaNacimiento;
	}

	public WebElement getTxtFechaDia() {
		return txtFechaDia;
	}

	public void setTxtFechaDia(WebElement txtFechaDia) {
		this.txtFechaDia = txtFechaDia;
	}

	public WebElement getTxtFechaMes() {
		return txtFechaMes;
	}

	public void setTxtFechaMes(WebElement txtFechaMes) {
		this.txtFechaMes = txtFechaMes;
	}

	public WebElement getTxtFechaAño() {
		return txtFechaAño;
	}

	public void setTxtFechaAño(WebElement txtFechaAño) {
		this.txtFechaAño = txtFechaAño;
	}

	public WebElement getLblGenero() {
		return lblGenero;
	}

	public void setLblGenero(WebElement lblGenero) {
		this.lblGenero = lblGenero;
	}

	public WebElement getLbxGenero() {
		return lbxGenero;
	}

	public void setLbxGenero(WebElement lbxGenero) {
		this.lbxGenero = lbxGenero;
	}

	public List<WebElement> getListGenero() {
		return listGenero;
	}

	public void setListGenero(List<WebElement> listGenero) {
		this.listGenero = listGenero;
	}

	public WebElement getLblPrevision() {
		return lblPrevision;
	}

	public void setLblPrevision(WebElement lblPrevision) {
		this.lblPrevision = lblPrevision;
	}

	public WebElement getLbxPrevision() {
		return lbxPrevision;
	}

	public void setLbxPrevision(WebElement lbxPrevision) {
		this.lbxPrevision = lbxPrevision;
	}

	public List<WebElement> getListPrevision() {
		return listPrevision;
	}

	public void setListPrevision(List<WebElement> listPrevision) {
		this.listPrevision = listPrevision;
	}

	public WebElement getLblCorreo() {
		return lblCorreo;
	}

	public void setLblCorreo(WebElement lblCorreo) {
		this.lblCorreo = lblCorreo;
	}

	public WebElement getTxtCorreo() {
		return txtCorreo;
	}

	public void setTxtCorreo(WebElement txtCorreo) {
		this.txtCorreo = txtCorreo;
	}

	public WebElement getLblTelefono() {
		return lblTelefono;
	}

	public void setLblTelefono(WebElement lblTelefono) {
		this.lblTelefono = lblTelefono;
	}

	public WebElement getTxtTelefono() {
		return txtTelefono;
	}

	public void setTxtTelefono(WebElement txtTelefono) {
		this.txtTelefono = txtTelefono;
	}

	public WebElement getLblNacionalidad() {
		return lblNacionalidad;
	}

	public void setLblNacionalidad(WebElement lblNacionalidad) {
		this.lblNacionalidad = lblNacionalidad;
	}

	public WebElement getLbxNacionalidad() {
		return lbxNacionalidad;
	}

	public void setLbxNacionalidad(WebElement lbxNacionalidad) {
		this.lbxNacionalidad = lbxNacionalidad;
	}

	public List<WebElement> getListNacionalidad() {
		return listNacionalidad;
	}

	public void setListNacionalidad(List<WebElement> listNacionalidad) {
		this.listNacionalidad = listNacionalidad;
	}

	public WebElement getLblDireccion() {
		return lblDireccion;
	}

	public void setLblDireccion(WebElement lblDireccion) {
		this.lblDireccion = lblDireccion;
	}

	public WebElement getTxtDireccion() {
		return txtDireccion;
	}

	public void setTxtDireccion(WebElement txtDireccion) {
		this.txtDireccion = txtDireccion;
	}

	public WebElement getTxtComuna() {
		return txtComuna;
	}

	public void setTxtComuna(WebElement txtComuna) {
		this.txtComuna = txtComuna;
	}

	public WebElement getLbxRegiones() {
		return lbxRegiones;
	}

	public void setLbxRegiones(WebElement lbxRegiones) {
		this.lbxRegiones = lbxRegiones;
	}

	public List<WebElement> getListRegiones() {
		return listRegiones;
	}

	public void setListRegiones(List<WebElement> listRegiones) {
		this.listRegiones = listRegiones;
	}

	public WebElement getBtnGuardar() {
		return btnGuardar;
	}

	public void setBtnGuardar(WebElement btnGuardar) {
		this.btnGuardar = btnGuardar;
	}

	public WebElement getImgIconoMedico() {
		return imgIconoMedico;
	}

	public void setImgIconoMedico(WebElement imgIconoMedico) {
		this.imgIconoMedico = imgIconoMedico;
	}

	public WebElement getTbMedicos() {
		return tbMedicos;
	}

	public void setTbMedicos(WebElement tbMedicos) {
		this.tbMedicos = tbMedicos;
	}

	public WebElement getDivMedicos() {
		return divMedicos;
	}

	public void setDivMedicos(WebElement divMedicos) {
		this.divMedicos = divMedicos;
	}

	public List<WebElement> getLbxMedico() {
		return lbxMedico;
	}

	public void setLbxMedico(List<WebElement> lbxMedico) {
		this.lbxMedico = lbxMedico;
	}

	public List<WebElement> getListMedico() {
		return listMedico;
	}

	public void setListMedico(List<WebElement> listMedico) {
		this.listMedico = listMedico;
	}

	public WebElement gethFourSubtituloEspecialidadPrestacionBoxMedico() {
		return hFourSubtituloEspecialidadPrestacionBoxMedico;
	}

	public void sethFourSubtituloEspecialidadPrestacionBoxMedico(WebElement hFourSubtituloEspecialidadPrestacionBoxMedico) {
		this.hFourSubtituloEspecialidadPrestacionBoxMedico = hFourSubtituloEspecialidadPrestacionBoxMedico;
	}

	public WebElement gethFiveSubtituloCentroMedicoBoxMedico() {
		return hFiveSubtituloCentroMedicoBoxMedico;
	}

	public void sethFiveSubtituloCentroMedicoBoxMedico(WebElement hFiveSubtituloCentroMedicoBoxMedico) {
		this.hFiveSubtituloCentroMedicoBoxMedico = hFiveSubtituloCentroMedicoBoxMedico;
	}

	public List<WebElement> getDivOcmPendientesPacienteSeccionGeneral() {
		return divOcmPendientesPacienteSeccionGeneral;
	}

	public void setDivOcmPendientesPacienteSeccionGeneral(List<WebElement> divOcmPendientesPacienteSeccionGeneral) {
		this.divOcmPendientesPacienteSeccionGeneral = divOcmPendientesPacienteSeccionGeneral;
	}

	public List<WebElement> getDivSeccionInformacionPaciente() {
		return divSeccionInformacionPaciente;
	}

	public void setDivSeccionInformacionPaciente(List<WebElement> divSeccionInformacionPaciente) {
		this.divSeccionInformacionPaciente = divSeccionInformacionPaciente;
	}

	public WebElement getImgIconoPacienteOcmPendiente() {
		return imgIconoPacienteOcmPendiente;
	}

	public void setImgIconoPacienteOcmPendiente(WebElement imgIconoPacienteOcmPendiente) {
		this.imgIconoPacienteOcmPendiente = imgIconoPacienteOcmPendiente;
	}

	public WebElement gethFiveNombrePacienteOcmPendiente() {
		return hFiveNombrePacienteOcmPendiente;
	}

	public void sethFiveNombrePacienteOcmPendiente(WebElement hFiveNombrePacienteOcmPendiente) {
		this.hFiveNombrePacienteOcmPendiente = hFiveNombrePacienteOcmPendiente;
	}

	public WebElement getLblGeneroFechaNacimientoOcmPendiente() {
		return lblGeneroFechaNacimientoOcmPendiente;
	}

	public void setLblGeneroFechaNacimientoOcmPendiente(WebElement lblGeneroFechaNacimientoOcmPendiente) {
		this.lblGeneroFechaNacimientoOcmPendiente = lblGeneroFechaNacimientoOcmPendiente;
	}

	public WebElement getLblCorreoOcmPendiente() {
		return lblCorreoOcmPendiente;
	}

	public void setLblCorreoOcmPendiente(WebElement lblCorreoOcmPendiente) {
		this.lblCorreoOcmPendiente = lblCorreoOcmPendiente;
	}

	public WebElement getLblTelefonoOcmPendiente() {
		return lblTelefonoOcmPendiente;
	}

	public void setLblTelefonoOcmPendiente(WebElement lblTelefonoOcmPendiente) {
		this.lblTelefonoOcmPendiente = lblTelefonoOcmPendiente;
	}

	public WebElement getLblRutOcmPendiente() {
		return lblRutOcmPendiente;
	}

	public void setLblRutOcmPendiente(WebElement lblRutOcmPendiente) {
		this.lblRutOcmPendiente = lblRutOcmPendiente;
	}

	public WebElement getLblPrevisionOcmPendiente() {
		return lblPrevisionOcmPendiente;
	}

	public void setLblPrevisionOcmPendiente(WebElement lblPrevisionOcmPendiente) {
		this.lblPrevisionOcmPendiente = lblPrevisionOcmPendiente;
	}

	public List<WebElement> getLnkDatosPacienteOcmPendiente() {
		return lnkDatosPacienteOcmPendiente;
	}

	public void setLnkDatosPacienteOcmPendiente(List<WebElement> lnkDatosPacienteOcmPendiente) {
		this.lnkDatosPacienteOcmPendiente = lnkDatosPacienteOcmPendiente;
	}

	public List<WebElement> getDivBotoneraNuevasReservasOcmPendiente() {
		return divBotoneraNuevasReservasOcmPendiente;
	}

	public void setDivBotoneraNuevasReservasOcmPendiente(List<WebElement> divBotoneraNuevasReservasOcmPendiente) {
		this.divBotoneraNuevasReservasOcmPendiente = divBotoneraNuevasReservasOcmPendiente;
	}
	
	public WebElement getBtnNuevaReservaHoraOcmPendiente() {
		return btnNuevaReservaHoraOcmPendiente;
	}

	public void setBtnNuevaReservaHoraOcmPendiente(WebElement btnNuevaReservaHoraOcmPendiente) {
		this.btnNuevaReservaHoraOcmPendiente = btnNuevaReservaHoraOcmPendiente;
	}

	public List<WebElement> getBtnReservaHoraAndPrecioOcmPendiente() {
		return btnReservaHoraAndPrecioOcmPendiente;
	}

	public void setBtnReservaHoraAndPrecioOcmPendiente(List<WebElement> btnReservaHoraAndPrecioOcmPendiente) {
		this.btnReservaHoraAndPrecioOcmPendiente = btnReservaHoraAndPrecioOcmPendiente;
	}

	public List<WebElement> getBtnReenviarEmailAgendarOcmPendiente() {
		return btnReenviarEmailAgendarOcmPendiente;
	}

	public void setBtnReenviarEmailAgendarOcmPendiente(List<WebElement> btnReenviarEmailAgendarOcmPendiente) {
		this.btnReenviarEmailAgendarOcmPendiente = btnReenviarEmailAgendarOcmPendiente;
	}

	public List<WebElement> getDivOcmSeccionBoxAgendamiento() {
		return divOcmSeccionBoxAgendamiento;
	}

	public void setDivOcmSeccionBoxAgendamiento(List<WebElement> divOcmSeccionBoxAgendamiento) {
		this.divOcmSeccionBoxAgendamiento = divOcmSeccionBoxAgendamiento;
	}

	public WebElement getTabContenedorTabAgendamiento() {
		return tabContenedorTabAgendamiento;
	}

	public void setTabContenedorTabAgendamiento(WebElement tabContenedorTabAgendamiento) {
		this.tabContenedorTabAgendamiento = tabContenedorTabAgendamiento;
	}

	public WebElement getTabPorGestionar() {
		return tabPorGestionar;
	}

	public void setTabPorGestionar(WebElement tabPorGestionar) {
		this.tabPorGestionar = tabPorGestionar;
	}

	public WebElement getTabGestionado() {
		return tabGestionado;
	}

	public void setTabGestionado(WebElement tabGestionado) {
		this.tabGestionado = tabGestionado;
	}

	public WebElement getTblAgendar() {
		return tblAgendar;
	}

	public void setTblAgendar(WebElement tblAgendar) {
		this.tblAgendar = tblAgendar;
	}

	public WebElement getTblAgendado() {
		return tblAgendado;
	}

	public void setTblAgendado(WebElement tblAgendado) {
		this.tblAgendado = tblAgendado;
	}

	public List<WebElement> getTbhCabezaraTablaAgendar() {
		return tbhCabezaraTablaAgendar;
	}

	public void setTbhCabezaraTablaAgendar(List<WebElement> tbhCabezaraTablaAgendar) {
		this.tbhCabezaraTablaAgendar = tbhCabezaraTablaAgendar;
	}

	public List<WebElement> getTbhCabeceraTablaPorGestionarIconoOrden() {
		return tbhCabeceraTablaPorGestionarIconoOrden;
	}

	public void setTbhCabeceraTablaPorGestionarIconoOrden(List<WebElement> tbhCabeceraTablaPorGestionarIconoOrden) {
		this.tbhCabeceraTablaPorGestionarIconoOrden = tbhCabeceraTablaPorGestionarIconoOrden;
	}

	public List<WebElement> getTbhCabeceraTablaGestionado() {
		return tbhCabeceraTablaGestionado;
	}

	public void setTbhCabeceraTablaGestionado(List<WebElement> tbhCabeceraTablaGestionado) {
		this.tbhCabeceraTablaGestionado = tbhCabeceraTablaGestionado;
	}

	public List<WebElement> getTbhCabeceraTablaGestionadoIconoOrden() {
		return tbhCabeceraTablaGestionadoIconoOrden;
	}

	public void setTbhCabeceraTablaGestionadoIconoOrden(List<WebElement> tbhCabeceraTablaGestionadoIconoOrden) {
		this.tbhCabeceraTablaGestionadoIconoOrden = tbhCabeceraTablaGestionadoIconoOrden;
	}

	public List<WebElement> getTbCuerpoOrdenesPorGestionar() {
		return tbCuerpoOrdenesPorGestionar;
	}

	public void setTbCuerpoOrdenesPorGestionar(List<WebElement> tbCuerpoOrdenesPorGestionar) {
		this.tbCuerpoOrdenesPorGestionar = tbCuerpoOrdenesPorGestionar;
	}

	public List<WebElement> getBtnAperturaOrdenesPorGestionar() {
		return btnAperturaOrdenesPorGestionar;
	}

	public void setBtnAperturaOrdenesPorGestionar(List<WebElement> btnAperturaOrdenesPorGestionar) {
		this.btnAperturaOrdenesPorGestionar = btnAperturaOrdenesPorGestionar;
	}

	public List<WebElement> getBtnLinkLeerIndicaciones() {
		return btnLinkLeerIndicaciones;
	}

	public void setBtnLinkLeerIndicaciones(List<WebElement> btnLinkLeerIndicaciones) {
		this.btnLinkLeerIndicaciones = btnLinkLeerIndicaciones;
	}

	public List<WebElement> getImgIconoPrestacionNoAgendable() {
		return ImgIconoPrestacionNoAgendable;
	}

	public void setImgIconoPrestacionNoAgendable(List<WebElement> imgIconoPrestacionNoAgendable) {
		ImgIconoPrestacionNoAgendable = imgIconoPrestacionNoAgendable;
	}
	
	public List<WebElement> getImgIconoMultiopcion() {
		return ImgIconoMultiopcion;
	}

	public void setImgIconoMultiopcion(List<WebElement> imgIconoMultiopcion) {
		ImgIconoMultiopcion = imgIconoMultiopcion;
	}

	public List<WebElement> getBtnOpcionEnviarIndicaciones() {
		return BtnOpcionEnviarIndicaciones;
	}

	public void setBtnOpcionEnviarIndicaciones(List<WebElement> btnOpcionEnviarIndicaciones) {
		BtnOpcionEnviarIndicaciones = btnOpcionEnviarIndicaciones;
	}

	public List<WebElement> getBtnOpcionRechazarAsesoria() {
		return BtnOpcionRechazarAsesoria;
	}

	public void setBtnOpcionRechazarAsesoria(List<WebElement> btnOpcionRechazarAsesoria) {
		BtnOpcionRechazarAsesoria = btnOpcionRechazarAsesoria;
	}

	public List<WebElement> getImgIconoPestañaAperturaPrestacion() {
		return imgIconoPestañaAperturaPrestacion;
	}

	public void setImgIconoPestañaAperturaPrestacion(List<WebElement> imgIconoPestañaAperturaPrestacion) {
		this.imgIconoPestañaAperturaPrestacion = imgIconoPestañaAperturaPrestacion;
	}

	public List<WebElement> getTbItemDetallePrestaciones() {
		return tbItemDetallePrestaciones;
	}

	public void setTbItemDetallePrestaciones(List<WebElement> tbItemDetallePrestaciones) {
		this.tbItemDetallePrestaciones = tbItemDetallePrestaciones;
	}
	
	public List<WebElement> getLblNoDisponibilidadProximosSieteDias() {
		return lblNoDisponibilidadProximosSieteDias;
	}

	public void setLblNoDisponibilidadProximosSieteDias(List<WebElement> lblNoDisponibilidadProximosSieteDias) {
		this.lblNoDisponibilidadProximosSieteDias = lblNoDisponibilidadProximosSieteDias;
	}

	public List<WebElement> getLblOcmPrestacionGestionado() {
		return lblOcmPrestacionGestionado;
	}

	public void setLblOcmPrestacionGestionado(List<WebElement> lblOcmPrestacionGestionado) {
		this.lblOcmPrestacionGestionado = lblOcmPrestacionGestionado;
	}

	public List<WebElement> getLblOcmHoraGestionado() {
		return lblOcmHoraGestionado;
	}

	public void setLblOcmHoraGestionado(List<WebElement> lblOcmHoraGestionado) {
		this.lblOcmHoraGestionado = lblOcmHoraGestionado;
	}

	public List<WebElement> getLblOcmFechaGestionado() {
		return lblOcmFechaGestionado;
	}

	public void setLblOcmFechaGestionado(List<WebElement> lblOcmFechaGestionado) {
		this.lblOcmFechaGestionado = lblOcmFechaGestionado;
	}

	public List<WebElement> getBtnCancelarAnularReservaHora() {
		return btnCancelarAnularReservaHora;
	}

	public void setBtnCancelarAnularReservaHora(List<WebElement> btnCancelarAnularReservaHora) {
		this.btnCancelarAnularReservaHora = btnCancelarAnularReservaHora;
	}

	public List<WebElement> getBtnAnularReservaHora() {
		return btnAnularReservaHora;
	}

	public void setBtnAnularReservaHora(List<WebElement> btnAnularReservaHora) {
		this.btnAnularReservaHora = btnAnularReservaHora;
	}

	public List<WebElement> getTbListadoProximasHorasDisponibles() {
		return tbListadoProximasHorasDisponibles;
	}

	public void setTbListadoProximasHorasDisponibles(List<WebElement> tbListadoProximasHorasDisponibles) {
		this.tbListadoProximasHorasDisponibles = tbListadoProximasHorasDisponibles;
	}

	public List<WebElement> getTbListadoGestionados() {
		return tbListadoGestionados;
	}

	public void setTbListadoGestionados(List<WebElement> tbListadoGestionados) {
		this.tbListadoGestionados = tbListadoGestionados;
	}

	public List<WebElement> getTbhCabezaraListadoProximasHorasDisponibles() {
		return tbhCabezaraListadoProximasHorasDisponibles;
	}

	public void setTbhCabezaraListadoProximasHorasDisponibles(List<WebElement> tbhCabezaraListadoProximasHorasDisponibles) {
		this.tbhCabezaraListadoProximasHorasDisponibles = tbhCabezaraListadoProximasHorasDisponibles;
	}
		
	public List<WebElement> getLbxHorasDisponibles() {
		return lbxHorasDisponibles;
	}

	public void setLbxHorasDisponibles(List<WebElement> lbxHorasDisponibles) {
		this.lbxHorasDisponibles = lbxHorasDisponibles;
	}

	public List<WebElement> getListHorasDisponibles() {
		return listHorasDisponibles;
	}

	public void setListHorasDisponibles(List<WebElement> listHorasDisponibles) {
		this.listHorasDisponibles = listHorasDisponibles;
	}

	public List<WebElement> getTbCentrosMedicos() {
		return tbCentrosMedicos;
	}

	public void setTbCentrosMedicos(List<WebElement> tbCentrosMedicos) {
		this.tbCentrosMedicos = tbCentrosMedicos;
	}

	public List<WebElement> getBtnMasOpciones() {
		return btnMasOpciones;
	}

	public void setBtnMasOpciones(List<WebElement> btnMasOpciones) {
		this.btnMasOpciones = btnMasOpciones;
	}

	public List<WebElement> getListMasOpciones() {
		return listMasOpciones;
	}

	public void setListMasOpciones(List<WebElement> listMasOpciones) {
		this.listMasOpciones = listMasOpciones;
	}

	public List<WebElement> getBtnSeleccionAgendarHora() {
		return BtnSeleccionAgendarHora;
	}

	public void setBtnSeleccionAgendarHora(List<WebElement> btnSeleccionAgendarHora) {
		BtnSeleccionAgendarHora = btnSeleccionAgendarHora;
	}

	public List<WebElement> getBtnSeleccionMasHoras() {
		return BtnSeleccionMasHoras;
	}

	public void setBtnSeleccionMasHoras(List<WebElement> btnSeleccionMasHoras) {
		BtnSeleccionMasHoras = btnSeleccionMasHoras;
	}

	public List<WebElement> getBtnSeleccionAnular() {
		return BtnSeleccionAnular;
	}

	public void setBtnSeleccionAnular(List<WebElement> btnSeleccionAnular) {
		BtnSeleccionAnular = btnSeleccionAnular;
	}
}