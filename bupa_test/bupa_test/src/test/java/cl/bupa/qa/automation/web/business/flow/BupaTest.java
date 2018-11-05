package cl.bupa.qa.automation.web.business.flow;

import org.junit.BeforeClass;
import org.junit.runners.Suite.SuiteClasses;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cl.bupa.qa.automation.web.poc.stage.set.BupaStageSetHoraOcupadaNuevaReservaHoraExamen;
import cl.bupa.qa.automation.web.poc.definition.components.DefinitionSeleccionHoraOcupadaPorUnaPrestacionPacienteOCMPendiente;
import cl.bupa.qa.automation.web.poc.stage.set.BupaStageSetAgendamientoHoraPorExamenSeleccionOpcionMasHorasDisponiblePorUnaPrestacionPacienteOCMPendiente;
import cl.bupa.qa.automation.web.poc.stage.set.BupaStageSetAgendamientoNuevaReservaHoraEspecialidad;
import cl.bupa.qa.automation.web.poc.stage.set.BupaStageSetAgendamientoNuevaReservaHoraExamen;
import cl.bupa.qa.automation.web.poc.stage.set.BupaStageSetAgendamientoNuevaReservaHoraMedico;
import cl.bupa.qa.automation.web.poc.stage.set.BupaStageSetAnulacionNuevaReservaHoraExamen;
import cl.bupa.qa.automation.web.poc.stage.set.BupaStageSetAnulacionNuevaReservaHoraMedico;
import cl.bupa.qa.automation.web.poc.stage.set.BupaStageSetAnulacionPorExamenSeleccionOpcionMasHorasDisponiblePorUnaPrestacionPacienteOCMPendiente;
import cl.bupa.qa.automation.web.poc.stage.set.BupaStageSetAnularHoraSeleccionHoraDisponiblePorUnaPrestacionPacienteOCMPendiente;
import cl.bupa.qa.automation.web.poc.stage.set.BupaStageSetBodyBusquedaPacienteRut;
import cl.bupa.qa.automation.web.poc.stage.set.BupaStageSetBusquedaFechaAvanzadaEspecialidad;
import cl.bupa.qa.automation.web.poc.stage.set.BupaStageSetBusquedaFechaAvanzadaExamen;
import cl.bupa.qa.automation.web.poc.stage.set.BupaStageSetBusquedaFechaAvanzadaMedico;
import cl.bupa.qa.automation.web.poc.stage.set.BupaStageSetBusquedaPacienteOCMPendientesPestañaLoGestionado;
import cl.bupa.qa.automation.web.poc.stage.set.BupaStageSetBusquedaPacienteOCMPendientesPestañaPorGestionar;
import cl.bupa.qa.automation.web.poc.stage.set.BupaStageSetBusquedaPacienteRutCorrecto;
import cl.bupa.qa.automation.web.poc.stage.set.BupaStageSetCrearDatosPaciente;
import cl.bupa.qa.automation.web.poc.stage.set.BupaStageSetEditarDatosPaciente;
import cl.bupa.qa.automation.web.poc.stage.set.BupaStageSetFiltrosPrecargadosPorExamenSeleccionOpcionMasHorasDisponiblePorUnaPrestacionPacienteOCMPendiente;
import cl.bupa.qa.automation.web.poc.stage.set.BupaStageSetHeaderBusquedaPacienteRut;
import cl.bupa.qa.automation.web.poc.stage.set.BupaStageSetHoraOcupadaNuevaReservaHoraEspecialidad;
import cl.bupa.qa.automation.web.poc.stage.set.BupaStageSetLateralBusquedaPacienteRut;
import cl.bupa.qa.automation.web.poc.stage.set.BupaStageSetLoginCorrecto;
import cl.bupa.qa.automation.web.poc.stage.set.BupaStageSetLoginCorrectoConClaveDinamica;
import cl.bupa.qa.automation.web.poc.stage.set.BupaStageSetLoginNoRegistrado;
import cl.bupa.qa.automation.web.poc.stage.set.BupaStageSetLoginVacio;
import cl.bupa.qa.automation.web.poc.stage.set.BupaStageSetReservaHoraEspecialidad;
import cl.bupa.qa.automation.web.poc.stage.set.BupaStageSetReservaHoraExamen;
import cl.bupa.qa.automation.web.poc.stage.set.BupaStageSetReservaHoraMedico;
import cl.bupa.qa.automation.web.poc.stage.set.BupaStageSetResumenPorExamenSeleccionOpcionMasHorasDisponiblePorUnaPrestacionPacienteOCMPendiente;
import cl.bupa.qa.automation.web.poc.stage.set.BupaStageSetSeleccionFechaPorExamenSeleccionOpcionMasHorasDisponiblePorUnaPrestacionPacienteOCMPendiente;
import cl.bupa.qa.automation.web.poc.stage.set.BupaStageSetSeleccionHoraPorExamenSeleccionOpcionMasHorasDisponiblePorUnaPrestacionPacienteOCMPendiente;
import cl.bupa.qa.automation.web.poc.stage.set.BupaStageSetSeleccionOpcionAnularBusquedaPacienteOCMPendientesPestañaLoGestionado;
import cl.bupa.qa.automation.web.poc.stage.set.BupaStageSetSeleccionPrimeraOpcionEnviarIndicacionesPorUnaPrestacionConIndicacionesNoAgendablePacienteOCMPendiente;
import cl.bupa.qa.automation.web.poc.stage.set.BupaStageSetSeleccionPrimeraOpcionEnviarIndicacionesPorUnaPrestacionSinIndicacionesNoAgendablePacienteOCMPendiente;
import cl.bupa.qa.automation.web.poc.stage.set.BupaStageSetSelecionOpcionMasHorasPorModalExamenDisponiblePorUnaPrestacionPacienteOCMPendiente;
/*agendamiento por especialidad*/
//@SuiteClasses({BupaStageSetLoginVacio.class, BupaStageSetLoginNoRegistrado.class, BupaStageSetLoginCorrectoConClaveDinamica.class, BupaStageSetHeaderBusquedaPacienteRut.class, BupaStageSetLateralBusquedaPacienteRut.class, BupaStageSetBodyBusquedaPacienteRut.class, BupaStageSetBusquedaPacienteRutCorrecto.class, BupaStageSetReservaHoraEspecialidad.class, BupaStageSetAgendamientoNuevaReservaHoraEspecialidad.class})
/*agendamiento por medico*/
//@SuiteClasses({BupaStageSetLoginVacio.class, BupaStageSetLoginNoRegistrado.class, BupaStageSetLoginCorrectoConClaveDinamica.class, BupaStageSetHeaderBusquedaPacienteRut.class, BupaStageSetLateralBusquedaPacienteRut.class, BupaStageSetBodyBusquedaPacienteRut.class, BupaStageSetBusquedaPacienteRutCorrecto.class, BupaStageSetReservaHoraMedico.class})
/*ocm pendiente*/
//@SuiteClasses({BupaStageSetLoginVacio.class, BupaStageSetLoginNoRegistrado.class, BupaStageSetLoginCorrectoConClaveDinamica.class, BupaStageSetHeaderBusquedaPacienteRut.class, BupaStageSetLateralBusquedaPacienteRut.class, BupaStageSetBodyBusquedaPacienteRut.class, BupaStageSetBusquedaPacienteOCMPendientesPestañaPorAgendar.class, BupaStageSetSelecionOpcionMasHorasPorModalExamenDisponiblePorUnaPrestacionPacienteOCMPendiente.class, BupaStageSetFiltrosPrecargadosPorExamenSeleccionOpcionMasHorasDisponiblePorUnaPrestacionPacienteOCMPendiente.class, BupaStageSetSeleccionFechaPorExamenSeleccionOpcionMasHorasDisponiblePorUnaPrestacionPacienteOCMPendiente.class, BupaStageSetSeleccionHoraPorExamenSeleccionOpcionMasHorasDisponiblePorUnaPrestacionPacienteOCMPendiente.class, BupaStageSetResumenPorExamenSeleccionOpcionMasHorasDisponiblePorUnaPrestacionPacienteOCMPendiente.class, BupaStageSetAgendamientoHoraPorExamenSeleccionOpcionMasHorasDisponiblePorUnaPrestacionPacienteOCMPendiente.class})
@SuiteClasses({BupaStageSetLoginVacio.class, BupaStageSetLoginNoRegistrado.class, BupaStageSetLoginCorrectoConClaveDinamica.class, BupaStageSetHeaderBusquedaPacienteRut.class, BupaStageSetLateralBusquedaPacienteRut.class, BupaStageSetBodyBusquedaPacienteRut.class, BupaStageSetBusquedaPacienteRutCorrecto.class, BupaStageSetBusquedaPacienteOCMPendientesPestañaPorGestionar.class, BupaStageSetSeleccionPrimeraOpcionEnviarIndicacionesPorUnaPrestacionConIndicacionesNoAgendablePacienteOCMPendiente.class})
public class BupaTest extends BaseFlow
{	
    private static final Logger LOGGER = LoggerFactory.getLogger(BupaTest.class);

    @BeforeClass
    public static void flag() throws Exception 
    {
        LOGGER.info("Ejecutando ClienteFlow...");        
    }
}
