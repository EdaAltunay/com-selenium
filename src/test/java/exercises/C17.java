package exercises;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C17 extends TestBase {
    //1- https://www.facebook.com adresine gidelim
    //2- Yeni hesap olustur butonuna basalim
    //3- Ad, soyad, mail ve sifre kutularina deger yazalim ve kaydol tusuna basalim
    //4- Kaydol tusuna basalim.


    @Test
    public void test() throws InterruptedException {
        //1- https://www.facebook.com adresine gidelim
        driver.get("https://www.facebook.com");
        //2- Yeni hesap olustur butonuna basalim
        driver.findElement(By.xpath("(//a[@role='button'])[2]")).click();
        Thread.sleep(3000);

        Actions actions = new Actions(driver);
        WebElement isimKutusuElementi = driver.findElement(By.xpath("//div[@class='mbm _1iy_ _a4y _3-90 lfloat _ohe']"));

        //3- Ad, soyad, mail ve sifre kutularina deger yazalim ve kaydol tusuna basalim
        actions.click(isimKutusuElementi)
                .sendKeys("Eda")
                .keyDown(Keys.TAB)
                .sendKeys("Altunay")
                .keyDown(Keys.TAB)
                .sendKeys("abc@gmail.com")
                .keyDown(Keys.TAB)
                .sendKeys("abc@gmail.com")
                .keyDown(Keys.TAB)
                .sendKeys("12345")
                .keyDown(Keys.TAB)
                .keyDown(Keys.TAB)
                .sendKeys("18")
                .keyDown(Keys.TAB)
                .sendKeys("mayis")
                .keyDown(Keys.TAB)
                .sendKeys("1991")
                .keyDown(Keys.TAB)
                .keyDown(Keys.TAB)
                .keyDown(Keys.ARROW_RIGHT)
                .keyDown(Keys.ARROW_RIGHT)
                .keyDown(Keys.ARROW_RIGHT)
                .keyDown(Keys.TAB)
                .keyDown(Keys.TAB)
                .keyDown(Keys.TAB)
                .keyDown(Keys.TAB)
                .keyDown(Keys.TAB)
                .perform();
        Thread.sleep(3000);

        //4- Kaydol tusuna basalim.

        actions.keyDown(Keys.ENTER).perform();
    }
}
