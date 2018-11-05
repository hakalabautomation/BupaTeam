package cl.cencosud.publicsite.automation.poc.stage.set;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(
	tags = {"@CompraInvitadoProductoEstandardCencosudVisaoMasterCard"}
        
)
public class FlujoCompraCompletoStageSet extends StageSet {
}
