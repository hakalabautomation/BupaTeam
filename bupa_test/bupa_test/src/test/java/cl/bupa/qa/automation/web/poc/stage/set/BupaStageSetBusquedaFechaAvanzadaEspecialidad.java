package cl.bupa.qa.automation.web.poc.stage.set;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(
        tags = {"@BusquedaAvanzadaEspecialidad"}
)
public class BupaStageSetBusquedaFechaAvanzadaEspecialidad extends StageSet {
}
