package lesson7;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


import static org.hamcrest.CoreMatchers.containsString;


public class FirstTest {

    static WebDriver driver;
    static LandingPage page;

    @BeforeClass
    public static void setUp(){
        driver = new ChromeDriver();
        page = new LandingPage(driver);
       // driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
       // driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
        driver.get("http://automationpractice.com/index.php");
        driver.manage().window().maximize();
    }


    @Test
    public  void  verifyFirstType(){
        page.searchFor("Dress");
        Assert.assertThat(page.searchedResult(driver), containsString("Dress"));
    }

    @AfterClass
    public static void down(){
        driver.quit();
    }
}


