package exercises;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C10 extends TestBase {

    // 1 ) https://the-internet.herokuapp.com/iframe adresine gidin.
    // 2 ) Bir metod olusturun: iframeTest
    //  - “An IFrame containing….” textinin erisilebilir oldugunu test edin
    //    ve  konsolda yazdirin.
    //  - Text Box’a “Merhaba Dunya!” yazin.
    //  - TextBox’in altinda bulunan “Elemental Selenium”
    //    linkini textinin gorunur oldugunu dogrulayin ve  konsolda yazdirin.

    @Test
    public void test() throws InterruptedException {
        // 1 ) https://the-internet.herokuapp.com/iframe adresine gidin.
        driver.get("https://the-internet.herokuapp.com/iframe");
        // 2 ) Bir metod olusturun: iframeTest
        //  - “An IFrame containing….” textinin erisilebilir oldugunu test edin
        //    ve  konsolda yazdirin.
        WebElement iframeElementi=driver.findElement(By.tagName("h3"));
        Assert.assertTrue(iframeElementi.isDisplayed());
        System.out.println(iframeElementi.getText());
        WebElement frameElementi=driver.findElement(By.id("mce_0_ifr"));
        driver.switchTo().frame(frameElementi);

        WebElement texBox=driver.findElement(By.xpath("//*[@id='tinymce']"));
        texBox.clear();
        Thread.sleep(5000);
        texBox.sendKeys("Merhaba Dunya!");
        Thread.sleep(5000);
        //  - TextBox’in altinda bulunan “Elemental Selenium”
        //    linkini textinin gorunur oldugunu dogrulayin ve  konsolda yazdirin.
        driver.switchTo().defaultContent();
        WebElement elementalSeleniumElementi=driver.findElement(By.linkText("Elemental Selenium"));
        Assert.assertTrue(elementalSeleniumElementi.isDisplayed());
        System.out.println(elementalSeleniumElementi.getText());




    }




}
