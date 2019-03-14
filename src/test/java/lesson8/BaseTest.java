package lesson8;

import org.junit.AfterClass;
import org.junit.AssumptionViolatedException;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public abstract class BaseTest {
    static WebDriver driver;
    static LandingPage page;

    @Rule
    public TestWatcher testWatcher = new TestWatcher() {
        @Override
        protected void succeeded(Description description) {
            System.out.print(String.format("Test '%s' - PASSED", description.getMethodName()));
            super.succeeded(description);
        }

        @Override
        protected void failed(Throwable e, Description description) {
            System.out.print(String.format("Test '%s' - FAILED", description.getMethodName()));
            super.failed(e, description);
        }

        @Override
        protected void skipped(AssumptionViolatedException e, Description description) {
            System.out.print(String.format("Test '%s' - SKIPPED", description.getMethodName()));
            super.skipped(e, description);
        }
    };

    @BeforeClass
    public static void setUp(){
        driver = new ChromeDriver();
        page = new LandingPage(driver);
        // driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        // driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
        driver.get("http://automationpractice.com/index.php");
        driver.manage().window().maximize();
    }

    @AfterClass
    public static void down(){

        driver.quit();
    }
}


