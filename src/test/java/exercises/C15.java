package exercises;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C15 extends TestBase {
    //1- https://www.amazon.com/ adresine gidin
    //2- Sag ust bolumde bulunan “Account & Lists” menusunun acilmasi icin
    //mouse’u bu menunun ustune getirin
    //3- “Create a list” butonuna basin
    //4- Acilan sayfada “Your Lists” yazisi oldugunu test edin.


    @Test
    public void test(){
        //1- https://www.amazon.com/ adresine gidin
        driver.get("https://www.amazon.com/");

        //2- Sag ust bolumde bulunan “Account & Lists” menusunun acilmasi icin mouse’u bu menunun ustune getirin

        Actions actions=new Actions(driver);
        WebElement accountListsElementi=driver.findElement(By.xpath("//*[@id='nav-link-accountList']"));
        actions.moveToElement(accountListsElementi).perform();

        //3- “Create a list” butonuna basin

       driver.findElement(By.xpath("//*[text()='Create a List']")).click();

       //4- Acilan sayfada “Your Lists” yazisi oldugunu test edin.

        String expected="Your Lists";
        String actual=driver.findElement(By.xpath("//*[@role='heading']")).getText();

        Assert.assertEquals(expected,actual);











    }
}
