package lesson7;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Optional;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

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
       /* Stream<WebElement> str = driver
                .findElements(By.xpath("//#[id=\"search\"]/div[2]/ul/li[1]")).stream();
        Optional<WebElement> webElement = str
                .filter(s->s.getText().contains("Dress"))
                .findAny();
        */

        String text = (new WebDriverWait(driver,10,2))
                            .until(s -> s.findElement(By.xpath("//div[2]/ul/li[1]"))
                            .getText());
        Assert.assertThat(text, containsString("Dress"));
    }

    @AfterClass
    public static void down(){
        driver.quit();
    }
}

class LandingPage{
    @CacheLookup
    @FindBy(id="search_query_top")
    WebElement searchField;

    @FindBy(xpath="//div[2]/ul/li[1]")
    WebElement searchedResult;

    public LandingPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    void searchFor(String query){
        searchField.clear();
        searchField.sendKeys(query);
    }
}
