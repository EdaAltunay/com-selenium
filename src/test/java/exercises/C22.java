package exercises;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C22 extends TestBase {
    // 1 ) https://the-internet.herokuapp.com/iframe adresine gidin.
    // 2 ) Bir metod olusturun: iframeTest
    //  - “An IFrame containing….” textinin erisilebilir oldugunu test edin
    //    ve  konsolda yazdirin.
    //  - Text Box’a “Merhaba Dunya!” yazin.
    //  - TextBox’in altinda bulunan “Elemental Selenium”
    //    linkini textinin gorunur oldugunu dogrulayin ve  konsolda yazdirin.

    @Test
    public void test(){

        // 1 ) https://the-internet.herokuapp.com/iframe adresine gidin.
        driver.get("https://the-internet.herokuapp.com/iframe");
        //  - “An IFrame containing….” textinin erisilebilir oldugunu test edin ve  konsolda yazdirin.
        WebElement element=driver.findElement(By.tagName("h3"));
        Assert.assertTrue(element.isDisplayed());


        //  - Text Box’a “Merhaba Dunya!” yazin.

        WebElement iframe=driver.findElement(By.id("mce_0_ifr"));
        driver.switchTo().frame(iframe);
        WebElement texbox=driver.findElement(By.xpath("//body[@id='tinymce']"));
        texbox.clear();
        texbox.sendKeys("Merhaba Dunya!");




        //  - TextBox’in altinda bulunan “Elemental Selenium” linkini textinin gorunur oldugunu dogrulayin ve  konsolda yazdirin.

        driver.switchTo().defaultContent();
        WebElement elementalSeleniumElementi=driver.findElement(By.xpath("//*[text()='Elemental Selenium']"));

        Assert.assertTrue(elementalSeleniumElementi.isDisplayed());
        System.out.println(elementalSeleniumElementi.getText());





    }
}
