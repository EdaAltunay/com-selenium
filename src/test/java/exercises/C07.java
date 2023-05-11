package exercises;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C07 extends TestBase {
    // amazon'a gidelim
    // Nutella icin arama yapalim
    // arama sonuclarinin Nutella icerdigini test edelim
    @Test
    public void test01() {
        driver.get("https://www.amazon.com");
        WebElement aramaKutusuElementi=driver.findElement(By.id("twotabsearchtextbox"));
        aramaKutusuElementi.sendKeys("Nutella"+ Keys.ENTER);
        String expectedSonuc="Nutella";
        String actualIcerik=driver.findElement(By.xpath("//div[@class='sg-col-inner'][1]")).getText();
        Assert.assertTrue(actualIcerik.contains(expectedSonuc));



    }
}
