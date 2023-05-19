package exercises;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C19File extends TestBase {
    // 1. Tests packagenin altina bir class oluşturalim : C04_FileDownload
    //2. https://the-internet.herokuapp.com/download adresine gidelim.
    //3. a.png dosyasını indirelim
    //4. Dosyanın başarıyla indirilip indirilmediğini test edelim


    @Test
public void test() throws InterruptedException {

        //2. https://the-internet.herokuapp.com/download adresine gidelim.
        driver.get("https://the-internet.herokuapp.com/download");
        //3. a.png dosyasını indirelim
        WebElement apngElementi=driver.findElement(By.xpath("//a[text()='a.png']"));
        apngElementi.click();
        Thread.sleep(3000);
        //4. Dosyanın başarıyla indirilip indirilmediğini test edelim.
        // Dosyayi Downloads klasorune indirecek
        String dosyaYolu="C:\\Users\\MONSTER\\Downloads\\a.png";

        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));













    }




}
