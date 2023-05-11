package exercises;

import com.fasterxml.jackson.databind.module.SimpleDeserializers;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;
import utilities.TestBaseBeforeClass;

public class C08 extends TestBaseBeforeClass {
    //   3 test method'u olusturup asagidaki gorevi tamamlayin
    //   1. Test
    //   -  https://the-internet.herokuapp.com/javascript_alerts adresine gidin
    //   - 1.alert'e tiklayin
    //   -  Alert'deki yazinin "I am a JS Alert" oldugunu test edin
    //   -  OK tusuna basip alert'i kapatin
    //   2.Test
    //   - https://the-internet.herokuapp.com/javascript_alerts adresine gidin
    //   - 2.alert'e tiklayalim
    //   - Cancel'a basip, cikan sonuc yazisinin "You clicked: Cancel" oldugunu test edin
    //   3.Test
    //   - https://the-internet.herokuapp.com/javascript_alerts adresine gidin
    //   - 3.alert'e tiklayalim
    //   - Cikan prompt ekranina "Abdullah" yazdiralim
    //   - OK tusuna basarak alert'i kapatalim
    //   - Cikan sonuc yazisinin Abdullah icerdigini test edelim
    @Test
    public void test01(){

        //   -  https://the-internet.herokuapp.com/javascript_alerts adresine gidin
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        //   - 1.alert'e tiklayin
        WebElement alert1Elementi=driver.findElement(By.xpath("//*[@onclick=\"jsAlert()\"]"));
        alert1Elementi.click();

        //   -  Alert'deki yazinin "I am a JS Alert" oldugunu test edin
        String expectedAlertYazisi="I am a JS Alert";
        String actualAlertYazisi=driver.switchTo().alert().getText();
        Assert.assertEquals(expectedAlertYazisi,actualAlertYazisi);
        //   -  OK tusuna basip alert'i kapatin
        driver.switchTo().alert().accept();

    }
    @Test
    public void test02() throws InterruptedException {
        //   - https://the-internet.herokuapp.com/javascript_alerts adresine gidin
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        //   - 2.alert'e tiklayalim
        Thread.sleep(3000);

        driver.findElement(By.xpath("//*[text()='Click for JS Confirm']")).click();
        //   - Cancel'a basip, cikan sonuc yazisinin "You clicked: Cancel" oldugunu test edin
        driver.switchTo().alert().dismiss();

        String expectedSonucYazisi="You clicked: Cancel";
        String actualsonucYazi=driver.findElement(By.xpath("//p[@id='result']")).getText();
        Assert.assertEquals(expectedSonucYazisi,actualsonucYazi);

    }
    @Test
    public void test03(){
        // - https://the-internet.herokuapp.com/javascript_alerts adresine gidin
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        //   - 3.alert'e tiklayalim
        driver.findElement(By.xpath("//*[text()='Click for JS Prompt']")).click();
        //   - Cikan prompt ekranina "Abdullah" yazdiralim
        driver.switchTo().alert().sendKeys("Abdullah");
        //   - OK tusuna basarak alert'i kapatalim
        driver.switchTo().alert().accept();
        //   - Cikan sonuc yazisinin Abdullah icerdigini test edelim

        String expectedSonuc="Abdullah";
        String actualSonuc=driver.findElement(By.xpath("//*[text()='You entered: Abdullah']")).getText();
        Assert.assertTrue(actualSonuc.contains(expectedSonuc));




    }


}
