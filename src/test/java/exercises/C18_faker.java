package exercises;

import com.github.javafaker.Faker;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C18_faker extends TestBase {

    @Test
    public void test() throws InterruptedException {
        //1- https://www.facebook.com adresine gidelim
        driver.get("https://www.facebook.com");
        //2- Yeni hesap olustur butonuna basalim
        driver.findElement(By.xpath("(//a[@role='button'])[2]")).click();
        Thread.sleep(3000);
        Faker faker = new Faker();
        Actions actions = new Actions(driver);
        WebElement isimKutusuElementi = driver.findElement(By.xpath("//div[@class='mbm _1iy_ _a4y _3-90 lfloat _ohe']"));

        //3- Ad, soyad, mail ve sifre kutularina deger yazalim ve kaydol tusuna basalim
        String email = faker.internet().emailAddress();

        actions.click(isimKutusuElementi)
                .sendKeys(faker.name().firstName())
                .keyDown(Keys.TAB)
                .sendKeys(faker.name().lastName())
                .keyDown(Keys.TAB)
                .sendKeys(email)
                .keyDown(Keys.TAB)
                .sendKeys(email)
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
                .sendKeys(Keys.ARROW_RIGHT)
                .sendKeys(Keys.ARROW_RIGHT)
                .sendKeys(Keys.ARROW_RIGHT)
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
