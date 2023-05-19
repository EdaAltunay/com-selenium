package exercises;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C20 extends TestBase {

    //2. https://the-internet.herokuapp.com/upload adresine gidelim
    //3. chooseFile butonunu kullanarak  projemizdeki deneme.txt dosyasini secelim.
    //4. Yuklemek istediginiz dosyayi secelim.
    //5. Upload butonuna basalim.
    //6. “File Uploaded!” textinin goruntulendigini test edelim.

    @Test
    public void test() throws InterruptedException {
        //2. https://the-internet.herokuapp.com/upload adresine gidelim
        driver.get("https://the-internet.herokuapp.com/upload");

        //3. chooseFile butonunu kullanarak  projemizdeki deneme.txt dosyasini secelim.
        WebElement chooseButonu = driver.findElement(By.xpath("//input[@id='file-upload']"));

        String dosyaYoluFarkli = System.getProperty("user.dir");
        String dosyaYoluAyni = "/src/test/java/day10_actionsClass_Faker_FileTestleri/deneme.txt";
        String dosyayolu = dosyaYoluFarkli + dosyaYoluAyni;

        chooseButonu.sendKeys(dosyayolu);
        //5. Upload butonuna basalim.
        driver.findElement(By.xpath("//input[@id='file-submit']")).click();

        //6. “File Uploaded!” textinin goruntulendigini test edelim.
        WebElement element = driver.findElement(By.tagName("h3"));
        Assert.assertTrue(element.isDisplayed());

    }

}
