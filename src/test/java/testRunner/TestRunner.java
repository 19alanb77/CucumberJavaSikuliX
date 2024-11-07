package testRunner;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Class that allows to run tests using SikuliX automation compiled as a .jar file.
 * 
 * @author Alan Buda
 */ 
public class TestRunner {
	
    public static void main(String[] args) throws Throwable {
        final String[] arguments = new String[]{
                "--glue", "sikulixPage",
                "--plugin", "pretty",
                "--plugin", "html:test-output/" + new SimpleDateFormat("yyyy-MM-dd HH-mm").format(new Date()) + ".html",
                "features"
        };
        io.cucumber.core.cli.Main.main(arguments);
    }
	
}