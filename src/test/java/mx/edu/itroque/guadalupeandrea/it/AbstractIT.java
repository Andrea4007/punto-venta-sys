package mx.edu.itroque.guadalupeandrea.it;

import com.vaadin.testbench.ScreenshotOnFailureRule;
import com.vaadin.testbench.TestBenchTestCase;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public abstract class AbstractIT extends TestBenchTestCase {

    @Rule
    public ScreenshotOnFailureRule rule = new ScreenshotOnFailureRule(this,
            true);

    @BeforeClass
    public static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    @Before
    public void startBrowser() {
        setDriver(new ChromeDriver(new ChromeOptions().setHeadless(false)));
    }

    protected void assertNumbers(String expected, String actual) {
        // Remove any thousands and decimal separators before comparing
        Assert.assertEquals(stripSeparators(expected), stripSeparators(actual));
    }

    private String stripSeparators(String string) {
        return string.replaceAll("[\\., ]", "").replace((char) 160, ' ');
    }

}
