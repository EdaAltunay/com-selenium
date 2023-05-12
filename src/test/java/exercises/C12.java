package exercises;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.List;
import java.util.Set;

public class C12 extends TestBase {
    //● Tests package’inda yeni bir class olusturun: WindowHandle2
    //● https://the-internet.herokuapp.com/windows adresine gidin.
    //● Sayfadaki textin “Opening a new window” olduğunu doğrulayın.
    //● Sayfa başlığının(title) “The Internet” olduğunu doğrulayın.
    //● Click Here butonuna basın.
    //● Acilan yeni pencerenin sayfa başlığının (title) “New Window” oldugunu
    //dogrulayin.
    //● Sayfadaki textin “New Window” olduğunu doğrulayın.
    //● Bir önceki pencereye geri döndükten sonra sayfa başlığının “The Internet”
    //olduğunu doğrulayın

    @Test
    public void test() throws InterruptedException {
        //● https://the-internet.herokuapp.com/windows adresine gidin.
        driver.get("https://the-internet.herokuapp.com/windows");
        String WHD1=driver.getWindowHandle();
        //● Sayfadaki textin “Opening a new window” olduğunu doğrulayın.

        String expected="Opening a new window";
        String actual=driver.findElement(By.tagName("h3")).getText();
        Thread.sleep(2000);
        Assert.assertEquals(expected,actual);
        //● Sayfa başlığının(title) “The Internet” olduğunu doğrulayın.
        expected="The Internet";
        actual=driver.getTitle();
        Assert.assertEquals(expected,actual);
        //● Click Here butonuna basın.
        driver.findElement(By.xpath("//*[text()='Click Here']")).click();
        //● Acilan yeni pencerenin sayfa başlığının (title) “New Window” oldugunu dogrulayin.
        Set<String> WHDList=driver.getWindowHandles();
        String WHD2="";
        for (String each:WHDList) {
            if (!each.contains(WHD1)){
                WHD2=each;
            }
        }
        driver.switchTo().window(WHD2);
        expected="New Window";
        actual=driver.getTitle();
        Assert.assertEquals(expected,actual);


        //● Sayfadaki textin “New Window” olduğunu doğrulayın.
        expected="New Window";
        actual=driver.findElement(By.tagName("h3")).getText();
        Assert.assertEquals(expected,actual);

        //● Bir önceki pencereye geri döndükten sonra sayfa başlığının “The Internet” olduğunu doğrulayın
        driver.switchTo().window(WHD1);
        expected="The Internet";
        actual=driver.getTitle();
        Assert.assertEquals(expected,actual);

















    }
}
