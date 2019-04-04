import domain.CirkelTest;
import domain.PuntTest;
import domain.SpelerTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)

@SuiteClasses({ domain.PuntTest.class, domain.SpelerTest.class, domain.CirkelTest.class, domain.RechthoekTest.class,
        domain.TekeningTest.class, domain.DriehoekTest.class, domain.WoordenLijstTest.class, domain.HintLetterTest.class,
        domain.HintWoordTest.class, domain.LijnStukTest.class, domain.OmhullendeTest.class})

public class AllTests {

}
