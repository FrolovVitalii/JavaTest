package lesson5;

import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Optional;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

import static org.hamcrest.CoreMatchers.containsString;


public class FirstTest {

    static WebDriver driver;

    @BeforeClass
    public static void setUp(){
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
        driver.get("http://automationpractice.com/index.php");
        driver.manage().window().maximize();
    }


    @Test
    public  void  verifyFirstType(){
        driver.findElement(By.id("search_query_top")).clear();
        driver.findElement(By.id("search_query_top")).sendKeys("Dress");
        Stream<WebElement> str = driver.findElements(By.xpath("//#[id=\"search\"]/div[2]/ul/li")).stream();
        Optional<WebElement> webelement = str.filter(s->s.getText().contains("Dress")).findAny();
        Assert.assertThat(webelement.get().getText(), containsString("Dress"));
    }

    @AfterClass
    public static void down(){
        driver.quit();
    }
}
