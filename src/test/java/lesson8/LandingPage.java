package lesson8;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LandingPage {
    @CacheLookup
    @FindBy(id="search_query_top")
    WebElement searchField;


    public LandingPage(WebDriver driver){

        PageFactory.initElements(driver,this);
    }

    void searchFor(String query){
        searchField.clear();
        searchField.sendKeys(query);
    }

    String searchedResult(WebDriver driver){
        return (new WebDriverWait(driver,16,2))
                .until(s -> s.findElement(By.xpath("//div[@class='ac_results']/ul/li[1]"))
                        .getText());
    }

}
