package lesson8;

import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.containsString;

public class FirstTest extends BaseTest {

    @Test
    public  void  FirstTest(){
        page.searchFor("Dress");
        Assert.assertThat(page.searchedResult(driver), containsString("Dress"));
    }
}
