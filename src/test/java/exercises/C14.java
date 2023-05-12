package exercises;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C14 extends TestBase {
    //1- https://demoqa.com/droppable adresine gidelim
    //2- “Drag me” butonunu tutup “Drop here” kutusunun ustune birakalim
    //3- “Drop here” yazisi yerine “Dropped!” oldugunu test edin

    @Test
    public void test() throws InterruptedException {
        //1- https://demoqa.com/droppable adresine gidelim
        driver.get("https://demoqa.com/droppable");
        //2- “Drag me” butonunu tutup “Drop here” kutusunun ustune birakalim

        Actions actions=new Actions(driver);

        WebElement dragMeElementi=driver.findElement(By.xpath("//*[@id='draggable']"));
        WebElement dropHeElementi=driver.findElement(By.xpath("//div[@id='droppable'][1]"));
        actions.dragAndDrop(dragMeElementi,dropHeElementi).perform();

        Thread.sleep(2000);


        //3- “Drop here” yazisi yerine “Dropped!” oldugunu test edin

        String expected="Dropped!";
        String actual=driver.findElement(By.xpath("//p[text()='Dropped!']")).getText();

        Assert.assertEquals(expected,actual);






    }


}
