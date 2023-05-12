package exercises;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import java.util.Set;

public class C13 extends TestBase {
    //1- Yeni bir class olusturalim: MouseActions1
    //2- https://the-internet.herokuapp.com/context_menu sitesine gidin
    //3- Cizili alan uzerinde sag click yapin
    //4- Alert’te cikan yazinin “You selected a context menu” oldugunu test edin.
    //5- Tamam diyerek alert’i kapatalim
    //6- Elemental Selenium linkine tiklayalim
    //7- Acilan sayfada h1 taginda “Elemental Selenium” yazdigini test edeli


    @Test
    public void test() {
        //2- https://the-internet.herokuapp.com/context_menu sitesine gidin
        driver.get("https://the-internet.herokuapp.com/context_menu");
        String WHD1 = driver.getWindowHandle();

        //3- Cizili alan uzerinde sag click yapin

        Actions actions = new Actions(driver);
        WebElement element = driver.findElement(By.xpath("//*[@id='hot-spot']"));
        actions.contextClick(element).perform();


        //4- Alert’te cikan yazinin “You selected a context menu” oldugunu test edin.

        String expected = "You selected a context menu";
        String actual = driver.switchTo().alert().getText();
        Assert.assertEquals(expected, actual);

        //5- Tamam diyerek alert’i kapatalim
        driver.switchTo().alert().accept();


        //6- Elemental Selenium linkine tiklayalim
        String windowWHD = driver.getWindowHandle();
        driver.findElement(By.linkText("Elemental Selenium")).click();
        String WHD2 = "";
        Set<String> WHD = driver.getWindowHandles();
        for (String each : WHD) {
            if (!each.equals(WHD1)) {
                WHD2=each;
            }
        }
        driver.switchTo().window(WHD2);
        //7- Acilan sayfada h1 taginda “Elemental Selenium” yazdigini test edeli

        expected="Elemental Selenium";
        actual=driver.findElement(By.tagName("h1")).getText();
        Assert.assertEquals(expected,actual);


    }
}
